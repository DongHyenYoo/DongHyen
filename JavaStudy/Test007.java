//������ �ڷ��� - 5����
//������ �ڷ��� �ǽ� �� �׽�Ʈ : boolean
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.io.*;
public class Test007{


	public static void main(String[] agrs)throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String plus="";
		ArrayList<Integer> menuList = new ArrayList<Integer>();

		do
		{	int num;
			System.out.print("������ �޴� ��ȣ�� �Է��� �ּ��� : ");
			num = Integer.parseInt(br.readLine());
			if(menuList.contains(num))
			{
				System.out.println("������ �޴���ȣ�� �����Ǽ� �����ϴ� ������ �޴� ������ �߰����ּ���");
			}
			else
			{
			menuList.add(num);
			}

			if(menuList.size()==3)
			 continue;
			System.out.print("�޴��� �� �����ðڽ��ϱ�? �ִ� 3���� �޴��� ������ �ֽ��ϴ�. (Y/N): ");
			plus = br.readLine();
			plus = plus.toUpperCase();
			menuList.trimToSize();
		}
		while (menuList.size() != 3 && !plus.equals("N"));
		
		System.out.print(menuList.size());
		Iterator<Integer> it = menuList.iterator();













	}









}