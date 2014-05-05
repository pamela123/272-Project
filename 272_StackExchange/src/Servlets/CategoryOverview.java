package Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CategoryOverview
 */

public class CategoryOverview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 Map<String, String> messages = new HashMap<String, String>();
	 HiveConnection total = new HiveConnection();
   /**
    * @see HttpServlet#HttpServlet()
    */
   public CategoryOverview() {
       super();
       // TODO Auto-generated constructor stub
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside dopost");
		DataBean[] totalAnswersPerYear = new DataBean[7];
		DataBean[] totalQuestionsPerYear = new DataBean[7];
		HttpSession session = request.getSession();
		String t;
		try
		{
			t= request.getParameter("t");
			System.out.println("tablename"+t);
			if(null==session.getAttribute("totalAnswersPerYear")){
			totalAnswersPerYear=total.TotalNoOfAnswers(t);
			session.setAttribute("totalAnswersPerYear", totalAnswersPerYear);
			}
			if(null==session.getAttribute("totalQuestionsPerYear")){
				totalQuestionsPerYear=total.TotalNoOfQuestions(t);
				session.setAttribute("totalQuestionsPerYear", totalQuestionsPerYear);
				}
			RequestDispatcher view = request.getRequestDispatcher("/View/CategoryOverview.jsp");
			view.forward(request, response);
		}
		catch(Exception e){
			
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
