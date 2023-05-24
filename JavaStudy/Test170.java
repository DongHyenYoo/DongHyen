/*===================================
�����÷��� �����ӿ�ũ���� 
================================*/

//Map -> Hashtable, HashMap


/*

- java.util.Map �������̽���  //pair �� �׻� ¦���� �����Ѵ�.
  Ű(key)�� ��(value)�� ����(mapping)�Ͽ� 
  ������ Ű�� ����� �� ����, �����ؾ� �ϸ�,
  �� Ű�� �� ���� ������ �����ؾ��Ѵ�.
  ��, �ϳ��� Ű�� �����ϴ� �ϳ��� ���� ���� �ڷᱸ���̴�.
  
*/

/*
 - Hashtable<K,V> Ŭ���� <Key, Value>

   -�ؽ����̺� ������ ��ü ���� Ŭ������
     �˻��� �����ϱ� ������ ��� �󵵰� ���� �� ���Ѵ�.

   - �ؽ����̺��̶� Ű(key)�� �׿� �����ϴ� ������(value)��
     ���е� ������ �����̴�.

   - �����͸� �����ϰ�, �˻��ϱ� ���ؼ� Ű(key)�� �����ϸ�
     �̱��������� Ű ���� �ο��ϸ� �ش� �����Ͱ� ��ȯ�ȴ�.

   - ����, Hashtable Ŭ������ key �Ǵ� value�� ������ null�� ������� �ʴ´�.
*/

import java.util.Hashtable;
public class Test170
{
	private static final String[] names = {"������","������","�ֳ���","����","������","�ݺ���"};
	private static final String[] tels = {"010-7202-6306","010-2546-0266","010-7236-0813","010-4016-6208","010-4051-5510","010-3578-3912"};


	public static void main(String[] args)
	{
		//Hashtable �ڷᱸ�� �ν��Ͻ� ����
		Hashtable<String,String> ht = new Hashtable<String,String>();

		//ht ��� Hashtable �ڷᱸ����
		//�迭(names,tels)�� ����ִ� �����͸� ��ҷ� ��Ƴ���
		//put(key,value) �޼ҵ�;
		for(int i=0; i<names.length; i++)
		{
			ht.put(names[i],tels[i]);

		}

		//ht��� Hashtable �ڷᱸ������
		//key�� �̿��Ͽ� ������ �˻�
		//get(key);
		String findName1 = "������";
		String str = ht.get(findName1);
		if(str != null)
		{
		System.out.println(findName1+"�� ��ȭ��ȣ�� "+str);
		}
		else
			{
				System.out.println("�װǾ���");
			}
			System.out.println();

		//������ Hashtable �ڷᱸ���� key�� �����ϴ����� ���� Ȯ��
		//containsKey()
		String findName2 = "�ֵ���";
		if(ht.containsKey(findName2))
		{
			System.out.println("�����Ͱ� ����");
		}
		else
		{
			System.out.println("�ش��Ҵ� ������������");
		}
		//�ֵ��� �����Ͱ� �������� �ʽ��ϴ�.

		String findName3 = "�ֳ���";
		if(ht.containsKey(findName3))
		{
			System.out.println(findName3+"��(��)�����Ѵ�");
		}
		else
		{
			System.out.println("����");
		}

		//ht��� Hashtable �ڷᱸ����... value�� �����ϴ����� ���� Ȯ��
		//contains()
		String findTel1 = "010-3578-3912";
		if(ht.contains(findTel1))
		{
			System.out.println(findTel1 + "�����Ͱ� �����մϴ�.");
		}
		else
		{
			System.out.println(findTel1 + "�����Ͱ� �������� �ʽ��ϴ�.");
		}
		System.out.println();
		//010-2546-0266 �����Ͱ� �����մϴ�.

		//ht ��� Hashtable �ڷᱸ������ �ݺ��� ������ ����
		//remove()
		ht.remove("�ݺ���");
		//remove�޼ҵ�� ���ڰ����� key�� �Ѱܹ����� �̶� key�� ����Ǿ��ִ�(���εǾ��ִ�) value ���� �Բ� ��������.

		//���� ���� key�� �����ϴ��� Ȯ��
		if(ht.containsKey("�ݺ���"))
			System.out.println("�����̰� ����");
		else
			System.out.println("����");

		//���� ���� value���� �����ϴ��� Ȯ��
		
		if(ht.contains("010-3578-3912"))
			System.out.println("������ ��ȭ��ȣ ����");
		else
			System.out.println("�ƴ�");

		//null���� ó�� null = '�ƹ��͵� ���ٴ� ���� ���°�' �� �츮���󿡼����� '�������� �ʴ´�' �ʹ� �ٸ��ǹ� '������ ä�����ִٴ� ��'�̶�� �ǹ��ϸ� �ɵ�
		//ht.put(null,null); //key �� value ��� null�� ��
		//Exception in thread "main" java.lang.NullPointerException
		//at java.util.Hashtable.put(Hashtable.java:460)��Ÿ�� ���� �߻�
		
		//ht.put("������",null); //value�� null����
		//Exception in thread "main" java.lang.NullPointerException
		
		//ht.put(null,"010-1234-5678");
		////Exception in thread "main" java.lang.NullPointerException
		
		//�ߺ��� key �Է�
		ht.put("������","010-1222-2222"); //�׳� ����ǹ��ȴµ�

		System.out.println(ht.get("������"));
		//�׳� ����Ⱑ ���.
		//�� �ߺ��� key�� ����Ұ�� value ���� ����Ⱑ�ȴ�.

		//�ߺ��� value �Է�
		ht.put("���¹�","010-7202-6306");
		System.out.println(ht.get("������"));
		//�������� ��ȭ��ȣ�� �״�� ���´�.
		System.out.println(ht.get("���¹�"));
		//�¹����� ��ȭ��ȣ�� �״�γ��´�.
		//�� value�� �ߺ��� ���� �����Ϳ� �ƹ� ������ ��ġ���ʴ´�.
		
		



	}
}