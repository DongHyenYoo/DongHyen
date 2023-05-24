/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
-Math Ŭ����
================================*/

/*
   java.util.Random Ŭ������

   ���� ������ ������ �߻����� �����ϴ� Ŭ�����̴�.
   MathŬ������ ���� �޼ҵ��� random() �޼ҵ嵵 ������ �����ϴ� �޼ҵ�������
   0.0~1.0������ �Ǽ� ���¸� �߻��ϰ� �ǹǷ�
   �ʿ��� ���� ������ ������ ������ ���ؼ��� �߰����� ������ �����ؾ� �Ѵ�.
   �׷��� �ڹٴ� ���� ������ ������ �߻������ִ�
   ���� Ŭ������ RandomŬ������ ������ ����
   */

  //�ζ� ��ȣ ����(���� �߻� ���α׷�)

  //���α׷��� ����Ǹ� �⺻������ �ζǸ�
  //5���� �����ϴ� ���α׷� ����


 //���� ��)
// 3 5 12 24 31 41
//1 2 8 36 41 42
//4 9 12 13 22 30
// 5 10 13 14 22 40
//22 31 36 40 43 44
import java.util.Random;
import java.util.Arrays;


class Lotto
{
	//�迭 ���� ���� �� �޸� �Ҵ� -> �ζ� ��ȣ�� ��Ƶ� �迭�� 6ĭ
	private int num[] = new int[6];
	//num = new int[6] �̰� �ȵȴ�... 


	Lotto()
	{
		num = new int[6];
	}

	//getter
	public int[] getNum()
	{
		return num;
	}

	public void start()
	{
		Random rd = new Random();


		int count=0; //������ ã�Ƽ� �ٽ� ���������� Ƚ��
		int n;
/*
		for(int i=0;i<num.length;i++)
			{

			num[i] = rd.nextInt(45)+1;

			for(int j=0;j<i;j++)

				if(num[j] == num[i])
				{
			num[j] = rd.nextInt(45)+1;
			count++;
				}
			}
		System.out.println(count);
		*/

		jump:

		while(count<6)
		{
			n = rd.nextInt(45)+1;

			for(int i=0;i<count;i++)
			{
				if(num[i]==n)
					continue jump;

			}
			num[count++] = n;

		}

		sorting();

	}


	private void sorting()
	{
		Arrays.sort(num);
	}
}

public class Test146
{
	public static void main(String[] args)
	{
		Lotto ob = new Lotto();


		for(int i=1;i<=5;i++)
		{
			ob.start();
			for(int j : ob.getNum())
			System.out.printf("%4d",j);

			System.out.println();
		}

		
		
		System.out.println();
	}
}