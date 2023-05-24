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
		return "�޴�1 :"+menus[0]+"�޴�2 :"+menus[1]+"�޴�2 :"+menus[2]+"����1 :"+prices[0]+"����2 :"+prices[1]+"����3 :"+prices[2]+"�ҿ�ð�"+time+"ī�װ�"+category;

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
		this.category = "����������";
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
		//������ �ִ� �����͸� �ҷ��ð�
		 String appDir = System.getProperty("user.dir");
		 File file = new File(appDir+"\\RestInfo.csv");  //java������ ��ġ�ϴ� ����+�ش� ���� �̸�
		//System.out.print(file); //C:\Users\USER\Desktop\�ڹ� ����2\RestInfo.csv

		String line=""; //BufferedReader �� �޾ƿ� ���ڿ� �����͸� �޾Ƶ��� line


		try
		{
			//FileInputStream fileinputstream = new FileInputStream(exFile2);
			//BufferedReader br0 = new BufferedReader(new InputStreamReader(new FileInputStream(exFile2));
			//							���ڿ�				����Ʈ�� ���ڿ�					����Ʈ       �̷��� �ɰ�

			//�츮�� ��ü����ȭ���� fileinputstream�� objectoutpustream���� ���� ������ �Ѵ� ����Ʈ�� �ѱ䵥���͸� read�ϴ� �뵵���⶧��

			BufferedReader br = new BufferedReader(new FileReader(file));   //try catch�� �ִ����� = api���������� FileReader �� FileNotFound ���ܸ� ������ BufferedReader�� IOException�� �����Ƿ�  
																			 //�� �ΰ��� ����ó���� Exception �ϳ��� ��� ����ó�� �Ҽ� �ֵ��� �Ѵ�.
			
			int startrow = 1;   
			
			while((line = br.readLine()) != null)
			{
				String rowinfo ="";             //�ʱ�ȭ ������ �ʴ´ٸ� ��� ���ļ� ���ð��̱⿡ ������ �о���� �ʱ�ȭ 
				
				
				if(startrow == 1)
				{
				}
				else
				{
				 rowinfo = line;
				// System.out.print(rowinfo);
				 String[] items = rowinfo.split(",");
				 String keys = items[0];  //���� ���Ͽ� ������ �����̸��� ���� ù��°
				 RestInfo ri = new RestInfo();

				for(int i=1;i<items.length;i++)
					{

					if(i%2==0) //2 4 6�� ����
					{	
						int[] temprices= new int[3];

						for(int j=2,k=0;j<=6;j+=2,k++)
						  temprices[k] = Integer.parseInt(items[j]);
						
						ri.setPrices(temprices);
					}
					else   //1 3 5�� �޴�
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
	���� ������ �б� ���� ���� Ŭ�����Դϴ�. �� Ŭ������ �����ڴ� �⺻ ���� ���ڵ��� �⺻ ����Ʈ ���� ũ�Ⱑ �����ϴٰ� �����մϴ�. �̷��� ���� ���� �����Ϸ��� FileInputStream���� InputStreamReader�� �����Ͻʽÿ�.
	FileReader�� ���� ��Ʈ���� �б� ���� ���Դϴ�. ���� ����Ʈ ��Ʈ���� �������� FileInputStream ����� ����Ͻʽÿ�.
	
	FileInputStream�� read()�޼ҵ��� ����Ÿ���� int������ ���ڿ��� �о�ü� ����. ��
	���ڿ��� �������� ȥ�յ� �츮�� csv������ �б����ؼ��� FileReader(InputStreamReader�� �ڽ�Ŭ�����ν� Override�Ѱ��� ���� Ŭ����)�� ����ؾ��Ѵ�.
	
	
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
			String text = "�ڷ��Ƴ뽺,�θ���,5000,Ÿ��,10000,�������,20000,8,�߽�ĭ";
			String text2 = "�ڷ��Ƴ뽺23,�θ���23,50020,Ÿ��,10000,�������,20000,8,�߽�ĭ";
			pw.write("\n");
			pw.write(text);
			pw.write("\n");
			pw.write(text2);
			pw.flush();
			
		/*	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			String text = "�Ͽ���,�ø�,10000,����ø�,10000,��ȫ��,9000,5,�ѽ�";
			bw.write(text);
			bw.write(System.lineSeparator()); // ����, ���� �ٿ��� �Է½�Ű�� ����

			bw.flush();
		*/	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}

}