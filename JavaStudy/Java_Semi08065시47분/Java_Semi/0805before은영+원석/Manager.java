import java. io. BufferedReader;
import java. io. IOException;
import java. io. InputStreamReader;
import java. util. HashMap;
import java. util. Map;
import java. io. FileInputStream;
import java. io. FileNotFoundException;
import java. io. FileReader;

import java. io. FileWriter;
import java. io. BufferedWriter;
import java. io. FileOutputStream;
import java. io. OutputStreamWriter;
import java. util. Scanner;
import java. io. File;


public class Manager
{
   //메인프로그램 실행과 동시에 HashMap 데이터 로드를 위해 전역변수로 선언
   public static HashMap<String, Object> hashMap = new HashMap<String, Object>();
   static Scanner sc = new Scanner(System.in);


   // 관리자 인터페이스(main에서)
   public static void userInterface() 
	{
	   System.out.println();
		System.out.println("\t\t\t==============================================");
		System.out.println("\t\t\t ▒▒▒    SIST TODAY LUNCH [관리자 모드]   ▒▒▒ ");	
		System.out.println("\t\t\t==============================================");
		System.out.println();

		System.out.print("\t\t\t┌");
		for(int i = 0; i < 43; i++) System.out.print("─");
		System.out.print("┐\n");
		System.out.println("\t\t\t│          1. 음식점 추가                   │");
		//System.out.println("\t\t\t│          2. 음식점 수정                   │");
		System.out.println("\t\t\t│          3. 음식점 삭제                   │");
		System.out.println("\t\t\t│          4. 음식점 조회                   │");

		System.out.println("\t\t\t│          5. 식권 채우기                   │");
		//System.out.println("\t\t\t│          6. 잔고 채우기                   │");
		//System.out.println("\t\t\t│          7. 매출 확인                     │");
		
		System.out.println("\t\t\t│          8. 프로그램 종료                 │");

		System.out.print("\t\t\t└");
		for(int i = 0; i < 43; i++) System.out.print("─");
		System.out.print("┘\n");

		
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t\t번호 선택 : ");
		String sel = sc.nextLine();
	
			switch (sel)
			{
				case "1": addRestData();break;
				case "2": modifyRestData();break;
				case "3": deleteRestData();break;
				case "4": printAllRestData();break;
				case "5": fillStock();break;
				case "7": endMachine();break;
				default: userInterface();break;
			}
	}

