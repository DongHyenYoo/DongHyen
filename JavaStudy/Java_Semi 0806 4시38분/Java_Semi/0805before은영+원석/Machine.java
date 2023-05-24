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
	// 로고 및 메인 선택 화면 출력 메소드
	public static void startMenu() throws IOException
	{
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
			for(int i=0; i< 25; i++)
			System.out.println("");

			System.out.print("\t\t\t문자를 입력하지 마세요");
			rcMenu();
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
	public static void ticketingCT() throws IOException
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

		int nummenu;
		int num;
		int stock=0;
		int price=0;
		int money=0;
		String menu="";

		do
		{
			System.out.print("원하시는 메뉴의 번호를 입력해 주세요 : ");
			nummenu = Integer.parseInt(br.readLine());
		}
		while (nummenu<1 || nummenu>3);

		//switch로 1~3해서 전달할 매개변수를 담아야할듯

		if(nummenu==1) //메뉴,가격,stock를 담아야한다.
		{
			SetData ob = ((SetData)Manager.hashMap.get(restName));
			menu = ob.getMenu1();
			price = ob.getPrice1();
			stock = ob.getStock1();
		}
		else if(nummenu==2) //메뉴,가격,stock를 담아야한다.
		{
			SetData ob = ((SetData)Manager.hashMap.get(restName));
			menu = ob.getMenu2();
			price = ob.getPrice2();
			stock = ob.getStock2();
		}
		else if(nummenu==3) //메뉴,가격,stock를 담아야한다.
		{
			SetData ob = ((SetData)Manager.hashMap.get(restName));
			menu = ob.getMenu3();
			price = ob.getPrice3();
			stock = ob.getStock3();
		}
		
		System.out.print(restName+"의 "+menu+"는 "+price+"원  "+"입니다."+"현재 재고는"+stock+"입니다.");

		do
		{
		System.out.print("\t\t\t고르신 메뉴의 티켓 재고는 "+stock+"입니다. 개수를 선택해주세요 : ");
		num = Integer.parseInt(br.readLine());       //후에 해당 메뉴의 재고에 접근해야할 변수
		}
		while (num>stock);
		
	
		do
		{
		System.out.print("\t\t\t현금을 투입해 주세요: ");
		money = Integer.parseInt(br.readLine());     //후에 잔고와 거스름돈에 이용되어야할 변수
		//총 금액보다 같거나 많은 현금을 받아야한다.
		//받아야 하는 현금 > 잔고+음식가격
		//if 잔고 : 3000 음식 가격 : 48000  넣은 돈: 100,000 거스름돈 :52000  

		}
		while (money<(num*price));//////////////////////////////////////////////////////////////////////////////////////money<=잔고
		



		check(restName,menu,price,num,money,stock);

		// 메뉴,갯수,현금 입력받기 
	}















		/*
		모든 키값을 불러오는 것
		Set<Integer> keySet = map.keySet();        
		for (Integer key : keySet)
			System.out.println(key + " : " + map.get(key));
		
		Set<String> keySet = Manager.hashMap.keySet();
		for(String key : keySet)

		//System.out.println(key+"의 재고1: "+((SetData)Manager.hashMap.get(key)).getStock1()+"재고2: "+((SetData)Manager.hashMap.get(key)).getStock2()+"재고3: "+((SetData)Manager.hashMap.get(key)).getStock3());
		//재고는 int형
		//불러오는 함수는 hashMap.get("음식점이름")getStock1~3
		*/
	public static void rankingRC()throws IOException //1.1.2 제일 많이 팔린메뉴
	{
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
		{						 //배열구조가 아니기에 3개단위로 입력해줘야할듯
			temp1 = ((SetData)Manager.hashMap.get(key)).getStock1(); ++everymenu;
			temp2 = ((SetData)Manager.hashMap.get(key)).getStock2(); ++everymenu;
			temp3 = ((SetData)Manager.hashMap.get(key)).getStock3(); ++everymenu;
			
			if((temp1 == 10 && temp2== 10 && temp3== 10)==false)
				++count;			
			}

		if(count==0)//모든 재고가 10이라면 안내메세지를 띄우고 이전메소드 호출
		{
			System.out.println("\t\t판매된 식권이 아직 없습니다.");
			System.out.println("\t\t이전 메뉴로 되돌아갑니다.");
			rcMenu();
		}

		//판매가 되었었으므로 진행 되어야할 부분
		//정렬방법
		//1.TreeSet 중복 안되므로 불가능 : 메뉴이름이 같을수도, 가격이 같을수도, 재고가 같을수도, 시간이 같다면 중복된 데이터는 삭제되버림
		//2.이전에 썻던 Comparator<T> 시도해 봤으나 실패 Arrays는 Comparable의 compare메소드로 정렬을 진행한다. API참조
		//3.Setdata에 사용자정의 생성자를 1.매개변수없는(은영과 원석이쓰고있는), 2.매개변수 (가게,메뉴,가격,재고)를 받는 생성자 선언
		//해봤으나 정렬과정에서 굉장히 헷갈려서 보류
		//4.3.번에서 깡통객체를 하나더 생성후 선택배열, 하나더 생성한 깡통객체때문에 때려맞추는식으로 일이 진행됨 : 실패
		//5.외부클래스로 SetData와 비슷한 클래스를 생성하고 Comparable 인터페이스 상속해서 CompareTo 메소드 오버라이딩 
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
		System.out.println("\t\t\t "+rdArr[i].getRestName()+"  "+rdArr[i].getMenu()+"  "+rdArr[i].getPrice()+"  "+rdArr[i].getTime()+"분");
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
		ticketing(rdArr[num-1].getRestName(),rdArr[num-1].getMenu(),rdArr[num-1].getPrice(),rdArr[num-1].getTime(),rdArr[num-1].getStock());
	}



	public static void ticketing(String restName, String menu, int price, int time,int stock)throws IOException
	{	//3개 추천 메소드를 합치려면 매개변수를 받는게 맞을거같다. 시연 = 시간단위로 결국 식당,메뉴,가격,시간을 받아오게 되어있음
																 //유림 = 카테고리단위로 결국 식당,메뉴,가격,시간을 받아오게 되어있음
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
		System.out.print("\t\t\t 식당명     메뉴    가격     시간\n");
		System.out.println("\t\t\t "+restName+"  "+menu+"  "+price+"  "+time+"분");
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		do
		{
		System.out.println("\t\t\t고르신 메뉴의 티켓 재고는 "+stock+"입니다. 개수를 선택해주세요 : ");
		num = Integer.parseInt(br.readLine());       //후에 해당 메뉴의 재고에 접근해야할 변수
		}
		while (num>stock);
		
		int money;
		do
		{
		System.out.print("\t\t\t현금을 투입해 주세요: ");
		money = Integer.parseInt(br.readLine());     //후에 잔고와 거스름돈에 이용되어야할 변수
		//총 금액보다 같거나 많은 현금을 받아야한다.
		//받아야 하는 현금 > 잔고+음식가격
		//if 잔고 : 3000 음식 가격 : 48000  넣은 돈: 100,000 거스름돈 :52000  

		}
		while (money<(num*price));//////////////////////////////////////////////////////////////////////////////////////money<=잔고
		



		check(restName,menu,price,num,money,stock);
		//원석이가 만든 UI에 따르면 발급재차확인(check메소드)에서는 식당,음식,입력한 발권개수, 가격*발권개수,넣은현금이 필요하다.
	}


	public static void check(String restName, String menu, int price,int num, int money,int stock)throws IOException
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
		System.out.println("\t\t\t 식당명 : "+restName);
		System.out.println("\t\t\t 음식명 : "+menu);
		System.out.println("\t\t\t 개수 : "+num);
		System.out.println("\t\t\t 총 금액 : "+(num*price));
		System.out.println();
		System.out.println("\t\t\t 넣은 현금 : "+money);
		System.out.print("\t\t\t");
		for(int i = 0; i < 34; i++) System.out.print("─");
		System.out.println();
		System.out.println();
		
		System.out.println("\t\t\t결제 완료시 취소할 수 없습니다.");
		char ch;
		do
		{
		System.out.print("\t\t\t발급하시겠습니다? (Y/y)");
		ch = Character.toUpperCase((char)System.in.read());
		}
		while (ch!='Y');
		
		System.out.print("\t\t\t티켓이 발급중입니다...");
		inputResultoExcel(restName,menu,price,num,money);
		//여기서 해쉬에 접속해서 재고를 감소시킬것?
	}




	private static void inputResultoExcel(String restName, String menu, int price,int num, int money)
	{
		//원석이가 거스름돈 생각하고 있다니 사용자가 넣은 현금은 어떻게할지 보류

		if(((SetData)Manager.hashMap.get(restName)).getMenu1().equals(menu))
		{

			int change = ((SetData)Manager.hashMap.get(restName)).getStock1()-num;
			((SetData)Manager.hashMap.get(restName)).setStock1(change);
			System.out.println(((SetData)Manager.hashMap.get(restName)).getMenu1());
			System.out.println(((SetData)Manager.hashMap.get(restName)).getStock1());
			//
			//관리자의 재고 +num*price  도 해야된다.

		}

		else if(((SetData)Manager.hashMap.get(restName)).getMenu2().equals(menu))
		{
			int change = ((SetData)Manager.hashMap.get(restName)).getStock2()-num;
			((SetData)Manager.hashMap.get(restName)).setStock2(change);
			System.out.println(((SetData)Manager.hashMap.get(restName)).getMenu2());
			System.out.println(((SetData)Manager.hashMap.get(restName)).getStock2());
			//관리자의 재고 +num*price  도 해야된다.
		}
		
		else if(((SetData)Manager.hashMap.get(restName)).getMenu3().equals(menu))
		{
			int change = ((SetData)Manager.hashMap.get(restName)).getStock3()-num;
			((SetData)Manager.hashMap.get(restName)).setStock3(change);
			System.out.println(((SetData)Manager.hashMap.get(restName)).getMenu3());
			System.out.println(((SetData)Manager.hashMap.get(restName)).getStock3());
			//관리자의 재고 +num*price  도 해야된다.
		}

		String file= "C:\\Users\\USER\\Desktop\\Java_Semi\\RestInfo.csv";
		
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
		




	}

	public static void printResult(String restName, String menu, int price,int num, int money)
	{

	}

}