import java.util.Hashtable;
import java.util.Scanner;

public class Test567
{
	private int num;
	private String name;
	

	Test567(String name, int num)
	{
		this.num = num;
		this.name = name;

	}
	

	public static void main(String[] args)
	{
		Hashtable<String,Object[]> ht = new Hashtable<String,Object[]>();
		Scanner sc = new Scanner(System.in);
		
		Test567[] ob2  = new Test567[3];

		Test567[] ob = new Test567[3];

		for(int i=0;i<3;i++)
		{
			System.out.print("�̸�,��ȣ ���鱸��");
			ob[i]= new Test567(sc.next(),sc.nextInt());
		}

		ht.put("ī�װ�",ob); //ob.name , ob.num ����غ���

		for(int i=0;i<3;i++)
		{
			ob2=(Test567[])ht.get("ī�װ�");
			System.out.println(ob2[i].name+"  "+ob2[i].num);
		}


		
		
		
	}
}