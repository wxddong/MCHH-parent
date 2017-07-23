<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>基础数据管理-辖区人数</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<script type="text/javascript">
	    var fid = '-1';
    	var addUrl = "${ctx}/populationdata/add";
    	var listUrl = "${ctx}/populationdata/Distictlist";
		var delUrl = "${ctx}/populationdata/delPopulation";
	    var updateUrl = "${ctx}/populationdata/updateView";
	    var updatePopUrl = "${ctx}/populationdata/update";
	    var selectTOW = "${ctx}/populationdata/selectTOW";
	    var selectVillage = "${ctx}/populationdata/selectVillage";
	    //var distictlistUrl = "${ctx}/populationdata/Distictlist";
		    $(function() {
		    	
		    	document.onkeydown = function () {
		            if (window.event && window.event.keyCode == 13) {
		                window.event.returnValue = false;
		            }
		        }
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,width : '40',resizable:'false',align:'center'},
                 {title:'序号',field:'id',width : '170',resizable:'f',align:'center',hidden:true},
                 {title:'统计地区',field:'countyId', width : '240',resizable:'true',align:'center'},
                 {title:'统计数量',field:'marryNum',width : '160', resizable:'true',align:'center'},
                 {title:'是否有效',field:'isvalid',width : '190',resizable:'true',align:'center',
                	
                	 formatter:function(v){ 
                         if(v==0){
                             return "无效"
                         } 
                         if(v==1){
                             return "有效"
                         } 
                     }
                 
                 
                 },
                 {title:'统计初始期',field:'statisticalDate',formatter:formatDate,width : '240',resizable:'true',align:'center'
                	
                 
                 },
                 {title:'统计截至期',field:'statisticalDateEnd',formatter:formatDate,width : '240',resizable:'true',align:'center'
                 	
                     
                 }
                ]]
			});
			
			
			/*得到乡的信息进行下拉显示  */
			$("#countyId").change(function(){
				
				var countyId=document.getElementById('countyId').value;
				
				$.ajax({
		             type: "GET",
		             url: selectTOW,
		             data: {countyId:countyId},
		             success: function(data){
		            	 
				            	 if (data.list == null || data.list.length==0 ) {
				            		 $("#towId").html("");
									} else {
											var str = "" ;
						 					for(var i = 0;i<data.list.length;i++){
						 						str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
						 					}
						 					$("#towId").html(str);
						 					$("#towId")[0].selectedIndex = -1;
									}
		                      }
		         });
				
			});
			
			
			
			
			/*得到村的信息进行下拉显示  */
			$("#towId").change(function(){
				var towId=document.getElementById('towId').value;
				$.ajax({
		             type: "GET",
		             url: selectVillage,
		             data: {towId:towId},
		             dataType: "json",
		             success: function(data){
		            	 
				            	 if (data == null || data.list.length==0 ) {
				            		 $("#villageId").html("");
									} else {
										
										var str = "" ;
					 					for(var i = 0;i<data.list.length;i++){
					 						//$("#villageId").append("<option value='"+data.list[i].id+"'>"+data.list[i].name+"<option>");
					 						 str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
					 					}
					 					
						 					$("#villageId").html(str);
						 					$("#villageId")[0].selectedIndex = -1;
									}
		                      }
		         });
				
			});
			
			
			
			
			/*得到乡的信息进行下拉显示  */
			$("#countyId1").change(function(){
				
				var countyId1=document.getElementById('countyId1').value;
				
				$.ajax({
		             type: "GET",
		             url: selectTOW,
		             data: {countyId:countyId1},
		             success: function(data){
		            	
				            	 if (data.list == null || data.list.length==0 ) {
				            		 $("#towId1").html("");
									} else {
											var str = "<option></option>" ;
						 					for(var i = 0;i<data.list.length;i++){
						 						str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
						 					}
						 					$("#towId1").html(str);
						 					$("#towId1")[0].selectedIndex = -1;
									}
		                      }
		         });
				
			});
			
			
			/*得到村的信息进行下拉显示  */
			$("#towId1").change(function(){
				var towId1=document.getElementById('towId1').value;
				$.ajax({
		             type: "GET",
		             url: selectVillage,
		             data: {towId:towId1},
		             dataType: "json",
		             success: function(data){
		            	 
				            	 if (data == null || data.list.length==0 ) {
				            		 $("#villageId1").html("");
									} else {
				
										var str = "" ;
					 					for(var i = 0;i<data.list.length;i++){
					 						//$("#villageId").append("<option value='"+data.list[i].id+"'>"+data.list[i].name+"<option>");
					 						 
					 						str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
					 					}
					 						
						 					$("#villageId1").html(str);
						 					$("#villageId1")[0].selectedIndex = -1;
									}
		                      }
		         });
				
			});
			
			
			
			
			
	  
			
		    });
			
			

		

		//修改
		function edit(node){
			if(!node){
				node = getSelected('edit');
			}
			showDialog_URl('修改辖区内人口总数','addOrUpdateAtv',updateUrl+'?id='+node.id,'moremiddle6');
			
		}
		
		//添加
		function add(){
			
			showDialog_('新建辖区内人口总数','addOrUpdateWin','moremiddle6');
		}
		
		
	
		  function save(){
			var yinchan=document.getElementById("statistical").value;
   			if(yinchan ==null || yinchan ==""){
   				alert("请选择统计时间初期");
   				return false;
   			};
   			
   			var moqi=document.getElementById("statisticalEnd").value;
   			if(moqi ==null || moqi ==""){
   				alert("请选择统计时间末期");
   				return false;
   			};
   			
   			var youxiao=document.getElementById("isval").value;
   			if(youxiao ==null || youxiao ==""){
   				alert("请选择是否有效");
   				return false;
   			};
   			
   			
   			var county=document.getElementById("countyId1").value;
   			if(county ==null || county ==""){
   				alert("请选择统计地区");
   				return false;
   			};
   			
   			
   			var num=document.getElementById("Num").value;
   			if(num ==null || num ==""){
   				alert("请选择统计数量");
   				return false;
   			};
   			
   			
   			
   				
				  $("#addUpdate").attr("action",addUrl);
	
				  $("#addUpdate").submit();
				  
			}
		function sum(){
			
			
			var tical=document.getElementById("tical").value;
   			if(tical ==null || tical ==""){
   				alert("请选择统计时间初期");
   				return false;
   			};
   			
   			var calEnd=document.getElementById("calEnd").value;
   			if(calEnd ==null || calEnd ==""){
   				alert("请选择统计时间末期");
   				return false;
   			};
   			
   			var isl=document.getElementById("isl").value;
   			if(isl ==null || isl ==""){
   				alert("请选择是否有效");
   				return false;
   			};
   			
   			
   			var coun=document.getElementById("coun").value;
   			if(coun ==null || coun ==""){
   				alert("请选择统计地区");
   				return false;
   			};
   			
   			
   			var maNum=document.getElementById("maNum").value;
   			if(maNum ==null || maNum ==""){
   				alert("请选择统计数量");
   				return false;
   			};
   			
   			
			 $("#UpdateFrom").attr("action",updatePopUrl);
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
		<input type="button" disabled="disabled" style="height: 35px; width: 120px; background-color: #ee5f45;border: 0px;cursor:pointer;color: white;"
											value="辖区内人口总数" onclick="window.location.href='${ctx}/populationdata/addxiaquview'"/> 
		&nbsp;
		<input type="button"  style="height: 35px; width: 120px; background-color:#999999 ;border: 0px;cursor:pointer;color: white;"
											value="结婚登记人数" onclick="window.location.href='${ctx}/marriager/addcontrollerview'"/> 
		
		
		<br>
		<br>
		
		<div style="position:relative; border: 1px solid #cccccc; top:-18px;height: 105px;width: 1120px;">
		<br>
		<form id="queryForm" method="post">
					<table width="99%" >
						
						<tr>
							<td  align="right" width='100px'>
								统计地区:&nbsp;
							</td>
							<td align="left"  width='200px'>
								<!-- 区县 -->
								<select class="easyui-validatebox select" name="countyId" id="countyId"  style="width:180px;border:1px solid #cccccc;">
									 <c:forEach var="adress" items="${findAll}" varStatus="status">
									 	<option id="name"  value="${adress.id}">${adress.name}</option>
									 </c:forEach>
								 </select>
							 </td>
							
							 <td align="left"  width='200px' >
								 <!--乡  -->
								 <select class="easyui-validatebox select" name="towId" id="towId"  style="width:180px;border:1px solid #cccccc;">
								 	<option id="name"  value=""></option>
								 </select>
							 </td>
							 
							 <td align="left">
							 	<!--村  -->
								 <select class="easyui-validatebox select" name="villageId" id="villageId"  style="width:180px;border:1px solid #cccccc;">
								 	<option id="name"  value=""></option>
								 </select>
							 </td>
							 <td ></td>
							 <td ></td>
							 
						</tr>
						<tr style="width:180px;height:5px"><td ></td><td ></td><td ></td><td ></td><td ></td><td ></td></tr>	
						<tr>
							<td align="right"> 
							 	统计时间:&nbsp;
							</td>
							<td align="left">
							  <input type="text" id="statisticalDate" name="statisticnow"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
				      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"/>
				      	       <span>-</span>
				      		</td>
			      			
				      		<td align="left">	
				      		  <input type="text" id="statisticalDateEnd" name="statisticfur"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
				      	      onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"/>
							</td>
							
							<td align="left">
							是否有效:
							<select class="easyui-validatebox select" name="isvalid" id="isvalid" style="width:180px;border:1px solid #cccccc;">
								 	<option  value="0">无效</option>
								 	<option  value="1">有效</option>				 	
							 </select>
							</td>
							
							<td>
							</td>
						
							<td align="right">
								<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"style="background-color: #56BB4D;"><i class="fa fa-search"></i>查询</a>
							</td>
						</tr>

					</table>
			</form>
		</div>
    	<div data-options="region:'south',border:false"> 
			<b:privilege url="sys/role/add">
			  <a href="javascript:void(0)" class="easyui-linkbutton new" onClick="add();" style="top:160px;left:910px;position:absolute;">添加</a>
		    </b:privilege>	    
		    <b:privilege url="sys/role/update">
			<a href="javascript:void(0)" class="easyui-linkbutton reset" onClick="edit();" style="top:160px;left:980px;position:absolute;">修改</a>
			</b:privilege>
			 <b:privilege url="sys/role/del">
			  <a href="javascript:void(0)"  class="easyui-linkbutton save" onClick="del();" style="top:160px;left:1050px;position:absolute;">删除</a>
		    </b:privilege>	
	   </div>
	   <br><br> 
	</div>
		<div id="addOrUpdateAtv" class="easyui-dialog" closed="true"></div>
	   <div id="addOrUpdateWin" class="easyui-dialog" title="预约检查" closed="true">

  			<form id="addUpdate" name="addUpdate" method="post">
	     
			   <input type="hidden" id="id" name="id" value="${id}"/>
			   
			   <div style="left:80px;top:30px;position:absolute;">
			 	<table class="datagrid-body" width="100%">
				    <tr>
						<td class="datagrid-header">统计地区：<span style="color: red;">*</span>	</td>
					<td>
						<!-- 区县 -->
						<select class="easyui-validatebox select" name="countyId" id="countyId1"  style="width:180px;border:1px solid #cccccc;">
							 <c:forEach var="adress" items="${findAll}" varStatus="status">
							 	<option id="name"  value="${adress.id}">${adress.name}</option>
							 </c:forEach>
						 </select>
						 <!--乡  -->
						 <select class="easyui-validatebox select" name="towId" id="towId1"  style="width:180px;border:1px solid #cccccc;">
						 </select>
						 <!-- 村 -->
						 <select class="easyui-validatebox select" name="villageId" id="villageId1"  style="width:180px;border:1px solid #cccccc;">
						 </select>
			 	
				    </td>
				</tr>
				    <tr>
						<td class="datagrid-header">统计数量：<span style="color: red;">*</span>	</td>
						<td><input name="marryNum" id="Num" class="easyui-validatebox text"   validType="maxLength[200]" required="true" missingMessage="标题不能为空" /></td>
					</tr>

				<tr>
				    <td class="datagrid-header">统计时间：<span style="color: red;">*</span></td>
					<td>
					    <input type="text" id="statistical" name="statisticalDate"  readonly style="width:180px;height:27px"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"/>
		      	       
		      	        <span>-</span>

		      			<input type="text" id="statisticalEnd" name="statisticalDateEnd"  readonly style="width:180px;height:27px"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"/>
					</td>
				</tr> 
			      <tr>
						<td class="datagrid-header">是否有效：<span style="color: red;">*</span>	</td>
					<td>
						 <select class="easyui-validatebox select"  name="isvalid" id="isval" style="width:180px;border:1px solid #cccccc;">
						 	<option  value="0">无效</option>
						 	<option  value="1">有效</option>
						</select>		
				    </td>
				</tr>
			    
				  <tr style="height: 60px;">
						<td>
							&nbsp;
						</td>
						<td>
							<div id="u6" class="ax_形状" >
						        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:18%;bottom: 1%;" onclick="save()">&nbsp 保存</a>
							 </div>
						     
						     <div id="u4" class="ax_形状">
						     	<a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #009DD9;border: 0px;color: white;position: absolute;right:15%;bottom: 1%;" iconCls="icon-cancel"
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