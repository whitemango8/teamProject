<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<form action="/board/modify" method="post">
		<table>
			<tr>
				<th colspan="2" >글 수정하기</th>
				
			</tr>
			<tr>
				<td colspan="2"><input name="writer" value="${boardSelect.writer }" readonly/></td>
			</tr>
			<tr>
				<td colspan="2"><input name="regdate" value="${boardSelect.regdate }" readonly/></td>
			</tr>
				<tr>
				<td colspan="2"><input name="title" value="${boardSelect.title }"/></td>
			</tr>
			<tr>	
				<td colspan="2"><input name="content" value="${boardSelect.content }"/></td>
			</tr>
		
		</table>
		<input type="submit" class="update-button" value="수정하기">
	<input type="button" class="list-button" value="목록보기">
		
	</form>
</body>
</html>