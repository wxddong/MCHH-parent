<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>出院3-7天访视编辑</title>
    <style type="text/css">
    
    	#title {
		position:fixed;
		left: 0px;
		top: 0px;
		width:1178px;
		line-height:44px;
		height:44px;
		z-index:9999;
		background: #FFFFFF; 
		border:1px solid #CCCCCC;
		}
    
    /* 		结案的弹框样式 */	
		#u002 {
		  position:absolute;
		  left:296px;
		  top:120px;
		  width:129px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
	
		#u003 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:129px;
		  white-space:nowrap;
		}
		#u004 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
	
		#u005 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u006 {
		  position:absolute;
		  left:270px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#u007 {
		  position:absolute;
		  left:16px;
		  top:-2px;
		  width:82px;
		  word-wrap:break-word;
		}
		#u006_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#u008 {
		  position:absolute;
		  left:390px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#u009 {
		  position:absolute;
		  left:16px;
		  top:-2px;
		  width:82px;
		  word-wrap:break-word;
		}
		#u008_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#u0010 {
		  position:absolute;
		  left:410px;
		  top:246px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
	
		#u0011 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u0012 {
		  position:absolute;
		  left:190px;
		  top:246px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}

		#u0013 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		
		/* 		完成区打印预览页面的弹框样式 */
		
		 #u02 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u03 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		   
		   #u04 {
		  position:absolute;
		  left:440px;
		  top:216px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}  
		#u05 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u06 {
		  position:absolute;
		  left:220px;
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
		  left:256px;
		  top:131px;
		  width:209px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#u09 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:209px;
		  white-space:nowrap;
		}
