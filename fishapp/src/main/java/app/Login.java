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
 
@WebServlet(
	    name = "login",
	    urlPatterns = {"/login"}
	)
public class Login extends HttpServlet {
 
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        System.out.println("username: " + username);
        System.out.println("password: " + password);
 
        // do some processing here...
        if(Validate.checkUser(username, password))
        {
            RequestDispatcher rs = request.getRequestDispatcher("/jsp/admin.jsp");
            rs.forward(request, response);
            HttpSession session = request.getSession(true);
            session.setAttribute("Admin",username);
            
        }
        else
        {
           System.out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("/jsp/loginfail.jsp");
           rs.include(request, response);
        }
        
 
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";      
        htmlRespone += "Your password is: " + password + "</h2>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
         
    }
 
}