<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>活动列表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<link href="${ctx}/static/css/app_jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/app_axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/app_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/service_styles.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/font-awesome.min.css">
	<script type="text/javascript">
	    var fid = '-1';
		var listUrl = "${ctx}/service/serviceList";
		var addUrl = "${ctx}/service/save";
		var editUrl = "${ctx}/service/updateService";
		var beforeDelUrl = "${ctx}/service/beforeChange";
		var delUrl = "${ctx}/service/change";
		$(function() {
    	  
    	    //下拉框默认为空
			$("#status")[0].selectedIndex = -1;
			$("#u135_input")[0].selectedIndex = -1;
    	    
			//关闭详情
			$("#u1731").click(function(){
				$("#detailAtv").window("close");
			})
			
			//取消新建
			$("#u145").click(function(){
				$("#addOrUpdateAtv").window("close");
			})
			
			//保存新建
			$("#u143").click(function(){
				
				var name = $.trim($("#u138_input").val());
				if (name == null || name == "") {
					alert("请输入特色服务项目名称！");
					return false;
				}
				
				var status = $("#u135_input").val();
				if (status == null || status == "") {
					alert("请选择状态！");
					return false;
				}
				
				var content = $.trim($("#u139").val());
				if (content == null || content == "") {
					alert("请输入详细介绍！");
					return false;
				}
				
				$("#add").attr("action",addUrl);
		    	$("#add").submit();
			})
			
			//保存修改
			$("#u1431").click(function(){
				
				var name = $.trim($("#u138_input").val());
				if (name == null || name == "") {
					alert("请输入特色服务项目名称！");
					return false;
				}
				
				var status = $("#u135_input").val();
				if (status == null || status == "") {
					alert("请选择状态！");
					return false;
				}
				
				var content = $.trim($("#u139").val());
				if (content == null || content == "") {
					alert("请输入详细介绍！");
					return false;
				}
				
				$("#add").attr("action",editUrl);
		    	$("#add").submit();
			})
			
			//重置
			$("#reSetBtn").click(function(){
	    		   $("#name").val("");
	    		   $("#status")[0].selectedIndex = -1;
	    		   $("#txtBegin").val("");
	    		   $("#txtEnd").val("");
	        });
			
			//列表
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'特色服务项目名称',field:'name',resizable:'true',width : '350',align:'center'},
                 {title:'状态',field:'status',resizable:'true',width : '250',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "无效"
                         } 
                         if(v==1){
                             return "有效"
                         }
                	 } 
                 },
                 {title:'添加时间',field:'createTime',formatter:formatDate,resizable:'true',width : '350',align:'center'},
                 {title:'操作',field:'Operation',align:'center',width : '350', formatter: operationFormate1}
                ]]
			});
			
		});
		
		//操作
		function operationFormate1(value,node){
			
			return operationFormate(value,node,[{'name':'detail','label':'查看详情'}],'false','false'); 
		};

		//查看
		function detail(node){
			//详情弹出框
			showDialog_("","detailAtv","zhongjianddle8",false);
			//名称
			var name = node.name;
			$("#serviceName").html(name);
			//状态
			var status = node.status;
			if (status == "0") {
				$("#serviceStatus").html("无效");
			}
			if (status == "1") {
				$("#serviceStatus").html("有效");
			}
			//添加时间
			var createTime = node.createTime;
			var create = new Date();
			create.setTime(createTime);
			var year = new Date(create).getFullYear();
	 		var month = new Date(create).getMonth()+1;
	 		var date = new Date(create).getDate();
	 		if(month<10) month="0"+month;
	 		if(date<10) date="0"+date; 
			var creat = (year)+"-"+(month)+"-"+(date);
			$("#createTime").html(creat);
			//详细介绍
			var content = node.content;
			$("#u182").html(content);
		}
		
		//新建
		function add(){
			$("#u138_input").val("");
			$("#u135_input")[0].selectedIndex = -1;
			$("#u139").val("");
			$("#u1431").hide();
			$("#u143").show();
			showDialog_("","addOrUpdateAtv","zhongjianddle8",false);
		}
		
		//修改
		function edit(node){
			//showDialog_("","addOrUpdateAtv","zhongjianddle8",false);
			$("#u143").hide();
			$("#u1431").show();
			if(!node){
				node = getSelected('edit');
			}
			var serviceId = node.id;
			$("#serviceId").val(serviceId);
			
			var name = node.name;
			$("#u138_input").val(name);
			
			var status = node.status;
			if (status == "0") {
				$("#u135_input").val("0");
			}
			if (status == "1") {
				$("#u135_input").val("1");
			}
			
			var content = node.content;
			$("#u139").val(content);
			
			showDialog_("","addOrUpdateAtv","zhongjianddle8",false);
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
						$.messager.confirm('确认框', '确定要删除吗?', function(r){
							if (r){ 
								doDel(ss);
						}});
					}
				},'json');
			}
			function doDel(ss){
				$.post(delUrl, {serviceIds:ss.join(',')}, 
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
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}
 	</style>
  </head>
 	<body class="panel-noscroll">
 	
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
		 <div>
			 <form id="queryForm" method="post">
			 <div style="position:relative;border: 1px solid #cccccc;height: 100px;width: 880px;">
				 <button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">特色服务项目</span></p></button>
				<span style="position:absolute;left:30px ;width:110px; top:68px;height: 25px;">特色服务项目名称：</span> <input style="position:absolute;left:140px ;width:140px; top:65px;height: 25px;border: 1px solid #cccccc;"  class="easyui-validatebox text" type="text" name="name" id = "name"/>
				<span style="position:absolute;left:348px ;width:70px; top:68px;height: 25px;">状态：</span>
		      	    <select class="easyui-validatebox select" name="status" id="status" style="position:absolute;border: 1px solid #cccccc;left:390px ;top:65px;width:140px;height: 25px;">
		      	    	<option value = "0">无效</option>
		      	    	<option value = "1">有效</option>
		      	    </select>
		      	
		      	<span style="position:absolute;left:620px ;width:70px; top:68px;height: 25px;">添加时间：</span>
		      		<input style="position:absolute;border: 1px solid #cccccc;left:685px ;top:65px;width:80px;height: 25px;" type="text" id="txtBegin" name="txtBegin" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'txtEnd\')}'})"/>
						<span style="position:absolute;left:770px ;top:68px;">—</span>
		      		<input style="position:absolute;border: 1px solid #cccccc;left:785px ;top:65px;width:80px;height: 25px;" type="text" id="txtEnd" name="txtEnd" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'txtBegin\')}'})"/>
				<br><br>
				</div>
				 
			<div style="position: absolute;right:8%;top: 70px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
      		</div>
      		<div style="position: absolute;right:0%;top: 70px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" id="reSetBtn"><i class="fa fa-undo"></i>重置</a>
      		</div>
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
		<br><br><br>
	</div>
	<!-- 查看详情弹出框 -->
	<div id="detailAtv" class="easyui-dialog" title="角色" closed="true">
	    	
	    	<!-- Unnamed (形状) -->
            <div id="u173" class="ax_形状" style="background-color:#EE5F45">
                <p id="u174"><span>特色服务</span><span>详情</span></p>
            </div>
            
            <div id="u1731" class="ax_形状" style="background-color:#009ED7;cursor:pointer">
                <p id="u1741"><span>关闭</span></p>
            </div>
            
            <!-- Unnamed (形状) -->
            <div id="u171" class="ax_文本段落">
                <p id="u172"><span>特</span><span>色</span><span>服务项目名称：</span><span id = "serviceName"></span></p>
            </div>
            
	    	<!-- Unnamed (形状) -->
            <div id="u169" class="ax_文本段落">
                <p id="u170"><span>状</span><span>态：</span><span id = "serviceStatus"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u176" class="ax_文本段落">
                <p id="u177"><span>添</span><span>加时间：</span><span>&nbsp; &nbsp; </span><span id = "createTime"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u178" class="ax_文本段落">
                <p id="u179"><span>详</span><span>细介绍：</span></p>
            </div>

                <textarea id="u182"></textarea>
	</div> 
	
	<div id="addOrUpdateAtv" class="easyui-dialog" title="角色" closed="true">
		<form id = "add" action=""  method="post">
		
			<input id = "serviceId" name = "serviceId" type = "hidden" value= ""/>
			<!-- Unnamed (形状) -->
            <div id="u133" class="ax_形状" style="background-color:#EE5F45">
                <p id="u134"><span>新</span><span>增特色服务</span></p>
            </div>
            
            <!-- Unnamed (形状) -->
            <div id="u131" class="ax_文本段落">
                <p id="u132"><span>特</span><span>色</span><span>服务项目名称：</span></p>
            </div>
            
            <!-- Unnamed (文本框) -->
            <div id="u138" class="ax_文本框">
              <input id="u138_input" name = "name" type="text" value=""/>
            </div>
            
            <!-- Unnamed (形状) -->
            <div id="u129" class="ax_文本段落">
                <p id="u130"><span>状</span><span>态：</span></p>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u135" class="ax_下拉列表框">
              <select id="u135_input" name = "status">
                <option value="1">有效</option>
                <option value="0">无效</option>
              </select>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u141" class="ax_文本段落">
                <p id="u142"><span>详</span><span>细介绍：</span></p>
            </div>
            
            <textarea id = "u139" name = "content"></textarea>

            <!-- Unnamed (形状) -->
            <div id="u143" class="ax_形状" style="background-color:#FC7D45;cursor:pointer">
                <p id="u144"><span>保</span><span>存</span></p>
            </div>
            
            <div id="u1431" class="ax_形状" style="background-color:#FC7D45;cursor:pointer">
                <p id="u1441"><span>保</span><span>存</span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u145" class="ax_形状" style="background-color:#009ED7;cursor:pointer">
                <p id="u146"><span>取消</span></p>
            </div>
        </form>
	</div>
	</body>
</html>