   //추가 메소드(음식점 데이터 추가)
   //1. hashMap 조작(데이터 입력)
   //2. writeCsv(hashMap) (CSV 생성)
   public static void addRestData()
	{	
	   char input = 'Y';

	   while(!(input != 'y' && input != 'Y'))
		{
		   try
		   {
				System.out.print("\n\t\t\t상호명을 입력하세요 : ");
				String restName = sc.next();

				if(hashMap.get(restName) == null)
				{
					System.out.print("\t\t\t메뉴1을 입력하세요 : ");
					String restMenu1 = sc.next();
					
					System.out.print("\t\t\t가격1을 입력하세요 : ");
					String restPrice1 = sc.next();
					
					System.out.print("\t\t\t메뉴2을 입력하세요 : ");
					String restMenu2 = sc.next();
					
					System.out.print("\t\t\t가격2을 입력하세요 : ");
					String restPrice2 = sc.next();
					
					System.out.print("\t\t\t메뉴3을 입력하세요 : ");
					String restMenu3 = sc.next();
					
					System.out.print("\t\t\t가격3을 입력하세요 : ");
					String restPrice3 = sc.next();
					
					System.out.print("\t\t\t소요 시간을 입력하세요 : ");
					String restTime = sc.next();

					System.out.print("\t\t\t분류를 입력하세요 : ");
					String restCategory = sc.next();

					String[] dataArr = {restName, restMenu1, restPrice1, restMenu2, restPrice2, restMenu3, restPrice3, restTime, restCategory};

					SetData addSetData = new SetData();

					addSetData.setRestName(dataArr[0]);
					addSetData.setMenu1(dataArr[1]);
					addSetData.setPrice1(Integer.parseInt(dataArr[2]));
					addSetData.setMenu2(dataArr[3]);
					addSetData.setPrice2(Integer.parseInt(dataArr[4]));
					addSetData.setMenu3(dataArr[5]);
					addSetData.setPrice3(Integer.parseInt(dataArr[6]));
					addSetData.setTime(Integer.parseInt(dataArr[7]));
					addSetData.setCategory(dataArr[8]);

					hashMap.put(dataArr[0], addSetData);

					System.out.println("\n\t\t\t\t추가 완료");
					System.out.println("\n\t\t\t[ " + restName + "의 추가 데이터 ]");
					printKeyRestData(restName);

					System.out.print("\t\t\t계속 추가하시겠습니까?(Y/N)");
					input = sc.next().charAt(0);
					
				}
				else if(hashMap.get(restName) != null)
				{
					System.out.println("\n\t\t\t해당 음식점은 이미 등록되어 있습니다.");
					System.out.println("\n\t\t\t[ " + restName + "의 내역 ]");
					printKeyRestData(restName);

					System.out.print("\n\t\t\t다시 입력하시겠습니까?(Y/N)");
					input = sc.next().charAt(0);
				}
		   }
		    catch (NumberFormatException e )
		   {
				System.out.println("\n\t\t\t알맞은 데이터 타입을 입력하세요.");
				System.out.println("\t\t\t\t가격과 소요시간은 숫자만 입력 가능합니다.");
				System.out.print("\n\t\t\t다시 입력하시겠습니까?(Y/N)");
				input = sc.next().charAt(0);
		   }
		}
		writerRestData();
		userInterface();
	} 

   //수정 메소드(음식점 데이터 수정)
   //1. hashMap 조작(데이터 수정)
   //2. writerRestData()   
   public static void modifyRestData() 
	{
      //TO_DO
      
      // 수정은 한꺼번에
      // 
	  // 
      // 키값 변경이 일어나는경우 (레스토랑 이름이 변경되는 경우)
      // sample code------------------------------------------------
      // map.put("up_menu_id", map.remove("menu_id"));
      // -----------------------------------------------------------
      writerRestData();
	}  
   
   //삭제 메소드(음식점 데이터 삭제)
   //1. hashMap 조작(데이터 삭제)
   //2. writerRestData()  
   public static void deleteRestData() 
	{
	    String key;
		char input = 'Y';

		while(!(input != 'y' && input != 'Y'))
		{
			System.out.print("\t\t\t삭제할 상호명을 입력하세요 : ");
			key = sc.next();

			if (hashMap.get(key) != null)
			{
				hashMap.remove(key);

				System.out.println("\n\t\t\t삭제 완료");
				System.out.print("\n\t\t\t계속 삭제하시겠습니까?(Y/N)");
				input = sc.next().charAt(0);

			}
			else if (hashMap.get(key) == null)
			{
				System.out.println("\n\t\t\t상호명이 존재하지 않습니다. ");
				System.out.print("\n\t\t\t다시 입력하시겠습니까?(Y/N)");
				input = sc.next().charAt(0);
			} 
			
		}
		writerRestData();
		userInterface();
		
	} 

