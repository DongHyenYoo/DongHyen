/*===================================
Ŭ���� ���
-�߻� Ŭ����(abstract)
================================*/

/*
���赵�� �ϼ����� ���� Ŭ������ �߻� Ŭ������� �Ѵ�.

�̰͵� ������ ����� ���ؼ��� ������� Ŭ�����̴�.

�߻� Ŭ������
 ���� �ְ� ���ǰ� ���� �ϳ� �̻��� �޼ҵ�(�߻� �޼ҵ�)�� ������ Ŭ������
 ����Ŭ����(�ڽ� Ŭ����)���� �������̵� �� ������ ����Ǵ� �޼ҵ忡 ����
 �޸� ���� ���� �̸� ȣ�� ��ȹ�� �����α� ���� �����.

 ���� �� ����
 [��������������] abstract class Ŭ������
 {

	[��������������] abstract �ڷ��� �޼ҵ��([�Ű�����],...); 
	
	//�̰��� �߻�޼ҵ�� {}�� �����ʰ� �ٷ�;�� ���������̴�. ���ÿ� �ϴ� ��ɵ� ����.
	�̰��� �ϳ��� ����ִٸ� Ŭ�����տ� abstract�� �־���Ѵ�.
	�׷��� �� Ŭ������ ���� ��ü�� ������ �� ����.

	�� �߻�޼ҵ尡 ��� class�տ� abstract�� �ٿ� �߻�Ŭ������ �ɼ� �ִ�.
	�ٸ� �̶��� ��ü�� ������ �� ����.

	�ٸ� �� �߻�޼ҵ带 ��ӹ��� Ŭ�������� �߻� �޼ҵ带 �������̵� �ϰԵǸ�
	�ڽ�Ŭ������ ���̻� �߻� Ŭ������ �ƴϰ� �ȴ�.

	�ٸ� �߻� �޼ҵ带 �������̵� ���� �ʴ´ٸ� �ڽ�Ŭ������ �տ� abstract�� �ٿ�
	�߻� Ŭ�������� �˷����Ѵ�.

}

 Ư¡
  
 Ŭ������ ��� �ϳ� �̻��� �߻� �޼ҵ带 ������ ��
 �� Ŭ������ Ŭ���� �տ� abstract Ű���带 �ٿ�
 �߻� Ŭ������ ����ؾ� �ϸ�
 �߻� Ŭ������ ������ ���
 �ҿ����� ������ Ŭ�����̹Ƿ� ��ü�� ������ �� ����.
 �߻� �޼ҵ尡 �������� �ʴ� �߻� Ŭ����������
 ��ü�� ������ �� ���°��̴�.

 ��,�߻� Ŭ������ ���������� ������ �� ���� ������
 ����� ���ؼ��� �����ϸ�
 �߻� Ŭ������ ��ӹ��� ���� Ŭ����������
 �ݵ�� �߻� �޼ҵ带 �������̵�(������)�ؾ� �Ѵ�.

 abstract Ű�����
 Ŭ������ �޼ҵ忡���� ����� �� ������
 ��� ������ ���� ���������� ����� �� ����.


*/
abstract class SortInt115
{
	private int[] value;

	protected void sort(int[] value)
	{
		this.value = value;
		sorting();
	}

	protected abstract void sorting(); //�߻�޼ҵ�


	protected int dataLength()
	{
		return value.length;
	}

	protected final int compare(int i,int j)
	{
		int x = value[i];
		int y = value[j];

		if(x==y)
			return 0;
		else if(x>y)
			return 1;
		else
			return -1;
	}
	//final Ű��������� �ڽ�Ŭ�������� override �Ҽ�����.
	protected final void swap(int i, int j)
	{
		int temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}
}
public class Test115 extends SortInt115
{
	int i,j;

	static int[] data = {7,10,3,28,7};

	@Override
	protected void sorting()
	{
	
		for(i=0;i<dataLength()-1;i++)
		{
			for(j=i+1;j<dataLength();j++)
			{
				int a = compare(i,j);
				switch(a)
				{
					case 0: continue;
					case 1: swap(i,j);break;
					case -1: continue;	 
			}
		}


	}
}


	public static void main(String[] args)
	{

		System.out.print("Source Data : ");
		for(int n : data)
			System.out.print(n + " ");
		System.out.println();
		//sort(data);
		Test115 ob = new Test115();

		ob.sort(data); //non ����ƽ�̴ϱ� ��ü �������� �ȵ�;;

		System.out.print("Sorted Data : ");
		for(int n : data)
			System.out.print(n + " ");
		System.out.println();


	}


}