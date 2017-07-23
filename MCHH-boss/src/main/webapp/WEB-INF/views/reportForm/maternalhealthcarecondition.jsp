<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>孕产妇保健和健康情况报表</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/report/listMaternalReport";
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
					/*1*/{title:'填报单位1',field:'date1',width : '100',align:'center',rowspan:4},
					{title:'活产数',width : '100',align:'center',colspan:4,rowspan:2},
					{title:'产妇数',width : '100',align:'center',colspan:3,rowspan:2},
					{title:'产妇建卡',width : '100',align:'center',colspan:2,rowspan:2},
					{title:'孕产妇管理',width : '100',align:'center',colspan:26},
					{title:'接生情况',width : '100',align:'center',colspan:6},
					{title:'孕产妇高危管理',width : '100',align:'center',colspan:6},
					{title:'孕产妇死亡',width : '100',align:'center',colspan:12},
					{title:'围产儿情况',width : '100',align:'center',colspan:10},
					],[
					   
			   		{title:'产妇产前检查情况',width : '100',align:'center',colspan:6},
			   		{title:'孕产妇艾滋病病毒检测',width : '100',align:'center',colspan:4},
					{title:'孕产妇梅毒检测',width : '100',align:'center',colspan:4},
			   		{title:'孕产妇乙肝表面抗原检测',width : '100',align:'center',colspan:4},
					{title:'孕产妇产前筛查',width : '100',align:'center',colspan:4},
					{title:'产妇产后访视',width : '100',align:'center',colspan:2},
					{title:'产妇系统管理',width : '100',align:'center',colspan:2},
					{title:'住院分娩',width : '100',align:'center',colspan:2},
					{title:'剖宫产',width : '100',align:'center',colspan:2},
					{title:'新法接生',width : '100',align:'center',colspan:2},
					/*43*/{title:'高危产妇人数43',field:'date34',width : '100',align:'center',rowspan:3},
					/*44*/{title:'高危占总产妇数44',field:'date35',width : '100',align:'center',rowspan:3},
					{title:'高危产妇管理',width : '100',align:'center',colspan:2},
					{title:'高危产妇住院分娩',width : '100',align:'center',colspan:2},
					/*49*/{title:'死亡人数49',field:'date40',width : '100',align:'center',rowspan:3},
					/*50*/{title:'死亡率%50',field:'date41',width : '100',align:'center',rowspan:3},
					{title:'产科出血',width : '100',align:'center',colspan:2},
					{title:'妊娠高血压疾病',width : '100',align:'center',colspan:2},
					{title:'内科合并症',width : '100',align:'center',colspan:2},
					{title:'羊水栓塞',width : '100',align:'center',colspan:2},
					{title:'其他原因',width : '100',align:'center',colspan:2},
					/*61*/{title:'巨大儿数61',field:'date52',width : '100',align:'center',rowspan:3},
					/*62*/{title:'巨大儿百分比%62',field:'date53',width : '100',align:'center',rowspan:3},
					/*63*/{title:'早产儿数63',field:'date54',width : '100',align:'center',rowspan:3},
					/*64*/{title:'早产率%64',field:'date55',width : '100',align:'center',rowspan:3},
					/*65*/{title:'死胎死产数65',field:'date56',width : '100',align:'center',rowspan:3},
					{title:'早期新生儿死亡数',width : '100',align:'center',colspan:4},
					/*70*/{title:'围产儿死亡率70',field:'date61',width : '100',align:'center',rowspan:3},
					
					],[
					/*2*/{title:'合计2',field:'date2',width : '100',align:'center',rowspan:2},
					/*3*/{title:'男3',field:'date3',width : '120',align:'center',rowspan:2},
					/*4*/{title:'女4',field:'date4',width : '100',align:'center',rowspan:2},
					/*5*/{title:'性别不明5',field:'date5',width : '100',align:'center',rowspan:2},
					/*6*/{title:'合计6',field:'date6',width : '100',align:'center',rowspan:2},
					/*7*/{title:'非农业户籍7',field:'date7',width : '100',align:'center',rowspan:2},
					/*8*/{title:'农业户籍8',field:'date8',width : '100',align:'center',rowspan:2},
					/*9*/{title:'人数9',field:'date9',width : '100',align:'center',rowspan:2},
					/*10*/{title:'%10',field:'date10',width : '100',align:'center',rowspan:2},
			  {title:'产检',width : '100',align:'center',colspan:2},
			  {title:'产检≥5次',width : '100',align:'center',colspan:2},
			  {title:'早检',width : '100',align:'center',colspan:2},
			  /*17*/{title:'检测人数17',field:'date17',width : '100',align:'center',rowspan:2},
			  /*18*/ {title:'%18',field:'date18',width : '100',align:'center',rowspan:2},
			 {title:'感染',width : '100',align:'center',colspan:2},
			 /*21*/{title:'检测人数21',field:'date21',width : '100',align:'center',rowspan:2},
			 /*22*/{title:'%22',field:'date22',width : '100',align:'center',rowspan:2},
			 {title:'感染',width : '100',align:'center',colspan:2},
			 /*25*/{title:'检测人数25',field:'date25',width : '100',align:'center',rowspan:2},
			 /*26*/{title:'%26',field:'date26',width : '100',align:'center',rowspan:2},
			 {title:'阳性',width : '100',align:'center',colspan:2},
			 /*29*/{title:'检测人数29',field:'date29',width : '100',align:'center',rowspan:2},
			 /*30*/{title:'%30',field:'date30',width : '100',align:'center',rowspan:2},
			 {title:'高危',width : '100',align:'center',colspan:2},
			 /*33*/{title:'人数33',field:'date33',width : '100',align:'center',rowspan:2},
			 /*34*/{title:'%34',field:'date36',width : '100',align:'center',rowspan:2},
			 /*35*/{title:'人数35',field:'date37',width : '100',align:'center',rowspan:2},
			 /*36*/{title:'%36',field:'date38',width : '100',align:'center',rowspan:2},
			 /*37*/{title:'活产数37',field:'date39',width : '100',align:'center',rowspan:2},
			 /*38*/{title:'%38',field:'date42',width : '100',align:'center',rowspan:2},	
			 /*39*/{title:'活产数39',field:'date43',width : '100',align:'center',rowspan:2},
			 /*40*/{title:'%40',field:'date44',width : '100',align:'center',rowspan:2},
			 /*41*/{title:'活产数41',field:'date45',width : '100',align:'center',rowspan:2},
			 /*42*/{title:'%42',field:'date46',width : '100',align:'center',rowspan:2},
			 /*45*/{title:'人数45',field:'date47',width : '100',align:'center',rowspan:2},
			 /*46*/{title:'%46',field:'date48',width : '100',align:'center',rowspan:2},
			 /*47*/{title:'人数47',field:'date49',width : '100',align:'center',rowspan:2},
			 /*48*/{title:'%48',field:'date50',width : '100',align:'center',rowspan:2},
			 /*51*/{title:'人数51',field:'date51',width : '100',align:'center',rowspan:2},
			 /*52*/{title:'%52',field:'date57',width : '100',align:'center',rowspan:2},
			 /*53*/{title:'人数53',field:'date58',width : '100',align:'center',rowspan:2},
			 /*54*/{title:'%54',field:'date59',width : '100',align:'center',rowspan:2},
			 /*55*/{title:'人数55',field:'date60',width : '100',align:'center',rowspan:2},
			 /*56*/{title:'%56',field:'date62',width : '100',align:'center',rowspan:2},
			 /*57*/{title:'人数57',field:'date63',width : '100',align:'center',rowspan:2},
			 /*58*/{title:'%58',field:'date64',width : '100',align:'center',rowspan:2},
			 /*59*/ {title:'人数59',field:'date65',width : '100',align:'center',rowspan:2},
			 /*60*/ {title:'%60',field:'date66',width : '100',align:'center',rowspan:2},
			 /*66*/{title:'合计66',field:'date67',width : '100',align:'center',rowspan:2},
			 /*67*/{title:'男67',field:'date68',width : '100',align:'center',rowspan:2},
			 /*68*/{title:'女68',field:'date69',width : '100',align:'center',rowspan:2},
			 /*69*/{title:'性别不明69',field:'date70',width : '100',align:'center',rowspan:2},
			],[
			   /*11*/{title:'人数11',field:'date11',width : '100',align:'center'},
			   /*12*/{title:'%12',field:'date12',width : '100',align:'center'},
			   /*13*/{title:'人数13',field:'date13',width : '100',align:'center'},
			   /*14*/{title:'%14',field:'date14',width : '100',align:'center'},
			   /*15*/{title:'人数15',field:'date15',width : '100',align:'center'},
			   /*16*/{title:'%16',field:'date16',width : '100',align:'center'},
			   /*19*/{title:'人数19',field:'date19',width : '100',align:'center'},
			   /*20*/{title:'1/10万20',field:'date20',width : '100',align:'center'},
			   /*23*/{title:'人数23',field:'date23',width : '100',align:'center'},
			   /*24*/{title:'%24',field:'date24',width : '100',align:'center'},
			   /*27*/{title:'人数27',field:'date27',width : '100',align:'center'},
			   /*28*/{title:'1/10万28',field:'date28',width : '100',align:'center'},
			   /*31*/{title:'%31',field:'date31',width : '100',align:'center'},
			   /*32*/{title:'人数32',field:'date32',width : '100',align:'center'},
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
				
					     	<span style="position: absolute;left:120px;top: 37px">结案日期：</span>
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
