/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
-문자열 관련 클래스
-캐릭터 셋(CharacterSet)
================================*/

/*
캐릭터 셋(CharacterSet)
	
	유니코드
	국제 표준으로 제정된 2바이트계의 만국 공통의 국제 문자부호 체계
	애플컴퓨터,IBM,마이크로소프트 등이 컨소시엄으로 설립한 유니코드
	
	데이터의 교환을 원활하게 하기위해서 문자 1개에 부여되는 값을 16비트로 통일
	코드의 1문자당 영어는 7비트, 비영어는 8비트.
	한글이나 일본어는 16비트의 값을 가진다.
	이들을 모두 16비트로 통일한것

	
	UTF-8 과 UTF-16
	둘의 차이는 : 문자를 표현할 때의 단위가 다르다는 것
	UTF-8 은 8비트 가변장 멀티바이트에서 문자를 표현하고.
	UTF-16은 16비트 가변장 멀티바이트에서 문자를 표현

	UTF-8(8bit UCS Transformation Format)
	 웹에서 기본적으로 사용하는 코드.
	 UCS-2로 정의되는 문자 집합을 이용하여 기술된 문자열을 바이트 열로 변환하는 방식의
	 1개 1문자를 1~6바이트 가변장 멀티바이트로 변환

	 UTF-16
	 자바의 기본 코드, 자바에서는 문자 하나를 저장하면 바이트 수는 모두 2바이트를 차지한다.
	 UCS-2로 정의되는 문자 집합을 이용하여 기술된 문자열에
	 UCS-4의 일부의 문자를 채워넣기 위한 인코딩 방식
	 UTF-8과 병용가능
	 UCS-2로 이용할 수 있는 문자 수를 대폭 늘릴 수 있다.

	 -자바에서는 UTF-16을 사용하고 웹에서는 UTF-8을 사용하기 때문에
	 경우에 따라 변환해야 하는 경우가 있음

	
	-문자 코드 종류
	
	KSC5601
	 한글 표준

	KSC5636
	 영문자표준
	 역슬래쉬\를 원표시로 바꾼것

	EUC-KR(MS949)
	유닉스에서 영문자 이외의 문자를 지원하기 위해 제안한 확장 유니코드중 한글 인코딩 방식
	영문은 KSC5636으로 한글은 KSC5601로 처리

	UTF-8
	영문과 숫자 1바이트, 한글은 3바이트로 표현,
	(웹에서 많이 사용, UTF-8 형식으로 JSP를 작성할 때에는 파일도 UTF-8 형식으로 저장해야 한다.

	UTF-16
	 자바 기본숫자 코드
	 영문과 숫자는 1바이트 한글은 2바이트  한글을 2개로 쪼개서 1바이트+1바이트 = 한글을 표현한것 그래서 한글이 깨지는것
	                                      8에서는 3개로 쪼개서 1바이트+1바이트+1바이트 로 한글을표현 그래서 인코딩이다르면 깨진당

	 ISO-8859 -1
	 서유럽 언어 표기에 필요한 아스키에 없는 94개 글자 순차적나열


		  코드화(인코딩)//쪼개기
	 현실 -------------->      컴퓨터
	데이터<------------       데이터(저장, 보관,전송,연산,처리...)
	 	  복원(디코딩)//합치기
	영상
	음악
	문자열                    1 or 0
	문자
	상수
	
	컴퓨터는 전부 나눠서 전송한다. 그것이 글자 하나일지라도  
								
	
	*/

import java.io.UnsupportedEncodingException;
public class Test141
{
	public static void main(String[] args)throws UnsupportedEncodingException
	{
		byte[] buf;
		String name = new String("최동현");

		System.out.println("디폴트 캐릭터셋 : " + System.getProperty("file.encoding"));
		//디폴트 캐릭터셋 파일의 인코딩 설정 MS949
		
		//String.getBytes()
		// : 디폴트 캐릭터셋으로 바이트 배열을 반환하는 메소드 즉 name에 들어있는 글자를 바이트단위로 쪼개서 바이트형 배열에 저장한다는뜻
		buf = name.getBytes();
		
		System.out.println("Length : "+buf.length); //6 한글자가 2개로 나눠졌다는뜻

		for(byte i : buf)
			System.out.println(i);
		/*-61
		-42
		-75
		-65
		-57
		-10
		*/
		
		//UTF-8캐릭터셋으로 바이트 배열을 전환
		buf = name.getBytes("utf-8");
		//예외발생 지원되지 않을수도 있는 인코딩방식이라 예외처리가 필요하다
		//해서 위에서 예외처리 UnsupportedEncodingException
		
		System.out.println("Length : "+buf.length);
		//Length : 9

		for(byte i : buf)
			System.out.println(i);
			/*-20
			-75
			-100
			-21
			-113
			-103
			-19
			-104
			-124
			*/
		//new String("최동현");
		//new String(바이트배열, 인코딩방식); //객체를 생성한것
		//new String (buf,"UTF-8"); //이렇게하면 바이트로 쪼개진 글자를 다시 글자형태로 합쳐준다.


		//utf-8 형태로 저장된 바이트 배열을
		//String 객체로 파라미터 값 utf-8을 부여하여 생성
		//즉 utf-8 기반으로 buf 바이트 배열을 합쳐
		//문자열 객체 생성한 후 이름 출력


		System.out.println("Value 1 : "+new String(buf,"utf-8"));
		//Value 1 : 최동현

		System.out.println();

		System.out.println("Value 2 : "+new String(buf));//디코딩방식을 안넣었으므로 디폴트 캐릭터셋으로 바이트형 배열을 합친다.
		//인코딩 방식 안맞으므로 당연히 이상하게 나옴

		System.out.println();

		String convert = new String(name.getBytes("euc-kr"),"utf-8"); //인코딩 방식과 디코딩 방식이 다르다.
		//6개로 쪼갯다가 9개로 합치니 당연히 제대로 안나옴

		buf = convert.getBytes();

		System.out.println("Length : "+buf.length);
		//Length : 5
		
		buf = convert.getBytes("utf-8");
		System.out.println("Length : "+buf.length);
		//Length : 14

		/*check
		
		euc-kr 을 utf-8로 변환하겠다는 의도로
		위와같이 코딩을 해버리면
		이러한 변환으로 인해 배열이 깨져서
		euc-kr 이든 utf-8이든 
		어떠한 바이트 배열로 읽어오든
		결과물이 깨져있는것을 확인할 수 있다.

		이미 깨져서 생성된 String 객체의 바이트 배열은
		어떤 방식으로든 복구가 불가능하다.
		*/
		


	}
}