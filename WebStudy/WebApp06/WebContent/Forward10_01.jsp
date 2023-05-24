<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	

	//연산페이지
	int firstNum = Integer.parseInt(request.getParameter("firstNum"));
	int secNum = Integer.parseInt(request.getParameter("secondNum"));
	String result = "";
	String vSign = request.getParameter("sign");
	
	
	switch(vSign)
	{
	case "*" : result = String.format("%d * %d = %d\n",firstNum,secNum,(firstNum*secNum));  break;
	case "/" : result = String.format("%d / %d = %.1f\n",firstNum,secNum,(firstNum/(double)secNum));  break;
	case "+" : result = String.format("%d + %d = %d\n",firstNum,secNum,(firstNum+secNum));  break;
	case "-" : result = String.format("%d - %d = %d\n",firstNum,secNum,(firstNum-secNum));  break;
	default : break;
	}
	
	request.setAttribute("result", result);
	
	//jsp의 forward를 대체하는것
	RequestDispatcher dispatcher = request.getRequestDispatcher("Receive10.jsp");
	dispatcher.forward(request, response);
	

	/*--------------------------------------------------------------------------------
	   ■■■ 『RequestDispatcher』 인터페이스 ■■■
	   
	   ※ 이 인터페이스는 『forward()』와 『include()』만 있다.
	   
	   ※ 처리 과정 및 개념
	   
	      일반적으로 HttpServlet 을 상속받는 클래스... 서블릿
	      
	      이렇게 작성된 클래스 내부에는
	      실제 요청을 서비스하는 『doGet()』과 『doPost()』 메소드가
	      정의되어 있으며 (service() 메소드가 상위 메소드)
	      
	      서블릿컽테이너는 init()메소드를 통해  비행기 조종사의 준비과정처럼 동작할 준비를한다.
	      즉 리소스를 점검한다.
	      클라이언트의 요청이 들어왔을때 service()를 호출하게된다.
	      
	      서블릿컨테이너는 하나고 서블릿은 여러개다 (web.xml에 등록하게되는것 처럼)
	      
	      ServletContainer(WebContainer=ServletContainer+html)는 『HttpServlet』의 인스턴스를 생성하고
	      『init()』 메소드를 실행해 주고
	      이 메소드에 의해 매핑된 URL에 (페이지 요청 방식에 따라)
	      doGet() 과 doPost() 중 메소드를 호출해 주고(실행시켜 주고),
	      container가 종료될 때 『destroy()』 메소드를 호출해 주고 관련된 처리 과정이 마무리 된다
	      
	      즉 ServletContainer 가
	      init() → 처음
	      service() → 중간중간 요청이 있을 때마다
	      destroy() → 마지막  -> 리소스 반납
	      메소드를 호출한다.
	      (절대 우리가 직접 호출하는 것이 아님)
	      
	      결국 『HttpServlet』은
	      하나의 인스턴스만 생성되어 멀티 스레딩으로 돌아가게 된다
	      하나로만 돌아가면 한명 실행 -> destroy 가 되면서 꺼버릴수있으므로 
	      
	      이렇게 구성되는 『HttpServlet』의 상속된 클래스의 인스턴스는
	      스레드에 안전하게 설계(스레드 세이프티)되어야 하고
	      
	      private static final long serialVersionUID = 1L; 이 구문
	      
	      따라서 스레드에 안전하게 설계하지 않은 경우
	      상위 클래스를 마구 접근하게 되어 에러가 발생할 수 밖에 없다
	      즉 6개의 요청을 하나의 프로그램이 처리하는데 1개의 요청이 끝나서 리소스를 반납할때
	      프로그램을 끝내버리면 다른 요청들이 프로그램을 사용할수 없게되는 에러가 발생한다는뜻
	      
	      요청당 하나의 프로그램이 돌아가는 구조가 cgi구조 //좋은 구조가 아님
	      
	      이와 같은 이유로 환경 설정이나 J2EE 서비스에 관한 내용은
	      『ServletContext』에서 할 수 있게 된다 -> 서비스를 처리하는 환경을 처리하는것 즉 요청은 여러개고 얘는 하나기에 멀티 스레드 세이프티하게 만들어졌을것
	      (※ ServletContext
	            : 서블릿에 대한 환경, 상태 등을 설정할 수 있는 객체)
	      이 『ServletContext』는 『getServletContext』로만 받을 수 있다
	      그렇기 때문에 이 『getServletContext』는
	      동기화가 제대로 구현되어 있을 것이라고 예측할 수 있다
	      그 이유는 멀티 스레드에 안전하게 설계(세이프티)되어 있어야
	      우리가 『ServletContext』의 『setAttribute()』나
	      『getAttribut()』를 스레드 걱정 없이 마음대로 읽고 쓸 수 있기 때문이다.
	      
	      『ServeletContext』의 또 다른 커다란 기능 중 하나는
	      다른 서블릿 인스턴스를 가져올 수 있다거나
	      서블릿 환경 설정값을 가져올 수 있는 기능이다.
	      
	      즉 요청은 여러개이므로 서블릿콘텍스트가 전부 처리할수 없으므로 하수인인
	      얘를 보내서 요청을 보내게한다.
	      『RequestDispatcher』역시 그 기능 중의 하나이다
	      사전적인 의미로는... 요청을 제공하는 도구
	      즉, 요청을 보내주는 인터페이스이다.
	      
	      jsp로 만들어놨던 java로 서블릿을 만들어놨던 결국 사용자에게 최종내용을 전송하려면
	      서블릿이어야 한다. 즉 모든 jsp는 서블릿이다.
	      현재.. 요청을 다른 서블릿(혹은 JSP)으로 보내야 하는 상황
	      그런데 위에 언급한 바와 같이 서블릿의 인스턴스는 하나만 생성되고 이것이 멀티스레딩으로 돌아가고 있다.
	      
	      그렇기 때문에 새로운 서블릿을
	      그 서블릿을 실행하는 것 만으로는 안되고
	      이미 돌아가고 있는 서블릿 인스턴스의 스레드를 하나 더 추가해야 한다.
	      즉 서블릿은 하나고 요청(request,response 두개가 합쳐진 객체가 돌아다니는것)은 여러개이므로 그것에 대한 스레드를 추가해야한다.
	      그리고 이것은 서블릿 개발자가 처리해야 할 영역을 벗어났기 때문에
	      이 일은 『Dispatcher』가 대신 수행해 준다는 것이다.
	      
	      하지만, 이 『Dispatcher』 는
	      『HttpServletRequest』, 『HttpServletResponse』를 생성해 줄 수는 없다 -> 허위 보고를 막기위해 권한 제약
	      그러기 때문에 『Dispatcher』가 생성해준 새로운 서블릿 스레드를 실행시키기 위해
	      『doGet()』이나 『doPost()』를 호출해야 한다.
	      
	      이와 같은 이유로 새로 request,response를 새로만들지 않고 요청사항과, 응답해야할 내용을 담아 
	      request,response는 우리가 만들었던 서블릿에서 doGet() doPost에서 넘긴 것들이다.
	      
	      서블릿 컨텍스트(서블릿컨테이너의 환경과 상태를 담당함)로 전달함 그래서 이 request,response가 서블릿컨테이너로
	      전달될 수있는것
	      『dispatcher.forward(request, response);』구문을 통해
	      request와 response를 넘겨주는 것이다.
	      
	   -------------------------------------------------------------------------------- */
	
	
%>
