<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>省(直辖市)管理</title>
		
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		
		var selfUrl = "${ctx}/config/cityInfo/list";
		var getUrl="${ctx}/config/cityInfo/all"
		var addUrl = "${ctx}/config/cityInfo/add";
		var updateUrl = "${ctx}/config/cityInfo/update";
		var delUrl = "${ctx}/config/cityInfo/del";
		var beforeDelUrl = "${ctx}/config/cityInfo/beforeDel";
		var listUrl = selfUrl;
		$(function() {
			
			//保存时进行校验 添加或修改重复地区时 弹框提示
			$("#name").change(function(){
				var	name = $("#name").val();
				var beforeUrl="${ctx}/config/cityInfo/findByName?name="+name;
				$.ajax({
					
					url:beforeUrl,
					type:"GET",
					success:function(data){
						
						if(data.cityInfoPO!=null){
							alert("名字已存在，请更换");
							addUrl = "";
							updateUrl="";
							//做一个标记 证明已经将addUrl的地址更换为"",当再次点击
						}else{
							addUrl = "${ctx}/config/cityInfo/add";
							updateUrl = "${ctx}/config/cityInfo/update";
						}
					}
				})
				
			});
			
			//点击保存对输入的信息进行校验
// 			$("#submitButton").click(function(){
// 				 var provinceName = $("#AllProvince").val();
// 				 if(provinceName==null){
// 					 alert("请选择省（直辖市）的名称");
// 					 return false;
// 				 }
// 				//省（直辖市）名称 汉字 1-30个字符
// 				var nameReg = /[\u4e00-\u9fa5]/;
// 				var name =$.trim($("#name").val());
// 				if(!nameReg.test(name)){
// 					alert("市（区）名称只能为汉字且不能为空");
// 					return false;
// 				}
// 				//编码 仅限数字 1-30个字符
// 				var numberReg = /^[0-9]*$/;
// 				var number = $.trim($("#number").val());
// 				if(!numberReg.test(number)||number==""){
// 					alert("市（区）编码只能为数字且不能为空");
// 					return false;
// 				}
// 				//排序号 仅限数字
// 				var sortNumberReg = /^[0-9]*$/;
// 				var sortNumber = $.trim($("#SortNmber").val());
// 				if(!sortNumberReg.test(sortNumber)||sortNumber==""){
// 					alert("市（区）排序号只能为数字且不能为空");
// 					return false;
// 				}
// 			});
			
			//点击查询对输入的查询条件进行校验
			$("#queryBtn").click(function(){
				//省（直辖市）名称  汉字
				var provinceNameReg = /[\u4e00-\u9fa5]/;
				var provinceName =$.trim($("#queryProvinceName").val());
				if(!provinceNameReg.test(provinceName)&&provinceName!=""){
					alert("省（直辖市）名称只能为汉字");
					window.location.href = selfUrl;
					return false;
				}
				//市（区）名称 汉字
				var cityNameReg = /[\u4e00-\u9fa5]/;
				var cityName =$.trim($("#queryCityName").val());
				if(!cityNameReg.test(cityName)&&cityName!=""){
					alert("市（区）名称只能为汉字");
					window.location.href = selfUrl;
					return false;
				}
				//仅限数字
				var cityNumberReg = /^[0-9]*$/;
				var cityNumber = $.trim($("#queryCityNumber").val());
				if(!cityNumberReg.test(cityNumber)&&cityNumber!=""){
					alert("市（区）编码只能为数字");
					window.location.href = selfUrl;
					return false;
				}
				
			});
			
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
                  {field:'ck',field:'全选',checkbox:true,width : '200',align:'center'},
                  {title:'排序',field:'sortNum',width : '100',align:'center'},
                  {title:'市(区)名称',field:'name',width : '420',align:'center'},
                  {title:'市(区)编码',field:'number',width : '420',align:'center'},
                  {title:'省(直辖市)编码',field:'provinceInfoPO.number',width : '450',align:'center'},
                  {title:'省(直辖市)id',field:'provinceInfoPO.id',width : '450',align:'center',hidden:true}
                 ]]
			});	
		});
		
		
		
		//添加
		function add(){
			resetAddOrUpdateForm();
			addUrl = "${ctx}/config/cityInfo/add";
			updateUrl = "${ctx}/config/cityInfo/update";
// 			$("#add").show();
// 			$("#edit").hide();
			$("#name").val("");
			$("#number").val("");
			$("#sortNum").html("");
			$.getJSON(getUrl,function(data){
				if (data.list == null || data.list.length==0 ) {
					var str = "";
 					$("#sortNum").html(str);
 					//下拉列表的默认值为空
 					$("#sortNum")[0].selectedIndex = -1;
 					//使下拉列表框可编辑
 					$("#sortNum").combobox({editable:true});
				} else {
	 					var str = "";
	 					for(var i = 0;i<data.list.length;i++){
	 						str += "<option value="+data.list[i]+">"+data.list[i]+"</option>" ;
	 					}
	 					$("#sortNum").html(str);
	 					//下拉列表的默认值为空
	 					$("#sortNum")[0].selectedIndex = -1;
	 					//使下拉列表框可编辑
	 					$("#sortNum").combobox({editable:true});
				}
				if (data.provinceList == null || data.provinceList.length==0 ) {
 					$("#AllProvince").html("<option value=''></option>");
				} else {
	 					var str = "" ;
	 					for(var i = 0;i<data.provinceList.length;i++){
	 						str += "<option value="+data.provinceList[i].id+">"+data.provinceList[i].name+"</option>" ;
	 					}
	 					$("#AllProvince").html(str);
	 					$("#AllProvince")[0].selectedIndex = -1;
// 	 					$("#AllProvince").combobox({editable:false});
				}
			});
 	

			showDialog_('新建市(区)','addOrUpdateWin','city');
		}
		
		
		 //修改
		  function edit(){
// 			$("#add").hide();
// 			$("#edit").show();
			var node = getSelected('edit');
			addUrl = "${ctx}/config/cityInfo/add";
			updateUrl = "${ctx}/config/cityInfo/update";
			if(node){
				$('#addOrUpdate').find('input#id').val(node.id);
				$('#addOrUpdate').find('input#name').val(node.name);
				$('#addOrUpdate').find('#number').val(node.number);
				var pId = node.provinceInfoPO.id;
				$.getJSON(getUrl,function(data){
				if (data.list == null || data.list.length==0 ) {
					var str = "" ;
 					$("#sortNum").html(str1);
 					//使下拉列表框可编辑
 					$("#sortNum").combobox({editable:true});
				} else {
	 					var str = "" ;
	 					for(var i = 0;i<data.list.length;i++){
	 						str += "<option value="+data.list[i]+">"+data.list[i]+"</option>" ;
	 					}
	 					$("#sortNum").html(str);
	 					//使下拉列表框可编辑
	 					$("#sortNum").combobox({editable:true});
	 					//使下拉列表回显
						$('#sortNum').combobox('setValue', node.sortNum);
				}
				if (data.provinceList == null || data.provinceList.length==0 ) {
				} else {
	 					var str = "" ;
	 					for(var i = 0;i<data.provinceList.length;i++){
	 						str += "<option value="+data.provinceList[i].id+">"+data.provinceList[i].name+"</option>" ;
	 					}
	 					$("#AllProvince").html(str);
// 	 					$("#AllProvince").combobox({editable:false});
	 					//使下拉列表回显
// 						$('#AllProvince').combobox('setValue', pId);
	 					$("#AllProvince").val(pId);
				}
			});
				
					showDialog_('修改市(区)','addOrUpdateWin','city')
			}
		}
		 
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
					if(data.msg=='hasCounty'){
						$.messager.info('所删除的市(区)含有区(县),不允许删除');
						return false;
					}
