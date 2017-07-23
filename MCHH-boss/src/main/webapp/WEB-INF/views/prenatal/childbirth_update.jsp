<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>0分娩登记</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="${ctx }/static/resources/css/jquery-ui-themes.css"
	type="text/css" rel="stylesheet" />
<link href="${ctx }/static/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="${ctx }/static/data/styles.css" type="text/css"
	rel="stylesheet" />
<link href="${ctx}/static/css/childbirth_update.css" type="text/css"
	rel="stylesheet" />


<script type="text/javascript">
	$(function() {

		
		var size=document.getElementById('size').value;
		var sh = document.getElementById('s7').style.display;
 		if(size==2){
 			
 			document.getElementById("hs1").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
			}
 			
 		}
 		if(size==3){
 			
 			document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+720+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+720+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+720+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+720+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+720+'px';
     		
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+720+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+720+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+536+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+536+'px';
			}
 			
 		}if(size==4){
 			
 			document.getElementById("hs1").style.display='';
 			
     		document.getElementById("hs2").style.display='';
     		
     		document.getElementById("hs3").style.display='';
     		
     		//document.getElementById('h4').style.height='1590px';
			document.getElementById('h4').style.height='1743px';
     		//document.getElementById('u1314').style.height='1743px';
     		
     		document.getElementById('s8').style.top='1640px';
     		
     		document.getElementById('s9').style.top='2160px';
     		
     		document.getElementById('s7').style.top='2188px';
     		
     		
     		if (sh == '') {
         		document.getElementById('s10').style.top='2371px';
         		document.getElementById('s11').style.top='2398px';
			}else{
         		document.getElementById('s10').style.top='2187px';
         		document.getElementById('s11').style.top='2214px';
			}
 			
 		}if(size==5){
 			
 			document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		document.getElementById("hs3").style.display='';
     		document.getElementById("hs4").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+1440+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+1440+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+1440+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+1440+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+1440+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1440+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1440+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1256+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1256+'px';
			}
 			
 		}if(size==6){
 			
 			document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		document.getElementById("hs3").style.display='';
     		document.getElementById("hs4").style.display='';
     		document.getElementById("hs5").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+1800+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+1800+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+1800+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+1800+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+1800+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1800+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1800+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1616+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1616+'px';
			}
 			
 		}if(size==7){
 			
 			
 			document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		document.getElementById("hs3").style.display='';
     		document.getElementById("hs4").style.display='';
     		document.getElementById("hs5").style.display='';
     		document.getElementById("hs6").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+2160+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+2160+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+2160+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+2160+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+2160+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+2160+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+2160+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1976+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1976+'px';
			}
 			
 		}
 		 
 		var n = size;
 		
 	$("#u504_img").click(function(){
 			
 			//var n=size;
 			n++;
 			//size++;
 			
 		if(n==1){
 			
 		document.getElementById("hs1").style.display='';
 		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
 		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
 		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
 		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
 		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
 		if (sh == '') {
     		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
     		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
		}else{
     		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
     		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
		}
 		
 		}
 		else if(n==2){
     		
     		document.getElementById("hs1").style.display='';
     		//document.getElementById("hs2").style.display='';
     		
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
     		
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
			}
     		
     		}
 		else if(n==3){
     		document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		//document.getElementById("hs3").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
			}
     		
     		}
 		
 		else if(n==4){
     		document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		document.getElementById("hs3").style.display='';
     		//document.getElementById("hs4").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
			}
     		
     		
     		}
 		else if(n==5){
 			
     		document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		document.getElementById("hs3").style.display='';
     		document.getElementById("hs4").style.display='';
     		//document.getElementById("hs5").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
			}
     		
     		}
 		else if(n==6){
 			
     		document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		document.getElementById("hs3").style.display='';
     		document.getElementById("hs4").style.display='';
     		document.getElementById("hs5").style.display='';
     		//document.getElementById("hs6").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
			}
     		
     		}
 		
 		else if(n==7){
 			
     		document.getElementById("hs1").style.display='';
     		document.getElementById("hs2").style.display='';
     		document.getElementById("hs3").style.display='';
     		document.getElementById("hs4").style.display='';
     		document.getElementById("hs5").style.display='';
     		document.getElementById("hs6").style.display='';
     		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
     		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
     		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
     		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
     		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
     		if (sh == '') {
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
			}else{
         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
			}
     		
     		}
 		else{ 
 			alert("您好！系统默认最多添加六个婴儿信息！");
 			n = 7;
 			//size--;
 		}
     		return false;
 		
 	});
 		
 		$("#u505_img").click(function(){
 			//var n=size;

 			n--;
     		//size--;
     		
     		if(n==1){
         		
         		
         		document.getElementById("hs1").style.display='none';
         		document.getElementById("hs2").style.display='none';
         		document.getElementById("hs3").style.display='none';
         		document.getElementById("hs4").style.display='none';
         		document.getElementById("hs5").style.display='none';
         		document.getElementById("hs6").style.display='none';
         		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight-360+'px';
         		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight-360+'px';
         		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop-360+'px';
         		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop-360+'px';
         		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop-360+'px';
         		if (sh == '') {
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-360+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-360+'px';
				}else{
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-544+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-544+'px';
				}
         		}
     		else if(n==2){
             		document.getElementById("hs1").style.display='';
             		document.getElementById("hs2").style.display='none';
             		document.getElementById("hs3").style.display='none';
             		document.getElementById("hs4").style.display='none';
             		document.getElementById("hs5").style.display='none';
             		document.getElementById("hs6").style.display='none';
             		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight-360+'px';
             		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight-360+'px';
             		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop-360+'px';
             		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop-360+'px';
             		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop-360+'px';
             		if (sh == '') {
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-360+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-360+'px';
    				}else{
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-544+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-544+'px';
    				}
             		}
     		else if(n==3){
             		document.getElementById("hs1").style.display='';
             		document.getElementById("hs2").style.display='';
             		document.getElementById("hs3").style.display='none';
             		document.getElementById("hs4").style.display='none';
             		document.getElementById("hs5").style.display='none';
             		document.getElementById("hs6").style.display='none';
             		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight-360+'px';
             		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight-360+'px';
             		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop-360+'px';
             		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop-360+'px';
             		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop-360+'px';
             		if (sh == '') {
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-360+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-360+'px';
    				}else{
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-544+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-544+'px';
    				}
             		}
     		else if(n==4){
             		document.getElementById("hs1").style.display='';
             		document.getElementById("hs2").style.display='';
             		document.getElementById("hs3").style.display='';
             		document.getElementById("hs4").style.display='none';
             		document.getElementById("hs5").style.display='none';
             		document.getElementById("hs6").style.display='none';
             		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight-360+'px';
             		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight-360+'px';
             		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop-360+'px';
             		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop-360+'px';
             		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop-360+'px';
             		if (sh == '') {
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-360+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-360+'px';
    				}else{
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-544+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-544+'px';
    				}
             		}
     		else if(n==5){
             		document.getElementById("hs1").style.display='';
             		document.getElementById("hs2").style.display='';
             		document.getElementById("hs3").style.display='';
             		document.getElementById("hs4").style.display='';
             		document.getElementById("hs5").style.display='none';
             		document.getElementById("hs6").style.display='none';
             		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight-360+'px';
             		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight-360+'px';
             		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop-360+'px';
             		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop-360+'px';
             		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop-360+'px';
             		if (sh == '') {
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-360+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-360+'px';
    				}else{
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-544+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-544+'px';
    				}
             		
             		}
     		else if(n==6){
             		document.getElementById("hs1").style.display='';
             		document.getElementById("hs2").style.display='';
             		document.getElementById("hs3").style.display='';
             		document.getElementById("hs4").style.display='';
             		document.getElementById("hs5").style.display='';
             		document.getElementById("hs6").style.display='none';
             		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight-360+'px';
             		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight-360+'px';
             		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop-360+'px';
             		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop-360+'px';
             		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop-360+'px';
             		if (sh == '') {
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-360+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-360+'px';
    				}else{
    	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-544+'px';
    	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-544+'px';
    				}
             		
             		}
     		/* else if(n==7){
     			
         		document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById("hs3").style.display='';
         		document.getElementById("hs4").style.display='';
         		document.getElementById("hs5").style.display='';
         		document.getElementById("hs6").style.display='';
         		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight-360+'px';
         		//document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight-360+'px';
         		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop-360+'px';
         		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop-360+'px';
         		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop-360+'px';
         		if (sh == '') {
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-360+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-360+'px';
				}else{
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop-544+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop-544+'px';
				}
         		
         		} */
     		else{
     			n = 1;
     			alert("您好！系统默认至少一个婴儿信息！");
     		}
     		return false;
 		
 		
 		});
				//保存
				var updateUrl = "${ctx}/archivesinfo/updateBirth";
				$("#u61").click(function() {
				
					//获取疫苗
					var abc1 = "";
		 			 //获得所打的疫苗
					 if($("#u411_input1").attr("checked")){
		 			 	var a1 = $("#u411_input1").val();
		 			 	if(a1 != "" || a1 != null){
		 			 		abc1 += a1 +",";
		 			 	}
					 }
					 if($("#u413_input1").attr("checked")){
		 			 	var b1 = $("#u413_input1").val();
		 			 	if(b1 != "" || b1 != null){
		 			 		abc1 += b1 +",";
		 			 	}
					 }
					
					 if($("#u415_input1").attr("checked")){
		 			 	var c1 = $("#u415_input1").val();
		 			 	if(c1 != "" || c1 != null){
		 			 		abc1 += c1+",";
		 			 	}
					 }
					 if(abc1 != "" || abc1 != null){
						 abc1 = abc1.substring(0,abc1.length-1);
					 }
				document.getElementById("babyVaccine1").value=abc1;
				var abc2 = "";
	 			 //获得所打的疫苗
				 if($("#u411_input2").attr("checked")){
	 			 	var a2 = $("#u411_input2").val();
	 			 	if(a2 != "" || a2 != null){
	 			 		abc2 += a2 +",";
	 			 	}
				 }
				 if($("#u413_input2").attr("checked")){
	 			 	var b2 = $("#u413_input2").val();
	 			 	if(b2 != "" || b2 != null){
	 			 		abc2 += b2 +",";
	 			 	}
				 }
				
				 if($("#u415_input2").attr("checked")){
	 			 	var c2 = $("#u415_input2").val();
	 			 	if(c2 != "" || c2 != null){
	 			 		abc2 += c2+",";
	 			 	}
				 }
				 if(abc2 != "" || abc2 != null){
					 abc2 = abc2.substring(0,abc2.length-1);
				 }
				
			document.getElementById("babyVaccine2").value=abc2;
			var abc3 = "";
			 //获得所打的疫苗
			 if($("#u411_input3").attr("checked")){
			 	var a3 = $("#u411_input3").val();
			 	if(a3 != "" || a3 != null){
			 		abc3 += a3 +",";
			 	}
			 }
			 if($("#u413_input3").attr("checked")){
			 	var b3 = $("#u413_input3").val();
			 	if(b3 != "" || b3 != null){
			 		abc3 += b3 +",";
			 	}
			 }
			 
			
			 if($("#u415_input3").attr("checked")){
			 	var c3 = $("#u415_input3").val();
			 	if(c3 != "" || c3 != null){
			 		abc3 += c3+",";
			 	}
			 }
			 if(abc3 != "" || abc3 != null){
				 abc3 = abc3.substring(0,abc3.length-1);
			 }
			
			document.getElementById("babyVaccine3").value=abc3;
			var abc4 = "";
			 //获得所打的疫苗
			 if($("#u411_input4").attr("checked")){
			 	var a4 = $("#u411_input4").val();
			 	if(a4 != "" || a4 != null){
			 		abc4 += a4 +",";
			 	}
			 }
			 if($("#u413_input4").attr("checked")){
			 	var b4 = $("#u413_input4").val();
			 	if(b4 != "" || b4 != null){
			 		abc4 += b4 +",";
			 	}
			 }
			
			 if($("#u415_input4").attr("checked")){
			 	var c4 = $("#u415_input4").val();
			 	if(c4 != "" || c4 != null){
			 		abc4 += c4+",";
			 	}
			 }
			 if(abc4 != "" || abc4 != null){
				 abc4 = abc4.substring(0,abc4.length-1);
			 }
			
		document.getElementById("babyVaccine4").value=abc4;
		var abc5 = "";
		 //获得所打的疫苗
		 if($("#u411_input5").attr("checked")){
		 	var a5 = $("#u411_input5").val();
		 	if(a5 != "" || a5 != null){
		 		abc5 += a5 +",";
		 	}
		 }
		 if($("#u413_input5").attr("checked")){
		 	var b5 = $("#u413_input5").val();
		 	if(b5 != "" || b5 != null){
		 		abc5 += b5 +",";
		 	}
		 }
		
		 if($("#u415_input5").attr("checked")){
		 	var c5 = $("#u415_input5").val();
		 	if(c5 != "" || c5 != null){
		 		abc5 += c5+",";
		 	}
		 }
		 if(abc5 != "" || abc5 != null){
			 abc5 = abc5.substring(0,abc5.length-1);
		 }
		
				document.getElementById("babyVaccine5").value=abc5;
				var abc6 = "";
				//获得所打的疫苗
				if($("#u411_input6").attr("checked")){
					var a6 = $("#u411_input6").val();
					if(a6 != "" || a6 != null){
						abc6 += a6 +",";
					}
				}
				if($("#u413_input6").attr("checked")){
					var b6 = $("#u413_input6").val();
					if(b6 != "" || b6 != null){
						abc6 += b6 +",";
					}
				}
				if($("#u415_input6").attr("checked")){
					var c6 = $("#u415_input6").val();
					if(c6 != "" || c6 != null){
						abc6 += c6+",";
					}
				}
				if(abc6 != "" || abc6 != null){
					 abc6 = abc6.substring(0,abc6.length-1);
				}
			document.getElementById("babyVaccine6").value=abc6;


					document.getElementById("editStatus").value = 0;

					$("#queryform").attr("action", updateUrl);
					$("#queryform").submit();

				});
				
				
				
				//完成
				$("#u63").click(function() {
					
					var abc1 = "";
		 			 //获得所打的疫苗
					 if($("#u411_input1").attr("checked")){
		 			 	var a1 = $("#u411_input1").val();
		 			 	if(a1 != "" || a1 != null){
		 			 		abc1 += a1 +",";
		 			 	}
					 }
					 if($("#u413_input1").attr("checked")){
		 			 	var b1 = $("#u413_input1").val();
		 			 	if(b1 != "" || b1 != null){
		 			 		abc1 += b1 +",";
		 			 	}
					 }
					 if($("#u415_input1").attr("checked")){
		 			 	var c1 = $("#u415_input1").val();
		 			 	if(c1 != "" || c1 != null){
		 			 		abc1 += c1+",";
		 			 	}
					 }
					 if(abc1 != "" || abc1 != null){
						 abc1 = abc1.substring(0,abc1.length-1);
					 }
					 
					
				document.getElementById("babyVaccine1").value=abc1;
				var abc2 = "";
	 			 //获得所打的疫苗
				 if($("#u411_input2").attr("checked")){
	 			 	var a2 = $("#u411_input2").val();
	 			 	if(a2 != "" || a2 != null){
	 			 		abc2 += a2 +",";
	 			 	}
				 }
				 if($("#u413_input2").attr("checked")){
	 			 	var b2 = $("#u413_input2").val();
	 			 	if(b2 != "" || b2 != null){
	 			 		abc2 += b2 +",";
	 			 	}
				 }
				 if($("#u415_input2").attr("checked")){
	 			 	var c2 = $("#u415_input2").val();
	 			 	if(c2 != "" || c2 != null){
	 			 		abc2 += c2+",";
	 			 	}
				 }
				 if(abc2 != "" || abc2 != null){
					 abc2 = abc2.substring(0,abc2.length-1);
				 }
			document.getElementById("babyVaccine2").value=abc2;
			var abc3 = "";
			 //获得所打的疫苗
			 if($("#u411_input3").attr("checked")){
			 	var a3 = $("#u411_input3").val();
			 	if(a3 != "" || a3 != null){
			 		abc3 += a3 +",";
			 	}
			 }
			 if($("#u413_input3").attr("checked")){
			 	var b3 = $("#u413_input3").val();
			 	if(b3 != "" || b3 != null){
			 		abc3 += b3 +",";
			 	}
			 }
			 if($("#u415_input3").attr("checked")){
			 	var c3 = $("#u415_input3").val();
			 	if(c3 != "" || c3 != null){
			 		abc3 += c3+",";
			 	}
			 }
			 if(abc3 != "" || abc3 != null){
				 abc3 = abc3.substring(0,abc3.length-1);
			 }
					document.getElementById("babyVaccine3").value=abc3;
					var abc4 = "";
					 //获得所打的疫苗
					 if($("#u411_input4").attr("checked")){
					 	var a4 = $("#u411_input4").val();
					 	if(a4 != "" || a4 != null){
					 		abc4 += a4 +",";
					 	}
					 }
					 if($("#u413_input4").attr("checked")){
					 	var b4 = $("#u413_input4").val();
					 	if(b4 != "" || b4 != null){
					 		abc4 += b4 +",";
					 	}
					 }
					 if($("#u415_input4").attr("checked")){
					 	var c4 = $("#u415_input4").val();
					 	if(c4 != "" || c4 != null){
					 		abc4 += c4+",";
					 	}
					 }
					 if(abc4 != "" || abc4 != null){
						 abc4 = abc4.substring(0,abc4.length-1);
					 }
				document.getElementById("babyVaccine4").value=abc4;
				var abc5 = "";
				 //获得所打的疫苗
				 if($("#u411_input5").attr("checked")){
				 	var a5 = $("#u411_input5").val();
				 	if(a5 != "" || a5 != null){
				 		abc5 += a5 +",";
				 	}
				 }
				 if($("#u413_input5").attr("checked")){
				 	var b5 = $("#u413_input5").val();
				 	if(b5 != "" || b5 != null){
				 		abc5 += b5 +",";
				 	}
				 }
				 if($("#u415_input5").attr("checked")){
				 	var c5 = $("#u415_input5").val();
				 	if(c5 != "" || c5 != null){
				 		abc5 += c5+",";
				 	}
				 }
				 if(abc5 != "" || abc5 != null){
					 abc5 = abc5.substring(0,abc5.length-1);
				 }
			document.getElementById("babyVaccine5").value=abc5;
			var abc6 = "";
			//获得所打的疫苗
			if($("#u411_input6").attr("checked")){
				var a6 = $("#u411_input6").val();
				if(a6 != "" || a6 != null){
					abc6 += a6 +",";
				}
			}
			if($("#u413_input6").attr("checked")){
				var b6 = $("#u413_input6").val();
				if(b6 != "" || b6 != null){
					abc6 += b6 +",";
				}
			}
			if($("#u415_input6").attr("checked")){
				var c6 = $("#u415_input6").val();
				if(c6 != "" || c6 != null){
					abc6 += c6+",";
				}
			}
			if(abc6 != "" || abc6 != null){
				 abc6 = abc6.substring(0,abc6.length-1);
			}
			document.getElementById("babyVaccine6").value=abc6;
									//验证孕周
									var tag = /^[0-9]{1}$|^[0-9]{2}$/;
									var week = document
											.getElementById("u281_input").value;
									if (!tag.test(week)) {
										alert("请输入正确的孕周(周 )");
										return false;
									};
									var daytime = /^[0-9]{1}$/;
									var day = document
											.getElementById("u286_input").value;
									if (!daytime.test(day)) {
										alert("请输入正确的孕周(天)");
										return false;
									};
									//验证孕次
									var time = document
											.getElementById("u295_input").value;
									if (time == null || time == "") {
										alert("请选择孕次");
										return false;
									};

									//验证产次
									var chantime = document
											.getElementById("u298_input").value;
									if (chantime == null || chantime == "") {
										alert("请选择产次");
										return false;
									};

									//验证孕产保健次数
									var yuntime = document
											.getElementById("u305_input").value;
									if (yuntime == null || yuntime == "") {
										alert("请选择孕产保健");
										return false;
									};

									//验证是否检测乙肝
					     			var yigan=document.getElementById("u310_input").value;
					     			if(yigan ==null || yigan==""){
					     				alert("请选择是否检测乙肝");
					     				return false;
					     			};
					     			var yigankang=document.getElementById("u313_input").value;
					     			if(yigan=='0'){
					     				document.getElementById("u313_input").disabled=false;
										document.getElementById("u313_input").readOnly=false;
										if(yigankang==null||yigankang==""){
					     					alert("请选择乙肝表面抗原");
						     				return false;
					     				}
					     			}
					     			//验证是否检测梅毒
					     			var meidu=document.getElementById("u316_input").value;
					     			if(meidu ==null || meidu==""){
					     				alert("请选择是否检测梅毒");
					     				return false;
					     			};
					     			//验证是否感染梅毒
					     			var ganranmei=document.getElementById("u319_input").value;
					     			if(meidu=='0'){
										if(ganranmei==null||ganranmei==""){
					     					alert("请选择是否感染梅毒");
						     				return false;
					     				}
					     			}
					     			//验证是否检测到艾滋病
					     			var aizi=document.getElementById("u322_input").value;
					     			if(aizi ==null || aizi==""){
					     				alert("请选择是否检测艾滋病");
					     				return false;
					     			};
					     			//验证是否感染艾滋病
					     			var ganranai=document.getElementById("u325_input").value;
					     			if(aizi=='0'){
										if(ganranai==null||ganranai==""){
					     					alert("请选择是否感染艾滋病");
						     				return false;
					     				}
					     			}
					     			//验证血红蛋白检测
					     			var xue=document.getElementById("u328_input").value;
					     			if(xue ==null || xue==""){
					     				alert("请选择血红蛋白检测");
					     				return false;
					     			};
					     			//验证是否重度贫血
					     			if(xue=='0'){
					     				var pingxue=document.getElementById("u331_input").value;
					     				if(pingxue==null||pingxue==""){
					     					alert("请选择是否重度贫血");
					     				}
					     			}

									//验证第一次产程时
									var firstchan = /^\+?[1-9][0-9]*$/;
									var chanweek = document
											.getElementById("u430_input").value;
									if (!firstchan.test(chanweek)) {
										alert("请输入第一次产程(时)");
										return false;
									};
									//验证第一产程分
									var firstchanfen = /^(0|[1-9][0-9]*)$/;
									var chanTian = document
											.getElementById("u435_input").value;
									if (!firstchanfen.test(chanTian)) {
										alert("请输入第一次产程(分)");
										return false;
									};

									//验证分娩地点
									var dian = /^[\u4e00-\u9fa5]{0,}$/;
									var jiehun = document.getElementById("u429_input").value;
									var difian = document.getElementById("u909_input").value;
									if(jiehun == null &&difian !=null&&difian !=""&&jiehun !=""){
						     			if(!dian.test(difian)){
						     				alert("请输入中文地点");
						     				return false;
						     			};
					     			};

									
									//验证第二产程时
									var secondshi = /^\+?[1-9][0-9]*$/;
									var erchan = document
											.getElementById("u436_input").value;
									if (!secondshi.test(erchan)) {
										alert("请输入第二次产程(时)(数字)");
										return false;
									};

									//验证第二产程分
									var secondfen = /^(0|[1-9][0-9]*)$/;
									var erfen = document
											.getElementById("u441_input").value;
									if (!secondfen.test(erfen)) {
										alert("请输入第二次产程(分)(数字)");
										return false;
									};

									//验证第三产程时
									var threeshi = /^\+?[1-9][0-9]*$/;
									var sanchan = document
											.getElementById("u442_input").value;
									if (!threeshi.test(sanchan)) {
										alert("请输入第三次产程(时)(数字)");
										return false;
									};

									//验证第三产程分
									var threefen = /^(0|[1-9][0-9]*)$/;
									var sanfen = document
											.getElementById("u447_input").value;
									if (!threefen.test(sanfen)) {
										alert("请输入第三次产程(分)(数字)");
										return false;
									};

									//验证总产程时
									var totalfen = /^\+?[1-9][0-9]*$/;
									var totalchan = document
											.getElementById("u448_input").value;
									if (!totalfen.test(totalchan)) {
										alert("请输入总产程(时)");
										return false;
									};

									//验证在总产程分
									var totfen = /^(0|[1-9][0-9]*)$/;
									var totalfen = document
											.getElementById("u453_input").value;
									if (!totfen.test(totalfen)) {
										alert("请输入总产程(分)");
										return false;
									};
									//验证胎盘
									var taipan = document
											.getElementById("u454_input").value;
									if (taipan == null || taipan == "") {
										alert("请输入胎盘");
									};

									var huiyin = document.getElementById("u455_input").value;
									if (huiyin == null || huiyin == "") {
										alert("请输入会阴侧切");
									};
									
						 			if(huiyin=='0'){
						 				var ceqie=$("#u456_input").val();
						 				if(ceqie==null||qie==""){
						 					alert("请输入伤裂程度");
						 					return false;
						 				}
						 			}
									var chuxueliang = /^\+?[1-9][0-9]*$/;
									var chanliang = document.getElementById("u467_input").value;
									if (!chuxueliang.test(chanliang)) {
										alert("请输入产时出血量");
										return false;
									};

									var twohourliang = /^\+?[1-9][0-9]*$/;
									var twoliang = document.getElementById("u470_input").value;
									if (!twohourliang.test(twoliang)) {
										alert("请输入产时2小时出血量");
										return false;
									};

									var totalhourliang = /^\+?[1-9][0-9]*$/;
									var talliang = document.getElementById("u471_input").value;
									if (!totalhourliang.test(talliang)) {
										alert("请输入总出血量");
										return false;
									};

									//验证胎盘
									var yangshui = document.getElementById("u481_input").value;
									if (yangshui == null || yangshui == "") {
										alert("请输入羊水性状");
										return false;
									};

									var yangshuiliang = /^\+?[1-9][0-9]*$/;
									var tyangshui = document.getElementById("u478_input").value;
									if (!yangshuiliang.test(tyangshui)) {
										alert("请输入羊水量");
										return false;
									};

									var taishui = document.getElementById("u483_input").value;
									if (taishui == null || taishui == "") {
										alert("请选择胎数");
										return false;
									};

									var taiwei = document.getElementById("u457_input").value;
									if (taiwei == null || taiwei == "") {
										alert("请选择胎位");
										return false;
									};

									var fenmians = /^\+?[1-9][0-9]*$/;
									var fenmainshi = document.getElementById("u460_input").value;
									if (!fenmians.test(fenmainshi)) {
										alert("请填写分娩时");
										return false;
									};
									var fenmianf = /^\+?[1-9][0-9]*$/;
									var fenmainfen = document.getElementById("u465_input").value;
									if (!fenmianf.test(fenmainfen)) {
										alert("请填写分娩分");
										return false;
									};

									var yinchan = document.getElementById("u458_input").value;
									if (yinchan == null || yinchan == "") {
										alert("请选择引产");
										return false;
									};

									var fenmianfang = document.getElementById("u459_input").value;
									if (fenmianfang == null
											|| fenmianfang == "") {
										alert("请选择分娩方式");
										return false;
									};

									if(fenmianfang=='0'){
										var zhizheng=document.getElementById("u466_input").value;
										if(zhizheng ==null || zhizheng ==""){
											
											alert("请选择指证");
											return false;
										}
									}

									var xingming = document.getElementById("u485_input").value;
									if (xingming == null || xingming == "") {
										alert("请输入婴儿姓名");
										return false;
									};

									var xinbie = document.getElementById("u482_input").value;
									if (xinbie == null || xinbie == "") {
										alert("请选择婴儿性别");
										return false;
									};

									var jiankang = document.getElementById("u484_input").value;
									if (jiankang == null || jiankang == "") {
										alert("请选择婴儿健康状况");
										return false;
									};

									var jixing = document.getElementById("u486_input").value;
									if (jixing == null || jixing == "") {
										alert("请选择婴儿畸形状况");
										return false;
									};
									if(jixing=='0'){
										var buwei = document.getElementById("u487_input").value;
										if (buwei == null || buwei == "") {
											alert("请输入婴儿畸形部位");
											return false;
										}
										var jixingming = document.getElementById("u488_input").value;
										if (jixingming == null || jixingming == "") {
											alert("请输入婴儿畸形名称");
											return false;
										}

									}
									var yifeng = document.getElementById("u489_input").value;
									if (yifeng == null || yifeng == "") {
										alert("请输入一分钟评分");
										return false;
									};

									var wufen = document.getElementById("u490_input").value;
									if (wufen == null || wufen == "") {
										alert("请输入五分钟评分");
										return false;
									};

									var tizhong = document.getElementById("u491_input").value;
									if (tizhong == null || tizhong == "") {
										alert("请输入体重");
										return false;
									};

									var shenchang = document.getElementById("u492_input").value;
									if (shenchang == null || shenchang == "") {
										alert("请输入身长");
										return false;
									};
									var jiesheng = document.getElementById("u497_input").value;
									if (jiesheng == null || jiesheng == "") {
										alert("请输入接生者");
										return false;
									};
									var val_payPlatform = $('input[name="referral"]:checked ').val();
									if (val_payPlatform == undefined) {

										alert("请选择是否转诊");
										return false;
									}
									var shouce = document.getElementById("u52_input").value;
									if (shouce == null || shouce == "") {
										alert("请选择是否发放母子健康手册");
										return false;
									}
									var geneticHistory = $(
											'input[name="vaccine"]:checked')
											.val();
									if (geneticHistory == undefined) {
										alert("请选择疫苗");
										return false;
									}
									
									var babyname1=document.getElementById("u485_inputA").value;
									if(babyname1 !=null &&babyname1 !=""){
										var taiweiA=document.getElementById("u457_inputA").value;
										if(taiweiA ==null || taiweiA ==""){
											alert("请选择胎位");
											return false;
										};
										var fenmiansA=/^\+?[1-9][0-9]*$/;
										var fenmainshiA=document.getElementById("u460_inputA").value;
										if(!fenmiansA.test(fenmainshiA) ){
											alert("请填写分娩   时");
											return false;
										};
										var fenmianfA=/^\+?[1-9][0-9]*$/;
										var fenmainfenA=document.getElementById("u465_inputA").value;
										if(!fenmianfA.test(fenmainfenA)){
											alert("请填写分娩    分");
											return false;
										};
										var yinchanA=document.getElementById("u458_inputA").value;
										if(yinchanA ==null || yinchanA ==""){
											alert("请选择引产");
											return false;
										};
										var fenmianfangA=document.getElementById("u459_inputA").value;
										if(fenmianfangA ==null || fenmianfangA ==""){
											alert("请选择分娩方式");
											return false;
										};
										if(fenmianfangA=='0'){
											var zhizhengA=document.getElementById("u466_inputA").value;
											if(zhizhengA ==null || zhizhengA ==""){
												
												alert("请选择指证");
												return false;
											}
										}
										var xingmingA=document.getElementById("u485_inputA").value;
										if(xingmingA ==null || xingmingA ==""){
											alert("请输入婴儿姓名");
											return false;
										};
										var xinbieA=document.getElementById("u482_inputA").value;
										if(xinbieA ==null || xinbieA ==""){
											alert("请选择婴儿性别");
											return false;
										};
										var jiankangA=document.getElementById("u484_inputA").value;
										if(jiankangA==null || jiankangA ==""){
											alert("请选择婴儿健康状况");
											return false;
										};
										var jixingA=document.getElementById("u486_inputA").value;
										if(jixingA ==null || jixingA ==""){
											alert("请选择婴儿畸形状况");
											return false;
										};
										if(jixingA=='0'){
											var buwei = document.getElementById("u487_inputA").value;
											if (buwei == null || buwei == "") {
												alert("请输入婴儿畸形部位");
												return false;
											}
											var jixingmingA=document.getElementById("u488_inputA").value;
											if(jixingmingA ==null || jixingmingA ==""){
												alert("请输入婴儿畸形名称");
												return false;
											}

										}
										var yifengA=document.getElementById("u489_inputA").value;
										if(yifengA ==null || yifengA ==""){
											alert("请输入一分钟评分");
											return false;
										};
										var wufenA=document.getElementById("u490_inputA").value;
										if(wufenA ==null || wufenA ==""){
											alert("请输入五分钟评分");
											return false;
										};
										var tizhongA=document.getElementById("u491_inputA").value;
										if(tizhongA ==null || tizhongA ==""){
											alert("请输入体重");
											return false;
										};
										var shenchangA=document.getElementById("u492_inputA").value;
										if(shenchangA ==null || shenchangA ==""){
											alert("请输入身长");
											return false;
										};
										var jieshengA=document.getElementById("u497_inputA").value;
										if(jieshengA ==null || jieshengA ==""){
											alert("请输入接生者");
											return false;
										};
										
									};
									var babyname2=document.getElementById("u485_inputB").value;
									if(babyname2 !=null &&babyname2 !=""){
										
									
									var taiweiB=document.getElementById("u457_inputB").value;
									if(taiweiB ==null || taiweiB ==""){
										alert("请选择胎位");
										return false;
									};
									var fenmiansB=/^\+?[1-9][0-9]*$/;
									var fenmainshiB=document.getElementById("u460_inputB").value;
									if(!fenmiansB.test(fenmainshiB) ){
										alert("请填写分娩   时");
										return false;
									};
									var fenmianfB=/^\+?[1-9][0-9]*$/;
									var fenmainfenB=document.getElementById("u465_inputB").value;
									if(!fenmianfB.test(fenmainfenB)){
										alert("请填写分娩    分");
										return false;
									};
									var yinchanB=document.getElementById("u458_inputB").value;
									if(yinchanB ==null || yinchanB ==""){
										alert("请选择引产");
										return false;
									};
									var fenmianfangB=document.getElementById("u459_inputB").value;
									if(fenmianfangB ==null || fenmianfangB ==""){
										alert("请选择分娩方式");
										return false;
									};
									
									if(fenmianfangB=='0'){
										var zhizhengB=document.getElementById("u466_inputB").value;
										if(zhizhengB ==null || zhizhengB ==""){
											
											alert("请选择指证");
											return false;
										}
									}
									var xingmingB=document.getElementById("u485_inputB").value;
									if(xingmingB ==null || xingmingB ==""){
										alert("请输入婴儿姓名");
										return false;
									};
									var xinbieB=document.getElementById("u482_inputB").value;
									if(xinbieB ==null || xinbieB ==""){
										alert("请选择婴儿性别");
										return false;
									};
									var jiankangB=document.getElementById("u484_inputB").value;
									if(jiankangB==null || jiankangB ==""){
										alert("请选择婴儿健康状况");
										return false;
									};
									var jixingB=document.getElementById("u486_inputB").value;
									if(jixingB ==null || jixingB ==""){
										alert("请选择婴儿畸形状况");
										return false;
									};
									if(jixingB=='0'){
										var buwei = document.getElementById("u487_inputB").value;
										if (buwei == null || buwei == "") {
											alert("请输入婴儿畸形部位");
											return false;
										}
										var jixingmingB=document.getElementById("u488_inputB").value;
										if(jixingmingB ==null || jixingmingB ==""){
											alert("请输入婴儿畸形名称");
											return false;
										}

									}
									
									var yifengB=document.getElementById("u489_inputB").value;
									if(yifengB ==null || yifengB ==""){
										alert("请输入一分钟评分");
										return false;
									};
									var wufenB=document.getElementById("u490_inputB").value;
									if(wufenB ==null || wufenB ==""){
										alert("请输入五分钟评分");
										return false;
									};
									var tizhongB=document.getElementById("u491_inputB").value;
									if(tizhongB ==null || tizhongB ==""){
										alert("请输入体重");
										return false;
									};
									var shenchangB=document.getElementById("u492_inputB").value;
									if(shenchangB ==null || shenchangB ==""){
										alert("请输入身长");
										return false;
									};
									var jieshengB=document.getElementById("u497_inputB").value;
									if(jieshengB ==null || jieshengB ==""){
										alert("请输入接生者");
										return false;
									}
								};
									
								var babyname3=document.getElementById("u485_inputC").value;
								if(babyname3 !=null &&babyname3 !=""){
									var taiweiC=document.getElementById("u457_inputC").value;
									if(taiweiC ==null || taiweiC ==""){
										alert("请选择胎位");
										return false;
									};
									var fenmiansC=/^\+?[1-9][0-9]*$/;
									var fenmainshiC=document.getElementById("u460_inputC").value;
									if(!fenmiansC.test(fenmainshiC) ){
										alert("请填写分娩   时");
										return false;
									};
									var fenmianfC=/^\+?[1-9][0-9]*$/;
									var fenmainfenC=document.getElementById("u465_inputC").value;
									if(!fenmianfC.test(fenmainfenC)){
										alert("请填写分娩    分");
										return false;
									};
									var yinchanC=document.getElementById("u458_inputC").value;
									if(yinchanC ==null || yinchanC ==""){
										alert("请选择引产");
										return false;
									};
									var fenmianfangC=document.getElementById("u459_inputC").value;
									if(fenmianfangC ==null || fenmianfangC ==""){
										alert("请选择分娩方式");
										return false;
									};
									
									if(fenmianfangC=='0'){
										var zhizhengC=document.getElementById("u466_inputC").value;
										if(zhizhengC ==null || zhizhengC ==""){
											
											alert("请选择指证");
											return false;
										}
									}
									var xingmingC=document.getElementById("u485_inputC").value;
									if(xingmingC ==null || xingmingC ==""){
										alert("请输入婴儿姓名");
										return false;
									};
									var xinbieC=document.getElementById("u482_inputC").value;
									if(xinbieC ==null || xinbieC ==""){
										alert("请选择婴儿性别");
										return false;
									};
									var jiankangC=document.getElementById("u484_inputC").value;
									if(jiankangC==null || jiankangC ==""){
										alert("请选择婴儿健康状况");
										return false;
									};
									var jixingC=document.getElementById("u486_inputC").value;
									if(jixingC ==null || jixingC ==""){
										alert("请选择婴儿畸形状况");
										return false;
									};
									if(jixingC=='0'){
										var buwei = document.getElementById("u487_inputC").value;
										if (buwei == null || buwei == "") {
											alert("请输入婴儿畸形部位");
											return false;
										}
										var jixingmingC=document.getElementById("u488_inputC").value;
										if(jixingmingC ==null || jixingmingC ==""){
											alert("请输入婴儿畸形名称");
											return false;
										}

									}
									
									
									var yifengC=document.getElementById("u489_inputC").value;
									if(yifengC ==null || yifengC ==""){
										alert("请输入一分钟评分");
										return false;
									};
									var wufenC=document.getElementById("u490_inputC").value;
									if(wufenC ==null || wufenC ==""){
										alert("请输入五分钟评分");
										return false;
									};
									var tizhongC=document.getElementById("u491_inputC").value;
									if(tizhongC ==null || tizhongC ==""){
										alert("请输入体重");
										return false;
									};
									var shenchangC=document.getElementById("u492_inputC").value;
									if(shenchangC ==null || shenchangC ==""){
										alert("请输入身长");
										return false;
									};
									var jieshengC=document.getElementById("u497_inputC").value;
									if(jieshengC ==null || jieshengC ==""){
										alert("请输入接生者");
										return false;
									};
								}
								
									var upUrl = "${ctx}/archivesinfo/updateBirth";
									document.getElementById("editStatus").value = 1;
									$("#queryform").attr("action", upUrl);
									$("#queryform").submit();
								});

				var endDateUrl = "${ctx}/archivesinfo/endNote";
				$("#u67").click(function() {
					showDialog_("提示","closeExa","moretopmiddle",false);

				});
				$("#u28_input").click(function() {

									var val_payPlatfo = $(
											'input[name="referral"]:checked ')
											.val();
									//当无转诊时
									if (val_payPlatfo == '0') {
										//获取转诊原因
										$("#u34_input").val("");
										document.getElementById("u34_input").readOnly = true;
										//获取转诊机构
										document.getElementById("u37_input").selectedIndex = -1;
										document.getElementById("u37_input").disabled = true;
										document.getElementById("u37_input").readOnly = true;
										//获取转诊科室
										document.getElementById("u40_input").selectedIndex = -1;
										document.getElementById("u40_input").disabled = true;
										document.getElementById("u40_input").readOnly = true;
										return true;
									}

								});
								//当确认转诊时
								$("#u30_input").click(function() {
									var val_payPlatf = $(
											'input[name="referral"]:checked ')
											.val();
									//当有转诊时
									if (val_payPlatf == '1') {

										document.getElementById("u34_input").disabled = false;
										document.getElementById("u34_input").readOnly = false;

										document.getElementById("u37_input").disabled = false;
										document.getElementById("u37_input").readOnly = false;

										document.getElementById("u40_input").disabled = false;
										document.getElementById("u40_input").readOnly = false;

										return true;
									}

								});

								$("#u48_input").click(function(){
									var val_payPlatfor = $('input[name="orderCheck"]:checked ').val();
									//当无访视时
									//获取下次访视日期
								 		$("#u43_input").val("");
										document.getElementById("u43_input").disabled=true;
										document.getElementById("u43_input").readOnly=true;
					     			
								 	
							});
							$("#u46_input").click(function() {
									var val_payPlatqq = $('input[name="orderCheck"]:checked ').val();
									//当有访视时
									//获取下次访视日期
										document.getElementById("u43_input").disabled = false;
										document.getElementById("u43_input").readOnly = false;
										var fangshi = document.getElementById("u43_input").value;
										if (fangshi == null){
											alert("请选择访视日期");
											return false;
										}
										
									
								});

				$("#u429_input").change(function() {

					$("#u909_input").val("");

				});
				$("#u909_input").change(function() {

					document.getElementById("u429_input").selectedIndex = -1;
				});
				/* //专案管理
				$("#u65").click(function(){
				
				var id = $("#archiId").val();
		        var zUrl = "${ctx}/archivesinfo/specialNote"+'?archiveId='+id; 
						$.ajax({
		   					url:zUrl,
		   					type:"GET",
		   					success:function(data){
		   						var str = "";
		   						var cStr = "";
		   						var i = 0;
		   						debugger;
		   						var now = new Date();
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

		   						for(; i < data.list.length; i++){
		   							
		   							str += "<div style='position:absolute;left:0px;top:"+(24+i*34)+"px;width:64px;"
		   							+"height:34px;text-align:center;' class='ax_单元格'><p style='position:absolute;"
		   							  +"left:2px;top:10px;width:60px;word-wrap:break-word;'>"
		   							+"<span>"+(i+1)+"</span></p></div><div style='position:absolute;"
		   							+"left:64px;top:"+(24+i*34)+"px;width:372px;height:34px;text-align:center;' class='ax_单元格'>"
		   							+"<p style='position:absolute;left:2px;top:10px;width:368px;"
		   							+"word-wrap:break-word;'><span>"+data.list[i].highRisk+"</span></p></div>";
		   							
		   							cStr += "<div id='u020' style='position:absolute;left:480px;top:"+(303+i*34)+"px;"
		   							+"width:100px;height:15px;' class='ax_复选框'><label for='u020_input"+i+"'>"
		   							+"<p style='position:absolute;left:16px;top:0px;width:82px;word-wrap:break-word;'><span>未矫正  </span></p>"
		   							+"</label><input class='ux' id='u020_input"+i+"' name='correct"+i+"' type='radio' value='0' checked/></div>"
		   							+"<input type='hidden' name='correct_"+i+"' value='"+data.list[i].termId+"'/>"
		   							+"<div style='position:absolute;left:575px;top:"+(303+i*34)+"px;width:212px;height:15px;'"
		   							+" class='ax_复选框'><label for='u022_input"+i+"'><p style='position:absolute;"
		   							+"left:16px;top:0px;width:194px;word-wrap:break-word;'>"
		   							+"<span>已矫正&nbsp; &nbsp; "+dateTime+"</span></p></label><input class='ux' id='u022_input"+i
		   							+"' name='correct"+i+"' type='radio' value='1'/></div>";
		   						}
								if(i > 2){
									$("#u05")[0].style.top = (386+(i-2)*30)+"px";
									$("#u034")[0].style.top = (563+(i-2)*30)+"px";
									$("#u036")[0].style.top = (563+(i-2)*30)+"px";
								}
		   						$("#inner").html(str);
		   						$("#checkRadio").html(cStr);
		   						
		   						
								showDialog_l("高危专案管理","addZhuan","moremiddle");
		   					}
		   				});
					
				}); */
				
				//专案记录
				var zhuanUrl="${ctx}/highriskprojectmanagement/list";
				
				$("#u65").click(function(){
					var id = $("#archiId").val();
					var birthArchiveId = $("#birthArchiveId").val();
					
					window.location.href=zhuanUrl+'?archivesId='+id+'&birthArchiveId='+birthArchiveId ;
				})
				
				var za = 0;
				//专案记录弹出页保存
				$("#u037").click(function(){
					
					
					var birthArchivesId= $("#birthArchivesId").val();
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
				
				//转归状态
				$("#u04_input").change(function(){
					
					var status = this.value;
					
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
				$("#jau3").click(function(){
					
					$("#closeExa").window("close");
					
				});
				
				//羊水状况  是异常时
				
		 		$("#u481_input").change(function(){
		 		$("#amniotic").hide();
		 		  var facialFeatures = $("#u481_input").val();
		 		  if (facialFeatures == "0") {
		 			 $("#amniotic").hide();
		 			 $("#amniotic").val("");
				  }else{
					  $("#amniotic").show(); 
				  }
		 		});
				
				
		 		//胎儿畸形
		 		$("#u486_input").change(function(){
		 			var jixing=$("#u486_input").val();
		 			//胎儿畸形是(否)时
		 			if(jixing=='1'){
		 				document.getElementById("u487_input").disabled=true;
						document.getElementById("u487_input").readOnly=true;
						document.getElementById("u487_input").value="";
						document.getElementById("u488_input").disabled=true;
						document.getElementById("u488_input").readOnly=true;
						document.getElementById("u488_input").value="";
		 			}
		 			//胎儿畸形是(是)时
		 			if(jixing=='0'){
		 				document.getElementById("u487_input").disabled=false;
						document.getElementById("u487_input").readOnly=false;
						document.getElementById("u488_input").disabled=false;
						document.getElementById("u488_input").readOnly=false;
						
		 			}
		 			
		 		})
		 		var jixing=$("#u486_input").val();
	 			//胎儿畸形是(否)时
	 			if(jixing=='1'){
	 				document.getElementById("u487_input").disabled=true;
					document.getElementById("u487_input").readOnly=true;
					document.getElementById("u487_input").value="";
					document.getElementById("u488_input").disabled=true;
					document.getElementById("u488_input").readOnly=true;
					document.getElementById("u488_input").value="";
	 			}
		 		
		 		
		 		//胎儿畸形
		 		$("#u486_inputA").change(function(){
		 			var jixing=$("#u486_inputA").val();
		 			//胎儿畸形是(否)时
		 			if(jixing=='1'){
		 				document.getElementById("u487_inputA").disabled=true;
						document.getElementById("u487_inputA").readOnly=true;
						document.getElementById("u487_inputA").value="";
						document.getElementById("u488_inputA").disabled=true;
						document.getElementById("u488_inputA").readOnly=true;
						document.getElementById("u488_inputA").value="";
		 			}
		 			//胎儿畸形是(是)时
		 			if(jixing=='0'){
		 				document.getElementById("u487_inputA").disabled=false;
						document.getElementById("u487_inputA").readOnly=false;
						document.getElementById("u488_inputA").disabled=false;
						document.getElementById("u488_inputA").readOnly=false;
						
		 			}
		 			
		 		})
		 		var jixingA=$("#u486_inputA").val();
	 			//胎儿畸形是(否)时
	 			if(jixingA=='1'){
	 				document.getElementById("u487_inputA").disabled=true;
					document.getElementById("u487_inputA").readOnly=true;
					document.getElementById("u487_inputA").value="";
					document.getElementById("u488_inputA").disabled=true;
					document.getElementById("u488_inputA").readOnly=true;
					document.getElementById("u488_inputA").value="";
	 			}
		 		
		 		//胎儿畸形
		 		$("#u486_inputB").change(function(){
		 			var jixing=$("#u486_inputB").val();
		 			//胎儿畸形是(否)时
		 			if(jixing=='1'){
		 				document.getElementById("u487_inputB").disabled=true;
						document.getElementById("u487_inputB").readOnly=true;
						document.getElementById("u487_inputB").value="";
						document.getElementById("u488_inputB").disabled=true;
						document.getElementById("u488_inputB").readOnly=true;
						document.getElementById("u488_inputB").value="";
		 			}
		 			//胎儿畸形是(是)时
		 			if(jixing=='0'){
		 				document.getElementById("u487_inputB").disabled=false;
						document.getElementById("u487_inputB").readOnly=false;
						document.getElementById("u488_inputB").disabled=false;
						document.getElementById("u488_inputB").readOnly=false;
		 			}
		 			
		 		})
		 		var jixingB=$("#u486_inputB").val();
	 			//胎儿畸形是(否)时
	 			if(jixingB=='1'){
	 				document.getElementById("u487_inputB").disabled=true;
					document.getElementById("u487_inputB").readOnly=true;
					document.getElementById("u487_inputB").value="";
					document.getElementById("u488_inputB").disabled=true;
					document.getElementById("u488_inputB").readOnly=true;
					document.getElementById("u488_inputB").value="";
	 			}
		 		
		 		
		 		//胎儿畸形
		 		$("#u486_inputC").change(function(){
		 			var jixing=$("#u486_inputC").val();
		 			//胎儿畸形是(否)时
		 			if(jixing=='1'){
		 				document.getElementById("u487_inputC").disabled=true;
						document.getElementById("u487_inputC").readOnly=true;
						document.getElementById("u487_inputC").value="";
						document.getElementById("u488_inputC").disabled=true;
						document.getElementById("u488_inputC").readOnly=true;
						document.getElementById("u488_inputC").value="";
		 			}
		 			//胎儿畸形是(是)时
		 			if(jixing=='0'){
		 				document.getElementById("u487_inputC").disabled=false;
						document.getElementById("u487_inputC").readOnly=false;
						document.getElementById("u488_inputC").disabled=false;
						document.getElementById("u488_inputC").readOnly=false;
		 			}
		 			
		 		})
		 		var jixingC=$("#u486_inputC").val();
	 			//胎儿畸形是(否)时
	 			if(jixingC=='1'){
	 				document.getElementById("u487_inputC").disabled=true;
					document.getElementById("u487_inputC").readOnly=true;
					document.getElementById("u487_inputC").value="";
					document.getElementById("u488_inputC").disabled=true;
					document.getElementById("u488_inputC").readOnly=true;
					document.getElementById("u488_inputC").value="";
	 			}
		 		
		 		
		 		//胎儿畸形
		 		$("#u486_inputD").change(function(){
		 			var jixing=$("#u486_inputD").val();
		 			//胎儿畸形是(否)时
		 			if(jixing=='1'){
		 				document.getElementById("u487_inputD").disabled=true;
						document.getElementById("u487_inputD").readOnly=true;
						document.getElementById("u487_inputD").value="";
						document.getElementById("u488_inputD").disabled=true;
						document.getElementById("u488_inputD").readOnly=true;
						document.getElementById("u488_inputD").value="";
		 			}
		 			//胎儿畸形是(是)时
		 			if(jixing=='0'){
		 				document.getElementById("u487_inputD").disabled=false;
						document.getElementById("u487_inputD").readOnly=false;
						document.getElementById("u488_inputD").disabled=false;
						document.getElementById("u488_inputD").readOnly=false;
		 			}
		 		})
		 		var jixingD=$("#u486_inputD").val();
	 			//胎儿畸形是(否)时
	 			if(jixingD=='1'){
	 				document.getElementById("u487_inputD").disabled=true;
					document.getElementById("u487_inputD").readOnly=true;
					document.getElementById("u487_inputD").value="";
					document.getElementById("u488_inputD").disabled=true;
					document.getElementById("u488_inputD").readOnly=true;
					document.getElementById("u488_inputD").value="";
	 			}
		 		
		 		//分娩方式
				$("#u459_input").click(function(){
					var fenmian=$("#u459_input").val();
					//顺产
					if(fenmian=='1'){
						document.getElementById("u466_input").disabled=true;
						document.getElementById("u466_input").readOnly=true;
						document.getElementById("u466_input").value="";
					}
					//刨宫产
					if(fenmian=='0'){
						document.getElementById("u466_input").disabled=false;
						document.getElementById("u466_input").readOnly=false;
						
					}
					
				})
				//分娩方式
				$("#u459_inputA").click(function(){
					var fenmianA=$("#u459_inputA").val();
					//顺产
					if(fenmianA=='1'){
						document.getElementById("u466_inputA").disabled=true;
						document.getElementById("u466_inputA").readOnly=true;
						document.getElementById("u466_inputA").value="";
					}
					//刨宫产
					if(fenmianA=='0'){
						document.getElementById("u466_inputA").disabled=false;
						document.getElementById("u466_inputA").readOnly=false;
						
					}
					
				})
				//分娩方式
				$("#u459_inputB").click(function(){
					var fenmianB=$("#u459_inputB").val();
					//顺产
					if(fenmianB=='1'){
						document.getElementById("u466_inputB").disabled=true;
						document.getElementById("u466_inputB").readOnly=true;
						document.getElementById("u466_inputB").value="";
					}
					//刨宫产
					if(fenmianB=='0'){
						document.getElementById("u466_inputB").disabled=false;
						document.getElementById("u466_inputB").readOnly=false;
						
					}
					
				})
				//分娩方式
				$("#u459_inputC").click(function(){
					var fenmianC=$("#u459_inputC").val();
					//顺产
					if(fenmianC=='1'){
						document.getElementById("u466_inputC").disabled=true;
						document.getElementById("u466_inputC").readOnly=true;
						document.getElementById("u466_inputC").value="";
					}
					//刨宫产
					if(fenmianC=='0'){
						document.getElementById("u466_inputC").disabled=false;
						document.getElementById("u466_inputC").readOnly=false;
						
					}
					
				})
				//分娩方式
				$("#u459_inputD").click(function(){
					var fenmianD=$("#u459_inputD").val();
					//顺产
					if(fenmianD=='1'){
						document.getElementById("u466_inputD").disabled=true;
						document.getElementById("u466_inputD").readOnly=true;
						document.getElementById("u466_inputD").value="";
					}
					//刨宫产
					if(fenmianD=='0'){
						document.getElementById("u466_inputD").disabled=false;
						document.getElementById("u466_inputD").readOnly=false;
						
					}
					
				})
		 		//伤裂
		 		$("#u455_input").change(function(){
		 			var shang=$("#u455_input").val();
		 			if(shang=='0'){
		 				document.getElementById("u456_input").disabled=false;
						document.getElementById("u456_input").readOnly=false;
		 				/* var qie=$("#u456_input").val();
		 				if(qie==null||qie==""){
		 					alert("请输入伤裂程度");
		 					return false;
		 				} */
		 			}
		 			if(shang=='1'){
		 				document.getElementById("u456_input").disabled=true;
						document.getElementById("u456_input").readOnly=true;
						document.getElementById("u456_input").value="";
		 			}
		 		})
		 		var shang=$("#u455_input").val();
		 		if(shang=='1'){
	 				document.getElementById("u456_input").disabled=true;
					document.getElementById("u456_input").readOnly=true;
					document.getElementById("u456_input").value="";
	 			}
		 		//验证乙肝抗原
				$("#u310_input").change(function(){
			 		var yigann=document.getElementById("u310_input").value;
	     			//验证乙肝抗原
	     			if(yigann=='0'){
	     				$("#u313_input")[0].disabled = false;
	     			}
	     			if(yigann=='1'){
	     				//document.getElementById("u313_input").disabled=true;
	     				$("#u313_input")[0].disabled = true;
						//document.getElementById("u313_input").selectedIndex=-1;
	     			}
				})
				var yigann=document.getElementById("u310_input").value;
				if(yigann=='1'){
     				document.getElementById("u313_input").disabled=true;
					document.getElementById("u313_input").selectedIndex=-1;
     			}
				//验证是否感染梅毒
				
				$("#u316_input").change(function(){
					var meidum=document.getElementById("u316_input").value;
	     			//验证是否感染梅毒
	     			if(meidum=='0'){
	     				$("#u319_input")[0].disabled = false;
	     			}
	     			if(meidum=='1'){
	     				$("#u319_input")[0].disabled = true;
						document.getElementById("u319_input").selectedIndex=-1;
						
	     			}
				})
				var meidum=document.getElementById("u316_input").value;
				if(meidum=='1'){
	     				$("#u319_input")[0].disabled = true;
						document.getElementById("u319_input").selectedIndex=-1;
				}
				//验证是否感染艾滋病
				
				$("#u322_input").change(function(){
					//验证是否检测到艾滋病
					var aizib=document.getElementById("u322_input").value;
	     			//验证是否感染艾滋病
	     			if(aizib=='0'){
	     				document.getElementById("u325_input").disabled=false;
						document.getElementById("u325_input").readOnly=false;
	     			}
	     			if(aizib=='1'){
	     				document.getElementById("u325_input").disabled=true;
						document.getElementById("u325_input").readOnly=true;
						document.getElementById("u325_input").value="";
	     			}
				})
				var aizib=document.getElementById("u322_input").value;
				if(aizib=='1'){
					$("#u325_input")[0].disabled = true;
					document.getElementById("u325_input").selectedIndex=-1;
     			}
				//验证是否重度贫血
	     		
				$("#u328_input").change(function(){
					var zhongxue=document.getElementById("u328_input").value;
	     			//验证是否重度贫血
	     			if(zhongxue=='0'){
	     				document.getElementById("u331_input").disabled=false;
						document.getElementById("u331_input").readOnly=false;
	     			}
	     			if(zhongxue=='1'){
	     				document.getElementById("u331_input").disabled=true;
						document.getElementById("u331_input").readOnly=true;
						document.getElementById("u331_input").value="";
	     			}
				})
				var zhongxue=document.getElementById("u328_input").value;
				if(zhongxue=='1'){
					$("#u331_input")[0].disabled = true;
					document.getElementById("u331_input").selectedIndex=-1;
     			}
				//下拉框默认为空
		 		var a=$(".test");
				for(var i = 0;i< a.length;i++){
					a[i].selectedIndex = -1;
				}
				
		 	})
			
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
    		if(type==="moretopmiddle"){
    			defaulttop="200";
    			defaultleft
    			defaultWith = 870;
    			defaultHeight = 660;
    			dialog_excend_id_ = 'moretopmiddle';
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
	
	function AutoFold(divName,textId,num){
		var operateDiv=document.getElementsByName(divName);
		var textDoc=document.getElementById(textId);
		var operateDivNum = divName.substring(7,divName.length);//获取当前操作层的层号
		
		var showStatus=operateDiv[0].style.display;
		var changeHeight=0;
		if(showStatus=='none'){
		//归位在展示，如果不归位，由于上移的关系，展示出来后的位置会偏上
		var d=document.getElementsByName("foldDiv"+(parseInt(operateDivNum)-1));
		operateDiv[0].style.top = (d[0].offsetTop+d[0].offsetHeight)+'px';
		
		operateDiv[0].style.display='';
		textDoc.innerHTML="收起";
		changeHeight=operateDiv[0].offsetHeight;
		}else{
		changeHeight=0-operateDiv[0].offsetHeight;
		operateDiv[0].style.display='none';
		textDoc.innerHTML="展开";
		}
		
		for (var i=parseInt(operateDivNum)+1;i<=num;i++)
		{
		var changeTopDiv=document.getElementsByName("foldDiv"+i);
		changeTopDiv[0].style.top=(changeTopDiv[0].offsetTop+changeHeight)+'px';
		}
	}
</script>
</head>
<body style="background-color: #ffffff">
<!-- 	<div id="base" class=""> -->


		<div id="u54" class="ax_形状" style="background-color: #ee5f45">
				<p id="u55">
					<span>分娩登记</span>
				</p>
		</div>
		<br>
		<form id="queryform" method="post">
			<div id="u8" class="ax_文本段落">
				<p id="u9">
					<span>检查医院:${operator2.department }</span>
				</p>
			</div>
			<div id="u10" class="ax_文本段落">
				<p>
					<span>检查医生:${operator2.realName }</span>
				</p>
			</div>
			<div id="u12" class="ax_文本段落">
				<c:if test="${birthArchives.referralSign=='0' }">
					<p id="u13">
						<span>转诊状态:未转诊</span>
					</p>
				</c:if>
				<c:if test="${birthArchives.referralSign=='1' }">
					<p id="u13">
						<span>转诊状态:孕检转诊</span>
					</p>
				</c:if>
				<c:if test="${birthArchives.referralSign=='2' }">
					<p id="u13">
						<span>转诊状态:分娩转诊</span>
					</p>
				</c:if>
				<c:if test="${birthArchives.referralSign=='3' }">
					<p id="u13">
						<span>转诊状态:产后转诊</span>
					</p>
				</c:if>
			</div>
			<div id="title">
    
      <div id="u54" class="ax_形状" style="background-color:#ee5f45">
        <p id="u55"><span>分娩登记</span></p>
      </div>
       
      <div id="u66" class="ax_形状" style="background-color:#999999;cursor: pointer">
          <p id="u67"><span id="u67">结案</span></p>
      </div>
      <c:if test="${riskSign=='1' }">
	      <div id="u64" class="ax_形状" style="background-color:#ee5f45; display:'';cursor: pointer">
	          <p id="u65"><span id="u65" >专案记录</span></p>
	      </div>
      </c:if>
      <c:if test="${riskSign=='0' }">
	      <div id="u64" class="ax_形状" style="background-color:#ee5f45; display:none;cursor: pointer">
	          <p id="u65" style="display:none"><a id="u65" >专案记录</a></p>
	      </div>
      </c:if>
      	<div id="u60" class="ax_形状" style="background-color:#009Dd9;cursor: pointer">
         <span id="u61">保存</span>
        </div>
	<div id="u62" class="ax_形状" style="background-color:#56bb4d;cursor: pointer">
          <span id="u63">完成</span>
    </div>
</div>
			<div id="h1">
				<div id="u4" class="ax_形状" style="background-color: #009dd9">
					<p id="u5">
						<span>个人基本信息</span>
					</p>
				</div>
			</div>
			<div id="s3">
			
				<input type="hidden" id="acrid0" name="acrid0" value="${childbirthBabyInfoPO0.id }" />
				<input type="hidden" id="acrid1" name="acrid1" value="${childbirthBabyInfoPO1.id }" />
				<input type="hidden" id="acrid2" name="acrid2" value="${childbirthBabyInfoPO2.id }" />
				<input type="hidden" id="acrid3" name="acrid3" value="${childbirthBabyInfoPO3.id }" />
				<input type="hidden" id="acrid4" name="acrid4" value="${childbirthBabyInfoPO4.id }" />
				<input type="hidden" id="acrid5" name="acrid5" value="${childbirthBabyInfoPO5.id }" />
				<input type="hidden" id="acrid6" name="acrid6" value="${childbirthBabyInfoPO6.id }" />
				<input type="hidden" id="acrid" name="acrid" value="${ArchivesInfoPO.id }" />
				<input id="babyVaccine1" type="hidden" name="babyVaccine1" value=""/>
				<input id="babyVaccine2" type="hidden" name="babyVaccine2" value=""/>
				<input id="babyVaccine3" type="hidden" name="babyVaccine3" value=""/>
				<input id="babyVaccine4" type="hidden" name="babyVaccine4" value=""/>
				<input id="babyVaccine5" type="hidden" name="babyVaccine5" value=""/>
				<input id="babyVaccine6" type="hidden" name="babyVaccine6" value=""/>
				
				<input type="hidden" value="${size }" id="size"/>
				<input id="highRiskId" type="hidden" name="highRiskId" value=""/>
				<input type="hidden" id="editStatus" name="editStatus" value="0" />
			  		<div id="u76" class="ax_文本段落" style="color:#ee5f45">
			          <p id="u77"><span>姓名:${ArchivesInfoPO.name }</span></p>
			      	</div>
			  		<div id="u76" class="ax_文本段落" >
			          <p id="u77"><span>姓名:${ArchivesInfoPO.name }</span></p>
			      	</div>
		  	  	<div id="u78" class="ax_文本段落">
		  	  		
			          <p id="u79">
			          <span>档案编号:${ArchivesInfoPO.archivesCode }</span>
			          
			          </p>
			  </div>
				<div id="u90" class="ax_文本段落">
					<p id="u91">
						<span>建档日期:<fmt:formatDate
								value="${ArchivesInfoPO.creatTime }" pattern="yyyyMMdd" /></span>
					</p>
				</div>
				<c:if test="${childbirthBasic.normalSign=='1' }">
					<div id="u74" class="ax_文本段落">
						<p id="u75">
							<span>末次月经:<fmt:formatDate
									value="${birthArchives.lastMenses }" pattern="yyyyMMdd" /></span>
						</p>
					</div>
				</c:if>
				<c:if test="${childbirthBasic.normalSign=='0' }">
				      <div id="u74" class="ax_文本段落">
				         	<span id="u75">创建时间:
							   <input type="text"  name="BasicCreateTime" 
							   value="<fmt:formatDate value="${childbirthBasic.creatTime }" pattern="yyyyMMdd"/>"
						       style="color:#333333;cursor:pointer;position:absolute;left:60px;top:-3px;width:150px;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
						       tabindex="1" required/></span>
				      </div>
      			</c:if>
				<div id="u70" class="ax_文本段落">
					<p id="u71">
						<span>孕周:${weekByLastMenses}</span>
					</p>
				</div>
				<div id="u68" class="ax_文本段落">
					<p id="u69">
						<span>出生日期:<fmt:formatDate
								value="${ArchivesInfoPO.birthday }" pattern="yyyyMMdd" /></span>
					</p>
				</div>
				<div id="u80" class="ax_文本段落">
					<p id="u81">
						<span>孕妇年龄:${age }</span>
					</p>
				</div>
				<div id="u72" class="ax_文本段落">
					<p id="u73">
						<span>预产期:<fmt:formatDate value="${endOfDate }"
								pattern="yyyyMMdd" /></span>
					</p>
				</div>
				<div id="u82" class="ax_文本段落">
					<p id="u83">
						<span>联系电话:${ArchivesInfoPO.telephone }</span>
					</p>
				</div>
				<div id="u84" class="ax_文本段落">
					<p id="u85">
						<span>丈夫姓名:${ArchivesInfoPO.manName }</span>
					</p>
				</div>
				<div id="u86" class="ax_文本段落">
					<p id="u87">
						<span>丈夫年龄:${manAge}</span>
					</p>
				</div>
				<div id="u88" class="ax_文本段落">
					<p id="u89">
						<span>丈夫电话:${ArchivesInfoPO.manTele }</span>
					</p>
				</div>
			</div>
			<div id="h2" name="foldDiv1" onclick="AutoFold('foldDiv2','u16',8)">

				<div id="u14" class="ax_形状" style="background-color: #009dd9">
					<p id="u15">
						<span>基本情况</span>
					</p>
				</div>
				<div id="u16" class="ax_文本段落" style="background-color: #009dd9">
					<p id="u17">收起</p>
				</div>
			</div>
			<div id="s4" name="foldDiv2">
				<div id="u287" class="ax_文本段落">
					<p id="u288">
						<span>分娩日期:</span>
					</p>
				</div>
				<div id="u289" class="ax_下拉列表框">
					<input type="text" id="u289_input" name="birthDate"
						value="<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyyMMdd"/>"
						readonly style="color: #adadaf"
						onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"  />


				</div>
				<div id="u290" class="ax_文本段落">
					<p id="u291">
						<span>住院号:</span>
					</p>
				</div>
				<div id="u292" class="ax_文本框">
					<input id="u292_input" type="text" name="hospitalCode"
						value=" ${childbirthBasic.hospitalCode }" />
				</div>
				<div id="u340" class="ax_文本段落">
					<p id="u341">
						<span>出院日期:</span>
					</p>
				</div>
				<div id="u342" class="ax_下拉列表框">
					<input type="text" id="u342_input" name="leaveDate"
						value="<fmt:formatDate value="${childbirthBasic.leaveDate }" pattern="yyyyMMdd"/>"
						readonly style="color: #adadaf"
						onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" />
				</div>
				<%-- <div id="u276" class="ax_文本段落">
					<p id="u277">
						<span>末次月经:</span>
					</p>
				</div>
				<div id="u278" class="ax_下拉列表框">
					<input type="text" id="u278_input" name="lastMenses"
						value="<fmt:formatDate value="${birthArchives.lastMenses}" pattern="yyyyMMdd"/>"
						readonly style="color: #adadaf"
						onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" />
				</div> --%>
				<div id="u279" class="ax_文本段落">
					<p id="u280">
						<span>孕周:</span>
					</p>
				</div>
				<div id="u281" class="ax_文本框">
					<input id="u281_input" type="text" name="gestationalWeek"
						value="${childbirthBasic.gestationalWeek }" />
				</div>
				<div id="u282" class="ax_文本段落">
					<p id="u283">
						<span>周</span>
					</p>
				</div>
				<div id="u286" class="ax_文本框">
					<input id="u286_input" type="text" name="gestationalDay"
						value="${childbirthBasic.gestationalDay }" />
				</div>
				<div id="u284" class="ax_文本段落">
					<p id="u285">
						<span>天</span>
					</p>
				</div>
				<div id="u293" class="ax_文本段落">
					<p id="u294">
						<span>孕 次:</span>
					</p>
				</div>
				<div id="u295" class="ax_下拉列表框">
					<select id="u295_input" name="pregnancyNum" >
						
						<option value="0"
							<c:if test="${childbirthBasic.pregnancyNum=='0'}">
								selected
							</c:if> 
						>0</option>
						<option value="1"
							<c:if test="${childbirthBasic.pregnancyNum=='1'}">
								selected
							</c:if> 
						>1</option>
						<option value="2"
							<c:if test="${childbirthBasic.pregnancyNum=='2'}">
								selected
							</c:if> 
						>2</option>
						<option value="3"
							<c:if test="${childbirthBasic.pregnancyNum=='3'}">
								selected
							</c:if> 
						>3</option>
						<option value="4"
							<c:if test="${childbirthBasic.pregnancyNum=='4'}">
								selected
							</c:if> 
						>4</option>
						<c:if test="${childbirthBasic.pregnancyNum==null&&childbirthBasic.pregnancyNum!=''}">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</c:if>
					</select>
				</div>
				<div id="u301" class="ax_文本段落">
					<p id="u302">
						<span>次</span>
					</p>
				</div>
				<div id="u296" class="ax_文本段落">
					<p id="u297">
						<span>产 次:</span>
					</p>
				</div>
				<div id="u298" class="ax_下拉列表框">
					<select id="u298_input" name="bearNum" >
						<option value="0"
							<c:if test="${childbirthBasic.bearNum=='0'}">
								selected
							</c:if>
						>0</option>
						<option value="1"
							<c:if test="${childbirthBasic.bearNum=='1'}">
								selected
							</c:if>
						>1</option>
						<option value="2"
							<c:if test="${childbirthBasic.bearNum=='2'}">
								selected
							</c:if>
						>2</option>
						<option value="3"
							<c:if test="${childbirthBasic.bearNum=='3'}">
								selected
							</c:if>
						>3</option>
						<option value="4"
							<c:if test="${childbirthBasic.bearNum=='4'}">
								selected
							</c:if>
						>4</option>
						<c:if test="${childbirthBasic.bearNum==null}">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</c:if>
					</select>
				</div>
				<div id="u299" class="ax_文本段落">
					<p id="u300">
						<span>次</span>
					</p>
				</div>
				<div id="u303" class="ax_文本段落">
					<p id="u304">
						<span>孕产保健</span>
					</p>
				</div>
				<div id="u305" class="ax_下拉列表框">
					<select id="u305_input" name="healthcareNum" >
						<option value="0"
							<c:if test="${childbirthBasic.healthcareNum=='0'}">
								selected
							</c:if>
						>0</option>
						<option value="1"
							<c:if test="${childbirthBasic.healthcareNum=='1'}">
								selected
							</c:if>
						>1</option>
						<option value="2"
							<c:if test="${childbirthBasic.healthcareNum=='2'}">
								selected
							</c:if>
						>2</option>
						<option value="3"
							<c:if test="${childbirthBasic.healthcareNum=='4'}">
								selected
							</c:if>
						>3</option>
						<option value="4"
							<c:if test="${childbirthBasic.healthcareNum=='5'}">
								selected
							</c:if>
						>4</option>
						<c:if test="${childbirthBasic.healthcareNum==null}">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</c:if>
					</select>
				</div>
				<div id="u306" class="ax_文本段落">
					<p id="u307">
						<span>次</span>
					</p>
				</div>

				<div id="u308" class="ax_文本段落">
					<p id="u309">
						<span>是否检测乙肝:</span>
					</p>
				</div>
				<div id="u310" class="ax_下拉列表框">
					<select id="u310_input" name="checkHepatitis" >
						<c:if test="${childbirthBasic.checkHepatitis=='0' }">
							<option value="0" selected>是</option>
							<option value="1">否</option>
						</c:if>
						<c:if test="${childbirthBasic.checkHepatitis=='1' }">
							<option value="1" selected>否</option>
							<option value="0">是</option>
						</c:if>
						
						<c:if test="${childbirthBasic.checkHepatitis!='0'&&childbirthBasic.checkHepatitis!='1' }">
							<option value="0">是</option>
							<option value="1">否</option>
						</c:if>
					</select>
				</div>
				<div id="u311" class="ax_文本段落">
					<p id="u312">
						<span>乙肝表面抗原:</span>
					</p>
				</div>
				<div id="u313" class="ax_下拉列表框">
					<select id="u313_input" name="antigenHepatitis" >
						<c:if test="${childbirthBasic.antigenHepatitis=='0' }">
							<option value="0" selected>阴性</option>
							<option value="1">阳性</option>
						</c:if>
						<c:if test="${childbirthBasic.antigenHepatitis=='1' }">
							<option value="1" selected>阳性</option>
							<option value="0">阴性</option>
						</c:if>
						<c:if test="${childbirthBasic.antigenHepatitis==null||childbirthBasic.antigenHepatitis==''}">
									<option value="1">阳性</option>
									<option value="0">阴性</option>
						</c:if>
					</select>
				</div>
				<div id="u314" class="ax_文本段落">
					<p id="u315">
						<span>是否检测梅毒:</span>
					</p>
				</div>
				<div id="u316" class="ax_下拉列表框">
					<select id="u316_input" name="checkSyphilis" >
						<c:if test="${childbirthBasic.checkSyphilis=='0' }">
							<option value="0" selected>是</option>
							<option value="1">否</option>
						</c:if>
						<c:if test="${childbirthBasic.checkSyphilis=='1' }">
							<option value="1" selected>否</option>
							<option value="0">是</option>
						</c:if>
						
						<c:if test="${childbirthBasic.checkSyphilis!='0'&&childbirthBasic.checkSyphilis!='1' }">
							<option value="1">否</option>
							<option value="0">是</option>
						</c:if>
					</select>
				</div>
				<div id="u317" class="ax_文本段落">
					<p id="u318">
						<span>是否感染梅毒:</span>
					</p>
				</div>
				<div id="u319" class="ax_下拉列表框">
					<select id="u319_input" name="infectedSyphilis" >
						<c:if test="${childbirthBasic.infectedSyphilis=='0' }">
							<option value="0" selected>是</option>
							<option value="1">否</option>
						</c:if>
						<c:if test="${childbirthBasic.infectedSyphilis=='1' }">
							<option value="1" selected>否</option>
							<option value="0">是</option>
						</c:if>
						<c:if test="${childbirthBasic.infectedSyphilis==null||childbirthBasic.infectedSyphilis==''}">
								<option value="1">否</option>
								<option value="0">是</option>
						</c:if>
					</select>
				</div>
				<div id="u320" class="ax_文本段落">
					<p id="u321">
						<span>是否检测艾滋病:</span>
					</p>
				</div>
				<div id="u322" class="ax_下拉列表框">
					<select id="u322_input" name="checkAids" >
						<c:if test="${childbirthBasic.checkAids=='0' }">
							<option value="0" selected>是</option>
							<option value="1">否</option>
						</c:if>
						<c:if test="${childbirthBasic.checkAids=='1' }">
							<option value="0">是</option>
							<option value="1" selected>否</option>
						</c:if>
						
						<c:if test="${childbirthBasic.checkAids!='0'&&childbirthBasic.checkAids!='1' }">
							<option value="1">否</option>
							<option value="0">是</option>
						</c:if>
						
					</select>
				</div>
				<div id="u323" class="ax_文本段落">
					<p id="u324">
						<span>是否感染艾滋病:</span>
					</p>
				</div>
				<div id="u325" class="ax_下拉列表框">
					<select id="u325_input" name="infectedAids" >
						<c:if test="${childbirthBasic.infectedAids=='0' }">
							<option value="0" selected>是</option>
							<option value="1">否</option>
						</c:if>
						<c:if test="${childbirthBasic.infectedAids=='1' }">
							<option value="1" selected>否</option>
							<option value="0">是</option>
						</c:if>
						<c:if test="${childbirthBasic.infectedAids==null||childbirthBasic.infectedAids=='' }">
								<option value="1">否</option>
								<option value="0">是</option>
						</c:if>
					</select>
				</div>
				<div id="u326" class="ax_文本段落">
					<p id="u327">
						<span>血红蛋白检测:</span>
					</p>
				</div>
				<div id="u328" class="ax_下拉列表框">
					<select id="u328_input" name="checkHemoglobin" >
						<c:if test="${childbirthBasic.checkHemoglobin=='0' }">
							<option value="0" selected>是</option>
							<option value="1">否</option>
						</c:if>
						<c:if test="${childbirthBasic.checkHemoglobin=='1' }">
							<option value="1" selected>否</option>
							<option value="0">是</option>
						</c:if>
						
						<c:if test="${childbirthBasic.checkHemoglobin!='0'&&childbirthBasic.checkHemoglobin!='1' }">
							<option value="1">否</option>
							<option value="0">是</option>
						</c:if>
					</select>
				</div>
				<div id="u329" class="ax_文本段落">
					<div>
						<p id="u330">
							<span>是否重度贫血:</span>
						</p>
					</div>
				</div>
				<div id="u331" class="ax_下拉列表框">
					<select id="u331_input" name="anemia" >
						<c:if test="${childbirthBasic.anemia=='0' }">
							<option value="0" selected>是</option>
							<option value="1">否</option>
						</c:if>
						<c:if test="${childbirthBasic.anemia=='1' }">
							<option value="1" selected>否</option>
							<option value="0">是</option>
						</c:if>
					
						<c:if test="${childbirthBasic.anemia==null||childbirthBasic.anemia=='' }">
								<option value="1">否</option>
								<option value="0">是</option>
						</c:if>
					</select>
				</div>
				<div id="u332" class="ax_文本段落">
					<p id="u333">
						<span>家族史:</span>
					</p>
				</div>
				<div id="u334" class="ax_文本段落">
					<p id="u335">
						<span>家族遗传疾病</span>
					</p>
				</div>
				<div id="u336" class="ax_文本框">
					<input id="u336_input" type="text"
						value="${childbirthBasic.geneticIll }" name="geneticIll" />
				</div>
				<div id="u337" class="ax_文本段落">
					<p id="u338">
						<span>近亲结婚:</span>
					</p>
				</div>
				<div id="u339" class="ax_下拉列表框">
					<select id="u339_input" name="relativesMating" >
						<c:if test="${childbirthBasic.relativesMating=='0' }">
							<option value="0" selected>是</option>
							<option value="1">否</option>
						</c:if>
						<c:if test="${childbirthBasic.relativesMating=='1' }">
							<option value="1" selected>否</option>
							<option value="0">是</option>
						</c:if>
						
						<c:if test="${childbirthBasic.relativesMating!='1'&&childbirthBasic.relativesMating!='0' }">
							<option value="1">否</option>
							<option value="0">是</option>
						</c:if>
					</select>
				</div>
			</div>
			<div id="h3" name="foldDiv3" onclick="AutoFold('foldDiv4','u20',8)">
				<div id="u18" class="ax_形状" style="background-color: #009dd9">
					<p id="u19">
						<span>分娩信息</span>
					</p>
				</div>
				<div id="u20" class="ax_文本段落">
					<!-- <p id="u21"><span>收起</span></p> -->
					<p id="u21">收起</p>
				</div>
			</div>
			<div id="h4" name="foldDiv4">
				<div id="s5">
					<div id="u343" class="ax_文本段落">
						<p id="u344">
							<span>分娩地点</span>
						</p>
					</div>
					<div id="u429" class="ax_下拉列表框">
						<select id="u429_input" name="childbirthPlace" >
							<c:if test="${childbirth.childbirthPlace!=null&&childbirth.childbirthPlace!='' }">
								<c:forEach var="place" items="${departlist }">
									<option value="${place.name }" 
										<c:if test="${childbirth.childbirthPlace==place.name}">
											selected
										</c:if>
									>${place.name }</option>
								</c:forEach>
							</c:if>
							<c:if test="${childbirth.childbirthPlace==null||childbirth.childbirthPlace=='' }">
								<c:forEach var="place" items="${departlist }">
									<option value="${place.name }">${place.name }</option>
								</c:forEach>
							</c:if>
						
						</select> 
						<input id="u909_input" name="childbirthPlace" type="text"
							value="" />

					</div>
					<div id="u345" class="ax_文本段落">
						<p id="u346">
							<span>产程时间:</span>
						</p>
					</div>
					<div id="u365" class="ax_文本段落">
						<p id="u366">
							<span>第一产程:</span>
						</p>
					</div>
					<div id="u430" class="ax_文本框">
						<input id="u430_input" type="text" name="firstHour"
							value="${childbirth.firstHour }" />
					</div>
					<div id="u431" class="ax_文本段落">
						<p id="u432">
							<span>小时</span>
						</p>
					</div>
					<div id="u435" class="ax_文本框">
						<input id="u435_input" type="text" name="firstMinute"
							value="${childbirth.firstMinute }" />
					</div>
					<div id="u433" class="ax_文本段落">
						<p id="u434">
							<span>分钟</span>
						</p>
					</div>
					<div id="u367" class="ax_文本段落">
						<p id="u368">
							<span>第二产程</span>
						</p>
					</div>
					<div id="u436" class="ax_文本框">
						<input id="u436_input" type="text" name="secondHour"
							value="${childbirth.secondHour }" />
					</div>
					<div id="u437" class="ax_文本段落">
						<p id="u438">
							<span>小时</span>
						</p>
					</div>

					<div id="u441" class="ax_文本框">
						<input id="u441_input" type="text" name="secondMinute"
							value="${childbirth.secondMinute }" />
					</div>
					<div id="u439" class="ax_文本段落">
						<p id="u440">
							<span>分钟</span>
						</p>
					</div>
					<div id="u369" class="ax_文本段落">
						<p id="u370">
							<span>第三产程:</span>
						</p>
					</div>
					<div id="u442" class="ax_文本框">
						<input id="u442_input" type="text" name="thirdHour"
							value="${childbirth.thirdHour}" />
					</div>
					<div id="u443" class="ax_文本段落">
						<p id="u444">
							<span>小时</span>
						</p>
					</div>
					<div id="u447" class="ax_文本框">
						<input id="u447_input" type="text" name="thirdMinute"
							value="${childbirth.thirdMinute }" />
					</div>
					<div id="u445" class="ax_文本段落">
						<p id="u446">
							<span>分钟</span>
						</p>
					</div>
					<div id="u371" class="ax_文本段落">
						<p id="u372">
							<span>总产程:</span>
						</p>
					</div>
					<div id="u448" class="ax_文本框">
						<input id="u448_input" type="text" name="totalHour"
							value="${childbirth.totalHour}" />
					</div>
					<div id="u449" class="ax_文本段落">
						<p id="u450">
							<span>小时</span>
						</p>
					</div>
					<div id="u451" class="ax_文本段落">
						<p id="u452">
							<span>分钟</span>
						</p>
					</div>
					<div id="u453" class="ax_文本框">
						<input id="u453_input" type="text" name="totalMinute"
							value="${childbirth.totalMinute }" />
					</div>

					<div id="u347" class="ax_文本段落">
						<p id="u348">
							<span>胎盘:</span>
						</p>
					</div>
					<div id="u454" class="ax_下拉列表框">
						<input type="text" id="u454_input" name="placenta"
							value="${childbirth.placenta }" />
					</div>
					<div id="u373" class="ax_文本段落">
						<p id="u374">
							<span>会阴侧切:</span>
						</p>
					</div>
					<div id="u455" class="ax_下拉列表框">
						<select id="u455_input" name="perineumCut" >
							<c:if test="${childbirth.perineumCut=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirth.perineumCut=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirth.perineumCut!='1'&&childbirth.perineumCut!='0' }">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u375" class="ax_文本段落">
						<p id="u376">
							<span>伤裂程度:</span>
						</p>
					</div>

					<div id="u456" class="ax_下拉列表框">
						<input id="u456_input" type="text" name="injuryDegree"
							value="${childbirth.injuryDegree }" />
					</div>
					<div id="u379" class="ax_文本段落">
						<p id="u380">
							<span>出血量及羊水:</span>
						</p>
					</div>
					<div id="u381" class="ax_文本段落">
						<p id="u382">
							<span>产时出血量:</span>
						</p>
					</div>


					<div id="u467" class="ax_文本框">
						<input id="u467_input" type="text" name="bearBleeding"
							value="${childbirth.bearBleeding }" />
					</div>
					<div id="u468" class="ax_文本段落">
						<p id="u469">
							<span>ml</span>
						</p>
					</div>
					<div id="u383" class="ax_文本段落">
						<p id="u384">
							<span>产后2小时:</span>
						</p>
					</div>

					<div id="u470" class="ax_文本框">
						<input id="u470_input" type="text" name="afterbearTwo"
							value="${childbirth.afterbearTwo }" />
					</div>
					<div id="u472" class="ax_文本段落">
						<p id="u473">
							<span>ml</span>
						</p>
					</div>
					<div id="u385" class="ax_文本段落">
						<p id="u386">
							<span>总出血量:</span>
						</p>
					</div>
					<div id="u471" class="ax_文本框">
						<input id="u471_input" type="text" name="totalBleeding"
							value="${childbirth.totalBleeding }" />
					</div>
					<div id="u474" class="ax_文本段落">
						<p id="u475">
							<span>ml</span>
						</p>
					</div>
					<div id="u476" class="ax_文本段落">
						<p id="u477">
							<span>羊水性状:</span>
						</p>
					</div>
					<div id="u481" class="ax_下拉列表框">
						<select id="u481_input" name="amnioticFluidTrait" >
							<c:if test="${childbirth.amnioticFluidTrait=='0' }">
								<option value="0" selected>正常</option>
								<option value="1">异常</option>
							</c:if>
							<c:if test="${childbirth.amnioticFluidTrait=='1' }">
								<option value="0">正常</option>
								<option value="1" selected>异常</option>
							</c:if>
							<c:if test="${childbirth.amnioticFluidTrait!='1'&&childbirth.amnioticFluidTrait!='0' }">
								<option value="0">正常</option>
								<option value="1">异常</option>
							</c:if>
						</select>
					</div>
				<c:if test="${childbirth.amnioticFluidTrait=='1' }">
					<div id="input_text" style="width:80px;left:210px;top:188px;height:25px;position:absolute;">
				      	<input type="text" style="width:120px;left:0px;top:0px;height:23px;" name="amnioticFluidRemark" id="amniotic" value="${childbirth.amnioticFluidRemark}" />
				    </div>
				</c:if>
					<div id="u387" class="ax_文本段落">
						<p id="u388">
							<span>羊水量:</span>
						</p>
					</div>
					<div id="u478" class="ax_文本框">
						<input id="u478_input" type="text" name="amnioticFluidAmount"
							value="${childbirth.amnioticFluidAmount }" />
					</div>
					<div id="u479" class="ax_文本段落">
						<p id="u480">
							<span>ml</span>
						</p>
					</div>
					<div id="u359" class="ax_文本段落">
						<p id="u360">
							<span>胎数</span><span>:</span>
						</p>
					</div>
					<div id="u483" class="ax_下拉列表框">
						<select id="u483_input" name="fetalNum" >
							<option value="1"
								<c:if test="${childbirth.fetalNum=='1'}">
									selected
								</c:if>
							>1</option>
							<option value="2"
								<c:if test="${childbirth.fetalNum=='2'}">
									selected
								</c:if>
							>2</option>
							<option value="3"
								<c:if test="${childbirth.fetalNum=='3'}">
									selected
								</c:if>
							>3</option>
							<option value="4"
								<c:if test="${childbirth.fetalNum=='4'}">
									selected
								</c:if>
							>4</option>
							<option value="5"
								<c:if test="${childbirth.fetalNum=='5'}">
									selected
								</c:if>
							>5</option>
							<option value="6"
								<c:if test="${childbirth.fetalNum=='6'}">
									selected
								</c:if>
							>6</option>
							<option value="7"
								<c:if test="${childbirth.fetalNum=='7'}">
									selected
								</c:if>
							>7</option>
							
						</select>
					</div>
					<div id="u504" class="ax_文本段落">
						<img id="u504_img" class="img "
							src="${ctx}/static/images/u639.png" style="cursor: pointer" /> <a
							id="u505" style="cursor: pointer; color: #ff4848">新增婴儿信息</a> <img
							id="u505_img" class="img " src="${ctx}/static/images/u641.png"
							style="cursor: pointer" /> <a id="utt"
							style="color: #ff4848; cursor: pointer"></a>
					</div>
				</div>
				<div id="s6">
				<div style="position:absolute; border: 1px solid #cccccc; top:0px;height: 335px;width: 1120px;left: 10px;">
				<br>
					<div id="u506" class="ax_形状">
						<p id="u507">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u502" class="ax_形状">
						<p id="u503">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u349" class="ax_文本段落">
						<p id="u350">
							<span>分娩情况:</span>
						</p>
					</div>
					<div id="u351" class="ax_文本段落">
						<p id="u352">
							<span>胎位:</span>
						</p>
					</div>
					<div id="u457" class="ax_下拉列表框">
						<select id="u457_input" name="fetusPosition" >
							<c:if test="${childbirthBabyInfoPO0.fetusPosition=='0'}">
								<option value="0" selected>左腹</option>
								<option value="1">右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.fetusPosition=='1'}">
								<option value="0">左腹</option>
								<option value="1" selected>右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.fetusPosition!='1'&&childbirthBabyInfoPO0.fetusPosition!='0'}">
								<option value="0">左腹</option>
								<option value="1">右腹</option>
							</c:if>
						</select>
					</div>

					<div id="u353" class="ax_文本段落">
						<p id="u354">
							<span>分娩时间:</span>
						</p>
					</div>
					<div id="u460" class="ax_文本框">
						<input id="u460_input" type="text"
							value="${childbirthBabyInfoPO0.deliveryHour}" name="deliveryHour" />
					</div>
					<div id="u461" class="ax_文本段落">
						<p id="u462">
							<span>时</span>
						</p>
					</div>
					<div id="u465" class="ax_文本框">
						<input id="u465_input" type="text"
							value="${childbirthBabyInfoPO0.deliveryMinute }"
							name="deliveryMinute" />
					</div>
					<div id="u463" class="ax_文本段落">
						<p id="u464">
							<span>分</span>
						</p>
					</div>
					<div id="u377" class="ax_文本段落">
						<p id="u378">
							<span>引产:</span>
						</p>
					</div>
					<div id="u458" class="ax_下拉列表框">
						<select id="u458_input" name="inducelabour" >
							<c:if test="${childbirthBabyInfoPO0.inducelabour=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.inducelabour=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO0.inducelabour!='1'&&childbirthBabyInfoPO0.inducelabour!='0' }">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u355" class="ax_文本段落">
						<p id="u356">
							<span>分娩方式:</span>
						</p>
					</div>
					<div id="u459" class="ax_下拉列表框">
						<select id="u459_input" name="deliveryType" >
							<c:if test="${childbirthBabyInfoPO0.deliveryType=='0'}">
								<option value="0" selected>剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.deliveryType=='1'}">
								<option value="0">剖宫产</option>
								<option value="1" selected>顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.deliveryType!='1'&&childbirthBabyInfoPO0.deliveryType!='0'}">
								<option value="0">剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
						</select>
					</div>
					<div id="u363" class="ax_文本段落">
						<p id="u364">
							<span>剖宫产指征:</span>
						</p>
					</div>
					<div id="u466" class="ax_文本框">
						<input id="u466_input" type="text"
							value="${childbirthBabyInfoPO0.cesareanIdicatio }"
							name="cesareanIdicatio" />
					</div>
					<div id="u389" class="ax_文本段落">

						<p id="u390">
							<span>婴儿基本情况:</span>
						</p>
					</div>
					<div id="u391" class="ax_文本段落">
						<p id="u392">
							<span>婴儿姓名:</span>
						</p>
					</div>
					<div id="u485" class="ax_文本框">
						<input id="u485_input" type="text"
							value="${childbirthBabyInfoPO0.babyName }" name="babyName" />
					</div>

					<div id="u357" class="ax_文本段落">
						<p id="u358">
							<span>婴儿性别:</span>
						</p>
					</div>
					<div id="u482" class="ax_下拉列表框">
						<select id="u482_input" name="babySex" >
							<c:if test="${childbirthBabyInfoPO0.babySex=='0'}">
								<option value="2">性别不明</option>
								<option value="0" selected>男</option>
								<option value="1">女</option>
								
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.babySex=='1'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1" selected>女</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO0.babySex!='1'&&childbirthBabyInfoPO0.babySex!='0'&&childbirthBabyInfoPO0.babySex!='2'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.babySex=='2'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
						</select>
					</div>
					<div id="u361" class="ax_文本段落">
						<p id="u362">
							<span>健康状况:</span>
						</p>
					</div>
					<div id="u484" class="ax_下拉列表框">
						<select id="u484_input" name="health" >
							<c:if test="${childbirthBabyInfoPO0.health=='0' }">
								
								<option value="0" selected>强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.health=='2' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2" selected>虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.health=='1' }">
								<option value="0">强壮</option>
								<option value="1" selected>健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.health!='0'&&childbirthBabyInfoPO0.health!='1'&&childbirthBabyInfoPO0.health!='2' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
						</select>
					</div>
					<div id="u393" class="ax_文本段落">
						<p id="u394">
							<span>胎儿畸形:</span>
						</p>
					</div>
					<div id="u486" class="ax_下拉列表框">
						<select id="u486_input" name="fetalAnomaly" >

							<c:if test="${childbirthBabyInfoPO0.fetalAnomaly=='0'}">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.fetalAnomaly=='1'}">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.fetalAnomaly!='0'&&childbirthBabyInfoPO0.fetalAnomaly!='1'}">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u395" class="ax_文本段落">
						<p id="u396">
							<span>畸形各类部位:</span>
						</p>
					</div>
					<div id="u487" class="ax_文本框">
						<input id="u487_input" type="text"
							value="${childbirthBabyInfoPO0.abnormalPosition }"
							name="abnormalPosition" />
					</div>
					<div id="u397" class="ax_文本段落">
						<p id="u398">
							<span>畸形名称:</span>
						</p>
					</div>
					<div id="u488" class="ax_文本框">
						<input id="u488_input" type="text"
							value="${childbirthBabyInfoPO0.abnormalName }"
							name="abnormalName" />
					</div>
					<div id="u399" class="ax_文本段落">
						<p id="u400">
							<span>评分:</span>
						</p>
					</div>
					<div id="u401" class="ax_文本段落">
						<p id="u402">
							<span>1分钟评分:</span>
						</p>
					</div>
					<div id="u489" class="ax_文本框">
						<input id="u489_input" type="text"
							value="${childbirthBabyInfoPO0.oneMinScore }" name="oneMinScore" />
					</div>
					<div id="u403" class="ax_文本段落">
						<p id="u404">
							<span>5分钟评分:</span>
						</p>
					</div>
					<div id="u490" class="ax_文本框">
						<input id="u490_input" type="text"
							value="${childbirthBabyInfoPO0.fiveMinScore }"
							name="fiveMinScore" />
					</div>
					<div id="u405" class="ax_文本段落">
						<p id="u406">
							<span>出生体重:</span>
						</p>
					</div>
					<div id="u491" class="ax_文本框">
						<input id="u491_input" type="text"
							value="${childbirthBabyInfoPO0.bornWeight }" name="bornWeight" />
					</div>
					<div id="u493" class="ax_文本段落">
						<p id="u494">
							<span>g</span>
						</p>
					</div>
					<div id="u407" class="ax_文本段落">
						<p id="u408">
							<span>身长:</span>
						</p>
					</div>
					<div id="u492" class="ax_文本框">
						<input id="u492_input" type="text"
							value="${childbirthBabyInfoPO0.bodyLenght }" name="bodyLenght" />
					</div>
					<div id="u495" class="ax_文本段落">
						<p id="u496">
							<span>cm</span>
						</p>
					</div>

					<div id="u409" class="ax_文本段落">
						<p id="u410">
							<span>已打疫苗:</span>
						</p>
					</div>
						<div id="u411" class="ax_复选框">

							<p id="u412">
								<span>卡介苗</span>
							</p>
									<input id="u411_input" type="checkbox" value="0" name="vaccine"
										<c:forEach var="li" items="${list0 }">
											<c:if test="${li=='0' }">
												checked = "checked"
											</c:if>
										</c:forEach> />
						</div>
						<div id="u413" class="ax_复选框">
							<p id="u414">
								<span>乙肝疫苗</span>
							</p>
									<input id="u413_input" type="checkbox" value="1" name="vaccine" 
										<c:forEach var="li" items="${list0 }">
											<c:if test="${li=='1' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									/>
								
						</div>
						<div id="u415" class="ax_复选框">
							<p id="u416">
								<span>早吸吮</span>
							</p>
									<input id="u415_input" type="checkbox" value="2" name="vaccine" 
										<c:forEach var="li" items="${list0 }">
											<c:if test="${li=='2' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									
									/>
						</div>
					<div id="u417" class="ax_文本段落">
						<p id="u418">
							<span>胎儿死亡:</span>
						</p>
					</div>
					<div id="u498" class="ax_下拉列表框">
						<select id="u498_input" name="fetusDie" >
							<c:if test="${childbirthBabyInfoPO0.fetusDie=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.fetusDie=='1' }">
								<option value="0" >是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO0.fetusDie!='1'&&childbirthBabyInfoPO0.fetusDie!='0' }">
								<option value="0" >是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u419" class="ax_文本段落">
						<p id="u420">
							<span>接生者:</span>
						</p>
					</div>

					<div id="u497" class="ax_文本框">
						<input id="u497_input" type="text"
							value="${childbirthBabyInfoPO0.midwife }" name="midwife" />
					</div>
				</div>
				</div>
				<div id="hs1" style="display: none">
					<div style="position:absolute; border: 1px solid #cccccc; top:10px;height: 340px;width: 1120px;left: 10px;">
					<br>	
					<div id="u506A" class="ax_形状">
						<p id="u507A">
							<span>&nbsp;</span>
						</p>
					</div>

					<div id="u502A" class="ax_形状">
						<p id="u503A">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u349A" class="ax_文本段落">
						<p id="u350A">
							<span>分娩情况:</span>
						</p>
					</div>
					<div id="u351A" class="ax_文本段落">
						<p id="u352A">
							<span>胎位:</span>
						</p>
					</div>
					<div id="u457A" class="ax_下拉列表框">
						<select id="u457_inputA" name="fetusPosition1" >
							<c:if test="${childbirthBabyInfoPO1.fetusPosition=='0'}">
								<option value="0" selected>左腹</option>
								<option value="1">右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.fetusPosition=='1'}">
								<option value="0">左腹</option>
								<option value="1" selected>右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.fetusPosition!='1'&&childbirthBabyInfoPO1.fetusPosition!='0'}">
								<option value="0">左腹</option>
								<option value="1">右腹</option>
							</c:if>
						</select>
					</div>
					<div id="u353A" class="ax_文本段落">
						<p id="u354A">
							<span>分娩时间:</span>
						</p>
					</div>

					<div id="u460A" class="ax_文本框">
						<input id="u460_inputA" type="text"
							value="${childbirthBabyInfoPO1.deliveryHour}" name="deliveryHour1" />
					</div>
					<div id="u461A" class="ax_文本段落">
						<p id="u462A">
							<span>时</span>
						</p>
					</div>
					<div id="u465A" class="ax_文本框">
						<input id="u465_inputA" type="text"
							value="${childbirthBabyInfoPO1.deliveryMinute }"
							name="deliveryMinute1" />
					</div>

					<div id="u463A" class="ax_文本段落">
						<p id="u464A">
							<span>分</span>
						</p>
					</div>
					<div id="u377A" class="ax_文本段落">
						<p id="u378A">
							<span>引产:</span>
						</p>
					</div>
					<div id="u458A" class="ax_下拉列表框">
						<select id="u458_inputA" name="inducelabour1" >
							<c:if test="${childbirthBabyInfoPO1.inducelabour=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.inducelabour=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO1.inducelabour!='1'&&childbirthBabyInfoPO1.inducelabour!='0' }">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u355A" class="ax_文本段落">
						<p id="u356A">
							<span>分娩方式:</span>
						</p>
					</div>
					<div id="u459A" class="ax_下拉列表框">
						<select id="u459_inputA" name="deliveryType1" >

							<c:if test="${childbirthBabyInfoPO1.deliveryType=='0'}">
								<option value="0" selected>剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.deliveryType=='1'}">
								<option value="0">剖宫产</option>
								<option value="1" selected>顺产</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO1.deliveryType!='1'&&childbirthBabyInfoPO1.deliveryType!='0'}">
								<option value="0">剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
						</select>
					</div>
					<div id="u363A" class="ax_文本段落">
						<p id="u364A">
							<span>剖宫产指征:</span>
						</p>
					</div>
					<div id="u466A" class="ax_文本框">
						<input id="u466_inputA" type="text"
							value="${childbirthBabyInfoPO1.cesareanIdicatio }"
							name="cesareanIdicatio1" />
					</div>
					<div id="u389A" class="ax_文本段落">
						<p id="u390A">
							<span>婴儿基本情况:</span>
						</p>
					</div>
					<div id="u391A" class="ax_文本段落">
						<p id="u392A">
							<span>婴儿姓名:</span>
						</p>
					</div>
					<div id="u485A" class="ax_文本框">
						<input id="u485_inputA" type="text"
							value="${childbirthBabyInfoPO1.babyName }" name="babyName1" />
					</div>
					<div id="u357A" class="ax_文本段落">
						<p id="u358A">
							<span>婴儿性别:</span>
						</p>
					</div>
					<div id="u482A" class="ax_下拉列表框">
						<select id="u482_inputA" name="babySex1" >
							<c:if test="${childbirthBabyInfoPO1.babySex=='0'}">
								<option value="2">性别不明</option>
								<option value="0" selected>男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.babySex=='1'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1" selected>女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.babySex=='2'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.babySex!='1'&&childbirthBabyInfoPO1.babySex!='0'&&childbirthBabyInfoPO1.babySex!='2'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
						</select>
					</div>
					<div id="u361A" class="ax_文本段落">
						<p id="u362A">
							<span>健康状况:</span>
						</p>
					</div>
					<div id="u484A" class="ax_下拉列表框">
						<select id="u484_inputA" name="health1" >
							<c:if test="${childbirthBabyInfoPO1.health=='0' }">
								<option value="0" selected>强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.health=='2' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2" selected>虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.health=='1' }">
								<option value="0">强壮</option>
								<option value="1" selected>健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.health!='1'&&childbirthBabyInfoPO1.health!='2'&&childbirthBabyInfoPO1.health!='0' }">
								<option value="0">强壮</option>
								<option value="1" selected>健康</option>
								<option value="2">虚弱</option>
							</c:if>
						</select>
					</div>
					<div id="u393A" class="ax_文本段落">
						<p id="u394A">
							<span>胎儿畸形:</span>
						</p>
					</div>
					<div id="u486A" class="ax_下拉列表框">
						<select id="u486_inputA" name="fetalAnomaly1" >
							<c:if test="${childbirthBabyInfoPO1.fetalAnomaly=='0'}">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.fetalAnomaly=='1'}">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO1.fetalAnomaly!='1'&&childbirthBabyInfoPO1.fetalAnomaly!='0'}">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u395A" class="ax_文本段落">
						<p id="u396A">
							<span>畸形各类部位:</span>
						</p>
					</div>
					<div id="u487A" class="ax_文本框">
						<input id="u487_inputA" type="text"
							value="${childbirthBabyInfoPO1.abnormalPosition}"
							name="abnormalPosition1" />
					</div>
					<div id="u397A" class="ax_文本段落">
						<p id="u398A">
							<span>畸形名称:</span>
						</p>
					</div>
					<div id="u488A" class="ax_文本框">
						<input id="u488_inputA" type="text"
							value="${childbirthBabyInfoPO1.abnormalName }"
							name="abnormalName1" />
					</div>
					<div id="u399A" class="ax_文本段落">
						<p id="u400A">
							<span>评分:</span>
						</p>
					</div>
					<div id="u401A" class="ax_文本段落">
						<p id="u402A">
							<span>1分钟评分:</span>
						</p>
					</div>
					<div id="u489A" class="ax_文本框">
						<input id="u489_inputA" type="text"
							value="${childbirthBabyInfoPO1.oneMinScore }" name="oneMinScore1" />
					</div>

					<div id="u403A" class="ax_文本段落">
						<p id="u404A">
							<span>5分钟评分:</span>
						</p>
					</div>
					<div id="u490A" class="ax_文本框">
						<input id="u490_inputA" type="text"
							value="${childbirthBabyInfoPO1.fiveMinScore }"
							name="fiveMinScore1" />
					</div>
					<div id="u405A" class="ax_文本段落">
						<p id="u406A">
							<span>出生体重:</span>
						</p>
					</div>
					<div id="u491A" class="ax_文本框">
						<input id="u491_inputA" type="text"
							value="${childbirthBabyInfoPO1.bornWeight }" name="bornWeight1" />
					</div>
					<div id="u493A" class="ax_文本段落">
						<p id="u494A">
							<span>g</span>
						</p>
					</div>
					<div id="u407A" class="ax_文本段落">
						<p id="u408A">
							<span>身长:</span>
						</p>
					</div>
					<div id="u492A" class="ax_文本框">
						<input id="u492_inputA" type="text"
							value="${childbirthBabyInfoPO1.bodyLenght }" name="bodyLenght1" />
					</div>
					<div id="u495A" class="ax_文本段落">
						<p id="u496A">
							<span>cm</span>
						</p>
					</div>

					<div id="u409A" class="ax_文本段落">
						<p id="u410A">
							<span>已打疫苗:</span>
						</p>
					</div>
					
						<div id="u411A" class="ax_复选框">

							<p id="u412A">
								<span>卡介苗</span>
							</p>
							
									<input id="u411_input1" type="checkbox" value="0" name="vaccine1"
										<c:forEach var="li" items="${list1 }">
											<c:if test="${li=='0' }">
												checked = "checked"
											</c:if>
										</c:forEach> />
	
								
						</div>
						<div id="u413A" class="ax_复选框">
							<p id="u414A">
								<span>乙肝疫苗</span>
							</p>
									<input id="u413_input1" type="checkbox" value="1" name="vaccine1" 
										<c:forEach var="li" items="${list1 }">
											<c:if test="${li=='1' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									/>
								
						</div>
						<div id="u415A" class="ax_复选框">
							<p id="u416A">
								<span>早吸吮</span>
							</p>
									<input id="u415_input1" type="checkbox" value="2" name="vaccine1" 
										<c:forEach var="li" items="${list1 }">
											<c:if test="${li=='2' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									
									/>
								
						</div>
					<div id="u417A" class="ax_文本段落">
						<p id="u418A">
							<span>胎儿死亡:</span>
						</p>
					</div>
					<div id="u498A" class="ax_下拉列表框">
						<select id="u498_inputA" name="fetusDie1" >
							<c:if test="${childbirthBabyInfoPO1.fetusDie=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO1.fetusDie=='1' }">
								<option value="0" >是</option>
								<option value="1" selected>否</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO1.fetusDie!='1'&&childbirthBabyInfoPO1.fetusDie!='0' }">
								<option value="0" >是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>

					<div id="u419A" class="ax_文本段落">
						<p id="u420A">
							<span>接生者:</span>
						</p>
					</div>

					<div id="u497A" class="ax_文本框">
						<input id="u497_inputA" type="text"
							value="${childbirthBabyInfoPO1.midwife }" name="midwife1" />
					</div>
				</div>
				</div>
				<div id="hs2" style="display: none">
					<div style="position:absolute; border: 1px solid #cccccc; top:5px;height: 345px;width: 1120px;left: 10px;">
					<br>
					<div id="u506B" class="ax_形状">
						<p id="u507B">
							<span>&nbsp;</span>
						</p>
					</div>

					<div id="u502B" class="ax_形状">
						<p id="u503B">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u349B" class="ax_文本段落">
						<p id="u350B">
							<span>分娩情况:</span>
						</p>
					</div>
					<div id="u351B" class="ax_文本段落">
						<p id="u352B">
							<span>胎位:</span>
						</p>
					</div>
					<div id="u457B" class="ax_下拉列表框">
						<select id="u457_inputB" name="fetusPosition2" >
							<c:if test="${childbirthBabyInfoPO2.fetusPosition=='0'}">
								<option value="0" selected>左腹</option>
								<option value="1">右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.fetusPosition=='1'}">
								<option value="0">左腹</option>
								<option value="1" selected>右腹</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO2.fetusPosition!='1'&&childbirthBabyInfoPO2.fetusPosition!='0'}">
								<option value="0">左腹</option>
								<option value="1">右腹</option>
							</c:if>
						</select>
					</div>
					<div id="u353B" class="ax_文本段落">
						<p id="u354B">
							<span>分娩时间:</span>
						</p>
					</div>
					<div id="u460B" class="ax_文本框">
						<input id="u460_inputB" type="text"
							value="${childbirthBabyInfoPO2.deliveryHour}" name="deliveryHour2" />
					</div>
					<div id="u461B" class="ax_文本段落">
						<p id="u462B">
							<span>时</span>
						</p>
					</div>
					<div id="u465B" class="ax_文本框">
						<input id="u465_inputB" type="text"
							value="${childbirthBabyInfoPO2.deliveryMinute }"
							name="deliveryMinute2" />
					</div>
					<div id="u463B" class="ax_文本段落">
						<p id="u464B">
							<span>分</span>
						</p>
					</div>
					<div id="u377B" class="ax_文本段落">
						<p id="u378B">
							<span>引产:</span>
						</p>
					</div>
					<div id="u458B" class="ax_下拉列表框">
						<select id="u458_inputB" name="inducelabour2" >
							<c:if test="${childbirthBabyInfoPO2.inducelabour=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.inducelabour=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.inducelabour!='1'&&childbirthBabyInfoPO2.inducelabour!='0' }">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u355B" class="ax_文本段落">
						<p id="u356B">
							<span>分娩方式:</span>
						</p>
					</div>
					<div id="u459B" class="ax_下拉列表框">
						<select id="u459_inputB" name="deliveryType2" >
							<c:if test="${childbirthBabyInfoPO2.deliveryType=='0'}">
								<option value="0" selected>剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.deliveryType=='1'}">
								<option value="0">剖宫产</option>
								<option value="1" selected>顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.deliveryType!='1'&&childbirthBabyInfoPO2.deliveryType!='0'}">
								<option value="0">剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
						</select>
					</div>
					<div id="u363B" class="ax_文本段落">
						<p id="u364B">
							<span>剖宫产指征:</span>
						</p>
					</div>
					<div id="u466B" class="ax_文本框">
						<input id="u466_inputB" type="text"
							value="${childbirthBabyInfoPO2.cesareanIdicatio }"
							name="cesareanIdicatio2" />
					</div>
					<div id="u389" class="ax_文本段落">

						<p id="u390">
							<span>婴儿基本情况:</span>
						</p>
					</div>
					<div id="u391B" class="ax_文本段落">
						<p id="u392B">
							<span>婴儿姓名:</span>
						</p>
					</div>
					<div id="u485B" class="ax_文本框">
						<input id="u485_inputB" type="text"
							value="${childbirthBabyInfoPO2.babyName }" name="babyName2" />
					</div>
					<div id="u357B" class="ax_文本段落">
						<p id="u358B">
							<span>婴儿性别:</span>
						</p>
					</div>
					<div id="u482B" class="ax_下拉列表框">
						<select id="u482_inputB" name="babySex2" >
							<c:if test="${childbirthBabyInfoPO2.babySex=='0'}">
								<option value="2">性别不明</option>
								<option value="0" selected>男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.babySex=='1'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1" selected>女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.babySex=='2'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO2.babySex!='2'&&childbirthBabyInfoPO2.babySex!='1'&&childbirthBabyInfoPO2.babySex!='0'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
						</select>
					</div>
					<div id="u361B" class="ax_文本段落">
						<p id="u362B">
							<span>健康状况:</span>
						</p>
					</div>
					<div id="u484B" class="ax_下拉列表框">
						<select id="u484_inputB" name="health2" >
							<c:if test="${childbirthBabyInfoPO2.health=='0' }">
								<option value="0" selected>强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.health=='2' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2" selected>虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.health=='1' }">
								<option value="0">强壮</option>
								<option value="1" selected>健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.health!='2'&&childbirthBabyInfoPO2.health!='1'&& childbirthBabyInfoPO2.health!='0'}">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
						</select>
					</div>
					<div id="u393B" class="ax_文本段落">
						<p id="u394B">
							<span>胎儿畸形:</span>
						</p>
					</div>
					<div id="u486B" class="ax_下拉列表框">
						<select id="u486_inputB" name="fetalAnomaly2" >
							<c:if test="${childbirthBabyInfoPO2.fetalAnomaly=='0'}">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.fetalAnomaly=='1'}">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.fetalAnomaly!='1'&&childbirthBabyInfoPO2.fetalAnomaly!='0'}">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
						</select>
					</div>
					<div id="u395B" class="ax_文本段落">
						<p id="u396B">
							<span>畸形各类部位:</span>
						</p>
					</div>
					<div id="u487B" class="ax_文本框">
						<input id="u487_inputB" type="text"
							value="${childbirthBabyInfoPO2.abnormalPosition }"
							name="abnormalPosition2" />
					</div>
					<div id="u397B" class="ax_文本段落">
						<p id="u398B">
							<span>畸形名称:</span>
						</p>
					</div>
					<div id="u488B" class="ax_文本框">
						<input id="u488_inputB" type="text"
							value="${childbirthBabyInfoPO2.abnormalName }"
							name="abnormalName2" />
					</div>
					<div id="u399B" class="ax_文本段落">
						<p id="u400B">
							<span>评分:</span>
						</p>
					</div>
					<div id="u401B" class="ax_文本段落">
						<p id="u402B">
							<span>1分钟评分:</span>
						</p>
					</div>
					<div id="u489B" class="ax_文本框">
						<input id="u489_inputB" type="text"
							value="${childbirthBabyInfoPO2.oneMinScore }" name="oneMinScore2" />
					</div>
					<div id="u403B" class="ax_文本段落">
						<p id="u404B">
							<span>5分钟评分:</span>
						</p>
					</div>
					<div id="u490B" class="ax_文本框">
						<input id="u490_inputB" type="text"
							value="${childbirthBabyInfoPO2.fiveMinScore }"
							name="fiveMinScore2" />
					</div>
					<div id="u405B" class="ax_文本段落">
						<p id="u406B">
							<span>出生体重:</span>
						</p>
					</div>
					<div id="u491B" class="ax_文本框">
						<input id="u491_inputB" type="text"
							value="${childbirthBabyInfoPO2.bornWeight }" name="bornWeight2" />
					</div>
					<div id="u493B" class="ax_文本段落">
						<p id="u494B">
							<span>g</span>
						</p>
					</div>
					<div id="u407B" class="ax_文本段落">
						<p id="u408B">
							<span>身长:</span>
						</p>
					</div>
					<div id="u492B" class="ax_文本框">
						<input id="u492_inputB" type="text"
							value="${childbirthBabyInfoPO2.bodyLenght }" name="bodyLenght2" />
					</div>
					<div id="u495B" class="ax_文本段落">
						<p id="u496B">
							<span>cm</span>
						</p>
					</div>
					<div id="u409B" class="ax_文本段落">
						<p id="u410B">
							<span>已打疫苗:</span>
						</p>
					</div>
						<div id="u411B" class="ax_复选框">

							<p id="u412B">
								<span>卡介苗</span>
							</p>
									<input id="u411_input2" type="checkbox" value="0" name="vaccine2"
										<c:forEach var="li" items="${list2 }">
											<c:if test="${li=='0' }">
												checked = "checked"
											</c:if>
										</c:forEach> />
						</div>
						<div id="u413B" class="ax_复选框">
							<p id="u414B">
								<span>乙肝疫苗</span>
							</p>
									<input id="u413_input2" type="checkbox" value="1" name="vaccine2" 
										<c:forEach var="li" items="${list2}">
											<c:if test="${li=='1' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									/>
						</div>
						<div id="u415B" class="ax_复选框">
							<p id="u416B">
								<span>早吸吮</span>
							</p>
									<input id="u415_input2" type="checkbox" value="2" name="vaccine2" 
										<c:forEach var="li" items="${list2 }">
											<c:if test="${li=='2' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									/>
						</div>
					<div id="u417B" class="ax_文本段落">
						<p id="u418B">
							<span>胎儿死亡:</span>
						</p>
					</div>
					<div id="u498B" class="ax_下拉列表框">
						<select id="u498_inputB" name="fetusDie2" >
							<c:if test="${childbirthBabyInfoPO2.fetusDie=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.fetusDie=='1' }">
								<option value="0" >是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO2.fetusDie!='1'&&childbirthBabyInfoPO2.fetusDie!='0' }">
								<option value="0" >是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u419B" class="ax_文本段落">
						<p id="u420B">
							<span>接生者:</span>
						</p>
					</div>
					<div id="u497B" class="ax_文本框">
						<input id="u497_inputB" type="text"
							value="${childbirthBabyInfoPO2.midwife }" name="midwife2" />
					</div>
				</div>
				</div>
				<div id="hs3" style="display: none">
					<div style="position:absolute; border: 1px solid #cccccc; top:5px;height: 345px;width: 1120px;left: 10px;">
					<br>
					<div id="u506C" class="ax_形状">
						<p id="u507C">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u502C" class="ax_形状">
						<p id="u503C">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u349C" class="ax_文本段落">
						<p id="u350C">
							<span>分娩情况:</span>
						</p>
					</div>
					<div id="u351C" class="ax_文本段落">
						<p id="u352C">
							<span>胎位:</span>
						</p>
					</div>
					<div id="u457C" class="ax_下拉列表框">
						<select id="u457_inputC" name="fetusPosition3" >
							<c:if test="${childbirthBabyInfoPO3.fetusPosition=='0'}">
								<option value="0" selected>左腹</option>
								<option value="1">右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.fetusPosition=='1'}">
								<option value="0">左腹</option>
								<option value="1" selected>右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.fetusPosition!='1'&&childbirthBabyInfoPO3.fetusPosition!='0'}">
								<option value="0">左腹</option>
								<option value="1">右腹</option>
							</c:if>
						</select>
					</div>
					<div id="u353C" class="ax_文本段落">
						<p id="u354C">
							<span>分娩时间:</span>
						</p>
					</div>
					<div id="u460C" class="ax_文本框">
						<input id="u460_inputC" type="text"
							value="${childbirthBabyInfoPO3.deliveryHour}" name="deliveryHour3" />
					</div>
					<div id="u461C" class="ax_文本段落">
						<p id="u462C">
							<span>时</span>
						</p>
					</div>
					<div id="u465C" class="ax_文本框">
						<input id="u465_inputC" type="text"
							value="${childbirthBabyInfoPO3.deliveryMinute }"
							name="deliveryMinute3" />
					</div>
					<div id="u463C" class="ax_文本段落">
						<p id="u464C">
							<span>分</span>
						</p>
					</div>
					<div id="u377C" class="ax_文本段落">
						<p id="u378C">
							<span>引产:</span>
						</p>
					</div>
					<div id="u458C" class="ax_下拉列表框">
						<select id="u458_inputC" name="inducelabour3" >
							<c:if test="${childbirthBabyInfoPO3.inducelabour=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.inducelabour=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.inducelabour!='1'&&childbirthBabyInfoPO3.inducelabour!='0' }">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u355C" class="ax_文本段落">
						<p id="u356C">
							<span>分娩方式:</span>
						</p>
					</div>
					<div id="u459C" class="ax_下拉列表框">
						<select id="u459_inputC" name="deliveryType3" >
							<c:if test="${childbirthBabyInfoPO3.deliveryType=='0'}">
								<option value="0" selected>剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.deliveryType=='1'}">
								<option value="0">剖宫产</option>
								<option value="1" selected>顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.deliveryType!='1'&&childbirthBabyInfoPO3.deliveryType!='0'}">
								<option value="0">剖宫产</option>
								<option value="1" selected>顺产</option>
							</c:if>
						</select>
					</div>
					<div id="u363C" class="ax_文本段落">
						<p id="u364C">
							<span>剖宫产指征:</span>
						</p>
					</div>
					<div id="u466C" class="ax_文本框">
						<input id="u466_inputC" type="text"
							value="${childbirthBabyInfoPO3.cesareanIdicatio }"
							name="cesareanIdicatio3" />
					</div>
					<div id="u389C" class="ax_文本段落">
						<p id="u390C">
							<span>婴儿基本情况:</span>
						</p>
					</div>
					<div id="u391C" class="ax_文本段落">
						<p id="u392C">
							<span>婴儿姓名:</span>
						</p>
					</div>
					<div id="u485C" class="ax_文本框">
						<input id="u485_inputC" type="text"
							value="${childbirthBabyInfoPO3.babyName }" name="babyName3" />
					</div>
					<div id="u357C" class="ax_文本段落">
						<p id="u358C">
							<span>婴儿性别:</span>
						</p>
					</div>
					<div id="u482C" class="ax_下拉列表框">
						<select id="u482_inputC" name="babySex3" >
							<c:if test="${childbirthBabyInfoPO3.babySex=='0'}">
								<option value="2">性别不明</option>
								<option value="0" selected>男</option>
								<option value="1">女</option>
								
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.babySex=='1'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1" selected>女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.babySex=='2'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.babySex!='2'&&childbirthBabyInfoPO3.babySex!='1'&&childbirthBabyInfoPO3.babySex!='0'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
						</select>
					</div>
					<div id="u361C" class="ax_文本段落">
						<p id="u362C">
							<span>健康状况:</span>
						</p>
					</div>
					<div id="u484C" class="ax_下拉列表框">
						<select id="u484_inputC" name="health3" >
							<c:if test="${childbirthBabyInfoPO3.health=='0' }">
								<option value="0" selected>强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.health=='2' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2" selected>虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.health=='1' }">
								<option value="0">强壮</option>
								<option value="1" selected>健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.health!='2'&&childbirthBabyInfoPO3.health!='1'&&childbirthBabyInfoPO3.health!='0' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
						</select>
					</div>
					<div id="u393C" class="ax_文本段落">
						<p id="u394C">
							<span>胎儿畸形:</span>
						</p>
					</div>
					<div id="u486C" class="ax_下拉列表框">
						<select id="u486_inputC" name="fetalAnomaly3" >

							<c:if test="${childbirthBabyInfoPO3.fetalAnomaly=='0'}">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.fetalAnomaly=='1'}">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.fetalAnomaly!='1'&&childbirthBabyInfoPO3.fetalAnomaly!='0'}">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u395C" class="ax_文本段落">
						<p id="u396C">
							<span>畸形各类部位:</span>
						</p>
					</div>
					<div id="u487C" class="ax_文本框">
						<input id="u487_inputC" type="text"
							value="${childbirthBabyInfoPO3.abnormalPosition }"
							name="abnormalPosition3" />
					</div>
					<div id="u397C" class="ax_文本段落">
						<p id="u398C">
							<span>畸形名称:</span>
						</p>
					</div>
					<div id="u488C" class="ax_文本框">
						<input id="u488_inputC" type="text"
							value="${childbirthBabyInfoPO3.abnormalName }"
							name="abnormalName3" />
					</div>
					<div id="u399C" class="ax_文本段落">
						<p id="u400C">
							<span>评分:</span>
						</p>
					</div>
					<div id="u401C" class="ax_文本段落">
						<p id="u402C">
							<span>1分钟评分:</span>
						</p>
					</div>
					<div id="u489C" class="ax_文本框">
						<input id="u489_inputC" type="text"
							value="${childbirthBabyInfoPO3.oneMinScore }" name="oneMinScore3" />
					</div>
					<div id="u403C" class="ax_文本段落">
						<p id="u404C">
							<span>5分钟评分:</span>
						</p>
					</div>
					<div id="u490C" class="ax_文本框">
						<input id="u490_inputC" type="text"
							value="${childbirthBabyInfoPO3.fiveMinScore }"
							name="fiveMinScore3" />
					</div>
					<div id="u405C" class="ax_文本段落">
						<p id="u406C">
							<span>出生体重:</span>
						</p>
					</div>
					<div id="u491C" class="ax_文本框">
						<input id="u491_inputC" type="text"
							value="${childbirthBabyInfoPO3.bornWeight }" name="bornWeight3" />
					</div>
					<div id="u493C" class="ax_文本段落">
						<p id="u494C">
							<span>g</span>
						</p>
					</div>
					<div id="u407C" class="ax_文本段落">
						<p id="u408C">
							<span>身长:</span>
						</p>
					</div>
					<div id="u492C" class="ax_文本框">
						<input id="u492_inputC" type="text"
							value="${childbirthBabyInfoPO3.bodyLenght }" name="bodyLenght3" />
					</div>
					<div id="u495C" class="ax_文本段落">
						<p id="u496C">
							<span>cm</span>
						</p>
					</div>
					<div id="u409C" class="ax_文本段落">
						<p id="u410C">
							<span>已打疫苗:</span>
						</p>
					</div>
						<div id="u411C" class="ax_复选框">
							<p id="u412C">
								<span>卡介苗</span>
							</p>
									<input id="u411_input3" type="checkbox" value="0" name="vaccine3"
										<c:forEach var="li" items="${list3 }">
											<c:if test="${li=='0' }">
												checked = "checked"
											</c:if>
										</c:forEach> />
						</div>
						<div id="u413C" class="ax_复选框">
							<p id="u414C">
								<span>乙肝疫苗</span>
							</p>
									<input id="u413_input3" type="checkbox" value="1" name="vaccine3" 
										<c:forEach var="li" items="${list3}">
											<c:if test="${li=='1' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									/>
						</div>
						<div id="u415C" class="ax_复选框">
							<p id="u416C">
								<span>早吸吮</span>
							</p>
									<input id="u415_input3" type="checkbox" value="2" name="vaccine3" 
										<c:forEach var="li" items="${list3 }">
											<c:if test="${li=='2' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									/>
						</div>
					<div id="u417C" class="ax_文本段落">
						<p id="u418C">
							<span>胎儿死亡:</span>
						</p>
					</div>

					<div id="u498C" class="ax_下拉列表框">
						<select id="u498_inputC" name="fetusDie3" >
							<c:if test="${childbirthBabyInfoPO3.fetusDie=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO3.fetusDie=='1' }">
								<option value="0" >是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO3.fetusDie!='1'&&childbirthBabyInfoPO3.fetusDie!='0' }">
								<option value="0" >是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>

					<div id="u419C" class="ax_文本段落">
						<p id="u420C">
							<span>接生者:</span>
						</p>
					</div>

					<div id="u497C" class="ax_文本框">
						<input id="u497_inputC" type="text"
							value="${childbirthBabyInfoPO3.midwife }" name="midwife3" />
					</div>
				</div>
				</div>				
				<div id="hs4" style="display: none">
					<div style="position:absolute; border: 1px solid #cccccc; top:5px;height: 345px;width: 1120px;left: 10px;">
					<br>
					<div id="u506" class="ax_形状">
						<p id="u507">
							<span>&nbsp;</span>
						</p>
					</div>

					<div id="u502" class="ax_形状">
						<p id="u503">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u349" class="ax_文本段落">
						<p id="u350">
							<span>分娩情况:</span>
						</p>
					</div>
					<div id="u351" class="ax_文本段落">
						<p id="u352">
							<span>胎位:</span>
						</p>
					</div>
					<div id="u457" class="ax_下拉列表框">
						<select id="u457_input" name="fetusPosition4" >
							<c:if test="${childbirthBabyInfoPO4.fetusPosition=='0'}">
								<option value="0" selected>左腹</option>
								<option value="1">右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.fetusPosition=='1'}">
								<option value="0">左腹</option>
								<option value="1" selected>右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.fetusPosition!='1'&&childbirthBabyInfoPO4.fetusPosition!='0'}">
								<option value="0">左腹</option>
								<option value="1">右腹</option>
							</c:if>
						</select>
					</div>
					<div id="u353" class="ax_文本段落">
						<p id="u354">
							<span>分娩时间:</span>
						</p>
					</div>
					<div id="u460" class="ax_文本框">
						<input id="u460_input" type="text"
							value="${childbirthBabyInfoPO4.deliveryHour}" name="deliveryHour4" />
					</div>
					<div id="u461" class="ax_文本段落">
						<p id="u462">
							<span>时</span>
						</p>
					</div>
					<div id="u465" class="ax_文本框">
						<input id="u465_input" type="text"
							value="${childbirthBabyInfoPO4.deliveryMinute }"
							name="deliveryMinute4" />
					</div>
					<div id="u463" class="ax_文本段落">
						<p id="u464">
							<span>分</span>
						</p>
					</div>
					<div id="u377" class="ax_文本段落">
						<p id="u378">
							<span>引产:</span>
						</p>
					</div>
					<div id="u458" class="ax_下拉列表框">
						<select id="u458_input" name="inducelabour4" >
							<c:if test="${childbirthBabyInfoPO4.inducelabour=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.inducelabour=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.inducelabour!='1'&&childbirthBabyInfoPO4.inducelabour!='0' }">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u355" class="ax_文本段落">
						<p id="u356">
							<span>分娩方式:</span>
						</p>
					</div>
					<div id="u459" class="ax_下拉列表框">
						<select id="u459_input" name="deliveryType4" >

							<c:if test="${childbirthBabyInfoPO4.deliveryType=='0'}">
								<option value="0" selected>剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.deliveryType=='1'}">
								<option value="0">剖宫产</option>
								<option value="1" selected>顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.deliveryType!='1'&&childbirthBabyInfoPO4.deliveryType!='0'}">
								<option value="0">剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
						</select>
					</div>
					<div id="u363" class="ax_文本段落">
						<p id="u364">
							<span>剖宫产指征:</span>
						</p>
					</div>
					<div id="u466" class="ax_文本框">
						<input id="u466_input" type="text"
							value="${childbirthBabyInfoPO4.cesareanIdicatio }"
							name="cesareanIdicatio4" />
					</div>
					<div id="u389" class="ax_文本段落">
						<p id="u390">
							<span>婴儿基本情况:</span>
						</p>
					</div>
					<div id="u391" class="ax_文本段落">
						<p id="u392">
							<span>婴儿姓名:</span>
						</p>
					</div>
					<div id="u485" class="ax_文本框">
						<input id="u485_input" type="text"
							value="${childbirthBabyInfoPO4.babyName }" name="babyName4" />
					</div>
					<div id="u357" class="ax_文本段落">
						<p id="u358">
							<span>婴儿性别:</span>
						</p>
					</div>
					<div id="u482" class="ax_下拉列表框">
						<select id="u482_input" name="babySex4" >
							<c:if test="${childbirthBabyInfoPO4.babySex=='0'}">
								<option value="2">性别不明</option>
								<option value="0" selected>男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.babySex=='1'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1" selected>女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.babySex=='2'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.babySex!='2'&&childbirthBabyInfoPO4.babySex!='1'&&childbirthBabyInfoPO4.babySex!='0'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
						</select>
					</div>
					<div id="u361" class="ax_文本段落">
						<p id="u362">
							<span>健康状况:</span>
						</p>
					</div>
					<div id="u484" class="ax_下拉列表框">
						<select id="u484_input" name="health4" >
							<c:if test="${childbirthBabyInfoPO4.health=='0' }">
								<option value="0" selected>强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.health=='2' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2" selected>虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.health=='1' }">
								<option value="0">强壮</option>
								<option value="1" selected>健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.health!='2'&&childbirthBabyInfoPO4.health!='1'&&childbirthBabyInfoPO4.health!='0' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
						</select>
					</div>
					<div id="u393" class="ax_文本段落">
						<p id="u394">
							<span>胎儿畸形:</span>
						</p>
					</div>
					<div id="u486" class="ax_下拉列表框">
						<select id="u486_input" name="fetalAnomaly4" >

							<c:if test="${childbirthBabyInfoPO4.fetalAnomaly=='0'}">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.fetalAnomaly=='1'}">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.fetalAnomaly!='1'&&childbirthBabyInfoPO4.fetalAnomaly!='0'}">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u395" class="ax_文本段落">
						<p id="u396">
							<span>畸形各类部位:</span>
						</p>
					</div>
					<div id="u487" class="ax_文本框">
						<input id="u487_input" type="text"
							value="${childbirthBabyInfoPO4.abnormalPosition }"
							name="abnormalPosition4" />
					</div>
					<div id="u397" class="ax_文本段落">
						<p id="u398">
							<span>畸形名称:</span>
						</p>
					</div>
					<div id="u488" class="ax_文本框">
						<input id="u488_input" type="text"
							value="${childbirthBabyInfoPO4.abnormalName }"
							name="abnormalName4" />
					</div>
					<div id="u399" class="ax_文本段落">
						<p id="u400">
							<span>评分:</span>
						</p>
					</div>
					<div id="u401" class="ax_文本段落">
						<p id="u402">
							<span>1分钟评分:</span>
						</p>
					</div>
					<div id="u489" class="ax_文本框">
						<input id="u489_input" type="text"
							value="${childbirthBabyInfoPO4.oneMinScore }" name="oneMinScore4" />
					</div>

					<div id="u403" class="ax_文本段落">
						<p id="u404">
							<span>5分钟评分:</span>
						</p>
					</div>
					<div id="u490" class="ax_文本框">
						<input id="u490_input" type="text"
							value="${childbirthBabyInfoPO4.fiveMinScore }"
							name="fiveMinScore4" />
					</div>
					<div id="u405" class="ax_文本段落">
						<p id="u406">
							<span>出生体重:</span>
						</p>
					</div>
					<div id="u491" class="ax_文本框">
						<input id="u491_input" type="text"
							value="${childbirthBabyInfoPO4.bornWeight }" name="bornWeight4" />
					</div>
					<div id="u493" class="ax_文本段落">
						<p id="u494">
							<span>g</span>
						</p>
					</div>
					<div id="u407" class="ax_文本段落">
						<p id="u408">
							<span>身长:</span>
						</p>
					</div>
					<div id="u492" class="ax_文本框">
						<input id="u492_input" type="text"
							value="${childbirthBabyInfoPO4.bodyLenght }" name="bodyLenght4" />
					</div>
					<div id="u495" class="ax_文本段落">
						<p id="u496">
							<span>cm</span>
						</p>
					</div>
					<div id="u409" class="ax_文本段落">
						<p id="u410">
							<span>已打疫苗:</span>
						</p>
					</div>
						<div id="u411" class="ax_复选框">
							<p id="u412">
								<span>卡介苗</span>
							</p>
									<input id="u411_input4" type="checkbox" value="0" name="vaccine4"
										<c:forEach var="li" items="${list4 }">
											<c:if test="${li=='0' }">
												checked = "checked"
											</c:if>
										</c:forEach> />
	
								
						</div>
						<div id="u413" class="ax_复选框">
							<p id="u414">
								<span>乙肝疫苗</span>
							</p>
									<input id="u413_input4" type="checkbox" value="1" name="vaccine4" 
										<c:forEach var="li" items="${list4}">
											<c:if test="${li=='1' }">
												checked = "checked"
											</c:if>
										</c:forEach>/>
						</div>
						<div id="u415" class="ax_复选框">
							<p id="u416">
								<span>早吸吮</span>
							</p>
									<input id="u415_input4" type="checkbox" value="2" name="vaccine4" 
										<c:forEach var="li" items="${list4 }">
											<c:if test="${li=='2' }">
												checked = "checked"
											</c:if>
										</c:forEach>/>
						</div>
					<div id="u417" class="ax_文本段落">
						<p id="u418">
							<span>胎儿死亡:</span>
						</p>
					</div>
					<div id="u498" class="ax_下拉列表框">
						<select id="u498_input" name="fetusDie4" >
							<c:if test="${childbirthBabyInfoPO4.fetusDie=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.fetusDie=='1' }">
								<option value="0" >是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO4.fetusDie!='1'&&childbirthBabyInfoPO4.fetusDie!='0' }">
								<option value="0" >是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>

					<div id="u419" class="ax_文本段落">
						<p id="u420">
							<span>接生者:</span>
						</p>
					</div>

					<div id="u497" class="ax_文本框">
						<input id="u497_input" type="text"
							value="${childbirthBabyInfoPO4.midwife }" name="midwife4" />
					</div>
				</div>
				</div>	
				<div id="hs5" style="display: none">
					<div style="position:absolute; border: 1px solid #cccccc; top:5px;height: 345px;width: 1120px;left: 10px;">
					<br>
					<div id="u506" class="ax_形状">
						<p id="u507">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u502" class="ax_形状">
						<p id="u503">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u349" class="ax_文本段落">
						<p id="u350">
							<span>分娩情况:</span>
						</p>
					</div>
					<div id="u351" class="ax_文本段落">
						<p id="u352">
							<span>胎位:</span>
						</p>
					</div>
					<div id="u457" class="ax_下拉列表框">
						<select id="u457_input" name="fetusPosition5" >
							<c:if test="${childbirthBabyInfoPO5.fetusPosition=='0'}">
								<option value="0" selected>左腹</option>
								<option value="1">右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.fetusPosition=='1'}">
								<option value="0">左腹</option>
								<option value="1" selected>右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.fetusPosition!='1'&&childbirthBabyInfoPO5.fetusPosition!='0'}">
								<option value="0">左腹</option>
								<option value="1">右腹</option>
							</c:if>
						</select>
					</div>
					<div id="u353" class="ax_文本段落">
						<p id="u354">
							<span>分娩时间:</span>
						</p>
					</div>
					<div id="u460" class="ax_文本框">
						<input id="u460_input" type="text"
							value="${childbirthBabyInfoPO5.deliveryHour}" name="deliveryHour5" />
					</div>
					<div id="u461" class="ax_文本段落">
						<p id="u462">
							<span>时</span>
						</p>
					</div>
					<div id="u465" class="ax_文本框">
						<input id="u465_input" type="text"
							value="${childbirthBabyInfoPO5.deliveryMinute }"
							name="deliveryMinute5" />
					</div>
					<div id="u463" class="ax_文本段落">
						<p id="u464">
							<span>分</span>
						</p>
					</div>
					<div id="u377" class="ax_文本段落">
						<p id="u378">
							<span>引产:</span>
						</p>
					</div>
					<div id="u458" class="ax_下拉列表框">
						<select id="u458_input" name="inducelabour5" >
							<c:if test="${childbirthBabyInfoPO5.inducelabour=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.inducelabour=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.inducelabour!='1'&&childbirthBabyInfoPO5.inducelabour!='0' }">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u355" class="ax_文本段落">
						<p id="u356">
							<span>分娩方式:</span>
						</p>
					</div>
					<div id="u459" class="ax_下拉列表框">
						<select id="u459_input" name="deliveryType5" >
							<c:if test="${childbirthBabyInfoPO5.deliveryType=='0'}">
								<option value="0" selected>剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.deliveryType=='1'}">
								<option value="0">剖宫产</option>
								<option value="1" selected>顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.deliveryType!='1'&&childbirthBabyInfoPO5.deliveryType!='0'}">
								<option value="0">剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
						</select>
					</div>
					<div id="u363" class="ax_文本段落">
						<p id="u364">
							<span>剖宫产指征:</span>
						</p>
					</div>
					<div id="u466" class="ax_文本框">
						<input id="u466_input" type="text"
							value="${childbirthBabyInfoPO5.cesareanIdicatio }"
							name="cesareanIdicatio5" />
					</div>
					<div id="u389" class="ax_文本段落">

						<p id="u390">
							<span>婴儿基本情况:</span>
						</p>
					</div>
					<div id="u391" class="ax_文本段落">
						<p id="u392">
							<span>婴儿姓名:</span>
						</p>
					</div>
					<div id="u485" class="ax_文本框">
						<input id="u485_input" type="text"
							value="${childbirthBabyInfoPO5.babyName }" name="babyName5" />
					</div>
					<div id="u357" class="ax_文本段落">
						<p id="u358">
							<span>婴儿性别:</span>
						</p>
					</div>
					<div id="u482" class="ax_下拉列表框">
						<select id="u482_input" name="babySex5" >
							<c:if test="${childbirthBabyInfoPO5.babySex=='0'}">
								<option value="2">性别不明</option>
								<option value="0" selected>男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.babySex=='1'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1" selected>女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.babySex=='2'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.babySex!='2'&&childbirthBabyInfoPO5.babySex!='1'&&childbirthBabyInfoPO5.babySex!='0'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
						</select>
					</div>

					<div id="u361" class="ax_文本段落">
						<p id="u362">
							<span>健康状况:</span>
						</p>
					</div>
					<div id="u484" class="ax_下拉列表框">
						<select id="u484_input" name="health5" >
							<c:if test="${childbirthBabyInfoPO5.health=='0' }">
								<option value="0" selected>强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.health=='2' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2" selected>虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.health=='1' }">
								<option value="0">强壮</option>
								<option value="1" selected>健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.health!='2'&&childbirthBabyInfoPO5.health!='1'&&childbirthBabyInfoPO5.health!='0' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
						</select>
					</div>
					<div id="u393" class="ax_文本段落">
						<p id="u394">
							<span>胎儿畸形:</span>
						</p>
					</div>
					<div id="u486" class="ax_下拉列表框">
						<select id="u486_input" name="fetalAnomaly5" >

							<c:if test="${childbirthBabyInfoPO5.fetalAnomaly=='0'}">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.fetalAnomaly=='1'}">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.fetalAnomaly!='1'&&childbirthBabyInfoPO5.fetalAnomaly!='0'}">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u395" class="ax_文本段落">
						<p id="u396">
							<span>畸形各类部位:</span>
						</p>
					</div>
					<div id="u487" class="ax_文本框">
						<input id="u487_input" type="text"
							value="${childbirthBabyInfoPO5.abnormalPosition }"
							name="abnormalPosition5" />
					</div>
					<div id="u397" class="ax_文本段落">
						<p id="u398">
							<span>畸形名称:</span>
						</p>
					</div>
					<div id="u488" class="ax_文本框">
						<input id="u488_input" type="text"
							value="${childbirthBabyInfoPO5.abnormalName }"
							name="abnormalName5" />
					</div>
					<div id="u399" class="ax_文本段落">
						<p id="u400">
							<span>评分:</span>
						</p>
					</div>
					<div id="u401" class="ax_文本段落">
						<p id="u402">
							<span>1分钟评分:</span>
						</p>
					</div>
					<div id="u489" class="ax_文本框">
						<input id="u489_input" type="text"
							value="${childbirthBabyInfoPO5.oneMinScore }" name="oneMinScore5" />
					</div>
					<div id="u403" class="ax_文本段落">
						<p id="u404">
							<span>5分钟评分:</span>
						</p>
					</div>
					<div id="u490" class="ax_文本框">
						<input id="u490_input" type="text"
							value="${childbirthBabyInfoPO5.fiveMinScore }"
							name="fiveMinScore5" />
					</div>
					<div id="u405" class="ax_文本段落">
						<p id="u406">
							<span>出生体重:</span>
						</p>
					</div>
					<div id="u491" class="ax_文本框">
						<input id="u491_input" type="text"
							value="${childbirthBabyInfoPO5.bornWeight }" name="bornWeight5" />
					</div>
					<div id="u493" class="ax_文本段落">
						<p id="u494">
							<span>g</span>
						</p>
					</div>
					<div id="u407" class="ax_文本段落">
						<p id="u408">
							<span>身长:</span>
						</p>
					</div>
					<div id="u492" class="ax_文本框">
						<input id="u492_input" type="text"
							value="${childbirthBabyInfoPO5.bodyLenght }" name="bodyLenght5" />
					</div>
					<div id="u495" class="ax_文本段落">
						<p id="u496">
							<span>cm</span>
						</p>
					</div>
					<div id="u409" class="ax_文本段落">
						<p id="u410">
							<span>已打疫苗:</span>
						</p>
					</div>
						<div id="u411" class="ax_复选框">
							<p id="u412">
								<span>卡介苗</span>
							</p>
									<input id="u411_input5" type="checkbox" value="0" name="vaccine5"
										<c:forEach var="li" items="${list5 }">
											<c:if test="${li=='0' }">
												checked = "checked"
											</c:if>
										</c:forEach> />
						</div>
						<div id="u413" class="ax_复选框">
							<p id="u414">
								<span>乙肝疫苗</span>
							</p>
									<input id="u413_input5" type="checkbox" value="1" name="vaccine5" 
										<c:forEach var="li" items="${list5}">
											<c:if test="${li=='1' }">
												checked = "checked"
											</c:if>
										</c:forEach>/>
						</div>
						<div id="u415" class="ax_复选框">
							<p id="u416">
								<span>早吸吮</span>
							</p>
									<input id="u415_input5" type="checkbox" value="2" name="vaccine5" 
										<c:forEach var="li" items="${list5 }">
											<c:if test="${li=='2' }">
												checked = "checked"
											</c:if>
										</c:forEach>/>
						</div>
					<div id="u417" class="ax_文本段落">
						<p id="u418">
							<span>胎儿死亡:</span>
						</p>
					</div>
					<div id="u498" class="ax_下拉列表框">
						<select id="u498_input" name="fetusDie5" >
							<c:if test="${childbirthBabyInfoPO5.fetusDie=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO5.fetusDie=='1' }">
								<option value="0" >是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO5.fetusDi!='1'&&childbirthBabyInfoPO5.fetusDi!='0' }">
								<option value="0" >是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u419" class="ax_文本段落">
						<p id="u420">
							<span>接生者:</span>
						</p>
					</div>

					<div id="u497" class="ax_文本框">
						<input id="u497_input" type="text"
							value="${childbirthBabyInfoPO5.midwife }" name="midwife5" />
					</div>
				</div>
				</div>
				<div id="hs6" style="display: none">
					<div style="position:absolute; border: 1px solid #cccccc; top:5px;height: 345px;width: 1120px;left: 10px;">
					<br>
					<div id="u506" class="ax_形状">
						<p id="u507">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u502" class="ax_形状">
						<p id="u503">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u349" class="ax_文本段落">
						<p id="u350">
							<span>分娩情况:</span>
						</p>
					</div>
					<div id="u351" class="ax_文本段落">
						<p id="u352">
							<span>胎位:</span>
						</p>
					</div>
					<div id="u457" class="ax_下拉列表框">
						<select id="u457_input" name="fetusPosition6" >
							<c:if test="${childbirthBabyInfoPO6.fetusPosition=='0'}">
								<option value="0" selected>左腹</option>
								<option value="1">右腹</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.fetusPosition=='1'}">
								<option value="0">左腹</option>
								<option value="1" selected>右腹</option>
							</c:if>
						</select>
					</div>
					<div id="u353" class="ax_文本段落">
						<p id="u354">
							<span>分娩时间:</span>
						</p>
					</div>
					<div id="u460" class="ax_文本框">
						<input id="u460_input" type="text"
							value="${childbirthBabyInfoPO6.deliveryHour}" name="deliveryHour6" />
					</div>
					<div id="u461" class="ax_文本段落">
						<p id="u462">
							<span>时</span>
						</p>
					</div>
					<div id="u465" class="ax_文本框">
						<input id="u465_input" type="text"
							value="${childbirthBabyInfoPO6.deliveryMinute }"
							name="deliveryMinute6" />
					</div>
					<div id="u463" class="ax_文本段落">
						<p id="u464">
							<span>分</span>
						</p>
					</div>
					<div id="u377" class="ax_文本段落">
						<p id="u378">
							<span>引产:</span>
						</p>
					</div>
					<div id="u458" class="ax_下拉列表框">
						<select id="u458_input" name="inducelabour6" >
							<c:if test="${childbirthBabyInfoPO6.inducelabour=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.inducelabour=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
						</select>
					</div>
					<div id="u355" class="ax_文本段落">
						<p id="u356">
							<span>分娩方式:</span>
						</p>
					</div>
					<div id="u459" class="ax_下拉列表框">
						<select id="u459_input" name="deliveryType6" >
							<c:if test="${childbirthBabyInfoPO6.deliveryType=='0'}">
								<option value="0" selected>剖宫产</option>
								<option value="1">顺产</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.deliveryType=='1'}">
								<option value="0">剖宫产</option>
								<option value="1" selected>顺产</option>
							</c:if>
						</select>
					</div>
					<div id="u363" class="ax_文本段落">
						<p id="u364">
							<span>剖宫产指征:</span>
						</p>
					</div>
					<div id="u466" class="ax_文本框">
						<input id="u466_input" type="text"
							value="${childbirthBabyInfoPO6.cesareanIdicatio }"
							name="cesareanIdicatio6" />
					</div>
					<div id="u389" class="ax_文本段落">

						<p id="u390">
							<span>婴儿基本情况:</span>
						</p>
					</div>
					<div id="u391" class="ax_文本段落">
						<p id="u392">
							<span>婴儿姓名:</span>
						</p>
					</div>
					<div id="u485" class="ax_文本框">
						<input id="u485_input" type="text"
							value="${childbirthBabyInfoPO6.babyName }" name="babyName6" />
					</div>
					<div id="u357" class="ax_文本段落">
						<p id="u358">
							<span>婴儿性别:</span>
						</p>
					</div>
					<div id="u482" class="ax_下拉列表框">
						<select id="u482_input" name="babySex6" >
							<c:if test="${childbirthBabyInfoPO6.babySex=='0'}">
								<option value="2">性别不明</option>
								<option value="0" selected>男</option>
								<option value="1">女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.babySex=='1'}">
								<option value="2">性别不明</option>
								<option value="0">男</option>
								<option value="1" selected>女</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.babySex=='2'}">
								<option value="2" selected>性别不明</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</c:if>
						</select>
					</div>
					<div id="u361" class="ax_文本段落">
						<p id="u362">
							<span>健康状况:</span>
						</p>
					</div>
					<div id="u484" class="ax_下拉列表框">
						<select id="u484_input" name="health6" >
							<c:if test="${childbirthBabyInfoPO6.health=='0' }">
								<option value="0" selected>强壮</option>
								<option value="1">健康</option>
								<option value="2">虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.health=='2' }">
								<option value="0">强壮</option>
								<option value="1">健康</option>
								<option value="2" selected>虚弱</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.health=='1' }">
								<option value="0">强壮</option>
								<option value="1" selected>健康</option>
								<option value="2">虚弱</option>
							</c:if>
						</select>
					</div>
					<div id="u393" class="ax_文本段落">
						<p id="u394">
							<span>胎儿畸形:</span>
						</p>
					</div>
					<div id="u486" class="ax_下拉列表框">
						<select id="u486_input" name="fetalAnomaly6" >

							<c:if test="${childbirthBabyInfoPO6.fetalAnomaly=='0'}">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.fetalAnomaly=='1'}">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
						</select>
					</div>
					<div id="u395" class="ax_文本段落">
						<p id="u396">
							<span>畸形各类部位:</span>
						</p>
					</div>
					<div id="u487" class="ax_文本框">
						<input id="u487_input" type="text"
							value="${childbirthBabyInfoPO6.abnormalPosition }"
							name="abnormalPosition6" />
					</div>
					<div id="u397" class="ax_文本段落">
						<p id="u398">
							<span>畸形名称:</span>
						</p>
					</div>
					<div id="u488" class="ax_文本框">
						<input id="u488_input" type="text"
							value="${childbirthBabyInfoPO6.abnormalName }"
							name="abnormalName6" />
					</div>
					<div id="u399" class="ax_文本段落">
						<p id="u400">
							<span>评分:</span>
						</p>
					</div>
					<div id="u401" class="ax_文本段落">
						<p id="u402">
							<span>1分钟评分:</span>
						</p>
					</div>
					<div id="u489" class="ax_文本框">
						<input id="u489_input" type="text"
							value="${childbirthBabyInfoPO6.oneMinScore }" name="oneMinScore6" />
					</div>
					<div id="u403" class="ax_文本段落">
						<p id="u404">
							<span>5分钟评分:</span>
						</p>
					</div>
					<div id="u490" class="ax_文本框">
						<input id="u490_input" type="text"
							value="${childbirthBabyInfoPO6.fiveMinScore }"
							name="fiveMinScore6" />
					</div>
					<div id="u405" class="ax_文本段落">
						<p id="u406">
							<span>出生体重:</span>
						</p>
					</div>
					<div id="u491" class="ax_文本框">
						<input id="u491_input" type="text"
							value="${childbirthBabyInfoPO6.bornWeight }" name="bornWeight6" />
					</div>

					<div id="u493" class="ax_文本段落">
						<p id="u494">
							<span>g</span>
						</p>
					</div>
					<div id="u407" class="ax_文本段落">
						<p id="u408">
							<span>身长:</span>
						</p>
					</div>
					<div id="u492" class="ax_文本框">
						<input id="u492_input" type="text"
							value="${childbirthBabyInfoPO6.bodyLenght }" name="bodyLenght6" />
					</div>
					<div id="u495" class="ax_文本段落">
						<p id="u496">
							<span>cm</span>
						</p>
					</div>
					<div id="u409" class="ax_文本段落">
						<p id="u410">
							<span>已打疫苗:</span>
						</p>
					</div>
						<div id="u411" class="ax_复选框">

							<p id="u412">
								<span>卡介苗</span>
							</p>
									<input id="u411_input6" type="checkbox" value="0" name="vaccine6"
										<c:forEach var="li" items="${list6 }">
											<c:if test="${li=='0' }">
												checked = "checked"
											</c:if>
										</c:forEach> />
						</div>
						<div id="u413" class="ax_复选框">
							<p id="u414">
								<span>乙肝疫苗</span>
							</p>
									<input id="u413_input6" type="checkbox" value="1" name="vaccine6" 
										<c:forEach var="li" items="${list6}">
											<c:if test="${li=='1' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									/>
						</div>
						<div id="u415" class="ax_复选框">
							<p id="u416">
								<span>早吸吮</span>
							</p>
									<input id="u415_input6" type="checkbox" value="2" name="vaccine6" 
										<c:forEach var="li" items="${list6 }">
											<c:if test="${li=='2' }">
												checked = "checked"
											</c:if>
										</c:forEach>
									/>
						</div>
					<div id="u417" class="ax_文本段落">
						<p id="u418">
							<span>胎儿死亡:</span>
						</p>
					</div>
					<div id="u498" class="ax_下拉列表框">
						<select id="u498_input" name="fetusDie6" >
							<c:if test="${childbirthBabyInfoPO6.fetusDie=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							
							<c:if test="${childbirthBabyInfoPO6.fetusDie=='1' }">
								<option value="0" >是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if test="${childbirthBabyInfoPO6.fetusDie!='1'&&childbirthBabyInfoPO6.fetusDie!='0' }">
								<option value="0" >是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
					<div id="u419" class="ax_文本段落">
						<p id="u420">
							<span>接生者:</span>
						</p>
					</div>
					<div id="u497" class="ax_文本框">
						<input id="u497_input" type="text"
							value="${childbirthBabyInfoPO6.midwife }" name="midwife6" />
					</div>
				</div>
				</div>
				<div id="s8" style="display: ''">
					<div id="u421" class="ax_文本段落">
						<p id="u422">
							<span>产妇、婴儿死亡情况:</span>
						</p>
					</div>
					<div id="u423" class="ax_文本段落">
						<p id="u424">
							<span>产妇:</span>
						</p>
					</div>
					<div id="u499" class="ax_文本框">
						<input id="u499_input" type="text" value="${childbirth.puerpera }"
							name="puerpera" />
					</div>
					<div id="u425" class="ax_文本段落">
						<p id="u426">
							<span>死亡原因:</span>
						</p>
					</div>
					<div id="u500" class="ax_文本框">
						<input id="u500_input" type="text"
							value="${childbirth.puerperaDieReason }" name="puerperaDieReason" />
					</div>

					<div id="u427" class="ax_文本段落">
						<p id="u428">
							<span>婴儿:</span>
						</p>
					</div>
					<div id="u501" class="ax_文本框">
						<input id="u501_input" type="text" value="${childbirth.baby }"
							name="baby" />
					</div>
				</div>
			</div>
			<div id="s9" name="foldDiv5" onclick="AutoFold('foldDiv6','u24',8)">
					<div id="u22" class="ax_形状" style="background-color: #009dd9">
						<p id="u23">
							<span>转 诊</span>
						</p>
					</div>
					<div id="u24" class="ax_文本段落">
						<!-- <p id="u25"><span>收起</span></p> -->
						<p id="u25" onclick="CanShu('s7','u25');">收起</p>
					</div>
				</div>
				<div id="s7" name="foldDiv6">
					<div id="u26" class="ax_文本段落">
						<p id="u27">
							<span>转诊</span><span>:</span>
						</p>
					</div>
					<c:if test="${findBy.referral =='0'}">
						<div id="u28" class="ax_单选按钮">
							<p id="u29">
								<span> 无</span>
							</p>
							<input id="u28_input" type="radio" value="0" name="referral"
								checked />
						</div>
						<div id="u30" class="ax_单选按钮">
							<p id="u31">
								<span> 有</span>
							</p>
							<input id="u30_input" type="radio" value="1" name="referral" />
						</div>
					</c:if>
					<c:if test="${findBy.referral =='1' }">
						<div id="u28" class="ax_单选按钮">
							<p id="u29">
								<span> 无</span>
							</p>

							<input id="u28_input" type="radio" value="0" name="referral" />
						</div>
						<div id="u30" class="ax_单选按钮">
							<p id="u31">
								<span> 有</span>
							</p>
							<input id="u30_input" type="radio" value="1" name="referral"
								checked />
						</div>
					</c:if>
					<c:if test="${findBy.referral !='1'&& findBy.referral !='0'}">
						<div id="u28" class="ax_单选按钮">
							<p id="u29">
								<span> 无</span>
							</p>

							<input id="u28_input" type="radio" value="0" name="referral"/>
						</div>
						<div id="u30" class="ax_单选按钮">
							<p id="u31">
								<span> 有</span>
							</p>
							<input id="u30_input" type="radio" value="1" name="referral"/>
						</div>
					</c:if>
					<div id="u32" class="ax_文本段落">
						<p id="u33">
							<span>原因:</span>
						</p>
					</div>

					<div id="u34" class="ax_文本框">
						<input id="u34_input" type="text" value="${findBy.reason}"
							name="reason" />
					</div>
					<div id="u35" class="ax_文本段落">
						<p id="u36">
							<span>转诊机构:</span>
						</p>
					</div>
					<div id="u37" class="ax_下拉列表框">
						<select id="u37_input" name="department" >
							<c:forEach var="par" items="${departlist }">
				        		<option  value="${par.id}"
				        			<c:if test="${department.id==par.id}">
				        				selected
				        			</c:if>
				        		>${par.name}</option>
				        	</c:forEach>
						</select>
					</div>
					<div id="u38" class="ax_文本段落">
						<p id="u39">
							<span>转诊科室:</span>
						</p>
					</div>
					<div id="u40" class="ax_下拉列表框">
						<select id="u40_input" name="mechanism" >
							<c:if test="${roleBy.id!=null&&roleBy.id!=''}">
								<option value="${roleBy.id}" selected>${roleBy.name }</option>
							</c:if>
							<c:forEach items="${roleList }" var="rolre">
               					<option value="${rolre.id }">${rolre.name }</option>
            				</c:forEach>
						</select>
					</div>
					<div id="u41" class="ax_文本段落">
						<p id="u42">
							<span>下次访视日期:</span>
						</p>
					</div>

					<div id="u43" class="ax_下拉列表框">
						<input type="text" id="u43_input" name="nextFollowingDate"
							value="<fmt:formatDate value="${findBy.nextFollowingDate }" pattern="yyyyMMdd"/>"
							readonly style="color: #adadaf"
							onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"  />
					</div>
					<div id="u44" class="ax_文本段落">
						<p id="u45">
							<span>是否预约下次访视:</span>
						</p>
					</div>
					<c:if test="${findBy.orderCheck=='0' }">
						<div id="u46" class="ax_单选按钮">
							<p id="u47">
								<span> 是</span>
							</p>
							<input id="u46_input" type="radio" value="0"
								name="orderCheck" checked />
						</div>
						<div id="u48" class="ax_单选按钮">
							<p id="u49">
								<span> 否</span>
							</p>
							<input id="u48_input" type="radio" value="1"
								name="orderCheck" />
						</div>
					</c:if>

					<c:if test="${findBy.orderCheck=='1' }">
						<div id="u46" class="ax_单选按钮">
							<p id="u47">
								<span> 是</span>
							</p>
							<input id="u46_input" type="radio" value="0" 
								name="orderCheck" />
						</div>
						<div id="u48" class="ax_单选按钮">
							<p id="u49">
								<span> 否</span>
							</p>
							<input id="u48_input" type="radio" value="1"
								name="orderCheck" checked />
						</div>
					</c:if>
					<c:if test="${findBy.orderCheck !='1' && findBy.orderCheck !='0'}">
						<div id="u46" class="ax_单选按钮">
							<p id="u47">
								<span> 是</span>
							</p>
							<input id="u46_input" type="radio" value="0" name="u46"
								name="orderCheck" />
						</div>
						<div id="u48" class="ax_单选按钮">
							<p id="u49">
								<span> 否</span>
							</p>
							<input id="u48_input" type="radio" value="1"
								name="orderCheck"/>
						</div>
					</c:if>
					<div id="u50" class="ax_文本段落">
						<p id="u51">
							<span>母子健康手册使用:</span>
						</p>
					</div>
					<div id="u52" class="ax_下拉列表框">
						<select id="u52_input" name="healthHandbook" >

							<c:if test="${findBy.healthHandbook=='0' }">
								<option value="0" selected>是</option>
								<option value="1">否</option>
							</c:if>
							<c:if test="${findBy.healthHandbook=='1' }">
								<option value="0">是</option>
								<option value="1" selected>否</option>
							</c:if>
							<c:if
								test="${findBy.healthHandbook !='1' && findBy.healthHandbook !='0'}">
								<option value="0">是</option>
								<option value="1">否</option>
							</c:if>
						</select>
					</div>
				</div>
				<div id="s10" name="foldDiv7" onclick="AutoFold('foldDiv8','u58',8)">
					<div id="u56" class="ax_形状" style="background-color: #009dd9">
						<p id="u57">
							<span>历史检查记录</span>
						</p>
					</div>

					<div id="u58" class="ax_文本段落">
						<!-- <p id="u59"><span>收起</span></p> -->
						<p id="u59">收起</p>
					</div>
				</div>
				<div id="s11" name="foldDiv8">
					<div id="u93" class="ax_形状">
						<p id="u94">
							<span>&nbsp;</span>
						</p>
					</div>
					<div id="u152" class="ax_动态面板">
						<!-- 可以下拉的框 -->
						<div id="u152_state0" class="panel_state" data-label="State1">
							<div id="u153" class="ax_形状">
								<p id="u154">
									<span>&nbsp;</span>
								</p>
							</div>
							<div id="u155" class="ax_表格">

								<table style="width:1173px">
									<tr>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">次数</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="100">
											<p>
												<span style="color: white; font-weight: bold;">检查日期</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">孕周</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="60">
											<p>
												<span style="color: white; font-weight: bold;">主诉</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="50">
											<p>
												<span style="color: white; font-weight: bold;">血压</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">体重</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">宫高</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">腹围</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">胎方位</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">胎心率</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">先露</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">浮肿</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">血红蛋白</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">尿蛋白</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">血糖</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="60">
											<p>
												<span style="color: white; font-weight: bold;">唐筛</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="60">
											<p>
												<span style="color: white; font-weight: bold;">NT</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="60">
											<p>
												<span style="color: white; font-weight: bold;">四维</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="60">
											<p>
												<span style="color: white; font-weight: bold;">B超</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="60">
											<p>
												<span style="color: white; font-weight: bold;">NST</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="100">
											<p>
												<span style="color: white; font-weight: bold;">其他（肝功、肾功、免疫）</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="40">
											<p>
												<span style="color: white; font-weight: bold;">高危评分</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="80">
											<p>
												<span style="color: white; font-weight: bold;">高危因素</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="50">
											<p>
												<span style="color: white; font-weight: bold;">分类</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="50">
											<p>
												<span style="color: white; font-weight: bold;">转诊</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="100">
											<p>
												<span style="color: white; font-weight: bold;">下次随访日期</span>
											</p>
										</td>

										<!-- Unnamed (单元格) -->
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="60">
											<p>
												<span style="color: white; font-weight: bold;">产检检查单位</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="50">
											<p>
												<span style="color: white; font-weight: bold;">随访医生</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="60">
											<p>
												<span style="color: white; font-weight: bold;">指导</span>
											</p>
										</td>
										<td
											style="background-color: #999999; border: 0.5px solid #FFF"
											width="50">
											<p>
												<span style="color: white; font-weight: bold;">操作</span>
											</p>
										</td>
									</tr>
									<!--  --------------------------------------------------------------------------------  -->
									<!-- ----------------需要遍历的历史检查记录-------------------------------- -->
									<%
										int i = 1;
									%>
									<c:forEach items="${historyChecks }" var="historyCheck">
										<!-- Unnamed (单元格) -->
										<tr>
											<td style="border: 0.5px solid #A6A6A6">
												<p>
													<span><%=i++%></span>
												</p>
											</td>
											<c:if test="${historyCheck.checkDate!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span><fmt:formatDate
																value="${historyCheck.checkDate }" pattern="yyyyMMdd" /></span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.checkDate==null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.pregnancyWeeks!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.pregnancyWeeks }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.pregnancyWeeks==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.chiefComplaint!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.chiefComplaint }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.chiefComplaint==null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if
												test="${historyCheck.bloodLow!=null || historyCheck.bloodHi!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.bloodHi }/${historyCheck.bloodLow }</span>
													</p>
												</td>
											</c:if>
											<c:if
												test="${historyCheck.bloodLow==null && historyCheck.bloodHi==null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.weight!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.weight }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.weight==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.uterusHight!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.uterusHight }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.uterusHight==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.abdomen!=null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.abdomen }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.abdomen==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>

											<c:if test="${historyCheck.fetusPosition!=null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.fetusPosition }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.fetusPosition==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>

											<c:if test="${historyCheck.heartRate!=null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.heartRate }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.heartRate==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.present!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.present }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.present==null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.edema!=null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.edema }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.edema==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.hemoglobin!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.hemoglobin }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.hemoglobin==null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.proteinuria!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.proteinuria }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.proteinuria==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.bloodGlucose!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.bloodGlucose }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.bloodGlucose==null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.tangSyndrome==0 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>未检查</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.tangSyndrome==1 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>无异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.tangSyndrome==2}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.tangSyndrome==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>

											<c:if test="${historyCheck.NT==0 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>未检查</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.NT==1 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>无异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.NT==2}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.NT==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.fourDimensional==0 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>未检查</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.fourDimensional==1 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>无异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.fourDimensional==2}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.fourDimensional==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>

											<c:if test="${historyCheck.bScan==0 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>未检查</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.bScan==1 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>无异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.bScan==2}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.bScan==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.NST==0 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>未检查</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.NST==1 }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>无异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.NST==2}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.NST==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.others!=null}">
												<td style="border: 0.5px solid #A6A6A6">
													<div class="autocut"
														onmouseover="this.className='autocut1'"
														onmouseout="this.className='autocut'">${historyCheck.others }</div>
												</td>

											</c:if>
											<c:if test="${historyCheck.others==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.score!=null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.score }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.score==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>

											<c:if test="${historyCheck.highRisk!=null}">
												<td style="border: 0.5px solid #A6A6A6">
													<div class="autocut"
														onmouseover="this.className='autocut1'"
														onmouseout="this.className='autocut'">${historyCheck.highRisk }</div>
												</td>
											</c:if>
											<c:if test="${historyCheck.highRisk==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if
												test="${historyCheck.evaluate==0 || historyCheck.evaluate==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>未见异常</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.evaluate==1}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>异常</span>
													</p>
												</td>
											</c:if>

											<c:if
												test="${historyCheck.referral==0 || historyCheck.referral==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.referral==1}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>转诊</span>
													</p>
												</td>
											</c:if>

											<c:if test="${historyCheck.nextFollowingDate!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span><fmt:formatDate
																value="${historyCheck.nextFollowingDate }"
																pattern="yyyyMMdd" /></span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.nextFollowingDate==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>

											<c:if test="${historyCheck.hospital!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.hospital }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.hospital==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>

											<c:if test="${historyCheck.doctorName!=null }">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>${historyCheck.doctorName }</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.doctorName==null}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>

											<c:if
												test="${historyCheck.guidance!=null && historyCheck.guidance!=''}">
												<td style="border: 0.5px solid #A6A6A6">
													<div class="autocut"
														onmouseover="this.className='autocut1'"
														onmouseout="this.className='autocut'">${historyCheck.guidance }</div>
												</td>
											</c:if>
											<c:if
												test="${historyCheck.guidance==null || historyCheck.guidance==''}">
												<td style="border: 0.5px solid #A6A6A6">
													<p>
														<span>-</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.type==1}">
												<td
													style="background-color: #009DD9; border: 0.5px solid #A6A6A6"
													onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaDetails?archiveId=${archiveId}&postpartumExaId=${historyCheck.checkId}'">
													<p>
														<span>详情</span>
													</p>
												</td>
											</c:if>
											<c:if test="${historyCheck.type==0}">
												<!-- Unnamed (单元格) -->
												<td
													style="background-color: #009DD9; cursor: pointer; border: 0.5px solid #A6A6A6"
													onclick="window.location.href='${ctx}/prenatal/prenatalExaDetails?prenatalId=${historyCheck.checkId}&count=<%=i-1 %>'">
													<p>
														<span>详情</span>
													</p>
												</td>
											</c:if>
										</tr>
									</c:forEach>
								</table>
								<!--  --------------------------------------------------------------------------------  -->
							</div>
						</div>
					</div>
				</div>
		</form>
	<div id="closeExa" class="easyui-dialog" title="角色" closed="true">
		<form id="closeForm" action="${ctx}/archivesinfo/endNote" method="post">
		<input type="hidden" id ="archiId" name="archiId" value="${ArchivesInfoPO.id }"/>
		<input type="hidden" id ="birthArchiveId" name="birthArchiveId" value="${birthArchives.id }"/>
		<div id="jau6" class="ax_文本段落">
          <p id="jau7"><span>请选择结案原因：</span></p>
      	</div>
        <div id="jau10" class="ax_单选按钮">
            <label for="u10_input">
                <p id="jau11"><span> 流产</span></p>
            </label>
            <input id="jau10_input" type="radio" value="0" name="closingReason"/>
      	</div>
        <div id="jau12" class="ax_单选按钮">
            <label for="u12_input">
                <p id="jau13"><span> 引产</span></p>
            </label>
            <input id="jau12_input" type="radio" value="1" name="closingReason"/>
      	</div>
         <div id="jau14" class="ax_单选按钮">
            <label for="u14_input">
                <p id="jau15"><span> 失访</span></p>
            </label>
            <input id="jau14_input" type="radio" value="2" name="closingReason"/>
      	</div>
        
         <div id="jau16" class="ax_单选按钮">
            <label for="u16_input">
                <p id="jau17"><span> 其他</span></p>
            </label>
            <input id="jau16_input" type="radio" value="3" name="closingReason"/>
      	</div>
        <div id="jau4" class="ax_形状" style="background-color:#e9854f">
          <p id="jau5" style="cursor:pointer;"><span>确定</span></p>
      	</div>
        <div id="jau2" class="ax_形状" style="background-color:#009DD9">
          <p id="jau3" style="cursor:pointer;"><span>取消</span></p>
      	</div>
     </form>
    </div>
    <div id="addZhuan" style="overflow:auto" class="easyui-dialog" title="角色" closed="true">
		<div id="cssAuto" style="overflow-y: auto;OVERFLOW-X:hidden;width: 860px;height: 620px;position: absolute;top: 0px;">
		<form  id="saveCheck"  method="post">
		<input id="birthArchivesId" type="hidden" name="birthArchivesId" value="${birthArchives.id}"/>
        <div id="u02" class="ax_文本段落">
          <p id="u03"><span>转归：</span></p>
        </div>
        <div id="u00" class="ax_形状">
			<p id="u01">
				<span> </span>
			</p>
		</div>
        <div id="u04" class="ax_下拉列表框">
            <select id="u04_input" name="lapseTo" >
              <option value="2">结束分娩</option>
              <option value="1">正常随访</option>
              <option selected value="0">继续监护</option>
            </select>
      	</div>
        <div id="u032" class="ax_形状" style="background-color:#999999">
          <p id="u033"><span>本次检查结果</span></p>
      	</div>
		<div id="u06" class="ax_多行文本框">
        	<textarea id="u06_input" style="height: 104px;" name="result"></textarea>
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

</body>
</html>
