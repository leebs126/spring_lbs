package ch7.ex7;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/login")
public class LoginSession extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding( "utf-8" );
			String user_name   = request.getParameter("user_name");
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			MemberVO memberVO=new MemberVO();
			memberVO.setId(user_id);
			
			HttpSession session  =  request.getSession();
			MemberDao dao=new MemberDao();
			boolean result=dao.isExisted(memberVO);
			
			if(result){
				session.setAttribute("isLogon",new Boolean(true));  //�α��� ���¸� �����Ѵ�.
				session.setAttribute("login.name" , user_name);
				session.setAttribute("login.id" , user_id);
				session.setAttribute("login.pass" , user_pw);
				
				out.print("<html><body><center>");
				out.print("�ȳ��ϼ��� "+user_name+"��!!!<br>");
				out.print("<a href='show'>ȸ����������</a>");
				out.print("</center></body></html>");
			}else{
				out.print("<html><body><center>ȸ�� ���̵� Ʋ���ϴ�.");
				out.print("<a href='login3.html'> �ٽ� �α����ϱ�</a>");
				out.print("</center>");
				out.print("</body></html>");
			}

		
			
	}
}

