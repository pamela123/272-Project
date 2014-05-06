package Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		System.out.println("inside do Get");
		DataBean[] totalAnswersPerYear = new DataBean[4];
		DataBean[] totalQuestionsPerYear = new DataBean[4];
		HttpSession session = request.getSession();
		String t;
		try
		{
			t= request.getParameter("t");
			System.out.println("tablename "+t);
			session.setAttribute("tableName", t);
			
			
			/*if(t.equalsIgnoreCase("programmer")){
				if(null==session.getAttribute("p_totalAnswersPerYear")){
					totalAnswersPerYear=total.TotalNoOfAnswers(t);
					session.setAttribute("p_totalAnswersPerYear", totalAnswersPerYear);
					}
				if(null==session.getAttribute("p_totalQuestionsPerYear")){
					totalQuestionsPerYear=total.TotalNoOfQuestions(t);
					session.setAttribute("p_totalQuestionsPerYear", totalQuestionsPerYear);					
					}
			}else if(t.equalsIgnoreCase("dba")){
				if(null==session.getAttribute("d_totalAnswersPerYear")){
					totalAnswersPerYear=total.TotalNoOfAnswers(t);
					session.setAttribute("d_totalAnswersPerYear", totalAnswersPerYear);
					}
				if(null==session.getAttribute("d_totalQuestionsPerYear")){
					totalQuestionsPerYear=total.TotalNoOfQuestions(t);
					session.setAttribute("d_totalQuestionsPerYear", totalQuestionsPerYear);					
					}
			}else if(t.equalsIgnoreCase("webapps")){
				if(null==session.getAttribute("w_totalAnswersPerYear")){
					totalAnswersPerYear=total.TotalNoOfAnswers(t);
					session.setAttribute("w_totalAnswersPerYear", totalAnswersPerYear);
					}
				if(null==session.getAttribute("w_totalQuestionsPerYear")){
					totalQuestionsPerYear=total.TotalNoOfQuestions(t);
					session.setAttribute("w_totalQuestionsPerYear", totalQuestionsPerYear);					
					}
			}else if(t.equalsIgnoreCase("android")){
				if(null==session.getAttribute("a_totalAnswersPerYear")){
					totalAnswersPerYear=total.TotalNoOfAnswers(t);
					session.setAttribute("a_totalAnswersPerYear", totalAnswersPerYear);
					}
				if(null==session.getAttribute("a_totalQuestionsPerYear")){
					totalQuestionsPerYear=total.TotalNoOfQuestions(t);
					session.setAttribute("a_totalQuestionsPerYear", totalQuestionsPerYear);					
					}
			}else if(t.equalsIgnoreCase("stackoverflow")){
				if(null==session.getAttribute("s_totalAnswersPerYear")){
					totalAnswersPerYear=total.TotalNoOfAnswers(t);
					session.setAttribute("s_totalAnswersPerYear", totalAnswersPerYear);
					}
				if(null==session.getAttribute("s_totalQuestionsPerYear")){
					totalQuestionsPerYear=total.TotalNoOfQuestions(t);
					session.setAttribute("s_totalQuestionsPerYear", totalQuestionsPerYear);					
					}
			}*/
			String sessionVar = t + "_totalAnswersPerYear";
			System.out.println("sessionVar" + sessionVar);
			if(null==session.getAttribute(sessionVar)){
			totalAnswersPerYear=total.TotalNoOfAnswers(t);
			session.setAttribute(sessionVar, totalAnswersPerYear);
			}
			sessionVar = t + "_totalQuestionsPerYear";
			if(null==session.getAttribute(sessionVar)){
				totalQuestionsPerYear=total.TotalNoOfQuestions(t);
				session.setAttribute(sessionVar, totalQuestionsPerYear);				
				}
		/*	if(session.getAttribute("totalAnswersPerYear")==null){
			totalAnswersPerYear=total.TotalNoOfAnswers(t);
			session.setAttribute("totalAnswersPerYear", totalAnswersPerYear);
		}
			if(session.getAttribute("totalQuestionsPerYear")==null){
				totalQuestionsPerYear=total.TotalNoOfQuestions(t);
				session.setAttribute("totalQuestionsPerYear", totalQuestionsPerYear);
			}
			*/
			System.out.println((String)session.getAttribute("tableName"));
			ServletContext sc = getServletContext();
			RequestDispatcher view = sc.getRequestDispatcher("/View/CategoryOverview.jsp");
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
