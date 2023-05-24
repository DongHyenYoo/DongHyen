/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
StringBuffer Ŭ����
================================*/

/*
StringBufferŬ����

	���ڿ��� ó���ϴ� Ŭ������ String Ŭ�������� ��������
	String Ŭ������ ���� ���ڿ� �������� ������ �Ұ���������
	StringBuffer Ŭ������ ���ڿ��� ����� ��
	���� ���ڿ��� ���� �ܰ迡�� ������ �� �ִ�.

	��,StringBuffer ��ü�� �������� ���̸� �����Ƿ�
	��ü�� �����ϴ� �������� �̸� �� ũ�⳪ ���� �����ϰų�
	���� �������� ������ ũ�⸦ �ٲܼ� �ִ� ��� ����

	����JDK 1.5���ĺ��ʹ�
	���ڿ��� ó���ϴ� StringBuilder ��� Ŭ������ �����Ѵ�.
	StringBuilderŬ������ ����� StirngBuffer Ŭ������ ����������
	����ū �������� multi-thread unsafe��� ���̴�.
	�� Syncronization�� ���⿡
	StringBuffer���� ������ ���ü�(����ȭ) ������ ���ٸ�
	StringBuilder�� ����ϴ� ���� ������ ����ų�� �ִ�.
	
	thread : �۾����� ó���ϴ� ���� ���(����) 


	����� StringBuffer�� ����.
	Stirng builder�� ������ ����.

	mutil-tread safty(����ȭ ����� ���Ե�)�� �������� ����� ���ư��� �����ϴ� = ���ÿ� �� �ڿ��� ���ÿ� �̿��Ҽ� �ִ°�
	mutie-tread unsafe(����ȭ ����� ���Ե��� ����) �� �������� ����� ���ư��� �������� �ʴ�. = �� �ڿ��� ������ �������� �ٸ� thread�� �ڿ��� �̿��� �� ����

*/

public class Test138
{
	public static void main(String[] args)
	{
		
		String str1 = new String("seoul");
		String str2 = new String("seoul");
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));//���빰�� ũ����ϴ� ���̹Ƿ� true

		StringBuffer sb1 = new StringBuffer("korea");
		StringBuffer sb2 = new StringBuffer("korea");

		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2)); //false�� ����
		//�̸��� ������Ʈ�� equals�� ����� �����Ƿ� StringBuffer������ ObjectŬ������ equals�޼ҵ带 �������̵� ���� ������

		System.out.println("-----------------------------");

		System.out.println(sb1); //��µ� ���� ��Ʈ�����̱��ѵ�  StringBuffer ���ΰ��̴�.
		
		System.out.println(sb1.toString()); //toString �޼ҵ��� �ڷ����� �ٲܼ� �����Ƿ� String���� ����Ѱ�

		//System.out.println(b1.toString(). �̷����ϸ� ���ڿ� ��ü.~~~ �� �����Ƿ� StringŬ������ �޼ҵ带 �����ִ�.
		
		System.out.println(sb1.toString().equals(sb2.toString())); //String���۴� �̷��� ���ؾ��Ѵ�.


		System.out.println("-----------------------------");
		
		StringBuffer sb3 = new StringBuffer(); //�⺻������ ��Ʈ�����۰� ������ ũ��� 16�̴�.
		//StringBuffer �⺻ ������ ȣ��(��ü ��������)

		//capacity() ������ ũ�⸦ Ȯ���ϴ� �޼ҵ�
		System.out.println(sb3.capacity()); // �⺻���� 16

		System.out.println(sb3);
		//

		String name = "���̰�";
		name += "������";
		name += "�ֵ���";
		name += "�ӽÿ�";

		System.out.println(name);
		
		sb3.append("seoul"); //StringBuffer������ ���ڿ� �߰��ϱ�
		sb3.append("korea");
		sb3.append("�츮����");
		sb3.append("���ѹα�");
		
		System.out.println(sb3);
		System.out.println(sb3.toString());


		System.out.println(sb3.capacity());//34�� �þ���. �� ����ũ�Ⱑ �ڵ����� ����.

		String temp1 = "java and oracle";
		System.out.println(temp1.toUpperCase()); //���� �빮�ڷ� �ٲٴ°�
		
		String temp2 = "JAVA AND ORACLE";
		System.out.println(temp2.toLowerCase());//���� �ҹ��ڷ�

		//System.out.println(sb3.toUpperCase()); StringBuffer���� ����.
		//System.out.println(sb3.toLowerCase());
		
		String temp3 = sb3.toString(); //�̷��� ���ۿ� �ִ°� ����������


		System.out.println(sb3.toString().toUpperCase());
		System.out.println(sb3.toString().toLowerCase());


		//��� ���ڿ�(sb3) �� seoul �տ� "�ѱ�"�̶�� ���ڿ� �߰�
		
		sb3.insert(0,"�ѱ�"); //index(�߰��� ���ڿ� ��������),"�߰��� ���ڿ�"
		System.out.println("seoul �տ� �ѱ� �߰� : "+sb3.toString());

		//��� ���ڿ�(sb3)�� korea ���ڿ� �ڿ�
		//"���"�̶�� ���ڿ� �߰� 
		//�� ��� ���ڿ��� �ε����� ������ ���� Ȯ������ �ʰ�
		//
		
		System.out.println(sb3.indexOf("korea")); //��Ʈ������ Ŭ������ indexOf�޼ҵ尡 �����Ѵ�.
		
		//System.out.println(sb3.insert(sb3.indexOf("korea")+5,"���"));
		System.out.println(sb3.insert(sb3.indexOf("korea")+"korea".length(),"���"));
		//System.out.println(sb3.insert(sb3.lastIndexOf("korea"),"���"));
		
		//System.out.println(sb3.toString().lastIndexOf("korea"));
		
		
		//sb3.insert(7,"���");
		//System.out.println(sb3.toString());


		//sb3���� �츮���� ���ڿ��� �����ض�

		//System.out.println(sb3.toString().replaceAll("�츮����",""));
		
		//delete ����
		//sb3.delete(14,18);
		//System.out.println(sb3);
		

		sb3.delete(sb3.indexOf("�츮����"),sb3.indexOf("�츮����")+"�츮����".length());
		System.out.println(sb3);

		//sb3���� korea������ ���ڿ� ����

		sb3.delete(sb3.indexOf("korea"),sb3.length());
		System.out.println(sb3);
	

		///////////////////////
		
		System.out.println(sb3.capacity()); //����ũ�� ������ 34 
		//���۰� �ʿ信���� �þ�°��� �ڵ��̳� �ٿ��ִ°��� �ڵ��� �ƴϴ�.

		System.out.println("���ڿ����� :"+sb3.length());
		//7

		//����ũ������
		//���� ���ڿ��� ������ �ִ� ������ ũ��� ����
		//trimToSize()
		sb3.trimToSize();
		System.out.println(sb3.capacity()); //������ ũ�� 7�� ������



	}
}