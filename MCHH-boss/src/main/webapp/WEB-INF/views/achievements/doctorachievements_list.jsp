<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>医生绩效管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/achievements/doctorList";
		var listUrl = selfUrl;
		//导出
		var exportUrl = "${ctx}/export";
		$(function() {
			
			//重置按钮点击事件  $("#villageMechanism")[0].selectedIndex = -1;
			$("#reset").click(function(){
				 $(".text1").val("");
				 $(".Wdate").val("");
				 $("#countyMechanism")[0].selectedIndex = -1;
				 $("#townMechanism")[0].selectedIndex = -1;
				 $("#villageMechanism")[0].selectedIndex = -1;
				 $("#townMechanism").html("");
				 $("#villageMechanism").html("");
				 $("#realName")[0].selectedIndex = -1;
				 $("#u129_input option[value=3]").attr('selected',true);
				 $("#u160_input").hide();
				 $("#u160_input option[value=n]").attr('selected',true);
				 $("#u130_input").hide();
				 $("#u130_input option[value=n]").attr('selected',true);
				 $(".select1 option[value=n]").attr('selected',true);
				return false;
			});
			
			 //接诊医生
	    	   $.ajax({
	 				dataType:'json',
	 	 			url:"${ctx}/archivesinfo/doctor",
	 	 			success:function(data){
	 	 	 			$("#realName").html("");
	 	 	 			var str = "" ;
	 	 	 			for(var i = 0;i<data.list.length;i++){
	 	 	 				str += "<option value="+data.list[i].id+">"+data.list[i].realName+"</option>" ;
	 	 	 			}
	 	 	 			$("#realName").html(str);
	 	 	 			$("#realName")[0].selectedIndex = -1;
	 	 	 			$("#premaritalStatus")[0].selectedIndex = -1;
	 	 			}
	 	 		});
			
				//县乡村三级联动
				var countyUrl = "${ctx}/achievements/county";
				
				//下拉列
	    	    function county(thisUrl,id,parentId){
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
		    	county(countyUrl,"countyMechanism",null);
				
		    	//乡级医院名称
		    	$("#countyMechanism").change(function(){
		    		 $("#villageMechanism")[0].selectedIndex = -1;
		    		  $("#villageMechanism").html("");
		    		  var countyId = $("#countyMechanism").val();
		    		  var townUrl = "${ctx}/achievements/town";
		    		  county(townUrl,"townMechanism",countyId);
		    	});
		    	
		    	//村级医院名称
		    	$("#townMechanism").change(function(){
		    		  var townId = $("#townMechanism").val();
		    		  var villageUrl = "${ctx}/achievements/village";
		    		  county(villageUrl,"villageMechanism",townId);
		    		  
		    	});
			
			//为列表绑定双击事件
// 			$('#dg').datagrid({
// 				onDblClickRow:function(rowIndex,rowData){
// 					var birthArchiveId = rowData.birthArchivesId;
// 					window.location.href = "${ctx}/highriskprojectmanagement/list?birthArchiveId="+birthArchiveId;
					
// 				}
// 			});
			
			
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
					  {field:'ck',field:'全选',checkbox:true,width : '200',align:'center', 
	                    	 formatter: function (v) {
	                   		 	if(v==null){
	                   			  return "-"
	                   		 	 }else{
	                   		 		 return v;
	                   		 	 }
	                   		 }
					  },
	                  {title:'单位',field:'hospitalName',width : '150',align:'center', 
	                    	 formatter: function (v) {
	                   		 	if(v==null){
	                   			  return "-"
	                   		 	 }else{
	                   		 		 return v;
	                   		 	 }
	                   		 }
					  },
	                  {title:'医生姓名',field:'doctorName',width : '70',align:'center', 
	                    	 formatter: function (v) {
	                   		 	if(v==null){
	                   			  return "-"
	                   		 	 }else{
	                   		 		 return v;
	                   		 	 }
	                   		 }
					  },
	                  {title:'孕13周前检查人次',field:'before13Num',width : '120',align:'center'},
	                  {title:'孕16-20周检查人次',field:'at16to20Num',width : '120',align:'center'},
	                  {title:'孕21-24周检查人次',field:'at21to24Num',width : '120',align:'center'},
	                  {title:'孕28-36周检查人次',field:'at28to36Num',width : '120',align:'center'},
	                  {title:'孕37-40周检查人次',field:'at37to40Num',width : '120',align:'center'},
	                  {title:'出院3-7天检查人次',field:'post3to7Num',width : '120',align:'center'},
	                  {title:'产后42天检查人次',field:'post42Num',width : '120',align:'center'},
	                  {title:'血常规检查人数',field:'bloodNum',width : '120',align:'center'},
	                  {title:'尿常规检查人数',field:'urineNum',width : '120',align:'center'},
	                  {title:'血型',field:'bloodTypeNum',width : '50',align:'center'},
	                  {title:'肝功能检查人数',field:'liverNum',width : '120',align:'center'},
	                  {title:'肾功能检查人数',field:'kidneyNum',width : '120',align:'center'},
	                  {title:'乙肝表抗检查人数',field:'hepatitisBNum',width : '120',align:'center'},
	                  {title:'梅毒检查人数',field:'syphilisNum',width : '120',align:'center'},
	                  {title:'艾滋病检查人数',field:'aidsNum',width : '120',align:'center'},
	                  {title:'血红蛋白检查人次数',field:'hemoglobinNum',width : '120',align:'center'},
	                  {title:'尿蛋白检查人次数',field:'urineProteinNum',width : '120',align:'center'},
	                  {title:'结案产妇电子录入数',field:'actualCloseNum',width : '120',align:'center'},
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
			<div style="position: absolute;width: 78%;height:82px; border:1px solid #CCCCCC;"></div>
			<button style="background-color:#EE5F45; width:90px;height:35px;color:white;border: 0px" disabled="disabled">综合查询</button>
			 <span style="position: absolute;left: 120px;top: 18px;">家庭住址： </span>
          <select class="easyui-validatebox select" name="countyMechanism" id="countyMechanism" style="width:150px;height: 25px;position: absolute;left: 180px;top: 15px;border:#C8C9CD 1px solid;"></select>
		  <select class="easyui-validatebox select" name="townMechanism" id="townMechanism" style="width:150px;height: 25px;position: absolute;left: 355px;top: 15px;border:#C8C9CD 1px solid;"></select>
		  <select class="easyui-validatebox select" name="villageMechanism" id="villageMechanism" style="width:150px;height: 25px;position: absolute;left: 528px;top: 15px;border:#C8C9CD 1px solid;"></select>
		  
		  <span style="position: absolute;left: 120px;top: 50px;">结案日期：</span>
     <br><br><br><br>
     
		   <input type="text" id="statisticnow" name="closeDateStare"  style="width: 150px;height: 25px;position: absolute;left: 175px;top: 46px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
		   <span style="position: absolute;left: 337px;top: 51px;">—</span> 
		    <input type="text" id="statisticnow" name="closeDateEnd"  style="width: 150px;height: 25px;position: absolute;left: 350px;top: 46px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
		      	      
		     <span style="position: absolute;left: 528px;top: 50px;">医生：</span> 
		       <select class="easyui-validatebox select" name="doctorId" id="realName" style="width: 150px;height: 25px;position: absolute;left: 565px;top: 46px;border:#C8C9CD 1px solid;"></select>

 				<div style="position: absolute;right: 14%;top: 45">
			          	<a href="javascript:void(0)" class="easyui-linkbutton"  id="queryBtn"><i class="fa fa-search"></i>查询</a>
			    </div> 
		        <div style="position: absolute;right: 7%;top: 45">
			          <a href="javascript:void(0)" class="easyui-linkbutton reset"  id="reset"><i class="fa fa-undo"></i>重置</a>
			    </div> 
		        <div style="position: absolute;right: 0%;top: 45">
			          	<a href="javascript:void(0)" class="easyui-linkbutton export"  id="export" onClick="exportExcel('queryForm','doctorExport');"><i class="fa fa-file-text-o"></i>导出</a>
			    </div> 
			</form>
		</div>
	</div>
 </div>
</div>
	
	</body>
</html>
