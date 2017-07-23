<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>资源管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		<style type="text/css">
			.list-box { list-style: none; margin: 0px; padding: 0px; }
			.list-box-item { clear: both; margin-left: 5px; padding: 5px; line-height: 22px; display: block; min-height: 22px;}
			.list-box-item-label { display: block; float: left; line-height: 22px; text-align: right; padding-right: 5px; width:100px;}
			.list-box-item .required{ display: block; float: left; line-height: 22px; width: 12px; color:red; }
			.list-box-item-tip {display: block; float: left; line-height: 22px; padding: 0px 5px 0px; color:#999999;}
			.list-box-item-content { float: left; padding-left: 5px;}
		</style>
		<script type="text/javascript">
		var selfUrl = "${ctx}/sys/resources/tree";
		var addUrl = "${ctx}/sys/resources/add";
		var updateUrl = "${ctx}/sys/resources/update";
		var delUrl = "${ctx}/sys/resources/del";
		var listUrl = selfUrl;
		$(function() {
			$.post(selfUrl, function(data){
				var treedata = [];
				treedata.push(data);
				$('#tt').tree({data:treedata});
			},'json');
			/* 注意!!!这里不要用submitButton做为id,因为在boss.js中做了对该id的提交绑定　xuyh */
			$('#submitButton1').click(function(){
				if($('#addOrUpdate').form('validate')){
				$.post($('#id').val().length>0?updateUrl:addUrl,
					$('#addOrUpdate').serialize(),
					function(data){
						if(data.msg){
							refreshTree();
							$('#resources-box').hide();
						}
				});
			}
			});
		});
		
		function showmenu(node){
			var mynode ;
			var nmnew = '<a href="javascript:void(0)" onclick="add();">新建</a>&nbsp;&nbsp;';
			var nmedit = '<a href="javascript:void(0)" onclick="edit();">编辑</a>&nbsp;&nbsp;';
			var nmdel = '<a href="javascript:void(0)" onclick="del();">删除</a>&nbsp;&nbsp;';
			$('.nodemenu').hide();
			var hnm = $(node.target).find('.nodemenu')[0];
			if(!hnm){//如果没有就加上
				if(node.id==0){
					$(node.target).append('<span class="nodemenu">&nbsp;&nbsp;&nbsp;&nbsp;'+nmnew+'</span>');
				}else{
					$(node.target).append('<span class="nodemenu">&nbsp;&nbsp;&nbsp;&nbsp;'+nmnew+nmedit+nmdel+'</span>');
				}
			}else if(hnm&&$(hnm).is(":visible")==false){//如果已经有却是隐藏的让它显示出来
				$(node.target).find('.nodemenu').show();
			}
		}
		function resetAddOrUpdateForm(){
			$('#addOrUpdate').find('input#id').val('');
			$('#addOrUpdate').find('input#name').val('');
			$('#addOrUpdate').find('input#flag').val('');
			$('#addOrUpdate').find('input#remark').val('');
		}
		//添加
		function add(){
			var node = $('#tt').tree('getSelected');
			var id = node.id;
			if(id=='0'){//根节点上新建
				$('#addOrUpdate').find('input#pname').val(node.text);
				$('#addOrUpdate').find('input#parentId').val(null);
				$('#addOrUpdate').find('input#type').val(1);
				$('#ftype-info').text('模块');
				$('#item-logFlag').hide();
				$('#item-logUri').hide();
				$('#item-logUrlMethod').hide();
				$('#item-menu').show();
			}else{
				$('#addOrUpdate').find('input#pname').val(node.attributes.name);
				$('#addOrUpdate').find('input#parentId').val(node.attributes.id);
				$('#addOrUpdate').find('input#type').val((node.attributes.type-0)+1);
				if(((node.attributes.type-0)+1)==2){
					$('#ftype-info').text('菜单');
					$('#item-menu').show();
				}else if(((node.attributes.type-0)+1)==3){
					$('#ftype-info').text('按钮/链接');
					$('#item-menu').hide();
				}
				$('#item-logFlag').show();
				$('#item-logUri').show();
				$('#item-logUrlMethod').show();
			}
			$('#addOrUpdate').find('input#id').val(null);
			$('#addOrUpdate').find('input#name').val('');
			$('#addOrUpdate').find('#uri').val('');
			$('#addOrUpdate').find('input#onum').val('0');
			$('#addOrUpdate').find('#remark').val('');
			$('#addOrUpdate').find('input#logUri').val('');
			$('#resources-box').show();
		}
		 //修改
		  function edit(){
			 var node = $('#tt').tree('getSelected');
			 var pnode = $('#tt').tree('getParent',node.target);
			if(pnode.attributes){
				$('#addOrUpdate').find('input#pname').val(pnode.attributes.name);
				$('#addOrUpdate').find('input#parentId').val(pnode.attributes.id);
				$('#addOrUpdate').find('input#type').val((node.attributes.type-0));
				if((node.attributes.type-0)==2){
					$('#ftype-info').text('菜单');
					$('#item-menu').show();
				}else if((node.attributes.type-0)==3){
					$('#ftype-info').text('按钮/链接');
					$('#item-menu').hide();
				}
				$('#item-logFlag').show();
				$('#item-logUri').show();
				$('#item-logUrlMethod').show();
			}else{
				$('#addOrUpdate').find('input#pname').val(pnode.text);
				$('#addOrUpdate').find('input#parentId').val(pnode.ud);
				$('#addOrUpdate').find('input#type').val(1);//模块
				$('#ftype-info').text('模块');
				$('#item-logFlag').hide();
				$('#item-logUri').hide();
				$('#item-logUrlMethod').hide();
				$('#item-menu').show();
			}
			$('#addOrUpdate').find('input#id').val(node.attributes.id);
			$('#addOrUpdate').find('input#name').val(node.attributes.name);
			$('#addOrUpdate').find('#uri').val(node.attributes.uri);
			$('#addOrUpdate').find('input#logUri').val(node.attributes.logUri);
			$('#addOrUpdate').find('input#onum').val(node.attributes.onum);
			$('#addOrUpdate').find('#remark').val(node.attributes.remark);
			if(1==node.attributes.grantFlag){
				$('#addOrUpdate').find('input#grantFlag').attr('checked',true);
			}else{
				$('#addOrUpdate').find('input#grantFlag').attr('checked',false);
			}
			$('#addOrUpdate').find('input[type=radio][name=menu][value=\''+node.attributes.menu+'\']').attr('checked','checked');
			if(1==node.attributes.logFlag){
				$('#addOrUpdate').find('input#logFlag').attr('checked',true);
			}else{
				$('#addOrUpdate').find('input#logFlag').attr('checked',false);
			}
			$('#addOrUpdate').find('#logMethod').val(node.attributes.logMethod);
			$('#resources-box').show();		
		}
 		//删除
 		function del(id){			
 			var node = $('#tt').tree('getSelected');
 			var id = node.id;
			$.messager.confirm('确认框', '删除操作将导致该节点下面的所有节点被删除,确定要删除吗?', function(r){
					if (r){ 
						$.post(delUrl, {
							resourcesId:id
						}, function(data){
							if(data.msg='true'){
								refreshTree();
							}else{
								$.messager.error('操作失败');
							}
						},'json');
					}
				});
		}
 		function refreshTree(){
 			$.post(selfUrl, function(data){
				var treedata = [];
				treedata.push(data);
				$('#tt').tree({data:treedata});
			},'json');
 		}
 </script>
	</head>

	<body>
		<table>
		<tr>
		<td width="320" valign="top" style="border-right: 1px solid #B2B2B2;">
			<div id="tree-box" style="width:320px;">
			<ul id="tt" class="easyui-tree" style="width: 100px;float: left;" data-options="animate:true,lines:true,onBeforeSelect:showmenu"></ul>
			</div>
		</td>
		<td width="460" valign="top">
			<div id="resources-box" style="display: none;width:460px;">
				<form name="addOrUpdate" id="addOrUpdate" method="post">
				<input name="id" type="hidden" id="id" />
				<input name="parentId" type="hidden" id="parentId" />
				<input name="type" type="hidden" id="type" value="1"/>
				<ul class="list-box">
					<li class="list-box-item">
						<label  class="list-box-item-label" for="pname">上级资源：</label> 
						<span class="list-box-item-content">
							<input name="pname" type="text" class="easyui-validatebox"  id="pname" disabled="disabled"/>
						</span>
					</li>
					<li class="list-box-item">
						<label  class="list-box-item-label" for="name"><font color="red">*</font>资源名称：</label> 
						<span class="list-box-item-content"><input name="name" type="text" class="easyui-validatebox"  id="name" /></span></li>
					<li class="list-box-item">
						<label  class="list-box-item-label" for="uri">资源配置：</label> 
						<span class="list-box-item-content"><textarea name="uri" class="easyui-validatebox"  id="uri" ></textarea></span></li>
					<li class="list-box-item">
						<label  class="list-box-item-label" for="ftype-info">资源类型：</label>
						<span class="list-box-item-content" id="ftype-info"></span></li>
					<li class="list-box-item" id="item-menu">
						<label class="list-box-item-label" for="menu">显示菜单：</label> 
						<span class="list-box-item-content">
							<input type="radio" name="menu" value="1" checked="checked"/> 是
							<input type="radio" name="menu" value="0" /> 否
						</span></li>
					<li class="list-box-item">
						<label  class="list-box-item-label">访问授权：</label> 
						<span class="list-box-item-content">
							<input type="checkbox" name="grantFlag" value="1" id="grantFlag"/>
							<label for="grantFlag">需要授权</label>
						</span></li>
					<li class="list-box-item">
						<label  class="list-box-item-label" for="flag">状态：</label> 
						<span class="list-box-item-content">
							<select name="flag" id="flag" class="sselect">
								<option value="1">正常</option>
								<option value="0">禁用</option>
							</select>
						</span></li>
					<li class="list-box-item">
						<label class="list-box-item-label" for="onum"><font color="red">*</font>顺序：</label> 
						<span class="list-box-item-content"><input name="onum" type="text" id="onum" /></span></li>
					<li class="list-box-item">
						<label  class="list-box-item-label" for="info">描述信息：</label> 
						<span class="list-box-item-content"><textarea name="info" class="easyui-validatebox"  id="remark" ></textarea></span></li>
					<li class="list-box-item" id="item-logFlag">
						<label  class="list-box-item-label">操作日志：</label> 
						<span class="list-box-item-content">
							<input type="checkbox" name="logFlag" value="1" id="logFlag"/> 记录日志
						</span></li>
					<li class="list-box-item" id="item-logUri">
						<label  class="list-box-item-label" for="logUri">记录日志URL：</label> 
						<span class="list-box-item-content"><input name="logUri" type="text" class="easyui-validatebox" id="logUri" /></span></li>
					<li class="list-box-item" id="item-logUrlMethod">
						<label  class="list-box-item-label" for="logurlMethod">请求方式：</label> 
						<span class="list-box-item-content">
							<select class="sselect" name="logMethod" id="logMethod">
									<option value="0">GET</option>
									<option value="1">POST</option>
							</select></span></li>
				</ul>
				<div class="button-box">
					<input type="button" value="保存" class="btn" id="submitButton1"/>
					<input type="button" value="取消" class="btn" id="cancelButton"/>
				</div>
				</form>
			</div>
			</td>
			</tr>
		</table>
	</body>
</html>
