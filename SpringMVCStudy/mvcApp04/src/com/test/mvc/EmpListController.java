/*=================================
	EmpListController.java
	- 사용자 정의 컨트롤러 클래스
	- 리스트 페이지 요청에 대한 액션 처리.(일반직워)
	- DAO 객체에 대한 의존성 주입(DI)를 위한 준비.
	 → 인터페이스 자료형 구성
	 → setter 정의
==================================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class EmpListController implements Controller
{
	
	private IEmployeeDAO dao;
	
	private int mad;
	
	
	
	
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
		
		//로그인한 인원만 empList.jsp에 접근할 수 있도록
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name")==null) //로그인 되어있지 않을때
		{
			mav.setViewName("redirect: loginform.action");
			return mav;
		}
		
		
		//일반직원 리스트 가져오려면 dao
		
		try
		{
			ArrayList<Employee> empList = dao.empList();
			
			mav.addObject("employeeList",empList);
			
			mav.setViewName("EmpList");
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		
		return mav;
	}

	
	
}
