<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<link href="${ctx}/static/css/directive_add_style.css" type="text/css" rel="stylesheet"/>
<div>
		<form id="UpdateFrom" name="UpdateFrom" method="post">
			   <input type="hidden" id="Directiveid" name="id" value="${DirectiveOpinionTemplatePO.id}"/>
			    
					<div  style="position:absolute;bottom: 390px" >
						  <div id="u8" class="ax_文本段落">
					         <p id="u9"><span>标签：</span></p>
						  </div>
						  <div id="u12" class="ax_下拉列表框">
					        <select id="type" name="modularType" style="width: 150px;height: 30px;border:1px solid #cccccc">
									<option value="3">孕产保健</option>
					        </select>
					      </div>
					      <div id="u10" class="ax_文本段落">
					          <p id="u11"><span>指导意见：</span></p>
					      </div>
					      <div id="u13" class="ax_多行文本框" >
					        	<textarea id="tent"  style="width: 460px;height: 150px;border:1px solid #cccccc" name="content">${DirectiveOpinionTemplatePO.content}</textarea>
					      </div>
					      <div id="u14" class="ax_文本段落">
					        <p id="u15"><span>可用标识：</span></p>
					   	  </div>
					      <div id="u16" class="ax_下拉列表框">
					        <select id="use" name="useSign" style="width: 150px;height: 30px;border:1px solid #cccccc" class="test">
					        	<c:if test="${DirectiveOpinionTemplatePO.useSign=='0'}">
								 	<option id="name1" name="name" value="0" selected>不可用</option>
								 	<option id="name2" name="name" value="1">可用</option>
					        	</c:if>
					        	<c:if test="${DirectiveOpinionTemplatePO.useSign=='1'}">
								 	<option id="name1" name="name" value="0" >不可用</option>
								 	<option id="name2" name="name" value="1" selected>可用</option>
					        	</c:if>
					        </select>
					      </div>
						  <div id="u17" class="ax_文本段落">
					       		<p id="u18"><span>孕周</span><span>：</span></p>
					      </div>
						  <div id="u19" class="ax_文本框">
					         <select id="td" name="tgd" style="width: 150px;height: 30px;border:1px solid #cccccc" class="test">
					         	<c:if test="${DirectiveOpinionTemplatePO.tgd=='0'}">
								 	<option id="" name="isvalid" value="0" selected>妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1">妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2">妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3">妊娠24-27+6周</option>
								 	<option id="" name="isvalid" value="4">妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5">妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6">妊娠37-41+6周</option>	
								 	<option id="" name="isvalid" value="7">产后访视</option>
								 	<option id="" name="isvalid" value="8">产后42天健康检查</option>		
					      		</c:if>
					      		<c:if test="${DirectiveOpinionTemplatePO.tgd=='1'}">
								 	<option id="" name="isvalid" value="0">妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1" selected>妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2">妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3">妊娠24-27+6周</option>	
								 	<option id="" name="isvalid" value="4">妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5">妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6">妊娠37-41+6周</option>	
								 	<option id="" name="isvalid" value="7">产后访视</option>
								 	<option id="" name="isvalid" value="8">产后42天健康检查</option>	
					      		</c:if>
					      		<c:if test="${DirectiveOpinionTemplatePO.tgd=='2'}">
								 	<option id="" name="isvalid" value="0">妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1" >妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2" selected>妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3">妊娠24-27+6周</option>	
								 	<option id="" name="isvalid" value="4">妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5">妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6">妊娠37-41+6周</option>	
								 	<option id="" name="isvalid" value="7">产后访视</option>
								 	<option id="" name="isvalid" value="8">产后42天健康检查</option>	
					      		</c:if>
					      		<c:if test="${DirectiveOpinionTemplatePO.tgd=='3'}">
								 	<option id="" name="isvalid" value="0">妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1" >妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2">妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3" selected>妊娠24-27+6周</option>
								 	<option id="" name="isvalid" value="4">妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5">妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6">妊娠37-41+6周</option>
								 	<option id="" name="isvalid" value="7">产后访视</option>
								 	<option id="" name="isvalid" value="8">产后42天健康检查</option>			
					      		</c:if>	
					      		
					      		<c:if test="${DirectiveOpinionTemplatePO.tgd=='4'}">
								 	<option id="" name="isvalid" value="0">妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1" >妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2">妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3">妊娠24-27+6周</option>
								 	<option id="" name="isvalid" value="4" selected>妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5">妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6">妊娠37-41+6周</option>	
								 	<option id="" name="isvalid" value="7">产后访视</option>
								 	<option id="" name="isvalid" value="8">产后42天健康检查</option>		
					      		</c:if>	
					      		
					      		<c:if test="${DirectiveOpinionTemplatePO.tgd=='5'}">
								 	<option id="" name="isvalid" value="0">妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1" >妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2">妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3">妊娠24-27+6周</option>
								 	<option id="" name="isvalid" value="4">妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5" selected>妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6">妊娠37-41+6周</option>
								 	<option id="" name="isvalid" value="7">产后访视</option>
								 	<option id="" name="isvalid" value="8">产后42天健康检查</option>			
					      		</c:if>	
					      		
					      		<c:if test="${DirectiveOpinionTemplatePO.tgd=='6'}">
								 	<option id="" name="isvalid" value="0">妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1" >妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2">妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3">妊娠24-27+6周</option>
								 	<option id="" name="isvalid" value="4">妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5">妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6" selected>妊娠37-41+6周</option>
								 	<option id="" name="isvalid" value="7">产后访视</option>
								 	<option id="" name="isvalid" value="8">产后42天健康检查</option>			
					      		</c:if>
					      		<c:if test="${DirectiveOpinionTemplatePO.tgd=='7'}">
								 	<option id="" name="isvalid" value="0">妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1" >妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2">妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3">妊娠24-27+6周</option>
								 	<option id="" name="isvalid" value="4">妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5">妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6">妊娠37-41+6周</option>
								 	<option id="" name="isvalid" value="7" selected>产后访视</option>
								 	<option id="" name="isvalid" value="8">产后42天健康检查</option>			
					      		</c:if>
					      		<c:if test="${DirectiveOpinionTemplatePO.tgd=='8'}">
								 	<option id="" name="isvalid" value="0">妊娠06-13+6周</option>
								 	<option id="" name="isvalid" value="1" >妊娠14-19+6周</option>
								 	<option id="" name="isvalid" value="2">妊娠20-23+6周</option>	
								 	<option id="" name="isvalid" value="3">妊娠24-27+6周</option>
								 	<option id="" name="isvalid" value="4">妊娠28-31+6周</option>	
								 	<option id="" name="isvalid" value="5">妊娠32-36+6周</option>	
								 	<option id="" name="isvalid" value="6">妊娠37-41+6周</option>
								 	<option id="" name="isvalid" value="7" >产后访视</option>
								 	<option id="" name="isvalid" value="8" selected>产后42天健康检查</option>			
					      		</c:if>					     
					      	</select>
					      </div>

					         <div id="u6" class="ax_形状">
					        <a href="javascript:void(0)" class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left: 20%;bottom: 10%;" iconCls="icon-save" id="sum">保存</a>
					      </div>
						   <div id="u4" class="ax_形状">
					   			<a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #009DD9;border: 0px;color: white;position: absolute;right: 20%;bottom: 10%;" iconCls="icon-cancel"
												onClick="closeDialog_();">取消</a>
					      </div>
    
    		</div>
    	</form>
    	<script type="text/javascript">
    		$(function(){
    			$("#sum").click(function(){
					var modular=document.getElementById("type").value;
					var tgd=document.getElementById("td").value;
					var Directiveid=document.getElementById("Directiveid").value;
					var ajaxUrl="${ctx}/directive/addByTgd"+'?modularType='+modular+'&tgd='+tgd+'&id='+Directiveid;
					$.ajax({
						url:ajaxUrl,
						type:"GET",
						success:function(data){
						
						
						var type=document.getElementById("type").value;
						if(type ==null || type ==""){
							alert("请选择标签");
							return false;
						};
						
						var use=document.getElementById("use").value;
						if(use ==null || use ==""){
							alert("请选择可用标识");
							return false;
						};
						
						
						var tent=document.getElementById("tent").value;
						if(tent ==null || tent ==""){
							alert("请选择指导意见");
							return false;
						};
						
						
						var td=document.getElementById("td").value;
						if(td ==null || td ==""){
							alert("请选择孕周");
							return false;
						};
						
						if(data.DirectiveOpinionTemplatePO!=null){
							
							alert("指导意见已存在，请更换");
							return false;
							
						}
						
						$("#UpdateFrom").attr("action",updateUrl);
						$("#UpdateFrom").submit();
						
					}
					})
				})
    		})
    	</script>
	</div>
