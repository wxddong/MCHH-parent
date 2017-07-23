<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>婚前保健情况报表</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		
		 
		var selfUrl = "${ctx}/report/listCheck";
		var listUrl = selfUrl;
		//导出premaritalcheck
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
			
	
			
			
			
	    	
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'id',checkbox:true,width : '30',resizable:'false',align:'center'},
                 {title:'编号',field:'archivesCode', width : '240',resizable:'true',align:'center'},
                 {title:'姓名',field:'name',width : '70', resizable:'true',align:'center'},
                 {title:'性别',field:'sex', width : '110', resizable:'true',align:'center',
                	 formatter:function(v){ 
                         if(v=="0"){
                             return "女"
                         } 
                         if(v=="1"){
                             return "男"
                         } 
                     } 
                 
                 },
                 
                 {title:'年龄',field:'age',width : '90',resizable:'true',align:'center'},
                 {title:'联系电话',field:'telephone',width : '120',resizable:'true',align:'center'},
                 {title:'家庭住址',field:'homeAddress',width : '250',resizable:'true',align:'center'},
                 {title:'检查日期',field:'checkDate',formatter:formatDate,width : '90',resizable:'true',align:'center'},
                 {title:'检出疾病',field:'dises',width : '240',resizable:'true',align:'center'}
                ]]
			});
			
		
		});
		 //重置   
	    function reset(){
	    	$(".Wdate").val("");
	    	$("#sex")[0].selectedIndex = 0;
	    	$("#exc1")[0].selectedIndex = 0;
	    	$("#exc2")[0].selectedIndex = 0;
	    	$("#exc3")[0].selectedIndex = 0;
	    	$("#exc4")[0].selectedIndex = 0;
	    	$("#exc5")[0].selectedIndex = 0;
	    	$("#exc6")[0].selectedIndex = 0;
	    	
	    }
		
	
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
					<div style="height: 160px;width: 100%;">
							
							<div style="height: 160px;width: 75%;border: 1px solid #CCCCCC;top: 5px;position: absolute;">
											
							<div style="height: 50px">		  
								    <button style="background-color:#EE5F45; width:90px;height:35px;color:white;border: 0px" disabled="disabled">综合查询</button>
							</div>	
				
					     	 <p> 
				 <span style="position: absolute;top: 20px;left: 118px">检查时间： </span>
				 <input type="text" id="checkDateStare" name="checkDateStare"  style="color:#adadaf,width:150px;height: 25px;top: 17px;left: 170px;position: absolute;"
	      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate"/>
	      	       <span style="position: absolute;top: 23px;left: 329px">-</span>
	      	       <input type="text" id="checkDateEnd" name="checkDateEnd"   style="color:#adadaf,width:150px;height: 25px;top: 17px;left: 335px;position: absolute;"
	      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate"/>
				 <span style="position: absolute;top: 20px;left: 520px">性别：</span>
				<select class="easyui-validatebox select" name="sex" id="sex"  style="width:150px;height: 25px;position: absolute;top: 17px;left: 555px">
					  <option>不限</option>
			          <option value="0">女</option>
			          <option value="1">男</option>
				 </select>
			 </p>
			 <p>
				<span style="position: absolute;top: 53px;left: 105px">指定传染病：</span> 
				 <select class="easyui-validatebox select" name="exc1" id="exc1" style="width:150px;height: 25px;position: absolute;top:50px;left: 175px; ">
				 	  <option value="不限">不限</option>
				 	  <option value="无">无</option>
			          <c:forEach items="${list1 }" var="list">
			         	 <option value="${list.id }">${list.name }</option>
			          </c:forEach>
				 </select>
				 
				  <span style="position: absolute;top: 53px;left: 483px">严重遗传病：</span>
				<select class="easyui-validatebox select" name="exc2" id="exc2"  style="width:150px;height: 25px;position: absolute;top: 50px;left: 555px;">	
					<option value="不限">不限</option>
					<option value="无">无</option>			 
			          <c:forEach items="${list2 }" var="list">
			         	 <option value="${list.id }">${list.name }</option>
			          </c:forEach>

				 </select>
			</p>
			<p>
				 <span style="position: absolute;top: 86;left: 129px;">精神病：</span>
				 <select class="easyui-validatebox select" name="exc3" id="exc3" style="width:150px;height: 25px;position: absolute;top: 83px;left: 175px">
					 <option value="不限">不限</option>
					 <option value="无">无</option>
			          <c:forEach items="${list3 }" var="list">
			         	 <option value="${list.id }">${list.name }</option>
			          </c:forEach>
		 	
				 </select>
				 <span style="position: absolute;top: 86px;left: 447px">女性生殖系统疾病：</span>
				<select class="easyui-validatebox select" name="exc4" id="exc4"  style="width:150px;height: 25px;position: absolute;top: 83px;left: 555px;">
					<option value="不限">不限</option>
					<option value="无">无</option>
			          <c:forEach items="${list5 }" var="list">
			         	 <option value="${list.id }">${list.name }</option>
			          </c:forEach>
				 </select>
			</p>
			<p>
				<span style="position: absolute;top: 119;left: 118px;">内科疾病：</span> 
				 <select class="easyui-validatebox select" name="exc5" id="exc5" style="width:150px;height: 25px;position: absolute;top: 116px;left:175px; ">
					 <option value="不限">不限</option>
					 <option value="无">无</option>
			          <c:forEach items="${list6 }" var="list">
			         	 <option value="${list.id }">${list.name }</option>
			          </c:forEach>		 	
				 </select>	 
				<span style="position: absolute;top: 119px;left: 447px">男性生殖系统疾病：</span>
				 <select class="easyui-validatebox select" name="exc6" id="exc6" style="width:150px;height: 25px;position: absolute;top: 116;left: 555px;">
					 <option value="不限">不限</option>
					 <option value="无">无</option>
			          <c:forEach items="${list4 }" var="list">
			         	 <option value="${list.id }">${list.name }</option>
			          </c:forEach>			 	
				 </select>
				 
			</p>

</div>



					
					         
			     <div style="position: absolute;right: 16%;top: 132px">
			          	<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
			    </div> 
		        <div style="position: absolute;right: 8%;top: 132px">
			          <a href="javascript:void(0)" class="easyui-linkbutton reset" id="reset" onClick="reset();"><i class="fa fa-undo"></i>重置</a>
			    </div> 
		        <div style="position: absolute;right: 0%;top: 132px">
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

