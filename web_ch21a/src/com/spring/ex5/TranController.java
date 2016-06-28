package com.spring.ex5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TranController extends MultiActionController {
	private TranService tranService ; 
	public void setTranService(TranService tranService){
		this.tranService = tranService;
	}	
	
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		tranService.addMember();
		mav.setViewName("result");
		return mav;
	}

}
