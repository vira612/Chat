package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.User;

@WebServlet("/Chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Chat() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> User =  (List<User>) getServletContext().getAttribute("User");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		int id = Integer.valueOf(request.getParameter("id"));
		
        out.println("<table frame='box'>");

		
		for(User u : User) {
			if(u.getId()==id) {
				out.println("<tr><th><h2>Welcome <font color='blue'><a href='Profile?id="+id+"' style='text-decoration: none;'>"+u.getName()+"</a></font></h2></th></tr>");
			}
		}
		
		//out.println("<a href='Profile?id="+id+"'>Profile</a>");
		
		out.println("<tr> <td><p align='center'>Contacts</p>");
		
		for(User u : User) {
			if(u.getId()!=id) {
	        out.println("<p align='center' style='border-style: solid;border-width: 1px;'>");
	        out.println("<a href='Messages?id="+id+"&key="+id +u.getId()+"&other_id="+u.getId()+"' style='text-decoration: none;'>"+u.getName()+"</a> ");
				//out.println("<a href='Chat?id="+u.getId()+"'>Become "+u.getName()+"</a>");
	        out.println("</p>");
			}
		}
		
		out.println("</tr> </td>");

		out.println("</table>");

		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
