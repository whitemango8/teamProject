<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

	var msg = true;
	
	<c:if test="${!empty alert}">
	 if(msg){
		 alert("${alert}");
		 msg = false;
	 }
	</c:if>


/*
	$(document).ready(function() {
		alert("${alert}");
	})
*/
</script>
</head>
<body>

	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>regdate</th>
		</tr>
		<c:forEach var="VO" items="${boardList }">
			<tr>
				<td><c:out value="${VO.bno }"/></td>
				<td><a href="/board/get?bno=${VO.bno }"><c:out value="${VO.title }"/></a></td>
				<td><c:out value="${VO.content }"/></td>
				<td><c:out value="${VO.writer }"/></td>
				<td><c:out value="${VO.regdate }"/></td>
			</tr>
		</c:forEach>
		
	</table>
	
	<a href="/board/register">글쓰기</a> <!-- BoardController접근 -->
</body>
</html>