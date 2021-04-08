import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertData extends HttpServlet{
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
        try{
      //get Username
      String username = request.getParameter("username");

     //get password
      String password = request.getParameter("password");
      out.println(username);
      out.println(password);

      //Get Connection Driver to establish database connection
      Class.forName("oracle.jdbc.driver.OracleDriver");
      //Establish connection
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jaiprakash","admin123");

      //Write SQL query to insert data
      PreparedStatement pst = con.prepareStatement("insert into emp_info values(?,?)");
      pst.setString(1,username);
      pst.setString(2,password);
      int i = pst.executeUpdate();
      //Check if values are saved successfully or not
      if(i!=0){
        out.println("<br>Record has been inserted");
      }
      else{
        out.println("failed to insert the data");
      }
    }
    catch (Exception e){
      out.println(e);
    }
  }
}