<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link rel="stylesheet" href="<%=path %>/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="<%=path %>/css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="<%=path %>/css/invalid.css" type="text/css" media="screen" />
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/simpla.jquery.configuration.js"></script>
	
	<script type="text/javascript">
	    function logout()
		{
		   if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="<%=path %>/login.jsp";
		   }
		}
	</script>
	
  </head>
  
<body>
    <div id="sidebar">
	    <div id="sidebar-wrapper">
		      <div id="profile-links">
		           <br /><br /><br />
		           <c:if test="${user!=null }">
		           <a href="#" style="font-family: 微软雅黑;font-size: 15px;color:black">你好,${user.name}!</a>&nbsp;&nbsp;&nbsp;</c:if>
		           <c:if test="${seller!=null }">
		           <a href="#" style="font-family: 微软雅黑;font-size: 15px;color:black">你好,${seller.name}!</a>&nbsp;&nbsp;&nbsp;</c:if>
		           <c:if test="${user==null and seller==nnull }">
		           <a href="#" style="font-family: 微软雅黑;font-size: 15px;color:black">你好,游客!</a>&nbsp;&nbsp;&nbsp;</c:if>
		           <a href="#" style="font-family: 微软雅黑;font-size: 15px;color:blue" onclick="logout()">退出</a>&nbsp;&nbsp;
		           <c:if test="${user!=null or seller!=null}">
		           <a href="<%=path %>/changePwd.jsp" target="rightFrame" style="font-family: 微软雅黑;font-size: 15px;color:blue">修改密码</a></c:if>
		      </div>
		      <ul id="main-nav">
		      <c:if test="${user!=null }">
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 18px;color:black;">个人中心</a>
			          <ul>
			            <li><a href="orderList.action?holderId=${user.id}"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">我的订单</a></li>
			            <li><a href="myPolicy.action?holderId=${user.id}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">我的保单</a></li>
			            <li><a href="myCheck.action?holderId=${user.id}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">我的核保</a></li>
			            <li><a href="<%=path %>/userInfo.jsp" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">我的信息</a></li>
			            <li><a href="myWallet.action?holderPhone=${user.phone}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">我的钱包</a></li>
			          </ul>
			       </li>
			       </c:if>
			       <c:if test="${user==null and seller==null }">
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 18px;color:black;">个人中心</a>
			          <ul>
			            <li><a href="orderList.action?holderId=${user.id}"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">我的订单</a></li>
			            <li><a href="myPolicy.action?holderId=${user.id}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">我的保单</a></li>
			            <li><a href="myCheck.action?holderId=${user.id}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">我的核保</a></li>
			            <li><a href="<%=path %>/userInfo.jsp" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">我的信息</a></li>
			            <li><a href="myWallet.action?holderPhone=${user.phone}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">我的钱包</a></li>
			          </ul>
			       </li>
			       </c:if>
			       <c:if test="${seller!=null }">
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 18px;color:black;">管理中心</a>
			          <ul>
			            <li><a href="productList.action?sellerId=${seller.id}"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">产品列表</a></li>
			            <li><a href="addProductInfo.jsp" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">添加产品</a></li>
			            <li><a href="deleteProduct.action?sellerId=${seller.id}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">删除产品</a></li>
			            <li><a href="sellerCheckList.action?sellerId=${seller.id}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">核保列表</a></li>
			            <li><a href="sellerOrderList?sellerId=${seller.id}" target="rightFrame" style="font-family: 微软雅黑;font-size: 13px;">订单列表</a></li>
			          </ul>
			       </li>
			       </c:if>
			       <li></li>
			       <c:if test="${user!=null }">
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 23px;color:green;">医疗保险</a>
			          <ul>
			            <li><a href="getProduct.action?typeCode=yiliao"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">医疗保险</a></li>
			          </ul>
			       </li>
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 23px;color:orange;">人寿保险</a>
			          <ul>
			            <li><a href="getProduct.action?typeCode=renshou"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">人寿保险</a></li>
			          </ul>
			       </li>
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 23px;color:red;">意外保险</a>
			          <ul>
			            <li><a href="getProduct.action?typeCode=yiwai"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">意外保险</a></li>
			          </ul>
			       </li>
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 23px;color:blue;">旅游保险</a>
			          <ul>
			            <li><a href="getProduct.action?typeCode=lvyou"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">旅游保险</a></li>
			          </ul>
			       </li>
			       </c:if>
			       <c:if test="${user==null and seller==null }">
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 23px;color:green;">医疗保险</a>
			          <ul>
			            <li><a href="getProduct.action?typeCode=yiliao"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">医疗保险</a></li>
			          </ul>
			       </li>
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 23px;color:orange;">人寿保险</a>
			          <ul>
			            <li><a href="getProduct.action?typeCode=renshou"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">人寿保险</a></li>
			          </ul>
			       </li>
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 23px;color:red;">意外保险</a>
			          <ul>
			            <li><a href="getProduct.action?typeCode=yiwai"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">意外保险</a></li>
			          </ul>
			       </li>
			       <li><a href="#" class="nav-top-item" style="font-family: 微软雅黑;font-size: 23px;color:blue;">旅游保险</a>
			          <ul>
			            <li><a href="getProduct.action?typeCode=lvyou"  target="rightFrame"style="font-family: 微软雅黑;font-size: 13px;">旅游保险</a></li>
			          </ul>
			       </li>
			       </c:if>
	          </ul>    
	    </div>
    </div>
</body>
</html>
