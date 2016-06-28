package com.spring.ex2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	@RequestMapping(value="/test/loginForm.do", method={RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	//request가 필요하면, 하고 쓰면된다 쓰지 않을 경우 쓰지 않아도 된다.
	@RequestMapping(value="/test/loginAction.do", method={RequestMethod.POST,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("result");
		String id=request.getParameter("userId");
		String name=request.getParameter("userName");
		mav.addObject("userId",id);
		mav.addObject("userName",name);
		return mav;
	//리타이렉트 시키는 방법
	//return "redirect:/main.action";
	}
}