<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>部门管理</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		<script type="text/javascript">
		var selfUrl = "${ctx}/sys/department/list";
		var getUrl = "${ctx}/sys/department/get";
		var villageUrl = "${ctx}/sys/villageinfo/list";
		var addUrl = "${ctx}/sys/department/add";
		var updateUrl = "${ctx}/sys/department/update";
		var beforeDelUrl = "${ctx}/sys/department/beforeDel";
		var delUrl = "${ctx}/sys/department/del";
		var nameurl = "${ctx}/sys/department/queryQy"
		var listUrl = selfUrl;
		$(function() {
		    $.treegrid({id:'#tg',title:"",url:selfUrl,toolbar:'#tb',pagination:false,
		    	columns:[[
                  {field:'ck',checkbox:true,width : '150',align:'center'},
                  {title:'序号',field:'level',width : '100',align:'center'},
                  {title:'部门名称',field:'name',width : '300',align:'center'},
                  {title:'所属地区',field:'reginName',width : '300',align:'center'},
                  {title:'描述',field:'remark',width : '812',align:'center'}
                 ]]
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
			showDialog_('新建部门','addOrUpdateWin','middle');
			resetAddOrUpdateForm();
			$.getJSON(getUrl,function(data){
				var depTreeList =[{id:"",text:'总部',children:depTreeList,state:'open'}];
				var depList = data.list;
				initDepList(depList,depTreeList,null,null);
				$('#parentId').combotree("loadData",depTreeList);
				$('#parentId').combotree("setValue","");
				
			});
			$(function(){
                var memberStars = boss.code.getCodes('memberStars');
      		    var htmlstr = '';
      		   if(title.text){
					htmlstr += '<option value="'+title['value']+'">'+title['text']+'</option>';
				}
      		     htmlstr += '<option value="">请选择</option>';
      		    for(var i in memberStars){
      		    	htmlstr += '<option value="'+i+'">'+memberStars[i]+'</option>';
      			}
      			  $('#level').html(htmlstr);  
  
			  });
			
		}
		 //修改
		  function edit(){
			 
			  showDialog_('修改部门','addOrUpdateWin','middle')
			var node = getSelected('edit');
			var regId = node.regionId;
			
			if(node){
				$('#addOrUpdate').find('input#id').val(node.id);
				$('#addOrUpdate').find('input#name').val(node.name);
				//var regionId = $('#addOrUpdate').find('input#quyuId').val(node.regionId);
				
				$('#addOrUpdate').find('#remark').val(node.remark);
				$.getJSON(getUrl,function(data){
					
					var depTreeList =[{id:"",text:'总部',children:depTreeList,state:'open'}];
					var depList = data.list;
					initDepList(depList,depTreeList,null,null);
					$('#parentId').combotree("loadData",depTreeList);
					$('#parentId').combotree("setValue",node.parentId?node.parentId:"");
					
				});
				//回显所属地区
				$('#parentId').combotree({
 	 			onSelect:function(node) {
 	 				var bumen =node.text;
 	 				$.ajax({
 	 	 				dataType:'json',
 	 	 				data:{val:bumen},
 	 	 				url:nameurl,
 	 	 				success:function(data){
 	 	 					if (data.list == null) {
								alert("当前部门已是最低级别，不能作为上级部门使用！")
							} else {
	 	 	 					$("#quyuId").html("");
	 	 	 					var str = "" ;
	 	 	 					for(var i = 0;i<data.list.length;i++){
	 	 	 						var s = "";
	 	 	 						if (regId == data.list[i].id) {
										s = "selected";
									}
	 	 	 						str += "<option "+s+" value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
	 	 	 					}
	 	 	 					$("#quyuId").html(str);
	 	 	 					
							}
 	 	 					$("#level2").val(data.level2);
 	 	 				}
 	 	 			});
 	 			}
 	 		});
				
					
			}
		}
 		//删除
 		function del(){					
			var ss = new Array();
			var rows = $('#tg').treegrid('getSelections');
			for(var i=0; i<rows.length; i++){
				var row = rows[i];
				if(row.children&&row.children.length>0){
					$.messager.error('所删除的部门含有子部门，不允许删除');
					return false;
				}
				ss.push(row.id);
			}
			$.getJSON(beforeDelUrl,{
				ids:ss.join(',')
			},function(data){
				$.messager.confirm('确认框', '确定要删除吗?', function(r){
					if (r){ 
						$.postJSON(delUrl,{ids:ss.join(',')},function(data){
							$('#tg').treegrid('reload'); 	
						});
					}
				});
			});
			
		}
 		
 		//根据选中的部门名称获取区域信息
 		$(function(){
 			$('#parentId').combotree({
 	 			onSelect:function(node) {
 	 				var bumen =node.text;
 	 				$.ajax({
 	 	 				dataType:'json',
 	 	 				data:{val:bumen},
 	 	 				url:nameurl,
 	 	 				success:function(data){
 	 	 					if (data.list == null) {
								alert("当前部门已是最低级别，不能作为上级部门使用！")
							} else {
	 	 	 					$("#quyuId").html("");
	 	 	 					var str = "" ;
	 	 	 					for(var i = 0;i<data.list.length;i++){
	 	 	 						/* var s = "";
	 	 	 						if (regionId != null && regionId != "" && regionId == data.list[i].id) {
										s = "selected";
									} */
	 	 	 						str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
	 	 	 					}
	 	 	 					$("#quyuId").html(str);
	 	 	 					$("#quyuId")[0].selectedIndex = -1;
							}
 	 	 					$("#level2").val(data.level2);
 	 	 				}
 	 	 			});
 	 			}
 	 		});
 		
 		})
 	
 		
 		
 </script>
	</head>
    
	<body>
		<table id="tg"></table>
		<div id="tb" style="padding:5px;height:auto">
		<div>
			<form id="queryForm" method="post">
			<div  style="width:99%;height: 55px;border: 1px solid #CCCCCC;position: absolute;top: 3px;left: 3px;"></div>
			<div style="height: 35px; width: 90px; background-color: #EE5F45;color: white;position: absolute;left: 3px;top: 3px;text-align: center;line-height: 35px;">部门列表</div>
			<span style="position: absolute;left: 120px;top: 23px">名称:</span> 
			<input class="easyui-validatebox text" type="text" name="name" style="width:150px;height: 25px;position: absolute;left: 160px;top: 20px;"/>
			<a style="position: absolute;left: 92%;top: 15px;background-color: #56BB4D;" href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
			</form>
			<br><br><br><br>
		</div>
		<div data-options="region:'south',border:false">  
		<b:privilege url="sys/role/add">
			<a href="javascript:void(0)" class="easyui-linkbutton new"  onClick="add();" style="position: absolute;right: 12%">添加</a>
		</b:privilege>
		<b:privilege url="sys/role/del">
			<a href="javascript:void(0)" class="easyui-linkbutton reset"  onClick="del();" style="position: absolute;right: 6%">删除</a>
		</b:privilege>
		<b:privilege url="sys/role/update">
			<a href="javascript:void(0)" class="easyui-linkbutton save"  onClick="edit();" style="position: absolute;right: 0%">修改</a>
		</b:privilege>
		<br><br>
		</div>  
	</div>
		<!-- 新建部门 -->
		<div id="addOrUpdateWin" class="easyui-dialog" title="部门" closed="true">
			<form id="addOrUpdate" name="addOrUpdate" method="post">
			<input type="hidden" id="id" name="id"/>
				<table class="treegrid-body" width="100%" style="position: absolute;left: 15%;top: 10%">
					<tr>
					<td class="treegrid-header"">上级部门：<span style="color: red;">*</span></td>
<!-- 					<td class="treegrid-header">上级部门：<span style="color: red;">*</span></td> -->
					<td>
					<input type="hidden" name="level" id="level2">
						<input class="easyui-combotree"	name="parentId" id="parentId" onclick="queryQy()"  data-options="valueField:'id',textField:'text',panelHeight:'auto'">
						<!-- <input type="text" id= "parentId" value="总部"  onblur="queryQy()"> -->
					</td>
					</tr>
					<tr>
					<td class="treegrid-header"">部门名称：<span style="color: red;">*</span></td>
<!-- 					<td class="treegrid-header">部门名称：<span style="color: red;">*</span></td> -->
					<td>
						<input name="name" id="name"  class="easyui-validatebox"  required="true" size="30" 
							data-options="validType:['maxLength[50]','invalidChar']" missingMessage="请输入部门名称" style="width:150px;"/>
					</td>
					</tr>
					<tr>
					
					<td class="treegrid-header"">所属地区：<span style="color: red;">*</span></td>

					<td>
					    <select class="easyui-validatebox" required="true"  name="regionId" id="quyuId" style="width:150px;">
						 </select>	
				    </td>
					</tr>
					<tr>
						<td class="treegrid-header">
							备注：
						</td>
						<td>
							<textarea name="remark" id="remark" rows="5" cols="30" validType="colENameStr[500]" class="easyui-validatebox" >
							</textarea>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<a style="position: absolute;left: 18%;top: 95%;" href="javascript:void(0);" class="easyui-linkbutton save" 
								id="submitButton" >保存</a>
							<a style="position: absolute;left:46%;top: 95%;" href="javascript:void(0);" class="easyui-linkbutton" 
								onClick="closeDialog_();">取消</a>
						</td>
					</tr>
				</table>
			</form>
		</div>						
	</body>
</html>
