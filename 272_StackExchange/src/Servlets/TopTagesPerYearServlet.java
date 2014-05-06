package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TopTagesPerYearServlet
 */
public class TopTagesPerYearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HiveConnection topTagesPerYear = new HiveConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopTagesPerYearServlet() {
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
		DataBean[] topTagesPerYear1 = new DataBean[5];
		String t;
		int y;
		try
		{
			t= request.getParameter("t");
			y=Integer.parseInt(request.getParameter("y"));
			session.setAttribute("tableName", t);
			session.setAttribute("year", y);
			String sessionVar = t + "_topTagesPerYear";
			sessionVar = sessionVar+ "_" + y;
			if(session.getAttribute(sessionVar)==null){
				topTagesPerYear1=topTagesPerYear.TopTagesPerYear(t,y);
				session.setAttribute(sessionVar, topTagesPerYear1);
			}
			
			
			System.out.println("year"+y);
			/*if(null==session.getAttribute("topTagesPerYear")){
				topTagesPerYear1=topTagesPerYear.TopTagesPerYear(t,y);
				session.setAttribute("topTagesPerYear", topTagesPerYear1);
			}*/
			
			RequestDispatcher view = request.getRequestDispatcher("/View/TopTagesPerYear.jsp");
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
