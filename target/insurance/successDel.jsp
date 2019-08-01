<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除记录</title>
</head>
<body>
<c:if test="${user!=null }">
Response.Write("<script>alert('删除成功！');location.href='myCheck.action?holderId=${user.id}';</script>");</c:if>
<c:if test="${seller!=null }">
Response.Write("<script>alert('删除成功！');location.href='deleteProduct.action?sellerId=${seller.id}';</script>");
</c:if>
</body>
</html>