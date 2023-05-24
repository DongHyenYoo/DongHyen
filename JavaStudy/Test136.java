/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
String 클래스
================================*/

/*
  String 클래스는 내부 문자열 데이터에 대한 수정이 불가능하다. 즉 처음에 String name="이순신" -> name ="유동현" 한다고해서 이순신의 데이터가 사라지는것이 아니라 유동현을 담을 새로운 메모리에 유동현을 저장하고 name이 연결해주는 
  (즉, 내용 불변 : Immutable)                                               주소를 "이순신"쪽을 끊어내고 참조변수가 가르키는 메모리주소를 "유동현"쪽으로 바꾼다.
  문자열의 내용이 변경되면 새로운 객체를 생성하며
  참조 대상을 잃어버린 객체는 가비지 컬렉션의 대상이 되고,
  새로운 객체에 새 주소를 할당하게 되므로
  해시코드도 변하게 된다.

  String 클래스 간에 + 연산자를 사용하게 되면
  문자열 간의 결합이 가능하며
  String 클래스와 다른 클래스 객체, 또는 기본형 데이터 간에
  +연산자를 사용하는 경우에도
  내부적으로 자동 String 클래스로 변환이 가능하다.

  눈으로(시각적으로) 확인되는 결과는 이렇지만...
  String은 내용을 변경할 수 없기 때문에
  +연산자를 사용하게 되면 내부적으로 StringBuffer를 생성하여    //Buffer란 임시 웅덩이과같고여기에 data를 채우고 다차면 데이터를 흘려보내고 다시 데이터를 채우고 다차면 흘녀보낸다.(웅덩이에 물이 차는듯한 것을 Buffering라고한다.)
  append() 메소드를 이용하여 문자열에 대한 결합을 수행하게 된다. //StringBuffer란 String에 버퍼가 달려있는것
  따라서 동적인 문자열을 많이 사용하는 Servlet 등에서는
  되도록이면 String 을 사용하는 것 보다
  StringBuffer나 char[]을 사용하는 것이 효율적일 수 있다.
  ==>정적인 문자열을 처리하는 경우에는 주로 String 클래스를 사용
     동적인 문자열을 처리하는 경우에는
	  런 타임 시 동적으로 처리해주는 StringBuffer 클래스를
	   사용하는 것이 효율적이다.

  String 객체의 생성 및 특징

  String 객체를 생성하는 방법은
  1. 문자열 상수를 지정하는 방법과
  2. String 클래스의 생성자를 이용하는 방법
  이렇게 두 가지 방법이 있다.

  String str1 = "Java";
  String str2 = new String("Java");

  하지만 문자열 상수를 대입 연산자를 사용하여
  지정하는 방법을 통해 객체를 생성하는 경우와
  new 연산자를 이용하여 객체를 생성하는 것은
  내부적으로 의미가 다르다.
  new에 의해 새롭게 메모리공간을 확보해 java를 저장

*/

public class Test136
{
	public static void main(String[] args)
	{
		String s1 = "seoul"; //얕은복사?....와 같이 같은 seoul이라는 값을 참조해서 s1==s2가 true가됨
		String s2 = "seoul"; //다만 busan을 넣으면 seoul값을 가리키는 참조변수 주소를 끊어내고 busan을 새로 메모리에 할당해 거기로 연결
		String s3 = new String("seoul");
		String s4 = new String("seoul"); //new : 새롭게 메모리공간을 확보해라
		

		System.out.println("s1 : "+s1);
		System.out.println("s2 : "+s2);
		System.out.println("s3 : "+s3);
		System.out.println("s4 : "+s4);
		//

		System.out.println("s1 == s2 : "+ (s1 == s2)); //
		System.out.println("s2 == s3 : "+(s2==s3));
		System.out.println("s3 == s4 : "+(s3==s4)); // s3와 s4모두 객체이므로 객체의 주소값을 비교하게 된것
		System.out.println("s1 == s4 : "+(s1==s4));
		/*
		s1 : seoul
s2 : seoul
s3 : seoul
s4 : seoul
s1 == s2 : true
s2 == s3 : false
s3 == s4 : false
s1 == s4 : false
계속하려면 아무 키나 누르십시오 . . .

*/
		

		//s1과 s2 객체가 참조하는 문자열 상수가 동일한 경우
		//문자열이 저장된 기억장소의 영역이 동일하기 때문에
		//s1객체와 s2객체는 동일한 기억 장소를 참조하게 된다.
		//하지만
		//s3와 s4는 동일한 영역이 아닌 다른 기억 공간을
		//새롭게(new)확보하여 문자열 상수를 그 공간에 대입한 경우이므로
		//두 인스턴스는 같은 영역을 참조하는 것이 아니다.
		//따라서 s3 == s4는 거짓이되며
		//만약 같은 문자열 상수인지의 여부를 비교해야 할 경우라면
		//equals()메소드를 이용해야 한다.

		//String클래스가 Object 클래스의 equals메소드를 오버라이드 했고 "문자열 객체".equals 는 오버라이드된 메소드라는것
		//이로인해 객체의 주소가 아니라 진짜 문자열을 비교한다.


		System.out.println("s1.equals(s2) : "+s1.equals(s2));
		System.out.println("s2.equals(s3) : "+s2.equals(s3));
		System.out.println("s3.equals(s4) : "+s3.equals(s4));
		System.out.println("s4.equals(s1) : "+s4.equals(s1));
		// all true

		System.out.println("s1 : " + s1.hashCode());
		System.out.println("s2 : " + s2.hashCode());
		System.out.println("s3 : " + s3.hashCode());
		System.out.println("s4 : " + s4.hashCode());

		//객체가 같으면 hashcode가 같지만
		//hashcode 가 같다고해서 같은 객체는 아니다.

		s2 += " korea";
		System.out.println("s2 : "+s2);
		//s2 : seoul korea

		s2 = "korea";
		System.out.println("s2 : "+s2);

		//이와 같은 경우
		//s2 가 참조한 "seoul" 이 저장된 영역은 
		//s2+= "korea"가 수행되는 시점에서
		//해당 영역의 값이 변경되는 것이 아니라
		//가비지 컬렉션의 대상이 되며
		//"seoul korea" 상수가 저장된 영역을
		//s2가 참조하게 되었다가
		//다시 s2가 참조한 seoul korea가 저장된 영역은
		//s2 = korea에 의해 가비지 컬렉션의 대상이 되며
		//korea가  문자열 상수가 새롭게 저장된 영역을
		//s2가 참조하게 된다.


		//String 객체의 내용은 절대 불변이다.
		

	}
}