<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户密码</title>
</head>
<body>
	<form action="changePwd.action" method="post">
		<table>
			<tr>
				<td>手机号码：</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>身份证号码：</td>
				<td><input type="text" name="numberId" /></td>
			</tr>
			<tr>
				<td>初始密码：</td>
				<td><input type="password" name="oldPwd" /></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="password" name="password" id="pw1" /></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="confirmPwd" id="pw2" onkeyup="validate()" /><span id="tishi"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认" /></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
	<script>
		function validate() {
			var pw1 = document.getElementById("pw1").value;
			var pw2 = document.getElementById("pw2").value;
			if (pw1 == pw2) {
				document.getElementById("tishi").innerHTML = "<font color='green'>两次密码相同</font>";
				document.getElementById("submit").disabled = false;
			} else {
				document.getElementById("tishi").innerHTML = "<font color='red'>两次密码不相同</font>";
				document.getElementById("submit").disabled = true;
			}
		}
	</script>
	<div class="error">
		<c:if test="${errorMsg!=null }">
			<font color="red">${errorMsg}</font>
		</c:if>
	</div>
</body>
</html>