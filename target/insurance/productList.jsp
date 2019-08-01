<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-1.3.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<title>保险产品中心</title>
<style>
body {
	text-align: center
}

#divcss5 {
	margin: 0 auto;
	border: 10px solid #000;
	width: 300px;
	height: 100px
}
</style>
</head>
<body>
	<div class="pro_recommend">
		<h2>保险产品中心</h2>
		<ul>
			<c:forEach var="product" items="${productList}" varStatus="status">
				<li><c:if test="${user!=null }">
						<a href="productDetail.action?productCode=${product.code}"
							class="goods-li-a" target="rightFrame"> <img class="item-img"
							src="${product.imgpath}">
							<div class="item-text">
								<strong>${product.name}</strong>
								<p>${product.title}<br>${product.shortTitle}</p>
								<span>查看详情</span>
							</div> <i class="i-p-hot"></i>
						</a>
					</c:if> <c:if test="${seller!=null }">
						<a href="" class="goods-li-a" target="rightFrame"> <img
							class="item-img" src="${product.imgpath}">
							<div class="item-text">
								<strong>${product.name}</strong>
								<p>${product.title}<br>${product.shortTitle}</p>
								<span>查看详情</span>
							</div> <i class="i-p-hot"></i>
						</a>
					</c:if>
					<c:if test="${user==null and seller==null}">
						<a href="productDetail.action?productCode=${product.code}"
							class="goods-li-a" target="rightFrame"> <img class="item-img"
							src="${product.imgpath}">
							<div class="item-text">
								<strong>${product.name}</strong>
								<p>${product.title}<br>${product.shortTitle}</p>
								<span>查看详情</span>
							</div> <i class="i-p-hot"></i>
						</a>
					</c:if>
					</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>