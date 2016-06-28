package ch7.ex7;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/show")
public class ShowLogin extends HttpServlet{
	public void doGet(HttpServletRequest request  , HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			String name="";
			String id ="";
			String pass="";
			Boolean isLogon=false;
			HttpSession session =  request.getSession(false);			

			if( session != null){
				System.out.println("session");
				isLogon=(Boolean)session.getAttribute("isLogon");
				
				if(isLogon==true){  //다른 페이지에서 로그인 했을 경우
					 name = (String)session.getAttribute("login.name");
					 id = (String)session.getAttribute("login.id");
					pass = (String)session.getAttribute("login.pass");
	
					System.out.println(name);
					System.out.println(id);
					
	
					out.print("<html><body>");
					out.print("이름:"+ name+"<br>" );
					out.print("아이디: " + id+"<br>");
					out.print("비밀번호: " + pass+"<br>");
					out.print("</body></html>");
				}else{
					response.sendRedirect("login3.html");
				}


			}else{
				response.sendRedirect("login3.html");
			}

	}
}

