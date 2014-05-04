package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OverviewQuestions
 */

public class OverviewQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HiveConnection totalQuestions = new HiveConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OverviewQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside doget");
		HttpSession session = request.getSession();
		//DataBean[] totalQuestionsOverview = new DataBean[7];
		int[] overview = new int[5];
		String t;
		try
		{
			
			if(null==session.getAttribute("totalQuestionsOverview")){
				overview=totalQuestions.OverviewQuestions();
				session.setAttribute("totalQuestionsOverview", overview);
			}
			RequestDispatcher view = request.getRequestDispatcher("/View/OverviewQuestions.jsp");
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
