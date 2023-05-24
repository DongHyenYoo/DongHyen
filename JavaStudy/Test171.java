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
  HashMap<key,value>Ŭ����
  -Hashtable Ŭ������ ���������� Map �������̽����� ��ӹ���
   HashMap Ŭ������ ����� Hashtable �� ����������
   Synchronization �� ���� ������ ���ü� ������ ���ٸ�
   (��, ��Ƽ ������ ���α׷��� �ƴ� �����) Multi Thread Unsafty
   HashMap�� ����ϴ°��� ������ ����ų�� �ִ�.

   -���� HashMap�� Hashtable Ŭ������ �޸� null�� ����Ѵ�.



*/
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test171
{
	public static void main(String[] args)throws IOException
	{
		//HashMap �ڷᱸ�� �ν��Ͻ� ����
		//HashMap<String, String>map = new HashMap<String,String>();
		Map<String,String> map = new HashMap<String,String>(); //HashMap�� Ŭ������ Map�� �������̽��̴�. �� �������̽� �����ڸ� �ҷ����°��� �ƴϹǷ� ��ü ���������ϴ�.
																//�������̽��� �����ڸ� �ҷ��� ��ü �����ϴ°� �ƴ��� ���
		

		//map �̶�� HashMap �ڷᱸ���� ��� �߰�
		// put();
		map.put("��ȭ","���˵���2");
		map.put("���","���¿�Ŭ��");
		map.put("��ȭ","������ũ");
		
		System.out.println(map);
		//{���=���¿�Ŭ��, ��ȭ=���˵���2, ��ȭ=������ũ} ���� ��� key�� value�� ���εǾ��ִ�.

		//������ ��� �ݳ� ������ �߰� ������ ���� ����
		//��¥�� key�� ���� �������̹Ƿ� ������ �ǹ̾��� �� �ڼ����� ����� ����.

		//null���� ó��
		//�Ʒ��� ������ �Է� ������ ���� ��� ������ ������ �Է��� ����������
		//������ null�� key�� ���ε� "�𳪸���"rk
		//���� null�� key�� �����ϴ� null�� ����� ��Ȳ�� �Ͼ��.
		//�� HashMap�� null�� �ϳ��� ������ key�� �����Ѵ�.


		map.put(null,null);
		System.out.println(map); //����Ȯ��
		

		//�׽�Ʈ(Ȯ��) -> ���� Ȯ��
		//{null=null, ���=���¿�Ŭ��, ��ȭ=���˵���2, ��ȭ=������ũ}

		//value �� null
		map.put("��ȭ",null);
		//�׽�Ʈ(Ȯ��) -> ���� Ȯ��
		System.out.println(map);
		//{null=null, ���=���¿�Ŭ��, ��ȭ=���˵���2, ��ȭ=null, ��ȭ=������ũ}

		//key�� null
		map.put(null,"�𳪸���");
		System.out.println(map);
		//{null=�𳪸���, ���=���¿�Ŭ��, ��ȭ=���˵���2, ��ȭ=null, ��ȭ=������ũ}2


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ī�װ�, Ÿ��Ʋ �Է�(�ĸ� ����) : ");
		String[] temp;
		for(String str; ((str = br.readLine()) != null);)
		{
			temp = str.split(",");
			if(temp.length<2)
			{
				System.out.print("ī�װ�,Ÿ��Ʋ �Է�");
				continue;
			}

		    map.put(temp[0].trim(), temp[1].trim());
			System.out.println(map);
			
		
		}

	}
}