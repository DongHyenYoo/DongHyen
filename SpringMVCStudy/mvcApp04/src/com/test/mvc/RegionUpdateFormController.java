/*
 #41. RegionUpdateFormController.java
 */

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegionUpdateFormController implements Controller
{
	private IRegionDAO dao;
	
	public void setDao(IRegionDAO dao)
	{
		this.dao = dao;
	}
	//필요한 의존객체 regionDAO
	
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
		
		//얻어온 데이터 regionId
		
		String regionId = request.getParameter("regionId");
		Region region = null;
		try
		{
			region = dao.serarchId(regionId);
			
			mav.addObject("region", region);
			mav.setViewName("RegionUpdateForm");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		return mav;
	}

	
	

}
