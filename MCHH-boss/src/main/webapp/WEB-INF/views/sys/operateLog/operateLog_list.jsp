<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>操作日志管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		<script type="text/javascript">
		var fid = '-1';
		var selfUrl = "${ctx}/sys/operateLog/list";
		var listUrl = selfUrl;
		$(function() {
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
               {title:'操作员',field:'loginName',align:'center',width : '190'},
               {title:'操作时间',field:'operateTime',align:'center',formatter:formattime,width : '270'},
               {title:'操作对象',field:'resName',align:'center',width : '250'},
               {title:'操作结果',field:'operateResult',align:'center',width : '250',
             	  formatter:function(v){ return v==0?'失败':'成功' }},
               {title:'操作数据',field:'operateData',width:'470',align:'center'}
              ]]
		});	
		});
 </script>
 <style type="text/css">
 		.combo-p{border:1px solid #95B8E7;}
 		.panel-fit body .panel-body{overflow-y:auto; overflow-x:hidden;} 		
 	</style>
	</head>
	<body>
	<div id="rolePanel" class="easyui-layout" fit="true" >
	 <div region="center" style="padding: 1px;">
	 <table id="dg"></table>
	 <div id="tb" style="padding:5px;height:auto">
		<div>
			<form id="queryForm" method="post">
			<div  style="width:99%;height: 55px;border: 1px solid #CCCCCC;position: absolute;top: 3px;left: 3px;"></div>
			<div style="height: 35px; width: 90px; background-color: #EE5F45;color: white;position: absolute;left: 3px;top: 3px;text-align: center;line-height: 35px;">操作列表</div>
			<span style="position: absolute;left: 120px;top: 23px">名称:</span> 
			<input class="easyui-validatebox text" type="text" name="loginName" style="width:150px;height: 25px;position: absolute;left: 170px;top: 20px;border:#C8C9CD 1px solid;"/>
			<a style="position: absolute;left: 92%;top: 15px;background-color: #56BB4D;" href="javascript:void(0)" class="easyui-linkbutton"  id="queryBtn"><i class="fa fa-search"></i>查询</a>
			</form>查询</a>
			<br><br><br>
			</form>
		</div>
	</div>
	</div>
 </div>
</body>
</html>