	// 조회 메소드
	// 모든 음식점의 데이터를 출력
	public static void printAllRestData()
	{
		 for(String strKey : hashMap.keySet())
		   {
			  SetData objValue = (SetData) hashMap.get(strKey);

			  System.out.println("\t\t\t[ " + strKey + "내역 조회 ]");
			  System.out.println("\n\t\t\t 메뉴 이름 | 메뉴 가격 | 재고 ");
			  System.out.println("\t\t\t----------------------------------------------");
			  System.out.println("\t\t\t" + objValue.getMenu1() +  objValue.getPrice1() + "원" + objValue.getStock1() + "개");
			  System.out.println("\t\t\t" + objValue.getMenu2() +  objValue.getPrice2() + "원" + objValue.getStock2() + "개");
			  System.out.println("\t\t\t" + objValue.getMenu3() +  objValue.getPrice3() + "원" + objValue.getStock3() + "개");
			  //System.out.println("\t\t\t" + objValue.getTime());
			  //System.out.println("\t\t\t" + objValue.getCategory());
			  System.out.println("\t\t\t-----------------------------------------------");
			  System.out.println();
		   }
		  userInterface();
	}// end printAllRestData()
	
	
	// 식권 채우기 메소드(식권의 잔고 추가)
	//1. hashMap 조작(데이터 수정)
	//2. writerRestData() 호출
	public static void fillStock()
	{
		int stock, sum;
		char input = 'Y';

		while(!(input != 'y' && input != 'Y'))
		{
			System.out.print("\n\t\t\t상호명을 입력하세요 : ");
			String key = sc.next();

			if (hashMap.get(key) != null)
			{
				System.out.println("\n\t\t\t[ " + key + "의 현재 재고 ]");
				printKeyRestData(key);

				System.out.print("\n\t\t\t재고를 추가할 메뉴를 입력하세요 : ");
				String inputMenu = sc.next();

				if ( inputMenu.equals(((SetData)hashMap.get(key)).getMenu1()) )
				{
					System.out.print("\t\t\t추가할 수량을 입력하세요 : ");
					stock = sc.nextInt();

					sum = ((SetData)hashMap.get(key)).getStock1();
					//System.out.println(sum);

					((SetData)hashMap.get(key)).setStock1(stock + sum);
					System.out.println("\n\t\t\t재고 추가 완료");
					System.out.println();
					System.out.println("\n\t\t\t[ " + key + "의 추가 후 재고 ]");
					printKeyRestData(key);
					System.out.print("\n\t\t\t계속 추가하시겠습니까?(Y/N)");
					input = sc.next().charAt(0);

				}
				else if (inputMenu.equals(((SetData)hashMap.get(key)).getMenu2()))
				{
					System.out.print("\t\t\t추가할 수량을 입력하세요 : ");
					stock = sc.nextInt();

					sum = ((SetData)hashMap.get(key)).getStock2();
					//System.out.println(sum);

					((SetData)hashMap.get(key)).setStock2(stock + sum);
					System.out.println("\n\t\t\t재고 추가 완료");
					System.out.println();
					System.out.println("\n\t\t\t[ " + key + "의 추가 후 재고 ]");
					printKeyRestData(key);
					System.out.print("\n\t\t\t계속 추가하시겠습니까?(Y/N)");
					input = sc.next().charAt(0);

				}

				else if (inputMenu.equals(((SetData)hashMap.get(key)).getMenu3()))
				{
					System.out.print("\t\t\t추가할 수량을 입력하세요 : ");
					stock = sc.nextInt();

					sum = ((SetData)hashMap.get(key)).getStock3();
					//System.out.println(sum);

					((SetData)hashMap.get(key)).setStock3(stock + sum);
					System.out.println("\t\t\t재고 추가 완료");
					System.out.println();
					System.out.println("\n\t\t\t[ " + key + "의 추가 후 재고 ]");
					printKeyRestData(key);
					System.out.print("\n\t\t\t계속 추가하시겠습니까?(Y/N)");
					input = sc.next().charAt(0);
				}
				else
				{
					System.out.println("\n\t\t\t해당 메뉴가 존재하지 않습니다.");
					System.out.print("\n\t\t\t다시 입력하시겠습니까?(Y/N)");
					input = sc.next().charAt(0);	
				}
			}
			else if(hashMap.get(key) == null)
			{
				System.out.println("\n\t\t\t상호명이 존재하지 않습니다.");
				System.out.print("\n\t\t\t다시 입력하시겠습니까?(Y/N)");
				input = sc.next().charAt(0);
			}
		}
		writerRestData();
		userInterface();
	
	}
	

