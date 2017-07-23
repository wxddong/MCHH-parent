<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
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
	    var addUrl = "${ctx}/premaritalexainfo/manAdd";
		var listUrl = "${ctx}/archivesinfo/manList";
		var delUrl = "${ctx}/acty/activity/deleteSign";
	    var updateUrl = "${ctx}/premaritalexainfo/toManUpdate";
	    var delUrl = "${ctx}/archivesinfo/delMan";
	    var doctorUrl = "${ctx}/archivesinfo/doctor";
	    var manPresentationUrl = "${ctx}/premaritalexainfo/manPresentation"
	    var manDetailUrl = "${ctx}/premaritalexainfo/manDetail";
	    var manProveUrl = "${ctx}/premaritalexainfo/manProve";
	    var toUpdateUrl = "${ctx}/premaritalexainfo/toEditManPremarital"
	  	//导出
		var exportUrl = "${ctx}/export";
		$(function() {
			
			 //建档医生
	    	   $.ajax({
	 				dataType:'json',
	 	 			url:doctorUrl,
	 	 			success:function(data){
	 	 	 			$("#realName").html("");
	 	 	 			var str = "" ;
	 	 	 			for(var i = 0;i<data.list.length;i++){
	 	 	 				str += "<option value="+data.list[i].realName+">"+data.list[i].realName+"</option>" ;
	 	 	 			}
	 	 	 			$("#realName").html(str);
	 	 	 			$("#realName")[0].selectedIndex = -1;
	 	 	 			$("#premaritalStatus")[0].selectedIndex = -1;
	 	 			}
	 	 		});
			
	    	 //重置
	    	    $("#reSetBtn").click(function(){
		    		   $("#archivesCode").val("");
		    		   $("#manName").val("");
		    		   $("#manIdNo").val("");
		    		   $("#txtBegin").val("");
		    		   $("#txtEnd").val("");
		    		   $("#premaritalStatus")[0].selectedIndex = -1;
		    		   $("#realName")[0].selectedIndex = -1;
		        });
			
			//列表
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'档案编号',field:'archivesCode',resizable:'true',width : '120',align:'center'},
                 {title:'姓名',field:'manName', resizable:'true',width : '90',align:'center'},
                 {title:'性别',field:'manSex',resizable:'true',width : '90',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "女"
                         } 
                         if(v==1){
                             return "男"
                         }
                         if(v==2){
                             return "性别不明"
                         }
                	 } 
                 },
                 
                 {title:'身份证号码',field:'manIdNo',resizable:'true',width : '160',align:'center'},
                 {title:'联系电话',field:'manTele',resizable:'true',width : '120',align:'center'},
                 {title:'家庭住址',field:'address', resizable:'true',width : '120',align:'center'},
                 {title:'对方姓名',field:'name',resizable:'true',width : '90',align:'center'},
                 {title:'联系电话',field:'telephone',resizable:'true',width : '120',align:'center'},
                 {title:'建档日期',field:'creatTime',formatter:formatDate,resizable:'true',width : '150',align:'center'},
                 {title:'建档医生',field:'operatorPO.realName',resizable:'true',width : '120',align:'center'},
                 {title:'婚检状态',field:'premaritalExaInfoPO.premaritalStatus', resizable:'true',width : '120',align:'center',
                	  formatter:function(v){ 
                         if(v==0){
                             return "未婚检"
                         } 
                         if(v==1){
                             return "已婚检"
                         } 
                	 } 
                 },
                 {title:'操作',field:'Operation',align:'center',width : '300', formatter: operationFormate1}
                ]]
			});
			
		});
		
		function operationFormate1(value,node){
			var doctorId = $("#doctorId").val();
			var adminId = $("#adminId").val();
			var admId = $("#admId").val();
			if (doctorId == adminId || doctorId == admId) {
				return operationFormate(value,node,[{'name':'detailList','label':'详情'},{'name':'detail','label':node.premaritalExaInfoPO.premaritalStatus=='0'?'进入婚检':''},{'name':'detailBao','label':node.premaritalExaInfoPO.premaritalStatus=='1'?'婚检报告':''},{'name':'detailMing','label':node.premaritalExaInfoPO.premaritalStatus=='1'?'婚检证明':''}],'true','true');    
			}
			if (doctorId != adminId || doctorId != admId) {
				return operationFormate(value,node,[{'name':'detailList','label':'详情'},{'name':'detail','label':node.premaritalExaInfoPO.premaritalStatus=='0'?'进入婚检':''},{'name':'detailBao','label':node.premaritalExaInfoPO.premaritalStatus=='1'?'婚检报告':''},{'name':'detailMing','label':node.premaritalExaInfoPO.premaritalStatus=='1'?'婚检证明':''}],'false','false');
			}
			
		};

		//进入婚检
		function detail(node){
			var status = node.premaritalExaInfoPO.editStatus;
			
			if (status == 'null' || status == '') {
				
				window.location=addUrl+'?id='+node.id ;
			}else if (status == '0') {
				  
				window.location = toUpdateUrl+'?id='+node.id;
			}
		}
		
		//婚检报告
		function detailBao(node){
				
			window.location=manPresentationUrl+'?id='+node.id ;
			
		}
		
		//婚检证明
		function detailMing(node){
				
			window.location=manProveUrl+'?id='+node.id ;
			
		}
		
		//详情
		function detailList(node){
			
			showDialog_URl('','detailAtv',manDetailUrl+'?id='+node.id,'dialList2');
		}
		
		//修改
		function edit(node){
			if(!node){
				node = getSelected('edit');
			}
			showDialog_URl('','addOrUpdateAtv',updateUrl+'?id='+node.id,'dialList3');
		}
		
		//删除
		function delById(node){
			var manName = node.manName;
			var id = node.id;
			$("#archivesId").val(id);
			$("#names").html(manName);
			showDialog_("提示","deleteAtv","zhongjianddle7",false);
		    
		}
		
		$(function(){
			
			//确认删除
			$("#u0601").click(function(){
				var id = $("#archivesId").val();
				
				window.location.href=delUrl+'?id='+id ;
			})
			
			//取消
			$("#u0401").click(function(){
				$("#deleteAtv").window("close");
			})
		})
		
	</script>
	<style type="text/css">
     	#u288 {
			position:fixed;
			left: 0px;
			top: 0px;
			width:1177px;
			line-height:44px;
			z-index:9999;
			background: #FFFFFF; 
			border:1px solid;
		}
		#u0001 {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:346px;
		}
		/* #u0101 {
		  position:absolute;
		  left:2px;
		  top:165px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		} */
		#u0201 {
		  position:absolute;
		  left:5px;
		  top:2px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u0301 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u0401 {
		  position:absolute;
		  left:360px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u05501 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u0601 {
		  position:absolute;
		  left:140px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u0701 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u0801 {
		  position:absolute;
		  left:170px;
		  top:103px;
		  width:258px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#u0901 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:258px;
		  white-space:nowrap;
		}
	</style>
	<style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 	</style>
  </head>
 	<body >
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto">
		 <div>
		 <input id = "status" name = "status" type = "hidden" value = "${premaritalExaInfoPO.editStatus }"/>
		 <input id = "archId" name = "archId" type = "hidden" value="${archivesInfoDetail.archivesInfo.id}"/>
		 <input type="hidden" id="doctorId" value="${doctId }"/>
 	 	 <input type="hidden" id="adminId" value="${adminId }"/>
 	 	 <input type="hidden" id="admId" value="${admId }"/>
			 <form id="queryForm" method="post">
			 
			 <div style="position:relative;border: 1px solid #cccccc;height: 45px;width: 930px;">
				 <button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">个案查询</span></p></button>
				
				<span style="position:absolute;left:120px ;width:60px; top:18px;height: 25px;">档案编号：</span>
				<input style="position:absolute;border: 1px solid #cccccc;left:180px ;width:150px; top:15px;height: 25px;"  class="easyui-validatebox text" type="text" name="archivesCode" id = "archivesCode" style="width:120px"/>
				
				<span style="position:absolute;left:350px ;width:40px; top:18px;height: 25px;">姓名：</span>
				<input style="position:absolute;border: 1px solid #cccccc;left:390px ;width:90px; top:15px;height: 25px;"  class="easyui-validatebox text" type="text" name="manName" id = "manName" style="width:120px"/>
				
				<span style="position:absolute;left:498px ;width:70px; top:18px;height: 25px;">身份证号：</span>
				<input style="position:absolute;border: 1px solid #cccccc;left:560px ;width:180px; top:15px;height: 25px;"  class="easyui-validatebox text" type="text" name="manIdNo" id = "manIdNo" style="width:120px"/><br><br>
			
			</div>
			
			<div style="position:relative; border: 1px solid #cccccc; top:3px;height: 140px;width: 930px;">
			<button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 15px;font-style: normal;"><p><span style="font-weight:bold;">综合查询</span></p></button>
			
			<span style="position:absolute;left:120px ;width:60px; top:15px;height: 15px;">建档日期：</span>
			<input style="position:absolute;border: 1px solid #cccccc;left:180px ;top:12px;width:150px;height: 25px;" type="text" id="txtBegin" name="txtBegin" style="color:#adadaf"
	      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', maxDate:'#F{$dp.$D(\'txtEnd\')}'})"/>
			<span style="position:absolute;left:335px ;top:15px;">—</span>
	      			<input style="position:absolute;border: 1px solid #cccccc;left:350px ;top:12px;width:150px;height: 25px;" type="text" id="txtEnd" name="txtEnd" style="color:#adadaf"
	      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd', minDate:'#F{$dp.$D(\'txtBegin\')}'})"/>
			
			<span style="position:absolute;left:120px ;width:60px; top:55px;height: 15px;">婚检状态：</span>
			 <select style="position:absolute;border: 1px solid #cccccc;left:180px ;top:52px;color:#333333;width:150px;height: 25px;" class="easyui-validatebox select" name="premaritalStatus" id="premaritalStatus" >
			 	  <option value="0">未婚检</option>
			 	  <option value="1">已婚检</option>
			 </select>
			 
			<span style="position:absolute;left:120px ;width:60px; top:95px;height: 15px;">建档医生：</span>
			 <select class="easyui-validatebox select" name="realName" id="realName" style="position:absolute;border: 1px solid #cccccc;left:180px ;top:92px;color:#333333;width:150px;height: 25px;">
			 </select>	
			
			</div>
			
			<div style="position: absolute;right:0%;top: 20px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
      		</div>
      		<div style="position: absolute;right:0%;top: 80px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" id="reSetBtn"><i class="fa fa-undo"></i>重置</a><br>
      		</div>
      		<div style="position: absolute;right:0%;top: 140px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton export" onClick="exportExcel('queryForm','manPreExport');"><i class="fa fa-file-text-o"></i>导出</a>
      		</div>
			
			</form>
		</div>
	</div>
	
	   <div id="addOrUpdateAtv"></div>
	   <div id="detailAtv"></div>
	   <!-- 删除弹出框 -->
    <div id="deleteAtv" class="easyui-dialog" title="角色" closed="true">
        	<!-- Unnamed (形状) -->
	      <div id="u0001" class="ax_形状">
	        <div id="u1" class="text">
	          <p><span>&nbsp;</span></p>
	        </div>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <!-- <div id="u0201" class="ax_形状" style="background-color:#EE5F45">
	          <p id="u0301"><span>提&nbsp; &nbsp; 示</span></p>
	      </div> -->
	
	      <!-- Unnamed (形状) -->
      		<div id="u0401" class="ax_形状" style="background-color:#009DD9;cursor:pointer">
	          <p id="u05501"><span id="no">取消</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u0601" class="ax_形状" style="background-color:#E9854F;cursor:pointer">
	      <input id = "archivesId" type = "hidden" name = "archivesId" value = ""/>
	          <p id="u0701"><span id="yes">确定删除</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u0801" class="ax_文本段落">
	          <p id="u0901"><span>确定要删除 &nbsp; &nbsp;"</span><span id = "names"></span><span>" &nbsp; &nbsp;的档案？</span>
	          	
	          </p>
      	  </div>
        </div>
	</body>
</html>
