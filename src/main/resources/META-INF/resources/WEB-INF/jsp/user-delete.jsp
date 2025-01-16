<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>

<html>
	<head>

	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    
	    <title>회원탈퇴</title>
		
		<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
				rel="stylesheet">
		
	</head>
  
	<body>
	<%@include file="common/navigation.jspf" %>
	
	<div class="container vh-100 d-flex justify-content-center align-items-center">
		<form:form method="POST" modelAttribute="userDeleteForm">
			<h1 class="h4 mb-3 fw-normal">본인인증</h1>
			
			<form:input path="confirmPassword" cssClass="form-control my-3 p-2" placeholder="비밀번호" />
			<form:errors path="confirmPassword" cssClass="invalid-feedback" />
			
			<input type="hidden" name="_method" value="DELETE">
			<button class="btn btn-primary w-100 py-2 my-2" type="submit">확인 및 <span class="fw-bold" style="color:#ff6b6b;">삭제</span></button>
		</form:form>
	</div>
	
	<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
	<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
  </body>
</html>