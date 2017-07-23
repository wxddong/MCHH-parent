<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>科室管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		<script type="text/javascript">
		var getResUrl = "${ctx}/sys/resources/treegrant";
		var selfUrl = "${ctx}/sys/role/list";
		var addUrl = "${ctx}/sys/role/add";
		var updateUrl = "${ctx}/sys/role/update";
		var delUrl = "${ctx}/sys/role/del";
		var beforeDelUrl = "${ctx}/sys/role/beforeDel";
		var updateGrantUrl="${ctx}/sys/role/grant/update";
		var listUrl = selfUrl;
		$(function() {
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
                  {field:'ck',checkbox:true,width : '270',align:'center'},
                  {title:'科室名称',field:'name',width : '400',align:'center'},
                  {title:'可用标识',field:'flag',width : '450',align:'center',
                	  formatter:function(v){ return v==0?'停用':'正常' }},
                  {title:'描述',field:'remark',width : '500',align:'center'}
                 ]]
			});	
			
		});
		 //资源授权
		function grant(){
			var node = getSelected('grant');
			$("#function-panel").panel(
				{
					title :node.name+":当前权限",
					tools:[{iconCls:'fa fa-save',handler:function(){mysubmit(node.id);}},
						{iconCls:'fa fa-history',handler:function(){$('#rolePanel').layout('collapse','east'); }}]
				}
			);
			//$('#function-panel').panel("refresh", getResUrl+"&roleId=" + id);
			$.post(getResUrl,{'roleId':node.id}, function(data){
				var treedata = [];
				treedata.push(data);
				//resetTree(treedata);
				$('#tt').tree({data:treedata});
			},'json');
			$('#rolePanel').layout('expand','east');  
		}
		 
		 function resetTree(treedata){
			 for(var i=0;i<treedata.length;i++){
				 var node = treedata[i];
				 if(node.children&&node.children.length>0){
					 for(var j=0;j<node.children.length;j++){
						 var child =node.children[j];
						 if(!child.checked&&node.checked){
							 node.checked = false;
						 }
						 if(child.children&&child.children.length>0){
							 resetTree(child.children);
						 }
					 }
				 }
			 }
		 }
		function mysubmit(roleId) {
		var s = GetNode();
		$.post(updateGrantUrl, {
			roleId:roleId,
			resourcesIds:s
		}, function(data){
			if(data.msg='true'){
				$.messager.info('操作成功！');
				$('#rolePanel').layout('collapse','east');  
			}else{
				$.messager.error('操作失败！');
			}
		},'json');
	}
	function GetNode() {
		var node = $('#tt').tree('getChecked');
		var nodes = '';
		for ( var i = 0; i < node.length; i++) {
			if ($('#tt').tree('isLeaf', node[i].target)) {
				nodes += node[i].id + ',';
				var pnode = $('#tt').tree('getParent', node[i].target); //获取当前节点的父节点
				if(pnode&&nodes.indexOf(pnode.id)==-1){
					nodes += pnode.id +','
				}
				var ppnode = $('#tt').tree('getParent', pnode.target);
				if(ppnode&&nodes.indexOf(ppnode.id)==-1){
					nodes += ppnode.id +','
				}
			}
		}
		nodes = nodes.substring(0, nodes.length - 1);
		return nodes;
	};
 		//删除
 		function del(){					
			var node = getSelected('del');
			var ss = new Array();
			var rows = $('#dg').datagrid('getSelections');
			for(var i=0; i<rows.length; i++){
				var row = rows[i];
				ss.push(row.id);
			}
			if(node==undefined){
				return false;
			}
			$.getJSON(beforeDelUrl,{
				ids:ss.join(',')
			}, function(data){
				if(data.msg=='hasOpe'){
					$.messager.info('所删除的科室已被赋予给了操作员,不允许删除');
					return false;
				}else if(data.msg=='hasRes'){
					$.messager.confirm('确认框', '所删除的科室中关联了资源信息，仍然删除吗?', function(r){
					if (r){
						doDel(ss);
					}});
				}else{
					$.messager.confirm('确认框', '确定要删除吗?', function(r){
					if (r){ 
						doDel(ss);
					}});
				}
			},'json');
		}
		function doDel(ss){
			$.post(delUrl, {roleIds:ss.join(',')}, 
				function(data){
					if(data.msg='true'){
						$('#queryForm')[0].reset();
						$('#dg').datagrid('options').queryParams={};
						$('#dg').datagrid('reload'); 	
					}else{
						$.messager.error('操作失败！');
					}
			},'json');
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
			<form id="queryForm" method="post">
			<div  style="width:99%;height: 55px;border: 1px solid #CCCCCC;position: absolute;top: 3px;left: 3px;"></div>
			<div style="height: 35px; width: 90px; background-color: #EE5F45;color: white;position: absolute;left: 3px;top: 3px;text-align: center;line-height: 35px;">科室列表</div>
			<span style="position: absolute;left: 120px;top: 23px">名称:</span> 
			<input class="easyui-validatebox text" type="text" name="name" style="width:150px;height: 25px;position: absolute;left: 160px;top: 20px;border:#C8C9CD 1px solid;"/>
			<span style="position: absolute;left: 350px;top: 23px">是否可用:</span> 
			<select name="flag" class="easyui-validatebox select" style="width:150px;height: 25px;position: absolute;left: 415px;top: 20px;border:#C8C9CD 1px solid;">
				<option value="" selected>全部</option>
				<option value="1">正常</option>
				<option value="0">停用</option>
			</select>
			<a style="position: absolute;left: 91%;top: 15px;background-color: #56BB4D;"  href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
			</form>
		</div>
		<div style="margin-top:70px; text-align:right;">
		<b:privilege url="sys/role/add">
			<a href="javascript:void(0)" class="easyui-linkbutton new"  onClick="add();">添加</a>
		</b:privilege>
		<b:privilege url="sys/role/del">
			<a href="javascript:void(0)" class="easyui-linkbutton reset" onClick="del();">删除</a>
		</b:privilege>
		<b:privilege url="sys/role/update">
			<a href="javascript:void(0)" class="easyui-linkbutton save" onClick="edit();">修改</a>
		</b:privilege>
		<b:privilege url="sys/resources/treegrant">
			<a href="javascript:void(0)" class="easyui-linkbutton" onClick="grant();">授权</a>
		</b:privilege>
		</div> 
	</div>
 </div>
 <div id='eastPanel' data-options="region:'east',split:true,collapsed:true" style="width: 200px;">
  <div tools="#tt1" class="easyui-panel" title="权限设置" style="padding: 10px;" fit="true" border="false" id="function-panel">
  <ul id="tt" class="easyui-tree" style="width: 100px;float: left;" data-options="animate:true,lines:true,checkbox:true"></ul>
  </div>
 </div>
 <div id="tt1">
 </div>
</div>
		<!-- 新建角色 -->
		<div id="addOrUpdateWin" class="easyui-dialog" title="角色" closed="true">
			<form id="addOrUpdate" name="addOrUpdate" method="post">
			<input type="hidden" id="id" name="id"/>
				<table class="datagrid-body" width="100%" style="position: absolute;left: 8%;top: 10%">
					<tr>
					<td class="datagrid-header">
						角色名称：
						<span style="color: red;">*</span>
					</td>
					<td>
						<input name="name" id="name"
							class="easyui-validatebox text" style="width:220px;" required="true" size="30"
							data-options="validType:['maxLength[50]','invalidChar']" missingMessage="请输入科室名称" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						可用标识：
						<span style="color: red;">*</span>
					</td>
					<td>
						<select name="flag" id="flag" style="width:195px;" class="easyui-validatebox select">
							<option value="1">正常</option>
							<option value="0">停用</option>
						</select>
					</td>
					</tr>
					<tr>
						<td class="datagrid-header">
							备注：
						</td>
						<td>
							<textarea name="remark" id="remark"  cols="40" rows="5" validType="colENameStr[500]" class="easyui-validatebox" >
							</textarea>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<a style="position: absolute;left: 28%;top: 95%" href="#" class="easyui-linkbutton save" id="submitButton">保存</a>
							<a style="position: absolute;right:38%;top: 95%" href="#" class="easyui-linkbutton" onClick="closeDialog_();">取消</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
