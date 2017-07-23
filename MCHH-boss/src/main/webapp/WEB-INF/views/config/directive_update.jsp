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
	//页面加载时判断特殊疾病
	var modulValue = $("#modul").val();
	if(modulValue==0 || modulValue==1){
		$("#tgh")[0].selectedIndex = -1;
		$("#tgh").attr("disabled", true);
		$("#tgh").css("background-color","#E5E5E5");
	}else{
		$("#tgh").attr("disabled", false);
		$("#tgh").css("background-color","#FFFFFF");
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
	
	var updateUrl = "${ctx}/directive/update";
	$("#submitBtn").click(function(){
		var modular=document.getElementById("modul").value;
		var tgd=document.getElementById("tgh").value;
		var id=document.getElementById("Directiveid").value;
		
		var ajaxUrl="${ctx}/directive/addByTgd"+'?modularType='+modular+'&tgd='+tgd+'&id='+id;
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
				if(modul==2){
					var tgd=document.getElementById("tgh").value;
					if(tgd ==null || tgd ==""){
						alert("请选择特殊疾病");
						return false;
					};
				}
				
				
				var cont=document.getElementById("cont").value;
				if(cont ==null || cont ==""){
					alert("请选择指导意见");
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
});

</script>
		
<div>
		<form id="UpdateFrom" name="UpdateFrom" method="post">
			   <input type="hidden" id="Directiveid" name="id" value="${DirectiveOpinionTemplatePO.id}"/>
			   
			   		<div  style="position:absolute;bottom: 400px" >
					         <p id="u8">标签：</p>
						  <div id="u12" class="ax_下拉列表框">
					        <select id="modul" name="modularType" style="width: 160px;height:30px;border:1px solid #cccccc" class="test">
					        	<c:if test="${DirectiveOpinionTemplatePO.modularType=='0'}">
						        	<option value="0" selected>男性婚前保健基础指导</option>
									<option value="1">女性婚前保健基础指导</option>
									<option value="2">婚前特殊保健指导</option>
						    
								</c:if>
								<c:if test="${DirectiveOpinionTemplatePO.modularType=='1'}">
						        	<option value="0" >男性婚前保健基础指导</option>
									<option value="1" selected>女性婚前保健基础指导</option>
									<option value="2">婚前特殊保健指导</option>
								</c:if>
								<c:if test="${DirectiveOpinionTemplatePO.modularType=='2'}">
						        	<option value="0" >男性婚前保健基础指导</option>
									<option value="1" >女性婚前保健基础指导</option>
									<option value="2" selected>婚前特殊保健指导</option>
								</c:if>
								
							</select>
					      </div>
					          <p id="u10">指导意见：</p>
					      <div id="u13" class="ax_多行文本框">
					        	<textarea id="cont" style="width: 460px;height: 150px;border:1px solid #cccccc" name="content">${DirectiveOpinionTemplatePO.content}</textarea>
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
					       		<p id="u17">特殊疾病：</p>
						  <div id="u19" class="ax_文本框">
					         <select id="tgh" name="tgd" style="width: 160px;height: 30px;border:1px solid #cccccc">
					         		<c:forEach var="findall" items="${findall }">
					         		<c:if test="${DirectiveOpinionTemplatePO.tgd==findall.id}">
				 							<option value="${findall.id }" selected>${findall.name }</option>
				 						
				 					</c:if>
				 				</c:forEach>
				 				
				 				<c:forEach var="findall" items="${findall }">
				 							<option value="${findall.id }">${findall.name }</option>
				 				</c:forEach>
					      	</select>
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

	</div>
