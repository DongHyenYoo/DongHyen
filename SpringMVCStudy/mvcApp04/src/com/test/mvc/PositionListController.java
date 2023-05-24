/*=================================
	#56. PositionListController.java
	- 사용자 정의 컨트롤러 클래스
	- 직위 리스트 페이지 요청에 대한 액션 처리
	- DAO 객체에 대한 의존성 주입(DI)을 위한 준비
	 → 인터페이스 자료형 구성.
	 → setter메소드 구성
==================================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class PositionListController implements Controller
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
		
		ArrayList<Position> positionList = new ArrayList<Position>();
		
		try
		{
			positionList = dao.list();
			
			mav.addObject("positionList",positionList);
			
			mav.setViewName("PositionList");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		
		
		
		return mav;
	}

	
	
}
