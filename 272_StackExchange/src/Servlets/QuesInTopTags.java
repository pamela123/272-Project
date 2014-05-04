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
public class QuesInTopTags extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 HiveConnection quesTags = new HiveConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuesInTopTags() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DataBean[] quesInTopTags;
		String t;
		try
		{
			t= request.getParameter("t");
			System.out.println("tablename"+t);
			/*if(session.getAttribute("quesInTopTags")==null){*/
				quesInTopTags=quesTags.QuesInTopTags(t);
				session.setAttribute("quesInTopTags", quesInTopTags);
			//}
			
			//request.setAttribute("result", result);
			
			RequestDispatcher view = request.getRequestDispatcher("/View/QuesInTopTags.jsp");
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
