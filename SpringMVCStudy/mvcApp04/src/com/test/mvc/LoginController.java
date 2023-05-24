/*=================================
	#30.LoginController.java
	- 사용자 정의 컨트롤러 클래스
	- 로그인 액션 처리 전용 클래스.
	- 로그인 액션 처리 이후
	employeelist.action / emplist.action
	을 요청할수있도록
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class LoginController implements Controller
{
	//Controller 인페이스의 handleRequest()메소드 재정의
	
	private IEmployeeDAO dao;
	
	

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
		
		// 이전 페이지(LoginForm.jsp)로부터 데이터 수신
		// -- id,pw, admin
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String admin = request.getParameter("admin");
		//String name = "";  //(Ⅹ) 이렇게 초기화하면 안됨
		String name = null;
		
		try
		{
			//로그인 처리 → 대상에 따른 로그인 처리 방식 구분(분기)
			if(admin==null)
			{
				//일반 사원 로그인
				name = dao.login(id, pw);
			}
			else
			{
				//관리자 로그인
				name = dao.loginAdmin(id, pw);
			}
			
			
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		//로그인 성공 여부에 따른 분기(구분)
		
		if(name==null)
		{
			//로그인 실패 → 로그인 폼을 다시 요청할 수 있도록 안내
			mav.setViewName("redirect:loginform.action");
		}
		else
		{
			//로그인 성공 →세션 구성
			//--로그인 형태(일반사원, 관리자)에 따라 분기
			
			HttpSession session =  request.getSession();
			session.setAttribute("name", name);
			
			if(admin==null) //로그인은했는데 일반사원으로 로그인한사람
			{
				// emplist.action 페이지를 요청할 수 있도록 안내
				mav.setViewName("redirect:emplist.action");
				
			}
			else //관리자로 로그인 성공한 상황
			{
				
				//admin 속성을 세션에 추가
				session.setAttribute("admin", "");
				//employeelist.action 페이지를 요청할 수 있도록 안내
				mav.setViewName("redirect: employeelist.action");
				
				
			}
			
			
		}
		
		return mav;
	}

	
	
}
