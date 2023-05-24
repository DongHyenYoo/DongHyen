/**
 * myMenu.js
 */


function myMenu(status)
{
	var menu = document.getElementById("menuTable");
	
	if(status == 1){
		menu.style.display = "block";
	//	---  -----  -------------
	//	div  css    적용하고싶은 css
		}
	else {
		
		menu.style.display="none";
		
	}
}









/*
 * function 메뉴 보이기() { <!-- 클릭시 메뉴 테이블 보이기 --> <input type="button"
 * value="메뉴보이기" class="btn" onclick="myMenu(1)" /> <!-- 클릭시 메뉴 테이블 감추기 -->
 * <input type="button" value="메뉴 감추기" class="btn" onclick="myMenu(2)"/>
 * 
 * 이렇게 만들면 이와같이 두개의 function을 만들필요가 없다. }
 * 
 * function 메뉴 감추기() {
 *  }
 */