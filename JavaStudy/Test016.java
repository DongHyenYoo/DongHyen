//자바의 기본 입출력 프로그램 : println

public class Test016{

	public static void main(String[] args)
	{


		System.out.print("AAA");
		System.out.print("BBB");
		System.out.print("CCC\n");


		//System.out.println();
		//System.out.print(); //에러발생 컴파일에러

		//System.out.prinnt(\n); 에러발생 컴파일 에러 
		System.out.print("\n");

		System.out.printf("123455");
		System.out.printf("123455\n"); // \n 개행
		System.out.printf("123455%n"); // %n 개행

		//System.out.printf(); 또한 컴파일 에러가 발생

		System.out.printf("%d + %d = %d%n", 10,20,30);
		
		System.out.printf("%d\n", 123);
		System.out.printf("%10d\n", 123); //이 정수를 위해 10칸을 할당하고 뒤에 3칸을쓴다.
		System.out.printf("%8d\n", 123);
		System.out.printf("%010d\n", 123); //앞의 빈공간을 0으로 채운다.

		System.out.printf("%+d\n", 365); //  +365의 형태로 나온다.
		System.out.printf("+%d\n", 365); // 같은 형태로 나옴

		System.out.printf("%d\n" , +365); // 그냥 365가 나옴

		System.out.printf("-%d\n", 365);
		System.out.printf("%d\n", -365); //둘다 -365

		//System.out.printf("%d\n" , 'a'); 런타임에러
	    System.out.printf("%c\n", 'A');

		//System.out.printf("-%d\n", "365"); 런타임에러

		System.out.printf("%s\n", "365");

		System.out.printf("%h\n", 365); //16진수로 반환
		
		System.out.printf("%o\n", 365); 

		System.out.printf("%b\n", true); //boolean 의 앞을따서 b로


		System.out.printf("%8.2f\n", 123.236); //  123.24

		System.out.printf("%2.2f\n", 123.24); // 자리수에 안맞으면 앞을 무시한다.






	}





}