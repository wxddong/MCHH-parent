<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>医生绩效管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/report/listTownShipReport";
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
// 					  {field:'ck',field:'全选',checkbox:true,width : '200',align:'center'},
	                  {title:'统计单位',field:'date1',width : '150',align:'center',rowspan:2},
	                  {title:'健康档案',width : '70',align:'center',colspan:10},
	                  {title:'0-6岁儿童健康管理',width : '120',align:'center',colspan:10},
	                  {title:'孕产妇保健',width : '120',align:'center',colspan:22},
	                  
	                  ],[
						{title:'2016年统计常驻人口',field:'date2',width : '150',align:'center'},
						{title:'纸质档案（含管理费用）',field:'date3',width : '150',align:'center'},
						{title:'纸质建档率',field:'date4',width : '150',align:'center'},
						{title:'合格率',field:'date5',width : '150',align:'center'},
						{title:'电子档案（含管理费用）',field:'date6',width : '150',align:'center'},
						{title:'电子建档率',field:'date7',width : '150',align:'center'},
						{title:'合格率',field:'date8',width : '150',align:'center'},
						{title:'新建纸质档案',field:'date9',width : '150',align:'center'},
						{title:'新建电子档案',field:'date10',width : '150',align:'center'},
						{title:'项目实得费用',field:'date11',width : '150',align:'center'},
						{title:'活产数',field:'date12',width : '150',align:'center'},
						{title:'儿保建卡人次数',field:'date13',width : '150',align:'center'},
						{title:'儿保体检人次数',field:'date14',width : '150',align:'center'},
						{title:'合格率',field:'date15',width : '150',align:'center'},
						{title:'电子档案体检录入数',field:'date16',width : '150',align:'center'},
						{title:'合格率',field:'date17',width : '150',align:'center'},
						{title:'新生儿访视电子录入数',field:'date18',width : '150',align:'center'},
						{title:'合格率',field:'date19',width : '150',align:'center'},
						{title:'血常规检查人次数',field:'date20',width : '150',align:'center'},
						{title:'项目实得费用',field:'date21',width : '150',align:'center'},
						{title:'产妇数',field:'date22',width : '150',align:'center'},
						{title:'动员孕保健卡数',field:'date23',width : '150',align:'center'},
						{title:'孕保体检人次数',field:'date24',width : '150',align:'center'},
						{title:'合格率',field:'date25',width : '150',align:'center'},
						{title:'电子档案录入体检人次数',field:'date26',width : '150',align:'center'},
						{title:'合格率',field:'date27',width : '150',align:'center'},
						{title:'产后访视',field:'date28',width : '150',align:'center'},
						{title:'合格率',field:'date29',width : '150',align:'center'},
						{title:'产后访视电子录入数',field:'date30',width : '150',align:'center'},
						{title:'合格率',field:'date31',width : '150',align:'center'},
						{title:'血常规检查人次数',field:'date32',width : '150',align:'center'},
						{title:'尿常规检查人次数',field:'date33',width : '150',align:'center'},
						{title:'血型',field:'date34',width : '150',align:'center'},
						{title:'肝功能检查人数',field:'date35',width : '150',align:'center'},
						{title:'肾功能检查人数',field:'date36',width : '150',align:'center'},
						{title:'乙肝表抗检查人次数',field:'date37',width : '150',align:'center'},
						{title:'血红蛋白检查人次数',field:'date38',width : '150',align:'center'},
						{title:'尿蛋白检查人次数',field:'date39',width : '150',align:'center'},
						{title:'项目实得费用',field:'date40',width : '150',align:'center'},
						{title:'合计实得费用',field:'date41',width : '150',align:'center'},
						{title:'',field:'date42',width : '150',align:'center'},
						{title:'',field:'date43',width : '150',align:'center'},
	                     
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
		  
		  <span style="position: absolute;left: 120px;top: 50px;">统计日期：</span>
     <br><br><br><br>
     
		   <input type="text" id="statisticnow" name="statisticsDateStare"  style="width: 150px;height: 25px;position: absolute;left: 175px;top: 46px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
		   <span style="position: absolute;left: 337px;top: 51px;">—</span> 
		    <input type="text" id="statisticnow" name="statisticsDateEnd"  style="width: 150px;height: 25px;position: absolute;left: 350px;top: 46px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
		      	      
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
