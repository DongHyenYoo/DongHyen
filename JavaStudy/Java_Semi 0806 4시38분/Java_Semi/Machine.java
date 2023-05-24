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

	
	// 로고 및 메인 선택 화면 출력 메소드
	public static void startMenu() throws IOException
	{

		HashMap<String,Object>hashTemp = new HashMap<String,Object>(Manager.hashMap);
		
		Manager.readerRestData(); //Hashmap에 엑셀 데이터 저장
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t    ▒▒▒   TODAY LUNCH   ▒▒▒ ");	
		System.out.println("\t\t\t==============================");
		System.out.println();


		System.out.print("\t\t\t┌");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┐\n");
		System.out.println("\t\t\t│       1. 티켓 구매        │");
		System.out.print("\t\t\t└");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┘\n");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num; 
		do
		{
			System.out.print("\t\t번호 선택 : ");
			num = br.readLine();
			if (num.equals("1"))
			{
				//티켓
				buyTicket();
			}
			else if (num.equals("1234"))
			{
				Manager.userInterface();
			}
			
		}
		while (!num.equals("1"));
		
		
	}




	// 1. 티켓 구매 화면 출력 메소드
		public static void buyTicket() throws IOException
	{
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t        1. 티켓 구매 ");	
		System.out.println("\t\t\t==============================");
		System.out.println();

		System.out.print("\t\t\t┌");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┐\n");
		
		System.out.println("\t\t\t│     1. 메뉴 추천받기      │");
		System.out.println("\t\t\t│     2. 메뉴 검색하기      │");
		System.out.print("\t\t\t└");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┘\n");

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num; 		
		do
		{
			System.out.print("\t\t번호 선택 : ");
			num = br.readLine();
			if (num.equals("1"))
			{
				//메뉴추천 받기
				rcMenu();
			}
			else if (num.equals("2"))
			{
				//메뉴 검색
				//searchRestaurant();
				System.out.print("추가예정");
			}
		}
			while (!num.equals("1") && !num.equals("2"));
		}
	


	

	//1.2 음식 메뉴 검색
	public static void searchRestaurant()
	{
		System.out.println("\t\t\t==========================================");
		System.out.println("\t\t\t\t\t직접 메뉴 검색");	
		System.out.println("\t\t\t==========================================");

		System.out.print("\t\t\t┌");
		for(int i = 0; i < 39; i++) System.out.print("─");
		System.out.print("┐\n ");
		
		System.out.println("\t\t\t│        가게 리스트 촤라락           │");

		System.out.print("\t\t\t└");
		for(int i = 0; i < 39; i++) System.out.print("─");
		System.out.print("┘\n");
	}
		



	









	public static void rcMenu() //1.1 메뉴 추천 받기
	{
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t        1. 티켓 구매 ");	
		System.out.println("\t\t\t==============================");
		System.out.println();

		System.out.print("\t\t\t┌");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┐\n");
		
		System.out.println("\t\t\t│  1. 가까운 거리의 식당    │");
		System.out.println("\t\t\t│  2. 제일 많이 팔린 메뉴   │");
		System.out.println("\t\t\t│  3. 카테고리 별 메뉴      │");
		System.out.print("\t\t\t└");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┘\n");

		System.out.println();
		System.out.println();
		
		try
		{

			int num; //입력받을 숫자
		
		do
		{
			System.out.print("\t\t 번호 선택(1~3) : ");
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
		
		//1.1.1 가까운 거리의 식당
		System.out.println("\t\t\t==============================================");
		System.out.println("\t\t\t\t\t랭킹 메뉴 추천");	
		System.out.println("\t\t\t==============================================");

		System.out.print("\t\t\t┌");
		for(int i = 0; i < 39; i++) System.out.print("─");
		System.out.print("┐\n");
		
		System.out.println("\t\t\t│         1. 5분 거리 이내              │");
		System.out.println("\t\t\t│         2. 10분 거리 이내             │");
		System.out.println("\t\t\t│         3. 15분 거리 이내             │");
		System.out.print("\t\t\t└");
		for(int i = 0; i < 39; i++) System.out.print("─");
		System.out.print("┘\n");

		//번호 입력받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		
		do
		{
			System.out.print("\t\t\t번호를 입력해 주세요 : ");
			num = Integer.parseInt(br.readLine());
		}
		while (num < 1 || num > 3);

		//5분, 10분, 15분별 화면 출력을 위한 변수값 설정
		if (num == 1)		
			num = 5;
		else if(num == 2)
			num = 10;
		else if(num == 3)
			num = 15;
		
		System.out.println("\t\t\t==============================================");
		System.out.printf("\t\t\t\t\t%d분 거리 이내\n ", num);	
		System.out.println("\t\t\t==============================================");					
		System.out.print("\t\t\t┌");
		for(int i = 0; i < 43; i++) System.out.print("─");
		System.out.print("┐\n");
		
		System.out.println("\t\t\t│     식당명\t메뉴\t  가격\t  시간\t        │");
		System.out.println("\t\t\t│-------------------------------------------│");

		//Manager 데이터 읽어오기
		//Manager.readRestData();
		//모든 키값 불러오기 : keySet() 메소드
		Set<String> keySet = Manager.hashMap.keySet();



		//Map<Integer> map = new (((SetData)Manager.hashMap.get(key)).getTime())<>();

		//키값 오름차순정렬
		//Set을 List로 변환
		//List<Integer> listTimeSet = new ArrayList<>(Manager.hashMap.values());
		//List 정렬

		// 
		Map<String,Integer> map = new HashMap<String,Integer>();
		

		for (String key:keySet )
		{
			map.put(key,(((SetData)Manager.hashMap.get(key)).getTime()));
		}
		List<String> listTime = new ArrayList<>(map.keySet());
		//오름차순정렬
		Collections.sort(listTime,(value1,value2)->(map.get(value1).compareTo(map.get(value2))));



		/*
		//Map.Entry리스트
		List<Entry<String,Integer>> entryList=new ArrayList<Entry<String,Integer>>(map.entrySet());
		//Comparatoe사용해 정렬
		Collections.sort(entryList, new Comparator<Entry<String,Integer>>)()
		{
			public int compara(Entry<String,Integer>obj1,Entry<String,Integer>obj2)
			{
				return obj1.getValue().comparaTo(obj2.getValue());
			}
		}
		*/


		//1.1.1 거리별 음식점 정보 출력(5분 / 10분 / 15분)
		for(String key : listTime)
		{
			if ((((SetData)Manager.hashMap.get(key)).getTime()) <= num )
			{								
				System.out.printf("\t\t\t│%s  \t%s  %d  %d분\t│\n", key,
						(((SetData)Manager.hashMap.get(key)).getMenu1()),
						(((SetData)Manager.hashMap.get(key)).getPrice1()),
						(((SetData)Manager.hashMap.get(key)).getTime()));
				System.out.printf("\t\t\t│\t\t%s  %d     %d분\t│\n", 
						(((SetData)Manager.hashMap.get(key)).getMenu2()),
						(((SetData)Manager.hashMap.get(key)).getPrice2()),
						(((SetData)Manager.hashMap.get(key)).getTime()));
				System.out.printf("\t\t\t│\t\t%s  %d     %d분\t│\n", 
						(((SetData)Manager.hashMap.get(key)).getMenu3()),
						(((SetData)Manager.hashMap.get(key)).getPrice3()),
						(((SetData)Manager.hashMap.get(key)).getTime()));			
			}
		}
		
		System.out.print("\t\t\t└");
		for(int i = 0; i < 43; i++) System.out.print("─");
		System.out.print("┘\n");

		ticketingCT();

	}

	
	public static void categoryRC() throws IOException
	{

		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       카테고리 선택 ");	
		System.out.println("\t\t\t==============================");
		System.out.println();

		System.out.print("\t\t\t┌");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┐\n");
		System.out.println("\t\t\t│         ○ 한식           │");
		System.out.println("\t\t\t│         ○ 중식           │");
		System.out.println("\t\t\t│         ○ 일식           │");
		System.out.println("\t\t\t│         ○ 양식           │");
		System.out.print("\t\t\t└");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┘\n");

		String ca;

		do
		{
			System.out.println();
			System.out.print("\t\t 카테고리 입력 : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ca = br.readLine();
		}
		while (!ca.equals("한식") && !ca.equals("중식") && !ca.equals("일식") && !ca.equals("양식"));
		//ca!="한식" || ca!="중식" || ca!="일식" || ca!="양식"
		//!ca.equals("한식") || !ca.equals("중식") || !ca.equals("일식") || !ca.equals("양식")


		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.printf("\t\t\t       카테고리 [ " + ca +" ] \n");	
		System.out.println("\t\t\t==============================");
		System.out.println();
		

		Set<String> keySet = Manager.hashMap.keySet();

		for(String key : keySet)
		{
			
			if ((((SetData)Manager.hashMap.get(key)).getCategory()).equals(ca))
			{
				//String menu=((SetData)Manager.hashMap.get(key)).getMenu1();
				System.out.print("\t\t\t┌");
				for(int i = 0; i < 27; i++) System.out.print("─");
				System.out.print("┐\n");
				System.out.printf("\t\t\t\t   ◎%s\n",key);
				System.out.print("\t\t\t└");
				for(int i = 0; i < 27; i++) System.out.print("─");
				System.out.print("┘\n");
				System.out.printf("\t\t\t  메뉴\t가격\t시간(분)\n");
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


	//티켓발급메소드
	public static void ticketingCT()throws IOException
	{
		
		
		Set<String> keySet = Manager.hashMap.keySet();
		//Set → 배열
		//배열의 크기를 0으로 설정하면 자동으로 배열크기 지정
		//String[] keyArr = keySet.toArray(new String[0]);
		//되는고만

		
		
		String restName;		//왜 restName로는 안되지 ㅜ
		boolean result = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.print("\t\t\t식당명을 입력하세요 : ");
			restName = br.readLine();
			//set에 요소확인
			result = keySet.contains(restName);
		}
		while (result==false); //key값과 일치하지않을때?????


		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.printf("\t\t\t   "+restName+" 티켓 발급 \n");	
		System.out.println("\t\t\t==============================");
		System.out.println();
		System.out.print("\t\t\t┌");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┐\n");
		System.out.printf("\t\t\t\t◎%s\n",restName);
		System.out.print("\t\t\t└");
		for(int i = 0; i < 27; i++) System.out.print("─");
		System.out.print("┘\n");
		System.out.printf("\t\t\t  메뉴\t가격\t수량\n");
		System.out.println("\t\t\t------------------------------");


		//restName2랑 일치하는 key값의 value가져오기?
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
			System.out.print("\t\t\t구입할 메뉴와 개수를 입력(공백구분) : ");
			menu = sc.next();
			su = sc.next();
			if(menuList.contains(menu))
			{
				System.out.println("\t\t\t동일한 메뉴는 담으실수 없습니다 결제전 메뉴 개수를 추가해주세요");
			}
			else if(menu.equals(ob.getMenu1()) && Integer.parseInt(su) > ob.getStock1())
			{
				System.out.println("\t\t\t재고보다 많이 구매하실수는 없습니다");
			
			}
			else if(menu.equals(ob.getMenu2()) && Integer.parseInt(su) > ob.getStock2())
			{
				System.out.println("\t\t\t재고보다 많이 구매하실수는 없습니다");
			
			}
			else if(menu.equals(ob.getMenu3()) && Integer.parseInt(su) > ob.getStock3())
			{
				System.out.println("\t\t\t재고보다 많이 구매하실수는 없습니다");	
			}
			else
			{
			menuList.add(menu);
			menuList.add(su);
			}

			if(menuList.size()==6)
			 continue;
			System.out.print("\t\t\t메뉴를 더 담으시겠습니까? 최대 3개의 메뉴를 담을수 있습니다. (Y/N): ");
			plus = br.readLine();
			plus = plus.toUpperCase();
			menuList.trimToSize();
		}
		while (menuList.size() != 6 && !plus.equals("N"));

		String[][] menus = new String[menuList.size()/2][5];
		int money=0;
		int count=0;
		
		Iterator<String> it = menuList.iterator();
		//restName,메뉴,가격,재고,개수

		while(it.hasNext()) //1개면 1개를 2개면 2개를 전달 3개면 3개 배열에 저장해야 근데 고른 순서, 메뉴,가격,재고
		{
			String i = it.next(); //다음꺼는 메뉴의 개수다

			if(i.equals(ob.getMenu1()))
			{
				menus[count][0] = restName;
				menus[count][1] = ob.getMenu1();
				menus[count][2]=  String.valueOf(ob.getPrice1());
				menus[count][3] = it.next(); //구입개수
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
		//나중에 합쳐서 던지자  합쳤다 이미

		//총 금액과 현금을 넣는 구문
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
		System.out.printf("\t\t\t총 %7d원입니다.\n",tot);
		System.out.print("\t\t\t현금을 투입해 주세요: ");
		money = Integer.parseInt(br.readLine());     //후에 잔고와 거스름돈에 이용되어야할 변수
		//총 금액보다 같거나 많은 현금을 받아야한다.
		//받아야 하는 현금 > 잔고+음식가격
		}
		while (money<tot);

		checkCT(menus,money,tot);
		//tot과 money은 권종구분 파트를 모르므로 빼놓고 필요하면 다시 넣자
	}


	public static void checkCT(String[][] menus,int money,int tot)throws IOException ///거리순,카테고리별 추천 에서 넘어오는 결제창 -> check()로 이동해서 최종결제창
	{
		//Manager.readerRestData(); //관리자가 티켓 재고를 채울시 엑셀데이터에 저장되므로 다시 hashMap에 데이터 저장
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       식당 티켓 발급       ");
		System.out.println("\t\t\t==============================");
		System.out.println();
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		System.out.println("\t\t\t 식당명 : "+menus[0][0]);
		System.out.println();
		for(int i=0;i<menus.length;i++)
		{
		System.out.println("\t\t\t 음식명 : "+menus[i][1]);
		System.out.println("\t\t\t 개수 : "+Integer.parseInt(menus[i][3]));
		System.out.println();
		}
		System.out.println();
		System.out.println("\t\t\t 총 금액 : "+tot);
		System.out.println("\t\t\t 넣은 현금 : "+money);
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		System.out.println();
		/*menus[count][0] = restName;
				menus[count][1] = ob.getMenu1();
				menus[count][2]=  String.valueOf(ob.getPrice1());
				menus[count][3] = it.next(); //구입개수
				menus[count][4] = String.valueOf(ob.getStock1());
				*/
		System.out.println("\t\t\t결제 완료시 취소할 수 없습니다.");
		
		String check = ""; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
		System.out.print("\t\t\t발급하시겠습니까? (Y/N)");
		check = br.readLine();
		check = check.toUpperCase();
		}
		while (!check.equals("Y") && !check.equals("N"));
		
		if(check.equals("Y"))
		{
		System.out.print("\n\t\t\t티켓이 발급중입니다...");
		inputResultoExcel(menus,money,tot);
		}
		else if(check.equals("N"))
		{
		System.out.print("\n\t\t\t검색or추천화면으로 돌아갑니다.");
			buyTicket();
		}	
	
	}




	public static void rankingRC()throws IOException //1.1.2 제일 많이 팔린메뉴
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


			//List는 순서대로들어간다 즉 모두 같은 순서로 나열되어있음 row만큼의 list 생성후 equals indexOf(0,1) 해서 같으면 해당 인덱스위치에 add하고 List.removeAll(list)해서 삭제 
		


		/*
		비교해서 담기 
		if((aSD[i][0].equals(aSD[j][0])) && (aSD[i][1].equals(aSD[j][1])))
					{

					}
		*/
				
		/*		
				for(int i=0;(line = br.readLine()) != null;i++)
			{
				for(int j=0;j<line.split(",").length;j++)          //line.split() = String[] 형을 반환하므로 String[].length가 된다.
				{
				String[] lineTemp = line.split(",");
															//lineTemp 배열을 List<>형에 적재한다. List형에 적재하면 contains메소드를 사용할 수 있다.
				if(Arrays.asList(lineTemp).contains(menus[i][0]) && Arrays.asList(lineTemp).contains(menus[i][1]))   //lineTemp배열을 List<>자료구조에 적재하고 SellData 엑셀을 읽어온 lineTemp가 사용자가 입력한 가게명,메뉴명을 포함한다면 
					{
						menus[i][3]+=lineTemp[3];
					}
				}
			}*/







		


		HashMap<String,Object> hashTemp = new HashMap<String,Object>(Manager.hashMap);
		 
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       제일 많이 팔린 메뉴  ");
		System.out.println("\t\t\t           1  ~  5 위       ");
		System.out.println("\t\t\t==============================");
		System.out.println();
		


		Set<String> allkey = Manager.hashMap.keySet(); //전체 키를 담을 Set 자료구조
		int temp1,temp2,temp3;
		int count=0;
		int everymenu=0; //전체 메뉴의 가지수
		int m=0;
		int num;		
		
		
	
		for(String key : allkey) //모든 재고 확인 
		{						 //배열구조가 아니기에 3개단위로 입력해줘야할듯  ///생각좀 해보고 다시 만들기
			temp1 = ((SetData)Manager.hashMap.get(key)).getStock1(); ++everymenu;
			temp2 = ((SetData)Manager.hashMap.get(key)).getStock2(); ++everymenu;
			temp3 = ((SetData)Manager.hashMap.get(key)).getStock3(); ++everymenu;
			
			}
		
		
		RankData[] rdArr = new RankData[everymenu]; 
		for(String key : allkey)
		{	
			SetData ob = ((SetData)Manager.hashMap.get(key));
			//한 가게의 메뉴는 3개 
			rdArr[m++]= new RankData(ob.getRestName(),ob.getMenu1(),ob.getPrice1(),ob.getStock1(),ob.getTime());
			rdArr[m++]= new RankData(ob.getRestName(),ob.getMenu2(),ob.getPrice2(),ob.getStock2(),ob.getTime());
			rdArr[m++]= new RankData(ob.getRestName(),ob.getMenu3(),ob.getPrice3(),ob.getStock3(),ob.getTime());

		}
		Arrays.sort(rdArr); //Arrays에서 재정의한 compareTo 사용 확인

		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		System.out.print("\t\t\t 식당명     메뉴    가격     시간\n");  //식당의 이름과 메뉴의 이름 으로인해 UI조정이 너무 힘듬 방법을 아는지 물어볼것
		for(int i=0;i<5;i++)
		System.out.println("\t\t\tTop"+(i+1)+")  "+rdArr[i].getRestName()+"  "+rdArr[i].getMenu()+"  "+rdArr[i].getPrice()+"  "+rdArr[i].getTime()+"분");
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		System.out.println();
		System.out.println();

		do
		{
		System.out.print("\t\t번호를 선택해 주세요 : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		}
		while (num <1 || num>5);
		//RankData는 임의로 생성한 클래스이므로 여기서 사용을 멈춰야 할것같다.
		String[][]menus = new String[1][5];

		menus[0][0]= rdArr[num-1].getRestName();
		menus[0][1]= rdArr[num-1].getMenu();
		menus[0][2]= String.valueOf(rdArr[num-1].getPrice());
		menus[0][3]= ""; //구입개수
		menus[0][4]= String.valueOf(rdArr[num-1].getStock());

		ticketing(menus);
	}


	public static void ticketing(String[][] menus)throws IOException  //카테고리 랭킹추천에서 넘어오는 결제창 -> check()로 이동해서 최종결제창
	{	
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       식당 티켓 발급       ");
		System.out.println("\t\t\t==============================");
		System.out.println();
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		System.out.print("\t\t\t 식당명     메뉴    가격     재고\n");
		System.out.println("\t\t\t "+menus[0][0]+"  "+menus[0][1]+"  "+menus[0][2]+"  "+menus[0][4]+"개");
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		do
		{
		System.out.print("\t\t고르신 메뉴의 티켓 재고는 "+menus[0][4]+"입니다. 개수를 선택해주세요 : ");
		num = Integer.parseInt(br.readLine());       //후에 해당 메뉴의 재고에 접근해야할 변수
		}
		while (num>Integer.parseInt(menus[0][4]));
		menus[0][3] = String.valueOf(num);


		int money;
		int tot = (Integer.parseInt(menus[0][3])*Integer.parseInt(menus[0][2]));
		do
		{
		System.out.print("\t\t현금을 투입해 주세요: ");
		money = Integer.parseInt(br.readLine());     //후에 잔고와 거스름돈에 이용되어야할 변수
		}
		while (money<tot);

		check(menus,money,tot);
		//원석이가 만든 UI에 따르면 발급재차확인(check메소드)에서는 식당,음식,입력한 발권개수, 가격*발권개수,넣은현금이 필요하다.
	}
	


	public static void check(String[][] menus,int money,int tot)throws IOException
	{
		Manager.readerRestData(); //관리자가 티켓 재고를 채울시 엑셀데이터에 저장되므로 다시 hashMap에 데이터 저장
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t==============================");
		System.out.println("\t\t\t       식당 티켓 발급       ");
		System.out.println("\t\t\t==============================");
		System.out.println();
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		System.out.println("\t\t\t 식당명 : "+menus[0][0]);
		System.out.println("\t\t\t 음식명 : "+menus[0][1]);
		System.out.println("\t\t\t 개수 : "+menus[0][3]);
		System.out.println("\t\t\t 총 금액 : "+tot);
		System.out.println();
		System.out.println("\t\t\t 넣은 현금 : "+money);
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		System.out.println();
		
		System.out.println("\t\t결제 완료시 취소할 수 없습니다.");
		String check = ""; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
		System.out.print("\t\t발급하시겠습니까? (Y/N)");
		check = br.readLine();
		check = check.toUpperCase();
		}
		while (!check.equals("Y") && !check.equals("N"));
		
		if(check.equals("Y"))
		{
		System.out.print("\n\t\t\t티켓이 발급중입니다...");
		inputResultoExcel(menus,money,tot);
		}
		else if(check.equals("N"))
		{
		System.out.print("\n\t\t\t검색or추천화면으로 돌아갑니다.");
			buyTicket();
		}
		
		//여기서 해쉬에 접속해서 재고를 감소시킬것?
	}


	private static void inputResultoExcel(String[][] menus, int money, int tot)
	{
		//각 메뉴의 판매수량은 독립적이어야한다. 관리자에서 쓰거나 사용자가 쓰거나 하면 안됨 오직 이 메소드만이 건드릴수있는 판매된 양을따지는 엑셀파일을 만들자.
		String dir = System.getProperty("user.dir");
		File file = new File(dir+"\\SellData.csv");
		//데이터를 담을 String 배열... 선언 할필요 없을듯? 
		//menus = 가게명  메뉴  가격  팔린양
		

		//SellData의 순서
		//가게명  /  메뉴1  / 가격1 /판매량  /
	
		/*menus 속성
				   0.가게명
				   1.메뉴명
				   2.금액
				   3.구입개수
				   4.재고*/ 
		try
		{	
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,false)); 
				
				//그럼 모든 매개변수를 일치시켜야되네...
				//매개변수 일치시킴
				for(int i=0;i<menus.length;i++)
				{
					String writeSell="";

					for(int j=0;j<menus[i].length-1;j++)//재고는 가지고 있을필요없을듯 
					{
						if(j==menus[i].length-2)
						{
						writeSell += menus[i][j];
						}
						else
							writeSell += menus[i][j]+",";
						
					}
					//여기 안에서 write하면 되지 않나?...
					//System.out.print(writeSell);
					
					bw.write(writeSell);
					bw.write("\n");//개행
					 
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


		//원석이가 거스름돈 생각하고 있다니 사용자가 넣은 현금은 어떻게할지 보류
/*
		if(((SetData)Manager.hashMap.get(restName)).getMenu1().equals(menu))
		{

			int change = ((SetData)Manager.hashMap.get(restName)).getStock1()-num;
			((SetData)Manager.hashMap.get(restName)).setStock1(change);
			//
			//관리자의 재고 +num*price  도 해야된다.

		}

		else if(((SetData)Manager.hashMap.get(restName)).getMenu2().equals(menu))
		{
			int change = ((SetData)Manager.hashMap.get(restName)).getStock2()-num;
			((SetData)Manager.hashMap.get(restName)).setStock2(change);
			//관리자의 재고 +num*price  도 해야된다.
		}
		
		else if(((SetData)Manager.hashMap.get(restName)).getMenu3().equals(menu))
		{
			int change = ((SetData)Manager.hashMap.get(restName)).getStock3()-num;
			((SetData)Manager.hashMap.get(restName)).setStock3(change);
			//관리자의 재고 +num*price  도 해야된다.
		}

		//String file= "C:\\Users\\USER\\Desktop\\Java_Semi\\RestInfo.csv";
		
		try
		{
			//BufferedWriter bw = new BufferedWriter(new FileWriter(file,false)); //이어쓰기가 아니라 덮어쓰기이므로 false
																			//FileWriter = FileNotFound BufferedWriter = IOException 고로 try-catch쓰는게 좋을듯
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//해쉬맵에서 restName으로 모든 값을 불러온다음 compare 혹은 equals를 이용해 int값이 음수 양수 0/true false 인걸통해서 현재 결제된 데이터로 덮어쓰기 이건 전부 if로 해야할듯
		//String의 join이용해서 배열에 담아뒀다가 빼내기 /Integer toString/ 오토 언박싱 박싱을 활용하자 

		//아니면 해쉬맵에서만 -하고 그대로 덮어쓰던가 근데 배열이 아니라 어짜피 equals는 써야할듯?... 키값은 괜찮지만 어떤 메뉴,어떤 가격,얼마의 티켓을 사갔는지 알아서 수정해야하니...
		//아니면 각 알고리즘에서 객체 자체를 넘겨주게 하던가...
		



*/
	}