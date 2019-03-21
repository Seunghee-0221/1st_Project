<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰/사용기</title>
<link rel="stylesheet" type="text/css"
	href="${conPath }/semantic/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="${conPath }/semantic/semantic.js"></script>
<style>
#paging {
	text-align: center;
}
#title {
	text-align: center;
	margin:30px 0;
}
</style>
</head>
<body>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="trophy icon"></i>리뷰/사용기 게시판
			</h2>
		</div>
		<table class="ui selectable padded table">
			<thead>
				<tr>
					<th class="one wide center aligned">글번호</th>
					<th class="eight wide center aligned">제목</th>
					<th>닉네임</th>
					<th>날짜</th>
					<th>조회</th>
					<th>좋아요</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }">
					<tr>
						<td class="single line">${dto.rbNo }</td>
						<td><a class="item" href="${conPath }/rBoardContentView.do?rbNo=${dto.rbNo}&pageNum=${pageNum}">${dto.rbTitle }</a></td>
						<td>${dto.mNickname }</td>
						<td><fmt:formatDate value="${dto.rbDate }"
								pattern="yyyy.MM.dd" /></td>
						<td>${dto.rbHit }</td>
						<td>${dto.rbLike }</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="6" id="paging">
						<div class="ui pagination menu">
							<c:if test="${pageNum != 1 }">
								<a class="icon item" href="${conPath }/rBoardView.do?pageNum=1">
									<i class="angle double left icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum == 1 }">
								<a class="icon disabled item">
									<i class="angle double left icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum > 10 }">
								<a class="icon item"
									href="${conPath }/rBoardView.do?pageNum=${startPage-1}">
									<i class="left chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum <= 10 }">
								<a class="icon disabled item">
									<i class="left chevron icon"></i>
								</a>
							</c:if>
							<c:forEach var="i" begin="${startPage }" end="${endPage }">
								<c:if test="${i == pageNum }">
									<a class="active item">${i }</a>
								</c:if>
								<c:if test="${i != pageNum }">
									<a class="item" href="${conPath }/rBoardView.do?pageNum=${i }">${i }</a>
								</c:if>
							</c:forEach>
							<c:if test="${endPage != pageCnt}">
								<a class="icon item"
									href="${conPath }/rBoardView.do?pageNum=${endPage+1}">
									<i class="right chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${endPage == pageCnt}">
								<a class="icon disabled item">
									<i class="right chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum != pageCnt }">
								<a class="icon item"
									href="${conPath }/rBoardView.do?pageNum=${pageCnt}">
									<i class="angle double right icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum == pageCnt }">
								<a class="icon disabled item">
									<i class="angle double right icon"></i>
								</a>
							</c:if>
						</div>
					</th>
				</tr>
			</tfoot>
		</table>
		<div class="ui middle aligned divided list">
			<div class="item">
				<div class="left floated segment">
					<a class="ui basic button" href="${conPath }/rBoardView.do?pageNum=${param.pageNum}">
						<i class="bars icon"></i>
						목록
					</a>
				</div>
				<c:if test="${not empty member }">
					<div class="right floated content">
						<a class="ui basic button" href="${conPath }/rBoardWriteView.do" id="write">
							<i class="pencil alternate icon"></i>
							글쓰기
						</a>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>