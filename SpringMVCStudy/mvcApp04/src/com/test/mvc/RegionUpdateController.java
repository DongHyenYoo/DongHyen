/*
#43. RegionUpdateController.java
 */
package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import sun.reflect.generics.visitor.Reifier;

public class RegionUpdateController implements Controller
{
	private IRegionDAO dao;
	
	
	
	public void setDao(IRegionDAO dao)
	{
		this.dao = dao;
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

		
		Region region = new Region();
		String regionId = request.getParameter("regionId");
		String regionName = request.getParameter("regionName");
		
		region.setRegionId(regionId);
		region.setRegionName(regionName);
		
		dao.modify(region);
		
		mav.setViewName("redirect: regionlist.action");
		
		return mav;
	}
	
	
	

}
