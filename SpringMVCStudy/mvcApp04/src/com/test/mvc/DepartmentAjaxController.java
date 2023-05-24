/*=================================
#49. DepartmentAjaxController.java
	- 사용자 정의 컨트롤러 클래스
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class DepartmentAjaxController implements Controller
{
	private IDepartmentDAO dao;
	
	
	//Controller 인페이스의 handleRequest()메소드 재정의

	public void setDao(IDepartmentDAO dao)
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
		
		String departmentName = request.getParameter("departmentName");
		String result ="사용가능한 부서명";
		for (Department department : dao.list())
		{
			
			if(department.getDepartmentName().equals(departmentName))
			{
				result="이미 해당부서는 존재합니다.";
				break;
			}
		}
		
		mav.addObject("result",result);
		
		mav.setViewName("DepartmentAjax");
		
		return mav;
	}

	
	
}
