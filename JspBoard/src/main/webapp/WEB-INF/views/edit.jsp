<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ����</title>
</head>
<body>



	<form action="./edit_update" method="GET" id="edit">
		<input type="hidden" name="no" value="${post.no }"/>
	</form>
	<table>
	
		<tr>
			<td><input type="text" name="edited_title" value="${post.title }" form="edit" /></td>
		</tr>
		<tr><td style="text-align: right;">�ۼ��� : ${post.nickname }</td></tr>
		<tr><td style="text-align: right;">�ۼ��� : ${post.date }</td></tr>	
		<tr><td><textarea name="edited_content" form="edit">${post.content }</textarea></td></tr>
		<tr>
		<td><button><a href="./board">�۸��</a></button>
			<input type="submit" value="����" form="edit"/>
			<button><a href="./delete_authen_form?no=${post.no }&nick=${post.nickname }">����</a></button></td>
		</tr>
	</table>
	

	<style>
		
		table{margin: auto; position:relative; top:10vh;}
		
		a {
			text-decoration : none;
			color : black; 		
		}

		textarea {
			border : 1px solid gray;
			width: 50vw;
			height : 50vh;
		}
		
	</style>
	




</body>
</html>