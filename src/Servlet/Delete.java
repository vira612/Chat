package Servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.*;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Delete() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.valueOf( request.getParameter( "mid" ) );
		int id = Integer.valueOf(request.getParameter("id"));
		String key = (request.getParameter("key"));
		int other_id = Integer.valueOf(request.getParameter("other_id"));
		List<Msg> m =  (List<Msg>) getServletContext().getAttribute("Msg");
		
		for(Msg a:m) {
			if(a.getMid()==mid) {
				{
					m.remove( a );
	                break;
					
				}
				
				
			}
			
		}
		

		response.sendRedirect("Messages?id="+id+"&key="+key+"&other_id="+other_id+"");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
