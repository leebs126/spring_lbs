package com.spring.ex5;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller("login")

public class LoginController extends MultiActionController {
	@RequestMapping(value="/findlogin.do")
	public ModelAndView findLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	
	private  String getFileName(HttpServletRequest request) throws Exception {
		String contextPath=request.getContextPath();
		String uri=(String)request.getAttribute("javax.servlet.include.request_uri");

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


