<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>婚前保健情况报表</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/report/list";
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
					{title:'结婚登记与婚前医学保健情况',width : '100',align:'center',colspan:5,rowspan:2},
					{title:'检出疾病分类',width : '100',align:'center',colspan:14},
					{title:'对影响婚育疾病的医学意见',width : '100',align:'center',colspan:2,rowspan:2}
					],[
					   
			   /*6*/{title:'检出疾病人数6',field:'date1',width : '100',align:'center',rowspan:3},
			   /*7*/{title:'占实际检验的%',field:'date2',width : '100',align:'center',rowspan:3},
					{title:'指定传染病',width : '100',align:'center',colspan:4},
					{title:'严重遗传病',width : '100',align:'center',colspan:2},
					{title:'精神病',width : '100',align:'center',colspan:2},
					{title:'生殖系统病',width : '100',align:'center',colspan:2},
					{title:'内科系统病',width : '100',align:'center',colspan:2},
					
					],[
					{title:'结婚登记',width : '100',align:'center',colspan:1},
					{title:'婚前医学检查',width : '120',align:'center',colspan:2},
					{title:'婚前卫生咨询',width : '100',align:'center',colspan:2},
					
			   /*8*/{title:'人数',field:'date8',width : '100',align:'center',rowspan:2},
			   /*9*/{title:'占检出人数的%',field:'date9',width : '100',align:'center',rowspan:2},
					{title:'性病',width : '100',align:'center',colspan:2},
					
			  /*12*/{title:'人数',field:'date12',width : '100',align:'center',rowspan:2},
			  /*13*/{title:'占检出人数的%',field:'date13',width : '100',align:'center',rowspan:2},
					
			  /*14*/{title:'人数',field:'date14',width : '100',align:'center',rowspan:2},
			  /*15*/{title:'占检出人数的%',field:'date15',width : '100',align:'center',rowspan:2},
					
			  /*16*/{title:'人数',field:'date16',width : '100',align:'center',rowspan:2},
			  /*17*/{title:'占检出人数的%',field:'date17',width : '100',align:'center',rowspan:2},
					
			  /*18*/{title:'人数',field:'date18',width : '100',align:'center',rowspan:2},
			  /*19*/{title:'占检出人数的%',field:'date19',width : '100',align:'center',rowspan:2},
					
			  /*20*/{title:'人数',field:'date20',width : '100',align:'center',rowspan:2},
			  /*21*/{title:'占实检的%',field:'date21',width : '100',align:'center',rowspan:2},
					
					],[
			   /*1*/{title:'人数',field:'date3',width : '100',align:'center'},
			   /*2*/{title:'人数',field:'date4',width : '100',align:'center'},
			   /*3*/{title:'%',field:'date5',width : '100',align:'center'},
			   /*4*/{title:'人数',field:'date6',width : '100',align:'center'},
			   /*5*/{title:'%',field:'date7',width : '100',align:'center'},
			
			   /*10*/{title:'人数',field:'date10',width : '100',align:'center'},
			   /*11*/{title:'占检出人数的%',field:'date11',width : '100',align:'center'},
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
					<div style="height: 90px;width: 100%;">
							
							<div style="height: 88px;width: 75%;border: 1px solid #CCCCCC;top: 5px;position: absolute;"></div>
											
							<div style="height: 50px">		  
								    <button style="background-color:#EE5F45; width:90px;height:35px;color:white;border: 0px" disabled="disabled">综合查询</button>
							</div>	
				
					     	<span style="position: absolute;left:120px;top: 37px">检查日期：</span>
					     	<input type="text" id="checkDateStare" name="checkDateStare"  style="width: 150px;height: 25px;position: absolute;left: 175px;top: 35px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" /> 
					     	<span style="position: absolute;left: 334px;top: 38px;">—</span> 
					     	<input type="text" id="checkDateEnd" name="checkDateEnd"  style="width: 150px;height: 25px;position: absolute;left: 345px;top: 35px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
					
							<span style="position: absolute;left: 520px;top: 37px;">统计单位：镇平县</span>	 
					
					         <br> <br> <br><br>
			     <div style="position: absolute;right: 16%;top: 59px">
			          	<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
			    </div> 
		        <div style="position: absolute;right: 8%;top: 59px">
			          <a href="javascript:void(0)" class="easyui-linkbutton reset" id="reset"><i class="fa fa-undo"></i>重置</a>
			    </div> 
		        <div style="position: absolute;right: 0%;top: 59px">
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

