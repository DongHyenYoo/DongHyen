package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AjaxssnController implements Controller
{
	
	private IEmployeeDAO dao;
	
	
	

	public void setDao(IEmployeeDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		String ssn2 = request.getParameter("ssn2");
		String employeeId = request.getParameter("employeeId");
		String result ="";
		
		
		ModelAndView mav = new ModelAndView();
		
		
		//폼을 막았다 해도 에이젝스에 값을 넘겨 쓸수있다. 그러니 
		
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
		
		
		try
		{
			result = dao.searchSSN(ssn2, employeeId);
			
			mav.addObject("ssn2", result);
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		mav.setViewName("Ajaxssn");
		
		return mav;
	}
	
	

}
