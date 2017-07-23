 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>县级绩效管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/achievements/countyList";
		var listUrl = selfUrl;
		//导出
		var exportUrl = "${ctx}/export";
		$(function() {
			//如果家庭地址县为空时，镇和村不可选，如果镇为空时，村不可选
// 			var countyVal = $("#countyMechanism").val();
// 			var townVal = $("#townMechanism").val();
// 			if(countyVal==null){
// 				$("#townMechanism").attr("disabled", true);
// 				$("#townMechanism").css("background-color","#FFFFFF");
// 				$("#villageMechanism").attr("disabled", true);
// 				$("#townMechanism").css("background-color","#FFFFFF");
// 			}
			
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
				  {field:'ck',field:'全选',checkbox:true,width : '200',align:'center'},
                  {title:'单位',field:'departmentName',width : '120',align:'center'},
                  {title:'辖区内人口总数',field:'populationNum',width : '100',align:'center', 
                	 formatter: function (v) {
            		 	if(v==null){
            			  return "-"
            		 	 }else{
            		 		 return v;
            		 	 }
            		 }
                  },
                  {title:'辖区内应结案产妇数',field:'shouldCloseNum',width : '110',align:'center'},
                  {title:'实际结案产妇数',field:'actualCloseNum',width : '100',align:'center'},
                  {title:'产前健康管理人数',field:'preGreat0Num',width : '100',align:'center'},
                  {title:'产前健康管理率',field:'preManageRate',width : '90',align:'center'},
                  {title:'早孕建卡数',field:'earlyCardNum',width : '70',align:'center'},
                  {title:'早孕健康率',field:'earlyRate',width : '70',align:'center'},
                  {title:'系统管理人数',field:'sysManagementPersonsNum',width : '80',align:'center'},
                  {title:'系统管理率',field:'sysManagementRate',width : '70',align:'center'},
                  {title:'产后访视人数',field:'postGreat0Num',width : '80',align:'center'},
                  {title:'产后访视率',field:'postRate',width : '70',align:'center'},
                  {title:'血常规检查人数',field:'bloodNum',width : '90',align:'center'},
                  {title:'尿常规检查人数',field:'urineNum',width : '90',align:'center'},
                  {title:'血型',field:'bloodTypeNum',width : '40',align:'center'},
                  {title:'肝功能检查人数',field:'liverNum',width : '100',align:'center'},
                  {title:'肾功能检查人数',field:'kidneyNum',width : '100',align:'center'},
                  {title:'乙肝表抗检查人数',field:'hepatitisBNum',width : '100',align:'center'},
                  {title:'梅毒检查人数',field:'syphilisNum',width : '90',align:'center'},
                  {title:'艾滋病检查人数',field:'aidsNum',width : '100',align:'center'},
                  {title:'血红蛋白检查人数',field:'hemoglobinNum',width : '100',align:'center'},
                  {title:'尿蛋白检查人数',field:'urineProteinNum',width : '90',align:'center'},
                  {title:'结案产妇电子录入数',field:'actualCloseNum',width : '100',align:'center'}
                 ]],
                 onLoadSuccess: function(data){   
                     var panel = $(this).datagrid('getPanel');   
                     var tr = panel.find('div.datagrid-body tr');   
                     tr.each(function(){   
                         var td = $(this).children('td[field="departmentName"]');   
                         td.children("div").css({   
                             //"text-align": "right" 
                             "height": "50" 
                         });   
                     });   
                 }
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
       			   <select class="easyui-validatebox select" name="countyMechanism" id="countyMechanism" style="width:150px;height: 25px;position: absolute;left: 180px;top: 14px;border:#C8C9CD 1px solid;"></select>
				   <select class="easyui-validatebox select" name="townMechanism" id="townMechanism" style="width:150px;height: 25px;position: absolute;left: 355px;top: 14px;border:#C8C9CD 1px solid;"></select> &nbsp;
				   <select class="easyui-validatebox select" name="villageMechanism" id="villageMechanism" style="width:150px;height: 25px;position: absolute;left: 530px;top: 14px;border:#C8C9CD 1px solid;"></select>
      
        		 <span style="position: absolute;left: 120px;top: 48px;">结案日期：</span>
		         <input type="text" id="statisticnow" name="closeDateStare"  style="width: 150;height: 25px;position: absolute;left: 175px;top: 45px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
				 <span style="position: absolute;left: 337px;top: 49px">—</span>
				 <input type="text" id="statisticnow" name="closeDateEnd"  style="width: 150;height: 25px;position: absolute;left: 350px;top: 45px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
      	       
      	     <br> <br> <br><br>
			     <div style="position: absolute;right: 14%;top: 45">
			          	<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
			    </div> 
		        <div style="position: absolute;right: 7%;top: 45">
			          <a href="javascript:void(0)" class="easyui-linkbutton reset" id="reset"><i class="fa fa-undo"></i>重置</a>
			    </div> 
		        <div style="position: absolute;right: 0%;top: 45">
			          	<a href="javascript:void(0)" class="easyui-linkbutton export" id="export" onClick="exportExcel('queryForm','countyExport');"><i class="fa fa-file-text-o"></i>导出</a>
			    </div> 

			</form>
		</div>
	</div>
 </div>
</div>
	
	</body>
</html>
 
 
 
  