<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<form action="/board/list" method="get">
	<table border="1">
		<tr>
				<th colspan="2" >글 상세보기</th>
		</tr>
		
			<tr>
				<td colspan="2"><c:out value="${boardSelect.title }"/></td>
			</tr>
			<tr>	
				<td colspan="2"><c:out value="${boardSelect.content }"/></td>
			</tr>
			<tr>		
				<td colspan="2"><c:out value="${boardSelect.writer }"/></td>
			</tr>	
			<tr>	
				<td colspan="2"><c:out value="${boardSelect.regdate }"/></td>
			</tr>
	</table>
		<a href="/board/modify?bno=${boardSelect.bno }" >수정하기</a>
		<a href="/board/remove?bno=${boardSelect.bno }" >삭제하기</a>
		<input type="submit" class="list-button" value="목록보기">
		
		
	</form>
</body>
</html>