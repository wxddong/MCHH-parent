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
    <%-- <link href="${ctx}/static/css/feedBack_styles.css" type="text/css" rel="stylesheet"/> --%>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/font-awesome.min.css">
	<script type="text/javascript">
	    var fid = '-1';
		var listUrl = "${ctx}/womanSchool/womanSchoolList";
		$(function() {
    	  
			//重置
			$("#reSetBtn").click(function(){
	    		   $("#name").val("");
	    		   $("#status")[0].selectedIndex = -1;
	    		   $("#txtBegin").val("");
	    		   $("#txtEnd").val("");
	        });
			
			//列表
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'课程名称',field:'topic',resizable:'true',width : '350',align:'center'},
                 {title:'课程时间',field:'startDate',resizable:'true',width : '250',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "无效"
                         } 
                         if(v==1){
                             return "有效"
                         }
                	 } 
                 },
                 {title:'主讲人',field:'speaker',resizable:'true',width : '350',align:'center'},
                 {title:'添加时间',field:'createTime',formatter:formatDate,resizable:'true',width : '350',align:'center'}
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
 	
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
		 <div>
			 <form id="queryForm" method="post">
			 <div style="position:relative;border: 1px solid #cccccc;height: 100px;width: 880px;">
				 <button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">孕妇学校</span></p></button>
				<span style="position:absolute;left:30px ;width:110px; top:68px;height: 25px;">课程名称：</span> <input style="position:absolute;left:100px ;width:140px; top:65px;height: 25px;border: 1px solid #cccccc;"  class="easyui-validatebox text" type="text" name="topic" id = "topic"/>
				<span style="position:absolute;left:318px ;width:70px; top:68px;height: 25px;">课程时间：</span>
		      	    <input style="position:absolute;border: 1px solid #cccccc;left:390px ;top:65px;width:80px;height: 25px;" type="text" id="txtBegin1" name="txtBegin1" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'txtEnd1\')}'})"/>
						<span style="position:absolute;left:475px ;top:68px;">—</span>
		      		<input style="position:absolute;border: 1px solid #cccccc;left:490px ;top:65px;width:80px;height: 25px;" type="text" id="txtEnd1" name="txtEnd1" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'txtBegin1\')}'})"/>
		      	
		      	<span style="position:absolute;left:620px ;width:70px; top:68px;height: 25px;">添加时间：</span>
		      		<input style="position:absolute;border: 1px solid #cccccc;left:685px ;top:65px;width:80px;height: 25px;" type="text" id="txtBegin" name="txtBegin" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'txtEnd\')}'})"/>
						<span style="position:absolute;left:770px ;top:68px;">—</span>
		      		<input style="position:absolute;border: 1px solid #cccccc;left:785px ;top:65px;width:80px;height: 25px;" type="text" id="txtEnd" name="txtEnd" style="color:#adadaf"
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
		<div data-options="region:'south',border:false">
			<b:privilege url="sys/role/add">
				<a id="beforeAdd" href="javascript:void(0)" class="easyui-linkbutton new" onClick="add();" style="position: absolute;right: 14%;top: 130px;">新建</a>
			</b:privilege>
			<b:privilege url="sys/role/del">
				<a href="javascript:void(0)" class="easyui-linkbutton reset" onClick="del();" style="position: absolute;right: 8%;top: 130px;">删除</a>
			</b:privilege>
			<b:privilege url="sys/role/update">
				<a href="javascript:void(0)" class="easyui-linkbutton save"  onClick="edit();" style="position: absolute;right: 2%;top: 130px;">修改</a>
			</b:privilege>
		</div> 
		<br><br><br>
	</div>
	
	   
	   
	</body>
</html>

