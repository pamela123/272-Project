package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class SignUp
 */
public class AnswersPerHourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 Map<String, String> messages = new HashMap<String, String>();
	 HiveConnection ansPerHour = new HiveConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswersPerHourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DataBean[] totalAnsPerHour;
		String t;
		try
		{
			t= request.getParameter("t");
			System.out.println("tablename"+t);
			if(session.getAttribute("totalAnsPerHour")==null){
				totalAnsPerHour=ansPerHour.TotalNoOfAnswersHour(t);
				session.setAttribute("totalAnsPerHour", totalAnsPerHour);
			}
			
			//request.setAttribute("result", result);
			
			RequestDispatcher view = request.getRequestDispatcher("/View/AnswersPerHour.jsp");
			view.forward(request, response);
		}
		catch(Exception e){
			
		}
	
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
