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
<title>�� ���� ��й�ȣ ����</title>
</head>
<body>

	<form action="./delete_authen" method="GET" id="delete"></form>
	<p>��й�ȣ : <input type="password" name="input_pwd" form="delete"/>
	<input type="submit" value="Ȯ��" form="delete" /></p>
	<input type="hidden" name="no" value="<%=no %>" form="delete"/>
	<input type="hidden" name="nick" value="<%=nick %>" form="delete"/>



</body>
</html>