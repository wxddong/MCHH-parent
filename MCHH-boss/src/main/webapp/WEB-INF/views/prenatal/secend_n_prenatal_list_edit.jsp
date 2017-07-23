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
		border:1px solid #CCCCCC;
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
		.autocut {  
		    width:100px;  
		    overflow:hidden;  
		    white-space:nowrap;  
		    text-overflow:ellipsis;  
		    -o-text-overflow:ellipsis;  
		    -icab-text-overflow: ellipsis;  
		    -khtml-text-overflow: ellipsis;  
		    -moz-text-overflow: ellipsis;  
		    -webkit-text-overflow: ellipsis;  
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
		#jau0 {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:346px;
		}
		#jau1 {
		  position:absolute;
		  left:2px;
		  top:165px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#jau2 {
		  position:absolute;
		  left:410px;
		  top:246px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#jau3 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#jau4 {
		  position:absolute;
		  left:190px;
		  top:246px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#jau5 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#jau6 {
		  position:absolute;
		  left:296px;
		  top:120px;
		  width:129px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#jau7 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:129px;
		  white-space:nowrap;
		}
		#jau8 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#jau9 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#jau10 {
		  position:absolute;
		  left:150px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#jau11 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		#jau10_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#jau12 {
		  position:absolute;
		  left:270px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#jau13 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		#jau12_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#jau14 {
		  position:absolute;
		  left:390px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#jau15 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		#jau14_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#jau16 {
		  position:absolute;
		  left:510px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#jau17 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		#jau16_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#u3790 {
		  position:absolute;
		  left:786px;
		  top:0px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		  background-color:#E9854F;
		}
		#u3800 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		
				
	</style>
    <title>第2-N次产前随访记录表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/secendNprenatalEdit_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
      
    	$(function(){
    		
    		$("#u16").click();
    		$("#u37").click();
    		$("#u49").click();
    		$("#u124").click();
    		$("#u135").click();
    		$("#u140").click();
    		$("#u203").click();
    		
    		var x = 0;
    		
    		//高危项选择
    		$("#u134_input").click(function(){
    			
    			var hignRiskUrl = "${ctx}/com/config/highrisk/allEditHighrisk";
    			var prenatalId = $("#prenatalId").val();
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
    				data:{prenatalId:prenatalId},
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
     								if(data.list[i].selected == "1"){
	     								gudiFive += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+a*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
     								}else{
	     								gudiFive += "<div class='gu5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+a*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
     								}
     								
	     							a += 1;
     							}
								if(data.list[i].score == "10"){
									if(data.list[i].selected == "1"){
		     							gudiTen += "<div class='gu10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+b*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
									}else{
		     							gudiTen += "<div class='gu10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+b*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
									}
	     							
	     							b += 1;
     							}
								if(data.list[i].score == "20"){
									if(data.list[i].selected == "1"){
	     								gudiTw += "<div class='gu20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+c*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}else{
	     								gudiTw += "<div class='gu20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+c*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}
     								
	     							c += 1;
     							}
     						}
     						if(data.list[i].status=="0"){
     							if(data.list[i].score == "5"){
     								if(data.list[i].selected == "1"){
	     								renshenFive += "<div class='ren5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+d*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}else{
	     								renshenFive += "<div class='ren5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+d*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}
	     							
	     							d += 1;
     							}
								if(data.list[i].score == "10"){
									if(data.list[i].selected == "1"){
		     							renshenTen += "<div class='ren10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+e*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}else{
		     							renshenTen += "<div class='ren10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+e*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}
	     							e += 1;
     							}
								if(data.list[i].score == "20"){
									if(data.list[i].selected == "1"){
		     							renshenTw += "<div class='ren20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+f*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}else{
		     							renshenTw += "<div class='ren20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+f*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}
	     							
	     							f += 1;
     							}
     						}
     						if(data.list[i].status=="2"){
     							if(data.list[i].score == "5"){
     								if(data.list[i].selected == "1"){
	     								benciFive += "<div class='ben5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+g*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}else{
	     								benciFive += "<div class='ben5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+g*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}
	     							g += 1;
     							}
								if(data.list[i].score == "10"){
									if(data.list[i].selected == "1"){
		     							benciTen += "<div class='ben10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+h*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
									}else{
		     							benciTen += "<div class='ben10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+h*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
									}
	     							h += 1;
     							}
								if(data.list[i].score == "20"){
									if(data.list[i].selected == "1"){
		     							benciTw += "<div class='ben20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+j*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}else{
		     							benciTw += "<div class='ben20' style='position:absolute;width:250px;height:15px;left:660px;top:"+(121+j*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}
	     							j += 1;
     							}
     						}
     						if(data.list[i].status=="3"){
     							if(data.list[i].score == "5"){
     								if(data.list[i].selected == "1"){
	     								shehuiFive += "<div class='she5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+k*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}else{
	     								shehuiFive += "<div class='she5' style='position:absolute;width:250px;height:15px;left:24px;top:"+(121+k*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}
	     							k += 1;
     							}
								if(data.list[i].score == "10"){
									if(data.list[i].selected == "1"){
		     							shehuiTen += "<div class='she10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+l*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
									}else{
		     							shehuiTen += "<div class='she10' style='position:absolute;width:250px;height:15px;left:342px;top:"+(121+l*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
									}
	     							l += 1;
     							}
								if(data.list[i].score == "20"){
									if(data.list[i].selected == "1"){
		     							shehuiTw += "<div class='she20' id=gu'"+j+"' style='position:absolute;left:660px;top:"+(121+m*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' checked type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}else{
		     							shehuiTw += "<div class='she20' id=gu'"+j+"' style='position:absolute;left:660px;top:"+(121+m*30)+"px;vertical-align: baseline;'><label>"
		     							+"<p class='ps'><span>"+data.list[i].name+"</span></p>"+
		     							"</label><input class='in' type='checkbox' value='"+data.list[i].id+"'name='evaluateRemark'/>"
		     							+"</div>";
	     							}
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
    		
			window.onload = function(){
				
				//页面加载的时候选择保健指导内容
				var week = $("#week").val();
				//week = week.substr(0,2);
				var day = "0";
				var directUrl = "${ctx}/directive/getDirectveByWeek"
				$.ajax({
   					url:directUrl,
   					type:"GET",
   					data:{week:week,day:day},
   					success:function(data){
   						
   						if(data.directive != null && data.directive !="" && data.directive != undefined){
   							if(data.directive.content!=null && data.directive.content!= "" &&data.directive.content!= undefined){
   								
   								$("#u139_input").val(data.directive.content);
   							}
   						}
   					}
   				});
				
				var radios = $("input[name='evaluate']");
				for (var i = 0; i < radios.length; i++) {
					radios[i].onclick = function(){
						var status = $("input[name='evaluate']:checked").val();
						if(status == 0){
							var highRiskStatu = $("#highRiskStatu").val();
							if(highRiskStatu != "1"){
								$("#u379").css("display","none");
								$("#u394").css({color:"#000000","font-weight":"100"});
								$("#u396").css({color:"#000000","font-weight":"100"});
							}
							$("#u134").css("display","none");
							
						}else{
							$("#u134").css("display","block");
							var top = $("#u132")[0].offsetTop;
							$("#u134")[0].style.top = (top-5)+"px";
							$("#u379").css("display","block");
							$("#u394").css({color:"#EE5F45","font-weight":"700"});
							$("#u396").css({color:"#EE5F45","font-weight":"700"});
							var correctCount = $("#correctCount").val();
							if(correctCount != "" && correctCount != null && correctCount != undefined){
								$("#u3790").css("display","none");
							}
						}
					};
				}
			};
			
			$(".test").change(function(){
				var idClass = $(this).attr("id");
				var testValue = $(this).val();
				if(testValue=="2"){
					$("."+idClass).show();
				}else{
					$("."+idClass).hide();
				}
			});
			
			$("#u32_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var height = this.value;
				if(!tag.test(height)){
					alert("只能输入整数或小数!");
				}
			});
			$("#u45_input").change(function(){
				var tag = /^[0-9]{2}$|^[0-9]{3}$/;
				var h = this.value;
				if(!tag.test(h)){
					alert("只能输入两位或者三位正整数!");
				}
			});
			$("#u48_input").change(function(){
				var tag = /^[0-9]{2}$|^[0-9]{3}$/;
				var l = this.value;
				if(!tag.test(l)){
					alert("只能输入两位或者三位正整数!");
				}
			});
			$("#u180_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var h = this.value;
				if(!tag.test(h)){
					alert("只能输入数字或小数!");
				}
			});			
			$("#u183_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var h = this.value;
				if(!tag.test(h)){
					alert("只能输入数字或小数!");
				}
			});
			$("input[name='heartRate']").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var h = this.value;
				if(!tag.test(h)){
					alert("只能输入数字或小数!");
				}
			});
			$("#u89_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
				if(b < 110){
					$("#u56_").html("↓");
				}else if(b > 150){
					$("#u56_").html("↑");
				}else{
					$("#u56_").html("");
				}
			});
			$("#u94_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
			});
			$("#u102_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
			});
			$("#u113_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
			});
			$("#u114_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
			});
			$("#u115_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
				if(b < 38.0){
					$("#u66_").html("↓");
				}else if(b > 53.0){
					$("#u66_").html("↑");
				}else{
					$("#u66_").html("");
				}
			});
			$("#u116_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
				if(b < 3.42){
					$("#u68_").html("↓");
				}else if(b > 20.50){
					$("#u68_").html("↑");
				}else{
					$("#u68_").html("");
				}
			});
			$("#u119_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
				/* if(b < 3.42){
					$("#u68_input").html("↓");
				}else if(b > 20.50){
					$("#u68_input").html("↑");
				} */
			});
			$("#u120_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
				if(b < 35.0){
					$("#u76_").html("↓");
				}else if(b > 80.0){
					$("#u76_").html("↑");
				}else{
					$("#u76_").html("");
				}
			});
			$("#u121_input").change(function(){
				var tag = /^\d+(\.\d+)?$/;
				var b = this.value;
				if(!tag.test(b)){
					alert("只能输入数字或小数!");
				}
				/* if(b < 35.0){
					$("#u76_input").html("↓");
				}else if(b > 80.0){
					$("#u76_input").html("↑");
				} */
			});
			
			
			//完成
			$("#u378").click(function(){
				
				var weight = $("#u32_input").val();
				var tag = /^\d+(\.\d+)?$/;
				
				if(weight == "" || weight == null){
					alert("请输入体重!");
					return false;
				}
				if(!tag.test(weight)){
					alert("体重只能输入整数或小数!");
					return false;
				}
				var bloodH = $("#u45_input").val();
				var tag2 = /^[0-9]{2}$|^[0-9]{3}$/;
				
				if(bloodH == "" || bloodH == null){
					alert("请输入血压高值!");
					return false;
				}
				if(!tag2.test(bloodH)){
					alert("血压高值只能输入数字!");
					return false;
				}
				var bloodL = $("#u48_input").val();
				
				if(bloodL == "" || bloodL == null){
					alert("请输入血压低值!");
					return false;
				}
				if(!tag2.test(bloodL)){
					alert("血压低值只能输入数字!");
					return false;
				}
				var houseH = $("#u180_input").val();
				var tag3 = /^\d+(\.\d+)?$/;
				
				if(houseH == "" || houseH == null){
					alert("请输入宫高!");
					return false;
				}
				if(!tag3.test(houseH)){
					alert("宫高只能输入数字或小数!");
					return false;
				}
				var fuLong = $("#u183_input").val();
				
				if(fuLong == "" || fuLong == null){
					alert("请输入腹围!");
					return false;
				}
				if(!tag3.test(fuLong)){
					alert("腹围只能输入数字或小数!");
					return false;
				}
				var tw = $("#u185_input").val();
				/* if(!tag3.test(tw)){
					alert("胎位只能输入数字或小数!");
					return false;
				} */
				if(tw == "" || tw == null || tw == undefined){
					alert("请输入胎位!");
					return false;
				}
				var tHert = $("#u184_input").val();
				
				if(tHert == "" || tHert == null){
					alert("请输入胎心率!");
					return false;
				}
				if(!tag3.test(tHert)){
					alert("胎心率只能输入数字或小数!");
					return false;
				}
				var zS = $("#u186_input").val();
				if(zS == "" || zS == null){
					alert("请输入主诉！");
					return false;
				}
				var blAWhite = $("#u89_input").val();
				
				if(blAWhite == "" || blAWhite == null){
					alert("请输入血红蛋白值!");
					return false;
				}
				if(!tag3.test(blAWhite)){
					alert("血红蛋白值只能输入数字或小数!");
					return false;
				}
				var nWhite = $("#u94_input").val();
				
				if(nWhite == "" || nWhite == null || nWhite == undefined){
					alert("请输入尿蛋白值!");
					return false;
				}
				if(!tag3.test(nWhite)){
					alert("尿蛋白值只能输入数字或小数!");
					return false;
				}
				var blSuger = $("#u102_input").val();
				
				if(!$("#u1300_input").attr("checked")){
					if(blSuger == "" || blSuger == null){
						alert("请输入血糖值!");
						return false;
					}
					if(!tag3.test(blSuger)){
						alert("血糖值只能输入数字或小数!");
						return false;
					}
				}
				var blqg = $("#u113_input").val();
				
				if(!$("#u6100").attr("checked")){
					if(blqg == "" || blqg == null){
						alert("请输入血清谷丙转氨酶值！");
						return false;
					}
					if(!tag3.test(blqg)){
						alert("血清谷丙转氨酶值只能输入数字或小数!");
						return false;
					}
				}
				var blgc = $("#u114_input").val();
				
				if(!$("#u6300").attr("checked")){
					if(blgc == "" || blgc == null){
						alert("请输入血清谷草转氨酶值!");
						return false;
					}
					if(!tag3.test(blgc)){
						alert("血清谷草转氨酶值只能输入数字或小数!");
						return false;
					}
				}
				var wAw = $("#u115_input").val();
				
				if(!$("#u6500").attr("checked")){
					if(wAw == "" || wAw == null){
						alert("请输入白蛋白值！");
						return false;
					}
					if(!tag3.test(wAw)){
						alert("白蛋白值只能输入数字或小数!");
						return false;
					}
				}
				var zdRed = $("#u116_input").val();
				
				if(!$("#u6700").attr("checked")){
					if(zdRed == "" || zdRed == null){
						alert("请输入总胆红素值!");
						return false;
					}
					if(!tag3.test(zdRed)){
						alert("总胆红素值只能输入数字或小数!");
						return false;
					}
				}
				var jhdRed = $("#u119_input").val();
				
				if(!$("#u11700").attr("checked")){
					if(jhdRed == "" || jhdRed == null){
						alert("请输入结合胆红素值!");
						return false;
					}
					if(!tag3.test(jhdRed)){
						alert("结合胆红素值只能输入数字或小数!");
						return false;
					}
				}
				var jg = $("#u120_input").val();
				
				if(!$("#u7500").attr("checked")){
					if(jg == "" || jg == null){
						alert("请输入血清肌酐值!");
						return false;
					}
					if(!tag3.test(jg)){
						alert("血清肌酐值只能输入数字或小数!");
						return false;
					}
				}
				var bloodPsd = $("#u121_input").val();
				
				if(!$("#u7900").attr("checked")){
					if(bloodPsd == "" || bloodPsd == null){
						alert("请输入血尿素氮!");
						return false;
					}
					if(!tag3.test(bloodPsd)){
						alert("血尿素氮值只能输入数字或小数!");
						return false;
					}
				}
				/* var other = $("#u202_input").val();
				other = $.trim(other);
				if(other == "" || other == null){
					alert("请输入辅助检查其他!");
					return false;
				} */
				//B超
				var bscan0 = $("#u187_input").val();
				if(bscan0 == "" || bscan0 == null || bscan0 == undefined){
					alert("请选择B超选项!");
					return false;
				}
				var nst0 = $("#u198_input").val();
				if(nst0 == "" || nst0 == null || nst0 == undefined){
					alert("请选择NST选项!");
					return false;
				}
				
				var status = $("input[name='evaluate']:checked").val();
				if(status == null || status == "" || status == undefined){
					alert("请选择是总体评估是否有异常!");
					return false;
				}
				if(status == "1"){
					if(za == 0){
						alert("请先保存专案管理!");
						return false;
					}
				}
				
				var gude = $("#u139_input").val();
				if(gude == "" || gude == null){
					alert("请输入保健指导！");
					return false;
				}
				var referral = $("input[name='referral']:checked").val();
				if(referral == null || referral == "" || referral == undefined){
					alert("请选择是否转诊没有选择无!");
					return false;
				}
				if(referral == 0){
					$("#u152_input").val("");
				}
				if(referral == 1){
					var reasion = $.trim($("#u152_input").val());
					if(reasion == "" || reasion == null){
						alert("请输入转诊原因！");
						return false;
					}
					var dept = $("#u155_input").val();
					if(dept == null || dept == ""){
						alert("请选择转诊机构!");
						return false;
					}
					var role = $("#u158_input").val();
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
					var nextDate = $("#u161_input").val();
					//alert(nextDate);
					if(nextDate == "" || nextDate == null || nextDate == undefined){
						alert("请选择下次随访时间!");
						return false;
					}
				}
				if(orderCheck == '0'){
					$("#nextFollowingDate").attr("name","nextFollowingDate");
				}
				var book = $("#u174_input").val();
				if(book == null || book == "" || book == undefined){
					alert("请选择是否使用母子健康手册!");
					return false;
				}
				var ys = $("#u175_input").val();
				if(ys == null || ys == "" || ys == undefined){
					alert("请选择是否发放叶酸");
					return false;
				}
				if(ys == 1){
					var yNum = $("#u176_input").val();
					var tag = /^\d+(\.\d+)?$/;
					
					if(!tag.test(yNum)){
						alert("只能输入数字!");
						return false;
					}
					if(yNum == "" || yNum == null){
						alert("请输入叶酸发放数量!");
						return false;
					}
				}
				
				var BScan1 = $("#u187_input").val();
				if(BScan1 != '2'){
					$("#u123_input").val("");
				}
				var TSai1 = $("#u85_input").val();
				if(TSai1 != '2'){
					$("#u122_input").val("");
				}
				var NT1 = $("#u190_input").val();
				if(NT1 != '2'){
					$("#u191_input").val("");
				}
				var SiWei1 = $("#u194_input").val();
				if(SiWei1 != '2'){
					$("#u195_input").val("");
				}
				var NST1 = $("#u198_input").val();
				if(NST1 != '2'){
					$("#u199_input").val("");
				}
				
				
				var finishUrl = "${ctx}/prenatal/editPrenatal2ToN";
				
				$.ajax({
   					url:finishUrl,
   					type:"POST",
   					data:$('#form').serialize(),
   					success:function(data){
   						//$("#prenatalId").val(data.prenatalId);
   		  	  			showDialog_("提示","finishTan","moremiddleOver",false);
   					}
   				});
				
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
				var count = $("#count").val();
				window.location.href = "${ctx}/prenatal/2ToNPrintPreview?prenatalId="+prenatalId+"&count="+count;
				return ;
			});
			
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
	   						$("#addOrUpdate").window("close");
	   					}
	   				});
				}
				
			});
			
			//专案管理
			$("#u380").click(function(){
				var zUrl = "${ctx}/com/config/highrisk/2ToNEditRedioHighRisk"
				var prenatalId = $("#prenatalId").val();
				
				$.ajax({
   					url:zUrl,
   					type:"GET",
   					data:{prenatalId:prenatalId},
   					success:function(data){
   						debugger;
   						var str = "";
   						var cStr = "";
   						var i = 0;
   						var j = 0 ;
   						if(data.thisTerms != null && x == 0){
   							var ts = 0;
							for( ; ts < data.thisTerms.length; ts++){
								
	   							str += "<div style='position:absolute;left:0px;top:"+(24+ts*34)+"px;width:64px;"
	   							+"height:34px;text-align:center;' class='ax_单元格'><p style='position:absolute;"
	   							+"left:2px;top:10px;width:60px;word-wrap:break-word;'>"
	   							+"<span>"+(ts+1)+"</span></p></div><div style='position:absolute;"
	   							+"left:64px;top:"+(24+ts*34)+"px;width:372px;height:34px;text-align:center;' class='ax_单元格'>"
	   							+"<p style='position:absolute;left:2px;top:10px;width:368px;"
	   							+"word-wrap:break-word;'><span>"+data.thisTerms[ts].highRisk+"</span></p></div>";
	   							if(data.thisTerms[ts].correct == "1"){
	   								//将日期转化为字符串
	   								var now = new Date(data.thisTerms[ts].correctionTime);
					                var year = now.getFullYear();
					                var month =(now.getMonth() + 1).toString();
					                var day = (now.getDate()).toString();
					                if (month.length == 1) {
					                    month = "0" + month;
					                }
					                if (day.length == 1) {
					                    day = "0" + day;
					                }
					                var dateTime = year +"年"+ month +"月" +  day + "日";
	   								
	   								
		   							cStr += "<div style='position:absolute;left:480px;top:"+(303+ts*34)+"px;"
		   							+"width:100px;height:15px;' class='ax_复选框'><label for='u020_input"+ts+"'>"
		   							+"<p style='position:absolute;left:16px;top:0px;width:82px;word-wrap:break-word;'><span>未矫正  </span></p>"
		   							+"</label><input class='ux' id='u020_input"+ts+"' name='correct"+ts+"' type='radio' value='0'/></div>"
		   							+"<input type='hidden' name='correct_"+ts+"' value='"+data.thisTerms[ts].termId+"'/>"
		   							+"<div style='position:absolute;left:575px;top:"+(303+ts*34)+"px;width:212px;height:15px;'"
		   							+" class='ax_复选框'><label for='u022_input"+ts+"'><p style='position:absolute;"
		   							+"left:16px;top:0px;width:194px;word-wrap:break-word;'>"
		   							+"<span>已矫正&nbsp; &nbsp; "+dateTime+"</span></p></label><input class='ux' checked id='u022_input"+ts
		   							+"' name='correct"+ts+"' type='radio' value='1'/></div>";
	   							}else{
		   							cStr += "<div style='position:absolute;left:480px;top:"+(303+ts*34)+"px;"
		   							+"width:100px;height:15px;' class='ax_复选框'><label for='u020_input"+ts+"'>"
		   							+"<p style='position:absolute;left:16px;top:0px;width:82px;word-wrap:break-word;'><span>未矫正  </span></p>"
		   							+"</label><input class='ux' id='u020_input"+ts+"' name='correct"+ts+"' type='radio' value='0' checked/></div>"
		   							+"<input type='hidden' name='correct_"+ts+"' value='"+data.thisTerms[ts].termId+"'/>"
		   							+"<div style='position:absolute;left:575px;top:"+(303+ts*34)+"px;width:212px;height:15px;'"
		   							+" class='ax_复选框'><label for='u022_input"+ts+"'><p style='position:absolute;"
		   							+"left:16px;top:0px;width:194px;word-wrap:break-word;'>"
		   							+"<span>已矫正&nbsp; &nbsp; ${map.time}</span></p></label><input class='ux' id='u022_input"+ts
		   							+"' name='correct"+ts+"' type='radio' value='1'/></div>";
	   							}
	   						}
							
							if(ts > 2){
								
								$("#u05")[0].style.top = (386+(ts-2)*30)+"px";
								$("#u034")[0].style.top = (563+(ts-2)*30)+"px";
								$("#u036")[0].style.top = (563+(ts-2)*30)+"px";
							}
							$("#inner").html(str);
	   						$("#checkRadio").html(cStr);
   						}else if(x > 0){
   						
	   						if(data.list != null ){
		   						for( ; i < data.list.length; i++){
		   							
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
		   							+"<span>已矫正&nbsp; &nbsp; ${map.time}</span></p></label><input class='ux' id='u022_input"+i
		   							+"' name='correct"+i+"' type='radio' value='1${map.time}'/></div>";
		   						}
	   						}
	   						
	   						if(data.terms != null){
								for( ;j < data.terms.length; j++){
		   							
		   							str += "<div style='position:absolute;left:0px;top:"+(24+(i+j)*34)+"px;width:64px;"
		   							+"height:34px;text-align:center;' class='ax_单元格'><p style='position:absolute;"
		   							+"left:2px;top:10px;width:60px;word-wrap:break-word;'>"
		   							+"<span>"+(i+j+1)+"</span></p></div><div style='position:absolute;"
		   							+"left:64px;top:"+(24+(i+j)*34)+"px;width:372px;height:34px;text-align:center;' class='ax_单元格'>"
		   							+"<p style='position:absolute;left:2px;top:10px;width:368px;"
		   							+"word-wrap:break-word;'><span>"+data.terms[j].highRisk+"</span></p></div>";
		   							
		   							cStr += "<div id='u020' style='position:absolute;left:480px;top:"+(303+(i+j)*34)+"px;"
		   							+"width:100px;height:15px;' class='ax_复选框'><label for='u020_input"+(i+j)+"'>"
		   							+"<p style='position:absolute;left:16px;top:0px;width:82px;word-wrap:break-word;'><span>未矫正  </span></p>"
		   							+"</label><input class='ux' id='u020_input"+(i+j)+"' name='correct"+(i+j)+"' type='radio' value='0' checked/></div>"
		   							+"<input type='hidden' name='correct_"+(i+j)+"' value='"+data.terms[j].termId+"'/>"
		   							+"<div style='position:absolute;left:575px;top:"+(303+(i+j)*34)+"px;width:212px;height:15px;'"
		   							+" class='ax_复选框'><label for='u022_input"+(i+j)+"'><p style='position:absolute;"
		   							+"left:16px;top:0px;width:194px;word-wrap:break-word;'>"
		   							+"<span>已矫正&nbsp; &nbsp; ${map.time}</span></p></label><input class='ux' id='u022_input"+(i+j)
		   							+"' name='correct"+(i+j)+"' type='radio' value='1${map.time}'/></div>";
		   						}
	   						}
	   						var ij = i+j;
							
							if(ij > 2){
								
								$("#u05")[0].style.top = (386+(ij-2)*30)+"px";
								$("#u034")[0].style.top = (563+(ij-2)*30)+"px";
								$("#u036")[0].style.top = (563+(ij-2)*30)+"px";
							}
	   						$("#inner").html(str);
	   						$("#checkRadio").html(cStr);
	   						
   						}
						showDialog_l("高危专案管理","addZhuan","moremiddle",false);
   					}
   				});
			});
			//递归状态选中
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
				
				//正常分娩
				if(status == "1"){
					
					$("#u380").css("display","none");
					$("#u3800").css("display","block");
					$("#u375").css("background-color","#0099DF");
					$("#u376").bind("click");
					$("#u377").css("background-color","#56BB4D");
					$("#u378").bind("click");
					$("#u383").css("background-color","#34A097");
					$("#u384").bind("click");
				}
				//结束分娩
				if(status == "2"){
					$("#u375").css("background-color","#999999");
					$("#u376").unbind("click");
					$("#u377").css("background-color","#999999");
					$("#u378").unbind("click");
					$("#u383").css("background-color","#999999");
					$("#u384").unbind("click");
					var shifang = $("#jau12").html();
					$("#jau12").html("");
					$("#jau14").html("");
					$("#jau16").html("shifang");
				}
				//正常随访
				if(status == "0"){
					$("#u375").css("background-color","#0099DF");
					$("#u376").bind("click");
					$("#u377").css("background-color","#56BB4D");
					$("#u378").bind("click");
					$("#u383").css("background-color","#34A097");
					$("#u384").bind("click");
				}
				
				var saveUrl = "${ctx}/prenatal/editProjectManager";
				
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
			
			$("#u3800").live("click",function(){
				
				var birthArchivesId = $("#birthArchivesId").val();
				var archivesId = $("#archivesId").val();
				
				window.location.href = "${ctx}/highriskprojectmanagement/list?birthArchiveId="+birthArchivesId+"&archivesId="+archivesId;
				
			});
			
			//点击已结案
			$("#u382").click(function(){
				
				showDialog_("提示","closeExa","moremiddleOver",false);
				
			});
			
			//确定
			$("#jau5").click(function(){
				
				var status = $("input[name='closingReason']:checked").val();
				if(status == null && status == undefined){
					alert("请选择结案原因!");
					return false;
				}
				
				$("#closeForm").submit();
			});
			
			//取消
			$("jau3").click(function(){
				
				$("#closeExa").window("close");
			});
			
			//分娩登记
			$("#u384").click(function(){
				
				var archivesId = $("#archivesId").val();
				window.location.href = "${ctx}/archivesinfo/listChildbirth?id="+archivesId;
			});
			
			var img = $("#len").val() - 1;
			$("#u639").click(function(){
				if(img < 0){
					img = 0;
				}
				if(img == 0){
					$("#firstFet").html("<div id='u623' class='ax_文本段落'>"
				      		+"<p id='u624'><span>胎位：</span></p></div><div id='u630' class='ax_文本框'>"
					        +"<input id='u630_input' name='fetusPosition' type='text' value=''/></div>"
					        +"<div id='u625' class='ax_文本段落'><p id='u626'><span>胎心率：</span></p></div>"
					        +"<div id='u629' class='ax_文本框'><input id='u629_input' name='heartRate' type='text' value=''/>"
					  		+"</div><div id='u627' class='ax_文本段落'><p id='u628'><span>次/分钟</span></p></div>"
					  		);
				}
				if(img == 1){
					$("#secendFet").html("<div id='u631' class='ax_文本段落'>"
				      		+"<p id='u632'><span>胎位：</span></p></div><div id='u638' class='ax_文本框'>"
					        +"<input id='u638_input' name='fetusPosition' type='text' value=''/></div>"
					        +"<div id='u633' class='ax_文本段落'><p id='u634'><span>胎心率：</span></p></div>"
					        +"<div id='u637' class='ax_文本框'><input id='u637_input' name='heartRate' type='text' value=''/>"
					  		+"</div><div id='u635' class='ax_文本段落'><p id='u636'><span>次/分钟</span></p></div>"
					  		);
				}
				img ++;
			});
			$("#u641").click(function(){
				if(img > 2){
					img = 2;
				}
				if(img == 1){
					$("#firstFet").html("");
				}
				if(img == 2){
					$("#secendFet").html("");
				}
				img --;
			});
			//转诊回显
			var vc = $("#u146_input").attr("checked");
			if(vc){
				$("#u152_input")[0].readOnly = true;
				$("#u155_input")[0].selectedIndex = -1;
				$("#u155_input")[0].disabled = true;
				$("#u158_input")[0].selectedIndex = -1;
				$("#u158_input")[0].disabled = true;
			}
			//转诊点击无
			$("#u146_input").click(function(){
				$("#u152_input")[0].readOnly = true;
				$("#u155_input")[0].selectedIndex = -1;
				$("#u155_input")[0].disabled = true;
				$("#u158_input")[0].selectedIndex = -1;
				$("#u158_input")[0].disabled = true;
			});
			//转诊点击有
			$("#u148_input").click(function(){
				$("#u152_input")[0].readOnly = false;
				$("#u155_input")[0].disabled = false;
				$("#u158_input")[0].disabled = false;
			});
			$("#u166_input").click(function(){
				
				$("#u161_input")[0].disabled = true;
				//$("#nextFollowingDate").attr("name","nextFollowingDate");
				
			});
			$("#u164_input").click(function(){
				
				$("#u161_input")[0].disabled = false;
				
			});
			
			var bscan = $("#bscan").val();
			if(bscan == null || bscan == ""){
				$("#u187_input")[0].selectedIndex = -1;
			}
			
			var week = $("#birWeek").val();
			if(week >= 14 && week <= 20){
				var tangSyndrome = $("#tangSyndrome").val();
				if(tangSyndrome == null || tangSyndrome == ""){
					$("#u85_input")[0].selectedIndex = -1;
				}
			}
			if(week >= 11 && week <=13){
				var nt = $("#nt").val();
				if(nt == null || nt == ""){
					$("#u190_input")[0].selectedIndex = -1;
				}
			}
			if(week >= 22 && week <=26){
				var fourDimensional = $("#fourDimensional").val();
				if(fourDimensional == null || fourDimensional == ""){
					$("#u194_input")[0].selectedIndex = -1;
				}
			}
			var nst = $("#nst").val();
			if(nst == null || nst == ""){
				$("#u198_input")[0].selectedIndex = -1;
			}
			
			var b = $("#u148_input").attr("checked");
			if(!b){
				$("#u155_input")[0].selectedIndex = -1;
				$("#u158_input")[0].selectedIndex = -1;
			}
			
			//保存
			var ba = 0;
			$("#u376").click(function(){
				
				var listEditUrl = "${ctx}/prenatal/listEditPrenatal2ToN";
				if(ba != 0){
					return false;
				}
				$("#form").attr("action",listEditUrl);
				ba ++;
				$("#form").submit();
			});
			
			//辅助检查多出未检查项----其中约束
			//肝功能
			$("#u1030").click(function(){
				//血清谷丙
				$("#u6100")[0].checked = true;
				$("#u6100").attr("name","sgpt");
				$("#u113_input").attr("name","");
				$("#u113_input").val("");
				//血清谷草
				$("#u6300")[0].checked = true;
				$("#u6300").attr("name","sgot");
				$("#u114_input").attr("name","");
				$("#u114_input").val("");
				//白蛋白
				$("#u6500")[0].checked = true;
				$("#u6500").attr("name","albumin");
				$("#u115_input").attr("name","");
				$("#u115_input").val("");
				//总胆红素
				$("#u6700")[0].checked = true;
				$("#u6700").attr("name","totalBilirubin");
				$("#u116_input").attr("name","");
				$("#u116_input").val("");
				//结合胆红素
				$("#u11700")[0].checked = true;
				$("#u11700").attr("name","dbil");
				$("#u119_input").attr("name","");
				$("#u119_input").val("");
			});
			
			$("#u720").click(function(){
				//血清肌酐
				$("#u7500")[0].checked = true;
				$("#u7500").attr("name","scr");
				$("#u120_input").attr("name","");
				$("#u120_input").val("");
				//血尿素氮
				$("#u7900")[0].checked = true;
				$("#u7900").attr("name","bun");
				$("#u121_input").attr("name","");
				$("#u121_input").val("");
			});
			
			//血糖
			$("#u102_input").change(function(){
				var val = this.value;
				//alert(val);
				if(val != "" && val != null && val != undefined){
					$("#u102_input").attr("name","bloodGlucose");
					$("#u1300_input").attr("name","");
					$("#u1300_input")[0].checked = false;
				}
			});
			$("#u1300_input").click(function(){
				if($("#u1300_input")[0].checked){
					$("#u1300_input").attr("name","bloodGlucose");
					$("#u102_input").attr("name","");
					$("#u102_input").val("");
				}
			});
			
			//血清谷丙
			$("#u113_input").change(function(){
				var val = this.value;
				//alert(val);
				if(val != "" && val != null && val != undefined){
					$("#u113_input").attr("name","sgpt");
					$("#u6100").attr("name","");
					$("#u6100")[0].checked = false;
					$("#u1030")[0].checked = false;
				}
			});
			$("#u6100").click(function(){
				if($("#u6100")[0].checked){
					$("#u6100").attr("name","sgpt");
					$("#u113_input").attr("name","");
					$("#u113_input").val("");
				}
			});
			//血清谷草
			$("#u114_input").change(function(){
				var val = this.value;
				//alert(val);
				if(val != "" && val != null && val != undefined){
					$("#u114_input").attr("name","sgot");
					$("#u6300").attr("name","");
					$("#u6300")[0].checked = false;
					$("#u1030")[0].checked = false;
				}
			});
			$("#u6300").click(function(){
				if($("#u6300")[0].checked){
					$("#u6300").attr("name","sgot");
					$("#u114_input").attr("name","");
					$("#u114_input").val("");
				}
			});
			//白蛋白
			$("#u115_input").change(function(){
				var val = this.value;
				//alert(val);
				if(val != "" && val != null && val != undefined){
					$("#u115_input").attr("name","albumin");
					$("#u6500").attr("name","");
					$("#u6500")[0].checked = false;
					$("#u1030")[0].checked = false;
				}
			});
			$("#u6500").click(function(){
				if($("#u6500")[0].checked){
					$("#u6500").attr("name","albumin");
					$("#u115_input").attr("name","");
					$("#u115_input").val("");
				}
			});
			//总胆红素
			$("#u116_input").change(function(){
				var val = this.value;
				//alert(val);
				if(val != "" && val != null && val != undefined){
					$("#u116_input").attr("name","totalBilirubin");
					$("#u6700").attr("name","");
					$("#u6700")[0].checked = false;
					$("#u1030")[0].checked = false;
				}
			});
			$("#u6700").click(function(){
				if($("#u6700")[0].checked){
					$("#u6700").attr("name","totalBilirubin");
					$("#u116_input").attr("name","");
					$("#u116_input").val("");
				}
			});
			//结合胆红素
			$("#u119_input").change(function(){
				var val = this.value;
				//alert(val);
				if(val != "" && val != null && val != undefined){
					$("#u119_input").attr("name","dbil");
					$("#u11700").attr("name","");
					$("#u11700")[0].checked = false;
					$("#u1030")[0].checked = false;
				}
			});
			$("#u11700").click(function(){
				if($("#u11700")[0].checked){
					$("#u11700").attr("name","dbil");
					$("#u119_input").attr("name","");
					$("#u119_input").val("");
				}
			});
			//血清肌酐
			$("#u120_input").change(function(){
				var val = this.value;
				//alert(val);
				if(val != "" && val != null && val != undefined){
					$("#u120_input").attr("name","scr");
					$("#u7500").attr("name","");
					$("#u7500")[0].checked = false;
					$("#u720")[0].checked = false;
				}
			});
			$("#u7500").click(function(){
				if($("#u7500")[0].checked){
					$("#u7500").attr("name","scr");
					$("#u120_input").attr("name","");
					$("#u120_input").val("");
				}
			});
			//血尿素氮
			$("#u121_input").change(function(){
				var val = this.value;
				//alert(val);
				if(val != "" && val != null && val != undefined){
					$("#u121_input").attr("name","bun");
					$("#u7900").attr("name","");
					$("#u7900")[0].checked = false;
					$("#u720")[0].checked = false;
				}
			});
			$("#u7900").click(function(){
				if($("#u7900")[0].checked){
					$("#u7900").attr("name","bun");
					$("#u121_input").attr("name","");
					$("#u121_input").val("");
				}
			});
			
			var folateNum = $("#u176_input").val();
			if(folateNum == "" || folateNum == null){
				$("#u175_input")[0].selectedIndex = -1;
			}
			//通过末次月经和检查时间算孕周
			$("#checkTime").blur(function(){
				var lastMenses = $("#lastMenses").val();
				var checkTime = $("#checkTime").val();
				getWeek(lastMenses,checkTime,'birthWeek');
			});
    	});
    	
    	function getWeek(lastMenses,checkTime,weekId){
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
    		$("#"+weekId).html(week);
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
	            $("#"+iid).val("");
	        }
		}
    	function only(){
    		if($("#u175_input").val()=="0"){
    			$("#u176_input").val("0");
    			$("#u176_input").attr("readonly",true);
    		}else{
    			$("#u176_input").val("");
    			$("#u176_input").attr("readonly",false);
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
		<div id="title" style="background-color: #FFFFFF;border: 1px solid #CCCCCC;">
        	
            <div id="u178" class="ax_形状" style="background-color:#EE5F45">
          		<p id="u179"><span>第${count }次产前随访</span></p>
      		</div>
            
            <c:if test="${map.birthArchives.pregnantState != '1' && map.birthArchives.pregnantState != '2' }">
	            <div id="u383" class="ax_形状" style="background-color:#34A097">
	         		<p id="u384" style="cursor:pointer;"><span>分娩登记</span></p>
	      		</div>
            </c:if>
            <!-- <div id="u383" class="ax_形状" style="background-color:#34A097">
         		<p id="u384" style="cursor:pointer;"><span>分娩登记</span></p>
      		</div> -->
            <c:if test="${map.prenatal.normalSign == '1' }">
	            <div id="u381" class="ax_形状" style="background-color:#999999">
	          		<p id="u382" style="cursor:pointer;"><span>结案</span></p>
	      		</div>
      		</c:if>
            <!-- <div id="u381" class="ax_形状" style="background-color:#999999">
          		<p id="u382" style="cursor:pointer;"><span>结案</span></p>
      		</div> -->
            
            <input type="hidden" id="highRiskStatu" value="${map.birthArchives.riskSign}"/>
           <%--  <c:if test="${map.prenatal.evaluate == '0' }">
	            <c:if test="${map.correctCount == '0' }">
	      			<div id="u379" class="ax_形状"  style="display: none">
		          		<p id="u380" style="cursor:pointer;"><span>专案管理</span></p>
		          		<p id="u3800" style="cursor:pointer;display: none" ><span>专案记录</span></p>
		      		</div>
		            <div id="u3790" class="ax_形状" >
		          		<p id="u3800" style="cursor:pointer;" ><span>专案记录</span></p>
		      		</div>
	      		</c:if>
	      		<c:if test="${map.correctCount == '1' }">
	      			<div id="u379" class="ax_形状" >
		          		<p id="u380" style="cursor:pointer;"><span>专案管理</span></p>
		          		<p id="u3800" style="cursor:pointer;display: none" ><span>专案记录</span></p>
		      		</div>
	      		</c:if>
	      		<c:if test="${map.correctCount == '3' }">
	      			<div id="u379" class="ax_形状"  style="display: none">
		          		<p id="u380" style="cursor:pointer;"><span>专案管理</span></p>
		          		<p id="u3800" style="cursor:pointer;display: none" ><span>专案记录</span></p>
		      		</div>
		            <div id="u3790" class="ax_形状" >
		          		<p id="u3800" style="cursor:pointer;" ><span>专案记录</span></p>
		      		</div>
	      		</c:if>
	      	</c:if>
	      	<c:if test="${map.prenatal.evaluate == '1' }">
	      		<div id="u379" class="ax_形状" >
	          		<p id="u380" style="cursor:pointer;"><span>专案管理</span></p>
	          		<p id="u3800" style="cursor:pointer;display: none" ><span>专案记录</span></p>
	      		</div>
	      	</c:if> --%>
            <c:if test="${map.correctCount != '0' }">
	            <div id="u379" class="ax_形状" <c:if test="${map.birthArchives.riskSign != '1' }"> style="display: none" </c:if>>
	          		<p id="u380" style="cursor:pointer;"><span>专案管理</span></p>
	          		<p id="u3800" style="cursor:pointer;display: none;" ><span>专案记录</span></p>
	      		</div>
      		</c:if>
      		<c:if test="${map.correctCount == '0' }">
      			<div id="u379" class="ax_形状" >
	          		<p id="u380" style="cursor:pointer;"><span>专案管理</span></p>
	          		<p id="u3800" style="cursor:pointer;display: none;" ><span>专案记录</span></p>
	      		</div>
	            <div id="u3790" class="ax_形状" style="display: none">
	          		<p id="u3800" style="cursor:pointer;"><span>专案记录</span></p>
	      		</div>
      		</c:if>
      		<input type="hidden" id = "correctCount" value="${map.correctCount }"/>
            
            <div id="u375" class="ax_形状" style="background-color:#0099DF">
          		<p id="u376" style="cursor:pointer;"><span>保存</span></p>
      		</div>
            <div id="u377" class="ax_形状" style="background-color:#56BB4D">
          		<p id="u378" style="cursor:pointer;"><span>完成</span></p>
      		</div>
            
            
        </div>

		<div id="baseMsg">
        	<div id="u10" class="ax_文本段落">
          		<p id="u11"><span>检查医院：&nbsp;${operatorPO.department }</span></p>
      		</div>
            <div id="u12" class="ax_文本段落">
          		<p id="u13"><span>检查医生：${operatorPO.realName }</span></p>
      		</div>
            <div id="u14" class="ax_文本段落">
          		<c:if test="${map.birthArchives.referralSign != '0'}">
              		<p id="u15"><span>转诊状态：转诊</span></p>
              	</c:if>
              	<c:if test="${map.birthArchives.referralSign == '0'}">
              	 	<p id="u15"><span>转诊状态：本院</span></p>
              	</c:if>
      		</div>
            <div id="u4" class="ax_形状">
                  <p id="u5"><span>&nbsp;</span></p>
          	</div>

            
        </div>
        
        <div id="u6" class="ax_形状" style="background-color:#009DD9">
          <p id="u7"><span>个 人 基 本 信 息</span></p>
      	</div>
        
        <div id="">
            <div id="u393" class="ax_文本段落" <c:if test="${map.birthArchives.riskSign == '1' }">style="color:#EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if>>
          		<p id="u394"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${map.archives.name }</span></p>
      		</div>
            <div id="u395" class="ax_文本段落" <c:if test="${map.birthArchives.riskSign == '1' }">style="color:#EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if>>
        		<input type="hidden" name="archivesCode" value="${map.archives.archivesCode }"/>
        		<input type="hidden" id="archivesId" value="${map.archives.id }"/>
          		<p id="u396"><span>档案编号：${map.archives.archivesCode }</span></p>
      		</div>
            <div id="u407" class="ax_文本段落">
            	<input type="hidden" name="ct" value="${time }"/>
          		<p id="u408"><span>检查日期：
          		<c:if test="${map.prenatal.normalSign == '1' }">
          		<fmt:formatDate value="${map.prenatal.creatTime }" pattern="yyyyMMdd"/>
          		<input type="hidden" id="" name="checkTime" 
        		style="color:#333333;cursor:pointer;height: 20px;width: 75px;left: 62px;top: -3px;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        		class="" value="<fmt:formatDate value="${map.prenatal.creatTime }" pattern="yyyyMMdd"/>" tabindex="1" required>
        		</c:if>
          		<c:if test="${map.prenatal.normalSign == '0' }">
          		<input type="text" id="" name="checkTime" 
        		style="color:#333333;cursor:pointer;height: 20px;width: 75px;left: 62px;top: -3px;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        		class="" value="<fmt:formatDate value="${map.prenatal.creatTime }" pattern="yyyyMMdd"/>" tabindex="1" required>
        		</c:if>
          		<%-- <input type="text" id="u73_input" name="checkTime" 
        style="color:#333333;cursor:pointer;height: 20px;width: 75px;left: 62px;top: -3px;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="" value="<fmt:formatDate value="${map.prenatal.creatTime }" pattern="yyyyMMdd"/>" tabindex="1" required> --%>
        		</span></p>
      		</div>
            <div id="u391" class="ax_文本段落"><input type="hidden" id="week" value="${map.week }"/>
          		<p id="u392"><span>孕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;周：</span><span id="birthWeek">${map.week }</span></p>
      		</div>
            <input type="hidden" id="birWeek" value="${map.week }"/>
            <div id="u385" class="ax_文本段落">
          		<p id="u386"><span>出生日期：<fmt:formatDate value="${map.archives.birthday}" pattern="yyyy-MM-dd"/></span><span>&nbsp;</span></p>
      		</div>
            <div id="u397" class="ax_文本段落">
          		<p id="u398"><span>孕妇年龄：${map.age }</span></p>
      		</div>
          <div id="u387" class="ax_文本段落"><input type="hidden" id="lastMenses" value="<fmt:formatDate value="${map.birthArchives.lastMenses }" pattern="yyyyMMdd"/>"/>
          		<p id="u388"><span>末次月经：<fmt:formatDate value="${map.birthArchives.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
      	  </div>
          <div id="u389" class="ax_文本段落">
          		<p id="u390"><span>预&nbsp;&nbsp;产&nbsp;&nbsp;期：<fmt:formatDate value="${map.expectedDate }" pattern="yyyy-MM-dd"/></span></p>
   		  </div>
          
          <div id="u399" class="ax_文本段落">
          	<p id="u400"><span>联系电话：${map.archives.telephone }</span></p>
      	  </div>
          <div id="u401" class="ax_文本段落">
          	<p id="u402"><span>丈夫姓名：${map.archives.manName }</span><span>&nbsp;</span></p>
      	  </div>
          <div id="u403" class="ax_文本段落">
          	<p id="u404"><span>丈夫年龄：${map.manAge }</span></p>
      	  </div>
          <div id="u405" class="ax_文本段落">
          	<p id="u406"><span>丈夫电话：${map.archives.manTele }</span></p>
      	  </div>
            
        </div>
        
        <div id="u16" name="foldDiv1" onclick="AutoFold('foldDiv2','u19',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u17"><span>产 科 检 查</span></p>
          <p id="u19" style="left: 1126px;top:5px;"><span>收起</span></p>
      	</div>
		
        
      <div id="baseesg" name="foldDiv2" style="height: 123px">
        
        	<div id="u30" class="ax_文本段落">
       		  <p id="u31"><span>体重：</span></p>
   		</div>
            <div id="u32" class="ax_文本框">
              <input id="u32_input" type="text" name="weight" value="${map.obstetricExa.weight }"/>
            </div>
            <div id="u33" class="ax_文本段落">
          		<p id="u34"><span>kg</span></p>
      		</div>
            
            <div id="u41" class="ax_文本段落">
       		  <p id="u42"><span>血压：</span></p>
      		</div>
            <div id="u45" class="ax_文本框">
        		<input id="u45_input" name="bloodHi" type="text" value="${map.obstetricExa.bloodHi }"/>
      		</div>
            <div id="u46" class="ax_文本段落">
          		<p id="u47"><span>/</span></p>
      		</div>
            <div id="u48" class="ax_文本框">
        		<input id="u48_input" name="bloodLow" type="text" value="${map.obstetricExa.bloodLow }"/>
      		</div>
            <div id="u43" class="ax_文本段落">
          		<p id="u44"><span>mmHg</span></p>
      		</div>
            
            <div id="u20" class="ax_文本段落">
          		<p id="u21"><span>宫底高度：</span></p>
      		</div>
            <div id="u180" class="ax_文本框">
        		<input id="u180_input" name="uterusHight" type="text" value="${map.obstetricExa.uterusHight }"/>
      		</div>
            <div id="u35" class="ax_文本段落">
          		<p id="u36"><span>cm</span></p>
      		</div>
            
            <div id="u22" class="ax_文本段落">
          		<p id="u23"><span>腹围：</span></p>
      		</div>
            <div id="u183" class="ax_文本框">
        		<input id="u183_input" name="abdomen" type="text" value="${map.obstetricExa.abdomen }"/>
      		</div>
            <div id="u181" class="ax_文本段落">
          		<p id="u182"><span>cm</span></p>
      		</div>
            
            <div id="u24" class="ax_文本段落">
          		<p id="u25"><span>胎位：</span></p>
      		</div>
            <div id="u185" class="ax_文本框">
        		<input id="u185_input" name="fetusPosition" type="text" value="${map.fetus0 }"/>
      		</div>
            
            <div id="u26" class="ax_文本段落">
          		<p id="u27"><span>胎心率：</span></p>
      		</div>
            <div id="u184" class="ax_文本框">
        		<input id="u184_input" name="heartRate" type="text" value="${map.heart0 }"/>
      		</div>
            <div id="u28" class="ax_文本段落">
          		<p id="u29"><span>次/分钟</span></p>
			</div>
	        <div id="u639" class="ax_形状" style="cursor: pointer;">
	       	<img id="u639_img"  class="img" src="${ctx }/static/css/u474.png">
	         	<p id="u640" ><span>+</span></p>
	     	</div>
	        <div id="u641" class="ax_形状" style="cursor: pointer;">
	        <img id="u641_img"  class="img" src="${ctx }/static/css/u476.png">
	      		<p id="u642" ><span>-</span></p>
	     	</div>
	            
	        <div id="u2" class="ax_形状">
	   		  <p id="u3"><span>&nbsp;</span></p>
	        </div>
	        
	        <div id="firstFet">
	        	<c:if test="${map.len > 1 }">
	        		<div id="u623" class="ax_文本段落">
	          		<p id="u624"><span>胎位：</span></p>
		      		</div>
		            <div id="u630" class="ax_文本框">
		              <input id="u630_input" name="fetusPosition" type="text" value="${map.fetus1}"/>
		            </div>
		            
		            <div id="u625" class="ax_文本段落">
		          		<p id="u626"><span>胎心率：</span></p>
		      		</div>
		            <div id="u629" class="ax_文本框">
		        		<input id="u629_input" name="heartRate" type="text" value="${map.heart1 }"/>
		      		</div>
	        	</c:if>
	        </div>
	        <input type="hidden" id="len" value="${map.len }"/>
	        <div id="secendFet">
	        	<c:if test="${map.len > 2 }">
	        		<div id="u623" class="ax_文本段落">
	          		<p id="u624"><span>胎位：</span></p>
		      		</div>
		            <div id="u630" class="ax_文本框">
		              <input id="u630_input" name="fetusPosition" type="text" value="${map.fetus2}"/>
		            </div>
		            
		            <div id="u625" class="ax_文本段落">
		          		<p id="u626"><span>胎心率：</span></p>
		      		</div>
		            <div id="u629" class="ax_文本框">
		        		<input id="u629_input" name="heartRate" type="text" value="${map.heart2 }"/>
		      		</div>
	        	</c:if>
	  		</div>
        
        </div>
      
      <div id="u37" name="foldDiv3" onclick="AutoFold('foldDiv4','u40',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u38"><span>主 诉</span></p>
          <p id="u40" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        
        <div id="zhusu" name="foldDiv4" style="height: 107px;">
        	
            <div id="u186" class="ax_多行文本框">
        		<textarea id="u186_input" name="chiefComplaint">${map.prenatal.chiefComplaint }</textarea>
      		</div>
        
        </div>
        
         <div id="u49" name="foldDiv5" onclick="AutoFold('foldDiv6','u52',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u50"><span>辅 助 检 查</span></p>
          <p id="u52" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        
      	
        <div id="" name="foldDiv6" style="height: 312px;">
        	
            <div id="u57" class="ax_文本段落">
          		<p id="u58"><span>血常规：</span></p>
      		</div>
            
            <div id="u53" class="ax_文本段落">
          		<p id="u54"><span>血红蛋白值：</span></p>
      		</div>
            <div id="u89" class="ax_文本框">
        		<input id="u89_input" name="hemoglobin" type="text" value="${map.supplemetnaryExam.hemoglobin }"/>
      		</div>
            <div id="u55" class="ax_文本段落">
          		<p id="u56"><span style="font-family:'Arial Normal', 'Arial';font-weight:400;color:#333333;">g/L</span><span style="font-family:'Arial Normal', 'Arial';font-weight:400;color:#333333;">&nbsp; </span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"><span id="u56_"></span></span></p>
      		</div>
            
            <div id="u87" class="ax_文本段落">
          		<p id="u88"><span>其他：</span></p>
      		</div>
            <div id="u86" class="ax_文本框">
        		<input id="u86_input" name="bloodOthers" type="text" value="${map.supplemetnaryExam.bloodOthers }"/>
      		</div>
            
            <div id="u59" class="ax_文本段落">
          		<p id="u60"><span>尿常规：</span></p>
      		</div>
            
            <div id="u90" class="ax_文本段落">
          		<p id="u91"><span>尿蛋白：</span></p>
      		</div>
            <div id="u94" class="ax_文本框">
        		<input id="u94_input" name="proteinuria" type="text" value="${map.supplemetnaryExam.proteinuria }"/>
      		</div>
            <div id="u92" class="ax_文本段落">
          		<p id="u93"><span>g/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u93_"></span></span></p>
      		</div>
            
            <div id="u96" class="ax_文本段落">
          		<p id="u97"><span>其他：</span></p>
      		</div>
            <div id="u95" class="ax_文本框">
        		<input id="u95_input" name="urineOthers" type="text" value="${map.supplemetnaryExam.urineOthers }"/>
      		</div>
            
            <div id="u98" class="ax_文本段落">
          		<p id="u99"><span>血糖：</span></p>
      		</div>
            <div id="u102" class="ax_文本框">
        		<input id="u102_input" <c:if test="${map.supplemetnaryExam.bloodGlucose != '-1'}">name="bloodGlucose" value="${map.supplemetnaryExam.bloodGlucose }"</c:if> type="text" />
      		</div>
            <div id="u100" class="ax_文本段落">
          		<p id="u101"><span>mmol/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u101_"></span></span></p>
      		</div>
      		
      		<div style="position: absolute;left: 255px;top: 567px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u1300_input">
                    <p id="u1020_input" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u1300_input"  style="position: absolute;left: 0px;" <c:if test="${map.supplemetnaryExam.bloodGlucose == '-1'}">checked name="bloodGlucose"</c:if> type="radio" value="-1" />
      		</div>
            
            <div id="u69" class="ax_文本段落">
          		<p id="u70"><span>肝功能：</span></p>
      		</div>
            
            <div style="position: absolute;left: 143px;top: 595px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u1030">
                    <p id="u1040" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u1030" style="position: absolute;left: 0px;" type="radio" value="-1" name=""/>
      		</div>
            
            <div id="u103" class="ax_文本段落">
          		<p id="u104"><span>血清谷丙转氨酶：</span></p>
      		</div>
            
            <div id="u113" class="ax_文本框">
        		<input id="u113_input" <c:if test="${map.supplemetnaryExam.sgpt != '-1'}">name="sgpt" value="${map.supplemetnaryExam.sgpt }"</c:if> type="text" />
      		</div>
            <div id="u61" class="ax_文本段落">
          		<p id="u62"><span>U/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u106_"></span></span></p>
      		</div>
      		
      		<div style="position: absolute;left: 520px;top: 595px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u6100">
                    <p id="u6200" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u6100" <c:if test="${map.supplemetnaryExam.sgpt == '-1'}">checked name="sgpt"</c:if> style="position: absolute;left: 0px;" type="radio" value="-1" />
      		</div>
            
            <div id="u105" class="ax_文本段落">
          		<p id="u106"><span>血清谷草转氨酶：</span></p>
      		</div>
            <div id="u114" class="ax_文本框">
        		<input id="u114_input" <c:if test="${map.supplemetnaryExam.sgot != '-1'}">name="sgot" value="${map.supplemetnaryExam.sgot }"</c:if>  type="text" />
      		</div>
            <div id="u63" class="ax_文本段落">
          		<p id="u64"><span>U/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u64_"></span></span></p>
      		</div>
      		
      		<div style="position: absolute;left: 795px;top: 595px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u6300">
                    <p id="u6400" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u6300" <c:if test="${map.supplemetnaryExam.sgot == '-1'}">checked name="sgot"</c:if> style="position: absolute;left: 0px;" type="radio" value="-1" />
      		</div>
            
            <div id="u107" class="ax_文本段落">
          		<p id="u108"><span>白蛋白：</span></p>
          	</div>
          	<div id="u115" class="ax_文本框">
            	<input id="u115_input"  <c:if test="${map.supplemetnaryExam.albumin != '-1'}">name="albumin" value="${map.supplemetnaryExam.albumin }"</c:if> type="text" />
          	</div>
          	<div id="u65" class="ax_文本段落">
              <p id="u66"><span>g/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u66_"></span></span></p>
          	</div>
          	
          	<div style="position: absolute;left: 1050px;top: 595px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u6500">
                    <p id="u6600" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u6500" <c:if test="${map.supplemetnaryExam.albumin == '-1'}">checked name="albumin"</c:if> style="position: absolute;left: 0px;" type="radio" value="-1" />
      		</div>
            
            <div id="u109" class="ax_文本段落">
         		<p id="u110"><span>总胆红素：</span></p>
      		</div>
            <div id="u116" class="ax_文本框">
        		<input id="u116_input" <c:if test="${map.supplemetnaryExam.totalBilirubin != '-1'}">name="totalBilirubin" value="${map.supplemetnaryExam.totalBilirubin }"</c:if>  type="text" />
      		</div>
            <div id="u67" class="ax_文本段落">
          		<p id="u68"><span>μmol/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u68_"></span></span></p>
      		</div>
      		
      		<div style="position: absolute;left: 520px;top: 624px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u6700">
                    <p id="u6800" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u6700" <c:if test="${map.supplemetnaryExam.totalBilirubin == '-1'}">checked name="totalBilirubin"</c:if> style="position: absolute;left: 0px;" type="radio" value="-1" />
      		</div>
            
            <div id="u111" class="ax_文本段落">
          		<p id="u112"><span>结合胆红素：</span></p>
      		</div>
            <div id="u119" class="ax_文本框">
        		<input id="u119_input"  <c:if test="${map.supplemetnaryExam.dbil != '-1'}">name="dbil" value="${map.supplemetnaryExam.dbil }"</c:if> type="text" />
      		</div>
            <div id="u117" class="ax_文本段落">
          		<p id="u118"><span>μmol/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u118_"></span></span></p>
      		</div>
      		
      		<div style="position: absolute;left: 795px;top: 624px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u11700">
                    <p id="u11800" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u11700" <c:if test="${map.supplemetnaryExam.dbil == '-1'}">checked name="dbil"</c:if> style="position: absolute;left: 0px;" type="radio" value="-1"/>
      		</div>
            
            <div id="u71" class="ax_文本段落">
          		<p id="u72"><span>肾功能：</span></p>
      		</div>
      		
      		<div style="position: absolute;left: 143px;top: 656px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u720">
                    <p id="u710" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u720" style="position: absolute;left: 0px;" type="radio" value="-1" name=""/>
      		</div>
            
            <div id="u73" class="ax_文本段落">
          		<p id="u74"><span>血清肌酐：</span></p>
      		</div>
            <div id="u120" class="ax_文本框">
        		<input id="u120_input" <c:if test="${map.supplemetnaryExam.scr != '-1'}">name="scr" value="${map.supplemetnaryExam.scr }"</c:if>  type="text" />
      		</div>
            <div id="u75" class="ax_文本段落">
          		<p id="u76" ><span>μmol/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u76_"></span></span></p>
      		</div>
            <div style="position: absolute;left: 520px;top: 656px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u7500">
                    <p id="u7600" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u7500" <c:if test="${map.supplemetnaryExam.scr == '-1'}">checked name="scr"</c:if> style="position: absolute;left: 0px;" type="radio" value="-1" />
      		</div>
            <div id="u77" class="ax_文本段落">
          		<p id="u78"><span>血尿素氮：</span></p>
      		</div>
            <div id="u121" class="ax_文本框">
        		<input id="u121_input" <c:if test="${map.supplemetnaryExam.bun != '-1'}">name="bun" value="${map.supplemetnaryExam.bun }"</c:if>  type="text" />
      		</div> 
            <div id="u79" class="ax_文本段落">
          		<p id="u80"><span>mmol/L</span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;">&nbsp;<span id="u80_"></span></span></p>
      		</div>
      		<div style="position: absolute;left: 795px;top: 656px;width: 80px;height: 15px;" class="ax_单选按钮">
                <label for="u7900">
                    <p id="u8000" style="position: absolute;left: 15px;"><span>&nbsp;未检查</span></p>
                </label>
                <input id="u7900" <c:if test="${map.supplemetnaryExam.bun == '-1'}">checked name="bun"</c:if> style="position: absolute;left: 0px;" type="radio" value="-1" />
      		</div>
            
            
            <div id="u81" class="ax_文本段落">
          		<p id="u82"><span>B超：</span></p>
      		</div>
            <div id="u187" class="ax_下拉列表框">
            	<input type="hidden" value="${map.supplemetnaryExam.bscan}" id="bscan"/>
                <select id="u187_input" class="test" name="bscan">
                  <option value="1" <c:if test="${map.supplemetnaryExam.bscan == '1'}">selected</c:if> >无异常</option>
                  <option value="2" <c:if test="${map.supplemetnaryExam.bscan == '2'}">selected</c:if>>有异常</option>
                  <option value="0" <c:if test="${map.supplemetnaryExam.bscan == 0}">selected</c:if>>未检查</option>
                </select>
      		</div>
          <div id="u123" class="ax_文本框">
        		<input id="u123_input" class="u187_input" <c:if test="${map.supplemetnaryExam.bscan != '2' }">style="display: none"</c:if>  name="bscanRemark" type="text" placeholder="异常时显示输入框" value="${map.supplemetnaryExam.bscanRemark}"/>
      		</div>
            <c:if test="${map.week >= 14 && map.week <=20 }">
	            <div id="u83" class="ax_文本段落">
	          		<p id="u84"><span>唐筛：</span></p>
		  	  	</div>
	            <div id="u85" class="ax_下拉列表框">
	            	<input type="hidden" value="${map.supplemetnaryExam.tangSyndrome}" id="tangSyndrome"/>
	                <select id="u85_input" class="test" name="tangSyndrome" <c:if test="${map.supplemetnaryExam.tangSyndrome == null }">class="selt"</c:if>>
	                  <option value="1" <c:if test="${map.supplemetnaryExam.tangSyndrome == '1'}">selected</c:if>>无异常</option>
	                  <option value="2" <c:if test="${map.supplemetnaryExam.tangSyndrome == '2'}">selected</c:if>>有异常</option>
	                  <option value="0" <c:if test="${map.supplemetnaryExam.tangSyndrome == '0'}">selected</c:if>>未检查</option>
	                </select>
	      		</div>
	            <div id="u122" class="ax_文本框">
	        		<input id="u122_input" class="u85_input" <c:if test="${map.supplemetnaryExam.tangSyndrome != '2'}">style="display: none"</c:if> name="tangSyndromeRemark" type="text" placeholder="异常时显示输入框" value="${map.supplemetnaryExam.tangSyndromeRemark}"/>
	      		</div>
      		</c:if>
            
            <c:if test="${map.week >= 11 && map.week <=13 }">
	            <div id="u83" class="ax_文本段落">
	          		<p id="u189"><span>&nbsp;NT：</span></p>
		  	  	</div>
	            <div id="u85" class="ax_下拉列表框">
	            	<input type="hidden" value="${map.supplemetnaryExam.nt}" id="nt"/>
	                <select id="u190_input" class="test" name="nt" <c:if test="${map.supplemetnaryExam.nt == null }">class="selt"</c:if>>
	                  <option value="1" <c:if test="${map.supplemetnaryExam.nt == '1'}">selected</c:if>>无异常</option>
	                  <option value="2" <c:if test="${map.supplemetnaryExam.nt == '2'}">selected</c:if>>有异常</option>
	                  <option value="0" <c:if test="${map.supplemetnaryExam.nt == '0'}">selected</c:if>>未检查</option>
	                </select>
	      		</div>
	            <div id="u122" class="ax_文本框">
	        		<input id="u191_input" class="u190_input" <c:if test="${map.supplemetnaryExam.nt != '2'}">style="display: none"</c:if> name="ntRemark" type="text" placeholder="异常时显示输入框" value="${map.supplemetnaryExam.ntRemark}"/>
	      		</div>
            </c:if>
            <c:if test="${map.week >= 22 && map.week <=26 }">
	            <div id="u83" class="ax_文本段落">
	          		<p id="u193"><span>四维：</span></p>
		  	  	</div>
	            <div id="u85" class="ax_下拉列表框">
	            	<input type="hidden" value="${map.supplemetnaryExam.fourDimensional}" id="fourDimensional"/>
	                <select id="u194_input" class="test" name="fourDimensional">
	                  <option value="1" <c:if test="${map.supplemetnaryExam.fourDimensional == '1'}">selected</c:if>>无异常</option>
	                  <option value="2" <c:if test="${map.supplemetnaryExam.fourDimensional == '2'}">selected</c:if>>有异常</option>
	                  <option value="0" <c:if test="${map.supplemetnaryExam.fourDimensional == '0'}">selected</c:if>>未检查</option>
	                </select>
	      		</div>
	            <div id="u122" class="ax_文本框">
	        		<input id="u195_input" class="u194_input" <c:if test="${map.supplemetnaryExam.fourDimensional != '2'}">style="display: none"</c:if> name="fourDimensionalRemark" type="text" placeholder="异常时显示输入框" value="${map.supplemetnaryExam.fourDimensionalRemark}"/>
	      		</div>
            </c:if>
            <div id="u196" class="ax_文本段落">
          		<p id="u197"><span>NST：</span></p>
   		  	</div>
            
            <div id="u198" class="ax_下拉列表框">
            	<input type="hidden" value="${map.supplemetnaryExam.nst}" id="nst"/>
                <select id="u198_input" class="test"  name="nst">
                  <option value="1" <c:if test="${map.supplemetnaryExam.nst == '1'}">selected</c:if>>无异常</option>
                  <option value="2" <c:if test="${map.supplemetnaryExam.nst == '2'}">selected</c:if>>有异常</option>
                  <option value="0" <c:if test="${map.supplemetnaryExam.nst == '0'}">selected</c:if>>未检查</option>
                </select>
      		</div>
            <div id="u199" class="ax_文本框">
        		<input id="u199_input" class="u198_input" <c:if test="${map.supplemetnaryExam.nst != '2'}">style="display: none"</c:if>  type="text" name="nstRemark" placeholder="异常时显示输入框" value="${map.supplemetnaryExam.nstRemark}"/>
      		</div>
            
            <div id="u200" class="ax_文本段落">
          		<p id="u201"><span>其他：</span></p>
      		</div>
            <div id="u202" class="ax_多行文本框">
        		<textarea id="u202_input" name="others">${map.supplemetnaryExam.others}</textarea>
      		</div>
            
            
        </div>
        
        <div id="u124" name="foldDiv7" onclick="AutoFold('foldDiv8','u127',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u125"><span>总 体 评 估</span></p>
          <p id="u127" style="top: 5px; left: 1126px;"><span>收起</span></p>
        </div>
        
        <div name="foldDiv8" style="height: 43px;">
        	
            <div id="u128" class="ax_文本段落">
          		<p id="u129"><span>总体评估：</span></p>
      		</div>
            <div id="u130" class="ax_单选按钮">
                <label for="u130_input">
                    <p id="u131"><span>&nbsp;未见异常</span></p>
                </label>
                <input id="u130_input" type="radio" <c:if test="${map.correct == '1'}">disabled="disabled"</c:if> <c:if test="${map.prenatal.evaluate == '0'}">checked="checked"</c:if> value="0" name="evaluate"/>
      		</div>
            <div id="u132" class="ax_单选按钮">
                <label for="u132_input">
                    <p id="u133"><span>&nbsp;异常</span></p>
                </label>
                <input id="u132_input" type="radio" <c:if test="${map.prenatal.evaluate == '1'}">checked="checked"</c:if> value="1" name="evaluate"/>
      		</div>
      		<c:if test="${map.prenatal.evaluate != '1'}">
	            <div id="u134" class="ax_下拉列表框" style="display: none;">
	                <p id="u134_input" style="cursor:pointer;background-color: #EE5F45"><span>异常选项</span></p>
	      		</div>
      		</c:if>
      		<c:if test="${map.prenatal.evaluate == '1'}">
	            <div id="u134" class="ax_下拉列表框">
	                <p id="u134_input" style="cursor:pointer;background-color: #EE5F45"><span>异常选项</span></p>
	      		</div>
      		</c:if>
      		<div id="u4310">
        		<p id="u43100"></p>
        	</div>
            
        </div>
        <div id="u135"  name="foldDiv9" onclick="AutoFold('foldDiv10','u138',14)"  class="ax_形状" style="background-color:#009DD9">
          <p id="u136"><span>保 健 指 导</span></p>
          <p id="u138" style="top: 5px; left: 1126px;"><span>收起</span></p>
      	</div>
        <div name="foldDiv10" style="height: 148px;">
	        <div id="u139" class="ax_多行文本框">
	        	<textarea id="u139_input" name="guidance">${map.prenatal.guidance }</textarea>
	      	</div>
        </div>
        <div id="u140" name="foldDiv11" onclick="AutoFold('foldDiv12','shouqi',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u141"><span>转 诊</span></p>
          <p id="shouqi" style="top: 5px; left: 1126px;position:absolute;"><span>收起</span></p>
      	</div>
        
        <div name="foldDiv12" style="height: 198px;">
        	
            <div id="u144" class="ax_文本段落">
          		<p id="u145"><span>转诊：</span></p>
      		</div>
            <div id="u146" class="ax_单选按钮">
                <label for="u146_input">
                    <p id="u147"><span> 无</span></p>
                </label>
                <input id="u146_input" type="radio" <c:if test="${map.prenatalReferral.referral == '0' }">checked="checked"</c:if> value="0" name="referral"/>
      		</div>
            <div id="u148" class="ax_单选按钮">
                <label for="u148_input">
                    <p id="u149"><span> 有</span></p>
                </label>
                <input id="u148_input" type="radio" <c:if test="${map.prenatalReferral.referral == '1' }">checked="checked"</c:if> value="1" name="referral"/>
      		</div>
            
            <div id="u150" class="ax_文本段落">
          		<p id="u151"><span>原因：</span></p>
      		</div>
            <div id="u152" class="ax_文本框">
        		<input id="u152_input" type="text" name="reason" value="${map.prenatalReferral.reason}"/>
      		</div>
            
            <div id="u153" class="ax_文本段落">
          		<p id="u154"><span>转诊机构：</span></p>
      		</div>
            <div id="u155" class="ax_下拉列表框">
                <select id="u155_input" name="mechanism">
	                <c:forEach items="${depts }" var="dept">
	            		<option value="${dept.id }" <c:if test="${map.prenatalReferral.mechanism== dept.id }">selected</c:if>>${dept.name }</option>
	            	</c:forEach>
                </select>
      		</div>
            
            <div id="u156" class="ax_文本段落">
          		<p id="u157"><span>转诊科室</span><span>：</span></p>
      		</div>
            <div id="u158" class="ax_下拉列表框">
                <select id="u158_input" name="department">
                	<c:forEach items="${roles }" var="role">
            			<option value="${role.id }" <c:if test="${map.prenatalReferral.department == role.id }">selected</c:if>>${role.name }</option>
            		</c:forEach>
                </select>
      		</div>
            
            <div id="u159" class="ax_文本段落">
          		<p id="u160"><span>下次随访日期：</span></p>
      		</div>
            <div id="u161" class="ax_下拉列表框">
            	<input id="nextFollowingDate" type="hidden" value=""/>
                <input type="text" id="u161_input" name="nextFollowingDate" readonly 
        	style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="Wdate" value="<fmt:formatDate value="${map.prenatalReferral.nextFollowingDate}" pattern="yyyyMMdd"/>" tabindex="1" required>
      		</div>
            
            <div id="u162" class="ax_文本段落">
          		<p id="u163"><span>是否预约下次检查：</span></p>
      		</div>
            <div id="u164" class="ax_单选按钮">
                <label for="u164_input">
                    <p id="u165"><span> 是</span></p>
                </label>
                <input id="u164_input" type="radio" <c:if test="${map.prenatalReferral.orderCheck == '1' }">checked="checked"</c:if> value="1" name="orderCheck" />
          	</div>>
          	<div id="u166" class="ax_单选按钮">
                <label for="u166_input">
                    <p id="u167"><span> 否</span></p>
                </label>
                <input id="u166_input" type="radio" <c:if test="${map.prenatalReferral.orderCheck == '0' }">checked="checked"</c:if> value="0" name="orderCheck" />
      		</div>
            
            <div id="u177" class="ax_水平线">
        		<hr id="u177_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      		</div>
            
            <div id="u168" class="ax_文本段落">
          		<p id="u169"><span>母子健康手册使用：</span></p>
      		</div>
            <div id="u174" class="ax_下拉列表框">
                <select id="u174_input" name="healthHandbook">
                  <option value="1" <c:if test="${map.prenatalReferral.healthHandbook == '1' }">selceted</c:if>>是</option>
                  <option value="0" <c:if test="${map.prenatalReferral.healthHandbook == '0' }">selceted</c:if>>否</option>
                </select>
      		</div>
            
            <div id="u170" class="ax_文本段落">
          		<p id="u171"><span>叶酸发放：</span></p>
      		</div>
            <div id="u175" class="ax_下拉列表框">
                <select id="u175_input" onchange="only()">
                  <option value="1" <c:if test="${map.prenatalReferral.folateNum != '0' && map.prenatalReferral.folateNum != null}">selected</c:if>>是</option>
                  <option value="0" <c:if test="${map.prenatalReferral.folateNum == '0' }">selected</c:if>>否</option>
                </select>
      		</div>
            
            <div id="u172" class="ax_文本段落">
          		<p id="u173"><span>发放数量：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;瓶</span></p>
      		</div>
            <div id="u176" class="ax_文本框">
        		<input id="u176_input" <c:if test="${map.prenatalReferral.folateNum == '0' }">readonly</c:if> name="folateNum" type="text" placeholder="填写数量" value="${map.prenatalReferral.folateNum}"/>
      		</div>
        
        </div>
        <input type="hidden" id="prenatalId" name="prenatalId" value="${map.prenatal.id }"/>
        <div id="u203" name="foldDiv13" onclick="AutoFold('foldDiv14','u206',14)" class="ax_形状" style="background-color:#006EBC">
          <p id="u204"><span>历 史 检 查 记 录</span></p>
          <p id="u206" style="top: 5px;left: 1126px;"><span>收起</span></p>
      	</div>
      
      <!-- <div id="u409" class="ax_动态面板"> -->
        <div id="u409_state0" name="foldDiv14" style="height: 220px;" class="panel_state" data-label="State1">
          <!-- <div id="u409_state0_content" class="panel_state_content"> -->
            <div id="u412" class="ax_表格">
            	<!-- <div id="u410" class="ax_形状">
					<p id="u411"><span>&nbsp;</span></p>
				</div> -->
            	<table width="1500"> 
                      <tr>
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">次数</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="100">
                          <p><span style="color: white;font-weight: bold;">检查日期</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">孕周</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">主诉</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">血压</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40"> 
                          <p><span style="color: white;font-weight: bold;">体重</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">宫高</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">腹围</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">胎方位</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">胎心率</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">先露</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">浮肿</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">血红蛋白</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">尿蛋白</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">血糖</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">唐筛</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">NT</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">四维</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">B超</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">NST</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="100">
                 		   <p><span style="color: white;font-weight: bold;">其他（肝功、肾功、免疫）</span></p>
              		  </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">高危评分</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="80">
                          <p><span style="color: white;font-weight: bold;">高危因素</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">分类</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">转诊</span></p>
                      </td> 
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="100">
                          <p><span style="color: white;font-weight: bold;">下次随访日期</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">产检检查单位</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">随访医生</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">指导</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">操作</span></p>
                      </td>
                  </tr>     
     <!--  --------------------------------------------------------------------------------  -->                  
                      
                      
                      
     
 				<!-- ----------------需要遍历的历史检查记录-------------------------------- -->
 			<%int i = 1; %>
        <c:forEach items="${historyChecks }" var="historyCheck">
                      <!-- Unnamed (单元格) -->
                      <tr>
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span><%=i++ %></span></p>
                      </td>
                      <c:if test="${historyCheck.checkDate!=null }">
                       <td  style="border:0.5px solid #A6A6A6">
                          <p><span><fmt:formatDate value="${historyCheck.checkDate }" pattern="yyyy-MM-dd"/></span></p>
                      </td>
                      </c:if>
        			<c:if test="${historyCheck.checkDate==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
       				 </c:if>
       				 <c:if test="${historyCheck.pregnancyWeeks!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.pregnancyWeeks }</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.pregnancyWeeks==null }">
                      	<td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      	</td>
                      </c:if>
        
                      <c:if test="${historyCheck.chiefComplaint!=null }">
	                      <td  style="border:0.5px solid #A6A6A6">
	                          <p><span>${historyCheck.chiefComplaint }</span></p>
	                      </td>
       				 </c:if>
       				  <c:if test="${historyCheck.chiefComplaint==null }">
	                      <td  style="border:0.5px solid #A6A6A6">
	                          <p><span>-</span></p>
	                      </td>
       				 </c:if>
       				 
       				  <c:if test="${historyCheck.bloodLow!=null || historyCheck.bloodHi!=null }">
	                      <td  style="border:0.5px solid #A6A6A6">
	                          <p><span>${historyCheck.bloodHi }/${historyCheck.bloodLow }</span></p>
	                      </td>
       				 </c:if>
       				 
       				  <c:if test="${historyCheck.bloodLow==null && historyCheck.bloodHi==null }">
	                      <td  style="border:0.5px solid #A6A6A6">
	                          <p><span>-</span></p>
	                      </td>
       				 </c:if>
       				 <c:if test="${historyCheck.weight!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.weight }</span></p>
                      </td>
			        </c:if>
			         <c:if test="${historyCheck.weight==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
			        </c:if>
			        
			         <c:if test="${historyCheck.uterusHight!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.uterusHight }</span></p>
                      </td>
        			 </c:if>
        			   <c:if test="${historyCheck.uterusHight==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
        			 </c:if>
                       <c:if test="${historyCheck.abdomen!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.abdomen }</span></p>
                      </td>
                      </c:if>
                          <c:if test="${historyCheck.abdomen==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.fetusPosition!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.fetusPosition }</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.fetusPosition==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                       <c:if test="${historyCheck.heartRate!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.heartRate }</span></p>
                      </td>
                       </c:if>
                                <c:if test="${historyCheck.heartRate==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
         <c:if test="${historyCheck.present!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.present }</span></p>
                      </td>
        </c:if>
             <c:if test="${historyCheck.present==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
        </c:if>
                      <c:if test="${historyCheck.edema!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.edema }</span></p>
                      </td>
                       </c:if>
                         <c:if test="${historyCheck.edema==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
        
         <c:if test="${historyCheck.hemoglobin!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.hemoglobin }</span></p>
                      </td>
         </c:if>
           <c:if test="${historyCheck.hemoglobin==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
         </c:if>
                       <c:if test="${historyCheck.proteinuria!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.proteinuria }</span></p>
                      </td>
                      </c:if>
                         <c:if test="${historyCheck.proteinuria==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.bloodGlucose!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span><c:if test="${historyCheck.bloodGlucose == '-1' }">未检查</c:if>
                          <c:if test="${historyCheck.bloodGlucose != '-1' }">${historyCheck.bloodGlucose }</c:if></span></p>
                      </td>
                       </c:if>
                          <c:if test="${historyCheck.bloodGlucose==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
        
                     <c:if test="${historyCheck.tangSyndrome==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.tangSyndrome==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.tangSyndrome==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.tangSyndrome==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
                      
                       <c:if test="${historyCheck.NT==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.NT==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.NT==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.NT==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                               <c:if test="${historyCheck.fourDimensional==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.fourDimensional==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.fourDimensional==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.fourDimensional==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                                  <c:if test="${historyCheck.bScan==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.bScan==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.bScan==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.bScan==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
                      
                     <c:if test="${historyCheck.NST==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.NST==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.NST==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.NST==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.others!=null}">
                      <td  style="border:0.5px solid #A6A6A6" >
                          <div  class="autocut" onmouseover="this.className='autocut1'" onmouseout="this.className='autocut'">${historyCheck.others }</div>

                      </td>
                     
                      </c:if>
                       <c:if test="${historyCheck.others==null}">
                      <td  style="border:0.5px solid #A6A6A6" >
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                       <c:if test="${historyCheck.score!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.score }</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.score==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.highRisk!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <div class="autocut" onmouseover="this.className='autocut1'" onmouseout="this.className='autocut'">${historyCheck.highRisk }</div>
                      </td>
                      </c:if>
                      
                         <c:if test="${historyCheck.highRisk==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.evaluate==0 || historyCheck.evaluate==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未见异常</span></p>
                      </td>
                      </c:if>
                         <c:if test="${historyCheck.evaluate==1}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
        
                       <c:if test="${historyCheck.referral==0 || historyCheck.referral==null}">
                      <td style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
                          <c:if test="${historyCheck.referral==1}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>转诊</span></p>
                      </td>
                      </c:if>
        
                     <c:if test="${historyCheck.nextFollowingDate!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span><fmt:formatDate value="${historyCheck.nextFollowingDate }" pattern="yyyy-MM-dd"/></span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.nextFollowingDate==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.hospital!=null }">
                      <td style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.hospital }</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.hospital==null}">
                      <td style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.doctorName!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.doctorName }</span></p>
                      </td>
                       </c:if>
                        <c:if test="${historyCheck.doctorName==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
        
                       <c:if test="${historyCheck.guidance!=null && historyCheck.guidance!=''}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p class="autocut" onmouseover="this.className='autocut1'" onmouseout="this.className='autocut'"><span>${historyCheck.guidance }</span></p>
                      </td>
                       </c:if>
                        <c:if test="${historyCheck.guidance==null || historyCheck.guidance==''}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
                       <c:if test="${historyCheck.type==0}">
	                      <!-- Unnamed (单元格) -->
	                      <td  style="background-color:#009DD9;border:0.5px solid #A6A6A6;cursor: pointer;" onclick="window.location.href='${ctx}/prenatal/prenatalExaDetails?prenatalId=${historyCheck.checkId}&count=<%=i-1 %>'">
	                          <p><span>详情</span></p>
	                      </td>
                      </c:if>
                      </tr>
               </c:forEach>
               </table>
            
            </div>
          </div>
       <!--  </div>
      </div> -->
      
      
      
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
		<div id="cssAuto" style="overflow-y: auto;OVERFLOW-X:hidden;width: 860px;height: 620px;position: absolute;top: 0px;">

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
              <option <c:if test="${map.highRisk.lapseTo == '0' }">selected</c:if> value="0">继续监护</option>
              <option <c:if test="${map.highRisk.lapseTo == '2' }">selected</c:if> value="2">结束分娩</option>
              <option <c:if test="${map.highRisk.lapseTo == '1' }">selected</c:if> value="1">正常随访</option>
            </select>
      	</div>
        
        <div id="u032" class="ax_形状" style="background-color:#999999">
          <p id="u033"><span>本次检查结果</span></p>
      	</div>
		<div id="u06" class="ax_多行文本框">
        	<textarea id="u06_input" name="result">${map.highRisk.result }</textarea>
      	</div>
      	<input type="hidden" name="highRiskInfoId" value="${map.highRisk.id }"/>
      	<div id="u027" class="ax_垂直线">
       		<hr id="u027_line" style="weight:1px;border:none;border-left:1px solid #999999;"/>
      	</div>
        
        <div id="u030" class="ax_形状" style="background-color:#999999">
          <p id="u031"><span>诊断结果</span></p>
      	</div>
        
        <div id="u024" class="ax_多行文本框">
        	<textarea id="u024_input" name="diaResult">${map.highRisk.diaResult }</textarea>
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
        <textarea id="u05_input" name="scheme">${map.highRisk.scheme }</textarea>
      </div>

      
      <div id="u034" class="ax_形状" style="background-color:#E9854F">
          <p id="u035" style="cursor:pointer" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${map.birthArchives.id }&archivesId=${map.birthArchives.archivesId }'"><span>专案记录</span></p>
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

      <!-- <div id="u004" class="ax_形状" style="background-color:#EE5F45">
          <p id="u005"><span>提&nbsp; &nbsp; 示</span></p>
      </div> -->

      <div id="u006" class="ax_形状" style="background-color:#009DD9">
          <p id="u007" style="cursor:pointer"><span>否</span></p>
      </div>
		
		<input type="hidden" id="count" value="${count }"/>
      <div id="u008" class="ax_形状" style="background-color:#E9854F">
          <p id="u009" style="cursor:pointer"><span>是</span></p>
      </div>
    </div>
    <input type="hidden" name="birthId" value="${map.birthArchives.id }"/>
     <div id="closeExa" class="easyui-dialog" title="角色" closed="true">
		<form id="closeForm" action="${ctx }/prenatal/closeExa" method="post">
		<!-- <div id="jau8" class="ax_形状" style="background-color:#EE5F45">
          <p id="jau9"><span>提&nbsp; &nbsp; 示</span></p>
      	</div> -->
        
        <div id="jau6" class="ax_文本段落">
          <p id="jau7"><span>请选择结案原因：</span></p>
      	</div>
        
        <div id="jau10" class="ax_单选按钮">
            <label for="u10_input">
                <p id="jau11"><span> 流产</span></p>
            </label>
            <input id="jau10_input" type="radio" value="1" name="closingReason"/>
      	</div>
        
        <div id="jau12" class="ax_单选按钮">
            <label for="u12_input">
                <p id="jau13"><span> 引产</span></p>
            </label>
            <input id="jau12_input" type="radio" value="2" name="closingReason"/>
      	</div>
        
         <div id="jau14" class="ax_单选按钮">
            <label for="u14_input">
                <p id="jau15"><span> 失访</span></p>
            </label>
            <input id="jau14_input" type="radio" value="3" name="closingReason"/>
      	</div>
        
         <div id="jau16" class="ax_单选按钮">
            <label for="u16_input">
                <p id="jau17"><span> 其他</span></p>
            </label>
            <input id="jau16_input" type="radio" value="4" name="closingReason"/>
      	</div>
        <input type="hidden" name="birthId" value="${map.birthArchives.id }"/>
        <div id="jau4" class="ax_形状" style="background-color:#e9854f">
          <p id="jau5" style="cursor:pointer;"><span>确定</span></p>
      	</div>
        
        <div id="jau2" class="ax_形状" style="background-color:#009DD9">
          <p id="jau3" style="cursor:pointer;"><span>取消</span></p>
      	</div>
     </form>
     	<input type="hidden" id="birthArchivesId" value="${map.birthArchives.id }"/>
    </div>
	
  </body>
</html>
