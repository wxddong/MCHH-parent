<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>0分娩登记</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx }/static/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/data/styles.css" type="text/css" rel="stylesheet"/>
	<link href="${ctx}/static/css/childbirth.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript">
     	$(function (){
     	
     		var n=1;
     		
     		$("#u505").click(function(){
     		
     		if(n==1){
     		document.getElementById('h4').style.height='1095px';
     		document.getElementById("hs1").style.display='';
     		document.getElementById('s8').style.top='1375px';
     		document.getElementById('s9').style.top='1495px';
     		document.getElementById('s7').style.top='1507px';
     		document.getElementById('s10').style.top='1706px';
     		document.getElementById('s11').style.top='1732px';
     		
     		}
     		if(n==2){
         		document.getElementById('h4').style.height='1500px';
         		document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById('s8').style.top='1780px';
         		document.getElementById('s9').style.top='1900px';
         		document.getElementById('s7').style.top='1912px';
         		document.getElementById('s10').style.top='2111px';
         		document.getElementById('s11').style.top='2137px';
         		
         		}
     		if(n==3){
         		document.getElementById('h4').style.height='1905px';
         		document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById("hs3").style.display='';
         		document.getElementById('s8').style.top='2185px';
         		document.getElementById('s9').style.top='2305px';
         		document.getElementById('s7').style.top='2317px';
         		document.getElementById('s10').style.top='2516px';
         		document.getElementById('s11').style.top='2542px';
         		
         		}
     		
     		if(n==4){
         		document.getElementById('h4').style.height='2310px';
         		document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById("hs3").style.display='';
         		document.getElementById("hs4").style.display='';
         		document.getElementById('s8').style.top='2590px';
         		document.getElementById('s9').style.top='2710px';
         		document.getElementById('s7').style.top='2722px';
         		document.getElementById('s10').style.top='2921px';
         		document.getElementById('s11').style.top='2947px';
         		
         		
         		}
     		if(n==5){
         		document.getElementById('h4').style.height='2715px';
         		document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById("hs3").style.display='';
         		document.getElementById("hs4").style.display='';
         		document.getElementById("hs5").style.display='';
         		document.getElementById('s8').style.top='2995px';
         		document.getElementById('s9').style.top='3115px';
         		document.getElementById('s7').style.top='3127px';
         		document.getElementById('s10').style.top='3326px';
         		document.getElementById('s11').style.top='3352px';
         		
         		}
     		if(n==6){
         		document.getElementById('h4').style.height='3120px';
         		document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById("hs3").style.display='';
         		document.getElementById("hs4").style.display='';
         		document.getElementById("hs5").style.display='';
         		document.getElementById("hs6").style.display='';
         		document.getElementById('s8').style.top='3400px';
         		document.getElementById('s9').style.top='3520px';
         		document.getElementById('s7').style.top='3532px';
         		document.getElementById('s10').style.top='3731px';
         		document.getElementById('s11').style.top='3757px';
         		
         		}
     		if(n==7){ 
     			alert("对   不     起    你   已   经    超    生   了");
     		}
     		n++;
     		return false;
     		});
     		
     		
     		
     		
     		/* 展开和收起 */
		 
		 		$("#h2").click(function(){
		 			var show = document.getElementById("u17").innerHTML;
		 			if (show == '收起') {
		 				document.getElementById("u17").innerHTML = '展开';
					}else {
						document.getElementById("u17").innerHTML = '收起';
					}
		 		
		 			
		 			

		 		var text1 = document.getElementById("u17").innerHTML;
	 			var text2 = document.getElementById("u21").innerHTML;
	 			var text3 = document.getElementById("u25").innerHTML;
	 			var text4 = document.getElementById("u59").innerHTML;
	 			
		 		
	 			if(text1=='展开'&&text2=='展开'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='265px';
	 				document.getElementById('s11').style.display='none';
	 				ocument.getElementById('s11').style.top='1318px';
	 				
	 			}
	 			
	 			if(text1=='收起'&&text2=='展开'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('h4').style.top='416px';
	 				document.getElementById('s8').style.top='416px';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='442px';
	 				document.getElementById('s10').style.top='442px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='442px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='1080px';
	 				document.getElementById('s10').style.top='1106px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='1306px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='1291px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1318px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1318px';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='239px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='799px';
	 				document.getElementById('s9').style.top='903px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='921px';
	 				document.getElementById('s10').style.top='1114px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1147px';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='265px';
	 				document.getElementById('s10').style.top='445px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='470px';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='265px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='291px';
	 				
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='903px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s10').style.top='1114px';
	 				document.getElementById('s11').style.display='none';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='893px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='919px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1141px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='442px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='469px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='428px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='654px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='1106px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1133px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='428px';
	 				document.getElementById('s10').style.top='627px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='654px';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='893px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='919px';
	 				document.getElementById('s11').style.display='none';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='251px';
	 				document.getElementById('s10').style.top='460px';
	 				document.getElementById('s11').style.display='none';
	 			}
		 		
		 	});
     		
     		
		 		$("#h3").click(function(){
		 			var show = document.getElementById("u21").innerHTML;
		 			if (show == '收起') {
		 				document.getElementById("u21").innerHTML = '展开';
					}else {
						document.getElementById("u21").innerHTML = '收起';
					}
		 		
		 		

		 		var text1 = document.getElementById("u17").innerHTML;
	 			var text2 = document.getElementById("u21").innerHTML;
	 			var text3 = document.getElementById("u25").innerHTML;
	 			var text4 = document.getElementById("u59").innerHTML;
	 			
	 				
	 			if(text1=='展开'&&text2=='展开'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='265px';
	 				document.getElementById('s11').style.display='none';
	 				ocument.getElementById('s11').style.top='1318px';
	 				
	 			}
	 			
	 			if(text1=='收起'&&text2=='展开'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('h4').style.top='416px';
	 				document.getElementById('s8').style.top='416px';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='442px';
	 				document.getElementById('s10').style.top='442px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='442px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='1080px';
	 				document.getElementById('s10').style.top='1106px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='1306px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='1291px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				
	 			
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1318px';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='239px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='799px';
	 				document.getElementById('s9').style.top='903px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='921px';
	 				document.getElementById('s10').style.top='1114px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1147px';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='265px';
	 				document.getElementById('s10').style.top='445px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='470px';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='265px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='291px';
	 				
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='903px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s10').style.top='1114px';
	 				document.getElementById('s11').style.display='none';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='893px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='919px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1141px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='442px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='469px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='428px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='654px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='1106px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1133px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='428px';
	 				document.getElementById('s10').style.top='627px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='654px';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='893px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='919px';
	 				document.getElementById('s11').style.display='none';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='251px';
	 				document.getElementById('s10').style.top='460px';
	 				document.getElementById('s11').style.display='none';
	 			}
		 		
		 	});	
		 		
		 		
		 		$("#s9").click(function(){
		 			var show = document.getElementById("u25").innerHTML;
		 			if (show == '收起') {
		 				document.getElementById("u25").innerHTML = '展开';
					}else {
						document.getElementById("u25").innerHTML = '收起';
					}
		 		
		 		

		 		var text1 = document.getElementById("u17").innerHTML;
	 			var text2 = document.getElementById("u21").innerHTML;
	 			var text3 = document.getElementById("u25").innerHTML;
	 			var text4 = document.getElementById("u59").innerHTML;
	 			
		 		
	 			if(text1=='展开'&&text2=='展开'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='265px';
	 				document.getElementById('s11').style.display='none';
	 				ocument.getElementById('s11').style.top='1318px';
	 				
	 			}
	 			
	 			if(text1=='收起'&&text2=='展开'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('h4').style.top='416px';
	 				document.getElementById('s8').style.top='416px';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='442px';
	 				document.getElementById('s10').style.top='442px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='442px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='1080px';
	 				document.getElementById('s10').style.top='1106px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='1306px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='1291px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				alert("1223234");
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1318px';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='239px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='799px';
	 				document.getElementById('s9').style.top='903px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='921px';
	 				document.getElementById('s10').style.top='1114px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1147px';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='265px';
	 				document.getElementById('s10').style.top='445px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='470px';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='265px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='291px';
	 				
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='903px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s10').style.top='1114px';
	 				document.getElementById('s11').style.display='none';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='893px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='919px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1141px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='442px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='469px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='428px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='654px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='1106px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1133px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='428px';
	 				document.getElementById('s10').style.top='627px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='654px';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='893px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='919px';
	 				document.getElementById('s11').style.display='none';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='251px';
	 				document.getElementById('s10').style.top='460px';
	 				document.getElementById('s11').style.display='none';
	 			}
		 		});
		 		$("#s10").click(function(){
		 			var show = document.getElementById("u59").innerHTML;
		 			if (show == '收起') {
		 				document.getElementById("u59").innerHTML = '展开';
					}else {
						document.getElementById("u59").innerHTML = '收起';
					}
		 		
		 		

		 		var text1 = document.getElementById("u17").innerHTML;
	 			var text2 = document.getElementById("u21").innerHTML;
	 			var text3 = document.getElementById("u25").innerHTML;
	 			var text4 = document.getElementById("u59").innerHTML;
	 			
		 		
	 			if(text1=='展开'&&text2=='展开'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='265px';
	 				document.getElementById('s11').style.display='none';
	 				ocument.getElementById('s11').style.top='1318px';
	 				
	 			}
	 			
	 			if(text1=='收起'&&text2=='展开'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('h4').style.top='416px';
	 				document.getElementById('s8').style.top='416px';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='442px';
	 				document.getElementById('s10').style.top='442px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='442px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s7').style.top='1080px';
	 				document.getElementById('s10').style.top='1106px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='1306px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='1291px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='410px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='970px';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='1092px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1318px';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='收起'&&text4=='收起'){
	 				
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='239px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='799px';
	 				document.getElementById('s9').style.top='903px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='921px';
	 				document.getElementById('s10').style.top='1114px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1147px';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('s4').style.top='213px';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='265px';
	 				document.getElementById('s10').style.top='445px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='470px';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='265px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='291px';
	 				
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='903px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s10').style.top='1114px';
	 				document.getElementById('s11').style.display='none';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='893px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='919px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1141px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='442px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='469px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='428px';
	 				document.getElementById('s10').style.top='1291px';
	 				document.getElementById('s11').style.display='none';
	 				document.getElementById('s11').style.top='654px';
	 			}
	 			if(text1=='收起'&&text2=='收起'&&text3=='展开'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s9').style.top='1080px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='1106px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='1133px';
	 			}
	 			if(text1=='收起'&&text2=='展开'&&text3=='收起'&&text4=='收起'){
	 				document.getElementById('s4').style.display='';
	 				document.getElementById('h3').style.top='390px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='416px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='428px';
	 				document.getElementById('s10').style.top='627px';
	 				document.getElementById('s11').style.display='';
	 				document.getElementById('s11').style.top='654px';
	 			}
	 			if(text1=='展开'&&text2=='收起'&&text3=='展开'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='';
	 				document.getElementById('h4').style.top='233px';
	 				document.getElementById('s8').style.display='';
	 				document.getElementById('s8').style.top='793px';
	 				document.getElementById('s9').style.top='893px';
	 				document.getElementById('s7').style.display='none';
	 				document.getElementById('s10').style.top='919px';
	 				document.getElementById('s11').style.display='none';
	 			}
	 			if(text1=='展开'&&text2=='展开'&&text3=='收起'&&text4=='展开'){
	 				document.getElementById('s4').style.display='none';
	 				document.getElementById('h3').style.top='213px';
	 				document.getElementById('h4').style.display='none';
	 				document.getElementById('s8').style.display='none';
	 				document.getElementById('s9').style.top='239px';
	 				document.getElementById('s7').style.display='';
	 				document.getElementById('s7').style.top='251px';
	 				document.getElementById('s10').style.top='460px';
	 				document.getElementById('s11').style.display='none';
	 			}
		 		});
		 		
		 		var addUrl="${ctx}/archivesinfo/addNote";
		 		$("#u61").click(function(){
		 			
		 			
					
					document.getElementById("editStatus").value=0;

					  $("#queryform").attr("action",addUrl);
					  $("#queryform").submit();
		 		
		 		});
		 		
		 		var saveUrl="${ctx}/archivesinfo/addNote";
				$("#u63").click(function(){
		 			
		 			
					
					document.getElementById("editStatus").value=1;

					  $("#queryform").attr("action",saveUrl);
					  $("#queryform").submit();
		 		
		 		});
		})
    </script>
  </head>
  <body>
     <div id="base" class="">
		<form id="queryform" method="post">
      <div id="u54" class="ax_形状" style="background-color:#ee5f45">
        <p id="u55"><span>分娩登记</span></p>
      </div>
      
      
           <div id="u8" class="ax_文本段落">
          <p id="u9"><span>检查医院:${operator.department }</span></p>
      </div>
      
      
           <!-- Unnamed (形状) -->
      <div id="u10" class="ax_文本段落" >
          <p><span>检查医生:${operator.realName }</span></p>
     </div>
     
     
     
           <!-- Unnamed (形状) -->
      <div id="u12" class="ax_文本段落">
          <p id="u13"><span>转诊状态：本院</span></p>
      </div>
      
      
      
      <div id="u66" class="ax_形状" style="background-color:#999999">
          <p id="u67"><span>结案</span></p>
      </div>
      
      
      
      <div id="u64" class="ax_形状" style="background-color:#ee5f45">
          <p id="u65"><a id="u65" onClick="guanli();">专案管理</a></p>
      </div>
      
      
      
      	<div id="u60" class="ax_形状" style="background-color:#009Dd9">
         <a id="u61" onClick="save();">保存</a>
        </div>
  
  
  
     
	<div id="u62" class="ax_形状" style="background-color:#56bb4d">
          <a id="u63" onClick="fanish();">完成</a>
    </div>

