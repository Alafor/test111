<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 정보 변경</h2>
<form action="update" method="post">
 이메일<input type="text" value='${member.email}' readonly="readonly"><br>
 이름<input type="text" name="name" value='${member.name}'><br>
 비밀번호<input type="password" name="password" value="">
 <input type="submit">
</form>
</body>
</html>