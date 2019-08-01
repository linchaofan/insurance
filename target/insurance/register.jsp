<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style3.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="js/jquery.min.js"></script> 
<title>用户注册</title>
</head>
<body>
	<div class="aui-register-popup"> 
   <div class="aui-register-box"> 
    <div class="aui-register-link"> 
     <a href="login.jsp" class="fr">已有账号？去登录</a> 
    </div> 
    <br>
    <div class="aui-register-form" id="verifyCheck"> 
     <form action="register.action" method="post"> 
      <div class="aui-register-form-item"> 
       <input type="text" name="name" placeholder="姓名" id="phone" /> 
       <label class="focus valid">
        <div class="msg" style="display:none">
         <i class="icon-tips"></i>您还未输入姓名
        </div></label> 
      </div> 
      <div align="center"> 
           性别:<input type="radio" name="gender" checked="checked"
					value="1" id="man" />男&nbsp;&nbsp; <input type="radio"
					name="gender" value="2" id="women" />女
      </div>
      <div class="aui-register-form-item"> 
       <input type="text" placeholder="身份证号码" name="numberId" /> 
       <label class="focus valid"></label> 
      </div> 
      
      <div class="aui-register-form-item"> 
       <input type="text" name="phone" maxlength="20" placeholder="手机号码" /> 
       <label class="focus valid"></label> 
      </div> 
       
      <div class="aui-register-form-item"> 
       <input type="text" name="address" placeholder="住址" /> 
       <label class="focus valid"></label> 
      </div> 
       <div class="aui-register-form-item"> 
       <input type="text" name="email" placeholder="电子邮箱" /> 
       <label class="focus valid"></label> 
      </div> 
      
      <div class="aui-register-form-item"> 
       <input type="password" name="password" placeholder="登录密码" /> 
       <label class="focus valid"></label> 
      </div> 
      <div class="aui-register-form-item"> 
       <input type="text" name="birth" placeholder="出生日期" /> 
       <label class="focus valid"></label> 
      </div> 
      <div class="aui-register-form-item"> 
       <div class="protocol">
        注册即同意
        <a href="#">《用户使用协议》</a>&amp;
        <a href="#">《隐私权条款》</a>
       </div> 
       <input type="submit" class="aui-btn-reg" placeholder=""  value="注册" /> 
      </div> 
     </form> 
    </div> 
    </div>
	<div class="error" align="center">
		<c:if test="${errorMsg!=null }">
			<font color="red">${errorMsg}</font>
		</c:if>
	</div>
	</div>
</body>
</html>