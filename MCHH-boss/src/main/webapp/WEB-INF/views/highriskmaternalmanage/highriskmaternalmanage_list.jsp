<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>高危孕产妇管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var selfUrl = "${ctx}/highriskmaternalmanage/list";
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
					window.location.href = "${ctx}/highriskmaternalmanage/list";
					return false;
				}
				
				//省份证  可数字+字母
				var queryIdReg = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X|x)$/;
				var queryId =$.trim($("#queryId").val());
				if(!queryIdReg.test(queryId)&&queryId!=""){
					alert("请输入正确格式的省份证号");
					window.location.href = "${ctx}/highriskmaternalmanage/list";
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
			
			//为列表绑定双击事件
			$('#dg').datagrid({
				onDblClickRow:function(rowIndex,rowData){
					var birthArchiveId = rowData.birthArchivesId;
					var archivesId = rowData.archivesId;
					window.location.href = "${ctx}/highriskprojectmanagement/list?birthArchiveId="+birthArchiveId+"&archivesId="+archivesId;
					
				}
			});
	    	
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
					{field:'ck',field:'全选',checkbox:true,width : '50',align:'center',rowspan:2,},
					{title:'建卡日期',field:'creatTime',width : '100',align:'center',rowspan:2,
					    formatter: function (value, row, index) {
					    	if(value==null){
								return "-";
							 }else{
					   	 var date = new Date(value);
					   	 var year = date.getFullYear().toString();
					   	 var month = (date.getMonth() + 1);
					   	 var day = date.getDate().toString();
					//    	 var hour = date.getHours().toString();
					//    	 var minutes = date.getMinutes().toString();
					//    	 var seconds = date.getSeconds().toString();
					   	 if (month < 10) {
					   		month = "0" + month;
					   	 }
					   	 if (day < 10) {
					   		 day = "0" + day;
					   	 }
					//    	 if (hour < 10) {
					//    	     hour = "0" + hour;
					//    	 }
					//    	 if (minutes < 10) {
					//    	 	minutes = "0" + minutes;
					//    	 }
					//    	 if (seconds < 10) {
					//    	    seconds = "0" + seconds;
					//         }
					//    	 return year + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds;
					   	 return year + "-" + month + "-" + day;
					    }}
					},
					
					{title:'编号',field:'archivesCode',width : '150',align:'center',rowspan:2,
						formatter: function (v) {
							if(v==null){
							  return "-"
							 }else{
								 return v;
							 }
						}
					},
					{title:'姓名',field:'name',width : '80',align:'center',rowspan:2,
						formatter: function (v) {
							if(v==null){
							  return "-"
							 }else{
								 return v;
							 }
						}
					},
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
					    	if(value==null){
								return "-";
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
					    }}
					},
					{title:'孕周',field:'weeks',width : '50',align:'center',rowspan:2,
						formatter: function (v) {
							if(v==null){
							  return "-"
							 }else{
								 return v;
							 }
						}
					},
					{title:'预产期',field:'predictDate',width : '100',align:'center',rowspan:2,
					 formatter: function (value, row, index) {
						 if(value==null){
								return "-";
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
					 }}
					},
					{title:'筛查日期',field:'checkDate',width : '100',align:'center',rowspan:2,
					 formatter: function (value, row, index) {
						 if(value==null){
								return "-";
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
					 }}
					},
					{title:'高危因素',field:'highRisk',width : '180',align:'center', rowspan:2,
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
					{title:'接诊医生',field:'doctorName',width : '80',align:'center',rowspan:2,
						formatter: function (v) {
							if(v==null){
							  return "-"
							 }else{
								 return v;
							 }
						}
					},
					{title:'转归',field:'lapseTo',width : '100',align:'center',rowspan:2,
						formatter: function (v) {
							if(v==null){
							  return "-"
							 }else{
								 return v;
							 }
						}
					},
					
					{title:'分娩情况',colspan:3},
					
					{title:'诊断结果',field:'diaResult',width : '200',align:'center',rowspan:2,
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
					{title:'档案ID',field:'archivesId',width : '100',align:'center',hidden:true}
					],[
					
					{title:'分娩日期',field:'birthDate',width : '100',align:'center',rowspan:1,
						 formatter: function (value, row, index) {
							 if(value==null){
								return "-";
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
						{title:'分娩地点',field:'childbirthPlace',width : '120',align:'center',rowspan:1,
							formatter: function (v) {
								if(v==null){
								  return "-"
								 }else{
									 return v;
								 }
							}
						},
						{title:'分娩方式',field:'deliveryType',width : '100',align:'center',rowspan:1,
							formatter: function (v) {
								if(v==null){
								  return "-"
								 }else{
									 return v;
								 }
							}
						},
                    
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
					<input type="hidden" name="thisHospitalId" value="${thisHospitalId }">
					<div style="height: 215px;width: 99%;">
							
					
							<div style="height: 30px">
									<p>本院本日新增：<span style="font-weight:700;color:#EE5F45;">${increaseNumToday }</span>人&nbsp;  
										转入：<span style="font-weight:700;color:#EE5F45;">${inNumToday }</span>人&nbsp; 
										转出：<span style="font-weight:700;color:#EE5F45;">${outNumToday }</span>人&nbsp; 
										本院共计：<span style="font-weight:700;color:#EE5F45;">${totalNum }</span>人&nbsp; 
										辖区内共计：<span style="font-weight:700;color:#EE5F45;">${allPeopleNum }<c:if test="${allPeopleNum ==null}">0</c:if></span>人</p>
							</div>
							
							<div style="height: 44px;width: 92%;border: 1px solid #CCCCCC;top: 34px;position: absolute;"></div>	
							<div style="height: 135px;width: 92%;border: 1px solid #CCCCCC;top: 85px;position: absolute;"></div>
											
							<div style="height: 50px">		  
								    <button style="background-color:#EE5F45; width:90px;height:35px;color:white;border: 0px" disabled="disabled">个案查询</button>
								    <span  style="position: absolute;left:120px;top: 47px;"> 档案编号：</span> <input id="queryCode" style="position:absolute; width: 150px;height: 25px;left: 180px;top: 45px;border:#C8C9CD 1px solid;" class="text1" type="text" name="archivesCode"/>
								    <span  style="position: absolute;left:370px;top: 47px">姓   名：</span>  <input id="queryName" style="position:absolute; width: 150px;height: 25px;left: 413px;top: 45px;border:#C8C9CD 1px solid;" class="text1" type="text" name="name"  /> 
									<span  style="position: absolute;left:600px;top: 47px">身份证号：</span> <input id="queryId" style="position:absolute; width: 150px;height: 25px;left: 660px;top: 45px;border:#C8C9CD 1px solid;" class="text1" type="text" name="idNo"/>
							</div>	
					
					
						      <button style="background-color:#EE5F45; width:90px;height:35px;color:white;border: 0px" disabled="disabled">综合查询</button>
						      
						     <span style="position: absolute;left:120px;top: 95px">医疗机构：</span>   
			        		 <select class="easyui-validatebox select" name="countyMechanism" id="countyMechanism" style="width:150px;height: 25px;position: absolute;left: 180px;top: 92px;border:#C8C9CD 1px solid;"></select>
							 <select class="easyui-validatebox select" name="townMechanism" id="townMechanism" style="width:150px;height: 25px;position: absolute;left: 350px;top: 92px;border:#C8C9CD 1px solid;"></select>
							 <select class="easyui-validatebox select" name="villageMechanism" id="villageMechanism" style="width:150px;height: 25px;position: absolute;left: 520px;top: 92px;border:#C8C9CD 1px solid;" ></select>
							 
							 
			              <span style="position: absolute;top: 95px;left: 755"> 高危评分：</span> 
					        <select id="u136_input" name="score" class="select1" style="height: 25px;width: 150px;position: absolute;top: 92px;left: 818;border:#C8C9CD 1px solid;">
					          <option value="0">0分</option>
					          <option value="5">5分</option>
					          <option value="10to15">10-15分</option>
					          <option value="G20">20分以上</option>
					          <option selected value="n">不限</option>
					        </select>
			        
						   <span style="position: absolute;left:120px;top: 128px">预 产 期：</span> 
						      <input type="text" id="statisticnow" name="exceptDateStare"   style="width: 150;height: 25px;position: absolute;left: 175px;top: 125px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
						       <span style="position: absolute;left: 334px;top: 129px;">—</span>
						       <input type="text" id="statisticnow" name="exceptDateEnd"  style="width: 150;height: 25px;position: absolute;;left: 345px;top: 125px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
						       <span style="position: absolute;left: 520px;top: 128px;">接诊医生：</span>
						     <select class="easyui-validatebox select" name="doctorId" id="realName" style="width:150px;height: 25px;position: absolute;left: 580px;top: 125px;border:#C8C9CD 1px solid;"></select>	
						     
						     <span style="position: absolute;left:755px;top: 128px">高危因素：</span>    
						        <select id="u138_input" name="highRisk" class="select1" style="height: 25px;width: 150px;position: absolute;left: 818px;top: 125px;border:#C8C9CD 1px solid;">
						          <option value="高血压">高血压</option>
						          <option value="糖尿病">糖尿病</option>
						          <option value="贫血">贫血</option>
						          <option value="m">其他</option>
						          <option selected value="n">不限</option> 
						        </select>
				
						     	<span style="position: absolute;left:120px;top: 160px">检查日期：</span>
						     	<input type="text" id="statisticnow" name="checkDateStare"  style="width: 150px;height: 25px;position: absolute;left: 175px;top: 157px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" /> 
						     	<span style="position: absolute;left: 334px;top: 162px;">—</span> 
						     	<input type="text" id="statisticnow" name="checkDateEnd"  style="width: 150px;height: 25px;position: absolute;left: 345px;top: 157px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
						
								<span style="position: absolute;left: 520px;top: 160px;"> 结案状态：</span>	 
						
						        <select id="u129_input" name="ifClose" style="height: 25px;width: 150px;position: absolute;left: 580px;top: 157px;border:#C8C9CD 1px solid;">
						          <option value="0">已结案</option>
						          <option value="1">未结案</option>
						          <option selected value="3">不限</option>
						        </select>
						 
						    	<select id="u130_input" name="statue" style="height: 25px;width: 150px;position: absolute;left:755px;top: 157px;border:#C8C9CD 1px solid;">
						          <option value="0">妊娠中</option>
						          <option value="1">正常分娩</option>
						            <option selected value="n">不限</option>
						        </select>&nbsp;
						        <select id="u160_input" name="closeReason" style="height: 25px;width: 150px;position: absolute;left:755px;top: 157px;border:#C8C9CD 1px solid;">
						          <option value="1">流产</option>
						          <option value="0">正常结案</option>
						          <option value="4 ">其他 </option>
						          <option value="2">引产</option>
						          <option value="3">失访</option>
						          <option selected value="n">不限</option>
						        </select>
								
					       <span style="position: absolute;left:120px;top: 193px">转诊日期：</span>   
					          <input type="text" id="statisticnow" name="referralTimeStare"  style="width: 150px;height:25px; position: absolute;left: 175px;top: 190px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" /> 
					          <span style="position: absolute;left: 334px;top: 196px;">—</span> 
					          <input type="text" id="statisticnow" name="referralTimeEnd"  style="width: 150px;height:25px; position: absolute;left: 345px;top: 190px;border:#C8C9CD 1px solid;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" />
					      	     
						<span style="position: absolute;left: 520px;top: 193px;"> 转诊状态：</span> 
					        <select name="referralStatue" class="select1" style="height: 25px;width: 150px;position: absolute;left: 580px;top: 190px;border:#C8C9CD 1px solid;">
					          <option value="in">转入</option>
					          <option value="this">本院</option>
					          <option value="out">转出</option>
					          <option value="n" selected >不限</option>
					        </select>
					
					
					       <span style="position: absolute;left:755px;top: 193px"> 转&nbsp;&nbsp;归：</span> 
					
					        <select name = "lapseTo" class="select1" style="height: 25px;width: 150px;position: absolute;;left: 818px;top: 190px;border:#C8C9CD 1px solid;">
					          <option value="0">继续监护</option>
					          <option value="2">结束分娩</option>
					          <option value="1">正常随访</option>
					          <option selected value="n">不限</option>
					        </select>
					        
					        
						     <a style="position: absolute;right: 0%;top: 65px" href="javascript:void(0)" class="easyui-linkbutton"  id="queryBtn"><i class="fa fa-search"></i>查询</a>
						     <a style="position: absolute;right: 0%;top: 125px" href="javascript:void(0)" class="easyui-linkbutton reset"  id="reset"><i class="fa fa-undo"></i>重置</a>
						     <a style="position: absolute;right: 0%;top: 185px" href="javascript:void(0)" class="easyui-linkbutton export"  id="export"><i class="fa fa-file-text-o"></i>导出</a>
						
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
