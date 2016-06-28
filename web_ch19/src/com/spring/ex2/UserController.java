package com.spring.ex2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class UserController extends MultiActionController {

	public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = "";
		String passwd = "";
		ModelAndView mav=new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userid = request.getParameter("userid");
		passwd = request.getParameter("passwd");

		mav.addObject("userid", userid);
		mav.addObject("passwd", passwd);
		mav.setViewName("result");
		return mav;
	}
	
	public ModelAndView getMemberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		int weight=Integer.parseInt(request.getParameter("weight"));
		int height=Integer.parseInt(request.getParameter("height"));
		int age=Integer.parseInt(request.getParameter("age"));
		
		mav.addObject("id",id);
		mav.addObject("name",name);
		mav.addObject("weight",weight);
		mav.addObject("height",weight);
		mav.addObject("age",age);
		mav.setViewName("memberInfo");
		return mav;
	}
}


