<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
		<meta charset="UTF-8">
		<title>${sessionScope.user.username}님의 블로그</title>
		
	</head>
	
	<body>
		<%@include file="common/navigation.jspf" %>
		
		<div class="container mt-1" style="background: #b2c7a8;">
			
			<h1>${sessionScope.user.username}님의 블로그</h1>
			<hr><br>
			
			<div class="p-4 p-md-5 mb-4 bg-body-secondary text-dark rounded shadow">
				<div class="d-flex justify-content-between align-items-center mb-4">
					<h1 class="fw-bold mb-3">${post.title}</h1>
					<form action="/${sessionScope.user.username}/posts/${post.id}" method="post">
						<input type="hidden" name="_method" value="DELETE">
						<button type="submit" class="btn btn-danger">글 삭제</button>
					</form>
				</div>
				
				<div class="d-flex justify-content-between align-items-center">
					<span class="text-muted">작성일: ${formattedCreatedAt}</span>
					<span class="text-muted">조회수: ${post.viewCount}</span>
				</div>
				<span class="text-muted">수정일: ${formattedUpdatedAt}</span>
				<hr>
				
				<div class="content">
					<p class="fs-5">${post.content}</p>
				</div>
			</div>
			
			<div class="comment mb-3 pb-3">
				<textarea class="form-control" rows="3" placeholder="댓글을 입력 해주세요."
						style="resize: none;"></textarea>
				<button class="btn btn-info mt-2" formmethod="post" formaction="">댓글 작성</button>
			</div>
		</div>
		
		<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
		<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>

</html>