<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<div>
		<br> 
       <form id="UpdateFrom" name="UpdateFrom" method="post">
			   <input type="hidden" id="id" name="id" value="${find.id}"/>
			   
			    <div style="left:80px;top:30px;position:absolute;">
			     <table class="datagrid-body" width="100%">
				   <tr>
						<td class="datagrid-header">统计地区：<span style="color: red;">*</span> </td>
						<td>
							<select class="easyui-validatebox select" name="countyId" id="coun"  style="width:180px;border:1px solid #cccccc;">				 
							 	
							 	<option id="name" value="${DistricId}" selected>${country}</option>
								<c:forEach var="list" items="${district }">
									<option value="${list.id }">${list.name }</option>
								</c:forEach>
								
							</select>
							<select class="easyui-validatebox select" name="towId" id="towId3"  style="width:180px;border:1px solid #cccccc;">
							 	<option id="name" value="${townId}" selected>${tow}</option>
							 </select>
						 
							 <select class="easyui-validatebox select" name="villageId" id="villageId3"  style="width:180px;border:1px solid #cccccc;">
							 	<option id="name" value="${villageId}" selected>${vill}</option>
							 </select>
						</td>
					</tr>
				    <tr>
						<td class="datagrid-header">统计数量：<span style="color: red;">*</span> </td>
					    <td><input name="marryNum" id="maNum" class="easyui-validatebox text"  value="${find.marryNum}"  validType="maxLength[200]" required="true" missingMessage="标题不能为空" /></td>
			      </tr>

				<tr>
				    <td class="datagrid-header">统计时间：<span style="color: red;">*</span></td>
					
					<td>
					   <input type="date" id="tical" name="statisticalDate"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'statisticalDateEnd\')}'})" value="${find.statisticalDate}" />
      	       		
      	       		<span>-</span>
      	       		
      				<input type="date" id="calEnd" name="statisticalDateEnd"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'statisticalDate\')}'})" value="${find.statisticalDateEnd}" />
					
					</td>
				</tr>  
				
				
				<tr>
			     <td class="datagrid-header">是否有效：<span style="color: red;">*</span></td>
				<td>
					<select class="easyui-validatebox select" name="isvalid" id="isl"  style="width:180px;border:1px solid #cccccc;">				 
						 	<c:if test="${find.isvalid=='0' }">
						 	<option id="isvalid" selected value="0">无效</option>
						 	<option id="isvalid" value="1">有效</option>
							</c:if>
							<c:if test="${find.isvalid=='1' }">
						 	<option id="isvalid" selected value="1">有效</option>
						 	<option id="isvalid" value="0">无效</option>
							</c:if>
					</select>
			     </td>
			     </tr>

				  <tr style="height: 60px;">
						<td>
							&nbsp;
						</td>
						<td>
							<div id="u6" class="ax_形状" >
						        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:18%;bottom: 1%;" onclick="sum()">&nbsp 保存</a>
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
		
		
		<script type="text/javascript">
		 var selectTOW = "${ctx}/populationdata/selectTOW";
		 var selectVillage = "${ctx}/populationdata/selectVillage";
		 
		 $(function() {
		/*得到乡的信息进行下拉显示  */
			$("#coun").change(function(){
				var countyId3=document.getElementById('coun').value;
				$.ajax({
		             type: "GET",
		             url: selectTOW,
		             data: {countyId:countyId3},
		             success: function(data){
		            	
				            	 if (data.list == null || data.list.length==0 ) {
				            		 $("#towId3").html("");
									} else {
											var str = "" ;
						 					for(var i = 0;i<data.list.length;i++){
						 						str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
						 					}
						 					$("#towId3").html(str);
						 					$("#towId3")[0].selectedIndex = -1;
									}
		                      }
		         });
				
			});
			
			
			
			/*得到村的信息进行下拉显示  */
			$("#towId3").change(function(){
				var towId3=document.getElementById('towId3').value;
				$.ajax({
		             type: "GET",
		             url: selectVillage,
		             data: {towId:towId3},
		             dataType: "json",
		             success: function(data){
				            	 if (data == null || data.list.length==0 ) {
				            		 $("#villageId3").html("");
									} else {
										
										var str = "" ;
					 					for(var i = 0;i<data.list.length;i++){
					 						//$("#villageId").append("<option value='"+data.list[i].id+"'>"+data.list[i].name+"<option>");
					 						 str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
					 					}
					 					
						 					$("#villageId3").html(str);
						 					$("#villageId3")[0].selectedIndex = -1;
									}
		                      }
		         });
				
			});
		 })
		 
		 
		</script>
	</div>
