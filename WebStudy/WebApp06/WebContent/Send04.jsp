<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send04.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">


  .msg {color: red; font-size: small; display: none;}
</style>

<script type="text/javascript">
	 var sex = "";
	var sub = 0;
	
	
	function sexCheck(obj)
	
	{/* 

		sex = obj.value;

	}
	
	function subCheck(obj)
	{
		if(obj.checked)
			{
			sub++;
			}
		
		
 */		
	}
	
	
	

	function dataCheck()
	{
		/* //alert("아");

		var userId = document.getElementById("identify").value;
		var pwd = document.getElementById("pwd").value;
		var name = document.getElementById("name").value;
		var tel = document.getElementById("tel").value;
	
		if (userId == "" || pwd == "" || name == "" || tel == "")
		{
			alert("*표시 부분은 빈칸이 아니어야 합니다.");
			document.getElementById("inputForm").action = "Send04.jsp";
		}

		if (sex == "")
		{
			alert("성별을 선택해 주세요");
			document.getElementById("inputForm").action = "Send04.jsp";
		}
		if(sub == 0)
			{
			alert("최소 한개의 과목을 선택해주세요");
			document.getElementById("inputForm").action = "Send04.jsp";
			
			
			} */
	}
 	
	
 
 function formCheck()
{
	
	 //검사 대상확인 -> 적합 -> return true;
	 //검사 대상확인 -> 부적합 -> return false;
	 
	 var userId = document.getElementById("identify");
	 var userPwd = document.getElementById("pwd");
	 var userName = document.getElementById("name");
	 var userTel = document.getElementById("tel");
	 
	 var idMsg = document.getElementById("idMsg");
	 var pwdMsg = document.getElementById("pwdMsg");
	 var nameMsg = document.getElementById("nameMsg");
	 var telMsg = document.getElementById("telMsg");
	 
	 
	 //이렇게하면 아이디를 입력해도 아이디를 입력했음에도 아이디를입력해달라는 말이 나오게된다.
	 idMsg.style.display="none";
	 pwdMsg.style.display="none";
	 nameMsg.style.display="none";
	 telMsg.style.display="none";
	 
	 var id = userId.value;
	 
	 if(userId.value == "");
	 {
		 idMsg.style.display="inline";
		 userId.focus();
		 return false;
		 
	 }
	 if(!userPwd.value);
	 {
		 pwdMsg.style.display="inline";
		 userPwd.focus();
		 return false;
		 
	 }
	 if(!userName.value);
	 {
		 nameMsg.style.display="inline";
		 userName.focus();
		 return false;
		 
	 }
	 if(!userTel.value);
	 {
		 telMsg.style.display="inline";
		 userTel.focus();
		 return false;
		 
	 }
	 
	 return false;
	 
}
 
		
		
		

</script>

</head>
<body>
	<!-- 
   ○ 데이터 송수신 실습 04
      - 회원가입 요청 및 처리에 대한 과정을 JSP페이지로 구성한다.
      
      - 서버로 전송하기 전에(클라이언트 측에서 작성한 내용을 서버 측에 제출하기 전에)
        입력 데이터에 대한 기본 검사 과정을 추가한다.
        즉, 자바스크립트로 필수 입력 항목에 대한 입력 누락 여부 확인
        (Send04.jsp)
        
        ----------------------------------------------------
        
        아이디(*)      [ textbox ]  
        패스워드(*)    [ textbox ]  
        이름(*)       [ textbox ]
        전화번호(*)    [ textbox ]  
        
        성별      ●여자 ○남자
        
        지역      [ 서울  ▼]
        
        수강과목    □자바기초 □오라클중급 □JDBC □JSP심화
        
        <회원 가입>
        
        -----------------------------------------------------
       
        
 -->
	<form id="inputForm"action="Receive04.jsp" method="post" onsubmit="return formCheck()"> <!-- onsubmit= submit액션이 일어났을때 라는 의미 -->
		<table>																				<!-- return false; 와 같이되고 이는 onsubmit시 명령문을 실행하는것과 같음 -->
			<tr>																			
				<th>아이디(<span style="color: red;">*</span>)
				</th>
				<td><input type="text" id="identify" name="userId"
						placeholder="ex)superman">
						<span class="msg" id="idMsg">아이디를 입력하세요.</span>
				
				
			</tr>

			<tr>
				<th>패스워드(<span style="color: red;">*</span>)
				</th>
				<td><input type="password" id="pwd" name="userPwd"
						placeholder="ex)1234">
						<span class="msg" id="pwdMsg">패스워드를 입력하세요.</span>
					</td>
			</tr>

			<tr>
				<th>이름(<span style="color: red;">*</span>)
				</th>
				<td><input type="text" id="name" name="userName"
						placeholder="ex)홍길동">
						<span class="msg" id="nameMsg">이름을 입력하세요.</span>
			</tr>

			<tr>
				<th>전화번호(<span style="color: red;">*</span>)
				</th>
				<td><input type="text" id="tel" name="userTel"
						placeholder="ex)010-1111-1111">
						<span class="msg" id="telMsg">전화번호를 입력하세요.</span>
			</tr>

			<tr>
				<th>성별</th>
				<td>여자<input type="radio" id="radio1" name="sex" value="여성"
					onclick="sexCheck(this)"> 남자<input type="radio" id="radio2"
					name="sex" value="남성" onclick="sexCheck(this)">
				</td>
			</tr>


			<tr>
				<th>지역</th>
				<td><select name="location">
						<option selected="selected" value="서울">서울</option>
						<option value="경기">경기</option>
						<option value="부산">부산</option>
						<option value="세종">세종</option>
				</select></td>

			</tr>

			<tr>
				<th>수강과목</th>
				<td>자바기초<input type="checkbox" id="s1" name="Sub" value="자바기초" onclick="subCheck(this)">
					오라클 중급<input type="checkbox" id="s2" name="Sub" value="오라클중급" onclick="subCheck(this)">
					JDBC<input type="checkbox" id="s3" name="Sub" value="JDBC" onclick="subCheck(this)">
					JSP심화<input type="checkbox" id="s4" name="Sub" value="JSP심화" onclick="subCheck(this)">
				</td>
			</tr>


			<tr>
				<td><input type="submit" onclick="formCheck()"></td>
			</tr>


		</table>
	</form>

	</div>

</body>
</html>