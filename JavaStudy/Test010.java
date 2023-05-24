//퀴즈
//사전에 부여된 반지름 정보를 통해
//원의 넒이와 둘레를 구하는 프로그램 구현
// -> 반지름: 10

//실행예
//넒이 :
//둘레 :


public class Test010{

	public static void main(String[] args){

		//넓이 공식 이파이알 제곱
		//둘레 이파이알

		int r= 10;
		final double PI = 3.141592; //앞에 final을 붙여 변수를 상수화 시킴 보통 중요한 변수는 대문자로
		double round;
		double area;

		area = PI * (r * r);
		round = 2 * PI * r;

		System.out.printf("원의 넒이 : %f\n",area);
		System.out.printf("원의 둘레 : %f\n",round);







	}





}