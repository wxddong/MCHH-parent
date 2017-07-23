<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>高危孕产妇管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchiveId}";
		var listUrl = selfUrl;
		//导出
		var exportUrl = "${ctx}/export";
		$(function() {
			
			
			
			$("#addPreExa").click(function(){
				window.location.href = "${ctx}/archivesinfo/comePrenatalExa?id=${archivesId}"
			});
			$("#addPostExa").click(function(){
				window.location.href="${ctx}/postpartum/postpartumexainfo/list?archiveId=${archivesId}&go=0";
			});
			$("#historyExas").click(function(){
				window.location.href = "${ctx}/prenatal/prenatalOverHistory?birthArchivesId=${birthArchiveId}"
			});
				
			
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
				  {field:'ck',field:'全选',checkbox:true,width : '50',align:'center',rowspan:2,},
                  {title:'检查日期',field:'checkDate',width : '100',align:'center',rowspan:2,
                	     formatter: function (value, row, index) {
                	    	 if(value==null){
                	    		 return "-"
                	    	 }else{
                	    		 var date = new Date(value);
                    	    	 var year = date.getFullYear().toString();
                    	    	 var month = (date.getMonth() + 1);
                    	    	 var day = date.getDate().toString();
//                     	    	 var hour = date.getHours().toString();
//                     	    	 var minutes = date.getMinutes().toString();
//                     	    	 var seconds = date.getSeconds().toString();
                    	    	 if (month < 10) {
                    	    		month = "0" + month;
                    	    	 }
                    	    	 if (day < 10) {
                    	    		 day = "0" + day;
                    	    	 }
//                     	    	 if (hour < 10) {
//                     	    	     hour = "0" + hour;
//                     	    	 }
//                     	    	 if (minutes < 10) {
//                     	    	 	minutes = "0" + minutes;
//                     	    	 }
//                     	    	 if (seconds < 10) {
//                     	    	    seconds = "0" + seconds;
//                     	         }
//                     	    	 return year + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds;
                    	    	 return year + "-" + month + "-" + day;
                	    	 }
                	     }
                  },
                 
                  {title:'孕周',field:'weeks',width : '40',align:'center',rowspan:2, 
                 	 formatter: function (v) {
             		 	if(v==null){
             			  return "-"
             		 	 }else{
             		 		 return v;
             		 	 }
             		 }
                  },
                  
                  {title:'高危因素',colspan:2, 
                 	 formatter: function (v) {
             		 	if(v==null){
             			  return "-"
             		 	 }else{
             		 		 return v;
             		 	 }
             		 }
                  },
                  
                  {title:'高危评分',field:'score',width : '60',align:'center',rowspan:2, 
                 	 formatter: function (v) {
             		 	if(v==null){
             			  return "-"
             		 	 }else{
             		 		 return v;
             		 	 }
             		 }
                  },
                  {title:'本次检查结果',field:'result',width : '120',align:'center',rowspan:2, 
                 	 formatter: function (v) {
             		 	if(v==null){
             			  return "-"
             		 	 }else{
             		 		 return v;
             		 	 }
             		 }
                  },
                  {title:'指导意见',field:'guidance',width : '180',align:'center',rowspan:2, 
                	 formatter: function (v) {
            		 	if(v==null){
            			  return "-"
            		 	 }else{
            		 		 return v;
            		 	 }
            		 }
                  },
                  {title:'预约时间',field:'orderDate',width : '100',align:'center',rowspan:2,
                	  formatter: function (value, row, index) {
                		  if(value==null){
                			  return "-"
                		  }else{
		             	    	 var date = new Date(value);
		             	    	 var year = date.getFullYear().toString();
		             	    	 var month = (date.getMonth() + 1);
		             	    	 var day = date.getDate().toString();
		             	    	 if (month < 10) {
		             	    		month = "0" + month;
		             	    	 }
		             	    	 if (day < 10) {
		             	    		 day = "0" + day;
		             	    	 }
		             	    	 return year + "-" + month + "-" + day;
	                		}
             	     }
                  },
                  {title:'转归',field:'lapseTo',width : '80',align:'center',rowspan:2, 
                 	 formatter: function (v) {
             		 	if(v==null){
             			  return "-"
             		 	 }else{
             		 		 return v;
             		 	 }
             		 }
                  },
                  
                  {title:'分娩情况',colspan:3},
                  
                  {title:'转出医院',field:'outHospitalName',width : '120',align:'center',rowspan:2, 
                 	 formatter: function (v) {
             		 	if(v==null){
             			  return "-"
             		 	 }else{
             		 		 return v;
             		 	 }
             		 }
                  },
                  {title:'转入医院',field:'inHospitalName',width : '120',align:'center',rowspan:2, 
                 	 formatter: function (v) {
             		 	if(v==null){
             			  return "-"
             		 	 }else{
             		 		 return v;
             		 	 }
             		 }
                  },
                  {title:'随访医生',field:'doctorName',width : '80',align:'center',rowspan:2, 
                 	 formatter: function (v) {
             		 	if(v==null){
             			  return "-"
             		 	 }else{
             		 		 return v;
             		 	 }
             		 }
                  }
                 ],[
					{title:'固定因素',field:'staticRisk',width : '150',align:'center', 
	                	 formatter: function (v) {
	             		 	if(v==null){
	             			  return "-"
	             		 	 }else{
	             		 		 return v;
	             		 	 }
	             		 }
					},
					{title:'动态因素',field:'moveRisk',width : '150',align:'center', 
	                	 formatter: function (v) {
	             		 	if(v==null){
	             			  return "-"
	             		 	 }else{
	             		 		 return v;
	             		 	 }
	             		 }
					},
					 {title:'分娩时间',field:'birthDate',width : '100',align:'center',
	                	  formatter: function (value, row, index) {
	                		  if(value==null){
	                			  return "-"
	                		  }else{
	                			  var date = new Date(value);
	 	             	    	 var year = date.getFullYear().toString();
	 	             	    	 var month = (date.getMonth() + 1);
	 	             	    	 var day = date.getDate().toString();
	 	             	    	 if (month < 10) {
	 	             	    		month = "0" + month;
	 	             	    	 }
	 	             	    	 if (day < 10) {
	 	             	    		 day = "0" + day;
	 	             	    	 }
	 	             	    	 return year + "-" + month + "-" + day;
	                		  }
	             	     }
	                  },
	                  {title:'分娩地点',field:'childbirthPlace',width : '150',align:'center', 
	                 	 formatter: function (v) {
	             		 	if(v==null){
	             			  return "-"
	             		 	 }else{
	             		 		 return v;
	             		 	 }
	             		 }
	                  },
	                  {title:'分娩方式',field:'deliveryType',width : '60',align:'center', 
	                 	 formatter: function (v) {
	             		 	if(v==null){
	             			  return "-"
	             		 	 }else{
	             		 		 return v;
	             		 	 }
	             		 }
	                  }
                    
                 ]]
			});	
		
		});
	
 </script>
 <style type="text/css">
 		.combo-p{border:1px solid #95B8E7;}  		
 	</style>
	</head>
	<body>
	
	<div id="rolePanel" class="easyui-layout" fit="true" >
	 <div region="center" style="padding: 1px;">
	 <table id="dg"></table>
	 <div id="tb" style="padding:5px;height:auto">
		<div>
			<form id="queryForm"  method="post">
 				<input type="hidden"  name="archivesId" value="${archivesId }"/> 
 				<input type="hidden"  name="birthArchiveId" value="${birthArchiveId }"/> 
				<div style="height: 45;width: 100%;">
					 <div style="background-color:#EE5F45; width:180px;height:36px;color:white;border: 0px;position:absolute;top: 14px;left: 4px;text-align: center;;line-height: 35px" >高危专案管理记录</div>
					 <c:if test="${birthArchives.pregnantState==0 }">
					 <div id="addPreExa" style="background-color:#009ED7; width:90px;height:51px;border: 0px;text-align: center;position: absolute;right: 9.2%;top: 0px;line-height: 50px;color: white;cursor:pointer;">增加随访</div>
					 </c:if>
					 <c:if test="${birthArchives.pregnantState==1 }">
					 <div id="addPostExa" style="background-color:#009ED7; width:90px;height:51px;border: 0px;text-align: center;position: absolute;right: 9.2%;top: 0px;line-height: 50px;color: white;cursor:pointer;">增加访视</div>
					 </c:if>
					 <c:if test="${birthArchives.pregnantState==2 }">
					 <div id="historyExas" style="background-color:#009ED7; width:90px;height:51px;border: 0px;text-align: center;position: absolute;right: 9.2%;top: 0px;line-height: 50px;color: white;cursor:pointer;">检查记录</div>
					 </c:if>
					 <div id="export" style="background-color:#56BB4D; width:90px;height:51px;border: 0px;text-align: center;position: absolute;right: 0.4%;top: 0px;line-height: 50px;color: white;cursor:pointer;" onClick="exportExcel('queryForm','highRiskProjectExport');">导出</div>
				</div>
					<center> 
				<div style="border:1px solid #CCCCCC;top: 10px">
					<table align="center" width="1000" height="100">
						<tr style="width: 100px;height: 30px">
							<td><font color="red">姓&nbsp;&nbsp;名：${message["name"]}</font></td>
							<td><font color="red">档案编号：${message["archivesCode"]}</font> </td>
							<td> 建档日期：<fmt:formatDate value="${message['creatTime']}" pattern="yyyy-MM-dd"/> </td>
							<td width="250"> 孕&nbsp;&nbsp;周：${message["weeks"]}</td>
						</tr>
						<tr>
							<td> 出生日期：<fmt:formatDate value="${message['birthday']}" pattern="yyyy-MM-dd"/> </td>
							<td> 孕妇年龄：${message["age"]}</td>
							<td> 末次月经：<fmt:formatDate value="${message['lastMenses']}" pattern="yyyy-MM-dd"/></td>
							<td> 预  产  期：<fmt:formatDate value="${message['predictDate']}" pattern="yyyy-MM-dd"/></td>
						</tr>
						<tr>
							<td> 联系电话：${message["telephone"]}</td>
							<td> 丈夫姓名：${message["manName"]}</td>
							<td>丈夫年龄：${message["manAge"]}</td>
							<td>丈夫电话：${message["manTele"]}</td>
						</tr>
						<tr>
							<td>分娩日期：<fmt:formatDate value="${message['birthDate']}" pattern="yyyy-MM-dd"/></td>
							<td>结案日期：<fmt:formatDate value="${message['closeDate']}" pattern="yyyy-MM-dd"/></td>
						</tr>
					</table> 
			</div>	
					</center>
			</form>
		</div>
	</div>
 </div>
</div>
	
	</body>
</html>
