/*===================================
Ŭ���� ���
�������̽�
================================*/

//�ǽ� ����

//���� ó�� ���α׷��� �����Ѵ�.
//�� �������̽� Ȱ�� �Ұ�

//���� ��)
//�ο� �� �Է�(1~10) : 11
//�ο� �� �Է�(1~10) : 2

//1��° �л��� �й��� �̸� �Է�(���� ����) :20227123 ������
//���� ���� ���� ���� �Է� (���鱸��):90 100 85
//2��° �л��� �й��� �̸� �Է� : 2208225 �ֳ���
//���� ���� ���� ���� �Է� (���� ����) : 85 70 65

//�й� �ֵ��� 90 100 85  ����  ���
//            ��  �� ��
//�й� �ֳ��� 90 100 85  ����  ���
//            �� ��  ��

//�������̽��� Ŭ���������� ���� ��������
// �������̽����� �޼ҵ常 �尡�� �ɵ�
// �Ӽ��� �����ϴ� Ŭ���� -> �ڷ���
import java.util.Scanner;


interface SungJuk
{
	public void set(); //�ο�
	public void input(); //������ �Է�
	public void print(); //��� ���
}

class Record 
{
	String hak, name;
	int kor, eng, mat;
	int tot;
	double avg;
}



class SungjukImpl implements SungJuk
{
	private int inwon;
	private Record[] rec;

	//���������� ��޿� ���� ������ ������ �޼ҵ�
	
	@Override
		public void set()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
		System.out.print("�ο� �� �Է�(1~10) : ");
		inwon = sc.nextInt();
		}
		while (inwon<1 || inwon>10);

		rec = new Record[inwon];
	}

	@Override
		public void input() //������ �Է�
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<rec.length;i++)//Ŭ������ �迭�� ��ü�� �ִ´�.
		{
			rec[i] = new Record();//�迭�� ��ü �ֱ�
			System.out.printf("%d��° �л��� �й��� �̸� �Է� : ",i+1);
			rec[i].hak = sc.next();
			rec[i].name = sc.next();
			
			System.out.printf("���� ���� ���� ���� �Է� : ");
			rec[i].kor = sc.nextInt();
			rec[i].tot += rec[i].kor;

			rec[i].eng = sc.nextInt();
			rec[i].tot += rec[i].eng;

			rec[i].mat = sc.nextInt();
			rec[i].tot += rec[i].mat;

			rec[i].avg = rec[i].tot/3.0;
		}
	}


	@Override
		public void print()
	{   
		System.out.println();
		System.out.println();
		
		for(int i=0;i<rec.length;i++)
		{
			System.out.printf("%s %4s %3d %3d %3d %4d %7.2f",rec[i].hak,rec[i].name,rec[i].kor,rec[i].eng,rec[i].mat,rec[i].tot,rec[i].avg);
			System.out.printf("\n\t\t   %2s %2s %2s",panjung(rec[i].kor),panjung(rec[i].eng),panjung(rec[i].mat));
			System.out.println("\n");
		}		
	}


	private String panjung(int score) //���� �Է¹޾Ƽ� ����̾簡 ���ϱ�
	{
		
		if(score>=90)
			return "��";
		else if(score>=80)	
			return "��";
		else if(score>=70)			
			return "��";
		else if(score>=60)	
			return "��";
		else
			return "��";
	}

}




public class Test121
{
	public static void main(String[] args)
	{

		SungjukImpl ob0 = new SungjukImpl();
		SungJuk ob = (SungJuk)ob0;
		//SungJuk ob = new SungjukImpl(); �����Ŵ�
		ob.set();
		ob.input();
		ob.print();
	
	}
}