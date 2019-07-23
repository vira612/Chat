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
import Data.*;

@WebServlet("/Messages")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int mid; 
    
    public void init() { 
        // Reset hit counter.
    	mid=0;
//    	List<Msg> Msg=new ArrayList<Msg>();
//    	
//    	
//    	getServletContext().setAttribute("Msg",Msg);
     } 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> User =  (List<User>) getServletContext().getAttribute("User");
		List<Msg> m =  (List<Msg>) getServletContext().getAttribute("Msg");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
		String key = (request.getParameter("key"));
		int other_id = Integer.valueOf(request.getParameter("other_id"));

		
		
		
		for(User u : User) {
			for(User v : User) {
				if(u.getId()==id && v.getId()==other_id) {
					out.println("<table frame='box'><tr><th align='center'><div style='border-style: solid;border-width: 1px;'><h1><font color='blue'>Chat with </font>"+v.getName()+"</h1></div></th></tr>");
					}
			}
		}
		
		
		
		
		for(User u : User) {
			for(User v : User) {
				if(u.getId()==id && v.getId()==other_id) {
			
				
						String hello2 = String.valueOf(id);
						String hello1 = String.valueOf(other_id);
						String hello = hello1 + hello2;
						out.println("<tr><td><h2><font color='blue'>Messages</font></h2></td></tr>");
						
						if(m.size()==0) {
							out.println("<tr><td><form action='Messages?id="+id+"&key="+id +other_id+"&other_id="+other_id+"' method='post'>" + 
									"  <textarea type='text' name='msg'></textarea>\n" + 
									"  <input type='submit' value='send'>\n" + 
									"</form></td></tr>");
							}
						else {
							for(Msg a : m) {
								if(a.getKey().equals(key) || a.getKey().equals(hello) ) {
	
									String s=a.getKey();
									
										if(s.charAt(0)== hello2.charAt(0)) {
											out.println("<tr><td align='right'><p>");
											out.println(a.getMsg());
											out.println("<br><button style='font-size:7pt;color:white;background-color:blue;border:2px solid #336600;padding:3px' ><a href='Edit?mid="+a.getMid()+"&id="+u.getId()+"&key="+a.getKey()+"&other_id="+v.getId()+"' style='text-decoration: none;color:white'>Edit</a></button>");
											out.println("<button style='font-size:7pt;color:white;background-color:blue;border:2px solid #336600;padding:3px' ><a href='Delete?mid="+a.getMid()+"&id="+u.getId()+"&key="+a.getKey()+"&other_id="+v.getId()+"' style='text-decoration: none;color:white'>Delete</a></button>");
											out.println("</p></td></tr>");
											getServletContext().setAttribute("Msg",m);

											}
										else {
											out.println("<tr><td align='left'>");
											out.println("<p>"+a.getMsg()+"</p>");
											out.println("</td></tr>");
											getServletContext().setAttribute("Msg",m);

										}
										

								}
							}
							out.println("<tr><td><form action='Messages?id="+id+"&key="+id +other_id+"&other_id="+other_id+"' method='post'>" + 
									"  <textarea type='text' name='msg'></textarea>\n" + 
									"  <input type='submit' value='send'>\n" + 
									"</form></td></tr>");
						
							}
						
						}
				}
			}
	
		
		
		out.println("<button style='font-size:7pt;color:white;background-color:blue;border:2px solid #336600;padding:3px' ><a href='Chat?id="+id+"' style='text-decoration: none;color:white'>Contacts</a></button>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		int other_id = Integer.valueOf(request.getParameter("other_id"));
		
		String key = (request.getParameter("key"));
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
//		
		List<Msg> m =  (List<Msg>) getServletContext().getAttribute("Msg");
		List<User> User =  (List<User>) getServletContext().getAttribute("User");

					String n=request.getParameter("msg");
//					
					Msg u1 =new Msg(mid++,n,key);
					m.add(u1);
//					
					getServletContext().setAttribute("Msg",m);

					response.sendRedirect("Messages?id="+id+"&key="+key+"&other_id="+other_id+"");
			
			//doGet(request,response);
			
		
	}

}
