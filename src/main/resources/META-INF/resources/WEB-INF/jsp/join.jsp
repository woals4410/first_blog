<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>회원가입</title>
		
		<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
		
		<style>
			.form-signup {
				max-width: 400px;
				margin: 0 auto;
			}
			
			.form-floating {
				margin-bottom: 15px;
			}
			
			.btn {
				margin-top: 5px;
			}
	
			@media (max-width: 576px) {
				.form-signin {
					max-width: 100%;
					padding: 15px;
				}
			}
			
			.invalid-feedback {
				color: #dc3545;
				font-size: 0.875rem;
				margin-top: 5px;
				display: block;
				font-weight: 400;
			}
	
			.invalid-feedback li {
				margin-left: 20px;  /* 여러 오류 메시지가 있을 경우, 들여쓰기 */
			}
			
		</style>
	</head>
	
	<body>
		<%@include file="common/navigation.jspf" %>
	
		<div class="container vh-100 d-flex justify-content-center align-items-center">
		<main class="form-signup w-100">
			<form:form method="POST" modelAttribute="joinForm">
				<img class="mb-4" src="https://getbootstrap.kr/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
				<h1 class="h3 mb-3 fw-normal">회원가입</h1>
			
				<div class="form-floating">
					<form:input path="email" class="form-control" id="floatingEmail" placeholder="이메일" />
					<form:errors path="email" cssClass="invalid-feedback" />
					<label for="floatingEmail">이메일</label>
				</div>
			
			<div class="form-floating">
				<form:input path="username" class="form-control" id="floatingUsername" placeholder="아이디" />
				<form:errors path="username" cssClass="invalid-feedback" />
				<label for="floatingUsername">아이디</label>
			</div>
			
			<div class="form-floating">
				<form:password path="password" class="form-control" id="floatingPassword" placeholder="비밀번호" />
				<form:errors path="password" cssClass="invalid-feedback" />
				<label for="floatingPassword">비밀번호</label>
			</div>
			
			<div class="form-floating">
				<form:password path="confirmPassword" class="form-control" id="floatingConfirmPassword" placeholder="비밀번호 확인" />
				<form:errors path="confirmPassword" cssClass="invalid-feedback" />
				<label for="floatingConfirmPassword">비민번호 확인</label>
			</div>
			
			<button class="btn btn-primary w-100 py-2" type="submit">회원가입</button>
			
			<a href="/login" class="btn btn-secondary w-100 py-2 mt-2">아이디가 이미 있으신가요? 로그인</a>
			</form:form>
		</main>
		</div>
	
	<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
	<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
	</body>
</html>
