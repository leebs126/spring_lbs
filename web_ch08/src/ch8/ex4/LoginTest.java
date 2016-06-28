package  ch8.ex4;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

/*@WebServlet("/login")*/
public class LoginTest extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding( "utf-8" );
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser=new LoginImpl(user_id,user_pw);
		
		
		if(session.isNew()){
			session.setAttribute("loginUser", loginUser);
		}
		out.println("<head>");
		out.println("<SCRIPT language='JavaScript'>");
		out.println("setTimeout('history.go(0);', 5000)");
		out.println("</SCRIPT>");
		out.println("</head>");
		out.println("<html><body>");
		out.println("아이디는 " + loginUser.user_id +"<br>");
		out.println("총 접속자수는"+LoginImpl.total_user +"<br>");
		out.println("</body></html>");
	}
}

