//����ڷκ��� ������ ���� 5���� �Է¹޾�
//¦�� Ȧ���� �հ踦 ����ϴ� ���α׷��� �����Ѵ�.
//�� Scanner�� Ȱ���Ͽ� �����͸� �Է¹����� �ֵ���
//������ ���� 5�� �Է�( ���� ����) : 1 2 3 4 5

import java.util.Scanner;


public class Test038
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int holesum=0 , zacsum=0;
		
		System.out.print("������ ���� 5�� �Է�(���� ����)");

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

			System.out.printf("¦���� ���� :%d �̰� Ȧ���� ���� : %d",zacsum,holesum);



		



	}

}