<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<div id="app">
		<div class="login_warp">
			<div class="loginbox fl">
				<div class="login_header">
					<span @click="cur=0" :class="{active:cur==0}">用户登录</span>
					<span @click="cur=1" :class="{active:cur==1}">承保方登录</span>
<<<<<<< HEAD
					<a href="visitorLogin.action" >游客登录</a>
=======
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
				</div>
				<div class="login_content">
				<form action="userLogin.action" method="post">
					<div v-show="cur==0" class="Cbody_item">
						<div class="form_item"><input type="text" name="phone" placeholder="手机号码"></div>
						<div class="form_item"><input type="password" name="pwd" placeholder="密码"></div>
						<div class="form_item">
							<div class="fl"><input type="checkbox">记住密码</div>
							<div class="fr">没有账户？<a href="register.jsp">去注册</a></div>
						</div>
						<div class="clear"></div>
						<div class="form_item">
							<input type="submit" name="" value="登录">
						</div>
					</div>
					</form>
					<form action="sellerLogin.action" method="post">
					<div v-show="cur==1" class="Cbody_item">
						<div class="form_item"><input type="text" name="sname" placeholder="用户名"></div>
						<div class="form_item"><input type="password" name="spwd" placeholder="密码"></div>
						<div class="form_item">
							<div class="fl"><input type="checkbox">记住密码</div>
							<div class="fr">没有账户？<a href="sellerReg.jsp">去注册</a></div>
						</div>
						<div class="clear"></div>
						<div class="form_item">
							<input type="submit" name="" value="登录">
						</div>

					</div>
					</form>
				</div>
			</div>
			<div class="loginrslider fl"></div>
		</div>
	</div>
	<div align="center">
		<c:if test="${errorMsg!=null }">
			<font color="red">${errorMsg}</font>
		</c:if>
	</div>
</body>
<script type="text/javascript" src="js/html5shiv.min.js"></script>
<script type="text/javascript" src="js/vue.js"></script>
<script type="text/javascript">
	var app = new Vue({
            el: "#app",
            data: {
                cur:0 //默认选中第一个tab
            }
        });    
</script>
</html>

