<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<div>
			
			<form id="addOrUp" name="addOrUp" method="post">
			<input type="hidden" name="id"  id="preId" value="${premaritalAbnormalOptionPO.id }"/>
 			<div style="left:2px;bottom:400px;position:absolute;">
				        <div id="u8" class="ax_文本段落">
				                         疾病名称：
				      </div>
					<div id="u10">
				        <input id="illkill" class="easyui-validatebox text"  type="text" name="name" value="${premaritalAbnormalOptionPO.name }"/>
				    </div>
				    <div id="u11" class="ax_文本段落">
				       所属分类：
				    </div>
					<c:if test="${premaritalAbnormalOptionPO.type=='0' }">
						    <div id="u13" class="ax_复选框">
						       <p id="u14"><span>指定传染病</span></p>
						       <input id="type0" type="radio" name="type" value="0" checked/>
						    </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u15" class="ax_复选框">
						      	<p id="u16" ><span>严重遗传病</span></p>
						        <input id="type1" class="type" type="radio" name="type" value="1"/>
						      </div>
						      <div id="u17" class="ax_复选框">
						       <p id="u18"><span>精神病</span></p>
						        <input id="type2" class="type" type="radio" name="type" value="2"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u19" class="ax_复选框">
						        <p id="u20"><span>男性 生殖系统疾病</span></p>
						        <input id="type3" class="type" type="radio" name="type" value="3"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u21" class="ax_复选框">
						       <p id="u22"><span>内科疾病</span></p>
						       <input id="type4" class="type" type="radio" name="type" value="5"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u23" class="ax_复选框">
						        <p  id="u24"><span>女性 生殖系统疾病</span></p>
						        <input id="type5" class="type" type="radio" name="type" value="4"/>
						      </div>
				      
				      </c:if>
				      
				      
				      
				      <c:if test="${premaritalAbnormalOptionPO.type=='1' }">
						    <div id="u13" class="ax_复选框">
						       <p id="u14"><span>指定传染病</span></p>
						       <input id="type0" type="radio" name="type" value="0" />
						    </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u15" class="ax_复选框">
						      	<p id="u16" ><span>严重遗传病</span></p>
						        <input id="type1" type="radio" name="type" value="1" checked/>
						      </div>
						      <div id="u17" class="ax_复选框">
						       <p id="u18"><span>精神病</span></p>
						        <input id="type2" class="type" type="radio" name="type" value="2"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u19" class="ax_复选框">
						        <p id="u20"><span>男性 生殖系统疾病</span></p>
						        <input id="type3" class="type" type="radio" name="type" value="3"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u21" class="ax_复选框">
						       <p id="u22"><span>内科疾病</span></p>
						       <input id="type4" class="type" type="radio" name="type" value="5"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u23" class="ax_复选框">
						        <p  id="u24"><span>女性 生殖系统疾病</span></p>
						        <input id="type5" class="type" type="radio" name="type" value="4"/>
						      </div>
				      
				      </c:if> 
				      
				      <c:if test="${premaritalAbnormalOptionPO.type=='2' }">
						    <div id="u13" class="ax_复选框">
						       <p id="u14"><span>指定传染病</span></p>
						       <input id="type0" type="radio" name="type" value="0" />
						    </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u15" class="ax_复选框">
						      	<p id="u16" ><span>严重遗传病</span></p>
						        <input id="type1" type="radio" name="type" value="1" />
						      </div>
						      <div id="u17" class="ax_复选框">
						       <p id="u18"><span>精神病</span></p>
						        <input id="type2" type="radio" name="type" value="2" checked/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u19" class="ax_复选框">
						        <p id="u20"><span>男性 生殖系统疾病</span></p>
						        <input id="type3" class="type" type="radio" name="type" value="3"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u21" class="ax_复选框">
						       <p id="u22"><span>内科疾病</span></p>
						       <input id="type4" class="type" type="radio" name="type" value="5"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u23" class="ax_复选框">
						        <p  id="u24"><span>女性 生殖系统疾病</span></p>
						        <input id="type5" class="type" type="radio" name="type" value="4"/>
						      </div>
				      
				      </c:if> 
				      
				      
				      
				      <c:if test="${premaritalAbnormalOptionPO.type=='3' }">
						    <div id="u13" class="ax_复选框">
						       <p id="u14"><span>指定传染病</span></p>
						       <input id="type0" type="radio" name="type" value="0" />
						    </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u15" class="ax_复选框">
						      	<p id="u16" ><span>严重遗传病</span></p>
						        <input id="type1" type="radio" name="type" value="1" />
						      </div>
						      <div id="u17" class="ax_复选框">
						       <p id="u18"><span>精神病</span></p>
						        <input id="type2" type="radio" name="type" value="2" />
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u19" class="ax_复选框">
						        <p id="u20"><span>男性 生殖系统疾病</span></p>
						        <input id="type3" type="radio" name="type" value="3" checked/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u21" class="ax_复选框">
						       <p id="u22"><span>内科疾病</span></p>
						       <input id="type4" type="radio" name="type" value="5"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u23" class="ax_复选框">
						        <p  id="u24"><span>女性 生殖系统疾病</span></p>
						        <input id="type5"  type="radio" name="type" value="4"/>
						      </div>
				      
				      </c:if> 
				      

				      <c:if test="${premaritalAbnormalOptionPO.type=='4' }">
						    <div id="u13" class="ax_复选框">
						       <p id="u14"><span>指定传染病</span></p>
						       <input id="type0" type="radio" name="type" value="0" />
						    </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u15" class="ax_复选框">
						      	<p id="u16" ><span>严重遗传病</span></p>
						        <input id="type1" type="radio" name="type" value="1" />
						      </div>
						      <div id="u17" class="ax_复选框">
						       <p id="u18"><span>精神病</span></p>
						        <input id="type2" type="radio" name="type" value="2" />
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u19" class="ax_复选框">
						        <p id="u20"><span>男性 生殖系统疾病</span></p>
						        <input id="type3" type="radio" name="type" value="3" />
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u21" class="ax_复选框">
						       <p id="u22"><span>内科疾病</span></p>
						       <input id="type4" type="radio" name="type" value="5"/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u23" class="ax_复选框">
						        <p  id="u24"><span>女性 生殖系统疾病</span></p>
						        <input id="type5"  type="radio" name="type" value="4" checked/>
						      </div>
				      
				      </c:if>
				      
				      
				      
				      <c:if test="${premaritalAbnormalOptionPO.type=='5' }">
						    <div id="u13" class="ax_复选框">
						       <p id="u14"><span>指定传染病</span></p>
						       <input id="type0" type="radio" name="type" value="0" />
						    </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u15" class="ax_复选框">
						      	<p id="u16" ><span>严重遗传病</span></p>
						        <input id="type1" type="radio" name="type" value="1" />
						      </div>
						      <div id="u17" class="ax_复选框">
						       <p id="u18"><span>精神病</span></p>
						        <input id="type2" type="radio" name="type" value="2" />
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u19" class="ax_复选框">
						        <p id="u20"><span>男性 生殖系统疾病</span></p>
						        <input id="type3" type="radio" name="type" value="3" />
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u21" class="ax_复选框">
						       <p id="u22"><span>内科疾病</span></p>
						       <input id="type4" type="radio" name="type" value="5" checked/>
						      </div>
						
						      <!-- Unnamed (复选框) -->
						      <div id="u23" class="ax_复选框">
						        <p  id="u24"><span>女性 生殖系统疾病</span></p>
						        <input id="type5"  type="radio" name="type" value="4" />
						      </div>
				      
				      </c:if>
				       
				      <div id="u6" class="ax_形状">
				        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left: 5%;bottom: 10%;" id="editSave">保存</a>
					 </div>
				     
				     <div id="u4" class="ax_形状">
				     	<a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #009DD9;border: 0px;color: white;position: absolute;right: 20%;bottom: 10%;" iconCls="icon-cancel"
												onClick="closeDialog_();">取消</a>
				     </div>
				
				</table>
			</form>
			
			
<script type="text/javascript">
$(function(){
//修改的保存数据
$("#editSave").click(function(){
	var updateUrl = "${ctx}/com/config/preoption/update";
	var ill=document.getElementById("illkill").value;
	var id=document.getElementById("preId").value;
	var type=$('input:radio[name="type"]:checked').val();
	var typeurl="${ctx}/com/config/preoption/findByname"+'?name='+ill+'&id='+id+'&type='+type;
	$.ajax({
		
		url:typeurl,
		type:"GET",
		success:function(data){
			
			
			if(ill ==null || ill ==""){
				alert("请输入疾病名称");
				return false;
			};
			
			var val_payPlat = $('input[name="type"]:checked ').val();
			
			if(val_payPlat ==null){
				alert("请选择所属分类");
				return false;
			};
			if(data.premaritalAbnormalOptionVO!=null){
				
				alert("名字已存在，请更换");
				return false;
				
			}
			 $("#addOrUp").attr("action",updateUrl);
				
			 $("#addOrUp").submit();
			
		}
	})
})

})


</script> 
	</div>