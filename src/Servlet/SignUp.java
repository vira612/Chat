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
import Data.Msg;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
    public SignUp() {
        super();
    }
    
    public int id; 
    
    public void init() { 
        // Reset hit counter.
    	id = 1;
    	List<User> User=new ArrayList<User>();
    	User.add(new User(id,"john","john@gmail.com","123"));
    	List<Msg> Msg=new ArrayList<Msg>();
    	
    	
    	getServletContext().setAttribute("Msg",Msg);
    	
    	getServletContext().setAttribute("User",User);
     } 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		id++;
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        out.println( "<html><head><title>Chat App</title></head><body>" );
        out.println("<table frame='box'>");
        out.println("<tr><th> <font color='blue'>Welcome to Chat Application</font></th></tr>");
        //out.println("<tr>");
        out.println( "<form action='SignUp' method='post'>" );

        out.println("<input type='hidden' name='id' value='"+(id)+"'>");
       
        out.println("<tr align='left'><td>");
        out.println("<font color='blue'>Name:</font><input type='text' name='userName'><br>");
        out.println("</td></tr>");
        
        out.println("<tr align='left'><td>");
        out.println("<font color='blue'>Password:</font><input type='password' name='userPass'><br>");
        out.println("</td></tr>");

        out.println("<tr align='left'><td>");
        out.println("<font color='blue'>Email Id:</font><input type='email' name='userEmail'><br>");
        out.println("</td></tr>");

        out.println("<tr align='center'><td>");
        out.println("<input type='submit' value='Register' style='font-size:7pt;color:white;background-color:blue;border:2px solid #336600;padding:3px' >");
        out.println("</tr></tr>");

        out.println("</form>");
        out.println("</table>");

        out.println("</body></html>");       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		
		List<User> u =  (List<User>) getServletContext().getAttribute("User");
		String id1=request.getParameter("id"); 
		int id = Integer.valueOf(id1);
		String n=request.getParameter("userName");  
		String p=request.getParameter("userPass");  
		String e=request.getParameter("userEmail");
		User u1 =new User(id,n,e,p);
		u.add(u1);
		
		for(User a : u) {
			System.out.println( a.getName());	
		}
			

		getServletContext().setAttribute("User", u);
		response.sendRedirect("Chat?id="+id);
	}

}
