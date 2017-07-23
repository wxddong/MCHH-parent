<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
	<head>
		<title>操作员管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		<script type="text/javascript">
		var selfUrl = "${ctx}/sys/operator/list";
		var getUrl = "${ctx}/sys/department/get";
		var addUrl = "${ctx}/sys/operator/add";
		var updateUrl = "${ctx}/sys/operator/update";
		var delUrl = "${ctx}/sys/operator/del";
		var getGrantedUrl = "${ctx}/sys/operator/granted";
		var assginRoleUrl = "${ctx}/sys/operator/assginRole";
		var resetPassUrl = "${ctx}/sys/operator/resetPass";
		var listUrl = selfUrl;
		$(function() {
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                  {field:'ck',checkbox:true,width : '120',resizable:'false',align:'center'},
                  {title:'登录名',field:'loginName',width : '140',resizable:'true',align:'center'},
                  {title:'姓名',field:'realName',width : '140',resizable:'true',align:'center'},
                  {title:'状态',field:'flag',width : '110',resizable:'true',align:'center',
                	  formatter:function(v){ return v==0?'停用':'正常' }},
                  {title:'固定电话',field:'phone',width : '140',align:'center'},
                  {title:'移动电话',field:'mobile',width : '140',align:'center'},
                  {title:'电子邮件',field:'email',width : '140',align:'center'},
                  {title:'通讯地址',field:'address',width : '190',align:'center'},
                  {title:'上次登录时间',field:'lastLogin',formatter:formatDate,width : '130',align:'center'},
                  {title:'上次修改密码时间',field:'lastPwd',formatter:formatDate,width : '190',align:'center'},
                  {title:'所属部门',field:'department',width : '150',align:'center'}
                 ]]
			});
			$('#submitButton1').click(function(){
				if($('#addOrUpdate').form('validate')){
					if($('#id').val().length==0){
						var opwd = $.trim($('#opassword').val());
						$('#password').val($.md5(opwd));
					}
					$.postJSON($('#id').val().length>0?updateUrl:addUrl,
					$('#addOrUpdate').serialize(),function(data){
						closeDialog_();
						$('#dg').datagrid('reload');
					});
				}
			});
			
			$('#btnAdd').click(function(){
				var nolist = $('#noassgin').find('option:checked');
				for(var i = 0; i < nolist.length; i++){
					$('#assgin').append(nolist[i]);
				}
			});
			
			$('#btnDel').die().click(function(){
				var list = $('#assgin').find('option:checked');
				for(var i = 0; i < list.length; i++){
					$('#noassgin').append(list[i]);
				}
			});
			
			$('#btnAddAll').click(function(){
				var nolist = $('#noassgin').find('option');
				for(var i = 0; i < nolist.length; i++){
					$('#assgin').append(nolist[i]);
				}
			});
			$('#btnDelAll').click(function(){
				var list = $('#assgin').find('option');
				for(var i = 0; i < list.length; i++){
					$('#noassgin').append(list[i]);
				}
			});
			//更新操作员
			$('#updateBtn').click(function(){
				var operatorId = $('#operatorId').val();
				var list = $('#assgin').find('option');
				var ss = new Array();
				for(var i=0; i<list.length; i++){
					var role = list[i];
					ss.push(role.id);
				}
				$.postJSON(assginRoleUrl,{operatorId:operatorId,roleIds:ss.join(',')},function(data){
					closeDialog_();
				});
			});
		});
		function initDepList(depList,depTreeList,parent,parentId){
			if(!parentId){
				for(var i=0 ; i < depList.length ; ++i){
					var dep = depList[i];
					if(!dep.parentId){
						var tdep = {id:dep.id,text:dep.name,children:dep.children};
						depTreeList.push(tdep);
						if(dep.children.length>0){
							initDepList(depList,depTreeList,tdep,tdep.id);
						}
					}
				}
			}else{
				var chr = parent.children;
				parent.children = [];
				if(chr.length>0){
					for(var i=0;i<chr.length;i++){
						var dep = chr[i];
						var tdep = {id:dep.id,text:dep.name,children:dep.children};
						parent.children.push(tdep);
						if(dep.children.length>0){
							initDepList(depList,depTreeList,tdep,tdep.id);
						}
					}
				}
			}
		}
		//添加
		function add(){
			resetAddOrUpdateForm();
			$.getJSON(getUrl,{},function(data){
				 var depTreeList =[];
				var depList = data.list;
				initDepList(depList,depTreeList,null,null);
				$('#depId').combotree("loadData",depTreeList);
				$('#depId').combotree("setValue","请选择"); 
			});
			$('#addOrUpdate').find('input#opassword').attr('disabled',false);
			$('#addOrUpdate').find('tr#passtr').show();
			showDialog_('新建操作员','addOrUpdateWin','zhongjianddle');
		}
		 //修改
		  function edit(){
			var node = getSelected('edit');
			if(node){
				$('#addOrUpdate').find('input#id').val(node.id);
				$('#addOrUpdate').find('input#loginName').val(node.loginName);
				$('#addOrUpdate').find('input#password').val(node.password);
				$('#addOrUpdate').find('input#realName').val(node.realName);
				$('#addOrUpdate').find('input#flag').val(node.flag);
				$('#addOrUpdate').find('input#phone').val(node.phone);
				$('#addOrUpdate').find('input#mobile').val(node.mobile);
				$('#addOrUpdate').find('input#email').val(node.email);
				$('#addOrUpdate').find('input#address').val(node.address);
				$('#addOrUpdate').find('#remark').val(node.remark);
				$('#addOrUpdate').find('input#opassword').attr('disabled',true);
				$('#addOrUpdate').find('tr#passtr').hide();
				$.getJSON(getUrl,{},function(data){
					var depTreeList =[];
					var depList = data.list;
					initDepList(depList,depTreeList,null,null);
					$('#depId').combotree("loadData",depTreeList);
					$('#depId').combotree("setValue",node.depId);
				});
			showDialog_('修改操作员','addOrUpdateWin','zhongjianddle')
			}
		}
		 //分配角色
		  function assignrole(){
			var node = getSelected('assignrole');
			$('#operatorId').val(node.id);
			$('#noassgin').empty();
			$('#assgin').empty();
			if(node){
				//初始化未分配角色列表
				//初始化已分配角色列表
				$.post(getGrantedUrl,{operatorId:node.id},function(data){
					if(data.nolist){
						var len = data.nolist.length;
						for(var i=0;i<len;i++){
							var role = data.nolist[i];
							$('#noassgin').append('<option id="'+role.id+'">'+role.name+'</option>');
						}
					}
					if(data.list){
						var len = data.list.length;
						for(var i=0;i<len;i++){
							var role = data.list[i];
							$('#assgin').append('<option id="'+role.id+'">'+role.name+'</option>');
						}
					}
				},'json');
				showDialog_('分配科室','roleWin','moremiddle')
			}
		}
		 
		 function resetPass(){
			 var node = getSelected('edit');
			 $.postJSON(resetPassUrl,{id: node.id,newPasword:'e10adc3949ba59abbe56e057f20f883e'},function(data){
				$.messager.info('重置密码成功，重置为:123456');
			});
		 }
 		
 </script>
 	 <style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}
 		.operator .easyui-linkbutton{margin:10px 5px 0;width:50px;text-align: center;}
 	</style>
	</head>

	<body class="panel-noscroll">
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
		<div style="">
			<form id="queryForm" method="post">
			<div  style="width:99%;height: 55px;border: 1px solid #CCCCCC;position: absolute;top: 3px;left: 3px;"></div>
			<div style="height: 35px; width: 90px; background-color: #EE5F45;color: white;position: absolute;left: 3px;top: 3px;text-align: center;line-height: 35px;">账号列表</div>
			<span style="position: absolute;left: 120px;top: 23px">登录名:</span>
			<input  class="easyui-validatebox text" type="text" name="loginName" style="width:150px;height: 25px;position: absolute;left: 170px;top: 20px;border:#C8C9CD 1px solid;"/>
			<span style="position: absolute;left: 350px;top: 23px">姓名:</span> 
			<input class="easyui-validatebox text" type="text" name="realName" style="width:150px;height: 25px;position: absolute;left: 385px;top: 20px;border:#C8C9CD 1px solid;"/>
			<span style="position: absolute;left: 560px;top: 23px">是否可用:</span> 
			<select class="select" name="flag" style="width:150px;height: 25px;position: absolute;left: 620px;top: 20px;border:#C8C9CD 1px solid;">
				<option value="" selected>全部</option>
				<option value="1">正常</option>
				<option value="0">停用</option>
			</select>
			<a href="javascript:void(0)" class="easyui-linkbutton"  id="queryBtn" style="position: absolute;left: 92%;top: 15px;background-color: #56BB4D;"><i class="fa fa-search"></i>查询</a>
			</form>
		
			<br><br><br><br>
		</div>
		<div style="margin-top:10px; text-align:right;">  
			<b:privilege url="sys/operator/add">
			<a href="javascript:void(0)" class="easyui-linkbutton new" onClick="add();">新建</a>
			</b:privilege>
			<b:privilege url="sys/operator/del">
			<a href="javascript:void(0)" class="easyui-linkbutton reset" onClick="del();">删除</a>
			</b:privilege>
			<b:privilege url="sys/operator/update">
			<a href="javascript:void(0)" class="easyui-linkbutton save" onClick="edit();">修改</a>
			</b:privilege>
			<b:privilege url="sys/operator/granted">
				<a href="javascript:void(0)" class="easyui-linkbutton" onClick="assignrole();">分配科室</a>
			</b:privilege>
