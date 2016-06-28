package ch8.ex1;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/set")
public class SetAttribute extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse  response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
			String ctxMesg = "context�� ���ε��˴ϴ�.";
			String sesMesg = "session�� ���ε��˴ϴ�.";
			String reqMesg = "request�� ���ε��˴ϴ�.";
			
			ServletContext  ctx  =  getServletContext();  //���ؽ�Ʈ ��ü�� ��´�.
			HttpSession session  = request.getSession();   //���� ��ü�� �����ϸ� �����ϰ� ,������ �����Ѵ�. 

			ctx.setAttribute("context" , ctxMesg);  //������ ��ü�� ���ε� �Ѵ�.
			session.setAttribute("session" , sesMesg );
			request.setAttribute("request" , reqMesg );

			out.print("���ε��� �����մϴ�.");
			
	}
}

