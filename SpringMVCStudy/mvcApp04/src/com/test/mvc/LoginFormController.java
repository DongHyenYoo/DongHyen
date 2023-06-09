/*=================================
	LoginFormController.java
	- 사용자 정의 컨트롤러 클래스
	- 로그인 폼 요청에 대한 액션 처리
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class LoginFormController implements Controller
{
	//Controller 인페이스의 handleRequest()메소드 재정의

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		//하는 일은 doGet , doPost 와 같다.
		
		//컨트롤러 내부 액션 처리 코드
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("LoginForm");
		
		return mav;
	}

	
	
}
