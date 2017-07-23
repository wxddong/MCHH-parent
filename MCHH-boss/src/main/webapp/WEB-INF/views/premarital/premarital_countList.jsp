<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>活动列表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/font-awesome.min.css">
	<script type="text/javascript">
	    var fid = '-1';
		var listUrl = "${ctx}/premaritalexainfo/countList";
	  	//导出
		var exportUrl = "${ctx}/export";
		$(function() {
			
			for(var i = 0; i<9; i ++){
	    		  
	    	  	$("select")[i].selectedIndex = -1;  	  
	    	}
			
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
	    		  var countyDepId = $("#countyMechanism").val();
	    		  var townDepUrl = "${ctx}/premaritalexainfo/townDep";
	    		  countyDep(townDepUrl,"townMechanism",countyDepId);
	    		  $("#townMechanism")[0].selectedIndex = -1;
	    		  $("#villageMechanism")[0].selectedIndex = -1;
	    	});
	    	
	    	//村级医院名称
	    	$("#townMechanism").change(function(){
	    		  var townDepId = $("#townMechanism").val();
	    		  var villageDepUrl = "${ctx}/premaritalexainfo/villageDep";
	    		  countyDep(villageDepUrl,"villageMechanism",townDepId);
	    		  $("#villageMechanism")[0].selectedIndex = -1;
	    	});
	    	
    	    //重置
    	    $("#reSetBtn").click(function(){
	    		   $("#archivesCode").val("");
	    		   $("#name").val("");
	    		   $("#idNo").val("");
	    		   $("#txtBegin").val("");
	    		   $("#txtEnd").val("");
	    		   $("#countyMechanism")[0].selectedIndex = -1;
	    		   $("#townMechanism")[0].selectedIndex = -1;
	    		   $("#villageMechanism")[0].selectedIndex = -1;
	    		   $("#sex")[0].selectedIndex = -1;
	    		   $("#checkResult")[0].selectedIndex = -1;
	    		   $("#medicalAdvice")[0].selectedIndex = -1;
	    		   $("#grantSign")[0].selectedIndex = -1;
	    		   $("#frantNum")[0].selectedIndex = -1;
	    		   $("#whetherPregnant")[0].selectedIndex = -1;
	        });
    	  
			//列表
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'建档日期',field:'creatTime',formatter:formatDate,resizable:'true',align:'center'},
                 {title:'编号',field:'archivesInfoPO.archivesCode',resizable:'true',align:'center'},
                 {title:'姓名',field:'archivesInfoPO.name',resizable:'true',align:'center'},
                 {title:'性别',field:'sex',resizable:'true',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "女"
                         } 
                         if(v==1){
                             return "男"
                         }
                         if(v==2){
                             return "性别不明"
                         }
                	 } 
                 },
                 
                 {title:'身份证号码',field:'archivesInfoPO.idNo',resizable:'true',align:'center'},
                 {title:'年龄',field:'age',resizable:'true',align:'center'},
                 {title:'家庭住址',field:'address',resizable:'true',align:'center'},
                 {title:'联系电话',field:'archivesInfoPO.telephone',resizable:'true',align:'center'},
                 {title:'对方姓名',field:'archivesInfoPO.manName',resizable:'true',align:'center'},
                 {title:'联系电话',field:'archivesInfoPO.manTele',resizable:'true',align:'center'},
                 {title:'转诊医院',field:'departmentPO.name',resizable:'true',align:'center'},
                 {title:'转诊日期',field:'premaritalReferralInfoPO.referralDate',formatter:formatDate,resizable:'true',align:'center'},
                 {title:'出具婚检证明日期',field:'inspectionResultPO.issuedByDate',formatter:formatDate,resizable:'true',align:'center'},
                 {title:'检查结果',field:'inspectionResultPO.checkResult',resizable:'true',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "未见异常"
                         } 
                         if(v==1){
                             return "异常"
                         } else{
                        	 return "-"
                         }
                	 } 
                 },
                 {title:'医学意见',field:'inspectionResultPO.medicalAdvice',resizable:'true',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "未发现医学上不宜结婚的情形"
                         } 
                         if(v==1){
                             return "建议暂缓结婚"
                         }
                         if(v==2){
                             return "建议不宜生育"
                         } 
                         if(v==3){
                             return "建议不宜结婚"
                         }
                         if(v==4){
                             return "建议采取医学措施，尊重受检者意愿"
                         }
                	 } 
                 },
                 {title:'建档医生',field:'operatorPO.realName',resizable:'true',align:'center'},
                 {title:'是否怀孕',field:'healthInfoPO.whetherPregnant',resizable:'true',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "备孕"
                         } 
                         if(v==1){
                             return "正常"
                         }
                         if(v==2){
                             return "现孕"
                         } 
                         if(v==3){
                             return "已分娩"
                         }
                	 } 
                 },
                 {title:'手册发放',field:'birthArchivesInfoPO.grantSign', resizable:'true',align:'center',
                	  formatter:function(v){ 
                         
	                		 if(v==0){
	                             return "否"
	                         } 
	                         if(v==1){
	                             return "是"
	                         }else{
	                        	 return "-"
	                         }
						
                	 } 
                 },
                 {title:'叶酸发放',field:'birthArchivesInfoPO.frantNum', resizable:'true',align:'center',
               	  formatter:function(v){ 
                        if(v==0){
                            return "否"
                        } 
                        if(v > 0){
                            return "是"
                        }else{
                        	return "-"
                        }
               	 } 
                }
                ]]
			});
			
		});

	</script>
	<style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}
 	</style>
  </head>
 	<body class="panel-noscroll">
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
		 <div>
		 <input id = "status" name = "status" type = "hidden" value = "${premaritalExaInfoPO.editStatus }"/>
		 <input id = "archId" name = "archId" type = "hidden" value="${archivesInfoDetail.archivesInfo.id}"/>
			 <form id="queryForm" method="post">
			 <div style="position:relative;border: 1px solid #cccccc;height: 45px;width: 930px;">
			 <button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">个案查询</span></p></button>
			
			<span style="position:absolute;left:120px ;width:60px; top:18px;height: 25px;">档案编号：</span><input style="position:absolute;border: 1px solid #cccccc;left:180px ;width:150px; top:15px;height: 25px;"  class="easyui-validatebox text" type="text" name="archivesCode" id = "archivesCode"/>
			
			<span style="position:absolute;left:350px ;width:40px; top:18px;height: 25px;">姓名：</span><input style="position:absolute;border: 1px solid #cccccc;left:390px ;width:90px; top:15px;height: 25px;"  class="easyui-validatebox text" type="text" name="name" id = "name" />
			<span style="position:absolute;left:498px ;width:70px; top:18px;height: 25px;">身份证号：</span><input style="position:absolute;border: 1px solid #cccccc;left:560px ;width:180px; top:15px;height: 25px;"  class="easyui-validatebox text" type="text" name="idNo" id = "idNo" />
			</div>
			<div style="position:relative; border: 1px solid #cccccc; top:3px;height: 140px;width: 930px;">
			
			<button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">综合查询</span></p></button>
			
			<span style="position:absolute;left:120px ;width:60px; top:15px;height: 15px;">医疗机构：</span>
			 <select style="position:absolute;border: 1px solid #cccccc;left:180px ;top:12px;width:150px;height: 25px;" class="easyui-validatebox select" name="countyMechanism" id="countyMechanism" >
			 </select>&nbsp;
			 <select style="position:absolute;border: 1px solid #cccccc;left:350px ;top:12px;width:150px;height: 25px;" class="easyui-validatebox select" name="townMechanism" id="townMechanism" >
			 </select>&nbsp;
			 <select style="position:absolute;border: 1px solid #cccccc;left:518px ;top:12px;width:150px;height: 25px;" class="easyui-validatebox select" name="villageMechanism" id="villageMechanism" >
			 </select>	
			 
			 <span style="position:absolute;left:120px ;width:60px; top:45px;height: 15px;">建档日期：</span> 
			 <input style="position:absolute;border: 1px solid #cccccc;left:180px ;top:42px;color:#333333;width:150px;height: 25px;cursor:pointer;" type="text" id="txtBegin" name="txtBegin" style="color:#adadaf"
	      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'txtEnd\')}'})"/> 
				<span style="position:absolute;left:335px ;top:45px;">—</span>
	      		<input style="position:absolute;border: 1px solid #cccccc;left:350px ;top:42px;color:#333333;width:150px;height: 25px;cursor:pointer" type="text" id="txtEnd" name="txtEnd" style="color:#adadaf"
	      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'txtBegin\')}'})"/>
	      	<span style="position:absolute;left:584px ;width:60px; top:45px;height: 15px;">性别：</span>
			 <select style="position:absolute;border: 1px solid #cccccc;left:620px ;top:42px;width:50px;height: 25px;" class="easyui-validatebox select" name="sex" id="sex" >
		          
		          <option value="0">女</option>
			 	  <option value="1">男</option>
			 	  <option value="2">性别不明</option>
			 </select> 
			<span style="position:absolute;left:695px ;width:60px; top:45px;height: 15px;">检查结果：</span>
			 <select style="position:absolute;border: 1px solid #cccccc;left:760px ; top:42px;height: 25px;width:100px;" class="easyui-validatebox select" name="checkResult" id="checkResult" >
		          
		          <option value="0">未见异常</option>
			 	  <option value="1">异常</option>
			 </select>
			
			 
			  
			<span style="position:absolute;left:120px ;width:60px; top:75px;height: 15px;">医学意见：</span>
			 <select style="position:absolute;border: 1px solid #cccccc;left:180px ;top:72px;color:#333333;height: 25px;width:320px;" class="easyui-validatebox select" name="medicalAdvice" id="medicalAdvice" >
		          
		          <option value="0">未发现医学上不宜结婚的情形</option>
		          <option value="1">建议暂缓结婚</option>
		          <option value="2">建议不宜生育</option>
		          <option value="3">建议不宜结婚</option>
		          <option value="4">建议采取医学措施，尊重受检者意愿</option>
			 </select>
			<span style="position:absolute;left:560px ;width:60px; top:75px;height: 15px;">手册发放：</span>
			 <select style="position:absolute;border: 1px solid #cccccc;left:620px ;top:72px;width:50px;height: 25px;" class="easyui-validatebox select" name="grantSign" id="grantSign" >
		          
		          <option value="1">是</option>
          		  <option value="0">否</option>
			 </select> 
			<span style="position:absolute;left:695px ;width:60px; top:75px;height: 15px;">叶酸发放：</span>
			 <select style="position:absolute;border: 1px solid #cccccc;left:760px ;top:72px;width:50px;height: 25px;width:100px;" class="easyui-validatebox select" name="frantNum" id="frantNum" >
		          
		          <option value="-1">是</option>
          		  <option value="0">否</option>
			 </select>
			
			
			<span style="position:absolute;left:120px ;width:60px; top:105px;height: 15px;">是否怀孕：</span>
			 <select style="position:absolute;border: 1px solid #cccccc;left:180px ;height: 25px;top:102px;color:#333333;width:180px;" class="easyui-validatebox select" name="whetherPregnant" id="whetherPregnant" >
			 		  
			 		  <option value="0">备孕</option>
			          <option value="1">正常</option>
			          <option value="2">现孕</option>
			          <option value="3">已分娩</option>
			 </select>
			
			</div>
			<div style="position: absolute;right:0%;top: 20px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
      		</div>
      		<div style="position: absolute;right:0%;top: 80px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" id="reSetBtn"><i class="fa fa-undo"></i>重置</a>
      		</div>
      		<div style="position: absolute;right:0%;top: 140px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton export" onClick="exportExcel('queryForm','countPreExport');"><i class="fa fa-file-text-o"></i>导出</a>
      		</div>
			 
      		</form>	
			
			
			
			
		</div>
	</div>
	
	   
	
	</body>
</html>
