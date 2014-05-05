package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FavouriteQuestions
 */

public class FavouriteQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HiveConnection favouriteQuestions = new HiveConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavouriteQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside dopost");
		DataBean[] favouriteQuestions1 = new DataBean[7];
		HttpSession session = request.getSession();
		String t;
		try
		{
			t= request.getParameter("t");
			System.out.println("tablename"+t);
			if(null==session.getAttribute("favouriteQuestions")){
				favouriteQuestions1=favouriteQuestions.FavouriteQuestions(t);
				session.setAttribute("favouriteQuestions", favouriteQuestions1);
			}
			RequestDispatcher view = request.getRequestDispatcher("/View/FavouriteQuestions.jsp");
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
