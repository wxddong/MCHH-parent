<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html style="overflow: auto;">
  <head>
  <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/font-awesome.min.css">
  	<style type="text/css">
  		#lastMenses{
			position: absolute;
		    left: 0px;
		    top: 0px;
		    width: 145px;
		    height: 25px;
		    border-style: solid;
		    border-width: 1px;
		    border-color: #C8C9CD;
		    font-family: 'Arial Normal', 'Arial';
		    font-weight: 400;
		    font-style: normal;
		    font-size: 13px;
		    text-decoration: none;
		    color: #333333;
		    text-align: left;
		}
		#predictDate{
			position: absolute;
		    left: 0px;
		    top: 0px;
		    width: 145px;
		    height: 25px;
		    border-style: solid;
		    border-width: 1px;
		    border-color: #C8C9CD;
		    font-family: 'Arial Normal', 'Arial';
		    font-weight: 400;
		    font-style: normal;
		    font-size: 13px;
		    text-decoration: none;
		    color: #333333;
		    text-align: left;
		}
  		#deu0 {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:346px;
		}
		#deu1 {
		  position:absolute;
		  left:2px;
		  top:165px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#deu2 {
		  position:absolute;
		  left:258px;
		  top:120px;
		  width:203px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#deu3 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:203px;
		  white-space:nowrap;
		}
		#deu4 {
		  position:absolute;
		  left:5px;
		  top:5px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#deu5 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#deu6 {
		  position:absolute;
		  left:410px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#deu7 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#deu8 {
		  position:absolute;
		  left:190px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#deu9 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
  		/* .form-control { 
		height: 25px; 
		padding: 6px 12px; 
		font-size: 13px; 
		line-height: 0.028571429; 
		color: #555555; 
		vertical-align: middle; 
		background-color: #ffffff; 
		border: 1px solid #cccccc; 
		border-radius: 4px; 
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075); 
		box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075); 
		-webkit-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s; 
		transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s; 
		}  */
		
  	
  	</style>
    <title>活动列表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
	<link href="${ctx}/static/css/child_archives_details_styles.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript">
	    var fid = '-1';
	    var exportUrl = "${ctx}/export";
		var detailUrl = "${ctx}/childrenarchives/detail";
		var updateUrl = "${ctx}/childrenarchives/detail";
		
		$(function() {
			var listUrl = "${ctx}/childrenarchives/list";
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'档案编号',field:'archivesCode',width:'130', resizable:'true',align:'center'},
                 {title:'姓名',field:'name', width:'70',resizable:'true',align:'center'},
                 {title:'姓别',field:'sex', width:'70',resizable:'true',align:'center',
                	 formatter:function(v){
                		 if(v == '0'){
                			 return "女"
                		 }
                		 if(v == '1'){
                			 return "男"
                		 }
			 	 	 }
                 },
                 {title:'出生日期',field:'birthday',width:'130',formatter:formatDate,resizable:'true',align:'center'},
                 {title:'年龄',field:'babyCreate', width:'70',formatter:getAge,resizable:'true',align:'center'},
                 {title:'建档日期',field:'creatTime',width:'130',formatter:formatDate,resizable:'true',align:'center'},
                 {title:'身份证号码',field:'idNo',width:'120',resizable:'true',align:'center'},
                 {title:'妈妈姓名',field:'momName',width:'90',resizable:'true',align:'center'},
                 {title:'手机号码',field:'momTele',width:'90',resizable:'true',align:'center'},
                 {title:'结案状态',field:'childrenLastStatusInfoPO.pregnantState',width:'100',resizable:'true',align:'center',
                	 formatter:function(v){
                         if(v=='0'){
                             return "未结案"
                         } 
                         if(v=='1'){
                             return "已结案"
                         } 
                	 } 
                 },
                 {title:'建档医生',field:'operatorPO.realName',width : '100',resizable:'true',align:'center'},
                 {title:'建档医院',field:'departmentPO.name', width : '115',resizable:'true',align:'center'},
                 {title:'最近检查日期',field:'childrenHealthExaInfoPO.creatTime',formatter:formatDate,resizable:'true',width:'130',align:'center'},
                 {title:'检查医生',field:'childrenHealthExaInfoPO.operatorPO.realName',resizable:'true',align:'center',width:'100'},
                 {title:'下次随访时间',field:'childrenHealthExaInfoPO.childrenReferralInfoPO.followingDate',width:'130',formatter:formatDate,resizable:'true',align:'center'},
                 {title:'操作',field:'Operation',align:'center',width:'150', formatter: operationFormate1}
                ]]
			});
			
			//双击进入历史列表
			$('#dg').datagrid({
				onDblClickRow: function(rowIndex,rowData){
					var prenatalState = rowData.childrenLastStatusInfoPO.pregnantState;
					//alert(rowData.birthArchivesId);
					if(prenatalState == '0'){
						//window.location.href = "${ctx}/prenatal/prenatalGestationHistory?birthArchivesId="+rowData.birthArchivesInfoPO.id;
					}
					if(prenatalState == '1'){
						//window.location.href = "${ctx}/prenatal/prenatalChildbirthHistory?birthArchivesId="+rowData.birthArchivesInfoPO.id;
					}
					
			    },
				rowStyler:function(index,row){
					//debugger;
					if(row.childrenLastStatusInfoPO != null && row.childrenLastStatusInfoPO != undefined){
				        if (row.childrenLastStatusInfoPO.riskSign == '1'){    
				            return 'color:#EE5F45;font-weight:800;';    
				        }
					}
			    }    
			});
			
			//确定
			$("#deu9").click(function(){
				var archivesId = $("#archivesId").val();
				//alert(birthArchivesId);
				window.location.href = "${ctx}/childrenarchives/delArchives?archivesId="+archivesId;
			});
			//取消
			$("#deu7").click(function(){
				$("#addOrUpdateWin").window("close");
			});
			/* $("#du67").click(function(){
				$('#addOrUpdateWin').dialog('close');
			}); */
			
			//重置
			$("#rollBackBtn").click(function(){
				
				$(".form-control").val("");
				$(".Wdate").val("");
				$("#countyMechanism")[0].selectedIndex = -1;
	    		$("#townMechanism")[0].selectedIndex = -1;
	    		$("#villageMechanism")[0].selectedIndex = -1;	
	    		$("#doctorId")[0].selectedIndex = -1;	
				$("#checkDoctor")[0].selectedIndex = 0;
				$("#closeState")[0].selectedIndex = 0;
			});
			 //建档医生 检查医生
			 var doctorUrl = "${ctx}/archivesinfo/doctor";
	    	   $.ajax({
	 				dataType:'json',
	 	 			url:doctorUrl,
	 	 			success:function(data){
	 	 	 			$("#doctorId").html("");
	 	 	 			var str = "" ;
	 	 	 			for(var i = 0;i<data.list.length;i++){
	 	 	 				str += "<option value="+data.list[i].id+">"+data.list[i].realName+"</option>" ;
	 	 	 			}
	 	 	 			$("#doctorId").html(str);
	 	 	 			$("#checkDoctor").html(str);
	 	 	 			$("#doctorId")[0].selectedIndex = -1;
	 	 	 			$("#checkDoctor")[0].selectedIndex = -1;
	 	 			}
	 	 		});
			
			var countyDepUrl = "${ctx}/premaritalexainfo/countyDep";
			
			//下拉列
    	    function countyDep(thisUrl,id,parentId){
				
    		    $.ajax({
				  dataType:'json',
				  url:thisUrl,
				  data:{parentId:parentId},
				  success:function(data){
 					  $("#"+id).html("");
 					  var str = "" ;
 					  for(var i = 0;i<data.list.length;i++){
 						  str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
 					  }
 					  $("#"+id).html(str);
 					  $("#"+id)[0].selectedIndex = -1;
				  }
			  });
    	    }
	    	
			//县级医院名称
	    	countyDep(countyDepUrl,"countyMechanism",null);
			
	    	//乡级医院名称
	    	$("#countyMechanism").change(function(){
	    		  var countyDepId = $("#countyMechanism").val();
	    		  var townDepUrl = "${ctx}/premaritalexainfo/townDep";
	    		  countyDep(townDepUrl,"townMechanism",countyDepId);
	    		  $("villageMechanism")[0].selectedIndex = -1;
	    	});
	    	
	    	//村级医院名称
	    	$("#townMechanism").change(function(){
	    		  var townDepId = $("#townMechanism").val();
	    		  var villageDepUrl = "${ctx}/premaritalexainfo/villageDep";
	    		  countyDep(villageDepUrl,"villageMechanism",townDepId);
	    	});
	    	
		});
		
		
		
		/* {title:'序号',field:'birthArchivesInfoPO.archivesInfoPO.id',width : '30',resizable:'true',align:'center'}, */
		function operationFormate1(value,node){
			var str = '';
			var show = "";
			var referralSign = node.childrenLastStatusInfoPO.referralSign;
			var outHospitalId = node.childrenLastStatusInfoPO.outHospitalId;
			var depId = $("#depId").val();
			if(node.childrenLastStatusInfoPO.pregnantState=='0'){
				str = "joinPrenatal";
				if(referralSign != '1'){
					show = "进入检查";
				}else if(referralSign == '1'){
					if(outHospitalId == depId){
						show = "";
					}else{
						show = "进入检查";
					}
				}
			}else if(node.childrenLastStatusInfoPO.pregnantState=='1'){
				
			}
			
			var adminId = $("#adminId").val();
			var doctorId = $("#nowDoctorId").val();
			var doctorAdminId = $("#doctorAdminId").val();
			if(adminId != null && doctorId != null && doctorAdminId != null){
				if(adminId != doctorId && doctorId != doctorAdminId){
					return operationFormate(value,node,[{'name':'msg','label':'详细'},{'name':str,'label':show}],'false','false');
				}else if(adminId == doctorId || doctorId == doctorAdminId){
					return operationFormate(value,node,[{'name':'msg','label':'详细'},{'name':str,'label':show}],'true','true');
				}//return operationFormate(value,node,[{'name':'msg','label':'详细'},{'name':'joinPrenatal','label':node.birthArchivesInfoPO.pregnantState=='0'?'进入产检':''},{'name':'childBasic','label':node.birthArchivesInfoPO.childbirthBasicInfoPO.leaveDate=='null'?(node.birthArchivesInfoPO.pregnantState=='1'?'分娩登记':''):''},{'name':'enterPost','label':node.birthArchivesInfoPO.childbirthBasicInfoPO.leaveDate=='null'?'':(node.birthArchivesInfoPO.pregnantState=='1'?'产后访视':'')},{'name':'increasePrenatal','label':node.birthArchivesInfoPO.pregnantState=='2'?'增加产检':''}],'true','true');    
			}else{
				return operationFormate(value,node,[{'name':'msg','label':'详细'},{'name':str,'label':show}],'false','false');
			}
		} 
		//进入产检
		function joinPrenatal(node){
			window.location.href = "${ctx}/childrenarchives/joinCheck?archivesId="+node.id+"&sign=1";
		}
		//修改
		function edit(node){
			//debugger;
			if(!node){
				node = getSelected('edit');
			}
			showDialog_URl('','detailAtv',updateUrl+'?id='+node.id+"&sign=1",'dialList6','zhongjianddle');
		}
		//删除
		function delById(node){
			$("#delName").html(node.name);
			$("#archivesId").val(node.id);
			showDialog_("","addOrUpdateWin","moremiddle",'true');
		}
		//详细
		function msg(node){
			showDialog_URl('','addOrUpdateAtv',detailUrl+'?id='+node.id+"&sign=0",'dialList5',false);
		}
		
		
	</script>
	<style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		
 	</style>
  </head>
 	<body  style="background-color: #FFFFFF;">
 		<input id="adminId" type="hidden" value="${adminId }"/>
 		<input id="nowDoctorId" type="hidden" value="${doctorId }"/>
 		<input id="depId" type="hidden" value="${depId }"/>
 		<input id="doctorAdminId" type="hidden" value="${doctorAdminId }"/>
		<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto;">
		 <div  style="">
			 <form id="queryForm" method="post">
			 <input type="hidden" id="sign" name="sign" value=""/>
			 
			 <div id="div" style="position:relative;border: 1px solid #cccccc;height: 45px;width: 91%;">
				 <button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 12px;font-weight: bold;">个案查询</button>
				<span style="position:absolute;left:120px ;width:60px; top:18px;height: 25px;">档案编号：</span> <input style="position:absolute;left:180px ;width:150px; top:15px;height: 25px;border: 1px solid #cccccc;" type="text" class="form-control" name="archivesCode"/>
				<span style="position:absolute;left:350px ;width:40px; top:18px;height: 25px;">姓名：</span><input style="position:absolute;left:390px ;width:90px; top:15px;height: 25px;border: 1px solid #cccccc;" class="form-control" type="text" name="name"/>
				<span style="position:absolute;left:498px ;width:70px; top:18px;height: 25px;">身份证号：</span><input style="position:absolute;left:560px ;width:180px; top:15px;height: 25px;border: 1px solid #cccccc;"  class="form-control" type="text" name="idNo"/>
			 </div>
			
			
			<div style="position:relative; border: 1px solid #cccccc; top:3px;height: 140px;width: 91%;">
				<button disabled="disabled" style="background-color: #EE5F45;height: 35px;width: 90px;color: #FFFFFF;border: 0px;font-size: 12px;font-weight: bold;">综合查询</button>
			<span style="position:absolute;left:120px ;width:60px; top:15px;height: 15px;">医疗机构：</span>
			 <select style="position:absolute;left:180px ;top:12px;width:150px;height: 25px;border: 1px solid #cccccc;" class="form-control" name="countyMechanism" id="countyMechanism" >
			 </select>
			 <select style="position:absolute;left:350px ;top:12px;width:150px;height: 25px;border: 1px solid #cccccc;" class="form-control" name="townMechanism" id="townMechanism" >
			 </select>
			 <select style="position:absolute;left:518px ;top:12px;width:150px;height: 25px;border: 1px solid #cccccc;" class="form-control" name="villageMechanism" id="villageMechanism" >
			 </select>
			 <br/>	
			<span style="position:absolute;left:120px ;width:60px; top:45px;height: 15px;">建档日期：</span>
			<input type="text" id="beginTime" name="beginTime" readonly
        	style="position:absolute;left:180px ;top:42px;color:#333333;width:150px;height: 25px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
        	<span style="position:absolute;left:335px ;top:45px;">—</span>
        	<input type="text" id="endTime" name="endTime" readonly
        	style="position:absolute;left:350px ;top:42px;color:#333333;width:150px;height: 25px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required> 
			<span style="position:absolute;left:560px ;width:60px; top:45px;height: 15px;">建档医生：</span> 
			 <select style="position:absolute;left:620px ;top:42px;width:100px;height: 25px;border: 1px solid #cccccc;" class="form-control" name="doctorId" id="doctorId" >
			 </select>
			 <br/>
			<span style="position:absolute;left:120px ;width:60px; top:75px;height: 15px;">检查日期：</span>
			<input type="text" id="beginCheckTime" name="beginCheckTime" readonly
        	style="position:absolute;left:180px ;top:72px;color:#333333;height: 25px;width:150px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
        	<span style="position:absolute;left:335px ;top:75px;">—</span>
        	<input type="text" id="endCheckTime" name="endCheckTime" readonly
        	style="position:absolute;left:350px ;top:72px;color:#333333;height: 25px;width:150px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
        	<span style="position:absolute;left:560px ;width:60px; top:75px;height: 15px;">检查医生：</span> 
			 <select style="position:absolute;left:620px ;top:72px;width:100px;height: 25px;border: 1px solid #cccccc;" class="form-control" name="prenstate" id="checkDoctor" >
			 </select>
      		<br/>
      		<span style="position:absolute;left:120px ;width:60px; top:105px;height: 15px;">预约日期：</span>
			<input type="text" id="beginNextTime" name="beginNextTime" readonly 
        	style="position:absolute;left:180px ;height: 25px;top:102px;color:#333333;width:150px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
        	<span style="position:absolute;left:335px ;top:105px;">—</span>
        	<input type="text" id="endNextTime" name="endNextTime" readonly 
        	style="position:absolute;left:350px ;height: 25px;top:102px;color:#333333;width:150px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
        	<span style="position:absolute;left:560px ;width:60px; top:105px;height: 15px;">结案状态：</span> 
			 <select style="position:absolute;left:620px ;top:102px;width:100px;height: 25px;border: 1px solid #cccccc;" class="form-control" name="closeState" id="closeState" >
			 	<option selected value="-1">不限</option>
			 	<option value="1">未结案</option>
			 	<option value="2">已结案</option>
			 </select>
			 </div>
      		<br/>	
      		<div style="position: absolute;left:93%;top: 20px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
      		</div>
      		<div style="position: absolute;left:93%;top: 80px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" id="rollBackBtn"><i class="fa fa-undo"></i>重置</a>
      		</div>
      		<div style="position: absolute;left:93%;top: 140px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton export" onClick="exportExcel('queryForm','prenatalList');"><i class="fa fa-file-text-o"></i>导出</a>
      		</div>
			
			</form>
			
		</div>
	</div>
	
	   <div id="addOrUpdateAtv"></div>
	   <div id="detailAtv"></div>
	   
	   <div id="addOrUpdateWin" class="easyui-dialog" title="角色" closed="true" >

		<div id="deu4" class="ax_形状" style="background-color:#E9854F">
          <p id="deu5"><span>提&nbsp; &nbsp; 示</span></p>
      	</div>
        
        <div id="deu0" class="ax_形状">
          <p id="deu1"><span>&nbsp;</span></p>
      	</div>
        
        <div id="deu2" class="ax_文本段落">
          <p id="deu3"><span>是否确定删除“<span id="delName"></span>”的档案？</span></p>
      	</div>
        
        <div id="deu8" class="ax_形状" style="background-color:#E9854F">
        	<input type="hidden" id="archivesId" value=""/>
          <p id="deu9" style="cursor: pointer;"><span>确定删除</span></p>
      	</div>
        
        <div id="deu6" class="ax_形状" style="background-color:#009DD9">
          <p id="deu7" style="cursor: pointer;"><span>取消</span></p>
      	</div>
		
    </div>
    
	</body>
</html>
