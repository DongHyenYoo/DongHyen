/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
StringBuffer 클래스
================================*/

/*
StringBuffer클래스

	문자열을 처리하는 클래스로 String 클래스와의 차이점은
	String 클래스는 내부 문자열 데이터의 수정이 불가능하지만
	StringBuffer 클래스는 문자열을 사용할 때
	내부 문자열을 실행 단계에서 변경할 수 있다.

	즉,StringBuffer 객체는 가변적인 길이를 가지므로
	객체를 생성하는 시점에서 미리 그 크기나 값을 지정하거나
	실행 시점ㅇ에 버퍼의 크기를 바꿀수 있는 기능 제공

	또한JDK 1.5이후부터는
	문자열을 처리하는 StringBuilder 라는 클래스도 제공한다.
	StringBuilder클래스의 기능은 StirngBuffer 클래스와 동일하지만
	가장큰 차이점은 multi-thread unsafe라는 점이다.
	즉 Syncronization이 없기에
	StringBuffer보다 빠르면 동시성(동기화) 문제가 없다면
	StringBuilder를 사용하는 것이 성능을 향상시킬수 있다.
	
	thread : 작업들을 처리하는 단위 기능(행위) 


	기능은 StringBuffer가 많다.
	Stirng builder는 성능이 좋다.

	mutil-tread safty(동기화 기능이 포함됨)는 여러개의 기능이 돌아가도 안전하다 = 동시에 한 자원을 동시에 이용할수 있는것
	mutie-tread unsafe(동기화 기능이 포함되지 않음) 는 여러개의 기능이 돌아가도 안전하지 않다. = 한 자원을 누군가 쓰고나서야 다른 thread가 자원을 이용할 수 있음

*/

public class Test138
{
	public static void main(String[] args)
	{
		
		String str1 = new String("seoul");
		String str2 = new String("seoul");
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));//내용물의 크기비교하는 것이므로 true

		StringBuffer sb1 = new StringBuffer("korea");
		StringBuffer sb2 = new StringBuffer("korea");

		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2)); //false가 나옴
		//이말은 오브젝트의 equals와 결과가 같으므로 StringBuffer에서는 Object클래스의 equals메소드를 오버라이딩 하지 않은것

		System.out.println("-----------------------------");

		System.out.println(sb1); //출력된 것은 스트링형이긴한데  StringBuffer 형인것이다.
		
		System.out.println(sb1.toString()); //toString 메소드의 자료형은 바꿀수 없으므로 String형을 출력한것

		//System.out.println(b1.toString(). 이렇게하면 문자열 객체.~~~ 와 같으므로 String클래스의 메소드를 쓸수있다.
		
		System.out.println(sb1.toString().equals(sb2.toString())); //String버퍼는 이렇게 비교해야한다.


		System.out.println("-----------------------------");
		
		StringBuffer sb3 = new StringBuffer(); //기본적으로 스트링버퍼가 가지는 크기는 16이다.
		//StringBuffer 기본 생성자 호출(객체 생성과정)

		//capacity() 버퍼의 크기를 확인하는 메소드
		System.out.println(sb3.capacity()); // 기본값인 16

		System.out.println(sb3);
		//

		String name = "정미경";
		name += "한은영";
		name += "최동현";
		name += "임시연";

		System.out.println(name);
		
		sb3.append("seoul"); //StringBuffer에서의 문자열 추가하기
		sb3.append("korea");
		sb3.append("우리나라");
		sb3.append("대한민국");
		
		System.out.println(sb3);
		System.out.println(sb3.toString());


		System.out.println(sb3.capacity());//34로 늘었따. 즉 버퍼크기가 자동으로 증가.

		String temp1 = "java and oracle";
		System.out.println(temp1.toUpperCase()); //전부 대문자로 바꾸는것
		
		String temp2 = "JAVA AND ORACLE";
		System.out.println(temp2.toLowerCase());//전부 소문자로

		//System.out.println(sb3.toUpperCase()); StringBuffer에는 없다.
		//System.out.println(sb3.toLowerCase());
		
		String temp3 = sb3.toString(); //이렇게 버퍼에 있는걸 담을수있찌


		System.out.println(sb3.toString().toUpperCase());
		System.out.println(sb3.toString().toLowerCase());


		//대상 문자열(sb3) 중 seoul 앞에 "한국"이라는 문자열 추가
		
		sb3.insert(0,"한국"); //index(추가할 문자열 시작지점),"추가할 문자열"
		System.out.println("seoul 앞에 한국 추가 : "+sb3.toString());

		//대상 문자열(sb3)중 korea 문자열 뒤에
		//"사랑"이라는 문자열 추가 
		//단 대상 문자열의 인덱스를 눈으로 직접 확인하지 않고
		//
		
		System.out.println(sb3.indexOf("korea")); //스트링버퍼 클래스에 indexOf메소드가 존재한다.
		
		//System.out.println(sb3.insert(sb3.indexOf("korea")+5,"사랑"));
		System.out.println(sb3.insert(sb3.indexOf("korea")+"korea".length(),"사랑"));
		//System.out.println(sb3.insert(sb3.lastIndexOf("korea"),"사랑"));
		
		//System.out.println(sb3.toString().lastIndexOf("korea"));
		
		
		//sb3.insert(7,"사랑");
		//System.out.println(sb3.toString());


		//sb3에서 우리나라 문자열을 삭제해라

		//System.out.println(sb3.toString().replaceAll("우리나라",""));
		
		//delete 삭제
		//sb3.delete(14,18);
		//System.out.println(sb3);
		

		sb3.delete(sb3.indexOf("우리나라"),sb3.indexOf("우리나라")+"우리나라".length());
		System.out.println(sb3);

		//sb3에서 korea이후의 문자열 삭제

		sb3.delete(sb3.indexOf("korea"),sb3.length());
		System.out.println(sb3);
	

		///////////////////////
		
		System.out.println(sb3.capacity()); //버퍼크기 여전히 34 
		//버퍼가 필요에의해 늘어나는것은 자동이나 줄여주는것은 자동이 아니다.

		System.out.println("문자열길이 :"+sb3.length());
		//7

		//버퍼크기조절
		//현재 문자열을 담을수 있는 버퍼의 크기로 조정
		//trimToSize()
		sb3.trimToSize();
		System.out.println(sb3.capacity()); //버퍼의 크기 7로 조정됨



	}
}