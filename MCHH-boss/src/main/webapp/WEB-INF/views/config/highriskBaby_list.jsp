<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>高危项管理</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<script type="text/javascript">
	    var fid = '-1';
    	var addUrl = "${ctx}/com/config/highrisk/addview";
    	var listUrl = "${ctx}/com/config/highrisk/listForBaby";
		var delUrl = "${ctx}/com/config/highrisk/del";
	    var updateUrl = "${ctx}/com/config/highrisk/updateBabyView";
	    var addhightUrl = "${ctx}/com/config/highrisk/addriskBaby";
	    
		    $(function() {
		    	
		    	document.onkeydown = function () {
		            if (window.event && window.event.keyCode == 13) {
		                window.event.returnValue = false;
		            }
		        }
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,width : '30',resizable:'false',align:'center'},
                 {title:'序号',field:'id',width : '160',resizable:'f',align:'center',hidden:true},
                 {title:'高危名称',field:'name', width : '300',resizable:'true',align:'center'},
                 {title:'高危评分',field:'score',width : '120',resizable:'true',align:'center'},
                 {title:'所属分类',field:'status',width : '300',resizable:'true',align:'center',
                	
                	 formatter:function(v){ 
                         if(v==0){
                             return "妊娠合并"
                         } 
                         if(v==1){
                             return "固定因素"
                         } 
                         if(v==2){
                             return "本次妊娠异常"
                         } 
                         if(v==3){
                             return "社会环境因素"
                         } 
                     }
                 
                 
                 },
                 {title:'描述',field:'remark',width : '350',resizable:'true',align:'center'
                }
                ]]
			})
			
			//添加的保存数据
			$("#save").click(function(){
				 var name=document.getElementById("name").value;
				
				var typeurl="${ctx}/com/config/highrisk/findByname"+'?name='+name;
				$.ajax({
					
					url:typeurl,
					type:"GET",
					success:function(data){
						
						if(data.HighRiskPregnancyScorePO!=null){
							
							alert("名字已存在，请更换");
							return false;
							
						}
						if(name ==null || name ==""){
							alert("请输入疾病名称");
							return false;
						};
						
						var sco=document.getElementById("sco").value;
						if(sco ==null || sco ==""){
							alert("请选择高危评分");
							return false;
						};
						var statu=document.getElementById("statu").value;
						if(statu ==null || statu ==""){
							alert("请选择所属分类");
							return false;
						};
					 		
						$("#addUpdate").attr("action",addhightUrl);
						$("#addUpdate").submit();
						
					}
				})
			})
			//下拉框默认为空
	 		var a=$(".text");
			for(var i = 0;i< a.length;i++){
				a[i].selectedIndex = -1;
			}
			
			
		});
	  

		

		//修改
		function edit(node){
			if(!node){
				node = getSelected('edit');
			}
			showDialog_URl('修改儿童高危因素','addOrUpdate',updateUrl+'?id='+node.id,'maxiddle5');
			
		}
		
		//添加
		function add(){
			
			showDialog_('新建儿童高危因素','addOrUpdateWin','maxiddle5');
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
		<input type="button" style="height: 35px; width: 120px; background-color: #999999;border: 0px;cursor:pointer;color: white;"
											value="孕产妇高危因素管理" onclick="window.location.href='${ctx}/com/config/highrisk/addhighrisk'"/> 
		&nbsp;
		<input type="button" disabled="disabled" style="height: 35px; width: 120px; background-color: #ee5f45;border: 0px;cursor:pointer;color: white;"
											value="儿童高危因素管理" onclick="window.location.href='${ctx}/com/config/highrisk/addhighriskBaby'"/> 
		<br><br>
		<div style="position:relative; border: 1px solid #cccccc; top:-19px;height: 70px;width: 1120px;line-height: 40px;">
			 <br>
			 <form id="queryForm" method="post">
			 <div style="top:17px;left:40px;position:absolute;">
				高危名称:
				<input type="text" name="name"style="width:180px;height:27px;border:1px solid #cccccc"/>
				 高危评分:
				 <select class="text" name="score" id="score" style="width:180px;border:1px solid #cccccc;" >
					 	<option value="">不限</option>
					 	<option  value="5">5</option>
					 	<option  value="10">10</option>
					 	<option  value="20">20</option>
				 </select>	 
				 所属分类:
				 <select class="text" name="status" id="status"  value="list.isvalid" style="width:180px;border:1px solid #cccccc;">
					 			<option value="">不限</option>
					 			<option id="status" name="status" value="0">妊娠合并</option>			 	
					 			<option id="status" name="status" value="1">固定因素</option>			 	
					 			<option id="status" name="status" value="2">本次妊娠异常</option>			 	
					 			<option id="status" name="status" value="3">社会环境因素</option>			 	
				 			
				 		
				 </select>	
				 </div>
			<div style="top:19px;height: 50px;left:1040px;width: 100px;position:absolute;">
				<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn" onclick="select()"style="background-color: #56BB4D;"><i class="fa fa-search"></i>查询</a>
			</div>
			</form>
		</div>
		
    	<div data-options="region:'south',border:false"> 
			<b:privilege url="sys/role/add">
			  <a href="javascript:void(0)" class="easyui-linkbutton new"  onClick="add();"  style="top:120px;left:910px;position:absolute;">添加</a>
		    </b:privilege>	    
		    <b:privilege url="sys/role/update">
			<a href="javascript:void(0)" class="easyui-linkbutton reset"  onClick="edit();" style="top:120px;left:980px;position:absolute;">修改</a>
			</b:privilege>
			<b:privilege url="sys/role/del">
			  <a href="javascript:void(0)"  class="easyui-linkbutton save"  onClick="del();" style="top:120px;left:1050px;position:absolute;">删除</a>
		    </b:privilege>	
	   </div>
	   
	 <br><br>
	 
	</div>
		<div id="addOrUpdate" class="easyui-dialog"  closed="true"></div>
	    <div id="addOrUpdateWin" class="easyui-dialog" title="预约检查" closed="true">
	   		<form id="addUpdate" name="addUpdate" method="post">
	     
			 <input type="hidden" id="type" name="type" value="1"/>
			   
			 <div style="left:80px;top:10px;position:absolute;">
			   
			 <table class="datagrid-body" width="100%">
				    <tr>
						<td class="datagrid-header">疾病名称：<span style="color: red;">*</span>	</td>
						<td>
					   	<input name="name" id="name" class="easyui-validatebox text"   validType="maxLength[200]" required="true" missingMessage="标题不能为空" />			
				    	</td>
					</tr>
				    <tr>
						<td class="datagrid-header">高危评分：<span style="color: red;">*</span>	</td>
						<td>
							 <select class="text"  name="score" id="sco" style="width:180px;border:1px solid #cccccc;">
									<option  value="5">5</option>
									<option  value="10">10</option>
									<option  value="20">20</option>
							</select>
						
						</td>
					</tr>
			   		<tr>
						<td class="datagrid-header">疾病描述：<span style="color: red;">*</span>	</td>
						<td>
					   	<textarea name="remark" id="remar" class="easyui-validatebox" cols="55" rows="7" validType="maxLengths[500]"style="border:1px solid #cccccc;" ></textarea>			
				    	</td>
					</tr>
				
			      <tr>
						<td class="datagrid-header">所属分类：<span style="color: red;">*</span>	</td>
					<td>
						 <select class="text"  name="status" id="statu" style="width:180px;border:1px solid #cccccc;">
							<option id="" name="status" value="0">妊娠合并</option>
							<option id="" name="status" value="1">固定因素</option>
							<option id="" name="status" value="2">本次妊娠异常</option>
							<option id="" name="status" value="3">社会环境因素</option>
						</select>		
				    </td>
				</tr>
			    
				  <tr>
						<td>
							&nbsp;
						</td>
						<td>

							  <div id="u6" class="ax_形状" >
						        <a class="easyui-linkbutton" style="height: 35px; width: 80px; background-color: #FC7D45;border: 0px;color: white;position: absolute;left:18%;bottom: 1%;" id="save" onclick="save()">&nbsp 保存</a>
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
	   
	   </div>
	</body>
</html>