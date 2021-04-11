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
import data.Ehdokkaat;

@WebServlet(
    name = "UpdateEhdokas",
    urlPatterns = {"/updateehdokas"}
)
public class UpdateEhdokas extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "antero", "kukkuu");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("index.html");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String ehdokas_id=request.getParameter("ehdokas_id");
		String etunimi=request.getParameter("etunimi");
		String sukunimi=request.getParameter("sukunimi");
		String puolue=request.getParameter("puolue");
		String kotipaikkakunta=request.getParameter("kotipaikkakunta");
		String ika=request.getParameter("ika");
		String miksi_eduskuntaan=request.getParameter("miksi_eduskuntaan");
		String mita_asioita_haluat_edistaa=request.getParameter("mita_asioita_haluat_edistaa");
		String ammatti=request.getParameter("ammatti");
		
		Ehdokkaat e=new Ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
		
		ArrayList<Ehdokkaat> list=null;
		if (dao.getConnection()) {
			list=dao.updateEhdokas(e);
		}
		
		request.setAttribute("ehdokkaatlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}