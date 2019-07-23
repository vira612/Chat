package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.User;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> User =  (List<User>) getServletContext().getAttribute("User");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
        out.println("<table frame='box'>");

		out.println("<tr><th><font color='blue'>Profile</font></th></tr><tr><td><h2></h2></td></tr>");
		for(User u : User) {
			
			if(u.getId()==id) {
		        out.println("<tr align='left'><td>");
		        out.println("<p><font color='blue'>Name:</font>"+u.getName()+"</p>");
		        out.println("</td></tr>");
		        out.println("<tr align='left'><td>");
				out.println("<p><font color='blue'>Email:</font>"+u.getEmail()+"</p>");
		        out.println("</td></tr>");
		        out.println("<tr align='left'><td>");
				out.println("<p><font color='blue'>Password:</font>"+u.getPwd()+"</p>");
		        out.println("</td></tr><tr><td><h2></h2></td></tr>");
		        out.println("<tr align='left'><td>");
				out.println("<button style='background-color:blue;border: none;text-align: center;text-decoration: none;display: inline-block;'><a href='ChangeProfile?id="+u.getId()+"' style='text-decoration: none;color:white;'>Change Profile</a></button>");
		        out.println("</td></tr>");

			}
		}
        out.println("</table>");
		out.println("<button style='font-size:7pt;color:white;background-color:blue;border:2px solid #336600;padding:3px' ><a href='Chat?id="+id+"' style='text-decoration: none;color:white'>Contacts</a></button>");


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
