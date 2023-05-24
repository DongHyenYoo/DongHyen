/*=================================
	#19EmployeeInsertFormController.java
	- 사용자 정의 컨트롤러 클래스
	- 직원 데이터 입력폼 요청에 대한 액션 처리
	- DAO 객체에 대한 의존성 주입(DI)을 위한 준비
	   →DB에 접근해 직위,지역목록을 가져와야...
	   → 인터페이스 자료형 속성 구성.
	   → setter 메소드 정의
==================================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmployeeInsertFormController implements Controller
{
	
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
		
		
		ArrayList<Region> regionList = new ArrayList<Region>();
		ArrayList<Department> departmentList = new ArrayList<Department>();
		ArrayList<Position> positionList = new ArrayList<Position>();
		
		try
		{
			regionList = dao.regionList();
			
			departmentList = dao.departmentList();
			
			positionList = dao.positionList();
			
			mav.addObject("regionList", regionList);
			mav.addObject("departmentList", departmentList);
			mav.addObject("positionList", positionList);
			
			//mav.setViewName("/WEB-INF/view/EmployeeInsertForm.jsp"); //view안에 넣으면 확인이 불가능하므로 일단은 이렇게
			mav.setViewName("EmployeeInsertForm");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		
		return mav;
	}

	
	
}
