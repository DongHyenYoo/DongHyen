import java.util.Scanner;

 
public class Main {
	public static final String[] SHAPE_ARR = {"│", "──", "┤", "├"};
    public static final int STANDARD_LINE = 1;
    public static final int BRIDGE_LINE = 3; 
    public static final int FINAL_LINE = STANDARD_LINE + BRIDGE_LINE; //폭을 담당하게하는듯
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
            String[][] sadariField = new String[HEIGHT][playNum * FINAL_LINE]; //7명이라면 길이 8에 좌우폭 28칸
            String[] user = new String[playNum];   //유저수만큼의 배열생성
            String[] result = new String[playNum]; //유저 수만큼의 결과배열 생성
 
            setField(sadariField, playNum); //setNumber로부터의 인원수와 인원수를 기반으로한 사다리 필드생성
            setInput(user, "플레이어");
            setInput(result, "결과");
            setBridge(sadariField, playNum);
            result(sadariField, playNum, user, result);
            break;
        }
    }////////////main
    
    
    private static int setNumber() throws Exception {
        
        System.out.println("플레이하려는 인원이 몇명입니까?");
        int tmp = Integer.parseInt(sc.nextLine());
        
        if(tmp <= 0 || tmp > 20) {
            Exception e = new Exception("플레이 인원은 1~20명으로 설정하세요.");
            throw e;
        }
        
        System.out.println("사다리 갯수가 "+tmp+"개로 설정 되었습니다.");
        return tmp;
    }
    
    private static void setField(String[][] arr, int num) {
 
        for(int q = 0 ; q < HEIGHT ; q++) {  //2차원배열이므로 0~7까지 8칸
            for(int w = 0 ; w < FINAL_LINE * num ; w++) { // 7명입력 받았으면 28칸
                
                if(w % 4 == STANDARD_LINE - 1) { //이건 사다리를 그리는 용도 
                    arr[q][w] = SHAPE_ARR[0];       
                    System.out.print(SHAPE_ARR[0]);//일자 사다리들만 그리는 용도 
                } else {
                    arr[q][w] = " ";
                    System.out.print("  "); //인원 사이의 폭을 채우는 용도
                }
            }
            System.out.println();
        }
    }//setSadari
    
    private static void setInput(String[] userArr,String msg) {
        
        for(int q = 0 ; q < userArr.length ; q++) {
            System.out.println((q+1)+"번째 "+msg+"를 입력하세요."); //인원수 만큼의 사람 입력과 user배열 각 사다리 끝의 결과입력 result 에 저장
            userArr[q] = sc.nextLine();
        }
    }
    
    private static void setBridge(String[][] arr, int num) { //일자형 사다리모양이 저장된 배열과 , 인원수 매개변수
        int lineNumber = arr[0].length / FINAL_LINE;   //lineNumber는 내부폭/사다리간격 으로 1번라인 2번라인을 의미 7명이면 결과가 7일것
        int[] checkLine = new int[lineNumber];   //라인넘버만큼의 정수형 배열생성
        
        for(int q = 1 ; q < arr.length - 1 ; q++) { //1~ 6 까지 크게 반복 //고정
            for(int w = 0 ; w < lineNumber - 1; w++) { //0부터 입력자수 7-1 해서 0부터 5까지 반복 //변함
                
                if((int)(Math.random() * 2) == 0)  //0.0부터 1.0까지의 난수 *2 가 0와 같을때 int형으로 하면 1이 넘지 않는한 반올림해서 1로 결과를 보여주진 않음  이걸 30번을한다.
            
					checkLine[w] += checkLine[w] < 3 ? setBridgeDetail(arr , q, w * FINAL_LINE) : 0;  //setBridegeDetail을 통해 체크라인에 값을 입력받고 아니면 0을 채워넣는다.
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
                
                //"♥"이동 로직
                tmp = arr[x][y];
                arr[x][y] = "♥";
                realTimeScreenDraw(arr, user[q / FINAL_LINE]);
                waitTime(250);
                arr[x][y] = tmp;
                x ++;
            }
            System.out.println(user[q / FINAL_LINE]+"의 결과는 "+result[y / FINAL_LINE]);
            user[q / FINAL_LINE] += "의 결과 -> "+result[y / FINAL_LINE];
            waitTime(1500);
        }
        blank();
        System.out.println("────── 결과창 ──────");
        for(String temp : user) {
            System.out.printf("%s %n",temp);
        }
    }
    
    private static void realTimeScreenDraw(String[][] arr, String user) {
        blank();
        System.out.println("현재 유저 -> "+user);
        
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
    public static final String[] SHAPE_ARR = {"│", "──", "┤", "├"};
    public static final int STANDARD_LINE = 1;
    public static final int BRIDGE_LINE = 3;
    public static final int FINAL_LINE = STANDARD_LINE + BRIDGE_LINE;
    public static final int HEIGHT= 8;
}