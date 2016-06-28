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
		System.out.println("utf-8 인코딩............");
		context =  fc.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException , ServletException{
			System.out.println("doFilter 호출");

			request.setCharacterEncoding( "utf-8" );  //한글 인코딩을 세팅한다.

			String path = ((HttpServletRequest)request).getContextPath();
			String pathinfo = ((HttpServletRequest)request).getRequestURI();
			String realPath = request.getRealPath( pathinfo);
			String mesg = "Context  정보:" + path + " URI 정보 : " + pathinfo + " 물리적 경로:  " + realPath;

			chain.doFilter( request, response );  //다음 필터로 넘기는 작업을 한다. 
			
			
	}
	public void destroy(){
		System.out.println("destroy 호출");
	}
}

