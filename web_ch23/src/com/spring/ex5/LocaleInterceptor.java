package com.spring.ex5;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LocaleInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		/*try {
			//logininfo ���ǰ��� ���ϰ��
			if(request.getSession().getAttribute("logininfo")==null){
					//�α����������� redirect
					response.sendRedirect("/login");	
					return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//���� �ƴϸ� ���������� ��Ʈ�ѷ� ȣ��
*/
		HttpSession session=request.getSession();
		String locale=request.getParameter("locale");
		if(locale ==null)
			locale="ko";
		session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(locale));
		
		return true;
	}
}
