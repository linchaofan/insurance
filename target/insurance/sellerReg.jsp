<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style3.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="js/jquery.min.js"></script> 
<title>Insert title here</title>
</head>
<body>
<div class="aui-register-popup"> 
   <div class="aui-register-box"> 
    <div class="aui-register-link"> 
     <a href="login.jsp" class="fr">已有账号？去登录</a> 
    </div> 
    <br>
    <div class="aui-register-form" id="verifyCheck"> 
     <form action="sellerRegister.action" method="post"> 
      <div class="aui-register-form-item"> 
       <input type="text" name="name" placeholder="名称"  /> 
       <label class="focus valid">
        <div class="msg" style="display:none">
         <i class="icon-tips"></i>您还未输入姓名
        </div></label> 
      </div> 
      <div class="aui-register-form-item"> 
       <input type="password" placeholder="登录密码" name="password" /> 
       <label class="focus valid"></label> 
      </div> 
      
      <div class="aui-register-form-item"> 
       <input type="text" name="company" maxlength="20" placeholder="公司名称" /> 
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