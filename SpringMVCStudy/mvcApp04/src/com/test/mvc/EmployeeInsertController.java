/*=================================
	#23. EmployeeInsertController.java
	- 사용자 정의 컨트롤러 클래스
	- 직원 데이터 입력 액션 수행 및 해당 액션 처리 이후
	『employeelist.action』을 요청할 수 있도록 안내
	- DAO 객체에 대한 의존성 주입(DI)을 위한 준비.
	→인터페이스 자료형
	→setter 메소드 정의
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.


public class EmployeeInsertController implements Controller
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
		
		
		
		Employee employee = new Employee();
		
		employee.setName(request.getParameter("name"));
		employee.setSsn1(request.getParameter("ssn1"));
		employee.setSsn2(request.getParameter("ssn2"));
		employee.setBirthday(request.getParameter("birthday"));
		employee.setLunar(Integer.parseInt(request.getParameter("lunar")));
		employee.setTelephone(request.getParameter("telephone"));
		employee.setRegionId(request.getParameter("regionId"));
		employee.setDepartmentId(request.getParameter("departmentId"));
		employee.setPositionId(request.getParameter("positionId"));
        employee.setBasicPay(Integer.parseInt(request.getParameter("basicPay")));
        employee.setExtraPay(Integer.parseInt(request.getParameter("extraPay")));
		
		int result = dao.employeeAdd(employee);
		
	

		// check~!!!
		//mav.setViewName("EmployeeList.jsp");
		// 내가 추가해줄테니까 넌 돌아가서 리스트 봐~ 라고 할껀데
		// 위에처럼 view 호출해주면 안된다.
		// 이건 뭐를 가지고 클라이언트 만나는 게 아님
		
		// '내가 갱신했으니까, 클라이언트한테 다시 요청하라고 해' 라고 해야함
		mav.setViewName("redirect:employeelist.action");
		
		return mav;
	}

	
	
}
