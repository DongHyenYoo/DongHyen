//while
//1���� 100���� ������ ���� ���ϵ�
//10�� ����� �ɶ�����
//����� ����ϴ� ���α׷��� �����Ѵ�.

//1~10 ������ �� :  xx
// 1~20 ������ ��
//1~100������ ��

public class Test048
{

	public static void main(String[] args){

		int n = 0, tot=0;

		while(++n<=100){

			tot += n;
			
			if(n%10 ==0)
				System.out.printf("1���� %d������ �� : %d\n",n,tot);

			else if(n%1 != 0){
				System.out.print("�Ǻ��ȵ�");
			}


		}





	}




}