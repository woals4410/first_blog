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
		<c:if test="${param.error == 'alreadyLogin'}">
			<script>alert('이미 로그인되어 있습니다.');</script>
		</c:if>
		
		<%@include file="common/navigation.jspf" %>
		
		<!-- 
			여기에 내용
		 -->
		
		<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
		<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>
	
</html>
