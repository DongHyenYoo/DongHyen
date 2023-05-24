<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weather.jsp</title>


<script type="text/javascript" src= "http://code.jquery.com.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
			<b>서울,경기도 육상 중기예보 - 2022년 12월 27일 (화)요일 06:00 발표</b>
			</p>
			
			<p>
			○ (하늘상태) 이번 예보기간에는 대체로 맑은 날이 많겠습니다.<br />
			○ (기온) 아침최저기온은 1월 1~2일은 -9~-1도로 평년(아침최저기온 -11~-4도)보다 조금 높겠고, 그 밖의 날은 -13~-4도로 평년과 비슷하겠습니다. <br /> 
			낮최고기온은 31일~1월 1일 2~4도로 평년(낮최고기온 1~3도)보다 조금 높겠고, 그 밖의 날은 -1~3도로 평년과 비슷하거나 조금 낮겠습니다.<br />
			○ (해상) 서해중부해상의 물결은 1월 2일(월) 1.0~2.5m로 일겠고, 그 밖의 날은 0.5~2.0m로 일겠습니다.<br />
			○ (주말전망) 31일(토)~1월 1일(일)은 맑겠습니다. 아침 기온은 -13~-1도, 낮 기온은 2~4도가 되겠습니다.
			</p>
			
			
			<h3>서울</h3>
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
				</table>
			</div>
		
		
		</div>
		
		
		
		
</div><!-- close panel-group -->

</div><!--close container -->



</body>
</html>