<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
String no = (String)request.getParameter("no");
String nick = (String)request.getParameter("nick");
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 수정 비밀번호 인증</title>
</head>
<body>


	<form action="./edit_authen" method="GET" id="edit"></form>
	<p>비밀번호 : <input type="password" name="input_pwd" form="edit"/>
	<input type="submit" value="확인" form="edit" /></p>
	<input type="hidden" name="no" value="<%=no %>" form="edit"/>
	<input type="hidden" name="nick" value="<%=nick %>" form="edit"/>




</body>
</html>