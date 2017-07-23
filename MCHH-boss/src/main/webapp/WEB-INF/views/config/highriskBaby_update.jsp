<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<div>
	      <form id="addUp" name="addUp" method="post">
	     	
			   <input type="hidden" id="id" name="id" value="${find.id}"/>
			   
			   <input type="hidden" id="type" name="type" value="${find.type}"/>
			   
			      <div style="left:80px;top:10px;position:absolute;">
			 <table class="datagrid-body" width="100%">
				    <tr>
						<td class="datagrid-header">疾病名称：<span style="color: red;">*</span>	</td>
						<td>
					   	<input name="name" id="nme" value="${find.name }" class="easyui-validatebox text"  style="border:1px solid #cccccc"  validType="maxLength[200]" required="true" missingMessage="标题不能为空" />			
				    	</td>
					</tr>
				    <tr>
						<td class="datagrid-header">高危评分：<span style="color: red;">*</span>	</td>
						<td>
							<select class="easyui-validatebox select"  name="score" id="core" style="width:180px;border:1px solid #cccccc;">
								<c:if test="${find.score=='5' }">
									<option></option>
									<option  value="5" selected>5</option>
									<option  value="10">10</option>
									<option  value="20">20</option>
								</c:if>
								<c:if test="${find.score=='10' }">
									<option></option>
									<option  value="5" >5</option>
									<option  value="10" selected>10</option>
									<option  value="20">20</option>
								</c:if>
								<c:if test="${find.score=='20' }">
									<option></option>
									<option  value="5" >5</option>
									<option  value="10">10</option>
									<option  value="20" selected>20</option>
								</c:if>
							</select>
						</td>
					</tr>
			   		<tr>
						<td class="datagrid-header">疾病描述：<span style="color: red;">*</span>	</td>
						<td>
					   	<textarea name="remark" id="mark" value="${find.remark }" class="easyui-validatebox" cols="55" rows="7" validType="maxLengths[500]" style="border:1px solid #cccccc">${find.remark }</textarea>			
				    	</td>
					</tr>
				
			      <tr>
						<td class="datagrid-header">所属分类：<span style="color: red;">*</span>	</td>
					<td>
						 <select class="easyui-validatebox select"  name="status" id="sta" style="width:180px;border:1px solid #cccccc">
							<c:if test="${find.status=='0' }">
								<option  ></option>
								<option  value="0" selected>妊娠合并</option>
								<option  value="1">固定因素</option>
								<option  value="2">本次异常</option>
								<option  value="3">社会环境因素</option>
							</c:if>
							<c:if test="${find.status=='1' }">
								<option  ></option>
								<option  value="0" >妊娠合并</option>
								<option  value="1" selected>固定因素</option>
								<option  value="2">本次异常</option>
								<option  value="3">社会环境因素</option>
							</c:if>
							<c:if test="${find.status=='2' }">
								<option  ></option>
								<option  value="0" >妊娠合并</option>
								<option  value="1" >固定因素</option>
								<option  value="2" selected>本次异常</option>
								<option  value="3">社会环境因素</option>
							</c:if>
							<c:if test="${find.status=='3' }">
								<option  ></option>
								<option  value="0" >妊娠合并</option>
								<option  value="1" >固定因素</option>
								<option  value="2">本次异常</option>
								<option  value="3" selected>社会环境因素</option>
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
				        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:18%;bottom: 1%;" id="same" onclick="same()">&nbsp 保存</a>
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
	$(function(){
		var update = "${ctx}/com/config/highrisk/updatebaby";
		//修改的保存数据
		$("#same").click(function(){
			var ill=document.getElementById("nme").value;
			var id=document.getElementById("id").value;
			var typeurl="${ctx}/com/config/highrisk/findByname"+'?name='+ill+'&id='+id;
			$.ajax({
				
				url:typeurl,
				type:"GET",
				success:function(data){
					
					if(data.HighRiskPregnancyScorePO!=null){
						
						alert("名字已存在，请更换");
						return false;
						
					}
					var nme=document.getElementById("nme").value;
					if(nme ==null || nme ==""){
						alert("请输入疾病名称");
						return false;
					};
					
					var core=document.getElementById("core").value;
					if(core ==null || core ==""){
						alert("请选择高危评分");
						return false;
					};
					var sta=document.getElementById("sta").value;
					if(sta ==null || sta ==""){
						alert("请选择所属分类");
						return false;
					};
					  $("#addUp").attr("action",update);
		
					  $("#addUp").submit();
					
				}
			})
		})
		
	})
	
	</script>
</div>