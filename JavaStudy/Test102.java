/*===================================
Ŭ������ �ν��Ͻ�
Ŭ������ �ν��Ͻ� Ȱ��
================================*/
//1~3������ ������ �߻����Ѽ�
//���� ���� �� ���� ���α׷��� �����Ѵ�.
//�� Ŭ������ ������ Ȱ���Ͽ� ó���� �� �ֵ��� �Ѵ�.
//���� �迭�� Ȱ���Ͽ� ó�� �� �� �ֵ��� �Ѵ�.
//���������� RpsGame Ŭ������ �ϼ��� �� �ֵ��� �Ѵ�.

//����
//1.���� ���� �� ���Է��϶�� �޼����� ��Ÿ�� �޼ҵ�
//�� �޼ҵ�� ���� �Է��� ���� ��������� �����ؾߵ�
//������� num ��������
//void ������

//1.1~3������ ������ �߻���ų �޼ҵ�//�̰� ��ǻ�Ͳ�
//�����¿� �߰��� ���Ե� �޼ҵ�� ��ǻ���� ����� {����, ����,��}�� ���õ�
//void Ÿ��

//3. ���ؼ� �������� �޼ҵ� print
// 1 vs 3 = 1�� �̱��
// 1 vs 2 = 2��
// 1 vs 1 = ���

//2 vs 1 = 2��
//2 vs 3 = 3��

//3 vs 1 = 1��
//3 vs 2 = 3��

import java.util.Scanner;
import java.util.Random;

class RpsGame
{
	private int num;
	private int pcNum;

	public void input()
	{
		Scanner sc = new Scanner(System.in);
		
		runCom();

		do
		{
			System.out.print("1.����, 2:����, 3:�� �� �Է�(1~3) : ");
				num = sc.nextInt();	
		}
		while (num<1 || num >3);

	}

	private void runCom()
	{
		Random rd = new Random();
		pcNum = rd.nextInt(3)+1;
	}


	public void midVs() //�߰����
	{

		String[] st = {"����","����","��"};
				System.out.println("���� : "+st[num-1]);
				System.out.println("��ǻ�� : "+st[pcNum-1]);
				System.out.println();
				
		}

	public String resultCalc()
	{
		String result = "���º��Դϴ�!";
		
		//(����=="����" && �� =="��") || (����=="����" && �� =="����") || (����=="��" && �� =="����")
		
		if((num==1 && pcNum ==3) || (num==2 && pcNum==1) || (num==3 && pcNum==2))
		{
			result = "����� �¸��߽��ϴ�!";
		}
		
		else if((num==1 && pcNum ==2) || (num==2 && pcNum==3) || (num==3 && pcNum==1)){

			result = "��ǻ�Ͱ� �¸��߽��ϴ�!";
		}

		

		return result;
	}



}



public class Test102
{
	public static void main(String[] args)
	{
	RpsGame ob = new RpsGame();
	ob.input();
	String result = ob.resultCalc();
	System.out.println(result);
	}

}