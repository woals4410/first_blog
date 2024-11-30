<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>

<html>
  <head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>로그인</title>
	
	<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
	
    <style>
      .form-signin {
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
  
  	<!-- 인증하지 않았을 때 띄우는 메시지 -->
    <c:if test="${param.error == 'unauthorized'}">
    	<script>alert('로그인이 필요합니다');</script>
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
	
	<div class="container vh-100 d-flex justify-content-center align-items-center">
	<main class="form-signin w-100">
	
	  <form action="/login" method="post">
	    <img class="mb-4" src="https://getbootstrap.kr/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
	    <h1 class="h4 mb-3 fw-normal">블로그 로그인</h1>
	
	    <div class="form-floating">
	      <input type="text" name="username" class="form-control" id="floatingInput" placeholder="아이디" />
	      <label for="floatingInput">아이디</label>
	    </div>
	    <div class="form-floating">
	      <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="비밀번호" />
	      <label for="floatingPassword">비밀번호</label>
	    </div>
		
	    <button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
	    
	    <a href="/join" class="btn btn-secondary w-100 py-2 mt-2">회원가입</a>
	    
	  </form>
	  
	</main>
	</div>
	
	<script src="/webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
  </body>
</html>