package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.Msg;
import Data.User;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Msg getEntry(Integer mid) {
		List<Msg> m =  (List<Msg>) getServletContext().getAttribute("Msg");
			
		for(Msg a:m) {
			if(a.getMid()==mid) {
				{
					return a;
				}
				
				
			}
			
		}
		return null;
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> User =  (List<User>) getServletContext().getAttribute("User");
		List<Msg> m =  (List<Msg>) getServletContext().getAttribute("Msg");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
		String key = (request.getParameter("key"));
		int other_id = Integer.valueOf(request.getParameter("other_id"));
		int mid = Integer.valueOf(request.getParameter("mid"));
		
		for(Msg a:m) {
			if(a.getMid()==mid) {
		out.println("<form action='Edit?mid="+a.getMid()+"&id="+id+"&key="+a.getKey()+"&other_id="+other_id+"' method='post'>" + 
				"  <font color='blue'>Message: </font><input type='text' name='msg' value='"+a.getMsg()+"'>\n" + 
				"  <input type='submit' style='font-size:7pt;color:white;background-color:blue;border:2px solid #336600;padding:3px'>\n" + 
				"</form>");
		
		
		}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<User> User =  (List<User>) getServletContext().getAttribute("User");
		List<Msg> m =  (List<Msg>) getServletContext().getAttribute("Msg");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
		String key = (request.getParameter("key"));
		int other_id = Integer.valueOf(request.getParameter("other_id"));
		int mid = Integer.valueOf(request.getParameter("mid"));
		
		String msg = (request.getParameter("msg"));
		
		Msg a1 = getEntry(mid);
		a1.setMsg(msg);
		a1.setKey(request.getParameter("key"));
		
		
		getServletContext().setAttribute("Msg", m);
		response.sendRedirect("Messages?id="+id+"&key="+key+"&other_id="+other_id);
		
	}

}
