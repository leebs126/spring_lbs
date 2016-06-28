package ch8.ex3;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.*;

/*@WebFilter(urlPatterns="/*")*/
public class EncodeFilter2 implements Filter{
	ServletContext context;
	public void init(FilterConfig fc) throws ServletException{
		System.out.println("utf-8 ���ڵ�............");
		context =  fc.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException , ServletException{
			System.out.println("doFilter ȣ��");

			request.setCharacterEncoding( "utf-8" );
			long begin  = System.currentTimeMillis();  
			String path = ((HttpServletRequest)request).getContextPath();
			String pathinfo = ((HttpServletRequest)request).getRequestURI();
			String realPath = request.getRealPath( pathinfo);
			String mesg = "Context  ����:" + path + " URI ���� : " + pathinfo + " ������ ���:  " + realPath;

			chain.doFilter( request, response ); 
			long end = System.currentTimeMillis();
			System.out.println("�۾� �ð�:"+(end-begin)+"ms");
	}
	public void destroy(){
		System.out.println("destroy ȣ��");
	}
}