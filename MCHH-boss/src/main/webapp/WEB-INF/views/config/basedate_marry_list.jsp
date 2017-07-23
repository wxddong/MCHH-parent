<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>基础数据管理-结婚登记人数</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<script type="text/javascript">
	    var fid = '-1';
    	var addUrl = "${ctx}/marriager/add";
    	var listUrl = "${ctx}/marriager/list";
		var delUrl = "${ctx}/marriager/del";
	    var updateUrl = "${ctx}/marriager/updateView";
		 var updateMarryUrl = "${ctx}/marriager/update";
		    $(function() {
		    	
		    	document.onkeydown = function () {
		            if (window.event && window.event.keyCode == 13) {
		                window.event.returnValue = false;
		            }
		        }
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,width : '30',resizable:'false',align:'center'},
                 {title:'序号',field:'id',width : '160',resizable:'f',align:'center',hidden:true},
                 {title:'统计地区',field:'name', width : '240',resizable:'true',align:'center'},
                 {title:'统计数量',field:'marryNum',width : '130', resizable:'true',align:'center'},
                 {title:'数据来源',field:'sources', width : '180', resizable:'true',align:'center'},
                 {title:'是否有效',field:'isvalid',width : '120',resizable:'true',align:'center',
                	
                	 formatter:function(v){ 
                         if(v==0){
                             return "无效"
                         } 
                         if(v==1){
                             return "有效"
                         } 
                     }
                 
                 
                 },
                 {title:'统计初始期',field:'statisticnow',formatter:formatDate,width : '200',resizable:'true',align:'center'
                	
                 
                 },
                 {title:'统计截至期',field:'statisticfur',formatter:formatDate,width : '200',resizable:'true',align:'center'
                 	
                     
                 }
                ]]
			});
			
		});
	  

		//修改
		function edit(node){
			if(!node){
				node = getSelected('edit');
			}
			showDialog_URl('修改结婚登记人数','addOrUpdateAtv',updateUrl+'?id='+node.id,'maxiddle');
		}
		
		//添加
		function add(){
			
			showDialog_('新建结婚登记人数','addOrUpdateWin','maxiddle');
		}
		
		//保存数据
		function save(){
			var county=document.getElementById("county").value;
   			if(county ==null || county ==""){
   				alert("请选择统计地区");
   				return false;
   			};
   			
   			var marry=document.getElementById("marry").value;
   			if(marry ==null || marry ==""){
   				alert("请选择统计数量");
   				return false;
   			};
   			
   			
   			var sour=document.getElementById("sour").value;
   			if(sour ==null || sour ==""){
   				alert("请选择统计来源");
   				return false;
   			};
   			
   			
   			var statisnow=document.getElementById("statisnow").value;
   			if(statisnow ==null || statisnow ==""){
   				alert("请选择统计初始期");
   				return false;
   			};
   			
   			var statifur=document.getElementById("statifur").value;
   			if(statifur ==null || statifur ==""){
   				alert("请选择统计末期");
   				return false;
   			};
   			
   			
   			
   			
   			
			
		$("#addOrUpdate").attr("action",addUrl);	
		$("#addOrUpdate").submit();
		}
		

		 //修改保存
			function sum(){
			 
			 
			 
				var coId=document.getElementById("coId").value;
	   			if(coId ==null || coId ==""){
	   				alert("请选择统计地区");
	   				return false;
	   			};
	   			
	   			var maNum=document.getElementById("maNum").value;
	   			if(maNum ==null || maNum ==""){
	   				alert("请选择统计数量");
	   				return false;
	   			};
	   			
	   			
	   			var soues=document.getElementById("soues").value;
	   			if(soues ==null || soues ==""){
	   				alert("请选择统计来源");
	   				return false;
	   			};
	   			
	   			
	   			var sticnow=document.getElementById("sticnow").value;
	   			if(sticnow ==null || sticnow ==""){
	   				alert("请选择统计初始期");
	   				return false;
	   			};
	   			
	   			var sticfur=document.getElementById("sticfur").value;
	   			if(sticfur ==null || sticfur ==""){
	   				alert("请选择统计末期");
	   				return false;
	   			};
	   			
	   			
	   			
	   			
				$("#UpdateFrom").attr("action",updateMarryUrl);
				$("#UpdateFrom").submit();
				
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
		<input type="button" style="height: 35px; width: 120px; background-color: #999999;border: 0px;cursor:pointer;color: white;"
											value="辖区内人口总数" onclick="window.location.href='${ctx}/populationdata/addxiaquview'"/> 
		&nbsp;
		<input type="button" disabled="disabled" style="height: 35px; width: 120px; background-color: #ee5f45;border: 0px;cursor:pointer;color: white;"
											value="结婚登记人数" onclick="window.location.href='${ctx}/marriager/addcontrollerview'"/> 

		<br>
		<br>
		
		<div style="position:relative; border: 1px solid #cccccc; top:-18px;height: 70px;width: 1120px;">
			 <br>
			 <form id="queryForm" method="post">
			 	<div style="top:15px;left:40px;position:absolute;">
			统计地区:
			<select class="easyui-validatebox select" name="name" id="name"  style="width:180px;border:1px solid #cccccc;">
				 <c:forEach var="adress" items="${findAll}" varStatus="status">
				 	<option  value="${adress.id}">${adress.name}</option>
				 </c:forEach>
			 </select>
			 是否有效:
			 <select class="easyui-validatebox select" name="isvalid" id="isvalid"  value="list.isvalid" style="width:180px;border:1px solid #cccccc;">
				 	<option id="" name="isvalid" value="0">无效</option>
				 	<option id="" name="isvalid" value="1">有效</option>				 	
			 </select>	 
			 
			 统计时间: <input type="text" id="statisticnow" name="statisticnow"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'statisticfur\')}'})"/>
      	       <span>-</span>
      			<input type="text" id="statisticfur" name="statisticfur"  readonly style="width:180px;height:27px;border:1px solid #cccccc; "
      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'statisticnow\')}'})"/>
			</div>
			<div style="top:15px;height: 50px;left:1040px;width: 100px;position:absolute;">
				<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn" onclick="select()"style="background-color: #56BB4D;"><i class="fa fa-search"></i>查询</a>
			</div>
			</form>
		
		</div>
    	<div data-options="region:'south',border:false"> 
			<b:privilege url="sys/role/add">
			  <a href="javascript:void(0)" class="easyui-linkbutton new" onClick="add();" style="top:120px;left:910px;position:absolute;">添加</a>
		    </b:privilege>	    
		    <b:privilege url="sys/role/update">
			<a href="javascript:void(0)" class="easyui-linkbutton reset" onClick="edit();" style="top:120px;left:980px;position:absolute;">修改</a>
			</b:privilege>
			 <b:privilege url="sys/role/del">
			  <a href="javascript:void(0)"  class="easyui-linkbutton save" onClick="del();" style="top:120px;left:1050px;position:absolute;">删除</a>
		    </b:privilege>	
	   </div>
	 <br><br> 
	</div>
		<div id="addOrUpdateAtv" class="easyui-dialog" closed="true"></div>
	   <div id="addOrUpdateWin" class="easyui-dialog" title="预约检查" closed="true">
	   		 <form id="addOrUpdate" method="post">
			   <input type="hidden" id="id" name="id" value="${id}"/>
			   
            <div style="left:80px;top:30px;position:absolute;">
			 <table class="datagrid-body" width="100%">
				    <tr>
						<td class="datagrid-header">统计地区：<span style="color: red;">*</span>	</td>
					<td>
					   <select class="easyui-validatebox select"  name="countyId" id="county" style="width:180px;border:1px solid #cccccc;">
					   	<c:forEach var="adress" items="${findAll}" varStatus="status">
				 				<option id="" name="name" value="${adress.id}">${adress.name}</option>
				 		</c:forEach>
					   </select>				
				    </td>
				</tr>
				    <tr>
						<td class="datagrid-header">统计数量：<span style="color: red;">*</span>	</td>
						<td><input name="marryNum" id="marry" class="easyui-validatebox text"  style="border:1px solid #cccccc;"  validType="maxLength[200]" required="true" missingMessage="标题不能为空" /></td>
					</tr>
			    <tr>
						<td class="datagrid-header">数据来源：<span style="color: red;">*</span>	</td>
						<td><input name="sources" id="sour" class="easyui-validatebox text"   style="border:1px solid #cccccc;" validType="maxLength[200]" required="true" missingMessage="标题不能为空" /></td>
				</tr>
				<tr>
					<td class="datagrid-header">统计时间：<span style="color: red;">*</span></td>
					<td>
							<input type="text" id="statisnow" name="statisticnow"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
			      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'statisticfur\')}'})" />
	      					
	      					<span>-</span>
	      					
			      			<input type="text" id="statifur" name="statisticfur"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
			      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'statisticnow\')}'})" >
					</td>
				</tr>
			      <tr>
						<td class="datagrid-header">是否有效：<span style="color: red;">*</span>	</td>
					<td>
						 <select class="easyui-validatebox select"  name="isvalid" id="isvalid" style="width:180px;border:1px solid #cccccc;">
							 	<option id="" name="isvalid" value="0">无效</option>
							 	<option id="" name="isvalid" value="1">有效</option>
							 	
					 		
						</select>		
				    </td>
				</tr>
			    
				  <tr>
						<td>
							&nbsp;
						</td>
						<td>
							<div id="u6" class="ax_形状" >
						        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:18%;" onclick="save()">&nbsp 保存</a>
							 </div>
						     
						     <div id="u4" class="ax_形状">
						     	<a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #009DD9;border: 0px;color: white;position: absolute;right:15%;" iconCls="icon-cancel"
														onClick="closeDialog_();">&nbsp 取消</a>
						     </div>
						</td>
				 </tr>
			   </table>
			   </div>
			</form>
	   </div>
	</body>
</html>