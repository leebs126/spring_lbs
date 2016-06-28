package com.spring.ex1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/list.do")*/
public class MemberServlet  extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			 throws IOException,ServletException{
		doHandle(request,response);
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			 throws IOException,ServletException{
		doHandle(request,response);
		
	}
	
	private void doHandle(HttpServletRequest request,HttpServletResponse response)
			 throws IOException,ServletException{
		
		MemberDao dao=new MemberDao();
		List member_list=dao.selectMemberAllList();
		
		request.setAttribute("memList", member_list);
		RequestDispatcher dispatch = request.getRequestDispatcher("ex1/listMember.jsp");  
		dispatch.forward(request, response);		
		
	}
}