   // writeeRestData() 생성
   // 변경된 HashMap을 .csv파일에 쓰기
   public static void writerRestData() 
   {
       File csv = new File("C:\\Users\\USER\\Desktop\\Java_Semi\\TRestinfo.csv");
       BufferedWriter bw = null; // 출력 스트림 생성
       try 
       {
           bw = new BufferedWriter(new FileWriter(csv));
           
           for(String strKey : hashMap.keySet())
		   {
			  SetData objValue = (SetData) hashMap.get(strKey);
			  /*
			  //테스트 출력
			  System.out.println("-------------------");
			  System.out.println(strKey);
			  System.out.println();
			  System.out.println(objValue.getMenu1());   
			  System.out.println(objValue.getPrice1()); 
			  System.out.println(objValue.getStock1()); 
			  
			  System.out.println(objValue.getMenu2());   
			  System.out.println(objValue.getPrice2());
			  System.out.println(objValue.getStock2());
			  
			  System.out.println(objValue.getMenu3());         
			  System.out.println(objValue.getPrice3());
			  System.out.println(objValue.getStock3());

			  System.out.println(objValue.getTime());
			  System.out.println(objValue.getCategory());
			  System.out.println("-------------------");
			  System.out.println();
			  */
			  
                
              //한 줄에 넣을 각 데이터 사이에 ,를 넣는다
			  String aData = objValue.getRestName() + "," + objValue.getMenu1() + "," + objValue.getPrice1() + "," + objValue.getStock1() + ","
							 + objValue.getMenu2() + "," + objValue.getPrice2() + "," + objValue.getStock2() + ","
							 + objValue.getMenu3() + "," + objValue.getPrice3() + "," + objValue.getStock3() + ","
							 + objValue.getTime() + "," + objValue.getCategory();

              //작성한 데이터를 파일에 넣는다
              bw.write(aData);
               
              //개행
              bw.newLine(); 
           }
           
       }
	   catch (FileNotFoundException e) 
       {
           e.printStackTrace();
       } 
       catch (IOException e) 
       {
           e.printStackTrace();
       } 
       finally 
       {
           try 
           {
               if (bw != null) 
               {
                   bw.flush(); // 남아있는 데이터까지 보내 준다
                   bw.close(); // 사용한 BufferedWriter를 닫아 준다
               }
           } 
           catch (IOException e) 
           {
               e.printStackTrace();
           }
       }
 
   }// endWriteRestData

  
   
   
   public static void readerRestData() 
   {
      String file = "C:\\Users\\USER\\Desktop\\Java_Semi\\TRestinfo.csv"; //Restinfo.csv파일의 절대 경로
      String line = " "; // while문으로 읽어올 데이터 배열 초기화
      
      try (BufferedReader br = new BufferedReader(new FileReader(file))) //br을 FileReader의 역할로 사용할 예정
      { 
        //int rowCnt = 1; // 첫째 줄부터 읽어올 예정
        
        while((line = br.readLine()) != null) // readLine()메소드로 파일에서 더이상 데이터 값이 없을 때까지 읽어들임
											  // .csv 파일은 엔터로 각 행을 구분하는데 엔터는 null값 X
        {
           String rowStr = ""; // line으로 읽어올 데이터를 저장할 변수 초기화
           
           //System.out.println(line);                        
          
           rowStr = line; //rowStr String에 line을 담음
           String[] items = rowStr.split(","); //items라는 배열에 ","를 기준으로 구분된 rowStr을 "," 단위로 잘라 담음
           String key = items[0]; // 배열에 가장 먼저 담기는 값은 csv구조상 상호명이므로 상호명을 Key값으로 담음
           
           //System.out.println("----------------------------------------------------------------------------------------------------------------------");
           //System.out.println("Key : " + key); // Key값이 제대로 담겼는지 테스트 출력
           
           SetData newSetData = new SetData(); //getter, setter가 있는 SetData 클래스 인스턴스 생성
         

         // test라는 객체로 생성된 SetData의 getter,setter에 각 항목을 초기화
         /*
         읽어온 데이터에 따라 
         items[0] = 상호명(Key값이 될 속성)    
         items[1] = 1번 메뉴, items[2] = 1번 메뉴의 가격
         items[3] = 2번 메뉴, items[4] = 2번 메뉴의 가격
         items[5] = 3번 메뉴, items[6] = 3번 메뉴의 가격
         items[7] = 소요시간, items[8] = 카테고리
         
         의 데이터가 담김 -> 즉 getter, setter에도 동일하게 넘겨줌
         */
            newSetData.setRestName(items[0]);
            newSetData.setMenu1(items[1]);
            newSetData.setPrice1(Integer.parseInt(items[2]));
			newSetData.setStock1(Integer.parseInt(items[3]));
            newSetData.setMenu2(items[4]);
            newSetData.setPrice2(Integer.parseInt(items[5]));
			newSetData.setStock2(Integer.parseInt(items[6]));
            newSetData.setMenu3(items[7]);
            newSetData.setPrice3(Integer.parseInt(items[8]));
			newSetData.setStock3(Integer.parseInt(items[9]));
            newSetData.setTime(Integer.parseInt(items[10]));
            newSetData.setCategory(items[11]);
            hashMap.put(key, newSetData);	// getter,setter로 SetData 클래스의 각 속성들을 초기화 했다면
											// 상호명을 담은 Key값과 데이터가 담긴 SetData클래스를 value에 객체로 전달
											// 즉 HashMap.put(Key(상호명),value(1번 메뉴, 1번 메뉴의 가격,2번 메뉴, 2번 메뉴의 가격,3번 메뉴, 3번 메뉴의 가격, 소요시간, 카테고리 )
            
            //System.out.println(test.toString() + "\n"); // toString 메소드를 재정의 한 내용대로 출력
            //System.out.println("rowCnt" + rowCnt);
            
          }

         //rowCnt++; // 한줄의 속성들을 전부 담았다면 rowCnt++ 하여 다음 라인을 읽어올 수 있도록 함
            
            
     } 
      catch (Exception e) //예외처리
      { 
         System.out.println(e); 
      }

   } // end readRestData() 
   
