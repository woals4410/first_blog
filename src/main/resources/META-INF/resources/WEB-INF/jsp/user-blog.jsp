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
		
		<style>
			.card-body.hover-effect:hover {
				background-color: #e7f3ff; /* 파스텔 블루 */
				transition: background-color 0.3s ease-in-out;
			}
		</style>
	</head>
	
	<body>
		<c:if test="${param.error == 'post not found'}">
			<script>alert('게시글이 존재하지 않습니다.');</script>
		</c:if>
		<%@include file="common/navigation.jspf" %>
		
		<div class="container mt-1" style="background: #b2c7a8;">
			<h1>${sessionScope.user.username}님의 블로그</h1>
			<hr><br>
			
			<div class="d-flex justify-content-between align-items-center mb-3">
				<h3>게시글 목록</h3>
				<a  href="/${username}/posts/new" class="btn btn-primary">새 글 작성</a>
			</div>
			
			<div class="row row-cols-1 g-4">
				<c:forEach items="${posts}" var="post">
					<div class="col mb-1">
						<div class="card">
							<a href="/${username}/posts/${post.id}" class="text-decoration-none text-body">
								<div class="card-body hover-effect">
									<h5 class="card-title">${post.title}</h5>
									<p class="card-text text-muted">${post.content}</p>
								</div>
							</a>
							
							<div class="card-footer text-muted">
								작성일: ${post.createdAt}
							</div>
						</div>
					</div>
				</c:forEach>
			</div><br>
		</div>
		
		<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
		<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>

</html>