<%@page import="com.sol.s1.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List Page</h1>
	
	<table>
		<tr>
			<th>일련번호</th><th>제품명</th><th>이자율</th>
		</tr>
	<%
		Object obj = request.getAttribute("list");
		ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)obj;
		for(BankBookDTO dto:ar){
	%>
		<!-- 		반복문 내부			-->
		<tr>
			<td><%= dto.getBookNumber() %></td>
			<td><a href="./bankbookSelect.do?bookNumber=<%= dto.getBookNumber() %>"><%=dto.getBookName() %></a></td>
			<td><%= dto.getBookRate() %></td>
		</tr>
	<%}%>
	</table>
	
	<a href="bankbookInsert.do">WRITE</a>
</body>
</html>