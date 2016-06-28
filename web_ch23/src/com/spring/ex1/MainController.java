package com.spring.ex1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController{
	protected final Log logger = LogFactory.getLog(getClass());
	@RequestMapping("/main.do")
	public ModelAndView main(){
		logger.debug("main.do 호출");
		String message = "안녕하세요!!!";
		ModelAndView mav=new ModelAndView();
		mav.addObject("message",message);
		mav.setViewName("main");
		return mav; 
	}

}