   // 선택한 키 값의 데이터의 출력을 위한 메소드
   // (fillStock() 잔고 채우기 메소드에서 호출)
   public static void printKeyRestData(String restName) 
	{
      // hashMap.get()메소드를 통해 key값으로 전달받은 파라미터 전달.각 객체의 속성값 출력
      // 속성들이 모두 private 형이며 SetData 클래스가 외부 클래스이기때문에 
      // SetData형으로 캐스팅 해서 각 속성들에 접근할 수 있도록 함
     
      //test
      //System.out.println("Type 확인");
      String key = ((SetData) hashMap.get(restName)).getRestName();
      //System.out.println(key);
      //System.out.println("--------------------");
      
	  System.out.println("\n\t\t\t 메뉴 이름 | 메뉴 가격 | 재고 ");
	  System.out.println("\t\t\t------------------------------");
      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu1() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice1() + "원 | ");
	  System.out.print(((SetData) hashMap.get(key)).getStock1() + " 개 |\n");

      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu2() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice2() + " 원 | ");
	  System.out.print(((SetData) hashMap.get(key)).getStock2() + " 개 |\n");

      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu3() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice3() + " 원 |");
	  System.out.print(((SetData) hashMap.get(key)).getStock3() + " 개 |\n");
      //System.out.print(((SetData) hashMap.get(key)).getTime() + "|");
      //System.out.println(((SetData) hashMap.get(key)).getCategory() + "|");

   }// end printKeyRestData()

	public static void endMachine()
	{
		System.out.println("\n\t\t\t※ 식권 발급 시스템을 종료합니다...\n");
		System.exit(-1);
		writerRestData();
	}

   public static void main(String[] args) throws IOException
   {
      readerRestData();// 실행과 동시에 데이터 셋팅 -> 머신 클래스 생성자에 넣어둬야지~

      
      //addRestData() 
     
      userInterface();


      //printRestData("하면옥"); // 매개변수로 조회를 원하는 키 값(Stirng 타입)을 전달


   }//end main

}