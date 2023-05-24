package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test05 extends HttpServlet
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
		//--addr
		
		//한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		
		//동 이름 넘어온 데이터 수신
		String addr = request.getParameter("addr");
		
		//※여기서도 역시 우편번호 데이터베이스가 존재한다고 가정하고...
		//  대신 직접 자료구조 구성
		
		ArrayList<ZipCodeDTO> list = new ArrayList<ZipCodeDTO>();
		
		if(addr.indexOf("서교")> -1)
		{
			list.add(new ZipCodeDTO("04044", "서울특별시 마포구 독막로3길 13 (서교동)"));
			list.add(new ZipCodeDTO("04044", "서울특별시 마포구 독막로3길 17 (서교동)"));
			list.add(new ZipCodeDTO("04047", "서울특별시 마포구 독막로3길 18 (서교동)"));
			list.add(new ZipCodeDTO("04047", "서울특별시 마포구 독막로3길 20 (서교동)"));
			list.add(new ZipCodeDTO("04044", "서울특별시 마포구 독막로3길 21 (서교동)"));
			list.add(new ZipCodeDTO("04044", "서울특별시 마포구 독막로3길 21-3 (서교동)"));
			list.add(new ZipCodeDTO("04044", "서울특별시 마포구 독막로3길 21-4 (서교동)"));
			list.add(new ZipCodeDTO("04044", "서울특별시 마포구 독막로3길 21-6 (서교동)"));
			list.add(new ZipCodeDTO("04044", "서울특별시 마포구 독막로3길 23 (서교동)"));
			list.add(new ZipCodeDTO("04047", "서울특별시 마포구 독막로3길 24 (서교동)"));
		
		}
		else if(addr.indexOf("신사")> -1)
		{
			list.add(new ZipCodeDTO("03442", "서울특별시 은평구 가좌로 269 (신사동)"));
			list.add(new ZipCodeDTO("03442", "서울특별시 은평구 가좌로 271 (신사동)"));
			list.add(new ZipCodeDTO("03452", "서울특별시 은평구 가좌로 272 (신사동)"));
			list.add(new ZipCodeDTO("03452", "서울특별시 은평구 가좌로 274 (신사동)"));
			list.add(new ZipCodeDTO("03442", "서울특별시 은평구 가좌로 275 (신사동)"));
			list.add(new ZipCodeDTO("03442", "서울특별시 은평구 가좌로 275-1 (신사동)"));
			list.add(new ZipCodeDTO("03442", "서울특별시 은평구 가좌로 275-2 (신사동)"));
			list.add(new ZipCodeDTO("03442", "서울특별시 은평구 가좌로 275-3 (신사동)"));
			list.add(new ZipCodeDTO("03442", "서울특별시 은평구 가좌로 275-5 (신사동)"));
			list.add(new ZipCodeDTO("03442", "서울특별시 은평구 가좌로 275-9 (신사동)"));
		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Test05Ok.jsp");
		dispatcher.forward(request, response);
		
		//jsp가 클라이언트에게 직접 전달되는것이 아니라
		// 일종의 작업 지시(서블릿 컨테이너) -> xxx.html(서블릿 컨테이너에게 html을 그리라는 작업지시)
		
		//이제는 Test05Ok.jsp 에게 작업지시를 내림 -> xxx.xml을 그리라고 지시
		
	}
	
}
