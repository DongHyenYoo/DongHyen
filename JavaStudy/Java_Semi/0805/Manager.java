import java. io. BufferedReader;
import java. io. IOException;
import java. io. InputStreamReader;
import java.util.HashMap;
import java. util. Hashtable;
import java. io. FileInputStream;
import java. io. FileReader;


public class Manager
{
   // �������α׷� ����� ���ÿ� HashMap ������ �ε带 ���� ���������� ����
   public static HashMap<String, Object> hashMap = new HashMap<String, Object>();

   public static void readRestData()
   {
      String file = "C:\\Users\\USER\\Desktop\\Java_Semi\\Restinfo.csv"; //Restinfo.csv������ ���� ���
      String line = " "; // while������ �о�� ������ �迭 �ʱ�ȭ

      try (BufferedReader br = new BufferedReader(new FileReader(file))) //br�� FileReader�� ���ҷ� ����� ����
      { 

        int rowCnt = 1; // ù° �ٺ��� �о�� ����

        while((line = br.readLine()) != null) // readLine()�޼ҵ�� ���Ͽ��� ���̻� ������ ���� ���� ������ �о����

											  // .csv ������ ���ͷ� �� ���� �����ϴµ� ���ʹ� null�� X

        {

           String rowStr = ""; // line���� �о�� �����͸� ������ ���� �ʱ�ȭ
           rowStr = line; //rowStr String�� line�� ����
           String[] items = rowStr.split(","); //items��� �迭�� ","�� �������� ���е� rowStr�� "," ������ �߶� ����
           String key = items[0]; // �迭�� ���� ���� ���� ���� csv������ ��ȣ���̹Ƿ� ��ȣ���� Key������ ����

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
       
      catch (Exception e) //����ó��
      { 
         System.out.println(e); 
      }

   } 
   
   // �������� ����� ���� �޼ҵ�
   public static void printData(String restName) {
      
      //System.out.println(restName + "���");
	  // hashMap.get()�޼ҵ带 ���� key������ ���޹��� �Ķ���� ����.�� ��ü�� �Ӽ��� ���
	  // �Ӽ����� ��� private ���̸� SetData Ŭ������ �ܺ� Ŭ�����̱⶧���� 
	  // SetData������ ĳ���� �ؼ� �� �Ӽ��鿡 ������ �� �ֵ��� ��
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

