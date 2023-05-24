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
   //�������α׷� ����� ���ÿ� HashMap ������ �ε带 ���� ���������� ����
   public static HashMap<String, Object> hashMap = new HashMap<String, Object>();
   static Scanner sc = new Scanner(System.in);


   // ������ �������̽�(main����)
   public static void userInterface() 
	{
	   System.out.println();
		System.out.println("\t\t\t==============================================");
		System.out.println("\t\t\t �ƢƢ�    SIST TODAY LUNCH [������ ���]   �ƢƢ� ");	
		System.out.println("\t\t\t==============================================");
		System.out.println();

		System.out.print("\t\t\t��");
		for(int i = 0; i < 43; i++) System.out.print("��");
		System.out.print("��\n");
		System.out.println("\t\t\t��          1. ������ �߰�                   ��");
		//System.out.println("\t\t\t��          2. ������ ����                   ��");
		System.out.println("\t\t\t��          3. ������ ����                   ��");
		System.out.println("\t\t\t��          4. ������ ��ȸ                   ��");

		System.out.println("\t\t\t��          5. �ı� ä���                   ��");
		//System.out.println("\t\t\t��          6. �ܰ� ä���                   ��");
		//System.out.println("\t\t\t��          7. ���� Ȯ��                     ��");
		
		System.out.println("\t\t\t��          8. ���α׷� ����                 ��");

		System.out.print("\t\t\t��");
		for(int i = 0; i < 43; i++) System.out.print("��");
		System.out.print("��\n");

		
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t\t��ȣ ���� : ");
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

   //�߰� �޼ҵ�(������ ������ �߰�)
   //1. hashMap ����(������ �Է�)
   //2. writeCsv(hashMap) (CSV ����)
   public static void addRestData()
	{	
	   char input = 'Y';

	   while(!(input != 'y' && input != 'Y'))
		{
		   try
		   {
				System.out.print("\n\t\t\t��ȣ���� �Է��ϼ��� : ");
				String restName = sc.next();

				if(hashMap.get(restName) == null)
				{
					System.out.print("\t\t\t�޴�1�� �Է��ϼ��� : ");
					String restMenu1 = sc.next();
					
					System.out.print("\t\t\t����1�� �Է��ϼ��� : ");
					String restPrice1 = sc.next();
					
					System.out.print("\t\t\t�޴�2�� �Է��ϼ��� : ");
					String restMenu2 = sc.next();
					
					System.out.print("\t\t\t����2�� �Է��ϼ��� : ");
					String restPrice2 = sc.next();
					
					System.out.print("\t\t\t�޴�3�� �Է��ϼ��� : ");
					String restMenu3 = sc.next();
					
					System.out.print("\t\t\t����3�� �Է��ϼ��� : ");
					String restPrice3 = sc.next();
					
					System.out.print("\t\t\t�ҿ� �ð��� �Է��ϼ��� : ");
					String restTime = sc.next();

					System.out.print("\t\t\t�з��� �Է��ϼ��� : ");
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

					System.out.println("\n\t\t\t\t�߰� �Ϸ�");
					System.out.println("\n\t\t\t[ " + restName + "�� �߰� ������ ]");
					printKeyRestData(restName);

					System.out.print("\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N)");
					input = sc.next().charAt(0);
					
				}
				else if(hashMap.get(restName) != null)
				{
					System.out.println("\n\t\t\t�ش� �������� �̹� ��ϵǾ� �ֽ��ϴ�.");
					System.out.println("\n\t\t\t[ " + restName + "�� ���� ]");
					printKeyRestData(restName);

					System.out.print("\n\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
					input = sc.next().charAt(0);
				}
		   }
		    catch (NumberFormatException e )
		   {
				System.out.println("\n\t\t\t�˸��� ������ Ÿ���� �Է��ϼ���.");
				System.out.println("\t\t\t\t���ݰ� �ҿ�ð��� ���ڸ� �Է� �����մϴ�.");
				System.out.print("\n\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
				input = sc.next().charAt(0);
		   }
		}
		writerRestData();
		userInterface();
	} 

   //���� �޼ҵ�(������ ������ ����)
   //1. hashMap ����(������ ����)
   //2. writerRestData()   
   public static void modifyRestData() 
	{
      //TO_DO
      
      // ������ �Ѳ�����
      // 
	  // 
      // Ű�� ������ �Ͼ�°�� (������� �̸��� ����Ǵ� ���)
      // sample code------------------------------------------------
      // map.put("up_menu_id", map.remove("menu_id"));
      // -----------------------------------------------------------
      writerRestData();
	}  
   
   //���� �޼ҵ�(������ ������ ����)
   //1. hashMap ����(������ ����)
   //2. writerRestData()  
   public static void deleteRestData() 
	{
	    String key;
		char input = 'Y';

		while(!(input != 'y' && input != 'Y'))
		{
			System.out.print("\t\t\t������ ��ȣ���� �Է��ϼ��� : ");
			key = sc.next();

			if (hashMap.get(key) != null)
			{
				hashMap.remove(key);

				System.out.println("\n\t\t\t���� �Ϸ�");
				System.out.print("\n\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N)");
				input = sc.next().charAt(0);

			}
			else if (hashMap.get(key) == null)
			{
				System.out.println("\n\t\t\t��ȣ���� �������� �ʽ��ϴ�. ");
				System.out.print("\n\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
				input = sc.next().charAt(0);
			} 
			
		}
		writerRestData();
		userInterface();
		
	} 

	// ��ȸ �޼ҵ�
	// ��� �������� �����͸� ���
	public static void printAllRestData()
	{
		 for(String strKey : hashMap.keySet())
		   {
			  SetData objValue = (SetData) hashMap.get(strKey);

			  System.out.println("\t\t\t[ " + strKey + "���� ��ȸ ]");
			  System.out.println("\n\t\t\t �޴� �̸� | �޴� ���� | ��� ");
			  System.out.println("\t\t\t----------------------------------------------");
			  System.out.println("\t\t\t" + objValue.getMenu1() +  objValue.getPrice1() + "��" + objValue.getStock1() + "��");
			  System.out.println("\t\t\t" + objValue.getMenu2() +  objValue.getPrice2() + "��" + objValue.getStock2() + "��");
			  System.out.println("\t\t\t" + objValue.getMenu3() +  objValue.getPrice3() + "��" + objValue.getStock3() + "��");
			  //System.out.println("\t\t\t" + objValue.getTime());
			  //System.out.println("\t\t\t" + objValue.getCategory());
			  System.out.println("\t\t\t-----------------------------------------------");
			  System.out.println();
		   }
		  userInterface();
	}// end printAllRestData()
	
	
	// �ı� ä��� �޼ҵ�(�ı��� �ܰ� �߰�)
	//1. hashMap ����(������ ����)
	//2. writerRestData() ȣ��
	public static void fillStock()
	{
		int stock, sum;
		char input = 'Y';

		while(!(input != 'y' && input != 'Y'))
		{
			System.out.print("\n\t\t\t��ȣ���� �Է��ϼ��� : ");
			String key = sc.next();

			if (hashMap.get(key) != null)
			{
				System.out.println("\n\t\t\t[ " + key + "�� ���� ��� ]");
				printKeyRestData(key);

				System.out.print("\n\t\t\t��� �߰��� �޴��� �Է��ϼ��� : ");
				String inputMenu = sc.next();

				if ( inputMenu.equals(((SetData)hashMap.get(key)).getMenu1()) )
				{
					System.out.print("\t\t\t�߰��� ������ �Է��ϼ��� : ");
					stock = sc.nextInt();

					sum = ((SetData)hashMap.get(key)).getStock1();
					//System.out.println(sum);

					((SetData)hashMap.get(key)).setStock1(stock + sum);
					System.out.println("\n\t\t\t��� �߰� �Ϸ�");
					System.out.println();
					System.out.println("\n\t\t\t[ " + key + "�� �߰� �� ��� ]");
					printKeyRestData(key);
					System.out.print("\n\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N)");
					input = sc.next().charAt(0);

				}
				else if (inputMenu.equals(((SetData)hashMap.get(key)).getMenu2()))
				{
					System.out.print("\t\t\t�߰��� ������ �Է��ϼ��� : ");
					stock = sc.nextInt();

					sum = ((SetData)hashMap.get(key)).getStock2();
					//System.out.println(sum);

					((SetData)hashMap.get(key)).setStock2(stock + sum);
					System.out.println("\n\t\t\t��� �߰� �Ϸ�");
					System.out.println();
					System.out.println("\n\t\t\t[ " + key + "�� �߰� �� ��� ]");
					printKeyRestData(key);
					System.out.print("\n\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N)");
					input = sc.next().charAt(0);

				}

				else if (inputMenu.equals(((SetData)hashMap.get(key)).getMenu3()))
				{
					System.out.print("\t\t\t�߰��� ������ �Է��ϼ��� : ");
					stock = sc.nextInt();

					sum = ((SetData)hashMap.get(key)).getStock3();
					//System.out.println(sum);

					((SetData)hashMap.get(key)).setStock3(stock + sum);
					System.out.println("\t\t\t��� �߰� �Ϸ�");
					System.out.println();
					System.out.println("\n\t\t\t[ " + key + "�� �߰� �� ��� ]");
					printKeyRestData(key);
					System.out.print("\n\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N)");
					input = sc.next().charAt(0);
				}
				else
				{
					System.out.println("\n\t\t\t�ش� �޴��� �������� �ʽ��ϴ�.");
					System.out.print("\n\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
					input = sc.next().charAt(0);	
				}
			}
			else if(hashMap.get(key) == null)
			{
				System.out.println("\n\t\t\t��ȣ���� �������� �ʽ��ϴ�.");
				System.out.print("\n\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
				input = sc.next().charAt(0);
			}
		}
		writerRestData();
		userInterface();
	
	}
	

   // writeeRestData() ����
   // ����� HashMap�� .csv���Ͽ� ����
   public static void writerRestData() 
   {
       File csv = new File("C:\\Users\\USER\\Desktop\\Java_Semi\\TRestinfo.csv");
       BufferedWriter bw = null; // ��� ��Ʈ�� ����
       try 
       {
           bw = new BufferedWriter(new FileWriter(csv));
           
           for(String strKey : hashMap.keySet())
		   {
			  SetData objValue = (SetData) hashMap.get(strKey);
			  /*
			  //�׽�Ʈ ���
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
			  
                
              //�� �ٿ� ���� �� ������ ���̿� ,�� �ִ´�
			  String aData = objValue.getRestName() + "," + objValue.getMenu1() + "," + objValue.getPrice1() + "," + objValue.getStock1() + ","
							 + objValue.getMenu2() + "," + objValue.getPrice2() + "," + objValue.getStock2() + ","
							 + objValue.getMenu3() + "," + objValue.getPrice3() + "," + objValue.getStock3() + ","
							 + objValue.getTime() + "," + objValue.getCategory();

              //�ۼ��� �����͸� ���Ͽ� �ִ´�
              bw.write(aData);
               
              //����
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
                   bw.flush(); // �����ִ� �����ͱ��� ���� �ش�
                   bw.close(); // ����� BufferedWriter�� �ݾ� �ش�
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
      String file = "C:\\Users\\USER\\Desktop\\Java_Semi\\TRestinfo.csv"; //Restinfo.csv������ ���� ���
      String line = " "; // while������ �о�� ������ �迭 �ʱ�ȭ
      
      try (BufferedReader br = new BufferedReader(new FileReader(file))) //br�� FileReader�� ���ҷ� ����� ����
      { 
        //int rowCnt = 1; // ù° �ٺ��� �о�� ����
        
        while((line = br.readLine()) != null) // readLine()�޼ҵ�� ���Ͽ��� ���̻� ������ ���� ���� ������ �о����
											  // .csv ������ ���ͷ� �� ���� �����ϴµ� ���ʹ� null�� X
        {
           String rowStr = ""; // line���� �о�� �����͸� ������ ���� �ʱ�ȭ
           
           //System.out.println(line);                        
          
           rowStr = line; //rowStr String�� line�� ����
           String[] items = rowStr.split(","); //items��� �迭�� ","�� �������� ���е� rowStr�� "," ������ �߶� ����
           String key = items[0]; // �迭�� ���� ���� ���� ���� csv������ ��ȣ���̹Ƿ� ��ȣ���� Key������ ����
           
           //System.out.println("----------------------------------------------------------------------------------------------------------------------");
           //System.out.println("Key : " + key); // Key���� ����� ������ �׽�Ʈ ���
           
           SetData newSetData = new SetData(); //getter, setter�� �ִ� SetData Ŭ���� �ν��Ͻ� ����
         

         // test��� ��ü�� ������ SetData�� getter,setter�� �� �׸��� �ʱ�ȭ
         /*
         �о�� �����Ϳ� ���� 
         items[0] = ��ȣ��(Key���� �� �Ӽ�)    
         items[1] = 1�� �޴�, items[2] = 1�� �޴��� ����
         items[3] = 2�� �޴�, items[4] = 2�� �޴��� ����
         items[5] = 3�� �޴�, items[6] = 3�� �޴��� ����
         items[7] = �ҿ�ð�, items[8] = ī�װ�
         
         �� �����Ͱ� ��� -> �� getter, setter���� �����ϰ� �Ѱ���
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
            hashMap.put(key, newSetData);	// getter,setter�� SetData Ŭ������ �� �Ӽ����� �ʱ�ȭ �ߴٸ�
											// ��ȣ���� ���� Key���� �����Ͱ� ��� SetDataŬ������ value�� ��ü�� ����
											// �� HashMap.put(Key(��ȣ��),value(1�� �޴�, 1�� �޴��� ����,2�� �޴�, 2�� �޴��� ����,3�� �޴�, 3�� �޴��� ����, �ҿ�ð�, ī�װ� )
            
            //System.out.println(test.toString() + "\n"); // toString �޼ҵ带 ������ �� ������ ���
            //System.out.println("rowCnt" + rowCnt);
            
          }

         //rowCnt++; // ������ �Ӽ����� ���� ��Ҵٸ� rowCnt++ �Ͽ� ���� ������ �о�� �� �ֵ��� ��
            
            
     } 
      catch (Exception e) //����ó��
      { 
         System.out.println(e); 
      }

   } // end readRestData() 
   
   // ������ Ű ���� �������� ����� ���� �޼ҵ�
   // (fillStock() �ܰ� ä��� �޼ҵ忡�� ȣ��)
   public static void printKeyRestData(String restName) 
	{
      // hashMap.get()�޼ҵ带 ���� key������ ���޹��� �Ķ���� ����.�� ��ü�� �Ӽ��� ���
      // �Ӽ����� ��� private ���̸� SetData Ŭ������ �ܺ� Ŭ�����̱⶧���� 
      // SetData������ ĳ���� �ؼ� �� �Ӽ��鿡 ������ �� �ֵ��� ��
     
      //test
      //System.out.println("Type Ȯ��");
      String key = ((SetData) hashMap.get(restName)).getRestName();
      //System.out.println(key);
      //System.out.println("--------------------");
      
	  System.out.println("\n\t\t\t �޴� �̸� | �޴� ���� | ��� ");
	  System.out.println("\t\t\t------------------------------");
      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu1() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice1() + "�� | ");
	  System.out.print(((SetData) hashMap.get(key)).getStock1() + " �� |\n");

      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu2() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice2() + " �� | ");
	  System.out.print(((SetData) hashMap.get(key)).getStock2() + " �� |\n");

      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu3() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice3() + " �� |");
	  System.out.print(((SetData) hashMap.get(key)).getStock3() + " �� |\n");
      //System.out.print(((SetData) hashMap.get(key)).getTime() + "|");
      //System.out.println(((SetData) hashMap.get(key)).getCategory() + "|");

   }// end printKeyRestData()

	public static void endMachine()
	{
		System.out.println("\n\t\t\t�� �ı� �߱� �ý����� �����մϴ�...\n");
		System.exit(-1);
		writerRestData();
	}

   public static void main(String[] args) throws IOException
   {
      readerRestData();// ����� ���ÿ� ������ ���� -> �ӽ� Ŭ���� �����ڿ� �־�־���~

      
      //addRestData() 
     
      userInterface();


      //printRestData("�ϸ��"); // �Ű������� ��ȸ�� ���ϴ� Ű ��(Stirng Ÿ��)�� ����


   }//end main

}