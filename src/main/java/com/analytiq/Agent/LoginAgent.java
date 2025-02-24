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
@WebServlet("/LoginAgent")
public class LoginAgent extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String query="select agent_name,agent_password from Agent where agent_name=?";

		String aname=req.getParameter("Agentname");
		String pass =req.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, aname);
			
			 
			 
			 ResultSet rs = ps.executeQuery();
				
				
			 if (rs.next()) {
	                String storedPassword = rs.getString("agent_password");
	                
	                // Compare entered password with stored password
	                if (storedPassword.equals(pass)) {
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
	                    pw.println("<center><h1 style='color:green;'>Agent Login successfully...</h1></center>");
	                    pw.println("<br>");
	                    pw.println("<br>");
	                    pw.println("<br>");
	                    
		                   
	                    pw.println("<center><a   href='agentfirstpage.html'><button style='background-color:green;'>View Menu</button></a></center>");
	                    pw.println("<br>");
	                    pw.println("<br>");
	                    pw.println("<br>");
	                   
	                
	                } else {
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
	                    pw.println("<center><h1 style='color:red;'> Invalid password...</h1></center>");
	                }
	               
	            } else {
	            	pw.println("<br>");
                	pw.println("<br>");
                	pw.println("<br>");
                	pw.println("<br>");
                
	                pw.println("<center><h1 style='color:red;'> Invalid username...</h1></center>");
	            }
		 } catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}

		pw.println("<center><a class='btn btn-Info'  href='HomePage.html'><button style='background-color:green;'>Back to Home</button></a></center>");
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req,resp);
		
	}
	}

	





