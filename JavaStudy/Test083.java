/*===================================
�迭
-�迭�� �⺻�� Ȱ��
-�迭�� ����� �ʱ�ȭ
================================*/


//����
// ����ڷκ��� ������ ������ �̹����� ������ŭ �Է¹޾�
// �Է¹��� �� �߿��� ���� ū ���� ����ϴ� ���α׷��� �����Ѵ�.
// �� �迭�� Ȱ���Ͽ� ������ �� �ֵ��� �Ѵ�.

//�Է��� �������� ���� : 12
//������ �Է�(���� ����) : 1 2 3 4 5 6 7 8 9 10 11 12
//���� ū �� -> 099

//���� ū���� ��� �����ϰ� 
//���� ū���� ��Ҵٰ� ���
import java.util.Scanner;


class Numarr
{
	
	int num;											//�Է¹��� ���� ���� num ����
	

	Numarr()											//������
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� �������� ���� : ");
		num = sc.nextInt();								//��ü ������ ���ÿ� �Է��� ������ �����ޱ�
	}

	int[] input(){										//num ���� �ش��ϴ� �� �޴� �޼ҵ� ���� �ڷ����� int�� �迭

		//System.out.println(num); ���� �� ������ ��µ�...
		//System.out.println(arr[0]); �迭�� �ʱ�ȭ�� �ȵǳ�?;; ���⼭ ������ ����.
		
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[this.num];						//num���� �ش��ϴ� �迭 ����
		System.out.print("������ �Է�(���� ����) : ");
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = sc.nextInt();						

		}
		return arr;										//�迭 ����
		
	
	}

	int cal(int[] arr){									//���� ū���� �����ϴ� �޼ҵ�

		int max = arr[0];								//�迭�� 0��° ���� ���Ƿ� ����ū ���� �д�.
		for(int i=1;i<arr.length;i++)
		{
			if(max<=arr[i])								//�ݺ����� ���� �迭�� �����鼭 max������ ū������ ��� max�� �ִ´�.
			{
				max = arr[i];
			}
		}

		return max;										//����ū�� ����
	}

	

}



public class Test083
{

	public static void main(String[] args)
	{		
		
		
		Numarr ob = new Numarr();

		int arr[] = new int[ob.num];					//��ü.�����̸� ���� Numarr�� �ִ� num���� ������ �迭����
		arr = ob.input();			//arr[ob.num] �ϸ�
									//Test083.java:72: error: incompatible types: int[] cannot be converted to int
									//arr[ob.num] = ob.input(); �� ���� ����

		int max = ob.cal(arr);							//�޾ƿ� ����ū ���� max�� ����
		System.out.println("���� ū ��: "+max);

		
		/*
		�Է��� �������� ���� : 12
		������ �Է�(���� ����) : 97 98 97 99 34 25 54 37 93 72 62 63
		���� ū ��: 99
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/

		
		
		


	/*
		Scanner sc = new Scanner(System.in);

		int num;
		
		System.out.print("�Է��� �������� ���� : ");
		num = sc.nextInt();
		
		int arr[] = new int[num];

		System.out.print("������ �Է�(���� ����) : ");
		for(int i=0;i<arr.length;i++)
			{
			arr[i] = sc.nextInt();
			}

		
		int max = arr[0];

		for(int i=1;i<arr.length;i++)
			{
			if(max<=arr[i])
				max=arr[i];

			}
		
		System.out.println("�Է¹��� �� �߿� ���� ū ����  : "+max);
	*/
	}

	/*
		�Է��� �������� ���� : 12
		������ �Է�(���� ����) : 97 98 97 99 34 25 54 37 93 72 62 63
		���� ū ��: 99
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/

}