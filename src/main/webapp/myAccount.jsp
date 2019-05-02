<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的账户余额</title>
</head>
<body>
<form action="recharge.action" method="post">
<div align="center">
<p>钱包主人:${pay.userName }</p>
<p>钱包余额:<a style="color:red;font-size:25px">${pay.account }元</a></p>
</div>
<div align="center">
<input type="text" name="money" id="money">&nbsp;&nbsp;&nbsp;<input type="submit" value="充值" style="color:blue">
</div>
</form>
</body>
</html>