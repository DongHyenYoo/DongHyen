/*=================================
	AjaxRegionController.java
	- 사용자 정의 컨트롤러 클래스
	- 지역 리스트의 지역명 중복검사 결과 반환 액션
	
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class AjaxRegionController implements Controller
{
	
	private IRegionDAO dao;
	
	
	
	
	//Controller 인페이스의 handleRequest()메소드 재정의

	public void setDao(IRegionDAO dao)
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
		
		
		String regionName = request.getParameter("regionName"); 
		String result = "사용할 수 있는 이름입니다.";
		
		System.out.println(regionName);
		
		for (Region region : dao.list())
		{
			//System.out.println(regionName);
			//System.out.println(region.getRegionName());
			if(region.getRegionName().equals(regionName))
			{
				result = "이미 사용중인 이름이 존재합니다.";
				break;
			}
			
		}
		
		mav.addObject("result",result);
		
		mav.setViewName("AjaxRegion");
		
		
		return mav;
	}

	
	
}
