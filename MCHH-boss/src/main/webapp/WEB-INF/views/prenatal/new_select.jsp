<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新建查询页</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/newSelect_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/prenatal_detail_styles.css" type="text/css" rel="stylesheet"/>
    <style type="text/css">
		#u00 {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:346px;
		}
		#u01 {
		  position:absolute;
		  left:2px;
		  top:165px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#u02 {
		  position:absolute;
		  left:256px;
		  top:131px;
		  width:209px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#u03 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:209px;
		  white-space:nowrap;
		}
		#u04 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u05 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u06 {
		  position:absolute;
		  left:410px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		
		#u07 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u08 {
		  position:absolute;
		  left:190px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u09 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
    	#u0_ {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:346px;
		}
		#u1_ {
		  position:absolute;
		  left:2px;
		  top:165px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#u2_ {
			position: absolute;
			left: 214px;
			top: 103px;
			width: 374px;
			height: 79px;
			font-size: 16px;
			color: #000000;
			text-align: center;
		}
		#u3_ {
			position: absolute;
			left: 0px;
			top: 1px;
			width: 374px;
			white-space: nowrap;
			height: 22px;
		}
		#u4_ {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u5_ {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u6_ {
			position: absolute;
			left: 89px;
			top: 228px;
			width: 120px;
			height: 43px;
			font-family: 'Arial Negreta', 'Arial';
			font-weight: 700;
			color: #FFFFFF;
		}
		#u7_ {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u8_ {
			position: absolute;
			left: 331px;
			top: 232px;
			width: 120px;
			height: 44px;
			font-family: 'Arial Negreta', 'Arial';
			font-weight: 700;
			color: #FFFFFF;
		}
		#u9_ {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u10_ {
			position: absolute;
			left: 504px;
			top: 232px;
			width: 118px;
			height: 44px;
			font-family: 'Arial Negreta', 'Arial';
			font-weight: 700;
			color: #FFFFFF;
		}
		#u11_ {
			position: absolute;
			left: 0px;
			top: 15px;
			width: 116px;
			word-wrap: break-word;
		}
		#u12_ {
			position: absolute;
			left: 159px;
			top: 232px;
			width: 120px;
			height: 44px;
			font-family: 'Arial Negreta', 'Arial';
			font-weight: 700;
			color: #FFFFFF;
		}
		#u13_ {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
    	#lastMenses {
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
    
    </style>
    <script type="text/javascript">
    
     	$(function(){
     		$("#u4").click(function(){
     			var newArchivesUrl = "${ctx}/prenatal/prenatalNewArchives";
     			window.location.href = newArchivesUrl;
     		});
     		
     		$("#u13").click(function(){
     			var idOrCodeUrl = "${ctx}/archivesinfo/selectArchivesByIdOrCode";
     			var idOrCode =$.trim($("#u2_input").val());
     			if(idOrCode == ""){
     				alert("请输入查询条件！");
     				return false;
     			}
     			//debugger;
     			var tag = /^[0-9]{19}$/;
     			if(!tag.test(idOrCode)){
     				alert("请输入正确的档案号！");
     				return false;
     			}
				$.ajax({
					url:idOrCodeUrl,
					type:"GET",
					data:{idOrCode:idOrCode},
					success:function(data){
						debugger;
						if(data.map.archives == null){
							//弹出无建档信息，是否建档
							showDialog_("提示","addOrUpdateWin","moremiddle",false);
						}else {
							
							if(data.map.isAll == '1'){
	    						alert("请补全档案信息!");
	    						
	    						var updateUrl = "${ctx}/prenatal/toUpdate?id="+data.map.archives.id+"&birthId="+data.map.birthArchives.id;
	    						showDialog_URl('','detailAtv',updateUrl,'maxBig1','zhongjianddle');
	    						
	    						return false;
							}else if(data.map.isAll == '0'){
								if(data.map.birthArchives != undefined && data.map.birthArchives != null){
									if(data.map.birthArchives.pregnantState == "2"){
										//window.location.href = "${ctx}/prenatal/affirmPrenatalArchives?archivesId="+data.map.archives.id;
										window.location.href = "${ctx}/prenatal/prenatalOverHistory?birthArchivesId="+data.map.birthArchives.id;
										return false;
									}
								}
								//产后访视
								if(data.map.postpartumExaInfoPO != null){
									//保存
									if(data.map.postpartumExaInfoPO.editStatus == '0'){
										window.location.href = "${ctx}/postpartum/postpartumexainfo/toPostExaEdit?archiveId="+data.map.archives.id+"&postpartumExaId="+data.map.postpartumExaInfoPO.id;
										return false;
									}else if(data.map.postpartumExaInfoPO.editStatus == '1'){
									//完成
										window.location.href = "${ctx}/postpartum/postpartumexainfo/list?archiveId="+data.map.archives.id+"&go=0";
										return false;
									}
								}else if(data.map.childbirthBasicInfoPO != null){
									//保存
									if(data.map.childbirthBasicInfoPO.editStatus == '0'){
										window.location.href = "${ctx}/archivesinfo/updateNoteView?id="+data.map.archivesInfoPO.id;
										return false;
									}else if(data.map.childbirthBasicInfoPO.editStatus == '1'){
									//完成
										window.location.href = "${ctx}/postpartum/postpartumexainfo/list?archiveId="+data.map.archives.id+"&go=0";
										return false;
									}
								}
								if (data.map.prenatalExa != null){
									
									if(data.map.prenatalExa.evaluate == "1"){
										//高危，进入高危产妇个人专案管理
										//alert("高危专案管理");
										window.location.href = "${ctx}/highriskprojectmanagement/list?birthArchiveId="+data.map.birthArchives.id+"&archivesId="+data.map.birthArchives.archivesId;
										return false;
									}
									//alert("下一次产前随访");
									
									if(data.map.prenatalExa.editStatus == "1"){
										//直接进入下一次的产前随访
										window.location.href = "${ctx}/archivesinfo/comePrenatalExa?id="+data.map.archives.id;
										return false;
									}else if(data.map.prenatalExa.editStatus == "0"){
										window.location.href="${ctx}/prenatal/selectTo1Or2?prenatalId="+data.map.prenatalExa.id;
									}
								
								} else {
								//无产前随访记录的弹窗点击“进入产检‘’、”分娩登记“、”产后访视“
								$("#archivesId").val(data.map.archives.id);
								$("#archivesCode").html(data.map.archives.archivesCode);
								$("#name").html("姓名："+data.map.archives.name+" 身份证号 ：");
								$("#idNo").html(data.map.archives.idNo);
								showDialog_("提示","addOrUpdate","moremiddle",false);
								}
	    					}
						}
					}
				});
     		});
     		//点击否，关闭弹窗
     		$("#u07").click(function(){
     			$("#addOrUpdateWin").window("close");
     		});
     		//点击是，新建孕检档案
     		$("#u09").click(function(){
     			
     			window.location.href = "${ctx}/prenatal/prenatalNewArchives";
     			
     		});
     		//进入产检
     		$("#u13_").click(function(){
     			var id = $("#archivesId").val();
     			//alert(id);
     			window.location.href="${ctx}/archivesinfo/comePrenatalExa?id="+id;
     		});
     		//产后访视
     		$("#u11_").click(function(){
     			var id = $("#archivesId").val();
     			window.location.href="${ctx}/postpartum/postpartumexainfo/list?archiveId="+id+"&go=0";
     		});
     		//分娩登记
     		$("#u9_").click(function(){
     			var id = $("#archivesId").val();
     			//alert(id);
     			window.location.href="${ctx}/archivesinfo/listChildbirth?id="+id;
     		});
     		
     	});
    </script>
  </head>
  <body style="border-width: 0px;">
    <div id="base" class="">

      <div id="u0" class="ax_文本段落">
          <p id="u1" ><span>请输入档案编号：</span></p>
      </div>
		<input id="archivesId" type="hidden" name="id" value=""/>
      <div id="u2" class="ax_文本框">
        <input id="u2_input" type="text" placeholder="档案编号" value=""/>
      </div>

      <div id="u3" class="ax_形状" style="background-color:#EE5F45">
          <p id="u4" style="cursor:pointer"><span>新建档案</span></p>
      </div>

      <div id="u5" class="ax_垂直线">
       	<hr id="u5_line" style="weight:1px;border:none;border-left:1px dashed #CCCCCC;"/>
      </div>

      <div id="u6" class="ax_文本段落">
          <p id="u7"><span>点击新建档案</span></p>
      </div>

      <div id="u12" class="ax_形状" style="background-color:#009DD9">
          <p id="u13" style="cursor:pointer"><span>查询</span></p>
      </div>
    </div>
    
    <div id="addOrUpdateWin" class="easyui-dialog" title="角色" closed="true">
      
      <div id="u00" class="ax_形状">
        <div id="u01" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>

      <div id="u02" class="ax_文本段落">
          <p id="u03"><span>无建档信息，是否开始建档？</span></p>
      </div>

      <!-- <div id="u04" class="ax_形状" style="background-color:#EE5F45">
          <p id="u05"><span>提&nbsp; &nbsp; 示</span></p>
      </div> -->

      <div id="u06" class="ax_形状" style="background-color:#009DD9">
          <p id="u07" style="cursor:pointer"><span>否</span></p>
      </div>

      <div id="u08" class="ax_形状" style="background-color:#E9854F">
          <p id="u09" style="cursor:pointer"><span>是</span></p>
      </div>
    </div>
    
    <div id="addOrUpdate" class="easyui-dialog" title="角色" closed="true">

      <div id="u0_" class="ax_形状">
        <div id="u1_" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>

      <div id="u2_" class="ax_文本段落">
          <p id="u3_">档案编号：<span id="archivesCode">34101245120000</span></p>
          <p><span>&nbsp;</span></p><p><span>&nbsp;</span></p>
          <p><span id="name">姓名：王晓婷 身份证号 ：</span><span id="idNO"></span></p>
      </div>

      <!-- <div id="u4_" class="ax_形状" style="background-color:#EE5F45">
          <p id="u5_"><span>提&nbsp; &nbsp; 示</span></p>
      </div> -->

      <div id="u8_" class="ax_形状" style="background-color:#009DD9">
          <p id="u9_" style="cursor:pointer"><span>分娩登记</span></p>
      </div>

      <div id="u10_" class="ax_形状" style="background-color:#56BB4D">
          <p id="u11_" style="cursor:pointer"><span>产后访视</span></p>
      </div>

      <div id="u12_" class="ax_形状" style="background-color:#E9854F">
          <p id="u13_" style="cursor:pointer"><span>进入产检</span></p>
      </div>
      
  </div>
  <div id="detailAtv"></div>
  </body>
</html>
