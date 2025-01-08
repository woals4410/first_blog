<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
		<title>${username}님의 블로그</title>
		
		<style>
			.form-floating {
				margin-bottom: 15px;
			}
		</style>
	</head>
	
	<body>
		<%@include file="common/navigation.jspf" %>
		
		<div class="container pt-4 pb-3 shadow" style="background-color: #d0d7c9;">
			<form:form method="POST" modelAttribute="postCreateForm">
				
				<div class="form-floating mt-3">
					<form:input path="title" class="form-control" id="floatingUsername" placeholder="아이디" />
					<form:errors path="title" cssClass="invalid-feedback" />
					<label for="floatingUsername">제목</label>
				</div>
				
				<div class="form-floating mb-3">
					<form:textarea path="content" cssClass="form-control" id="floatingContent" placeholder="내용을 입력 해주세요."
						rows="7" style="resize: none; min-height: 300px;" />
						<form:errors path="title" cssClass="invalid-feedback" />
					<label for="floatingContent" class="form-label">내용</label>
				</div>
				
				<div class="container d-flex justify-content-end">
					<a class="btn btn-secondary" href="/${sessionScope.user.username}/posts" style="width: 10%;">취소</a>
					<button class="btn btn-primary ms-2" type="submit" style="width: 10%;">작성</button>
				</div>
			</form:form>
		</div>
		
		
		<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
		<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>
	
</html>