/* 		#u08 { */
/* 		  position:absolute; */
/* 		  left:248px; */
/* 		  top:131px; */
/* 		  width:225px; */
/* 		  height:16px; */
/* 		  font-size:16px; */
/* 		  color:#000000; */
/* 		  text-align:center; */
/* 		} */
/* 		#u09 { */
/* 		  position:absolute; */
/* 		  left:0px; */
/* 		  top:0px; */
/* 		  width:200px; */
/* 		  white-space:nowrap; */
/* 		  font-size:20px; */
/* 		  font-weight:700; */
/* 		} */
		
		.autocut {  
		    width:100px;  
		    overflow:hidden;  
		    white-space:nowrap;  
		    text-overflow:ellipsis;  
		    -o-text-overflow:ellipsis;  
		    -icab-text-overflow: ellipsis;  
		    -khtml-text-overflow: ellipsis;  
		    -moz-text-overflow: ellipsis;  
		    -webkit-text-overflow: ellipsis;  
		} 
	</style>  
    
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx }/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/PostpartumExa3to7_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/PostpartumExa3to7SaveEdit_styles1.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript">
	
	/**
	 * @author dingjh
	 */
	     /** 展开和收起 *
		 *divName 要操作层的name
		 *textId 变换文字的元素ID
		 *num 操作的层数量
		 */

		 function AutoFold(divName,textId,num){
				var operateDiv=document.getElementsByName(divName);
				var textDoc=document.getElementById(textId);
				var operateDivNum = divName.substring(7,divName.length);//获取当前操作层的层号
				
				var showStatus=operateDiv[0].style.visibility;
				var changeHeight=0;
				if(showStatus=='hidden'){
					//归位在展示，如果不归位，由于上移的关系，展示出来后的位置会偏上
					
					operateDiv[0].style.visibility='';
					textDoc.innerHTML="收起";

					var d=document.getElementsByName("foldDiv"+(parseInt(operateDivNum)-1));
					var aa=operateDiv[0].offsetTop;//移动前top值
					operateDiv[0].style.top = (d[0].offsetTop+d[0].offsetHeight)+'px';
					var bb=operateDiv[0].offsetTop;//移动后top值
	
					 var divList=operateDiv[0].getElementsByTagName("div");
					 for(var j=0;j<divList.length; j++){
						 divList[j].style.top=(divList[j].offsetTop+(bb-aa))+'px';
					 }

					changeHeight=operateDiv[0].offsetHeight;
				}else{
					changeHeight=0-operateDiv[0].offsetHeight;
					operateDiv[0].style.visibility='hidden';
					textDoc.innerHTML="展开";
				}

				for (var i=parseInt(operateDivNum)+1;i<=num;i++)
				{
					var changeTopDiv=document.getElementsByName("foldDiv"+i);
					changeTopDiv[0].style.top=(changeTopDiv[0].offsetTop+changeHeight)+'px';
					 var divList=changeTopDiv[0].getElementsByTagName("div");
					 for(var j=0;j<divList.length; j++){
						 divList[j].style.top=(divList[j].offsetTop+changeHeight)+'px';
					 }
					
				}
			}
	
	$(function(){
		
		//加载页面收起
		$("[name='foldDiv1']").click();
		$("[name='foldDiv3']").click();
		$("[name='foldDiv5']").click();
		$("[name='foldDiv7']").click();
		$("[name='foldDiv9']").click();
		$("[name='foldDiv11']").click();
		$("[name='foldDiv13']").click();
		$("[name='foldDiv15']").click();
		
		
		//点击保存按钮向数据库中更新数据
		$("#u113").click(function(){
			$('[name="nextFollowingDate"]').attr("disabled", false);
			var path="${ctx }/postpartum/postpartumexainfo/update?save=0";
			var fromClass = $('#form1').attr("class");
			
			if(fromClass==1){
				$('#form1').attr("action", path).submit();
			}
			
			$('#form1').attr("class","0");
		});
		
		//点击完成按钮向数据库中更新数据
		$("#u115").click(function(){
			
			//校验体温 : 仅限数字，精确到小数点后两位。
			var bodyTemperatureValue =  $.trim($("[name='bodyTemperature']").val());
			var bodyTemperatureReg = /^[0-9]+(.[0-9]{2})?$/;
			if(bodyTemperatureValue==""){
				alert("请输入体温");
				return;
			}else if(!bodyTemperatureReg.test(bodyTemperatureValue)){
				alert("体温只能为数字，小数最多两位！");
				return;
			}
			
			//血压校验：仅限数字
			var bloodLowValue =  $.trim($("[name='bloodLow']").val());
			var bloodHiValue =  $.trim($("[name='bloodHi']").val());
			var bloodReg = /^[0-9]*$/;
			if(bloodLowValue=="" || bloodHiValue==""){
				alert("请输入血压");
				return;
			}else if(!bloodReg.test(bloodLowValue) || !bloodReg.test(bloodHiValue)){
				alert("血压只能为数字！");
				return false;
			}
			
			//一般健康情况 必填
			var healthValue = $.trim($("[name='health']").val());
			if(healthValue==""){
				alert("请输入一般健康情况");
				return;
			}
			//一般心理状况 必填
			var psychologicalValue = $.trim($("[name='psychological']").val());
			if(psychologicalValue==""){
				alert("请输入一般心理状况");
				return;
			}
			
			//乳房 必填
			var breastValue = $("[name='breast']").val();
			if(breastValue==null){
				alert("请选择乳房是否异常");
				return;
			}else if(breastValue=="1"){
				var breastRemarkValue = $.trim($("[name='breastRemark']").val());
				if(breastRemarkValue==""){
					alert("请输入乳房异常原因");
					return;
				}
			}
			//恶露 必填
			var lochiaValue = $("[name='lochia']").val();
			if(lochiaValue==null){
				alert("请选择恶露是否异常");
				return;
			}else if(lochiaValue=="1"){
				var lochiaRemarkValue = $.trim($("[name='lochiaRemark']").val());
				if(lochiaRemarkValue==""){
					alert("请输入恶露异常原因");
					return;
				}
			}
			//子宫 必填
			var uterusValue = $("[name='uterus']").val();
			if(uterusValue==null){
				alert("请选择子宫是否异常");
				return;
			}else if(uterusValue=="1"){
				var uterusRemarkValue = $.trim($("[name='uterusRemark']").val());
				if(uterusRemarkValue==""){
					alert("请输入子宫异常原因");
					return;
				}
			}
			//伤口 必填
			var woundValue = $("[name='wound']").val();
			if(woundValue==null){
				alert("请选择伤口是否异常");
				return;
			}else if(woundValue=="1"){
				var woundRemarkValue = $.trim($("[name='woundRemark']").val());
				if(woundRemarkValue==""){
					alert("请输入伤口异常原因");
					return;
				}
			}
			//其他 必填
			var otherValue = $.trim($("[name='other']").val());
			if(otherValue==""){
				alert("请输入'其他'信息");
				return;
			}
			
			//分类 必选
			var resultValue = $("[name='result']:checked").val();
			if(resultValue==undefined){
				alert("请选择分类信息");
				return;
			}else if(resultValue=="1"){
				var remarkValue = $.trim($("[name='remark']").val());
				if(remarkValue==""){
					alert("请输入分类异常原因");
					return;
				}
			}
			
			//指导意见 必填
			var guidanceValue = $.trim($("[name='guidance']").val());
			if(guidanceValue==""){
				alert("请输入保健指导意见");
				return;
			}
			
			//转诊 必填 选择无时 原因 科室 机构置灰不可编辑 
			var referralValue = $("[name='referral']:checked").val();
			if(referralValue==undefined){
				alert("请选择是否转诊");
				return;
			}else if(referralValue=="1"){
				//转诊原因 校验
				var referralReasonValue = $.trim($("[name='referralReason']").val());
				if(referralReasonValue==""){
					alert("请输入转诊原因");
					return;
				}
				//转诊机构 校验
				var mechanismValue = $("[name='mechanism']").val();
				if(mechanismValue==null){
					alert("请选择转诊机构");
					return;
				}
				//转诊科室 校验
				var departmentValue = $("[name='department']").val();
				if(departmentValue==null){
					alert("请选择转诊科室");
					return;
				}
			}
			
			//是否预约下次产检 必选
			var orderCheckValue = $("[name='orderCheck']:checked").val();
			if(orderCheckValue==undefined){
				alert("请选择是否预约下次产检");
				return;
			}
			
			//母子健康手册使用情况 
			var healthHandbookValue = $("[name='healthHandbook']").val();
			if(healthHandbookValue==null){
				alert("请选择母子健康手册是否使用");
				return;
			}
			
			$('[name="nextFollowingDate"]').attr("disabled", false);
			var fromClass = $('#form1').attr("class");
			
			if(fromClass==1){
				$.ajax({
					url:"${ctx }/postpartum/postpartumexainfo/update?save=1",
					type:"POST",
					data:$('#form1').serialize(),
					success:function(data){
					}
				});
			}
			
			$('#form1').attr("class","0");
			showDialog_("提示","ifPrint","over");
		});
		

		//刚加载页面时，有异常的框显示，没异常的框不显示   没选择有无异常的情况下默认为空   !breast && typeof(breast)!="undefined" && breast!=0
		var breast = "${postpartumExaDetailed.breast}";
		if(breast==0){
			$("[name='breastRemark']").hide();
		}
		if(breast==""){
			$("[name='breastRemark']").hide();
			$("[name='breast']")[0].selectedIndex = -1;
		}
		var lochia = "${postpartumExaDetailed.lochia}";
		if(lochia==0){
			$("[name='lochiaRemark']").hide();
		}
		if(lochia==""){
			$("[name='lochiaRemark']").hide();
			$("[name='lochia']")[0].selectedIndex = -1;
		}
		var uterus = "${postpartumExaDetailed.uterus}";
		if(uterus==0){
			$("[name='uterusRemark']").hide();
		}
		if(uterus==""){
			$("[name='uterusRemark']").hide();
			$("[name='uterus']")[0].selectedIndex = -1;
		}
		var wound = "${postpartumExaDetailed.wound}";
		if(wound==0){
			$("[name='woundRemark']").hide();
		}
		if(wound==""){
			$("[name='woundRemark']").hide();
			$("[name='wound']")[0].selectedIndex = -1;
		}
		var healthHandbook = "${postpartumReferral.healthHandbook}";
		if(healthHandbook==""){
			$("[name='healthHandbook']")[0].selectedIndex = -1;
		}
		//所有的下拉列表 选择为未见异常时后面的input输入框隐藏，选择为异常时后面的input输入框显示
		$(".test").change(function(){
			var idClass = $(this).attr("id");
			var testValue = $(this).val();
			var selectedName = this.attributes["name"].value;
			if(testValue==0){
				$("."+idClass).hide();
				$("."+idClass).removeAttr("name");
			}else{
				$("."+idClass).show();
				var inputName = selectedName+"Remark"
				$("."+idClass).attr("name",inputName);
			}
		});

		//到达编辑页面时，异常单选按钮被选中时显示对应的文本框，没异常时不显示
		var result = $('input:radio[name="result"]:checked').val();
		if(result==undefined){
			$("[name='remark']").hide();
		}
		if(result==0){
			$("#u143_input").hide();
		}
		$('input:radio[name="result"]').click(function(){
			var val=$('input:radio[name="result"]:checked').val();	
			if(val==0){
				$("#u143_input").hide();
				$('#u143_input').removeAttr("name");
			}else{
				$("#u143_input").show();
				$('#u143_input').attr("name","remark");
			}
		});
		//页面加载时看是否预约下次随访日期  否 日期置空
		var orderCheckVal=$('input:radio[name="orderCheck"]:checked').val();
		if(orderCheckVal==0){
			$('[name="nextFollowingDate"]').attr("disabled", true);
			$('[name="nextFollowingDate"]').css("background-color","#E5E5E5");
		}
		//点击是否预约产检 点击否下次随访日期不可用 并且置空
		$('input:radio[name="orderCheck"]').click(function(){
			var orderCheckVal=$('input:radio[name="orderCheck"]:checked').val();
			if(orderCheckVal==0){
				$('[name="nextFollowingDate"]').val("");
				$('[name="nextFollowingDate"]').attr("disabled", true);
				$('[name="nextFollowingDate"]').css("background-color","#E5E5E5");
			}else{
				$('[name="nextFollowingDate"]').attr("disabled", false);
				$('[name="nextFollowingDate"]').css("background-color","#FFFFFF");
			}
		});
		
		
		//点击不转诊时 原因 机构 科室 默认不可用
		$("[name='referral']").change(function(){
			var referralValue = $("[name='referral']:checked").val();
			if(referralValue=="0"){ 
				$("#u80_input").attr("disabled", true);
				$("#u80_input").css("background-color","#E5E5E5");
				$("#u83_input").attr("disabled", true);
				$("#u83_input").css("background-color","#E5E5E5");
				$("#u86_input").attr("disabled", true);
				$("#u86_input").css("background-color","#E5E5E5");
				$("#u80_input").removeAttr("name");
				$("#u83_input").removeAttr("name");
				$("#u86_input").removeAttr("name");
			}
			if(referralValue=="1"){
				$("#u80_input").attr("disabled", false);
				$("#u80_input").css("background-color","#FFFFFF");
				$("#u83_input").attr("disabled", false);
				$("#u83_input").css("background-color","#FFFFFF");
				$("#u86_input").attr("disabled", false);
				$("#u86_input").css("background-color","#FFFFFF");
				$("#u80_input").attr("name","referralReason");
				$("#u83_input").attr("name","mechanism");
				$("#u86_input").attr("name","department");
			}
		});
		 	
		//到达编辑页面时，无转诊的，原因 机构 科室 灰色不可点并且默认为空
		var ifReferralValue = $("[name='referral']:checked").val();
		if(ifReferralValue=="0"){
			$("#u80_input").attr("disabled", true);
			$("#u80_input").css("background-color","#E5E5E5");
			$("#u83_input").attr("disabled", true);
			$("#u83_input").css("background-color","#E5E5E5");
			$("#u86_input").attr("disabled", true);
			$("#u86_input").css("background-color","#E5E5E5");
			$("#u83_input")[0].selectedIndex = -1;
			$("#u86_input")[0].selectedIndex = -1;
		}
		//到达编辑页面时，没有选择是否转诊的，机构 科室下拉列表默认为空不选
		if(ifReferralValue==undefined){
			$("#u83_input")[0].selectedIndex = -1;
			$("#u86_input")[0].selectedIndex = -1;
		}
		

		
		//点击否关闭弹框
		$("#u0010").click(function(){
			$("#ifCloseCase").window("close");
		});
		//点击确定进行结案
		$("#u0012").click(function(){
			var closeCaseReasonValue = $("[name='closeCaseReason']:checked").val();
			if(closeCaseReasonValue==undefined){
				alert("请选择结案原因");
				return;
			}
			$("#closeCase").submit();
		});
		
		//弹出的是否打印对话框，点击是进入预览页面
		$("#u06").click(function(){
			$("#feedBack").submit();
		});
		
		
	});
	
	//点击结案按钮，进行结案（弹对话框写入结案原因）
	function closeCase(){
			showDialog_("提示","ifCloseCase","closeCase");
		}
