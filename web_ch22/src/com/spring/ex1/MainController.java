package com.spring.ex1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
	//��Ʈ�ѷ���� ������̼� �߰�!
	@Controller("mainController")
	// RequestMapping:�ּ��ٿ��� /test.do��  �Է��ϸ� ������Ʈ�ѷ��� �޾Ƽ� �����ϰڴ�.
	@RequestMapping("/test")
	public class MainController {
		//  ../main/test.do�� ��û �� ȣ��ȴ�.(get���)
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
