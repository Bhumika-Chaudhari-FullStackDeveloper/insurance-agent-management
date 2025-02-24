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
@WebServlet("/registerAgent")
public class RegisterAgent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String query="insert into  Agent  (agent_name,agent_email,agent_phone, agent_password ) values (?,?,?,?)";

		String aname=req.getParameter("AgentName");
		String aEmail=req.getParameter("Email");
		String mobile =req.getParameter("mobile");
		String pass =req.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
			PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, aname);
			 ps.setString(2,aEmail);
				 ps.setString(3,mobile);
				 ps.setString(4,pass);
				 int i=ps.executeUpdate();
				  if(i==1)
				    {
				       pw.println("<h1>Registered Successfully...</h1>");
				    }
				 else {
					 pw.println("<h1> Record not Register</h1>");
				 }
				  
				  } catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
		
		pw.println("<a class='btn btn-Info'  href='AgentLogin.html'>Login Here</a>");
		pw.println("<a class='btn btn-Info'  href='HomePage.html'>Back to Home</a>");
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req,resp);
		
	}
	

}
