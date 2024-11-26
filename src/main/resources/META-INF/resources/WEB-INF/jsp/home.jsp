<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
		<title>First Blog</title>
	</head>
	
	<body>
		
		<c:if test="${param.error == 'alreadyLogin'}">
			<script>alert('이미 로그인되어 있습니다.');</script>
		</c:if>
		
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
		
		<!-- 
			여기에 내용
		 -->
		
		<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>
	
</html>