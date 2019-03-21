<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 상세보기</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<style>
		.centerAlign, #paging{text-align:center;}
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
	<jsp:include page="../main/header.jsp"/>
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="bullhorn icon"></i>공지사항
			</h2>
		</div>
		<h2 class="ui top attached block header">
			${notice.nTitle }
		</h2>
		<div class="ui bottom attached segment">
			<h5 class="ui left floated header"><i class="user circle icon"></i>${notice.aId }</h5>
			<div class="ui clearing divider"></div>
			${notice.nContent }
			<br>
		</div>
		<c:if test="${notice.aId eq admin.aId or admin.aMaster eq 1 }">
			<button class="ui right floated vertical labeled icon button" onclick="location='${conPath}/noticeDelete.do?nNo=${param.nNo }&pageNum=${pageNum }'">
				<i class="trash alternate icon"></i>
				삭제
			</button>
		</c:if>
		<c:if test="${notice.aId eq admin.aId }">
			<button class="ui right floated vertical labeled icon button" onclick="location='${conPath}/noticeModifyView.do?nNo=${param.nNo }&pageNum=${pageNum }'">
				<i class="edit icon"></i>
				수정
			</button>
		</c:if>
		<br><br>
		<table class="ui selectable padded table">
			<thead>
				<tr>
					<th class="one wide center aligned">글번호</th>
					<th class="ten wide center aligned">제목</th>
					<th>관리자명</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }">
					<tr>
						<td class="single line">${dto.nNo }</td>
						<td><a class="item" href="${conPath }/noticeContentView.do?nNo=${dto.nNo}&pageNum=${pageNum}">${dto.nTitle }</a></td>
						<td>${dto.aId }</td>
						<td><fmt:formatDate value="${dto.nDate }"
								pattern="yyyy.MM.dd" /></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="4" id="paging">
						<div class="ui pagination menu">
							<c:if test="${pageNum != 1 }">
								<a class="icon item" href="${conPath }/noticeView.do?pageNum=1">
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
									href="${conPath }/noticeView.do?pageNum=${startPage-1}">
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
									<a class="item" href="${conPath }/noticeView.do?pageNum=${i }">${i }</a>
								</c:if>
							</c:forEach>
							<c:if test="${endPage != pageCnt}">
								<a class="icon item"
									href="${conPath }/noticeView.do?pageNum=${endPage+1}">
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
									href="${conPath }/noticeView.do?pageNum=${pageCnt}">
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
				<div class="left floated content">
					<a class="ui basic button" href="${conPath }/noticeView.do?pageNum=${param.pageNum}">
						<i class="bars icon"></i>
						목록
					</a>
				</div>
				<c:if test="${not empty admin }">
					<div class="right floated content">
						<a class="ui basic button" href="${conPath }/noticeWriteView.do">
							<i class="pencil alternate icon"></i>
							글쓰기
						</a>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>