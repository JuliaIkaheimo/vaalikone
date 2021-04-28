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

@WebServlet(
		name = "LisaaKysymys",
		urlPatterns = {"/lisaakysymys"}
)

public class LisaaKysymys extends HttpServlet {
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
		String kysymys_id=request.getParameter("kysymys_id");
		String kysymys=request.getParameter("kysymys");
		
		Kysymykset k=new Kysymykset (kysymys_id, kysymys);
		
		ArrayList <Kysymykset> list=null;
		ArrayList <Kysymykset> list3=null;
		ArrayList <Ehdokkaat> list2=null;
		if (dao.getConnection()) {
			list=dao.lisaaKysymys(k);
			list2=dao.readAllEhdokkaat();
			list3=dao.readAllKysymykset();
		}
		
		request.setAttribute("ehdokkaatlist", list2);
		request.setAttribute("kysymyksetlist", list3);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}