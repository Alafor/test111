<%@page import="spms.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%List<Member> members = (List<Member>)request.getAttribute("members"); 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<h1>회원목록</h1>
	${loginMember.name}님 안녕하세요<br>
	<input type="button" value="회원추가"  onclick="location.href='add'"><br>
	<%if(members.isEmpty()){%>
		<p>회원이 없습니다.</p>
	<%}else{%>
	<c:forEach var="member" items="${members}">
	
		<a href='update?no=${member.mno }'>${member.name}</a>, ${member.email}, ${member.cre_date}, <a href='delete?no=${member.mno }'> [삭제]</a><br>
	</c:forEach>
		
	<%}
		%>
	<input type="button" value="로그아웃"  onclick="location.href='../login/logout'"><br>
	<jsp:include page="/footer.jsp" />
</body>
</html>