//					else if(data.msg=='hasRes'){
//						$.messager.confirm('确认框', '所删除的角色中关联了资源信息，仍然删除吗?', function(r){
//						if (r){
//							doDel(ss);
//						}});
//					}
					else{
						$.messager.confirm('确认框', '确定要删除吗?', function(r){
						if (r){ 
							doDel(ss);
						}});
					}
				},'json');
			}
			function doDel(ss){
				$.post(delUrl, {cityIds:ss.join(',')}, 
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
			<div style="width: 1100;height: 18px;">
					<input type="button" style="height: 35px;width: 120px;background-color: #9A9691;border: 0px;cursor:pointer;color: white;" value="省（直辖市）维护" onclick="window.location.href='${ctx}/config/provinceInfo/list'"/>
					&nbsp;
					<input type="button" disabled="disabled" style="height: 35px;width: 120px;background-color: #EE5F45;border: 0px;cursor:pointer;color: white;" value="市（区）维护" />
					&nbsp;
					<input type="button" style="height: 35px;width: 120px;background-color: #9A9691;border: 0px;cursor:pointer;color: white;" value="区（县）维护" onclick="window.location.href='${ctx}/config/districtAndCountyInfo/list'"/>
					&nbsp;
					<input type="button" style="height: 35px;width: 120px;background-color: #9A9691;border: 0px;cursor:pointer;color: white;" value="街道（乡）维护" onclick="window.location.href='${ctx}/config/townshipinfo/list'"/>
					&nbsp;
					<input type="button" style="height: 35px;width: 120px;background-color: #9A9691;border: 0px;cursor:pointer;color: white;" value="社区（村）维护" onclick="window.location.href='${ctx}/config/villageInfo/list'"/>
					
					<div  style="width: 99%;height: 70px;border: 1px solid #CCCCCC;position: absolute;top: 40px;"></div>
			</div>
			
				<br><br><br><br><br><br><br><br>
			<form id="queryForm" method="post">
			
					<span style="position:absolute; left: 30px;top: 60px;">省(直辖市)名称: </span>
					<input id="queryProvinceName" type="text" name="pName" style="width: 150px;height: 25px;position: absolute;left: 125px;top: 58px;border:#C8C9CD 1px solid;"/>
					<span style="position:absolute; left: 320px;top: 60px;">市(区) 名称:</span>
					<input id="queryCityName" type="text" name="cName" style="width: 150px;height: 25px;position: absolute;left: 398px;top: 58px;border:#C8C9CD 1px solid;"/>
					<span style="position:absolute; left: 590px;top: 60px;">市(区)编码:</span>
					<input id="queryCityNumber"  type="text" name="number" style="width: 150px;height: 25px;position: absolute;left: 663px;top: 58px;border:#C8C9CD 1px solid;"/>
					
						<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn" style="position: absolute;left: 92%;top: 50;background-color: #56BB4D;"><i class="fa fa-search"></i>查询</a>
			</form>
		</div>
		<div data-options="region:'south',border:false">
		<b:privilege url="sys/role/add">
			<a id="beforeAdd" href="javascript:void(0)" class="easyui-linkbutton new" onClick="add();" style="position: absolute;right: 14%;top: 130px;">新建</a>
		</b:privilege>
		<b:privilege url="sys/role/del">
			<a href="javascript:void(0)" class="easyui-linkbutton reset" onClick="del();" style="position: absolute;right: 8%;top: 130px;">删除</a>
		</b:privilege>
		<b:privilege url="sys/role/update">
			<a href="javascript:void(0)" class="easyui-linkbutton save"  onClick="edit();" style="position: absolute;right: 2%;top: 130px;">修改</a>
		</b:privilege>
		</div>  
	</div>
 </div>
 <div id="tt1">
 </div>
</div>
		<!-- 新建/修改市(区) -->
		<div id="addOrUpdateWin" class="easyui-dialog" title="角色" closed="true">
			<form id="addOrUpdate" name="addOrUpdate" method="post">
			<input type="hidden" id="id" name="id"/>
<!-- 			<input id="add" type="button" disabled="disabled" -->
<!-- 											style="height: 35px; width: 120px; background-color: #EE5F45;border: 0px;color: white;position: absolute;top: 0px;left: 0px;" -->
<!-- 											value="新建市（区）" />  -->
<!-- 			<input id="edit" type="button" disabled="disabled" -->
<!-- 											style="height: 35px; width: 120px; background-color: #EE5F45;border: 0px;color: white;position: absolute;top: 0px;left: 0px;" -->
<!-- 											value="修改市（区）" />  -->
											<br>
				<table class="datagrid-body" width="100%" align="center">
					<tr>
					<td class="datagrid-header" align="right">
						省(直辖市)名称：
					</td>
					<td>
						<select class="easyui-validatebox text"	required="true"	 missingMessage="请选择省(直辖市)名称" required="true" name="provinceInfoPO.id"  id="AllProvince" style="width:150px;height: 25px;">
						 </select>	
					</td>
					</tr>
					
						<tr>
					<td class="datagrid-header" align="right">
						市(区)名称：
					</td>
					<td>
						<input class="easyui-validatebox text"	required="true"	data-options="validType:['maxLength[30]','invalidChar']" missingMessage="请输入市(区)名称" name="name" id="name" style="width:150px;height: 25px;"  />
					</td>
					</tr>
					<tr>
					<tr>
					<td class="datagrid-header" align="right">
						市(区)编码：
					</td>
					<td>
						<input class="easyui-validatebox text"	required="true" missingMessage="请输入市(区)编码" name="number" id="number" style="width:150px;height: 25px;" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header" align="right">
						排列顺序：
					</td>
					<td>
						<select class="easyui-validatebox text"	required="true" missingMessage="请输入市(区)排序号" validType="number" name="sortNum"  id="sortNum" style="width:150px;height: 25px;">
						 </select>	
						
					</td>
					</tr>
					
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<a href="#" class="easyui-linkbutton" iconCls="icon-save" id="submitButton" style="height: 35px; width: 50px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left: 30%;bottom: 15%;">保存</a>
							<a href="#" class="easyui-linkbutton" iconCls="icon-cancel"  style="height: 35px; width: 50px; background-color: #009ED7;border: 0px;color: white;position: absolute;right: 25%;bottom: 15%;"
								onClick="closeDialog_();">取消</a>
						</td>
					</tr>
				</table>
				<br><br>
			</form>
		</div>
	</body>
</html>
