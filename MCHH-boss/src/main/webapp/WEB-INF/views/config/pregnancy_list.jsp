<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>指导意见管理-高危</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx }/static/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/data/styles.css" type="text/css" rel="stylesheet"/>
	<link href="${ctx}/static/css/directive_add_style.css" type="text/css" rel="stylesheet"/>
    <style type="text/css">
	.divcss5{ border:1px; width:100%; height:20px} 
	</style>
    <script type="text/javascript">
		    var fid = '-1';
			var addUrl = "${ctx}/directive/addPregancy";
			var listUrl = "${ctx}/directive/listPregancy";
			var delUrl = "${ctx}/directive/del";
		    var updateViewUrl = "${ctx}/directive/updatePregancy";
			    $(function() {

			    	
			    	document.onkeydown = function () {
			            if (window.event && window.event.keyCode == 13) {
			                window.event.returnValue = false;
			            }
			        }

			    	
		    	//下拉框默认为空
		    	$("#modularType")[0].selectedIndex = -1;
		    	$("#useSign")[0].selectedIndex = -1;
		    	$("#tgd")[0].selectedIndex = -1;
		    	$("#u12_input")[0].selectedIndex = -1;
		    	$("#u16_input")[0].selectedIndex = -1;
		    	$("#u19_input")[0].selectedIndex = -1;
			    	

				$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
					columns:[[
		             {field:'ck',checkbox:true,width : '30',resizable:'false',align:'center'},
		             {title:'序号',field:'id',width : '60',resizable:'f',align:'center',hidden:true},
		             {title:'标签',field:'modularType', width : '300',resizable:'true',align:'center',
			             formatter:function(v){ 
	                         if(v==4){
	                             return "高危妊娠保健"
	                         } 
			             } 
		             },
		             {title:'高危因素',field:'tgd',width : '200', resizable:'true',align:'center'},
		             {title:'指导内容',field:'content',width : '400',resizable:'true',align:'center'},
		             {title:'可用标识',field:'useSign',width : '180',resizable:'true',align:'center',
			             formatter:function(v){ 
	                        	if(v==0){
		                             return "不可用"
		                         } 
		                         if(v==1){
		                             return "可用"
		                         }
			             }
						},
		             ]]
				});
				$("#save").click(function(){
					var modular=$("#u12_input").val();
					var tgd=document.getElementById("u19_input").value;
					var ajaxUrl="${ctx}/directive/addByTgd"+'?modularType='+modular+'&tgd='+tgd;
					$.ajax({
						url:ajaxUrl,
						type:"GET",
						success:function(data){
						
						
						var u12_input=document.getElementById("u12_input").value;
						if(u12_input ==null || u12_input ==""){
							alert("请选择标签");
							return false;
						};
						
						var u16_input=document.getElementById("u16_input").value;
						if(u16_input ==null || u16_input ==""){
							alert("请选择可用标识");
							return false;
						};
						
						
						var u13_input=document.getElementById("u13_input").value;
						if(u13_input ==null || u13_input ==""){
							alert("请选择指导意见");
							return false;
						};
						
						
						var u19_input=document.getElementById("u19_input").value;
						if(u19_input ==null || u19_input ==""){
							alert("请选择高危因素");
							return false;
						};
						
						if(data.DirectiveOpinionTemplatePO!=null){
							
							alert("指导意见已存在，请更换");
							return false;
							
						}
						
						$("#addOrUpdate").attr("action",addUrl);
						$("#addOrUpdate").submit();
						
					}
					})
				})
				
			});
  
			    
			    
			  //添加
				function add(){
					
					/* showDialog_URl('添加活动','addOrUpdateAtv',addUrl,'zhongjianddle',true); */
					showDialog_('新建高危妊娠保健指导意见','addOrUpdateWin','moremiddle5');
				}
				//修改
				function edit(){
					
					var node = getSelected('edit');
					if(node){
						showDialog_URl('编辑高危妊娠保健指导意见','addOrUpdateAtv',updateViewUrl+'?id='+node.id,'moremiddle5');	
					}
					
			  }
				
      </script>
  </head>
  <body class="panel-noscroll">
	<table id="dg"></table>
	<div id="tb" style="padding:5px;height:auto">
		<input type="button"  style="height: 35px; width: 120px; background-color: #999999;border: 0px;cursor:pointer;color: white;"
											value="婚前保健指导" onclick="window.location.href='${ctx}/directive/list'"/> 
		&nbsp;
		<input type="button" style="height: 35px; width: 120px; background-color: #999999;border: 0px;cursor:pointer;color: white;"
											value="孕产期保健指导" onclick="window.location.href='${ctx}/directive/listMaternal'"/> 
		&nbsp;
		<input type="button" disabled="disabled" style="height: 35px; width: 120px; background-color: #ee5f45;border: 0px;cursor:pointer;color: white;"
											value="高危妊娠保健指导" onclick="window.location.href='${ctx}/directive/listPregancy'"/> 
		&nbsp;
		<input type="button" style="height: 35px; width: 120px; background-color: #999999;border: 0px;cursor:pointer;color: white;"
											value="儿童保健指导" onclick="window.location.href='${ctx}/directive/listBabyView'"/> 
		&nbsp;
		<input type="button" style="height: 35px; width: 120px; background-color: #999999;border: 0px;cursor:pointer;color: white;"
											value="高危儿童保健指导" onclick="window.location.href='${ctx}/directive/listBabyHightRiskView'"/> 
		
		<div class="divcss5"></div>
		<div style="position:relative; border: 1px solid #cccccc; top:-20px;height: 70px;width: 1120px;">
			 <br>
			<form id="queryForm" method="post">
			<div style="top:15px;left:40px;position:absolute;">
		      标签:
			<select class="easyui-validatebox select" name="modularType" id="modularType"  style="width:180px;border:1px solid #cccccc;">
					<option value="">不限</option>			
					<option value="4">高危妊娠保健</option>
								
			 </select>
			 可用标识:
			 <select class="easyui-validatebox select" name="useSign" id="useSign"  style="width:180px;border:1px solid #cccccc;">
				 		<option id="name" name="name" value="">不限</option>
					 	<option id="name1" name="name" value="0">不可用</option>
					 	<option id="name2" name="name" value="1">可用</option>
				 			 				 	
			 </select>
			高危因素:
			 <select class="easyui-validatebox select" name="tgd" id="tgd" style="width:180px;border:1px solid #cccccc;">
				 	<option value="">不限</option>
				 	<c:forEach var="highrisk" items="${HighRiskAll }">
				 		<option value="${highrisk.id }">${highrisk.name }</option>
				 	</c:forEach>		
			 </select>
			 </div>
			<div style="top:15px;height: 50px;left:1040px;width: 100px;position:absolute;">
			 	<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn" onclick="select()"style="background-color: #56BB4D;"><i class="fa fa-search"></i>查询</a>		 		 
			</div>		 		 
		</form>
		</div>
		 <div data-options="region:'south',border:false">      

				<div data-options="region:'south',border:false"> 
					<b:privilege url="sys/role/add">
					  <a href="javascript:void(0)" class="easyui-linkbutton new"  onClick="add();"style="top:120px;left:910px;position:absolute;">添加</a>
				    </b:privilege>	    
				    <b:privilege url="sys/role/update">
					<a href="javascript:void(0)" class="easyui-linkbutton reset"  onClick="edit();"style="top:120px;left:980px;position:absolute;">修改</a>
					</b:privilege>
					<b:privilege url="sys/role/del">
					  <a href="javascript:void(0)"  class="easyui-linkbutton save"  onClick="del();"style="top:120px;left:1050px;position:absolute;">删除</a>
				    </b:privilege>	
			   </div>
		</div>
		       <br>  <br>  
	</div>
      <div id="addOrUpdateAtv"  class="easyui-dialog"  closed="true"></div>
      <div id="addOrUpdateWin" class="easyui-dialog" title="街道" closed="true">
			<form id="addOrUpdate" name="addOrUpdate" method="post">
			<input type="hidden" id="id" name="id"/>

			   <div style="bottom:385;position:absolute;">
			   
						  <div id="u8" class="ax_文本段落">
					         <p id="u9"><span>标签：</span></p>
						  </div>
						  <div id="u12" class="ax_下拉列表框">
					        <select id="u12_input" vlaue="" name="modularType" style="border:1px solid #cccccc">
								
								<option value="4">高危妊娠保健</option>
								
					        </select>
					      </div>
					      <div id="u10" class="ax_文本段落">
					          <p id="u11"><span>指导意见：</span></p>
					      </div>
					      <div id="u13" class="ax_多行文本框">
					        	<textarea id="u13_input" name="content" style="border:1px solid #cccccc"></textarea>
					      </div>					      
						  <div id="u14" class="ax_文本段落">
					        <p id="u15"><span>可用标识：</span></p>
					   	  </div>
					      <div id="u16" class="ax_下拉列表框">
					        <select id="u16_input" name="useSign" style="border:1px solid #cccccc"> 
							 	<option id="name1" name="name" value="0">不可用</option>
							 	<option id="name2" name="name" value="1">可用</option>
					        </select>
					      </div>
						  <div id="u17" class="ax_文本段落">
					       		<p id="u18"><span>高危因素：</span></p>
					      </div>
						  <div id="u19" class="ax_文本框">
					        <select id="u19_input" name="tgd" style="border:1px solid #cccccc">
					        	<c:forEach var="highrisk" items="${HighRiskAll }">
				 					<option value="${highrisk.id }">${highrisk.name }</option>
				 				</c:forEach>
					      	</select>
					      </div>
					      
					       <div id="u6" class="ax_形状" >
						        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:18%;bottom: 1%;" id="save">&nbsp 保存</a>
							 </div>
						     
						     <div id="u4" class="ax_形状">
						     	<a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #009DD9;border: 0px;color: white;position: absolute;right:15%;bottom: 1%;" iconCls="icon-cancel"
														onClick="closeDialog_();">&nbsp 取消</a>
						     </div>
				</div>
			</form> 
	</div>
  </body>
</html>
