<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<div>
       <form id="UpdateFrom" name="UpdateFrom" method="post">
			   <input type="hidden" id="id" name="id" value="${MarriageRegistrationDataPO.id}"/>
			   
			   <div style="left:80px;top:30px;position:absolute;">
			     <table class="datagrid-body" width="100%">
				   <tr>
						<td class="datagrid-header">统计地区：<span style="color: red;">*</span> </td>
						<td>
							<select class="easyui-validatebox select" name="countyId" id="coId"  style="width:180px;border:1px solid #cccccc;">				 
							 	<c:forEach var ="test" items="${findAll }">
							 		<option value="${test.id }">${test.name }</option>
							 	</c:forEach>
							 	<option id="countyId" name="countyId" value="${MarriageRegistrationDataPO.countyId}" selected>${MarriageRegistrationDataPO.name}</option>
								
							</select>
						</td>
					</tr>
				    <tr>
						<td class="datagrid-header">统计数量：<span style="color: red;">*</span> </td>
					    <td><input name="marryNum" id="maNum" class="easyui-validatebox text"  value="${MarriageRegistrationDataPO.marryNum}" style="border:1px solid #cccccc;" validType="maxLength[200]" required="true" missingMessage="标题不能为空" /></td>
			      </tr>
			      
			      <tr>
					 <td class="datagrid-header">数据来源：<span style="color: red;">*</span></td>
					  <td> 
					     <input name="sources" id="soues" class="easyui-validatebox text"  value="${MarriageRegistrationDataPO.sources}"  style="border:1px solid #cccccc;" validType="maxLength[200]" required="true" missingMessage="标题不能为空" />
				     </td>
			    </tr>
				<tr>
				    <td class="datagrid-header">统计时间：<span style="color: red;">*</span></td>
					
					<td>
					   <input type="date" id="sticnow" name="statisticnow"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'statisticfur\')}'})" value="${MarriageRegistrationDataPO.statisticnow}" />
      	       		
      	       		<span>-</span>
      	       		
      				<input type="date" id="sticfur" name="statisticfur"  readonly style="width:180px;height:27px;border:1px solid #cccccc;"
      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'statisticnow\')}'})" value="${MarriageRegistrationDataPO.statisticfur}" />
					
					</td>
				</tr>  
				
				
				<tr>
			     <td class="datagrid-header">是否有效：<span style="color: red;">*</span></td>
				<td>
					<select class="easyui-validatebox select" name="isvalid" id="isvalid"  style="width:180px;border:1px solid #cccccc;">				 
						 	<c:if test="${MarriageRegistrationDataPO.isvalid=='0' }">
						 	<option id="isvalid" selected value="0">无效</option>
						 	<option id="isvalid" value="1">有效</option>
							</c:if>
							<c:if test="${MarriageRegistrationDataPO.isvalid=='1' }">
						 	<option id="isvalid" selected value="1">有效</option>
						 	<option id="isvalid" value="0">无效</option>
							</c:if>
					</select>
			     </td>
			     </tr>
				  
				  <tr>
						<td>
							&nbsp;
						</td>
						<td>
							  <div id="u6" class="ax_形状" >
						        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:18%;" onclick="sum()">&nbsp 保存</a>
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
