//Ŭ������ �ν��Ͻ�
// Test071�� CircleTest.java���ϰ� ��Ʈ��

import java.io.IOException;

public class Test071
{
	public static void main(String[] args)throws IOException//main�̶�� �����ȿ��� br.readLine�� 
											//������ ���� main�̶�� ���� ������ br.readLine�� ������
											//circletest�� input������ br.readLine�� �������ص�
											//������ ������ ������ �ƴ� Test071�� main�ȿ� ������
											//�� �ȴ�.(Test071 ( input()))�̷����� Test071
											//�� ������ �ȿ� �ִ°Ŵ�.
	{

		CircleTest ct = new CircleTest();

		ct.input(); //�� ����ó���ؾߵǴ���
					//
		double round = ct.callRound();
		double area = ct.callArea();
		ct.print(area,round);

	}


}