</script>
  </head>
  <body>
  
  <div id="title">

     <!-- Unnamed (形状) -->
      <div id="u106" class="ax_形状" style="background-color:#999999;">
          <p id="u107"><span>产后访视</span></p>
      </div>


	   <c:if test="${prenatalCount!=0 && birthArchives.riskSign ==1}">
	      <div id="u148" class="ax_形状" style="background-color:#999999;cursor:pointer;" onclick="closeCase();">
	          <p id="u149"><span>结案</span></p>
	      </div>
         <!-- Unnamed (形状) -->
	      <div id="u117" class="ax_形状" style="background-color:#E9854F;cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchivesId}&archivesId=${archiveId }'">
	          <p id="u118"><span>专案记录</span></p>
	      </div>
      </c:if>
      
       <c:if test="${prenatalCount==0 && birthArchives.riskSign ==1}">
	      <div id="u117" class="ax_形状" style="background-color:#E9854F;cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchivesId}&archivesId=${archiveId }'">
	          <p id="u118"><span>专案记录</span></p>
	      </div>
      </c:if>
      
      <c:if test="${prenatalCount!=0 && birthArchives.riskSign ==0}">
	      <div id="u117" class="ax_形状" style="background-color:#999999;cursor:pointer;height: 35px;top:9px;line-height: 9px;" onclick="closeCase();">
	          <p id="u118"><span>结案</span></p>
	      </div>
      </c:if>
      
          <!-- Unnamed (形状) -->
      <div id="u113" class="ax_形状" style="background-color:#009DD9;cursor:pointer;">
          <p id="u114"><span>保存</span></p>
      </div>
      
          <!-- Unnamed (形状) -->
      <div id="u115" class="ax_形状" style="background-color:#56BB4D;cursor:pointer;">
          <p id="u116"><span>完成</span></p>
      </div>
      
   </div>   
 <!--  --------------------------------------------------------------------------------  -->     
      
      <div id="u2" class="ax_文本段落" style="border-top:#B5B5B5 solid 1px;">   
              <p id="u30"><span>检查医院：${operator.department }</span></p>
              <p id="u32"><span>检查医生：${operator.realName }</span></p>
              <c:if test="${birthArchives.referralSign != 0}">
              		 <p id="u34"><span>转诊状态：转诊</span></p>
              </c:if>
              <c:if test="${birthArchives.referralSign == 0}">
              	 <p id="u34"><span>转诊状态：本院</span></p>
              </c:if>
             
       </div>  
 
  <!--  --------------------------------------------------------------------------------  --> 
  <form id="form1" class="1" method="post"> 
   <!-- Unnamed (形状) -->
      <div id="u4" class="ax_形状" style="background-color:#009DD9;">
          <p id="u5"><span>个 人 基 本 信 息</span></p>
      </div> 
  <!--  --------------------------------------------------------------------------------  --> 
       <div> 
       	  <c:if test="${birthArchives.riskSign ==1 }">
              <p id="u14"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name } </span></p>
              <p id="u16"><span>档案编号：${archives.archivesCode }</span></p>
          </c:if> 
          <c:if test="${birthArchives.riskSign ==0 }">
              <p id="u14n"><span>姓&nbsp;&nbsp;名：${archives.name } </span></p>
              <p id="u16n"><span>档案编号：${archives.archivesCode }</span></p>
          </c:if>         
              
              <p id="u6"><span>出生日期：<fmt:formatDate value="${archives.birthday }" pattern="yyyy-MM-dd"/></span></p>
              <p id="u20"><span>联系电话：${archives.telephone }</span></p>
              <p id="u119"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
              <p id="u18"><span>孕妇年龄：${womenAge }</span></p>
              <p id="u22"><span>丈夫姓名：${archives.manName }</span></p>
              <p id="u336"><span>出院日期：<fmt:formatDate value="${childbirthBasic.leaveDate }" pattern="yyyy-MM-dd"/></span></p>
               <c:if test="${ifFalse==1 }">
              <p id="u28"><span>检查日期：<fmt:formatDate value="${postpartumExa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
              </c:if>
              <c:if test="${ifFalse==0 }">
              <p id="u28"><span>检查日期：<input type="text" id="statisticnow" name="falseCheckDate"  style="width: 150px;height: 25px;" value="<fmt:formatDate value="${postpartumExa.creatTime }" pattern="yyyyMMdd"/>"
	   	        onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" /></span></p>
              </c:if>
              <p id="u8"><span>末次月经：<fmt:formatDate value="${childbirthBasic.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
              <p id="u24"><span>丈夫年龄：${manAge }</span></p>
              <p id="u12"><span>孕&nbsp;&nbsp;周：${childbirthBasic.gestationalWeek }</span></p>
              <p id="u10"><span>预 产 期：<fmt:formatDate value="${expectedDate }" pattern="yyyy-MM-dd"/></span></p>
              <p id="u26"><span>丈夫电话：${archives.manTele }</span></p>
      </div>    
   <!--  --------------------------------------------------------------------------------  -->        
            <!-- Unnamed (形状) -->
      <div id="u36" class="ax_形状" name="foldDiv1" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv2','u39',10)">
          <p id="u37"><span>一 般 检 查</span></p>
           <p id="u39"><span>收起</span></p>
 	  </div>
      
            <!-- Unnamed (形状) -->
