

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Reg extends HttpServlet {
	int num=1;
		private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*PrintWriter pw=response.getWriter();

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhanu","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from fest");
			pw.println("<h1>Participation List for Fest..........!</h1>");
			pw.println("<table border='1' style='center'><tr><th>Name</th><th>Email</th><th>College Name</th><th>Branch</th><th>Gender</th><th>Mobile No</th><th>City</th><th>Type Of Event</th></tr> ");
			while(rs.next()) {
				String	pname=rs.getString(1);
				String pemail=rs.getString(2);
				String clname=rs.getString(3);
				String branch=rs.getString(4);
				String pgender=rs.getString(5);
				String pmobile=rs.getString(6);
				String pcity=rs.getString(7);
				String event=rs.getString(8);
				
					pw.println("<tr><td>"+pname+"</td>");
					pw.print("<td>"+pemail+"</td>>");
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
			
		}*/

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String	pname=request.getParameter("name");
		String pemail=request.getParameter("email");
		String clname=request.getParameter("cname");
		String branch=request.getParameter("branch");
		String pgender=request.getParameter("gender");
		String pmobile=request.getParameter("mobile");
		String pcity=request.getParameter("city");
		String event=request.getParameter("event");
		
		String code="TECH";
		
		
		//pw.println(num);
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhanu","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select count(name) from fest1");
			while(rs.next()) {
				num=rs.getInt(1);
				num+=1;
				code=code+num;
			}
			
			PreparedStatement ps=con.prepareStatement("insert into fest1 values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, code);
			ps.setString(2, pname);
			ps.setString(3, pemail);
			ps.setString(4, clname);
			ps.setString(5, branch);
			ps.setString(6, pgender);
			ps.setString(7, pmobile);
			ps.setString(8, pcity);
			ps.setString(9, event);
			
			
			int i=ps.executeUpdate();
			if(i>0)
				pw.println("<body bg color='blue' style='color:orange;'><br><br><center><h1>You are succesfully register........For "+event+"<h1>Your Registration No is : </body>"+code);
				
			}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		//doGet(request, response);
		pw.close();
		
	}

}
