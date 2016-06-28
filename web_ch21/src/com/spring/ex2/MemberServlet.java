package com.spring.ex2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do")
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
		request.setCharacterEncoding("utf-8");
		MemberDao dao=new MemberDao();
		MemberBean bean=new MemberBean();
		String action=request.getParameter("action");
		String nextPage="";
		if(action.equals("listMember")){
			List member_list=dao.selectMemberAllList();	
			request.setAttribute("memList", member_list);
			nextPage="ex2/listMember.jsp";
		}else if(action.equals("searchMember")){
			String id=request.getParameter("id");
			MemberBean member=dao.selectMember(id);
			request.setAttribute("member",member);
			nextPage="ex2/memberInfo.jsp";
		}else if(action.equals("regMember")){
			HashMap memberMap=new HashMap();
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			int height=Integer.parseInt(request.getParameter("height"));
			int weight=Integer.parseInt(request.getParameter("weight"));
			int age=Integer.parseInt(request.getParameter("age"));
			
			memberMap.put("id",id);
			memberMap.put("name", name);
			memberMap.put("height", height);
			memberMap.put("weight", weight);
			memberMap.put("age", age);
			dao.insertMember(memberMap);
			
			/*
			bean.setId(id);
			bean.setName(name);
			bean.setHeight(height);
			bean.setWeight(weight);
			bean.setAge(age);
			dao.insertMember(bean);
			*/
			nextPage="/member.do?action=listMember";
		}else if(action.equals("delMember")){
			String id=request.getParameter("id");
			bean.setId(id);
			dao.delMember(bean);
			nextPage="/member.do?action=listMember";
			
		}else if(action.equals("modMember")){
			
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);  
		dispatch.forward(request, response);		
		
	}
}
