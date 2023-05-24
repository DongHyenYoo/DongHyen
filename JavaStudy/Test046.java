// while실습
//1 부터 100까지의 정수중
//홀수의 합 :
//짝수의 합 :
//조건문을 사용하기



public class Test046{

	public static void main(String[] args)
		{

		int n= 1, evenSum = 0, oddSum = 0;

		while(n<=100){

			if(n%2 ==0)
				evenSum += n;

			else if(n%2 != 0)
				oddSum += n;
			else
				System.out.println("판별불가데이터");
				return; //메소드 종료 -> main() 메소드 종료 -> 프로그램 종료를 의미


			n++;

		}

		System.out.printf("짝수의 합 : %d\n홀수의 합 : %d\n",evenSum,oddSum);


		}



}