<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import ="java.io.PrintWriter" %>


<% 

String authen_failed = (String)request.getParameter("authen_failed"); 

PrintWriter script = response.getWriter();

if(authen_failed!=null) {
	if(authen_failed.equals("0")) {
		script.println("<script>alert('비밀번호가 일치하지 않습니다.');</script>");	
	} else if(authen_failed.equals("1")) {
		script.println("<script>alert('작성자 본인만 수정/삭제할 수 있습니다.');</script>");	
	} 	
}

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>${post.title }</title>
</head>
<body>



	<table>
	
		<tr>
			<td><b>${post.title }</b></td>
		</tr>
		<tr><td style="text-align: right;">작성자 : ${post.nickname }</td></tr>
		<tr><td style="text-align: right;">작성일 : ${post.date }</td></tr>
		<tr><td style="text-align: right;">조회수 : ${post.view_num }</td></tr>	
		<tr><td><textarea disabled>${post.content }</textarea></td></tr>
		<tr>
		<td><button><a href="./board">글목록</a></button>
			<button><a href="./edit_authen_form?no=${post.no }&nick=${post.nickname }">수정</a></button>
			<button><a href="./delete_authen_form?no=${post.no }&nick=${post.nickname }">삭제</a></button></td>
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