<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import ="java.io.PrintWriter" %>    
<%
Integer login_result = (Integer)session.getAttribute("longin_result");

PrintWriter script = response.getWriter();

if(login_result!=null && login_result==1) {
	script.println("<script>alert('비밀번호가 일치하지 않습니다.')</script>");
} else if(login_result!=null && login_result==2) {
	script.println("<script>alert('아이디가 존재하지 않습니다.')</script>");
}


String input_id = request.getParameter("input_id");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 페이지</title>
</head>
<body>


	<!-- http://localhost:8888/JspBoard1/login_form 처음에 여기로 이동하셈~ -->


	<form action="./login" id="f1" method="POST" id="f1">
	

		<table>
			<tr><td><h3>로그인</h3></td></tr>
			<tr><td><p>ID : <input type="text" name="input_id" form="f1" ></p></td></tr>
			<tr><td><p>PW : <input type="password" name="input_pwd" form="f1"/></p></td></tr>
			<tr><td>&nbsp;&nbsp;<input type="submit" value="로그인" form="f1"/>&nbsp;&nbsp;&nbsp;&nbsp; <button id="btn">회원가입</button></td></tr>
		</table>
	
	
	<!-- <a href="./signup_form" style="text-decoration: none; color: black;">회원가입</a> -->
	
	<script>
	const btn = document.getElementById('btn');

	btn.addEventListener('click', (e) => {
		e.preventDefault();
		location.href = './signup_form';
	});
	
	</script>
	
	<style>
		table {
			margin: auto; 
			text-align : center;
			position: relative;
			top : 10vh;
		}
	</style>

</body>
</html>