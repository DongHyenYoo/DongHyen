/*=============================================
 ���� ��ü ����ȭ(Object Serialization) ����
=============================================*/

/*
 --��ü ����ȭ�� //�޸𸮿� �ִ� ��ü�� ��ȣ�� �ٿ� �ɰ��� �����ؼ� ��ȣ�� ���� �����Ҽ� �ְ�(������ȭ)����� ����
                 //01  12  23 34 �̷��� ����θ� ǥ���ؼ� �ɰ���.
				
				 
   �޸𸮿� ������ Ŭ���� ��ü�� ��� ������ ���� ���¸�
   �״�� �����ؼ� ���Ͽ� �����ϰų�
   ��Ʈ��ũ�� ���� ������ �� �ִ� �������
   ��� ������ ���� �����Ѵٰų�
   �ٸ� ��Ʈ��ũ�� �ִ� ȣ��Ʈ�� ���� ���� ��� ����ϰ� �ȴ�.

   �� ��ü ����ȭ�� ���빰�� ����Ʈ ������ ��ȯ�Ͽ�
   ���� �Ǵ� ��Ʈ��ũ�� ���� �ۼ���(��Ʈ��)�� �����ϰ�
   ������ִ� ������ �̶�, ��ü�� ��� ������ �޸𸮸����� ������ ���� ���Ѵ�.

   ����, �޼ҵ�� �����ڴ� ��ü ����ȭ�� ��󿡼� ���ܵȴ�.


 --��ü ����ȭ�� ����
   
   ��ü ��ü�� ������ ����� ���Ŀ� ���ֹ��� �ʰ�
   ��ü�� ���Ͽ� ���������ν� �������� �Ӽ��� ������ �� ������ �� �ʱ���¸� �����ϴ°��� �ƴ϶� ������ ���µ� ������ ���ִ�.
   ��ü ��ü�� ��Ʈ��ũ�� ���� �ս��� ��ȯ�� �� �ְԵȴ�.

   ��ü ����ȭ�� �ڹ� �ڹ� 1.1���Ŀ� ���ԵǾ��µ�
   �� ������ RMI�� Bean���� �̾���. RMI �տ��� System.out.exit(-1)

   RMI�� ���� ��ü ����� �����ؾ� �ϱ� ������
   ��ü�� �״�� �̵��� �� �־�� �Ѵ�.
   ���� �̸� �����ϱ� ���ؼ��� ��ü ����ȭ�� �ʼ����̾���.

   ���� Bean�� ����� ���¿� ���� ������ ������ ��
   �� ��ü ����ȭ�� ����ϸ� ���ϰ� ��ü ���¸� ������ �� �ִ�.

   --RMI(Remote Method Invocation)
   ���� �ٸ� ���� �����ġ�� �����ϴ� �Լ���
   ȣ���ϰ� �����ϴ� ����� ����Ѵ�.
   ���� �ٸ� ��� ������ ��ġ�� ������ ���� ��ü�� ����
   ��� ������ �����ϴ� ����

   --Bean (��Ģ/�Ծ�)�̴�.
   C/S������ �𵨿��� ������ ������ �ش��ϸ�
   ���� ������ ����Ʈ���� ��ü�� ���� �� �ְ� �ϴ� ������Ʈ ���.
   �ۼ��� ��ü�� ������ �����ϸ� ������Ʈ�� ���� ���Խ�ų �� �ֵ����Ѵ�.
   Ŭ���̾�Ʈ���� ���̶�� ���α׷� ������Ʈ�� �й��ϴ� ������� ó��


 --Serializable �������̽�

   ��ü ����ȭ�� �ϱ� ���� ���� ��ü ����ȭ�� �����ϵ���
   java.io.Serializable �������̽��� ������ �־�� �Ѵ�.
   �� �������̽��� ��ü ����ȭ�� �����Ǿ�� �Ѵٴ� �����
   JVM�� �˷��ִ� ������ �����Ѵ�.
   ����,Serializable �������̽���
   �ٸ� �������̽��� �޸� �����ؾ� �� �޼ҵ尡 ���� ������
   ���� ���� ���ָ� �ȴ�.

   ����)
   1)

   public class Ŭ������ implements Serializable
   {
   }

   2)
   Serializable �������̽��� ��������
   ObjectInputStream Ŭ������ ObjectOutputStream Ŭ������ �̿��Ͽ�
   ��ü ������ ������� �����ϰ� �ȴ�.

   --��� ������ static ���� ����� ���
   (��, Ŭ���� ������ ���)
   ��ü ����ȭ�� ��󿡼� ���ܵȴ�.


   --Object Stream

   java.io.ObjectInputStream
   ObjectInputStream Ŭ������ ObjectOutputStream Ŭ������ ����
   ����Ʈ������� ��/����ϴ� ��Ʈ���� ��ü�� �ø��� �ִ�.

   ���Ͽ� ����Ǿ� �ִ� ��ü�� ��Ʈ��ũ�� ���� ���޵� ��ü��
   ����ȭ�� �����ϴ� ����� �����Ѵ�.
   ��, java.io.Serializable �������̽���
   java.io.Externalizable �������̽��� �������ִ� ��ü�� ���ؼ���
   ����� �����ϴ�
   ��,Serializable �������̽��� Externalizable �������̽���
   ������ ��ü������ ����� �����ϴٴ� ���̴�.
   �̶�, readObject()�޼ҵ带 �̿��Ͽ�
   ��Ʈ�����κ��� ����ȭ�� ��ü�� ���� �� ������

   �̷��� ���� ��ü�� �迭, ���ڿ� �Ǵ� �� ��ü ��
   ������ ��(Type)���� ĳ���� ���־���Ѵ�.(Object������ �ö����� ������� �ٿ�ĳ����������Ѵ�.)
*/
import java.io.File;
import java.util.Hashtable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Enumeration; //���⼭ Iterator�� �������Ѵ�.



