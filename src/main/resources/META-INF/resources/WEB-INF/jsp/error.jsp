<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
				rel="stylesheet">
	
	<title>에러 페이지</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f8d7da;
			color: #721c24;
			margin: 0;
			padding: 20px;
		}
		.error-container {
			max-width: 600px;
			margin: 50px auto;
			padding: 20px;
			border: 1px solid #f5c6cb;
			border-radius: 5px;
			background-color: #f8d7da;
		}
		.error-header {
			font-size: 24px;
			font-weight: bold;
		}
		.error-message {
			margin: 10px 0;
		}
		.error-details {
			font-size: 14px;
			color: #6c757d;
		}
		.home-link {
			display: inline-block;
			margin-top: 20px;
			padding: 10px 20px;
			background-color: #721c24;
			color: #fff;
			text-decoration: none;
			border-radius: 3px;
		}
		.home-link:hover {
			background-color: #50161b;
		}
	</style>
</head>
<body>
	<%@include file="common/navigation.jspf" %>
	
	<div class="error-container">
		<div class="error-header">An Error Occurred</div>
		<p class="error-message">${errorMessage}</p>
		<p class="error-details">
			<strong>HTTP 상태 코드:</strong> ${statusCode}<br>
			<strong>에러 타입:</strong> ${errorClass}
		</p>
		<a href="/" class="home-link">메인 페이지로 이동</a>
	</div>
	
	<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
	<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>
