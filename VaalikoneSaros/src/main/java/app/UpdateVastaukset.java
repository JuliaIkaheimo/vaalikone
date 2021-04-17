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
    name = "UpdateVastaukset",
    urlPatterns = {"/updatevastaukset"}
)
public class UpdateVastaukset extends HttpServlet {
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
		ArrayList<Vastaukset> vastauksetList=(ArrayList<Vastaukset>) request.getAttribute("vastauksetlist");
		ArrayList<Ehdokkaat> list=null;
		ArrayList<Kysymykset> list2=null;
		ArrayList<Vastaukset> vastauksetlist=null;
		
		for (int i=0; i<vastauksetList.size();i++){
			String ehdokas_id=request.getParameter("ehdokas_id");	
			String kysymys_id=request.getParameter("kysymys_id");
			String vastaus = request.getParameter("vastaus"+(i));
			String kommentti=request.getParameter("kommentti");
			Vastaukset v = new Vastaukset (ehdokas_id, kysymys_id, vastaus, kommentti);
			vastauksetlist.add(v);
		}
		if (dao.getConnection()) {
			dao.updateVastaukset(vastauksetlist);
			list=dao.readAllEhdokkaat();
			list2=dao.readAllKysymykset();
		}
		else {
			System.out.println("No connection to database");
		}		
		request.setAttribute("ehdokkaatlist", list);
		request.setAttribute("kysymyksetlist", list2);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}