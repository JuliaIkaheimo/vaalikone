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
		
		ArrayList<Integer> kvlist=null;
		ArrayList<Vastaukset> evlist=null;
		


		if (dao.getConnection()) {
			evlist=dao.readEhdokkaanVastaukset("1");
			
			for (int i=0;evlist!=null && i<evlist.size();i++) {	
				kvlist.add(Integer.parseInt(request.getParameter("vastaus"+(i+1))));
		}
			for (int i=0;evlist!=null && i<evlist.size();i++) {
				evlist=dao.readEhdokkaanVastaukset(Integer.toString(i));
				Vastaukset v=evlist.get(i);
				v.getVastaus(); - kvlist(i);
				
			}


		}
		else {
			System.out.println("No connection to database");
		}

		

		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showtulokset.jsp");
		rd.forward(request, response);
	}
}
