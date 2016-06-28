package ch15.ex3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem.do")
public class MemberController extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doHandle(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doHandle(request,response);
	}
	
	
	private void doHandle(HttpServletRequest request,HttpServletResponse response)
	 throws IOException,ServletException{
		String nextPage=null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String action=request.getParameter("action");
		System.out.println("action:"+action);
		
		MemberDao dao=new MemberDao();
		
		if(action==null || action.equals("memberList")){
			ArrayList memberList=dao.listMember();
			request.setAttribute("memberList", memberList);
			nextPage="/ex3/memberList.jsp";
		}else if(action.equals("regMember")){
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			int weight=Integer.parseInt(request.getParameter("weight"));
			int height=Integer.parseInt(request.getParameter("height"));
			MemberVO vo=new MemberVO(id,name,age,weight,height);
			dao.insertMember(vo);
			nextPage="mem.do?action=memberList";
			
		}else if(action.equals("memberForm.ui")){
			nextPage="/ex3/memberForm.jsp";
		}else if(action.equals("modMember.ui")){
			String id=request.getParameter("id");
			MemberVO memVO=dao.selectMember(id);
			request.setAttribute("memVO", memVO);
			nextPage="/ex3/modMember.jsp";
		}else if(action.equals("modMember")){
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			int weight=Integer.parseInt(request.getParameter("weight"));
			int height=Integer.parseInt(request.getParameter("height"));
			MemberVO vo=new MemberVO(id,name,age,weight,height);
			dao.modMember(vo);
			nextPage="mem.do?action=memberList";
		}else if(action.equals("delMember")){
			String id=request.getParameter("id");
			dao.delMember(id);
			request.setAttribute("message", "deleted");
			nextPage="mem.do?action=memberList";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);  
		dispatch.forward(request, response);
	}
}
