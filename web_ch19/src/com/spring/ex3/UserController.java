package com.spring.ex3;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class UserController extends MultiActionController {

	public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = "";
		String passwd = "";
		String fileName=getFileName(request);
		ModelAndView mav=new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userid = request.getParameter("userid");
		passwd = request.getParameter("passwd");

		mav.addObject("userid", userid);
		mav.addObject("passwd", passwd);
		mav.setViewName(fileName);
		System.out.println("ViewName:"+fileName);
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String fileName=getFileName(request);
		int weight=Integer.parseInt(request.getParameter("weight"));
		int height=Integer.parseInt(request.getParameter("height"));
		int age=Integer.parseInt(request.getParameter("age"));
		
		mav.addObject("id",id);
		mav.addObject("name",name);
		mav.addObject("weight",weight);
		mav.addObject("height",weight);
		mav.addObject("age",age);
		mav.setViewName(fileName);
		System.out.println("ViewName:"+fileName);
		return mav;
	}
	
	private  String getFileName(HttpServletRequest request) throws Exception {

		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");


		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if(!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if(uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if(fileName.indexOf(".") != -1) {
		        fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/") != -1){
		        fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}

		return fileName;
	}	
}


