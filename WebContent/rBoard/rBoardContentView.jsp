<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리뷰/사용기 상세보기</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<script>
		$(document).ready(function(){
			$('.ui.labeled.button.like').click(function(){
				var member = '${member}';
				if(member != ""){
					var rbNo = ${rBoard.rbNo};
					var mId = '${member.mId}';
					if($('input[name="likeState"]').val() == 1){
						$.ajax({
							url : '${conPath}/rBoardLikeUp.do',
							type : 'post',
							data : "rbNo="+rbNo+"&mId="+mId,
							dataType : 'html',
							success : function(data){
								$('#likeArea').html(data);
							}
						});
					} else {
						$.ajax({
							url : '${conPath}/rBoardLikeDown.do',
							type : 'post',
							data : "rbNo="+rbNo+"&mId="+mId,
							dataType : 'html',
							success : function(data){
								$('#likeArea').html(data);
							}
						});
					}
				} else {
					alert('좋아요 하시려면 로그인하세요');
				}
			});
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
				<i class="trophy icon"></i>리뷰/사용기 게시판
			</h2>
		</div>
		<h2 class="ui top attached block header">
			${rBoard.rbTitle }
		</h2>
		<div class="ui bottom attached segment">
			<h5 class="ui left floated header"><i class="user circle icon"></i>${rBoard.mNickname }</h5>
			<h5 class="ui right floated header">조회수 ${rBoard.rbHit } &nbsp; &nbsp; 좋아요 ${rBoard.rbLike } &nbsp;</h5>
			<div class="ui clearing divider"></div>
			${rBoard.rbContent }
			<br><br>
			<div class="centerAlign">
				<c:if test="${empty rbLike }">
					<div class="ui labeled button like" tabindex="0" id="likeArea">
						<input type="hidden" name="likeState" value="1">
						<div class="ui button">
							<i class="heart icon"></i>좋아요
						</div>
						<a class="ui basic label">
							${rBoard.rbLike }
						</a>
					</div>
				</c:if>
				<c:if test="${not empty rbLike }">
					<div class="ui labeled button like" tabindex="0" id="likeArea">
						<input type="hidden" name="likeState" value="2">
						<div class="ui red button">
							<i class="heart icon"></i>좋아요
						</div>
						<a class="ui basic red left pointing label">
							${rBoard.rbLike }
						</a>
					</div>
				</c:if>
			</div>
			<br>
		</div>
		<c:if test="${member.mId eq rBoard.mId or not empty admin }">
			<button class="ui right floated vertical labeled icon button" onclick="location='${conPath}/rBoardDelete.do?rbNo=${param.rbNo }&pageNum=${pageNum }'">
				<i class="trash alternate icon"></i>
				삭제
			</button>
		</c:if>
		<c:if test="${member.mId eq rBoard.mId }">
			<button class="ui right floated vertical labeled icon button" onclick="location='${conPath}/rBoardModifyView.do?rbNo=${param.rbNo }&pageNum=${pageNum }'">
				<i class="edit icon"></i>
				수정
			</button>
		</c:if>
		<br>
		<div class="ui comments" id="comment">
			<h3 class="ui dividing header">Comments</h3>
			<c:forEach var="comment" items="${rbComment }">
				<div class="comment">
					<a class="avatar">
						<i class="user circle icon"></i>
					</a>
					<div class="content">
						<a class="author">${comment.mNickname }</a>
						<div class="metadata">
							<fmt:formatDate value="${comment.rbCDate }" pattern="yyyy.MM.dd hh.mm"/>
							<c:if test="${member.mId eq comment.mId }">
								<i class="x link icon" onclick="location='${conPath}/rBoardCommentDelete.do?rbCNo=${comment.rbCNo }&rbNo=${param.rbNo }'"></i>
							</c:if>
						</div>
						<div class="text">
							${comment.rbComment }
						</div>
					</div>
				</div>
			</c:forEach>
			<form class="ui reply form" id="comment_form" action="${conPath }/rBoardComment.do?rbNo=${param.rbNo}&pageNum=${param.pageNum}" method="post">
				<c:if test="${not empty member }">
					<div class="field">
						<textarea name="rbComment" placeholder="로그인한 회원만 댓글 작성이 가능합니다"></textarea>
					</div>
					<button class="ui right floated primary button">
						<i class="icon edit"></i> 댓글작성
					</button>
					</c:if>
					<c:if test="${empty member }">
						<div class="field">
							<textarea name="rbComment" placeholder="로그인한 회원만 댓글 작성이 가능합니다" disabled="disabled"></textarea>
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
								<a class="icon disabled item"
									href="${conPath }/rBoardView.do?pageNum=1"> <i
									class="angle double left icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum <= 10 }">
								<a class="icon disabled item"
									href="${conPath }/rBoardView.do?pageNum=${pageNum-1}"> <i
									class="left chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum > 10 }">
								<a class="icon item"
									href="${conPath }/rBoardView.do?pageNum=${startPage-1}"> <i
									class="left chevron icon"></i>
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
									href="${conPath }/rBoardView.do?pageNum=${endPage+1}"> <i
									class="right chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${endPage == pageCnt}">
								<a class="icon disabled item"
									href="${conPath }/rBoardView.do?pageNum=${endPage+1}"> <i
									class="right chevron icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum != pageCnt }">
								<a class="icon item"
									href="${conPath }/rBoardView.do?pageNum=${pageCnt}"> <i
									class="angle double right icon"></i>
								</a>
							</c:if>
							<c:if test="${pageNum == pageCnt }">
								<a class="icon disabled item"
									href="${conPath }/rBoardView.do?pageNum=${pageCnt}"> <i
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
					<a class="ui basic button" href="${conPath }/rBoardView.do?pageNum=${param.pageNum}">
						<i class="bars icon"></i>
						목록
					</a>
				</div>
				<c:if test="${not empty member }">
					<div class="right floated content">
						<a class="ui basic button" href="${conPath }/rBoardWriteView.do">
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