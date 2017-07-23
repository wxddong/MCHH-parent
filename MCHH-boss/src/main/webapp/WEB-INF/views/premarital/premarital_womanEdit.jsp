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
		 		var year = new Date().getFullYear();
		 		var month = new Date().getMonth()+1;
		 		var date = new Date().getDate();
		 		if(month<10) month="0"+month;
		 		if(date<10) date="0"+date; 
		 		/* document.getElementById("u511_input").value=(year)+"-"+(month)+"-"+(date);
		 		document.getElementById("u235_input").value=(year)+"-"+(month)+"-"+(date);
		 		document.getElementById("u238_input").value=(year)+"-"+(month)+"-"+(date);
		 		document.getElementById("u354_input").value=(year)+"-"+(month)+"-"+(date); */
		 		
		 		
				//下拉框未选择时默认为空
		 		var a=$(".test");
		 		
				for(var i = 0;i< a.length;i++){
					
					a[i].selectedIndex = -1;
				}
		 		
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
			    $("#u999_input").hide();
		 		$("input[name^='geneticHistory']").click(function(){
			        
			        if($("#u351_input").attr("checked")){
			            $("#u533_input").css({"display":"block"});
			            //document.getElementById('u999_input').style.left='593px';
			            $("#u999_input").css({"display":"block"});
			        }else{
			            $("#u533_input").css({"display":"none"});
			            //document.getElementById('u999_input').style.left='438px';
			            $("#u999_input").css({"display":"none"});
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
		 		
		 		//特殊疾病弹出框
		 		var excTerm1Url = "${ctx}/premaritalexainfo/excTerm"
		 		var	specialUrl = "${ctx}/specialdiseaseinfo/getById"
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
	    			  var resultId = $("#resultId").val();
	 			 
	 			  showDialog_("提示","illAtv","moremiddle14",false);
	 			  
	 			  //加载所有特殊疾病项
		 			  $.ajax({
	    				  url:specialUrl,
	    				  type:"GET",
	    				  data:{resultId:resultId},
	    				  success:function(data){
	    					  var a = 0;
	    					  var a1 = 0;
	    					  var b = 0;
	    					  var c = 0;
	    					  var d = 0;
	    					  var d1 = 0;
	    					  var e = 0;
	    					  var f = 0;
	    					  var g = 0;
	    					  var g1 = 0;
	    					  var h = 0;
	    					  var i = 0;
	    					  var j = 0;
	    					  var j1 = 0;
	    					  var k = 0;
	    					  var l = 0;
	    					  var m = 0;
	    					  var m1 = 0;
	    					  var n = 0;
	    					  var o = 0;
	    					  var gu1 = "";
	    					  var gu2 = "";
	    					  var gu3 = "";
	    					  var ren1 = "";
	    					  var ren2 = "";
	    					  var ren3 = "";
	    					  var ben1 = "";
	    					  var ben2 = "";
	    					  var ben3 = "";
	    					  var she1 = "";
	    					  var she2 = "";
	    					  var she3 = "";
	    					  var nei1 = "";
	    					  var nei2 = "";
	    					  var nei3 = "";
	    					  //指定传染病
	    					  for(var i = 0;i<data.list.length;i++){
	    						  if (data.list[i].type == "0") {
		    						  if (a1 < 7) {
		    							  if (data.list[i].selected == "1") {
		    								  gu1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+a*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='infectiousDis'/>"
				     							+"</div>";
										  }else{
				    						  gu1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+a*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='infectiousDis'/>"
				     							+"</div>";
										  }
		    							  a += 1;
			     							
									  }
		    						  if (6 < a1 && a1 < 14) {
		    							  if (data.list[i].selected == "1") {
		    								  gu2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+b*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='infectiousDis'/>"
				     							+"</div>";
										  }else{
				    						  gu2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+b*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='infectiousDis'/>"
				     							+"</div>";
										  }
		   								
			     							b += 1;
									  }
		    						  if (13 < a1 && a1 < 21) {
		    							  if (data.list[i].selected == "1") {
		    								  gu3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+c*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='infectiousDis'/>"
				     							+"</div>";
										  }else{
				    						  gu3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+c*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='infectiousDis'/>"
				     							+"</div>";
										  }
		   								
			     							c += 1;
									  }
		    						  a1 += 1;
								  }
	    						  if (data.list[i].type == "1") {
	    							  if (d1 < 7) {
		    							  if (data.list[i].selected == "1") {
		    								  ren1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+d*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='geneticDis'/>"
				     							+"</div>";
										  }else{
			    							  ren1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+d*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='geneticDis'/>"
				     							+"</div>";
											  
										  }
		   								
			     							d += 1;
									  }
		    						  if (6 < d1 && d1 < 14) {
		    							  if (data.list[i].selected == "1") {
		    								  ren2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+e*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='geneticDis'/>"
				     							+"</div>";	
										  }else{
			    							  ren2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+e*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='geneticDis'/>"
				     							+"</div>";
											  
										  }
		   								
			     							e += 1;
									  }
		    						  if (13 < d1 && d1 < 21) {
		    							  if (data.list[i].selected == "1") {
		    								  ren3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+f*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='geneticDis'/>"
				     							+"</div>";
										  }else{
				    						  ren3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+f*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='geneticDis'/>"
				     							+"</div>";
											  
										  }
		   								
			     							f += 1;
									  }
		    						  d1 += 1;
								  }
	    						  if (data.list[i].type == "2") {
	    							  if (g1 < 7) {
		    							  if (data.list[i].selected == "1") {
		    								  ben1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+g*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='mentalDis'/>"
				     							+"</div>";
										  }else{
											  ben1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+g*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='mentalDis'/>"
				     							+"</div>";
										  }
		   								
			     							g += 1;
									  }
		    						  if (6 < g1 && g1 < 14) {
		    							  if (data.list[i].selected == "1") {
		    								  ben2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+h*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='mentalDis'/>"
				     							+"</div>";
										  }else{
											  ben2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+h*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='mentalDis'/>"
				     							+"</div>";
										  }
		   								
			     							h += 1;
									  }
		    						  if (13 < g1 && g1 < 21) {
		    							  if (data.list[i].selected == "1") {
		    								  ben3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+i*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='mentalDis'/>"
				     							+"</div>";
										  }else{
											  ben3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+i*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='mentalDis'/>"
				     							+"</div>";
										  }
		   								
			     							i += 1;
									  }	
		    						  g1 += 1;
								  }
	    						  if (data.list[i].type == "4") {
	    							  if (j1 < 7) {
		    							  if (data.list[i].selected == "1") {
		    								  she1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+j*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='reproductiveDis'/>"
				     							+"</div>";
										  }else{
											  she1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+j*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='reproductiveDis'/>"
				     							+"</div>";
										  }
		   								
			     							j += 1;
									  }
		    						  if (6 < j1 && j1 < 14) {
		    							  if (data.list[i].selected == "1") {
		    								  she2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+k*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='reproductiveDis'/>"
				     							+"</div>";
										  }else{
											  she2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+k*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='reproductiveDis'/>"
				     							+"</div>";
										  }
		   								
			     							k += 1;
									  }
		    						  if (13 < j1 && j1 < 21) {
		    							  if (data.list[i].selected == "1") {
		    								  she3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+l*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='reproductiveDis'/>"
				     							+"</div>";
										  }else{
											  she3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+l*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='reproductiveDis'/>"
				     							+"</div>";
										  }
		   								
			     							l += 1;
									  }	
		    						  j1 += 1;
								  }
	    						  if (data.list[i].type == "5") {
	    							  if (m1 < 7) {
		    							  if (data.list[i].selected == "1") {
		    								  nei1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+m*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='medicalDis'/>"
				     							+"</div>";
										  }else{
											  nei1 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:30px;top:"+(71+m*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='medicalDis'/>"
				     							+"</div>";
										  }
		   								
			     							m += 1;
									  }
		    						  if (6 < m1 && m1 < 14) {
		    							  if (data.list[i].selected == "1") {
		    								  nei2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+n*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='medicalDis'/>"
				     							+"</div>";
										  }else{
											  nei2 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:328px;top:"+(71+n*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='medicalDis'/>"
				     							+"</div>";
										  }
		   								
			     							n += 1;
									  }
		    						  if (13 < m1 && m1 < 21) {
		    							  if (data.list[i].selected == "1") {
		    								  nei3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+o*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='medicalDis'/>"
				     							+"</div>";
										  }else{
											  nei3 += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:626px;top:"+(71+o*50)+"px;vertical-align: baseline;'><label>"
				     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
				     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='medicalDis'/>"
				     							+"</div>";
										  }
		   								
			     							o += 1;
									  }	
		    						  m1 += 1;
								  }
	    					  }
	    					  $("#guding").html(gu1+gu2+gu3);
	    					  $("#renshen").html(ren1+ren2+ren3);
	    					  $("#benci").html(ben1+ben2+ben3);
	    					  $("#shehui").html(she1+she2+she3);
	    					  $("#neike").html(nei1+nei2+nei3);
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
	    		});
	    		
	    		//特殊疾病弹出框---取消
	    		$("#su256").click(function(){
	     			$("#illAtv").window("close");
	     		});
	    		
	    		//特殊疾病保存修改
	    		updateSpecialUrl = "${ctx}/specialdiseaseinfo/updateSpecial"
	    		
	    		//特殊疾病项保存修改
	    		$("#su254").click(function(){
	     			$.ajax({
	 	 				type:'POST',
	 	 	 			url:updateSpecialUrl,
	 	 	 			data:$('#special').serialize(),
	 	 	 			success:function(data){
	 	 	 				$("#u494_input").val(data.ill);
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
			            
			        }
			    });
		 		
		 		//血缘关系
		 		$("#u262_input").change(function(){
		 		  var kinship = $("#u262_input").val();
		 		  if (kinship == "3") {
					  $("#u355_input").show(); 
				  }else if(kinship == "4"){
		 			 $("#u355_input").show();
				  }else{
		 			 $("#u355_input").hide();
		 			
				  }
		 		});
		 		
		 		var kinship = $("#kinship").val();
		 		
		 		  if (kinship == "3") {
					  $("#u355_input").show(); 
				  }else if(kinship == "4"){
		 			 $("#u355_input").show();
				  }else{
		 			 $("#u355_input").hide();
		 			
				  }
		 		
		 		//手术史
		 		$("#u279_input").change(function(){
		 		  var surgeryHistory = $("#u279_input").val();
		 		  if (surgeryHistory == "1") {
					  $("#u356_input").show(); 
				  }else{
		 			 $("#u356_input").hide();
		 			
				  }
		 		});
		 		
		 		var surgeryHistory = $("#surgeryHistory").val();
		 		  if (surgeryHistory == "1") {
					  $("#u356_input").show(); 
				  }else{
		 			 $("#u356_input").hide();
		 			
				  }
		 		
		 		//现病史
		 		$("#u283_input").change(function(){
		 		  var hpi = $("#u283_input").val();
		 		  if (hpi == "0") {
		 			 $("#u357_input").hide();
		 			
				  }else{
					  $("#u357_input").show(); 
				  }
		 		});
		 		
		 		var hpi = $("#hpi").val();
		 		
		 		  if (hpi == "0") {
		 			 $("#u357_input").hide();
				  }else{
					  $("#u357_input").show(); 
				  }
		 		  if (hpi == "" || hpi == null) {
		 			 $("#u357_input").hide();
				  }
		 		
		 		//特殊体态
		 		$("#u379_input").change(function(){
		 		  var specialPosture = $("#u379_input").val();
		 		  if (specialPosture == "0") {
		 			 $("#u380_input").hide();
		 			
				  }else{
					  $("#u380_input").show(); 
				  }
		 		});
		 		
		 		var specialPosture = $("#u379_input").val();
		 		  if (specialPosture == "0") {
		 			 $("#u380_input").hide();
				  }else{
					  $("#u380_input").show(); 
				  }
		 		  if (specialPosture == "" || specialPosture == null) {
		 			 $("#u380_input").hide();
				  }
		 		  
		 		//特殊面容
		 		$("#u383_input").change(function(){
		 		  var specialFace = $("#u383_input").val();
		 		  if (specialFace == "0") {
		 			 $("#u384_input").hide();
		 			
				  }else{
					  $("#u384_input").show(); 
				  }
		 		});
		 		
		 		var specialFace = $("#u383_input").val();
		 		  if (specialFace == "0") {
		 			 $("#u384_input").hide();
		 			
				  }else{
					  $("#u384_input").show(); 
				  }
		 		  if (specialFace == "" || specialFace == null) {
		 			 $("#u384_input").hide();
				  }
		 		//精神状态
		 		$("#u387_input").change(function(){
		 		  var mentalState = $("#u387_input").val();
		 		  if (mentalState == "0") {
		 			 $("#u388_input").hide();
		 			
				  }else{
					  $("#u388_input").show(); 
				  }
		 		});
		 		
		 		var mentalState = $("#u387_input").val();
		 		  if (mentalState == "0") {
		 			 $("#u388_input").hide();
		 			
				  }else{
					  $("#u388_input").show(); 
				  }
		 		 if (mentalState == "" || mentalState == null) {
		 			 $("#u388_input").hide();
				  }
		 		  
		 		//皮肤毛发
		 		$("#u395_input").change(function(){
		 		  var skinHair = $("#u395_input").val();
		 		  if (skinHair == "0") {
		 			 $("#u396_input").hide();
		 			
				  }else{
					  $("#u396_input").show(); 
				  }
		 		});
		 		
		 		var skinHair = $("#u395_input").val();
		 		  if (skinHair == "0") {
		 			 $("#u396_input").hide();
		 			
				  }else{
					  $("#u396_input").show(); 
				  }
		 		 if (skinHair == "" || skinHair == null) {
		 			 $("#u396_input").hide();
				  }
		 		  
		 		//五官
		 		$("#u52_input").change(function(){
		 		  var facialFeatures = $("#u52_input").val();
		 		  if (facialFeatures == "0") {
		 			 $("#u53_input").hide();
		 			
				  }else{
					  $("#u53_input").show(); 
				  }
		 		});
		 		
		 		var facialFeatures = $("#u52_input").val();
		 		  if (facialFeatures == "0") {
		 			 $("#u53_input").hide();
		 			
				  }else{
					  $("#u53_input").show(); 
				  }
		 		 if (facialFeatures == "" || facialFeatures == null) {
		 			 $("#u53_input").hide();
				  }
		 		  
		 		//甲状腺
		 		$("#u399_input").change(function(){
		 		  var thyroidGland = $("#u399_input").val();
		 		  if (thyroidGland == "0") {
		 			 $("#u400_input").hide();
		 			
				  }else{
					  $("#u400_input").show(); 
				  }
		 		});
		 		
		 		var thyroidGland = $("#u399_input").val();
		 		  if (thyroidGland == "0") {
		 			 $("#u400_input").hide();
				  }else{
					  $("#u400_input").show(); 
				  }
		 		 if (thyroidGland == "" || thyroidGland == null) {
		 			 $("#u400_input").hide();
				  }
		 		
		 		//足月
		 		$("#u298_input").change(function(){
		 		  var thyroidGland = $("#u298_input").val();
		 		  if (thyroidGland == "7") {
					  $("#u373_input").show(); 
				  }else{
		 			 $("#u373_input").hide();
		 			
				  }
		 		});
		 		
		 		var thyroidGland = $("#u298_input").val();
		 		  if (thyroidGland == "7") {
					  $("#u373_input").show(); 
				  }else{
		 			 $("#u373_input").hide();
				  }
		 		 if (thyroidGland == "" || thyroidGland == null) {
		 			 $("#u373_input").hide();
				  }
		 		
		 		//杂音
		 		$("#u412_input").change(function(){
		 		  var noise = $("#u412_input").val();
		 		  if (noise == "0") {
		 			 $("#u413_input").hide();
		 			
				  }else{
					  $("#u413_input").show(); 
				  }
		 		});
		 		
		 		var noise = $("#u412_input").val();
		 		  if (noise == "0") {
		 			 $("#u413_input").hide();
		 			
				  }else{
					  $("#u413_input").show(); 
				  }
		 		 if (noise == "" || noise == null) {
		 			 $("#u413_input").hide();
				  }
		 		
		 		//肺
		 		$("#u416_input").change(function(){
		 		  var lung = $("#u416_input").val();
		 		  if (lung == "0") {
		 			 $("#u417_input").hide();
		 			
				  }else{
					  $("#u417_input").show(); 
				  }
		 		});
		 		
		 		var lung = $("#u416_input").val();
		 		  if (lung == "0") {
		 			 $("#u417_input").hide();
		 			
				  }else{
					  $("#u417_input").show(); 
				  }
		 		 if (lung == "" || lung == null) {
		 			 $("#u417_input").hide();
				  }
		 		
		 		//肝
		 		$("#u420_input").change(function(){
		 		  var liver = $("#u420_input").val();
		 		  if (liver == "0") {
		 			 $("#u421_input").hide();
		 			
				  }else{
					  $("#u421_input").show(); 
				  }
		 		});
		 		
		 		var liver = $("#u420_input").val();
		 		  if (liver == "0") {
		 			 $("#u421_input").hide();
		 			
				  }else{
					  $("#u421_input").show(); 
				  }
		 		 if (liver == "" || liver == null) {
		 			 $("#u421_input").hide();
				  }
		 		
		 		//四肢脊柱
		 		$("#u424_input").change(function(){
		 		  var limbs = $("#u424_input").val();
		 		  if (limbs == "0") {
		 			 $("#u425_input").hide();
		 			
				  }else{
					  $("#u425_input").show(); 
				  }
		 		});
		 		
		 		var limbs = $("#u424_input").val();
		 		  if (limbs == "0") {
		 			 $("#u425_input").hide();
		 			
				  }else{
					  $("#u425_input").show(); 
				  }
		 		 if (limbs == "" || limbs == null) {
		 			 $("#u425_input").hide();
				  }
		 		
		 		//乳房
		 		$("#u449_input").change(function(){
		 		  var breast = $("#u449_input").val();
		 		  if (breast == "0") {
		 			 $("#u450_input").hide();
		 			
				  }else{
					  $("#u450_input").show(); 
				  }
		 		});
		 		
		 		var breast = $("#u449_input").val();
		 		  if (breast == "0") {
		 			 $("#u450_input").hide();
		 			
				  }else{
					  $("#u450_input").show(); 
				  }
		 		 if (breast == "" || breast == null) {
		 			 $("#u450_input").hide();
				  }
		 		
		 		//外阴
		 		$("#u451_input").change(function(){
		 		  var anusVulva = $("#u451_input").val();
		 		  if (anusVulva == "0") {
		 			 $("#u452_input").hide();
		 			
				  }else{
					  $("#u452_input").show(); 
				  }
		 		});
		 		
		 		var anusVulva = $("#u451_input").val();
		 		  if (anusVulva == "0") {
		 			 $("#u452_input").hide();
		 			
				  }else{
					  $("#u452_input").show(); 
				  }
		 		 if (anusVulva == "" || anusVulva == null) {
		 			 $("#u452_input").hide();
				  }
		 		
		 		//分泌物
		 		$("#u453_input").change(function(){
		 		  var secretions = $("#u453_input").val();
		 		  if (secretions == "0") {
		 			 $("#u454_input").hide();
		 			
				  }else{
					  $("#u454_input").show(); 
				  }
		 		});
		 		
		 		 var secretions = $("#u453_input").val();
		 		  if (secretions == "0") {
		 			 $("#u454_input").hide();
		 			
				  }else{
					  $("#u454_input").show(); 
				  }
		 		 if (secretions == "" || secretions == null) {
		 			 $("#u454_input").hide();
				  }
		 		
		 		//外阴
		 		$("#u455_input").change(function(){
		 		  var vulvaVagina = $("#u455_input").val();
		 		  if (vulvaVagina == "0") {
		 			 $("#u456_input").hide();
		 			
				  }else{
					  $("#u456_input").show(); 
				  }
		 		});
		 		
		 		var vulvaVagina = $("#u455_input").val();
		 		  if (vulvaVagina == "0") {
		 			 $("#u456_input").hide();
		 			
				  }else{
					  $("#u456_input").show(); 
				  }
		 		 if (vulvaVagina == "" || vulvaVagina == null) {
		 			 $("#u456_input").hide();
				  }
		 		
		 		//外阴
		 		$("#u462_input").change(function(){
		 		  var vulva = $("#u462_input").val();
		 		  if (vulva == "0") {
		 			 $("#u463_input").hide();
		 			
				  }else{
					  $("#u463_input").show(); 
				  }
		 		});
		 		
		 		var vulva = $("#u462_input").val();
		 		  if (vulva == "0") {
		 			 $("#u463_input").hide();
		 			
				  }else{
					  $("#u463_input").show(); 
				  }
		 		 if (vulva == "" || vulva == null) {
		 			 $("#u463_input").hide();
				  }
		 		
		 		//阴道
		 		$("#u469_input").change(function(){
		 		  var vagina = $("#u469_input").val();
		 		  if (vagina == "0") {
		 			 $("#u470_input").hide();
		 			
				  }else{
					  $("#u470_input").show(); 
				  }
		 		});
		 		
		 		var vagina = $("#u469_input").val();
		 		  if (vagina == "0") {
		 			 $("#u470_input").hide();
		 			
				  }else{
					  $("#u470_input").show(); 
				  }
		 		 if (vagina == "" || vagina == null) {
		 			 $("#u470_input").hide();
				  }
		 		
		 		//宫颈
		 		$("#u447_input").change(function(){
		 		  var vagina = $("#u447_input").val();
		 		  if (vagina == "其他") {
					  $("#u464_input").show(); 
				  }else{
		 			 $("#u464_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u447_input").val();
		 		  if (vagina == "其他") {
					  $("#u464_input").show(); 
				  }else{
		 			 $("#u464_input").hide();
		 			
				  }
		 		 if (vagina == "" || vagina == null) {
		 			 $("#u464_input").hide();
				  }
		 		
		 		//流产
		 		$("#u371_input").change(function(){
		 		  var vagina = $("#u371_input").val();
		 		  if (vagina == "7") {
					  $("#u375_input").show(); 
				  }else{
		 			 $("#u375_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u371_input").val();
		 		  if (vagina == "7") {
					  $("#u375_input").show(); 
				  }else{
		 			 $("#u375_input").hide();
		 			
				  }
		 		 if (vagina == "" || vagina == null) {
		 			 $("#u375_input").hide();
				  }
		 		
		 		//子宫
		 		$("#u471_input").change(function(){
		 		  var vagina = $("#u471_input").val();
		 		  if (vagina == "1") {
					  $("#u472_input").show(); 
				  }else{
		 			  $("#u472_input").hide();
				  }
		 		});
		 		
		 		var vagina = $("#u471_input").val();
		 		  if (vagina == "1") {
		 			
					  $("#u472_input").show(); 
				  }else{
		 			  $("#u472_input").hide();
				  }
		 		 if (vagina == "" || vagina == null) {
		 			 $("#u472_input").hide();
				  }
		 		
		 		//附件
		 		$("#u475_input").change(function(){
		 		  var vagina = $("#u475_input").val();
		 		  if (vagina == "0") {
		 			 $("#u476_input").hide();
		 			
				  }else{
					  $("#u476_input").show(); 
				  }
		 		});
		 		
		 		var vagina = $("#u475_input").val();
		 		  if (vagina == "0") {
		 			 $("#u476_input").hide();
		 			
				  }else{
					  $("#u476_input").show(); 
				  }
		 		 if (vagina == "" || vagina == null) {
		 			 $("#u476_input").hide();
				  }
		 		
		 		//胸透
		 		$("#u147_input").change(function(){
		 		  var vagina = $("#u147_input").val();
		 		  if (vagina == "1") {
					  $("#u534_input").show(); 
				  }else{
		 			 $("#u534_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u147_input").val();
		 		  if (vagina == "1") {
					  $("#u534_input").show(); 
				  }else{
		 			 $("#u534_input").hide();
		 			
				  }
		 		 if (vagina == "" || vagina == null) {
		 			 $("#u534_input").hide();
				  }
		 		
		 		//指定传染病
		 		$("#u514_input").change(function(){
		 		  var vagina = $("#u514_input").val();
		 		  if (vagina == "6") {
					  $("#u515_input").show(); 
				  }else{
		 			 $("#u515_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u514_input").val();
		 		  if (vagina == "6") {
					  $("#u515_input").show(); 
				  }else{
		 			 $("#u515_input").hide();
		 			
				  }
		 		 if (vulva == "" || vulva == null) {
		 			 $("#u463_input").hide();
				  }
		 		
		 		//严重遗传病
		 		$("#u518_input").change(function(){
		 		  var vagina = $("#u518_input").val();
		 		  
		 		  if (vagina == "16") {
		 			 
					  $("#u519_input").show(); 
				  }else{
		 			 $("#u519_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u518_input").val();
		 		  
		 		  if (vagina == "16") {
		 			 
					  $("#u519_input").show(); 
				  }else{
		 			 $("#u519_input").hide();
		 			
				  }
		 		 if (vulva == "" || vulva == null) {
		 			 $("#u463_input").hide();
				  }
		 		  
		 		//智力
		 		var vagina = $("#u391_input").val();
		 		  
		 		  if (vagina == "1") {
		 			 
					  $("#u392_input").show(); 
				  }else{
		 			 $("#u392_input").hide();
		 			
				  }
		 		
		 		 $("#u391_input").change(function(){
			 		  var vagina = $("#u391_input").val();
			 		  
			 		  if (vagina == "1") {
			 			 
						  $("#u392_input").show(); 
					  }else{
			 			 $("#u392_input").hide();
			 			
					  }
			 	});
		 		
		 		//精神病
		 		$("#u522_input").change(function(){
		 		  var vagina = $("#u522_input").val();
		 		  if (vagina == "25") {
					  $("#u523_input").show(); 
				  }else{
		 			 $("#u523_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u522_input").val();
		 		  if (vagina == "25") {
					  $("#u523_input").show(); 
				  }else{
		 			 $("#u523_input").hide();
		 			
				  }
		 		
		 		//生殖系统疾病
		 		$("#u526_input").change(function(){
		 		  var vagina = $("#u526_input").val();
		 		  if (vagina == "38") {
					  $("#u527_input").show(); 
				  }else{
		 			 $("#u527_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u526_input").val();
		 		  if (vagina == "38") {
					  $("#u527_input").show(); 
				  }else{
		 			 $("#u527_input").hide();
		 			
				  }
		 		
		 		//内科疾病
		 		$("#u530_input").change(function(){
		 		  var vagina = $("#u530_input").val();
		 		  if (vagina == "59") {
					  $("#u531_input").show(); 
				  }else{
		 			 $("#u531_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u530_input").val();
		 		  if (vagina == "59") {
					  $("#u531_input").show(); 
				  }else{
		 			 $("#u531_input").hide();
		 			
				  }
		 		
		 		//家族近亲婚配
		 		$("#u305_input").change(function(){
		 		  var vagina = $("#u305_input").val();
		 		  if (vagina == "4") {
					  $("#u353_input").show(); 
				  }else{
		 			 $("#u353_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u305_input").val();
		 		  if (vagina == "4") {
					  $("#u353_input").show(); 
				  }else{
		 			 $("#u353_input").hide();
				  }
		 		  
		 		
		 		//早产
		 		$("#u370_input").change(function(){
		 		  var vagina = $("#u370_input").val();
		 		  if (vagina == "7") {
					  $("#u374_input").show(); 
				  }else{
		 			 $("#u374_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u370_input").val();
		 		  if (vagina == "7") {
					  $("#u374_input").show(); 
				  }else{
		 			 $("#u374_input").hide();
				  }
		 		 
		 		
		 		//心律
		 		$("#u408_input").change(function(){
		 		  var vagina = $("#u408_input").val();
		 		  if (vagina == "4") {
					  $("#u409_input").show(); 
				  }else{
		 			 $("#u409_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u408_input").val();
		 		  if (vagina == "4") {
					  $("#u409_input").show(); 
				  }else{
		 			 $("#u409_input").hide();
		 			
				  }
		 		
		 		//子女
		 		$("#u372_input").change(function(){
		 		  var vagina = $("#u372_input").val();
		 		  if (vagina == "7") {
					  $("#u376_input").show(); 
				  }else{
		 			 $("#u376_input").hide();
		 			
				  }
		 		});
		 		
		 		var vagina = $("#u372_input").val();
		 		  if (vagina == "7") {
					  $("#u376_input").show(); 
				  }else{
		 			 $("#u376_input").hide();
		 			
				  }
		 		
		 		//既往婚育史
		 		//$("#u295_input").hide();
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
					  $("#u296").hide();
				 	  $("#u299").hide();
				 	  $("#u302").hide();
				 	  $("#u303").hide();
		 			
				  }
		 		});
		 		//既往婚育史
		 		
		 		var marr = $("#marr").val();
		 		if (marr == "0") {
		 			
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
				}else if (marr == "1") {
					
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
				}
		 		
		 		//转诊
		 		$("input[name^='referral']").click(function(){
			        
			        if($("#u223_input").attr("checked")){
			        	
			            $("#u229_input")[0].readOnly=true;
				 		//document.getElementById("u235_input").value="";
				 		document.getElementById('u232_input').disabled=true;
				 		document.getElementById('u235_input').disabled=true;
				 		//$("#u232_input")[0].selectedIndex = -1;
				 		//$("#u508_input")[0].selectedIndex = -1;
				 		//$("#u229_input").val("");
			        }
			        if($("#u225_input").attr("checked")){
			        	
			            $("#u229_input")[0].readOnly=false;
			            /* document.getElementById("u511_input").value=(year)+"-"+(month)+"-"+(date);
				 		document.getElementById("u235_input").value=(year)+"-"+(month)+"-"+(date);
				 		document.getElementById("u238_input").value=(year)+"-"+(month)+"-"+(date); */
				 		document.getElementById('u232_input').disabled=false;
				 		document.getElementById('u235_input').disabled=false;
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
		 		if($("#u197_input").attr("checked")){
		        	$("#u196_input").show();
		        }else{
		        	$("#u196_input").hide();
		        }
		 		
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
			        	$("#u533_input").hide();
			        	$("#u541_input").hide();
			        	$("#u533_input").val("");
			        	$("#u541_input").val("");
			        }
			    });
		 		
		 		var checkResult = $("#checkResult").val();
		 		
		 		if (checkResult == "1") {
		 			$("#u512").show();
				}else{
					$("#u512").hide();
				}
		 		
		 		//当检查结果选中异常时，显示特殊疾病按钮
		 		$("input[name^='checkResult']").click(function(){
		 			if($("#u215_input").attr("checked")){
						$("#u512").show();
			        }
					if($("#u213_input").attr("checked")){
						$("#u512").hide();
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
				
		 		var b = $.trim($("#u151_input").val());
				/* if(!tag.test(b)){
					alert("只能输入数字或小数!");
				} */
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
				
		 		var c = $.trim($("#u152_input").val());
				
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
				
				var d = $.trim($("#u153_input").val());
				
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
				
				var d1 = $.trim($("#u191_input").val());
				
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
				
				var d2 = $.trim($("#u192_input").val());
				
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
				
				//转诊
				var referral = $("input[name='referral']:checked").val();
				if (referral == "0") {
					
					$("#u229_input")[0].readOnly=true;
			 		document.getElementById('u232_input').disabled=true;
			 		document.getElementById('u235_input').disabled=true;
				}
				
				
		 		  var noPresentationWomanUrl = "${ctx}/premaritalexainfo/noPresentationWoman"
		 		  //var inUrl = "${ctx}/premaritalexainfo/finishAdd"
		 		  var finishEditUrl = "${ctx}/premaritalexainfo/finishEdit"
		 		  var womanPresentationUrl = "${ctx}/premaritalexainfo/womanPresentation"
		 		  var editUrl = "${ctx}/premaritalexainfo/edit"
		 		  var addUrl = "${ctx}/premaritalexainfo/add"
		 		  //保存
			 	  $("#u241").click(function(){
			 		 document.getElementById('u235_input').disabled=false;
			 		 $("#from").attr("action",editUrl);
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
		 			 if (referral == "0") {
		 				$("#u229_input").val("");
				 		$("#u232_input")[0].selectedIndex = -1;
				 		$("#u235_input").val("");
					 }
		 			 
		 			 //出具《婚前医学检查证明》日期
		 			 var issuedByDate = $("#u511_input").val();
					 
					 if (issuedByDate == null || issuedByDate == "") {
						 alert("出具《婚前医学检查证明》日期不能为空！");
							return false;
					 }
					 
		 			  
		 			 document.getElementById('u235_input').disabled=false;
		 			  
		 			  $.ajax({
	    					url:finishEditUrl,
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
		 		  
		 		  //不进入婚检报告
		 		  $("#u04").click(function(){
		 			 
		 			 var id = $("#archId").val();
		 			
		 			window.location = noPresentationWomanUrl+'?id='+id;
		 			
		 		  })
		 		  
	    		  //年龄
	    		  var birthday = $("#birthday").html();
	    		  var nowdate = new Date();
	    		  var age = nowdate.getFullYear() - birthday.substr(0,4);
	    		  $("#u14").html("年龄："+age);
	    		  
	    		  var hospitalUrl = "${ctx}/premaritalexainfo/hospital"
	    		  
    			  //转诊机构下拉列
    			  var mechanism = $("#mechanism").val();
 	 			  $.ajax({
 	 				  dataType:'json',
 	 	 			  url:hospitalUrl,
 	 	 			  success:function(data){
	 	 	 			  $("#u232_input").html("");
	 	 	 			  var str = "" ;
	 	 	 			  for(var i = 0;i<data.list.length;i++){
	 	 	 				  var s = "";
	 	 	 				  if (mechanism == data.list[i].id) {
	 	 	 					s = "selected";
							  }
	 	 	 				  str += "<option "+s+" value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
	 	 	 			  }
	 	 	 			  $("#u232_input").html(str);
	 	 	 			  if (mechanism == null || mechanism == "") {
	 	 	 				$("#u232_input").html(str);
	 	 	 				$("#u232_input")[0].selectedIndex = -1;
						}
 	 	 			  }
 	 	 		  });
	    	 		
	    		  
		    	  //预约医生
		    	  var doctorUrl = "${ctx}/premaritalexainfo/doctor"
		    	  var doctorAppointments = $("#doctorAppointments").val();
		    	  
		    	  $.ajax({
	 	 				dataType:'json',
	 	 	 			url:doctorUrl,
	 	 	 			success:function(data){
		 	 	 			$("#u508_input").html("");
		 	 	 			var str = "" ;
		 	 	 			for(var i = 0;i<data.list.length;i++){
		 	 	 				var ss = "";
		 	 	 				if (doctorAppointments == data.list[i].id) {
		 	 	 					ss = "selected";
								}
		 	 	 				
		 	 	 				str += "<option "+ss+" value="+data.list[i].id+">"+data.list[i].realName+"</option>" ;
		 	 	 			}
		 	 	 			$("#u508_input").html(str);
		 	 	 			
		 	 	 			if (doctorAppointments == null || doctorAppointments == "") {
	 	 	 					
	 	 	 					$("#u508_input").html(str);
	 	 	 					$("#u508_input")[0].selectedIndex = -1;
	 	 	 					
							}
		 	 	 			//$("#u508_input")[0].selectedIndex = -1;
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
						}
					});
		    	  }; */
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
  
          <p id="u30"><span>检查医院：${archivesInfoDetail.department.name }</span></p>
          <p id="u32"><span>检查医生：<input id = "realName" type = "hidden" name = "realName" value="${archivesInfoDetail.operatorPO.realName }"/>${archivesInfoDetail.operatorPO.realName }</span></p>
          <p id="u250"><span>检查日期：<input id = "createTime" type = "hidden" name = "createTime" value="${archivesInfoDetail.creatTime }"/>${archivesInfoDetail.creatTime }</span></p>
          <p id="u252"><span>档案编号：<input id = "archivesCode" type = "hidden" name = "archivesCode" value="${archivesInfoDetail.archivesInfo.archivesCode }"/>${archivesInfoDetail.archivesInfo.archivesCode }</span></p>
  </div>

      <!-- Unnamed (形状) -->
  <div id="u4" class="ax_形状" style="background-color:#009DD9;">
          <p id="u5"><span>个 人 基 本 信 息</span></p>
  </div>
      
<div id="u6" class="ax_形状" >
			<input id = "premaritalId" type = "hidden" name = "premaritalId" value = "${archivesInfoDetail.premarital.id }"/>
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
		<input id = "kinship" type = "hidden" value = "${archivesInfoDetail.health.kinship }"/>
  		<select id="u262_input" name = "kinship"
  			<c:if test="${archivesInfoDetail.health.kinship == null }">
	          	class = "test"
          </c:if> >
          
          <c:if test="${archivesInfoDetail.health.kinship == '0' }">
	          	<option value="0" selected>无</option>
	            <option value="1">表</option>
	            <option value="2">堂</option>
	            <option value="3">其他（三代内）</option>
	            <option value="4">其他（非三代内）</option>
          </c:if>
          <c:if test="${archivesInfoDetail.health.kinship == '1' }">
	          	<option value="0">无</option>
	            <option value="1" selected>表</option>
	            <option value="2">堂</option>
	            <option value="3">其他（三代内）</option>
	            <option value="4">其他（非三代内）</option>
          </c:if>
          <c:if test="${archivesInfoDetail.health.kinship == '2' }">
	          	<option value="0">无</option>
	            <option value="1">表</option>
	            <option value="2" selected>堂</option>
	            <option value="3">其他（三代内）</option>
	            <option value="4">其他（非三代内）</option>
          </c:if>
          <c:if test="${archivesInfoDetail.health.kinship == '3' }">
	          	<option value="0">无</option>
	            <option value="1">表</option>
	            <option value="2">堂</option>
	            <option value="3" selected>其他（三代内）</option>
	            <option value="4">其他（非三代内）</option>
          </c:if>
          <c:if test="${archivesInfoDetail.health.kinship == '4' }">
	          	<option value="0">无</option>
	            <option value="1">表</option>
	            <option value="2">堂</option>
	            <option value="3">其他（三代内）</option>
	            <option value="4" selected>其他（非三代内）</option>
          </c:if>
          <c:if test="${archivesInfoDetail.health.kinship == '' || archivesInfoDetail.health.kinship == null }">
	          	<option value="0">无</option>
	            <option value="1">表</option>
	            <option value="2">堂</option>
	            <option value="3">其他（三代内）</option>
	            <option value="4">其他（非三代内）</option>
          </c:if>
        </select>

        <input id="u355_input" name = "otherRelationships" type="text" value="${archivesInfoDetail.health.otherRelationships }"/>


          <p id="u263"><span>既往病史</span><span>：</span></p>
	
	
      <div id="u309" class="ax_复选框">
      	
      	
		<input id="u309_input" name = "medicalHistory" type="checkbox"
			<c:forEach items="${list }" var="s">
			<c:if test="${s == '0'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="0"/>
            <p id="u310"><span>无</span></p>
            
      </div>

      <div id="u311" class="ax_复选框">
            <p id="u312"><span>心脏病</span></p>
        <input id="u311_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s"> 
        	<c:if test="${s == '1'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="1"/>
      </div>

      <div id="u313" class="ax_复选框">
            <p id="u314"><span>肺结核</span></p>
        <input id="u313_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '2'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="2"/>
      </div>

      <div id="u315" class="ax_复选框">
            <p id="u316"><span>肝脏病</span></p>
        <input id="u315_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '3'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="3"/>
      </div>

      <div id="u317" class="ax_复选框">
            <p id="u318"><span>泌尿生殖系统疾病</span></p>
        <input id="u317_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '4'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="4"/>
      </div>
	  
      <div id="u319" class="ax_复选框">
            <p id="u320"><span>糖尿病</span></p>
        <input id="u319_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '5'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="5"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u321" class="ax_复选框">
            <p id="u322"><span>高血压</span></p>
        <input id="u321_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '6'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="6"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u323" class="ax_复选框">
            <p id="u324"><span>精神病</span></p>
        <input id="u323_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '7'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="7"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u325" class="ax_复选框">
            <p id="u326"><span>性病</span></p>
        <input id="u325_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '8'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="8"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u327" class="ax_复选框">
            <p id="u328"><span>癫痫</span></p>
        <input id="u327_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '9'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="9"/>
      </div>

      <!-- Unnamed (复选框) -->
  <div id="u329" class="ax_复选框">
            <p id="u330"><span>甲亢</span></p>
        <input id="u329_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '10'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="10"/>
      </div>

      <!-- Unnamed (复选框) -->
  <div id="u331" class="ax_复选框">
            <p id="u332"><span>先天疾患</span></p>
        <input id="u331_input" name = "medicalHistory" type="checkbox"
        <c:forEach items="${list }" var="s">
        	<c:if test="${s == '11'}">
          			checked = "checked"
          	</c:if>
        </c:forEach> value="11"/>
  </div>

  <input id="u358_input" name = "medicalOther" type="text" value="${archivesInfoDetail.health.medicalOther }"/>
  
          <p id="u265"><span>手术史：</span></p>
          <input id = "surgeryHistory" type = "hidden" value = "${archivesInfoDetail.health.surgeryHistory }"/>
  <select id="u279_input" name = "surgeryHistory" <c:if test="${archivesInfoDetail.health.surgeryHistory == null }">
	          	class = "test"
          </c:if>>
          <c:if test="${archivesInfoDetail.health.surgeryHistory == '0'}">
	   			<option selected value="0">无</option>
	            <option value="1">有</option>
   		  </c:if>
   		  <c:if test="${archivesInfoDetail.health.surgeryHistory == '1'}">
	   			<option value="0">无</option>
	            <option selected value="1">有</option>
   		  </c:if>
   		  <c:if test="${archivesInfoDetail.health.surgeryHistory == '' || archivesInfoDetail.health.surgeryHistory == null }">
	   			<option value="0">无</option>
	            <option value="1">有</option>
   		  </c:if>
  </select>

  <input id="u356_input" name = "operation" type="text" value="${archivesInfoDetail.health.operation }" placeholder = "有时显示输入框"/>
  
          <p id="u280"><span>其他：</span></p>
  <input id="u282_input" name = "operationOther" type="text" value="${archivesInfoDetail.health.operationOther }"/>

          <p id="u267"><span>现病史：</span></p>
          <input id = "hpi" type = "hidden" value = "${archivesInfoDetail.health.hpi }"/>
  <select id="u283_input" name = "hpi" <c:if test="${archivesInfoDetail.health.hpi == null }">
	          	class = "test"
          </c:if>>
  		<c:if test="${archivesInfoDetail.health.hpi == '0'}">
            <option selected value="0">无</option>
            <option value="1">有</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.hpi == '1'}">
   			<option value="0">无</option>
            <option selected value="1">有</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.hpi == '' || archivesInfoDetail.health.hpi == null }">
   			<option value="0">无</option>
            <option value="1">有</option>
   		</c:if>
  </select>

  <input id="u357_input" name = "caseInformation" type="text" value="${archivesInfoDetail.health.caseInformation }" placeholder = "有时显示输入框"/>

          <p id="u269"><span>月经史：</span></p>
          
          <p id="u285"><span>初潮年龄：</span></p>    
  <input id="u359_input" name = "menarcheAge" type="text" value="${archivesInfoDetail.health.menarcheAge }"/>
          <p id="u360"><span>岁</span></p>

          <p id="u286"><span>经期：</span></p>
  <input id="u362_input" name = "menstrualPeriod" type="text" value="${archivesInfoDetail.health.menstrualPeriod }"/>
          <p id="u363"><span>天</span></p>


          <p id="u288"><span>周期：</span></p>
  <input id="u365_input" name = "cycle" type="text" value="${archivesInfoDetail.health.cycle }"/>
          <p id="u366"><span>天</span></p>

          <p id="u290"><span>量：</span></p>
  <select id="u368_input" name = "amount" <c:if test="${archivesInfoDetail.health.amount == null }">
	          	class = "test"
          </c:if>>
  		<c:if test="${archivesInfoDetail.health.amount == '0'}">
   			<option selected value="0">多</option>
            <option value="1">中</option>
            <option value="2">少</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.amount == '1'}">
          <option value="0">多</option>
          <option selected value="1">中</option>
          <option value="2">少</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.amount == '2'}">
          <option value="0">多</option>
          <option value="1">中</option>
          <option selected value="2">少</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.amount == '' || archivesInfoDetail.health.amount == null }">
          <option value="0">多</option>
          <option value="1">中</option>
          <option value="2">少</option>
   		</c:if>
   </select>

          <p id="u271"><span>痛经：</span></p>
        <select id="u292_input" name = "dysmenorrhea" <c:if test="${archivesInfoDetail.health.dysmenorrhea == null }">
	          	class = "test"
          </c:if>>
          <c:if test="${archivesInfoDetail.health.dysmenorrhea == '0'}">
   			<option selected value="0">无</option>
            <option value="1">轻</option>
            <option value="2">中</option>
            <option value="3">重</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.dysmenorrhea == '1'}">
   			<option value="0">无</option>
            <option selected value="1">轻</option>
            <option value="2">中</option>
            <option value="3">重</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.dysmenorrhea == '2'}">
   			<option value="0">无</option>
            <option value="1">轻</option>
            <option selected value="2">中</option>
            <option value="3">重</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.dysmenorrhea == '3'}">
   			<option value="0">无</option>
            <option value="1">轻</option>
            <option value="2">中</option>
            <option selected value="3">重</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.dysmenorrhea == '' || archivesInfoDetail.health.dysmenorrhea == null }">
   			<option value="0">无</option>
            <option value="1">轻</option>
            <option value="2">中</option>
            <option value="3">重</option>
   		</c:if>
 </select>
        

          <p id="u293"><span>末次月经：</span></p>
  
        <input type="text" id="u354_input" name="lastMenstrualPeriod"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="${archivesInfoDetail.lastMenstrualPeriod }" tabindex="1" required>


          <p id="u306"><span>是否怀孕：</span></p>
  <select id="u308_input" name="whetherPregnant" <c:if test="${archivesInfoDetail.health.whetherPregnant == null }">
	          	class = "test"
          </c:if>>
          
       <c:if test="${archivesInfoDetail.health.whetherPregnant == '0'}">
   			<option selected value="0">备孕</option>
          <option value="1">正常</option>
          <option value="2">现孕</option>
          <option value="3">已分娩</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.whetherPregnant == '1'}">
   			<option value="0">备孕</option>
          <option selected value="1">正常</option>
          <option value="2">现孕</option>
          <option value="3">已分娩</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.whetherPregnant == '2'}">
   			<option value="0">备孕</option>
          <option value="1">正常</option>
          <option selected value="2">现孕</option>
          <option value="3">已分娩</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.whetherPregnant == '3'}">
   			<option value="0">备孕</option>
          <option value="1">正常</option>
          <option value="2">现孕</option>
          <option selected value="3">已分娩</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.whetherPregnant == '' || archivesInfoDetail.health.whetherPregnant == null }">
   			<option value="0">备孕</option>
          <option value="1">正常</option>
          <option value="2">现孕</option>
          <option value="3">已分娩</option>
   		</c:if>
  </select>

          <p id="u273"><span>既往婚育史：</span></p>
          <input id = "marr" type = "hidden" value = "${archivesInfoDetail.health.marriedHistory }"/>
  <select id="u369_input" name="marriedHistory" <c:if test="${archivesInfoDetail.health.marriedHistory == null }">
	          	class = "test"
          </c:if>>
        <c:if test="${archivesInfoDetail.health.marriedHistory == '0'}">
   			<option value="1">有</option>
            <option selected value="0">无</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.marriedHistory == '1'}">
   			<option selected value="1">有</option>
            <option value="0">无</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.marriedHistory == '' || archivesInfoDetail.health.marriedHistory == null }">
   			<option value="1">有</option>
            <option value="0">无</option>
   		</c:if>
  </select>

  <select id="u295_input" name="marriageStatus" <c:if test="${archivesInfoDetail.health.marriageStatus == null }">
	          	class = "test"
          </c:if>>
        <c:if test="${archivesInfoDetail.health.marriageStatus == '0'}">
   			<option value="1">离异</option>
            <option selected value="0">丧偶</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.marriageStatus == '1'}">
   			<option selected value="1">离异</option>
            <option value="0">丧偶</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.marriageStatus == '' || archivesInfoDetail.health.marriageStatus == null }">
   			<option value="1">离异</option>
            <option value="0">丧偶</option>
   		</c:if>
  </select>

          <p id="u296"><span>足月：</span></p>
  <select id="u298_input" name="amontNumber" <c:if test="${archivesInfoDetail.health.amontNumber == null }">
	          	class = "test"
          </c:if>>
      <c:if test="${archivesInfoDetail.health.amontNumber == '0'}">
		  <option selected value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
	</c:if>
	<c:if test="${archivesInfoDetail.health.amontNumber == '1'}">
		<option value="0">0</option>
          <option selected value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
	</c:if>
	<c:if test="${archivesInfoDetail.health.amontNumber == '2'}">
		<option value="0">0</option>
          <option value="1">1</option>
          <option selected value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
	</c:if>
	<c:if test="${archivesInfoDetail.health.amontNumber == '3'}">
		  <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option selected value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
	</c:if>
	<c:if test="${archivesInfoDetail.health.amontNumber == '4'}">
		  <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option selected value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
	</c:if>
	<c:if test="${archivesInfoDetail.health.amontNumber == '5'}">
		  <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option selected value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
	</c:if>
	<c:if test="${archivesInfoDetail.health.amontNumber == '6'}">
		<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option selected value="6">6</option>
          <option value="7">其他</option>
	</c:if>
	<c:if test="${archivesInfoDetail.health.amontNumber == '7'}">
		<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option selected value="7">其他</option>
	</c:if>
	<c:if test="${archivesInfoDetail.health.amontNumber == '' || archivesInfoDetail.health.amontNumber == null }">
		<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
	</c:if>
  </select>

  <input id="u373_input" name="amontNumberOther" type="text" value="${archivesInfoDetail.health.amontNumberOther }" placeholder = "其他"/>

          <p id="u299"><span>早产：</span></p>
  <select id="u370_input" name="pretermDeliveryNum" <c:if test="${archivesInfoDetail.health.pretermDeliveryNum == null }">
	          	class = "test"
          </c:if>>
       <c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '0'}">
   			<option selected value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '1'}">
   			<option value="0">0</option>
          <option selected value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '2'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option selected value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '3'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option selected value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '4'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option selected value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '5'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option selected value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '6'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option selected value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '7'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option selected value="7">其他</option>
   			
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.pretermDeliveryNum == '' || archivesInfoDetail.health.pretermDeliveryNum == null }">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   			
   		</c:if>
  </select>

  <input id="u374_input" name="pretermDeliveryOther" type="text" value="${archivesInfoDetail.health.pretermDeliveryOther }" placeholder = "其他"/>

          <p id="u302"><span>流产：</span></p>
  <select id="u371_input" name="abortionNumber" <c:if test="${archivesInfoDetail.health.abortionNumber == null }">
	          	class = "test"
          </c:if>>
          
      <c:if test="${archivesInfoDetail.health.abortionNumber == '0'}">
   			<option selected value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.abortionNumber == '1'}">
   			<option value="0">0</option>
          <option selected value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.abortionNumber == '2'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option selected value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.abortionNumber == '3'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option selected value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.abortionNumber == '4'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option selected value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.abortionNumber == '5'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option selected value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.abortionNumber == '6'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option selected value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.abortionNumber == '7'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option selected value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.abortionNumber == '' || archivesInfoDetail.health.abortionNumber == null }">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
  </select>

  <input id="u375_input" name="abortionOther" type="text" value="${archivesInfoDetail.health.abortionOther }" placeholder = "其他"/>

          <p id="u303"><span>子女：</span></p>
  <select id="u372_input" name="childrenNumber" <c:if test="${archivesInfoDetail.health.childrenNumber == null }">
	          	class = "test"
          </c:if>>
          
      <c:if test="${archivesInfoDetail.health.childrenNumber == '0'}">
   			<option selected value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.childrenNumber == '1'}">
   			<option value="0">0</option>
          <option selected value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.childrenNumber == '2'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option selected value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.childrenNumber == '3'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option selected value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.childrenNumber == '4'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option selected value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.childrenNumber == '5'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option selected value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.childrenNumber == '6'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option selected value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.childrenNumber == '7'}">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option selected value="7">其他</option>
   		</c:if>
   		<c:if test="${archivesInfoDetail.health.childrenNumber == '' || archivesInfoDetail.health.childrenNumber == null }">
   			<option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">其他</option>
   		</c:if>
  </select>

  <input id="u376_input" name="childrenOther" type="text" value="${archivesInfoDetail.health.childrenOther }" placeholder = "其他"/>

          <p id="u275"><span>与遗传有关的家族史：</span></p>

  <div id="u333" class="ax_复选框">
            <p id="u334"><span>无</span></p>
        <input id="u333_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        	<c:if test="${s1 == '0'}">
          			checked = "checked"
          	</c:if>
       	</c:forEach> value="0"/>
  </div>

  <div id="u335" class="ax_复选框">
            <p id="u336"><span>盲</span></p>
        <input id="u335_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
         <c:if test="${s1 == '1'}">
          			checked = "checked"
         </c:if>
         </c:forEach> value="1"/>
  </div>

  <input id="u532_input" name="patientRelationship" type="text" value="${list11[0] }" placeholder = "患者与本人关系"/>

  <div id="u337" class="ax_复选框">
            <p id="u338"><span>聋</span></p>
        <input id="u337_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        <c:if test="${s1 == '2'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="2"/>
      </div>

  <input id="u535_input" name="patientRelationship" type="text" value="${list11[1] }" placeholder = "患者与本人关系"/>

  <div id="u339" class="ax_复选框">
            <p id="u340"><span>哑</span></p>
        <input id="u339_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        <c:if test="${s1 == '3'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="3"/>
      </div>

  <input id="u536_input" name="patientRelationship" type="text" value="${list11[2] }" placeholder = "患者与本人关系"/>

  <div id="u341" class="ax_复选框">
            <p id="u342"><span>精神病</span></p>
        <input id="u341_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        <c:if test="${s1 == '4'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="4"/>
      </div>
      
  <input id="u643_input" name="patientRelationship" type="text" value="${list11[3] }" placeholder = "患者与本人关系"/>

  <div id="u343" class="ax_复选框">
            <p id="u344"><span>先天性智力低下</span></p>
        <input id="u343_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        <c:if test="${s1 == '5'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="5"/>
      </div>

  <input id="u537_input" name="patientRelationship" type="text" value="${list11[4] }" placeholder = "患者与本人关系"/>


      <!-- Unnamed (复选框) -->
  <div id="u345" class="ax_复选框">
            <p id="u346"><span>先天性心脏病</span></p>
        <input id="u345_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        <c:if test="${s1 == '6'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="6"/>
      </div>

  <input id="u538_input" name="patientRelationship" type="text" value="${list11[5] }" placeholder = "患者与本人关系"/>

      <!-- Unnamed (复选框) -->
  <div id="u347" class="ax_复选框">
            <p id="u348"><span>血友病</span></p>
        <input id="u347_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        <c:if test="${s1 == '7'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="7"/>
      </div>

  <input id="u539_input" name="patientRelationship" type="text" value="${list11[6] }" placeholder = "患者与本人关系"/>

  <div id="u349" class="ax_复选框">
            <p id="u350"><span>糖尿病</span></p>
        <input id="u349_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        <c:if test="${s1 == '8'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="8"/>
      </div>

  <input id="u540_input" name="patientRelationship" type="text" value="${list11[7] }" placeholder = "患者与本人关系"/>

      <!-- Unnamed (复选框) -->
  <div id="u351" class="ax_复选框">
            <p id="u352"><span>其他</span></p>
        <input id="u351_input" name="geneticHistory" type="checkbox"
        <c:forEach items="${list1 }" var="s1">
        	<c:if test="${s1 == '9'}">
          			checked = "checked"
          	</c:if>
        </c:forEach> value="9"/>
  </div>
        
  <input id="u533_input" name="geneticHistory" style="display:block" type="text" value="${archivesInfoDetail.health.geneticHistoryRemark }" placeholder = "其他时显示输入框"/>
  <input id="u999_input" name="patientRelationship" type="text" value="${list11[8] }" placeholder = "患者与本人关系"/>

          <p id="u277"><span>家族近亲婚配</span><span>：</span></p>
        <select id="u305_input" name="relativesMating" <c:if test="${archivesInfoDetail.health.relativesMating == null }">
	          	class = "test"
          </c:if>>
          
            <c:if test="${archivesInfoDetail.health.relativesMating == '0'}">
       			  <option selected value="0">无</option>
		          <option value="1">有（父母）</option>
		          <option value="2">有（祖父母）</option>
		          <option value="3">有（外祖父母）</option>
		          <option value="4">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.health.relativesMating == '1'}">
       			  <option value="0">无</option>
		          <option selected value="1">有（父母）</option>
		          <option value="2">有（祖父母）</option>
		          <option value="3">有（外祖父母）</option>
		          <option value="4">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.health.relativesMating == '2'}">
       			  <option value="0">无</option>
		          <option value="1">有（父母）</option>
		          <option selected value="2">有（祖父母）</option>
		          <option value="3">有（外祖父母）</option>
		          <option value="4">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.health.relativesMating == '3'}">
       			  <option value="0">无</option>
		          <option value="1">有（父母）</option>
		          <option value="2">有（祖父母）</option>
		          <option selected value="3">有（外祖父母）</option>
		          <option value="4">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.health.relativesMating == '4'}">
       			  <option value="0">无</option>
		          <option value="1">有（父母）</option>
		          <option value="2">有（祖父母）</option>
		          <option value="3">有（外祖父母）</option>
		          <option selected value="4">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.health.relativesMating == '' || archivesInfoDetail.health.relativesMating == null }">
       			  <option value="0">无</option>
		          <option value="1">有（父母）</option>
		          <option value="2">有（祖父母）</option>
		          <option value="3">有（外祖父母）</option>
		          <option value="4">其他</option>
       		</c:if>
        </select>

        <input id="u353_input" name="relativesMatingRemark" type="text" value="${archivesInfoDetail.health.relativesMatingRemark }"/>

  </div>
    
    <div id="u38" class="ax_形状" style="background-color:#009DD9;" onclick="CanShu('u41','u38','u40');">
          <p id="u39"><span>体 格 检 查</span></p>
          <p id="u40">展开</p>
  </div>
  
  <div id="u41" class="ax_形状" style="display:none">
          <p id="u42"><span>血压：</span></p>
        <input id="u48_input" name = "bloodLow" type="text" value="${archivesInfoDetail.physique.bloodLow }"/>

          <p id="u49"><span>/</span></p>
        <input id="u51_input" name = "bloodHi" type="text" value="${archivesInfoDetail.physique.bloodHi }"/>
          <p id="u44"><span>mmHg</span></p>

          <p id="u72"><span>血型：</span></p>
        <select id="u177_input" name = "bloodType" <c:if test="${archivesInfoDetail.physique.bloodType == null }">
	          	class = "test"
          </c:if>>
          <c:if test="${archivesInfoDetail.physique.bloodType == '0'}">
       			  <option selected value="0">A型</option>
		          <option value="1">B型</option>
		          <option value="2">AB型</option>
		          <option value="3">O型</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.physique.bloodType == '1'}">
       			  <option value="0">A型</option>
		          <option selected value="1">B型</option>
		          <option value="2">AB型</option>
		          <option value="3">O型</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.physique.bloodType == '2'}">
       			  <option value="0">A型</option>
		          <option value="1">B型</option>
		          <option selected value="2">AB型</option>
		          <option value="3">O型</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.physique.bloodType == '3'}">
       			  <option value="0">A型</option>
		          <option value="1">B型</option>
		          <option value="2">AB型</option>
		          <option selected value="3">O型</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.physique.bloodType == '' || archivesInfoDetail.physique.bloodType ==null }">
       			  <option value="0">A型</option>
		          <option value="1">B型</option>
		          <option value="2">AB型</option>
		          <option value="3">O型</option>
       		</c:if>
        </select>

          <p id="u140"><span>RH：</span></p>
        <select id="u178_input" name = "yinYang" <c:if test="${archivesInfoDetail.physique.yinYang == null }">
	          	class = "test"
          </c:if>>
            <c:if test="${archivesInfoDetail.physique.yinYang == '0'}">
       			  <option value="2">未检查</option>
		          <option selected value="0">RH+</option>
		          <option value="1">RH-</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.physique.yinYang == '1'}">
       			  <option value="2">未检查</option>
		          <option value="0">RH+</option>
		          <option selected value="1">RH-</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.physique.yinYang == '2'}">
       			  <option selected value="2">未检查</option>
		          <option value="0">RH+</option>
		          <option value="1">RH-</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.physique.yinYang == '' || archivesInfoDetail.physique.yinYang ==null }">
       			  <option value="2">未检查</option>
		          <option value="0">RH+</option>
		          <option value="1">RH-</option>
       		</c:if>
        </select>

          <p id="u377"><span>特殊体态：</span></p>
        <select id="u379_input" name = "specialPosture" data-label="性别" <c:if test="${archivesInfoDetail.physique.specialPosture == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.specialPosture == '0'}">
          			<option selected value="0">无</option>
          			<option value="1">有</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.specialPosture == '1'}">
          			<option value="0">无</option>
          			<option selected value="1">有</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.specialPosture == '' || archivesInfoDetail.physique.specialPosture == null }">
          			<option value="0">无</option>
          			<option value="1">有</option>
          		</c:if>
        </select>

        <input id="u380_input" name = "postureRemark" type="text" value="${archivesInfoDetail.physique.postureRemark }" placeholder = "有时显示输入框"/>
        
          <p id="u381"><span>特殊面容：</span></p>
        <select id="u383_input" name = "specialFace" data-label="性别" <c:if test="${archivesInfoDetail.physique.specialFace == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.specialFace == '0'}">
          			<option selected value="0">无</option>
          			<option value="1">有</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.specialFace == '1'}">
          			<option value="0">无</option>
          			<option selected value="1">有</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.specialFace == '' || archivesInfoDetail.physique.specialFace == null }">
          			<option value="0">无</option>
          			<option value="1">有</option>
          		</c:if>
        </select>

        <input id="u384_input" name = "faceRemark" type="text" value="${archivesInfoDetail.physique.faceRemark }" placeholder = "有时显示输入框"/>

          <p id="u385"><span>精神状态：</span></p>
        <select id="u387_input" name = "mentalState" data-label="性别" <c:if test="${archivesInfoDetail.physique.mentalState == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.mentalState == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.mentalState == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.mentalState == '' || archivesInfoDetail.physique.mentalState == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u388_input" name = "stateRemark" type="text" value="${archivesInfoDetail.physique.stateRemark }" placeholder = "异常时显示输入框"/>

          <p id="u389"><span>智力：</span></p>
        <select id="u391_input" name = "intelligence" data-label="性别" <c:if test="${archivesInfoDetail.physique.intelligence == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.intelligence == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.intelligence == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.intelligence == '' || archivesInfoDetail.physique.intelligence == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <select id="u392_input" name = "exceptionTypes" <c:if test="${archivesInfoDetail.physique.exceptionTypes == null }">
	          	class = "test"
          </c:if>>
          
          		<c:if test="${archivesInfoDetail.physique.exceptionTypes == '0'}">
          			  <option selected value="0">常识</option>
			          <option value="1">判断</option>
			          <option value="2">记忆</option>
			          <option value="3">计算</option>
			          <option value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.exceptionTypes == '1'}">
          			  <option value="0">常识</option>
			          <option selected value="1">判断</option>
			          <option value="2">记忆</option>
			          <option value="3">计算</option>
			          <option value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.exceptionTypes == '2'}">
          			  <option value="0">常识</option>
			          <option value="1">判断</option>
			          <option selected value="2">记忆</option>
			          <option value="3">计算</option>
			          <option value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.exceptionTypes == '3'}">
          			  <option value="0">常识</option>
			          <option value="1">判断</option>
			          <option value="2">记忆</option>
			          <option selected value="3">计算</option>
			          <option value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.exceptionTypes == '4'}">
          			  <option value="0">常识</option>
			          <option value="1">判断</option>
			          <option value="2">记忆</option>
			          <option value="3">计算</option>
			          <option selected value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.exceptionTypes == '' || archivesInfoDetail.physique.exceptionTypes == null }">
          			  <option value="0">常识</option>
			          <option value="1">判断</option>
			          <option value="2">记忆</option>
			          <option value="3">计算</option>
			          <option value="4">其他</option>
          		</c:if>
        </select>

          <p id="u393"><span>皮肤毛发：</span></p>
        <select id="u395_input" name = "skinHair" data-label="性别" <c:if test="${archivesInfoDetail.physique.skinHair == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.skinHair == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.skinHair == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.skinHair == '' || archivesInfoDetail.physique.skinHair == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u396_input" name = "skinHairNote" type="text" value="${archivesInfoDetail.physique.skinHairNote }" placeholder = "异常时显示输入框"/>

          <p id="u46"><span>五官：</span></p>
        <select id="u52_input" name = "facialFeatures" data-label="性别" <c:if test="${archivesInfoDetail.physique.facialFeatures == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.facialFeatures == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.facialFeatures == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.facialFeatures == '' || archivesInfoDetail.physique.facialFeatures == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u53_input" name = "facialFeaturesRemark" type="text" value="${archivesInfoDetail.physique.facialFeaturesRemark }" placeholder = "异常时显示输入框"/>

          <p id="u397"><span>甲状腺：</span></p>
        <select id="u399_input" name = "thyroidGland" data-label="性别" <c:if test="${archivesInfoDetail.physique.thyroidGland == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.thyroidGland == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.thyroidGland == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.thyroidGland == '' || archivesInfoDetail.physique.thyroidGland == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u400_input" name = "thyroidGlandRemark" type="text" value="${archivesInfoDetail.physique.thyroidGlandRemark }" placeholder = "异常时显示输入框"/>

          <p id="u401"><span>心率：</span></p>
        <input id="u403_input" name = "heartRate" type="text" value="${archivesInfoDetail.physique.heartRate }"/>
          <p id="u404"><span>次/分</span></p>

          <p id="u406"><span>心律：</span></p>
        <select id="u408_input" name = "heartRhythm" <c:if test="${archivesInfoDetail.physique.heartRhythm == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm == '0'}">
          			  <option selected value="0">齐</option>
			          <option value="1">过速</option>
			          <option value="2">过缓</option>
			          <option value="3">不齐</option>
			          <option value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm == '1'}">
          			  <option value="0">齐</option>
			          <option selected value="1">过速</option>
			          <option value="2">过缓</option>
			          <option value="3">不齐</option>
			          <option value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm == '2'}">
          			  <option value="0">齐</option>
			          <option value="1">过速</option>
			          <option selected value="2">过缓</option>
			          <option value="3">不齐</option>
			          <option value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm == '3'}">
          			  <option value="0">齐</option>
			          <option value="1">过速</option>
			          <option value="2">过缓</option>
			          <option selected value="3">不齐</option>
			          <option value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm == '4'}">
          			  <option value="0">齐</option>
			          <option value="1">过速</option>
			          <option value="2">过缓</option>
			          <option value="3">不齐</option>
			          <option selected value="4">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm == '' || archivesInfoDetail.physique.heartRhythm == null }">
          			  <option value="0">齐</option>
			          <option value="1">过速</option>
			          <option value="2">过缓</option>
			          <option value="3">不齐</option>
			          <option value="4">其他</option>
          		</c:if>
        </select>

        <input id="u409_input" name = "heartRhythmRemark" type="text" value="${archivesInfoDetail.physique.heartRhythmRemark }" placeholder = "其他"/>

          <p id="u410"><span>杂音：</span></p>
        <select id="u412_input" name = "noise" data-label="性别" <c:if test="${archivesInfoDetail.physique.noise == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.noise == '0'}">
          			  	<option selected value="0">无</option>
          				<option value="1">有</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.noise == '1'}">
          			  	<option value="0">无</option>
          				<option selected value="1">有</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.noise == '' || archivesInfoDetail.physique.noise == null }">
          			  	<option value="0">无</option>
          				<option value="1">有</option>
          		</c:if>
        </select>

        <input id="u413_input" name = "noiseRemark" type="text" value="${archivesInfoDetail.physique.noiseRemark }" placeholder = "有时显示输入框"/>

          <p id="u414"><span>肺：</span></p>
        <select id="u416_input" name = "lung" data-label="性别" <c:if test="${archivesInfoDetail.physique.lung == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.lung == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.lung == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.lung == '' || archivesInfoDetail.physique.lung == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u417_input" name = "lungRemark" type="text" value="${archivesInfoDetail.physique.lungRemark }" placeholder = "异常时显示输入框"/>

          <p id="u418"><span>肝</span><span>：</span></p>
        <select id="u420_input" name = "liver" data-label="性别" <c:if test="${archivesInfoDetail.physique.liver == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.liver == '0'}">
          			<option selected value="0">未及</option>
          			<option value="1">可及</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.liver == '1'}">
          			<option value="0">未及</option>
          			<option selected value="1">可及</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.liver == '' || archivesInfoDetail.physique.liver == null }">
          			<option value="0">未及</option>
          			<option value="1">可及</option>
          		</c:if>
        </select>
        <input id="u421_input" name = "liverRemark" type="text" value="${archivesInfoDetail.physique.liverRemark }" placeholder = "可及时显示输入框"/>

          <p id="u422"><span>四肢脊柱：</span></p>
        <select id="u424_input" name = "limbs" data-label="性别" <c:if test="${archivesInfoDetail.physique.limbs == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.limbs == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.limbs == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.limbs == '' || archivesInfoDetail.physique.limbs == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u425_input" name = "limbsRemark" type="text" value="${archivesInfoDetail.physique.limbsRemark }" placeholder = "异常时显示输入框"/>

          <p id="u426"><span>其他：</span></p>
        <input id="u428_input" name = "others" type="text" value="${archivesInfoDetail.physique.others }"/>

      <div id="u484" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u429"><span>第二性征：</span></p>
          <p id="u431"><span>阴毛：</span></p>
        <select id="u457_input" name = "pubicHair" data-label="性别" <c:if test="${archivesInfoDetail.physique.pubicHair == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.pubicHair == '0'}">
          			  <option selected value="0">正常</option>
			          <option value="1">稀少</option>
			          <option value="2">无</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.pubicHair == '1'}">
          			  <option value="0">正常</option>
			          <option selected value="1">稀少</option>
			          <option value="2">无</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.pubicHair == '2'}">
          			  <option value="0">正常</option>
			          <option value="1">稀少</option>
			          <option selected value="2">无</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.pubicHair == '' || archivesInfoDetail.physique.pubicHair == null }">
          			  <option value="0">正常</option>
			          <option value="1">稀少</option>
			          <option value="2">无</option>
          		</c:if>
        </select>

          <p id="u433"><span>乳房：</span></p>
        <select id="u449_input" name = "breast" data-label="性别" <c:if test="${archivesInfoDetail.physique.breast == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.breast == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.breast == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.breast == '' || archivesInfoDetail.physique.breast == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u450_input" name = "breastRemark" type="text" value="${archivesInfoDetail.physique.breastRemark }" placeholder = "异常时显示输入框"/>

          <p id="u439"><span>外阴：</span></p>
        <select id="u451_input" name = "anusVulva" data-label="性别" <c:if test="${archivesInfoDetail.physique.anusVulva == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.anusVulva == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.anusVulva == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.anusVulva == '' || archivesInfoDetail.physique.anusVulva == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u452_input" name = "anusVulvaRemark" type="text" value="${archivesInfoDetail.physique.anusVulvaRemark }" placeholder = "异常时显示输入框"/>

      <div id="u482" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u435"><span>生殖器：</span></p>
          <p id="u437"><span>肛查（常规）：</span></p>
          <p id="u443"><span>分泌物：</span></p>

        <select id="u453_input" name = "secretions" data-label="性别" <c:if test="${archivesInfoDetail.physique.secretions == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.secretions == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.secretions == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.secretions == '' || archivesInfoDetail.physique.secretions == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u454_input" name = "secretionsRemark" type="text" value="${archivesInfoDetail.physique.secretionsRemark }" placeholder = "异常时显示输入框"/>

          <p id="u445"><span>外阴：</span></p>
        <select id="u455_input" name = "vulvaVagina" data-label="性别" <c:if test="${archivesInfoDetail.physique.vulvaVagina == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.vulvaVagina == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.vulvaVagina == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.vulvaVagina == '' || archivesInfoDetail.physique.vulvaVagina == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u456_input" name = "vulvaVaginaRemark" type="text" value="${archivesInfoDetail.physique.vulvaVaginaRemark }" placeholder = "异常时显示输入框"/>

      <div id="u483" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u441"><span>子宫、附件：阴道检查（必要时）</span></p>
          <p id="u458"><span>外阴：</span></p>

        <select id="u462_input" name = "vulva" data-label="性别" <c:if test="${archivesInfoDetail.physique.vulva == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.vulva == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.vulva == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.vulva == '' || archivesInfoDetail.physique.vulva == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u463_input" name = "vulvaRemark" type="text" value="${archivesInfoDetail.physique.vulvaRemark }" placeholder = "异常时显示输入框"/>

          <p id="u465"><span>阴道：</span></p>
        <select id="u469_input" name = "vagina" data-label="性别" <c:if test="${archivesInfoDetail.physique.vagina == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.vagina == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.vagina == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.vagina == '' || archivesInfoDetail.physique.vagina == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u470_input" name = "vaginaRemark" type="text" value="${archivesInfoDetail.physique.vaginaRemark }" placeholder = "异常时显示输入框"/>

          <p id="u460"><span>宫颈：</span></p>
        <select id="u447_input" name = "cervical" <c:if test="${archivesInfoDetail.physique.cervical == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.cervical == 'Ⅰ°糜烂'}">
          			  <option selected value="Ⅰ°糜烂">Ⅰ°糜烂</option>
			          <option value="Ⅱ°糜烂">Ⅱ°糜烂</option>
			          <option value="Ⅲ°糜烂">Ⅲ°糜烂</option>
			          <option value="宫颈肥大">宫颈肥大</option>
			          <option value="其他">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.cervical == 'Ⅱ°糜烂'}">
          			  <option value="Ⅰ°糜烂">Ⅰ°糜烂</option>
			          <option selected value="Ⅱ°糜烂">Ⅱ°糜烂</option>
			          <option value="Ⅲ°糜烂">Ⅲ°糜烂</option>
			          <option value="宫颈肥大">宫颈肥大</option>
			          <option value="其他">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.cervical == 'Ⅲ°糜烂'}">
          			  <option value="Ⅰ°糜烂">Ⅰ°糜烂</option>
			          <option value="Ⅱ°糜烂">Ⅱ°糜烂</option>
			          <option selected value="Ⅲ°糜烂">Ⅲ°糜烂</option>
			          <option value="宫颈肥大">宫颈肥大</option>
			          <option value="其他">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.cervical == '宫颈肥大'}">
          			  <option value="Ⅰ°糜烂">Ⅰ°糜烂</option>
			          <option value="Ⅱ°糜烂">Ⅱ°糜烂</option>
			          <option value="Ⅲ°糜烂">Ⅲ°糜烂</option>
			          <option selected value="宫颈肥大">宫颈肥大</option>
			          <option value="其他">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.cervical == '其他'}">
          			  <option value="Ⅰ°糜烂">Ⅰ°糜烂</option>
			          <option value="Ⅱ°糜烂">Ⅱ°糜烂</option>
			          <option value="Ⅲ°糜烂">Ⅲ°糜烂</option>
			          <option value="宫颈肥大">宫颈肥大</option>
			          <option selected value="其他">其他</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.cervical == '' || archivesInfoDetail.physique.cervical == null }">
          			  <option value="Ⅰ°糜烂">Ⅰ°糜烂</option>
			          <option value="Ⅱ°糜烂">Ⅱ°糜烂</option>
			          <option value="Ⅲ°糜烂">Ⅲ°糜烂</option>
			          <option value="宫颈肥大">宫颈肥大</option>
			          <option value="其他">其他</option>
          		</c:if>
        </select>

        <input id="u464_input" name = "cervicalRemark" type="text" value="${archivesInfoDetail.physique.cervicalRemark }" placeholder = "其他时显示输入框"/>

          <p id="u467"><span>子宫 ：</span></p>
        <select id="u471_input" name = "uterus" data-label="性别" <c:if test="${archivesInfoDetail.physique.uterus == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.uterus == '0'}">
          			<option value="2">未检查</option>
          			<option selected value="0">未见异常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.uterus == '1'}">
          			<option value="2">未检查</option>
          			<option value="0">未见异常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.uterus == '2'}">
          			<option selected value="2">未检查</option>
          			<option value="0">未见异常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.uterus == '' || archivesInfoDetail.physique.uterus == null }">
          			<option value="2">未检查</option>
          			<option value="0">未见异常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u472_input" name = "uterusRemark" type="text" value="${archivesInfoDetail.physique.uterusRemark }" placeholder = "异常时显示输入框"/>

          <p id="u473"><span>附件：</span></p>
        <select id="u475_input" name = "attachment" data-label="性别" <c:if test="${archivesInfoDetail.physique.attachment == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.attachment == '0'}">
          			<option selected value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.attachment == '1'}">
          			<option value="0">正常</option>
          			<option selected value="1">异常</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.attachment == '' || archivesInfoDetail.physique.attachment == null }">
          			<option value="0">正常</option>
          			<option value="1">异常</option>
          		</c:if>
        </select>

        <input id="u476_input" name = "attachmentRemark" type="text" value="${archivesInfoDetail.physique.attachmentRemark }" placeholder = "异常时显示输入框"/>

          <p id="u477"><span>其他：</span></p>
        <input id="u479_input" name = "attachmentOther" type="text" value="${archivesInfoDetail.physique.attachmentOther }"/>

          <p id="u480"><span>是否同意阴道检查：</span></p>
        <select id="u644_input" name = "vaginalExamination" <c:if test="${archivesInfoDetail.physique.vaginalExamination == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.physique.vaginalExamination == '0'}">
          			<option selected value="0">同意阴道检查</option>
          			<option value="1">拒绝阴道检查</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.vaginalExamination == '1'}">
          			<option value="0">同意阴道检查</option>
          			<option selected value="1">拒绝阴道检查</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.vaginalExamination == '' || archivesInfoDetail.physique.vaginalExamination == null }">
          			<option value="0">同意阴道检查</option>
          			<option value="1">拒绝阴道检查</option>
          		</c:if>
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
        <input id="u151_input" name = "hemoglobin" type="text" value="${archivesInfoDetail.laboratory.hemoglobin }"/>
          <p id="u60"><span>g/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u60_"></span></span></p>

          <p id="u62"><span>白细胞计数值：</span></p>
        <input id="u152_input" name = "whiteCellCount" type="text" value="${archivesInfoDetail.laboratory.whiteCellCount }"/>
          <p id="u142"><span>×10^9/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u152_"></span></span></p>

          <p id="u64"><span>血小板计数值：</span></p>
        <input id="u153_input" name = "platelet" type="text" value="${archivesInfoDetail.laboratory.platelet }"/>
          <p id="u66"><span>×10^9/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u153_"></span></span></p>

          <p id="u149"><span>其他：</span></p>
        <input id="u148_input" name = "routineBlood" type="text" value="${archivesInfoDetail.laboratory.routineBlood }"/>

      <div id="u247" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u70"><span>尿常规：</span></p>
          <p id="u156" ><span>尿糖：</span></p>
        <input id="u170_input" name = "urineSugar" type="text" value="${archivesInfoDetail.laboratory.urineSugar }"/>
          <p id="u164"><span>mmol/L</span></p>

          <p id="u158"><span>尿酮体：</span></p>
        <input id="u171_input" name = "ketoneBody" type="text" value="${archivesInfoDetail.laboratory.ketoneBody }"/>
          <p id="u166"><span>mmol/L</span></p>

          <p id="u154"><span>尿蛋白：</span></p>
        <input id="u172_input" name = "urineProtein" type="text" value="${archivesInfoDetail.laboratory.urineProtein }"/>
          <p id="u162"><span>g/L</span></p>

          <p id="u490"><span>PH：</span></p>
        <input id="u492_input" name = "ph" type="text" value="${archivesInfoDetail.laboratory.ph }"/>
        
          <p id="u160"><span>尿潜血：</span></p>
        <input id="u173_input" name = "ery" type="text" value="${archivesInfoDetail.laboratory.ery }"/>
          <p id="u168"><span>cells/u</span></p>

          <p id="u485"><span>白细胞：</span></p>
        <input id="u489_input" name = "whiteCell" type="text" value="${archivesInfoDetail.laboratory.whiteCell }"/>
          <p id="u487"><span>cells/u</span></p>

          <p id="u175"><span>其他：</span></p>
        <input id="u174_input" name = "routineUrine" type="text" value="${archivesInfoDetail.laboratory.routineUrine }"/>

      <div id="u248" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u82"><span>肝功能：</span></p>
          <p id="u179"><span>血清谷丙转氨酶：</span></p>
        <input id="u189_input" name = "serumAlt" type="text" value="${archivesInfoDetail.laboratory.serumAlt }"/>
          <p id="u74"><span>U/L</span></p>
          
          <p id="u181"><span>血清谷草转氨酶：</span></p>
        <input id="u190_input" name = "aspertateAmi" type="text" value="${archivesInfoDetail.laboratory.aspertateAmi }"/>
          <p id="u76"><span>U/L</span></p>

          <p id="u183"><span>白蛋白：</span></p>
        <input id="u191_input" name = "albumin" type="text" value="${archivesInfoDetail.laboratory.albumin }"/>
          <p id="u78"><span>g/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u191_"></span></span></p>

          <p id="u185"><span>总胆红素：</span></p>
        <input id="u192_input" name = "totalBilirubin" type="text" value="${archivesInfoDetail.laboratory.totalBilirubin }"/>
          <p id="u80"><span>μ mol/L</span>
         		<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u192_"></span></span> 
          </p>

          <p id="u187"><span>结合胆红素：</span></p>
        <input id="u193_input" name = "combiningBilirubin" type="text" value="${archivesInfoDetail.laboratory.combiningBilirubin }"/>
          <p id="u245"><span>μ mol/L</span></p>

      <div id="u249" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u84"><span>肾功能：</span></p>
          <p id="u86"><span>血清肌酐：</span></p>
        <input id="u194_input" name = "serumCreatinine" type="text" value="${archivesInfoDetail.laboratory.serumCreatinine }"/>
          <p id="u88"><span>μ mol/L</span></p>

          <p id="u90"><span>血尿素氮：</span></p>
        <input id="u195_input" name = "bloodUreaNitrogen" type="text" value="${archivesInfoDetail.laboratory.bloodUreaNitrogen }"/>
          <p id="u92"><span>mmol/L</span></p>

      <div id="u493" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

          <p id="u94"><span>阴道分泌物：</span></p>
      <div id="u96" class="ax_复选框">
            <p id="u97"><span>未见异常</span></p>
        <input id="u96_input" name = "vaginalDischarge" type="checkbox"
        <c:forEach items="${list2 }" var="s2">
        <c:if test="${s2 == '0'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="0"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u98" class="ax_复选框">
            <p id="u99"><span>滴虫</span></p>
        <input id="u98_input" name = "vaginalDischarge" type="checkbox"
        <c:forEach items="${list2 }" var="s2">
        <c:if test="${s2 == '1'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="1"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u100" class="ax_复选框">
            <p id="u101"><span>假丝酵母菌</span></p>
        <input id="u100_input" name = "vaginalDischarge" type="checkbox"
        <c:forEach items="${list2 }" var="s2">
        <c:if test="${s2 == '2'}">
          			checked = "checked"
          	</c:if>
          	</c:forEach> value="2"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u197" class="ax_复选框">
            <p id="u198"><span>其他</span></p>
        <input id="u197_input" name = "vaginalDischarge" type="checkbox"
        <c:forEach items="${list2 }" var="s2">
        	<c:if test="${s2 == '3'}">
          			checked = "checked"
          	</c:if>
        </c:forEach> value="3"/>
      </div>

        <input id="u196_input" name = "otherSecretion" style="display:block" type="text" value="${archivesInfoDetail.laboratory.otherSecretion }" placeholder = "其他时显示输入框"/>

          <p id="u102"><span>阴道清洁度：</span></p>
        <select id="u144_input" name = "cleanliness" <c:if test="${archivesInfoDetail.laboratory.cleanliness == null }">
	          	class = "test"
          </c:if>>
          		<c:if test="${archivesInfoDetail.laboratory.cleanliness == '0'}">
          			  <option selected value="0">Ⅰ度</option>
			          <option value="1 ">Ⅱ度 </option>
			          <option value="2">Ⅲ度</option>
			          <option value="3"> Ⅳ度</option>
			          <option value="4">未检查</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.cleanliness == '1'}">
          			  <option value="0">Ⅰ度</option>
			          <option selected value="1 ">Ⅱ度 </option>
			          <option value="2">Ⅲ度</option>
			          <option value="3"> Ⅳ度</option>
			          <option value="4">未检查</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.cleanliness == '2'}">
          			  <option value="0">Ⅰ度</option>
			          <option value="1 ">Ⅱ度 </option>
			          <option selected value="2">Ⅲ度</option>
			          <option value="3"> Ⅳ度</option>
			          <option value="4">未检查</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.cleanliness == '3'}">
          			  <option value="0">Ⅰ度</option>
			          <option value="1 ">Ⅱ度 </option>
			          <option value="2">Ⅲ度</option>
			          <option selected value="3"> Ⅳ度</option>
			          <option value="4">未检查</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.cleanliness == '4'}">
          			  <option value="0">Ⅰ度</option>
			          <option value="1 ">Ⅱ度 </option>
			          <option value="2">Ⅲ度</option>
			          <option value="3"> Ⅳ度</option>
			          <option selected value="4">未检查</option>
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.cleanliness == '' || archivesInfoDetail.laboratory.cleanliness == null }">
          			  <option value="0">Ⅰ度</option>
			          <option value="1 ">Ⅱ度 </option>
			          <option value="2">Ⅲ度</option>
			          <option value="3"> Ⅳ度</option>
			          <option value="4">未检查</option>
          		</c:if>
        </select>

          <p id="u104"><span>乙肝五项：</span></p>

          <p id="u106"><span>乙型肝炎表面抗原：</span></p>
      <div id="u120" class="ax_单选按钮">
            <p id="u121"><span>阴性</span></p>
        <input id="u120_input" type="radio" value="0"
        <c:if test="${archivesInfoDetail.laboratory.antigenHepatitis == '0'}">
          			checked = "checked"
          	</c:if> name="antigenHepatitis"/>
      </div>
      <div id="u122" class="ax_单选按钮">
            <p id="u123"><span>阳性</span></p>
        <input id="u122_input" type="radio" value="1"
        <c:if test="${archivesInfoDetail.laboratory.antigenHepatitis == '1'}">
          			checked = "checked"
          	</c:if> name="antigenHepatitis"/>
      </div>

          <p id="u108"><span>乙型肝炎表面抗体：</span></p>
      <div id="u124" class="ax_单选按钮">
            <p id="u125"><span>阴性</span></p>
        <input id="u124_input" type="radio" value="0"
        <c:if test="${archivesInfoDetail.laboratory.hepatitisAntibody == '0'}">
          			checked = "checked"
          	</c:if> name="hepatitisAntibody"/>
      </div>
      <div id="u126" class="ax_单选按钮">
            <p id="u127"><span>阳性</span></p>
        <input id="u126_input" type="radio" value="1"
        <c:if test="${archivesInfoDetail.laboratory.hepatitisAntibody == '1'}">
          			checked = "checked"
          	</c:if> name="hepatitisAntibody"/>
      </div>

          <p id="u114"><span>乙型肝炎核心抗体：</span></p>
      <div id="u132" class="ax_单选按钮">
            <p id="u133"><span>阴性</span></p>
        <input id="u132_input" type="radio" value="0"
        <c:if test="${archivesInfoDetail.laboratory.coreAntibody == '0'}">
          			checked = "checked"
          	</c:if> name="coreAntibody"/>
      </div>
      <div id="u134" class="ax_单选按钮">
            <p id="u135"><span>阳性</span></p>
        <input id="u134_input" type="radio" value="1"
        <c:if test="${archivesInfoDetail.laboratory.coreAntibody == '1'}">
          			checked = "checked"
          	</c:if> name="coreAntibody"/>
      </div>

          <p id="u112"><span>乙型肝炎e抗体：</span></p>
          
      <div id="u128" class="ax_单选按钮">
            <p id="u129"><span>阴性</span></p>
        <input id="u128_input" type="radio" value="0"
        <c:if test="${archivesInfoDetail.laboratory.eantibody == '0'}">
          			checked = "checked"
          	</c:if> name="eantibody"/>
      </div>
      <div id="u130" class="ax_单选按钮">
            <p id="u131"><span>阳性</span></p>
        <input id="u130_input" type="radio" value="1"
        <c:if test="${archivesInfoDetail.laboratory.eantibody == '1'}">
          			checked = "checked"
          	</c:if> name="eantibody"/>
      </div>
      
          <p id="u110"><span>乙型肝炎e抗原：</span></p>
          
      <div id="u136" class="ax_单选按钮">
            <p id="u137"><span>阴性</span></p>
        <input id="u136_input" type="radio" value="0"
        <c:if test="${archivesInfoDetail.laboratory.eantigen == '0'}">
          			checked = "checked"
          	</c:if> name="eantigen"/>
      </div>
      <div id="u138" class="ax_单选按钮">
            <p id="u139"><span>阳性</span></p>
        <input id="u138_input" type="radio" value="1"
        <c:if test="${archivesInfoDetail.laboratory.eantigen == '1'}">
          			checked = "checked"
          	</c:if> name="eantigen"/>
      </div>

          <p id="u116"><span>梅毒血清学试验：</span></p>
      <div id="u199" class="ax_单选按钮">
            <p id="u200"><span>阴性</span></p>
        <input id="u199_input" type="radio" value="0"
        <c:if test="${archivesInfoDetail.laboratory.syphilisSerum == '0'}">
          			checked = "checked"
          	</c:if> name="syphilisSerum"/>
      </div>
      <div id="u201" class="ax_单选按钮">
            <p id="u202"><span>阳性</span></p>
        <input id="u201_input" type="radio" value="1"
        <c:if test="${archivesInfoDetail.laboratory.syphilisSerum == '1'}">
          			checked = "checked"
          	</c:if> name="syphilisSerum"/>
      </div>

          <p id="u118"><span>HIV抗体检测：</span></p>
      <div id="u203" class="ax_单选按钮">
            <p id="u204"><span>阴性</span></p>
        <input id="u203_input" type="radio" value="0"
        <c:if test="${archivesInfoDetail.laboratory.hivAntibodies == '0'}">
          			checked = "checked"
          	</c:if> name="hivAntibodies"/>
      </div>
      <div id="u205" class="ax_单选按钮">
            <p id="u206"><span>阳性</span></p>
        <input id="u205_input" type="radio" value="1"
        <c:if test="${archivesInfoDetail.laboratory.hivAntibodies == '1'}">
          			checked = "checked"
          	</c:if> name="hivAntibodies"/>
      </div>

          <p id="u145"><span>胸透</span><span>：</span></p>
        <select id="u147_input" name = "chest" <c:if test="${archivesInfoDetail.laboratory.chest == null }">
	          	class = "test"
          </c:if>>
            <c:if test="${archivesInfoDetail.laboratory.chest == '0'}">
          		  <option selected value="0">未见异常</option>
		          <option value="1">异常</option>
		          <option value="2">未检查</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.laboratory.chest == '1'}">
          		  <option value="0">未见异常</option>
		          <option selected value="1">异常</option>
		          <option value="2">未检查</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.laboratory.chest == '2'}">
          		  <option value="0">未见异常</option>
		          <option value="1">异常</option>
		          <option selected value="2">未检查</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.laboratory.chest == '' || archivesInfoDetail.laboratory.chest == null }">
          		  <option value="0">未见异常</option>
		          <option value="1">异常</option>
		          <option value="2">未检查</option>
          	</c:if>
        </select>
        <input id="u534_input" name = "note" type="text" value="${archivesInfoDetail.laboratory.note }" placeholder = "异常时显示输入框"/>
      
      </div>
  
      <!-- Unnamed (形状) -->
  <div id="u207" class="ax_形状" style="background-color:#009DD9;" onclick="CanShu('u210','u207','u209');">
          <p id="u208"><span>检 查 结 果</span></p>
          <p id="u209">展开</p>
      </div>
      
      <div id="u210" class="ax_形状" style="display:none">

          <p id="u211"><span>检查结果：</span></p>
          <input id = "checkResult" type = "hidden" value = "${archivesInfoDetail.inspection.checkResult }"/>
          <input id = "resultId" type = "hidden" value = "${archivesInfoDetail.inspection.id }"/>
      <div id="u213" class="ax_单选按钮">
            <p id="u214"><span>未见异常</span></p>
        <input id="u213_input" type="radio" value="0"
        		<c:if test="${archivesInfoDetail.inspection.checkResult == '0'}">
          			checked = "checked"
          		</c:if> name="checkResult"/>
      </div>
      <div id="u215" class="ax_单选按钮">
            <p id="u216"><span>异常</span></p>
        <input id="u215_input" type="radio" value="1"
        		<c:if test="${archivesInfoDetail.inspection.checkResult == '1'}">
          			checked = "checked"
          		</c:if> name="checkResult"/>
      </div>
      
        <div id="u512" style="background: #EE5F45;cursor:pointer">
			<p id = "u5121"><span>特殊疾病</span></p>
		</div>

          <%-- <p id="u512"><span>指定传染病：</span></p>
          <input type="hidden" id="s1" value="${s1.id }"/>
          <input type="hidden" id="s11" value="${s11 }"/>
        <select id="u514_input" name = "excTerm" class = "test">
        	
        </select>
        <input id="u515_input" name = "otherExc" type="text" value="${list12[0] }" placeholder = "其他时显示输入框"/>

          <p id="u516"><span>严重遗传病：</span></p>
          <input type="hidden" id="s2" value="${s2.id }"/>
          <input type="hidden" id="s22" value="${s22 }"/>
        <select id="u518_input" name = "excTerm" class = "test">
        </select>
        <input id="u519_input" name = "otherExc" type="text" value="${list12[1] }" placeholder = "其他时显示输入框"/>

          <p id="u520"><span>精神病：</span></p>
          <input type="hidden" id="s3" value="${s3.id }"/>
          <input type="hidden" id="s33" value="${s33 }"/>
        <select id="u522_input" name = "excTerm" class = "test">
        </select>
        <input id="u523_input" name = "otherExc" type="text" value="${list12[2] }" placeholder = "其他时显示输入框"/>

          <p id="u524"><span>生殖系统疾病：</span></p>
          <input type="hidden" id="s4" value="${s4.id }"/>
          <input type="hidden" id="s44" value="${s44 }"/>
        <select id="u526_input" name = "excTerm" class = "test">
        </select>
        <input id="u527_input" name = "otherExc" type="text" value="${list12[3] }" placeholder = "其他时显示输入框"/>

          <p id="u528"><span>内科疾病：</span></p>
          <input type="hidden" id="s5" value="${s5.id }"/>
          <input type="hidden" id="s55" value="${s55 }"/>
        <select id="u530_input" name = "excTerm" class = "test">
        </select>
        <input id="u531_input" name = "otherExc" type="text" value="${list12[4] }" placeholder = "其他时显示输入框"/> --%>
    
          <p id="u495"><span>疾病诊断：</span></p>
        <input id="u494_input" name = "diseaseDiagnosis" type="text" value="${archivesInfoDetail.inspection.diseaseDiagnosis }"/>

          <p id="u497"><span>医学意见：</span></p>
        <select id="u499_input" name = "medicalAdvice" <c:if test="${archivesInfoDetail.inspection.medicalAdvice == null }">
	          	class = "test"
          </c:if>>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '0'}">
          		  <option selected value="0">未发现医学上不宜结婚的情形</option>
		          <option value="1">建议暂缓结婚</option>
		          <option value="2">建议不宜生育</option>
		          <option value="3">建议不宜结婚</option>
		          <option value="4">建议采取医学措施，尊重受检者意愿</option>  
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '1'}">
          		  <option value="0">未发现医学上不宜结婚的情形</option>
		          <option selected value="1">建议暂缓结婚</option>
		          <option value="2">建议不宜生育</option>
		          <option value="3">建议不宜结婚</option>
		          <option value="4">建议采取医学措施，尊重受检者意愿</option>  
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '2'}">
          		  <option value="0">未发现医学上不宜结婚的情形</option>
		          <option value="1">建议暂缓结婚</option>
		          <option selected value="2">建议不宜生育</option>
		          <option value="3">建议不宜结婚</option>
		          <option value="4">建议采取医学措施，尊重受检者意愿</option>  
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '3'}">
          		  <option value="0">未发现医学上不宜结婚的情形</option>
		          <option value="1">建议暂缓结婚</option>
		          <option value="2">建议不宜生育</option>
		          <option selected value="3">建议不宜结婚</option>
		          <option value="4">建议采取医学措施，尊重受检者意愿</option>  
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '4'}">
          		  <option value="0">未发现医学上不宜结婚的情形</option>
		          <option value="1">建议暂缓结婚</option>
		          <option value="2">建议不宜生育</option>
		          <option value="3">建议不宜结婚</option>
		          <option selected value="4">建议采取医学措施，尊重受检者意愿</option>  
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '' || archivesInfoDetail.inspection.medicalAdvice == null }">
          		  <option value="0">未发现医学上不宜结婚的情形</option>
		          <option value="1">建议暂缓结婚</option>
		          <option value="2">建议不宜生育</option>
		          <option value="3">建议不宜结婚</option>
		          <option value="4">建议采取医学措施，尊重受检者意愿</option>  
          	</c:if>
        </select>

          <p id="u500"><span>婚前卫生咨询：</span></p>
        <textarea id="u505_input" name = "maritalConsultation">${archivesInfoDetail.maritalConsultation }</textarea>
          <p id="u502"><span>咨询指导结果：</span></p>
        <select id="u504_input" name = "consultativeResults" <c:if test="${archivesInfoDetail.inspection.consultativeResults == null }">
	          	class = "test"
          </c:if>>
          	<c:if test="${archivesInfoDetail.inspection.consultativeResults == '0'}">
          		    <option selected value="0">接受指导意见</option>
          			<option value="1">不接受指导意见，知情后选择结婚，后果自己承担</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.consultativeResults == '1'}">
          		    <option value="0">接受指导意见</option>
          			<option selected value="1">不接受指导意见，知情后选择结婚，后果自己承担</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.consultativeResults == '' || archivesInfoDetail.inspection.consultativeResults == null }">
          		    <option value="0">接受指导意见</option>
          			<option value="1">不接受指导意见，知情后选择结婚，后果自己承担</option>
          	</c:if>
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
        <input id="u223_input" type="radio" value="0"
        <c:if test="${archivesInfoDetail.preReferral.referral == '0'}">
          			checked = "checked"
          	</c:if> name="referral"/>
      </div>
      <div id="u225" class="ax_单选按钮">
            <p id="u226"><span> 有</span></p>
        <input id="u225_input" type="radio" value="1"
        <c:if test="${archivesInfoDetail.preReferral.referral == '1'}">
          			checked = "checked"
          	</c:if> name="referral"/>
      </div>

          <p id="u227"><span>原因：</span></p>
        <input id="u229_input" name = "reason" type="text" value="${archivesInfoDetail.preReferral.reason }"/>

          <p id="u230"><span>转诊机构：</span></p>
          <input id = "mechanism" type = "hidden" value = "${archivesInfoDetail.preReferral.mechanism }"/>
        <select id="u232_input" name="mechanism" class = "test">
        	<%-- <option selected>${archivesInfoDetail.preReferral.mechanism }</option> --%>
        </select>
        
        
          <p id="u233"><span>转诊日期：</span></p>
        <input type="text" id="u235_input" name="referralDate"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="${archivesInfoDetail.referralDate }" tabindex="1" required>
      
        
          <p id="u236"><span>预约复诊日期：</span></p>
        <input type="text" id="u238_input" name="appointmentDate"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="${archivesInfoDetail.appointmentDate }" tabindex="1" required>

          <p id="u506"><span>预约医生：</span></p>
          <input id = "doctorAppointments" type = "hidden" value = "${archivesInfoDetail.preReferral.doctorAppointments }"/>
        <select id="u508_input" name = "doctorAppointments" class = "test">
        	<option selected>${archivesInfoDetail.preReferral.doctorAppointments }</option>
        </select>

          <p id="u509"><span>出具《婚前医学检查证明》日期：</span></p>
        <input type="text" id="u511_input" name="issuedByDate"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="${archivesInfoDetail.issuedByDate }" tabindex="1" required>
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
        <!-- 特殊疾病弹出框 -->
        <div id="illAtv" style="overflow:auto" class="easyui-dialog" title="角色" closed="true">
      		<form id="special" action="" method="post">
      		<input id = "result" type = "hidden" name="resultId" value = "${archivesInfoDetail.inspection.id }" />
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
