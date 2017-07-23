<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>短信管理-高危检查短信</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<link href="${ctx }/static/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/data/styles.css" type="text/css" rel="stylesheet"/>
	<link href="${ctx}/static/css/short_manage.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript">
	    var fid = '-1';
    	
    	var listUrl = "${ctx}/shortmessage/listHight";
		var delUrl = "${ctx}/shortmessage/del";
	   	var updateUrl = "${ctx}/shortmessage/updateViewHight";
	   	//var update = "${ctx}/com/config/highrisk/update";
		    $(function() {
		    	
		    	document.onkeydown = function () {
		            if (window.event && window.event.keyCode == 13) {
		                window.event.returnValue = false;
		            }
		        }
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'选 中',checkbox:true,width : '95',resizable:'false',align:'center'},
                 {title:'序号',field:'id',width : '100',resizable:'f',align:'center',hidden:true},
                 {title:'发送人群',field:'sendCrowd', width : '300',resizable:'true',align:'center'},
                 {title:'发送时间',field:'sendTime',width : '200', resizable:'true',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "提前三天"
                         } 
                        
                          
                     }
                 
                 },
                 
                 
                 {title:'短信模版',field:'content', width : '400', resizable:'true',align:'center'},
                 {title:'可用标识',field:'useSign',width : '211',resizable:'true',align:'center',
                	
                	 formatter:function(v){ 
                         if(v==0){
                             return "正常"
                         } 
                         if(v==1){
                             return "停用"
                         }
                          
                     }
                 
                 
                 }
                 
                ]]
			});
			
		});

		//修改
		function edit(node){
			if(!node){
				node = getSelected('edit');
			}
			showDialog_URl('编辑高危检查短信模版','addOrUpdateAtv',updateUrl+'?id='+node.id,'moremiddle3');
		}
		
		//添加
		function add(){
			
			showDialog_('新建高危检查短信模版','addOrUpdateWin','moremiddle3');
		}
		
		function save(){
			
			
			
			var u12_input=document.getElementById("u12_input").value;
			if(u12_input ==null || u12_input ==""){
				alert("请选择发送入群");
				return false;
			};
			
			var u16_input=document.getElementById("u16_input").value;
			if(u16_input ==null || u16_input ==""){
				alert("请选择可用标识");
				return false;
			};
			
			
			var u19_input=document.getElementById("u19_input").value;
			if(u19_input ==null || u19_input ==""){
				alert("请选择发送时间");
				return false;
			};
			
			
			var u13_input=document.getElementById("u13_input").value;
			if(u13_input ==null || u13_input ==""){
				alert("请输入短信内容");
				return false;
			};
			
			
			
		var addUrl = "${ctx}/shortmessage/addHight";
		$("#query").attr("action",addUrl);	
		$("#query").submit();
		}
		
		function edtt(){
			
			
			alert("123");
			 var send=document.getElementById("send").value;
				if(send ==null || send ==""){
					alert("请选择发送人群");
					return false;
				};
				
				var Time=document.getElementById("Time").value;
				if(Time ==null || Time ==""){
					alert("请选择发送时间");
					return false;
				};
				
				
				var tent=document.getElementById("tent").value;
				if(tent ==null || tent ==""){
					alert("请输入短信内容");
					return false;
				};
				
				
				var use=document.getElementById("use").value;
				if(use ==null || use ==""){
					alert("请选择可用标识");
					return false;
				};
				
				
			var update = "${ctx}/shortmessage/updateHight";
			$("#queryform").attr("action",update);	
			$("#queryform").submit();
		}

		function cancel(){
			$("#addOrUpdateWin").window("close");
		}
		
		function canl(){
			$("#addOrUpdateAtv").window("close");
		}
		
		
		
		$("#short").click(function(){
			$("#short").css("backgroud-color","#ee5f45");
			
		})
		$("#hight").click(function(){
			$("#hight").css("backgroud-color","#ee5f45");
			
		})
		
		
		 
		 
		
	</script>
	<style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}	
 	</style>
  </head>
 	<body class="panel-noscroll">
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
			<input type="button"  style="height: 35px; width: 120px; background-color: #999999;border: 0px;cursor:pointer;color: white;"
												value="预约检查短信模版" onclick="window.location.href='${ctx}/shortmessage/list'"/> 
			&nbsp;
			<input type="button"  disabled="disabled" style="height: 35px; width: 120px; background-color:#ee5f45 ;border: 0px;cursor:pointer;color: white;"
											value="高危检查短信模版" onclick="window.location.href='${ctx}/shortmessage/listHight'"/> 
		
		
			<br>
			<br>
		
		<div style="position:relative; border: 1px solid #cccccc; top:-18px;height: 70px;width: 1120px;">
			 <br>
			 <form id="queryForm" method="post">
			 <div style="top:15px;left:40px;position:absolute;">
			发送人群：
			<select class="easyui-validatebox select" name="sendCrowd" id="sendCrowd"  style="width:180px;border:1px solid #cccccc;">
				 <c:forEach var="adress" items="${findAll }" varStatus="status">
				 	<option id="sendCrowd" name="sendCrowd" value=""></option>
				 	<option id="sendCrowd" name="sendCrowd" value="${adress.sendCrowd}">${adress.sendCrowd}</option>
				 </c:forEach>
			 </select>
			 可用标识：
			 <select class="easyui-validatebox select" name="useSign" id="useSign"  value="list.isvalid" style="width:180px;border:1px solid #cccccc;">
				 	<option id="" name="useSign" value=""></option>
				 	<option id="" name="useSign" value="0">正常</option>
				 	<option id="" name="useSign" value="1">停用</option>				 	
			 </select>
			 </div>
			 <div style="top:15px;height: 50px;left:1040px;width: 100px;position:absolute;">
				<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn" onclick="select()"style="background-color: #56BB4D;"><i class="fa fa-search"></i>查询</a>
			 </div>
			</form>
		</div>
		
    	<div data-options="region:'south',border:false"> 
			<b:privilege url="sys/role/add">
			  <a href="javascript:void(0)" class="easyui-linkbutton new"  onClick="add();"style="top:120px;left:910px;position:absolute;">添加</a>
		    </b:privilege>	    
		    <b:privilege url="sys/role/update">
			  <a href="javascript:void(0)" class="easyui-linkbutton reset"  onClick="edit();"style="top:120px;left:980px;position:absolute;">修改</a>
			</b:privilege>
			<b:privilege url="sys/role/del">
			  <a href="javascript:void(0)"  class="easyui-linkbutton save" onClick="del();"style="top:120px;left:1050px;position:absolute;">删除</a>
		    </b:privilege>	
	   </div>
	 <br>  <br>  
	</div>
		<div id="addOrUpdateAtv" class="easyui-dialog"  closed="true"></div>
	   <div id="addOrUpdateWin" class="easyui-dialog" title="预约检查" closed="true">

			<form id="query" method="post">
			
				<div  style="right:710px;bottom:420px;position:absolute;">
						<input type="hidden" name="messType" value="1"/>

					  		<div id="u8" class="ax_文本段落">
					          <p id="u9"><span>发送人群：</span></p>
					  		</div>
					
					      <div id="u12" class="ax_下拉列表框">
					        <select id="u12_input" name="sendCrowd" style="border:1px solid #cccccc;">
					          <option ></option>
					          <option value="孕12周以前">孕12周以前</option>
					          <option value="孕13-16周">孕13-16周</option>
					          <option value="孕17-20周">孕17-20周</option>
					          <option value="孕21-24周">孕21-24周</option>
					          <option value="孕25-28周">孕25-28周</option>
					          <option value="孕29-30周">孕29-30周</option>
					          <option value="孕31-32周">孕31-32周</option>
					          <option value="孕33-34周">孕33-34周</option>
					          <option value="孕35-36周">孕35-36周</option>
					          <option value="孕37周">孕37周</option>
					          <option value="孕38周">孕38周</option>
					          <option value="孕39周">孕39周</option>
					        </select>
					      </div>
					      
					      <div id="u14" class="ax_文本段落">
					          <p id="u15"><span>可用标识：</span></p>
					      </div>
					      
					      <div id="u16" class="ax_下拉列表框">
					        <select id="u16_input" name="useSign" style="border:1px solid #cccccc;">
					          <option value=" "></option>
					          <option value="0">正常</option>
					          <option value="1">停用</option>
					        </select>
					      </div>
					      
					      
					       <div id="u17" class="ax_文本段落">
					          <p id="u18"><span>发送时间：</span></p>
					      </div>
					      <div id="u19" class="ax_下拉列表框">
					        <select id="u19_input" name="sendTime" id="sendTime" style="border:1px solid #cccccc;">
					        	<option></option>
					        	<option value="0">提前三天</option>
					        </select>
					      </div>
					      
					      
					      <div id="u10" class="ax_文本段落" >
					          <p id="u11"><span>短信内容：</span></p>
					      </div>
					      
					      <div id="u13" class="ax_多行文本框">
					        <textarea id="u13_input" name="content" style="border:1px solid #cccccc;"></textarea>
					      </div>

						 <div style="right:30px;bottom:40px;position:absolute;">
						      <!-- Unnamed (形状) -->
						      <div id="u4" class="ax_形状" style="background-color:#009dd9">
						          <p id="u5"><span id="cancel" onclick="cancel()">取消</span></p>
						      </div>
						
						      <!-- Unnamed (形状) -->
						      <div id="u6" class="ax_形状" style="background-color:#fc7d45">
						         <p id="u7"> <span id=" " onclick="save()">保存</span></p>
						      </div>
					      </div>
   					</div>

	   		</form>

	   	</div>
	</body>
</html>