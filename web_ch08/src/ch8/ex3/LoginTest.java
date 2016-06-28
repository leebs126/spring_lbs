package  ch8.ex3;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

/*@WebServlet("/login")*/
public class LoginTest extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	request.setCharacterEncoding( "utf-8" );
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		out.println("<html><body>");
		out.println("이름는 " + user_name +"<br>");
		out.println("비밀번호는 "+user_pw +"<br>");
		out.println("</body></html>");
	}
}

