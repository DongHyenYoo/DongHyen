import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;


class RankData implements Comparable
{
   private String restName;
   private String menu;
   private int price;
   private int stock;
   private int time;

   public RankData(String restName, String menu, int price, int stock,int time)
	{
	   this.restName = restName;
	   this.menu = menu;
	   this.price = price;
	   this.stock = stock;
	   this.time = time;
	}
	
	public String getRestName() {
      return restName;
	}
	 public String getMenu() {
      return menu;
   }

	public int getPrice() {
     return price;
   }
	
	public int getStock() {
      return stock;
   }
   public int getTime(){
	   return time;
   }
  
	@Override
		public int compareTo(Object o1)
	{
		RankData ob1 = (RankData)o1;

		return this.getStock()-ob1.getStock();

	}

}


public class Machine
{

	
	// �ΰ� �� ���� ���� ȭ�� ��� �޼ҵ�
	public static void startMenu() throws IOException
	{

		HashMap<String,Object>hashTemp = new HashMap<String,Object>(Manager.hashMap);
		
		Manager.readerRestData(); //Hashmap�� ���� ������ ����
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t    �ƢƢ�   TODAY LUNCH   �ƢƢ� ");	
		System.out.println("\t\t\t==============================");
		System.out.println();


		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");
		System.out.println("\t\t\t��       1. Ƽ�� ����        ��");
		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num; 
		do
		{
			System.out.print("\t\t��ȣ ���� : ");
			num = br.readLine();
			if (num.equals("1"))
			{
				//Ƽ��
				buyTicket();
			}
			else if (num.equals("1234"))
			{
				Manager.userInterface();
			}
			
		}
		while (!num.equals("1"));
		
		
	}




	// 1. Ƽ�� ���� ȭ�� ��� �޼ҵ�
		public static void buyTicket() throws IOException
	{
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t        1. Ƽ�� ���� ");	
		System.out.println("\t\t\t==============================");
		System.out.println();

		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");
		
		System.out.println("\t\t\t��     1. �޴� ��õ�ޱ�      ��");
		System.out.println("\t\t\t��     2. �޴� �˻��ϱ�      ��");
		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num; 		
		do
		{
			System.out.print("\t\t��ȣ ���� : ");
			num = br.readLine();
			if (num.equals("1"))
			{
				//�޴���õ �ޱ�
				rcMenu();
			}
			else if (num.equals("2"))
			{
				//�޴� �˻�
				//searchRestaurant();
				System.out.print("�߰�����");
			}
		}
			while (!num.equals("1") && !num.equals("2"));
		}
	


	

	//1.2 ���� �޴� �˻�
	public static void searchRestaurant()
	{
		System.out.println("\t\t\t==========================================");
		System.out.println("\t\t\t\t\t���� �޴� �˻�");	
		System.out.println("\t\t\t==========================================");

		System.out.print("\t\t\t��");
		for(int i = 0; i < 39; i++) System.out.print("��");
		System.out.print("��\n ");
		
		System.out.println("\t\t\t��        ���� ����Ʈ �Ҷ��           ��");

		System.out.print("\t\t\t��");
		for(int i = 0; i < 39; i++) System.out.print("��");
		System.out.print("��\n");
	}
		



	









