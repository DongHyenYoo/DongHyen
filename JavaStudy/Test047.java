
//while
//1���� 100���� ������ �� : 5050
//1���� 100���� ¦���� �� : 2550
//1���� 100���� Ȧ���� �� : 2500


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
				System.out.println("�Է� �����Դϴ� "); 
				return;
			}

			n++;

		}

		System.out.println("1���� 100���� ������ �� : "+sum);
		System.out.println("1���� 100���� ¦���� �� : "+evenSum);
		System.out.println("1���� 100���� Ȧ���� �� : "+oddSum);



	}


}