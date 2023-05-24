/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
Wrapper 클래스
================================*/

public class Test131
{
	public static void main(String[] args)
	{
		boolean bi = true;
		Boolean wrapBi = new Boolean(bi);
		Boolean wBi = bi;					//-- 오토 박싱 (클래스형에 primitive형을 대입하는것)

		int n = 300;
		Integer wrapN = new Integer(n);		//박싱
		int n2 = wrapN;						// 오토 언박싱

		float f = 300.3f;
		Float wrapF = new Float(f);

		System.out.println(wrapBi.toString());
		System.out.println(wrapN.toString());
		System.out.println(wrapF.toString());

		System.out.println(wrapBi);
		System.out.println(wrapN);
		System.out.println(wrapF);



		//Integer 클래스
		String sn = "12";
		int ni = Integer.parseInt(sn);
		System.out.printf("ni : %3d\n", ni);
		
		ni = Integer.parseInt("0101",2);  //뒤의 파라미터는 2진법으로 변환한것을 의미
			System.out.printf("ni : %3d\n", ni);

		ni = Integer.parseInt("12",8);
		System.out.printf("%ni : %3d\n", ni);

		ni = Integer.parseInt("A",16);
		System.out.printf("ni : %3d\n",ni);

		sn = Integer.toBinaryString(20); //to 뭔가로 변하게하는 가능성이 크다. is는 보통 true false로 변환하게 하는경우가 많다.
		System.out.println("sn : "+ sn);

		sn = Integer.toOctalString(31);
		System.out.printf("sn : %s\n", sn);

		sn = Integer.toHexString(31);
		System.out.printf("sn : %s\n",sn);
		

		Integer num = new Integer(50); //얕은복사 로 num에 50 담음  toString은 Integer에서 오버라이드됨
		System.out.println("num.toString :"+num.toString());

		int n3 = 345;
		Integer n4 = Integer.valueOf(n3);
		System.out.println("n4 : "+n4); 
		//n4 : 345



	}
}