/*===================================
�迭
-�迭�� ���� ó�� Random Ŭ���� Ȱ��
================================*/

//����ڷκ��� ������ ���� �Է¹޾�
//������ ������ŭ ����(1~100)�� �߻����� �迭�� ���
//�迭�� ����ִ� �����͵���
//���� ū ���� ���� �������� �����Ͽ�
//����� ����ϴ� ���α׷��� �����Ѵ�.

//������ ���� ���� 

//�� �������� �߻��� �������� �迭�� ��Ƴ���
//���� ���� ū�� ���� ������


import java.util.Scanner;
import java.util.Random;
public class Test095
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("�߻���ų ������ �Է� : ");

		int size = sc.nextInt(); //������� �Է°��� ��Ƴ� ���� 

		//size ������ ��Ƴ� �� ��ŭ�� �迭�� �����(�迭����)
		int arr[] = new int[size];

		//���� �߻� ���� ��ü Random �ʿ�
		Random rd = new Random();
		//Random Ŭ���� �ν��Ͻ� ����

		//Random Ŭ������ nextInt() �޼ҵ� //��ĳ���� nextInt�ʹ� �ٸ� �޼ҵ��̴�.
		// 0~ �Ű������� �Ѱܹ��� ���� n-1������ ���� ������ ����(����) 1���� �߻���Ų��.
		//rd.nextInt(10);

		//�׽�Ʈ
		//System.out.println("�߻��� ���� "+rd.nextInt(10));
		//0~9������ ������ �ǹ��ϴ� ���̰� �� ���̿��� ������ ���� 1��

		//�迭����
		for(int i=0;i<size;i++)
		{
			//rd.nextInt(101); //0~100
			
			//rd.nextInt(100)+1; // 0~99+1�̹Ƿ� 1~100�̴�

			arr[i] = rd.nextInt(100)+1;
			
			//rd.nextInt(100);  -> 0~99 ������ ������ ���� �� �� �߻�
			//rd.nextInt(100)+1; -> 1~100������ ������ ���� �� �� �߻�

		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.printf("%4d",arr[i]);
		}
		
		int max, min;
		max = min = arr[0];

		for(int i=1;i<size;i++)
		{
			if(max<arr[i])
				max = arr[i];
		
			if(min>arr[i])
				min = arr[i];
		}

		System.out.printf("\n������ ���� ū ���� %3d �̰� ���� ���� ���� %3d�Դϴ�.\n",max,min);



	}

}