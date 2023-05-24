/*=================================
	HelloController.java
	- 사용자 정의 컨트롤러 클래스
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.



public class HelloController implements Controller
{
	//Controller 인페이스의 handleRequest()메소드 재정의

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		//하는 일은 doGet , doPost 와 같다.
		
		//컨트롤러 내부 액션 처리 코드
		
		
		ModelAndView mav = new ModelAndView();
		
		String message = "Hello, Spring MVC World~!!!";
		
		mav.addObject("message",message);
		//무엇을 건네는가
		mav.setViewName("/WEB-INF/view/Hello.jsp");
		//어떤 View로 결과를 보여줄 것인가
		
		return mav;
	}

	
	
}