<!--       <div id="u38" class="ax_文本段落"> -->
<!--           <p id="u39"><span>收起</span></p> -->
<!--       </div> -->
   <!--  --------------------------------------------------------------------------------  -->    
     
    
      <input type="hidden" name="postpartumExaId" value="${postpartumExa.id}" />
      <input type="hidden" name="birthArchivesId" value="${birthArchivesId }" />
      <div id="neirong" name="foldDiv2" style="height: 225px;">
      	        <!-- Unnamed (形状) -->
          <div id="u40" class="ax_文本段落">
              <p u41><span>体温：</span></p>
          </div>
          
                <!-- Unnamed (文本框) -->
          <div id="u42" class="ax_文本框">
            <input id="u42_input" name="bodyTemperature" type="text" value="${postpartumExaDetailed.bodyTemperature }"/>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u43" class="ax_文本段落">
              <p id="u44"><span>C</span></p>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u45" class="ax_文本段落">
              <p id="u46"><span>血压：</span></p>
          </div>
          
                <!-- Unnamed (文本框) -->
          <div id="u49" class="ax_文本框">
            <input id="u49_input" name="bloodLow" type="text" value="${postpartumExaDetailed.bloodLow }"/>
          </div>
                <!-- Unnamed (形状) -->
          <div id="u50" class="ax_文本段落">
              <p id="u51"><span>/</span></p>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u52" class="ax_文本框">
            <input id="u52_input" name="bloodHi" type="text" value="${postpartumExaDetailed.bloodHi }"/>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u47" class="ax_文本段落">
              <p  id="u48"><span>mmHg</span></p>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u137" class="ax_文本段落">
              <p id="u138"><span>一般健康情况：</span></p>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u142" class="ax_文本框">
            <input id="u142_input" name="health" type="text" value="${postpartumExaDetailed.health }"/>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u139" class="ax_文本段落">
              <p id="u140"><span>一般心理状况</span><span>：</span></p>
          </div>
          
                <!-- Unnamed (文本框) -->
          <div id="u141" class="ax_文本框">
            <input id="u141_input" name="psychological" type="text" value="${postpartumExaDetailed.psychological }"/>
          </div>
          
               <!-- Unnamed (形状) -->
          <div id="u121" class="ax_文本段落">
              <p id="u122" ><span>乳房：</span></p>
          </div>
          
                <!-- Unnamed (下拉列表框) -->
	          <div id="u127" class="ax_下拉列表框">
	            <select id="u127_input" name="breast" class="test" style="width: 150px;height: 25px;">
	              <option value="0" <c:if test="${postpartumExaDetailed.breast==0 }">selected="true"</c:if>>未见异常</option>
	              <option value="1" <c:if test="${postpartumExaDetailed.breast==1 }">selected="true"</c:if>>异常</option>
	            </select>
	          </div>
        
                <!-- Unnamed (文本框) -->
          <div id="u126" class="ax_文本框">
            <input style="color: #000000" id="u126_input" type="text" class="u127_input" name="breastRemark" value="${postpartumExaDetailed.breastRemark }" />
          </div>
                <!-- Unnamed (形状) -->
          <div id="u123" class="ax_文本段落">
              <p id="u124"><span>恶露：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u134" class="ax_下拉列表框">
            <select id="u134_input" name="lochia" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaDetailed.lochia==0 }">selected="true"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaDetailed.lochia==1 }">selected="true"</c:if>>异常</option>
            </select>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u125" class="ax_文本框">
            <input style="color: #000000" id="u125_input" class="u134_input" type="text" name="lochiaRemark" value="${postpartumExaDetailed.lochiaRemark }" />
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u128" class="ax_文本段落">
              <p id="u129"><span>子宫</span><span>：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u135" class="ax_下拉列表框">
            <select id="u135_input" name="uterus" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaDetailed.uterus==0 }">selected="true"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaDetailed.uterus==1 }">selected="true"</c:if>>异常</option>
            </select>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u130" class="ax_文本框">
            <input style="color: #000000" id="u130_input" class="u135_input" type="text" name="uterusRemark" value="${postpartumExaDetailed.uterusRemark }"/>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u131" class="ax_文本段落">
              <p id="u132"><span>伤口</span><span>：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u136" class="ax_下拉列表框">
            <select id="u136_input" name="wound" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaDetailed.wound==0 }">selected="true"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaDetailed.wound==1 }">selected="true"</c:if>>异常</option>
            </select>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u133" class="ax_文本框">
            <input style="color: #000000" id="u133_input" class="u136_input" type="text" name="woundRemark" value="${postpartumExaDetailed.woundRemark }"/>
          </div>
      </div>
    
      
   <!--  --------------------------------------------------------------------------------  -->    
      
            <!-- Unnamed (形状) -->
      <div id="u144" class="ax_形状" name="foldDiv3" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv4','u147',10)">
          <p id="u145"><span>其 他</span></p>
          <p id="u147"><span>收起</span></p>
      </div>
            <!-- Unnamed (形状) -->
