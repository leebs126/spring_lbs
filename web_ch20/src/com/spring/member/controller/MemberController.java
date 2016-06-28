package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	public ModelAndView listMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public  ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}


