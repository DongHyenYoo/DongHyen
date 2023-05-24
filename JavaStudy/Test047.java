
//while
//1부터 100까지 정수의 합 : 5050
//1부터 100까지 짝수의 합 : 2550
//1부터 100까지 홀수의 합 : 2500


public class Test047
{
	public static void main(String[] args)
	{

		int n = 1, sum=0, evenSum=0, oddSum=0;
		
		while(n<=100){

			sum += n;

			if(n%2 == 0)
				evenSum += n;

			else if(n%2 != 0)
				oddSum += n;
			else{
				System.out.println("입력 오류입니다 "); 
				return;
			}

			n++;

		}

		System.out.println("1부터 100까지 정수의 합 : "+sum);
		System.out.println("1부터 100까지 짝수의 합 : "+evenSum);
		System.out.println("1부터 100까지 홀수의 합 : "+oddSum);



	}


}