<%-- 			<b:privilege url="sys/operator/resetPass"> --%>
<!-- 				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onClick="resetPass();">密码重置</a> -->
<%-- 			</b:privilege> --%>
<br><br>
		</div>  
	</div>
		<!-- 新建操作员 -->
		<div id="addOrUpdateWin" class="easyui-dialog" title="操作员" closed="true">
			<form id="addOrUpdate" name="addOrUpdate" method="post">
			<input type="hidden" id="id" name="id"/>
			<input name="password" type="hidden" id="password"/>
				<table class="datagrid-body" width="100%" align="right" style="position: absolute;left: 8%">
					<tr>
					<td class="datagrid-header">
						登录名：
						<span style="color: red;">*</span>
					</td>
					<td>
						<input name="loginName" id="loginName"
							class="easyui-validatebox text" required="true" size="30" 
							data-options="validType:['maxLength[50]','invalidChar']" 
							missingMessage="请输入登录名"  />
					</td>
					</tr>
					<tr id="passtr">
					<td class="datagrid-header">
						密码：
						<span style="color: red;">*</span>
					</td>
					<td>
						<input id="opassword" type="password"
							class="easyui-validatebox text" required="true" size="30" validType="maxLength[50]" missingMessage="请输入密码" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						真实姓名：
						<span style="color: red;">*</span>
					</td>
					<td>
						<input name="realName" id="realName"
							class="easyui-validatebox text" required="true" size="30" validType="maxLength[50]" missingMessage="请输入真实姓名" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						可用标识：
						<span style="color: red;">*</span>
					</td>
					<td>
						<select class="easyui-validatebox select" name="flag" id="flag" style="width:195px;" required="true">
							<option value="1" selected>正常</option>
							<option value="0">停用</option>
						</select>
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						固定电话：
					</td>
					<td>
						<input name="phone" id="phone" class="easyui-validatebox text" size="30"  data-options="validType:['tel']" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						移动电话：
					</td>
					<td>
						<input name="mobile" id="mobile" class="easyui-validatebox text" size="30"  data-options="validType:['mobile']"  />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						电子邮件：
					</td>
					<td>
						<input name="email" id="email" class="easyui-validatebox text" size="30" data-options="validType:['email']" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header">
						通讯地址：
					</td>
					<td>
						<input name="address" id="address" class="easyui-validatebox text" size="30" validType="maxLength[50]" />
					</td>
					</tr>	
					<tr>
						<td class="datagrid-header">
							所属部门：
						</td>
						<td>
							<input name="depId" id="depId" class="easyui-combotree select" size="30"/>
						</td>
					</tr>	
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<a style="position: absolute;left: 28%;bottom: 2%" href="javascript:void(0)" class="easyui-linkbutton save" id="submitButton1">保存</a>
							<a style="position: absolute;right: 38%;bottom: 2%" href="javascript:void(0)" class="easyui-linkbutton" onClick="closeDialog_();">取消</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="roleWin" class="easyui-dialog" closed="true">
		<center>
		<input type="hidden" id="operatorId">
		<table style="position: absolute;top:8%;left: 28%">
		 <tr>
		 	<td>未分配科室</td>
		 	<td rowspan="2" >
		 	<table class="operator" >
				<tr><td><a href="javascript:void(0)" id="btnAddAll" class="easyui-linkbutton">&gt;&gt;</a></td></tr>
				<tr><td><a href="javascript:void(0)" id="btnAdd" class="easyui-linkbutton">&nbsp;&gt;&nbsp;</a></td></tr>
				<tr><td><a href="javascript:void(0)" id="btnDel" class="easyui-linkbutton">&nbsp;&lt;&nbsp;</a></td></tr>
				<tr><td><a href="javascript:void(0)" id="btnDelAll" class="easyui-linkbutton">&lt;&lt;</a></td></tr>
				</table>
			</td>
			<td>已分配科室</td>
  		</tr>
  		<tr>
			<td>
			<select id="noassgin" multiple="multiple" style="width: 120px;height: 200px; float:left;">
			</select>
			</td>
			<td>
			<select id="assgin" multiple="multiple" style="width: 120px;height: 200px;">
			</select>
			</td>
  		</tr><tr>
		  	<td colspan="3" align="center">
		  		<a style="position: absolute;left: 18%;top: 99%" href="javascript:void(0)" id="updateBtn" class="easyui-linkbutton save mar_t_10">保存</a>
				<a style="position: absolute;right: 28%;top: 99%" href="javascript:void(0)" id="cancelBtn" class="easyui-linkbutton mar_t_10">取消</a>
		  	</td>
		  </tr>
		</table>
		</center>
		</div>
	</body>
</html>
