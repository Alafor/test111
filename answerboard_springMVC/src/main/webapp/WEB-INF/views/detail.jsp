<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#replyform {
		display: none;
	}
	#container{
		height: 338px;
		width: 800px;
		margin: 0 auto;
		overflow: auto;
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function replyForm() {
		$("#replyform").toggle(1);
		var replyPosition = $("#replyform").offset().top;
		$("#container").animate({
			"scrollTop":replyPosition,
			"width":"800px"
		},800)
	}
</script>
</head>
<body>
	<div id="container">
	<h1>게시글 상세보기	</h1>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="60" >${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button"
					onclick="location.href='updateform.do?seq=${dto.seq }'"
					value="수정"> <input type="button"
					onclick="location.href='muldel.do?seq=${dto.seq }'"
					value="삭제"> <input type="button" onclick="replyForm()"
					value="답글"> <input type="button"
					onclick="location.href='boardlist.do'"
					value="글 목록"></td>
		</table>

		<div id='replyform'>
			<h1>답글 달기</h1>
			<form action="replyboard.do" method="post">
				<input
					type="hidden" name="seq" value="${dto.seq }">
				<table border="1">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td></td>
						<td><textarea rows="10" cols="60" name="content"></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="댓글 달기"> <input
							type="button"
							onclick="location.href='boardlist.do'"
							value="글 목록"> <input type="button" onclick="replyForm()"
							value="댓글창 닫기"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>