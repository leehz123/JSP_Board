<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글쓰기</title>
</head>
<body>


	<form action="./posting" id="posting"></form>
	<table>
		<tr><td><input form="posting" id="title" type="text" name="title" placeholder="제목"/></td></tr>
		<tr><td><textarea form="posting" id="content" name="content" placeholder="내용을 입력하세요"></textarea></td></tr>
		<tr><td><input form="posting" id="save" type="submit" value="저장"/></td></tr>
	</table>

	<style>
		table {
			position: relative;
			top : 5vh;
			border-collapse : collapse;
			margin: auto;
		}
		
		#title {
			width : 80vw;
		}
		
		#content {
			width : 80vw;
			height : 70vh;
			
		}
		
	</style>


</body>
</html>