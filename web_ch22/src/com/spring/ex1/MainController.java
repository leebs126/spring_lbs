package com.spring.ex1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
	//컨트롤러라는 어노테이션 추가!
	@Controller("mainController")
	// RequestMapping:주소줄에서 /test.do를  입력하면 메인컨트롤러가 받아서 실행하겠다.
	@RequestMapping("/test")
	public class MainController {
		//  ../main/test.do로 요청 시 호출된다.(get방식)
		@RequestMapping(value="/main.do" ,method = RequestMethod.GET)
		public ModelAndView test1(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav=new ModelAndView();
			mav.setViewName("/main");
			return mav;
			
		}
		
		@RequestMapping(value="/main2.do" ,method = RequestMethod.GET)
		public ModelAndView test2(HttpServletRequest request, HttpServletResponse response){
			ModelAndView mav=new ModelAndView();
			mav.setViewName("/main2");
			return mav;
		}
		
}
