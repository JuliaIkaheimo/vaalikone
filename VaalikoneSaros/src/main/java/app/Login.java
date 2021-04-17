package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import data.Ehdokkaat;
import data.Kysymykset;
 
@WebServlet(
	    name = "login",
	    urlPatterns = {"/login"}
	)
public class Login extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "antero", "kukkuu");
	}
 
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        System.out.println("username: " + username);
        System.out.println("password: " + password);
 
		ArrayList <Kysymykset> list3=null;
		ArrayList <Ehdokkaat> list2=null;
        // do some processing here...
        if(Dao.checkUser(username, password) && dao.getConnection())
        {
			list2=dao.readAllEhdokkaat();
			list3=dao.readAllKysymykset();
			request.setAttribute("ehdokkaatlist", list2);
			request.setAttribute("kysymyksetlist", list3);
            
            
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            
            RequestDispatcher rs = request.getRequestDispatcher("/jsp/admin.jsp");
            rs.forward(request, response);
            
        }
        else
        {
        	String viesti = "Tunnus tai salasana on v‰‰rin";
           request.setAttribute("viesti", viesti);
           RequestDispatcher rs = request.getRequestDispatcher("/jsp/login.jsp");
           rs.include(request, response);
        }
        
 

         
    }
 
}