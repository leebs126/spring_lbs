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
				
				if(isLogon==true){  //�ٸ� ���������� �α��� ���� ���
					 name = (String)session.getAttribute("login.name");
					 id = (String)session.getAttribute("login.id");
					pass = (String)session.getAttribute("login.pass");
	
					System.out.println(name);
					System.out.println(id);
					
	
					out.print("<html><body>");
					out.print("�̸�:"+ name+"<br>" );
					out.print("���̵�: " + id+"<br>");
					out.print("��й�ȣ: " + pass+"<br>");
					out.print("</body></html>");
				}else{
					response.sendRedirect("login3.html");
				}


			}else{
				response.sendRedirect("login3.html");
			}

	}
}

