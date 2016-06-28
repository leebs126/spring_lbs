package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl   extends MultiActionController  implements MemberController{
	protected final Log logger = LogFactory.getLog(getClass());
	private MemberService memberService ;  
	public void setMemberService(MemberServiceImpl memberService){
		this.memberService = memberService;
	}
	
	public ModelAndView listMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName=getFileName(request);
		List memberList = memberService.getMemberList();
		System.out.println("memberList size : "+ memberList.size());

		ModelAndView mav = new ModelAndView(fileName);
		mav.addObject("memberList", memberList);
		return mav;
	}

	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String fileName=getFileName(request);
		MemberVO memberVO = new MemberVO();
		bind(request, memberVO);
		int result = 0 ;
		result = memberService.insertMember(memberVO);
		ModelAndView mav = new ModelAndView("/member/insertRst");
		mav.addObject("result" ,result );
		return mav;
	}

	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//MemberService 의 updateMember() 호출
		return null;
	}

	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// MemberService 의 deleteMember() 호출
		return null;
	}
	
	public  ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
