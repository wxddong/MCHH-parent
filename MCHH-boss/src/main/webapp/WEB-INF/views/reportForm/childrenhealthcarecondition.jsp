<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>孕产妇保健和健康情况报表</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/report/listChildrenReport";
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
					/*1*/{title:'填报单位1',field:'date1',width : '100',align:'center',rowspan:3},
					{title:'活产数',width : '100',align:'center',colspan:4,rowspan:2},
					{title:'儿童数',width : '100',align:'center',colspan:3},
					{title:'5岁以下儿童死亡情况',width : '100',align:'center',colspan:15},
					{title:'6个月内婴儿母乳喂养情况',width : '100',align:'center',colspan:5},
					{title:'7岁以下儿童保健服务',width : '100',align:'center',colspan:12},
					{title:'5岁以下儿童营养评价',width : '100',align:'center',colspan:14},
					],[
					   
			   		/*6*/{title:'7岁以下6',field:'date2',width : '100',align:'center',rowspan:2},
			   		/*7*/{title:'5岁以下7',field:'date3',width : '100',align:'center',rowspan:2},
			   		/*8*/{title:'3岁以下8',field:'date4',width : '100',align:'center',rowspan:2},
			   		{title:'5岁以下儿童死亡数',width : '100',align:'center',colspan:4},
			   		/*13*/{title:'5岁以下儿童死亡率（‰）13',field:'date9',width : '100',align:'center',rowspan:2},
					{title:'婴儿死亡数',width : '100',align:'center',colspan:4},
					/*18*/{title:'婴儿死亡率（‰）14',field:'date14',width : '100',align:'center',rowspan:2},
					{title:'新生儿死亡数',width : '100',align:'center',colspan:4},
					/*23*/{title:'新生儿死亡率23',field:'date19',width : '100',align:'center',rowspan:2},
					/*24*/{title:'调查人数24',field:'date20',width : '100',align:'center',rowspan:2},
					{title:'母乳喂养',width : '100',align:'center',colspan:2},
					{title:'纯母乳喂养',width : '100',align:'center',colspan:2},
					{title:'新生儿访视',width : '100',align:'center',colspan:2},
					{title:'新生儿苯丙酮尿症筛查',width : '100',align:'center',colspan:2},
					{title:'新生儿甲状腺功能减低症筛查',width : '100',align:'center',colspan:2},
					{title:'新生儿听力筛查',width : '100',align:'center',colspan:2},
					{title:'7岁以下儿童保健覆盖',width : '100',align:'center',colspan:2},
					{title:'3岁以下儿童系统管理',width : '100',align:'center',colspan:2},
					{title:'身长（长）体重检查',width : '100',align:'center',colspan:9},
					{title:'血红蛋白',width : '100',align:'center',colspan:5},
					
					],[
					/*2*/{title:'合计2',field:'date5',width : '100',align:'center',rowspan:1},
					/*3*/{title:'男3',field:'date6',width : '120',align:'center',rowspan:1},
					/*4*/{title:'女4',field:'date7',width : '100',align:'center',rowspan:1},
					/*5*/{title:'性别不明5',field:'date8',width : '100',align:'center',rowspan:1},
					/*9*/{title:'合计9',field:'date10',width : '100',align:'center',rowspan:1},
					/*10*/{title:'男10',field:'date11',width : '120',align:'center',rowspan:1},
					/*11*/{title:'女11',field:'date12',width : '100',align:'center',rowspan:1},
					/*12*/{title:'性别不明12',field:'date13',width : '100',align:'center',rowspan:1},
					/*14*/{title:'合计14',field:'date15',width : '100',align:'center',rowspan:1},
					/*15*/{title:'男15',field:'date16',width : '120',align:'center',rowspan:1},
					/*16*/{title:'女16',field:'date17',width : '100',align:'center',rowspan:1},
					/*17*/{title:'性别不明17',field:'date18',width : '100',align:'center',rowspan:1},
					/*19*/{title:'合计19',field:'date21',width : '100',align:'center',rowspan:1},
					/*20*/{title:'男20',field:'date22',width : '120',align:'center',rowspan:1},
					/*21*/{title:'女21',field:'date23',width : '100',align:'center',rowspan:1},
					/*22*/{title:'性别不明22',field:'date24',width : '100',align:'center',rowspan:1},
					/*25*/{title:'人数25',field:'date25',width : '100',align:'center',rowspan:1},
					/*26*/{title:'率%26',field:'date26',width : '100',align:'center',rowspan:1},
					/*27*/{title:'人数27',field:'date27',width : '100',align:'center',rowspan:1},
					/*28*/{title:'率%28',field:'date28',width : '100',align:'center',rowspan:1},
					/*29*/{title:'人数29',field:'date29',width : '100',align:'center',rowspan:1},
					/*30*/{title:'率%30',field:'date30',width : '100',align:'center',rowspan:1},
					/*31*/{title:'人数31',field:'date31',width : '100',align:'center',rowspan:1},
					/*32*/{title:'率%32',field:'date32',width : '100',align:'center',rowspan:1},
					/*33*/{title:'人数33',field:'date33',width : '100',align:'center',rowspan:1},
					/*34*/{title:'率%34',field:'date34',width : '100',align:'center',rowspan:1},
					/*35*/{title:'人数35',field:'date35',width : '100',align:'center',rowspan:1},
					/*36*/{title:'率%36',field:'date36',width : '100',align:'center',rowspan:1},
					/*37*/{title:'人数37',field:'date37',width : '100',align:'center',rowspan:1},
					/*38*/{title:'率%38',field:'date38',width : '100',align:'center',rowspan:1},
					/*39*/{title:'人数39',field:'date39',width : '100',align:'center',rowspan:1},
					/*40*/{title:'率%40',field:'date40',width : '100',align:'center',rowspan:1},
					/*41*/{title:'检查人数41',field:'date41',width : '100',align:'center',rowspan:1},
					/*42*/{title:'低体重人数42',field:'date42',width : '100',align:'center',rowspan:1},
					/*43*/{title:'低体重率%43',field:'date43',width : '100',align:'center',rowspan:1},
					/*44*/{title:'生长迟缓人数44',field:'date44',width : '100',align:'center',rowspan:1},
					/*45*/{title:'生长迟缓率%45',field:'date45',width : '100',align:'center',rowspan:1},
					/*46*/{title:'超重人数46',field:'date46',width : '100',align:'center',rowspan:1},
					/*47*/{title:'超重率率%47',field:'date47',width : '100',align:'center',rowspan:1},
					/*48*/{title:'肥胖人数48',field:'date48',width : '100',align:'center',rowspan:1},
					/*49*/{title:'肥胖率%49',field:'date49',width : '100',align:'center',rowspan:1},
					/*50*/{title:'检查人数50',field:'date50',width : '100',align:'center',rowspan:1},
					/*51*/{title:'贫血患病热人数51',field:'date51',width : '100',align:'center',rowspan:1},
					/*52*/{title:'贫血患病率52',field:'date52',width : '100',align:'center',rowspan:1},
					/*53*/{title:'中重度贫血患病人数53',field:'date53',width : '100',align:'center',rowspan:1},
					/*54*/{title:'中重度贫血患病率%54',field:'date54',width : '100',align:'center',rowspan:1},
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
				
					     	<span style="position: absolute;left:120px;top: 37px">统计日期：</span>
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
