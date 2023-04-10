<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<div>
		<c:url value="/add" var="addUrl" />
		<a href="${addUrl }">선수 추가</a>
	</div>
	<div>
	선수목록
		<ul>
			<c:forEach items="${list }" var="item" varStatus="status">
				<li id="${status.index }">${item }</li>
			</c:forEach>
		</ul>
	</div>
	
	<div>
	이름 수정
		<c:url value="/update" var="updateUrl" />
		<form action="${updateUrl }" method="post">
			<input type="hidden" name="index" id="input1" />
			<input type="text" name="name" id="input2" />
			<input type="submit" value="수정" />
		</form>
	</div>
	
	<!-- 삭제 폼 -->
	<c:url var="deleteUrl" value="/delete" />
	<form action="${deleteUrl }" method="post">
		<input type="hidden" name="index" id="input3" />
		<input type="submit" value="삭제" />
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
	<script>
	
		$("li").click(function() {
			const name = $(this).text();
			const index = $(this).attr("id");
			
			$("#input1").val(index);
			$("#input2").val(name);
			$("#input3").val(index);
		});
	</script>
</body>
</html>