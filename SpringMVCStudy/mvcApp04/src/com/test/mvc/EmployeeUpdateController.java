package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmployeeUpdateController implements Controller
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
		
		employee.setEmployeeId(request.getParameter("employeeId"));
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
		
        
		try
		{
			int result = dao.modify(employee);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
        
		
		
		mav.setViewName("redirect:employeelist.action");
		
		
		
		return mav;
	}

	

}
