package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmployeeUpdateFormController implements Controller
{
	
	//EmployeeInsertFormCotroller와는 다른 방식으로 처리한다
	//비교해야...
	
	private IEmployeeDAO employeeDAO;
	private IPositionDAO positionDAO;
	private IRegionDAO regionDAO;
	private IDepartmentDAO departmentDAO;

	public void setEmployeeDAO(IEmployeeDAO employeeDAO)
	{
		this.employeeDAO = employeeDAO;
	}



	public void setPositionDAO(IPositionDAO positionDAO)
	{
		this.positionDAO = positionDAO;
	}



	public void setRegionDAO(IRegionDAO regionDAO)
	{
		this.regionDAO = regionDAO;
	}



	public void setDepartmentDAO(IDepartmentDAO departmentDAO)
	{
		this.departmentDAO = departmentDAO;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
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
		
		
		
		String employeeId = request.getParameter("employeeId");
		
		
		
		try
		{
			
			Employee employee = employeeDAO.searchId(employeeId);
			
			ArrayList<Position> positionList = positionDAO.list();
			
			ArrayList<Department> departmentList = departmentDAO.list();
			
			ArrayList<Region> regionList = regionDAO.list();
			
			mav.addObject("positionList", positionList);
			
			mav.addObject("departmentList", departmentList);
			
			mav.addObject("regionList", regionList);
			
			mav.addObject("employee", employee);
			
			
			//mav.setViewName("/WEB-INF/view/EmployeeUpdateForm.jsp");
			mav.setViewName("EmployeeUpdateForm");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		return mav;
		
	
	}
	
	
	
	
}
