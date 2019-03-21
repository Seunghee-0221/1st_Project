<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 견적함</title>
<link rel="stylesheet" type="text/css"
	href="${conPath }/semantic/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="${conPath }/semantic/semantic.js"></script>
<style>
.item:hover {
	cursor: pointer;
}

.column {
	text-align: center;
}
table img{
	width:100px;
	height:100px;
}
table tfoot{font-size:1.2em;}

</style>
</head>
<body>
	<c:if test="${empty member }">
		<script>
			location = "${conPath}/main.do";
		</script>
	</c:if>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<c:if test="${empty pLNo }">
		<script>
			alert('견적을 먼저 작성하세요');
			location = "${conPath}/productEstimateView.do";
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div class="ui container">
		<div class="ui grid">
			<div class="ten column row">
				<c:forEach var="idx" begin="1" end="${totCnt }">
					<c:if test="${pageNum eq idx }">
						<div class="column">
							<span class="ui red circular label">${idx }</span>
						</div>
					</c:if>
					<c:if test="${pageNum != idx }">
						<div class="column">
							<a class="ui black circular label"
								href="${conPath }/myEstimateView.do?mId=${member.mId }&pageNum=${idx}">${idx }</a>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<br>
		<table class="ui table">
			<thead>
				<tr>
					<th class="two wide center aligned">대표 이미지</th>
					<th class="two wide center aligned">분류</th>
					<th class="ten wide">상품명</th>
					<th class="two wide center aligned">가격</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty cpu }">
					<tr>
						<td class="center aligned">
							<c:if test="${not empty cpu.pImg }">
								<img src="${conPath }/productImg/${cpu.pImg}"></img>
							</c:if>
							<c:if test="${empty cpu.pImg }">
								<img src="${conPath }/productImg/nothing.jpg">
							</c:if>
						</td>
						<td class="center aligned">${cpu.pCodeName }</td>
						<td>
							<a href="${conPath }/productContentView.do?pNo=${cpu.pNo}"
							onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${cpu.pName }</a>
						</td>
						<td class="center aligned"><fmt:formatNumber value="${cpu.pPrice }" pattern="##,###,###"/> 원</td>
					</tr>
				</c:if>
				<c:if test="${not empty mainboard }">
					<tr>
						<td class="center aligned">
							<c:if test="${not empty mainboard.pImg }">
								<img src="${conPath }/productImg/${mainboard.pImg}"></img>
							</c:if>
							<c:if test="${empty mainboard.pImg }">
								<img src="${conPath }/productImg/nothing.jpg">
							</c:if>
						</td>
						<td class="center aligned">${mainboard.pCodeName }</td>
						<td>
							<a href="${conPath }/productContentView.do?pNo=${mainboard.pNo}"
							onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${mainboard.pName }</a>
						</td>
						<td class="center aligned"><fmt:formatNumber value="${mainboard.pPrice }" pattern="##,###,###"/> 원</td>
					</tr>
				</c:if>
				<c:if test="${not empty ram }">
					<tr>
						<td class="center aligned">
							<c:if test="${not empty ram.pImg }">
								<img src="${conPath }/productImg/${ram.pImg}"></img>
							</c:if>
							<c:if test="${empty ram.pImg }">
								<img src="${conPath }/productImg/nothing.jpg">
							</c:if>
						</td>
						<td class="center aligned">${ram.pCodeName }</td>
						<td>
							<a href="${conPath }/productContentView.do?pNo=${ram.pNo}"
							onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${ram.pName }</a>
						</td>
						<td class="center aligned"><fmt:formatNumber value="${cpu.pPrice }" pattern="##,###,###"/> 원</td>
					</tr>
				</c:if>
				<c:if test="${not empty vga }">
					<tr>
						<td class="center aligned">
							<c:if test="${not empty vga.pImg }">
								<img src="${conPath }/productImg/${vga.pImg}"></img>
							</c:if>
							<c:if test="${empty vga.pImg }">
								<img src="${conPath }/productImg/nothing.jpg">
							</c:if>
						</td>
						<td class="center aligned">${vga.pCodeName }</td>
						<td>
							<a href="${conPath }/productContentView.do?pNo=${vga.pNo}"
							onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${vga.pName }</a>
						</td>
						<td class="center aligned"><fmt:formatNumber value="${vga.pPrice }" pattern="##,###,###"/> 원</td>
					</tr>
				</c:if>
				<c:if test="${not empty ssd }">
					<tr>
						<td class="center aligned">
							<c:if test="${not empty ssd.pImg }">
								<img src="${conPath }/productImg/${ssd.pImg}"></img>
							</c:if>
							<c:if test="${empty ssd.pImg }">
								<img src="${conPath }/productImg/nothing.jpg">
							</c:if>
						</td>
						<td class="center aligned">${ssd.pCodeName }</td>
						<td>
							<a href="${conPath }/productContentView.do?pNo=${ssd.pNo}"
							onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${ssd.pName }</a>
						</td>
						<td class="center aligned"><fmt:formatNumber value="${ssd.pPrice }" pattern="##,###,###"/> 원</td>
					</tr>
				</c:if>
				<c:if test="${not empty hdd }">
					<tr>
						<td class="center aligned">
							<c:if test="${not empty hdd.pImg }">
								<img src="${conPath }/productImg/${hdd.pImg}"></img>
							</c:if>
							<c:if test="${empty hdd.pImg }">
								<img src="${conPath }/productImg/nothing.jpg">
							</c:if>
						</td>
						<td class="center aligned">${hdd.pCodeName }</td>
						<td>
							<a href="${conPath }/productContentView.do?pNo=${hdd.pNo}"
							onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${hdd.pName }</a>
						</td>
						<td class="center aligned"><fmt:formatNumber value="${hdd.pPrice }" pattern="##,###,###"/> 원</td>
					</tr>
				</c:if>
				<c:if test="${not empty pcase }">
					<tr>
						<td class="center aligned">
							<c:if test="${not empty pcase.pImg }">
								<img src="${conPath }/productImg/${pcase.pImg}"></img>
							</c:if>
							<c:if test="${empty pcase.pImg }">
								<img src="${conPath }/productImg/nothing.jpg">
							</c:if>
						</td>
						<td class="center aligned">${pcase.pCodeName }</td>
						<td>
							<a href="${conPath }/productContentView.do?pNo=${pcase.pNo}"
							onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${pcase.pName }</a>
						</td>
						<td class="center aligned"><fmt:formatNumber value="${pcase.pPrice }" pattern="##,###,###"/> 원</td>
					</tr>
				</c:if>
				<c:if test="${not empty power }">
					<tr>
						<td class="center aligned">
							<c:if test="${not empty power.pImg }">
								<img src="${conPath }/productImg/${power.pImg}"></img>
							</c:if>
							<c:if test="${empty power.pImg }">
								<img src="${conPath }/productImg/nothing.jpg">
							</c:if>
						</td>
						<td class="center aligned">${power.pCodeName }</td>
						<td>
							<a href="${conPath }/productContentView.do?pNo=${power.pNo}"
							onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${power.pName }</a>
						</td>
						<td class="center aligned"><fmt:formatNumber value="${power.pPrice }" pattern="##,###,###"/> 원</td>
					</tr>
				</c:if>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="4" class="right aligned">
						합계 : <fmt:formatNumber value="${cpu.pPrice + mainboard.pPrice + ram.pPrice + vga.pPrice + ssd.pPrice + hdd.pPrice + pcase.pPrice + power.pPrice }" pattern="###,###,###"/> 원
					</th>
				</tr>
			</tfoot>
		</table>
		<div class="ui vertical right floated labeled icon buttons">
			<button class="ui button" onclick="location='${conPath}/myEstimateDelete.do?pLNo=${pLNo }&mId=${member.mId }'">
				<i class="trash icon"></i>
				견적 삭제
			</button>
		</div>
		<br>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>