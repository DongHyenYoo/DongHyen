/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
String 클래스
================================*/


public class Test137
{
	public static void main(String[] args)
	{
		String s = "seoul korea";
		System.out.println("s : "+s);
		//s : seoul korea

		//문자열 추출

		System.out.println(s.substring(6,9)); //결과 kor

		//String.substring(s,e)
		//String 문자열을 대상으로
		//s번째에서 e-1번째 까지 추출
		// 단 (인덱스는 0 부터 시작)
		
		System.out.println(s.substring(7));


		//String.substring(s)
		//String 문자열을 대상으로
		//s번째에서 끝까지 추출
		//즉 문자열이 가진 길이만큼..

		//문자열의 데이터 (값) 비교

		System.out.println(s.equals("seoul korea"));
		System.out.println(s.equals("seoul Korea"));
		//true
		//false
		//대소문자 구분..

		System.out.println(s.equalsIgnoreCase("SEOUL KOREA"));
		//true 이 메소드는 string에서 정의한 메소드로 대소문자를 구분하지 않는것
		

		//찾고자 하는 대상 문자열(s)에
		// kor 문자열이 존재할까??
		//존재한다면 어느 위치에 존재하는지?
		
		System.out.println(s.indexOf("kor"));
		//6 => 6번위치에 존재한다.

		System.out.println(s.indexOf("ea"));
		//9 
		
		System.out.println(s.indexOf("e"));
		//e는 두곳에 있는데 앞에서부터 찾고 제일 먼저찾은곳만 알려주고 끝냄

		System.out.println(s.indexOf("z"));
		//찾고자 하는게 없다면 음수를 반환한다.
	    

		//대상 문자열이 rea로 끝나는지의 여부 확인
		//true false 반환 
		System.out.println(s.endsWith("rea"));
		//rea 로 끝나므로 true
		System.out.println(s.endsWith("oul"));
		//false



		//찾고자 하는 대상 문자열에
		// e 문자열이 존재할까?
		// 존재한다면 그 위치는 어떻게되는가?
		//indexOf 는 앞에서부터 찾고 찾으면 끝났다. 이건 뒤에서 부터 검사
		
		System.out.println(s.indexOf("s"));
		System.out.println(s.indexOf("o"));

		System.out.println(s.lastIndexOf("e"));
		//9
		System.out.println(s.lastIndexOf("o"));
		//7

		//대상 문자열(s) 중
		// 6번째 인덱스 위치의 문자는?

		System.out.println(s.charAt(6));
		//k 
		//System.out.println(s.charAt(22));
		//런타임 에러 발생 java.lang.StringIndexOutOfBoundsException: String index out of range: 22
		//


		//대상 문자열s와 비교하는 문자열 seoul corea중 어떤 문자열이 더 큰가? 
		//문자열에 대한 크기 비교
		//크기 같다 = 0
		//크기 다름 = 차이를 확인한다.

		System.out.println(s.compareTo("seoul korea"));
		//0 =두 문자열이 같다. (s와 "seoul korea"가 같다.)
		System.out.println(s.compareTo("seoul uorea"));
		//8차이가 나고 이건 k~c의 알파벳 차이? 를 반환

		
		//대상 문자열s 중
		// 해당 문자열을 찾아서 원하는 형태로 수정된 문자열을 반환해주는것

		s = "우리나라 대한민국 대한독립 만세";
		//s.replaceAll() 이거한다고 문자열객체의 내용을 바꾸는것이 아니다.

		s = s.replaceAll("대한", "자주"); //대한을 찾아 자주라는 문자로 바꿔라 그리고 그걸 문자열에 담아라
		System.out.println(s);

		//공백 제거

		s = "          사          랑           ";
		System.out.println("|"+s+"|");

		System.out.println("|"+s.trim()+"|"); //양쪽 가장자리의 공백 제거
		//양쪽 가장자리 공백 제거

		System.out.println("|"+s.replaceAll(" ","")+"|");
		//모든 공백을 ""로 대체

		int temp = Integer.parseInt("50");

		s = Integer.toString(30);
		System.out.printf("%s\n",s); //이건 오버라이드가 아니라 오버로딩 object의 string 을 오버로딩한것. 오브젝트의 toString은 매개변수가 없었다. 그리고 기능이 있었다. 추상 메소드가앙니었음
		//=>30

		int n = 2345678;
		System.out.println(n);
		System.out.format("%d\n",n);
		//printf와 기능이 같은 format

		s = String.format("%d",n); //문자열을 반환하는 친구
		System.out.println(s);

		s= String.format("%,d",n); //d앞에 ,를 쓰면 돈계산하는 것처럼 3자리마다 ,를 찍어준다.
		System.out.println(s);
		
		//String str ="기본,열정,배열";
		//String[] strArr = str.split(",");

		String[] strArr = "기본,열정,배열".split(",");
		//위는 그자체가 문자열이고 문자열 객체이다 즉 String의 기능을 쓸수있다.
		//142 143과 같은 구문이다.

		for(String i : strArr)
			System.out.println(i);
		//기본 열정 배려




	}
}