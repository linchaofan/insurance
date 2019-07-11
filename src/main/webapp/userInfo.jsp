<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<table>
<tr>
<td colspan="2" align="center" style="font-size: 30px; color: blue">
			<b>您的个人信息如下：</b>
		</td></tr>
		<tr><td colspan="2" align="center" style="font-size: 15px">
		<b>姓名：${user.name}</b>
		</td></tr>
		<tr><td colspan="2" align="center" style="font-size: 15px">
		<b>身份证号码：${user.numberId}</b>
		</td></tr>
		<tr><td colspan="2" align="center" style="font-size: 15px">
		<b>手机号码：${user.phone}</b>
		</td></tr>
		<tr><td colspan="2" align="center" style="font-size: 15px">
		<b>性别：${user.gender=='1'?"男":"女"}
		</b>
		</td></tr>
		<tr><td colspan="2" align="center" style="font-size: 15px">
		<b>住址：${user.address}</b>
		</td></tr>
		<tr><td colspan="2" align="center" style="font-size: 15px">
		<b>邮箱：${user.email}</b>
		</td></tr>
</table>
</body>
</html>