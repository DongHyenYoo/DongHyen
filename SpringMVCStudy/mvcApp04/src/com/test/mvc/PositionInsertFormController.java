/*=================================
#58. PositionInsertFormController.java
	- 사용자 정의 컨트롤러 클래스
	- 지역 데이터 입력 폼 요청에 대한 액션 처리
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class PositionInsertFormController implements Controller
{
	//Controller 인페이스의 handleRequest()메소드 재정의

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		//하는 일은 doGet , doPost 와 같다.
		
		//컨트롤러 내부 액션 처리 코드
		
		
		ModelAndView mav = new ModelAndView();
		
		//세션 처리과정 추가(로그인에 대한 확인 과정 추가)===================================
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name")==null) //로그인이 되어있지 않은 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
			
		}
		else if(session.getAttribute("admin")==null) //로그인은 되어있으나 관리자가 아님
		{
			mav.setViewName("redirect:logout.action");
			return mav;
		}
		
		//세션 처리과정 추가(로그인에 대한 확인 과정 추가)===================================
				
		
		try
		{
			
			mav.setViewName("PositionInsertForm");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		return mav;
	}

	
	
}
