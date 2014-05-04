package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MostScoredQuestions
 */

public class MostScoredQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HiveConnection mostScoredQuestions = new HiveConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostScoredQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside dopost");
		DataBean[] mostScoredQuestions1 = new DataBean[7];
		HttpSession session = request.getSession();
		String t;
		try
		{
			t= request.getParameter("t");
			System.out.println("tablename"+t);
			if(null==session.getAttribute("mostScoredQuestions")){
			mostScoredQuestions1=mostScoredQuestions.MostScoredQuestions(t);
			session.setAttribute("mostScoredQuestions", mostScoredQuestions1);
			}
			RequestDispatcher view = request.getRequestDispatcher("/View/MostScoredQuestions.jsp");
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
