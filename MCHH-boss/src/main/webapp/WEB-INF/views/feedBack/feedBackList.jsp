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
		var listUrl = "${ctx}/feedBack/feedBackList";
		var doctorUrl = "${ctx}/archivesinfo/doctor";
		var updateStatusUrl = "${ctx}/feedBack/updateStatus";
		var opnUrl = "${ctx}/feedBack/opnFeedBack";
		$(function() {
    	  
		   //处理人
    	   $.ajax({
 				dataType:'json',
 	 			url:doctorUrl,
 	 			success:function(data){
 	 	 			$("#opnName").html("");
 	 	 			var str = "" ;
 	 	 			for(var i = 0;i<data.list.length;i++){
 	 	 				str += "<option value="+data.list[i].id+">"+data.list[i].realName+"</option>" ;
 	 	 			}
 	 	 			$("#opnName").html(str);
 	 	 			$("#opnName")[0].selectedIndex = -1;
 	 	 			
 	 			}
 	 		});
		   
    	    //下拉框默认为空
			$("#status")[0].selectedIndex = -1;
			
			//重置
			$("#reSetBtn").click(function(){
	    		   $("#userName").val("");
	    		   $("#nickName").val("");
	    		   $("#status")[0].selectedIndex = -1;
	    		   $("#opnName")[0].selectedIndex = -1;
	    		   $("#txtBegin").val("");
	    		   $("#txtEnd").val("");
	        });
			
			//取消处理意见反馈
			$("#u8").click(function(){
				
				window.location = listUrl ;
			})
			
			//保存处理意见
			$("#u10").click(function(){
	  			 	var feedId = $("#feedId").val();
	  			 	var remark = $.trim($("#u14_input").val());
	  			 	if (remark == null || remark == "") {
						alert("请输入备注信息！");
						return false;
					}
	  			 	$("#saveOpn").attr("action",opnUrl);
			    	$("#saveOpn").submit();
	  		})
			
			//列表
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'会员账号',field:'appMemberPO.userName',resizable:'true',width : '150',align:'center'},
                 {title:'昵称',field:'appMemberPO.nickName',resizable:'true',width : '90',align:'center'},
                 {title:'反馈内容',field:'content',resizable:'true',width : '150',align:'center'},
                 {title:'反馈时间',field:'createTime',formatter:formatDate,resizable:'true',width : '160',align:'center'},
                 {title:'处理人',field:'operatorPO.realName',resizable:'true',width : '120',align:'center'},
                 {title:'处理状态',field:'status',resizable:'true',width : '120',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "未查看"
                         } 
                         if(v==1){
                             return "已查看"
                         }
                	 } 
                 },
                 {title:'备注',field:'opnRemark',resizable:'true',width : '150',align:'center'},
                 {title:'备注时间',field:'opnTime',formatter:formatDate,resizable:'true',width : '160',align:'center'},
                 {title:'操作',field:'Operation',align:'center',width : '300', formatter: operationFormate1}
                ]]
			});
			
		});
		
		//操作
		function operationFormate1(value,node){
			
			return operationFormate(value,node,[{'name':'detail','label':'查看'}],'false','false'); 
		};

		//查看
		function detail(node){
			
			//反馈内容
			var content = node.content;
			
			//备注
			var opnRemark = node.opnRemark;
			
			//修改状态
			var mbrId = node.id;
			
			$("#feedId").val(mbrId);
			
			$.ajax({
 				type:'POST',
 	 			url:updateStatusUrl,
 	 			data:{mbrId:mbrId},
 	 			success:function(data){
 	 				//反馈内容
 	 				$("#u15_input").val(content);
 	 				//备注
 	 				$("#u14_input").val(opnRemark);
 	 				//处理意见反馈弹出框
					showDialog_("","detailAtv","zhongjianddle8",false);
					 	 			
 	 			}
 	 		});
			
		}
		
	</script>
	<style type="text/css">
		#u0 {
		  position:absolute;
		  left:146px;
		  top:80px;
		  width:415px;
		  height:110px;
		}
		#u0_img {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:415px;
		  height:110px;
		}
		#u1 {
		  position:absolute;
		  left:2px;
		  top:47px;
		  width:411px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#u2 {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:446px;
		}
		#u2_img {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:719px;
		  height:446px;
		}
		#u3 {
		  position:absolute;
		  left:2px;
		  top:215px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#u4 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  font-style:normal;
		  color:#FFFFFF;
		}
		#u4_img {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		}
		#u5 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u6 {
		  position:absolute;
		  left:57px;
		  top:88px;
		  width:83px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		}
		#u6_img {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:83px;
		  height:16px;
		}
		#u7 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:83px;
		  word-wrap:break-word;
		}
		#u8 {
		  position:absolute;
		  left:410px;
		  top:416px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  font-style:normal;
		  color:#FFFFFF;
		}
		#u8_img {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:120px;
		  height:44px;
		}
		#u9 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u10 {
		  position:absolute;
		  left:190px;
		  top:416px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  font-style:normal;
		  color:#FFFFFF;
		}
		#u10_img {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:120px;
		  height:44px;
		}
		#u11 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u12 {
		  position:absolute;
		  left:88px;
		  top:210px;
		  width:55px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		}
		#u12_img {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:55px;
		  height:16px;
		}
		#u13 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:55px;
		  word-wrap:break-word;
		}
		#u14 {
		  position:absolute;
		  left:146px;
		  top:210px;
		  width:412px;
		  height:180px;
		}
		#u14_input {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:412px;
		  height:180px;
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  text-decoration:none;
		  color:#000000;
		  text-align:left;
		}
		#u15 {
		  position:absolute;
		  left:146px;
		  top:90px;
		  width:412px;
		  height:110px;
		}
		#u15_input {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:412px;
		  height:110px;
		  font-family:'Arial Normal', 'Arial';
		  font-weight:400;
		  font-style:normal;
		  font-size:13px;
		  text-decoration:none;
		  color:#000000;
		  text-align:left;
		}
	</style>
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
			 <div style="position:relative;border: 1px solid #cccccc;height: 100px;width: 880px;">
				 <button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">意见反馈</span></p></button>
				<span style="position:absolute;left:30px ;width:60px; top:68px;height: 25px;">会员账号：</span> <input style="position:absolute;left:90px ;width:80px; top:65px;height: 25px;border: 1px solid #cccccc;"  class="easyui-validatebox text" type="text" name="userName" id = "userName"/>
				<span style="position:absolute;left:190px ;width:40px; top:68px;height: 25px;">昵称：</span> <input style="position:absolute;left:230px ;width:80px; top:65px;height: 25px;border: 1px solid #cccccc;"  class="easyui-validatebox text" type="text" name="nickName" id = "nickName"/>
				<span style="position:absolute;left:328px ;width:70px; top:68px;height: 25px;">处理状态：</span>
		      	    <select class="easyui-validatebox select" name="status" id="status" style="position:absolute;border: 1px solid #cccccc;left:390px ;top:65px;width:70px;height: 25px;">
		      	    	<option value = "">全部</option>
		      	    	<option value = "0">未查看</option>
		      	    	<option value = "1">已查看</option>
		      	    </select>
		      	<span style="position:absolute;left:478px ;width:70px; top:68px;height: 25px;">处理人：</span>
		      	    <select class="easyui-validatebox select" name="opnName" id="opnName" style="position:absolute;border: 1px solid #cccccc;left:530px ;top:65px;width:70px;height: 25px;">
		      	    </select>
		      	<span style="position:absolute;left:620px ;width:70px; top:68px;height: 25px;">反馈时间：</span>
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
		
	</div>
	
	   
	   <!-- 查看弹出框 -->
	    <div id="detailAtv" class="easyui-dialog" title="角色" closed="true">
	        	 
			<form id = "saveOpn" action="" method="post">
				<input id = "feedId" name = "feedId" value = ""/>
		      <!-- Unnamed (形状) -->
		      <div id="u4" class="ax_形状" style="background-color:#EE5F45">
		        
		          <p id="u5"><span>意</span><span>见反馈处理</span></p>
		        
		      </div>
		
		      <!-- Unnamed (形状) -->
		      <div id="u6" class="ax_文本段落">
		        
		          <p id="u7"><span>意见反馈</span><span>：</span></p>
		        
		      </div>
		      
		      <!-- Unnamed (多行文本框) -->
		      <div id="u15" class="ax_多行文本框">
		        <textarea id="u15_input" name = "content" readonly></textarea>
		      </div>
		      
		      <!-- Unnamed (形状) -->
		      <div id="u12" class="ax_文本段落">
		        
		          <p id="u13"><span>备注</span><span>：</span></p>
		        
		      </div>
		
		      <!-- Unnamed (多行文本框) -->
		      <div id="u14" class="ax_多行文本框">
		        <textarea id="u14_input" name = "opnRemark"></textarea>
		      </div>
		
		      <!-- Unnamed (形状) -->
		      <div id="u8" class="ax_形状" style="background-color:#009ED7;cursor:pointer">
		        
		          <p id="u9"><span>取</span><span>消</span></p>
		        
		      </div>
		
		      <!-- Unnamed (形状) -->
		      <div id="u10" class="ax_形状" style="background-color:#FC7D45;cursor:pointer">
		        
		          <p id="u11"><span>保存</span></p>
		        
		      </div>
			</form>
		
	    </div>
	</body>
</html>
