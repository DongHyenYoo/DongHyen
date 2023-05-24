import java. io. BufferedReader;
import java. io. IOException;
import java. io. InputStreamReader;
import java.util.HashMap;
import java. util. Hashtable;
import java. io. FileInputStream;
import java. io. FileReader;


public class Manager
{
   // 메인프로그램 실행과 동시에 HashMap 데이터 로드를 위해 전역변수로 선언
   public static HashMap<String, Object> hashMap = new HashMap<String, Object>();

   public static void readRestData()
   {
      String file = "C:\\Users\\USER\\Desktop\\Java_Semi\\Restinfo.csv"; //Restinfo.csv파일의 절대 경로
      String line = " "; // while문으로 읽어올 데이터 배열 초기화

      try (BufferedReader br = new BufferedReader(new FileReader(file))) //br을 FileReader의 역할로 사용할 예정
      { 

        int rowCnt = 1; // 첫째 줄부터 읽어올 예정

        while((line = br.readLine()) != null) // readLine()메소드로 파일에서 더이상 데이터 값이 없을 때까지 읽어들임

											  // .csv 파일은 엔터로 각 행을 구분하는데 엔터는 null값 X

        {

           String rowStr = ""; // line으로 읽어올 데이터를 저장할 변수 초기화
           rowStr = line; //rowStr String에 line을 담음
           String[] items = rowStr.split(","); //items라는 배열에 ","를 기준으로 구분된 rowStr을 "," 단위로 잘라 담음
           String key = items[0]; // 배열에 가장 먼저 담기는 값은 csv구조상 상호명이므로 상호명을 Key값으로 담음

           SetData newSetData = new SetData(); 

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
            hashMap.put(key, newSetData); 
            
          }

         rowCnt++; 
            
            
         } 
       
      catch (Exception e) //예외처리
      { 
         System.out.println(e); 
      }

   } 
   
   // 데이터의 출력을 위한 메소드
   public static void printData(String restName) {
      
      //System.out.println(restName + "출력");
	  // hashMap.get()메소드를 통해 key값으로 전달받은 파라미터 전달.각 객체의 속성값 출력
	  // 속성들이 모두 private 형이며 SetData 클래스가 외부 클래스이기때문에 
	  // SetData형으로 캐스팅 해서 각 속성들에 접근할 수 있도록 함
      System.out.print(((SetData) hashMap.get(restName)).getMenu1() + "|");
      System.out.print(((SetData) hashMap.get(restName)).getPrice1() + "|");
      System.out.print(((SetData) hashMap.get(restName)).getMenu2() + "|");
      System.out.print(((SetData) hashMap.get(restName)).getPrice2() + "|");
      System.out.print(((SetData) hashMap.get(restName)).getMenu3() + "|");
      System.out.print(((SetData) hashMap.get(restName)).getPrice3() + "|");  
      System.out.print(((SetData) hashMap.get(restName)).getTime() + "|");
      System.out.println(((SetData) hashMap.get(restName)).getCategory() + "|");
      
   }
   
   
  

}

