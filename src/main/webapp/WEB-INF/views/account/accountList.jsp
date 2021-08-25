<%@page import="com.sol.s1.account.AccountDTO"%>
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
	<h1>Account List Page</h1>
	
	<table>
		<tr>
			<th>계좌번호</th><th>아이디</th><th>일련번호</th><th>날짜</th><th>잔액</th>
			<% 
				Object obj = request.getAttribute("list");
				ArrayList<AccountDTO> ar = (ArrayList<AccountDTO>)obj;
				for(AccountDTO dto:ar){
			%>
				<tr>
					<td><%= dto.getAccountNumber() %></td>
					<td><%= dto.getId() %></td>
					<td><%= dto.getBookNumber() %></td>
					<td><%= dto.getAccountDate() %></td>
					<td><%= dto.getAccountBalance() %></td>
				</tr>
			<% 
				}
			%>
		</tr>
	</table>
</body>
</html>