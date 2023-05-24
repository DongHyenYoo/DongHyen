//비트 단위 연산자

// 쉬프트 연산자


public class Test025
	
	{

		public static void main(String[] args)
		{

			int x = 128; // 0000 0000  0000 0000 0000 0000 1000 0000

			System.out.printf("x <<3 : %d\n", x << 3);
			System.out.printf("x * 8 : %d\n", x* 8);

			System.out.printf(" x >> 3: %d\n", x >> 3);

			System.out.printf(" x << 24: %d\n", x << 24);


			System.out.printf(" x << 25: %d\n", x << 25);
			System.out.printf(" x << 32: %d\n", x << 32);
			System.out.printf(" x << 64: %d\n", x << 64);






		}






}