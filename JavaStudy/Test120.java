/*===================================
Ŭ���� ����
�������̽�
================================*/

/*

Ŭ���� extends Ŭ����
Ŭ���� implements �������̽�

�������̽� extends �������̽�
�������̽� extends �������̽�,�������̽��������̽�

�߻�Ŭ���� implements �������̽�
�߻�Ŭ���� implements �������̽�,�������̽�

Ŭ���� implements �������̽�
Ŭ���� implemnts �������̽�,�������̽�,�������̽�

�������̽��� Ŭ�����ʹ� �޸� ���� ����� �����ϸ�
�������̽� ��ü�� ��ӵȴ�.

�������̽��� ��� ������ �����ʹ�
�������������ڸ� ������ �������� �ʴ��� �⺻ �����
public static final�� �����ڷ� �����ȴ�.
Ŭ�������� �������̽��� �߰��Ͽ�(implements)����� ���
�������̽� �ȿ��� ����� ��� �޼ҵ带 ������ �־�� �ϸ�
�������̽��� �����ϴ� Ŭ������
�������̽��� ���� �������̽��� �����ϴ� �߻� �޼ҵ带 ������
��� �޼ҵ带 �������� ���� ���
�߻�(abstract) Ŭ������ �����ؾ� �Ѵ�.

����
 - �������̽��� �޼ҵ带 ���� �ϰ� ���Ǵ� ����.
 -�������̽��� implements �� ��� �ݵ�� ���� Ŭ������
 -�������̽��� ��� �޼ҵ带 �������̵� �ؾ��Ѵ�.
 -�������̽��� �ڵ������� ������ ���� ó���Ѵ�.
  ��� ���� : public static final
  �޼ҵ� : public abstract


	�������̽��� ����

	�������̽��� Ŭ������ ���� ������ ������ �������� ������ ��
	�޼ҵ带 ���� �ϰ� ���� �Ҽ� ����
	���� Ŭ�������� �������� ���ϴ°Ͱ� �޸� �������̽������� ������
	���ó�� ���� �ٲ�� ���� ����� ���� �̸� �Ҵ��ؾ���

	�������̽��� ����

	�������̽��� Ŭ������ ���� ���ø��̱� ������
	��� ������ �������̽��� �Ǳ� ���ؼ���
	�ڹ� ���α׷����� �������̽��� ������ �־���ϴµ�
	�̷��� ����� �����ϴ� ���� implemnets �����


*/

interface ADemo
{
	public void write();
}
interface BDemo
{
	public void print();
}
interface CDemo extends ADemo,BDemo
{
	public void test();
}
//�߻�Ŭ����
///�� �������̽�AB �� ��ӹ��� �������̽�C�� ������ �߻� Ŭ����

//C�� AB�� �߻�޼ҵ带 ��� �������̵��� Ŭ����

class DemoImpl implements CDemo /
{
	@Override
		public void test()
	{
		System.out.println("test");
	}

	@Override
		public void write()
	{
		System.out.println("write");

	}
	@Override
		public void print()
	{
		System.out.println("print");
	}

}

public class Test120
{
	public static void main(String[] args)
	{

		//�� �������̽��� ��ӹ��� �������̽��� �����ϰ�
		//�ش� �������̽��� �޼ҵ� �� �ƴ϶�
		//��ӹ��� �������̽��� ��� �޼ҵ带 �������� Ŭ���� ����� �ν��Ͻ� ����
		DemoImpl ob = new DemoImpl();

		ob.test();
		ob.write();
		ob.print();

	}
}