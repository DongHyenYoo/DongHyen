package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test06 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	/* 사용자 요청이 GET 방식인 경우 Servlet Contatiner에 의해 자동으로 호출되는 메소드 */
		
		doGetPost(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*사용자 요청이 POST 방식인 경우 Servlet Contatiner에 의해 자동으로 호출되는 메소드*/
		doGetPost(request, response);
		
	}
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*사용자 요청이 GET or POST 방식인 경우 Servlet Contatiner에 의해 자동으로 호출되게 구성한 사용자 정의 메소드 */
		
		//이전페이지 AjaxTest06.jsp에서 넘겨받은 Data
		// 검색어 str
		
		//한국어
		request.setCharacterEncoding("UTF-8");
		
		//검색어 받아오기
		//사용자가 타이핑중에 전송한 데이터(완성형 단어) 수신
		String searchWord = request.getParameter("str");
		
	      //DB연결 및 액션 처리
	      //--------where column like 'search%'; 와 같은 쿼리문 수행
	      //--------where column like '%search%'; 와 같은 쿼리문 수행
	      //→ 그에 따른 결과 수신

		
		ArrayList<RecommendDTO> list = new ArrayList<RecommendDTO>();
		
		
		if(searchWord.equals("가"))
		{
			list.add(new RecommendDTO("가지"));
			list.add(new RecommendDTO("가위"));
			list.add(new RecommendDTO("가방"));
			list.add(new RecommendDTO("가방끈"));
			list.add(new RecommendDTO("가방끈 매듭"));
			list.add(new RecommendDTO("가방끈 매듭 만드는법"));
			list.add(new RecommendDTO("가방끈 매듭 풀기"));
		}
		else if(searchWord.equals("가사"))
		{
			list.add(new RecommendDTO("가사"));
			list.add(new RecommendDTO("가사 듣기"));
			list.add(new RecommendDTO("가사 말하기"));
		}
		
		
		if(searchWord.equals("윈터"))
		{
			list.add(new RecommendDTO("윈터"));
			list.add(new RecommendDTO("윈터 단발"));
			list.add(new RecommendDTO("윈터 직캠"));
			list.add(new RecommendDTO("윈터 실물"));
			list.add(new RecommendDTO("윈터 도깨비불"));
			
		}
		
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Test06Ok.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
}
