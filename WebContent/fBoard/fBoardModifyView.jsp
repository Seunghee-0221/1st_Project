<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글수정</title>
<link rel="stylesheet" type="text/css"
	href="${conPath }/semantic/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="${conPath }/semantic/semantic.js"></script>
<script
	src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=xm2s0g4rn0v76xq46qy83s40zk89w5ikf7i2fk07d7xn07up"></script>
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
<script>
	$(document).ready(function(){
		$('#fbFilename').change(function(){
			$('#filename').val($('input[type=file]')[0].files[0].name);
		});
	});
</script>
<style>
	#title {
		text-align: center;
		margin-bottom: 30px;
	}
	#fbFilename {display:none;}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="edit icon"></i>자유게시판 글수정
			</h2>
		</div>
		<form class="ui form" action="${conPath }/fBoardModify.do?pageNum=${param.pageNum}" method="post" enctype="multipart/form-data">
			<input type="hidden" name="fbNo" value="${fBoard.fbNo }">
			<div class="field">
				<label>제목</label> <input type="text" name="fbTitle"
					placeholder="제목" required="required" value="${fBoard.fbTitle }">
			</div>
			<textarea id="image-tools" name="fbContent">
			${fBoard.fbContent }
			</textarea>
			<br>
			<input type="file" id="fbFilename" name="fbFilename">
			<label for="fbFilename">
				<div class="ui action input">
					<input type="text" name="originalFilename" id="filename" readonly="readonly" value="${fBoard.fbFilename }">
					<div class="ui red right labeled icon button">
					    <i class="upload icon"></i>
						파일 업로드
					</div>
				</div>
			</label>
			<br>
			<input type="submit" value="글수정" class="ui right floated primary button">
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>