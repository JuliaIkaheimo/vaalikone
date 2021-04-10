package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Ehdokkaat;

/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/readtocompare")
public class ReadAndCompare extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "antero", "kukkuu");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadAndCompare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ehdokas_id=request.getParameter("ehdokas_id");
		Ehdokkaat list=null;
		if (dao.getConnection()) {
			
			list=dao.readAllVastaukset();
		}
		request.setAttribute("uservastauksetlist", list);
		
		for (int i=1; i<21;i++){
		String vastaus=request.getParameter("vastaus");
		}
		kayttajanVastaukset kv=new kayttajanVastaukset(ehdokas_id, etunimi, sukunimi, puolue);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcompare.jsp");
		rd.forward(request, response);
	}
}
