<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="java.io.PrintWriter" %>
    
<%

if(request.getAttribute("dup_result")!=null){
	boolean dup_result = (boolean)request.getAttribute("dup_result");
	PrintWriter script = response.getWriter();

	if(dup_result) {
		script.println("<script>alert('중복된 아이디 입니다.')</script>");
	} else if(!dup_result) {
		script.println("<script>alert('사용 가능한 아이디입니다.')</script>");
	}
	
}

String input_id = (String)request.getParameter("user_id");
if(input_id==null) {
	input_id = "";
}

%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 페이지</title>
</head>
<body>

	<!-- <button><a href="./duplicateChk">중복확인</a></button> -->
	

	<form action="./signup" id='signup'></form>
		<table>
			<tr><td><h3>회원가입</h3></td></tr>
			<tr><td><p>아이디 : <input type="text" form="signup"  name="user_id" maxlength="12" id="id" value="<%=input_id%>"/> <input type="submit" name="button" value="중복확인" form="signup"/></p></td></tr>
			<tr><td><p>비밀번호 : <input type="password" form="signup" name="user_pw" maxlength="20"/></p></td></tr>
			<tr><td><p>닉네임 : <input type="text" form="signup" name="nick_name" maxlength="15" /></p></td></tr>
			<tr><td><p>이름 : <input type="text" form="signup" name ="user_name" maxlength="15"/></p></td></tr>
			<tr><td><p>이메일 : <input type="email" form="signup" name="user_mail" maxlength="30"/></p></td></tr>
			<tr><td><p>핸드폰 : <input type="number" form="signup" class="phone" name="user_phone1" maxlength="3" oninput="numberMaxLength(this);"/> 
				- <input type="number" form="signup" class="phone" name="user_phone2" maxlength="4" oninput="numberMaxLength(this);"/> 
				- <input type="number" form="signup" class="phone" name="user_phone3" maxlength="4" oninput="numberMaxLength(this);"/></p></td></tr>
			<tr><td><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" name="button" value="가입하기" form="signup" /> 
						&nbsp;&nbsp;&nbsp;&nbsp;<button id="backBtn">뒤로가기</button></p></td></tr>		
		</table>
		
		
		
		
		
		
			 
	
	


	<script>

		function numberMaxLength(e){
	        if(e.value.length > e.maxLength){
	            e.value = e.value.slice(0, e.maxLength);
	        }
	    }
		
		const backBtn = document.getElementById('backBtn');
		backBtn.addEventListener('click', (e)=>{
			e.preventDefault();
			//history.back();
			location.href = "./login_form";
		});

	</script>


	<style>
		
		
	
		/* Chrome, Safari, Edge, Opera */
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
		  -webkit-appearance: none;
		  margin: 0;
		}
		
		/* Firefox */
		input[type=number] {
		  -moz-appearance: textfield;
		}	
		
		.phone {
			width : 3vw;
		}
		
		a {
			text-decoration : none;
			color : black;
		}
	
		p { margin : 2vh; }
		table {margin: auto; }
	
	</style>


</body>
</html>