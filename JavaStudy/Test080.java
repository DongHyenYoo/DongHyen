/*===================================
�迭
-�迭�� �⺻�� Ȱ��
================================*/

//������ �������� ����ִ� �迭�� ���� �����͵� ��
// ¦���� ��Ҹ� ��� ����ϰ� 3�� ����� ��Ҹ� ��� ����ϴ�
//���α׷��� �����Ѵ�.


import java.io.*;
import java.util.*;

public class Test080
{

	public static void main(String[] args)throws IOException
	{


		Scanner sc = new Scanner(System.in);

		char arr1[];
		int num=0;
		


		System.out.print("�迭 ���� ���� �Է� : ");
		num = sc.nextInt();


		arr1 = new char[num]; //���⼭ �̰� �����ָ� �迭ũ�Ⱑ ���ٰ���



		System.out.print("\n�迭�� �Է��ϼ���");

		for(int i=0;i<num;i++){

			arr1[i] = sc.next(); 
			
		}

		//�迭 ���� �Է¹ް� �ִ¼���
		//�迭����[] -> []�ȿ��� ���ڼ��� �� �ʱ�ȭ -> �迭�� �Է¹ޱ� -> for������ �迭����ŭ
		//�迭�̸�[i] nextInt�� �޾Ƴ���

		

		
		
		//int arr[] = sc.nextInt(); int�� int�� �ȵǴµ�?
		//�迭��ü�� String���̶� �ȵǴµ� 
		//�ϰ� ������ ������ ���� �����ϰ� �ؾߴ�


/*
		int[] arr1 ={4,7,9,1,3,2,5,6,8};


		System.out.println(arr1.length); //�迭�� ���̴�?
		
		System.out.println("�迭�� ��� ��ü ���"); 

		for(int i=0;i<arr1.length;i++) //�� ���� �迭�� ���̸�ŭ ���� �־��ش�.
		System.out.printf("%2d",arr1[i]);
		
		System.out.println();

			System.out.println("¦�� ������ ���");
			for(int j=0;j<9;j++){

				if(arr1[j]%2==0)
					System.out.printf("%2d",arr1[j]);

			}

			System.out.println("\nȦ�� ������ ���");			
			for(int j=0;j<9;j++){

				if(arr1[j]%3==0)
					System.out.printf("%2d",arr1[j]);
			}

			System.out.println();


					*/



	
	}

}