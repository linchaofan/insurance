<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
=======
    pageEncoding="UTF-8"%>
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
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
=======
<script src="js/jquery-1.3.2.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<title>保险产品中心</title>
<style>
body{ text-align:center} 
#divcss5{margin:0 auto;border:10px solid #000;width:300px;height:100px} 
</style>
</head>
<body>
<div class="pro_recommend">
    <h2>保险产品中心</h2>
    <ul>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <li>
            <a href="productDetail.action?productCode=${product.code}" class="goods-li-a" target="rightFrame">
                <img class="item-img" src="${product.imgpath}">
                <div class="item-text">
                    <strong>${product.name}</strong>
                    <p>${product.title}<br>${product.shortTitle}</p>
                    <span>查看详情</span>
                </div>
                <i class="i-p-hot"></i>
            </a>
        </li>
    </c:forEach> 
    </ul>
</div>
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
</body>
</html>