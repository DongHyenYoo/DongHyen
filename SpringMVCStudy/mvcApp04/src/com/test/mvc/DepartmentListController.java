//#45. DepartmentListController.java

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DepartmentListController  implements Controller
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
		
		if(session.getAttribute("name")==null) //로그인이 되어있지 않은 상황
		{
			//로그인이 되어있지 않은 상황에서의 처리
			//-- 로그인 폼 페이지를 다시 요청할 수 있도록 안내
			mav.setViewName("redirect:loginform.action");
			return mav;
			
		}
		else if(session.getAttribute("admin")==null) //로그인은 되어있으나 관리자가 아님
		{
			//관리자가 아닌상황 즉, 일반 사원일 때의 처리
			//-- 현재의 일반회원으로써의 로그인(세션)을 해제하고 
			// 다시 관리자로 로그인 할 수있도록 처리
			mav.setViewName("redirect:logout.action");
			return mav;
		}
		
		ArrayList<Department> departmentList = new ArrayList<Department>();
		
		try
		{
			departmentList = dao.list();
			
			mav.addObject("departmentList",departmentList);
			
			mav.setViewName("DepartmentList");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		
		
		
		return mav;
	}

	
	
}
