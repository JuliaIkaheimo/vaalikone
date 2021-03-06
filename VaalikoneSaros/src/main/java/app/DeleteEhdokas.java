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
		if (dao.getConnection()) {
			list=dao.deleteEhdokas(ehdokas_id);
		}
		request.setAttribute("ehdokkaatlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin.jsp");
		rd.forward(request, response);
	}
}