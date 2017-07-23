<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>特殊疾病</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<link href="${ctx}/static/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/specialIll_style.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript">
	    var fid = '-1';
    	var addUrl = "${ctx}/com/config/preoption/add";
    	var listUrl = "${ctx}/com/config/preoption/list";
		var delUrl = "${ctx}/com/config/preoption/del";
	    var updateiview="${ctx}/com/config/preoption/updateView";
	    var getUrl="${ctx}/com/config/preoption/all";
		    $(function() {
		    	document.onkeydown = function () {
		            if (window.event && window.event.keyCode == 13) {
		                window.event.returnValue = false;
		            }
		        }
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'选中',checkbox:true,width : '100',resizable:'false',align:'center'},
                 {title:'序号',field:'id',width : '150',resizable:'f',align:'center',hidden:true},
                 {title:'疾病名称',field:'name', width : '600',resizable:'true',align:'center'},
                 {title:'所属分类',field:'type',width : '600',resizable:'true',align:'center',
                	
                	 formatter:function(v){ 
                         if(v==0){
                             return "指定传染病"
                         } 
                         if(v==1){
                             return "严重遗传病"
                         } 
                         if(v==2){
                             return "精神病"
                         } 
                         if(v==3){
                             return "男性生殖系统疾病"
                         } 
                         if(v==4){
                             return "女性生殖系统疾病"
                         } 
                         if(v==5){
                             return "内科疾病"
                         } 
                         
                     }
                 
                 
                 }
                
                ]]
			})
			
			//添加的保存数据
			$("#baocun").click(function(){
				var ill=document.getElementById("ill").value;
				var type=$('input:radio[name="type1"]:checked').val();

				var typeurl="${ctx}/com/config/preoption/findByname"+'?name='+ill+'&type='+type;
				$.ajax({
					
					url:typeurl,
					type:"GET",
					success:function(data){
						
						
						if(ill ==null || ill ==""){
							alert("请输入疾病名称");
							return false;
						};
						
						var val_payPlat = $('input[name="type1"]:checked ').val();
						
						if(val_payPlat ==null){
							alert("请选择所属分类");
							return false;
						};
						if(data.premaritalAbnormalOptionVO!=null){
							
							alert("名字已存在，请更换");
							return false;
							
						}
						 $("#addOrUpda").attr("action",addUrl);
							
						 $("#addOrUpda").submit();
						
					}
				}) 
			})
			
		});
		    

		//修改
		function edit(node){
			if(!node){
				node = getSelected('edit');
			}
			showDialog_URl('修改特殊疾病','addOrUpdate',updateiview+'?id='+node.id,'maxiddle1');
			
		}
			
		//添加
		function add(){

			showDialog_('新建特殊疾病','addOrUpdateWin','maxiddle1');
		}
		//查询
		function select(){
			var postUrl="${ctx}/com/config/preoption/list";
			
		}
	
	</script>
	<style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}	
 	</style>
  </head>
 	<body class="panel-noscroll">
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
		<input type="button" disabled="disabled" style="height: 35px; width: 120px; background-color:#ee5f45;border: 0px;cursor:pointer;color: white;"
											value="特殊疾病"/> 
		<br><br>
		<div style="position:relative; border: 1px solid #cccccc; top:-54px;height: 100px;width: 1120px;line-height: 40px;">
			 <br>
			 <form id="queryForm" method="post" width="100%">
			 <div style="top:45px;left:40px;position:absolute;">
				疾病名称:
				<input type="text" id="name" name="name" style="left:1050px;height: 25px"/>
				 所属分类:
				 <select name="type" id="type"  value="list.isvalid" style="width:180px;border:1px solid #cccccc;height: 25px">
					 	<option></option>
					 	<c:forEach var="adress" items="${findAll}" varStatus="status">
					 	<c:if test="${adress.type=='0' }">
					 	<option id="" name="type" value="0">指定传染病</option>
					 	</c:if>
					 	<c:if test="${adress.type=='1' }">
					 	<option id="" name="type" value="1">严重遗传病</option>
					 	</c:if>
					 	<c:if test="${adress.type=='2' }">
					 	<option id="" name="type" value="2">精神病</option>
					 	</c:if>
					 	<c:if test="${adress.type=='3' }">
					 	<option id="" name="type" value="3">男性生殖系统疾病</option>
					 	</c:if>
					 	<c:if test="${adress.type=='4' }">
					 	<option id="" name="type" value="4">女性生殖系统疾病</option>
					 	</c:if>
					 	<c:if test="${adress.type=='5' }">
					 	<option id="" name="type" value="5">内科疾病</option>
					 	</c:if>
					 	</c:forEach>			 	
				 </select>
				 </div>
		 	<div style="top:45px;height: 50px;left:1040px;width: 100px;position:absolute;">
				<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn" onclick="select()"style="background-color: #56BB4D;">查询</a>
			</div>
			</form>
		</div>
    	<div data-options="region:'south',border:false"> 
			<b:privilege url="sys/role/add">
			  <a href="javascript:void(0)" class="easyui-linkbutton new"  onClick="add();"  style="top:120px;left:910px;position:absolute;">添加</a>
		    </b:privilege>	    
		    <b:privilege url="sys/role/update">
			<a href="javascript:void(0)" class="easyui-linkbutton reset"  onClick="edit();"  style="top:120px;left:980px;position:absolute;">修改</a>
			</b:privilege>
			 <b:privilege url="sys/role/del">
			  <a href="javascript:void(0)"  class="easyui-linkbutton save" onClick="del();"  style="top:120px;left:1050px;position:absolute;">删除</a>
		    </b:privilege>	
	   </div>
	 
	</div>
	<div id="addOrUpdate"></div>
	<div id="addOrUpdateWin" class="easyui-dialog" title="街道" closed="true">
			
			<form id="addOrUpda" name="addOrUpda" method="post">
			<input type="hidden" id="id" name="id"/>
			
			  <div style="left:2px;bottom:400px;position:absolute;">
				      <div id="u8" class="ax_文本段落">
				        疾病名称：
				      </div>
					<div id="u10">
				        <input id="ill" class="easyui-validatebox text"  type="text" name="name"/>
				    </div>
				    <div id="u11" class="ax_文本段落">
				       所属 分类  ：
				    </div>
				
				      <!-- Unnamed (复选框) -->
				    <div id="u13" class="ax_复选框">
				       <p id="u14"><span>指定传染病</span></p>
				       <input id="type0" class="type" type="radio" name="type1" value="0"/>
				    </div>
				
				      <!-- Unnamed (复选框) -->
				      <div id="u15" class="ax_复选框">
				      	<p id="u16" ><span>严重遗传病</span></p>
				        <input id="type1" class="type" type="radio" name="type1" value="1"/>
				      </div>
				      <div id="u17" class="ax_复选框">
				       <p id="u18"><span>精神病</span></p>
				        <input id="type2" class="type" type="radio" name="type1" value="2"/>
				      </div>
				
				      <!-- Unnamed (复选框) -->
				      <div id="u19" class="ax_复选框">
				        <p id="u20"><span>男性 生殖系统疾病</span></p>
				        <input id="type3" class="type" type="radio" name="type1" value="3"/>
				      </div>
				
				      <!-- Unnamed (复选框) -->
				      <div id="u21" class="ax_复选框">
				       <p id="u22"><span>内科疾病</span></p>
				       <input id="type4" class="type" type="radio" name="type1" value="5"/>
				      </div>
				
				      <!-- Unnamed (复选框) -->
				      <div id="u23" class="ax_复选框">
				        <p  id="u24"><span>女性生殖系统疾病</span></p>
				        <input id="type5" class="type" type="radio" name="type1" value="4"/>
				      </div> 
				       
				      <div id="u6" class="ax_形状" >
				        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:5%;bottom: 10%;" id="baocun">保存</a>
					 </div>
				     
				     <div id="u4" class="ax_形状">
				     	<a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #009DD9;border: 0px;color: white;position: absolute;right:20%;bottom: 10%;" iconCls="icon-cancel"
												onClick="closeDialog_();">取消</a>
				     </div>
				     
                    </div>
			</form> 
	</div>
	</body>
</html>