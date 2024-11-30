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
		
		<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
			<a class="navbar-brand m-1" href="/">Blog Home</a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
				</ul>
			</div>
			
			<ul class="navbar-nav ms-auto">
				<c:if test="${not empty sessionScope.user}">
					<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
				</c:if>
			
				<c:if test="${empty sessionScope.user}">
					<li class="nav-item"><a class="nav-link" href="/login">로그인</a></li>
				</c:if>
			</ul>	
		</nav>
		
		<div class="container mt-5">
			<h1>${sessionScope.user.username}님의 블로그</h1>
			<hr><br>
			
			<div class="d-flex justify-content-between align-items-center mb-3">
				<h3>게시글 목록</h3>
				<a  href="/${username}/posts/new" class="btn btn-primary">새 글 작성</a>
			</div>
			
			<div class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${posts}" var="post">
					<div class="col">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">${post.title}</h5>
								<p class="card-text">${post.content}</p>
								<a href="/posts/${post.id}" class="btn btn-info">자세히 보기</a>
							</div>
							<div class="card-footer text-muted">
								작성일: ${post.createdAt}
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<script src="/webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
		<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>

</html>