package ch8.ex1;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/get")
public class GetAttribute extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse  response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

	    ServletContext ctx = getServletContext();
	    HttpSession sess = request.getSession();
 
		 String ctxMesg = (String)ctx.getAttribute("context");
		 String sesMesg = (String)sess.getAttribute("session");
		 String reqMesg = (String)request.getAttribute("request");

		out.print("context°ª : " + ctxMesg + "<br>");	
		out.print("session°ª : " + sesMesg + "<br>");
		out.print("request°ª : " + reqMesg + "<br>");
		
	}
}

