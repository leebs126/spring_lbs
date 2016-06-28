package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	public ModelAndView listMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView delMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView detailMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
