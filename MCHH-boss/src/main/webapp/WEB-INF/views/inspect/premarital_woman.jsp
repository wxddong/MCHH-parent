<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="basePath" value="<%=basePath%>" /> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>0女性婚前医学检查表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/premarital-styles.css" type="text/css" rel="stylesheet"/>
   </head>
   
	<style type="text/css">
	
	body {
		margin:0px auto;
		}
		#u666 {
		position:fixed;
		left: 0px;
		top: 0px;
		width:1177px;
		line-height:44px;
		z-index:9999;
		background: #FFFFFF; 
		border:1px solid;
	}
	#u00 {
	  position:absolute;
	  left:1px;
	  top:34px;
	  width:719px;
	  height:346px;
	}
	#u01 {
	  position:absolute;
	  left:2px;
	  top:165px;
	  width:715px;
	  visibility:hidden;
	  word-wrap:break-word;
	}
	#u02 {
	  position:absolute;
	  left:0px;
	  top:0px;
	  width:217px;
	  height:36px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#u03 {
	  position:absolute;
	  left:2px;
	  top:10px;
	  width:213px;
	  word-wrap:break-word;
	}
	#u04 {
	  position:absolute;
	  left:410px;
	  top:216px;
	  width:120px;
	  height:44px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#u05 {
	  position:absolute;
	  left:2px;
	  top:14px;
	  width:116px;
	  word-wrap:break-word;
	}
	#u06 {
	  position:absolute;
	  left:190px;
	  top:216px;
	  width:120px;
	  height:44px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#u07 {
	  position:absolute;
	  left:2px;
	  top:14px;
	  width:116px;
	  word-wrap:break-word;
	}
	#u08 {
	  position:absolute;
	  left:231px;
	  top:103px;
	  width:258px;
	  height:16px;
	  font-size:16px;
	  color:#000000;
	  text-align:center;
	}
	#u09 {
	  position:absolute;
	  left:0px;
	  top:0px;
	  width:258px;
	  white-space:nowrap;
	}
	#su252 {
	  position:absolute;
	  left:5px;
	  top:9px;
	  width:100px;
	  height:36px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#su253 {
	  position:absolute;
	  left:-28px;
	  top:10px;
	  width:157px;
	  word-wrap:break-word;
	}
	.in{
	  left:-3px;
	  top:-2px;
	}
	.ps{
	 position:absolute;
	  left:16px;
	  top:0px;
	  width:232px;
	  word-wrap:break-word;	
	}
	#su282 {
	  position:absolute;
	  left:34px;
	  top:80px;
	  width:84px;
	  height:19px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  font-size:16px;
	  color:#EE5F45;
	}
	#su283 {
	  position:absolute;
	  left:0px;
	  top:0px;
	  width:84px;
	  white-space:nowrap;
	}
	#su284 {
	  position:absolute;
	  left:352px;
	  top:80px;
	  width:94px;
	  height:19px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  font-size:16px;
	  color:#EE5F45;
	}
	#su285 {
	  position:absolute;
	  left:0px;
	  top:0px;
	  width:94px;
	  white-space:nowrap;
	}
	#su286 {
	  position:absolute;
	  left:669px;
	  top:80px;
	  width:94px;
	  height:19px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  font-size:16px;
	  color:#EE5F45;
	}
	#su287 {
	  position:absolute;
	  left:0px;
	  top:0px;
	  width:94px;
	  white-space:nowrap;
	}
	#su276 {
	  position:absolute;
	  left:120px;
	  top:9px;
	  width:100px;
	  height:36px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#su277 {
	  position:absolute;
	  left:-28px;
	  top:10px;
	  width:157px;
	  word-wrap:break-word;
	}
	#su278 {
	  position:absolute;
	  left:235px;
	  top:9px;
	  width:100px;
	  height:36px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#su279 {
	  position:absolute;
	  left:-28px;
	  top:10px;
	  width:157px;
	  word-wrap:break-word;
	}
	#su280 {
	  position:absolute;
	  left:350px;
	  top:9px;
	  width:100px;
	  height:36px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#su281 {
	  position:absolute;
	  left:-28px;
	  top:10px;
	  width:157px;
	  word-wrap:break-word;
	}
	#su2801 {
	  position:absolute;
	  left:465px;
	  top:9px;
	  width:100px;
	  height:36px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#su2811 {
	  position:absolute;
	  left:-28px;
	  top:10px;
	  width:157px;
	  word-wrap:break-word;
	}
	#su254 {
	  position:absolute;
	  left:600px;
	  top:0px;
	  width:120px;
	  height:44px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#su255 {
	  position:absolute;
	  left:2px;
	  top:14px;
	  width:116px;
	  word-wrap:break-word;
	}
	#su256 {
	  position:absolute;
	  left:734px;
	  top:0px;
	  width:120px;
	  height:44px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#su257 {
	  position:absolute;
	  left:2px;
	  top:14px;
	  width:116px;
	  word-wrap:break-word;
	}
	
	
	#su0 {
	  position:absolute;
	  left:1px;
	  top:44px;
	  width:979px;
	  height:676px;
	}
	#su1 {
	  position:absolute;
	  left:2px;
	  top:330px;
	  width:975px;
	  visibility:hidden;
	  word-wrap:break-word;
	}
	#su2 {
	  position:absolute;
	  left:10px;
	  top:59px;
	  width:10px;
	  height:611px;
	}
	#su2_start {
	  position:absolute;
	  left:-5px;
	  top:0px;
	  width:20px;
	  height:18px;
	}
	#su2_end {
	  position:absolute;
	  left:-5px;
	  top:594px;
	  width:20px;
	  height:18px;
	}
	#su2_line {
	  position:absolute;
	  left:5px;
	  top:0px;
	  width:1px;
	  height:321px;
	}
	#su3 {
	  position:absolute;
	  left:606px;
	  top:59px;
	  width:10px;
	  height:611px;
	}
	#su3_start {
	  position:absolute;
	  left:-5px;
	  top:0px;
	  width:20px;
	  height:18px;
	}
	#su3_end {
	  position:absolute;
	  left:-5px;
	  top:594px;
	  width:20px;
	  height:18px;
	}
	#su3_line {
	  position:absolute;
	  left:5px;
	  top:0px;
	  width:1px;
	  height:321px;
	}
	#su4 {
	  position:absolute;
	  left:308px;
	  top:59px;
	  width:10px;
	  height:611px;
	}
	#su4_start {
	  position:absolute;
	  left:-5px;
	  top:0px;
	  width:20px;
	  height:18px;
	}
	#su4_end {
	  position:absolute;
	  left:-5px;
	  top:594px;
	  width:20px;
	  height:18px;
	}
	#su4_line {
	  position:absolute;
	  left:5px;
	  top:0px;
	  width:1px;
	  height:321px;
	}

