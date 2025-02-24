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

@WebServlet("/viewPolicies")

public class ViewAllPolicies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
		
		PrintWriter pw=resp.getWriter();
		
		String query=" select policy_id, policy_name, premium ,coverage from policies";
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			 PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				
				pw.println("<table border='1' align='center'>");
				pw.println("<tr>");
				pw.println("<th>Policy Id</th>");
				pw.println("<th>Policy Name</th>");
				pw.println("<th>Premium</th>");
				pw.println("<th>Coverage</th>");
				pw.println("</tr>");
				while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getString(4)+"</td>");
							pw.println("</tr>");
							
							   
		 }
				pw.println("<table>");
				pw.println("<br>");
           
                pw.println("<center><a   href='agentfirstpage.html'><button style='background-color:green;'>View Menu</button></a></center>");
	                
			} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h2>");
		}
		 pw.println("<br>");
		
		 pw.println("<br>");
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);}

}