<div id="h1">    
      <div id="u4" class="ax_形状" style="background-color:#009dd9"> 
          <p id="u5"><span>个人基本信息</span></p>
      </div>
</div>
<div id="s3">
		<input type="hidden" name="id" value="${ArchivesInfoPO.id }"/>
		<input type="hidden" id="editStatus" name="editStatus" value="0"/>
  		<div id="u76" class="ax_文本段落">
          <p id="u77"><span>姓名  ${ArchivesInfoPO.name }</span></p>
      	</div>

   
  	  <div id="u78" class="ax_文本段落">
          <p id="u79">
          <span>档案编号 ${ArchivesInfoPO.archivesCode }</span>
          
          </p>
      </div>
      <div id="u90" class="ax_文本段落">
      		<p id="u91"><span>建档日期：<fmt:formatDate value="${ArchivesInfoPO.creatTime }" pattern="yyyy-MM-dd"/></span></p>
      </div>
      <div id="u74" class="ax_文本段落">
          <p id="u75"><span>孕周: ${weekByLastMenses}</span></p>
      </div>
      <div id="u70" class="ax_文本段落">
        	<p id="u71"><span>末次月经:${ArchivesInfoPO.lastmenstrual }</span></p>
      </div>
      <div id="u68" class="ax_文本段落">
          <p id="u69"><span>出生日期:<fmt:formatDate value="${ArchivesInfoPO.birthday }" pattern="yyyy-MM-dd"/></span></p>
      </div>
      <div id="u80" class="ax_文本段落">
          <p  id="u81"><span>孕妇年龄：${age }</span></p>
      </div>
      <div id="u72" class="ax_文本段落">
          <p id="u73"><span>预产期:<fmt:formatDate value="${endOfDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
     
      <div id="u82" class="ax_文本段落">
        <p  id="u83"><span>联系电话:${ArchivesInfoPO.telephone }</span></p>
      </div>
	  <div id="u84" class="ax_文本段落">
		       <p id="u85"><span>丈夫姓名 :${ArchivesInfoPO.manName }</span></p>
	  </div>
      <div id="u86" class="ax_文本段落">
          <p id="u87"><span>丈夫 年龄:${manAge}</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u88" class="ax_文本段落">     
        <p id="u89"><span>丈夫电话:${ArchivesInfoPO.manTele }</span></p>
      </div>
