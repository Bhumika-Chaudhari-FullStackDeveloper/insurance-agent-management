package UpdatePolicy;

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
@WebServlet("/upadtepolicy")
public class UpdatePolicy extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
			resp.setContentType("text/html");
			
			int pid=Integer.parseInt(req.getParameter("policyNo"));
			String pname=req.getParameter("policyName");
			String premium=req.getParameter("premium");
			String coverage=req.getParameter("coverage");
			
			PrintWriter pw=resp.getWriter();
			
			String query=" update policies set policy_name=?,premium=?,coverage=? where policy_id=?";
			
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceAgent","root","bhumikac2111");
				 PreparedStatement ps=con.prepareStatement(query);
				 ps.setString(1,pname );
				 ps.setString(2, premium);
				 ps.setString(3, coverage);
				 ps.setInt(4, pid);
				 int i=ps.executeUpdate();
				 if(i==1)
				 {
					 pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                	pw.println("<br>");
	                
					 pw.println("<center><h1 style='color:green;'>Policy is updated Successfully...</h1></center>");
					 
				 }
				 else
				 {
					 pw.println("<center><h1 style='color:red;'>Policy is not updated ...</h1></center>"); 
				 }
				 
						
				} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
				pw.println("<h1>"+e.getMessage()+"</h2>");
			}
			 pw.println("<br>");
			 pw.println("<br>");
         	pw.println("<br>");
         	pw.println("<br>");
         	pw.println("<br>");
         	 pw.println("<center><a   href='agentfirstpage.html'><button style='background-color:green;'>View Menu</button></a></center>");
             

			 
			
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		}




}
