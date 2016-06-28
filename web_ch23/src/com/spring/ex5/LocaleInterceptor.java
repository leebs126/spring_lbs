package com.spring.ex5;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LocaleInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		/*try {
			//logininfo 세션값이 널일경우
			if(request.getSession().getAttribute("logininfo")==null){
					//로그인페이지로 redirect
					response.sendRedirect("/login");	
					return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//널이 아니면 정상적으로 컨트롤러 호출
*/
		HttpSession session=request.getSession();
		String locale=request.getParameter("locale");
		if(locale ==null)
			locale="ko";
		session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(locale));
		
		return true;
	}
}
