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
    <title>第1次产前随访记录表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/first_prenataldetail_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
      
    	$(function(){
    		
    		$("#u38").click();
    		$("#u148").click();
    		$("#u235").click();
    		$("#u259").click();
    		$("#u421").click();
    		$("#u432").click();
    		$("#u437").click();
    		
			//总体评估有异常和无异常显示的和不显示的
			window.onload = function(){
				var radios = $("input[name='evaluate']");
				for (var i = 0; i < radios.length; i++) {
					radios[i].onclick = function(){
						var status = $("input[name='evaluate']:checked").val();
						if(status == 0){
							$("#u431").css("display","none");
							$("#u481").css("display","none");
							$("#u17").css("color","#000000");
							$("#u19").css("color","#000000");
							
						}else{
							$("#u431").css("display","block");
							$("#u481").css("display","block");
							$("#u17").css("color","#EE5F45");
							$("#u19").css("color","#EE5F45");
						}
					};
				}
			};
			
			
			//编辑
			/* $("#u480").click(function(){
				var finishUrl = "${ctx}/prenatal/finishFirstExa";
				
				$.ajax({
   					url:finishUrl,
   					type:"POST",
   					data:$('#form').serialize(),
   					success:function(data){
   						$("#prenatalId").val(data.prenatalId);
   		  	  			showDialog_("提示","finishTan","moremiddle",false);
   					}
   				});
				
			});
			 

			*/
			
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
		<div id="title" class="ax_形状" style="background-color: #FFFFFF;border: 1px solid #CCCCCC;">
        	
            <div id="u475" class="ax_形状" style="background-color:#EE5F45">
       		  <p id="u476"><span>第1次产前随访记录</span></p>
      		</div>
      		<c:if test="${map.birthArchives.riskSign == '1'}">
          		<div id="u4790" style="background-color:#EE5F45"><p onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${map.birthArchives.id }&archivesId=${map.birthArchives.archivesId }'" id="u4800" style="cursor:pointer">专案记录</p></div>
            </c:if>
            <c:if test="${map.birthArchives.pregnantState != '2' }">
            <c:if test="${operatorPO.id == operator.id || operator.id == adminId || operator.id == doctorAdminId}">
	            <div id="u479" class="ax_形状" style="background-color:#56BB4D">
	          		<p id="u480" style="cursor:pointer" onclick="window.location.href='${ctx}/prenatal/firstPrenatalEdit?prenatalId=${map.prenatalExa.id}'"><span>编辑</span></p>
	      		</div>
      		</c:if>
      		</c:if>
      		<%-- <div id="u47900" style="background-color:#009DD9"><p style="cursor:pointer" id="u48000" onclick="window.location.href='${ctx}/prenatal/printPreview?prenatalId=${map.prenatalExa.id }'">产前随访记录表</p></div> --%>
        <div id="u3610" onclick="window.location.href='${ctx}/prenatal/printPreview?prenatalId=${map.prenatalExa.id }&go=0'" class="ax_形状" style="cursor: pointer;background-color: #009Ed7">
			<p id="u3620">
				<span>产前随访记录表</span>
			</p>
		</div>
		<div id="u3630" onclick="window.location.href='${ctx}/prenatal/printPreview?prenatalId=${map.prenatalExa.id }&go=1'" class="ax_形状" style="cursor: pointer;background-color: #009Ed7">
			<p id="u3640">
			<span>产前检查反馈单</span></p>
			</div>
        </div>
        
        <div id="">
        	
            <div id="u32" class="ax_文本段落">
          		<p id="u33"><span>检查医院：${operatorPO.department }</span></p>
      		</div>
            
            <div id="u34" class="ax_文本段落">
          		<p id="u35"><span>检查医生:${operatorPO.realName }</span></p>
      		</div>
            
            <div id="u36" class="ax_文本段落">
            	<c:if test="${map.birthArchives.referralSign != '0'}">
          			<p id="u37"><span>转诊状态：转诊</span></p>
          		</c:if>
            	<c:if test="${map.birthArchives.referralSign == '0' }">
          			<p id="u37"><span>转诊状态：本院</span></p>
          		</c:if>
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
        	
            <div id="u16" class="ax_文本段落" <c:if test="${map.birthArchives.riskSign == '1' }">style="color:#EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if>>
       		  <p id="u17"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${map.archives.name } </span></p>
      		</div>
            <div id="u18" class="ax_文本段落" <c:if test="${map.birthArchives.riskSign == '1' }">style="color:#EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if>>
       		  <p id="u19"><span>档案编号：${map.archives.archivesCode }</span></p>
      		</div>
            <div id="u30" class="ax_文本段落">
          		<p id="u31"><span>检查日期：<fmt:formatDate value="${map.prenatalExa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u8" class="ax_文本段落">
       		  <p id="u9"><span>出生日期：<fmt:formatDate value="${map.archives.birthday }" pattern="yyyy-MM-dd"/> </span></p>
      		</div>
            <div id="u20" class="ax_文本段落">
          		<p id="u21"><span>孕妇年龄：${map.age }</span></p>
      		</div>
            <div id="u10" class="ax_文本段落">
          		<p id="u11"><span>联系电话：${map.archives.telephone }</span></p>
      		</div>
            
            <div id="u22" class="ax_文本段落">
       		  <p id="u23"><span>丈夫姓名：${map.archives.manName }</span></p>
      		</div>
            <div id="u24" class="ax_文本段落">
          		<p id="u25"><span>丈夫年龄：${map.manAge }</span></p>
      		</div>
            <div id="u26" class="ax_文本段落">
          		<p id="u27"><span>丈夫电话：${map.archives.manTele }</span></p>
      		</div>
        
        </div>
        
        <div id="u38" name="foldDiv1" onclick="AutoFold('foldDiv2','u41',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u39"><span>孕 产 信 息</span></p>
          <p id="u41" style="left: 1126px;top: 5px;"><span>收起</span></p>
        </div>
        <!-- <div id="u40" class="ax_文本段落">
          
      	</div> -->
        
        <div id="" name="foldDiv2" style="height: 329px">
        	
            <div id="u61" class="ax_文本段落">
       		  <p id="u62"><span>孕周：</span></p>
          	</div>
          	<div id="u63" class="ax_文本框">
          		<p id="u63_input">${map.motherhood.pregnancyWeeks }</p>
          	</div>
          	<div id="u64" class="ax_文本段落">
           	  <p id="u65"><span>周</span></p>
          	</div>
          	<div id="u74" class="ax_文本框">
            	<p id="u74_input">${map.motherhood.pregnancyDays }</p>
            </div>
          	<div id="u66" class="ax_文本段落">
           	  <p id="u67"><span>天</span></p>
          	</div>
            
            <div id="u42" class="ax_文本段落">
       		  <p id="u43"><span>末次月经：</span></p>
      		</div>
            <div id="u75" class="ax_下拉列表框">
        		<p id="u75_input"><fmt:formatDate value="${map.birthArchives.lastMenses }" pattern="yyyy-MM-dd"/></p>
      		</div>
            
            <div id="u44" class="ax_文本段落">
          		<p id="u45"><span>预产期： </span><fmt:formatDate value="${map.expectedDate }" pattern="yyyy-MM-dd"/></p>
      		</div>
            
            <div id="u46" class="ax_文本段落">
       		  <p id="u47"><span>孕次：</span></p>
      		</div>
            <div id="u48" class="ax_下拉列表框">
        		<p id="u48_input">${map.motherhood.pregnancyNum }</p>
      		</div>
            <div id="u71" class="ax_文本段落">
          		<p id="u72" ><span>次</span></p>
      		</div>
            
            <div id="u49" class="ax_文本段落">
          		<p id="u50"><span>产次：</span></p>
      		</div>
            <div id="u68" class="ax_下拉列表框">
        		<p id="u68_input">${map.motherhood.bearNum}</p>
     		</div>
            <div id="u69" class="ax_文本段落">
          		<p id="u70"><span>次</span></p>
      		</div>
            
            <div id="u53" class="ax_文本段落">
          		<p id="u54"><span>阴道分娩：</span></p>
      		</div>
            <div id="u51" class="ax_下拉列表框">
        		<p id="u51_input">${map.motherhood.eutociaNum}</p>
      		</div>
            <div id="u55" class="ax_文本段落">
          		<p id="u56"><span>次</span></p>
      		</div>
            
            <div id="u57" class="ax_文本段落">
          		<p id="u58"><span>剖宫产：</span></p>
      		</div>
            <div id="u52" class="ax_下拉列表框">
        		<p id="u52_input">${map.motherhood.cesareanNum}</p>
      		</div>
            <div id="u59" class="ax_文本段落">
          		<p id="u60"><span>次</span></p>
      		</div>
            
            <div id="u76" class="ax_文本段落">
          		<p id="u77"><span>早产：</span></p>
      		</div>
          <div id="u78" class="ax_下拉列表框">
       		<p id="u78_input">${map.motherhood.prebearNum}</p>
       		</div>
            <div id="u90" class="ax_文本段落">
          		<p id="u91"><span>次</span></p>
      		</div>
            
            <div id="u79" class="ax_文本段落">
          		<p id="u80"><span>自然流产：</span></p>
     		</div>
            <div id="u87" class="ax_下拉列表框">
                <p id="u87_input">${map.motherhood.naturalAbortionNum}</p>
      		</div>
            <div id="u88" class="ax_文本段落">
          		<p id="u89"><span>次</span></p>
      		</div>
            
            <div id="u83" class="ax_文本段落">
          		<p id="u84"><span>人流：</span></p>
      		</div>
            <div id="u81" class="ax_下拉列表框">
                <p id="u81_input">${map.motherhood.inducedAbortionNum}</p>
      		</div>
            <div id="u92" class="ax_文本段落">
          		<p id="u93"><span>次</span></p>
      		</div>
            
            <div id="u85" class="ax_文本段落">
          		<p id="u86"><span>药流：</span></p>
      		</div>
            <div id="u82" class="ax_下拉列表框">
                <p id="u82_input">${map.motherhood.drugAbortionNum}</p>
      		</div>
            <div id="u94" class="ax_文本段落">
          		<p id="u95"><span>次</span></p>
      		</div>
            
            <div id="u97" class="ax_文本段落">
          		<p id="u98"><span>宫外孕：</span></p>
   		  </div>
            <div id="u96" class="ax_下拉列表框">
                <p id="u96_input">${map.motherhood.exfetationNum}</p>
      		</div>
            <div id="u99" class="ax_文本段落">
          		<p id="u100"><span>次</span></p>
      		</div>
            
            <div id="u102" class="ax_文本段落">
          		<p id="u103"><span>中期引产：</span></p>
      		</div>
            <div id="u101" class="ax_下拉列表框">
                <p id="u101_input">${map.motherhood.inducelabourNum}</p>
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
                <p id="u116_input">${map.motherhood.abortionNum}</p>
      		</div>
            <div id="u117" class="ax_文本段落">
          		<p id="u118"><span>次</span></p>
      		</div>
            
            <div id="u112" class="ax_文本段落">
          		<p id="u113"><span>死胎：</span></p>
      		</div>
            <div id="u110" class="ax_下拉列表框">
            	<p id="u110_input">${map.motherhood.deadfetusNum}</p>
            </div>
            <div id="u119" class="ax_文本段落">
          		<p id="u120"><span>次</span></p>
      		</div>
            
            <div id="u114" class="ax_文本段落">
          		<p id="u115"><span>死产：</span></p>
      		</div>
            <div id="u111" class="ax_下拉列表框">
                <p id="u111_input">${map.motherhood.stillbirthNum}</p>
      		</div>
            <div id="u121" class="ax_文本段落">
          		<p id="u122"><span>次</span></p>
      		</div>
            
            <div id="u124" class="ax_文本段落">
          		<p id="u125"><span>新生儿死亡：</span></p>
      		</div>
            <div id="u123" class="ax_下拉列表框">
                <p id="u123_input">${map.motherhood.newbornDieNum}</p>
      		</div>
            <div id="u126" class="ax_文本段落">
          		<p id="u127"><span>次</span></p>
      		</div>
            
            <div id="u129" class="ax_文本段落">
          		<p id="u130"><span>出生儿缺陷：</span></p>
      		</div>
            <div id="u128" class="ax_下拉列表框">
              <p id="u128_input">${map.motherhood.defectNum}</p>
      		</div>
            <div id="u131" class="ax_文本段落">
          		<p id="u132"><span>次</span></p>
      		</div>
            
            <div id="u133" class="ax_文本段落">
          		<p id="u134"><span>产后出血：</span></p>
      		</div>
            <div id="u141" class="ax_下拉列表框">
                <p id="u141_input">${map.motherhood.bleedingNum}</p>
            </div>
            <div id="u142" class="ax_文本段落">
          		<p id="u143"><span>次</span></p>
      		</div>
            
            <div id="u137" class="ax_文本段落">
          		<p id="u138"><span>双胎：</span></p>
      		</div>
			<div id="u135" class="ax_下拉列表框">
                <p id="u135_input">${map.motherhood.twinsNum}</p>
      		</div>
            <div id="u144" class="ax_文本段落">
          		<p id="u145"><span>次</span></p>
      		</div>
            
            <div id="u139" class="ax_文本段落">
          		<p id="u140"><span>畸形：</span></p>
      		</div>
			<div id="u136" class="ax_下拉列表框">
                <p id="u136_input">${map.motherhood.deformityNum}</p>
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
            	<c:forEach items="${map.historys }" var = "history">
               		<c:if test="${history == '0' }">无</c:if>
               		<c:if test="${history == '1' }">心脏病</c:if>
               		<c:if test="${history == '2' }">肾脏疾病</c:if>
               		<c:if test="${history == '3' }">肝脏疾病</c:if>
               		<c:if test="${history == '4' }">高血压</c:if>
               		<c:if test="${history == '5' }">贫血</c:if>
               		<c:if test="${history == '6' }">糖尿病</c:if>
               		<c:if test="${history == '7' }">其它&nbsp;${map.motherhood.historyOthers }</c:if>
               	</c:forEach>
          	</div>
            
            <div id="u169" class="ax_文本段落">
          		<p id="u170"><span>家族史</span><span>：</span></p>
      		</div>
            <div id="u191" class="ax_复选框">
      			<c:forEach items="${map.famHistorys }" var="famHistory">
                 	<c:if test="${famHistory == '0' }">无</c:if>
                 	<c:if test="${famHistory == '1' }">遗传性疾病史&nbsp;${map.motherhood.heredityRelation }</c:if>
                 	<c:if test="${famHistory == '2' }">精神疾病史&nbsp;${map.motherhood.mentalRelation }</c:if>
                 	<c:if test="${famHistory == '3' }">其它&nbsp;${map.motherhood.famHistoryOthers }</c:if>
               	</c:forEach>
      		</div>
            
            <div id="u185" class="ax_文本段落">
          		<p id="u186"><span>个人史：</span></p>
      		</div>
            <div id="u193" class="ax_复选框">
      			<c:forEach items="${map.perHistorys }" var="perHistory">
                	<c:if test="${perHistory == '0' }">无</c:if>
                	<c:if test="${perHistory == '1' }">吸烟</c:if>
                	<c:if test="${perHistory == '2' }">饮酒</c:if>
                	<c:if test="${perHistory == '3' }">服用药物</c:if>
                	<c:if test="${perHistory == '4' }">接触有毒有害物质</c:if>
                	<c:if test="${perHistory == '5' }">接触放射线</c:if>
                	<c:if test="${perHistory == '6' }">其它&nbsp;${map.motherhood.perHistoryOthers }</c:if>
              	</c:forEach>
      		</div>
            
            <div id="u187" class="ax_文本段落">
          		<p id="u188"><span>妇科手术史：</span></p>
      		</div>
            <div id="u203" class="ax_下拉列表框">
           		<c:if test="${map.motherhood.operation == '0' }">无</c:if>
           		<c:if test="${map.motherhood.operation == '1' }">有&nbsp;${map.motherhood.operationRemark }</c:if>
      		</div>
            
            <div id="u195" class="ax_文本段落">
          		<p id="u196"><span>药物过敏史：</span></p>
      		</div>
            <div id="u205" class="ax_下拉列表框">
                <c:if test="${map.motherhood.allergy == '0' }">无</c:if>
           		<c:if test="${map.motherhood.allergy == '1' }">有&nbsp;${map.motherhood.allergyRemark }</c:if>
      		</div>
        </div>
        
        <div id="u148" name="foldDiv3" onclick="AutoFold('foldDiv4','u151',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u149"><span>体 格 / 血 压 / 听 诊 检 查</span></p>
          <p id="u151" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        <!-- <div id="u150" class="ax_文本段落">
          
      	</div> -->
        
        <div id="" name="foldDiv4" style="height: 78px">
        	
            <div id="u217" class="ax_文本段落">
          		<p id="u218"><span>身高：</span></p>
      		</div>
            <div id="u219" class="ax_文本框">
        		<p id="u219_input">${map.bloodStethos.height }</p>
      		</div>
            <div id="u220" class="ax_文本段落">
         		<p id="u221"><span>cm</span></p>
      		</div>
            
            <div id="u222" class="ax_文本段落">
          		<p id="u223"><span>体重：</span></p>
      		</div>
            <div id="u224" class="ax_文本框">
        		<p id="u224_input">${map.bloodStethos.weight }</p>
      		</div>
            <div id="u225" class="ax_文本段落">
          		<p id="u226"><span>kg</span></p>
      		</div>
            <div id="u207" class="ax_文本段落">
          		<p id="u208"><span>体质指数：${map.bmi }</span></p>
      		</div>
            
            <div id="u209" class="ax_文本段落">
          		<p id="u210"><span>血压：</span></p>
      		</div>
            <div id="u227" class="ax_文本框">
        		<p id="u227_input">${map.bloodStethos.bloodHi }</p>
      		</div>
            <div id="u228" class="ax_文本段落">
          		<p id="u229"><span>/</span></p>
      		</div>
            <div id="u230" class="ax_文本框">
        		<p id="u230_input">${map.bloodStethos.bloodLow }</p>
      		</div>
            <div id="u211" class="ax_文本段落">
          		<p id="u212"><span>mmHg</span></p>
      		</div>
            
            <div id="u213" class="ax_文本段落">
          		<p id="u214"><span>心脏：</span></p>
      		</div>
            <div id="u231" class="ax_下拉列表框">
                <p id="u231_input">
                 	<c:if test="${map.bloodStethos.heart == '0' }">未见异常</c:if>
          			<c:if test="${map.bloodStethos.heart == '1' }">异常</c:if>
                </p>
      		</div>
            <div id="u232" class="ax_文本框">
        		<p id="u232_input">${map.bloodStethos.heartRemark }</p>
      		</div>
            
            <div id="u215" class="ax_文本段落">
          		<p id="u216"><span>肺部：</span></p>
      		</div>
            <div id="u233" class="ax_下拉列表框">
                <p id="u233_input">
                	<c:if test="${map.bloodStethos.lung == '0' }">未见异常</c:if>
          			<c:if test="${map.bloodStethos.lung == '1' }">异常</c:if>
                </p>
      		</div>
            <div id="u234" class="ax_文本框">
        		<p id="u234_input">${map.bloodStethos.lungRemark }</p>
      		</div>
        
        </div>
        
        
        <div id="u235" name="foldDiv5" onclick="AutoFold('foldDiv6','u238',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u236"><span>妇 科 检 查</span></p>
          <p id="u238" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        <!-- <div id="u237" class="ax_文本段落">
          
      	</div> -->
        
        <div id="" name="foldDiv6" style="height: 111px">
        	
            <div id="u239" class="ax_文本段落">
          		<p id="u240"><span>外阴：</span></p>
      		</div>
            <div id="u249" class="ax_下拉列表框">
                <p id="u249_input">
                	<c:if test="${map.gynecologcal.outerVulva == '0' }">未见异常</c:if>
          			<c:if test="${map.gynecologcal.outerVulva == '2' }">未检查</c:if>
          			<c:if test="${map.gynecologcal.outerVulva == '1' }">异常</c:if>
                </p>
      		</div>
            <div id="u250" class="ax_文本框">
        		<p id="u250_input">${map.gynecologcal.outerVulvaRemark }</p>
      		</div>
            
            <div id="u241" class="ax_文本段落">
          		<p id="u242"><span>阴道：</span></p>
      		</div>
            <div id="u251" class="ax_下拉列表框">
                <p id="u251_input">
                	<c:if test="${map.gynecologcal.vagina == '0' }">未见异常</c:if>
          			<c:if test="${map.gynecologcal.vagina == '2' }">未检查</c:if>
          			<c:if test="${map.gynecologcal.vagina == '1' }">异常</c:if>
                </p>
      		</div>
            <div id="u252" class="ax_文本框">
        		<p id="u252_input">${map.gynecologcal.vaginaRemark }</p>
      		</div>
            
            <div id="u245" class="ax_文本段落">
          		<p id="u246"><span>子宫：</span></p>
      		</div>
            <div id="u253" class="ax_下拉列表框">
                <p id="u253_input">
                	<c:if test="${map.gynecologcal.uterus == '0' }">未见异常</c:if>
          			<c:if test="${map.gynecologcal.uterus == '3' }">未检查</c:if>
          			<c:if test="${map.gynecologcal.uterus == '2' }">正常孕期</c:if>
          			<c:if test="${map.gynecologcal.uterus == '1' }">异常&nbsp;</c:if>
                </p>
      		</div>
            <div id="u254" class="ax_文本框">
        		<p id="u254_input">${map.gynecologcal.uterusRemark }</p>
      		</div>
            
            <div id="u243" class="ax_文本段落">
          		<p id="u244"><span>宫颈：</span></p>
      		</div>
            <div id="u255" class="ax_下拉列表框">
                <p id="u255_input">
                	<c:if test="${map.gynecologcal.uterineNeck == '0' }">未见异常</c:if>
          			<c:if test="${map.gynecologcal.uterineNeck == '2' }">未检查</c:if>
          			<c:if test="${map.gynecologcal.uterineNeck == '1' }">异常</c:if>
                </p>
      		</div>
            <div id="u256" class="ax_文本框">
        		<p id="u256_input">${map.gynecologcal.uterineNeckRemark }</p>
      		</div>
            
            <div id="u247" class="ax_文本段落">
          		<p id="u248"><span>附件：</span></p>
      		</div>
            <div id="u257" class="ax_下拉列表框">
                <p id="u257_input">
                	<c:if test="${map.gynecologcal.appendix == '0' }">未见异常</c:if>
          			<c:if test="${map.gynecologcal.appendix == '2' }">未检查</c:if>
          			<c:if test="${map.gynecologcal.appendix == '1' }">异常</c:if>
                </p>
      		</div>
            <div id="u258" class="ax_文本框">
        		<p id="u258_input">${map.gynecologcal.appendixRemark }</p>
      		</div>
        
        </div>
        
        <div id="u259" name="foldDiv7" onclick="AutoFold('foldDiv8','u262',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u260"><span>辅 助 检 查</span></p>
          <p id="u262" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
        <!-- <div id="u261" class="ax_文本段落">
          
      	</div> -->
        
        <div id="" name="foldDiv8" style="height: 563px">
        	
            <div id="u273" class="ax_文本段落">
          		<p id="u274"><span>血常规：</span></p>
      		</div>
            
            <div id="u263" class="ax_文本段落">
          		<p id="u264"><span>血红蛋白值：</span></p>
      		</div>
            <div id="u358" class="ax_文本框">
        		<p id="u358_input">${map.supplemetnaryExam.hemoglobin}</p>
     		</div>
            <div id="u265" class="ax_文本段落">
          		<p id="u266"><span style="font-family:'Arial Normal', 'Arial';font-weight:400;color:#333333;">g/L</span></p>
            </div>
            <div id="u267" class="ax_文本段落">
          		<p id="u268"><span>白细胞计数值：</span></p>
      		</div>
            <div id="u359" class="ax_文本框">
        		<p id="u359_input">${map.supplemetnaryExam.leucocyte}</p>
      		</div>
            <div id="u349" class="ax_文本段落">
          		<p id="u350"><span>×10^9/L</span></p>
      		</div>
            
            <div id="u269" class="ax_文本段落">
          		<p id="u270"><span>血小板计数值：</span></p>
      		</div>
            <div id="u360" class="ax_文本框">
        		<p id="u360_input">${map.supplemetnaryExam.platelet}</p>
      		</div>
            <div id="u271" class="ax_文本段落">
          		<p id="u272"><span>×10^9/L</span></p>
      		</div>
            
            
            <div id="u356" class="ax_文本段落">
          		<p id="u357"><span>其他：</span></p>
      		</div>
            <div id="u355" class="ax_文本框">
        		<p id="u355_input">${map.supplemetnaryExam.bloodOthers}</p>
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
        		<p id="u377_input">${map.supplemetnaryExam.urineSugar}</p>
      		</div>
            <div id="u371" class="ax_文本段落">
          		<p id="u372"><span>mmol/L</span></p>
      		</div>
            
            <div id="u365" class="ax_文本段落">
          		<p id="u366"><span>尿酮体：</span></p>
      		</div>
            <div id="u378" class="ax_文本框">
        		<p id="u378_input">${map.supplemetnaryExam.ketone}</p>
      		</div>
            <div id="u373" class="ax_文本段落">
          		<p id="u374"><span>mmol/L</span></p>
      		</div>
            
            <div id="u361" class="ax_文本段落">
          		<p id="u362"><span>尿蛋白：</span></p>
      		</div>
            <div id="u379" class="ax_文本框">
        		<p id="u379_input">${map.supplemetnaryExam.proteinuria}</p>
      		</div>
            <div id="u369" class="ax_文本段落">
          		<p id="u370"><span>g/L</span></p>
      		</div>
            
            <div id="u367" class="ax_文本段落">
          		<p id="u368"><span>尿潜血：</span></p>
      		</div>
            <div id="u380" class="ax_文本框">
        		<p id="u380_input">${map.supplemetnaryExam.urineBlood}</p>
      		</div>
            <div id="u375" class="ax_文本段落">
          		<p id="u376"><span>cells/u</span></p>
      		</div>
            
            <div id="u382" class="ax_文本段落">
          		<p id="u383"><span>其他：</span></p>
      		</div>
            <div id="u381" class="ax_文本框">
        		<p id="u381_input">${map.supplemetnaryExam.urineOthers}</p>
      		</div>
            
            <div id="u486" class="ax_水平线">
        		<hr id="u486_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      		</div>
            
            <div id="u277" class="ax_文本段落">
          		<p id="u278"><span>血型：</span></p>
      		</div>
            <div id="u384" class="ax_下拉列表框">
                <p id="u384_input">
                	<c:if test="${map.supplemetnaryExam.bloodType == '0'}">A</c:if>
           			<c:if test="${map.supplemetnaryExam.bloodType == '1'}">B</c:if>
           			<c:if test="${map.supplemetnaryExam.bloodType == '2'}">AB</c:if>
           			<c:if test="${map.supplemetnaryExam.bloodType == '3'}">O</c:if>
                </p>
      		</div>
            
            <div id="u347" class="ax_文本段落">
          		<p id="u348"><span>RH：</span></p>
      		</div>
            <div id="u385" class="ax_下拉列表框">
                <p id="u385_input">
                	<c:if test="${map.supplemetnaryExam.bloodTypeRh == '0'}">Rh+</c:if>
            		<c:if test="${map.supplemetnaryExam.bloodTypeRh == '1'}">Rh-</c:if>
                </p>
      		</div>
            
            <div id="u386" class="ax_文本段落">
          		<p id="u387"><span>血糖：</span></p>
      		</div>
            <div id="u390" class="ax_文本框">
        		<p id="u390_input">${map.supplemetnaryExam.bloodGlucose}</p>
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
        		<p id="u401_input">${map.supplemetnaryExam.sgpt}</p>
      		</div>
            <div id="u279" class="ax_文本段落">
          		<p id="u280"><span>U/L</span></p>
      		</div>
            
            <div id="u393" class="ax_文本段落">
          		<p id="u394"><span>血清谷草转氨酶：</span></p>
      		</div>
            <div id="u402" class="ax_文本框">
        		<p id="u402_input">${map.supplemetnaryExam.sgot}</p>
      		</div>
            <div id="u281" class="ax_文本段落">
          		<p id="u282"><span>U/L</span></p>
      		</div>
            
            <div id="u395" class="ax_文本段落">
          		<p id="u396"><span>白蛋白：</span></p>
      		</div>
            <div id="u403" class="ax_文本框">
        		<p id="u403_input">${map.supplemetnaryExam.albumin}</p>
      		</div>
            <div id="u283" class="ax_文本段落">
          		<p id="u284"><span>g/L</span></p>
      		</div>
            
            <div id="u397" class="ax_文本段落">>
          		<p id="u398"><span>总胆红素：</span></p>
      		</div>
            <div id="u404" class="ax_文本框">
        		<p id="u404_input">${map.supplemetnaryExam.totalBilirubin}</p>
      		</div>
            <div id="u285" class="ax_文本段落">
          		<p id="u286"><span>μmol/L</span></p>
      		</div>
            
            <div id="u399" class="ax_文本段落">
          		<p id="u400"><span>结合胆红素：</span></p>
      		</div>
            <div id="u405" class="ax_文本框">
        		<p id="u405_input">${map.supplemetnaryExam.dbil}</p>
      		</div>
            <div id="u483" class="ax_文本段落">
          		<p id="u484"><span>μmol/L</span></p>
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
        		<p id="u406_input">${map.supplemetnaryExam.scr}</p>
      		</div>
            <div id="u293" class="ax_文本段落">
          		<p id="u294"><span>μmol/L</span></p>
      		</div>
            
            <div id="u295" class="ax_文本段落">
          		<p id="u296"><span>血尿素氮：</span></p>
      		</div>
            <div id="u407" class="ax_文本框">
        		<p id="u407_input">${map.supplemetnaryExam.bun}</p>
      		</div>
            <div id="u297" class="ax_文本段落">
          		<p id="u298"><span>mmol/L</span></p>
      		</div>
            
            <div id="u299" class="ax_文本段落">
          		<p id="u300"><span>阴道分泌物：</span></p>
      		</div>
            <div id="u301" class="ax_复选框">
                <c:forEach items="${map.vaginalFluids }" var="vagin">
          			<c:if test="${vagin == '0'}">未见异常</c:if>
          			<c:if test="${vagin == '1'}">滴虫</c:if>
          			<c:if test="${vagin == '2'}">假丝酵母菌</c:if>
          			<c:if test="${vagin == '3'}">其他</c:if>
         		</c:forEach>
      		</div>
            <div id="u408" class="ax_文本框">
        		<p id="u408_input">${map.supplemetnaryExam.vaginalFluidOthers}</p>
      		</div>
            
            <div id="u307" class="ax_文本段落">
          		<p id="u308"><span>阴道清洁度：</span></p>
      		</div>
            <div id="u351" class="ax_下拉列表框">
                <p id="u351_input">
                	<c:if test="${map.supplemetnaryExam.vaginalClean == '0'}">Ⅰ度</c:if>
           			<c:if test="${map.supplemetnaryExam.vaginalClean == '1'}">ⅠⅠ度</c:if>
           			<c:if test="${map.supplemetnaryExam.vaginalClean == '2'}">ⅠⅠⅠ度</c:if>
           			<c:if test="${map.supplemetnaryExam.vaginalClean == '3'}">Ⅳ度</c:if>
                <p>
      		</div>
            
            <div id="u309" class="ax_文本段落">
          		<p id="u310"><span>乙肝五项：</span></p>
      		</div>
            
            <div id="u311" class="ax_文本段落">
          		<p id="u312"><span>乙型肝炎表面抗原：</span></p>
      		</div>
            <div id="u327" class="ax_单选按钮">
                <c:if test="${map.supplemetnaryExam.hbsag == '0'}">阴性</c:if>
            	<c:if test="${map.supplemetnaryExam.hbsag == '1'}">阳性</c:if>
      		</div>
            
            <c:if test="${map.supplemetnaryExam.hbsag == '1'}">
	            <div id="u313" class="ax_文本段落">
	          		<p id="u314"><span>乙型肝炎表面抗体：</span></p>
	      		</div>
	            <div id="u331" class="ax_单选按钮">
	                <c:if test="${map.supplemetnaryExam.hbsab == '0'}">阴性</c:if>
	            	<c:if test="${map.supplemetnaryExam.hbsab == '1'}">阳性</c:if>
	      		</div>
	            
	            <div id="u319" class="ax_文本段落">
	          		<p id="u320"><span>乙型肝炎核心抗体：</span></p>
	      		</div>
	            <div id="u339" class="ax_单选按钮">
	                <c:if test="${map.supplemetnaryExam.hbeag == '0'}">阴性</c:if>
	            	<c:if test="${map.supplemetnaryExam.hbeag == '1'}">阳性</c:if>
	      		</div>
	            
	            <div id="u317" class="ax_文本段落">
	          		<p id="u318"><span>乙型肝炎e抗体：</span></p>
	      		</div>
	            <div id="u335" class="ax_单选按钮">
	               	<c:if test="${map.supplemetnaryExam.hbeab == '0'}">阴性</c:if>
	            	<c:if test="${map.supplemetnaryExam.hbeab == '1'}">阳性</c:if>
	      		</div>
	            
	            <div id="u315" class="ax_文本段落">
	          		<p id="u316"><span>乙型肝炎e抗原：</span></p>
	      		</div>
	            <div id="u343" class="ax_单选按钮">
	                <c:if test="${map.supplemetnaryExam.hbcab == '0'}">阴性</c:if>
	            	<c:if test="${map.supplemetnaryExam.hbcab == '1'}">阳性</c:if>
	      		</div>
            </c:if>
            <div id="u321" class="ax_文本段落">
          		<p id="u322"><span>梅毒血清学试验：</span></p>
      		</div>
            <div id="u411" class="ax_单选按钮">
                <c:if test="${map.supplemetnaryExam.syphilisSerology == '0'}">阴性</c:if>
            	<c:if test="${map.supplemetnaryExam.syphilisSerology == '1'}">阳性</c:if>
      		</div>
            
            <div id="u323" class="ax_文本段落">
          		<p id="u324"><span>HIV抗体检测：</span></p>
      		</div>
            <div id="u415" class="ax_单选按钮">
                <c:if test="${map.supplemetnaryExam.hivab == '0'}">阴性</c:if>
            	<c:if test="${map.supplemetnaryExam.hivab == '1'}">阳性</c:if>
      		</div>
            <div id="u325" class="ax_文本段落">
          		<p id="u326"><span>B超：</span></p>
      		</div>
             <div id="u420" class="ax_文本框">
                <p id="u420_input">
                	<c:if test="${map.supplemetnaryExam.bscan == '0'}">未检查</c:if>
         			<c:if test="${map.supplemetnaryExam.bscan == '1'}">无异常</c:if>
           			<c:if test="${map.supplemetnaryExam.bscan == '2'}">有异常</c:if>
                </p>
      		</div>
            <div id="u42400">
            	<p id="u42400_input">${map.supplemetnaryExam.bscanRemark}</p>
       	  	</div>
            
            <div id="u352" class="ax_文本段落">
          		<p id="u353"><span> NT：</span></p>
      		</div>
            <div id="u354" class="ax_下拉列表框">
                <p id="u354_input">
                	<c:if test="${map.supplemetnaryExam.nt == '0'}">未检查</c:if>
        			<c:if test="${map.supplemetnaryExam.nt == '1'}">无异常</c:if>
          			<c:if test="${map.supplemetnaryExam.nt == '2'}">有异常</c:if>
                </p>
      		</div>
            <div id="u419" class="ax_文本框">
        		<p id="u419_input">${map.supplemetnaryExam.ntRemark}</p>
      		</div>
            
            
        </div>
        
        <div id="u421" name="foldDiv9" onclick="AutoFold('foldDiv10','u424',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u422"><span>总 体 评 估</span></p>
          <p id="u424" style="left: 1126px;top: 5px;"><span>收起</span></p>
      	</div>
      <!-- <div id="u423" class="ax_文本段落">
          
      </div> -->
      
      <div id="" name="foldDiv10" style="height: 43px">
      	
        <div id="u425" class="ax_文本段落">
          <p id="u426"><span>总体评估：</span></p>
      	</div>
        <div id="u427" class="ax_单选按钮">
            <c:if test="${map.prenatalExa.evaluate == '0'}">未见异常</c:if>
     		<c:if test="${map.prenatalExa.evaluate == '1'}">异常&nbsp;
	     		<c:forEach items="${map.list}" var="item">
	     			${item };&nbsp;
	     		</c:forEach>
     		</c:if>
      	</div>
        <div id="u4310">
        	<p id="u43100"></p>
        </div>
              	
      </div>
      
      <div id="u432" name="foldDiv11" onclick="AutoFold('foldDiv12','u435',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u433"><span>保 健 指 导</span></p>
          <p id="u435" style="left: 1126px;top: 5px;"><span>收起</span></p>
      </div> 
      <!-- <div id="u434" class="ax_文本段落">
          
      </div> -->
      
      <div id="" name="foldDiv12" style="height: 171px">
      	
        <div id="u436" class="ax_多行文本框">
        	<p id="u436_input">${map.prenatalExa.guidance }</p>
      	</div>
      
      </div>
      
      <div id="u437" name="foldDiv13" onclick="AutoFold('foldDiv14','u440',14)" class="ax_形状" style="background-color:#009DD9">
          <p id="u438"><span>转 诊</span></p>
          <p id="u440" style="left: 1126px;top: 5px;"><span>收起</span></p>
      </div>
      <!-- <div id="u439" class="ax_文本段落">
          
      </div> -->
      
      <div id="" name="foldDiv14" style="height: 253px">
      
      	<div id="u441" class="ax_文本段落">
          <p id="u442"><span>转诊：</span></p>
      	</div>
        <div id="u443" class="ax_单选按钮">
            <c:if test="${map.prenatalReferral.referral == '0' }">无</c:if>
            <c:if test="${map.prenatalReferral.referral == '1' }">有</c:if>
      	</div>
        
        <div id="u447" class="ax_文本段落">
          <p id="u448" ><span>原因：</span></p>
      	</div>
        <div id="u449" class="ax_文本框">
        	<p id="u449_input">${map.prenatalReferral.reason}</p>
      	</div>
        
        <div id="u450" class="ax_文本段落">
          <p id="u451"><span>转诊机构：</span></p>
      	</div>
        <div id="u452" class="ax_下拉列表框">
            <p id="u452_input">
            	${departmentPO.name}
            </p>
      	</div>
        
        <div id="u453" class="ax_文本段落">
          <p id="u454"><span>转诊科室：</span></p>
      	</div>
        <div id="u455" class="ax_下拉列表框">
            <p id="u455_input">
            	${rolePO.name}
            </p>
      	</div>
        
        <div id="u456" class="ax_文本段落">
          <p id="u457"><span>下次随访日期：</span></p>
      	</div>
        <div id="u458" class="ax_下拉列表框">
            <p id="u458_input"><fmt:formatDate value="${map.prenatalReferral.nextFollowingDate}" pattern="yyyy-MM-dd"/></p>
      	</div>
        
        <div id="u459" class="ax_文本段落">
          <p id="u460"><span>是否预约下次检查：</span></p>
      	</div>
        <div id="u461" class="ax_单选按钮">
            <c:if test="${map.prenatalReferral.orderCheck == '0' }">否</c:if>
            <c:if test="${map.prenatalReferral.orderCheck == '1' }">是</c:if>
      	</div>
        
        <div id="u474" class="ax_水平线">
        	<hr id="u474_line" style="height:1px;border:none;border-top:1px solid #999999;"/>
      	</div>
        
        <div id="u465" class="ax_文本段落">
          <p id="u466"><span>母子健康手册使用：</span></p>
      	</div>
        <div id="u471" class="ax_下拉列表框">
            <p id="u471_input">
            	<c:if test="${map.prenatalReferral.healthHandbook == '0' }">未使用</c:if>
            	<c:if test="${map.prenatalReferral.healthHandbook == '1' }">使用</c:if>
            </p>
      	</div>
        
        <div id="u467" class="ax_文本段落">
          <p id="u468"><span>叶酸发放：</span></p>
      	</div>
        <div id="u472" class="ax_下拉列表框">
            <p id="u472_input">
            	<c:if test="${map.prenatalReferral.folateNum == '0' }">否</c:if>
            	<c:if test="${map.prenatalReferral.folateNum != '0' }">是</c:if>
            </p>
      	</div>
        
        <div id="u469" class="ax_文本段落">
          <p id="u470"><span>发放数量：${map.prenatalReferral.folateNum}瓶</span></p>
      	</div>
        
        
      </div>
      
	
  </body>
</html>
