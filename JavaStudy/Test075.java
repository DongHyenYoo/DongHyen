/*===================================
Ŭ������ �ν��Ͻ�
-������(Constructor)
================================*/

class NumberTest2
{
	int num;
	//����� ���� ������

	NumberTest2(int n)
	{

		num = n; //�����ڿ��� num�� ȣ����
		System.out.println("������ ȣ��� �Ű����� ���� : "+n);
	}

	int getNum(){

		return num;

	}
}

public class Test075
{

	public static void main(String[] args)
	{
		//NumberTest2 ob1 = new NumberTest2(); //�����ڸ� ȣ���ߴµ� int���� �Ű������� �����ʾ�  ������ ��
									//������ ����
									//NumberTest2 Ŭ��������
									//����� ���� �����ڰ� �����ϹǷ� ����Ʈ �����ڴ� �������� �ʰ�
									//����� ���� �����ڴ� �Ű������� ���� �����̱� ������
									//���� ���� �Ű����� ���� �����ڸ� ȣ���ϴ� ������ ������
									// ������ �߻���Ű�Եȴ�.

		NumberTest2 ob1 = new NumberTest2(10);

		System.out.println("����� �Է� ������"+ob1.num);
		System.out.println("����� �Է� ������"+ob1.getNum());

	}
}
