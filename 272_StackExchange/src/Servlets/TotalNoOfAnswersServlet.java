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
public class TotalNoOfAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 Map<String, String> messages = new HashMap<String, String>();
	 HiveConnection totalAnswers = new HiveConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalNoOfAnswersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result=0;	
		//HttpSession session = request.getSession();
		System.out.println("inside dopost");
		DataBean[] totalAnswersPerYear = new DataBean[7];
		String t;
		try
		{
			t= request.getParameter("t");
			System.out.println("tablename"+t);
			totalAnswersPerYear=totalAnswers.TotalNoOfAnswers(t);
			System.out.println("returned result="+result);
			//request.setAttribute("result", result);
			request.setAttribute("totalAnswersPerYear", totalAnswersPerYear);
			RequestDispatcher view = request.getRequestDispatcher("/View/TotalNoOfAnswers.jsp");
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
