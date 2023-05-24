import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.File;
import java.util.HashMap;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

class RestInfo
{
	private String[] menus= new String[3];
	private int[] prices = new int[3];
	private int time;
	private String category;

	@Override
	public String toString()
	{
		return "메뉴1 :"+menus[0]+"메뉴2 :"+menus[1]+"메뉴2 :"+menus[2]+"가격1 :"+prices[0]+"가격2 :"+prices[1]+"가격3 :"+prices[2]+"소요시간"+time+"카테고리"+category;

	}
	
	public void setMenus(String[] menus)
	{
		this.menus = menus;
	}
	public String[] getMenus()
	{
		return menus;
	}

	public void setPrices(int[] prices)
	{
		this.prices = prices;
	}
	public int[] getPrices()
	{
		return prices;
	}

	public void setTime(int time)
	{
		this.time = time;
	}
	public int getTime()
	{
		return time;
	}

	public void setCategory(String category)
	{
		this.category = "ㄴㅇㄹㄴㅇ";
	}
	public String getCategory()
	{
		return category;
	}
}


public class Server
{
	public static HashMap<String,Object> hm = new HashMap<String,Object>(); 
	public static void putData()
	{
		//엑셀에 있는 데이터를 불러올것
		 String appDir = System.getProperty("user.dir");
		 File file = new File(appDir+"\\RestInfo.csv");  //java파일이 위치하는 폴더+해당 파일 이름
		//System.out.print(file); //C:\Users\USER\Desktop\자바 세미2\RestInfo.csv

		String line=""; //BufferedReader 가 받아올 문자열 데이터를 받아들일 line


		try
		{
			//FileInputStream fileinputstream = new FileInputStream(exFile2);
			//BufferedReader br0 = new BufferedReader(new InputStreamReader(new FileInputStream(exFile2));
			//							문자열				바이트를 문자열					바이트       이렇게 될것

			//우리가 객체직렬화에서 fileinputstream을 objectoutpustream으로 묶은 이유는 둘다 바이트로 넘긴데이터를 read하는 용도였기때문

			BufferedReader br = new BufferedReader(new FileReader(file));   //try catch에 넣는이유 = api페이지에서 FileReader 는 FileNotFound 예외를 던지고 BufferedReader는 IOException을 던지므로  
																			 //이 두개의 예외처리를 Exception 하나로 묶어서 예외처리 할수 있도록 한다.
			
			int startrow = 1;   
			
			while((line = br.readLine()) != null)
			{
				String rowinfo ="";             //초기화 해주지 않는다면 계속 겹쳐서 나올것이기에 한줄을 읽어온후 초기화 
				
				
				if(startrow == 1)
				{
				}
				else
				{
				 rowinfo = line;
				// System.out.print(rowinfo);
				 String[] items = rowinfo.split(",");
				 String keys = items[0];  //엑셀 파일에 따르면 가게이름이 제일 첫번째
				 RestInfo ri = new RestInfo();

				for(int i=1;i<items.length;i++)
					{

					if(i%2==0) //2 4 6은 가격
					{	
						int[] temprices= new int[3];

						for(int j=2,k=0;j<=6;j+=2,k++)
						  temprices[k] = Integer.parseInt(items[j]);
						
						ri.setPrices(temprices);
					}
					else   //1 3 5는 메뉴
						{
						String[] tempmenus= new String[3];

						for(int j=1,k=0;j<=5;j+=2,k++)
						  tempmenus[k] = items[j];

						ri.setMenus(tempmenus);
						}

					}
				ri.setTime(Integer.parseInt(items[7]));
				ri.setCategory(items[8]);
				//System.out.println(ri);
				hm.put(keys,ri);
				}
				startrow++;
			}
			

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	/*
	문자 파일을 읽기 위한 편의 클래스입니다. 이 클래스의 생성자는 기본 문자 인코딩과 기본 바이트 버퍼 크기가 적절하다고 가정합니다. 이러한 값을 직접 지정하려면 FileInputStream에서 InputStreamReader를 구성하십시오.
	FileReader는 문자 스트림을 읽기 위한 것입니다. 원시 바이트 스트림을 읽으려면 FileInputStream 사용을 고려하십시오.
	
	FileInputStream의 read()메소드의 리턴타입은 int형으로 문자열을 읽어올수 없다. 즉
	문자열과 정수형이 혼합된 우리의 csv파일을 읽기위해서는 FileReader(InputStreamReader의 자식클래스로써 Override한것은 없는 클래스)를 사용해야한다.
	
	
	*/
	
	}


	public static void printdate(String key)
	{
		System.out.println(((RestInfo)hm.get(key)).getTime());
		for(int a : ((RestInfo)hm.get(key)).getPrices()) 
		System.out.println(a);
	}

	public static void writedata()
	{
		String appDir = System.getProperty("user.dir");
		File file = new File(appDir+"\\RestInfo.csv");
		
		try
		{
			//BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			BufferedWriter pw = new BufferedWriter(new FileWriter(file,true));
			String text = "코레아노스,부리또,5000,타코,10000,헤이즐넛,20000,8,멕시칸";
			String text2 = "코레아노스23,부리또23,50020,타코,10000,헤이즐넛,20000,8,멕시칸";
			pw.write("\n");
			pw.write(text);
			pw.write("\n");
			pw.write(text2);
			pw.flush();
			
		/*	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			String text = "하연옥,냉면,10000,비빔냉면,10000,거홍면,9000,5,한식";
			bw.write(text);
			bw.write(System.lineSeparator()); // 개행, 다음 줄에다 입력시키기 위해

			bw.flush();
		*/	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}

}