package ch7.ex4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;


/*@WebServlet("/sess")*/
public class SessionTest  extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response )throws IOException{
		
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();  //세션이 있으면  리턴하고 없으면 생성한다.


		out.println("Session ID : "+session.getId()+"<br>");
		out.println("Creation Time : "+ new Date(session.getCreationTime())+"<br>");
		out.println("Last Accessed Time : "+ new Date(session.getLastAccessedTime())+"<br>");
		out.println("Max Inactive Interval : "+ session.getMaxInactiveInterval()+"<br>");

		//session.setMaxInactiveInterval(5);

		if(session.isNew()){
				out.print("NEW Session is Createed");
		}
		session.invalidate();
	}
}

