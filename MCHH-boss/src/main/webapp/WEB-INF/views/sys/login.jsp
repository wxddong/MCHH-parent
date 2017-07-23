<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="basePath" value="<%=basePath%>" /> 
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>妇幼健康信息管理平台_登录</title>
		<link rel="shortcut icon"
			href="${ctx}/static/common/images/title_logo.png">
		<!--[if lt IE 9]>
  
   <script src="plug-in/login/js/html5.js"></script>
  <![endif]-->
		<!--[if lt IE 7]>
  <script src="plug-in/login/js/iepng.js" type="text/javascript"></script>
  <script type="text/javascript">
	EvPNG.fix('div, ul, img, li, input'); //EvPNG.fix('包含透明PNG图片的标签'); 多个标签之间用英文逗号隔开。
</script>
<link rel="stylesheet" type="text/css"  href="${ctx}/static/common/css/css/icon.css"/>
  <![endif]-->
  <style type="text/css">
		.formLogin .tip.tc{text-align:center;width:100px;}
		label.iPhoneCheckLabelOn span {
			padding-left: 0px
		}
		#versionBar {
			background-color: #212121;
			position: absolute ;
			width: 100%;
			height: 35px;
			bottom: 0;
			left: 0;
			text-align: center;
			line-height: 35px;
			z-index: 11;
			-webkit-box-shadow: black 0px 10px 10px -10px inset;
			-moz-box-shadow: black 0px 10px 10px -10px inset;
			box-shadow: black 0px 10px 10px -10px inset;
		}
		
		.copyright {
			text-align: center;
			font-size: 10px;
			color: #CCC;
		}
		
		.copyright a {
			color: #A31F1A;
			text-decoration: none
		}
		/*update-begin--Author:tanghong  Date:20130419 for：【是否】按钮错位*/
		.on_off_checkbox {
			width: 0px;
		}
		
		/*update-end--Author:tanghong  Date:20130419 for：【是否】按钮错位*/
		#login .login_btn{
	background: url("${ctx}/static/common/images/login_btn.png") repeat-x;
    border: 1px solid #2f85d4;
    border-radius: 4px;
    color: #fff;
    cursor: pointer; 
    padding-left:0;
    font-family: "微软雅黑","宋体";
    font-size: 14px;
    height: 32px;
    line-height: 22px;
    margin-top: 25px;
    width: 100px;}
	</style>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/zice.style.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/buttons.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/tipsy.css" media="all" />
	
	
	</head>
	<body>
	<script>
	  /* 刷新父窗口登陆页面 */
	if (window.parent != window) {
		window.parent.location.href = window.location.href;
	}
	</script>
<div class="loginTop">
	<img src="${ctx}/static/common/images/359t_fuyoujiankang.png" />
</div>	
<div id="login_repeat">		
<div id="alertMessage"></div>
  <div id="successLogin"></div>
  <div class="text_success">
   <img src="${ctx}/static/common/images/loader_green.gif" alt="Please wait" />
   <span>登录成功!请稍后....</span>
  </div>
  <div class="logintop">
  	<h2>账号登录</h2>
  </div>
  <div id="login">
   <div class="ribbon"></div>
   <div class="inner">
    <div class="formLogin">
     <form name="formLogin" id="formLogin" action="${ctx}/login" check="${basePath}"  method="post">
     <input type="hidden" name="password" id="md5password"/>
      <div class="tip">
       <span class="tipspan">用户名：</span><input class="userName" name="loginName" type="text" id="userName"  iscookie="true" nullmsg="请输入用户名!"/>
      </div>
      <div class="tip">
       <span class="tipspan">密&nbsp&nbsp&nbsp&nbsp码：</span><input class="password" type="password" id="password"  nullmsg="请输入密码!"/><label class="check"><input type="checkbox">记住密码</label>
      </div>
      <div class="tc tip">          
       <input type="button" id="but_login" style="left:450px" value="登 录" class="btn"/>
      </div>
     </form>
    </div>
   </div>
  </div>
  <!--Login div-->
  <div class="clr"></div>
  </div>
  <div id="versionBar">
   <div class="copyright">
    &copy; 版权所有  三五九通(北京)科技有限公司
<!--     <span class="tip">(推荐使用IE可以获得更快,更安全的页面响应速度)技术支持:</span> -->
   </div>
  </div>
  <script type="text/javascript" src="${ctx}/static/common/js/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="${ctx}/static/common/js/jquery.cookie.js"></script>
  <script type="text/javascript" src="${ctx}/static/common/js/jquery-jrumble.js"></script>
  <script type="text/javascript" src="${ctx}/static/common/js/jquery.tipsy.js"></script>
  <script type="text/javascript" src="${ctx}/static/common/js/iphone.check.js"></script>
    <script type="text/javascript" src="${ctx}/static/common/js/jquery.md5.js"></script>
  <script type="text/javascript" src="${ctx}/static/sys/login.js"></script>
  <script type="text/javascript" src="${ctx}/static/common/js/easyui-lang-zh_CN.js"></script>
	</body>
</html>
