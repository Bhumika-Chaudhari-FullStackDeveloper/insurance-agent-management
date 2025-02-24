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


@WebServlet("/selectPolicy")
public class SelectPolicy extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String query="UPDATE policies SET user_id = (SELECT user_id FROM users WHERE name = ?),start_date=?,end_date=? WHERE policy_id = ?;";

		String uname=req.getParameter("UserName");
		int pid=Integer.parseInt(req.getParameter("PolicyId"));
		String sdate=req.getParameter("sdate");
		String edate=req.getParameter("edate");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, uname);
			 ps.setString(2, sdate);
			 ps.setString(3, edate);
			 ps.setInt(4,pid);
				
				 int i=ps.executeUpdate();
				  if(i==1)
				    {
					  pw.println("<br>");
	                    pw.println("<br>");
	                    pw.println("<br>");
		             
				       pw.println("<center><h1 style='color:green;'>Policy Brought Successfully...</h1></center>");
				    }
				 else {
					 pw.println("<br>");
	                    pw.println("<br>");
	                    pw.println("<br>");
		             
					 pw.println("<center><h1 style='color:red;'>Policy  not Brought...</h1></center>");
				 }
				  
				  } catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
		 pw.println("<br>");
         pw.println("<br>");
         pw.println("<br>");
         pw.println("<center><a class='btn btn-Info'  href='payment.html'><button style='background-color:green;'>Payment</button></a></center>");

		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req,resp);
		
	}
	



}




