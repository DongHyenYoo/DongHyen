/*===================================
�����÷��� �����ӿ�ũ����
================================*/

//Vector v = new Vector();
//--�ȿ� ��ҵ��� ����ִ� Vector �ڷᱸ�� v ����

//������ �����ڿ� �������¸� �Է��Ѵٸ�
//Vector v = new Vector(8);
//--8���� �ʱ� elements �� ���� Vector �ڷᱸ�� v ����
//�� �ڷᱸ���� Ȱ���ϴ� ��������
//8���� ��� ä������ �Ǹ� �ڵ����� Ȯ������ش�.

//Vector v = new Vector(3,5);
// 3���� �ʱ�elements�� ���� Vecotr �ڷ� v ����
//�ڷᱸ���� Ȱ���ϴ� ��������
//3���� ��� ä������ �Ǹ� �ڵ����� 5���� �����ȴ�.

//���ʹ� ������ ��ҷμ� ������,�Ǽ���,���ڿ�,���� 
// ��Ƴ��� ���� ����������.
// ������ �������� Ȯ�� check�� �ذ��鼭 �ڷᱸ���� �ٷ�� �Ѵ�.
import java.util.Vector;
import java.util.Iterator;
class MyVector extends Vector<Object>//�����ϸ鼭 Vector Ŭ������ ����ؼ� ����
{
	//������
	MyVector()
	{
		
		//Vector(���� Ŭ����)�� �����ڸ� ȣ���Ұ�
		//super(); �� �ڵ����� ���Ե�
		//->Vector();
		super(1,1);
		//ù��° ���� = �־��� �뷮
		//�ι�° ���� = ������
		

	}

	void addInt(int i)
	{
		addElement(new Integer(i));
	}

	void addFloat(float f)
	{
		addElement(new Float(f));
	}
	void addString(String s)
	{
		addElement(s);
	}
	void addCharArray(char[] a)
	{
		addElement(a);
	}
	void addObject(Record rec)
	{
		addElement(rec);
	}
	
	void write()
	{
		/*
		Iterator<Object> vi = this.iterator(); //this�� MyVector��...
	
	while(vi.hasNext())
		{
		System.out.println(vi.next());
		}*/
      /*
		Object o;
		int length = size();

		System.out.println("���� ��� ���� : " + length);

		for(int i=0;i<length; i++)
		{
			o= elementAt(i);
			System.out.println(o);
		} //���� �ѰŶ� ����� ����.. Iterator���Ŷ� ����� ���� //�̷��� ���׹��� ���Ű��Ƽ� ���׸��̶�� ���� �����ϴ°�
		*/

		Object o;
		int length = size();

		System.out.println("���� ��� ���� : "+length);
		
		for(int i=0;i<length;i++)
		{
			o = elementAt(i);
			
			//instanceof ������
			//ó���ؾ� �ϴ� ����� ��ü Ÿ�� Ȯ��

			if(o instanceof char[])
			{
				//System.out.println("���ڹ迭 : " + o);
				//System.out.println("���ڹ迭 : "+o.toString());
				System.out.println("���ڹ迭 : " +String.copyValueOf((char[])o)); //char[]�� �ٿ�ĳ���� �Ѱ��̰� StringŬ������ static �޼ҵ��� copyValueOf��� ���ڿ� ���·� ���ڹ迭�� �̾Ƴ��ִ� �޼ҵ��̴�.
			}
			else if(o instanceof String)
			{
				System.out.println("���ڿ� : " + o);
			}
			else if(o instanceof Integer)
			{
				System.out.println("������ : " + o);
			}
			else if(o instanceof Float)
			{
				System.out.println("�Ǽ��� : " + o);
			}
			else
			{
				System.out.println("type Ȯ�� �Ұ�~!!!!");
			}

		}

	}

}

public class Test159
{
	public static void main(String[] args)
	{
		
		MyVector v = new MyVector();

		int digit = 5;
		float real = 3.14f;
		String s = new String("�ȳ��ϼ���");
		char[] letters = {'s','t','u','d','y'};

		v.addInt(digit);		//���� �ڷᱸ���� ���� ����
		v.addFloat(real);		//���� �ڷᱸ���� �Ǽ� ����
		v.addString(s);			//���� �ڷᱸ���� ���ڿ� ����
		v.addCharArray(letters);//���� �ڷᱸ���� ���� �迭 ����
		v.write();



		//Object ob = 10; �� ù��° 10�� Integer(10)���� ���� �ڽ��� �ѹ��Ͼ�� (Object)(Integer(10)���� ��ĳ������ �ѹ� �Ͼ�� �Ǵ°�
	}
}