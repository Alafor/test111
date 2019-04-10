<%@page import="com.hk.utils.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

	function allsel(bool) {
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = bool;
		}
	}
	function sp(td,step1,depth1,title) {	
		var space = "";
		var step = parseInt(step1);
		var depth = parseInt(depth1);
		if(step==0){
			td.innerHTML="<a href='boarddetail.do?seq=${seq}'>"+title+"</a>";
		}else{
			for(var i=0;i<depth;i++){
				space+="&nbsp&nbsp";
			}
		td.innerHTML="<a href='boarddetail.do?seq=${seq}'>"+space+"┖▷"+title+"</a>";
		}
	}
	
	$(function() {
		
		$("h1").click(function(){
			$("th").slice(7,9).toggle();
			$("th").slice(10).toggle();
			$("tr").each(function() {
				$(this).children("td").slice(7,9).toggle();
				$(this).children("td").slice(10).toggle();
			});
		});
		
		
		$("td>a").hover(function(){
			//마우스가 올라갔을때
			var seq = $(this).parent().prev().prev().html();
			//alert(seq);
			$.ajax({
				url:"ContentAjax.do",
//				data:"seq"+seq,
				data:{"seq":seq },///    서버로 보낸느 타입
				datatype:"json", ///서버로부터 받을 타입 
				method:"post",
				success:function(obj){///""
					var ansDto=obj.dto;
//					$("textarea[name=textAjax]").val(obj.dto.content);
					$("textarea[name=textAjax]").html(ansDto.content);
				},
				error:function(){
					alert("서버통신 실패");
				}
			})
		}, function(){})
	});
	
	
</script>

<style type="text/css">
   table tr td img{width:13px;height: 13px;}
</style>
<jsp:useBean id="util" class="com.hk.utils.Util"/>
</head>
<body>
<textarea rows="2" cols="60" name="textAjax">
	
</textarea>
	<h1>글목록</h1>
	<form action="muldel.do" method="post">
		<table border="1">
			<col width="50px">
			<col width="50px">
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<col width="50px">
			<col width="50px">
			<col width="50px">
			<col width="60px">
			<col width="50px">
			<tr style="background-color: silver;">
				<th><input type="checkbox" onclick="allsel(this.checked)"></th>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>8</td>
				<td>9</td>
				<td>10</td>
			</tr>
			<tr style="background-color: silver;">
				<th><input type="checkbox" onclick="allsel(this.checked)"></th>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>refer</td>
				<td>step</td>
				<td>deptd</td>
				<td>조회수</td>
				<td>삭제</td>
			</tr>

			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td colspan="10">작성된 글이 없습니다</td>
					</tr>

				</c:when>
				<c:otherwise>
					<c:forEach items='${list}' var="dto">
						<tr>
							<td><input type="checkbox" name="chk" value="${dto.seq}"></td>
							<td>${dto.seq}</td>
							<td>${dto.id }</td>

							<c:choose>
								<c:when test="${dto.deflag =='Y' }">
									<td>-------------삭제된 글입니다--------------</td>
								</c:when>

								<c:otherwise>
															
									<td><jsp:setProperty property="arrowNbsp" name="util" value="${dto.depth}"/>
				                       <jsp:getProperty property="arrowNbsp" name="util"/>
				                       <a href="boarddetail.do?seq=${dto.seq}">${dto.title}</a>
				                       </td>   
								</c:otherwise>
							</c:choose>

							<td><fmt:formatDate value="${dto.regdate }"
									pattern="yyyy.MM.dd" /></td>
							<td>${dto.refer }</td>
							<td>${dto.step }</td>
							<td>${dto.depth }</td>
							<td>${dto.readcount }</td>
							<td>${dto.deflag }</td>
						</tr>
						<!-- <td><a href="AnsControll.do?command=deleteone&seq=${dto.seq }">삭제</a></td> -->
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="10"><input type="button"
					onclick="location.href='insertform.do'"
					value="글추가"> <input type="submit" value="선택글 삭제"></td>
			</tr>

		</table>
	</form>
</body>
</html>