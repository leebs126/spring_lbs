package ch8.ex3;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/*@WebFilter(urlPatterns="/*")*/
public class EncodeFilter implements Filter{
	ServletContext context;
	public void init(FilterConfig fc) throws ServletException{
		System.out.println("utf-8 ���ڵ�............");
		context =  fc.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException , ServletException{
			System.out.println("doFilter ȣ��");

			request.setCharacterEncoding( "utf-8" );  //�ѱ� ���ڵ��� �����Ѵ�.

			String path = ((HttpServletRequest)request).getContextPath();
			String pathinfo = ((HttpServletRequest)request).getRequestURI();
			String realPath = request.getRealPath( pathinfo);
			String mesg = "Context  ����:" + path + " URI ���� : " + pathinfo + " ������ ���:  " + realPath;

			chain.doFilter( request, response );  //���� ���ͷ� �ѱ�� �۾��� �Ѵ�. 
			
			
	}
	public void destroy(){
		System.out.println("destroy ȣ��");
	}
}

