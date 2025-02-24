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
@WebServlet("/AddPolicies")
public class AddPolicy extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String query="insert into  policies (policy_name, premium ,coverage ) values (?,?,?)";

		String pname=req.getParameter("policyName");
		String premium=req.getParameter("premium");
		String coverage=req.getParameter("coverage");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, pname);
			 ps.setString(2,premium);
				 ps.setString(3,coverage);
				
				 int i=ps.executeUpdate();
				  if(i==1)
				    {
					  pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
				       pw.println("<center><h1 style='color:green;'> Policy Added Successfully...</h1></center>");
				    }
				 else {
					 pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
					 pw.println("<center><h1 style='color:red;'>Policy Not Added...</h1></center>");
				 }
				  
				  } catch (ClassNotFoundException | SQLException e) {
					  pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
					  pw.println("<center><h1 style='color:red;'>Policy Not Added...</h1></center>");
	
			e.printStackTrace();
		}
		
		
		 pw.println("<br>");
		 pw.println("<br>");
		 pw.println("<center><a   href='agentfirstpage.html'><button style='background-color:green;'>View Menu</button></a></center>");
         
		 pw.println("<br>");
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req,resp);
		
	}
	


	
}
