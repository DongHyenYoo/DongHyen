/*=================================
   40#RegionInsertController.java
   - 사용자 정의 컨트롤러 클래스
   - 지역 데이터 입력 액션 수행 및 해당 액션 처리 이후
     『regionlist.action』을 다시 요청할 수 있도록 처리
   - DAO 객체에 대한 의존성 주입(DI)을 위한 준비
      → 인터페이스 자료형 구조
      → setter 메소드 정의
==================================*/
package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegionInsertController implements Controller
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
		
		if(session.getAttribute("name")==null)
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		else if(session.getAttribute("admin")==null)
		{
			mav.setViewName("redirect:logout.action");
			return mav;
		}
		
		
		String regionName = request.getParameter("regionName");
		
		
		
		try
		{
			
			Region region = new Region();
			
			region.setRegionName(regionName);
			
			dao.add(region);
			
			mav.setViewName("redirect: regionlist.action");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		return mav;
	}

	
	
}
