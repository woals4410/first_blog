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
		
		<style>
			.comment-list .card {
				border: 1px solid #ddd; /* 연한 테두리 */
				border-radius: 8px; /* 둥근 모서리 */
				box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 약간의 그림자 */
				background-color: #f9f9f9; /* 부드러운 배경색 */
			}
			.commentTextForm {
				background-color: #f9f9f9; /* 부드러운 배경색 */
			}
		</style>
	</head>
	
	<body>
		<%@include file="common/navigation.jspf" %>
		
		<div class="container py-3" style="background: #b2c7a8;">
			
			<h1>${username}님의 블로그</h1>
			<hr><br>
			
			<div class="border-left border-right p-4 mb-4 bg-body-secondary text-dark rounded shadow">
				<div class="d-flex justify-content-between align-items-center">
					<h1 class="fw-bold mb-3">${post.title}</h1>
					<c:if test="${username == authenticatedUsername}">
						<div>
							<form action="/${username}/posts/${post.id}" method="post">
								<input type="hidden" name="_method" value="DELETE">
								<button type="button" class="btn btn-danger"
									onclick="confirmDeletePost('${username}', ${post.id})">글 삭제</button>
							</form>
						</div>
					</c:if>
				</div>
				<div class="d-flex justify-content-end mb-4">
					<c:if test="${username == authenticatedUsername}">
						<form action="/${username}/posts/${post.id}/edit" class="ms-3">
							<button type="submit" class="btn btn-info">수정</button>
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
			
			<div class="m-2 p-3 bg-body rounded shadow">
				<h2 class="fw-bold fs-4 py-2">댓글</h2>
				<div class="comment-list ">
					<ul class="card mx-2 px-2" style="list-style:none;">
						<c:forEach items="${comments}" var="comment">
							<li class="card-body">
								<div class="d-flex justify-content-between">
									<div>
										<h5 class="card-title">${comment.user.username}</h5>
										<p class="card-text ps-2">${comment.content}</p>
									</div>
									<c:if test="${authenticatedUsername == comment.user.username}">
										<form action="/${username}/posts/${post.id}/comments/${comment.id}" method="post" class="ms-3">
											<input type="hidden" name="_method" value="DELETE">
											<button type="submit" class="comment-delete-button btn btn-link text-danger btn-sm">
													삭제
											</button>
										</form>
									</c:if>
								</div>
								<div class="text-muted mt-1">
									작성일: ${post.createdAt}
								</div>
							</li>
							<hr>
						</c:forEach>
					</ul>
				</div>
				
				<form:form  action="/${username}/posts/${postId}/createComment" method="POST" modelAttribute="commentCreateForm">
					<div class="d-flex justify-content-between align-items-stretch pt-3">
						<form:textarea path="content" rows="3" placeholder="댓글을 입력 해주세요."
							cssClass="form-control commentTextForm" cssStyle="resize: none;" />
						<button type="submit" class="btn m-1 py-3 fs-6 text-nowrap fw-bold h-100" style="background: #7facd3;">댓글 작성</button>
					</div>
					<c:if test="${error eq 'ContentBlank'}">
						<span class="invalid-feedback d-block px-2">내용을 입력해주세요.</span>
					</c:if>
				</form:form>
			</div>
		</div>
		
		<script>
			function confirmDeletePost(username, postId) {
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