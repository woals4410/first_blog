<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
		<title>${sessionScope.user.username}님의 블로그</title>
		
		<style>
			.form-floating {
				margin-bottom: 15px;
			}
		</style>
	</head>
	
	<body>
		<c:if test="${param.error == 'alreadyLogin'}">
			<script>alert('이미 로그인되어 있습니다.');</script>
		</c:if>
		<%@include file="common/navigation.jspf" %>
		
		<div class="container">
			<form:form method="POST" modelAttribute="postCreateForm">
				
				<div class="mb-3">
					<form:textarea path="content" cssClass="form-control" id="floatingContent" placeholder="내용을 입력 해주세요."
						rows="7" style="resize: none;" />
					<label for="floatingContent" class="form-label">내용</label>
				</div>
				
				<div class="form-floating">
					<form:input path="title" class="form-control" id="floatingUsername" placeholder="아이디" />
					<form:errors path="title" cssClass="invalid-feedback" />
					<label for="floatingUsername">아이디</label>
				</div>
			</form:form>
		</div>
		
		
		<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
		<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>
	
</html>
