//여러개의 양의 정수를 입력받고
//그 합을 계산하여 출력하는 프로그램을 작성한다.
//단 -1이 되는 순간 입력 행위를 중지
//-1을 입력중지 커맨드로 사용
//do while문을 활용하여 문제를 해결 할 수 있도록 한다.



public class Test056
{
	public static void main(String[] args)
	{

		java.util.Scanner sc = new java.util.Scanner(System.in);

		int num, i;
		i=0;
		int tot =0;

		do
		{	

			i++;
			System.out.printf("%d 번째 정수 입력(-1 종료) : ",i);
			num = sc.nextInt();
			if(num == -1)

			tot += num;
			
		}
		while (num != -1); // 왜 num == -1 이 아닌가 당연히 조건식이 참이어야흘러가는데
		                   // 이건 -1이어야 true가 되는것이므로 당연히 num != -1 이다.

			System.out.printf("현재까지 입력된 정수의 합 : %d ",(tot+1)); //



	}


}