</div>




<div id="h2">
     
     <div id="u14" class="ax_形状" style="background-color:#009dd9">
          <p id="u15"><span>基本情况</span></p>
     </div>
     <div id="u16" class="ax_文本段落" style="background-color:#009dd9">
          <p id="u17">收起</p>
      </div>
</div>    
<div id="s4" style="display:''">
     <div id="u287" class="ax_文本段落">
          <p id="u288" ><span>分娩日期</span></p>
     </div>
     
     
       <div id="u289" class="ax_下拉列表框">
       <!--  <input type="text" id="u289_input" name="birthDate" /> -->
        <input type="text" id="u289_input" name="birthDate" readonly 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required/>
      </div> 
      
      
        <div id="u290" class="ax_文本段落">
          <p id="u291"><span>住院号</span></p>
      </div>
      
      
          <div id="u292" class="ax_文本框">
        <input id="u292_input" type="text" name="hospitalCode"/>
      </div>
      
      
         <div id="u340" class="ax_文本段落">
          <p id="u341"><span>出院日期</span></p>
      </div>
       <div id="u342" class="ax_下拉列表框">
        <input type="text" id="u342_input" name="leaveDate" readonly 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required/>
      </div>
      <div id="u276" class="ax_文本段落">
          <p id="u277"><span>末次月经：</span></p>      
      </div>
      <div id="u278" class="ax_下拉列表框">
        <input type="text" id="u278_input" name="lastMenses" readonly 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required/>
      </div>
      
     


	   <div id="u279" class="ax_文本段落">
	          <p id="u280"><span>孕周</span></p>
	  </div>
      <div id="u281" class="ax_文本框">
        <input id="u281_input" type="text" name="gestationalWeek"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u282" class="ax_文本段落">
          <p id="u283"><span>周</span></p>
      </div>
 	  <div id="u286" class="ax_文本框">
        <input id="u286_input" type="text" name="gestationalDay"/>
      </div>
  <!-- Unnamed (形状) -->
      <div id="u284" class="ax_文本段落">
          <p id="u285"><span>天</span></p>
      </div>
    	<div id="u293" class="ax_文本段落">
          <p  id="u294"><span>孕 次：</span></p>
      </div>
      <div id="u295" class="ax_下拉列表框">
        <select id="u295_input" name="pregnancyNum">
          <option selected value="" ></option>
          <option selected value="1" >1</option>
          <option selected value="2" >2</option>
          <option selected value="3" >3</option>
          <option selected value="4" >4</option>
        </select>
      </div>
      <div id="u301" class="ax_文本段落">
        <p id="u302" ><span>次</span></p>
      </div>
      <div id="u296" class="ax_文本段落">
          <p id="u297"><span>产 次：</span></p>
      </div>
      <div id="u298" class="ax_下拉列表框">
        <select id="u298_input" name="bearNum">
          <option selected value=""></option>
          <option selected value="1">1</option>
          <option selected value="2">2</option>
          <option selected value="3">3</option>
          <option selected value="4">4</option>
        </select>
      </div>
       <div id="u299" class="ax_文本段落">
          <p id="u300"><span>次</span></p>
      </div>
      <div id="u303" class="ax_文本段落">
          <p id="u304"><span>孕产保健</span></p>
      </div>
        <div id="u305" class="ax_下拉列表框">
        <select id="u305_input" name="healthcareNum">
          <option value=""></option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>
      </div>
      <div id="u306" class="ax_文本段落">
          <p id="u307"><span>次</span></p>
      </div>

    <div id="u308" class="ax_文本段落">
          <p  id="u309"><span>是否检测乙肝</span><span>：</span></p>
  </div>

  <!-- Unnamed (下拉列表框) -->
      <div id="u310" class="ax_下拉列表框">
        <select id="u310_input" name="checkHepatitis">
        <option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u311" class="ax_文本段落">
          <p id="u312"><span>乙 表面抗原：</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u313" class="ax_下拉列表框">
        <select id="u313_input" name="antigenHepatitis">
        <option value=""></option>
          <option value="阴性">阴性</option>
          <option value="阳性">阳性</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u314" class="ax_文本段落">
          <p id="u315"><span>是否检测梅毒：</span></p>
      </div>
      <div id="u316" class="ax_下拉列表框">
        <select id="u316_input" name="checkSyphilis">
        <option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u317" class="ax_文本段落">
          <p id="u318"><span>是否感染梅毒：</span></p>
      </div>
      <div id="u319" class="ax_下拉列表框">
        <select id="u319_input" name="infectedSyphilis">
        <option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u320" class="ax_文本段落">
          <p id="u321"><span>是否检测 艾滋病</span></p>
      </div>
      <div id="u322" class="ax_下拉列表框"> 
      	<select id="u319_input" name="checkAids">
      	<option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u323" class="ax_文本段落" >
          <p id="u324"><span>是否感染艾滋病</span></p>
      </div>
      <div id="u325" class="ax_下拉列表框">
        <select id="u325_input"  name="infectedAids">
        <option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u326" class="ax_文本段落">
          <p id="u327"><span>血红蛋白检测</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u328" class="ax_下拉列表框">
        <select id="u328_input" name="checkHemoglobin">
        <option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u329" class="ax_文本段落">
        <div>
          <p id="u330"><span>是否重度贫血:</span></p>
        </div>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u331" class="ax_下拉列表框">
        <select id="u331_input" name="anemia">
        <option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u332" class="ax_文本段落">
          <p id="u333"><span name="famHistory">家族史：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u334" class="ax_文本段落">
          <p id="u335"><span>家族遗传疾病</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u336" class="ax_文本框">
        <input id="u336_input" type="text" value="" name="geneticIll"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u337" class="ax_文本段落">
          <p id="u338"><span>近亲结婚：</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u339" class="ax_下拉列表框" >
        <select id="u339_input" name="relativesMating">
        <option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
      </div>