</style>
   
   <script type="text/javascript">
     
     /* 展开和收起 */
		 	function CanShu(id,key,va){
		 		var show=document.getElementById(id).style.display;
		 		if(show=='none'){
		 			document.getElementById(id).style.display='';
		 			document.getElementById(va).innerHTML="收起";
		 			
		 		}else{
		 			document.getElementById(id).style.display='none';
		 	 		document.getElementById(va).innerHTML="展开";
		 		}
		 		
		 		
		 		
		 		var text1 = document.getElementById("u36").innerHTML;
	 			var text2 = document.getElementById("u40").innerHTML;
	 			var text3 = document.getElementById("u56").innerHTML;
	 			var text4 = document.getElementById("u209").innerHTML;
	 			var text5 = document.getElementById("u219").innerHTML;
		 		
		 			
		 			if (text1 == "展开" && text2 == "展开" && text3 == "展开" && text4 == "展开" && text5 == "展开") {
		 				document.getElementById('u38').style.top='247px';
		 				document.getElementById('u54').style.top='274px';
		 				document.getElementById('u207').style.top='301px';
		 				document.getElementById('u217').style.top='328px';
		 				
		 				
					}
		 		    if (text1 == "收起" && text2 == "展开" && text3 == "展开" && text4 == "展开" && text5 == "展开"){
		 				
		 		    	document.getElementById('u38').style.top='716px';
		 				document.getElementById('u54').style.top='743px';
		 				document.getElementById('u207').style.top='770px';
		 				document.getElementById('u217').style.top='797px';
					}
		 		   if (text1 == "收起" && text2 == "收起" && text3 == "展开" && text4 == "展开" && text5 == "展开"){
		 				
		 		    	document.getElementById('u38').style.top='716px';
		 		    	document.getElementById('u41').style.top='743px';
		 				document.getElementById('u54').style.top='1306px';
		 				document.getElementById('u207').style.top='1333px';
		 				document.getElementById('u217').style.top='1360px';
					}
		 		   if (text1 == "展开" && text2 == "收起" && text3 == "展开" && text4 == "展开" && text5 == "展开"){
		 				
		 		    	document.getElementById('u38').style.top='247px';
		 		    	document.getElementById('u41').style.top='274px';
		 				document.getElementById('u54').style.top='837px';
		 				document.getElementById('u207').style.top='864px';
		 				document.getElementById('u217').style.top='891px';
					}
		 		   if (text1 == "展开" && text2 == "展开" && text3 == "收起" && text4 == "展开" && text5 == "展开"){
		 				
		 		    	document.getElementById('u38').style.top='247px';
		 				document.getElementById('u54').style.top='274px';
		 				document.getElementById('u57').style.top='301px';
		 				document.getElementById('u207').style.top='820px';
		 				document.getElementById('u217').style.top='847px';
					}
		 		   if (text1 == "收起" && text2 == "展开" && text3 == "收起" && text4 == "展开" && text5 == "展开"){
		 				
		 		    	document.getElementById('u38').style.top='716px';
		 				document.getElementById('u54').style.top='743px';
		 				document.getElementById('u57').style.top='770px';
		 				document.getElementById('u207').style.top='1289px';
		 				document.getElementById('u217').style.top='1316px';
					}
		 		   if (text1 == "收起" && text2 == "收起" && text3 == "收起" && text4 == "展开" && text5 == "展开"){
		 				
		 		    	document.getElementById('u38').style.top='716px';
		 		    	document.getElementById('u41').style.top='743px';
		 				document.getElementById('u54').style.top='1307px';
		 				document.getElementById('u57').style.top='1334px';
		 				document.getElementById('u207').style.top='1853px';
		 				document.getElementById('u217').style.top='1880px';
					}
		 		  	if (text1 == "收起" && text2 == "收起" && text3 == "收起" && text4 == "收起" && text5 == "展开"){
		 				
		 		    	document.getElementById('u38').style.top='716px';
		 		    	document.getElementById('u41').style.top='743px';
		 				document.getElementById('u54').style.top='1307px';
		 				document.getElementById('u57').style.top='1334px';
		 				document.getElementById('u207').style.top='1857px';
		 				document.getElementById('u210').style.top='1884px';
		 				document.getElementById('u217').style.top='2204px';
					}
					if (text1 == "展开" && text2 == "收起" && text3 == "收起" && text4 == "收起" && text5 == "展开"){
		 				
		 		    	document.getElementById('u38').style.top='247px';
		 		    	document.getElementById('u41').style.top='274px';
		 				document.getElementById('u54').style.top='837px';
		 				document.getElementById('u57').style.top='864px';
		 				document.getElementById('u207').style.top='1383px';
		 				document.getElementById('u210').style.top='1410px';
		 				document.getElementById('u217').style.top='1729px';
					}
					if (text1 == "收起" && text2 == "展开" && text3 == "收起" && text4 == "收起" && text5 == "展开"){
						document.getElementById('u38').style.top='716px';
		 				document.getElementById('u54').style.top='743px';
		 				document.getElementById('u57').style.top='770px';
		 				document.getElementById('u207').style.top='1289px';
		 				document.getElementById('u210').style.top='1316px';
		 				document.getElementById('u217').style.top='1635px';
					}
					if (text1 == "收起" && text2 == "收起" && text3 == "展开" && text4 == "收起" && text5 == "展开"){
						document.getElementById('u38').style.top='716px';
		 		    	document.getElementById('u41').style.top='743px';
		 				document.getElementById('u54').style.top='1306px';
		 				document.getElementById('u207').style.top='1333px';
		 				document.getElementById('u210').style.top='1360px';
		 				document.getElementById('u217').style.top='1679px';
					}
					if (text1 == "收起" && text2 == "收起" && text3 == "收起" && text4 == "收起" && text5 == "收起"){
						document.getElementById('u38').style.top='716px';
		 		    	document.getElementById('u41').style.top='743px';
		 				document.getElementById('u54').style.top='1307px';
		 				document.getElementById('u57').style.top='1334px';
		 				document.getElementById('u207').style.top='1857px';
		 				document.getElementById('u210').style.top='1884px';
		 				document.getElementById('u217').style.top='2204px';
		 				document.getElementById('u220').style.top='2231px';
					}
					if (text1 == "展开" && text2 == "收起" && text3 == "收起" && text4 == "收起" && text5 == "收起"){
						document.getElementById('u38').style.top='247px';
		 		    	document.getElementById('u41').style.top='274px';
		 				document.getElementById('u54').style.top='837px';
		 				document.getElementById('u57').style.top='864px';
		 				document.getElementById('u207').style.top='1383px';
		 				document.getElementById('u210').style.top='1410px';
		 				document.getElementById('u217').style.top='1729px';
		 				document.getElementById('u220').style.top='1756px';
					}
					if (text1 == "收起" && text2 == "展开" && text3 == "收起" && text4 == "收起" && text5 == "收起"){
						document.getElementById('u38').style.top='716px';
		 				document.getElementById('u54').style.top='743px';
		 				document.getElementById('u57').style.top='770px';
		 				document.getElementById('u207').style.top='1289px';
		 				document.getElementById('u210').style.top='1316px';
		 				document.getElementById('u217').style.top='1635px';
		 				document.getElementById('u220').style.top='1662px';
					}
					if (text1 == "收起" && text2 == "收起" && text3 == "展开" && text4 == "收起" && text5 == "收起"){
						document.getElementById('u38').style.top='716px';
		 		    	document.getElementById('u41').style.top='743px';
		 				document.getElementById('u54').style.top='1306px';
		 				document.getElementById('u207').style.top='1333px';
		 				document.getElementById('u210').style.top='1360px';
		 				document.getElementById('u217').style.top='1679px';
		 				document.getElementById('u220').style.top='1706px';
					}
					if (text1 == "收起" && text2 == "收起" && text3 == "收起" && text4 == "展开" && text5 == "收起"){
						document.getElementById('u38').style.top='716px';
		 		    	document.getElementById('u41').style.top='743px';
		 				document.getElementById('u54').style.top='1307px';
		 				document.getElementById('u57').style.top='1334px';
		 				document.getElementById('u207').style.top='1853px';
		 				document.getElementById('u217').style.top='1880px';
		 				document.getElementById('u220').style.top='1907px';
					}
					if (text1 == "收起" && text2 == "收起" && text3 == "展开" && text4 == "展开" && text5 == "收起"){
						document.getElementById('u38').style.top='716px';
		 		    	document.getElementById('u41').style.top='743px';
		 				document.getElementById('u54').style.top='1306px';
		 				document.getElementById('u207').style.top='1333px';
		 				document.getElementById('u217').style.top='1360px';
		 				document.getElementById('u220').style.top='1387px';
					}
					if (text1 == "收起" && text2 == "展开" && text3 == "展开" && text4 == "展开" && text5 == "收起"){
						document.getElementById('u38').style.top='716px';
		 				document.getElementById('u54').style.top='743px';
		 				document.getElementById('u207').style.top='770px';
		 				document.getElementById('u217').style.top='797px';
		 				document.getElementById('u220').style.top='824px';
					}
					if (text1 == "收起" && text2 == "展开" && text3 == "展开" && text4 == "收起" && text5 == "收起"){
						document.getElementById('u38').style.top='716px';
		 				document.getElementById('u54').style.top='743px';
		 				document.getElementById('u207').style.top='770px';
		 				document.getElementById('u210').style.top='797px';
		 				document.getElementById('u217').style.top='1116px';
		 				document.getElementById('u220').style.top='1143px';
					}
					if (text1 == "收起" && text2 == "展开" && text3 == "展开" && text4 == "收起" && text5 == "展开"){
						document.getElementById('u38').style.top='716px';
		 				document.getElementById('u54').style.top='743px';
		 				document.getElementById('u207').style.top='770px';
		 				document.getElementById('u210').style.top='797px';
		 				document.getElementById('u217').style.top='1116px';
					}
					if (text1 == "收起" && text2 == "展开" && text3 == "收起" && text4 == "展开" && text5 == "收起"){
						document.getElementById('u38').style.top='716px';
		 				document.getElementById('u54').style.top='743px';
		 				document.getElementById('u57').style.top='770px';
		 				document.getElementById('u207').style.top='1289px';
		 				document.getElementById('u217').style.top='1316px';
		 				document.getElementById('u220').style.top='1343px';
					}
					if (text1 == "展开" && text2 == "展开" && text3 == "展开" && text4 == "展开" && text5 == "收起") {
		 				document.getElementById('u38').style.top='247px';
		 				document.getElementById('u54').style.top='274px';
		 				document.getElementById('u207').style.top='301px';
		 				document.getElementById('u217').style.top='328px';
		 				document.getElementById('u220').style.top='355px';
					}
					if (text1 == "展开" && text2 == "展开" && text3 == "展开" && text4 == "收起" && text5 == "收起") {
		 				document.getElementById('u38').style.top='247px';
		 				document.getElementById('u54').style.top='274px';
		 				document.getElementById('u207').style.top='301px';
		 				document.getElementById('u210').style.top='328px';
		 				document.getElementById('u217').style.top='647px';
		 				document.getElementById('u220').style.top='674px';
					}
					if (text1 == "展开" && text2 == "展开" && text3 == "展开" && text4 == "收起" && text5 == "展开") {
		 				document.getElementById('u38').style.top='247px';
		 				document.getElementById('u54').style.top='274px';
		 				document.getElementById('u207').style.top='301px';
		 				document.getElementById('u210').style.top='328px';
		 				document.getElementById('u217').style.top='647px';
					}
					if (text1 == "展开" && text2 == "展开" && text3 == "收起" && text4 == "收起" && text5 == "收起") {
						document.getElementById('u38').style.top='247px';
		 				document.getElementById('u54').style.top='274px';
		 				document.getElementById('u57').style.top='301px';
		 				document.getElementById('u207').style.top='820px';
		 				document.getElementById('u210').style.top='847px';
		 				document.getElementById('u217').style.top='1166px';
		 				document.getElementById('u220').style.top='1193px';
					}
					if (text1 == "展开" && text2 == "展开" && text3 == "收起" && text4 == "收起" && text5 == "展开") {
						document.getElementById('u38').style.top='247px';
		 				document.getElementById('u54').style.top='274px';
		 				document.getElementById('u57').style.top='301px';
		 				document.getElementById('u207').style.top='820px';
		 				document.getElementById('u210').style.top='847px';
		 				document.getElementById('u217').style.top='1166px';
					}
					if (text1 == "展开" && text2 == "展开" && text3 == "收起" && text4 == "展开" && text5 == "收起") {
						document.getElementById('u38').style.top='247px';
		 				document.getElementById('u54').style.top='274px';
		 				document.getElementById('u57').style.top='301px';
		 				document.getElementById('u207').style.top='820px';
		 				document.getElementById('u217').style.top='847px';
		 				document.getElementById('u220').style.top='874px';
					}
					if (text1 == "展开" && text2 == "收起" && text3 == "收起" && text4 == "展开" && text5 == "收起") {
						document.getElementById('u38').style.top='247px';
		 		    	document.getElementById('u41').style.top='274px';
		 				document.getElementById('u54').style.top='837px';
		 				document.getElementById('u57').style.top='864px';
		 				document.getElementById('u207').style.top='1383px';
		 				document.getElementById('u217').style.top='1410px';
		 				document.getElementById('u220').style.top='1437px';
					}
					if (text1 == "展开" && text2 == "收起" && text3 == "收起" && text4 == "展开" && text5 == "展开") {
						document.getElementById('u38').style.top='247px';
		 		    	document.getElementById('u41').style.top='274px';
		 				document.getElementById('u54').style.top='837px';
		 				document.getElementById('u57').style.top='864px';
		 				document.getElementById('u207').style.top='1383px';
		 				document.getElementById('u217').style.top='1410px';
					}
					if (text1 == "展开" && text2 == "收起" && text3 == "展开" && text4 == "展开" && text5 == "收起") {
						document.getElementById('u38').style.top='247px';
		 		    	document.getElementById('u41').style.top='274px';
		 				document.getElementById('u54').style.top='837px';
		 				document.getElementById('u207').style.top='864px';
		 				document.getElementById('u217').style.top='891px';
		 				document.getElementById('u220').style.top='918px';
					}
					if (text1 == "展开" && text2 == "收起" && text3 == "展开" && text4 == "收起" && text5 == "收起") {
						document.getElementById('u38').style.top='247px';
		 		    	document.getElementById('u41').style.top='274px';
		 				document.getElementById('u54').style.top='837px';
		 				document.getElementById('u207').style.top='864px';
		 				document.getElementById('u210').style.top='891px';
		 				document.getElementById('u217').style.top='1210px';
		 				document.getElementById('u220').style.top='1238px';
					}
					if (text1 == "展开" && text2 == "收起" && text3 == "展开" && text4 == "收起" && text5 == "展开") {
						document.getElementById('u38').style.top='247px';
		 		    	document.getElementById('u41').style.top='274px';
		 				document.getElementById('u54').style.top='837px';
		 				document.getElementById('u207').style.top='864px';
		 				document.getElementById('u210').style.top='891px';
		 				document.getElementById('u217').style.top='1210px';
					}
				
		 	}
     
		 	//
		 	$(function(){
		 		
		 		//时间默认为当前时间
		 		/* var year = new Date().getFullYear();
		 		var month = new Date().getMonth()+1;
		 		var date = new Date().getDate();
		 		if(month<10) month="0"+month;
		 		if(date<10) date="0"+date; 
		 		document.getElementById("u511_input").value=(year)+"-"+(month)+"-"+(date);
		 		document.getElementById("u235_input").value=(year)+"-"+(month)+"-"+(date);
		 		document.getElementById("u238_input").value=(year)+"-"+(month)+"-"+(date);
		 		document.getElementById("u354_input").value=(year)+"-"+(month)+"-"+(date); */
		 		
		 		$("#u34").click();
		 		$("#u38").click();
		 		$("#u54").click();
		 		$("#u207").click();
		 		$("#u217").click();
		 		
		 		//与遗传有关的家族--其他
		 		$("#u532_input").hide();
			    $("#u535_input").hide();
			    $("#u536_input").hide();
			    $("#u643_input").hide();
			    $("#u537_input").hide();
			    $("#u538_input").hide();
			    $("#u539_input").hide();
			    $("#u540_input").hide();
			    $("#u533_input").hide();
			    $("#u541_input").hide();
		 		$("input[name^='geneticHistory']").click(function(){
			        
			        if($("#u351_input").attr("checked")){
			            $("#u533_input").css({"display":"block"});
			            $("#u541_input").css({"display":"block"});
			            
			        }else{
			            $("#u533_input").css({"display":"none"});
			            $("#u541_input").css({"display":"none"});
			            $("#u533_input").val("");
			            $("#u541_input").val("");
			        }
			        if($("#u335_input").attr("checked")){
			            $("#u532_input").show();
			        }else{
			        	$("#u532_input").hide();
			        }
			        if($("#u337_input").attr("checked")){
			            $("#u535_input").show();
			        }else{
			        	$("#u535_input").hide();
			        }
			        if($("#u339_input").attr("checked")){
			            $("#u536_input").show();
			        }else{
			        	$("#u536_input").hide();
			        }
			        if($("#u341_input").attr("checked")){
			            $("#u643_input").show();
			        }else{
			        	$("#u643_input").hide();
			        }
			        if($("#u343_input").attr("checked")){
			            $("#u537_input").show();
			        }else{
			        	$("#u537_input").hide();
			        }
			        if($("#u345_input").attr("checked")){
			            $("#u538_input").show();
			        }else{
			        	$("#u538_input").hide();
			        }
			        if($("#u347_input").attr("checked")){
			            $("#u539_input").show();
			        }else{
			        	$("#u539_input").hide();
			        }
			        if($("#u349_input").attr("checked")){
			            $("#u540_input").show();
			        }else{
			        	$("#u540_input").hide();
			        }
			    });
		 		
		 		//当检查结果选中异常时，显示特殊疾病按钮
		 		$("#u512").hide();
		 		$("input[name^='checkResult']").click(function(){
					if($("#u215_input").attr("checked")){
						$("#u512").show();
			        }else{
			        	$("#u512").hide();
			        }
		 		});
		 		
		 		var excTerm1Url = "${ctx}/premaritalexainfo/excTerm"
		 		//特殊疾病
	 		    $("#u512").click(function(){
	 			   //showDialog_URl('','illAtv','dialList2');
	 			      $("#guding").show();
	    			  $("#su252").css("background-color","#EE5F45");
	    			  $("#su276").css("background-color","#999999");
	    			  $("#su278").css("background-color","#999999");
	    			  $("#su280").css("background-color","#999999");
	    			  $("#su2801").css("background-color","#999999");
	    			  $("#renshen").hide();
	    			  $("#benci").hide();
	    			  $("#shehui").hide();
	    			  $("#neike").hide();
	 			 
	 			  showDialog_("提示","illAtv","moremiddle14",false);
		 			  $.ajax({
	    				  url:excTerm1Url,
	    				  type:"GET",
	    				  success:function(data){
	    					  var a = 0;
	    					  var b = 0;
	    					  var c = 0;
	    					  var gu1 = "";
	    					  var gu2 = "";
	    					  var gu3 = "";
	    					  //指定传染病
	    					  for(var i = 0;i<data.list0.length;i++){
	    						  if (i < 7) {
		    						  gu1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+a*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list0[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list0[i].id+"'name='infectiousDis'/>"
		     							+"</div>";
	   								
		     							a += 1;
								  }
	    						  if (6 < i && i < 14) {
		    						  gu2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+b*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list0[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list0[i].id+"'name='infectiousDis'/>"
		     							+"</div>";
	   								
		     							b += 1;
								  }
	    						  if (13 < i && i < 21) {
		    						  gu3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+c*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list0[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list0[i].id+"'name='infectiousDis'/>"
		     							+"</div>";
	   								
		     							c += 1;
								  }
	    					  }
	    					  $("#guding").html(gu1+gu2+gu3);
	    					  
	    				  }
		 			  });
		        });
		 		
		 		//特殊疾病弹出框---各分类疾病切换
		 		$("#su252").click(function(){
	    			$("#guding").show();
	    			$("#su252").css("background-color","#EE5F45");
	    			$("#su276").css("background-color","#999999");
	    			$("#su278").css("background-color","#999999");
	    			$("#su280").css("background-color","#999999");
	    			$("#su2801").css("background-color","#999999");
	    			$("#renshen").hide();
	    			$("#benci").hide();
	    			$("#shehui").hide();
	    			$("#neike").hide();
	    			$.ajax({
	    				  url:excTerm1Url,
	    				  type:"GET",
	    				  success:function(data){
	    					  var a = 0;
	    					  var b = 0;
	    					  var c = 0;
	    					  var gu1 = "";
	    					  var gu2 = "";
	    					  var gu3 = "";
	    					  //指定传染病
	    					  for(var i = 0;i<data.list0.length;i++){
	    						  if (i < 7) {
		    						  gu1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+a*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list0[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list0[i].id+"'name='infectiousDis'/>"
		     							+"</div>";
	   								
		     							a += 1;
								  }
	    						  if (6 < i && i < 14) {
		    						  gu2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+b*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list0[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list0[i].id+"'name='infectiousDis'/>"
		     							+"</div>";
	   								
		     							b += 1;
								  }
	    						  if (13 < i && i < 21) {
		    						  gu3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+c*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list0[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list0[i].id+"'name='infectiousDis'/>"
		     							+"</div>";
	   								
		     							c += 1;
								  }
	    					  }
	    					  $("#guding").html(gu1+gu2+gu3);
	    					  
	    				  }
		 			  });
	    		});
	    		$("#su276").click(function(){
	    			$("#guding").hide();
	    			$("#su252").css("background-color","#999999");
	    			$("#su276").css("background-color","#EE5F45");
	    			$("#su278").css("background-color","#999999");
	    			$("#su280").css("background-color","#999999");
	    			$("#su2801").css("background-color","#999999");
	    			$("#renshen").show();
	    			$("#benci").hide();
	    			$("#shehui").hide();
	    			$("#neike").hide();
	    			$.ajax({
	    				  url:excTerm1Url,
	    				  type:"GET",
	    				  success:function(data){
	    					  var a = 0;
	    					  var b = 0;
	    					  var c = 0;
	    					  var ren1 = "";
	    					  var ren2 = "";
	    					  var ren3 = "";
	    					  //严重遗传病
	    					  for(var i = 0;i<data.list1.length;i++){
	    						  if (i < 7) {
	    							  ren1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+a*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list1[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list1[i].id+"'name='geneticDis'/>"
		     							+"</div>";
	   								
		     							a += 1;
								  }
	    						  if (6 < i && i < 14) {
	    							  ren2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+b*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list1[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list1[i].id+"'name='geneticDis'/>"
		     							+"</div>";
	   								
		     							b += 1;
								  }
	    						  if (13 < i && i < 21) {
		    						  ren3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+c*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list1[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list1[i].id+"'name='geneticDis'/>"
		     							+"</div>";
	   								
		     							c += 1;
								  }
	    					  }
	    					  $("#renshen").html(ren1+ren2+ren3);
	    					  
	    				  }
		 			  });
	    		});
	    		$("#su278").click(function(){
	    			$("#guding").hide();
	    			$("#su252").css("background-color","#999999");
	    			$("#su276").css("background-color","#999999");
	    			$("#su278").css("background-color","#EE5F45");
	    			$("#su280").css("background-color","#999999");
	    			$("#su2801").css("background-color","#999999");
	    			$("#renshen").hide();
	    			$("#benci").show();
	    			$("#shehui").hide();
	    			$("#neike").hide();
	    			$.ajax({
	    				  url:excTerm1Url,
	    				  type:"GET",
	    				  success:function(data){
	    					  var a = 0;
	    					  var b = 0;
	    					  var c = 0;
	    					  var ben1 = "";
	    					  var ben2 = "";
	    					  var ben3 = "";
	    					  //精神病
	    					  for(var i = 0;i<data.list2.length;i++){
	    						  if (i < 7) {
	    							  ben1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+a*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list2[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list2[i].id+"'name='mentalDis'/>"
		     							+"</div>";
	   								
		     							a += 1;
								  }
	    						  if (6 < i && i < 14) {
	    							  ben2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+b*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list2[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list2[i].id+"'name='mentalDis'/>"
		     							+"</div>";
	   								
		     							b += 1;
								  }
	    						  if (13 < i && i < 21) {
		    						  ben3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+c*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list2[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list2[i].id+"'name='mentalDis'/>"
		     							+"</div>";
	   								
		     							c += 1;
								  }
	    					  }
	    					  $("#benci").html(ben1+ben2+ben3);
	    					  
	    				  }
		 			  });
	    		});
	    		$("#su280").click(function(){
	    			$("#guding").hide();
	    			$("#su252").css("background-color","#999999");
	    			$("#su276").css("background-color","#999999");
	    			$("#su278").css("background-color","#999999");
	    			$("#su280").css("background-color","#EE5F45");
	    			$("#su2801").css("background-color","#999999");
	    			$("#renshen").hide();
	    			$("#benci").hide();
	    			$("#shehui").show();
	    			$("#neike").hide();
	    			$.ajax({
	    				  url:excTerm1Url,
	    				  type:"GET",
	    				  success:function(data){
	    					  var a = 0;
	    					  var b = 0;
	    					  var c = 0;
	    					  var she1 = "";
	    					  var she2 = "";
	    					  var she3 = "";
	    					  //女性生殖系统疾病
	    					  for(var i = 0;i<data.list4.length;i++){
	    						  if (i < 7) {
	    							  she1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+a*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list4[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list4[i].id+"'name='reproductiveDis'/>"
		     							+"</div>";
	   								
		     							a += 1;
								  }
	    						  if (6 < i && i < 14) {
	    							  she2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+b*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list4[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list4[i].id+"'name='reproductiveDis'/>"
		     							+"</div>";
	   								
		     							b += 1;
								  }
	    						  if (13 < i && i < 21) {
		    						  she3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+c*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list4[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list4[i].id+"'name='reproductiveDis'/>"
		     							+"</div>";
	   								
		     							c += 1;
								  }
	    					  }
	    					  $("#shehui").html(she1+she2+she3);
	    					  
	    				  }
		 			  });
	    		});
	    		$("#su2801").click(function(){
	    			$("#guding").hide();
	    			$("#su252").css("background-color","#999999");
	    			$("#su276").css("background-color","#999999");
	    			$("#su278").css("background-color","#999999");
	    			$("#su280").css("background-color","#999999");
	    			$("#su2801").css("background-color","#EE5F45");
	    			$("#renshen").hide();
	    			$("#benci").hide();
	    			$("#shehui").hide();
	    			$("#neike").show();
	    			$.ajax({
	    				  url:excTerm1Url,
	    				  type:"GET",
	    				  success:function(data){
	    					  var a = 0;
	    					  var b = 0;
	    					  var c = 0;
	    					  var nei1 = "";
	    					  var nei2 = "";
	    					  var nei3 = "";
	    					  //内科疾病
	    					  for(var i = 0;i<data.list5.length;i++){
	    						  if (i < 7) {
	    							  nei1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+a*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list5[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list5[i].id+"'name='medicalDis'/>"
		     							+"</div>";
	   								
		     							a += 1;
								  }
	    						  if (6 < i && i < 14) {
	    							  nei2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+b*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list5[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list5[i].id+"'name='medicalDis'/>"
		     							+"</div>";
	   								
		     							b += 1;
								  }
	    						  if (13 < i && i < 21) {
		    						  nei3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+c*50)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list5[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list5[i].id+"'name='medicalDis'/>"
		     							+"</div>";
	   								
		     							c += 1;
								  }
	    					  }
	    					  $("#neike").html(nei1+nei2+nei3);
	    					  
	    				  }
		 			  });
	    		});
	    		
	    		//特殊疾病弹出框---取消
	    		$("#su256").click(function(){
	     			$("#illAtv").window("close");
	     		});
	    		
	    		
	    		
	    		saveSpecialUrl = "${ctx}/specialdiseaseinfo/add"
	    		//特殊疾病项保存
	    		$("#su254").click(function(){
	     			$.ajax({
	 	 				type:'POST',
	 	 	 			url:saveSpecialUrl,
	 	 	 			data:$('#special').serialize(),
	 	 	 			success:function(data){
	 	 	 				$("#resultId").val(data.resultId);
	 	 	 				$("#u494_input").val(data.ill);
	 	 	 				//将特殊疾病的指导意见带入到婚前卫生咨询
	 	 	 				$("#u505_input").val(data.direct);
	 	 	 				$("#illAtv").window("close");//保存完成关闭弹出框
	 	 	 			}
	 	 	 		});
	     			
	     		});
		 		
				$("input[name^='vaginalDischarge']").click(function(){
			        
			        if($("#u197_input").attr("checked")){
			            $("#u196_input").css({"display":"block"});
			        }else{
			            $("#u196_input").css({"display":"none"});
			            $("#u196_input").val("");
			        }
			    });
		 		
		 		//血缘关系
		 		$("#u355_input").hide();
		 		$("#u262_input").change(function(){
		 		  var kinship = $("#u262_input").val();
		 		  if (kinship == "3") {
					  $("#u355_input").show(); 
				  }else if(kinship == "4"){
					  $("#u355_input").show(); 
				  }else{
		 			 $("#u355_input").hide();
		 			 $("#u355_input").val("");
				  }
		 		});
		 		//手术史
		 		$("#u356_input").hide();
		 		$("#u279_input").change(function(){
		 		  var surgeryHistory = $("#u279_input").val();
		 		  if (surgeryHistory == "1") {
					  $("#u356_input").show(); 
				  }else{
		 			 $("#u356_input").hide();
		 			 $("#u356_input").val("");
				  }
		 		});
		 		//现病史
		 		$("#u357_input").hide();
		 		$("#u283_input").change(function(){
		 		  var hpi = $("#u283_input").val();
		 		  if (hpi == "0") {
		 			 $("#u357_input").hide();
		 			 $("#u357_input").val("");
				  }else{
					  $("#u357_input").show(); 
				  }
		 		});
		 		//特殊体态
		 		$("#u380_input").hide();
		 		$("#u379_input").change(function(){
		 		  var specialPosture = $("#u379_input").val();
		 		  if (specialPosture == "0") {
		 			 $("#u380_input").hide();
		 			 $("#u380_input").val("");
				  }else{
					  $("#u380_input").show(); 
				  }
		 		});
		 		//特殊面容
		 		$("#u384_input").hide();
		 		$("#u383_input").change(function(){
		 		  var specialFace = $("#u383_input").val();
		 		  if (specialFace == "0") {
		 			 $("#u384_input").hide();
		 			 $("#u384_input").val("");
				  }else{
					  $("#u384_input").show(); 
				  }
		 		});
		 		//精神状态
		 		$("#u388_input").hide();
		 		$("#u387_input").change(function(){
		 		  var mentalState = $("#u387_input").val();
		 		  if (mentalState == "0") {
		 			 $("#u388_input").hide();
		 			 $("#u388_input").val("");
				  }else{
					  $("#u388_input").show(); 
				  }
		 		});
		 		//皮肤毛发
		 		$("#u396_input").hide();
		 		$("#u395_input").change(function(){
		 		  var skinHair = $("#u395_input").val();
		 		  if (skinHair == "0") {
		 			 $("#u396_input").hide();
		 			 $("#u396_input").val("");
				  }else{
					  $("#u396_input").show(); 
				  }
		 		});
		 		//五官
		 		$("#u53_input").hide();
		 		$("#u52_input").change(function(){
		 		  var facialFeatures = $("#u52_input").val();
		 		  if (facialFeatures == "0") {
		 			 $("#u53_input").hide();
		 			 $("#u53_input").val("");
				  }else{
					  $("#u53_input").show(); 
				  }
		 		});
		 		
		 		//甲状腺
		 		$("#u400_input").hide();
		 		$("#u399_input").change(function(){
		 		  var thyroidGland = $("#u399_input").val();
		 		  if (thyroidGland == "0") {
		 			 $("#u400_input").hide();
		 			 $("#u400_input").val("");
				  }else{
					  $("#u400_input").show(); 
				  }
		 		});
		 		
		 		//足月
		 		$("#u373_input").hide();
		 		$("#u298_input").change(function(){
		 		  var thyroidGland = $("#u298_input").val();
		 		  if (thyroidGland == "7") {
					  $("#u373_input").show(); 
				  }else{
		 			 $("#u373_input").hide();
		 			 $("#u373_input").val("");
				  }
		 		});
		 		
		 		//杂音
		 		$("#u413_input").hide();
		 		$("#u412_input").change(function(){
		 		  var noise = $("#u412_input").val();
		 		  if (noise == "0") {
		 			 $("#u413_input").hide();
		 			 $("#u413_input").val("");
				  }else{
					  $("#u413_input").show(); 
				  }
		 		});
		 		
		 		//肺
		 		$("#u417_input").hide();
		 		$("#u416_input").change(function(){
		 		  var lung = $("#u416_input").val();
		 		  if (lung == "0") {
		 			 $("#u417_input").hide();
		 			$("#u417_input").val("");
				  }else{
					  $("#u417_input").show(); 
				  }
		 		});
		 		
		 		//肝
		 		$("#u421_input").hide();
		 		$("#u420_input").change(function(){
		 		  var liver = $("#u420_input").val();
		 		  if (liver == "0") {
		 			 $("#u421_input").hide();
		 			$("#u421_input").val("");
				  }else{
					  $("#u421_input").show(); 
				  }
		 		});
		 		
		 		//四肢脊柱
		 		$("#u425_input").hide();
		 		$("#u424_input").change(function(){
		 		  var limbs = $("#u424_input").val();
		 		  if (limbs == "0") {
		 			 $("#u425_input").hide();
		 			$("#u425_input").val("");
				  }else{
					  $("#u425_input").show(); 
				  }
		 		});
		 		
		 		//乳房
		 		$("#u450_input").hide();
		 		$("#u449_input").change(function(){
		 		  var breast = $("#u449_input").val();
		 		  if (breast == "0") {
		 			 $("#u450_input").hide();
		 			$("#u450_input").val("");
				  }else{
					  $("#u450_input").show(); 
				  }
		 		});
		 		
		 		//外阴
		 		$("#u452_input").hide();
		 		$("#u451_input").change(function(){
		 		  var anusVulva = $("#u451_input").val();
		 		  if (anusVulva == "0") {
		 			 $("#u452_input").hide();
		 			$("#u452_input").val("");
				  }else{
					  $("#u452_input").show(); 
				  }
		 		});
		 		
		 		//分泌物
		 		$("#u454_input").hide();
		 		$("#u453_input").change(function(){
		 		  var secretions = $("#u453_input").val();
		 		  if (secretions == "0") {
		 			 $("#u454_input").hide();
		 			$("#u454_input").val("");
				  }else{
					  $("#u454_input").show(); 
				  }
		 		});
		 		
		 		//外阴
		 		$("#u456_input").hide();
		 		$("#u455_input").change(function(){
		 		  var vulvaVagina = $("#u455_input").val();
		 		  if (vulvaVagina == "0") {
		 			 $("#u456_input").hide();
		 			$("#u456_input").val("");
				  }else{
					  $("#u456_input").show(); 
				  }
		 		});
		 		
		 		//外阴
		 		$("#u463_input").hide();
		 		$("#u462_input").change(function(){
		 		  var vulva = $("#u462_input").val();
		 		  /* if (vulva != undefined) {
		 			 document.getElementById('u644_input').selectedIndex = 0;
		 			 document.getElementById('u644_input').disabled=true;
		 			 
				  } */
		 		  if (vulva == "0") {
		 			 $("#u463_input").hide();
		 			$("#u463_input").val("");
		 			//document.getElementById('u644_input').readOnly=true;
		 			
				  }else{
					  $("#u463_input").show(); 
				  }
		 		});
		 		
		 		//阴道
		 		$("#u470_input").hide();
		 		$("#u469_input").change(function(){
		 		  var vagina = $("#u469_input").val();
		 		  /* if (vagina != undefined) {
		 			 document.getElementById('u644_input').selectedIndex = 0;
		 			 document.getElementById('u644_input').disabled=true;
				  } */
		 		  if (vagina == "0") {
		 			 $("#u470_input").hide();
		 			$("#u470_input").val("");
				  }else{
					  $("#u470_input").show(); 
				  }
		 		});
		 		
		 		//宫颈
		 		$("#u464_input").hide();
		 		$("#u447_input").change(function(){
		 		  var vagina = $("#u447_input").val();
		 		  /* if (vagina != undefined) {
		 			 document.getElementById('u644_input').selectedIndex = 0;
		 			 document.getElementById('u644_input').disabled=true;
				  } */
		 		  if (vagina == "其他") {
					  $("#u464_input").show(); 
				  }else{
		 			 $("#u464_input").hide();
		 			$("#u464_input").val("");
				  }
		 		});
		 		
		 		//流产
		 		$("#u375_input").hide();
		 		$("#u371_input").change(function(){
		 		  var vagina = $("#u371_input").val();
		 		  if (vagina == "7") {
					  $("#u375_input").show(); 
				  }else{
		 			 $("#u375_input").hide();
		 			$("#u375_input").val("");
				  }
		 		});
		 		
		 		//子宫
		 		$("#u472_input").hide();
		 		$("#u471_input").change(function(){
		 		  var vagina = $("#u471_input").val();
		 		  /* if (vagina != undefined) {
		 			 document.getElementById('u644_input').selectedIndex = 0;
		 			 document.getElementById('u644_input').disabled=true;
				  } */
		 		  if (vagina == "1") {
					  $("#u472_input").show(); 
				  }else{
		 			 $("#u472_input").hide();
		 			 $("#u472_input").val("");
				  }
		 		});
		 		
		 		//附件
		 		$("#u476_input").hide();
		 		$("#u475_input").change(function(){
		 		  var vagina = $("#u475_input").val();
		 		  /* if (vagina != undefined) {
		 			 document.getElementById('u644_input').selectedIndex = 0;
		 			 document.getElementById('u644_input').disabled=true;
				  } */
		 		  if (vagina == "0") {
		 			 $("#u476_input").hide();
		 			$("#u476_input").val("");
				  }else{
					  $("#u476_input").show(); 
				  }
		 		});
		 		
		 		//胸透
		 		$("#u534_input").hide();
		 		$("#u147_input").change(function(){
		 		  var vagina = $("#u147_input").val();
		 		  if (vagina == "1") {
					  $("#u534_input").show(); 
				  }else{
		 			 $("#u534_input").hide();
		 			$("#u534_input").val("");
				  }
		 		});
		 		
		 		//指定传染病
		 		$("#u515_input").hide();
		 		$("#u514_input").change(function(){
		 		  var vagina = $("#u514_input").val();
		 		  if (vagina == "6") {
					  $("#u515_input").show(); 
				  }else{
		 			 $("#u515_input").hide();
		 			$("#u515_input").val("");
				  }
		 		});
		 		
		 		//严重遗传病
		 		$("#u519_input").hide();
		 		$("#u518_input").change(function(){
		 		  var vagina = $("#u518_input").val();
		 		  
		 		  if (vagina == "16") {
		 			 
					  $("#u519_input").show(); 
				  }else{
		 			 $("#u519_input").hide();
		 			$("#u519_input").val("");
				  }
		 		});
		 		
		 		//精神病
		 		$("#u523_input").hide();
		 		$("#u522_input").change(function(){
		 		  var vagina = $("#u522_input").val();
		 		  if (vagina == "25") {
					  $("#u523_input").show(); 
				  }else{
		 			 $("#u523_input").hide();
		 			$("#u523_input").val("");
				  }
		 		});
		 		
		 		//生殖系统疾病
		 		$("#u527_input").hide();
		 		$("#u526_input").change(function(){
		 		  var vagina = $("#u526_input").val();
		 		  if (vagina == "38") {
					  $("#u527_input").show(); 
				  }else{
		 			 $("#u527_input").hide();
		 			$("#u527_input").val("");
				  }
		 		});
		 		
		 		//内科疾病
		 		$("#u531_input").hide();
		 		$("#u530_input").change(function(){
		 		  var vagina = $("#u530_input").val();
		 		  if (vagina == "59") {
					  $("#u531_input").show(); 
				  }else{
		 			 $("#u531_input").hide();
		 			$("#u531_input").val("");
				  }
		 		});
		 		
		 		//家族近亲婚配
		 		$("#u353_input").hide();
		 		$("#u305_input").change(function(){
		 		  var vagina = $("#u305_input").val();
		 		  if (vagina == "4") {
					  $("#u353_input").show(); 
				  }else{
		 			 $("#u353_input").hide();
		 			$("#u353_input").val("");
				  }
		 		});
		 		
		 		//早产
		 		$("#u374_input").hide();
		 		$("#u370_input").change(function(){
		 		  var vagina = $("#u370_input").val();
		 		  if (vagina == "7") {
					  $("#u374_input").show(); 
				  }else{
		 			 $("#u374_input").hide();
		 			$("#u374_input").val("");
				  }
		 		});
		 		
		 		//心律
		 		$("#u409_input").hide();
		 		$("#u408_input").change(function(){
		 		  var vagina = $("#u408_input").val();
		 		  if (vagina == "4") {
					  $("#u409_input").show(); 
				  }else{
		 			 $("#u409_input").hide();
		 			$("#u409_input").val("");
				  }
		 		});
		 		
		 		//子女
		 		$("#u376_input").hide();
		 		$("#u372_input").change(function(){
		 		  var vagina = $("#u372_input").val();
		 		  if (vagina == "7") {
					  $("#u376_input").show(); 
				  }else{
		 			 $("#u376_input").hide();
		 			$("#u376_input").val("");
				  }
		 		});
		 		
		 		//末次月经
		 		/* $("#u354_input").change(function(){
		 		  var lastMenstrualPeriod = $("#u354_input").val();
					
				  var y = lastMenstrualPeriod.substr(0,4);
				  
				  var m = lastMenstrualPeriod.substr(4,2);
				  
				  var d = lastMenstrualPeriod.substr(6,2);
				  
				  var last = y + '-' + m + '-' + d;
				  
				  $("#u354_input").val(last);
				  
		 		}); */
		 		
		 		//智力
		 		$("#u392_input").hide();
		 		$("#u391_input").change(function(){
		 		  var vagina = $("#u391_input").val();
		 		  if (vagina == "1") {
					  $("#u392_input").show(); 
				  }else{
		 			 $("#u392_input").hide();
		 			$("#u392_input").val("");
				  }
		 		});
		 		
		 		//既往婚育史
		 		$("#u295_input").hide();
		 		$("#u298_input").hide();
		 		$("#u373_input").hide();
		 		$("#u370_input").hide();
		 		$("#u374_input").hide();
		 		$("#u371_input").hide();
		 		$("#u375_input").hide();
		 		$("#u372_input").hide();
		 		$("#u376_input").hide();
		 		$("#u296").hide();
		 		$("#u299").hide();
		 		$("#u302").hide();
		 		$("#u303").hide();
		 		$("#u369_input").change(function(){
		 		  var vagina = $("#u369_input").val();
		 		  if (vagina == "1") {
					  $("#u295_input").show();
					  $("#u298_input").show();
					  $("#u370_input").show();
					  $("#u371_input").show();
					  $("#u372_input").show();
					  $("#u296").show();
				 	  $("#u299").show();
				 	  $("#u302").show();
				 	  $("#u303").show();
				  }else{
		 			 $("#u295_input").hide();
		 			 $("#u298_input").hide();
					 $("#u370_input").hide();
					 $("#u371_input").hide();
					 $("#u372_input").hide();
					 $("#u373_input").hide();
					 $("#u374_input").hide();
					 $("#u375_input").hide();
					 $("#u376_input").hide();
					 $("#u296").hide();
				 	 $("#u299").hide();
				 	 $("#u302").hide();
				 	 $("#u303").hide();
				 	 $("#u298_input").val("");
					 $("#u370_input").val("");
					 $("#u371_input").val("");
					 $("#u372_input").val("");
		 			$("#u295_input")[0].selectedIndex = -1;
		 			$("#u298_input")[0].selectedIndex = -1;
		 			$("#u370_input")[0].selectedIndex = -1;
		 			$("#u371_input")[0].selectedIndex = -1;
		 			$("#u372_input")[0].selectedIndex = -1;
				  }
		 		});
		 		
		 		//转诊
				$("input[name^='referral']").click(function(){
					
			        if($("#u223_input").attr("checked")){
			        	
			            $("#u229_input")[0].readOnly=true;
			            //document.getElementById("u511_input").value="";
				 		document.getElementById("u235_input").disabled=true;
				 		$("#u235_input").val("");
				 		$("#u238_input").val("");
				 		document.getElementById('u232_input').disabled=true;
				 		$("#u232_input")[0].selectedIndex = -1;
				 		$("#u508_input")[0].selectedIndex = -1;
				 		$("#u229_input").val("");
				 		
				 		/* var referral = $("#referralDate").val();
				 		if (referral == "0") {
			 				
			 				$("#referralDate").attr("name","referralDate");
						} */
			        }
			        if($("#u225_input").attr("checked")){
			        	
			            $("#u229_input")[0].readOnly=false;
			            /* document.getElementById("u511_input").value=(year)+"-"+(month)+"-"+(date);
				 		document.getElementById("u235_input").value=(year)+"-"+(month)+"-"+(date);
				 		document.getElementById("u238_input").value=(year)+"-"+(month)+"-"+(date); */
				 		document.getElementById("u235_input").disabled=false;
				 		document.getElementById('u232_input').disabled=false;
				 		
			        }
			    });
			 	
		 		//阴道分泌物
		 		$("input[name^='vaginalDischarge']").click(function(){
			        
			        if($("#u96_input").attr("checked")){
			        	
			        	$("#u98_input").attr("checked",false);
			        	$("#u100_input").attr("checked",false);
			        	$("#u197_input").attr("checked",false);
			        	$("#u196_input").hide();
			        	$("#u196_input").val("");
			        }
			    });
		 		
		 		//既往病史
		 		$("input[name^='medicalHistory']").click(function(){
			        
			        if($("#u309_input").attr("checked")){
			        	
			        	$("#u311_input").attr("checked",false);
			        	$("#u313_input").attr("checked",false);
			        	$("#u315_input").attr("checked",false);
			        	$("#u317_input").attr("checked",false);
			        	$("#u319_input").attr("checked",false);
			        	$("#u321_input").attr("checked",false);
			        	$("#u323_input").attr("checked",false);
			        	$("#u325_input").attr("checked",false);
			        	$("#u327_input").attr("checked",false);
			        	$("#u329_input").attr("checked",false);
			        	$("#u331_input").attr("checked",false);
			        	$("#u358_input").hide();
			        	$("#u358_input").val("");
			        }else{
			        	$("#u358_input").show();
			        }
			    });
		 		
		 		//检查结果
		 		$("input[name^='checkResult']").click(function(){
			        
			        if($("#u213_input").attr("checked")){
			        	//选择未见异常下拉框不能选择
			        	$("#u514_input")[0].selectedIndex = -1;
			        	$("#u518_input")[0].selectedIndex = -1;
			        	$("#u522_input")[0].selectedIndex = -1;
			        	$("#u526_input")[0].selectedIndex = -1;
			        	$("#u530_input")[0].selectedIndex = -1;
			        	//$("#u499_input")[0].selectedIndex = -1;
			        	//$("#u504_input")[0].selectedIndex = -1;
			        	document.getElementById('u514_input').disabled=true;
			        	document.getElementById('u518_input').disabled=true;
			        	document.getElementById('u522_input').disabled=true;
			        	document.getElementById('u526_input').disabled=true;
			        	document.getElementById('u530_input').disabled=true;
			        	
			        	document.getElementById('u515_input').readOnly=true;
			        	document.getElementById('u519_input').readOnly=true;
			        	document.getElementById('u523_input').readOnly=true;
			        	document.getElementById('u527_input').readOnly=true;
			        	document.getElementById('u531_input').readOnly=true;
			        	$("#u515_input").hide();
			        	$("#u519_input").hide();
			        	$("#u523_input").hide();
			        	$("#u527_input").hide();
			        	$("#u531_input").hide();
			        	//选择未见异常清空输入框
			        	$("#u515_input").val("");
			        	$("#u519_input").val("");
			        	$("#u523_input").val("");
			        	$("#u527_input").val("");
			        	$("#u531_input").val("");
			        	//$("#u494_input").val("");
			        	//$("#u505_input").val("");
			        	
			        }
			        
			        if($("#u215_input").attr("checked")){
			        	
			        	document.getElementById('u514_input').disabled=false;
			        	document.getElementById('u518_input').disabled=false;
			        	document.getElementById('u522_input').disabled=false;
			        	document.getElementById('u526_input').disabled=false;
			        	document.getElementById('u530_input').disabled=false;
			        	
			        	document.getElementById('u515_input').readOnly=false;
			        	document.getElementById('u519_input').readOnly=false;
			        	document.getElementById('u523_input').readOnly=false;
			        	document.getElementById('u527_input').readOnly=false;
			        	document.getElementById('u531_input').readOnly=false;
			        	
			        }
			    });
		 		
		 		//与遗传有关的家族
		 		$("input[name^='geneticHistory']").click(function(){
			        
			        if($("#u333_input").attr("checked")){
			        	
			        	$("#u335_input").attr("checked",false);
			        	$("#u337_input").attr("checked",false);
			        	$("#u339_input").attr("checked",false);
			        	$("#u341_input").attr("checked",false);
			        	$("#u343_input").attr("checked",false);
			        	$("#u345_input").attr("checked",false);
			        	$("#u347_input").attr("checked",false);
			        	$("#u349_input").attr("checked",false);
			        	$("#u351_input").attr("checked",false);
			        	
			        	document.getElementById('u532_input').readOnly=true;
			        	document.getElementById('u535_input').readOnly=true;
			        	document.getElementById('u536_input').readOnly=true;
			        	document.getElementById('u643_input').readOnly=true;
			        	document.getElementById('u537_input').readOnly=true;
			        	document.getElementById('u538_input').readOnly=true;
			        	document.getElementById('u539_input').readOnly=true;
			        	document.getElementById('u540_input').readOnly=true;
			        	
			        	$("#u532_input").val("");
			        	$("#u536_input").val("");
			        	$("#u535_input").val("");
			        	$("#u643_input").val("");
			        	$("#u537_input").val("");
			        	$("#u538_input").val("");
			        	$("#u539_input").val("");
			        	$("#u540_input").val("");
			        	
			        	$("#u533_input").hide();
			        	$("#u541_input").hide();
			        	$("#u533_input").val("");
			        	$("#u541_input").val("");
			        }else{
			        	document.getElementById('u532_input').readOnly=false;
			        	document.getElementById('u535_input').readOnly=false;
			        	document.getElementById('u536_input').readOnly=false;
			        	document.getElementById('u643_input').readOnly=false;
			        	document.getElementById('u537_input').readOnly=false;
			        	document.getElementById('u538_input').readOnly=false;
			        	document.getElementById('u539_input').readOnly=false;
			        	document.getElementById('u540_input').readOnly=false;
			        }
			    });
		 		
					var tag = /^\d+(\.\d+)?$/;
				//血红蛋白值
		 		$("#u151_input").change(function(){
					var b = $.trim(this.value);
					
					if(!tag.test(b)){
						alert("只能输入数字或小数!");
					}
					if(b < 110){
						$("#u60_").html("↓");
					}else if(b > 150){
						$("#u60_").html("↑");
					}else{
						$("#u60_").html("");
					}
					if(b == null || b == ""){
						$("#u60_").html("");
					}
				});
		 		
				//白细胞
		 		$("#u152_input").change(function(){
					
					var c = $.trim(this.value);
					if(!tag.test(c)){
						alert("只能输入数字或小数!");
					}
					if(c < 4.0){
						$("#u152_").html("↓");
					}else if(c > 10.0){
						$("#u152_").html("↑");
					}else{
						$("#u152_").html("");
					}
					if(c == null || c == ""){
						$("#u152_").html("");
					}
				});
		 		
				//血小板
				$("#u153_input").change(function(){
					
					var d = $.trim(this.value);
					if(!tag.test(d)){
						alert("只能输入数字或小数!");
					}
					if(d < 100){
						$("#u153_").html("↓");
					}else if(d > 300){
						$("#u153_").html("↑");
					}else{
						$("#u153_").html("");
					}
					if(d == null || d == ""){
						$("#u153_").html("");
					}
				});
				
				//白蛋白
				$("#u191_input").change(function(){
					
					var d1 = $.trim(this.value);
					if(!tag.test(d1)){
						alert("只能输入数字或小数!");
					}
					if(d1 < 38.0){
						$("#u191_").html("↓");
					}else if(d1 > 53.0){
						$("#u191_").html("↑");
					}else{
						$("#u191_").html("");
					}
					if(d1 == null || d1 == ""){
						$("#u191_").html("");
					}
				});
				
				//总胆红素
				$("#u192_input").change(function(){
					
					var d2 = $.trim(this.value);
					if(!tag.test(d2)){
						alert("只能输入数字或小数!");
					}
					if(d2 < 3.42){
						$("#u192_").html("↓");
					}else if(d2 > 20.50){
						$("#u192_").html("↑");
					}else{
						$("#u192_").html("");
					}
					if(d2 == null || d2 == ""){
						$("#u192_").html("");
					}
				});
				
		 		
		 		//下拉框默认为空
		 		var a=$(".test");
				for(var i = 0;i< a.length;i++){
					a[i].selectedIndex = -1;
				}
				
		 		  var addUrl = "${ctx}/premaritalexainfo/add"
		 		  var inUrl = "${ctx}/premaritalexainfo/finishAdd"
		 		  var womanPresentationUrl = "${ctx}/premaritalexainfo/womanPresentation"
		 		  //保存
			 	  $("#u241").click(function(){
			 		 var premaritalId = $("#premaritalId").val();
			 		 var exc = $("#u514_input").val();
			 		 document.getElementById("u235_input").disabled=false;
			 		  $("#from").attr("action",addUrl);
			    	  $("#from").submit();
			      });
		 		  
		 		  
		 		  
		 		  //完成
		 		  $("#u243").click(function(){
		 			  
			    	  var reg = /^[_0-9a-zA-Z\u4e00-\u9fa5]{1,10}$/;
			    	  
			    	  //数字
			    	  var number = /^[0-9]*$/;
			    	  
			    	  //验证m-n位的数字
			    	  var num = /^\d+(-\d+)*$/;
			    	  
			    	  //数字，可以输入小数点
				      var smallNumber = /^\d+(\.\d+)?$/;
			    	  
		 			  //血缘关系
		 			  var kinship = $("#u262_input").val();
		 			  
		 			  if (kinship == null) {
						  alert("血缘关系不能为空");
						  return false;
					  }
		 			  
		 			  //既往病史
		 			  var medicalHistory = $("input[name^='medicalHistory']:checked").val();
		 			  
		 			  if (medicalHistory == undefined) {
						alert("既往病史不能为空");
						return false;
					  }
		 			  
		 			  //手术史
		 			  var surgeryHistory = $("#u279_input").val();
		 			  if (surgeryHistory == null) {
		 				  alert("手术史不能为空");
						  return false;
					  }
		 			  
		 			  //现病史
		 			  var hpi = $("#u283_input").val();
		 			  if (hpi == null) {
		 				  alert("现病史不能为空");
						  return false;
					  }
		 			  
		 			  var str = $("#u355_input").val();
			    	  //用户名只能为下划线、数字、字母或中文长度不超过10个字符
			    	  //年龄
			    	  var age = $("#u359_input").val();
			    	  if (age == null || age == "") {
			    		  alert("年龄不能为空！");
					  		return false;
					  }
			    	  if (!number.test(age)) {
					  		alert("您输入的年龄格式错误！");
					  		return false;
					  }
			    	  
			    	  
			    	  //经期
			    	  var menstrualPeriod = $("#u362_input").val();
			    	  if (menstrualPeriod == null || menstrualPeriod == "") {
						  alert("经期不能为空！");
						  return false;
					  }
			    	  if (!num.test(menstrualPeriod)) {
					  		alert("您输入的经期格式错误！");
					  		return false;
					  }
			    	  //周期
			    	  var cycle = $("#u365_input").val();
					  if (cycle == null || cycle == "") {
						  alert("周期不能为空！");
						  return false;
					  }
			    	  if (!number.test(cycle)) {
					  		alert("您输入的周期格式错误！");
					  		return false;
					  }
			    	  
			    	  //量
			    	  var amount = $("#u368_input").val();
		 			  if (amount == null) {
		 				  alert("量不能为空");
						  return false;
					  }
			    	  
			    	  //痛经
			    	  var dysmenorrhea = $("#u292_input").val();
		 			  if (dysmenorrhea == null) {
		 				  alert("痛经不能为空");
						  return false;
					  }
		 			  
			    	  //末次月经
			    	  var lastMenstrualPeriod = $("#u354_input").val();
			    	  if (lastMenstrualPeriod == null || lastMenstrualPeriod == "") {
		 				  alert("末次月经不能为空");
						  return false;
					  }
			    	  
			    	  //是否怀孕
			    	  var whetherPregnant = $("#u308_input").val();
			    	  if (whetherPregnant == null) {
			    		  alert("是否怀孕不能为空");
						  return false;
					  }
			    		   
			    	 //既往婚育史
			    	 var marriedHistory = $("#u369_input").val();
			    	 if (marriedHistory == null) {
			    		  alert("既往婚育史不能为空");
						  return false;
					 }
			    	 
			    	 //与遗传有关的家族
			    	 var geneticHistory = $("input[name='geneticHistory']:checked").val();
		 			  
		 			 if (geneticHistory == undefined) {
						alert("与遗传有关的家族不能为空");
						return false;
					 }
		 			 
		 			 //家族近亲婚配
		 			 var relativesMating = $("#u305_input").val();
			    	 if (relativesMating == null) {
			    		  alert("家族近亲婚配不能为空");
						  return false;
					 } 
			    	 
			    	 //血压
			    	 
			    	 var bloodLow = $("#u48_input").val();
			    	 var bloodHi = $("#u51_input").val();
		 			  
			    	 if (bloodLow == null || bloodLow == "") {
						  alert("血压值不能为空！");
						  return false;
					 }
			    	 if (bloodHi == null || bloodHi == "") {
						  alert("血压值不能为空！");
						  return false;
					 }
			    	 if (!smallNumber.test(bloodLow)) {
					  		alert("您输入的血压低值格式错误！");
					  		return false;
					 }
			    	 if (!smallNumber.test(bloodHi)) {
					  		alert("您输入的血压高值格式错误！");
					  		return false;
					 }
					 
					 //特殊体态
					 var specialPosture = $("#u379_input").val();
					 if (specialPosture == null) {
						  alert("特殊体态不能为空");
						  return false;
					 }
					 
					 //特殊面容
					 var specialFace = $("#u383_input").val();
					 if (specialFace == null) {
						  alert("特殊面容不能为空");
						  return false;
					 }
					 
					 //精神状态
					 var mentalState = $("#u387_input").val();
					 if (mentalState == null) {
						  alert("精神状态不能为空");
						  return false;
					 }
					 
					//智力
					 var intelligence = $("#u391_input").val();
					 if (intelligence == null) {
						  alert("智力不能为空");
						  return false;
					 }
					 
					//皮肤毛发
					 var skinHair = $("#u395_input").val();
					 if (skinHair == null) {
						  alert("皮肤毛发不能为空");
						  return false;
					 }
					 
					//五官
					 var facialFeatures = $("#u52_input").val();
					 if (facialFeatures == null) {
						  alert("五官不能为空");
						  return false;
					 }
					 
					//甲状腺
					 var thyroidGland = $("#u399_input").val();
					 if (thyroidGland == null) {
						  alert("甲状腺不能为空");
						  return false;
					 }
					 
					 //心率
					 var heartRate = $("#u403_input").val();
					 if (heartRate == null || heartRate == "") {
						  alert("心率不能为空！");
						  return false;
					 }
					 if (!number.test(heartRate)) {
					  		alert("您输入的心率值格式错误！");
					  		return false;
					 }
					 
					 //心律
					 var heartRhythm = $("#u408_input").val();
					 if (heartRhythm == null) {
						  alert("心律不能为空");
						  return false;
					 }
					 
					 //杂音
					 var noise = $("#u412_input").val();
					 if (noise == null) {
						  alert("杂音不能为空");
						  return false;
					 }
					 
					//肺
					 var lung = $("#u416_input").val();
					 if (lung == null) {
						  alert("肺不能为空");
						  return false;
					 }
					 
					//肝
					 var liver = $("#u420_input").val();
					 if (liver == null) {
						  alert("肝不能为空");
						  return false;
					 }
					 
					//四肢脊柱
					 var limbs = $("#u424_input").val();
					 if (limbs == null) {
						  alert("四肢脊柱不能为空");
						  return false;
					 }
					 
					//第二性征--阴毛
					 var pubicHair = $("#u457_input").val();
					 if (pubicHair == null) {
						  alert("第二性征-阴毛不能为空");
						  return false;
					 }
					 
					//乳房
					 var breast = $("#u449_input").val();
					 if (breast == null) {
						  alert("第二性征-乳房不能为空");
						  return false;
					 }
					 
					//外阴
					 var anusVulva = $("#u451_input").val();
					 if (anusVulva == null) {
						  alert("第二性征-外阴不能为空");
						  return false;
					 }
					 
					//是否同意阴道检查
					 var vaginalExamination = $("#u644_input").val();
					 if (vaginalExamination == null) {
						  alert("是否同意阴道检查不能为空");
						  return false;
					 }
					 
					 //血红蛋白值  110-150
					 var hemoglobin = $("#u151_input").val();
					 if (hemoglobin == null || hemoglobin == "") {
						alert("血红蛋白值不能为空！");
						return false;
					 }
					 if (!smallNumber.test(hemoglobin)) {
						alert("您输入的血红蛋白值格式错误！");
						return false;
					 }
					 
					 //白细胞计数值  4-9
					 var whiteCellCount = $("#u152_input").val();
					 
					 if (whiteCellCount == null || whiteCellCount == "") {
						 alert("白细胞计数值不能为空！");
							return false;
					 }
					 if (!smallNumber.test(whiteCellCount)) {
						 alert("您输入的白细胞计数值格式错误！");
							return false;
					 }
					 
					 //血小板计数值
					 var platelet = $("#u153_input").val();
					 if (platelet == null || platelet == "") {
						 alert("血小板计数值不能为空！");
							return false;
					 }
					 if (!smallNumber.test(platelet)) {
						 alert("您输入的血小板计数值格式错误！");
							return false;
					 }
					 
					 //尿糖
					 var urineSugar = $("#u170_input").val();
					 if (urineSugar == null || urineSugar == "") {
						 alert("尿糖不能为空！");
							return false;
					 }
					 if (!smallNumber.test(urineSugar)) {
						 alert("您输入的尿糖值格式错误！");
							return false;
					 }
					 
					 //尿酮体
					 var ketoneBody = $("#u171_input").val();
					 if (ketoneBody == null || ketoneBody == "") {
						 alert("尿酮体不能为空！");
							return false;
					 }
					 if (!smallNumber.test(ketoneBody)) {
						 alert("您输入的尿酮体值格式错误！");
							return false;
					 }
					 
					//尿蛋白
					 var urineProtein = $("#u172_input").val();
					 if (urineProtein == null || urineProtein == "") {
						 alert("尿蛋白不能为空！");
							return false;
					 }
					 if (!smallNumber.test(urineProtein)) {
						 alert("您输入的尿蛋白值格式错误！");
							return false;
					 }
					 
					//PH
					 var ph = $("#u492_input").val();
					 if (ph == null || ph == "") {
						 alert("PH不能为空！");
							return false;
					 }
					 if (!smallNumber.test(ph)) {
						 alert("您输入的PH值格式错误！");
							return false;
					 }
					 
					//尿潜血
					 var ery = $("#u173_input").val();
					 if (ery == null || ery == "") {
						 alert("尿潜血不能为空！");
							return false;
					 }
					 if (!smallNumber.test(ery)) {
						 alert("您输入的尿潜血值格式错误！");
							return false;
					 }
					 
					//白细胞
					 var whiteCell = $("#u489_input").val();
					 if (whiteCell == null || whiteCell == "") {
						 alert("白细胞不能为空！");
							return false;
					 }
					 if (!smallNumber.test(whiteCell)) {
						 alert("您输入的白细胞值格式错误！");
							return false;
					 }
					 
					//血清谷丙转氨酶
					 var serumAlt = $("#u189_input").val();
					 if (serumAlt == null || serumAlt == "") {
						 alert("血清谷丙转氨酶不能为空！");
							return false;
					 }
					 if (!smallNumber.test(serumAlt)) {
						 alert("您输入的血清谷丙转氨酶值格式错误！");
							return false;
					 }
					 
					//血清谷草转氨酶
					 var aspertateAmi = $("#u190_input").val();
					 if (aspertateAmi == null || aspertateAmi == "") {
						 alert("血清谷草转氨酶不能为空！");
							return false;
					 }
					 if (!smallNumber.test(aspertateAmi)) {
						 alert("您输入的血清谷草转氨酶值格式错误！");
							return false;
					 }
					 
					//白蛋白
					 var albumin = $("#u191_input").val();
					 if (albumin == null || albumin == "") {
						 alert("白蛋白不能为空！");
							return false;
					 }
					 if (!smallNumber.test(albumin)) {
						 alert("您输入的白蛋白值格式错误！");
							return false;
					 }
					 
					//总胆红素
					 var totalBilirubin = $("#u192_input").val();
					 if (totalBilirubin == null || totalBilirubin == "") {
						 alert("总胆红素不能为空！");
							return false;
					 }
					 if (!smallNumber.test(totalBilirubin)) {
						 alert("您输入的总胆红素值格式错误！");
							return false;
					 }
					 
					//结合胆红素
					 var combiningBilirubin = $("#u193_input").val();
					 if (combiningBilirubin == null || combiningBilirubin == "") {
						 alert("结合胆红素不能为空！");
							return false;
					 }
					 if (!smallNumber.test(combiningBilirubin)) {
						 alert("您输入的结合胆红素值格式错误！");
							return false;
					 }
					 
					//血清肌酐
					 var serumCreatinine = $("#u194_input").val();
					 if (serumCreatinine == null || serumCreatinine == "") {
						 alert("血清肌酐不能为空！");
							return false;
					 }
					 if (!smallNumber.test(serumCreatinine)) {
						 alert("您输入的血清肌酐值格式错误！");
							return false;
					 }
					 
					//血尿素氮
					 var bloodUreaNitrogen = $("#u195_input").val();
					 if (bloodUreaNitrogen == null || bloodUreaNitrogen == "") {
						 alert("血尿素氮不能为空！");
							return false;
					 }
					 if (!smallNumber.test(bloodUreaNitrogen)) {
						 alert("您输入的血尿素氮值格式错误！");
							return false;
					 }
					 
					//乙型肝炎表面抗原
			    	 var antigenHepatitis = $("input[name='antigenHepatitis']:checked").val();
		 			//乙肝五项第一项为阳性时，其他四项不能为空
		 			//乙型肝炎表面抗体
		 			var hepatitisAntibody = $("input[name='hepatitisAntibody']:checked").val();
		 			//乙型肝炎核心抗体
		 			var coreAntibody = $("input[name='coreAntibody']:checked").val();
		 			//乙型肝炎e抗体
		 			var eantibody = $("input[name='eantibody']:checked").val();
		 			//乙型肝炎e抗原
		 			var eantigen = $("input[name='eantigen']:checked").val();
		 			  
		 			 if (antigenHepatitis == undefined) {
						alert("乙型肝炎表面抗原不能为空");
						return false;
					 }
		 			 if (antigenHepatitis == "1") {
		 				 if (hepatitisAntibody == undefined) {
							alert("乙型肝炎表面抗体不能为空");
							return false;
						 }
		 				 if (coreAntibody == undefined) {
							alert("乙型肝炎核心抗体不能为空");
							return false;
						 }
		 				 if (eantibody == undefined) {
							alert("乙型肝炎e抗体不能为空");
							return false;
						 }
		 				 if (eantigen == undefined) {
							alert("乙型肝炎e抗原不能为空");
							return false;
						 }
					 }
		 			 
		 			//梅毒血清学试验
			    	 var syphilisSerum = $("input[name='syphilisSerum']:checked").val();
		 			  
		 			 if (syphilisSerum == undefined) {
						alert("梅毒血清学试验不能为空");
						return false;
					 }
					 
		 			//HIV抗体检测
			    	 var hivAntibodies = $("input[name='hivAntibodies']:checked").val();
		 			  
		 			 if (hivAntibodies == undefined) {
						alert("HIV抗体检测不能为空");
						return false;
					 }
		 			 
		 			//检查结果
			    	 var checkResult = $("input[name='checkResult']:checked").val();
		 			  
		 			 if (checkResult == undefined) {
						alert("检查结果不能为空");
						return false;
					 }
		 			 
					 //医学意见
					 var medicalAdvice = $("#u499_input").val();
					 if (medicalAdvice == null) {
						 alert("医学意见不能为空！");
							return false;
					 }
					 
					//婚前卫生咨询
					 var maritalConsultation = $("#u505_input").val();
					 
					 if (maritalConsultation == null || maritalConsultation == "") {
						 alert("婚前卫生咨询不能为空！");
							return false;
					 }
					 
					 //咨询指导结果
					 var consultativeResults = $("#u504_input").val();
					 if (consultativeResults == null) {
						 alert("咨询指导结果不能为空！");
							return false;
					 }
					 
					 //转诊
					 var referral = $("input[name='referral']:checked").val();
		 			  
		 			 if (referral == undefined) {
						alert("转诊不能为空");
						return false;
					 }
		 			 
		 			 
		 			 //出具《婚前医学检查证明》日期
		 			 var issuedByDate = $("#u511_input").val();
		 			 
					 if (issuedByDate == null || issuedByDate == "") {
						 alert("出具《婚前医学检查证明》日期不能为空！");
							return false;
					 }
					 document.getElementById("u235_input").disabled=false;
		 			 
		 			 $.ajax({
	    					url:inUrl,
	    					type:"POST",
	    					data:$('#from').serialize(),
	    					success:function(data){
	    						$("#archId").val( );
					 			showDialog_("提示","finishForm","moremiddle4");
	    						
	    					}
	    			 });
			      });
		 		  
		 		 
		 		  //进入婚检报告
		 		  $("#u06").click(function(){
		 			 
		 			 var id = $("#archId").val();
		 			 var premaritalId = $("#premaritalId").val();
		 			window.location = womanPresentationUrl+'?id='+id+"&premaritalId="+premaritalId;
		 			
		 		  })
		 		  
	    		  //年龄
	    		  var birthday = $("#birthday").html();
	    		  var nowdate = new Date();
	    		  var age = nowdate.getFullYear() - birthday.substr(0,4);
	    		  $("#u14").html("年龄："+age);
	    		  
	    		  var hospitalUrl = "${ctx}/premaritalexainfo/hospital"
	    		  
	    			//转诊机构下拉列
	 	 			$.ajax({
	 	 				dataType:'json',
	 	 	 			url:hospitalUrl,
	 	 	 			success:function(data){
		 	 	 			$("#u232_input").html("");
		 	 	 			var str = "" ;
		 	 	 			for(var i = 0;i<data.list.length;i++){
		 	 	 				str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
		 	 	 			}
		 	 	 			$("#u232_input").html(str);
		 	 	 			$("#u232_input")[0].selectedIndex = -1;
	 	 	 			}
	 	 	 		});
	    	 		
	    		  
	    		  //检查异常下拉列
	 	 		  $.ajax({
	 	 			  dataType:'json',
	 	 	 		  url:excTerm1Url,
	 	 	 		  success:function(data){
	 	 	 			  //指定传染病
	 	 	 			  $("#u514_input").html("");
		 	 	 		  var str0 = "" ;
		 	 	 		  for(var i = 0;i<data.list0.length;i++){
		 	 	 			  str0 += "<option value="+data.list0[i].id+">"+data.list0[i].name+"</option>" ;
		 	 	 		  }
		 	 	 		  str0 += "<option value='6'>其他</option>" ;
		 	 	 		  $("#u514_input").html(str0);
		 	 	 		  $("#u514_input")[0].selectedIndex = -1;
		 	 	 		  
		 	 	 		  //严重遗传病
		 	 	 		  $("#u518_input").html("");
		 	 	 		  var str1 = "" ;
		 	 	 		  for(var i = 0;i<data.list1.length;i++){
		 	 	 			  str1 += "<option value="+data.list1[i].id+">"+data.list1[i].name+"</option>" ;
		 	 	 		  }
		 	 	 		  str1 += "<option value='16'>其他</option>" ;
		 	 	 		  $("#u518_input").html(str1);
		 	 	 		  $("#u518_input")[0].selectedIndex = -1;
		 	 	 		  
		 	 	 		  //精神病
		 	 	 		  $("#u522_input").html("");
		 	 	 		  var str2 = "" ;
		 	 	 		  for(var i = 0;i<data.list2.length;i++){
		 	 	 			  str2 += "<option value="+data.list2[i].id+">"+data.list2[i].name+"</option>" ;
		 	 	 		  }
		 	 	 		  str2 += "<option value='25'>其他</option>" ;
		 	 	 		  $("#u522_input").html(str2);
		 	 	 		  $("#u522_input")[0].selectedIndex = -1;
		 	 	 		  
		 	 	 		  //女性生殖系统疾病
		 	 	 		  $("#u526_input").html("");
		 	 	 		  var str4 = "" ;
		 	 	 		  for(var i = 0;i<data.list4.length;i++){
		 	 	 			  str4 += "<option value="+data.list4[i].id+">"+data.list4[i].name+"</option>" ;
		 	 	 		  }
		 	 	 		  str4 += "<option value='38'>其他</option>" ;
		 	 	 		  $("#u526_input").html(str4);
		 	 	 		  $("#u526_input")[0].selectedIndex = -1;
		 	 	 		  
		 	 	 		  //内科疾病
		 	 	 		  $("#u530_input").html("");
		 	 	 		  var str5 = "" ;
		 	 	 		  for(var i = 0;i<data.list5.length;i++){
		 	 	 			  str5 += "<option value="+data.list5[i].id+">"+data.list5[i].name+"</option>" ;
		 	 	 		  }
		 	 	 		  str5 += "<option value='59'>其他</option>" ;
		 	 	 		  $("#u530_input").html(str5);
		 	 	 		  $("#u530_input")[0].selectedIndex = -1;
	 	 	 		  }
	 	 	 	  });
	    		  
	    		  var doctorUrl = "${ctx}/premaritalexainfo/doctor"
		    	  //预约医生
		    	  $.ajax({
	 	 				dataType:'json',
	 	 	 			url:doctorUrl,
	 	 	 			success:function(data){
		 	 	 			$("#u508_input").html("");
		 	 	 			var str = "" ;
		 	 	 			for(var i = 0;i<data.list.length;i++){
		 	 	 				str += "<option value="+data.list[i].id+">"+data.list[i].realName+"</option>" ;
		 	 	 			}
		 	 	 			$("#u508_input").html(str);
		 	 	 			$("#u508_input")[0].selectedIndex = -1;
	 	 	 			}
	 	 	 		});
		    	  /* $("#u232_input").change(function(){
		    		  
		    		  var provinceId = $("#u232_input").val();
		    		  var doctorUrl = "${ctx}/premaritalexainfo/doctor";
		    		  province(doctorUrl,"u508_input",provinceId);
		    	  });
		    	  
		    	  function province(thisUrl,id,parentId){
			 			
		    		  $.ajax({
						dataType:'json',
						url:thisUrl,
						data:{parentId:parentId},
						success:function(data){
							
		 					$("#u508_input").html("");
		 					var str = "" ;
		 					for(var i = 0;i<data.list.length;i++){
		 						str += "<option value="+data.list[i].id+">"+data.list[i].realName+"</option>" ;
		 					}
		 					$("#u508_input").html(str);
		 					$("#u508_input")[0].selectedIndex = -1;
						}
					});
		    	  };
		    	   */
		    	 
		 	});
		 	
	 </script>
     
  <body>
      <div id = "u666" class="ax_形状" >
		   <!-- Unnamed (形状) -->
		  <div id="u239" class="ax_形状" style="background-color:#EE5F45;">
		          <p id="u240"><span>女性婚前医学检查</span></p>
		  </div>
	  
	  
	      <!-- Unnamed (形状) -->
	  	  <div id="u241" class="ax_形状" style="background-color:#009DD9;cursor:pointer">
	          <p id="u242"><span id="save">保存</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	  	  <div id="u243" class="ax_形状" style="background-color:#56BB4D;cursor:pointer">
	          <p id="u244"><span id = "finish">完成</span></p>
	      </div>
      </div>
	<form id="from" action="" method="post">
      <!-- Unnamed (形状) -->
  <div id="u2" class="ax_形状 "style="border-top:#B5B5B5 solid 1px;">
  
          <p id="u30"><span>检查医院：${archivesInfoDetail.operator.department }</span></p>
          <p id="u32"><span>检查医生：<input id = "realName" type = "hidden" name = "realName" value="${archivesInfoDetail.operator.realName }"/>${archivesInfoDetail.operator.realName }</span></p>
          <p id="u250"><span>检查日期：<input id = "createTime" type = "hidden" name = "createTime" value="${archivesInfoDetail.time }"/>${archivesInfoDetail.time }</span></p>
          <p id="u252"><span>档案编号：<input id = "archivesCode" type = "hidden" name = "archivesCode" value="${archivesInfoDetail.archivesInfo.archivesCode }"/>${archivesInfoDetail.archivesInfo.archivesCode }</span></p>
  </div>

      <!-- Unnamed (形状) -->
  <div id="u4" class="ax_形状" style="background-color:#009DD9;">
          <p id="u5"><span>个 人 基 本 信 息</span></p>
  </div>
      
<div id="u6" class="ax_形状" >
			<input id = "premaritalId" type = "hidden" name = "premaritalId" value = "${archivesInfoDetail.premaritalId }"/>
			<input id = "archivesId" type = "hidden" name = "archivesId" value = "${archivesInfoDetail.archivesInfo.id }"/>
          <p id="u16"><span>姓名：${archivesInfoDetail.archivesInfo.name }</span></p>
          <p id="u18"><span>性别：<input id = "sex" type = "hidden" name = "sex" value = "${archivesInfoDetail.archivesInfo.sex }"/>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex eq '1'}">
          			男
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex eq '0'}">
          			女
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex eq '2'}">
          			性别不明
          		</c:if>
          	</span>
          </p>
          <p id="u28"><span>出生日期：<span id = "birthday">${archivesInfoDetail.birthday }</span></span></p>
          <p id="u14"><span>年龄：</span></p>
          <p id="u8"><span>民族：${archivesInfoDetail.archivesInfo.nation }</span></p>
          <p id="u20"><span>身份证号码：${archivesInfoDetail.archivesInfo.idNo }</span></p>
          <p id="u10"><span>工作单位：${archivesInfoDetail.archivesInfo.workUnit }</span></p>
          <p id="u12"><span>职业：
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '1'}">
          			事业单位
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '2'}">
          			企业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '3'}">
          			服务业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '4'}">
          			制造业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '5'}">
          			农业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '6'}">
          			其他
          		</c:if>
          </span></p>
          <p id="u22"><span>户口所在地：</span>
          	  <span>${archivesInfoDetail.provinceInfo.name }</span>
   			  <span>${archivesInfoDetail.cityInfo.name }</span>
   			  <span>${archivesInfoDetail.districtAndCountyInfo.name }</span>
   			  <span>${archivesInfoDetail.townshipInfo.name }</span>
   			  <span>${archivesInfoDetail.villageInfo.name }</span>
   			  <span>${archivesInfoDetail.archivesInfo.accAddress }</span>
          </p>
          <p id="u24"><span>现住址：</span>
          	  <span>${archivesInfoDetail.provinceInfo1.name }</span>
   			  <span>${archivesInfoDetail.cityInfo1.name }</span>
   			  <span>${archivesInfoDetail.districtAndCountyInfo1.name }</span>
   			  <span>${archivesInfoDetail.townshipInfo1.name }</span>
   			  <span>${archivesInfoDetail.villageInfo1.name }</span>
   			  <span>${archivesInfoDetail.archivesInfo.homeAddress }</span>
          </p>
          <p id="u26"><span>联系电话：${archivesInfoDetail.archivesInfo.telephone }</span></p>
          <p id="u254"><span>文化程度：
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '0'}">
          			小学
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '1'}">
          			初中
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '2'}">
          			高中
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '3'}">
          			中专
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '4'}">
          			大专
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '5'}">
          			本科
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '6'}">
          			硕士
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '7'}">
          			博士
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '8'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '9'}">
          			不详
          		</c:if>
          </span></p>
          <p id="u256"><span>对方姓名：${archivesInfoDetail.archivesInfo.manName }</span></p>
          <p id="u258"><span>身份证号码：${archivesInfoDetail.archivesInfo.manIdNo }</span></p>

  </div>


  <div id="u34" class="ax_形状" style="background-color:#009DD9;" onclick="CanShu('u3','u34','u36');">
          <p id="u35" ><span>健 康 状 况</span></p>
          <p id="u36">展开</p>
  </div>

