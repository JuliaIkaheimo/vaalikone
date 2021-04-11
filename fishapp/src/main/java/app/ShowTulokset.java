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
import data.Kysymykset;

/**
 * Servlet implementation class ShowKysymykset
 */
@WebServlet("/showtulokset")
public class ShowTulokset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
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
    
tected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Kysymykset> list=null;
		if (dao.getConnection()) {
		String ehdokas_id=request.getParameter("ehdokas_id");
		String etunimi=request.getParameter("etunimi");
		String sukunimi=request.getParameter("sukunimi");
		
		Ehdokkaat e=new Ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
			l
		ist=dao.readAllKysymykset();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("tuloksetlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showtulokset.jsp");
		rd.forward(request, response);
	}
	
}