<!--       <div id="u146" class="ax_文本段落"> -->
<!--           <p id="u147"><span>收起</span></p> -->
<!--       </div> -->
  <!--  --------------------------------------------------------------------------------  -->     
      <div name="foldDiv4" style="height: 92px;">
                <!-- Unnamed (多行文本框) -->
          <div id="u108" class="ax_多行文本框">
            <textarea id="u108_input" name="other">${postpartumExaOther.other}</textarea>
          </div>
      </div>
  <!--  --------------------------------------------------------------------------------  -->     
            <!-- Unnamed (形状) -->
      <div id="u53" class="ax_形状" name="foldDiv5" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv6','u56',10)">
          <p id="u54"><span>分 类</span></p>
          <p id="u56"><span>收起</span></p>
      </div>
            <!-- Unnamed (形状) -->
<!--       <div id="u55" class="ax_文本段落"> -->
<!--           <p id="u56"><span>收起</span></p> -->
<!--       </div> -->
 <!--  --------------------------------------------------------------------------------  -->      
      
      <div name="foldDiv6" style="height: 43px;">
                  <!-- Unnamed (形状) -->
          <div id="u57" class="ax_文本段落">
              <p id="u58"><span>分类：</span></p>
          </div>
          
                   <!-- Unnamed (单选按钮) -->
          <div id="u59" class="ax_单选按钮">
          	 <label for="u59_input">
	             <p id="u60"><span>未见异常</span></p>
	             <input id="u59_input" type="radio" value="0" name="result" <c:if test="${postpartumExa.result==0 }">checked="checked"</c:if>/>
             </label>
             
          </div>
          
                    <!-- Unnamed (单选按钮) -->
          <div id="u61" class="ax_单选按钮">
           <label for="u61_input">
             <p id="u62"><span>&nbsp;</span><span>异常</span></p>
             <input id="u61_input" type="radio" value="1" name="result" <c:if test="${postpartumExa.result==1 }">checked="checked"</c:if>/>
           </label>
          </div>
          
                    <!-- Unnamed (文本框) -->
          <div id="u143" class="ax_文本框">
            <input  id="u143_input" type="text" name="remark" value="${postpartumExa.remark}" style="width: 150px;height: 25px;color: #000000;"/>
          </div>

      </div>
      
  <!--  --------------------------------------------------------------------------------  -->     
            <!-- Unnamed (形状) -->
      <div id="u63" class="ax_形状" name="foldDiv7" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv8','u66',10)">
          <p id="u64"><span>保 健 指 导</span></p>
          <p id="u66"><span>收起</span></p>
      </div>
            <!-- Unnamed (形状) -->
