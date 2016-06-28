package com.spring.mytest05;

import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("localeController")
public class LocaleController {
	@RequestMapping(value="/test/locale.do", method={RequestMethod.GET})
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("localeController¿‘¥œ¥Ÿ.");
		return "localeTest";
	}

}

