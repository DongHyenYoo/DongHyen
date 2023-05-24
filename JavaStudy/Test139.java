/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
StringBuffer 클래스
================================*/


public class Test139
{
	public static void main(String[] args)
	{

		String s1 = "123456789";
		s1 = (s1+"123").replace('2','A'); //s1에 123문자열 추가하고 2를 A로 바꿔라
		
		System.out.println(s1); 

		StringBuffer s2 = new StringBuffer("123456789");
		s2.delete(0,3).replace(1,3,"24").delete(4,6);  //0->2까지  1->2까지 4->5까지
		
		System.out.println(s2);
		//456789
		//424789
		//4247

		StringBuffer s3 = new StringBuffer("123456789");
		String s4 = s3.substring(3,6);  //3->5까지
		System.out.println(s4);

		StringBuffer s5 = new StringBuffer("123456789");
		s5.delete(0,3).delete(1,3).delete(2,5).insert(1,"24");
			//4247
		System.out.println("s5 : "+s5.toString());

	}
}