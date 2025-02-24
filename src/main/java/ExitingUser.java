import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/exitinguser")
public class ExitingUser extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter pw=resp.getWriter();
		
		String query="select user_id,name,email,phone,address from users where name=?";
		String name=req.getParameter("username");
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1,name );
				ResultSet rs=ps.executeQuery();
				 pw.println("<center><h1 style='color:green;'>User Information</h1></center>");
			    	pw.println("<br>");
			    	pw.println("<br>");
			    
				pw.println("<table border='1' align='center'>");
				pw.println("<tr>");
				pw.println("<th>User Id</th>");
				pw.println("<th>User Name</th>");
				pw.println("<th>Email</th>");
				pw.println("<th>Phone</th>");
				pw.println("<th>Address</th>");
			
				pw.println("</tr>");
				while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getString(4)+"</td>");
				pw.println("<td>"+rs.getString(5)+"</td>");
				
								
				pw.println("</tr>");
				
		 }
				pw.println("<table>");
	 } catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h2>");
		}
		 pw.println("<br>");
		 pw.println("<br>");
	    	pw.println("<br>");
	    	pw.println("<br>");
	    
			pw.println("<center><a class='btn btn-Info'  href='UserLogin.html'><button style='background-color:green;'>Login Here</button></a></center>");

	    	pw.println("<br>");
	    	pw.println("<br>");
	    	pw.println("<br>");
	    	pw.println("<br>");
	    
			pw.println("<center><a class='btn btn-Info'  href='HomePage.html'><button style='background-color:green;'>Back to Home</button></a></center>");


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req,resp);
	}



}


