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
@WebServlet("/viewPoliciesUser")
public class viewPolicytoUser extends HttpServlet {
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
				} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
				pw.println("<h1>"+e.getMessage()+"</h2>");
			}
			 pw.println(" <center><h1 style='color:green;'>Please See the Policy No to be taken...</h1></center>");
			  pw.println("<br>");
              pw.println("<br>");
              pw.println("<br>");
            
			 pw.println("<center><a class='btn btn-Info'  href='SelectPolicy.html'><button style='background-color:green;'>Select Policy</button></a></center>");
				
			 pw.println("<br>");
	            
				pw.println("<center><a class='btn btn-Info'  href='HomePage.html'><button style='background-color:green;'>Back to Home</button></a></center>");
			}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			doGet(req, resp);}

	}



