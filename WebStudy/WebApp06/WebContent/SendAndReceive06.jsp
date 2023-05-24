<%@page import="sun.security.jca.GetInstance"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SendAndReceive06.jsp</title>

<% 


//사용자가 선택한 년과 월
String userYear = request.getParameter("year");
String userMonth = request.getParameter("month");


//달력객체 생성
GregorianCalendar date = new GregorianCalendar();
//Calendar date = Calendar.getInstance();

int year = date.get(date.YEAR);
int month = date.get(date.MONTH)+1;
int day = date.get(date.DAY_OF_MONTH);
//사용자 컴퓨터의 년 월 일

//사용자가 선택하지 않았다면 즉 select에 2022년 10월이 있다면
if(userYear != null || userMonth != null)
{
	year = Integer.parseInt(userYear);
	month = Integer.parseInt(userMonth);
}


//String yearStr = "<option value='" + year + "'>" + year + "</option>"; 

//String monthStr = "<option value='" + month + "'>" + month + "</option>";

String optionYear="";
String optionMonth="";

//년도 그리기
for(int i=year-10; i<=year+10 ; i++)
{
	
	if(year == i) //현재년도와 같을때
	{
		optionYear += "<option value='" + i + "' selected = 'selected'>" + i + "</option>"; 
		
	}
	else if(year != i)
	{
		optionYear += "<option value='" + i + "'>" + i + "</option>";
		
		
	}
}


for(int i=1; i<=12 ; i++)
{
	
	if(month == i) //현재월와 같을때
	{
		optionMonth += "<option value='" + i + "' selected = 'selected'>" + i + "</option>"; 
		
	}
	else if(month != i)
	{
		optionMonth += "<option value='" + i + "'>" + i + "</option>";
		
		
	}
}


int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
if (date.isLeapYear(year)) //윤년이라면
{
   months[1] = 29;
}

int week = date.get(date.DAY_OF_WEEK);

String[] weekName = { "일", "월", "화", "수", "목", "금", "토" };


/*==================== 달력 그리기 ===================================  */
String calStr = "";
calStr += "<table border='1'>";
calStr += "<tr>";
for (int i = 0; i < weekName.length; i++)
{
   if (i == 0)
      calStr += "<th style ='color:red;'>" + weekName[i] + "</th>";
   else if (i == 6)
      calStr += "<th style ='color:blue;'>" + weekName[i] + "</th>";
   else
      calStr += "<th>" + weekName[i] + "</th>";
}
calStr += "</tr>";
calStr += "<tr>";
// 빈칸 공백 발생
for (int i = 1; i <= week; i++)
{
   calStr += "<td></td>";
}
// 날짜 td 발생
for (int i = 1; i <= months[month-1]; i++)
{
   week++;
   /* calStr += "<td>" + i +"</td>"; */
   if (i == day && week % 7 == 0)
   {
      calStr += "<td class ='nowSat'>" + i + "</td>";
   } else if ( i == day && week % 7 == 1)
   { //일요일
      calStr += "<td class ='nowSun'>" + i + "</td>";
   } else if (i == day)
   {
      calStr += "<td class='now'>" + i + "</td>";
   } else if (week % 7 == 0)
   {
      calStr += "<td class='sat'>" + i + "</td>";
   } else if (week % 7 == 1)
   {
      calStr += "<td class='sun'>" + i + "</td>";
   } else
   {
      calStr += "<td>" + i + "</td>";
   }
   if (week % 7 == 0)
      calStr += "</tr><tr>";
}
for (int i = 0; i <= week; i++, week++)
{
   if (week % 7 == 0)
      break;
   calStr += "<td></td>";
}

if(week%7!=0){
   calStr +="</tr>";      
}
calStr += "</table>";
// 빈칸 공백 td 발생


%>

<script type="text/javascript">
function formCalendar(obj){
   obj.submit();
}
</script>

</head>
<body>
<!-- 
	○ 데이터 송수신 실습 06
	   - 달력을 출력하는 JSP 페이지를 구성한다.
	   - 년도와 월을 입력받아 화면에 출력해주는 형태의 페이지로 구성
	   
	   - 단 submit 버튼 없이 이벤트 처리할 수 있도록한다.
	   
	   - 전송한 내용을 수신해서 출력해주는 형태의 페이지로 구현한다.
	   - 년도 구성은 현재 년도 기준 이전 10년 이후 10년으로 구성한다.
	   
	   -월은 1월부터 12월까지로 구성
	   
	   
	   - 페이지 레이아웃
	    ----------------------------------- 
	     [2022▼]년 [10▼]월 select
	     
	     ---------------------------------
	     
	     - 원하는 단을 선택 시
	     구구단이 나올수 있도록
	     와 같은 내용을 출력하는 jsp페이지를 작성한다.
	     
	   - 사용자의 최초 요청 주소는
	     『http://localhost:8090/WebApp07/Send04.html』
	     로 한다.

		1.jsp로 select 생성
		2.
		3.
		4.

 -->
<div>
      <h1>데이터 송수신 실습 07</h1>
      <hr>
   </div>
   <div>
      <form name="frm" method="post">

         <select name="year" id="year" style="width: 300px;" onchange="formCalendar(this.form)">
            <%=optionYear%>
         </select>년 <select name="month" id="month" style="width: 300px;" onchange="formCalendar(this.form)">
            <%=optionMonth%>
         </select>월

      </form>

   </div>
   <div>
      <%=calStr%>
   </div>
</body>
</html>