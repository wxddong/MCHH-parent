<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>活动列表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/premaritalDetail-styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/detail_styles.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/font-awesome.min.css">
	<script type="text/javascript">
	    var fid = '-1';
		var listUrl = "${ctx}/operation/operationList";
		$(function() {
    	  
			//下拉框默认为空
			$("#ornType")[0].selectedIndex = -1;
			
			//重置
			$("#reSetBtn").click(function(){
	    		   $("#userName").val("");
	    		   $("#nickName").val("");
	    		   $("#ornType")[0].selectedIndex = -1;
	    		   $("#txtBegin").val("");
	    		   $("#txtEnd").val("");
	        });
			
			//列表
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'会员账号',field:'appMemberPO.userName',resizable:'true',width : '200',align:'center'},
                 {title:'昵称',field:'appMemberPO.nickName',resizable:'true',width : '150',align:'center'},
                 {title:'操作内容',field:'content',resizable:'true',width : '500',align:'center'},
                 {title:'操作类型',field:'status',resizable:'true',width : '200',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "修改密码"
                         } 
                         if(v==1){
                             return "更新会员信息"
                         }
                	 } 
                 },
                 {title:'操作时间',field:'opnTime',formatter:formattime,resizable:'true',width : '250',align:'center'}
                ]]
			});
			
		});
		
	</script>
	
	<style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}
 	</style>
  </head>
 	<body class="panel-noscroll">
 	<input type="hidden" id="doctorId" value="${doctId }"/>
 	<input type="hidden" id="adminId" value="${adminId }"/>
 	<input type="hidden" id="admId" value="${admId }"/>
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
		 <div>
			 <form id="queryForm" method="post">
			 <div style="position:relative;border: 1px solid #cccccc;height: 100px;width: 920px;">
				 <button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">操作日志</span></p></button>
				<span style="position:absolute;left:30px ;width:60px; top:68px;height: 25px;">会员账号：</span> <input style="position:absolute;left:90px ;width:120px; top:65px;height: 25px;border: 1px solid #cccccc;"  class="easyui-validatebox text" type="text" name="userName" id = "userName"/>
				<span style="position:absolute;left:230px ;width:40px; top:68px;height: 25px;">昵称：</span> <input style="position:absolute;left:270px ;width:100px; top:65px;height: 25px;border: 1px solid #cccccc;"  class="easyui-validatebox text" type="text" name="nickName" id = "nickName"/>
				<span style="position:absolute;left:393px ;width:70px; top:68px;height: 25px;">操作类型：</span>
		      	    <select class="easyui-validatebox select" name="ornType" id="ornType" style="position:absolute;border: 1px solid #cccccc;left:455px ;top:65px;width:100px;height: 25px;">
		      	    	<option value = "">全部</option>
		      	    	<option value = "0">修改密码</option>
		      	    	<option value = "1">更新会员信息</option>
		      	    </select>
		      	<span style="position:absolute;left:580px ;width:70px; top:68px;height: 25px;">操作时间：</span>
		      		<input style="position:absolute;border: 1px solid #cccccc;left:650px ;top:65px;width:100px;height: 25px;" type="text" id="txtBegin" name="txtBegin" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'txtEnd\')}'})"/>
						<span style="position:absolute;left:755px ;top:68px;">—</span>
		      		<input style="position:absolute;border: 1px solid #cccccc;left:770px ;top:65px;width:100px;height: 25px;" type="text" id="txtEnd" name="txtEnd" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'txtBegin\')}'})"/>
				<br><br>
				</div>
				 
			<div style="position: absolute;right:8%;top: 70px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
      		</div>
      		<div style="position: absolute;right:0%;top: 70px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" id="reSetBtn"><i class="fa fa-undo"></i>重置</a>
      		</div>
      		
			</form>	
		</div>
		
	</div>
	</body>
</html>
