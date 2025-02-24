package com.analytiq.Agent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userregi")
public class UserRegister extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String query="insert into users (name,email,phone,address,password) values (?,?,?,?,?)";

		String uname=req.getParameter("userName");
		String uEmail=req.getParameter("Email");
		String umobile =req.getParameter("mobile");
		String uadd =req.getParameter("Address");
		String upass =req.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, uname);
			 ps.setString(2,uEmail);
				 ps.setString(3,umobile);
				 ps.setString(4,uadd);
				 ps.setString(5,upass);
				 int i=ps.executeUpdate();
				  if(i==1)
				    {
		            	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
				       pw.println("<center><h1 style='color:green;'>User Registered Successfully...</h1></center>");
				    }
				 else {

		            	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
					 pw.println("<center><h1 style='color:red;'> User not Register</h1></center>");
				 }
				  
				  } catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
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
