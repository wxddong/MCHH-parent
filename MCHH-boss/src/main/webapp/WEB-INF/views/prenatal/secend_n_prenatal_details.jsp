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
		position:fixed;
		left: 30px;
		top: 40px;
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
		  width:132px;
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
		#u3610 {
		  position:absolute;
		  left:733px;
		  top:6px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u3620 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u3630 {
		  position:absolute;
		  left:956px;
		  top:6px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u3640 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
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
    <link href="${ctx}/static/css/secendNprenatalDatails_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
      
    	$(function(){
    		
    		$("#u16").click();
    		$("#u37").click();
    		$("#u49").click();
    		$("#u124").click();
    		$("#u135").click();
    		$("#u140").click();
    		
    		window.onload = function(){
				var radios = $("input[name='evaluate']");
				for (var i = 0; i < radios.length; i++) {
					radios[i].onclick = function(){
						var status = $("input[name='evaluate']:checked").val();
						if(status == 0){
							$("#u134").css("display","none");
							$("#u379").css("display","none");
							$("#u394").css("color","#000000");
							$("#u396").css("color","#000000");
							
						}else{
							$("#u134").css("display","block");
							$("#u379").css("display","block");
							$("#u394").css("color","#EE5F45");
							$("#u396").css("color","#EE5F45");
						}
					};
				}
    		};
    	});	
			
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
		<div id="title" style="background-color: #FFFFFF;border: 1px solid #CCCCCC;">
        	
            <div id="u178" class="ax_形状" style="background-color:#EE5F45">
          		<p id="u179"><span>第${count }次产前随访记录</span></p>
      		</div>
            
            <c:if test="${map.birthArchives.riskSign == '1' }">
	            <div id="u379" class="ax_形状" style="background-color:#E9854F;">
	          		<p id="u380" style="cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${map.birthArchives.id }&archivesId=${map.birthArchives.archivesId }'"><span>专案记录</span></p>
	      		</div>
            </c:if>
            
            <c:if test="${map.birthArchives.pregnantState != '2' }">
            <c:if test="${operatorPO.id == operator.id || operator.id == adminId || operator.id == doctorAdminId}">
	            <div id="u375" class="ax_形状" style="background-color:#56BB4D">
	          		<p id="u376" style="cursor:pointer;" onclick="window.location.href='${ctx}/prenatal/2ToNPrenatalEdit?prenatalId=${map.prenatal.id }&count=${count }'"><span>编辑</span></p>
	      		</div>
            </c:if>
            </c:if>
            <%-- <div id="u377" class="ax_形状" style="background-color:#56BB4D">
          		<p id="u378" style="cursor:pointer;"onclick="window.location.href='${ctx}/prenatal/2ToNPrintPreview?prenatalId=${map.prenatal.id }&count=${count }'"><span>第${count }次产前随访记录表</span></p>
      		</div> --%>
            <div id="u3610" onclick="window.location.href='${ctx}/prenatal/2ToNPrintPreview?prenatalId=${map.prenatal.id }&count=${count }&go=0'" class="ax_形状" style="cursor: pointer;background-color: #009Ed7">
			<p id="u3620">
				<span>产前随访记录表</span>
			</p>
			</div>
			<div id="u3630" onclick="window.location.href='${ctx}/prenatal/2ToNPrintPreview?prenatalId=${map.prenatal.id }&count=${count }&go=1'" class="ax_形状" style="cursor: pointer;background-color: #009Ed7">
				<p id="u3640">
				<span>产前检查反馈单</span></p>
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
          		<p id="u408"><span>检查日期：<fmt:formatDate value="${map.prenatal.creatTime }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            <div id="u391" class="ax_文本段落">
          		<p id="u392"><span>孕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;周：</span><span id="week">${map.week }</span></p>
      		</div>
            
            <div id="u385" class="ax_文本段落">
          		<p id="u386"><span>出生日期：<fmt:formatDate value="${map.archives.birthday}" pattern="yyyy-MM-dd"/></span><span>&nbsp;</span></p>
      		</div>
            <div id="u397" class="ax_文本段落">
          		<p id="u398"><span>孕妇年龄：${map.age }</span></p>
      		</div>
          <div id="u387" class="ax_文本段落">
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
        
		<div id="u16" name="foldDiv1" onclick="AutoFold('foldDiv2','u19',12)" class="ax_形状" style="background-color:#009DD9">
          <p id="u17"><span>产 科 检 查</span></p>
          <p id="u19" style="left: 1126px;top:5px;"><span>收起</span></p>
      	</div>
        
      <div id="baseesg" name="foldDiv2" style="height: 123px">
        
        	<div id="u30" class="ax_文本段落">
       		  <p id="u31"><span>体重：</span></p>
   		</div>
            <div id="u32" class="ax_文本框">
              <p id="u32_input">${map.obstetricExa.weight }</p>
            </div>
            <div id="u33" class="ax_文本段落">
          		<p id="u34"><span>kg</span></p>
      		</div>
            
            <div id="u41" class="ax_文本段落">
       		  <p id="u42"><span>血压：</span></p>
      		</div>
            <div id="u45" class="ax_文本框">
        		<p id="u45_input">${map.obstetricExa.bloodHi }</p>
      		</div>
            <div id="u46" class="ax_文本段落">
          		<p id="u47"><span>/</span></p>
      		</div>
            <div id="u48" class="ax_文本框">
        		<p id="u48_input">${map.obstetricExa.bloodLow }</p>
      		</div>
            <div id="u43" class="ax_文本段落">
          		<p id="u44"><span>mmHg</span></p>
      		</div>
            
            <div id="u20" class="ax_文本段落">
          		<p id="u21"><span>宫底高度：</span></p>
      		</div>
            <div id="u180" class="ax_文本框">
        		<p id="u180_input">${map.obstetricExa.uterusHight }</p>
      		</div>
            <div id="u35" class="ax_文本段落">
          		<p id="u36"><span>cm</span></p>
      		</div>
            
            <div id="u22" class="ax_文本段落">
          		<p id="u23"><span>腹围：</span></p>
      		</div>
            <div id="u183" class="ax_文本框">
        		<p id="u183_input">${map.obstetricExa.abdomen }</p>
      		</div>
            <div id="u181" class="ax_文本段落">
          		<p id="u182"><span>cm</span></p>
      		</div>
            
            <div id="u24" class="ax_文本段落">
          		<p id="u25"><span>胎位：</span></p>
      		</div>
            <div id="u185" class="ax_文本框">
        		<p id="u185_input">${map.obstetricExa.fetusPosition }</p>
      		</div>
            
            <div id="u26" class="ax_文本段落">
          		<p id="u27"><span>胎心率：</span></p>
      		</div>
            <div id="u184" class="ax_文本框">
        		<p id="u184_input">${map.obstetricExa.heartRate }</p>
      		</div>
            <div id="u28" class="ax_文本段落">
          		<p id="u29"><span>次/分钟</span></p>
		</div>
            
        </div>
      
      <div id="u37" name="foldDiv3" onclick="AutoFold('foldDiv4','u40',12)" class="ax_形状" style="background-color:#009DD9">
          <p id="u38"><span>主 诉</span></p>
          <p id="u40" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
		
        
        <div id="zhusu" name="foldDiv4" style="height: 107px;">
        	
            <div id="u186" class="ax_多行文本框">
        		<p id="u186_input">${map.prenatal.chiefComplaint }</p>
      		</div>
        
        </div>
        
        <div id="u49" name="foldDiv5" onclick="AutoFold('foldDiv6','u52',12)" class="ax_形状" style="background-color:#009DD9">
          <p id="u50"><span>辅 助 检 查</span></p>
          <p id="u52" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        
      	
        <div id="" name="foldDiv6" style="height: 402px;">
        	
            <div id="u57" class="ax_文本段落">
          		<p id="u58"><span>血常规：</span></p>
      		</div>
            
            <div id="u53" class="ax_文本段落">
          		<p id="u54"><span>血红蛋白值：</span></p>
      		</div>
            <div id="u89" class="ax_文本框">
        		<p id="u89_input">${map.supplemetnaryExam.hemoglobin }</p>
      		</div>
            <div id="u55" class="ax_文本段落">
          		<p id="u56"><span style="font-family:'Arial Normal', 'Arial';font-weight:400;color:#333333;">g/L</span><span style="font-family:'Arial Normal', 'Arial';font-weight:400;color:#333333;">&nbsp; </span><span style="font-family:'Arial Negreta', 'Arial';font-weight:700;color:#FF0000;"></span></p>
      		</div>
            
            <div id="u87" class="ax_文本段落">
          		<p id="u88"><span>其他：</span></p>
      		</div>
            <div id="u86" class="ax_文本框">
        		<p id="u86_input">${map.supplemetnaryExam.bloodOthers }</p>
      		</div>
            
            <div id="u59" class="ax_文本段落">
          		<p id="u60"><span>尿常规：</span></p>
      		</div>
            
            <div id="u90" class="ax_文本段落">
          		<p id="u91"><span>尿蛋白：</span></p>
      		</div>
            <div id="u94" class="ax_文本框">
        		<p id="u94_input">${map.supplemetnaryExam.proteinuria }</p>
      		</div>
            <div id="u92" class="ax_文本段落">
          		<p id="u93"><span>g/L</span></p>
      		</div>
            
            <div id="u96" class="ax_文本段落">
          		<p id="u97"><span>其他：</span></p>
      		</div>
            <div id="u95" class="ax_文本框">
        		<p id="u95_input">${map.supplemetnaryExam.urineOthers }</p>
      		</div>
            
            <div id="u98" class="ax_文本段落">
          		<p id="u99"><span>血糖：</span></p>
      		</div>
            <div id="u102" class="ax_文本框">
        		<p id="u102_input">
        			<c:if test="${map.supplemetnaryExam.bloodGlucose != '-1'}">${map.supplemetnaryExam.bloodGlucose }</c:if> 
        			<c:if test="${map.supplemetnaryExam.bloodGlucose == '-1'}">未检查</c:if> 
        		</p>
      		</div>
            <div id="u100" class="ax_文本段落">
          		<p id="u101"><span><c:if test="${map.supplemetnaryExam.bloodGlucose != '-1'}">mmol/L</c:if> </span></p>
      		</div>
            
            <div id="u69" class="ax_文本段落">
          		<p id="u70"><span>肝功能：</span></p>
      		</div>
            
            <div id="u103" class="ax_文本段落">
          		<p id="u104"><span>血清谷丙转氨酶：</span></p>
      		</div>
            
            <div id="u113" class="ax_文本框">
        		<p id="u113_input">
        			<c:if test="${map.supplemetnaryExam.sgpt != '-1'}">${map.supplemetnaryExam.sgpt }</c:if>
        			<c:if test="${map.supplemetnaryExam.sgpt == '-1'}">未检查</c:if>
        		</p>
      		</div>
            <div id="u61" class="ax_文本段落">
          		<p id="u62"><span><c:if test="${map.supplemetnaryExam.sgpt != '-1'}">U/L</c:if></span></p>
      		</div>
            
            <div id="u105" class="ax_文本段落">
          		<p id="u106"><span>血清谷草转氨酶：</span></p>
      		</div>
            <div id="u114" class="ax_文本框">
        		<p id="u114_input">
        			<c:if test="${map.supplemetnaryExam.sgot != '-1'}">${map.supplemetnaryExam.sgot }</c:if>
        			<c:if test="${map.supplemetnaryExam.sgot == '-1'}">未检查</c:if>
        		</p>
      		</div>
            <div id="u63" class="ax_文本段落">
          		<p id="u64"><span><c:if test="${map.supplemetnaryExam.sgot != '-1'}">U/L</c:if></span></p>
      		</div>
            
            <div id="u107" class="ax_文本段落">
          		<p id="u108"><span>白蛋白：</span></p>
          	</div>
          	<div id="u115" class="ax_文本框">
            	<p id="u115_input">
	            	<c:if test="${map.supplemetnaryExam.albumin != '-1'}">${map.supplemetnaryExam.albumin }</c:if>
	            	<c:if test="${map.supplemetnaryExam.albumin == '-1'}">未检查</c:if>
            	</p>
          	</div>
          	<div id="u65" class="ax_文本段落">
              <p id="u66"><span><c:if test="${map.supplemetnaryExam.albumin != '-1'}">g/L</c:if></span></p>
          	</div>
            
            <div id="u109" class="ax_文本段落">
         		<p id="u110"><span>总胆红素：</span></p>
      		</div>
            <div id="u116" class="ax_文本框">
        		<p id="u116_input">
        			<c:if test="${map.supplemetnaryExam.totalBilirubin != '-1'}">${map.supplemetnaryExam.totalBilirubin }</c:if>
        			<c:if test="${map.supplemetnaryExam.totalBilirubin == '-1'}">未检查</c:if>
        		</p>
      		</div>
            <div id="u67" class="ax_文本段落">
          		<p id="u68"><span><c:if test="${map.supplemetnaryExam.totalBilirubin != '-1'}">μmol/L</c:if></span></p>
      		</div>
            
            <div id="u111" class="ax_文本段落">
          		<p id="u112"><span>结合胆红素：</span></p>
      		</div>
            <div id="u119" class="ax_文本框">
        		<p id="u119_input">
        			<c:if test="${map.supplemetnaryExam.dbil != '-1'}">${map.supplemetnaryExam.dbil }</c:if>
        			<c:if test="${map.supplemetnaryExam.dbil == '-1'}">未检查</c:if>
        		</p>
      		</div>
            <div id="u117" class="ax_文本段落">
          		<p id="u118"><span><c:if test="${map.supplemetnaryExam.dbil != '-1'}">μmol/L</c:if></span></p>
      		</div>
            
            <div id="u71" class="ax_文本段落">
          		<p id="u72"><span>肾功能：</span></p>
      		</div>
            
            <div id="u73" class="ax_文本段落">
          		<p id="u74"><span>血清肌酐：</span></p>
      		</div>
            <div id="u120" class="ax_文本框">
        		<p id="u120_input">
        			<c:if test="${map.supplemetnaryExam.scr != '-1'}">${map.supplemetnaryExam.scr }</c:if>
        			<c:if test="${map.supplemetnaryExam.scr == '-1'}">未检查</c:if>
        		</p>
      		</div>
            <div id="u75" class="ax_文本段落">
          		<p id="u76" ><span><c:if test="${map.supplemetnaryExam.scr != '-1'}">μmol/L</c:if></span></p>
      		</div>
            
            <div id="u77" class="ax_文本段落">
          		<p id="u78"><span>血尿素氮：</span></p>
      		</div>
            <div id="u121" class="ax_文本框">
        		<p id="u121_input">
        			<c:if test="${map.supplemetnaryExam.bun != '-1'}">${map.supplemetnaryExam.bun }</c:if>
        			<c:if test="${map.supplemetnaryExam.bun == '-1'}">未检查</c:if>
        		</p>
      		</div>
            <div id="u79" class="ax_文本段落">
          		<p id="u80"><span><c:if test="${map.supplemetnaryExam.bun != '-1'}">mmol/L</c:if></span></p>
      		</div>
            
            <div id="u81" class="ax_文本段落">
          		<p id="u82"><span>B超：</span></p>
      		</div>
            <div id="u187" class="ax_下拉列表框">
                <p id="u187_input">
                	<c:if test="${map.supplemetnaryExam.bscan == '0'}">未检查</c:if>
         			<c:if test="${map.supplemetnaryExam.bscan == '1'}">无异常</c:if>
           			<c:if test="${map.supplemetnaryExam.bscan == '2'}">有异常</c:if>
                </p>
      		</div>
          <div id="u123" class="ax_文本框">
        		<p id="u123_input">${map.supplemetnaryExam.bscanRemark}</p>
      		</div>
            <c:if test="${week >= 14 && week <=20 }">
            <div id="u83" class="ax_文本段落">
          		<p id="u84"><span>唐筛：</span></p>
	  	  </div>
            <div id="u85" class="ax_下拉列表框">
                <p id="u85_input">
                	<c:if test="${map.supplemetnaryExam.tangSyndrome == '0'}">未检查</c:if>
          			<c:if test="${map.supplemetnaryExam.tangSyndrome == '1'}">无异常</c:if>
            		<c:if test="${map.supplemetnaryExam.tangSyndrome == '2'}">有异常</c:if>
      			</p>
      		</div>
            <div id="u122" class="ax_文本框">
        		<p id="u122_input">${map.supplemetnaryExam.tangSyndromeRemark}</p>
      		</div>
            </c:if>
            <c:if test="${week >= 11 && week <=13 }">
            <div id="u188" class="ax_文本段落">
          		<p id="u189"><span>&nbsp;NT：</span></p>
	  	  </div>
            <div id="u190" class="ax_下拉列表框">
                <p id="u190_input">
                	<c:if test="${map.supplemetnaryExam.nt == '0'}">未检查</c:if>
          			<c:if test="${map.supplemetnaryExam.nt == '1'}">无异常</c:if>
            		<c:if test="${map.supplemetnaryExam.nt == '2'}">有异常</c:if>
                </p>
      		</div>
            <div id="u191" class="ax_文本框">
        		<p id="u191_input">${map.supplemetnaryExam.ntRemark}</p>
      		</div>
            </c:if>
            <c:if test="${week >= 22 && week <=26 }">
            <div id="u192" class="ax_文本段落">
          		<p id="u193"><span>四维：</span></p>
	  	  </div>
            <div id="u194" class="ax_下拉列表框">
                <p id="u194_input">
                	<c:if test="${map.supplemetnaryExam.fourDimensional == '0'}">未检查</c:if>
          			<c:if test="${map.supplemetnaryExam.fourDimensional == '1'}">无异常</c:if>
            		<c:if test="${map.supplemetnaryExam.fourDimensional == '2'}">有异常</c:if>
                </p>
      		</div>
            <div id="u195" class="ax_文本框">
        		<p id="u195_input">${map.supplemetnaryExam.fourDimensionalRemark}</p>
      		</div>
            </c:if>
            <div id="u196" class="ax_文本段落">
          		<p id="u197"><span>NST：</span></p>
   		  	</div>
            
            <div id="u198" class="ax_下拉列表框">
                <p id="u198_input">
                	<c:if test="${map.supplemetnaryExam.nst == '0'}">未检查</c:if>
          			<c:if test="${map.supplemetnaryExam.nst == '1'}">无异常</c:if>
            		<c:if test="${map.supplemetnaryExam.nst == '2'}">有异常</c:if>
                </p>
      		</div>
            <div id="u199" class="ax_文本框">
        		<p id="u199_input">${map.supplemetnaryExam.nstRemark}</p>
      		</div>
            
            <div id="u200" class="ax_文本段落">
          		<p id="u201"><span>其他：</span></p>
      		</div>
            <div id="u202" class="ax_多行文本框">
        		<p id="u202_input">${map.supplemetnaryExam.others}</p>
      		</div>
            
            
        </div>
        
        <div id="u124" name="foldDiv7" onclick="AutoFold('foldDiv8','u127',12)" class="ax_形状" style="background-color:#009DD9">
          <p id="u125"><span>总 体 评 估</span></p>
          <p id="u127" style="top: 5px; left: 1126px;"><span>收起</span></p>
        </div>
        
        <div name="foldDiv8" style="height: 43px;">
        	
            <div id="u128" class="ax_文本段落">
          		<p id="u129"><span>总体评估：</span></p>
      		</div>
            <div id="u130" class="ax_单选按钮">
                <c:if test="${map.prenatal.evaluate == '0'}">未见异常</c:if>
          		<c:if test="${map.prenatal.evaluate == '1'}">异常&nbsp;
          			<c:forEach items="${map.list}" var="item">
          				${item };&nbsp;
          			</c:forEach>
          		</c:if>
      		</div>
            
        </div>
        
        <div id="u135"  name="foldDiv9" onclick="AutoFold('foldDiv10','u138',12)"  class="ax_形状" style="background-color:#009DD9">
          <p id="u136"><span>保 健 指 导</span></p>
          <p id="u138" style="top: 5px; left: 1126px;"><span>收起</span></p>
      	</div>
      	<div name="foldDiv10" style="height: 148px;">
	        <div id="u139" class="ax_多行文本框">
	        	<p id="u139_input">${map.prenatal.guidance }</p>
	      	</div>
        </div>
        <div id="u140" name="foldDiv11" onclick="AutoFold('foldDiv12','shouqi',12)" class="ax_形状" style="background-color:#009DD9">
          <p id="u141"><span>转 诊</span></p>
          <p id="shouqi" style="top: 5px; left: 1126px;position:absolute;"><span>收起</span></p>
      	</div>
        
        <div name="foldDiv12" style="height: 198px;">
        	
            <div id="u144" class="ax_文本段落">
          		<p id="u145"><span>转诊：</span></p>
      		</div>
            <div id="u146" class="ax_单选按钮">
                <c:if test="${map.prenatalReferral.referral == '0' }">无</c:if>
            	<c:if test="${map.prenatalReferral.referral == '1' }">有</c:if>
      		</div>
            
            <div id="u150" class="ax_文本段落">
          		<p id="u151"><span>原因：</span></p>
      		</div>
            <div id="u152" class="ax_文本框">
        		<p id="u152_input">${map.prenatalReferral.reason}</p>
      		</div>
            
            <div id="u153" class="ax_文本段落">
          		<p id="u154"><span>转诊机构：</span></p>
      		</div>
            <div id="u155" class="ax_下拉列表框">
                <p id="u155_input">
	                <c:if test="${map.prenatalReferral.referral == '1' }">${departmentPO.name}</c:if>
                </p>
      		</div>
            
            <div id="u156" class="ax_文本段落">
          		<p id="u157"><span>转诊科室</span><span>：</span></p>
      		</div>
            <div id="u158" class="ax_下拉列表框">
                <p id="u158_input">
                	<c:if test="${map.prenatalReferral.referral == '1' }">${rolePO.name}</c:if>
                </p>
      		</div>
            
            <div id="u159" class="ax_文本段落">
          		<p id="u160"><span>下次随访日期：</span></p>
      		</div>
            <div id="u161" class="ax_下拉列表框">
                <p id="u161_input" ><fmt:formatDate value="${map.prenatalReferral.nextFollowingDate}" pattern="yyyy-MM-dd"/></p>
      		</div>
            
            <div id="u162" class="ax_文本段落">
          		<p id="u163"><span>是否预约下次检查：</span></p>
      		</div>
            <div id="u164" class="ax_单选按钮">
                <c:if test="${map.prenatalReferral.orderCheck == '0' }">否</c:if>
            	<c:if test="${map.prenatalReferral.orderCheck == '1' }">是</c:if>
          	</div>>
            
            <div id="u177" class="ax_水平线">
        		<hr id="u177_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      		</div>
            
            <div id="u168" class="ax_文本段落">
          		<p id="u169"><span>母子健康手册使用：</span></p>
      		</div>
            <div id="u174" class="ax_下拉列表框">
                <p id="u174_input">
                	<c:if test="${map.prenatalReferral.healthHandbook == '0' }">否</c:if>
            		<c:if test="${map.prenatalReferral.healthHandbook == '1' }">是</c:if>
                </p>
      		</div>
            
            <div id="u170" class="ax_文本段落">
          		<p id="u171"><span>叶酸发放：</span></p>
      		</div>
            <div id="u175" class="ax_下拉列表框">
                <p id="u175_input">
	                <c:if test="${map.prenatalReferral.folateNum == '0' }">否</c:if>
	            	<c:if test="${map.prenatalReferral.folateNum != '0' }">是</c:if>
                </p>
      		</div>
            
            <div id="u172" class="ax_文本段落">
          		<p id="u173"><span>发放数量：${map.prenatalReferral.folateNum}瓶</span></p>
      		</div>
        
        </div>
        
  </body>
</html>
