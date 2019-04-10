<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 작성</h1>
	<form action="updateboard.do" method="post">
		<input type="hidden" name="seq" value="${dto.seq }">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${dto.id}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${dto.title }"></td>
		</tr>
		<tr>
			<td></td>
			<td><textarea rows="40" cols="60" name="content">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="글 수정">
				<button onclick="location.href='boardlist.do'">글 목록</button>
								                
			</td>
		</tr>
	</table>
	</form>
</body>
</html>