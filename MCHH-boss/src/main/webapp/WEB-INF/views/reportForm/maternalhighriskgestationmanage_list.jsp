<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>婚前保健情况报表</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/report/maternalhighriskgestationmanagelist";
		var listUrl = selfUrl;
		//导出
		var exportUrl = "${ctx}/export";
		$(function() {
			
			$("#export").click(function(){
				//选中复选框后，导出选中的行
// 				var rows = $('#dg').datagrid('getSelections');
// 				if(rows==null || rows==""){
// 					exportExcel('queryForm','highRiskMaternalExport');
// 				}else{
// 					var ids = []; 
// 					for(var i=0; i<rows.length; i++){
// 						ids.push(rows[i].name);
// 					}
// 					var str =  '<input type="hidden" name="ids"  value="'+ids+'" ></input>'
// 					alert(str);
// 					$("#selectedRows").append(str);
// 					exportExcel('selectedRows','highRiskMaternalExport');
// 				}
				exportExcel('queryForm','highRiskMaternalExport');
				
			});
			
	
			
			
			//重置按钮点击事件  $("#villageMechanism")[0].selectedIndex = -1;
			$("#reset").click(function(){
				$(".Wdate").val("");
				return false;
			});
			
	    	
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[
			         
			        [
// 					{field:'ck',field:'全选',checkbox:true,width : '50',align:'center',rowspan:5},
					{title:'管理单位',field:'hospitalName',width : '200',align:'center'},
					{title:'孕产妇总数',field:'maternalNum',width : '200',align:'center'},
					{title:'高危产妇筛选人数',field:'maternalFilterNum',width : '200',align:'center'},
					{title:'高危产妇筛选率',field:'maternalFilterRate',width : '200',align:'center'},
					{title:'高危产妇管理人数',field:'maternalManageNum',width : '200',align:'center'},
					{title:'高危产妇管理率',field:'maternalManageRate',width : '200',align:'center'},
					{title:'高危产妇上转人数',field:'turnOnNum',width : '200',align:'center'},
					{title:'高危产妇上转率',field:'turnOnRate',width : '200',align:'center'},
                  ]
			        
			      ]
			
		
		
		
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
					<div style="height: 98px;width: 100%;">
							
							<div style="height: 97px;width: 75%;border: 1px solid #CCCCCC;top: 5px;position: absolute;"></div>
											
							<div style="height: 50px">		  
								    <button style="background-color:#EE5F45; width:90px;height:35px;color:white;border: 0px" disabled="disabled">综合查询</button>
							</div>	
							
							
				
					     	<span style="position: absolute;top: 37px;left: 120px;">医疗机构：</span>
				        	<select style="position: absolute;top: 34px;left: 180px;width: 150px;height: 25px">
				        	  <option value="镇平县妇幼保健院">镇平县妇幼保健院</option>
				        	  <option value="不限">不限</option>
				   	     </select>
  
				      	  <select style="position: absolute;top: 34px;left: 350px;width: 150px;height: 25px">
				        	  <option value="选择乡镇级机构">选择乡镇级机构</option>
				       	 	  <option value="不限">不限</option>
				      	  </select>
   
      
		     			<span style="position: absolute;top: 70px;left: 120px;"> 结案日期：</span>
		     		   <input type="text" id="statisticnow" name="closeDateStare"   style="color:#adadaf;width: 150px;height: 25px;position: absolute;top: 67;left: 175px"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
						<span style="position: absolute;top: 73px;left: 335px">—</span> 
		   			<input type="text" id="statisticnow" name="closeDateEnd"   style="color:#adadaf;width: 150px;height: 25px;position: absolute;top: 67;left: 345px "
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
		      	       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      	       
		
					         <br> <br> <br><br>
			     <div style="position: absolute;right: 16%;top: 68px">
			          	<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
			    </div> 
		        <div style="position: absolute;right: 8%;top: 68px">
			          <a href="javascript:void(0)" class="easyui-linkbutton reset" id="reset"><i class="fa fa-undo"></i>重置</a>
			    </div> 
		        <div style="position: absolute;right: 0%;top: 68px">
			          	<a href="javascript:void(0)" class="easyui-linkbutton export" id="export" onClick="exportExcel('queryForm','countyExport');"><i class="fa fa-file-text-o"></i>导出</a>
			    </div> 
			</div>	
</form>	
	<form id="selectedRows" method="post">
	  
	</form>

		</div>
	</div>
 </div>
</div>
	
	</body>
</html>

