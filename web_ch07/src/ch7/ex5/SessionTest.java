package ch7.ex5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;


@WebServlet("/sess")
public class SessionTest  extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response )throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		if(session.isNew()){
			session.setAttribute("user_id", user_id);
			String url=response.encodeURL("sess");
			out.println("<a href="+url+">�α��� ���� Ȯ��</a>");
		}else{
			user_id=(String)session.getAttribute("user_id");
			if(user_id!=null && user_id.length()!=0){
			 out.print("�ȳ��ϼ��� " +user_id+ "��!!!");
			}else{
				out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
			}
		}
	}
}

