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
		ArrayList<Vastaukset> vastauksetList=(ArrayList<Vastaukset>) request.getAttribute("vastauksetList");
		int listanpituus= vastauksetList.size();
		

		
		ArrayList<Vastaukset> list=null;
		if (dao.getConnection()) {
			for (int i=0; i<listanpituus;i++){
				String ehdokas_id=request.getParameter("ehdokas_id");	
				String kysymys_id=request.getParameter("kysymys_id");
				String vastaus = request.getParameter("vastaus"+(i));
				String kommentti=request.getParameter("kommentti");
				Vastaukset v = new Vastaukset (ehdokas_id, kysymys_id, vastaus, kommentti);
				list=dao.updateVastaukset(v);
			}
			
		}
		
		request.setAttribute("vastaus", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}