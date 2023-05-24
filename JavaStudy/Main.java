import java.util.Scanner;

 
public class Main {
	public static final String[] SHAPE_ARR = {"��", "����", "��", "��"};
    public static final int STANDARD_LINE = 1;
    public static final int BRIDGE_LINE = 3; 
    public static final int FINAL_LINE = STANDARD_LINE + BRIDGE_LINE; //���� ����ϰ��ϴµ�
    public static final int HEIGHT= 8;

    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int playNum = 0;
        
        while(true) {
            
            try {
                playNum = setNumber();
            } catch(Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            String[][] sadariField = new String[HEIGHT][playNum * FINAL_LINE]; //7���̶�� ���� 8�� �¿��� 28ĭ
            String[] user = new String[playNum];   //��������ŭ�� �迭����
            String[] result = new String[playNum]; //���� ����ŭ�� ����迭 ����
 
            setField(sadariField, playNum); //setNumber�κ����� �ο����� �ο����� ��������� ��ٸ� �ʵ����
            setInput(user, "�÷��̾�");
            setInput(result, "���");
            setBridge(sadariField, playNum);
            result(sadariField, playNum, user, result);
            break;
        }
    }////////////main
    
    
    private static int setNumber() throws Exception {
        
        System.out.println("�÷����Ϸ��� �ο��� ����Դϱ�?");
        int tmp = Integer.parseInt(sc.nextLine());
        
        if(tmp <= 0 || tmp > 20) {
            Exception e = new Exception("�÷��� �ο��� 1~20������ �����ϼ���.");
            throw e;
        }
        
        System.out.println("��ٸ� ������ "+tmp+"���� ���� �Ǿ����ϴ�.");
        return tmp;
    }
    
    private static void setField(String[][] arr, int num) {
 
        for(int q = 0 ; q < HEIGHT ; q++) {  //2�����迭�̹Ƿ� 0~7���� 8ĭ
            for(int w = 0 ; w < FINAL_LINE * num ; w++) { // 7���Է� �޾����� 28ĭ
                
                if(w % 4 == STANDARD_LINE - 1) { //�̰� ��ٸ��� �׸��� �뵵 
                    arr[q][w] = SHAPE_ARR[0];       
                    System.out.print(SHAPE_ARR[0]);//���� ��ٸ��鸸 �׸��� �뵵 
                } else {
                    arr[q][w] = " ";
                    System.out.print("  "); //�ο� ������ ���� ä��� �뵵
                }
            }
            System.out.println();
        }
    }//setSadari
    
    private static void setInput(String[] userArr,String msg) {
        
        for(int q = 0 ; q < userArr.length ; q++) {
            System.out.println((q+1)+"��° "+msg+"�� �Է��ϼ���."); //�ο��� ��ŭ�� ��� �Է°� user�迭 �� ��ٸ� ���� ����Է� result �� ����
            userArr[q] = sc.nextLine();
        }
    }
    
    private static void setBridge(String[][] arr, int num) { //������ ��ٸ������ ����� �迭�� , �ο��� �Ű�����
        int lineNumber = arr[0].length / FINAL_LINE;   //lineNumber�� ������/��ٸ����� ���� 1������ 2�������� �ǹ� 7���̸� ����� 7�ϰ�
        int[] checkLine = new int[lineNumber];   //���γѹ���ŭ�� ������ �迭����
        
        for(int q = 1 ; q < arr.length - 1 ; q++) { //1~ 6 ���� ũ�� �ݺ� //����
            for(int w = 0 ; w < lineNumber - 1; w++) { //0���� �Է��ڼ� 7-1 �ؼ� 0���� 5���� �ݺ� //����
                
                if((int)(Math.random() * 2) == 0)  //0.0���� 1.0������ ���� *2 �� 0�� ������ int������ �ϸ� 1�� ���� �ʴ��� �ݿø��ؼ� 1�� ����� �������� ����  �̰� 30�����Ѵ�.
            
					checkLine[w] += checkLine[w] < 3 ? setBridgeDetail(arr , q, w * FINAL_LINE) : 0;  //setBridegeDetail�� ���� üũ���ο� ���� �Է¹ް� �ƴϸ� 0�� ä���ִ´�.
            }
            
            if(q == arr.length - 2)
                for(int w = 0 ; w < lineNumber - 1 ; w++) {
                    if(checkLine[w] == 0) {
                        q = 1;
                        break;
                    }
                }
        }
    }
    
    private static int setBridgeDetail(String[][] sadari, int q, int w) {
        
        if(sadari[q][w].equals(SHAPE_ARR[0]) && sadari[q][w + FINAL_LINE].equals(SHAPE_ARR[0])) {
            sadari[q][w] = SHAPE_ARR[3];
 
            for(int e = 1 ; e < FINAL_LINE + 1 ; e++) {
                if(e < FINAL_LINE) {
                    sadari[q][w + e] = SHAPE_ARR[1];
                } else {
                    sadari[q][w + e] = SHAPE_ARR[2];
                }
            }
            return 1;
        }
        return 0;
    }
    
    private static void result(String[][] arr, int sadariNum, String[] user, String[] result) {
        realTimeScreenDraw(arr, "");
        String tmp = "";
        
        for(int q = 0 ; q < arr[0].length ; q += FINAL_LINE) {
            int x = 0, y = q;
            
            for(int w = 0 ; w < arr.length ; w++) {
                if(arr[x][y].equals(SHAPE_ARR[3])) y += FINAL_LINE;
                else if(arr[x][y].equals(SHAPE_ARR[2])) y -= FINAL_LINE;
                
                //"��"�̵� ����
                tmp = arr[x][y];
                arr[x][y] = "��";
                realTimeScreenDraw(arr, user[q / FINAL_LINE]);
                waitTime(250);
                arr[x][y] = tmp;
                x ++;
            }
            System.out.println(user[q / FINAL_LINE]+"�� ����� "+result[y / FINAL_LINE]);
            user[q / FINAL_LINE] += "�� ��� -> "+result[y / FINAL_LINE];
            waitTime(1500);
        }
        blank();
        System.out.println("������������ ���â ������������");
        for(String temp : user) {
            System.out.printf("%s %n",temp);
        }
    }
    
    private static void realTimeScreenDraw(String[][] arr, String user) {
        blank();
        System.out.println("���� ���� -> "+user);
        
        for(int q = 0 ; q < arr.length ; q++) {
            for(int w = 0 ; w <arr[q].length ; w++) {
                System.out.print(arr[q][w]);
            }
            System.out.println();
        }
    }
    
    private static void waitTime(int waitNum) {
        try {
            Thread.sleep(waitNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private static void blank() {
        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    }
}//class
 
class Sadari {
    public static final String[] SHAPE_ARR = {"��", "����", "��", "��"};
    public static final int STANDARD_LINE = 1;
    public static final int BRIDGE_LINE = 3;
    public static final int FINAL_LINE = STANDARD_LINE + BRIDGE_LINE;
    public static final int HEIGHT= 8;
}