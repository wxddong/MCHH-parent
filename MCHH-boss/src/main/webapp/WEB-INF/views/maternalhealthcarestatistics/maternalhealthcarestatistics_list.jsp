<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>孕产妇保健统计</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/maternalhealthcarestatistics/list";
		var listUrl = selfUrl;
		//导出
		var exportUrl = "${ctx}/export";
		$(function() {
			
			//点击查询对输入的查询条件进行校验
			$("#queryBtn").click(function(){
				
				//档案编号 仅限数字
				var queryCodeReg = /^[0-9]*$/;
				var queryCode = $.trim($("#queryCode").val());
				if(!queryCodeReg.test(queryCode)&&queryCode!=""){
					alert("请输入正确格式的档案编号");
					window.location.href = selfUrl;
					return false;
				}
				
				//姓名  通用规则
				var queryNameReg = /[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/;
				var queryName =$.trim($("#queryName").val());
				if(!queryNameReg.test(queryName)&&queryName!=""){
					alert("请输入正确格式的姓名");
					window.location.href = "${ctx}/maternalhealthcarestatistics/list";
					return false;
				}
				
				//省份证  可数字+字母
				var queryIdReg = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X|x)$/;
				var queryId =$.trim($("#queryId").val());
				if(!queryIdReg.test(queryId)&&queryId!=""){
					alert("请输入正确格式的省份证号");
					window.location.href = "${ctx}/maternalhealthcarestatistics/list";
					return false;
				}
				
			});
			
			//重置按钮点击事件  $("#villageMechanism")[0].selectedIndex = -1;
			$("#reset").click(function(){
				 $(".text1").val("");
				 $(".Wdate").val("");
				 $("#countyMechanism")[0].selectedIndex = -1;
				 $("#townMechanism")[0].selectedIndex = -1;
				 $("#villageMechanism")[0].selectedIndex = -1;
				 $("#townMechanism").html("");
				 $("#villageMechanism").html("");
				 $("#u129_input option[value=3]").attr('selected',true);
				 $("#u160_input").hide();
				 $("#u160_input option[value=n]").attr('selected',true);
				 $("#u130_input").hide();
				 $("#u130_input option[value=n]").attr('selected',true);
				return false;
			});
			
			
			//点击结案按钮结案原因框自动弹出   $('#category option[value=3]').attr('selected',true);
			$("#u160_input").hide();
			$("#u130_input").hide();
			$("#u129_input").change(function(){
				
				var a = this.value;
				if(a==0){
					$("#u160_input").show();
					$("#u130_input").hide();
					$("#u130_input option[value=n]").attr('selected',true);
				}else if(a==1){
					$("#u130_input").show();
					$("#u160_input").hide();
					$("#u160_input option[value=n]").attr('selected',true);
				}else{
					$("#u160_input").hide();
					$("#u130_input").hide();
					$("#u130_input option[value=n]").attr('selected',true);
					$("#u160_input option[value=n]").attr('selected',true);
				}
			});
			
			//县乡村三级联动
			var countyDepUrl = "${ctx}/premaritalexainfo/countyDep";
			
			//下拉列
    	    function countyDep(thisUrl,id,parentId){
    		    $.ajax({
				  dataType:'json',
				  url:thisUrl,
				  data:{parentId:parentId},
				  success:function(data){
 					  $("#"+id).html("");
 					  var str = "" ;
 					  for(var i = 0;i<data.list.length;i++){
 						  str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
 					  }
 					  $("#"+id).html(str);
 					  $("#"+id)[0].selectedIndex = -1;
				  }
			  });
    	    }
	    	
			//县级医院名称
	    	countyDep(countyDepUrl,"countyMechanism",null);
			
	    	//乡级医院名称
	    	$("#countyMechanism").change(function(){
	    		 $("#villageMechanism")[0].selectedIndex = -1;
	    		  $("#villageMechanism").html("");
	    		  var countyDepId = $("#countyMechanism").val();
	    		  var townDepUrl = "${ctx}/premaritalexainfo/townDep";
	    		  countyDep(townDepUrl,"townMechanism",countyDepId);
	    	});
	    	
	    	//村级医院名称
	    	$("#townMechanism").change(function(){
	    		  var townDepId = $("#townMechanism").val();
	    		  var villageDepUrl = "${ctx}/premaritalexainfo/villageDep";
	    		  countyDep(villageDepUrl,"villageMechanism",townDepId);
	    		  
	    	});
	    	
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
			      {field:'ck',field:'全选',checkbox:true,width : '50',align:'center',rowspan:2,},
                  {title:'建卡日期',field:'creatDate',width : '100',align:'center',rowspan:2,
                   	  formatter: function (value, row, index) {
                		  if(value!=null){
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
                		  }else{
                			  return "-";
                		  }
             	    	 
             	     }
//                 	     formatter: function (value, row, index) {
//                 	    	 var date = new Date(value);
//                 	    	 var year = date.getFullYear().toString();
//                 	    	 var month = (date.getMonth() + 1);
//                 	    	 var day = date.getDate().toString();
// //                 	    	 var hour = date.getHours().toString();
// //                 	    	 var minutes = date.getMinutes().toString();
// //                 	    	 var seconds = date.getSeconds().toString();
//                 	    	 if (month < 10) {
//                 	    		month = "0" + month;
//                 	    	 }
//                 	    	 if (day < 10) {
//                 	    		 day = "0" + day;
//                 	    	 }
// //                 	    	 if (hour < 10) {
// //                 	    	     hour = "0" + hour;
// //                 	    	 }
// //                 	    	 if (minutes < 10) {
// //                 	    	 	minutes = "0" + minutes;
// //                 	    	 }
// //                 	    	 if (seconds < 10) {
// //                 	    	    seconds = "0" + seconds;
// //                 	         }
// //                 	    	 return year + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds;
//                 	    	 return year + "-" + month + "-" + day;
//                 	     }
                  },
                 
                  {title:'编号',field:'archivesCode',width : '150',align:'center',rowspan:2, 
                 	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }},
                  {title:'姓名',field:'name',width : '80',align:'center',rowspan:2, 
                 	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }},
                  {title:'年龄',field:'age',width : '50',align:'center',rowspan:2, 
                 	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                  },
                  {title:'末次月经',field:'lastMenses',width : '100',align:'center',rowspan:2,
                   	  formatter: function (value, row, index) {
                		  if(value!=null){
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
                		  }else{
                			  return "-";
                		  }
             	    	 
             	     }
                  },
                  {title:'预产期',field:'predictDate',width : '100',align:'center',rowspan:2,
                   	  formatter: function (value, row, index) {
                		  if(value!=null){
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
                		  }else{
                			  return "-";
                		  }
             	    	 
             	     }
                  },
                  {title:'建卡孕周',field:'weeks',width : '180',align:'center',rowspan:2, 
                 	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                  },
                  
                  {title:'孕13周6天前',colspan:2},
                  {title:'孕14周-15周6天',colspan:2},
                  {title:'孕16周-20周6天',colspan:2},
                  {title:'孕21周-24周6天',colspan:2},
                  {title:'孕25周-27周6天',colspan:2},
                  {title:'孕28周-36周6天',colspan:2},
                  {title:'孕37周-40周6天',colspan:2},
                  {title:'出院3-7天',colspan:2},
                  {title:'产后42天',colspan:1},

                  {title:'结案时间',field:'closeDate',width : '100',align:'center',rowspan:2,
                   	  formatter: function (value, row, index) {
                		  if(value!=null){
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
                		  }else{
                			  return "-";
                		  }
             	    	 
             	     }
                  },
                  {title:'高危因素',field:'highRisk',width : '180',align:'center',rowspan:2, 
                 	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                  },
                  {title:'分娩时间',field:'birthDate',width : '100',align:'center',rowspan:2,
                   	  formatter: function (value, row, index) {
                		  if(value!=null){
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
                		  }else{
                			  return "-";
                		  }
             	    	 
             	     }
                  },
                  {title:'分娩地点',field:'childbirthPlace',width : '120',align:'center',rowspan:2, 
                 	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                  },
                  {title:'家庭住址',field:'address',width : '300',align:'center',rowspan:2, 
                 	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                  },
                  {title:'联系电话',field:'telephone',width : '100',align:'center',rowspan:2, 
                 	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                  },
                 ],[
                    
                    {title:'随访时间',field:'oneCheckDate',width : '100',height:'10',align:'center',
                  	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    {title:'预约时间',field:'oneOrderDate',width : '100',align:'center',
                     	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    {title:'随访次数',field:'twoCheckTimes',width : '180',align:'center', 
                   	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                    },
                    {title:'预约时间',field:'twoOrderDate',width : '100',align:'center',
                     	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    
                    {title:'随访次数',field:'threeCheckTimes',width : '180',align:'center', 
                   	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                    },
                    {title:'预约时间',field:'threeOrderDate',width : '100',align:'center',
                     	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    {title:'随访次数',field:'fourCheckTimes',width : '180',align:'center', 
                   	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                    },
                    {title:'预约时间',field:'fourOrderDate',width : '100',align:'center',
                     	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    {title:'随访次数',field:'fiveCheckTimes',width : '180',align:'center', 
                   	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                    },
                    {title:'预约时间',field:'fiveOrderDate',width : '100',align:'center',
                     	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    {title:'随访次数',field:'sixCheckTimes',width : '180',align:'center', 
                   	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                    },
                    {title:'预约时间',field:'sixOrderDate',width : '100',align:'center',
                     	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    {title:'随访次数',field:'sevenCheckTimes',width : '180',align:'center', 
                   	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                    },
                    {title:'预约时间',field:'sevenOrderDate',width : '100',align:'center',
                     	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    {title:'随访次数',field:'post3to7Times',width : '180',align:'center', 
                   	 formatter: function (v) {
               		 	if(v==null){
               			  return "-"
               		 	 }else{
               		 		 return v;
               		 	 }
               		 }
                    },
                    {title:'预约时间',field:'post3to7Date',width : '100',align:'center',
                     	  formatter: function (value, row, index) {
                  		  if(value!=null){
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
                  		  }else{
                  			  return "-";
                  		  }
               	    	 
               	     }
                    },
                    {title:'检查次数',field:'post42Times',width : '180',align:'center', 
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
			
						<div style="border:1px solid #CCCCCC;height: 47px;width: 92%;">
						
							    <button style="background-color:#EE5F45; width:90px;height:35px;color:white;border: 0px;position: absolute;left: 5px;top: 5px" disabled="disabled">个案查询</button>
								<span style="position: absolute;left: 120px;top: 13px;">档案编号：</span> <input id="queryCode" style="width: 150px;height: 25px;position: absolute;left: 180px;top: 10px;border:#C8C9CD 1px solid;" class="text1" type="text" name="archivesCode"/>
								<span style="position: absolute;left: 375px;top: 13px;">姓   名：</span>  <input id="queryName" style="width: 150px;height: 25px;position: absolute;left: 418px;top: 10px;border:#C8C9CD 1px solid;" class="text1" type="text" name="name"  /> 
								<span style="position: absolute;left: 610px;top: 13px;">身份证号：</span>  <input id="queryId" style="width: 150px;height: 25px;position: absolute;;left: 670;top: 10px;border:#C8C9CD 1px solid;" class="text1" type="text" name="idNo"/>
						</div>

						<div style="border:1px solid #CCCCCC;height:150px;width: 92%;margin-top:5px;">
									
								<button style="background-color:#EE5F45; width:90px;height:35px;color:white;border: 0px;position:absolute;left: 5px;" disabled="disabled">综合查询</button>
								 <span style="position: absolute;left: 120px;top: 75px;">医疗机构： </span> 
						        <select class="easyui-validatebox select" name="countyMechanism" id="countyMechanism" style="width:150px;height:25px;position: absolute;left: 180px;top:72px;border:#C8C9CD 1px solid;"></select>
								<select class="easyui-validatebox select" name="townMechanism" id="townMechanism" style="width:150px;height: 25px;position: absolute;left: 352px;top:72px;border:#C8C9CD 1px solid;"></select>
								<select class="easyui-validatebox select" name="villageMechanism" id="villageMechanism" style="width:150px;height: 25px;position: absolute;left: 523px;top:72px;border:#C8C9CD 1px solid;"> </select>
						 	
						         <span style="position: absolute;left: 120px;top: 105px;">建档日期：</span>
						         <input  type="text" id="statisticnow" name="creatDateStare"  style="width: 150px;height: 25px;position: absolute;left: 175px;top:103px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" /> 
						         <span style="position: absolute;left: 336px;top: 108px;">—</span>
						         <input type="text" id="statisticnow" name="creatDateEnd"  style="width: 150px;height: 25px;position: absolute;left: 347px;top:103px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
						
						 
								 <span style="position: absolute;left: 120px;top: 138px;">预 产 期：</span>
								 <input  type="text" id="statisticnow" name="exceptDateStare"  style="width: 150px;height: 25px;position: absolute;left: 175px;top:135px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" /> 
								 <span style="position: absolute;left: 336px;top: 140px;">—</span>
								 <input type="text" id="statisticnow" name="exceptDateEnd"  style="width: 150px;height: 25px;position: absolute;left: 347px;top:135px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
						    
						         <span style="position: absolute;left: 120px;top: 170px;"> 结案状态：</span> 
						          <select id="u129_input" name="ifClose" style="width: 150px;height: 25px ;position: absolute;left: 180px;top:167px;border:#C8C9CD 1px solid; ">
						          <option value="0">已结案</option>
						          <option value="1">未结案</option>
						          <option selected value="3">不限</option>
						        </select>
							 
							    	<select id="u130_input" name="statue" style="width: 150px;height: 25px;position: absolute;left: 352px;top:167px;border:#C8C9CD 1px solid;">
							          <option value="0">妊娠中</option>
							          <option value="1">正常分娩</option>
							            <option selected value="n">不限</option>
							        </select>
							        <select id="u160_input" name="closeReason" style="width: 150px;height: 25px;position: absolute;left: 352px;top:167px ;border:#C8C9CD 1px solid;">
							          <option value="1">流产</option>
							          <option value="0">正常结案</option>
							          <option value="4 ">其他 </option>
							          <option value="2">引产</option>
							          <option value="3">失访</option>
							          <option selected value="n">不限</option>
							        </select>
						</div>		

						<div style="position: absolute;right: 0%;top: 70px">
					          <a href="javascript:void(0)" class="easyui-linkbutton"  id="queryBtn"><i class="fa fa-search"></i>查询</a>
					    </div> 
				        <div style="position: absolute;right: 0%;top: 123px">
					          <a href="javascript:void(0)" class="easyui-linkbutton reset"  id="reset"><i class="fa fa-undo"></i>重置</a>
					    </div> 
				        <div style="position: absolute;right: 0%;top: 175px">
					          <a href="javascript:void(0)" class="easyui-linkbutton export"  id="export" onClick="exportExcel('queryForm','maternalHealthCareExport');"><i class="fa fa-file-text-o"></i>导出</a>
					    </div> 	 
			        
			</form>
		</div>
	</div>
 </div>
</div>
	
	</body>
</html>
