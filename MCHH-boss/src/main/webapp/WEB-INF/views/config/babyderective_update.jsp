<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<link href="${ctx}/static/css/directive_add_style.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript">
$(function(){
	
	var modulValue = $("#modul").val()
	if(modulValue==0 || modulValue==1){
		$("#tgh").attr("disabled", true);
		$("#tgh").css("background-color","#E5E5E5");
	}
	
	//修改时 标签的change事件
	$("#modul").change(function(){
		var modulValue = $("#modul").val();
		if(modulValue==0 || modulValue==1){
			$("#tgh")[0].selectedIndex = -1;
			$("#tgh").attr("disabled", true);
			$("#tgh").css("background-color","#E5E5E5");
		}else{
			$("#tgh").attr("disabled", false);
			$("#tgh").css("background-color","#FFFFFF");
		}
	});
});

</script>
		
<div>
		<form id="UpdateFrom" name="UpdateFrom" method="post">
			   <input type="hidden" id="Directiveid" name="id" value="${DirectiveOpinionTemplatePO.id}"/>
			   
			   		<div  style="position:absolute;bottom: 400px" >
					         <p id="u8">标签：</p>
						  <div id="u12" class="ax_下拉列表框">
					        <select id="modul" name="modularType" style="width: 160px;height:30px;border:1px solid #cccccc">
					        	<c:if test="${DirectiveOpinionTemplatePO.modularType=='5'}">
						        	<option value=""></option>
									<option value="5" selected>儿童保健指导</option>
								</c:if>
								
							</select>
					      </div>
					        <p id="u14">可用标识：</p>
					      <div id="u16" class="ax_下拉列表框">
					        <select id="sighn" name="useSign" style="width: 160px;height:30px;border:1px solid #cccccc">
					        	
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
					       		<p id="u17">儿童年龄：</p>
						  <div id="u19" class="ax_文本框">
					         <select id="tgh" name="tgd" style="width: 160px;height: 30px;border:1px solid #cccccc">
					         		
					         		
				 							<option ></option>
										 	<option value="0" 
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='0'}">
										 			selected
										 		</c:if>
										 	>新生儿</option>
										 	<option value="1"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='1'}">
										 			selected
										 		</c:if>
										 	>1月龄</option>
										 	<option value="2"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='2'}">
										 			selected
										 		</c:if>
										 	>3月龄</option>
										 	<option value="3"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='3'}">
										 			selected
										 		</c:if>
										 	>6月龄</option>
										 	<option value="4"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='4'}">
										 			selected
										 		</c:if>
										 	>8月龄</option>
										 	<option value="5"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='5'}">
										 			selected
										 		</c:if>
										 	>12月龄</option>
										 	<option value="6"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='6'}">
										 			selected
										 		</c:if>
										 	>18月龄</option>
										 	<option value="7"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='7'}">
										 			selected
										 		</c:if>
										 	>24月龄</option>
										 	<option value="8"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='8'}">
										 			selected
										 		</c:if>
										 	>30月龄</option>
										 	<option value="9"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='9'}">
										 			selected
										 		</c:if>
										 	>3岁龄</option>
										 	<option value="10"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='10'}">
										 			selected
										 		</c:if>
										 	>4岁龄</option>
										 	<option value="11"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='11'}">
										 			selected
										 		</c:if>
										 	>5岁龄</option>
										 	<option value="12"
										 		<c:if test="${DirectiveOpinionTemplatePO.tgd=='12'}">
										 			selected
										 		</c:if>
										 	>6岁龄</option>
				 						
				 					
				 			 </select>
					      </div>
					      
					      
					          <p id="u10">指导意见：</p>
					      <div id="u13" class="ax_多行文本框">
					        	<textarea id="cont" style="width: 460px;height: 150px;border:1px solid #cccccc" name="content">${DirectiveOpinionTemplatePO.content}</textarea>
					      </div>
					      <div id="u4" class="ax_形状">
					   			<a href="#" class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #009DD9;border: 0px;color: white;position: absolute;right: 20%;bottom: 10%;" iconCls="icon-cancel"
												onClick="cancle();">取消</a>
					      </div>
					      <div id="u6" class="ax_形状">
					        <a href="javascript:void(0)" class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left: 20%;bottom: 10%;" iconCls="icon-save" id="submitBtn">保存</a>
					      </div>
    			</div>
    	</form>
    	<script type="text/javascript">
    		$(function(){
    			
    			$("#submitBtn").click(function(){
    				var updateUrl = "${ctx}/directive/updateBaby";
					var modular=document.getElementById("modul").value;
					var tgd=document.getElementById("tgh").value;
					var Directiveid=document.getElementById("Directiveid").value;
					var ajaxUrl="${ctx}/directive/addByTgd"+'?modularType='+modular+'&tgd='+tgd+'&id='+Directiveid;
					$.ajax({
						url:ajaxUrl,
						type:"GET",
						success:function(data){
						
						
						var modul=document.getElementById("modul").value;
						if(modul ==null || modul ==""){
							alert("请选择标签");
							return false;
						};
						
						var sighn=document.getElementById("sighn").value;
						if(sighn ==null || sighn ==""){
							alert("请选择可用标识");
							return false;
						};
						
						var tg=document.getElementById("tgh").value;
						if(tg ==null || tg ==""){
							alert("请选择年龄");
							return false;
						};
						var cont=document.getElementById("cont").value;
						if(cont ==null || cont ==""){
							alert("请选择指导意见");
							return false;
						};
						if(data.DirectiveOpinionTemplatePO!=null){
							
							alert("名字已存在，请更换");
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
