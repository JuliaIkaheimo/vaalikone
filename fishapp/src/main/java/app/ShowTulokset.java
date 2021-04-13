package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.*;


/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet(
	    name = "ShotTulokset",
	    urlPatterns = {"/showtulokset"}
	)
public class ShowTulokset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "antero", "kukkuu");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTulokset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Vastaukset> kvlist=null;
		ArrayList<Vastaukset> evlist=null;
		ArrayList<Vastaukset> kevlist=null;
		

		if (dao.getConnection()) {
			evlist=dao.readEhdokkaanVastaukset(ehdokas_id);
			kevlist.add(evlist);
		}
		else {
			System.out.println("No connection to database");
		}

		
		for (int i=0;klist!=null && i<klist.size();i++) {
			kevlist=dao.readEhdokkaanVastaukset(i);
			kvlist.add(request.getParameter("vastaus"+(i+1)));
	}
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showtulokset.jsp");
		rd.forward(request, response);
	}
}
