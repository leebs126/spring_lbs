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
		
			String ctxMesg = "context에 바인딩됩니다.";
			String sesMesg = "session에 바인딩됩니다.";
			String reqMesg = "request에 바인딩됩니다.";
			
			ServletContext  ctx  =  getServletContext();  //컨텍스트 객체를 얻는다.
			HttpSession session  = request.getSession();   //세션 객체가 존재하면 리턴하고 ,없으면 생성한다. 

			ctx.setAttribute("context" , ctxMesg);  //각각의 객체에 바인딩 한다.
			session.setAttribute("session" , sesMesg );
			request.setAttribute("request" , reqMesg );

			out.print("바인딩을 수행합니다.");
			
	}
}

