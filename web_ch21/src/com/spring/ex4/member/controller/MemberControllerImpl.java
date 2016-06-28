package com.spring.ex4.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.ex4.member.service.MemberService;
import com.spring.ex4.member.service.MemberServiceImpl;
import com.spring.ex4.member.vo.MemberBean;


public class MemberControllerImpl extends MultiActionController implements MemberController{
	protected final Log logger = LogFactory.getLog(getClass());
	private MemberService memberService ;  
	public void setMemberService(MemberServiceImpl memberService){
		this.memberService = memberService;
	}
	
	public ModelAndView listMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message=request.getParameter("message");
		String fileName=getFileName(request);
		List memList = memberService.getMemberList();
		ModelAndView mav = new ModelAndView(fileName);
		mav.addObject("memList", memList);
		mav.addObject("message", message);
		return mav;
	}

	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String fileName=getFileName(request);
		MemberBean memberBean= new MemberBean();
		bind(request, memberBean);
		int result = 0 ;
		result = memberService.insertMember(memberBean);
		ModelAndView mav = new ModelAndView("redirect:/member/listMember.do");
		mav.addObject("message" ,"insert" );
		return mav;
	}

	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//MemberService 의 updateMember() 호출
		return null;
	}

	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = 0 ;
		String id=request.getParameter("id");
		result = memberService.deleteMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMember.do");
		mav.addObject("message" ,"delete" );
		return mav;
	}
	
	public ModelAndView detailMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// MemberService 의 detailMember() 호출
		ModelAndView mav = new ModelAndView("redirect:/member/listMember.do");
			//	mav.addObject("result" ,result );
		return mav;
	}
	
	public  ModelAndView viewJSP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName=getFileName(request);
		ModelAndView mav = new ModelAndView(fileName);
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
		return fileName;
	}	
}
