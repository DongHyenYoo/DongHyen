/*===================================
�迭�� �迭(2���� �迭)
================================*/

//����

//������ �迭�� Ȱ���Ͽ�
//������ ���� �����͸� ��ҷ� ���ϴ� �迭�� ��
//���ϰ�
//�� ����� ����ϴ� ���α׷��� �����Ѵ�.
//�迭�� �Ʒ��� ��� �� �迭�� 2���������Ϳ� ������ �����ϱ�

//���� ��
/* 

A            65
B C			 66 67
D E F		 68 69 70
G H I J      71 72 73 74
K L M N O    75 76 77 78 79


*/
public class Test093
{

	public static void main(String[] args)
	{

		int arr[][] = new int[5][5];

			int n=65;

			for(int i=0;i<5;i++)
			{
				for(int j=0;j<=i;j++)
				{
					arr[i][j] = n;
					n++;
					

				}
				
			}

			for(int i=0;i<5;i++)
			{
				for(int j=0;j<=i;j++)
				{					
					System.out.printf("%3c",arr[i][j]);
				
				}
				System.out.println();
			}

/*
  A
  B  C
  D  E  F
  G  H  I  J
  K  L  M  N  O
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/


	}

}