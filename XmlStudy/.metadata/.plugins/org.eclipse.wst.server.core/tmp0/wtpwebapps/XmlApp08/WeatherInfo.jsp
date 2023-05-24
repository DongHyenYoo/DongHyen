<%@page import="com.test.WeatherDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.WeatherDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%

//이전 페이지(WeatherInfo.jsp,자기 자신)로부터 데이터 수신
//사용자가 선택한 지역 데이터 수신

String stnId = request.getParameter("stnId");

if(stnId == null)
{
	stnId = "108";    //전국 날씨
}

StringBuilder sb = new StringBuilder();
WeatherDAO dao = new WeatherDAO(stnId);

//타이틀
String title = dao.weatherTitle();

//육상 중기 예보
String weatherInfo = dao.weatherInfo();

//도시 정보 및 날짜 시간별 날씨 정보
ArrayList<String> cityList = dao.weatherCityList();
for(int i=0;i<cityList.size();i++)
{
	sb.append(String.format("<h3>%s</h3>", cityList.get(i)));
	
	ArrayList<WeatherDTO> weatherList = dao.weatherList(String.valueOf(i+1));
	
	//테이블 구성 → 테이블 동적 생성
	sb.append("<table class='table'>");
	sb.append("<tr>");
	sb.append("<th>날짜</th>");
	sb.append("<th>날씨</th>");
	sb.append("<th>최저/최고 기온</th>");
	sb.append("<th>강수확률</th>");
	sb.append("</tr>");
	
	for(WeatherDTO w  : weatherList)
	{
		sb.append("<tr>");
		sb.append(String.format("<td>%s</td>", w.getTmEf())); //날짜
		sb.append(String.format("<td><img src='images/%s'> %s</td>",w.getImg(),w.getWf())); //날씨
		sb.append(String.format("<td>%s℃ / %s℃</td>", w.getTmn(), w.getTmx()));	// 최저/최고 기온
		sb.append(String.format("<td>%s%%</td>", w.getRnSt()));						// 강수확률
		sb.append("</tr>");
	}
	
	sb.append("</table>");
}


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WeatherInfo.jsp</title>


<script type="text/javascript" src= "http://code.jquery.com/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript">

$(function()
{
		//alert("");
	
		//선택한 라디오 상태를 선택된 상태(checked)로 표시(유지)할 수 있도록 처리
		//$(":radio:eq(0)").attr("checked", " checked");
		
		// 페이지 시작할 때부터 강원으로 시작
		//$(":radio:eq(2)").attr("checked", " checked");
		
		// 페이지 시작할 때부터 제주도로 시작
		//$(":radio:eq(9)").attr("checked", " checked");
		
		// 전국
		//$(":radio[value='108']").attr("checked", " checked");
		// 전북
		//$(":radio[value='146']").attr("checked", " checked");
		// 제주
		//$(":radio[value='184']").attr("checked", " checked");
		
		$(":radio[value='<%=stnId%>']").attr("checked", " checked");
		
});

</script>

<body>

<!-- 
/*============================================================================

 	  (http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108)
=============================================================================*/

/*
stnId=108   전국
stnId=109   서울, 경기
stnId=105   강원
stnId=131   충북
stnId=133   충남
stnId=146   전북
stnId=156   전남
stnId=143   경북
stnId=159   경남
stnId=184   제주특별자치도
*/


 -->

<div class="container">

<h2>기상 정보 <small>Bootstrap</small></h2>

