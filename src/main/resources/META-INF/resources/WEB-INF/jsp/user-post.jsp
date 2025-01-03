<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
			rel="stylesheet">
		<meta charset="UTF-8">
		<title>${username}님의 블로그</title>
		
	</head>
	
	<body>
		<%@include file="common/navigation.jspf" %>
		
		<div class="container mt-1" style="background: #b2c7a8;">
			
			<h1>${username}님의 블로그</h1>
			<hr><br>
			
			<div class="p-4 p-md-5 mb-4 bg-body-secondary text-dark rounded shadow">
				<div class="d-flex justify-content-between align-items-center mb-4">
					<h1 class="fw-bold mb-3">${post.title}</h1>
					<c:if test="${username == authenticatedUsername}">
						<form action="/${username}/posts/${post.id}" method="post">
							<input type="hidden" name="_method" value="DELETE">
							<button type="button" class="btn btn-danger"
								onclick="confirmDelete('${username}', ${post.id})">글 삭제</button>
						</form>
					</c:if>
				</div>
				
				<div class="d-flex justify-content-between align-items-center">
					<span class="text-muted">작성일: ${formattedCreatedAt}</span>
					<span class="text-muted">조회수: ${post.viewCount}</span>
				</div>
				<span class="text-muted">수정일: ${formattedUpdatedAt}</span>
				<hr>
				
				<div class="content">
					<p class="fs-5">${post.content}</p>
				</div>
				
				<div class="d-flex justify-content-between align-items-center">
					<form action="/${username}/posts/${post.id}/like-toggle" method="post">
						<button type="submit" class="btn ${isLiked ? 'btn-danger' : 'btn-outline-danger'}">
							${isLiked ? '좋아요 취소' : '좋아요'}
						</button>
					</form>
					<p>
						좋아요 수: ${likeCount}
					</p>
				</div>
			</div>
			
			<div class="comment mb-3 pb-3">
				<form method="post" action="#">
					<textarea class="form-control" rows="3" placeholder="댓글을 입력 해주세요."
							style="resize: none;"></textarea>
					<button type="submit" class="btn btn-info mt-2">댓글 작성</button>
				</form>
			</div>
		</div>
		
		<script>
			function confirmDelete(username, postId) {
				if (confirm("정말로 삭제하시겠습니까?")) {
					
					const form = document.querySelector(`form[action="/${username}/posts/${postId}"]`);
					form.submit();
				}
			}
		</script>
		
		<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
		<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
		
	</body>

</html>