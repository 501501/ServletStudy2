<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join Page</h1>
	
	<form action="./memberJoin.do" method="post">
		아이디 <input type="text" name="id"><br>
		비밀번호 <input type="password" name="pw"><br>
		이름 <input type="text" name="name"><br>
		전화번호 <input type="tel" name="phone"><br>
		이메일 <input type="email" name="email"><br>
		<button>JOIN</button>
	</form>
</body>
</html>