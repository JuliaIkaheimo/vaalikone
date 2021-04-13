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
    name = "ShowTulokset",
    urlPatterns = {"/showtulokset"}
)
public class ShowTulokset extends HttpServlet {
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
		ArrayList<Integer> Kayttajanvastaukset= new ArrayList<Integer>();
		
		for (int i=1; i<19;i++){
			int vastaus=Integer.valueOf(request.getParameter("vastaus"+i));
			Kayttajanvastaukset.add(vastaus);
		}

		ArrayList<Vastaukset> list=null;
		if (dao.getConnection()) {
			list=dao.readAllVastaukset();
		}
		
		int yhteensopivuus = 0;
		for (int i=0; i<19;i++){
			yhteensopivuus = yhteensopivuus + Kayttajanvastaukset.get(i) - list.get(i);
		}
		
		request.setAttribute("ehdokkaidenvastaukset", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showtulokset.jsp");
		rd.forward(request, response);
	}
}