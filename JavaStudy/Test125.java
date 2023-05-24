/*===================================
클래스 고급
중첩 클래스
================================*/

/*
Annonymous 클래스(익명의 클래스 : 무명 클래스)

  -AMT 나 안드로이드 이벤트 처리에서 일반적으로 사용
  -상위 클래스 메소드를 하나 정도 재정의할 필요성이 있을때 사용
  -클래스의 객체가 필요하면 또 다시 클래스를 생성해야 하는
  번거로움으로 인해 빈번하게 객체 생성이 필요할 경우
  익명의 클래스를 생성하여 처리할 수 있다.

  형식 및 구조

  new 상위클래스의 생성자()
  {
	  접근제어지시자 자료형 메소드()
	  {

	  }
	  }; 
*/
class Test3
{
	public Object getString()
	{

		return new Object()
		{
			@Override
				public String toString()
			{
				return "익명의 클래스";
			}
	};
}

}

public class Test125 //extends object 가 줄곧 붙어있었다.오브젝트 클래스는 모든 객체의 조상클래스
{
	public static void main(String[] args)
	{
		Test3 ob1 = new Test3();

		System.out.println(ob1.toString());

		System.out.println(ob1.getString());

	}
}