	public static void rcMenu() //1.1 �޴� ��õ �ޱ�
	{
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t        1. Ƽ�� ���� ");	
		System.out.println("\t\t\t==============================");
		System.out.println();

		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");
		
		System.out.println("\t\t\t��  1. ����� �Ÿ��� �Ĵ�    ��");
		System.out.println("\t\t\t��  2. ���� ���� �ȸ� �޴�   ��");
		System.out.println("\t\t\t��  3. ī�װ� �� �޴�      ��");
		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");

		System.out.println();
		System.out.println();
		
		try
		{

			int num; //�Է¹��� ����
		
		do
		{
			System.out.print("\t\t ��ȣ ����(1~3) : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			num = Integer.parseInt(br.readLine());
		}
		while (num<1 || num>3);
	
		switch (num)
		{
		case 1:  distanceRC(); break; //distanceRC();
		case 2:  rankingRC(); break;  //
		case 3:  categoryRC(); break;  //categoryRC();
		}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}





	public static void distanceRC() throws IOException
	{
		
		//1.1.1 ����� �Ÿ��� �Ĵ�
		System.out.println("\t\t\t==============================================");
		System.out.println("\t\t\t\t\t��ŷ �޴� ��õ");	
		System.out.println("\t\t\t==============================================");

		System.out.print("\t\t\t��");
		for(int i = 0; i < 39; i++) System.out.print("��");
		System.out.print("��\n");
		
		System.out.println("\t\t\t��         1. 5�� �Ÿ� �̳�              ��");
		System.out.println("\t\t\t��         2. 10�� �Ÿ� �̳�             ��");
		System.out.println("\t\t\t��         3. 15�� �Ÿ� �̳�             ��");
		System.out.print("\t\t\t��");
		for(int i = 0; i < 39; i++) System.out.print("��");
		System.out.print("��\n");

		//��ȣ �Է¹ޱ� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		
		do
		{
			System.out.print("\t\t\t��ȣ�� �Է��� �ּ��� : ");
			num = Integer.parseInt(br.readLine());
		}
		while (num < 1 || num > 3);

		//5��, 10��, 15�к� ȭ�� ����� ���� ������ ����
		if (num == 1)		
			num = 5;
		else if(num == 2)
			num = 10;
		else if(num == 3)
			num = 15;
		
		System.out.println("\t\t\t==============================================");
		System.out.printf("\t\t\t\t\t%d�� �Ÿ� �̳�\n ", num);	
		System.out.println("\t\t\t==============================================");					
		System.out.print("\t\t\t��");
		for(int i = 0; i < 43; i++) System.out.print("��");
		System.out.print("��\n");
		
		System.out.println("\t\t\t��     �Ĵ��\t�޴�\t  ����\t  �ð�\t        ��");
		System.out.println("\t\t\t��-------------------------------------------��");

		//Manager ������ �о����
		//Manager.readRestData();
		//��� Ű�� �ҷ����� : keySet() �޼ҵ�
		Set<String> keySet = Manager.hashMap.keySet();



		//Map<Integer> map = new (((SetData)Manager.hashMap.get(key)).getTime())<>();

		//Ű�� ������������
		//Set�� List�� ��ȯ
		//List<Integer> listTimeSet = new ArrayList<>(Manager.hashMap.values());
		//List ����

		// 
		Map<String,Integer> map = new HashMap<String,Integer>();
		

		for (String key:keySet )
		{
			map.put(key,(((SetData)Manager.hashMap.get(key)).getTime()));
		}
		List<String> listTime = new ArrayList<>(map.keySet());
		//������������
		Collections.sort(listTime,(value1,value2)->(map.get(value1).compareTo(map.get(value2))));



		/*
		//Map.Entry����Ʈ
		List<Entry<String,Integer>> entryList=new ArrayList<Entry<String,Integer>>(map.entrySet());
		//Comparatoe����� ����
		Collections.sort(entryList, new Comparator<Entry<String,Integer>>)()
		{
			public int compara(Entry<String,Integer>obj1,Entry<String,Integer>obj2)
			{
				return obj1.getValue().comparaTo(obj2.getValue());
			}
		}
		*/


		//1.1.1 �Ÿ��� ������ ���� ���(5�� / 10�� / 15��)
		for(String key : listTime)
		{
			if ((((SetData)Manager.hashMap.get(key)).getTime()) <= num )
			{								
				System.out.printf("\t\t\t��%s  \t%s  %d  %d��\t��\n", key,
						(((SetData)Manager.hashMap.get(key)).getMenu1()),
						(((SetData)Manager.hashMap.get(key)).getPrice1()),
						(((SetData)Manager.hashMap.get(key)).getTime()));
				System.out.printf("\t\t\t��\t\t%s  %d     %d��\t��\n", 
						(((SetData)Manager.hashMap.get(key)).getMenu2()),
						(((SetData)Manager.hashMap.get(key)).getPrice2()),
						(((SetData)Manager.hashMap.get(key)).getTime()));
				System.out.printf("\t\t\t��\t\t%s  %d     %d��\t��\n", 
						(((SetData)Manager.hashMap.get(key)).getMenu3()),
						(((SetData)Manager.hashMap.get(key)).getPrice3()),
						(((SetData)Manager.hashMap.get(key)).getTime()));			
			}
		}
		
		System.out.print("\t\t\t��");
		for(int i = 0; i < 43; i++) System.out.print("��");
		System.out.print("��\n");

		ticketingCT();

	}

	
	public static void categoryRC() throws IOException
	{

		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       ī�װ� ���� ");	
		System.out.println("\t\t\t==============================");
		System.out.println();

		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");
		System.out.println("\t\t\t��         �� �ѽ�           ��");
		System.out.println("\t\t\t��         �� �߽�           ��");
		System.out.println("\t\t\t��         �� �Ͻ�           ��");
		System.out.println("\t\t\t��         �� ���           ��");
		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");

		String ca;

		do
		{
			System.out.println();
			System.out.print("\t\t ī�װ� �Է� : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ca = br.readLine();
		}
		while (!ca.equals("�ѽ�") && !ca.equals("�߽�") && !ca.equals("�Ͻ�") && !ca.equals("���"));
		//ca!="�ѽ�" || ca!="�߽�" || ca!="�Ͻ�" || ca!="���"
		//!ca.equals("�ѽ�") || !ca.equals("�߽�") || !ca.equals("�Ͻ�") || !ca.equals("���")


		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.printf("\t\t\t       ī�װ� [ " + ca +" ] \n");	
		System.out.println("\t\t\t==============================");
		System.out.println();
		

		Set<String> keySet = Manager.hashMap.keySet();

		for(String key : keySet)
		{
			
			if ((((SetData)Manager.hashMap.get(key)).getCategory()).equals(ca))
			{
				//String menu=((SetData)Manager.hashMap.get(key)).getMenu1();
				System.out.print("\t\t\t��");
				for(int i = 0; i < 27; i++) System.out.print("��");
				System.out.print("��\n");
				System.out.printf("\t\t\t\t   ��%s\n",key);
				System.out.print("\t\t\t��");
				for(int i = 0; i < 27; i++) System.out.print("��");
				System.out.print("��\n");
				System.out.printf("\t\t\t  �޴�\t����\t�ð�(��)\n");
				System.out.println("\t\t\t------------------------------");
				System.out.printf("\t\t\t%s\t %s\t %s\n",((SetData)Manager.hashMap.get(key)).getMenu1()
									,((SetData)Manager.hashMap.get(key)).getPrice1()
									,((SetData)Manager.hashMap.get(key)).getTime());
				System.out.printf("\t\t\t%s\t %s \n",((SetData)Manager.hashMap.get(key)).getMenu2()
									,((SetData)Manager.hashMap.get(key)).getPrice2());
				System.out.printf("\t\t\t%s\t %s \n",((SetData)Manager.hashMap.get(key)).getMenu3()
									,((SetData)Manager.hashMap.get(key)).getPrice3());
				System.out.println();

			}
			
		}
		
		ticketingCT();
		

	}


	//Ƽ�Ϲ߱޸޼ҵ�
	public static void ticketingCT()throws IOException
	{
		
		
		Set<String> keySet = Manager.hashMap.keySet();
		//Set �� �迭
		//�迭�� ũ�⸦ 0���� �����ϸ� �ڵ����� �迭ũ�� ����
		//String[] keyArr = keySet.toArray(new String[0]);
		//�Ǵ°�

		
		
		String restName;		//�� restName�δ� �ȵ��� ��
		boolean result = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.print("\t\t\t�Ĵ���� �Է��ϼ��� : ");
			restName = br.readLine();
			//set�� ���Ȯ��
			result = keySet.contains(restName);
		}
		while (result==false); //key���� ��ġ����������?????


		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.printf("\t\t\t   "+restName+" Ƽ�� �߱� \n");	
		System.out.println("\t\t\t==============================");
		System.out.println();
		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");
		System.out.printf("\t\t\t\t��%s\n",restName);
		System.out.print("\t\t\t��");
		for(int i = 0; i < 27; i++) System.out.print("��");
		System.out.print("��\n");
		System.out.printf("\t\t\t  �޴�\t����\t����\n");
		System.out.println("\t\t\t------------------------------");


		//restName2�� ��ġ�ϴ� key���� value��������?
		//SetData key =(SetData)Manager.hashMap.get(restName2);
		//Object key =(SetData)Manager.hashMap.get(restName2);

		System.out.printf("\t\t\t1)%s\t %s\t %s\n",((SetData)Manager.hashMap.get(restName)).getMenu1()
							,((SetData)Manager.hashMap.get(restName)).getPrice1()
							,((SetData)Manager.hashMap.get(restName)).getStock1());
		System.out.printf("\t\t\t2)%s\t %s\t %s\n",((SetData)Manager.hashMap.get(restName)).getMenu2()
							,((SetData)Manager.hashMap.get(restName)).getPrice2()
							,((SetData)Manager.hashMap.get(restName)).getStock2());
		System.out.printf("\t\t\t3)%s\t %s\t %s\n",((SetData)Manager.hashMap.get(restName)).getMenu3()
							,((SetData)Manager.hashMap.get(restName)).getPrice3()
							,((SetData)Manager.hashMap.get(restName)).getStock3());
		System.out.println();

		String plus="";
		ArrayList<String> menuList = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		SetData ob = ((SetData)Manager.hashMap.get(restName));

		do
		{	String menu="";
			String su="";
			System.out.print("\t\t\t������ �޴��� ������ �Է�(���鱸��) : ");
			menu = sc.next();
			su = sc.next();
			if(menuList.contains(menu))
			{
				System.out.println("\t\t\t������ �޴��� �����Ǽ� �����ϴ� ������ �޴� ������ �߰����ּ���");
			}
			else if(menu.equals(ob.getMenu1()) && Integer.parseInt(su) > ob.getStock1())
			{
				System.out.println("\t\t\t����� ���� �����ϽǼ��� �����ϴ�");
			
			}
			else if(menu.equals(ob.getMenu2()) && Integer.parseInt(su) > ob.getStock2())
			{
				System.out.println("\t\t\t����� ���� �����ϽǼ��� �����ϴ�");
			
			}
			else if(menu.equals(ob.getMenu3()) && Integer.parseInt(su) > ob.getStock3())
			{
				System.out.println("\t\t\t����� ���� �����ϽǼ��� �����ϴ�");	
			}
			else
			{
			menuList.add(menu);
			menuList.add(su);
			}

			if(menuList.size()==6)
			 continue;
			System.out.print("\t\t\t�޴��� �� �����ðڽ��ϱ�? �ִ� 3���� �޴��� ������ �ֽ��ϴ�. (Y/N): ");
			plus = br.readLine();
			plus = plus.toUpperCase();
			menuList.trimToSize();
		}
		while (menuList.size() != 6 && !plus.equals("N"));

		String[][] menus = new String[menuList.size()/2][5];
		int money=0;
		int count=0;
		
		Iterator<String> it = menuList.iterator();
		//restName,�޴�,����,���,����

		while(it.hasNext()) //1���� 1���� 2���� 2���� ���� 3���� 3�� �迭�� �����ؾ� �ٵ� �� ����, �޴�,����,���
		{
			String i = it.next(); //�������� �޴��� ������

			if(i.equals(ob.getMenu1()))
			{
				menus[count][0] = restName;
				menus[count][1] = ob.getMenu1();
				menus[count][2]=  String.valueOf(ob.getPrice1());
				menus[count][3] = it.next(); //���԰���
				menus[count][4] = String.valueOf(ob.getStock1());
			}

			else if(i.equals(ob.getMenu2()))
			{
				menus[count][0] = restName;
				menus[count][1] = ob.getMenu2();
				menus[count][2]=  String.valueOf(ob.getPrice2());
				menus[count][3] = it.next();
				menus[count][4] = String.valueOf(ob.getStock2());
				
			}
			else if(i.equals(ob.getMenu3()))
			{
				menus[count][0] = restName;
				menus[count][1] = ob.getMenu3();
				menus[count][2]=  String.valueOf(ob.getPrice3());
				menus[count][3] = it.next();
				menus[count][4] = String.valueOf(ob.getStock3());
				
			}
				count++;
		}
/*
		for(int i=0;i<menus.length;i++)
		{
			for(int j=0;j<menus[i].length;j++)
			{
				System.out.printf("%7s",menus[i][j]);
			}
			System.out.println();
		}*/
		//���߿� ���ļ� ������  ���ƴ� �̹�

		//�� �ݾװ� ������ �ִ� ����
		int tot=0;

		for(int i=0;i<menus.length;i++)
		{
			for(int j=2;j<=2;j++)
			{
				tot += Integer.parseInt(menus[i][j]) * Integer.parseInt(menus[i][j+1]);			
			}
		}


		do
		{
		System.out.printf("\t\t\t�� %7d���Դϴ�.\n",tot);
		System.out.print("\t\t\t������ ������ �ּ���: ");
		money = Integer.parseInt(br.readLine());     //�Ŀ� �ܰ�� �Ž������� �̿�Ǿ���� ����
		//�� �ݾ׺��� ���ų� ���� ������ �޾ƾ��Ѵ�.
		//�޾ƾ� �ϴ� ���� > �ܰ�+���İ���
		}
		while (money<tot);

		checkCT(menus,money,tot);
		//tot�� money�� �������� ��Ʈ�� �𸣹Ƿ� ������ �ʿ��ϸ� �ٽ� ����
	}


	public static void checkCT(String[][] menus,int money,int tot)throws IOException ///�Ÿ���,ī�װ��� ��õ ���� �Ѿ���� ����â -> check()�� �̵��ؼ� ��������â
	{
		//Manager.readerRestData(); //�����ڰ� Ƽ�� ��� ä��� ���������Ϳ� ����ǹǷ� �ٽ� hashMap�� ������ ����
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       �Ĵ� Ƽ�� �߱�       ");
		System.out.println("\t\t\t==============================");
		System.out.println();
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		System.out.println("\t\t\t �Ĵ�� : "+menus[0][0]);
		System.out.println();
		for(int i=0;i<menus.length;i++)
		{
		System.out.println("\t\t\t ���ĸ� : "+menus[i][1]);
		System.out.println("\t\t\t ���� : "+Integer.parseInt(menus[i][3]));
		System.out.println();
		}
		System.out.println();
		System.out.println("\t\t\t �� �ݾ� : "+tot);
		System.out.println("\t\t\t ���� ���� : "+money);
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		System.out.println();
		/*menus[count][0] = restName;
				menus[count][1] = ob.getMenu1();
				menus[count][2]=  String.valueOf(ob.getPrice1());
				menus[count][3] = it.next(); //���԰���
				menus[count][4] = String.valueOf(ob.getStock1());
				*/
		System.out.println("\t\t\t���� �Ϸ�� ����� �� �����ϴ�.");
		
		String check = ""; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
		System.out.print("\t\t\t�߱��Ͻðڽ��ϱ�? (Y/N)");
		check = br.readLine();
		check = check.toUpperCase();
		}
		while (!check.equals("Y") && !check.equals("N"));
		
		if(check.equals("Y"))
		{
		System.out.print("\n\t\t\tƼ���� �߱����Դϴ�...");
		inputResultoExcel(menus,money,tot);
		}
		else if(check.equals("N"))
		{
		System.out.print("\n\t\t\t�˻�or��õȭ������ ���ư��ϴ�.");
			buyTicket();
		}	
	
	}




	public static void rankingRC()throws IOException //1.1.2 ���� ���� �ȸ��޴�
	{
		
		String dir = System.getProperty("user.dir");
		File file = new File(dir+"\\SellData.csv");
		String line=" ";
		int row=0;
		int column=0;
		List<String> list = new ArrayList<String>();
		String data="";
		
				

				

		//	System.out.println(Arrays.asList(aSD[0][aSD[0].length]).get(0));
			//System.out.println(Arrays.asList(aSD[0][aSD[0].length]).get(4));


			//List�� ������ε��� �� ��� ���� ������ �����Ǿ����� row��ŭ�� list ������ equals indexOf(0,1) �ؼ� ������ �ش� �ε�����ġ�� add�ϰ� List.removeAll(list)�ؼ� ���� 
		


		/*
		���ؼ� ��� 
		if((aSD[i][0].equals(aSD[j][0])) && (aSD[i][1].equals(aSD[j][1])))
					{

					}
		*/
				
		/*		
				for(int i=0;(line = br.readLine()) != null;i++)
			{
				for(int j=0;j<line.split(",").length;j++)          //line.split() = String[] ���� ��ȯ�ϹǷ� String[].length�� �ȴ�.
				{
				String[] lineTemp = line.split(",");
															//lineTemp �迭�� List<>���� �����Ѵ�. List���� �����ϸ� contains�޼ҵ带 ����� �� �ִ�.
				if(Arrays.asList(lineTemp).contains(menus[i][0]) && Arrays.asList(lineTemp).contains(menus[i][1]))   //lineTemp�迭�� List<>�ڷᱸ���� �����ϰ� SellData ������ �о�� lineTemp�� ����ڰ� �Է��� ���Ը�,�޴����� �����Ѵٸ� 
					{
						menus[i][3]+=lineTemp[3];
					}
				}
			}*/







		


		HashMap<String,Object> hashTemp = new HashMap<String,Object>(Manager.hashMap);
		 
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       ���� ���� �ȸ� �޴�  ");
		System.out.println("\t\t\t           1  ~  5 ��       ");
		System.out.println("\t\t\t==============================");
		System.out.println();
		


		Set<String> allkey = Manager.hashMap.keySet(); //��ü Ű�� ���� Set �ڷᱸ��
		int temp1,temp2,temp3;
		int count=0;
		int everymenu=0; //��ü �޴��� ������
		int m=0;
		int num;		
		
		
	
		for(String key : allkey) //��� ��� Ȯ�� 
		{						 //�迭������ �ƴϱ⿡ 3�������� �Է�������ҵ�  ///������ �غ��� �ٽ� �����
			temp1 = ((SetData)Manager.hashMap.get(key)).getStock1(); ++everymenu;
			temp2 = ((SetData)Manager.hashMap.get(key)).getStock2(); ++everymenu;
			temp3 = ((SetData)Manager.hashMap.get(key)).getStock3(); ++everymenu;
			
			}
		
		
		RankData[] rdArr = new RankData[everymenu]; 
		for(String key : allkey)
		{	
			SetData ob = ((SetData)Manager.hashMap.get(key));
			//�� ������ �޴��� 3�� 
			rdArr[m++]= new RankData(ob.getRestName(),ob.getMenu1(),ob.getPrice1(),ob.getStock1(),ob.getTime());
			rdArr[m++]= new RankData(ob.getRestName(),ob.getMenu2(),ob.getPrice2(),ob.getStock2(),ob.getTime());
			rdArr[m++]= new RankData(ob.getRestName(),ob.getMenu3(),ob.getPrice3(),ob.getStock3(),ob.getTime());

		}
		Arrays.sort(rdArr); //Arrays���� �������� compareTo ��� Ȯ��

		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		System.out.print("\t\t\t �Ĵ��     �޴�    ����     �ð�\n");  //�Ĵ��� �̸��� �޴��� �̸� �������� UI������ �ʹ� ���� ����� �ƴ��� �����
		for(int i=0;i<5;i++)
		System.out.println("\t\t\tTop"+(i+1)+")  "+rdArr[i].getRestName()+"  "+rdArr[i].getMenu()+"  "+rdArr[i].getPrice()+"  "+rdArr[i].getTime()+"��");
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		System.out.println();
		System.out.println();

		do
		{
		System.out.print("\t\t��ȣ�� ������ �ּ��� : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		}
		while (num <1 || num>5);
		//RankData�� ���Ƿ� ������ Ŭ�����̹Ƿ� ���⼭ ����� ����� �ҰͰ���.
		String[][]menus = new String[1][5];

		menus[0][0]= rdArr[num-1].getRestName();
		menus[0][1]= rdArr[num-1].getMenu();
		menus[0][2]= String.valueOf(rdArr[num-1].getPrice());
		menus[0][3]= ""; //���԰���
		menus[0][4]= String.valueOf(rdArr[num-1].getStock());

		ticketing(menus);
	}


	public static void ticketing(String[][] menus)throws IOException  //ī�װ� ��ŷ��õ���� �Ѿ���� ����â -> check()�� �̵��ؼ� ��������â
	{	
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       �Ĵ� Ƽ�� �߱�       ");
		System.out.println("\t\t\t==============================");
		System.out.println();
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		System.out.print("\t\t\t �Ĵ��     �޴�    ����     ���\n");
		System.out.println("\t\t\t "+menus[0][0]+"  "+menus[0][1]+"  "+menus[0][2]+"  "+menus[0][4]+"��");
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		do
		{
		System.out.print("\t\t���� �޴��� Ƽ�� ���� "+menus[0][4]+"�Դϴ�. ������ �������ּ��� : ");
		num = Integer.parseInt(br.readLine());       //�Ŀ� �ش� �޴��� ��� �����ؾ��� ����
		}
		while (num>Integer.parseInt(menus[0][4]));
		menus[0][3] = String.valueOf(num);


		int money;
		int tot = (Integer.parseInt(menus[0][3])*Integer.parseInt(menus[0][2]));
		do
		{
		System.out.print("\t\t������ ������ �ּ���: ");
		money = Integer.parseInt(br.readLine());     //�Ŀ� �ܰ�� �Ž������� �̿�Ǿ���� ����
		}
		while (money<tot);

		check(menus,money,tot);
		//�����̰� ���� UI�� ������ �߱�����Ȯ��(check�޼ҵ�)������ �Ĵ�,����,�Է��� �߱ǰ���, ����*�߱ǰ���,���������� �ʿ��ϴ�.
	}
	


	public static void check(String[][] menus,int money,int tot)throws IOException
	{
		Manager.readerRestData(); //�����ڰ� Ƽ�� ��� ä��� ���������Ϳ� ����ǹǷ� �ٽ� hashMap�� ������ ����
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       �Ĵ� Ƽ�� �߱�       ");
		System.out.println("\t\t\t==============================");
		System.out.println();
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		System.out.println("\t\t\t �Ĵ�� : "+menus[0][0]);
		System.out.println("\t\t\t ���ĸ� : "+menus[0][1]);
		System.out.println("\t\t\t ���� : "+menus[0][3]);
		System.out.println("\t\t\t �� �ݾ� : "+tot);
		System.out.println();
		System.out.println("\t\t\t ���� ���� : "+money);
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		System.out.println();
		
		System.out.println("\t\t���� �Ϸ�� ����� �� �����ϴ�.");
		String check = ""; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
		System.out.print("\t\t�߱��Ͻðڽ��ϱ�? (Y/N)");
		check = br.readLine();
		check = check.toUpperCase();
		}
		while (!check.equals("Y") && !check.equals("N"));
		
		if(check.equals("Y"))
		{
		System.out.print("\n\t\t\tƼ���� �߱����Դϴ�...");
		inputResultoExcel(menus,money,tot);
		}
		else if(check.equals("N"))
		{
		System.out.print("\n\t\t\t�˻�or��õȭ������ ���ư��ϴ�.");
			buyTicket();
		}
		
		//���⼭ �ؽ��� �����ؼ� ��� ���ҽ�ų��?
	}


	private static void inputResultoExcel(String[][] menus, int money, int tot)
	{
		//�� �޴��� �Ǹż����� �������̾���Ѵ�. �����ڿ��� ���ų� ����ڰ� ���ų� �ϸ� �ȵ� ���� �� �޼ҵ常�� �ǵ帱���ִ� �Ǹŵ� ���������� ���������� ������.
		String dir = System.getProperty("user.dir");
		File file = new File(dir+"\\SellData.csv");
		//�����͸� ���� String �迭... ���� ���ʿ� ������? 
		//menus = ���Ը�  �޴�  ����  �ȸ���
		

		//SellData�� ����
		//���Ը�  /  �޴�1  / ����1 /�Ǹŷ�  /
	
		/*menus �Ӽ�
				   0.���Ը�
				   1.�޴���
				   2.�ݾ�
				   3.���԰���
				   4.���*/ 
		try
		{	
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,false)); 
				
				//�׷� ��� �Ű������� ��ġ���Ѿߵǳ�...
				//�Ű����� ��ġ��Ŵ
				for(int i=0;i<menus.length;i++)
				{
					String writeSell="";

					for(int j=0;j<menus[i].length-1;j++)//���� ������ �����ʿ������ 
					{
						if(j==menus[i].length-2)
						{
						writeSell += menus[i][j];
						}
						else
							writeSell += menus[i][j]+",";
						
					}
					//���� �ȿ��� write�ϸ� ���� �ʳ�?...
					//System.out.print(writeSell);
					
					bw.write(writeSell);
					bw.write("\n");//����
					 
				}
				if(bw != null)
				{
					bw.flush();
					bw.close();
				}

			

			
			}
			catch (Exception e)
			{	
				e.printStackTrace();
			}
	}