</div>  
   

<div id="h3">
      <div id="u18" class="ax_形状" style="background-color:#009dd9">
        <p id="u19"><span>分娩信息</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u20" class="ax_文本段落">
          <!-- <p id="u21"><span>收起</span></p> -->
          <p id="u21" onclick="CanShu('h4','u21');">收起</p>
      </div>   
</div>
<div id="h4" style="display:''">
<div id="s5">  
   
      <div id="u343" class="ax_文本段落">
          <p id="u344"><span>分娩地点</span></p>
      </div>
      
       <div id="u429" class="ax_下拉列表框">
        <select id="u429_input" name="childbirthPlace">
        </select>
        <input id="u909_input" name="childbirthPlace" type="text"/>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u345" class="ax_文本段落">
          <p id="u346"><span>产程时间：</span></p>
      </div>
      
      
       <div id="u365" class="ax_文本段落">
		 <p id="u366"><span>第一产：</span></p>      
  	  </div>
      <div id="u430" class="ax_文本框">
        <input id="u430_input" type="text" name="firstHour"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u431" class="ax_文本段落">
          <p id="u432"><span>小时</span></p>
      </div>
      
      <div id="u435" class="ax_文本框">
        <input id="u435_input" type="text" name="firstMinute"/>
      </div>
      
      

      <!-- Unnamed (形状) -->
      <div id="u433" class="ax_文本段落">
          <p id="u434"><span>分钟</span></p>
      </div>
      <div id="u367" class="ax_文本段落">
          <p id="u368"><span>第二产程</span></p>
      </div>
       <div id="u436" class="ax_文本框">
        <input id="u436_input" type="text" value="" name="secondHour"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u437" class="ax_文本段落">
          <p id="u438"><span>小时</span></p>
      </div>
      
       <div id="u441" class="ax_文本框">
        <input id="u441_input" type="text" value="" name="firstMinute"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u439" class="ax_文本段落">
          <p id="u440"><span>分钟</span></p>
      </div>
	<div id="u369" class="ax_文本段落">
          <p id="u370"><span>第三产程：</span></p>
  </div>
      
      <div id="u442" class="ax_文本框">
        <input id="u442_input" type="text" value="" name="thirdHour"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u443" class="ax_文本段落">
          <p id="u444"><span>小时</span></p>
      </div>
      
      <div id="u447" class="ax_文本框">
        <input id="u447_input" type="text" value="" name="thirdMinute"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u445" class="ax_文本段落">
          <p id="u446"><span>分钟</span></p>
      </div>

	 
     
     <div id="u371" class="ax_文本段落">
       <p id="u372"><span>总产程：</span></p>
  </div>
   <div id="u448" class="ax_文本框">
        <input id="u448_input" type="text" value="" name="totalHour"/>
  </div>

      <!-- Unnamed (形状) -->
      <div id="u449" class="ax_文本段落">
          <p id="u450"><span>小时</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u451" class="ax_文本段落">
          <p id="u452"><span>分钟</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u453" class="ax_文本框">
        <input id="u453_input" type="text" value="" name="totalMinute "/>
      </div>

 		<div id="u347" class="ax_文本段落">
          <p id="u348"><span>胎盘：</span></p>
      </div>
       <div id="u454" class="ax_下拉列表框">
        <input type="text" name="" id="u454_input" name="placenta"/>
      </div>
      
      

 	  <div id="u373" class="ax_文本段落">
          <p id="u374"><span>会阴侧切：</span></p>
      </div>
	 <div id="u455" class="ax_下拉列表框">
        <select id="u455_input" name="perineumCut">
        </select>
  	</div>
  	 <!-- Unnamed (形状) -->
      <div id="u375" class="ax_文本段落">
          <p  id="u376"><span>伤裂程度：</span></p>
      </div>
      
      <div id="u456" class="ax_下拉列表框">
        <select id="u456_input" name="injuryDegree">
        </select>
      </div>

      <!-- Unnamed (形状) -->
      
	  <div id="u379" class="ax_文本段落">
          <p id="u380"><span>出血量及羊水：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u381" class="ax_文本段落">
          <p id="u382"><span>产时出血量：</span></p>      
  	  </div>
        
        
      <div id="u467" class="ax_文本框">
        <input id="u467_input" type="text" value="" name="bearBleeding"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u468" class="ax_文本段落">
          <p id="u469"><span>ml</span></p>
      </div>
      
      

      <!-- Unnamed (形状) -->
      <div id="u383" class="ax_文本段落">
          <p id="u384"><span>产后2小时：</span></p>
      </div>
      
       <div id="u470" class="ax_文本框">
        <input id="u470_input" type="text" value="" name="afterbearTwo"/>
      </div>
      <div id="u472" class="ax_文本段落">
          <p id="u473"><span>ml</span></p>
      </div>
      
      

      <!-- Unnamed (形状) -->
      <div id="u385" class="ax_文本段落">
          <p id="u386"><span>总出血量：</span></p>
      </div>
         <div id="u471" class="ax_文本框">
        <input id="u471_input" type="text" value="" name="totalBleeding"/>
      </div>

      <!-- Unnamed (形状) -->
      

      <!-- Unnamed (形状) -->
      <div id="u474" class="ax_文本段落">
          <p id="u475"><span>ml</span></p>
      </div>
      
      <div id="u476" class="ax_文本段落">
          <p id="u477"><span>羊水性状：</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      

      <!-- Unnamed (下拉列表框) -->
      <div id="u481" class="ax_下拉列表框" name="amnioticFluidTrait">
        <select id="u481_input">
        </select>
      </div>
      

      <!-- Unnamed (形状) -->
      <div id="u387" class="ax_文本段落">
          <p id="u388"><span>羊水量：</span></p>
      </div>
      <div id="u478" class="ax_文本框">
        <input id="u478_input" type="text" value=""  name="amnioticFluidAmount"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u479" class="ax_文本段落">
          <p id="u480"><span>ml</span></p>
      </div>
      <div id="u359" class="ax_文本段落">
          <p id="u360"><span>胎数</span><span>：</span></p>
      </div>
      
      <div id="u483" class="ax_下拉列表框">
        <select id="u483_input" name="fetalNum">
        	<option value=""></option>
        	<option value="1">1</option>
        	<option value="2">2</option>
        	<option value="3">3</option>
        	<option value="4">4</option>
        	<option value="5">5</option>
        </select>
      </div>
      
      <div id="u504" class="ax_文本段落">
      <img id="u506_img" class="img " src="${ctx}/static/images/0第2次产前随访记录表/u639.png"/>
          <a href="" id="u505" style="color:#ff4848" >新增婴儿信息</a>
      </div>
     
</div>      
      

