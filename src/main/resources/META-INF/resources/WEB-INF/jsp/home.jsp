<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
		<title>First Blog</title>
	</head>
	
	<body>
		<c:if test="${error eq 'alreadyLogin'}">
        	<div class="alert alert-danger text-center" role="alert">
            	이미 로그인되어 있습니다.
        	</div>
    	</c:if>
    	
		
		<%@include file="common/navigation.jspf" %>
		
		<div class="container pt-2" style="background: #b2c7a8;">
			<c:forEach items="${top5Posts}" var="post">
				<div class="col mb-2 p-1">
					<div class="card">
						<a href="/${post.user.username}/posts/${post.id}" class="text-decoration-none text-body">
							<div class="card-body hover-effect">
								<h5 class="card-title">${post.title}</h5>
								<p class="card-text text-muted">${post.content}</p>
							</div>
						</a>
						
						<div class="card-footer text-muted d-flex justify-content-between">
							<p>작성일: ${post.createdAt.year}-${post.createdAt.monthValue}-${post.createdAt.dayOfMonth}
									${post.createdAt.hour}:${post.createdAt.minute}:${post.createdAt.second}</p>
							<p>작성자: ${post.user.username}</p>
						</div>
					</div>
				</div>
			</c:forEach><br>			
		</div>
		
		<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
		<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>
	
</html>
