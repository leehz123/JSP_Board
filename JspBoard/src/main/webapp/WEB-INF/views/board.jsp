<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
</head>
<body>

	<form action="./logout"><input id="logoutBtn" type="submit" value="로그아웃" /></form>
	<a href="#" id="id">${sessionScope.id}</a>

	<h3>게시판</h3>
		
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${posts }" var="post">
				<tr>
					<td>${post.no }</td>
					<td><a href="./post?no=${post.no }" method="GET">${post.title }</a></td>
					<td><a href="">${post.nickname }</a></td>
					<td>${post.date }</td>
					<td>${post.view_num }</td>
				</tr>			
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><button id="btn"><a href="./posting_form">글쓰기</a></button></td>
			</tr>
			<tr>
				<td colspan="5">
					<form action="./search" method="GET">
						<p><select name='sort'>
					  		<option value='글제목' selected>글제목</option>
					  		<option value='글쓴이'>글쓴이</option>
						</select>			
						<input type="text" name="search"/>
						<input type="submit" value="검색" /></p>
					</form>									
				</td>
			</tr>
		</tbody>
	</table>	
	

<!-- 

	<script>
		const btn = document.getElementById('btn');
		btn.addEventListener('click', (e)=>{
			location.href ='./posting_form';
			
		});	
	</script>
 -->		
	<style>
	
		h3 {
			text-align : center;
			margin: 10vh 0;
		}
		
		#btn {
			margin-top : 20px;	
		}
	
		
		table {
			border-collapse : collapse; /*separate는 테두리 겹침 없게 하는 거*/
			margin-left : auto;
			margin-right: auto;
		}
		
		th, td {
			padding : 3px 2vw;
			text-align : center;
			border: 1px solid gray;
		}
		
		
		th:nth-child(2), td:nth-child(2) {
			padding-left : 10vw;
			padding-right : 10vw;
		}
		
		th:nth-child(3), td:nth-child(3) {
			padding-left : 5vw;
			padding-right : 5vw;

		}
		
		tr:nth-child(${posts.size()+1})>td, tr:nth-child(${posts.size()+2})>td {
			border : none;
		}
		
		
		a {
			text-decoration: none;
			color: black;
		}
		
		a:hover {
			color: gray;
		}


		#logoutBtn {
			position : absolute;
			top : 5vh;
			right : 5vw;
		}
		
		#id {position : absolute; top: 5vh; left : 5vw;}
		
		
	</style>
	


</body>
</html>