<div id="s6">
      <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位：</span></p>
      </div>
      
       <!-- Unnamed (下拉列表框) -->
      <div id="u457" class="ax_下拉列表框">
        <select id="u457_input" name="fetusPosition">
        	
        	<option value=""></option>
        	<option value="0">左腹</option>
        	<option value="1">右腹</option>
        </select>
      </div>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间：</span></p>
      </div>
      
        <div id="u460" class="ax_文本框">
        <input id="u460_input" type="text" value="" name="deliveryHour"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u461" class="ax_文本段落">
          <p  id="u462"><span>时</span></p>
  	  </div>
      

      <!-- Unnamed (文本框) -->
      <div id="u465" class="ax_文本框">
        <input id="u465_input" type="text" value="" name="deliveryMinute"/>
      </div>
      
      <div id="u463" class="ax_文本段落">      
          <p id="u464"><span>分</span></p>
      </div>
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产：</span></p>
      </div>
      
       <div id="u458" class="ax_下拉列表框">
        <select id="u458_input" name="inducelabour">
        </select>
      </div>
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式：</span></p>
      </div>
      
      
       <div id="u459" class="ax_下拉列表框">
        <select id="u459_input" name="deliveryType">
        	<option value=""></option>
        	<option value="0">刨妇产</option>
        	<option value="1">顺产</option>
        </select>
      </div>
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征：</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <input id="u466_input" type="text" value="" name="cesareanIdicatio"/>
      </div>
      
        <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况：</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名：</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <input id="u485_input" type="text" value="" name="babyName"/>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别：</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">
        <select id="u482_input" name="babySex">
        	<option value=""></option>
        	<option value="0">男</option>
        	<option value="1">女</option>
        </select>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况：</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
        <select id="u484_input" name="health">
        </select>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形：</span></p>
      </div>
      
      
      
       <div id="u486" class="ax_下拉列表框">
        <select id="u486_input" name="fetalAnomaly">
        	<option value=""></option>
        	<option value="0">连体</option>
        	<option value="1">腿短</option>
        </select>
      </div>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位：</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <input id="u487_input" type="text" value="" name="abnormalPosition"/>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称：</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <input id="u488_input" type="text" value="" name="abnormalName"/>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分：</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分：</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <input id="u489_input" type="text" value="" name="oneMinScore"/>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分：</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <input id="u490_input" type="text" value="" name="fiveMinScore"/>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重：</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <input id="u491_input" type="text" value="" name="bornWeight"/>
      </div>
      
       <div id="u493" class="ax_文本段落">
          <p id="u494"><span>g</span></p>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长：</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <input id="u492_input" type="text" value="" name="bodyLenght"/>
      </div>
      <div id="u495" class="ax_文本段落">
          <p id="u496"><span>cm</span></p>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗：</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
        <input id="u411_input" type="checkbox" value="0" name="vaccine"/>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        <input id="u413_input" type="checkbox" value="1" name="vaccine"/>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        <input id="u415_input" type="checkbox" value="2" name="vaccine"/>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡：</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <select id="u498_input" name="fetusDie">
        </select>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者：</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <input id="u497_input" type="text" value="" name="midwife"/>
      </div>
 </div> 
    
<div id="hs1"  style="display: none" >
      <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位：</span></p>
      </div>
      
       <!-- Unnamed (下拉列表框) -->
      <div id="u457" class="ax_下拉列表框">
        <select id="u457_input" name="fetusPosition1">
        </select>
      </div>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间：</span></p>
      </div>
      
        <div id="u460" class="ax_文本框">
        <input id="u460_input" type="text" value="" name="deliveryHour1"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u461" class="ax_文本段落">
          <p  id="u462"><span>时</span></p>
  	  </div>
      

      <!-- Unnamed (文本框) -->
      <div id="u465" class="ax_文本框">
        <input id="u465_input" type="text" value="" name="deliveryMinute1"/>
      </div>
      
      <div id="u463" class="ax_文本段落">      
          <p id="u464"><span>分</span></p>
      </div>
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产：</span></p>
      </div>
      
       <div id="u458" class="ax_下拉列表框">
        <select id="u458_input" name="inducelabour1">
        </select>
      </div>
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式：</span></p>
      </div>
      
      
       <div id="u459" class="ax_下拉列表框">
        <select id="u459_input" name="deliveryType1">
        	<option ></option>
        	<option value="0">刨妇产</option>
        	<option value="1">顺产</option>
        </select>
      </div>
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征：</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <input id="u466_input" type="text" value="" name="cesareanIdicatio1"/>
      </div>
      
        <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况：</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名：</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <input id="u485_input" type="text" value="" name="babyName1"/>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别：</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">
        <select id="u482_input" name="babySex1">
        	<option></option>
        	<option value="0">男</option>
        	<option value="1">女</option>
        </select>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况：</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
        <select id="u484_input" name="health1">
        </select>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形：</span></p>
      </div>
      
      
      
       <div id="u486" class="ax_下拉列表框">
        <select id="u486_input" name="fetalAnomaly1">
        </select>
      </div>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位：</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <input id="u487_input" type="text" value="" name="abnormalPosition1"/>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称：</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <input id="u488_input" type="text" value="" name="abnormalName1"/>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分：</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分：</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <input id="u489_input" type="text" value="" name="oneMinScore1"/>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分：</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <input id="u490_input" type="text" value="" name="fiveMinScore1"/>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重：</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <input id="u491_input" type="text" value="" name="bornWeight1"/>
      </div>
      
       <div id="u493" class="ax_文本段落">
          <p id="u494"><span>g</span></p>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长：</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <input id="u492_input" type="text" value="" name="bodyLenght1"/>
      </div>
      <div id="u495" class="ax_文本段落">
          <p id="u496"><span>cm</span></p>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗：</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
        <input id="u411_input" type="checkbox" value="0" name="vaccine1"/>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        <input id="u413_input" type="checkbox" value="1" name="vaccine1"/>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        <input id="u415_input" type="checkbox" value="2" name="vaccine1"/>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡：</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <select id="u498_input" name="fetusDie1">
        </select>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者：</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <input id="u497_input" type="text" value="" name="midwife1"/>
      </div>
 </div>
