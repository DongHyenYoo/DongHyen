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

A B C D E
F G H I J
K L M N O
P Q R S T
U V W X Y



*/
public class Test092
{

	public static void main(String[] args)
	{

		int arr[][] = new int[5][5];

			int n=65;

			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++)
				{
					arr[i][j] = n;
					n++;

				}

			}

			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++)
				{
					System.out.printf("%4c",arr[i][j]);

				}
				System.out.println();

			}
/*
   A   B   C   D   E
   F   G   H   I   J
   K   L   M   N   O
   P   Q   R   S   T
   U   V   W   X   Y
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/




	}

}