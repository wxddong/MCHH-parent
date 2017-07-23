<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>区（县）维护</title>
		<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
		<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

		<script type="text/javascript">
		var getUrl = "${ctx}/config/districtAndCountyInfo/all";
		var selfUrl = "${ctx}/config/districtAndCountyInfo/list";
		var addUrl = "${ctx}/config/districtAndCountyInfo/add";
		var updateUrl = "${ctx}/config/districtAndCountyInfo/update";
		var delUrl = "${ctx}/config/districtAndCountyInfo/del";
		var beforeDelUrl = "${ctx}/config/districtAndCountyInfo/beforeDel";
// 		var updateGrantUrl="${ctx}/sys/role/grant/update";
		var listUrl = selfUrl;
		$(function() {
			//保存时进行校验 添加或修改重复地区时 弹框提示
			$("#name").change(function(){
				var	name = $("#name").val();
				var beforeUrl="${ctx}/config/districtAndCountyInfo/findByName?name="+name;
				$.ajax({
					
					url:beforeUrl,
					type:"GET",
					success:function(data){
						
						if(data.countyPO!=null){
							alert("名字已存在，请更换");
							addUrl = "";
							updateUrl="";
							//做一个标记 证明已经将addUrl的地址更换为"",当再次点击
						}else{
							addUrl = "${ctx}/config/districtAndCountyInfo/add";
							updateUrl = "${ctx}/config/districtAndCountyInfo/update";
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
// 				 var cityName = $("#AllCities").val();
// 				 if(cityName==null){
// 					 alert("请选择市（区）的名称");
// 					 return false;
// 				 }
			
// 				//省（直辖市）名称 汉字 1-30个字符
// 				var nameReg = /[\u4e00-\u9fa5]/;
// 				var name =$.trim($("#name").val());
// 				if(!nameReg.test(name)){
// 					alert("区（县）名称只能为汉字且不能为空");
// 					return false;
// 				}
// 				//编码 仅限数字 1-30个字符
// 				var numberReg = /^[0-9]*$/;
// 				var number = $.trim($("#number").val());
// 				if(!numberReg.test(number)||number==""){
// 					alert("区（县）编码只能为数字且不能为空");
// 					return false;
// 				}
// 				//排序号 仅限数字
// 				var sortNumberReg = /^[0-9]*$/;
// 				var sortNumber = $.trim($("#SortNmber").val());
// 				if(!sortNumberReg.test(sortNumber)||sortNumber==""){
// 					alert("区（县）排序号只能为数字且不能为空");
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
				//区（县）名称 汉字
				var countyNameReg = /[\u4e00-\u9fa5]/;
				var countyName =$.trim($("#queryCountyName").val());
				if(!countyNameReg.test(countyName)&&countyName!=""){
					alert("区（县）名称只能为汉字");
					window.location.href = selfUrl;
					return false;
				}
				//仅限数字
				var countyNumberReg = /^[0-9]*$/;
				var countyNumber = $.trim($("#queryCountyNumber").val());
				if(!countyNumberReg.test(countyNumber)&&countyNumber!=""){
					alert("区（县）编码只能为数字");
					window.location.href = selfUrl;
					return false;
				}
				
			});
			
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
			columns:[[
                  {field:'ck',field:'全选',checkbox:true,width : '80',align:'center'},
                  {title:'排序',field:'sortNum',width : '100',align:'center'},
                  {title:'区(县)名称',field:'name',width : '310',align:'center'},
                  {title:'区(县)编码',field:'number',width : '310',align:'center'},
                  {title:'市(区)编码',field:'cityInfoPO.number',width : '310',align:'center'},
                  {title:'市(区)id',field:'cityInfoPO.id',width : '310',align:'center',hidden:true},
                  {title:'省(直辖市)编码',field:'cityInfoPO.provinceInfoPO.number',width : '310',align:'center'},
                  {title:'省(直辖市)id',field:'cityInfoPO.provinceInfoPO.id',width : '310',align:'center',hidden:true}
                 ]]
			});	
			
			//点击省的下拉列表，自动匹配市的下拉列表
			$("#AllProvince").change(function(){
				var provinceId = $("#AllProvince").val();
				var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
				  $.ajax({
			             type: "GET",
			             url: cityUrl,
			             data: {"times":new Date(),"parentId":provinceId },
			             dataType: "json",
			             success: function(data){
					            	 if (data.list == null || data.list.length==0 ) {
					            		 $("#AllCities").html("");
										} else {
												var str = "" ;
							 					for(var i = 0;i<data.list.length;i++){
							 						str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
							 					}
							 					$("#AllCities").html(str);
							 					$("#AllCities")[0].selectedIndex = -1;
// 							 					$("#AllCities").combobox({editable:false});
							 					
										}
			                      }
			         });
			});
			
		});
		
		
		
		//添加
		function add(){
			resetAddOrUpdateForm();
			addUrl = "${ctx}/config/districtAndCountyInfo/add";
			updateUrl = "${ctx}/config/districtAndCountyInfo/update";
// 			$("#add").show();
// 			$("#edit").hide();
			$("#AllCities").html("");
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
	 					var str = "" ;
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

			showDialog_('新建区(县)','addOrUpdateWin','county');
		}
		
		 //修改
		  function edit(){
// 			$("#add").hide();
// 			$("#edit").show();
			var node = getSelected('edit');
			addUrl = "${ctx}/config/districtAndCountyInfo/add";
			updateUrl = "${ctx}/config/districtAndCountyInfo/update";
			if(node){
				$('#addOrUpdate').find('input#id').val(node.id);
				$('#addOrUpdate').find('input#name').val(node.name);
				$('#addOrUpdate').find('#number').val(node.number);
				var pId = node.cityInfoPO.provinceInfoPO.id;
				var cId = node.cityInfoPO.id;
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
// 	 					$('#AllProvince').combobox('setValue',pId);
	 					$("#AllProvince").val(pId);
				}
			});
			//ajax请求获取所有的市的下拉列表 并用于回显
			var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
			$.ajax({
			             type: "GET",
			             url: cityUrl,
			             data: {"times":new Date(),"parentId":pId },
			             dataType: "json",
			             success: function(data){
					            	 if (data.list == null || data.list.length==0 ) {
					            		 $("#AllCities").html("");
										} else {
												var str = "" ;
							 					for(var i = 0;i<data.list.length;i++){
							 						str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
							 					}
							 					$("#AllCities").html(str);
							 					$("#AllCities").val(cId);
// 							 					$("#AllCities").combobox({editable:false});
										}
			                      }
			         });
					showDialog_('修改区(县)','addOrUpdateWin','county')
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
						if(data.msg=='hasTown'){
							$.messager.info('所删除的区(县)含有街道(乡),不允许删除');
							return false;
						}
//	 					else if(data.msg=='hasRes'){
//	 						$.messager.confirm('确认框', '所删除的角色中关联了资源信息，仍然删除吗?', function(r){
//	 						if (r){
//	 							doDel(ss);
//	 						}});
//	 					}
						else{
							$.messager.confirm('确认框', '确定要删除吗?', function(r){
							if (r){ 
								doDel(ss);
							}});
						}
					},'json');
				}
				function doDel(ss){
					$.post(delUrl, {countyIds:ss.join(',')}, 
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
						<input type="submit" style="height: 35px;width: 120px;background-color: #9A9691;border: 0px;cursor:pointer;color: white;" value="省（直辖市）维护" onclick="window.location.href='${ctx}/config/provinceInfo/list'"/>
						&nbsp;
						<input type="button" style="height: 35px;width: 120px;background-color: #9A9691;border: 0px;cursor:pointer;color: white;" value="市（区）维护" onclick="window.location.href='${ctx}/config/cityInfo/list'" />
						&nbsp;
						<input type="button" disabled="disabled" style="height: 35px;width: 120px;background-color: #EE5F45;border: 0px;cursor:pointer;color: white;" value="区（县）维护" />
						&nbsp;
						<input type="button" style="height: 35px;width: 120px;background-color: #9A9691;border: 0px;cursor:pointer;color: white;" value="街道（乡）维护" onclick="window.location.href='${ctx}/config/townshipinfo/list'"/>
						&nbsp;
						<input type="button" style="height: 35px;width: 120px;background-color: #9A9691;border: 0px;cursor:pointer;color: white;" value="社区（村）维护" onclick="window.location.href='${ctx}/config/villageInfo/list'"/>
						<div  style="width: 99%;height:90px;border: 1px solid #CCCCCC;position: absolute;top: 40px;"></div>
				</div>
				<br><br><br><br><br><br><br><br><br>
			<form id="queryForm" method="post">
					<div style="position:absolute; left: 125px;top: 60px;">省(直辖市)名称:</div>
					 <input id="queryProvinceName" type="text" name="pName" style="width: 150px;height: 25px;position: absolute;left: 225px;top: 58px;border:#C8C9CD 1px solid;"/>
					<div style="position:absolute; left: 422px;top: 60px;">市(区)名称:</div> 
					<input id="queryCityName" type="text" name="cName" style="width: 150px;height: 25px;position: absolute;left: 498px;top: 58px;border:#C8C9CD 1px solid;"/>
					<div style="position:absolute; left: 145px;top: 92px;">区(县) 名称: </div>
					<input id="queryCountyName" type="text" name="dName" style="width: 150px;height: 25px;position: absolute;left: 225px;top: 90px;border:#C8C9CD 1px solid;"/>
					<div style="position:absolute; left: 420px;top: 92px;">区(县) 编码: </div>
					<input id="queryCountyNumber" type="text" name="number" style="width: 150px;height: 25px;position: absolute;left: 498px;top: 90px;border:#C8C9CD 1px solid;"/>
			
					<a style="position: absolute;left: 92%;top: 80;background-color: #56BB4D;" href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
			</form>
		</div>
		<div data-options="region:'south',border:false">
		<b:privilege url="sys/role/add">
			<a href="javascript:void(0)" class="easyui-linkbutton new" onClick="add();" style="position: absolute;right: 14%;top: 150px;">新建</a>
		</b:privilege>
		<b:privilege url="sys/role/del">
			<a href="javascript:void(0)" class="easyui-linkbutton reset" onClick="del();" style="position: absolute;right: 8%;top: 150px;">删除</a>
		</b:privilege>
		<b:privilege url="sys/role/update">
			<a href="javascript:void(0)" class="easyui-linkbutton save" onClick="edit();" style="position: absolute;right: 2%;top: 150px;">修改</a>
		</b:privilege>
		</div>  
	</div>
 </div>
 <div id="tt1">
 </div>
</div>
		<!-- 新建区(县) -->
		<div id="addOrUpdateWin" class="easyui-dialog" title="添加/修改区县" closed="true">
			<form id="addOrUpdate" name="addOrUpdate" method="post">
			<input type="hidden" id="id" name="id"/>
<!-- 			<input id="add" type="button" disabled="disabled" -->
<!-- 											style="height: 35px; width: 120px; background-color: #EE5F45;border: 0px;color: white;position: absolute;top: 0px;left: 0px;" -->
<!-- 											value="新建区（县）" />  -->
<!-- 			<input id="edit" type="button" disabled="disabled" -->
<!-- 											style="height: 35px; width: 120px; background-color: #EE5F45;border: 0px;color: white;position: absolute;top: 0px;left: 0px;" -->
<!-- 											value="修改区（县）" />  -->
											<br>
				<table class="datagrid-body" width="100%">
					<tr>
					<td class="datagrid-header" align="right">
						省(直辖市)名称：
					</td>
					<td>
						<select class="easyui-validatebox text"	required="true" missingMessage="请选择省(直辖市)名称"  name="cityInfoPO.provinceInfoPO.id"  id="AllProvince" style="width:150px;height: 25px;">
						 </select>	
					</td>
					</tr>
					<tr>
					<td class="datagrid-header" align="right">
						市(区)名称：
					</td>
					<td>
						<select class="easyui-validatebox text"	required="true" missingMessage="请输入市(区)名称"  name="cityInfoPO.id"  id="AllCities" style="width:150px;height: 25px;">
						 </select>	
					</td>
					</tr>
					<tr>
					<td class="datagrid-header" align="right">
						区(县)名称：
					</td>
					<td>
						<input class="easyui-validatebox text"	required="true"	data-options="validType:['maxLength[30]','invalidChar']" missingMessage="请输入区(县)名称" name="name" id="name" style="width:150px;height: 25px;" />
					</td>
					</tr>
					<tr>
					<td class="datagrid-header" align="right">
						区(县)编码：
					</td>
					<td>
						<input class="easyui-validatebox text"	required="true" missingMessage="请输入区(县)编码" name="number" id="number" style="width:150px;height: 25px;"  />
					</td>
					</tr>
					
					<tr>
					<td class="datagrid-header" align="right">
						排列顺序：
					</td>
					<td>
						<select class="easyui-validatebox text"	required="true" validType="number" missingMessage="请输入区(县)排序号"  name="sortNum" id="sortNum" style="width:150px;height: 25px;">
						 </select>	
						
					</td>
					</tr>
					
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<a href="#" class="easyui-linkbutton" iconCls="icon-save" id="submitButton" style="height: 35px; width: 50px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left: 30%;bottom: 12%;">保存</a>
							<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" style="height: 35px; width: 50px; background-color: #009ED7;border: 0px;color: white;position: absolute;right: 25%;bottom: 12%;"
								onClick="closeDialog_();">取消</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
