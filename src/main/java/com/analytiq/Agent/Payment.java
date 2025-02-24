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
@WebServlet("/payment")
public class Payment extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String query="INSERT INTO payments (payment_date, payment_amount, payment_method, user_id, policy_id, payment_status)VALUES (?, ?, ?, (SELECT user_id FROM users WHERE name = ?), ?, ?)";

		String pdate=req.getParameter("pdate");
		int pamount=Integer.parseInt(req.getParameter("Pamount"));
	    String pmethod=req.getParameter("pmethod");
	    String uname=req.getParameter("uid");
	   int pid=Integer.parseInt(req.getParameter("pid"));
	    String pstatus=req.getParameter("pstatus");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			PreparedStatement ps=con.prepareStatement(query);

			 ps.setString(1,pdate );
			 ps.setInt(2,pamount);
				 ps.setString(3,pmethod);
				 ps.setString(4,uname);
				  ps.setInt(5,pid);
				 ps.setString(6,pstatus);
				
				 int i=ps.executeUpdate();
				  if(i==1)
				    {
						pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
				       pw.println("<center><h1 style='color:green;'>Payment Successfully...</h1></center>");
				    }
				 else {
						pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
					 pw.println("<center><h1 style='color:red;'> <h1> Payment not Sucessfully...</h1></center>");
				 }
				  
				  } catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
			pw.println("<center><h1 style='color:red;'> <h1> payment not Successfully</h1></center>");
			pw.println("<br>");
        	pw.println("<br>");
        	pw.println("<br>");
        	pw.println("<br>");
        
			pw.println("<h1>"+e.getMessage()+"</h1>");
			
		}
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
