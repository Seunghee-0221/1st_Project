<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>뉴스/정보 글쓰기</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=xm2s0g4rn0v76xq46qy83s40zk89w5ikf7i2fk07d7xn07up"></script>
	<script>
		tinymce.init({
			selector : 'textarea#image-tools',
			height : 500,
			plugins : [
					"advlist autolink lists link image charmap print preview anchor",
					"searchreplace visualblocks code fullscreen",
					"insertdatetime media table paste imagetools wordcount" ],
			toolbar : "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
			content_css : [
					'//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
					'//www.tiny.cloud/css/codepen.min.css' ]
		});
	</script>
	<style>
		#title {
			text-align: center;
			margin-bottom: 30px;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="pencil alternate icon"></i>뉴스/정보 글쓰기
			</h2>
		</div>
		<form class="ui form" action="${conPath }/nBoardWrite.do" method="post">
			<input type="hidden" name="mId" value="${member.mId }">
			<div class="field">
				<label>제목</label> <input type="text" name="nbTitle"
					placeholder="제목" required="required">
			</div>
			<textarea id="image-tools" name="nbContent">
			</textarea>
			<br>
			<input type="submit" value="글작성" class="ui right floated primary button">
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>