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


import java.io.BufferedWriter;
import java.io.FileWriter;


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
			for(int i=0; i< 25; i++)
			System.out.println("");

			System.out.print("\t\t\t���ڸ� �Է����� ������");
			rcMenu();
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
	public static void ticketingCT() throws IOException
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

		int nummenu;
		int num;
		int stock=0;
		int price=0;
		int money=0;
		String menu="";

		do
		{
			System.out.print("���Ͻô� �޴��� ��ȣ�� �Է��� �ּ��� : ");
			nummenu = Integer.parseInt(br.readLine());
		}
		while (nummenu<1 || nummenu>3);

		//switch�� 1~3�ؼ� ������ �Ű������� ��ƾ��ҵ�

		if(nummenu==1) //�޴�,����,stock�� ��ƾ��Ѵ�.
		{
			SetData ob = ((SetData)Manager.hashMap.get(restName));
			menu = ob.getMenu1();
			price = ob.getPrice1();
			stock = ob.getStock1();
		}
		else if(nummenu==2) //�޴�,����,stock�� ��ƾ��Ѵ�.
		{
			SetData ob = ((SetData)Manager.hashMap.get(restName));
			menu = ob.getMenu2();
			price = ob.getPrice2();
			stock = ob.getStock2();
		}
		else if(nummenu==3) //�޴�,����,stock�� ��ƾ��Ѵ�.
		{
			SetData ob = ((SetData)Manager.hashMap.get(restName));
			menu = ob.getMenu3();
			price = ob.getPrice3();
			stock = ob.getStock3();
		}
		
		System.out.print(restName+"�� "+menu+"�� "+price+"��  "+"�Դϴ�."+"���� ����"+stock+"�Դϴ�.");

		do
		{
		System.out.print("\t\t\t���� �޴��� Ƽ�� ���� "+stock+"�Դϴ�. ������ �������ּ��� : ");
		num = Integer.parseInt(br.readLine());       //�Ŀ� �ش� �޴��� ��� �����ؾ��� ����
		}
		while (num>stock);
		
	
		do
		{
		System.out.print("\t\t\t������ ������ �ּ���: ");
		money = Integer.parseInt(br.readLine());     //�Ŀ� �ܰ�� �Ž������� �̿�Ǿ���� ����
		//�� �ݾ׺��� ���ų� ���� ������ �޾ƾ��Ѵ�.
		//�޾ƾ� �ϴ� ���� > �ܰ�+���İ���
		//if �ܰ� : 3000 ���� ���� : 48000  ���� ��: 100,000 �Ž����� :52000  

		}
		while (money<(num*price));//////////////////////////////////////////////////////////////////////////////////////money<=�ܰ�
		



		check(restName,menu,price,num,money,stock);

		// �޴�,����,���� �Է¹ޱ� 
	}















		/*
		��� Ű���� �ҷ����� ��
		Set<Integer> keySet = map.keySet();        
		for (Integer key : keySet)
			System.out.println(key + " : " + map.get(key));
		
		Set<String> keySet = Manager.hashMap.keySet();
		for(String key : keySet)

		//System.out.println(key+"�� ���1: "+((SetData)Manager.hashMap.get(key)).getStock1()+"���2: "+((SetData)Manager.hashMap.get(key)).getStock2()+"���3: "+((SetData)Manager.hashMap.get(key)).getStock3());
		//���� int��
		//�ҷ����� �Լ��� hashMap.get("�������̸�")getStock1~3
		*/
	public static void rankingRC()throws IOException //1.1.2 ���� ���� �ȸ��޴�
	{
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
		{						 //�迭������ �ƴϱ⿡ 3�������� �Է�������ҵ�
			temp1 = ((SetData)Manager.hashMap.get(key)).getStock1(); ++everymenu;
			temp2 = ((SetData)Manager.hashMap.get(key)).getStock2(); ++everymenu;
			temp3 = ((SetData)Manager.hashMap.get(key)).getStock3(); ++everymenu;
			
			if((temp1 == 10 && temp2== 10 && temp3== 10)==false)
				++count;			
			}

		if(count==0)//��� ��� 10�̶�� �ȳ��޼����� ���� �����޼ҵ� ȣ��
		{
			System.out.println("\t\t�Ǹŵ� �ı��� ���� �����ϴ�.");
			System.out.println("\t\t���� �޴��� �ǵ��ư��ϴ�.");
			rcMenu();
		}

		//�ǸŰ� �Ǿ������Ƿ� ���� �Ǿ���� �κ�
		//���Ĺ��
		//1.TreeSet �ߺ� �ȵǹǷ� �Ұ��� : �޴��̸��� ��������, ������ ��������, ��� ��������, �ð��� ���ٸ� �ߺ��� �����ʹ� �����ǹ���
		//2.������ ���� Comparator<T> �õ��� ������ ���� Arrays�� Comparable�� compare�޼ҵ�� ������ �����Ѵ�. API����
		//3.Setdata�� ��������� �����ڸ� 1.�Ű���������(������ �����̾����ִ�), 2.�Ű����� (����,�޴�,����,���)�� �޴� ������ ����
		//�غ����� ���İ������� ������ �򰥷��� ����
		//4.3.������ ���밴ü�� �ϳ��� ������ ���ù迭, �ϳ��� ������ ���밴ü������ �������ߴ½����� ���� ����� : ����
		//5.�ܺ�Ŭ������ SetData�� ����� Ŭ������ �����ϰ� Comparable �������̽� ����ؼ� CompareTo �޼ҵ� �������̵� 
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
		System.out.println("\t\t\t "+rdArr[i].getRestName()+"  "+rdArr[i].getMenu()+"  "+rdArr[i].getPrice()+"  "+rdArr[i].getTime()+"��");
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
		ticketing(rdArr[num-1].getRestName(),rdArr[num-1].getMenu(),rdArr[num-1].getPrice(),rdArr[num-1].getTime(),rdArr[num-1].getStock());
	}



	public static void ticketing(String restName, String menu, int price, int time,int stock)throws IOException
	{	//3�� ��õ �޼ҵ带 ��ġ���� �Ű������� �޴°� �����Ű���. �ÿ� = �ð������� �ᱹ �Ĵ�,�޴�,����,�ð��� �޾ƿ��� �Ǿ�����
																 //���� = ī�װ������� �ᱹ �Ĵ�,�޴�,����,�ð��� �޾ƿ��� �Ǿ�����
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
		System.out.print("\t\t\t �Ĵ��     �޴�    ����     �ð�\n");
		System.out.println("\t\t\t "+restName+"  "+menu+"  "+price+"  "+time+"��");
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		do
		{
		System.out.println("\t\t\t���� �޴��� Ƽ�� ���� "+stock+"�Դϴ�. ������ �������ּ��� : ");
		num = Integer.parseInt(br.readLine());       //�Ŀ� �ش� �޴��� ��� �����ؾ��� ����
		}
		while (num>stock);
		
		int money;
		do
		{
		System.out.print("\t\t\t������ ������ �ּ���: ");
		money = Integer.parseInt(br.readLine());     //�Ŀ� �ܰ�� �Ž������� �̿�Ǿ���� ����
		//�� �ݾ׺��� ���ų� ���� ������ �޾ƾ��Ѵ�.
		//�޾ƾ� �ϴ� ���� > �ܰ�+���İ���
		//if �ܰ� : 3000 ���� ���� : 48000  ���� ��: 100,000 �Ž����� :52000  

		}
		while (money<(num*price));//////////////////////////////////////////////////////////////////////////////////////money<=�ܰ�
		



		check(restName,menu,price,num,money,stock);
		//�����̰� ���� UI�� ������ �߱�����Ȯ��(check�޼ҵ�)������ �Ĵ�,����,�Է��� �߱ǰ���, ����*�߱ǰ���,���������� �ʿ��ϴ�.
	}


	public static void check(String restName, String menu, int price,int num, int money,int stock)throws IOException
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
		System.out.println("\t\t\t �Ĵ�� : "+restName);
		System.out.println("\t\t\t ���ĸ� : "+menu);
		System.out.println("\t\t\t ���� : "+num);
		System.out.println("\t\t\t �� �ݾ� : "+(num*price));
		System.out.println();
		System.out.println("\t\t\t ���� ���� : "+money);
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("��");
		System.out.println();
		System.out.println();
		
		System.out.println("\t\t\t���� �Ϸ�� ����� �� �����ϴ�.");
		char ch;
		do
		{
		System.out.print("\t\t\t�߱��Ͻðڽ��ϴ�? (Y/y)");
		ch = Character.toUpperCase((char)System.in.read());
		}
		while (ch!='Y');
		
		System.out.print("\t\t\tƼ���� �߱����Դϴ�...");
		inputResultoExcel(restName,menu,price,num,money);
		//���⼭ �ؽ��� �����ؼ� ��� ���ҽ�ų��?
	}




	private static void inputResultoExcel(String restName, String menu, int price,int num, int money)
	{
		//�����̰� �Ž����� �����ϰ� �ִٴ� ����ڰ� ���� ������ ������� ����

		if(((SetData)Manager.hashMap.get(restName)).getMenu1().equals(menu))
		{

			int change = ((SetData)Manager.hashMap.get(restName)).getStock1()-num;
			((SetData)Manager.hashMap.get(restName)).setStock1(change);
			System.out.println(((SetData)Manager.hashMap.get(restName)).getMenu1());
			System.out.println(((SetData)Manager.hashMap.get(restName)).getStock1());
			//
			//�������� ��� +num*price  �� �ؾߵȴ�.

		}

		else if(((SetData)Manager.hashMap.get(restName)).getMenu2().equals(menu))
		{
			int change = ((SetData)Manager.hashMap.get(restName)).getStock2()-num;
			((SetData)Manager.hashMap.get(restName)).setStock2(change);
			System.out.println(((SetData)Manager.hashMap.get(restName)).getMenu2());
			System.out.println(((SetData)Manager.hashMap.get(restName)).getStock2());
			//�������� ��� +num*price  �� �ؾߵȴ�.
		}
		
		else if(((SetData)Manager.hashMap.get(restName)).getMenu3().equals(menu))
		{
			int change = ((SetData)Manager.hashMap.get(restName)).getStock3()-num;
			((SetData)Manager.hashMap.get(restName)).setStock3(change);
			System.out.println(((SetData)Manager.hashMap.get(restName)).getMenu3());
			System.out.println(((SetData)Manager.hashMap.get(restName)).getStock3());
			//�������� ��� +num*price  �� �ؾߵȴ�.
		}

		String file= "C:\\Users\\USER\\Desktop\\Java_Semi\\RestInfo.csv";
		
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
		




	}

	public static void printResult(String restName, String menu, int price,int num, int money)
	{

	}

}