<div id="hs2"  style="display: none">
<div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位：</span></p>
      </div>
      
       <!-- Unnamed (下拉列表框) -->
      <div id="u457" class="ax_下拉列表框">
        <select id="u457_input" name="fetusPosition2">
        </select>
      </div>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间：</span></p>
      </div>
      
        <div id="u460" class="ax_文本框">
        <input id="u460_input" type="text" value="" name="deliveryHour2"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u461" class="ax_文本段落">
          <p  id="u462"><span>时</span></p>
  	  </div>
      

      <!-- Unnamed (文本框) -->
      <div id="u465" class="ax_文本框">
        <input id="u465_input" type="text" value="" name="deliveryMinute2"/>
      </div>
      
      <div id="u463" class="ax_文本段落">      
          <p id="u464"><span>分</span></p>
      </div>
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产：</span></p>
      </div>
      
       <div id="u458" class="ax_下拉列表框">
        <select id="u458_input" name="inducelabour2">
        </select>
      </div>
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式：</span></p>
      </div>
      
      
       <div id="u459" class="ax_下拉列表框">
        <select id="u459_input" name="deliveryType2">
        	<option ></option>
        	<option value="0">刨妇产</option>
        	<option value="1">顺产</option>
        </select>
      </div>
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征：</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <input id="u466_input" type="text" value="" name="cesareanIdicatio2"/>
      </div>
      
        <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况：</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名：</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <input id="u485_input" type="text" value="" name="babyName2"/>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别：</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">
        <select id="u482_input" name="babySex2">
        	<option></option>
        	<option value="0">男</option>
        	<option value="1">女</option>
        </select>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况：</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
        <select id="u484_input" name="health2">
        </select>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形：</span></p>
      </div>
      
      
      
       <div id="u486" class="ax_下拉列表框">
        <select id="u486_input" name="fetalAnomaly2">
        </select>
      </div>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位：</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <input id="u487_input" type="text" value="" name="abnormalPosition2"/>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称：</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <input id="u488_input" type="text" value="" name="abnormalName2"/>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分：</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分：</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <input id="u489_input" type="text" value="" name="oneMinScore2"/>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分：</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <input id="u490_input" type="text" value="" name="fiveMinScore2"/>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重：</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <input id="u491_input" type="text" value="" name="bornWeight2"/>
      </div>
      
       <div id="u493" class="ax_文本段落">
          <p id="u494"><span>g</span></p>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长：</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <input id="u492_input" type="text" value="" name="bodyLenght2"/>
      </div>
      <div id="u495" class="ax_文本段落">
          <p id="u496"><span>cm</span></p>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗：</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
        <input id="u411_input" type="checkbox" value="0" name="vaccine2"/>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        <input id="u413_input" type="checkbox" value="1" name="vaccine2"/>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        <input id="u415_input" type="checkbox" value="2" name="vaccine2"/>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡：</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <select id="u498_input" name="fetusDie2">
        </select>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者：</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <input id="u497_input" type="text" value="" name="midwife2"/>
      </div>
 </div>
 
 <div id="hs3"  style="display: none" >
		<div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位：</span></p>
      </div>
      
       <!-- Unnamed (下拉列表框) -->
      <div id="u457" class="ax_下拉列表框">
        <select id="u457_input" name="fetusPosition3">
        </select>
      </div>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间：</span></p>
      </div>
      
        <div id="u460" class="ax_文本框">
        <input id="u460_input" type="text" value="" name="deliveryHour3"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u461" class="ax_文本段落">
          <p  id="u462"><span>时</span></p>
  	  </div>
      

      <!-- Unnamed (文本框) -->
      <div id="u465" class="ax_文本框">
        <input id="u465_input" type="text" value="" name="deliveryMinute3"/>
      </div>
      
      <div id="u463" class="ax_文本段落">      
          <p id="u464"><span>分</span></p>
      </div>
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产：</span></p>
      </div>
      
       <div id="u458" class="ax_下拉列表框">
        <select id="u458_input" name="inducelabour3">
        </select>
      </div>
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式：</span></p>
      </div>
      
      
       <div id="u459" class="ax_下拉列表框">
        <select id="u459_input" name="deliveryType3">
        	<option ></option>
        	<option value="0">刨妇产</option>
        	<option value="1">顺产</option>
        </select>
      </div>
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征：</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <input id="u466_input" type="text" value="" name="cesareanIdicatio3"/>
      </div>
      
        <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况：</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名：</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <input id="u485_input" type="text" value="" name="babyName3"/>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别：</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">
        <select id="u482_input" name="babySex3">
        	<option></option>
        	<option value="0">男</option>
        	<option value="1">女</option>
        </select>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况：</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
        <select id="u484_input" name="health3">
        </select>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形：</span></p>
      </div>
      
      
      
       <div id="u486" class="ax_下拉列表框">
        <select id="u486_input" name="fetalAnomaly3">
        </select>
      </div>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位：</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <input id="u487_input" type="text" value="" name="abnormalPosition3"/>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称：</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <input id="u488_input" type="text" value="" name="abnormalName3"/>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分：</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分：</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <input id="u489_input" type="text" value="" name="oneMinScore3"/>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分：</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <input id="u490_input" type="text" value="" name="fiveMinScore3"/>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重：</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <input id="u491_input" type="text" value="" name="bornWeight3"/>
      </div>
      
       <div id="u493" class="ax_文本段落">
          <p id="u494"><span>g</span></p>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长：</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <input id="u492_input" type="text" value="" name="bodyLenght3"/>
      </div>
      <div id="u495" class="ax_文本段落">
          <p id="u496"><span>cm</span></p>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗：</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
        <input id="u411_input" type="checkbox" value="0" name="vaccine3"/>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        <input id="u413_input" type="checkbox" value="1" name="vaccine3"/>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        <input id="u415_input" type="checkbox" value="2" name="vaccine3"/>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡：</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <select id="u498_input" name="fetusDie3">
        </select>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者：</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <input id="u497_input" type="text" value="" name="midwife3"/>
      </div>
 </div>
