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
	    name = "EhdokasKysymysUpdate",
	    urlPatterns = {"/showvastauksettoedit"}
	)
public class EhdokasKysymyksetUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "antero", "kukkuu");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EhdokasKysymyksetUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Kysymykset> list=null;
		String ehdokas_id=request.getParameter("ehdokas_id");
		Ehdokkaat e=null;
		Vastaukset v=null;
		if (dao.getConnection()) {
			list=dao.readAllKysymykset();
			e=dao.readEhdokas(ehdokas_id);
			v=dao.readVastaus(ehdokas_id);
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("kysymyksetlist", list);
		request.setAttribute("ehdokkaat", e);
		request.setAttribute("vastaukset", v);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showvastauksettoedit.jsp");
		rd.forward(request, response);
	}
}
