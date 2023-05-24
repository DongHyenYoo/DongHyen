//사용자로부터 임의의 정수 5개를 입력받아
//짝수 홀수별 합계를 출력하는 프로그램을 구현한다.
//단 Scanner를 활용하여 데이터를 입력받을수 있도록
//임의의 정수 5개 입력( 공백 구분) : 1 2 3 4 5

import java.util.Scanner;


public class Test038
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int holesum=0 , zacsum=0;
		
		System.out.print("임의의 정수 5개 입력(공백 구분)");

		int a = sc.nextInt();
			if(a%2==0)
				zacsum += a;
			else
				holesum += a;
			
			a = sc.nextInt();
				if(a%2==0)
				zacsum += a;
			else
				holesum += a;

			
			a = sc.nextInt();
				if(a%2==0)
				zacsum += a;
			else
				holesum += a;

			a = sc.nextInt();
				if(a%2==0)
				zacsum += a;
			else
				holesum += a;

			a = sc.nextInt();
				if(a%2==0)
				zacsum += a;
			else
				holesum += a;

			/*int a = sc.nextInt();
			if(a%2==0)
			{
				zacsum += a;	
				a = sc.nextInt();
			}else
			{
				holesum += a;	
				a = sc.nextInt();
			
			}
			
			if(a%2==0){
				zacsum += a; 		
				a = sc.nextInt();
			}
			else{
				holesum += a;
			a = sc.nextInt();
			}
			
			
			if(a%2==0){
				zacsum += a;
				a = sc.nextInt();
			}
			else{
				holesum += a;
			a = sc.nextInt();
			}

			
			if(a%2==0){
				zacsum += a;
				a = sc.nextInt();
			}
			else{
				holesum += a;
			a = sc.nextInt();

			}
			if(a%2==0){
				zacsum += a;
			}
			else{
				holesum += a;
			}
*/


			

	/*			
		int b = sc.nextInt();
			if(b%2==0)
				zacsum += b;
			else
				holesum +=b;

		int c = sc.nextInt();
			if(c%2==0)
				zacsum += c;
			else
				holesum += c;


		int d = sc.nextInt();
			if(d%2==0)
				zacsum += d;
			else
				holesum +=d;


		int e = sc.nextInt();
		    if(e%2==0)
				zacsum += e;
			else
				holesum +=e;

				*/

			System.out.printf("짝수의 합은 :%d 이고 홀수의 합은 : %d",zacsum,holesum);



		



	}

}