package com.analytiq.Agent;

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
@WebServlet("/Loginuser")
public class LoginUser extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String query="select name,password from users where name=?";

		String uname=req.getParameter("Username");
		String pass =req.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, uname);
			
			 
			 
			 ResultSet rs = ps.executeQuery();
				
				
			 if (rs.next()) {
	                String storedPassword = rs.getString("password");
	                
	                // Compare entered password with stored password
	                if (storedPassword.equals(pass)) {
	                	 pw.println("<br>");
		                    pw.println("<br>");
		                    pw.println("<br>");
			               
	                    pw.println("<center><h1 style='color:green;'>Login successfully...</h1></center>");
	                    pw.println("<br>");
	                    pw.println("<br>");
	                    pw.println("<br>");
		                   
	                    pw.println("<center><a class='btn btn-Info'  href='ViewAllPolicyToUser.html'><button style='background-color:green;'>View Policies</button></a></center>");

	                    pw.println("<br>");
	                    pw.println("<br>");
	                    
		               
	                
	                } else {
	                	  pw.println("<center><h1 style='color:red;'> Invalid password...</h1></center>");
	  	                
	                }
	            } else {
	            	  pw.println("<center><h1 style='color:red;'> Invalid UserName...</h1></center>");
		                
	            }
		 } catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}

		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req,resp);
		
	}


}
