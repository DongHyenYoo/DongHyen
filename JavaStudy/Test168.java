/*===================================
�����÷��� �����ӿ�ũ���� 
================================*/

//Set �� implements �ϴ� �͵��� -> HashSet, TreeSet
//���� ����.
//�ߺ��� ������� �ʴ� ����(�⺻)


/*
 HashSet<E> Ŭ����
  java.util.HashSet<E>Ŭ������
  Set�������̽��� �����ϴ� Ŭ������
  ������ ������ �ƴ϶� ������ �������� �����ؾ� �ϴ� �ڷᱸ���̴�.
  �̷� ���� �������� �ߺ��� ������� �ʴ´�.
  ����, ����ȭ�� �������� �ʴ´�.


*/

import java.util.Set;
import java.util.HashSet;

public class Test168
{
	public static void main(String[] args)
	{
		//Set ob = new Set(); //Set�� �������̽�
		Set<String> dog = new HashSet<String>();
		
		//dog��� Set �ڷᱸ���� ��� �߰�

		dog.add("���޶�Ͼ�");
		dog.add("��Ƽ��");
		dog.add("���");
		dog.add("������");
		dog.add("�ҵ�");

		//���� ������ Set ���
		System.out.print("���� ������ Set : ");
		for(String s : dog)
			System.out.print(s+ "  ");
		System.out.println();
		//������ �ǹ� ���� �ڷᱸ���̱� ������
		//������ �Է� ���� -> �ڷᱸ���� ��� �ݳ� ����
		//�̵��� ���� ������� �����Ǿ� �ִ� ���� Ȯ��

		//������(���) �߰�
		dog.add("��������");
		dog.add("ġ�Ϳ�");
		dog.add("�ú������㽺Ű");
		dog.add("�ú������㽺Ű");
		dog.add("�ú������㽺Ű");
		dog.add("��ư�׸���");
		
		for(String s : dog)
			System.out.print(s+ "  ");
		//�����Ͱ� �� ������ �ǹ̾���.
		//�����Ͱ� �߰��Ǵ� ������ ������� ����� �����Ǿ� ������
		//���� �����Ͱ� ������ �ݺ� �߰��� ���
		//�̵� �� �ϳ��� ��ȿ�� �����ͷ� �����Ǿ� �ִ� ���� Ȯ���� �� �ִ�.
		//�ƹ��� �߰��ص� �� ���� ��µ�

		//���� �ڷᱸ���� Ư����
		//�ߺ� �����͸� ������� �ʴ´ٰ� �ؼ�
		//�ߺ� �����͸� �߰��� ���
		//������ �߻��Ѵٴ� �ǹ̴� �ƴ϶�� �͵� Ȯ���� �� �ִ�.
		



	

	}
}