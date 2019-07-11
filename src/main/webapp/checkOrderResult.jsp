<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<c:if test="${errorMsg!=null }">
<p style="font-size:20px;color:red">${errorMsg}</p>
前往<a href="myCheck.action?holderId=${user.id}" >我的核保</a>查看
</c:if>
<c:if test="${errorMsg==null }">
<p style="font-size:20px;color:green;">核保通过！</p>
<a href="payOrder.action?proposalNo=${proposalNo}&checkStatus=4" >点击查看并支付保单</a>
</c:if>
</div>
</body>
</html>