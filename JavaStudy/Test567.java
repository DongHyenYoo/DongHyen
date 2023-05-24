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
			System.out.print("이름,번호 공백구분");
			ob[i]= new Test567(sc.next(),sc.nextInt());
		}

		ht.put("카테고리",ob); //ob.name , ob.num 출력해보기

		for(int i=0;i<3;i++)
		{
			ob2=(Test567[])ht.get("카테고리");
			System.out.println(ob2[i].name+"  "+ob2[i].num);
		}


		
		
		
	}
}