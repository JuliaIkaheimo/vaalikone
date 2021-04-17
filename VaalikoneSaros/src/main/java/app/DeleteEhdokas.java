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
import data.Kysymykset;

@WebServlet(
    name = "DeleteEhdokas",
    urlPatterns = {"/deleteehdokas"}
)
public class DeleteEhdokas extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "antero", "kukkuu");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String ehdokas_id=request.getParameter("ehdokas_id");
		
		
		ArrayList<Ehdokkaat> list=null;
		ArrayList <Kysymykset> list3=null;
		ArrayList <Ehdokkaat> list2=null;
		if (dao.getConnection()) {
			list=dao.deleteEhdokas(ehdokas_id);
			list2=dao.readAllEhdokkaat();
			list3=dao.readAllKysymykset();
		}
		request.setAttribute("ehdokkaatlist", list2);
		request.setAttribute("kysymyksetlist", list3);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}