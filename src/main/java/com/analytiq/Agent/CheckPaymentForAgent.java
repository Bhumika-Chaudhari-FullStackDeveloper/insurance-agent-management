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
@WebServlet("/checkPaymentforA")
public class CheckPaymentForAgent extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
			
			PrintWriter pw=resp.getWriter();
			
			String query=" select * from payments;";
			
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
				 PreparedStatement ps=con.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					 pw.println("<br>");
					 pw.println("<br>");
					 pw.println("<br>");
			      	pw.println("<br>");
			      	
					pw.println("<table border='1' align='center'>");
					pw.println("<tr>");
					pw.println("<th>Payment Id</th>");
					pw.println("<th>Payment Date</th>");
					pw.println("<th>Payment Amount</th>");
					pw.println("<th>Payment Method</th>");
					pw.println("<th>User Id</th>");
					pw.println("<th>Policy Id</th>");
					pw.println("<th>Payment Status</th>");
					
					pw.println("</tr>");
					while(rs.next()) {
					pw.println("<tr>");
					pw.println("<td>"+rs.getInt(1)+"</td>");
					pw.println("<td>"+rs.getDate(2)+"</td>");
					pw.println("<td>"+rs.getInt(3)+"</td>");
					pw.println("<td>"+rs.getString(4)+"</td>");
					pw.println("<td>"+rs.getInt(5)+"</td>");
					pw.println("<td>"+rs.getInt(6)+"</td>");
					pw.println("<td>"+rs.getString(7)+"</td>");
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
	      	 pw.println("<center><a   href='agentfirstpage.html'><button style='background-color:green;'>View Menu</button></a></center>");
	        
		
			}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			doGet(req, resp);}


	

}
