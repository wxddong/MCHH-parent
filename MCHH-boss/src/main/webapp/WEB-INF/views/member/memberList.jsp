<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>活动列表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<link href="${ctx}/static/css/app_jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/app_axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/app_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/member_styles.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/font-awesome.min.css">
	<script type="text/javascript">
	    var fid = '-1';
		var listUrl = "${ctx}/member/memberList";
	    var updateStatusUrl = "${ctx}/member/updateStatus";
	    var resetUrl = "${ctx}/member/resetPwd";
	    var beforeChangeUrl = "${ctx}/member/beforeChange";
	    var changeUrl = "${ctx}/member/change";
	  	//导出
		var exportUrl = "${ctx}/export";
		$(function() {
			
			//重置
			$("#reSetBtn").click(function(){
	    		   $("#userName").val("");
	    		   $("#nickName").val("");
	    		   $("#txtBegin").val("");
	    		   $("#txtEnd").val("");
	        });
			
			//关闭详情
			$("#u184").click(function(){
				$("#detailAtv").window("close");
			})
			
			//取消停用弹出框
			$("#u211").click(function(){
				window.location = listUrl ;
			})
			
			//确定执行停用操作
			$("#u213").click(function(){
				var mbId = $("#memberId").val();
				$.ajax({
					type:'POST',
	 	 			url:updateStatusUrl,
	 	 			data:{mbId:mbId},
	 	 			success:function(data){
	 	 				//修改成功跳转到列表页
	 	 				window.location = listUrl ;
	 	 	 			
	 	 			}
	 	 		});
			})
			
			//取消重置密码弹出框
			$("#u223").click(function(){
				$("#resetPwdAtv").window("close");
			})
			
			//确定重置密码
			$("#u225").click(function(){
				var mbId = $("#memberId").val();
				$.ajax({
					type:'POST',
	 	 			url:resetUrl,
	 	 			data:{mbId:mbId},
	 	 			success:function(data){
	 	 				//重置密码成功到列表页
	 	 				$("#resetPwdAtv").window("close");
	 	 	 			
	 	 			}
	 	 		});
			})
    	  
			//列表
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'会员账号',field:'userName',resizable:'true',width : '120',align:'center'},
                 {title:'昵称',field:'nickName',resizable:'true',width : '90',align:'center'},
                 {title:'性别',field:'sex',resizable:'true',width : '90',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "女"
                         } 
                         if(v==1){
                             return "男"
                         }else{
                             return "-"
                         } 
                	 } 
                 },
                 
                 {title:'孕育状态',field:'currentStage',resizable:'true',width : '160',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "备孕期"
                         } 
                         if(v==1){
                             return "孕产期"
                         }
                         if(v==2){
                             return "育儿期"
                         } 
                	 } 
                 },
                 {title:'关联医院',field:'appAffiliatedHospitalInfoPO.hospitalName',resizable:'true',width : '120',align:'center'},
                 {title:'档案号',field:'appAffiliatedHospitalInfoPO.archivesCode',resizable:'true',width : '120',align:'center'},
                 {title:'状态',field:'status',resizable:'true',width : '120',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "无效"
                         } 
                         if(v==1){
                             return "有效"
                         }
                	 } 
                 },
                 {title:'注册时间',field:'createTime',formatter:formatDate,resizable:'true',width : '90',align:'center'},
                 {title:'上次登录时间',field:'loginTime',formatter:formattime,resizable:'true',width : '120',align:'center'},
                 {title:'操作',field:'Operation',align:'center',width : '300', formatter: operationFormate1}
                ]]
			});
			
		});

		function operationFormate1(value,node){
			return operationFormate(value,node,[{'name':'detail','label':'详情'},{'name':'changeStatus','label':node.status=='0'?'解冻':'停用'},{'name':'detailLook','label':'查看'},{'name':'resetPwd','label':'重置密码'}],'false','false'); 
		};
		
		//重置密码
		function resetPwd(node){
			var memberId = node.id;
			$("#memberId").val(memberId);
			//是否执行该操作弹出框
			showDialog_("","resetPwdAtv","zhongjianddle7",false);
		}
		
		//停用
		function changeStatus(node){
			var status = node.status;
			$("#mbrStatus").val(status);
			
			var memberId = node.id;
			$("#memberId").val(memberId);
			//是否执行该操作弹出框
			showDialog_("","deleteAtv","zhongjianddle7",false);
		}
		
		//详情
		function detail(node){
			var userName = node.userName;
			
			$("#useName").html(userName);//会员账号
			$("#nicName").html(node.nickName);//昵称
			//性别
			var sex = node.sex;
			if (sex == "0") {
				$("#sex").html("女");
			}
			if (sex == "1") {
				$("#sex").html("男");
			}
			
			//血型
			var bloodType = node.bloodType;
			if (bloodType == "0") {
				$("#bloodType").html("O型血");
			}
			if (bloodType == "1") {
				$("#bloodType").html("A型血");
			}
			if (bloodType == "2") {
				$("#bloodType").html("B型血");
			}
			if (bloodType == "3") {
				$("#bloodType").html("AB型血");
			}
			if (bloodType == "4") {
				$("#bloodType").html("其他");
			}
			
			//生日
			var birthday = node.birthday;
			var bir = new Date();
			bir.setTime(birthday);
			
			var year = new Date(bir).getFullYear();
	 		var month = new Date(bir).getMonth()+1;
	 		var date = new Date(bir).getDate();
	 		if(month<10) month="0"+month;
	 		if(date<10) date="0"+date; 
			var birth = (year)+"-"+(month)+"-"+(date);
			$("#birthday").html(birth);
			
			//个性签名
			var signature = node.signature;
			$("#signature").html(signature);
			
			//孕育状态
			var currentStage = node.currentStage;
			if (currentStage == "0") {
				$("#currentStage").html("备孕期");
			}
			if (currentStage == "1") {
				$("#currentStage").html("孕产期");
			}
			if (currentStage == "2") {
				$("#currentStage").html("育儿期");
			}
			
			//关联医院
			var hospitalName = node.appAffiliatedHospitalInfoPO.hospitalName;
			$("#hospitalName").html(hospitalName);
			
			//会员详情弹出框
			showDialog_("","detailAtv","zhongjianddle8",false);
		}
		
		//批量停用
		function change(){			
				var node = getSelected('del');
				var ss = new Array();
				var rows = $('#dg').datagrid('getSelections');
				for(var i=0; i<rows.length; i++){
					var row = rows[i];
					ss.push(row.id);
				}
				
				if(node==undefined){
					return false;
				}
				
				$.getJSON(beforeChangeUrl,{
					ids:ss.join(',')
				}, function(data){
					if(data.msg=='hasCounty'){
						$.messager.confirm('确认框', '确定要停用吗?', function(r){
							if (r){ 
								doDel(ss);
						}});
					}
				},'json');
			}
			function doDel(ss){
				$.post(changeUrl, {memberIds:ss.join(',')}, 
					function(data){
						if(data.msg='true'){
							$('#queryForm')[0].reset();
							$('#dg').datagrid('options').queryParams={};
							$('#dg').datagrid('reload'); 	
						}else{
							$.messager.error('操作失败！');
						}
				},'json');
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
		 <div>
			 <form id="queryForm" method="post">
			 <div style="position:relative;border: 1px solid #cccccc;height: 100px;width: 740px;">
				 <button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">会员信息</span></p></button>
				<span style="position:absolute;left:30px ;width:60px; top:68px;height: 25px;">会员账号：</span> <input style="position:absolute;left:90px ;width:120px; top:65px;height: 25px;border: 1px solid #cccccc;"  class="easyui-validatebox text" type="text" name="userName" id = "userName" style="width:120px"/>
				<span style="position:absolute;left:230px ;width:40px; top:68px;height: 25px;">昵称：</span> <input style="position:absolute;left:270px ;width:120px; top:65px;height: 25px;border: 1px solid #cccccc;"  class="easyui-validatebox text" type="text" name="nickName" id = "nickName" style="width:120px"/>
				<span style="position:absolute;left:398px ;width:70px; top:68px;height: 25px;">注册时间：</span>
					<input style="position:absolute;border: 1px solid #cccccc;left:460px ;top:65px;width:100px;height: 25px;" type="text" id="txtBegin" name="txtBegin" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'txtEnd\')}'})"/>
					<span style="position:absolute;left:565px ;top:68px;">—</span>
		      			<input style="position:absolute;border: 1px solid #cccccc;left:580px ;top:65px;width:100px;height: 25px;" type="text" id="txtEnd" name="txtEnd" style="color:#adadaf"
		      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'txtBegin\')}'})"/>
				<br><br>
				</div>
				 
			<div style="position: absolute;right:24%;top: 70px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
      		</div>
      		<div style="position: absolute;right:16%;top: 70px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" onClick= "change()" ><i class="fa fa-undo"></i>停用</a><br>
      		</div>
      		<div style="position: absolute;right:8%;top: 70px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton export" onClick="exportExcel('queryForm','appMemberExport');"><i class="fa fa-file-text-o"></i>导出</a>
      		</div>
			<div style="position: absolute;right:0%;top: 70px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" id="reSetBtn"><i class="fa fa-undo"></i>重置</a>
      		</div>
      		
			</form>	
		</div>
		
	</div>
	
	
	   <div id="resetPwdAtv" class="easyui-dialog" title="角色" closed="true">
	   		<!-- Unnamed (形状) -->
            <div id="u221" class="ax_形状" style="background-color:#EE5F45">
                <p id="u222"><span>提&nbsp; &nbsp; 示</span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u219" class="ax_文本段落">
                <p id="u220"><span>确定重置密码吗，该操作会将当前用户的密码重置为123456</span></p>
            </div>


            <!-- Unnamed (形状) -->
            <div id="u223" class="ax_形状" style="background-color:#009ED7;cursor:pointer">
                <p id="u224"><span>取消</span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u225" class="ax_形状" style="background-color:#FC7D45;cursor:pointer">
                <p id="u226"><span>确定</span></p>
            </div>
	   </div>
	   <!-- 停用 -->
	   <div id="deleteAtv" class="easyui-dialog" title="角色" closed="true">
	   	<input id = "mbrStatus" type = "hidden" value = ""/>
	   	<input id = "memberId" type = "hidden" value = ""/>
            <!-- Unnamed (形状) -->
            <div id="u209" class="ax_形状" style="background-color:#EE5F45">
                <p id="u210"><span>提&nbsp; &nbsp; 示</span></p>
            </div>
            
	   		<!-- Unnamed (形状) -->
            <div id="u207" class="ax_文本段落">
                <p id="u208"><span>是</span><span>否执行该操作？</span></p>
            </div>


            <!-- Unnamed (形状) -->
            <div id="u211" class="ax_形状" style="background-color:#009ED7;cursor:pointer">
                <p id="u212"><span>取消</span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u213" class="ax_形状" style="background-color:#FC7D45;cursor:pointer">
                <p id="u214"><span>确定</span></p>
            </div>
	   </div>
	   <!-- 详情弹出框 -->
       <div id="detailAtv" class="easyui-dialog" title="角色" closed="true">
            <!-- Unnamed (形状) -->
            <div id="u182" class="ax_形状" style="background-color:#EE5F45">
                <p id="u183"><span>会</span><span>员详情</span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u184" class="ax_形状" style="background-color:#009ED7;cursor:pointer">
                <p id="u185"><span>关</span><span>闭</span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u186" class="ax_文本段落">
                <p id="u187"><span>会员帐号</span><span>：</span><span id = "useName" name = "useName"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u188" class="ax_文本段落">
                <p id="u189"><span>昵称：</span><span id = "nicName" name = "nicName"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u190" class="ax_文本段落">
                <p id="u191"><span>姓别</span><span>：</span><span id = "sex" name = "sex"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u192" class="ax_文本段落">
                <p id="u193"><span>孕育状态</span><span>：</span><span id = "currentStage" name = "currentStage"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u194" class="ax_文本段落">
                <p id="u195"><span>个性签名：</span><span id = "signature" name = "signature"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u196" class="ax_文本段落">
                <p id="u197"><span>血型：</span><span id = "bloodType" name = "bloodType"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u198" class="ax_文本段落">
                <p id="u199"><span>生日：</span><span id = "birthday" name = "birthday"></span></p>
            </div>

            <!-- Unnamed (形状) -->
            <div id="u200" class="ax_文本段落">
                <p id="u201"><span>关</span><span>联医院：</span><span id = "hospitalName" name = "hospitalName"></span></p>
            </div>
       </div>
	</body>
</html>


 