<div class="panel-group" role="group">
		
		<div class="panel panel-default" role="group">
		
			<div class="panel-heading">지역 선택</div>
			<div class="panel-body">
			
			<!-- action 속성 생략 →전송하는 데이터의 수신처는 자기 자신 -->
				<form method="get" role="form">
					<input type="radio" name="stnId" value="108" checked="checked" /> 전국
					<input type="radio" name="stnId" value="109" /> 서울, 경기
					<input type="radio" name="stnId" value="105" /> 강원
					<input type="radio" name="stnId" value="131" /> 충북
					<input type="radio" name="stnId" value="133" /> 충남
					<input type="radio" name="stnId" value="146" /> 전북
					<input type="radio" name="stnId" value="156" /> 전남
					<input type="radio" name="stnId" value="143" /> 경북
					<input type="radio" name="stnId" value="159" /> 경남
					<input type="radio" name="stnId" value="184" /> 제주특별자치도
					
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div><!-- close .panel-body -->

		</div><!-- close .panel .panel-default -->
		
		
		<div class="panel- paneldefault" role="group">
		
			
			<div class="panel-heading">기상 정보 출력</div>
			<div class="panel-body">
			
			<p>
			<!-- <b>서울,경기도 육상 중기예보 - 2022년 12월 27일 (화)요일 06:00 발표</b> -->
			<b><%=title %></b>
			</p>
			
			<p>
			<!-- ○ (하늘상태) 이번 예보기간에는 대체로 맑은 날이 많겠습니다.<br />
			○ (기온) 아침최저기온은 1월 1~2일은 -9~-1도로 평년(아침최저기온 -11~-4도)보다 조금 높겠고, 그 밖의 날은 -13~-4도로 평년과 비슷하겠습니다. <br /> 
			낮최고기온은 31일~1월 1일 2~4도로 평년(낮최고기온 1~3도)보다 조금 높겠고, 그 밖의 날은 -1~3도로 평년과 비슷하거나 조금 낮겠습니다.<br />
			○ (해상) 서해중부해상의 물결은 1월 2일(월) 1.0~2.5m로 일겠고, 그 밖의 날은 0.5~2.0m로 일겠습니다.<br />
			○ (주말전망) 31일(토)~1월 1일(일)은 맑겠습니다. 아침 기온은 -13~-1도, 낮 기온은 2~4도가 되겠습니다. -->
			<%=weatherInfo %>
			</p>
			
			
			<!-- <h3>서울</h3>
				<table class="table">
					<thead>
					<tr>
						<th>날짜</th>
						<th>날씨</th>
						<th>최저/최고 기온</th>
						<th>강수확률</th>
					</tr>
					</thead>
					<tbody>
						<tr>
							<td>2022-12-30 00:00</td>
							<td>맑음</td>
							<td>-6~1</td>
							<td>10</td>
						</tr>
						<tr>
							<td>2022-12-30 12:00</td>
							<td>맑음</td>
							<td>-6~1</td>
							<td>0</td>
						</tr>
						<tr>
							<td>2022-12-31 00:00</td>
							<td>맑음</td>
							<td>-6~4<td>
							<td>0</td>
						</tr>
						<tr>
							<td>2022-12-31 12:00</td>
							<td>맑음</td>
							<td>-6~4<td>
							<td>0</td>
						</tr>
					</tbody>
				</table>
			
			
		<h3>인천</h3>
				<table class="table">
					<thead>
					<tr>
						<th>날짜</th>
						<th>날씨</th>
						<th>최저/최고 기온</th>
						<th>강수확률</th>
					</tr>
					</thead>
					<tbody>
						<tr>
							<td>2022-12-30 00:00</td>
							<td>맑음</td>
							<td>-6~1</td>
							<td>10</td>
						</tr>
						<tr>
							<td>2022-12-30 12:00</td>
							<td>맑음</td>
							<td>-6~1</td>
							<td>0</td>
						</tr>
						<tr>
							<td>2022-12-31 00:00</td>
							<td>맑음</td>
							<td>-6~4<td>
							<td>0</td>
						</tr>
						<tr>
							<td>2022-12-31 12:00</td>
							<td>맑음</td>
							<td>-6~4<td>
							<td>0</td>
						</tr>
					</tbody>
				</table> -->
				
				<%=sb.toString() %>
			</div>
		
		
		</div>
		
		
		
		
</div><!-- close panel-group -->

</div><!--close container -->



</body>
</html>