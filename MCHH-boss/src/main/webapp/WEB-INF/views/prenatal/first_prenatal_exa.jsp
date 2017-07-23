<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<style type="text/css">
  	
  		body {
		margin:0px auto;
		}
		#title {
		position:fixed;
		left: 0px;
		top: 0px;
		width:1177px;
		line-height:44px;
		height:44px;
		z-index:9999;
		background: #FFFFFF; 
		border:1px solid;
		}
		#addOrUpdate {
		/* position:fixed;
		left: 30px;
		top: 40px; */
		/* width:1177px; */
		/* line-height:44px; */
		/* height:44px; */
		z-index:9999;
		/* background: #FFFFFF;  */
		/* border:1px solid; */
		}
		.in{
		  left:-3px;
		  top:-2px;
		}
		.ps{
		 position:absolute;
		  left:16px;
		  top:0px;
		  width:290px;
		  word-wrap:break-word;	
		}
		.ax_表格 {
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  color:#333333;
		  text-align:center;
		  line-height:normal;
		}
		.ax_单元格 {
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  color:#333333;
		  text-align:left;
		  line-height:normal;
		}
		#u2540 {
		  position:absolute;
		  left:300px;
		  top:719px;
		  width:145px;
		  height:25px;
		}
		#u2540_input {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:145px;
		  height:25px;
		  border-style:solid;border-width:1px;border-color:#C8C9CD;
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  text-decoration:none;
		  color:#333333;
		  text-align:left;
		}
		#u000 {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:346px;
		}
		#u001 {
		  position:absolute;
		  left:2px;
		  top:165px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#u002 {
		  position:absolute;
		  left:256px;
		  top:131px;
		  width:209px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#u003 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:209px;
		  white-space:nowrap;
		}
		#u004 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u005 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u006 {
		  position:absolute;
		  left:410px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		
		#u007 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u008 {
		  position:absolute;
		  left:190px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u009 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#su252 {
		  position:absolute;
		  left:0px;
		  top:9px;
		  width:161px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#su253 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:157px;
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
		  left:168px;
		  top:9px;
		  width:161px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#su277 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:157px;
		  word-wrap:break-word;
		}
		#su278 {
		  position:absolute;
		  left:337px;
		  top:9px;
		  width:161px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#su279 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:157px;
		  word-wrap:break-word;
		}
		#su280 {
		  position:absolute;
		  left:505px;
		  top:9px;
		  width:161px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#su281 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:157px;
		  word-wrap:break-word;
		}
		#su254 {
		  position:absolute;
		  left:734px;
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
		  left:860px;
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
		  top:109px;
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
		  height:611px;
		}
		#su3 {
		  position:absolute;
		  left:646px;
		  top:109px;
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
		  height:611px;
		}
		#su4 {
		  position:absolute;
		  left:328px;
		  top:109px;
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
		  height:611px;
		}
		
		
		#u00 {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:856px;
		  height:516px;
		}
		#u01 {
		  position:absolute;
		  left:2px;
		  top:250px;
		  width:852px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#u02 {
		  position:absolute;
		  left:43px;
		  top:67px;
		  width:39px;
		  height:16px;
		}
		#u03 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:39px;
		  white-space:nowrap;
		}
		#u04 {
		  position:absolute;
		  left:94px;
		  top:63px;
		  width:167px;
		  height:24px;
		}
		#u04_input {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:167px;
		  height:24px;
		  background-image:none;
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  text-decoration:none;
		  color:#333333;
		}
		#u05 {
		  position:absolute;
		  left:35px;
		  top:386px;
		  width:795px;
		  height:128px;
		}
		#u05_input {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:795px;
		  height:128px;
		  background-image:none;
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  text-decoration:none;
		  color:#333333;
		  text-align:left;
		}
		#u06 {
		  position:absolute;
		  left:35px;
		  top:139px;
		  width:342px;
		  height:104px;
		}
		#u06_input {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:342px;
		  height:104px;
		  background-image:none;
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  text-decoration:none;
		  color:#333333;
		  text-align:left;
		}
		#u07 {
		  position:absolute;
		  left:34px;
		  top:273px;
		  width:798px;
		  height:63px;
		}
		#u08 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:64px;
		  height:24px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		  text-align:center;
		}
		#u09 {
		  position:absolute;
		  left:2px;
		  top:4px;
		  width:60px;
		  word-wrap:break-word;
		}
		#u010 {
		  position:absolute;
		  left:64px;
		  top:0px;
		  width:372px;
		  height:24px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		  text-align:center;
		}
		#u011 {
		  position:absolute;
		  left:2px;
		  top:4px;
		  width:368px;
		  word-wrap:break-word;
		}
		#u012 {
		  position:absolute;
		  left:436px;
		  top:0px;
		  width:357px;
		  height:24px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		  text-align:center;
		}
		#u013 {
		  position:absolute;
		  left:2px;
		  top:4px;
		  width:353px;
		  word-wrap:break-word;
		}
		#u014 {
		  position:absolute;
		  left:0px;
		  top:24px;
		  width:64px;
		  height:34px;
		  text-align:center;
		}
		#u015 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:60px;
		  word-wrap:break-word;
		}
		#u016 {
		  position:absolute;
		  left:64px;
		  top:24px;
		  width:372px;
		  height:34px;
		  text-align:center;
		}
		#u017 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:368px;
		  word-wrap:break-word;
		}
		#u018 {
		  position:absolute;
		  left:436px;
		  top:24px;
		  width:357px;
		  height:34px;
		  text-align:center;
		}
		#u019 {
		  position:absolute;
		  left:2px;
		  top:9px;
		  width:353px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#u020 {
		  position:absolute;
		  left:480px;
		  top:303px;
		  width:100px;
		  height:15px;
		}
		#u021 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		.ux{
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#u020_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#u022 {
		  position:absolute;
		  left:575px;
		  top:303px;
		  width:212px;
		  height:15px;
		}
		#u023 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:194px;
		  word-wrap:break-word;
		}
		#u022_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#u024 {
		  position:absolute;
		  left:487px;
		  top:138px;
		  width:343px;
		  height:104px;
		}
		#u024_input {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:343px;
		  height:104px;
		  background-image:none;
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  text-decoration:none;
		  color:#333333;
		  text-align:left;
		}
		#u025 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u026 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u027 {
		  position:absolute;
		  left:427px;
		  top:115px;
		  width:10px;
		  height:128px;
		}
		#u027_line {
		  position:absolute;
		  left:5px;
		  top:0px;
		  width:1px;
		  height:128px;
		}
		#u028 {
		  position:absolute;
		  left:34px;
		  top:361px;
		  width:797px;
		  height:26px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u029 {
		  position:absolute;
		  left:2px;
		  top:6px;
		  width:793px;
		  word-wrap:break-word;
		}
		#u030 {
		  position:absolute;
		  left:486px;
		  top:113px;
		  width:345px;
		  height:26px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u031 {
		  position:absolute;
		  left:2px;
		  top:6px;
		  width:341px;
		  word-wrap:break-word;
		}
		#u032 {
		  position:absolute;
		  left:34px;
		  top:114px;
		  width:344px;
		  height:26px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u033 {
		  position:absolute;
		  left:2px;
		  top:6px;
		  width:340px;
		  word-wrap:break-word;
		}
		#u034 {
		  position:absolute;
		  left:597px;
		  top:563px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u035 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u036 {
		  position:absolute;
		  left:733px;
		  top:563px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u037 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
				
	</style>
    <title>第1次产前随访记录表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/first_prenatalExa_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
      
    	$(function(){
    		
    		for(var sel = 0; sel < 36; sel ++){
    			$("select")[sel].selectedIndex = -1;
    		}
    		
    		//$("#u455_input")[0].selectedIndex = -1;
    		
    		var x = 0;
    		
    		//高危项选择
    		$("#u431_input").click(function(){
    			
    			var hignRiskUrl = "${ctx}/com/config/highrisk/allHighrisk";
    			
    			$("#guding").show();
    			$("#su252").css("background-color","#EE5F45");
    			$("#su276").css("background-color","#999999");
    			$("#su278").css("background-color","#999999");
    			$("#su280").css("background-color","#999999");
    			$("#renshen").hide();
    			$("#benci").hide();
    			$("#shehui").hide();
    			showDialog_("异常选项","addOrUpdate","bigHigh",false);
    			
    			if(x == 1){
    				return false;
    			}
    			$.ajax({
    				url:hignRiskUrl,
    				type:"GET",
    				success:function(data){
    					x ++;
     					var gudiFive = "" ;
     					var gudiTen = "" ;
     					var gudiTw = "" ;
     					var renshenFive = "";
     					var renshenTen = "";
     					var renshenTw = "";
     					var benciFive = "";
     					var benciTen = "";
     					var benciTw = "";
     					var shehuiFive = "";
     					var shehuiTen = "";
     					var shehuiTw = "";
     					var a = 0;
     					var b = 0;
     					var c = 0;
     					var d = 0;
     					var e = 0;
     					var d = 0; 
     					var e = 0;
     					var f = 0;
     					var g = 0;
     					var h = 0;
     					var j = 0;
     					var k = 0;
     					var l = 0;
     					var m = 0;
     					for(var i = 0;i<data.list.length;i++){
     						
     						if(data.list[i].status == "1"){
     							if(data.list[i].score == "5"){
     								
     								gudiFive += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+a*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
     								
	     							a += 1;
     							}
								if(data.list[i].score == "10"){
     								
	     							gudiTen += "<div class='gu10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+b*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							
	     							b += 1;
     							}
								if(data.list[i].score == "20"){
     								
     								gudiTw += "<div class='gu20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+c*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
     								
	     							c += 1;
     							}
     						}
     						if(data.list[i].status=="0"){
     							if(data.list[i].score == "5"){
	     							
     								renshenFive += "<div class='ren5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+d*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							
	     							d += 1;
     							}
								if(data.list[i].score == "10"){
     								
	     							renshenTen += "<div class='ren10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+e*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							
	     							e += 1;
     							}
								if(data.list[i].score == "20"){
     								
	     							renshenTw += "<div class='ren20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+f*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							
	     							f += 1;
     							}
     						}
     						if(data.list[i].status=="2"){
     							if(data.list[i].score == "5"){
	     							
     								benciFive += "<div class='ben5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+g*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							g += 1;
     							}
								if(data.list[i].score == "10"){
     								
	     							benciTen += "<div class='ben10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+h*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							h += 1;
     							}
								if(data.list[i].score == "20"){
     								
	     							benciTw += "<div class='ben20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+j*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							j += 1;
     							}
     						}
     						if(data.list[i].status=="3"){
     							if(data.list[i].score == "5"){
	     							
     								shehuiFive += "<div class='she5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+k*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							k += 1;
     							}
								if(data.list[i].score == "10"){
     								
	     							shehuiTen += "<div class='she10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+l*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							l += 1;
     							}
								if(data.list[i].score == "20"){
     								
	     							shehuiTw += "<div class='she20' id=gu'"+j+"' style='position:absolute;left:660px;top:"+(121+m*30)+"px;vertical-align: baseline;'><label>"
	     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
	     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
	     							+"</div>";
	     							m += 1;
     							}
     						}
     					}
     					$("#guding").html(gudiFive+gudiTen+gudiTw);
     					$("#renshen").html(renshenFive+renshenTen+renshenTw);
     					$("#benci").html(benciFive+benciTen+benciTw);
     					$("#shehui").html(shehuiFive+shehuiTen+shehuiTw);
     					
	    			}
	    		});
    			
    	});
    		
    		$("#su253").click(function(){
    			$("#guding").show();
    			$("#su252").css("background-color","#EE5F45");
    			$("#su276").css("background-color","#999999");
    			$("#su278").css("background-color","#999999");
    			$("#su280").css("background-color","#999999");
    			$("#renshen").hide();
    			$("#benci").hide();
    			$("#shehui").hide();
    		});
    		$("#su277").click(function(){
    			$("#guding").hide();
    			$("#su252").css("background-color","#999999");
    			$("#su276").css("background-color","#EE5F45");
    			$("#su278").css("background-color","#999999");
    			$("#su280").css("background-color","#999999");
    			$("#renshen").show();
    			$("#benci").hide();
    			$("#shehui").hide();
    			
    		});
    		$("#su279").click(function(){
    			$("#guding").hide();
    			$("#su252").css("background-color","#999999");
    			$("#su276").css("background-color","#999999");
    			$("#su278").css("background-color","#EE5F45");
    			$("#su280").css("background-color","#999999");
    			$("#renshen").hide();
    			$("#benci").show();
    			$("#shehui").hide();
    			
    		});
    		$("#su281").click(function(){
    			$("#guding").hide();
    			$("#su252").css("background-color","#999999");
    			$("#su276").css("background-color","#999999");
    			$("#su278").css("background-color","#999999");
    			$("#su280").css("background-color","#EE5F45");
    			$("#renshen").hide();
    			$("#benci").hide();
    			$("#shehui").show();
    			
    		});
    		
    		$("#su257").click(function(){
     			$("#addOrUpdate").window("close");
     		});
    		
    		$("#u167_input").click(function(){
    			
    			none("u167_input","u73_input");
    		});
    		
			$("#u198_input").click(function(){
    			
    			none("u198_input","u197_input");
    		});
			
			$("#u201_input").click(function(){
    			
    			none("u201_input","u200_input");
    		});

			$("#u409_input").click(function(){
				
				none("u409_input","u408_input");
			});
    		
			//总体评估有异常和无异常显示的和不显示的
			window.onload = function(){
				var radios = $("input[name='evaluate']");
				for (var i = 0; i < radios.length; i++) {
					radios[i].onclick = function(){
						var status = $("input[name='evaluate']:checked").val();
						if(status == 0){
							$("#u431").css("display","none");
							$("#u481").css("display","none");
							$("#u17").css({color:"#000000","font-weight":"100"});
							$("#u19").css({color:"#000000","font-weight":"100"});
							
						}else{
							$("#u431").css("display","block");
							var top = $("#u429")[0].offsetTop;
							$("#u431")[0].style.top = (top-5)+"px";
							$("#u481").css("display","block");
							$("#u17").css({color:"#EE5F45","font-weight":"700"});
							$("#u19").css({color:"#EE5F45","font-weight":"700"});
						}
					};
				}
			};
			
			$(".test").change(function(){
				var idClass = $(this).attr("id");
				var testValue = $(this).val();
				if(testValue==0){
					$("."+idClass).hide();
				}else{
					$("."+idClass).show();
				}
			});
			$(".test1").change(function(){
				var idClass = $(this).attr("id");
				var testValue = $(this).val();
				if(testValue==1){
					$("."+idClass).show();
				}else{
					$("."+idClass).hide();
				}
			});
			
			$("#u420_input").change(function(){
				var val = $(this).val();
				if(val==2){
					$("#u42400_input").show();
				}else{
					$("#u42400_input").hide();
				}
			});
			
			$("#u354_input").change(function(){
				var val = $(this).val();
				if(val==2){
					$("#u419_input").show();
				}else{
					$("#u419_input").hide();
				}
			});
			var ba = 0;
			//保存
			$("#u478").click(function(){
				
				var evaluate = $("input[name='evaluate']:checked").val();
				
				if(evaluate == "1"){
					if(za == 0){
						alert("请先保存专案管理!");
						return false;
					}
				}
				
				var addUrl = "${ctx}/prenatal/addPrenatal"
				if(ba == 1){
					return false;
				}
				$("#form").attr("action",addUrl);
				ba ++;
				$("#form").submit();
			});
			
			/* $("#u63_input").change(function(){
				
				var tag = /^[0-9]{1}$|^[0-9]{2}$/;
				var week = this.value;
				if(!tag.test(week)){
					alert("只能输入一位或两位正整数！");
					return false;
				}
			});
			
			$("#u74_input").change(function(){
				
				var tag = /^[0-9]{1}$/;
				var day = this.value;
				if(!tag.test(day)){
					alert("只能输入一位少于7的正整数!");
				}
			}); */
			
			$("#u219_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var height = this.value;
				if(!tag.test(height)){
					alert("只能输入整数或小数!");
				}
			});
			$("#u224_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var weight = this.value;
				if(!tag.test(weight)){
					alert("只能输入整数或小数!");
				}
			});
			$("#u227_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var h = this.value;
				if(!tag.test(h)){
					alert("只能输入两位或者三位正整数!");
				}
			});
			$("#u230_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var l = this.value;
				if(!tag.test(l)){
					alert("只能输入两位或者三位正整数!");
				}
			});
			$("#u358_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入整数或小数!");
				}
				if(b < 110){
					$("#u266_").html("↓");
				}else if(b > 150){
					$("#u266_").html("↑");
				}else{
					$("#u266_").html("");
				}
			});
			$("#u359_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入整数或小数!");
				}
				if(b < 4.0){
					$("#u350_").html("↓");
				}else if(b > 10.0){
					$("#u350_").html("↑");
				}else{
					$("#u350_").html("");
				}
			});
			$("#u360_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入正整数!");
				}
				if(b < 100){
					$("#u272_").html("↓");
				}else if(b > 300){
					$("#u272_").html("↑");
				}else{
					$("#u272_").html("");
				}
			});
			$("#u377_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
				}
			});
			$("#u378_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
				}
			});
			$("#u379_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
				}
			});
			$("#u380_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
				}
			});
			$("#u390_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
				}
			});
			$("#u401_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
				}
			});
			$("#u402_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
				}
			});
			$("#u403_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
					return false;
				}
				if(b < 38.0){
					$("#u284_").html("↓");
				}else if(b > 53.0){
					$("#u284_").html("↑");
				}else{
					$("#u284_").html("");
				}
			});
			$("#u404_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
					return;
				}
				if(b < 3.42){
					$("#u286_").html("↓");
				}else if(b > 20.50){
					$("#u286_").html("↑");
				}else{
					$("#u286_").html("");
				}
			});
			$("#u405_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
					return;
				}
				/* if(b < 38.0){
					$("#u284_").html("↓");
				}else if(b > 53.0){
					$("#u284_").html("↑");
				} */
			});
			$("#u406_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
					return;
				}
				if(b < 35.0){
					$("#u294_").html("↓");
				}else if(b > 80.0){
					$("#u294_").html("↑");
				}else{
					$("#u294_").html("");
				}
			});
			$("#u407_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字！");
					return;
				}
				/* if(b < 38.0){
					$("#u284_").html("↓");
				}else if(b > 53.0){
					$("#u284_").html("↑");
				} */
			});
			
			var finis = 0;
			//完成
			$("#u480").click(function(){
				
				if(finis != 0){
					//alert("请勿重复点击完成!");
					return false;
				}
				/* var week = $("#u63_input").val();
				var tag = /^[0-9]{1}$|^[0-9]{2}$/;
				if(week == "" || week == null){
					alert("请输入孕周(周)!");
					return false;
				}
				if(!tag.test(week)){
					alert("请输入正确的孕周(周)！");
					return false;
				}
				var day = $("#u74_input").val();
				var tag1 = /^[0-9]{1}$/;
				if(day == "" || day == null){
					alert("请输入孕周(天)!");
					return false;
				}
				if(!tag1.test(day)){
					alert("请输入正确的孕周(天)!");
					return false;
				} */
				/* var lastMess = $("#u75_input").val();
				if(lastMess == "" || lastMess == null){
					alert("请选择末次月经时间!");
					return false;
				} */
				var num1 = $("#u48_input").val();
				if(num1 == "" || num1 == null){
					alert("请选择孕次！");
					return false;
				}
				var num2 = $("#u68_input").val();
				if(num2 == "" || num2 == null){
					alert("请选择产次！");
					return false;
				}
				var num3 = $("#u51_input").val();
				if(num3 == "" || num3 == null){
					alert("请选择阴道分娩次数！");
					return false;
				}
				var num4 = $("#u52_input").val();
				if(num4 == "" || num4 == null){
					alert("请选择刨宫产次数！");
					return false;
				}
				var num5 = $("#u78_input").val();
				if(num5 == "" || num5 == null){
					alert("请选择早产次数！");
					return false;
				}
				var num6 = $("#u87_input").val();
				if(num6 == "" || num6 == null){
					alert("请选择自然流产次数！");
					return false;
				}
				var num7 = $("#u81_input").val();
				if(num7 == "" || num7 == null){
					alert("请选择人流次数！");
					return false;
				}
				var num8 = $("#u82_input").val();
				if(num8 == "" || num8 == null){
					alert("请选择药流次数！");
					return false;
				}
				var num9 = $("#u96_input").val();
				if(num9 == "" || num9 == null){
					alert("请选择宫外孕次数！");
					return false;
				}
				var num10 = $("#u101_input").val();
				if(num10 == "" || num10 == null){
					alert("请选择中期引产次数！");
					return false;
				}
				var num11 = $("#u116_input").val();
				if(num11 == "" || num11 == null){
					alert("请选择流产次数！");
					return false;
				}
				var num12 = $("#u110_input").val();
				if(num12 == "" || num12 == null){
					alert("请选择死胎次数！");
					return false;
				}
				var num13 = $("#u111_input").val();
				if(num13 == "" || num13 == null ){
					alert("请选择死产次数！");
					return false;
				}
				var num14 = $("#u123_input").val();
				if(num14 == "" || num14 == null){
					alert("请选择新生儿死亡次数！");
					return false;
				}
				var num15 = $("#u128_input").val();
				if(num15 == "" || num15 == null ){
					alert("请选择初生儿缺陷次数！");
					return false;
				}
				var num16 = $("#u141_input").val();
				if(num16 == "" || num16 == null ){
					alert("请选择产后出血次数！");
					return false;
				}
				var num17 = $("#u135_input").val();
				if(num17 == "" || num17 == null){
					alert("请选择双胎次数！");
					return false;
				}
				var num18 = $("#u136_input").val();
				if(num18 == "" || num18 == null){
					alert("请选择畸形次数！");
					return false;
				}
				
				var history = $("input[name='history']:checked").val();
				if(history == "" || history == null || history == undefined){
					alert("请选择既往史,没有请选无!");
					return false;
				}
				var famHistory = $("input[name='famHistory']:checked").val();
				if(famHistory == "" || famHistory == null || famHistory == undefined){
					alert("请选择家族史,没有请选无!");
					return false;
				}
				var perHistory = $("input[name='perHistory']:checked").val();
				if(perHistory == "" || perHistory == null || perHistory == undefined){
					alert("请选择个人史,没有请选无!");
					return false;
				}
				
				
				
				var operation = $("#u203_input").val();
				if(operation == "" || operation == null){
					alert("请选择妇科手术史！");
					return false;
				}
				var allergy = $("#u205_input").val();
				if(allergy == "" || allergy == null){
					alert("请选择药物过敏史！");
					return false;
				}
				var height = $("#u219_input").val();
				var tag2 = /^\d+(\.\d+)?$/;
				
				if(height == "" || height == null){
					alert("请输入身高!");
					return false;
				}
				if(!tag2.test(height)){
					alert("请输入正确的身高格式!");
					return false;
				}
				var weight = $("#u224_input").val();
				var tag3 = /^\d+(\.\d+)?$/;
				if(weight == "" || weight == null){
					alert("请输入体重!");
					return false;
				}
				if(!tag3.test(weight)){
					alert("请输入正确的体重格式!");
					return false;
				}
				var hBoold = $("#u227_input").val();
				var tag4 = /^\d+(\.\d+)?$/;
				if(hBoold == "" || hBoold == null){
					alert("请输入血压高值!");
					return false;
				}
				if(!tag4.test(hBoold)){
					alert("血压高值只能输入数字!");
					return false;
				}
				var lBoold = $("#u230_input").val();
				if(lBoold == "" || lBoold == null){
					alert("请输入血压低值!");
					return false;
				}
				if(!tag4.test(lBoold)){
					alert("血压低值只能输入数字!");
					return false;
				}
				var hert = $("#u231_input").val();
				if(hert == "" || hert == null){
					alert("请选择心脏是否有异常!");
					return false;
				}
				var pee = $("#u233_input").val();
				if(pee == "" || pee == null){
					alert("请选择肺部是否有异常!");
					return false;
				}
				var outW = $("#u249_input").val();
				if(outW == "" || outW == null){
					alert("请选择外阴是否有异常!");
					return false;
				}
				var wLoad = $("#u251_input").val();
				if(wLoad == "" || wLoad == null){
					alert("请选择阴道是否有异常!");
					return false;
				}
				var sonH = $("#u253_input").val();
				if(sonH == "" || sonH == null){
					alert("请选择子宫是否有异常!");
					return false;
				}
				var houseF = $("#u255_input").val();
				if(houseF == "" || houseF == null){
					alert("请选择宫颈是否有异常!");
					return false;
				}
				var anoth = $("#u257_input").val();
				if(anoth == "" || anoth == null){
					alert("请选择附件是否有异常!");
					return false;
				}
				var bloodWite = $("#u358_input").val();
				
				if(bloodWite == "" || bloodWite == null){
					alert("请输入血红蛋白值！");
					return false;
				}
				if(!tag4.test(bloodWite)){
					alert("血红蛋白值只能输入数字!");
					return false;
				}
				var wite = $("#u359_input").val();
				
				if(wite == "" || wite == null){
					alert("请输入白细胞数！");
					return false;
				}
				if(!tag4.test(wite)){
					alert("白细胞数只能输入数字!");
					return false;
				}
				var bloodPad = $("#u359_input").val();
				
				if(bloodPad == "" || bloodPad == null){
					alert("请输入血小板数！");
					return false;
				}
				if(!tag4.test(bloodPad)){
					alert("血小板数只能输入数字!");
					return false;
				}
				var suger = $("#u377_input").val();
				
				if(suger == "" || suger == null){
					alert("请输入尿糖值!");
					return false;
				}
				if(!tag4.test(suger)){
					alert("尿糖值只能输入数字!");
					return false;
				}
				var tong = $("#u378_input").val();
				
				if(tong == "" || tong == null){
					alert("请输入尿酮体值!");
					return false;
				}
				if(!tag4.test(tong)){
					alert("尿酮体值只能输入数字!");
					return false;
				}
				var argWhite = $("#u379_input").val();
				
				if(argWhite == "" || tong == null){
					alert("请输入尿蛋白值!");
					return false;
				}
				if(!tag4.test(argWhite)){
					alert("尿蛋白值只能输入数字!");
					return false;
				}
				var bloodHide = $("#u380_input").val();
				
				if(bloodHide == "" || bloodHide == null){
					alert("请输入尿潜血值!");
					return false;
				}
				if(!tag4.test(bloodHide)){
					alert("尿潜血值只能输入数字!");
					return false;
				}
				var bloodType =  $("#u384_input").val();
				if(bloodType == "" || bloodType == null || bloodType == undefined){
					alert("请选择血型!");
					return false;
				}
				var bloodRH =  $("#u385_input").val();
				if(bloodRH == "" || bloodRH == null || bloodType == undefined){
					alert("请选择血型RH!");
					return false;
				}
				var bloodSuger = $("#u390_input").val();
				
				if(bloodSuger == "" || bloodSuger == null){
					alert("请输入血糖值!");
					return false;
				}
				if(!tag4.test(bloodSuger)){
					alert("血糖值只能输入数字!");
					return false;
				}
				var sgpt = $("#u401_input").val();
				
				if(sgpt == "" || sgpt == null || sgpt == undefined){
					alert("请输入血清谷丙转氨酶数值!");
					return false;
				}
				if(!tag4.test(sgpt)){
					alert("血清谷丙转氨酶数只能输入数字!");
					return false;
				}
				var sgot = $("#u402_input").val();
				
				if(sgot == "" || sgot == null || sgot == undefined){
					alert("请输入血清谷草转氨酶数值!");
					return false;
				}
				if(!tag4.test(sgot)){
					alert("血清谷草转氨酶数只能输入数字!");
					return false;
				}
				var wAw = $("#u403_input").val();
				
				if(wAw == "" || wAw == null ){
					alert("请输入白蛋白值!");
					return false;
				}
				if(!tag4.test(wAw)){
					alert("白蛋白值只能输入数字!");
					return false;
				}
				var zDred = $("#u404_input").val();
				
				if(zDred == "" || zDred == null){
					alert("请输入总胆红素值！");
					return false;
				}
				if(!tag4.test(zDred)){
					alert("总胆红素值只能输入数字!");
					return false;
				}
				var jDred = $("#u405_input").val();
				
				if(jDred == "" || jDred == null){
					alert("请输入结合胆红素值！");
					return false;
				}
				if(!tag4.test(jDred)){
					alert("结合胆红素值只能输入数字!");
					return false;
				}
				var jG = $("#u406_input").val();
				
				if(jG == "" || jG == null){
					alert("请输入血清肌酐值！");
					return false;
				}
				if(!tag4.test(jG)){
					alert("血清肌酐值只能输入数字!");
					return false;
				}
				var pS = $("#u407_input").val();
				
				if(pS == "" || pS == null){
					alert("请输入血尿素氮值！");
					return false;
				}
				if(!tag4.test(pS)){
					alert("血尿素氮值只能输入数字!");
					return false;
				}
				var vaginalFluid = $("input[name='vaginalFluid']:checked").val();
				if(vaginalFluid == null || vaginalFluid == "" || vaginalFluid == undefined){
					alert("请选择阴道分泌物,没有选择未见异常!");
					return false;
				}
				var vaginalClean = $("#u351_input").val();
				if(vaginalClean == null || vaginalClean == ""){
					alert("请选择阴道清洁度!");
					return false;
				}
				var hbsag = $("input[name='hbsag']:checked").val();
				if(hbsag == null || hbsag == "" || hbsag == undefined){
					alert("请选择乙型肝炎表面抗原阴性或阳性!");
					return false;
				}
				if(hbsag == '1'){
					var hbsab = $("input[name='hbsab']:checked").val();
					if(hbsab == null || hbsab == "" || hbsab == undefined){
						alert("请选择乙型肝炎表面抗体阴性或阳性!");
						return false;
					}
					var hbcab = $("input[name='hbcab']:checked").val();
					if(hbcab == null || hbcab == "" || hbcab == undefined){
						alert("请选择乙型肝炎核心抗体阴性或阳性!");
						return false;
					}
					var hbeab = $("input[name='hbeab']:checked").val();
					if(hbeab == null || hbeab == "" || hbeab == undefined){
						alert("请选择乙型肝炎e抗体阴性或阳性!");
						return false;
					}
					var hbeag = $("input[name='hbeag']:checked").val();
					if(hbeag == null || hbeag == "" || hbeag == undefined){
						alert("请选择乙型肝炎e抗原阴性或阳性!");
						return false;
					}
				}
				var syphilisSerology = $("input[name='syphilisSerology']:checked").val();
				if(syphilisSerology == null || syphilisSerology == "" || syphilisSerology == undefined){
					alert("请选择梅毒血清学试验阴性或阳性!");
					return false;
				}
				var hivab = $("input[name='hivab']:checked").val();
				if(hivab == null || hivab == "" || hivab == undefined){
					alert("请选择HIV抗体检测阴性或阳性!");
					return false;
				}
				var bScan = $("#u420_input").val();
				if(bScan == "" || bScan == null){
					alert("请选择B超检查项!");
					return false;
				}
				var nt = $("#u354_input").val();
				if(nt == "" || nt == null){
					alert("请选择NT检查项!");
					return false;
				}
				var evaluate = $("input[name='evaluate']:checked").val();
				if(evaluate == null || evaluate == "" || evaluate == undefined){
					alert("请选择总体评估是否有异常!");
					return false;
				}
				if(evaluate == "1"){
					if(za == 0){
						alert("请先保存专案管理!");
						return false;
					}
				}
				
				var gude = $("#u436_input").val();
				gude = $.trim(gude);
				if(gude == "" || gude == null){
					alert("请输入保健指导意见!");
					return false;
				}
				var referral = $("input[name='referral']:checked").val();
				if(referral == null || referral == "" || referral == undefined){
					alert("请选择是否转诊没有选择无!");
					return false;
				}
				if(referral == 0){
					$("#u449_input").val("");
				}
				if(referral == 1){
					var reasion = $.trim($("#u449_input").val());
					if(reasion == "" || reasion == null){
						alert("请输入转诊原因！");
						return false;
					}
					var dept = $("#u452_input").val();
					if(dept == null || dept == ""){
						alert("请选择转诊机构!");
						return false;
					}
					var role = $("#u455_input").val();
					if(role == null || role == ""){
						alert("请选择转诊科室!");
						return false;
					}
				}
				var orderCheck = $("input[name='orderCheck']:checked").val();
				if(orderCheck == null || orderCheck == "" || orderCheck == undefined){
					alert("请选择是否预约下次随访!");
					return false;
				}
				if(orderCheck == 1){
					var nextDate = $("#u458_input").val();
					if(nextDate == "" || nextDate == null || nextDate == undefined){
						alert("请选择下次随访时间!");
						return false;
					}
				}
				if(orderCheck == 0){
					$("#nextFollowingDate").attr("name","nextFollowingDate");
				}
				var book = $("#u471_input").val();
				if(book == null || book == "" || book == undefined){
					alert("请选择是否使用母子健康手册!");
					return false;
				}
				var ys = $("#u472_input").val();
				if(ys == null || ys == "" || ys == undefined){
					alert("请选择是否发放叶酸");
					return false;
				}
				if(ys == 1){
					var yNum = $("#u473_input").val();
					var tag5 = /^[0-9]{1}$|^[0-9]{2}$|^[0-9]{3}$/;
					
					if(yNum == "" || yNum == null){
						alert("请输入叶酸发放数量!");
						return false;
					}
					if(!tag5.test(yNum)){
						alert("叶酸发放数只能输入数字!");
						return false;
					}
				}	
				
				var hert1 = $("#u231_input").val();
				if(hert1 != "1"){
					$("#u232_input").val("");
				}
				var pee1 = $("#u233_input").val();
				if(pee1 != "1"){
					$("#u234_input").val("");
				}
				var outYi1 = $("#u249_input").val();
				if(outYi1 != "1"){
					$("#u250_input").val("");
				}
				var yinDao1 = $("#u251_input").val();
				if(yinDao1 != "1"){
					$("#u252_input").val("");
				}
				var ziGong1 = $("#u253_input").val();
				if(ziGong1 != "1" && ziGong1 != "2"){
					$("#u254_input").val("");
				}
				var gongJing1 = $("#u255_input").val();
				if(gongJing1 != "1"){
					$("#u256_input").val("");
				}
				var fujian1 = $("#u257_input").val();
				if(fujian1 != "1"){
					$("#u258_input").val("");
				}
				
				var BChao1 = $("#u420_input").val();
				if(BChao1 != "2"){
					$("#u42400_input").val("");
				}
				var NT1 = $("#u354_input").val();
				if(NT1 != "2"){
					$("#u419_input").val("");
				}
					
				var finishUrl = "${ctx}/prenatal/finishFirstExa";
				$.ajax({
   					url:finishUrl,
   					type:"POST",
   					data:$('#form').serialize(),
   					success:function(data){
   						$("#prenatalId").val(data.prenatalId);
   		  	  			showDialog_("提示","finishTan","moremiddleOver",false);
   					}
   				});
				finis ++;
			});
			
			//点击完成后点是或者否的跳转页面
			//否
			$("#u007").click(function(){
				
				window.location.href = "${ctx}/prenatal/list";
				return ;
			});
			
			//是
			$("#u009").click(function(){
				var prenatalId = $("#prenatalId").val();
				window.location.href = "${ctx}/prenatal/printPreview?prenatalId="+prenatalId;
				return ;
			});
			
			//通过末次月经计算预产期
			//$("#u75_input").focus(function(){
				//alert("11");
				var birthUrl = "${ctx}/prenatal/birthDate";
				var lastDate = this.value;
				$.ajax({
   					url:birthUrl,
   					type:"GET",
   					data:{lastDate:lastDate},
   					success:function(data){
   						//$("#birthTime").html(data.birthDate);
   						$("#u458_input").val(data.nextCheck);
   					}
   				});
				
				//通过末次月经计算下次随访时间
				
			//});
			
			//获取高危项
			$("#su255").click(function(){
				
				var obj=document.getElementsByName('evaluateRemark'); //选择所有name="'test'"的对象，返回数组 
				//取到对象数组后，我们来循环检测它是不是被选中 
				var s=''; 
				for(var i=0; i<obj.length; i++){ 
				if(obj[i].checked) s+=obj[i].value+','; //如果选中，将value添加到变量s中 
				} 
				var checkUrl = "${ctx}/com/config/highrisk/addHighriskToJsp"
				if(s!=""){
					$.ajax({
	   					url:checkUrl,
	   					type:"POST",
	   					data:{s:s},
	   					success:function(data){
	   						$("#u43100").html("<span>"+data.str+"</span>");
	   					    $("#u05_input").val(data.directiveStr);
	   						$("#addOrUpdate").window("close");
	   					}
	   				});
				}
				
			});
			
			//通过孕周和天数选择保健指导意见
			//$("#u74_input").change(function(){
				
				var week = $("#u63_input").val();
				var day = $("#u74_input").val();
				
				/* if(week == ""){
					alert("请输入正确的孕周");
					return false;
				}
				if(day == ""){
					alert("请输入正确的天数");
					return false;
				} */
				
				/* if(week <= 24){
					var date = new Date();
					var ms = dayNumber * (1000 * 60 * 60 * 24);
			        var newDate = new Date(date.getTime() + ms);
			        return newDate;
				}
				$("#u458_input").val() */
				
				var directUrl = "${ctx}/directive/getDirectveByWeek"
				
				$.ajax({
   					url:directUrl,
   					type:"GET",
   					data:{week:week,day:day},
   					success:function(data){
   						if(data.directive != null && data.directive !="" && data.directive != undefined){
   							if(data.directive.content!=null && data.directive.content!= "" && data.directive.content!= undefined){
   								
   								$("#u436_input").val(data.directive.content);
   							}
   						}
   						
   					}
   				});
				
			//});
			
			//通过身高体重计算bmi值
			$("#u224_input").change(function(){
				
				var high = $("#u219_input").val()/100;
				if(high == ""){
					alert("请输入身高！");
				}
				var weight = $(this).val();
				
				var bmi = weight/(high*high);
				if(bmi <= 24 && bmi >= 18){
					$("#bmi").html(bmi.toFixed(2)+" 正常体质");
				}
				if(bmi <= 28 && bmi > 24){
					$("#bmi").html(bmi.toFixed(2)+" 偏重体质");
				}
				if(bmi > 28){
					$("#bmi").html(bmi.toFixed(2)+" 肥胖体质");
				}
				if(bmi < 18){
					$("#bmi").html(bmi.toFixed(2)+" 偏瘦体质");
				}
				
			});
			
			//专案管理
			$("#u482").click(function(){
				var zUrl = "${ctx}/com/config/highrisk/checkRedioHighRisk"
				
				$.ajax({
   					url:zUrl,
   					type:"GET",
   					success:function(data){
   						var str = "";
   						var cStr = "";
   						var i = 0;
   						//debugger;
   						for(; i < data.list.length; i++){
   							
   							str += "<div style='position:absolute;left:0px;top:"+(24+i*34)+"px;width:64px;"
   							+"height:34px;text-align:center;' class='ax_单元格'><p style='position:absolute;"
   							  +"left:2px;top:10px;width:60px;word-wrap:break-word;'>"
   							+"<span>"+(i+1)+"</span></p></div><div style='position:absolute;"
   							+"left:64px;top:"+(24+i*34)+"px;width:372px;height:34px;text-align:center;' class='ax_单元格'>"
   							+"<p style='position:absolute;left:2px;top:10px;width:368px;"
   							+"word-wrap:break-word;'><span>"+data.list[i].name+"</span></p></div>";
   							
   							cStr += "<div id='u020' style='position:absolute;left:480px;top:"+(303+i*34)+"px;"
   							+"width:100px;height:15px;' class='ax_复选框'><label for='u020_input"+i+"'>"
   							+"<p style='position:absolute;left:16px;top:0px;width:82px;word-wrap:break-word;'><span>未矫正  </span></p>"
   							+"</label><input class='ux' id='u020_input"+i+"' name='correct"+i+"' type='radio' value='0' checked/></div>"
   							+"<input type='hidden' name='correct_"+i+"' value='"+data.list[i].id+"'/>"
   							+"<div style='position:absolute;left:575px;top:"+(303+i*34)+"px;width:212px;height:15px;'"
   							+" class='ax_复选框'><label for='u022_input"+i+"'><p style='position:absolute;"
   							+"left:16px;top:0px;width:194px;word-wrap:break-word;'>"
   							+"<span>已矫正&nbsp; &nbsp; ${time}</span></p></label><input class='ux' id='u022_input"+i
   							+"' name='correct"+i+"' type='radio' value='1'/></div>";
   						}
						if(i > 2){
							$("#u05")[0].style.top = (386+(i-2)*30)+"px";
							$("#u034")[0].style.top = (563+(i-2)*30)+"px";
							$("#u036")[0].style.top = (563+(i-2)*30)+"px";
						}
   						$("#inner").html(str);
   						$("#checkRadio").html(cStr);
   						//$("#u05_input").val()
						showDialog_l("高危专案管理","addZhuan","moremiddle",false);
   					}
   				});
				
			});
			
			$("#u04_input").change(function(){
				
				var status = this.value;
				//alert(status);
				//正常随访 状态默认为已校正
				if(status == "1"){
					$("input[type=radio][name^=correct][value=1]").attr("checked",'checked');
				//结束分娩 状态默认为未校正
				}else if(status == "2"){
					$("input[type=radio][name^=correct][value=0]").attr("checked",'checked');
				//继续监护 状态默认为未矫正
				}else if(status == "0"){
					$("input[type=radio][name^=correct][value=0]").attr("checked",'checked');
				}
				
			});
			
			var za = 0;
			//专案记录弹出页保存
			$("#u037").click(function(){
				var status = $("#u04_input").val();
				if(status == "" || status == null){
					alert("请选择转归状态!");
					return false;
				}
				var checkResult = $("#u06_input").val();
				if(checkResult == "" || checkResult == null || checkResult == undefined){
					alert("请输入本次检查结果!");
					return false;
				}
				var ifResult = $("#u024_input").val();
				if(ifResult == "" || ifResult == null || ifResult == undefined){
					alert("请输入诊断结果!");
					return false;
				}
				var highRiskGude = $("#u05_input").val();
				if(highRiskGude == "" || highRiskGude == null || highRiskGude == undefined){
					alert("请输入高危指导意见!");
					return false;
				}
				
				var saveUrl = "${ctx}/prenatal/saveProjectManager"
				
				$.ajax({
					url:saveUrl,
					type:"POST",
					data:$('#saveCheck').serialize(),
					success:function(data){
						$("#highRiskId").val(data.highRiskId);
					}
				});
				za ++;
				$("#addZhuan").window("close");
				
			});
			
			//转诊点击无
			$("#u443_input").click(function(){
				$("#u449_input")[0].readOnly = true;
				$("#u452_input")[0].selectedIndex = -1;
				$("#u452_input")[0].disabled = true;
				$("#u455_input")[0].selectedIndex = -1;
				$("#u455_input")[0].disabled = true;
			});
			//转诊点击有
			$("#u445_input").click(function(){
				$("#u449_input")[0].readOnly = false;
				$("#u452_input")[0].disabled = false;
				$("#u455_input")[0].disabled = false;
			});
			
			//既往史点击约束
			$("input[name^='history']").click(function(){
		        
		        if($("#u155_input").attr("checked")){
		        	
		        	$("#u157_input").attr("checked",false);
		        	$("#u159_input").attr("checked",false);
		        	$("#u189_input").attr("checked",false);
		        	$("#u161_input").attr("checked",false);
		        	$("#u163_input").attr("checked",false);
		        	$("#u165_input").attr("checked",false);
		        	$("#u167_input").attr("checked",false);
		        	$("#u73_input").hide();
		        	$("#u73_input").val("");
		        }
		    });
			//家庭史
			$("input[name^='famHistory']").click(function(){
		        
		        if($("#u191_input").attr("checked")){
		        	
		        	$("#u171_input").attr("checked",false);
		        	$("#u489_input").hide();
		        	$("#u489_input").val("");
		        	$("#u173_input").attr("checked",false);
		        	$("#u490_input").hide();
		        	$("#u490_input").val("");
		        	$("#u198_input").attr("checked",false);
		        	$("#u197_input").hide();
		        	$("#u197_input").val("");
		        	
		        }else{
		        	$("#u489_input").show();
		        	$("#u490_input").show();
		        }
		    });
			//个人史
			$("input[name^='perHistory']").click(function(){
		        
		        if($("#u193_input").attr("checked")){
		        	
		        	$("#u175_input").attr("checked",false);
		        	$("#u177_input").attr("checked",false);
		        	$("#u179_input").attr("checked",false);
		        	$("#u181_input").attr("checked",false);
		        	$("#u183_input").attr("checked",false);
		        	$("#u201_input").attr("checked",false);
		        	$("#u200_input").hide();
		        	$("#u200_input").val("");
		        }
		    });
			//阴道分泌物
			$("input[name^='vaginalFluid']").click(function(){
		        
		        if($("#u301_input").attr("checked")){
		        	
		        	$("#u303_input").attr("checked",false);
		        	$("#u305_input").attr("checked",false);
		        	$("#u409_input").attr("checked",false);
		        	$("#u408_input").hide();
		        	$("#u408_input").val("");
		        }
		    });
			$("input[name^='evaluate']").click(function(){
				
				if($("#u427_input").attr("checked")){
					$("#u43100").html("");
					var radios = $("input[name='evaluateRemark']");
					for (var i = 0; i < radios.length; i++) {
						$("input[name='evaluateRemark']")[i].checked=false;
					}
				}
			});
			
			$("#u463_input").click(function(){
				
				$("#u458_input")[0].disabled = true;
				
			});
			$("#u461_input").click(function(){
				
				$("#u458_input")[0].disabled = false;
				
			});
			
			
			$("#u48_input").change(function(){
				var yunNum = this.value;
				var chanNum = $("#u68_input").val();
				
				if(yunNum == 0 && chanNum == 0){
					$("#u51_input")[0].selectedIndex = 0;
					$("#u52_input")[0].selectedIndex = 0;
				}else{
					$("#u51_input")[0].selectedIndex = -1;
					$("#u52_input")[0].selectedIndex = -1;
				}
				
			});
			$("#u68_input").change(function(){
				var yunNum = this.value;
				var chanNum = $("#u48_input").val();
				
				if(yunNum == 0 && chanNum == 0){
					$("#u51_input")[0].selectedIndex = 0;
					$("#u52_input")[0].selectedIndex = 0;
				}else{
					$("#u51_input")[0].selectedIndex = -1;
					$("#u52_input")[0].selectedIndex = -1;
				}
				
			});
			
			//子宫检查
			$("#u253_input").change(function(){
				var val = this.value;
				//debugger;
				if(val == "1"){
					$("#u254_input").val("");
					$("#u254_input").show();
				}else if(val == "2"){
					$("#u254_input").val("");
					$("#u254_input").show();
				}else{
					$("#u254_input").val("");
					$("#u254_input").hide();
				}
			});
			
			//通过末次月经和检查时间算孕周
			$("#checkTime").blur(function(){
				var lastMenses = $("#u75_input").val();
				var checkTime = $("#checkTime").val();
				getWeek(lastMenses,checkTime,'u63_input','u74_input');
			});
    	});
    	
    	function getWeek(lastMenses,checkTime,weekId,dayId){
    		var a = checkTime.substr(0,4);
    		var b = checkTime.substr(4,2);
    		var c = checkTime.substr(6,2);
    		var s = a+"/"+b+"/"+c;
    		var checkDate = Date.parse(new Date(s));
    		var a1 = lastMenses.substr(0,4);
    		var b1 = lastMenses.substr(4,2);
    		var c1 = lastMenses.substr(6,2);
    		var s1 = a1+"/"+b1+"/"+c1;
    		var lastDate = Date.parse(new Date(s1));
    		var allDay = Math.abs(parseInt((checkDate - lastDate)/(1000*3600*24)));
    		var week = parseInt(allDay/7);
    		var day = allDay % 7;
    		$("#"+weekId).val(week);
    		$("#"+dayId).val(day);
    		$("#week").html(week);
    		$("#day").html(day);
    		var directChangeUrl = "${ctx}/directive/getDirectveByWeek";
    		$.ajax({
				url:directChangeUrl,
				type:"GET",
				data:{week:week,day:day},
				success:function(data){
					if(data.directive != null && data.directive !="" && data.directive != undefined){
						if(data.directive.content!=null && data.directive.content!= "" && data.directive.content!= undefined){
							
							$("#u436_input").val(data.directive.content);
						}
					}
					
				}
			});
    	}
    	
    	function showDialog_l(title,divId,type,isReloadParent){
    		dialog_div_id = divId;
    		var ie6Flag = false;
    		if($.browser.msie){
    			if($.browser.version == '6.0'){
    				ie6Flag = true;
    			}
    		}
    		var defaulttop=10;
    		var defaultleft;
    		var defaultWith = 500;
    		var defaultHeight = 300;
    		
    		if(type==="moremiddle"){
    			defaulttop="40%";
    			defaultleft
    			defaultWith = 870;
    			defaultHeight = 660;
    			dialog_excend_id_ = 'moremiddle';
    		}    		
    		$('#'+dialog_div_id).dialog({
    			top:defaulttop,
    			left:defaultleft,
    			title:title,
    			width:defaultWith,
    			height:defaultHeight,
    			draggable:true, //定义是否可以拖动
                //collapsible:true, //定义是否显示可折叠按钮
    			modal:true, 
    			resizable:true,  //定义是否可以bianj
    			//minimizable:true, //
    			onBeforeClose:function(){
    				if(isReloadParent === true){
    					reloadList();
    				}
    			}
    		});
    		
    		$('#'+dialog_div_id).dialog('open');
    		if(ie6Flag){
    			//IE6bug
    			ie6bug.maskSelect();
    		}
    	}
    		
			
    	function none(sid,iid){
			
			if($("#"+sid).attr("checked")){
	            $("#"+iid).css({"display":"block"});
	        }else{
	            $("#"+iid).css({"display":"none"});
	        }
		}
    	function only(){
    		if($("#u472_input").val()=="0"){
    			$("#u473_input").val("0");
    			$("#u473_input").attr("readonly",true);
    		}else{
    			$("#u473_input").val("");
    			$("#u473_input").attr("readonly",false);
    		}
    	};
    	/**
    	 * @author dingjh
    	 */
    	     /** 展开和收起 *
    		 *divName 要操作层的name
    		 *textId 变换文字的元素ID
    		 *num 操作的层数量
    		 */

    		 function AutoFold(divName,textId,num){
    				var operateDiv=document.getElementsByName(divName);
    				var textDoc=document.getElementById(textId);
    				var operateDivNum = divName.substring(7,divName.length);//获取当前操作层的层号
    				
    				var showStatus=operateDiv[0].style.visibility;
    				var changeHeight=0;
    				if(showStatus=='hidden'){
    					//归位在展示，如果不归位，由于上移的关系，展示出来后的位置会偏上
    					
    					operateDiv[0].style.visibility='';
    					textDoc.innerHTML="收起";

    					var d=document.getElementsByName("foldDiv"+(parseInt(operateDivNum)-1));
    					var aa=operateDiv[0].offsetTop;//移动前top值
    					operateDiv[0].style.top = (d[0].offsetTop+d[0].offsetHeight)+'px';
    					var bb=operateDiv[0].offsetTop;//移动后top值
    	
    					 var divList=operateDiv[0].getElementsByTagName("div");
    					 for(var j=0;j<divList.length; j++){
    						 divList[j].style.top=(divList[j].offsetTop+(bb-aa))+'px';
    					 }

    					changeHeight=operateDiv[0].offsetHeight;
    				}else{
    					changeHeight=0-operateDiv[0].offsetHeight;
    					operateDiv[0].style.visibility='hidden';
    					textDoc.innerHTML="展开";
    				}

    				for (var i=parseInt(operateDivNum)+1;i<=num;i++)
    				{
    					var changeTopDiv=document.getElementsByName("foldDiv"+i);
    					changeTopDiv[0].style.top=(changeTopDiv[0].offsetTop+changeHeight)+'px';
    					 var divList=changeTopDiv[0].getElementsByTagName("div");
    					 for(var j=0;j<divList.length; j++){
    						 divList[j].style.top=(divList[j].offsetTop+changeHeight)+'px';
    					 }
    					
    				}
    			}
    	
    </script>
  </head>
  <body style="background-color: #FFFFFF">
    <form id="form" action="" method="post">
		<div id="title" class="ax_形状" style="background-color: #FFFFFF;border: 1px solid #CCCCCC;">
        	
       		<input type="hidden" name="nomal" value="${nomal }"/>
        	
            <div id="u475" class="ax_形状" style="background-color:#EE5F45">
       		  <p id="u476"><span>第1次产前随访</span></p>
      		</div>
            
            <div id="u481" class="ax_形状" style="background-color:#E9854F;display: none">
          		<p id="u482" style="cursor:pointer;"><span>专案管理</span></p>
        	</div>
            <c:if test="${nomal == '1' }">
	            <div id="u477" class="ax_形状" style="background-color:#009DD9">
	          		<p id="u478" style="cursor:pointer"><span>保存</span></p>
	      		</div>
            </c:if>
            <div id="u479" class="ax_形状" style="background-color:#56BB4D">
          		<p id="u480" style="cursor:pointer"><span>完成</span></p>
      		</div>
        
        </div>
        
        <div id="">
        	
            <div id="u32" class="ax_文本段落">
          		<p id="u33"><span>检查医院：${operator.department }</span></p>
      		</div>
            
            <div id="u34" class="ax_文本段落">
          		<p id="u35"><span>检查医生：${operator.realName }</span></p>
      		</div>
            
            <div id="u36" class="ax_文本段落">
          		<p id="u37"><span>转诊状态：本院</span></p>
      		</div>
            
            <div id="u0" class="ax_形状">
          		<p id="u1"><span>&nbsp;</span></p>
      		</div>
        
        </div>
        
        <div id="u4" class="ax_形状" style="background-color:#009DD9">
          <p id="u5"><span>个 人 基 本 信 息</span></p>
      	</div>
        <div id="u6" class="ax_文本段落">
          <p id="u7"><span></span></p>
      	</div>
        <div id="baseConfig">
        	
            <div id="u16" class="ax_文本段落">
       		  <p id="u17"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name } </span></p>
      		</div>
            <div id="u18" class="ax_文本段落">
            <input type="hidden" name="archivesCode" value="${archives.archivesCode }"/>
       		  <p id="u19"><span>档案编号：${archives.archivesCode }</span></p>
      		</div>
            <div id="u30" class="ax_文本段落">
            	<input type="hidden" name="ct" value="${time }"/>
          		<p id="u31"><span>检查日期：
          		<c:if test="${nomal == '1' }">
          		<%=new SimpleDateFormat("yyyyMMdd").format(new Date()) %>
          		<input type="hidden" id="checkTime" name="checkDate" 
        		style="color:#333333;cursor:pointer;height: 20px;width: 75px;left: 62px;top: -3px;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        		class="" value="<%=new SimpleDateFormat("yyyyMMdd").format(new Date()) %>" tabindex="1" required>
        		</c:if>
          		<c:if test="${nomal == '0' }">
          		<input type="text" id="checkTime" name="checkDate" 
        		style="color:#333333;cursor:pointer;height: 20px;width: 75px;left: 62px;top: -3px;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        		class="" value="<%=new SimpleDateFormat("yyyyMMdd").format(new Date()) %>" tabindex="1" required>
        		</c:if>
          		<%-- <input type="text" id="u73_input" name="birthday" 
        style="color:#333333;cursor:pointer;height: 20px;width: 75px;left: 62px;top: -3px;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="" value="<%=new SimpleDateFormat("yyyyMMdd").format(new Date()) %>" tabindex="1" required> --%>
        		</span></p>
      		</div>
            
            <div id="u8" class="ax_文本段落">
       		  <p id="u9"><span>出生日期：${birth }</span></p>
      		</div>
            <div id="u20" class="ax_文本段落">
          		<p id="u21"><span>孕妇年龄：${age }</span></p>
      		</div>
            <div id="u10" class="ax_文本段落">
          		<p id="u11"><span>联系电话：${archives.telephone }</span></p>
      		</div>
            
            <div id="u22" class="ax_文本段落">
       		  <p id="u23"><span>丈夫姓名：${archives.manName }</span></p>
      		</div>
            <div id="u24" class="ax_文本段落">
          		<p id="u25"><span>丈夫年龄：${manAge }</span></p>
      		</div>
            <div id="u26" class="ax_文本段落">
          		<p id="u27"><span>丈夫电话：${archives.manTele }</span></p>
      		</div>
        
        </div>
        
        <div id="u38" name="foldDiv1" onclick="AutoFold('foldDiv2','u41',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u39"><span>孕 产 信 息</span></p>
          <p id="u41" style="left: 1126px;top: 5px;"><span>收起</span></p>
        </div>
        <input type="hidden" name="birthArchiveId" value="${birthArchives.id }"/>
        <div id="" name="foldDiv2" style="height: 329px">
        	
            <div id="u61" class="ax_文本段落">
       		  <p id="u62"><span>孕周：</span></p>
          	</div>
          	<div id="u63" class="ax_文本框"><p style="position: absolute;top: 6px;" id="week">${w }</p>
          		<input id="u63_input" name="pregnancyWeeks" type="hidden" value="${w }"/>
          	</div>
          	<div id="u64" class="ax_文本段落">
           	  <p id="u65"><span>周</span></p>
          	</div>
          	<div id="u74" class="ax_文本框"><p style="position: absolute;top: 6px;" id="day">${d }</p>
            	<input id="u74_input" name="pregnancyDays" type="hidden" value="${d }"/>
            </div>
          	<div id="u66" class="ax_文本段落">
           	  <p id="u67"><span>天</span></p>
          	</div>
            
            <div id="u42" class="ax_文本段落">
       		  <p id="u43"><span>末次月经：</span></p>
      		</div>
            <div id="u75" class="ax_下拉列表框"><p style="position: absolute;top: 6px;"><fmt:formatDate value="${birthArchives.lastMenses }" pattern="yyyy-MM-dd"/></p>
        		<input type="hidden" id="u75_input" name="lastMenses" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="<fmt:formatDate value="${birthArchives.lastMenses }" pattern="yyyyMMdd"/>" tabindex="1" required>
      		</div>
            
            <div id="u44" class="ax_文本段落">
          		<p id="u45"><span>预产期： </span><span id="birthTime"><fmt:formatDate value="${birthArchives.predictDate }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u46" class="ax_文本段落">
       		  <p id="u47"><span>孕次：</span></p>
      		</div>
            <div id="u48" class="ax_下拉列表框">
        		<select id="u48_input" name="pregnancyNum">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
        		</select>
      		</div>
            <div id="u71" class="ax_文本段落">
          		<p id="u72" ><span>次</span></p>
      		</div>
            
            <div id="u49" class="ax_文本段落">
          		<p id="u50"><span>产次：</span></p>
      		</div>
            <div id="u68" class="ax_下拉列表框">
        		<select id="u68_input" name="bearNum">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
        		</select>
     		</div>
            <div id="u69" class="ax_文本段落">
          		<p id="u70"><span>次</span></p>
      		</div>
            
            <div id="u53" class="ax_文本段落">
          		<p id="u54"><span>阴道分娩：</span></p>
      		</div>
            <div id="u51" class="ax_下拉列表框">
        		<select id="u51_input" name="eutociaNum">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
        		</select>
      		</div>
            <div id="u55" class="ax_文本段落">
          		<p id="u56"><span>次</span></p>
      		</div>
            
            <div id="u57" class="ax_文本段落">
          		<p id="u58"><span>剖宫产：</span></p>
      		</div>
            <div id="u52" class="ax_下拉列表框">
        		<select id="u52_input" name="cesareanNum">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
        		</select>
      		</div>
            <div id="u59" class="ax_文本段落">
          		<p id="u60"><span>次</span></p>
      		</div>
            
            <div id="u76" class="ax_文本段落">
          		<p id="u77"><span>早产：</span></p>
      		</div>
          <div id="u78" class="ax_下拉列表框">
       		<select id="u78_input" name="prebearNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>
                  <option value="8">8</option>
                  <option value="9">9</option>
                  <option value="10">10</option>
       		  </select>
       		</div>
            <div id="u90" class="ax_文本段落">
          		<p id="u91"><span>次</span></p>
      		</div>
            
            <div id="u79" class="ax_文本段落">
          		<p id="u80"><span>自然流产：</span></p>
     		</div>
            <div id="u87" class="ax_下拉列表框">
                <select id="u87_input" name="naturalAbortionNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u88" class="ax_文本段落">
          		<p id="u89"><span>次</span></p>
      		</div>
            
            <div id="u83" class="ax_文本段落">
          		<p id="u84"><span>人流：</span></p>
      		</div>
            <div id="u81" class="ax_下拉列表框">
                <select id="u81_input" name="inducedAbortionNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u92" class="ax_文本段落">
          		<p id="u93"><span>次</span></p>
      		</div>
            
            <div id="u85" class="ax_文本段落">
          		<p id="u86"><span>药流：</span></p>
      		</div>
            <div id="u82" class="ax_下拉列表框">
                <select id="u82_input" name="drugAbortionNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u94" class="ax_文本段落">
          		<p id="u95"><span>次</span></p>
      		</div>
            
            <div id="u97" class="ax_文本段落">
          		<p id="u98"><span>宫外孕：</span></p>
   		  </div>
            <div id="u96" class="ax_下拉列表框">
                <select id="u96_input" name="exfetationNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u99" class="ax_文本段落">
          		<p id="u100"><span>次</span></p>
      		</div>
            
            <div id="u102" class="ax_文本段落">
          		<p id="u103"><span>中期引产：</span></p>
      		</div>
            <div id="u101" class="ax_下拉列表框">
                <select id="u101_input" name="inducelabourNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u104" class="ax_文本段落">
          		<p id="u105"><span>次</span></p>
      		</div>
            
            <div id="u106" class="ax_文本段落">
          		<p id="u107"><span>孕产史：</span></p>
      		</div>
            
            <div id="u108" class="ax_文本段落">
       		  <p id="u109"><span>流产：</span></p>
      		</div>
            <div id="u116" class="ax_下拉列表框">
                <select id="u116_input" name="abortionNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u117" class="ax_文本段落">
          		<p id="u118"><span>次</span></p>
      		</div>
            
            <div id="u112" class="ax_文本段落">
          		<p id="u113"><span>死胎：</span></p>
      		</div>
            <div id="u110" class="ax_下拉列表框">
            	<select name="deadfetusNum" id="u110_input">
	                <option value="0">0</option>
	                <option value="1">1</option>
	                <option value="2">2</option>
	                <option value="3">3</option>
      			</select>
            </div>
            <div id="u119" class="ax_文本段落">
          		<p id="u120"><span>次</span></p>
      		</div>
            
            <div id="u114" class="ax_文本段落">
          		<p id="u115"><span>死产：</span></p>
      		</div>
            <div id="u111" class="ax_下拉列表框">
                <select id="u111_input" name="stillbirthNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u121" class="ax_文本段落">
          		<p id="u122"><span>次</span></p>
      		</div>
            
            <div id="u124" class="ax_文本段落">
          		<p id="u125"><span>新生儿死亡：</span></p>
      		</div>
            <div id="u123" class="ax_下拉列表框">
                <select id="u123_input" name="newbornDieNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u126" class="ax_文本段落">
          		<p id="u127"><span>次</span></p>
      		</div>
            
            <div id="u129" class="ax_文本段落">
          		<p id="u130"><span>出生儿缺陷：</span></p>
      		</div>
            <div id="u128" class="ax_下拉列表框">
              <select id="u128_input" name="defectNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u131" class="ax_文本段落">
          		<p id="u132"><span>次</span></p>
      		</div>
            
            <div id="u133" class="ax_文本段落">
          		<p id="u134"><span>产后出血：</span></p>
      		</div>
            <div id="u141" class="ax_下拉列表框">
                <select id="u141_input" name="bleedingNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
            </div>
            <div id="u142" class="ax_文本段落">
          		<p id="u143"><span>次</span></p>
      		</div>
            
            <div id="u137" class="ax_文本段落">
          		<p id="u138"><span>双胎：</span></p>
      		</div>
			<div id="u135" class="ax_下拉列表框">
                <select id="u135_input" name="twinsNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u144" class="ax_文本段落">
          		<p id="u145"><span>次</span></p>
      		</div>
            
            <div id="u139" class="ax_文本段落">
          		<p id="u140"><span>畸形：</span></p>
      		</div>
			<div id="u136" class="ax_下拉列表框">
                <select id="u136_input" name="deformityNum">
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
      		</div>
            <div id="u146" class="ax_文本段落">
          		<p id="u147"><span>次</span></p>
      		</div>
            
            <div id="u152" class="ax_水平线">
            	<hr id="u152_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
          	</div>
            
            <div id="u153" class="ax_文本段落">
          		<p id="u154"><span>既往史：</span></p>
      		</div>
            <div id="u155" class="ax_复选框">
                <label for="u155_input">
                    <p id="u156"><span>无</span></p>
                </label>
                <input id="u155_input" type="checkbox" name="history" value="0"/>
          	</div>
            <div id="u157" class="ax_复选框">
                <label for="u157_input">
                    <p id="u158"><span>心脏病</span></p>
                </label>
                <input id="u157_input" type="checkbox" name="history" value="1"/>
      		</div>
            <div id="u159" class="ax_复选框">
                <label for="u159_input">
                    <p id="u160" ><span>肾脏疾病</span></p>
                </label>
                <input id="u159_input" type="checkbox" name="history" value="2"/>
      		</div>
            <div id="u189" class="ax_复选框">
                <label for="u189_input">
                    <p id="u190"><span>肝脏疾病</span></p>
                </label>
                <input id="u189_input" type="checkbox" name="history" value="3"/>
      		</div>
            <div id="u161" class="ax_复选框">
                <label for="u161_input">
                    <p id="u162"><span>高血压</span></p>
                </label>
                <input id="u161_input" type="checkbox" name="history" value="4"/>
      		</div>
            <div id="u163" class="ax_复选框">
                <label for="u163_input">
                    <p id="u164"><span>贫血</span></p>
                </label>
                <input id="u163_input" type="checkbox" name="history" value="5"/>
      		</div>
            <div id="u165" class="ax_复选框">
                <label for="u165_input">
                    <p id="u166"><span>糖尿病</span></p>
                </label>
                <input id="u165_input" type="checkbox" name="history" value="6"/>
      		</div>
            <div id="u167" class="ax_复选框">
                <label for="u167_input">
                    <p id="u168"><span>其他</span></p>
                </label>
                <input id="u167_input" type="checkbox" name="history" value="7"/>
      		</div>
            <div id="u73" class="ax_文本框">
        		<input id="u73_input" style="display: none;" type="text" name="historyOthers" placeholder="其他时显示输入框" value=""/>
      		</div>
            
            <div id="u169" class="ax_文本段落">
          		<p id="u170"><span>家族史</span><span>：</span></p>
      		</div>
            <div id="u191" class="ax_复选框">
                <label for="u191_input">
                    <p id="u192"><span>无</span></p>
                </label>
                <input id="u191_input" name="famHistory" type="checkbox" value="0"/>
      		</div>
            <div id="u171" class="ax_复选框">
                <label for="u171_input">
                    <p id="u172"><span>遗传性疾病史</span></p>
                </label>
                <input id="u171_input" name="famHistory" type="checkbox" value="1"/>
      		</div>
            <div id="u489" class="ax_文本框">
        		<input id="u489_input" name="heredityRelation" type="text" placeholder="与患者的关系" value=""/>
      		</div>
            <div id="u173" class="ax_复选框">
                <label for="u173_input">
                    <p id="u174"><span>精神疾病史</span></p>
                </label>
                <input id="u173_input" name="famHistory" type="checkbox" value="2"/>
      		</div>
            <div id="u490" class="ax_文本框">
        		<input id="u490_input" name="mentalRelation" type="text" placeholder="与患者的关系" value=""/>
      		</div>
            <div id="u198" class="ax_复选框">
                <label for="u198_input">
                    <p id="u199"><span>其他</span></p>
                </label>
                <input id="u198_input" name="famHistory" type="checkbox" value="3"/>
      		</div>
            <div id="u197" class="ax_文本框">
        		<input id="u197_input" style="display: none;" type="text" name="famHistoryOthers" placeholder="其他时显示输入框" value=""/>
      		</div>
            
            <div id="u185" class="ax_文本段落">
          		<p id="u186"><span>个人史：</span></p>
      		</div>
            <div id="u193" class="ax_复选框">
                <label for="u193_input">
                    <p id="u194"><span>无</span></p>
                </label>
                <input id="u193_input" name="perHistory" type="checkbox" value="0"/>
      		</div>
            <div id="u175" class="ax_复选框">
                <label for="u175_input">
                    <p id="u176"><span>吸烟</span></p>
                </label>
                <input id="u175_input" name="perHistory" type="checkbox" value="1"/>
      		</div>
            <div id="u177" class="ax_复选框">
                <label for="u177_input">
                    <p id="u178"><span>饮酒</span></p>
                </label>
                <input id="u177_input" name="perHistory" type="checkbox" value="2"/>
      		</div>
            <div id="u179" class="ax_复选框">
                <label for="u179_input">
                    <p id="u180"><span>服用药物</span></p>
                </label>
                <input id="u179_input" name="perHistory" type="checkbox" value="3"/>
      		</div>
            <div id="u181" class="ax_复选框">
                <label for="u181_input">
                    <p id="u182"><span>接触有毒有害物质</span></p>
                </label>
                <input id="u181_input" name="perHistory" type="checkbox" value="4"/>
      		</div>
            <div id="u183" class="ax_复选框">
                <label for="u183_input">
                    <p id="u184"><span>接触放射线</span></p>
                </label>
                <input id="u183_input" name="perHistory" type="checkbox" value="5"/>
      		</div>
            <div id="u201" class="ax_复选框">
                <label for="u201_input">
                    <p id="u202"><span>其他</span></p>
                </label>
                <input id="u201_input" name="perHistory" type="checkbox" value="6"/>
      		</div>
            <div id="u200" class="ax_文本框">
        		<input id="u200_input" style="display: none;" name="perHistoryOthers" type="text" placeholder="其他时显示输入框" value=""/>
      		</div>
            
            <div id="u187" class="ax_文本段落">
          		<p id="u188"><span>妇科手术史：</span></p>
      		</div>
            <div id="u203" class="ax_下拉列表框">
                <select id="u203_input" class="test" name="operation">
                  <option value="0">无</option>
                  <option value="1">有</option>
                </select>
      		</div>
            <div id="u204" class="ax_文本框">
        		<input id="u204_input" type="text" class="u203_input" style="display: none;" name="operationRemark" placeholder="其他时显示输入框" value=""/>
      		</div>
            
            <div id="u195" class="ax_文本段落">
          		<p id="u196"><span>药物过敏史：</span></p>
      		</div>
            <div id="u205" class="ax_下拉列表框">
                <select id="u205_input" class="test" name="allergy">
                  <option value="0">无</option>
                  <option value="1">有</option>
                </select>
      		</div>
            <div id="u206" class="ax_文本框">
        		<input id="u206_input" type="text" class="u205_input" style="display: none;" name="allergyRemark" placeholder="有时显示输入框" value=""/>
      		</div>
        
        </div>
        
        <div id="u148" name="foldDiv3" onclick="AutoFold('foldDiv4','u151',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u149"><span>体 格 / 血 压 / 听 诊 检 查</span></p>
          <p id="u151" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        
        <div id="" name="foldDiv4" style="height: 78px">
        	
            <div id="u217" class="ax_文本段落">
          		<p id="u218"><span>身高：</span></p>
      		</div>
            <div id="u219" class="ax_文本框">
        		<input id="u219_input" name="height" type="text" value=""/>
      		</div>
            <div id="u220" class="ax_文本段落">
         		<p id="u221"><span>cm</span></p>
      		</div>
            
            <div id="u222" class="ax_文本段落">
          		<p id="u223"><span>体重：</span></p>
      		</div>
            <div id="u224" class="ax_文本框">
        		<input id="u224_input" name="weight" type="text" value=""/>
      		</div>
            <div id="u225" class="ax_文本段落">
          		<p id="u226"><span>kg</span></p>
      		</div>
            <div id="u207" class="ax_文本段落">
          		<p id="u208"><span>体质指数：</span><span id="bmi"></span></p>
      		</div>
            
            <div id="u209" class="ax_文本段落">
          		<p id="u210"><span>血压：</span></p>
      		</div>
            <div id="u227" class="ax_文本框">
        		<input id="u227_input" name="bloodHi" type="text" value=""/>
      		</div>
            <div id="u228" class="ax_文本段落">
          		<p id="u229"><span>/</span></p>
      		</div>
            <div id="u230" class="ax_文本框">
        		<input id="u230_input" name="bloodLow" type="text" value=""/>
      		</div>
            <div id="u211" class="ax_文本段落">
          		<p id="u212"><span>mmHg</span></p>
      		</div>
            
            <div id="u213" class="ax_文本段落">
          		<p id="u214"><span>心脏：</span></p>
      		</div>
            <div id="u231" class="ax_下拉列表框">
                <select id="u231_input" class="test" name="heart">
                  <option value="0">未见异常</option>
                  <option value="1">异常</option>
                </select>
      		</div>
            <div id="u232" class="ax_文本框">
        		<input id="u232_input" type="text" class="u231_input" style="display: none;" name="heartRemark" placeholder="异常时显示输入框" value=""/>
      		</div>
            
            <div id="u215" class="ax_文本段落">
          		<p id="u216"><span>肺部：</span></p>
      		</div>
            <div id="u233" class="ax_下拉列表框">
                <select id="u233_input" class="test" name="lung">
                  <option value="0">未见异常</option>
                  <option value="1">异常</option>
                </select>
      		</div>
            <div id="u234" class="ax_文本框">
        		<input id="u234_input" name="lungRemark" class="u233_input" style="display: none;" type="text" placeholder="异常时显示输入框" value=""/>
      		</div>
        
        </div>
        
        
        <div id="u235" name="foldDiv5" onclick="AutoFold('foldDiv6','u238',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u236"><span>妇 科 检 查</span></p>
          <p id="u238" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        
        <div id="" name="foldDiv6" style="height: 111px">
        	
            <div id="u239" class="ax_文本段落">
          		<p id="u240"><span>外阴：</span></p>
      		</div>
            <div id="u249" class="ax_下拉列表框">
                <select id="u249_input" class="test1" name="outerVulva">
                  <option value="2">未检查</option>
                  <option value="0">未见异常</option>
                  <option value="1">异常</option>
                </select>
      		</div>
            <div id="u250" class="ax_文本框">
        		<input id="u250_input" name="outerVulvaRemark" class="u249_input" style="display: none;" type="text" placeholder="异常时显示输入框" value=""/>
      		</div>
            
            <div id="u241" class="ax_文本段落">
          		<p id="u242"><span>阴道：</span></p>
      		</div>
            <div id="u251" class="ax_下拉列表框">
                <select id="u251_input" class="test1" name="vagina">
                  <option value="2">未检查</option>
                  <option value="0">未见异常</option>
                  <option value="1">异常</option>
                </select>
      		</div>
            <div id="u252" class="ax_文本框">
        		<input id="u252_input" name="vaginaRemark" class="u251_input" style="display: none;" type="text" placeholder="异常时显示输入框" value=""/>
      		</div>
            
            <div id="u245" class="ax_文本段落">
          		<p id="u246"><span>子宫：</span></p>
      		</div>
            <div id="u253" class="ax_下拉列表框">
                <select id="u253_input" name="uterus">
                  <option value="3">未检查</option>
                  <option value="0">未见异常</option>
                  <option value="1">异常</option>
                  <option value="2">正常孕期</option>
                </select>
      		</div>
            <div id="u254" class="ax_文本框">
        		<input id="u254_input" name="uterusRemark" style="display: none;" type="text" placeholder="异常时显示输入框" value=""/>
      		</div>
            
            
            <div id="u243" class="ax_文本段落">
          		<p id="u244"><span>宫颈：</span></p>
      		</div>
            <div id="u255" class="ax_下拉列表框">
                <select id="u255_input" class="test1" name="uterineNeck">
                  <option value="2">未检查</option>
                  <option value="0">未见异常</option>
                  <option value="1">异常</option>
                </select>
      		</div>
            <div id="u256" class="ax_文本框">
        		<input id="u256_input" type="text" class="u255_input" style="display: none;" name="uterineNeckRemark" placeholder="异常时显示输入框" value=""/>
      		</div>
            
            <div id="u247" class="ax_文本段落">
          		<p id="u248"><span>附件：</span></p>
      		</div>
            <div id="u257" class="ax_下拉列表框">
                <select id="u257_input" class="test1" name="appendix">
                  <option value="2">未检查</option>
                  <option value="0">未见异常</option>
                  <option value="1">异常</option>
                </select>
      		</div>
            <div id="u258" class="ax_文本框">
        		<input id="u258_input" name="appendixRemark" class="u257_input" style="display: none;" type="text" placeholder="异常时显示输入框" value=""/>
      		</div>
        
        </div>
        
        <div id="u259" name="foldDiv7" onclick="AutoFold('foldDiv8','u262',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u260"><span>辅 助 检 查</span></p>
          <p id="u262" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        
        <div id="" name="foldDiv8" style="height: 563px">
        	
            <div id="u273" class="ax_文本段落">
          		<p id="u274"><span>血常规：</span></p>
      		</div>
            
            <div id="u263" class="ax_文本段落">
          		<p id="u264"><span>血红蛋白值：</span></p>
      		</div>
            <div id="u358" class="ax_文本框">
        		<input id="u358_input" name="hemoglobin" type="text" value=""/>
     		</div>
            <div id="u265" class="ax_文本段落">
          		<p id="u266"><span style="font-family:'Arial Normal', 'Arial';font-weight:400;color:#333333;">g/L</span><span style="font-family:'Arial Normal', 'Arial';font-weight:400;color:#333333;">&nbsp; </span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u266_"></span></span></p>
      		</div>
            
            <div id="u267" class="ax_文本段落">
          		<p id="u268"><span>白细胞计数值：</span></p>
      		</div>
            <div id="u359" class="ax_文本框">
        		<input id="u359_input" name="leucocyte" type="text" value=""/>
      		</div>
            <div id="u349" class="ax_文本段落">
          		<p id="u350"><span>×10^9/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u350_"></span></span></p>
      		</div>
            
            <div id="u269" class="ax_文本段落">
          		<p id="u270"><span>血小板计数值：</span></p>
      		</div>
            <div id="u360" class="ax_文本框">
        		<input id="u360_input" name="platelet" type="text" value=""/>
      		</div>
            <div id="u271" class="ax_文本段落">
          		<p id="u272">×10^9/L<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u272_"></span></span></p>
      		</div>
            
            
            <div id="u356" class="ax_文本段落">
          		<p id="u357"><span>其他：</span></p>
      		</div>
            <div id="u355" class="ax_文本框">
        		<input id="u355_input" name="bloodOthers" type="text" value=""/>
      		</div>
            <div id="u485" class="ax_水平线">
        		<hr id="u485_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      		</div>
            
            <div id="u275" class="ax_文本段落">
          		<p id="u276"><span>尿常规：</span></p>
      		</div>
            
            <div id="u363" class="ax_文本段落">
          		<p id="u364"><span>尿糖：</span></p>
      		</div>
            <div id="u377" class="ax_文本框">
        		<input id="u377_input" name="urineSugar" type="text" value=""/>
      		</div>
            <div id="u371" class="ax_文本段落">
          		<p id="u372"><span>mmol/L</span></p>
      		</div>
            
            <div id="u365" class="ax_文本段落">
          		<p id="u366"><span>尿酮体：</span></p>
      		</div>
            <div id="u378" class="ax_文本框">
        		<input id="u378_input" name="ketone" type="text" value=""/>
      		</div>
            <div id="u373" class="ax_文本段落">
          		<p id="u374"><span>mmol/L</span></p>
      		</div>
            
            <div id="u361" class="ax_文本段落">
          		<p id="u362"><span>尿蛋白：</span></p>
      		</div>
            <div id="u379" class="ax_文本框">
        		<input id="u379_input" name="proteinuria" type="text" value=""/>
      		</div>
            <div id="u369" class="ax_文本段落">
          		<p id="u370"><span>g/L</span></p>
      		</div>
            
            <div id="u367" class="ax_文本段落">
          		<p id="u368"><span>尿潜血：</span></p>
      		</div>
            <div id="u380" class="ax_文本框">
        		<input id="u380_input" name="urineBlood" type="text" value=""/>
      		</div>
            <div id="u375" class="ax_文本段落">
          		<p id="u376"><span>cells/u</span></p>
      		</div>
            
            <div id="u382" class="ax_文本段落">
          		<p id="u383"><span>其他：</span></p>
      		</div>
            <div id="u381" class="ax_文本框">
        		<input id="u381_input" name="urineOthers" type="text" value=""/>
      		</div>
            
            <div id="u486" class="ax_水平线">
        		<hr id="u486_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      		</div>
            
            <div id="u277" class="ax_文本段落">
          		<p id="u278"><span>血型：</span></p>
      		</div>
            <div id="u384" class="ax_下拉列表框">
                <select id="u384_input" name=bloodType>
                  <option value="0">A型</option>
                  <option value="1">B型</option>
                  <option value="2">AB型</option>
                  <option value="3">O型</option>
                </select>
      		</div>
            
            <div id="u347" class="ax_文本段落">
          		<p id="u348"><span>RH：</span></p>
      		</div>
            <div id="u385" class="ax_下拉列表框">
                <select id="u385_input" name="bloodTypeRh">
                  <option value="0">RH+</option>
                  <option value="1">RH-</option>
                </select>
      		</div>
            
            <div id="u386" class="ax_文本段落">
          		<p id="u387"><span>血糖：</span></p>
      		</div>
            <div id="u390" class="ax_文本框">
        		<input id="u390_input" name="bloodGlucose" type="text" value=""/>
      		</div>
            <div id="u388" class="ax_文本段落">
          		<p id="u389"><span>mmol/L</span></p>
      		</div>
            
            <div id="u488" class="ax_水平线">
        		<hr id="u488_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      		</div>
            
            <div id="u287" class="ax_文本段落">
          		<p id="u288"><span>肝功能：</span></p>
      		</div>
            
            <div id="u391" class="ax_文本段落">
          		<p id="u392"><span>血清谷丙转氨酶：</span></p>
      		</div>
            <div id="u401" class="ax_文本框">
        		<input id="u401_input" name="sgpt" type="text" value=""/>
      		</div>
            <div id="u279" class="ax_文本段落">
          		<p id="u280"><span>U/L</span></p>
      		</div>
            
            <div id="u393" class="ax_文本段落">
          		<p id="u394"><span>血清谷草转氨酶：</span></p>
      		</div>
            <div id="u402" class="ax_文本框">
        		<input id="u402_input" name="sgot" type="text" value=""/>
      		</div>
            <div id="u281" class="ax_文本段落">
          		<p id="u282"><span>U/L</span></p>
      		</div>
            
            <div id="u395" class="ax_文本段落">
          		<p id="u396"><span>白蛋白：</span></p>
      		</div>
            <div id="u403" class="ax_文本框">
        		<input id="u403_input" name="albumin" type="text" value=""/>
      		</div>
            <div id="u283" class="ax_文本段落">
          		<p id="u284"><span>g/L<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u284_"></span></span></span></p>
      		</div>
            
            <div id="u397" class="ax_文本段落">
          		<p id="u398"><span>总胆红素：</span></p>
      		</div>
            <div id="u404" class="ax_文本框">
        		<input id="u404_input" name="totalBilirubin" type="text" value=""/>
      		</div>
            <div id="u285" class="ax_文本段落">
          		<p id="u286"><span>μmol/L<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u286_"></span></span></span></p>
      		</div>
            
            <div id="u399" class="ax_文本段落">
          		<p id="u400"><span>结合胆红素：</span></p>
      		</div>
            <div id="u405" class="ax_文本框">
        		<input id="u405_input" name="dbil" type="text" value=""/>
      		</div>
            <div id="u483" class="ax_文本段落">
          		<p id="u484"><span>μmol/L<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u484_"></span></span></span></p>
     		</div>
            
            <div id="u487" class="ax_水平线">
        		<hr id="u487_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      		</div>
            
            <div id="u289" class="ax_文本段落">
          		<p id="u290"><span>肾功能：</span></p>
      		</div>
            
            <div id="u291" class="ax_文本段落">
          		<p id="u292"><span>血清肌酐：</span></p>
      		</div>
            <div id="u406" class="ax_文本框">
        		<input id="u406_input" name="scr" type="text" value=""/>
      		</div>
            <div id="u293" class="ax_文本段落">
          		<p id="u294"><span>μmol/L<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u294_"></span></span></span></p>
      		</div>
            
            <div id="u295" class="ax_文本段落">
          		<p id="u296"><span>血尿素氮：</span></p>
      		</div>
            <div id="u407" class="ax_文本框">
        		<input id="u407_input" name="bun" type="text" value=""/>
      		</div>
            <div id="u297" class="ax_文本段落">
          		<p id="u298"><span>mmol/L<span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u298_"></span></span></span></p>
      		</div>
            
            <div id="u299" class="ax_文本段落">
          		<p id="u300"><span>阴道分泌物：</span></p>
      		</div>
            <div id="u301" class="ax_复选框">
                <label for="u301_input">
                    <p id="u302"><span>未见异常</span></p>
                </label>
                <input id="u301_input" name="vaginalFluid" type="checkbox" value="0"/>
      		</div>
            <div id="u303" class="ax_复选框">
                <label for="u303_input">
                    <p id="u304"><span>滴虫</span></p>
                </label>
                <input id="u303_input" name="vaginalFluid" type="checkbox" value="1"/>
      		</div>
            <div id="u305" class="ax_复选框">
                <label for="u305_input">
                    <p id="u306"><span>假丝酵母菌</span></p>
                </label>
                <input id="u305_input" name="vaginalFluid" type="checkbox" value="2"/>
      		</div>
            <div id="u409" class="ax_复选框">
                <label for="u409_input">
                    <p id="u410"><span>其</span><span>他</span></p>
                </label>
                <input id="u409_input" name="vaginalFluid" type="checkbox" value="3"/>
      		</div>
            <div id="u408" class="ax_文本框">
        		<input id="u408_input" style="display: none;" name="vaginalFluidOthers" type="text" placeholder="其他时显示输入框" value=""/>
      		</div>
            
            <div id="u307" class="ax_文本段落">
          		<p id="u308"><span>阴道清洁度：</span></p>
      		</div>
            <div id="u351" class="ax_下拉列表框">
                <select id="u351_input" name="vaginalClean">
                  <option value="0">Ⅰ度</option>
                  <option value="1">Ⅱ度 </option>
                  <option value="2">Ⅲ度</option>
                  <option value="3"> Ⅳ度</option>
                </select>
      		</div>
            
            <div id="u309" class="ax_文本段落">
          		<p id="u310"><span>乙肝五项：</span></p>
      		</div>
            
            <div id="u311" class="ax_文本段落">
          		<p id="u312"><span>乙型肝炎表面抗原：</span></p>
      		</div>
            <div id="u327" class="ax_单选按钮">
                <label for="u327_input">
                    <p id="u328"><span>阴性</span></p>
                </label>
                <input id="u327_input" type="radio" value="0" name="hbsag"/>
      		</div>
            <div id="u329" class="ax_单选按钮">
                <label for="u329_input">
                    <p id="u330"><span>阳性</span></p>
                </label>
                <input id="u329_input" type="radio" value="1" name="hbsag"/>
      		</div>
            
            <div id="u313" class="ax_文本段落">
          		<p id="u314"><span>乙型肝炎表面抗体：</span></p>
      		</div>
            <div id="u331" class="ax_单选按钮">
                <label for="u331_input">
                    <p id="u332"><span>阴性</span></p>
                </label>
                <input id="u331_input" type="radio" value="0" name="hbsab"/>
      		</div>
            <div id="u333" class="ax_单选按钮">
                <label for="u333_input">
                    <p id="u334"><span>阳性</span></p>
                </label>
                <input id="u333_input" type="radio" value="1" name="hbsab"/>
      		</div>
            
            <div id="u319" class="ax_文本段落">
          		<p id="u320"><span>乙型肝炎核心抗体：</span></p>
      		</div>
            <div id="u339" class="ax_单选按钮">
                <label for="u339_input">
                    <p id="u340"><span>阴性</span></p>
                </label>
                <input id="u339_input" type="radio" value="0" name="hbcab"/>
      		</div>
            <div id="u341" class="ax_单选按钮">
                <label for="u341_input">
                    <p id="u342"><span>阳性</span></p>
                </label>
                <input id="u341_input" type="radio" value="1" name="hbcab"/>
      		</div>
            
            <div id="u317" class="ax_文本段落">
          		<p id="u318"><span>乙型肝炎e抗体：</span></p>
      		</div>
            <div id="u335" class="ax_单选按钮">
                <label for="u335_input">
                    <p id="u336"><span>阴性</span></p>
                </label>
                <input id="u335_input" type="radio" value="0" name="hbeab"/>
      		</div>
            <div id="u337" class="ax_单选按钮">
                    <label for="u337_input">
                        <p id="u338"><span>阳性</span></p>
                    </label>
                    <input id="u337_input" type="radio" value="1" name="hbeab"/>
      		</div>
            
            <div id="u315" class="ax_文本段落">
          		<p id="u316"><span>乙型肝炎e抗原：</span></p>
      		</div>
            <div id="u343" class="ax_单选按钮">
                <label for="u343_input">
                    <p id="u344"><span>阴性</span></p>
                </label>
                <input id="u343_input" type="radio" value="0" name="hbeag"/>
      		</div>
            <div id="u345" class="ax_单选按钮">
                <label for="u345_input">
                    <p id="u346" ><span>阳性</span></p>
                </label>
                <input id="u345_input" type="radio" value="1" name="hbeag"/>
      		</div>
            
            <div id="u321" class="ax_文本段落">
          		<p id="u322"><span>梅毒血清学试验：</span></p>
      		</div>
            <div id="u411" class="ax_单选按钮">
                <label for="u411_input">
                    <p id="u412"><span>阴性</span></p>
                </label>
                <input id="u411_input" type="radio" value="0" name="syphilisSerology"/>
      		</div>
            <div id="u413" class="ax_单选按钮">
                <label for="u413_input">
                    <p id="u414"><span>阳性</span></p>
                </label>
                <input id="u413_input" type="radio" value="1" name="syphilisSerology"/>
      		</div>
            
            <div id="u323" class="ax_文本段落">
          		<p id="u324"><span>HIV抗体检测：</span></p>
      		</div>
            <div id="u415" class="ax_单选按钮">
                <label for="u415_input">
                    <p id="u416"><span>阴性</span></p>
                </label>
                <input id="u415_input" type="radio" value="0" name="hivab"/>
      		</div>
            <div id="u417" class="ax_单选按钮">
                <label for="u417_input">
                    <p id="u418"><span>阳性</span></p>
                </label>
                <input id="u417_input" type="radio" value="1" name="hivab"/>
      		</div>
            <div id="u325" class="ax_文本段落">
          		<p id="u326"><span>B超：</span></p>
      		</div>
             <div id="u420" class="ax_文本框">
                <select id="u420_input" name="bscan">
                  <option value="1">无异常</option>
                  <option value="2">有异常</option>
                  <option selected value="0">未检查</option>
                </select>
      		</div>
            <div id="u42400">
            	<input id="u42400_input" style="display: none;" name="bscanRemark" type="text" placeholder="异常时显示输入框" value=""/>
       	  	</div>
            
            <div id="u352" class="ax_文本段落">
          		<p id="u353"><span> NT：</span></p>
      		</div>
            <div id="u354" class="ax_下拉列表框">
                <select id="u354_input" name="nt">
                  <option value="1">无异常</option>
                  <option value="2">有异常</option>
                  <option selected value="0">未检查</option>
                </select>
      		</div>
            <div id="u419" class="ax_文本框">
        		<input id="u419_input" style="display: none;" type="text" name="ntRemark" placeholder="异常时显示输入框" value=""/>
      		</div>
            
            
        </div>
        
        <div id="u421" name="foldDiv9" onclick="AutoFold('foldDiv10','u424',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u422"><span>总 体 评 估</span></p>
          <p id="u424" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
      
      <div id="" name="foldDiv10" style="height: 43px">
      	
        <div id="u425" class="ax_文本段落">
          <p id="u426"><span>总体评估：</span></p>
      	</div>
        <div id="u427" class="ax_单选按钮">
            <label for="u427_input">
                <p id="u428"><span>&nbsp;</span><span>未见异常</span></p>
            </label>
            <input id="u427_input" type="radio" value="0" name="evaluate"/>
      	</div>
        <div id="u429" class="ax_单选按钮">
            <label for="u429_input">
                <p id="u430"><span> 异常</span></p>
            </label>
            <input id="u429_input" type="radio" value="1" name="evaluate"/>
      	</div>
        <div id="u431" style="display: none;" class="ax_下拉列表框">
            <p id="u431_input" style="cursor:pointer;background-color: #EE5F45"><span>异常选项</span></p>
      	</div>
        <div id="u4310">
        	<p id="u43100"></p>
        </div>
              	
      </div>
      
      <div id="u432" name="foldDiv11" onclick="AutoFold('foldDiv12','u435',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u433"><span>保 健 指 导</span></p>
          <p id="u435" style="left: 1126px;top: 5px;"><span>收起</span></p>
      </div> 
      
      <div id="" name="foldDiv12" style="height: 171px">
      	
        <div id="u436" class="ax_多行文本框">
        	<textarea id="u436_input" name="guidance"></textarea>
      	</div>
      
      </div>
      
      <div id="u437" name="foldDiv13" onclick="AutoFold('foldDiv14','u440',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u438"><span>转 诊</span></p>
          <p id="u440" style="left: 1126px;top: 5px;"><span>收起</span></p>
      </div>
      
      <div id="" name="foldDiv14" style="height: 253px">
      
      	<div id="u441" class="ax_文本段落">
          <p id="u442"><span>转诊：</span></p>
      	</div>
        <div id="u443" class="ax_单选按钮">
            <label for="u443_input">
                <p id="u444"><span> 无</span></p>
            </label>
            <input id="u443_input" type="radio" value="0" name="referral"/>
      	</div>
        <div id="u445" class="ax_单选按钮">
            <label for="u445_input">
                <p id="u446"><span> 有</span></p>
            </label>
            <input id="u445_input" type="radio" value="1" name="referral"/>
      	</div>
        
        <div id="u447" class="ax_文本段落">
          <p id="u448" ><span>原因：</span></p>
      	</div>
        <div id="u449" class="ax_文本框">
        	<input id="u449_input" type="text" name="reason" value=""/>
      	</div>
        
        <div id="u450" class="ax_文本段落">
          <p id="u451"><span>转诊机构：</span></p>
      	</div>
        <div id="u452" class="ax_下拉列表框">
            <select id="u452_input" name="mechanism">
            <c:forEach items="${depts }" var="dept">
            	<option value="${dept.id }">${dept.name }</option>
            </c:forEach>
            </select>
      	</div>
        
        <div id="u453" class="ax_文本段落">
          <p id="u454"><span>转诊科室：</span></p>
      	</div>
        <div id="u455" class="ax_下拉列表框">
            <select id="u455_input" name="department">
            	<c:forEach items="${roles }" var="role">
            		<option value="${role.id }">${role.name }</option>
            	</c:forEach>
            </select>
      	</div>
        
        <div id="u456" class="ax_文本段落">
          <p id="u457"><span>下次随访日期：</span></p>
      	</div>
        <div id="u458" class="ax_下拉列表框">
        	<input id="nextFollowingDate" type="hidden" value=""/>
            <input type="text" id="u458_input" name="nextFollowingDate" 
        	style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="Wdate" value="" tabindex="1" required>
      	</div>
        
        <div id="u459" class="ax_文本段落">
          <p id="u460"><span>是否预约下次检查：</span></p>
      	</div>
        <div id="u461" class="ax_单选按钮">
            <label for="u461_input">
                <p id="u462"><span> 是</span></p>
            </label>
            <input id="u461_input" type="radio" value="1" name="orderCheck"/>
      	</div>
        <div id="u463" class="ax_单选按钮">
            <label for="u463_input">
                <p id="u464"><span> 否</span></p>
            </label>
            <input id="u463_input" type="radio" value="0" name="orderCheck"/>
      	</div>
        
        <div id="u474" class="ax_水平线">
        	<hr id="u474_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      	</div>
        
        <div id="u465" class="ax_文本段落">
          <p id="u466"><span>母子健康手册使用：</span></p>
      	</div>
        <div id="u471" class="ax_下拉列表框">
            <select id="u471_input" name="healthHandbook">
              <option value="1">是</option>
              <option value="0">否</option>
            </select>
      	</div>
        
        <div id="u467" class="ax_文本段落">
          <p id="u468"><span>叶酸发放：</span></p>
      	</div>
        <div id="u472" class="ax_下拉列表框">
            <select id="u472_input" onchange="only()">
              <option value="1">是</option>
              <option value="0">否</option>
            </select>
      	</div>
        
        <div id="u469" class="ax_文本段落">
          <p id="u470"><span>发放数量：&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;瓶</span></p>
      	</div>
        <div id="u473" class="ax_文本框">
        	<input id="u473_input" name="folateNum" type="text" placeholder="填写数量" value=""/>
      	</div>
        
      </div>
      <input id="highRiskId" type="hidden" name="highRiskId" value=""/>
      <div id="addOrUpdate" style="overflow:auto" class="easyui-dialog" title="角色" closed="true">
      	<div style="overflow-y: auto;OVERFLOW-X:hidden;width: 995px;height: 748px;position: absolute;top: 0px;">
      		<div id="guding" style="overflow:auto">
		        
		    </div>
		      
		    <div id="renshen">
			    	
			</div>
      
			<div id="benci">
        	
	        </div>
	       
	        <div id="head">
    	
		        <div id="su252" class="ax_形状" style="background-color:#999999">
		          <p id="su253" style="cursor:pointer"><span>固定因素</span></p>
		      	</div>
		        
		        <div id="su276" class="ax_形状" style="background-color:#999999">
		          <p id="su277" style="cursor:pointer"><span>妊娠合并症</span></p>
		      	</div>
		        
		        <div id="su278" class="ax_形状" style="background-color:#999999">
		          <p id="su279" style="cursor:pointer"><span>本次妊娠异常情况</span></p>
		      	</div>
		        
		        <div id="su280" class="ax_形状" style="background-color:#999999">
		          <p id="su281" style="cursor:pointer"><span>社会环境因素</span></p>
		      	</div>
		        
		        <div id="su254" class="ax_形状" style="background-color:#009DD9">
		          <p id="su255" style="cursor:pointer"><span>保存</span></p>
		      	</div>
		        
		        <div id="su256" class="ax_形状" style="background-color:#56BB4D">
		          <p id="su257" style="cursor:pointer"><span>取消</span></p>
		      	</div>
		    
		    </div>
		    
		    <div id="fen">
		    	<div id="su282" class="ax_文本段落">
		          <p id="su283"><span>5分（A级）</span></p>
		      	</div>
		        
		        <div id="su284" class="ax_文本段落">
		          <p id="su285"><span>10分（B级）</span></p>
		      	</div>
		        
		        <div id="su286" class="ax_文本段落">
		          <p id="su287"><span>20分（C级）</span></p>
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
	      </div>
      </div>
      </form>
      
      <div id="addZhuan" style="overflow:auto" class="easyui-dialog" title="角色" closed="true">
		
		<div id="cssAuto" style="overflow-y: auto;OVERFLOW-X:hidden;width: 860px;height: 615px;position: absolute;top: 0px;">
		<form  id="saveCheck" method="post">
		<!-- <div id="u025" class="ax_形状" style="background-color:#EE5F45">
          <p id="u026"><span>高危专案管理</span></p>
      	</div> -->
        
        <div id="u02" class="ax_文本段落">
          <p id="u03"><span>转归：</span></p>
        </div>
        
        <div id="u00" class="ax_形状">
			<p id="u01">
				<span> </span>
			</p>
		</div>
        
        <div id="u04" class="ax_下拉列表框">
            <select id="u04_input" name="lapseTo">
              <option value="2">结束分娩</option>
              <option value="1">正常随访</option>
              <option selected value="0">继续监护</option>
            </select>
      	</div>
        
        <div id="u032" class="ax_形状" style="background-color:#999999">
          <p id="u033"><span>本次检查结果</span></p>
      	</div>
		<div id="u06" class="ax_多行文本框">
        	<textarea id="u06_input" name="result"></textarea>
      	</div>
      
      	<div id="u027" class="ax_垂直线">
       		<hr id="u027_line" style="weight:1px;border:none;border-left:1px solid #999999;"/>
      	</div>
        
        <div id="u030" class="ax_形状" style="background-color:#999999">
          <p id="u031"><span>诊断结果</span></p>
      	</div>
        
        <div id="u024" class="ax_多行文本框">
        	<textarea id="u024_input" name="diaResult"></textarea>
      	</div>
        
     <div id="u07" class="ax_表格">

        <div id="u08" class="ax_单元格" style="background-color:#999999">
            <p id="u09"><span>序号</span></p>
        </div>

        <div id="u010" class="ax_单元格" style="background-color:#999999">
            <p id="u011"><span>高危因素</span></p>
        </div>

        <div id="u012" class="ax_单元格" style="background-color:#999999">
            <p id="u013"><span>矫正</span></p>
        </div>
		
		<div id="inner">
	        
		
		</div>

        <!-- Unnamed (单元格) -->
        <div id="u018" class="ax_单元格">
            <p id="u019"><span>&nbsp;</span></p>
        </div>
      </div>
      
      <div id = "checkRadio">
      	
	      
      </div>
      
      
      <div id="u05" class="ax_多行文本框">
        <textarea id="u05_input" name="scheme"></textarea>
      </div>

      
      <div id="u034" class="ax_形状" style="background-color:#E9854F">
          <p id="u035" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchives.id }&archivesId=${birthArchives.archivesId }'" style="cursor:pointer"><span>专案记录</span></p>
      </div>
		
      <div id="u036" class="ax_形状" style="background-color:#009DD9">
          <p id="u037" style="cursor:pointer"><span>保存</span></p>
      </div>
      </form>
      </div>
    </div>
      <div id="finishTan" class="easyui-dialog" title="角色" closed="true">
      
      <div id="u000" class="ax_形状">
        <div id="u001" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>

      <div id="u002" class="ax_文本段落">
          <p id="u003"><span>随访完成，是否前去打印表格？</span></p>
      </div>

<!--       <div id="u004" class="ax_形状" style="background-color:#EE5F45"> -->
<!--           <p id="u005"><span>提&nbsp; &nbsp; 示</span></p> -->
<!--       </div> -->

      <div id="u006" class="ax_形状" style="background-color:#009DD9">
          <p id="u007" style="cursor:pointer"><span>否</span></p>
      </div>
		<input type="hidden" id="prenatalId" value=""/>
      <div id="u008" class="ax_形状" style="background-color:#E9854F">
          <p id="u009" style="cursor:pointer"><span>是</span></p>
      </div>
    </div>
	
  </body>
</html>
