package com.spring.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
	public ModelAndView listWrite(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView addWrite(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewWrite(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public  ModelAndView removeWrite(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public  ModelAndView addReply(HttpServletRequest request, HttpServletResponse response) throws Exception;
	

}
