//while
//1부터 100까지 정수의 합을 구하되
//10의 배수가 될때마다
//결과를 출력하는 프로그램을 구현한다.

//1~10 까지의 합 :  xx
// 1~20 까지의 합
//1~100까지의 합

public class Test048
{

	public static void main(String[] args){

		int n = 0, tot=0;

		while(++n<=100){

			tot += n;
			
			if(n%10 ==0)
				System.out.printf("1부터 %d까지의 합 : %d\n",n,tot);

			else if(n%1 != 0){
				System.out.print("판별안됨");
			}


		}





	}




}