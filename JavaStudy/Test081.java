/*===================================
�迭
-�迭�� �⺻�� Ȱ��
-�迭�� ����� �ʱ�ȭ
================================*/


//char �ڷ����� �迭
//�� �迩���� �� �濡 ���ĺ� �빮�ڸ� ä���
//ä���� �� �迭�� ��ü��Ҹ� ����ϴ� ���α׷�
//��, ä��� ������ ����ϴ� ������ ���� �и��Ͽ� ó���� �� �ֵ��� �Ѵ�.

//import java.util.Scanner;
//import java.io.*;

public class Test081
{
	public static void main(String[] args)
	{
/*
		char arr[]; //���ڹ迭
		int num = 0; //���ڹ迭��
		arr = new char[num];

		Scanner sc = new Scanner(System.in);

		System.out.print("�Է¹��� ���� �Է��ϼ���");
		num = sc.nextInt();

		for(int i=0;i<num;i++)
		{
			arr[i]= sc.nextChar();

		}

		for(int i=0;i<num;i++)
		System.out.println(arr[i]);


*/

		int arr[];
		arr = new int[26];
		int count =0;
		//arr = new char[count]; 
		//arr = new char[];
		//count�� �ȿ� ���� ��������. ���ڸ� �Է��ؾ��߳�? count�� 0�̾ �׷�����

		//char[] arr = new char[26];
		
	/*	
		for(int i=65;i<=90;i++){
			arr[count] = (char)i;
			count++;
		}
		*/

		for (int i=0, ch=65;i<arr.length;i++,ch++)
		{
			arr[i]=ch;
		}
		
		for(int i=0;i<arr.length;i++) //for�ȿ� �ʱ⺯���� �������ϼ� �ְ�, ������ �������ϼ������� �������ڿ����ϰ� (����� true Ȥ�� false�̱⿡
			System.out.printf("%2c",(char)arr[i]); //�� �Ǵµ�?

	}

}