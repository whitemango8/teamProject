<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 쓰기</title>
</head>
<body>
	<form action="/board/register" method="post">
		<table>
			<tr>
				<th colspan="2" >새 피드 쓰기</th>
			</tr>
		
			<tr>
				<td colspan="2" id="title"><input name="title" rows="8"
						cols="50" placeholder="제목을 작성해주세요"></input></td>
			</tr>
			<tr>
				<td colspan="2" id="content"><textarea name="content" rows="8"
						cols="50" placeholder="글을 작성해주세요"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" id="writer"><input name="writer" rows="8"
						cols="50" placeholder="작성자를 작성해주세요"></input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="write-button"
					value="게시하기"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>