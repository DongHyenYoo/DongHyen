// while�ǽ�
//1 ���� 100������ ������
//Ȧ���� �� :
//¦���� �� :
//���ǹ��� ����ϱ�



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
				System.out.println("�Ǻ��Ұ�������");
				return; //�޼ҵ� ���� -> main() �޼ҵ� ���� -> ���α׷� ���Ḧ �ǹ�


			n++;

		}

		System.out.printf("¦���� �� : %d\nȦ���� �� : %d\n",evenSum,oddSum);


		}



}