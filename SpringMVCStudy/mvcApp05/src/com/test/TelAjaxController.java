package com.test;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TelAjaxController implements Controller
{
	private IMemberDAO dao;

	
	
	public void setDao(IMemberDAO dao)
	{
		this.dao = dao;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		ModelAndView mav = new ModelAndView();
		
		String tel = request.getParameter("tel");
		String result = "사용 가능한 전화번호입니다.";
		for(Member member : dao.list())
		{
			
			if(member.getTel().equals(tel))
			{
				result="이미 등록된 전화번호입니다. 아이디/비밀번호 찾기를 이용해주세요";
				break;
			}
			
		}
		
		mav.addObject("result", result);
		mav.setViewName("TelAjax");
		
		return mav;
		
		
		
	}
	
	

}
