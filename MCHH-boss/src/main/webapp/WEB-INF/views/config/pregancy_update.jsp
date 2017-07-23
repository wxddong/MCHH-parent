<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<link href="${ctx}/static/css/directive_add_style.css" type="text/css" rel="stylesheet"/>
<div>

		<form id="UpdateFrom" name="UpdateFrom" method="post">
			   <input type="hidden" id="Directiveid" name="id" value="${DirectiveOpinionTemplatePO.id}"/>

		             	   <div style="bottom:385;position:absolute;">
			   
						  <div id="u8" class="ax_文本段落">
					         <p id="u9"><span>标签：</span></p>
						  </div>
						  <div id="u12" class="ax_下拉列表框">
					        <select id="modul" name="modularType" style="width: 150px;height: 30px;border:1px solid #cccccc">
						   		<option value="4">高危妊娠保健</option>
							</select>
					      </div>
					      <div id="u10" class="ax_文本段落">
					          <p id="u11"><span>指导意见：</span></p>
					      </div>
					      <div id="u13" class="ax_多行文本框">
					        	<textarea id="content"  style="width: 460px;height: 150px;border:1px solid #cccccc" name="content">${DirectiveOpinionTemplatePO.content}</textarea>
					      </div>
					      <div id="u14" class="ax_文本段落">
					        <p id="u15"><span>可用标识：</span></p>
					   	  </div>
					      <div id="u16" class="ax_下拉列表框">
					        <select id="sign" name="useSign" style="width: 150px;height: 30px;border:1px solid #cccccc">
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
					       		<p id="u18"><span>高危因素</span><span>：</span></p>
					      </div>
						  <div id="u19" class="ax_文本框">
					         <select id="tgh" name="tgd" style="width: 150px;height: 30px;border:1px solid #cccccc">
					         	
					         	<c:forEach var="highrisk" items="${HighRiskAll }">
					         		<c:if test="${DirectiveOpinionTemplatePO.tgd==highrisk.id}">
				 							<option value="${highrisk.id }" selected>${highrisk.name }</option>
				 						<c:forEach var="high" items="${HighRiskAll }">
				 							<option value="${high.id }">${high.name }</option>
				 						</c:forEach>
				 					</c:if>
				 				</c:forEach>
					        </select>
					      </div>

					         <div id="u6" class="ax_形状" >
						        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:18%;bottom: 1%;" id="sum">&nbsp 保存</a>
							 </div>
						     
						     <div id="u4" class="ax_形状">
						     	<a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #009DD9;border: 0px;color: white;position: absolute;right:15%;bottom: 1%;" iconCls="icon-cancel"
														onClick="closeDialog_();">&nbsp 取消</a>
						     </div>
					 </div>
    	     </form>
    	     <script type="text/javascript">
    		$(function(){
    			$("#sum").click(function(){
					var modular=document.getElementById("modul").value;
					var tgd=document.getElementById("tgh").value;
					var Directiveid=document.getElementById("Directiveid").value;
					var ajaxUrl="${ctx}/directive/addByTgd"+'?modularType='+modular+'&tgd='+tgd+'&id='+Directiveid;
					var updateUrl = "${ctx}/directive/updatepre";
					$.ajax({
						url:ajaxUrl,
						type:"GET",
						success:function(data){
						
						
						var modul=document.getElementById("modul").value;
						if(modul ==null || modul ==""){
							alert("请选择标签");
							return false;
						};
						
						var sign=document.getElementById("sign").value;
						if(sign ==null || sign ==""){
							alert("请选择可用标识");
							return false;
						};
						
						
						var content=document.getElementById("content").value;
						if(content ==null || content ==""){
							alert("请选择指导意见");
							return false;
						};
						
						
						var tgh=document.getElementById("tgh").value;
						if(tgh ==null || tgh ==""){
							alert("请选择高危因素");
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
