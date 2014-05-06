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
public class QuestionsPerHourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 Map<String, String> messages = new HashMap<String, String>();
	 HiveConnection quesPerHour = new HiveConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionsPerHourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result=0;	
		HttpSession session = request.getSession();
		DataBean[] totalQuesPerHour;
		String t;
		try
		{
			t= request.getParameter("t");
			session.setAttribute("tableName", t);
			String sessionVar = t + "_totalQuesPerHour";
			if(session.getAttribute(sessionVar)==null){
				totalQuesPerHour=quesPerHour.TotalNoOfQuestionsHour(t);
				session.setAttribute(sessionVar, totalQuesPerHour);
			}
			/*if(session.getAttribute("totalQuesPerHour")==null){
				totalQuesPerHour=quesPerHour.TotalNoOfQuestionsHour(t);
				session.setAttribute("totalQuesPerHour", totalQuesPerHour);
			}*/
			
			//System.out.println("returned result="+result);
			//request.setAttribute("result", result);
			
			RequestDispatcher view = request.getRequestDispatcher("/View/QuestionsPerHour.jsp");
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
