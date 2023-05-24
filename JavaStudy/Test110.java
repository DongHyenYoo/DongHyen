/*===================================
���� �˰���
����
����ڷκ��� ���� �л��� ���� �����͸� �Է¹޾�
������ ���� �л����� ���� ������ ����� �ο��Ͽ�
����� ����ϴ� ���α׷��� ����
�� �迭�� ���� �˰����� Ȱ���Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.

��)
�ο��� �Է� : input�޼ҵ�

�̸������Է�(1, ���� ����) : ������ 90
�̸������Է�(2, ���� ����) : ������ 85
�̸������Է�(3, ���� ����) : ���¹� 80

-------------------
1�� ������ 90
2�� ������ 85
.
.
.
.
.------------------
����Ϸ��� �ƹ�Ű�� ��������
================================*/
import java.util.Scanner;

class Student //�л� Ŭ������ �л��� �迭 ������
{
	int score;
	String name;
	int rankNum;
}


class Ranking
{
	int num;
	Student[] ob;

	void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�ο��� �Է��ϼ��� : ");
		num = sc.nextInt();
		ob = new Student[num+1];
	}
	
	void score()
	{
		Scanner sc = new Scanner(System.in);
		int score;
		String name;

		for(int i=0;i<num;i++)
		{
			ob[i] = new Student();
			System.out.printf("�̸� ���� �Է� ���鱸��(%d) : ",i+1);
			ob[i].name=sc.next();
			ob[i].score=sc.nextInt();
			
		}
		ob[num] = new Student();
	}
		

	void rank() //score ���ؼ� ��ũ �ű��
	{	
		for(int i=0;i<ob.length-1;i++)
			ob[i].rankNum=1;


		for(int i=0;i<ob.length-2;i++)
		{
			for(int j=1+i;j<ob.length-1;j++)
			{
				if(ob[i].score>ob[j].score)
				{
					ob[j].rankNum+=1;
				}
				else if(ob[i].score<ob[j].score)
				{
					ob[i].rankNum+=1;
				}

			}
		}

		reArr();

	}


	void reArr()
	{
		int pass=1;
		boolean flag;
		do
		{
			flag=false;
			pass++;
			for(int i=0;i<ob.length-pass;i++)
			{
				if(ob[i].rankNum>ob[i+1].rankNum) //��ũ�� ������� 1����� �������� ����
				{
					ob[num] = ob[i];
					ob[i] = ob[i+1];
					ob[i+1] = ob[num];
					flag=true;
				}


			}
			

		}
		while (flag);
	}

	void print()
	{
		System.out.print("-----------------------------\n");
		for(int i=0;i<ob.length-1;i++)
			System.out.printf("%d��%4s%3d\n",ob[i].rankNum,ob[i].name,ob[i].score);

		System.out.print("-----------------------------");
	}


}

public class Test110
{
	public static void main(String[] args)
	{
		Ranking ob = new Ranking();
		ob.input();
		ob.score();
		ob.rank();
		ob.print();

	/*
	�ο��� �Է��ϼ��� : 6
�̸� ���� �Է� ���鱸��(1) : ������ 87
�̸� ���� �Է� ���鱸��(2) : ���ҿ� 76
�̸� ���� �Է� ���鱸��(3) : �躸�� 84
�̸� ���� �Է� ���鱸��(4) : ������ 91
�̸� ���� �Է� ���鱸��(5) : ���α� 93
�̸� ���� �Է� ���鱸��(6) : ������ 65
-----------------------------
1�� ���α� 93
2�� ������ 91
3�� ������ 87
4�� �躸�� 84
5�� ���ҿ� 76
6�� ������ 65
-----------------------------����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


	*/
	}

}