<div id="hs4"  style="display: none" >
		<div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位：</span></p>
      </div>
      
       <!-- Unnamed (下拉列表框) -->
      <div id="u457" class="ax_下拉列表框">
        <select id="u457_input" name="fetusPosition4">
        </select>
      </div>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间：</span></p>
      </div>
      
        <div id="u460" class="ax_文本框">
        <input id="u460_input" type="text" value="" name="deliveryHour4"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u461" class="ax_文本段落">
          <p  id="u462"><span>时</span></p>
  	  </div>
      

      <!-- Unnamed (文本框) -->
      <div id="u465" class="ax_文本框">
        <input id="u465_input" type="text" value="" name="deliveryMinute4"/>
      </div>
      
      <div id="u463" class="ax_文本段落">      
          <p id="u464"><span>分</span></p>
      </div>
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产：</span></p>
      </div>
      
       <div id="u458" class="ax_下拉列表框">
        <select id="u458_input" name="inducelabour4">
        </select>
      </div>
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式：</span></p>
      </div>
      
      
       <div id="u459" class="ax_下拉列表框">
        <select id="u459_input" name="deliveryType4">
        	<option ></option>
        	<option value="0">刨妇产</option>
        	<option value="1">顺产</option>
        </select>
      </div>
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征：</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <input id="u466_input" type="text" value="" name="cesareanIdicatio4"/>
      </div>
      
        <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况：</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名：</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <input id="u485_input" type="text" value="" name="babyName4"/>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别：</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">
        <select id="u482_input" name="babySex4">
        	<option ></option>
        	<option value="0">男</option>
        	<option value="1">女</option>
        </select>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况：</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
        <select id="u484_input" name="health4">
        </select>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形：</span></p>
      </div>
      
      
      
       <div id="u486" class="ax_下拉列表框">
        <select id="u486_input" name="fetalAnomaly4">
        </select>
      </div>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位：</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <input id="u487_input" type="text" value="" name="abnormalPosition4"/>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称：</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <input id="u488_input" type="text" value="" name="abnormalName4"/>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分：</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分：</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <input id="u489_input" type="text" value="" name="oneMinScore4"/>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分：</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <input id="u490_input" type="text" value="" name="fiveMinScore4"/>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重：</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <input id="u491_input" type="text" value="" name="bornWeight4"/>
      </div>
      
       <div id="u493" class="ax_文本段落">
          <p id="u494"><span>g</span></p>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长：</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <input id="u492_input" type="text" value="" name="bodyLenght4"/>
      </div>
      <div id="u495" class="ax_文本段落">
          <p id="u496"><span>cm</span></p>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗：</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
        <input id="u411_input" type="checkbox" value="0" name="vaccine4"/>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        <input id="u413_input" type="checkbox" value="1" name="vaccine4"/>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        <input id="u415_input" type="checkbox" value="2" name="vaccine4"/>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡：</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <select id="u498_input" name="fetusDie4">
        </select>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者：</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <input id="u497_input" type="text" value="" name="midwife4"/>
      </div>
 </div>
 <div id="hs5"  style="display: none" >
		<div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位：</span></p>
      </div>
      
       <!-- Unnamed (下拉列表框) -->
      <div id="u457" class="ax_下拉列表框">
        <select id="u457_input" name="fetusPosition5">
        </select>
      </div>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间：</span></p>
      </div>
      
        <div id="u460" class="ax_文本框">
        <input id="u460_input" type="text" value="" name="deliveryHour5"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u461" class="ax_文本段落">
          <p  id="u462"><span>时</span></p>
  	  </div>
      

      <!-- Unnamed (文本框) -->
      <div id="u465" class="ax_文本框">
        <input id="u465_input" type="text" value="" name="deliveryMinute5"/>
      </div>
      
      <div id="u463" class="ax_文本段落">      
          <p id="u464"><span>分</span></p>
      </div>
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产：</span></p>
      </div>
      
       <div id="u458" class="ax_下拉列表框">
        <select id="u458_input" name="inducelabour5">
        </select>
      </div>
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式：</span></p>
      </div>
      
      
       <div id="u459" class="ax_下拉列表框">
        <select id="u459_input" name="deliveryType5">
        	<option ></option>
        	<option value="0">刨妇产</option>
        	<option value="1">顺产</option>
        </select>
      </div>
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征：</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <input id="u466_input" type="text" value="" name="cesareanIdicatio5"/>
      </div>
      
        <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况：</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名：</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <input id="u485_input" type="text" value="" name="babyName5"/>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别：</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">
        <select id="u482_input" name="babySex5">
        	<option ></option>
        	<option value="0">男</option>
        	<option value="1">女</option>
        </select>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况：</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
        <select id="u484_input" name="health5">
        </select>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形：</span></p>
      </div>
      
      
      
       <div id="u486" class="ax_下拉列表框">
        <select id="u486_input" name="fetalAnomaly5">
        </select>
      </div>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位：</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <input id="u487_input" type="text" value="" name="abnormalPosition5"/>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称：</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <input id="u488_input" type="text" value="" name="abnormalName5"/>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分：</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分：</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <input id="u489_input" type="text" value="" name="oneMinScore5"/>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分：</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <input id="u490_input" type="text" value="" name="fiveMinScore5"/>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重：</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <input id="u491_input" type="text" value="" name="bornWeight5"/>
      </div>
      
       <div id="u493" class="ax_文本段落">
          <p id="u494"><span>g</span></p>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长：</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <input id="u492_input" type="text" value="" name="bodyLenght5"/>
      </div>
      <div id="u495" class="ax_文本段落">
          <p id="u496"><span>cm</span></p>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗：</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
        <input id="u411_input" type="checkbox" value="0" name="vaccine5"/>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        <input id="u413_input" type="checkbox" value="1" name="vaccine5"/>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        <input id="u415_input" type="checkbox" value="2" name="vaccine5"/>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡：</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <select id="u498_input" name="fetusDie5">
        </select>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者：</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <input id="u497_input" type="text" value="" name="midwife5"/>
      </div>
 </div>
 <div id="hs6"  style="display: none" >
	  <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位：</span></p>
      </div>
      
       <!-- Unnamed (下拉列表框) -->
      <div id="u457" class="ax_下拉列表框">
        <select id="u457_input" name="fetusPosition6">
        </select>
      </div>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间：</span></p>
      </div>
      
        <div id="u460" class="ax_文本框">
        <input id="u460_input" type="text" value="" name="deliveryHour6"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u461" class="ax_文本段落">
          <p  id="u462"><span>时</span></p>
  	  </div>
      

      <!-- Unnamed (文本框) -->
      <div id="u465" class="ax_文本框">
        <input id="u465_input" type="text" value="" name="deliveryMinute6"/>
      </div>
      
      <div id="u463" class="ax_文本段落">      
          <p id="u464"><span>分</span></p>
      </div>
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产：</span></p>
      </div>
      
       <div id="u458" class="ax_下拉列表框">
        <select id="u458_input" name="inducelabour6">
        </select>
      </div>
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式：</span></p>
      </div>
      
      
       <div id="u459" class="ax_下拉列表框">
        <select id="u459_input" name="deliveryType6">
        	<option ></option>
        	<option value="0">刨妇产</option>
        	<option value="1">顺产</option>
        </select>
      </div>
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征：</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <input id="u466_input" type="text" value="" name="cesareanIdicatio6"/>
      </div>
      
        <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况：</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名：</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <input id="u485_input" type="text" value="" name="babyName6"/>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别：</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">
        <select id="u482_input" name="babySex6">
        	<option ></option>
        	<option value="0">男</option>
        	<option value="1">女</option>
        </select>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况：</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
        <select id="u484_input" name="health6">
        </select>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形：</span></p>
      </div>
      
      
      
       <div id="u486" class="ax_下拉列表框">
        <select id="u486_input" name="fetalAnomaly6">
        </select>
      </div>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位：</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <input id="u487_input" type="text" value="" name="abnormalPosition6"/>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称：</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <input id="u488_input" type="text" value="" name="abnormalName6"/>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分：</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分：</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <input id="u489_input" type="text" value="" name="oneMinScore6"/>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分：</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <input id="u490_input" type="text" value="" name="fiveMinScore6"/>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重：</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <input id="u491_input" type="text" value="" name="bornWeight6"/>
      </div>
      
       <div id="u493" class="ax_文本段落">
          <p id="u494"><span>g</span></p>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长：</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <input id="u492_input" type="text" value="" name="bodyLenght6"/>
      </div>
      <div id="u495" class="ax_文本段落">
          <p id="u496"><span>cm</span></p>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗：</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
        <input id="u411_input" type="checkbox" value="0" name="vaccine6"/>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        <input id="u413_input" type="checkbox" value="1" name="vaccine6"/>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        <input id="u415_input" type="checkbox" value="2" name="vaccine6"/>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡：</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <select id="u498_input" name="fetusDie6">
        </select>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者：</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <input id="u497_input" type="text" value="" name="midwife6"/>
      </div>
 </div>
 </div>
<div id="s8" style="display:''">        
    <div id="u421" class="ax_文本段落">
          <p id="u422"><span>产妇、婴儿死亡情况：</span></p>
    </div>  
        
      
      <div id="u423" class="ax_文本段落">
          <p id="u424"><span id="" name="puerpera">产妇：</span></p>
      </div>
      
      <div id="u499" class="ax_文本框">
        <input id="u499_input" type="text" value="" name="puerpera"/>
      </div>
      
       <div id="u425" class="ax_文本段落">
          <p id="u426"><span >死亡原因：</span></p>
      </div>
      
      <div id="u500" class="ax_文本框">
        <input id="u500_input" type="text" value="" name="puerperaDieReason"/>
      </div>
      
       <div id="u427" class="ax_文本段落">
          <p id="u428"><span >婴儿：</span></p>
      </div>
      
      <div id="u501" class="ax_文本框">
        <input id="u501_input" type="text" value="" name="baby"/>
      </div>
      
