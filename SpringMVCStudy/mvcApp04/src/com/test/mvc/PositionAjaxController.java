/*=================================
 - #60. PositionAjaxController.java
	- 사용자 정의 컨트롤러 클래스
	- 직위 리스트의 지역명 중복검사 결과 반환 액션
	
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class PositionAjaxController implements Controller
{
	
	private IPositionDAO dao;
	
	
	
	
	//Controller 인페이스의 handleRequest()메소드 재정의

	public void setDao(IPositionDAO dao)
	{
		this.dao = dao;
	}




	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		//하는 일은 doGet , doPost 와 같다.
		
		//컨트롤러 내부 액션 처리 코드
		
		
		ModelAndView mav = new ModelAndView();
		
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name")==null || session.getAttribute("admin")== null)
		{
			mav.setViewName("redirect:logout.action");
			return mav;
		}
		
		
		String positionName = request.getParameter("positionName"); 
		String result = "사용할 수 있는 이름입니다.";
		
		for (Position position : dao.list())
		{
			if(position.getPositionName().equals(positionName))
			{
				result = "이미 사용중인 이름이 존재합니다.";
				break;
			}
			
		}
		
		mav.addObject("result",result);
		
		mav.setViewName("AjaxPosition");
		
		
		return mav;
	}

	
	
}
