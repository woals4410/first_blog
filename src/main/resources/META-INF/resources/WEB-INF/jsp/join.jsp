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
	
	<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
	
    <style>
      .form-signup {
        max-width: 400px; /* 폼의 최대 너비를 400px로 설정 */
        margin: 0 auto;   /* 화면 가운데 정렬 */
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
    </style>

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
	
	<div class="container vh-100 d-flex justify-content-center align-items-center">
	<main class="form-signup w-100">
	
	  <form:form method="POST" modelAttribute="joinForm">
	    <img class="mb-4" src="https://getbootstrap.kr/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
	    <h1 class="h3 mb-3 fw-normal">회원가입</h1>
		
		<div class="form-floating">
	      <form:input type="email" path="email" class="form-control" id="floatingEmail" placeholder="이메일" required />
	      <label for="floatingUsername">이메일</label>
	    </div>
		
	    <div class="form-floating">
	      <form:input type="text" path="username" class="form-control" id="floatingUsername" placeholder="아이디" required />
	      <label for="floatingUsername">아이디</label>
	    </div>
	
	    <div class="form-floating">
	      <form:input type="password" path="password" class="form-control" id="floatingPassword" placeholder="비밀번호" required />
	      <label for="floatingPassword">비밀번호</label>
	    </div>
	
	    <div class="form-floating">
	      <form:input type="password" path="confirmPassword" class="form-control" id="floatingConfirmPassword" placeholder="비밀번호 확인" required />
	      <label for="floatingConfirmPassword">비민번호 확인</label>
	    </div>
		
	    <button class="btn btn-primary w-100 py-2" type="submit">회원가입</button>
	    
	    <a href="/login" class="btn btn-secondary w-100 py-2 mt-2">아이디가 이미 있으신가요? 로그인</a>
	    
	  </form:form>
	  
	</main>
	</div>
	
	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
  </body>
</html>
