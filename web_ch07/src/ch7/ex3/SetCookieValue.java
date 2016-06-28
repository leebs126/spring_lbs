package ch7.ex3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue  extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	 throws IOException, ServletException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Date d=new Date();
		//Cookie c=new Cookie("cookieTest",d.toString());
		Cookie c=new Cookie("cookieTest",URLEncoder.encode("JSP���α׷����Դϴ�.","utf-8"));
		//c.setMaxAge(24*60*60);
		c.setMaxAge(-1);
		response.addCookie(c);
		
		out.println("����ð� : "+d);
		out.println("����ð��� Cookie�� �����մϴ�.");
		
	}
}