		//�����̰� �Ž����� �����ϰ� �ִٴ� ����ڰ� ���� ������ ������� ����
/*
		if(((SetData)Manager.hashMap.get(restName)).getMenu1().equals(menu))
		{

			int change = ((SetData)Manager.hashMap.get(restName)).getStock1()-num;
			((SetData)Manager.hashMap.get(restName)).setStock1(change);
			//
			//�������� ��� +num*price  �� �ؾߵȴ�.

		}

		else if(((SetData)Manager.hashMap.get(restName)).getMenu2().equals(menu))
		{
			int change = ((SetData)Manager.hashMap.get(restName)).getStock2()-num;
			((SetData)Manager.hashMap.get(restName)).setStock2(change);
			//�������� ��� +num*price  �� �ؾߵȴ�.
		}
		
		else if(((SetData)Manager.hashMap.get(restName)).getMenu3().equals(menu))
		{
			int change = ((SetData)Manager.hashMap.get(restName)).getStock3()-num;
			((SetData)Manager.hashMap.get(restName)).setStock3(change);
			//�������� ��� +num*price  �� �ؾߵȴ�.
		}

		//String file= "C:\\Users\\USER\\Desktop\\Java_Semi\\RestInfo.csv";
		
		try
		{
			//BufferedWriter bw = new BufferedWriter(new FileWriter(file,false)); //�̾�Ⱑ �ƴ϶� ������̹Ƿ� false
																			//FileWriter = FileNotFound BufferedWriter = IOException ��� try-catch���°� ������
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//�ؽ��ʿ��� restName���� ��� ���� �ҷ��´��� compare Ȥ�� equals�� �̿��� int���� ���� ��� 0/true false �ΰ����ؼ� ���� ������ �����ͷ� ����� �̰� ���� if�� �ؾ��ҵ�
		//String�� join�̿��ؼ� �迭�� ��Ƶ״ٰ� ������ /Integer toString/ ���� ��ڽ� �ڽ��� Ȱ������ 

		//�ƴϸ� �ؽ��ʿ����� -�ϰ� �״�� ������� �ٵ� �迭�� �ƴ϶� ��¥�� equals�� ����ҵ�?... Ű���� �������� � �޴�,� ����,���� Ƽ���� �簬���� �˾Ƽ� �����ؾ��ϴ�...
		//�ƴϸ� �� �˰��򿡼� ��ü ��ü�� �Ѱ��ְ� �ϴ���...
		



*/
	}