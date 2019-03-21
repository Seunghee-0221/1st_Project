<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>자유게시판 상세보기</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<script>
		$(document).ready(function(){
			$('#comment_form').submit(function(){
				var member = '${member}';
				if(member == ""){
					alert('로그인한 회원만 댓글 작성이 가능합니다');
					return false;
				}
			});
		});
	</script>
	<style>
		.centerAlign, #paging{text-align:center;}
		#comment{max-width:none;}
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
				<i class="paper plane icon"></i>자유게시판
			</h2>
		</div>
		<h2 class="ui top attached block header">
			${fBoard.fbTitle }
		</h2>
		<div class="ui bottom attached segment">
			<h5 class="ui left floated header"><i class="user circle icon"></i>${fBoard.mNickname }</h5>
			<h5 class="ui right floated header">조회수 ${fBoard.fbHit } &nbsp;</h5>
			<div class="ui clearing divider"></div>
			${fBoard.fbContent }
			<br>
		</div>
		<c:if test="${not empty fBoard.fbFilename }">
			<div class="ui action input">
				<input type="text" value="${fBoard.fbFilename }" readonly="readonly">
				<a class="ui teal right labeled icon button" href="${conPath }/fBoardUp/${fBoard.fbFilename}" download>
					<i class="download icon"></i>
					다운로드
				</a>
			</div>
		</c:if>
		<c:if test="${member.mId eq fBoard.mId or not empty admin }">
			<button class="ui right floated vertical labeled icon button" onclick="location='${conPath}/fBoardDelete.do?fbNo=${param.fbNo }&pageNum=${pageNum }'">
				<i class="trash alternate icon"></i>
				삭제
			</button>
		</c:if>
		<c:if test="${member.mId eq fBoard.mId }">
			<button class="ui right floated vertical labeled icon button" onclick="location='${conPath}/fBoardModifyView.do?fbNo=${param.fbNo }&pageNum=${pageNum }'">
				<i class="edit icon"></i>
				수정
			</button>
		</c:if>
		<c:if test="${not empty member }">
			<button class="ui right floated vertical labeled icon button" onclick="location='${conPath}/fBoardReplyView.do?fbNo=${param.fbNo }&pageNum=${pageNum }'">
				<i class="reply icon"></i>
				답변글
			</button>
		</c:if>
		<br>
		<div class="ui comments" id="comment">
			<h3 class="ui dividing header">Comments</h3>
			<c:forEach var="comment" items="${fbComment }">
				<div class="comment">
					<a class="avatar">
						<i class="user circle icon"></i>
					</a>
					<div class="content">
						<a class="author">${comment.mNickname }</a>
						<div class="metadata">
							<fmt:formatDate value="${comment.fbCDate }" pattern="yyyy.MM.dd"/>
							<c:if test="${member.mId eq comment.mId }">
								<i class="x link icon" onclick="location='${conPath}/fBoardCommentDelete.do?fbCNo=${comment.fbCNo }&fbNo=${param.fbNo }'"></i>
							</c:if>
						</div>
						<div class="text">
							${comment.fbComment }
						</div>
					</div>
				</div>
			</c:forEach>
			<form class="ui reply form" id="comment_form" action="${conPath }/fBoardComment.do?fbNo=${param.fbNo}&pageNum=${param.pageNum}" method="post">
				<c:if test="${not empty member }">
					<div class="field">
						<textarea name="fbComment" placeholder="로그인한 회원만 댓글 작성이 가능합니다"></textarea>
					</div>
					<button class="ui right floated primary button">
						<i class="icon edit"></i> 댓글작성
					</button>
					</c:if>
					<c:if test="${empty member }">
						<div class="field">
							<textarea name="fbComment" placeholder="로그인한 회원만 댓글 작성이 가능합니다" disabled="disabled"></textarea>
						</div>
						<button class="ui right floated primary button" disabled="disabled">
							<i class="icon edit"></i> 댓글작성
						</button>
					</c:if>
			</form>
		</div>
		<br><br>
		<table class="ui selectable padded table">
			<thead>
				<tr>
					<th class="one wide center aligned">글번호</th>
					<th class="nine wide center aligned">제목</th>
					<th>닉네임</th>
					<th>날짜</th>
					<th>조회</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }">
					<tr>
						<td class="single line">${dto.fbNo }</td>
						<td><a class="item" href="${conPath }/fBoardContentView.do?fbNo=${dto.fbNo}&pageNum=${pageNum}">${dto.fbTitle }</a></td>
						<td>${dto.mNickname }</td>
						<td><fmt:formatDate value="${dto.fbDate }"
								pattern="yyyy.MM.dd" /></td>
						<td>${dto.fbHit }</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="5" id="paging">
						<div class="ui pagination menu">
							<c:if test="${pageNum != 1 }">
								<a class="icon item" href="${conPath }/fBoardView.do?pageNum=1">
									<i class="angle double left icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum == 1 }">
								<a class="icon disabled item"
									href="${conPath }/fBoardView.do?pageNum=1"> <i
									class="angle double left icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum <= 10 }">
								<a class="icon disabled item"
									href="${conPath }/fBoardView.do?pageNum=${pageNum-1}"> <i
									class="left chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum > 10 }">
								<a class="icon item"
									href="${conPath }/fBoardView.do?pageNum=${startPage-1}"> <i
									class="left chevron icon"></i>
								</a>
							</c:if>
							<c:forEach var="i" begin="${startPage }" end="${endPage }">
								<c:if test="${i == pageNum }">
									<a class="active item">${i }</a>
								</c:if>
								<c:if test="${i != pageNum }">
									<a class="item" href="${conPath }/fBoardView.do?pageNum=${i }">${i }</a>
								</c:if>
							</c:forEach>
							<c:if test="${endPage != pageCnt}">
								<a class="icon item"
									href="${conPath }/fBoardView.do?pageNum=${endPage+1}"> <i
									class="right chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${endPage == pageCnt}">
								<a class="icon disabled item"
									href="${conPath }/fBoardView.do?pageNum=${endPage+1}"> <i
									class="right chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum != pageCnt }">
								<a class="icon item"
									href="${conPath }/fBoardView.do?pageNum=${pageCnt}"> <i
									class="angle double right icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum == pageCnt }">
								<a class="icon disabled item"
									href="${conPath }/fBoardView.do?pageNum=${pageCnt}"> <i
									class="angle double right icon"></i>
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
					<a class="ui basic button" href="${conPath }/fBoardView.do?pageNum=${param.pageNum}">
						<i class="bars icon"></i>
						목록
					</a>
				</div>
				<c:if test="${not empty member }">
					<div class="right floated content">
						<a class="ui basic button" href="${conPath }/fBoardWriteView.do">
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