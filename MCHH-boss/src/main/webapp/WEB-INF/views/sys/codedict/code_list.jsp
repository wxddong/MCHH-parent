<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
	<head>
		<title>数据字典信息</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		<script type="text/javascript">
		var categoryListUrl = "${ctx}/sys/codedict/category/list";
		var listUrl = "${ctx}/sys/codedict/code/list";
		var addUrl = "${ctx}/sys/codedict/code/add";
		var updateUrl = "${ctx}/sys/codedict/code/update";
		var delUrl = "${ctx}/sys/codedict/code/del";
		$(function() {
			$.grid({id:'#dg',url:listUrl+'?categoryId='+$('#categoryId').val(),title:"数据字典信息",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,width : '100',resizable:'false',align:'center'},
                 {title:'代码键',field:'codeKey',width : '100',resizable:'true',align:'center'},
                 {title:'代码值',field:'codeValue',width : '100',resizable:'true',align:'center'},
                 {title:'描述',field:'remark',width : '100',resizable:'true',align:'center'}
                ]]
			});	
		});
 		function gocatagory(){
 			window.location = categoryListUrl;
 			
 		}
 </script>
 	 <style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}	
 	</style>
	</head>

	<body class="panel-noscroll">
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto"><div>
		</div>
		<div data-options="region:'south',border:false">  
			<b:privilege url="sys/codedict/add">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onClick="add();">添加</a>
			</b:privilege>
			<b:privilege url="sys/codedict/del">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onClick="del();">删除</a>
			</b:privilege>
			<b:privilege url="sys/codedict/update">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onClick="edit();">修改</a>
			</b:privilege>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true" onClick="gocatagory();">返回</a>
	</div></div>
		<!-- 新建字典 -->
		<div id="addOrUpdateWin" class="easyui-dialog" title="字典信息" closed="true">
			<form id="addOrUpdate" name="addOrUpdate" method="post">
			<input type="hidden" id="categoryId" name="categoryId" value="${categoryId}" reset="false">
			<input type="hidden" id="id" name="id"/>
				<table class="datagrid-body" width="100%">
					<tr>
					<td class="datagrid-header">
						代码健：
						<span style="color: red;">*</span>
					</td>
					<td>
						<input name="codeKey" id="codeKey" class="easyui-validatebox text"  style="width:200px;" required="true" missingMessage="代码健" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						代码值：
						<span style="color: red;">*</span>
					</td>
					<td>
						<input name="codeValue" id="codeValue" class="easyui-validatebox text" style="width:200px;" required="true" missingMessage="代码值" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						顺序：
						<span style="color: red;">*</span>
					</td>
					<td>
						<input name="onum" id="onum" class="easyui-validatebox text"  style="width:200px;" required="true" missingMessage="顺序" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						描述：
					</td>
					<td>
						<textarea name="remark" id="remark" rows="5" cols="30" validType="colENameStr[500]" class="easyui-validatebox" ></textarea>
					</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" id="submitButton">保存</a>
							<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
								onClick="closeDialog_();">取消</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
