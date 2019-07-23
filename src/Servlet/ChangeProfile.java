package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.*;

@WebServlet("/ChangeProfile")
public class ChangeProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ChangeProfile() {
        super();
    }
    
    private User getEntry(Integer id) {
		List<User> m =  (List<User>) getServletContext().getAttribute("User");
			
		for(User a:m) {
			if(a.getId()==id) {
				{
					return a;
				}
				
				
			}
			
		}
		return null;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> User =  (List<User>) getServletContext().getAttribute("User");
		//List<Msg> m =  (List<Msg>) getServletContext().getAttribute("Msg");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
		String key = (request.getParameter("key"));
		//int other_id = Integer.valueOf(request.getParameter("other_id"));
		//int mid = Integer.valueOf(request.getParameter("mid"));
		
		for(User u : User) {
			if(u.getId()==id) {
		out.println("<table  frame='box'><tr><td><form action='ChangeProfile?id="+u.getId()+"' method='post'><br>" + 
				" <font color='blue'> Name:</font> <input type='text' name='msg' value='"+u.getName()+"'><br>" +
				" <font color='blue'>Email:</font> <input type='email' name='msg1' value='"+u.getEmail()+"'><br>" +
				"  <font color='blue'>Password:</font> <input type='password' name='msg2' value='"+u.getPwd()+"'><br>" +
				" <div align='center'> <input type='submit' value='Edit Profile' style='font-size:7pt;color:white;background-color:blue;border:2px solid #336600;padding:3px' ></div>" + 
				"</form></td></tr></table>");
		
		
		}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> User =  (List<User>) getServletContext().getAttribute("User");
		//List<Msg> m =  (List<Msg>) getServletContext().getAttribute("Msg");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
//		String key = (request.getParameter("key"));
//		int other_id = Integer.valueOf(request.getParameter("other_id"));
//		int mid = Integer.valueOf(request.getParameter("mid"));
		
		String msg = (request.getParameter("msg"));
		String msg1 = (request.getParameter("msg1"));
		String msg2 = (request.getParameter("msg2"));
		
		User a1 = getEntry(id);
		a1.setName(msg);
		a1.setEmail(msg1);
		a1.setPwd(msg2);
		
		
		getServletContext().setAttribute("Msg", User);
		response.sendRedirect("Profile?id="+id);
	}

}