public class Test177
{
	public static void main(String[] args)throws Exception //���͸��� �������������� �Ҿ����ϴٰ� �����ϴ� �ڹٰ� ����ó���� �䱸
	{
		String appDir = System.getProperty("user.dir");
		//System.out.println(appDir);
		//C:\JavaStudy ���� Test177������ ��� �ִ°�.

		//���� ��ü ����
		File f0 = new File(appDir,"\\data\\test.ser");
		//appDir: C:\JavaStudy 
		//appDir ��ġ�� �������� \\data\\test.ser ��
		//�����ϰڴٴ� �ǹ�
		//��������� C:\JavaStudy\data\test.ser�� �����ϰڴٴ� �ǹ�
		//""�ȿ����� \\ = \�̴�.

		//System.out.println(f0.getParentFile().exists());
		//�θ���� C:\JavaStudy\data �̹Ƿ� �� C:\JavaStudy\data�� �����ϴ°���� �����
		//false
		//test.ser������ ������� ���͸� ��ΰ� �����Ǿ� ���� �ʴ�.

		//C:\JavaStudy��ġ�� data ���͸� ������ �ٽ� Ȯ��

		//System.out.println(f0.getParentFile().exists());
		//true �� ���Դ�.

		if(!f0.getParentFile().exists())
		{
			//���͸� ����ڴ�.
			f0.getParentFile().mkdirs(); 
		}
		Hashtable<Integer,String>h1 = new Hashtable<Integer,String>();
		//��ü ����ȭ�� ������ ������� �ʱ⿡ map�ڷᱸ���� �ַ� ����.
		
		//������ h1�̶�� Hashtable �ڷᱸ���� ��� �߰�

		h1.put(2206428,"���ҿ�");
		h1.put(2206436,"������");
		h1.put(2206512,"�ӽÿ�");
		h1.put(2206524,"������");
		h1.put(2206537,"������");

		//�׽�Ʈ
		//System.out.print(h1.get("2206524"));

		//���� ���� ��� ��Ʈ�� ����
		FileOutputStream fos = new FileOutputStream(f0);

		//���� ���� ��� ��Ʈ����
		//f0�̶�� ���� ��ü�� ����.
		//InputStreamReader isr = new InputStreamReader(System.in);

		//��ü ���� ��� ��Ʈ�� ����
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//��ü ���� ��� ��Ʈ������ fos��� �������� ��� ��Ʈ���� ���ΰڴ�.
		//BufferedReader br = new BufferedReader(isr) �� ����.

		//���� line 152 ~159�� ������ ����
		//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f0));
		//�� ����. �� ���������� ������ ����

		//ObjectOutputStream Ŭ������
		//��ü���� ����ϴ� ����� �����ϴ� Ŭ������
		//��� ��Ʈ���� ����ϱ� ����
		//���������� ��ü ����ȭ�� �����ϰ� �ȴ�.
		//�ڹ� �⺻�� ������ �Ǵ� ��ü����
		//���Ͽ� �����ϰų� ��Ʈ��ũ�� ���� �����ϱ� ����
		//������ ��ü�� ����ȭ�ϴ� ����� �����ϴ� ���̴�.

		//������ ��Ʈ���� ������ ��ü�� ���
		oos.writeObject(h1);
		//out.write(ch);�� ���� ������ ���� 


		//��ü ���� ���ҽ� �ݳ�
		
		oos.close();
		//ObjectOutputStream ���ҽ� �ݳ�

		//���� ���� ���ҽ� �ݳ�
		fos.close();
		//FileOutputStream ���ҽ� �ݳ�

		//(��ü�� ����ȭ�Ͽ� ���Ϸ�) �������� ��

		//(��ü�� ����ȭ�Ͽ� ������ ����)�о���̱� ����

		if(f0.exists())
		{
			//f0������ ���� �Է� ��Ʈ��(fis, FileInputStream)���� �о���̰�
			FileInputStream fis = new FileInputStream(f0);

			//fis ���� �Է� ��Ʈ�����κ��� ��ü �Է� ��Ʈ���� ����
			ObjectInputStream ois = new ObjectInputStream(fis);

			//��ü �Է� ��Ʈ��(oos, ObjectInputStream)���� ���� �о���� ��ü(Object)��
			//ĳ����(Hashtable)�Ͽ� 
			//h2��� Hashtable �ڷᱸ���� ��Ƴ���
			//Object obj = ois.readObject();
			Hashtable h2 = (Hashtable)ois.readObject();

			ois.close();

			fis.close();

			//�о���̱� ��--------------------------
		//�о���� h2��ü ���� Ȯ��

		int key;
		String value;

		//Iterator��� �Ұ�

		Enumeration e = h2.keys();

		while(e.hasMoreElements())
		{
			key = (int)e.nextElement();
			//Hashtable �ڷᱸ���� ������� key���� �о���̴� ����

		//System.out.println(key);

		value = (String)h2.get(key);
		//Hashtable�ڷᱸ���� ������� key�� Ȱ���Ͽ� value�� ���� ����

		System.out.println(key+" -> "+ value);


		}
		
		}
		
	}
} 