<!--       <div id="u65" class="ax_文本段落"> -->
<!--           <p id="u66"><span>收起</span></p> -->
<!--       </div> -->
  <!--  --------------------------------------------------------------------------------  -->     
      <div name="foldDiv8" style="height: 152px;">
                      <!-- Unnamed (多行文本框) -->
          <div id="u67" class="ax_多行文本框">
            <textarea id="u67_input" name="guidance">${postpartumExa.guidance }</textarea>
          </div>
      </div>
  <!--  --------------------------------------------------------------------------------  -->     
            <!-- Unnamed (形状) -->
      <div id="u68" class="ax_形状" name="foldDiv9" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv10','u71',10)">
          <p id="u69"><span>转 诊</span></p>
           <p id="u71"><span>收起</span></p>
      </div>
            <!-- Unnamed (形状) -->
<!--       <div id="u70" class="ax_文本段落"> -->
<!--           <p id="u71"><span>收起</span></p> -->
<!--       </div> -->
  <!--  --------------------------------------------------------------------------------  -->     
      <div name="foldDiv10" style="height: 30px;">
                      <!-- Unnamed (形状) -->
          <div id="u72" class="ax_文本段落">
              <p id="u73"><span>转诊：</span></p>
          </div>
          
               <!-- Unnamed (单选按钮) -->
          <div id="u74" class="ax_单选按钮">
          <label for="u74_input">
             <p id="u75"><span> 无</span></p>
             <input id="u74_input" type="radio" value="0" name="referral" <c:if test="${postpartumReferral.referral==0 }">checked="checked"</c:if>/>
           </label>
          </div>
                    <!-- Unnamed (单选按钮) -->
          <div id="u76" class="ax_单选按钮">
          <label for="u76_input">
             <p id="u77"><span>有</span></p>
             <input id="u76_input" type="radio" value="1" name="referral" <c:if test="${postpartumReferral.referral==1 }">checked="checked"</c:if>/>
          </label>
          </div>
          
                    <!-- Unnamed (形状) -->
          <div id="u78" class="ax_文本段落">
              <p id="u79"><span>原因：</span></p>
          </div>
               <!-- Unnamed (文本框) -->
          <div id="u80" class="ax_文本框">
            <input style="color: #000000" id="u80_input" type="text"  name="referralReason" value="${postpartumReferral.referralReason }"/>
          </div>
          
         <c:if test="${postpartumReferral.referral==0 ||postpartumReferral.referral==null}">
         	                <!-- Unnamed (形状) -->
          <div id="u81" class="ax_文本段落">
              <p id="u82"><span>转诊机构：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u83" class="ax_下拉列表框">
            <select id="u83_input" name="mechanism" class="test" style="width: 150px;height: 25px;">
	            <c:forEach items="${hospitals }" var="hospital">
	           	 	<option value="${hospital.id }" <c:if test="${hospital.id == postpartumReferral.mechanism }">selected="selected"</c:if>>${hospital.name }</option>
	            </c:forEach>
            </select>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u84" class="ax_文本段落">
              <p id="u85"><span>转诊科室：</span></p>
          </div>
           <!-- Unnamed (下拉列表框) -->
          <div id="u86" class="ax_下拉列表框">
                <select id="u86_input" name="department" class="test" style="width: 150px;height: 25px;">
                	<c:forEach items="${roleList }" var="role">
                		<option value="${role.id }" <c:if test="${role.id == postpartumReferral.department }">selected="selected"</c:if>>${role.name }</option>
                	</c:forEach>
                </select>
          </div>
         
         </c:if> 
         
          <c:if test="${postpartumReferral.referral==1 }">
          
                <!-- Unnamed (形状) -->
          <div id="u81" class="ax_文本段落">
              <p id="u82"><span>转诊机构：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u83" class="ax_下拉列表框">
            <select id="u83_input" name="mechanism" class="test" style="width: 150px;height: 25px;">
	            <c:forEach items="${hospitals }" var="hospital">
	           	 	<option value="${hospital.id }" <c:if test="${hospital.id == postpartumReferral.mechanism }">selected="selected"</c:if>>${hospital.name }</option>
	            </c:forEach>
            </select>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u84" class="ax_文本段落">
              <p id="u85"><span>转诊科室：</span></p>
          </div>
           <!-- Unnamed (下拉列表框) -->
          <div id="u86" class="ax_下拉列表框">
                <select id="u86_input" name="department" class="test" style="width: 150px;height: 25px;">
                	<c:forEach items="${roleList }" var="role">
                		<option value="${role.id }" <c:if test="${role.id == postpartumReferral.department }">selected="selected"</c:if>>${role.name }</option>
                	</c:forEach>
                </select>
          </div>
          
       </c:if> 
          
                <!-- Unnamed (形状) -->
          <div id="u87" class="ax_文本段落">
              <p id="u88"><span>下次随访日期：</span></p>
          </div>
                    <!-- Unnamed (下拉列表框) -->
          <div id="u89" class="ax_下拉列表框">
          	<input type="text" id="statisticnow" name="nextFollowingDate"  style="width: 150px;height: 25px;"
      	       onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" value="<fmt:formatDate value="${postpartumReferral.nextFollowingDate }" pattern="yyyyMMdd"/>"/>
          </div>
          
                    <!-- Unnamed (形状) -->
          <div id="u90" class="ax_文本段落">
              <p id="u91"><span>是否预约下次检查：</span></p>
          </div>
                <!-- Unnamed (单选按钮) -->
          <div id="u92" class="ax_单选按钮">
          <label for="u92_input">
              <p id="u93"><span> 是</span></p>
              <input id="u92_input" type="radio" value="1" name="orderCheck" <c:if test="${postpartumReferral.orderCheck==1 }">checked="checked"</c:if>/>
           </label>
          </div>
    
          <!-- Unnamed (单选按钮) -->
          <div id="u94" class="ax_单选按钮">
          <label for="u94_input">
              <p id="u95"><span> 否</span></p>
              <input id="u94_input" type="radio" value="0" name="orderCheck" <c:if test="${postpartumReferral.orderCheck==0 }">checked="checked"</c:if>/>
           </label>
          </div>
          
          
                  <!-- Unnamed (水平线) -->
          <div id="u105" class="ax_水平线">
				<hr style="border:1px dashed #B5B5B5;" />
          </div>
          
                    <!-- Unnamed (形状) -->
          <div id="u96" class="ax_文本段落">
              <p id="u97"><span>母子健康手册使用：</span></p>
          </div>
                    <!-- Unnamed (下拉列表框) -->
          <div id="u102" class="ax_下拉列表框">
            <select id="u102_input" name="healthHandbook" class="test" style="width: 150px;height: 25px;">
              <option value="1" <c:if test="${postpartumReferral.healthHandbook == 1}">selected="selected"</c:if>>是</option>
              <option value="0" <c:if test="${postpartumReferral.healthHandbook == 0}">selected="selected"</c:if>>否</option>
            </select>
          </div>
      </div>
    </form>
  <!--  --------------------------------------------------------------------------------  -->     

      
      
  <!--  --------------------------------------------------------------------------------  -->           

    
   
         <!--       是否前去打印弹出框                 -->
	
