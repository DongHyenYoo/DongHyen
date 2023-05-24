/*=================================
	#27. EmployeeDeleteController.java
	- 사용자 정의 컨트롤러 클래스
	- 직원 데이터 삭제 액션 수행 및 해당 액션 처리 이후
	employeedelete.action 요청하게
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class EmployeeDeleteController implements Controller
{
	private IEmployeeDAO dao;
	//Controller 인페이스의 handleRequest()메소드 재정의
	public void setDao(IEmployeeDAO dao)
	{
		this.dao = dao;
	}

	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		//하는 일은 doGet , doPost 와 같다.
		
		//컨트롤러 내부 액션 처리 코드
		
		
		ModelAndView mav = new ModelAndView();
		
		//이전 페이지(EmployeeList.jsp)로부터 데이터 수신
		//-- employeeId
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
		
		
		
		String employeeId = request.getParameter("employeeId");
		
		try
		{
			dao.remove(employeeId);
			
			mav.setViewName("redirect:employeelist.action");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		return mav;
	}


	
	
	
}
