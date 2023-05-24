<%@page import="java.time.DayOfWeek"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%

// 현재 연도와 달
GregorianCalendar cal = new GregorianCalendar();

int nowYear = cal.get(cal.YEAR);
int nowMonth = cal.get(cal.MONTH)+1;
int nowDay = cal.get(cal.DAY_OF_MONTH); //달에서 몇일인지
//int weekDay = cal.get(cal.DAY_OF_WEEK); // 오늘이 주에서 몇일인지
//int weekmonthDay = cal.get(cal.DAY_OF_WEEK_IN_MONTH); 이는 주중일 이 아니라 이번주가 달에서 몇번째 주인지를 뜻함


//1. 현재 연도와 달 띄우기

//2.사용자가 왼쪽을 클릭시 month - 1 해서 값을 넘기기

//3. 매년 1월에서 왼쪽을 클릭시 year -1 하기

//4. 오른쪽은 +1로 마찬가지

//5.달력 그리기 


int year = nowYear;
int month = nowMonth;




String clickYear = request.getParameter("year");
String clickMonth = request.getParameter("month");

if(clickYear != null && clickMonth != null) // 아직 사용자가 왼쪽 혹은 오른쪽을 클릭했을경우
{
	year = Integer.parseInt(clickYear);
	month = Integer.parseInt(clickMonth);
	
}



int beforeYear = year;
int beforeMonth = month-1;  //이전달 변수

int nextYear = year;
int nextMonth = month+1; //다음달 변수

if(beforeMonth < 1) // 현재페이지의 달이 1월인경우 
{
	beforeYear -= 1;  //해는 전해로
	beforeMonth = 12;  // 달은 12월로
}
else if(nextMonth > 12)  //현재 페이지의 달이 12월인 경우
{
	nextYear += 1; //해는 다음해로
	nextMonth = 1; //달은 1월로
}


// a href를 통해 값을전달
String beforeMon = String.format("<a href='SendAndReceive07.jsp?year=%d&month=%d'>◀</a>",beforeYear,beforeMonth);
String nextMon = String.format("<a href='SendAndReceive07.jsp?year=%d&month=%d'>▶</a>",nextYear,nextMonth);



//달력 그리기위해 연도,달, 달의첫째날 세팅

cal.set(cal.YEAR,year);
cal.set(cal.MONTH,month-2);
int befores = cal.getActualMaximum(cal.DAY_OF_MONTH);
cal.set(cal.MONTH,month-1);
cal.set(cal.DAY_OF_MONTH,1);
int week = cal.get(cal.DAY_OF_WEEK);
int maxdays = cal.getActualMaximum(cal.DAY_OF_MONTH);



String[] weekName = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};


String drawCal = "<table border='1'>"; 

drawCal += "<tr>";

for(int i=0;i<weekName.length;i++) //일~토요일 넣기
{
	if(i ==0 ) //일요일이라면
	drawCal += "<th class='sunday'>"+ weekName[i]  +"</th>";
	else if(i == 6)
	drawCal += "<th class='saturday'>" + weekName[i] + "</th>";
	else
	drawCal += "<th>" + weekName[i] + "</th>";
}


drawCal += "</tr>";

//일~토요일 넣기 end


// 1일까지 빈칸 채우기
drawCal += "<tr>";
week -=1;
for(int i=1,j = befores-week+1; i<=week; i++,j++)  
{
	drawCal += "<td class='nextAndBefore'>" + (month-1) +"/" + (j) + "</td>";

}

//빈칸 채우기 end

//달력 그리기

for(int i=1; i<=maxdays;i++)
{
	week++; 
	//토/일 구분용
	if(week%7==0)
	{
		drawCal += "<td class='saturday'>" + i + "</td>";
	}
	else if(week%7==1)
	{
	drawCal += "<td class='sunday'>" + i + "</td>";
	}
	else if(i==nowDay && year == nowYear && month == nowMonth)
	{
		drawCal += "<td class='now'>" + i + "</td>";
	}
	else
	{
		drawCal += "<td>" + i + "</td>";
	}
	
	if(week % 7 == 0)
	{
		drawCal += "</tr><tr>";
	}
	
	
}

//출력후 빈칸 채우기
	for(int i=1; i<=week; i++, week++)
	{
		if(week%7==0)
			break;
		drawCal += "<td class='nextAndBefore'>"+ nextMonth +"/" + i+ "</td>";
		
	}


drawCal += "</tr>";


drawCal += "</table>";



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

 .sunday{color: red;}
 .saturday{color: blue;}
 .now{background-color: fuchsia;}
 .nextAndBefore{color: gray;}
</style>
</head>

<body>
<div>
<%=beforeMon %> <%=year %>년 <%=month %>월 <%=nextMon %>


<%=drawCal %>

</div>
</body>
</html>