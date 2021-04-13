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
		ArrayList<Kysymykset> kysymyksetList=(ArrayList<Kysymykset>) request.getAttribute("kysymyksetList");
		for (int i=0; i<kysymyksetList.size();i++){
			
		String vastaus=request.getParameter("vastaus"+(1));
		
		}
		
		Vastaukset e=new Vastaukset();
		
		ArrayList<Ehdokkaat> list=null;
		if (dao.getConnection()) {
			list=dao.updateEhdokas(e);
		}
		
		request.setAttribute("ehdokkaatlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}