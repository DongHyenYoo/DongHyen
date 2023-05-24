/*
 * MVC에서 Model 역할을 수행할 클래스 
 * 비즈니스 로직과 관련된 부분만 처리
     데이터베이스 관련 로직 구현
 */

package com.test.svt;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVCTest02Model
{
	public String actionCount(HttpServletRequest request, HttpServletResponse response)
	{
		
		String result = "";
		
		//1부터 100까지의 수를 객체(컬렉션)에 저장하는 과정
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 1; i <= 100; i++)
		{
			list.add(String.valueOf(i));
			
		}
		
		request.setAttribute("list", list);
		
		result = "WEB-INF/view/MVCTest02.jsp";
	      
	    return result;
				
				
		
	}
	

}