<div id="ifPrint" class="easyui-dialog" title="42天产后检查，是否前去打印" closed="true">
		   <!-- Unnamed (形状) -->
     

   	 <!-- Unnamed (形状) -->
      <div id="u08" class="ax_文本段落">
          <p><span id="u09" >访视完成！是否前去打印表格？</span></p>
      </div>
      
   <!-- Unnamed (形状) -->
      <div id="u06" class="ax_形状" style="background-color:#E9854F;cursor:pointer;">
          <p id="u07"><span>是</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u04" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="window.location.href='${ctx}/prenatal/list'">
          <p id="u05"><span>否</span></p>
      </div>
  </div>
      <!-- 到打印预览页面时，需要提交的参数 -->
      <form id="feedBack" action="${ctx }/postpartum/postpartumexainfo/postExaRecord" method="post">
      	<input type="hidden" name="archiveId" value="${archiveId }"/>
      	<input type="hidden" name="postpartumExaId" value="${postpartumExa.id}"/>
      </form>
   
   
     <!--       结案时选择结案原因                 --> 
     
   <div id="ifCloseCase" class="easyui-dialog" title="是否结案" closed="true">
		 <!-- Unnamed (形状) -->
      
         <!-- Unnamed (形状) -->
      <div id="u002" class="ax_文本段落">
          <p id="u003"><span>请选择结案原因：</span></p>
      </div>
				<form id="closeCase" action="${ctx }/postpartum/postpartumexainfo/closeCase" method="post">  
				      <!-- Unnamed (单选按钮) -->
				      <div id="u006" class="ax_单选按钮">
				        <label for="u006_input">
				            <p id="u007"><span> 失访</span></p>
				        </label>
				        <input id="u006_input" type="radio" value="失访" name="closeCaseReason"/>
				      </div>
				
				      <!-- Unnamed (单选按钮) -->
				      <div id="u008" class="ax_单选按钮">
				        <label for="u008_input">
				            <p id="u009"><span> 其他</span></p>
				        </label>
				        <input id="u008_input" type="radio" value="其他" name="closeCaseReason"/>
				      </div>
				     <!-- 点击结案时需要提交的参数（生育档案的id） -->
				      	<input type="hidden" name="birthArchivesId" value="${birthArchivesId }" />
				      </form>    
          <!-- Unnamed (形状) -->
      <div id="u0012" class="ax_形状" style="background-color:#E9854F;cursor:pointer;">
          <p id="u0013"><span>确定</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u0010" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" >
          <p id="u0011"><span>取消</span></p>
      </div>
  </div>
    
</body>
</html>
