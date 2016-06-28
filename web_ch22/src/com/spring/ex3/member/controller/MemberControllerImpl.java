package com.spring.ex3.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.ex3.member.service.MemberService;
import com.spring.ex3.member.vo.MemberBean;

@Controller
@RequestMapping("/member")
public class MemberControllerImpl extends MultiActionController implements MemberController{
	@Autowired
	private MemberService memberService ;  

	@RequestMapping(value="/listMember.do" ,method = RequestMethod.GET)
	public ModelAndView listMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message=request.getParameter("message");
		String fileName=getFileName(request);
		List memList = memberService.getMemberList();
		ModelAndView mav = new ModelAndView(fileName);
		mav.addObject("memList", memList);
		mav.addObject("message",message);
		return mav;
	}

	 @RequestMapping(value="/addMember.do" ,method = RequestMethod.POST)
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String fileName=getFileName(request);
		MemberBean memberBean= new MemberBean();
		bind(request, memberBean);
		int result = 0 ;
		result = memberService.addMember(memberBean);
		ModelAndView mav = new ModelAndView("redirect:/member/listMember.do");
		mav.addObject("message" ,"insert" );
		return mav;
	}

	 @RequestMapping(value="/modMember.do" ,method = RequestMethod.POST)
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//MemberService ¿« updateMember() »£√‚
		return null;
	}

	 @RequestMapping(value="/delMember.do" ,method = RequestMethod.GET)
	public ModelAndView delMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = 0 ;
		String id=request.getParameter("id");
		result = memberService.delMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMember.do");
		mav.addObject("message" ,"delete" );
		return mav;
	}
	
	@RequestMapping(value="/detailMember.do" ,method = RequestMethod.GET)
	public ModelAndView detailMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return null;
	}
	
	@RequestMapping(value="/*.do" ,method={RequestMethod.POST,RequestMethod.GET})
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
