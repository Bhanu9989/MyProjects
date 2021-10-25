
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RespApp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhanu","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from login where username='"+name+"' and password='"+password+"'");
			if(rs.next()) {
				pw.println("Welcome<h1>"+name);
				
				}
			else {
					pw.println("Inalid Password..!");
				}
			con.close();
			}
			
			
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhanu","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from fest1");
			pw.println("<br><br>Click to <a href='1.html'><b>LogOut</b></a>");
			pw.println("<body style='text-align:center; background-color:#b3ffff;'><h1>Participation List for Fest..........!</h1>");
			pw.println("<table border='1' style='text-align:center;background-color:blue;margin:50px auto;'>"
					+ "<tr style='color:orange;'><th>Id</th><th>Name</th><th>Email</th><th>College Name</th><th>Branch</th><th>Gender</th><th>Mobile No</th><th>City</th><th>Type Of Event</th></tr> ");
			while(rs.next()) {
				String	pid=rs.getString(1);
				String	pname=rs.getString(2);
				String pemail=rs.getString(3);
				String clname=rs.getString(4);
				String branch=rs.getString(5);
				String pgender=rs.getString(6);
				String pmobile=rs.getString(7);
				String pcity=rs.getString(8);
				String event=rs.getString(9);
				
				pw.println("<tr style='color:white;'><td>"+pid+"</td>");
					pw.println("<td>"+pname+"</td>");
					pw.print("<td>"+pemail+"</td>");
					pw.print("<td>"+clname+"</td>");
					pw.print("<td>"+branch+"</td>");
					pw.print("<td>"+pgender+"</td>");
					pw.print("<td>"+pmobile+"</td>");
					pw.print("<td>"+pcity+"</td>");
					pw.print("<td>"+event+"</td>");
				}
			
			pw.println("</table>");
			}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}

}
