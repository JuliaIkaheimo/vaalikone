package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
 
@WebServlet("/ProfileServlet")
	
public class ProfileServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out=response.getWriter();
    	
    	HttpSession session = request.getSession(false);
    	
    	if(session!=null)
    	{ 
    		String username=(String)session.getAttribute("username");
    		out.print("Tervetuloa! " + username);
    	}
    	else
    	{
    		response.sendRedirect("/jsp/login.jsp");
    	}
    	out.print("<a href='admin.jsp'>Admin paneeli</a>");		
    
         
     
         
    }
 
}