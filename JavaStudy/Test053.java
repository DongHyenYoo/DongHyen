// ����
//������ ���� �Է¹޾�
//1���� �Է¹��� �� ����������
//��ü�� ¦���� ��  Ȧ���� ����
//���� ��������� ����ϴ� ���α׷��� �����Ѵ�.

// ������ ���� �Է� :
//1~123 ���� �������� : ''
//���� ����

import java.util.Scanner;

public class Test053
{

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���� �Է� : ");


		int oddSum,evenSum;
		oddSum = evenSum = 0;

		int num = sc.nextInt();
		if( num == 0){
			System.out.print("0�� �ȵǿ�");
			return;
		}

		int i = 1; //1~�� ����� ����i

		while(i<=num){


			if((i%2) == 0){
				evenSum += i; //¦����
			}
			else if((i%2) != 0){
				oddSum += i; //Ȧ����
			}

			i++;
		}

		System.out.printf("1���� %d ���� ������ �� : %d\n",num,(evenSum+oddSum));  //Ȧ��+¦������ ������
		System.out.printf("1���� %d ���� ¦���� �� : %d\n",num,evenSum);
		System.out.printf("1���� %d ���� Ȧ���� �� : %d\n",num,oddSum);

	}

}

/*
������ ���� �Է� : 100
1���� 100 ���� ������ �� : 5050
1���� 100 ���� ¦���� �� : 2550
1���� 100 ���� Ȧ���� �� : 2500
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/