<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
	<head>
		<title>数据字典类别</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		<script type="text/javascript">
		var listUrl = "${ctx}/sys/codedict/category/list";
		var addUrl = "${ctx}/sys/codedict/category/add";
		var updateUrl = "${ctx}/sys/codedict/category/update";
		var delUrl = "${ctx}/sys/codedict/category/del";
		var codeListUrl = "${ctx}/sys/codedict/code/list";
		
		$(function() {
			//表格初始化
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
                {field:'ck',checkbox:true,width : '100',resizable:'false',align:'center'},
                {title:'类别名称',field:'categoryName',width : '450',resizable:'true',align:'center'},
                {title:'描述',field:'remark',width : '500',resizable:'true',align:'center'},
                {title:'操作',field:'Operation',width : '520',align:'center',formatter:operationFormate1}
               ]]
			});	
		});
		function operationFormate1(value,node){
			return operationFormate(value,node,[{'name':'detail','label':'查看'}]);
		}
 		 //修改
		 function detail(node){
 			 window.location = codeListUrl+"?categoryId="+node.id;
		}
 </script>
 	 <style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}	
 	</style>
	</head>

	<body class="panel-noscroll">
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
		<div>
			<form id="queryForm" method="post">
			<div  style="width:99%;height: 55px;border: 1px solid #CCCCCC;position: absolute;top: 3px;left: 3px;"></div>
			<div style="height: 35px; width: 90px; background-color: #EE5F45;color: white;position: absolute;left: 3px;top: 3px;text-align: center;line-height: 35px;">字典列表</div>
			<span style="position: absolute;left: 120px;top: 23px" >名称:</span>
			<input class="easyui-validatebox text" type="text" name="categoryName" style="width:150px;height: 25px;position: absolute;left: 155px;top: 20px;border:#C8C9CD 1px solid;"/>
			<span style="position: absolute;left: 350px;top: 23px">描述:</span> 
			<input class="easyui-validatebox text" type="text" name="remark" style="width:150px;height: 25px;position: absolute;left: 385px;top: 20px;border:#C8C9CD 1px solid;"/>
			<a style="position: absolute;left: 92%;top: 15px;background-color: #56BB4D;" href="javascript:void(0)" class="easyui-linkbutton"  id="queryBtn"><i class="fa fa-search"></i>查询</a>
			</form>
			<br><br><br><br>
		</div>
		<div data-options="region:'south',border:false">  
			<b:privilege url="sys/codedict/add">
			<a href="javascript:void(0)" class="easyui-linkbutton new"  onClick="add();" style="position: absolute;right: 6%">添加</a>
			</b:privilege>
			<b:privilege url="sys/codedict/del">
			<a href="javascript:void(0)" class="easyui-linkbutton reset"  onClick="del();" style="position: absolute;right: 0%">删除</a>
			</b:privilege>
			<br><br>
	</div></div>
		<!-- 新建字典 -->
		<div id="addOrUpdateWin" class="easyui-dialog" title="字典类别信息" closed="true">
			<form id="addOrUpdate" name="addOrUpdate" method="post">
			<input type="hidden" id="id" name="id"/>
				<table class="datagrid-body" width="100%" style="position: absolute;left: 10%;top: 10%">
					<tr>
					<td class="datagrid-header">
						字典类别：
						<span style="color: red;">*</span>
					</td>
					<td>
						<input name="categoryName" id="categoryName" class="easyui-validatebox text"  style="width:200px;" required="true" missingMessage="字典类别" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						描述：
					</td>
					<td>
						<textarea name="remark" id="remark" rows="5" cols="30" validType="colENameStr[500]" class="easyui-validatebox"></textarea>
					</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<a style="position: absolute;left: 25%;top: 95%;" href="javascript:void(0)" class="easyui-linkbutton save"  id="submitButton">保存</a>
							<a style="position: absolute;left:52%;top: 95%;" href="javascript:void(0)" class="easyui-linkbutton" 
								onClick="closeDialog_();">取消</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