</div>

<div id="s9">      
      <div id="u22" class="ax_形状" style="background-color:#009dd9">
          <p id="u23"><span>转   诊</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u24" class="ax_文本段落">
          <!-- <p id="u25"><span>收起</span></p> -->
           <p id="u25" onclick="CanShu('s7','u25');">收起</p>
      </div>
</div>      
     
     
<div id="s7" style="display:''">    
      <div id="u26" class="ax_文本段落">
          <p id="u27"><span>转诊</span><span>：</span></p>
      </div>
      
      <div id="u28" class="ax_单选按钮">
            <p id="u29"><span> 无</span></p>
        <input id="u28_input" type="radio" value="0" name="referral"/>
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u30" class="ax_单选按钮">
            <p id="u31"><span> 有</span></p>
        <input id="u30_input" type="radio" value="1" name="referral"/>
      </div>
      
      <div id="u32" class="ax_文本段落">
          <p id="u33"><span>原因：</span></p>
      </div>
      
       <div id="u34" class="ax_文本框">
        <input id="u34_input" type="text" value="" name="referralReason"/>
      </div>
      
      <div id="u35" class="ax_文本段落">
          <p id="u36"><span>转诊机构：</span></p>
      </div>
      
      <div id="u37" class="ax_下拉列表框">
        <select id="u37_input" name="mechanism">
        	<c:forEach var="list" items="${list }"></c:forEach>
        	<option  value="${list.id}">${list.name}</option>
        </select> 
      </div>
      
      <div id="u38" class="ax_文本段落">
          <p id="u39"><span>转诊科室：</span></p>
      </div>
      
      <div id="u40" class="ax_下拉列表框">
        <select id="u40_input" name="department">
        	<c:forEach items="${roleList }" var="role">
               <option value="${role.id }">${role.name }</option>
            </c:forEach>
        </select>
      </div>
      <div id="u41" class="ax_文本段落">
          <p id="u42"><span>下次访视日期：</span></p>
      </div>

       <div id="u43" class="ax_下拉列表框">
        <input type="text" id="u43_input" name="nextFollowingDate" readonly 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required/>
      </div>
      
      <div id="u44" class="ax_文本段落">
          <p id="u45"><span>是否预约
          下次访视：</span></p>
      </div>
      
      <div id="u46" class="ax_单选按钮">
       <p id="u47" ><span> 是</span></p>
        <input id="u46_input" type="radio" value="0" name="u46" name="orderCheck" />
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u48" class="ax_单选按钮">
            <p id="u49"><span> 否</span></p>
        <input id="u48_input" type="radio" value="1" name="u48" name="orderCheck"/>
      </div>
      
      <div id="u50" class="ax_文本段落">
          <p id="u51"><span>母子健康手册使用：</span></p>                
     </div>
     
     <div id="u52" class="ax_下拉列表框">
        <select id="u52_input" name="healthHandbook">
          <option value=""></option>
          <option value="是">是</option>
          <option value="否">否</option>
        </select>
     </div>
</div>       
      
      
<div id="s10">      
      <div id="u56" class="ax_形状" style="background-color:#009dd9">
          <p id="u57"><span>历史检查记录</span></p>
      </div>
    
      <div id="u58" class="ax_文本段落">
          <!-- <p id="u59"><span>收起</span></p> -->
          <p id="u59" onclick="CanShu('s11','u59');">收起</p>
      </div>
</div>

<div id="s11" style="dispaly:''">     
       		
				
				           
							          <div id="u93" class="ax_形状">
							              <p id="u94"><span>&nbsp;</span></p>
							          </div>
						              <div id="u96" class="ax_单元格">
						                  <p id="u97"><span>次数</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u98" class="ax_单元格" style="background-color:#999999">
						                  <p id="u99"><span>检查日期</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u100" class="ax_单元格" style="background-color:#999999">
						                  <p  id="u101"><span>孕周</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u102" class="ax_单元格" style="background-color:#999999">
						                  <p id="u103"><span>主诉</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u104" class="ax_单元格" style="background-color:#999999">                  
						              <p id="u105"><span>血压</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u106" class="ax_单元格" style="background-color:#999999" >
						                  <p id="u107"><span>体重</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u108" class="ax_单元格" style="background-color:#999999">
						                  <p id="u109"><span>宫高</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u110" class="ax_单元格" style="background-color:#999999">
						                  <p id="u111"><span>腹围</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u112" class="ax_单元格" style="background-color:#999999">
						                  <p id="u113"><span>胎方位</span></p>
						              </div>
						              <div id="u114" class="ax_单元格" style="background-color:#999999">
						                  <p id="u115"><span>胎心率</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u116" class="ax_单元格" style="background-color:#999999">
						                  <p id="u117"><span>先露</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u118" class="ax_单元格" style="background-color:#999999">
						                  <p id="u119"><span>浮肿</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u120" class="ax_单元格" style="background-color:#999999">
						                  <p id="u121" ><span>血红蛋白</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u122" class="ax_单元格" style="background-color:#999999">
						                  <p id="u123"><span>尿蛋白</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u124" class="ax_单元格" style="background-color:#999999">               
						                  <p id="u125"><span>血糖</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u126" class="ax_单元格" style="background-color:#999999">
						                  <p id="u127"><span>唐筛</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u128" class="ax_单元格" style="background-color:#999999">
						                  <p id="u129"><span>N</span><span>T</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u130" class="ax_单元格" style="background-color:#999999">
						                  <p id="u131"><span>四维</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u132" class="ax_单元格" style="background-color:#999999">
						                  <p id="u133"><span>B超</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u134" class="ax_单元格" style="background-color:#999999">              
						                  <p  id="u135"><span>NST</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u136" class="ax_单元格" style="background-color:#999999">
						                  <p id="u137"><span>其他肝功、肾功、免疫）</span></p>
						              </div>
						
						                            <!-- Unnamed (单元格) -->
						              <div id="u138" class="ax_单元格" style="background-color:#999999">
						               
						                  <p id="u139"><span>高危评分</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u140" class="ax_单元格" style="background-color:#999999">
						                  <p id="u141"><span>高危因素</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u142" class="ax_单元格" style="background-color:#999999">
						                <div id="u143" class="text">
						                  <p><span>分类</span></p>
						                </div>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u144" class="ax_单元格" style="background-color:#999999">
						                  <p id="u145"><span>转诊</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u146" class="ax_单元格" style="background-color:#999999">
						                  <p id="u147"><span>下次随访日期</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u148" class="ax_单元格" style="background-color:#999999">
						                  <p id="u149"><span>产检检查单位</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u150" class="ax_单元格" style="background-color:#999999">
						                  <p id="u151"><span>随访医生</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u152" class="ax_单元格" style="background-color:#999999">
						                  <p id="u153"><span>指导</span></p>
						              </div>
						
						              <!-- Unnamed (单元格) -->
						              <div id="u154" class="ax_单元格" style="background-color:#999999">
						                  <p id="u155"><span>操作</span></p>
						              </div>
</div>
</form>
	</div>
	
  </body>
</html>
