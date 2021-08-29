<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link href="./css/test.css" rel="stylesheet">
</head>
<body>
	<h1>Index Page</h1>
	<h3 id="t1">Member</h3>
	<p id="t2">
		<a href="/ServletStudy2/member/memberLogin.do?id=t1&pw=pw1">Member Login</a><br>
		<a href="./member/memberJoin.do">Member Join</a><br>
		<a href="member/memberPage.do">My Page</a>
	</p>
	
	<h3 id="t3" class="c2">Bankbook</h3>
	<p>
		<a href="/ServletStudy2/bankbook/bankbookList.do">List</a><br>
		<a href="./bankbook/bankbookInsert.do">Insert</a><br>
		<a href="bankbook/bankbookSelect.do?bookNumber=5">Select</a>
	</p>
	<h3>Account</h3>
	<p>
		<a href="./account/accountList.do">List</a>
	</p>
	
	<h2 class="c1 c2">Button</h2>
	
	<button class="c1">CLICK</button>
	
	<div id="circle"> CIRCLE </div>
</body>
</html>