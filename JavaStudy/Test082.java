/*===================================
�迭
-�迭�� �⺻�� Ȱ��
-�迭�� ����� �ʱ�ȭ
================================*/

//����ڷκ��� �ο����� �Է¹ް�
//�Է¹��� �ο��� ��ŭ�� �л� �̸��� ��ȭ��ȣ�� �Է¹ް�
//�̷��� �Է¹��� �����͸� �̸� �迭�� ��ȭ��ȣ �迭�� �����Ͽ�
//����� ����� �� �ִ� ���α׷� ����

//�Է� ó���� �л� �� �Է�(1~10) :
//�Է� �� �ʰ��� ��� �ٽ� �Է��ض� ��� �ض�

//�̸� ��ȭ��ȣ �Է�[1]( ���� ����): ������ 010-3578-3912
//�̸� ��ȭ��ȣ �Է�[2](���� ����) :



import java.util.Scanner;
/*
class Student
{
	int num;

	Student(){

		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("�Է��� �л� �����Է��ϼ��� : ");
			num = sc.nextInt();

		}
		while (num <1 || num >10);
	}


	String[] inputInfo(){
		String arr[] = new String[num];
		String arr1[] = new String[num];
		

		Scanner sc = new Scanner(System.in);

		for(int i=0;i<num;i++)
			{
			System.out.printf("�л��� �̸��� ��ȭ ��ȣ�� �Է�[%d] : ",i);
			arr[i] = sc.next();
			arr1[i] = sc.next();
			}
			System.out.println();
			return arr;


			�̰� �߰��� �ٸ��Լ� ȣ���ؼ� �ű⿡ �����Ҽ� ������!!!!!!
		}
	
	

	}
������ ������
*/ 

public class Test082
{

	public static void main(String[] args)
	{
		int studentNum; //�л��� �Է¹��� ����
		
		String name;
		String number;
		

		Scanner sc = new Scanner(System.in);

		do{
		System.out.print("�Է� ó���� �л� �� �Է�(1~10) : ");
		studentNum = sc.nextInt();
		}
		while(studentNum < 1 || studentNum >10); //studentNum < 1 || studentNum >10

		String nameArr[] = new String[studentNum]; //�л� �̸� �迭
		String phoneArr[]= new String[studentNum]; // �л� ��ȭ��ȣ �迭 //String phoneArr[]= new String[nameArr.length]; �� �ص��ȴ�.
		
		
			for(int i=0;i<studentNum;i++){
				System.out.printf("�̸� ��ȭ��ȣ �Է�[%d] : ",i+1);
				nameArr[i] = sc.next();    //String name = sc.next();
				phoneArr[i] = sc.next();   //String number = sc.next();
				// nameArr[i] = name + " " + number; //�̷��� �ص� �ȴ�.
			
		}
		System.out.print("=====================\n");
		System.out.printf("��ü �л� �� : %d\n",studentNum);
		System.out.print("======================\n");
		System.out.print("�̸�   ��ȭ��ȣ\n");
		for(int i=0;i<studentNum;i++){
			System.out.printf("%s \t%s\n",nameArr[i],phoneArr[i]);
		}
		System.out.println();

		


	}

}