<div id="u3" class="ax_形状" style="display:none;">
         <p id="u260"><span>血缘关系</span><span>：</span></p>

  		<select id="u262_input" name = "kinship" class = "test">
          <option value="0">无</option>
          <option value="1">表</option>
          <option value="2">堂</option>
          <option value="3">其他（三代内）</option>
          <option value="4">其他（非三代内）</option>
        </select>

        <input id="u355_input" name = "otherRelationships" type="text" value=""/>


          <p id="u263"><span>既往病史</span><span>：</span></p>


      <div id="u309" class="ax_复选框">
		<input id="u309_input" name = "medicalHistory" type="checkbox" value="0"/>
            <p id="u310"><span>无</span></p>
      </div>

      <div id="u311" class="ax_复选框">
            <p id="u312"><span>心脏病</span></p>
        <input id="u311_input" name = "medicalHistory" type="checkbox" value="1"/>
      </div>

      <div id="u313" class="ax_复选框">
            <p id="u314"><span>肺结核</span></p>
        <input id="u313_input" name = "medicalHistory" type="checkbox" value="2"/>
      </div>

      <div id="u315" class="ax_复选框">
            <p id="u316"><span>肝脏病</span></p>
        <input id="u315_input" name = "medicalHistory" type="checkbox" value="3"/>
      </div>

      <div id="u317" class="ax_复选框">
            <p id="u318"><span>泌尿生殖系统疾病</span></p>
        <input id="u317_input" name = "medicalHistory" type="checkbox" value="4"/>
      </div>
	  
      <div id="u319" class="ax_复选框">
            <p id="u320"><span>糖尿病</span></p>
        <input id="u319_input" name = "medicalHistory" type="checkbox" value="5"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u321" class="ax_复选框">
            <p id="u322"><span>高血压</span></p>
        <input id="u321_input" name = "medicalHistory" type="checkbox" value="6"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u323" class="ax_复选框">
            <p id="u324"><span>精神病</span></p>
        <input id="u323_input" name = "medicalHistory" type="checkbox" value="7"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u325" class="ax_复选框">
            <p id="u326"><span>性病</span></p>
        <input id="u325_input" name = "medicalHistory" type="checkbox" value="8"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u327" class="ax_复选框">
            <p id="u328"><span>癫痫</span></p>
        <input id="u327_input" name = "medicalHistory" type="checkbox" value="9"/>
      </div>

      <!-- Unnamed (复选框) -->
  <div id="u329" class="ax_复选框">
            <p id="u330"><span>甲亢</span></p>
        <input id="u329_input" name = "medicalHistory" type="checkbox" value="10"/>
      </div>

      <!-- Unnamed (复选框) -->
  <div id="u331" class="ax_复选框">
            <p id="u332"><span>先天疾患</span></p>
        <input id="u331_input" name = "medicalHistory" type="checkbox" value="11"/>
      </div>

  <input id="u358_input" name = "medicalOther" type="text" value=""/>
  
          <p id="u265"><span>手术史：</span></p>
  <select id="u279_input" name = "surgeryHistory" class = "test">
          <option selected value="0">无</option>
          <option value="1">有</option>
        </select>

  <input id="u356_input" name = "operation" type="text" value="" placeholder = "有时显示输入框"/>
  
          <p id="u280"><span>其他：</span></p>
  <input id="u282_input" name = "operationOther" type="text" value=""/>

          <p id="u267"><span>现病史：</span></p>
  <select id="u283_input" name = "hpi" class = "test">
          <option selected value="0">无</option>
          <option value="1">有</option>
        </select>

  <input id="u357_input" name = "caseInformation" type="text" value="" placeholder = "有时显示输入框"/>

          <p id="u269"><span>月经史：</span></p>
          
          <p id="u285"><span>初潮年龄：</span></p>    
  <input id="u359_input" name = "menarcheAge" type="text" value=""/>
          <p id="u360"><span>岁</span></p>

          <p id="u286"><span>经期：</span></p>
  <input id="u362_input" name = "menstrualPeriod" type="text" value=""/>
          <p id="u363"><span>天</span></p>


          <p id="u288"><span>周期：</span></p>
  <input id="u365_input" name = "cycle" type="text" value=""/>
          <p id="u366"><span>天</span></p>

          <p id="u290"><span>量：</span></p>
  <select id="u368_input" name = "amount" class = "test">
          <option value="0">多</option>
          <option value="1">中</option>
          <option value="2">少</option>
        </select>

          <p id="u271"><span>痛经：</span></p>
        <select id="u292_input" name = "dysmenorrhea" class = "test">
          <option selected value="0">无</option>
          <option value="1">轻</option>
          <option value="2">中</option>
          <option value="3">重</option>
        </select>
        

          <p id="u293"><span>末次月经：</span></p>
  
        <input type="text" id="u354_input" name="lastMenstrualPeriod"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
       


          <p id="u306"><span>是否怀孕：</span></p>
  <select id="u308_input" name="whetherPregnant" class = "test">
          <option value="0">备孕</option>
          <option selected value="1">正常</option>
          <option value="2">现孕</option>
          <option value="3">已分娩</option>
        </select>

          <p id="u273"><span>既往婚育史：</span></p>
  <select id="u369_input" name="marriedHistory" class = "test">
          <option value="1">有</option>
          <option value="0">无</option>
        </select>

  <select id="u295_input" name="marriageStatus" class = "test">
          <option value="0">丧偶</option>
          <option selected value="1">离异</option>
        </select>

          <p id="u296"><span>足月：</span></p>
  <select id="u298_input" name="amontNumber" class = "test">
          <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
        </select>

  <input id="u373_input" name="amontNumberOther" type="text" value="" placeholder = "其他"/>

          <p id="u299"><span>早产：</span></p>
  <select id="u370_input" name="pretermDeliveryNum" class = "test">
          <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
        </select>

  <input id="u374_input" name="pretermDeliveryOther" type="text" value="" placeholder = "其他"/>

          <p id="u302"><span>流产：</span></p>
  <select id="u371_input" name="abortionNumber" class = "test">
          <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
        </select>

  <input id="u375_input" name="abortionOther" type="text" value="" placeholder = "其他"/>

          <p id="u303"><span>子女：</span></p>
  <select id="u372_input" name="childrenNumber" class = "test">
          <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
        </select>

  <input id="u376_input" name="childrenOther" type="text" value="" placeholder = "其他"/>

          <p id="u275"><span>与遗传有关的家族史：</span></p>

  <div id="u333" class="ax_复选框">
            <p id="u334"><span>无</span></p>
        <input id="u333_input" name="geneticHistory" type="checkbox" value="0"/>
      </div>

  <div id="u335" class="ax_复选框">
            <p id="u336"><span>盲</span></p>
        <input id="u335_input" name="geneticHistory" type="checkbox" value="1"/>
      </div>

  <input id="u532_input" name="patientRelationship" type="text" value="" placeholder = "患者与本人关系"/>

  <div id="u337" class="ax_复选框">
            <p id="u338"><span>聋</span></p>
        <input id="u337_input" name="geneticHistory" type="checkbox" value="2"/>
      </div>

  <input id="u535_input" name="patientRelationship" type="text" value="" placeholder = "患者与本人关系"/>

  <div id="u339" class="ax_复选框">
            <p id="u340"><span>哑</span></p>
        <input id="u339_input" name="geneticHistory" type="checkbox" value="3"/>
      </div>

  <input id="u536_input" name="patientRelationship" type="text" value="" placeholder = "患者与本人关系"/>

  <div id="u341" class="ax_复选框">
            <p id="u342"><span>精神病</span></p>
        <input id="u341_input" name="geneticHistory" type="checkbox" value="4"/>
      </div>
      
  <input id="u643_input" name="patientRelationship" type="text" value="" placeholder = "患者与本人关系"/>

  <div id="u343" class="ax_复选框">
            <p id="u344"><span>先天性智力低下</span></p>
        <input id="u343_input" name="geneticHistory" type="checkbox" value="5"/>
      </div>

  <input id="u537_input" name="patientRelationship" type="text" value="" placeholder = "患者与本人关系"/>


      <!-- Unnamed (复选框) -->
  <div id="u345" class="ax_复选框">
            <p id="u346"><span>先天性心脏病</span></p>
        <input id="u345_input" name="geneticHistory" type="checkbox" value="6"/>
      </div>

  <input id="u538_input" name="patientRelationship" type="text" value="" placeholder = "患者与本人关系"/>

      <!-- Unnamed (复选框) -->
  <div id="u347" class="ax_复选框">
            <p id="u348"><span>血友病</span></p>
        <input id="u347_input" name="geneticHistory" type="checkbox" value="7"/>
      </div>

  <input id="u539_input" name="patientRelationship" type="text" value="" placeholder = "患者与本人关系"/>

  <div id="u349" class="ax_复选框">
            <p id="u350"><span>糖尿病</span></p>
        <input id="u349_input" name="geneticHistory" type="checkbox" value="8"/>
      </div>

  <input id="u540_input" name="patientRelationship" type="text" value="" placeholder = "患者与本人关系"/>

      <!-- Unnamed (复选框) -->
  <div id="u351" class="ax_复选框">
            <p id="u352"><span>其他</span></p>
        <input id="u351_input" name="geneticHistory" type="checkbox" value="9"/>
        </div>
        
  <input id="u533_input" name="geneticHistoryRemark" style="display:none" type="text" value="" placeholder = "其他时显示输入框"/>
  <input id="u541_input" name="patientRelationship" style="display:none" type="text" value="" placeholder = "患者与本人关系"/>

          <p id="u277"><span>家族近亲婚配</span><span>：</span></p>
        <select id="u305_input" name="relativesMating" class = "test">
          <option value="0">无</option>
          <option value="1">有（父母）</option>
          <option value="2">有（祖父母）</option>
          <option value="3">有（外祖父母）</option>
          <option value="4">其他</option>
        </select>

        <input id="u353_input" name="relativesMatingRemark" type="text" value=""/>

  </div>
    
    <div id="u38" class="ax_形状" style="background-color:#009DD9;" onclick="CanShu('u41','u38','u40');">
          <p id="u39"><span>体 格 检 查</span></p>
          <p id="u40">展开</p>
  </div>
  
  <div id="u41" class="ax_形状" style="display:none">
          <p id="u42"><span>血压：</span></p>
        <input id="u48_input" name = "bloodLow" type="text" value=""/>

          <p id="u49"><span>/</span></p>
        <input id="u51_input" name = "bloodHi" type="text" value=""/>
          <p id="u44"><span>mmHg</span></p>

          <p id="u72"><span>血型：</span></p>
        <select id="u177_input" name = "bloodType" class = "test">
          <option value="0">A型</option>
          <option value="1">B型</option>
          <option value="2">AB型</option>
          <option value="3">O型</option>
        </select>

          <p id="u140"><span>RH：</span></p>
        <select id="u178_input" name = "yinYang" class = "test">
          <option value="2">未检查</option>
          <option value="0">RH+</option>
          <option value="1">RH-</option>
        </select>

          <p id="u377"><span>特殊体态：</span></p>
        <select id="u379_input" name = "specialPosture" data-label="性别" class = "test">
          <option value="0">无</option>
          <option value="1">有</option>
        </select>

        <input id="u380_input" name = "postureRemark" type="text" value="" placeholder = "有时显示输入框"/>
        
          <p id="u381"><span>特殊面容：</span></p>
        <select id="u383_input" name = "specialFace" data-label="性别" class = "test">
          <option value="0">无</option>
          <option value="1">有</option>
        </select>

        <input id="u384_input" name = "faceRemark" type="text" value="" placeholder = "有时显示输入框"/>

          <p id="u385"><span>精神状态：</span></p>
        <select id="u387_input" name = "mentalState" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u388_input" name = "stateRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u389"><span>智力：</span></p>
        <select id="u391_input" name = "intelligence" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <select id="u392_input" name = "exceptionTypes" class = "test">
          <option value="0">常识</option>
          <option selected value="1">判断</option>
          <option value="2">记忆</option>
          <option value="3">计算</option>
          <option value="4">其他</option>
        </select>

          <p id="u393"><span>皮肤毛发：</span></p>
        <select id="u395_input" name = "skinHair" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u396_input" name = "skinHairNote" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u46"><span>五官：</span></p>
        <select id="u52_input" name = "facialFeatures" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u53_input" name = "facialFeaturesRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u397"><span>甲状腺：</span></p>
        <select id="u399_input" name = "thyroidGland" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u400_input" name = "thyroidGlandRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u401"><span>心率：</span></p>
        <input id="u403_input" name = "heartRate" type="text" value=""/>
          <p id="u404"><span>次/分</span></p>

          <p id="u406"><span>心律：</span></p>
        <select id="u408_input" name = "heartRhythm" class = "test">
          <option selected value="0">齐</option>
          <option value="1">过速</option>
          <option value="2">过缓</option>
          <option value="3">不齐</option>
          <option value="4">其他</option>
        </select>

        <input id="u409_input" name = "heartRhythmRemark" type="text" value="" placeholder = "其他"/>

          <p id="u410"><span>杂音：</span></p>
        <select id="u412_input" name = "noise" data-label="性别" class = "test">
          <option value="0">无</option>
          <option value="1">有</option>
        </select>

        <input id="u413_input" name = "noiseRemark" type="text" value="" placeholder = "有时显示输入框"/>

          <p id="u414"><span>肺：</span></p>
        <select id="u416_input" name = "lung" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u417_input" name = "lungRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u418"><span>肝</span><span>：</span></p>
        <select id="u420_input" name = "liver" data-label="性别" class = "test">
          <option value="0">未及</option>
          <option value="1">可及</option>
        </select>
        <input id="u421_input" name = "liverRemark" type="text" value="" placeholder = "可及时显示输入框"/>

          <p id="u422"><span>四肢脊柱：</span></p>
        <select id="u424_input" name = "limbs" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u425_input" name = "limbsRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u426"><span>其他：</span></p>
        <input id="u428_input" name = "others" type="text" value=""/>

      <div id="u484" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u429"><span>第二性征：</span></p>
          <p id="u431"><span>阴毛：</span></p>
        <select id="u457_input" name = "pubicHair" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">稀少</option>
          <option value="2">无</option>
        </select>

          <p id="u433"><span>乳房：</span></p>
        <select id="u449_input" name = "breast" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u450_input" name = "breastRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u439"><span>外阴：</span></p>
        <select id="u451_input" name = "anusVulva" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u452_input" name = "anusVulvaRemark" type="text" value="" placeholder = "异常时显示输入框"/>

      <div id="u482" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u435"><span>生殖器：</span></p>
          <p id="u437"><span>肛查（常规）：</span></p>
          <p id="u443"><span>分泌物：</span></p>

        <select id="u453_input" name = "secretions" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u454_input" name = "secretionsRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u445"><span>外阴：</span></p>
        <select id="u455_input" name = "vulvaVagina" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u456_input" name = "vulvaVaginaRemark" type="text" value="" placeholder = "异常时显示输入框"/>

      <div id="u483" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u441"><span>子宫、附件：阴道检查（必要时）</span></p>
          <p id="u458"><span>外阴：</span></p>

        <select id="u462_input" name = "vulva" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u463_input" name = "vulvaRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u465"><span>阴道：</span></p>
        <select id="u469_input" name = "vagina" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u470_input" name = "vaginaRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u460"><span>宫颈：</span></p>
        <select id="u447_input" name = "cervical" class = "test">
          <option value="Ⅰ°糜烂">Ⅰ°糜烂</option>
          <option value="Ⅱ°糜烂">Ⅱ°糜烂</option>
          <option value="Ⅲ°糜烂">Ⅲ°糜烂</option>
          <option value="宫颈肥大">宫颈肥大</option>
          <option value="其他">其他</option>
        </select>

        <input id="u464_input" name = "cervicalRemark" type="text" value="" placeholder = "其他时显示输入框"/>

          <p id="u467"><span>子宫：</span></p>
        <select id="u471_input" name = "uterus" data-label="性别" class = "test">
          <option value="2">未检查</option>
          <option value="0">未见异常</option>
          <option value="1">异常</option>
        </select>

        <input id="u472_input" name = "uterusRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u473"><span>附件：</span></p>
        <select id="u475_input" name = "attachment" data-label="性别" class = "test">
          <option value="0">正常</option>
          <option value="1">异常</option>
        </select>

        <input id="u476_input" name = "attachmentRemark" type="text" value="" placeholder = "异常时显示输入框"/>

          <p id="u477"><span>其他：</span></p>
        <input id="u479_input" name = "attachmentOther" type="text" value=""/>

          <p id="u480"><span>是否同意阴道检查：</span></p>
        <select id="u644_input" name = "vaginalExamination" class = "test">
          <option value="0">同意阴道检查</option>
          <option value="1">拒绝阴道检查</option>
        </select>
   
  </div>
  
      <!-- Unnamed (形状) -->
  	  <div id="u54" class="ax_形状" style="background-color:#009DD9;" onclick="CanShu('u57','u54','u56');">
          <p id="u55"><span>实 验 室 及 特 殊 检 查</span></p>
          <p id="u56">展开</p>
      </div>
      
        <div id="u57" class="ax_形状" style="display:none">
          <p id="u68"><span>血常规：</span></p>
          <p id="u58"><span>血红蛋白值：</span></p>
        <input id="u151_input" name = "hemoglobin" type="text" value=""/>
          <p id="u60"><span>g/L</span>
          	<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u60_"></span></span>
          </p>
          

          <p id="u62"><span>白细胞计数值：</span></p>
        <input id="u152_input" name = "whiteCellCount" type="text" value=""/>
          <p id="u142"><span>×10^9/L</span>
          	<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u152_"></span></span>
          </p>

          <p id="u64"><span>血小板计数值：</span></p>
        <input id="u153_input" name = "platelet" type="text" value=""/>
          <p id="u66"><span>×10^9/L</span>
          	<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u153_"></span></span>
          </p>

          <p id="u149"><span>其他：</span></p>
        <input id="u148_input" name = "routineBlood" type="text" value=""/>

      <div id="u247" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u70"><span>尿常规：</span></p>
          <p id="u156" ><span>尿糖：</span></p>
        <input id="u170_input" name = "urineSugar" type="text" value=""/>
          <p id="u164"><span>mmol/L</span></p>

          <p id="u158"><span>尿酮体：</span></p>
        <input id="u171_input" name = "ketoneBody" type="text" value=""/>
          <p id="u166"><span>mmol/L</span></p>

          <p id="u154"><span>尿蛋白：</span></p>
        <input id="u172_input" name = "urineProtein" type="text" value=""/>
          <p id="u162"><span>g/L</span></p>

          <p id="u490"><span>PH：</span></p>
        <input id="u492_input" name = "ph" type="text" value=""/>
        
          <p id="u160"><span>尿潜血：</span></p>
        <input id="u173_input" name = "ery" type="text" value=""/>
          <p id="u168"><span>cells/u</span></p>

          <p id="u485"><span>白细胞：</span></p>
        <input id="u489_input" name = "whiteCell" type="text" value=""/>
          <p id="u487"><span>cells/u</span></p>

          <p id="u175"><span>其他：</span></p>
        <input id="u174_input" name = "routineUrine" type="text" value=""/>

      <div id="u248" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u82"><span>肝功能：</span></p>
          <p id="u179"><span>血清谷丙转氨酶：</span></p>
        <input id="u189_input" name = "serumAlt" type="text" value=""/>
          <p id="u74"><span>U/L</span></p>
          
          <p id="u181"><span>血清谷草转氨酶：</span></p>
        <input id="u190_input" name = "aspertateAmi" type="text" value=""/>
          <p id="u76"><span>U/L</span></p>

          <p id="u183"><span>白蛋白：</span></p>
        <input id="u191_input" name = "albumin" type="text" value=""/>
          <p id="u78"><span>g/L</span>
          	<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u191_"></span></span>
          </p>

          <p id="u185"><span>总胆红素：</span></p>
        <input id="u192_input" name = "totalBilirubin" type="text" value=""/>
          <p id="u80"><span>μ mol/L</span>
          		<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u192_"></span></span>
          </p>

          <p id="u187"><span>结合胆红素：</span></p>
        <input id="u193_input" name = "combiningBilirubin" type="text" value=""/>
          <p id="u245"><span>μ mol/L</span></p>

      <div id="u249" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u84"><span>肾功能：</span></p>
          <p id="u86"><span>血清肌酐：</span></p>
        <input id="u194_input" name = "serumCreatinine" type="text" value=""/>
          <p id="u88"><span>μ mol/L</span></p>

          <p id="u90"><span>血尿素氮：</span></p>
        <input id="u195_input" name = "bloodUreaNitrogen" type="text" value=""/>
          <p id="u92"><span>mmol/L</span></p>

      <div id="u493" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u94"><span>阴道分泌物：</span></p>
      <div id="u96" class="ax_复选框">
            <p id="u97"><span>未见异常</span></p>
        <input id="u96_input" name = "vaginalDischarge" type="checkbox" value="0"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u98" class="ax_复选框">
            <p id="u99"><span>滴虫</span></p>
        <input id="u98_input" name = "vaginalDischarge" type="checkbox" value="1"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u100" class="ax_复选框">
            <p id="u101"><span>假丝酵母菌</span></p>
        <input id="u100_input" name = "vaginalDischarge" type="checkbox" value="2"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u197" class="ax_复选框">
            <p id="u198"><span>其他</span></p>
        <input id="u197_input" name = "vaginalDischarge" type="checkbox" value="3"/>
      </div>

        <input id="u196_input" name = "otherSecretion" style="display:none" type="text" value="" placeholder = "其他时显示输入框"/>

          <p id="u102"><span>阴道清洁度：</span></p>
        <select id="u144_input" name = "cleanliness" class = "test">
          <option value="0">Ⅰ度</option>
          <option value="1 ">Ⅱ度 </option>
          <option value="2">Ⅲ度</option>
          <option value="3"> Ⅳ度</option>
          <option selected value="4">未检查</option>
        </select>

          <p id="u104"><span>乙肝五项：</span></p>

          <p id="u106"><span>乙型肝炎表面抗原：</span></p>
      <div id="u120" class="ax_单选按钮">
            <p id="u121"><span>阴性</span></p>
        <input id="u120_input" type="radio" value="0" name="antigenHepatitis"/>
      </div>
      <div id="u122" class="ax_单选按钮">
            <p id="u123"><span>阳性</span></p>
        <input id="u122_input" type="radio" value="1" name="antigenHepatitis"/>
      </div>

          <p id="u108"><span>乙型肝炎表面抗体：</span></p>
      <div id="u124" class="ax_单选按钮">
            <p id="u125"><span>阴性</span></p>
        <input id="u124_input" type="radio" value="0" name="hepatitisAntibody"/>
      </div>
      <div id="u126" class="ax_单选按钮">
            <p id="u127"><span>阳性</span></p>
        <input id="u126_input" type="radio" value="1" name="hepatitisAntibody"/>
      </div>

          <p id="u114"><span>乙型肝炎核心抗体：</span></p>
      <div id="u132" class="ax_单选按钮">
            <p id="u133"><span>阴性</span></p>
        <input id="u132_input" type="radio" value="0" name="coreAntibody"/>
      </div>
      <div id="u134" class="ax_单选按钮">
            <p id="u135"><span>阳性</span></p>
        <input id="u134_input" type="radio" value="1" name="coreAntibody"/>
      </div>

          <p id="u112"><span>乙型肝炎e抗体：</span></p>
      <div id="u128" class="ax_单选按钮">
            <p id="u129"><span>阴性</span></p>
        <input id="u128_input" type="radio" value="0" name="eantibody"/>
      </div>
      <div id="u130" class="ax_单选按钮">
            <p id="u131"><span>阳性</span></p>
        <input id="u130_input" type="radio" value="1" name="eantibody"/>
      </div>
      
          <p id="u110"><span>乙型肝炎e抗原：</span></p>
      <div id="u136" class="ax_单选按钮">
            <p id="u137"><span>阴性</span></p>
        <input id="u136_input" type="radio" value="0" name="eantigen"/>
      </div>
      <div id="u138" class="ax_单选按钮">
            <p id="u139"><span>阳性</span></p>
        <input id="u138_input" type="radio" value="1" name="eantigen"/>
      </div>

          <p id="u116"><span>梅毒血清学试验：</span></p>
      <div id="u199" class="ax_单选按钮">
            <p id="u200"><span>阴性</span></p>
        <input id="u199_input" type="radio" value="0" name="syphilisSerum"/>
      </div>
      <div id="u201" class="ax_单选按钮">
            <p id="u202"><span>阳性</span></p>
        <input id="u201_input" type="radio" value="1" name="syphilisSerum"/>
      </div>

          <p id="u118"><span>HIV抗体检测：</span></p>
      <div id="u203" class="ax_单选按钮">
            <p id="u204"><span>阴性</span></p>
        <input id="u203_input" type="radio" value="0" name="hivAntibodies"/>
      </div>
      <div id="u205" class="ax_单选按钮">
            <p id="u206"><span>阳性</span></p>
        <input id="u205_input" type="radio" value="1" name="hivAntibodies"/>
      </div>

          <p id="u145"><span>胸透</span><span>：</span></p>
        <select id="u147_input" name = "chest" class = "test">
          <option value="0">未见异常</option>
          <option value="1">异常</option>
          <option selected value="2">未检查</option>
        </select>
        <input id="u534_input" name = "note" type="text" value="" placeholder = "异常时显示输入框"/>
      
      </div>
  
      <!-- Unnamed (形状) -->
  <div id="u207" class="ax_形状" style="background-color:#009DD9;" onclick="CanShu('u210','u207','u209');">
          <p id="u208"><span>检 查 结 果</span></p>
          <p id="u209">展开</p>
      </div>
      
      <div id="u210" class="ax_形状" style="display:none">

          <p id="u211"><span>检查结果：</span></p>
          <input id = "resultId" type = "hidden" name = "resultId" value = ""/>
      <div id="u213" class="ax_单选按钮">
            <p id="u214"><span>未见异常</span></p>
        <input id="u213_input" type="radio" value="0" name="checkResult"/>
      </div>
      <div id="u215" class="ax_单选按钮">
            <p id="u216"><span>异常</span></p>
        <input id="u215_input" type="radio" value="1" name="checkResult"/>
      </div>
        
		<div id="u512" style="background: #EE5F45;cursor:pointer">
			<p id = "u5121"><span>特殊疾病</span></p>
		</div>
         <!--  <p id="u512"><span>指定传染病：</span></p>
        <select id="u514_input" name = "excTerm" class = "test">
          
        </select>
        <input id="u515_input" name = "otherExc" type="text" value="" placeholder = "其他时显示输入框"/>

          <p id="u516"><span>严重遗传病：</span></p>
        <select id="u518_input" name = "excTerm" class = "test">
          
        </select>
        <input id="u519_input" name = "otherExc" type="text" value="" placeholder = "其他时显示输入框"/>

          <p id="u520"><span>精神病：</span></p>
        <select id="u522_input" name = "excTerm" class = "test">
          
        </select>
        <input id="u523_input" name = "otherExc" type="text" value="" placeholder = "其他时显示输入框"/>

          <p id="u524"><span>生殖系统疾病：</span></p>
        <select id="u526_input" name = "excTerm" class = "test">
          
        </select>
        <input id="u527_input" name = "otherExc" type="text" value="" placeholder = "其他时显示输入框"/>

          <p id="u528"><span>内科疾病：</span></p>
        <select id="u530_input" name = "excTerm" class = "test">
          
        </select>
        <input id="u531_input" name = "otherExc" type="text" value="" placeholder = "其他时显示输入框"/> -->
    
          <p id="u495"><span>疾病诊断：</span></p>
        <input id="u494_input" name = "diseaseDiagnosis" type="text" value=""/>

          <p id="u497"><span>医学意见：</span></p>
        <select id="u499_input" name = "medicalAdvice" class = "test">
          <option value="0">未发现医学上不宜结婚的情形</option>
          <option value="1">建议暂缓结婚</option>
          <option value="2">建议不宜生育</option>
          <option value="3">建议不宜结婚</option>
          <option selected value="4">建议采取医学措施，尊重受检者意愿</option>
        </select>

          <p id="u500"><span>婚前卫生咨询：</span></p>
        <textarea id="u505_input" name = "maritalConsultation">${archivesInfoDetail.directiveOpinionTemplatePO.content }</textarea>

          <p id="u502"><span>咨询指导结果：</span></p>
        <select id="u504_input" name = "consultativeResults" class = "test">
          <option value="0">接受指导意见</option>
          <option selected value="1">不接受指导意见，知情后选择结婚，后果自己承担</option>
        </select>
        
       </div>
      

  <div id="u217" class="ax_形状" style="background-color:#009DD9;" onclick="CanShu('u220','u217','u219');">
          <p id="u218"><span>转 诊</span></p>
          <p id="u219">展开</p>
      </div>

 <div id="u220" class="ax_形状" style="display:none">

          <p id="u221"><span>转诊：</span></p>
      <div id="u223" class="ax_单选按钮">
            <p id="u224"><span> 无</span></p>
        <input id="u223_input" type="radio" value="0" name="referral"/>
      </div>
      <div id="u225" class="ax_单选按钮">
            <p id="u226"><span> 有</span></p>
        <input id="u225_input" type="radio" value="1" name="referral"/>
      </div>

          <p id="u227"><span>原因：</span></p>
        <input id="u229_input" name = "reason" type="text" value=""/>

          <p id="u230"><span>转诊机构：</span></p>
        <select id="u232_input" name="mechanism" class = "test">
        	
        </select>
        
        
          <p id="u233"><span>转诊日期：</span></p>
          <input id = "referralDate" type = "hidden" value = ""/>
        <input type="text" id="u235_input" name="referralDate"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
      
        
          <p id="u236"><span>预约复诊日期：</span></p>
        <input type="text" id="u238_input" name="appointmentDate" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>

          <p id="u506"><span>预约医生：</span></p>
        <select id="u508_input" name = "doctorAppointments" class = "test">
        </select>

          <p id="u509"><span>出具《婚前医学检查证明》日期：</span></p>
        <input type="text" id="u511_input" name="issuedByDate" style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
        </div>
        </form>
        <div id="finishForm" class="easyui-dialog" title="角色" closed="true">
        	<!-- Unnamed (形状) -->
	      <div id="u00" class="ax_形状">
	        <div id="u1" class="text">
	          <p><span>&nbsp;</span></p>
	        </div>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <!-- <div id="u02" class="ax_形状" style="background-color:#F30">
	          <p id="u03"><span>提&nbsp; &nbsp; 示</span></p>
	      </div> -->
	
	      <!-- Unnamed (形状) -->
      		<div id="u04" class="ax_形状" style="background-color:#06F;cursor:pointer">
	          <p id="u05"><span id="no">否</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u06" class="ax_形状" style="background-color:#F00;cursor:pointer">
	          <p id="u07"><span id="yes">是</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u08" class="ax_文本段落">
	          <p id="u09"><span>婚检完成！是否生成检查报告？</span>
	          	<input id = "archId" name = "archId" type = "hidden" value="${archivesInfoDetail.archivesInfo.id}"/>
	          </p>
      	  </div>
        </div>
        
        <div id="illAtv" style="overflow:auto" class="easyui-dialog" title="角色" closed="true">
      		<form id="special" action="" method="post">
      		<div id="guding">
		        
		    </div>
		      
		    <div id="renshen">
			    	
			</div>
      
			<div id="benci">
        		
	        </div>
	       
	        <div id="head">
    	
		        <div id="su252" class="ax_形状" style="background-color:#999999">
		          <p id="su253" style="cursor:pointer"><span>指定传染病</span></p>
		      	</div>
		        
		        <div id="su276" class="ax_形状" style="background-color:#999999">
		          <p id="su277" style="cursor:pointer"><span>严重遗传病</span></p>
		      	</div>
		        
		        <div id="su278" class="ax_形状" style="background-color:#999999">
		          <p id="su279" style="cursor:pointer"><span>精神病</span></p>
		      	</div>
		        
		        <div id="su280" class="ax_形状" style="background-color:#999999">
		          <p id="su281" style="cursor:pointer"><span>生殖系统疾病</span></p>
		      	</div>
		      	
		      	<div id="su2801" class="ax_形状" style="background-color:#999999">
		          <p id="su2811" style="cursor:pointer"><span>内科疾病</span></p>
		      	</div>
		        
		        <div id="su254" class="ax_形状" style="background-color:#009DD9">
		          <p id="su255" style="cursor:pointer"><span>保存</span></p>
		      	</div>
		        
		        <div id="su256" class="ax_形状" style="background-color:#56BB4D">
		          <p id="su257" style="cursor:pointer"><span>取消</span></p>
		      	</div>
		    
		    </div>
		    
		    <div id="xian">
		    
		    	<div id="su2" class="ax_垂直线">
		        	<hr id="su2_line" style="weight:1px;border:none;border-left:1px solid #999999;"/>
		      	</div>
		        
		        <div id="su4" class="ax_垂直线">
		          <hr id="su4_line" style="weight:1px;border:none;border-left:1px solid #999999;"/>
		      	</div>
		        
		        <div id="su3" class="ax_垂直线">
		        	<hr id="su3_line" style="weight:1px;border:none;border-left:1px solid #999999;"/>
		      	</div>
		    	
		    </div>
		    
		    <div id="shehui">
		    
		    	
		    </div>
		    
		    <div id="neike">
		    
		    </div>
	       </form>
      </div>
  </body>
</html>
