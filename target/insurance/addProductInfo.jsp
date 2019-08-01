<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="images/jqtransform.css" /> 

<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/jquery.jqtransform.js"></script>
<script language="javascript">
$(function(){
	$('.jqtransform').jqTransform();
});
</script>

<style type="text/css">
.demo{width:680px; margin:10px auto; color:#333; background:#fff}
.page_title{width:680px; height:30px; margin:10px auto 0 auto; text-align:center; font-weight:bold;}
form p{padding:4px; line-height:20px; clear:both}
form p label{display:block; float:left; width:100px; padding-top:2px}
</style>
</head>
<body>
<div>
<form class="jqtransform" action="addProductInfo.action?sellerId=${seller.id }" method="post" enctype="multipart/form-data">
<div align="center" style="font-size:30px ">添加商品信息</div>
		<p><label>商品标识码：</label><input type="text" name="code"/></p>
		<p><label>商品名称：</label><input type="text" name="productName"/></p>
		<p><label>商品类型：</label>
		 <select name="type">
			<option value="yiliao">医疗保险</option>
			<option value="renshou">人寿保险</option>
			<option value="yiwai">意外保险</option>
			<option value="lvyou">旅游保险</option>
		 </select>
		</p>
		<p><label>商品标题：</label><input type="text" name="title"/></p>
		<p><label>短标题：</label><input type="text" name="shortTitle"/></p>
		<p><label>商品介绍：</label>
		<textarea name="introduce" rows="6" cols="40"></textarea>
		</p>
		<p><label>购买须知：</label>
		<textarea name="notice" rows="6" cols="40"></textarea>
		</p>
		<p><label>理赔流程：</label>
		<textarea name="compensationNote" rows="6" cols="40"></textarea>
		</p>
		<p><label>常见问题：</label>
		<textarea name="question" rows="6" cols="40"></textarea>
		</p>
		<p><label>上传图片：</label>
		<input type="file" name="image"/> </p>
		<p><label>&nbsp;</label><input type="submit" value="提交" /> <input type="reset" value="重置" /></p>
	</form>
	</div>
	<c:if test="${errorMsg!=null }">
	<script type="text/javascript" language="javascript">	
			alert("${errorMsg}"); 
		</script>
		</c:if>
</body>
</html>