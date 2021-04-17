package app;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.*;

@WebServlet(
	    name = "ReadAndCompare",
	    urlPatterns = {"/readandcompare"}
	)
public class ReadAndCompare extends HttpServlet {
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
		ArrayList<Vastaukset> vastauksetlist=null;
		ArrayList<Ehdokkaat> ehdokkaatlist=null;
		float vertailuarvo = 0;
		ArrayList<Float> vertailuprosentit= new ArrayList<Float>();
		
		if (dao.getConnection()) {
			ehdokkaatlist=dao.readAllEhdokkaat();
			for (int i=0; i<ehdokkaatlist.size();i++){
				Ehdokkaat e=ehdokkaatlist.get(i);
				vastauksetlist=dao.readEhdokkaanVastaukset(Integer.toString(e.getEhdokas_id()));
				for (int i2=0; i2<vastauksetlist.size();i2++){
					Integer kayttajanvastaus=Integer.parseInt(request.getParameter("vastaus"+(i2+1)));
					Vastaukset v=vastauksetlist.get(i2);
					vertailuarvo = vertailuarvo + Math.abs(v.getVastaus()-kayttajanvastaus);
				}
				float max = vastauksetlist.size()*4;
				float prosentti = 100 - (vertailuarvo / max * 100);
				e.setVertailu(Math.round(prosentti));
				vertailuarvo=0;	
			}

			
		}
		Collections.sort(ehdokkaatlist, new Comparator<Ehdokkaat>() {
		    @Override
		    public int compare(Ehdokkaat t, Ehdokkaat t1) {
		        return Float.compare(t1.getVertailu(), t.getVertailu());
		    }
		});
		
		request.setAttribute("ehdokkaatlist", ehdokkaatlist);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showtulokset.jsp");
		rd.forward(request, response);
	}
}
