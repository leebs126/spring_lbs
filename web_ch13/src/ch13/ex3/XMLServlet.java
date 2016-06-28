package ch13.ex3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xml")
public class XMLServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String result="";
		PrintWriter writer = response.getWriter();
		
		
		result="<main><book>"+
				"<title><![CDATA[�ι�,����, ������ ���� :���� �ô��� ���� ���]]></title>" +
				"<writer><![CDATA[ö���� �ô� �� | Ǫ����]]></writer>" +
				"<image><![CDATA[http://localhost:8090/web_ch13/image/image.jpg]]></image>"+
				"</book>"+
				"<book>"+
				"<title><![CDATA[���Ƕ� �����ΰ�?]]></title>" +
				"<writer><![CDATA[����Ŭ ���� �� | �迵��]]></writer>" +
				"<image><![CDATA[http://localhost:8090/web_ch13/image/image1.jpg]]></image>"+
				"</book></main>"				
				;
		System.out.println(result);
		writer.print(result);
		
		
	}	

}
