<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ���</title>
</head>
<body>

	<form action="./logout"><input id="logoutBtn" type="submit" value="�α׾ƿ�" /></form>
	<a href="#" id="id">${sessionScope.id}</a>

	<h3>�Խ���</h3>
		
	<table>
		<thead>
			<tr>
				<th>��ȣ</th>
				<th>������</th>
				<th>�۾���</th>
				<th>�ۼ���</th>
				<th>��ȸ</th>
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
				<td><button id="btn"><a href="./posting_form">�۾���</a></button></td>
			</tr>
			<tr>
				<td colspan="5">
					<form action="./search" method="GET">
						<p><select name='sort'>
					  		<option value='������' selected>������</option>
					  		<option value='�۾���'>�۾���</option>
						</select>			
						<input type="text" name="search"/>
						<input type="submit" value="�˻�" /></p>
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
			border-collapse : collapse; /*separate�� �׵θ� ��ħ ���� �ϴ� ��*/
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