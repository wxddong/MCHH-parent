<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>产后42天健康检查编辑</title>
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
		    -icab-text-overflow: ellipsis;  F
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
	    <link href="${ctx }/static/css/PostpartumExa42_styles.css" type="text/css" rel="stylesheet"/>
	    <link href="${ctx }/static/css/PostpartumExa42SaveEdit_styles1.css" type="text/css" rel="stylesheet"/>
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
			$("#u50").click(function(){
				$('[name="nextFollowingDate"]').attr("disabled", false);
				var path="${ctx }/postpartum/postpartumexainfo/update?save=0";
				var fromClass = $('#form1').attr("class");
				
				if(fromClass==1){
					$('#form1').attr("action", path).submit();
				}
				
				$('#form1').attr("class","0");	
			});
			
	    	//点击完成按钮向数据库中插入数据
			$("#u52").click(function(){
				
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
				
				//外阴 
				var vulvaValue = $("[name='vulva']").val();
				if(vulvaValue==null){
					alert("请选择外阴是否异常");
					return;
				}else if(vulvaValue=="1"){
					var vulvaRemarkValue = $.trim($("[name='vulvaRemark']").val());
					if(vulvaRemarkValue==""){
						alert("请输入外阴异常原因");
						return;
					}
				}
				
				//阴道
				var vaginaValue = $("[name='vagina']").val();
				if(vaginaValue==null){
					alert("请选择阴道是否异常");
					return;
				}else if(vaginaValue=="1"){
					var vaginaRemarkValue = $.trim($("[name='vaginaRemark']").val());
					if(vaginaRemarkValue==""){
						alert("请输入阴道异常原因");
						return;
					}
				}
				
				//宫颈
				var cervicalValue = $("[name='cervical']").val();
				if(cervicalValue==null){
					alert("请选择宫颈是否异常");
					return;
				}else if(cervicalValue=="1"){
					var cervicalRemarkValue = $.trim($("[name='cervicalRemark']").val());
					if(cervicalRemarkValue==""){
						alert("请输入宫颈异常原因");
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
					var reasonValue = $("[name='reason']").val();
					if(reasonValue==null){
						alert("请输入选择未恢复原因");
						return;
					}else if(reasonValue=="3"){
						var remarkValue = $.trim($("[name='remark']").val());
						if(remarkValue==""){
							alert("请输入未恢复的其他原因");
							return;
						}
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
			
			
			
			//刚加载页面时分类项有异常时显示下拉列表框，没有异常时不显示；下拉列表为其他时显示输入框，否则隐藏输入框
			var result = $('input:radio[name="result"]:checked').val();
			if(result==0){
				$("#u72_input").hide();
				$("#u56_input").hide();
			}else if(result==null){
				$("#u72_input").hide();
				$("#u72_input")[0].selectedIndex = -1;
				$("#u56_input").hide();
			}
			var reason = $("#u72_input").val();
			if(reason==0 || reason==1 || reason==2 ){
				 $("#u56_input").hide();
			}
			
			//分类默认对应的输入框不显示，点击radio标签 有异常时显示显示输入框 没异常时隐藏输入框 
			$('input:radio[name="result"]').click(function(){
				var val=$('input:radio[name="result"]:checked').val();	
				if(val==0){
					$("#u56_input").hide();
					$("#u72_input").hide()
					$("#u72_input").removeAttr("name");
					$("#u56_input").removeAttr("name");
				}else{
					$("#u72_input").show();
					$("#u72_input").attr("name","reason");
					var result1 = $("#u72_input").val();
					if(result1==3){
						$("#u56_input").show();
						$("#u56_input").attr("name","remark");
					}
				}
			});
			$("#u72_input").change(function(){
				var testValue = $(this).val();
				if(testValue==3){
					$("#u56_input").show();
					$("#u56_input").attr("name","remark");
				}else{
					$("#u56_input").hide();
					$("#u56_input").removeAttr("name");
				}
			});
			
			
			
			//点击不转诊时 原因 机构 科室 默认不可用
			$("[name='referral']").change(function(){
				var referralValue = $("[name='referral']:checked").val();
				if(referralValue=="0"){ 
					$("#u39_input").attr("disabled", true);
					$("#u39_input").css("background-color","#E5E5E5");
					$("#u42_input").attr("disabled", true);
					$("#u42_input").css("background-color","#E5E5E5");
					$("#u45_input").attr("disabled", true);
					$("#u45_input").css("background-color","#E5E5E5");
					$("#u39_input").removeAttr("name");
					$("#u39_input").removeAttr("name");
					$("#u39_input").removeAttr("name");
				}
				if(referralValue=="1"){
					$("#u39_input").attr("disabled", false);
					$("#u39_input").css("background-color","#FFFFFF");
					$("#u42_input").attr("disabled", false);
					$("#u42_input").css("background-color","#FFFFFF");
					$("#u45_input").attr("disabled", false);
					$("#u45_input").css("background-color","#FFFFFF");
					$("#u39_input").attr("name","referralReason");
					$("#u42_input").attr("name","mechanism");
					$("#u45_input").attr("name","department");
				}
			});
			
			//到达编辑页面时，无转诊的，原因 机构 科室 灰色不可点并且默认为空
			var ifReferral = $("[name='referral']:checked").val();
			if(ifReferral=="0"){
				$("#u39_input").attr("disabled", true);
				$("#u39_input").css("background-color","#E5E5E5");
				$("#u42_input").attr("disabled", true);
				$("#u42_input").css("background-color","#E5E5E5");
				$("#u45_input").attr("disabled", true);
				$("#u45_input").css("background-color","#E5E5E5");
				$("#u42_input")[0].selectedIndex = -1;
				$("#u45_input")[0].selectedIndex = -1;
			}
			//到达编辑页面时，没有选择是否转诊的， 科室下拉列表默认为空不选
			if(ifReferral==undefined){
				$("#u42_input")[0].selectedIndex = -1;
				$("#u45_input")[0].selectedIndex = -1;
			}
			
			//刚加载页面时，有异常的框显示，没异常的框不显示
			//刚加载页面时，有异常的框显示，没异常的框不显示   没选择有无异常的情况下默认为空
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
			
			var vulva = "${postpartumExaOther.vulva}";
			if(vulva==0){
				$("[name='vulvaRemark']").hide();
			}
			if(vulva==""){
				$("[name='vulvaRemark']").hide();
				$("[name='vulva']")[0].selectedIndex = -1;
			}
			var vagina = "${postpartumExaOther.vagina}";
			if(vagina==0){
				$("[name='vaginaRemark']").hide();
			}
			if(vagina==""){
				$("[name='vaginaRemark']").hide();
				$("[name='vagina']")[0].selectedIndex = -1;
			}
			var cervical = "${postpartumExaOther.cervical}";
			if(cervical==0){
				$("[name='cervicalRemark']").hide();
			}
		    if(cervical==""){
				$("[name='cervicalRemark']").hide();
				$("[name='cervical']")[0].selectedIndex = -1;
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
      <div id="u81" class="ax_形状" style="background-color:#999999;">
          <p id="u82"><span>产后42天健康检查</span></p>
      </div>
      
      <c:if test="${prenatalCount!=0 && birthArchives.riskSign ==1}">
	            <!-- Unnamed (形状) -->
	      <div id="u77" class="ax_形状" style="background-color:#999999;cursor:pointer;" onclick="closeCase();">
	          <p id="u78"><span>结案</span></p>
	      </div>
	            <!-- Unnamed (形状) -->
	      <div id="u54" class="ax_形状" style="background-color:#EE5F45;cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchivesId}&archivesId=${archiveId }'">
	          <p id="u55"><span>专案记录</span></p>
	      </div>
     </c:if>
     
     <c:if test="${prenatalCount==0 && birthArchives.riskSign ==1}">
	            <!-- Unnamed (形状) -->
	      <div id="u54" class="ax_形状" style="background-color:#EE5F45;cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchivesId}&archivesId=${archiveId }'">
	          <p id="u55"><span>专案记录</span></p>
	      </div>
     </c:if>
     
     <c:if test="${prenatalCount!=0 && birthArchives.riskSign ==0}">
	            <!-- Unnamed (形状) -->
	      <div id="u54" class="ax_形状" style="background-color:#999999;cursor:pointer;height: 35px;top:9px;line-height: 9px; " onclick="closeCase();">
	          <p id="u55"><span>结案</span></p>
	      </div>
     </c:if>
     
     
     <!-- Unnamed (形状) -->
      <div id="u50" class="ax_形状" style="background-color:#009DD9;cursor:pointer;">
          <p id="u51"><span>保存</span></p>
      </div>

	      <!-- Unnamed (形状) -->
      <div id="u52" class="ax_形状" style="background-color:#56BB4D;cursor:pointer;">
          <p id="u53"><span>完成</span></p>
      </div>
 </div>     
      <div id="u0" class="ax_文本段落" style="border-top:#B5B5B5 solid 1px;">
      </div>
      
<!--        <div id="u002" class="ax_文本段落" style="border-top:#B5B5B5 solid 1px;">   -->
          <p id="u6"><span>检查医院：${operator.department }</span></p>
          <p id="u8"><span>检查医生：${operator.realName }</span></p>
           <c:if test="${birthArchives.referralSign != 0}">
              		 <p id="u10"><span>转诊状态：转诊</span></p>
              </c:if>
              <c:if test="${birthArchives.referralSign == 0}">
              	 <p id="u10"><span>转诊状态：本院</span></p>
              </c:if>
<!--        </div> -->
              
     

<!-- ------------------------------------------------------------------------------------------------ -->
<form id="form1" class="1" action="${ctx }/postpartum/postpartumexainfo/add?days=42&save=1" method="post">
	      <!-- Unnamed (形状) -->
      <div id="u83" class="ax_形状" style="background-color:#009DD9;">
          <p id="u84"><span>个 人 基 本 信 息</span></p>
      </div>
		
      <div>
		  <c:if test="${birthArchives.riskSign ==1 }">
              <p id="u93" ><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name } </span></p>
              <p id="u95"><span>档案编号：${archives.archivesCode }</span></p>
          </c:if> 
         <c:if test="${birthArchives.riskSign ==0 }">
              <p id="u93n"><span>姓&nbsp;&nbsp;名：${archives.name } </span></p>
              <p id="u95n"><span>档案编号：${archives.archivesCode }</span></p>
          </c:if> 
              <p id="u85"><span>出生日期：<fmt:formatDate value="${archives.birthday }" pattern="yyyy-MM-dd"/></span></p>
              <p id="u99"><span>联系电话：${archives.telephone }</span></p>
              <p id="u121"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
              <p id="u97"><span>孕妇年龄：${womenAge }</span></p>
              <p id="u101"><span>丈夫姓名：${archives.manName }</span></p>
              <p id="u345"><span>出院日期：<fmt:formatDate value="${childbirthBasic.leaveDate }" pattern="yyyy-MM-dd"/></span></p>
               <c:if test="${ifFalse==1 }">
              <p id="u107"><span>检查日期：<fmt:formatDate value="${postpartumExa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
              </c:if>
               <c:if test="${ifFalse==0 }">
              <p id="u107"><span>检查日期：<input type="text" id="statisticnow" name="falseCheckDate"  style="width: 150px;height: 25px;" value="<fmt:formatDate value="${postpartumExa.creatTime }" pattern="yyyyMMdd"/>"
	   	        onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" class="Wdate" /></span></p>
              </c:if>
              <p id="u87"><span>末次月经：<fmt:formatDate value="${childbirthBasic.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
              <p id="u103"><span>丈夫年龄：${manAge }</span></p>
              <p id="u91"><span>孕&nbsp;&nbsp;周：${childbirthBasic.gestationalWeek }</span></p>
              <p id="u89"><span>预 产 期：<fmt:formatDate value="${expectedDate }" pattern="yyyy-MM-dd"/></span></p>
              <p id="u105"><span>丈夫电话：${archives.manTele }</span></p>
      </div>  


<!-- ------------------------------------------------------------------------------------------------ -->        
       <!-- Unnamed (形状) -->
      <div id="u109" class="ax_形状" name="foldDiv1" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv2','u112',10)">
          <p id="u110"><span>一 般 检 查</span></p>
           <p id="u112"><span>收起</span></p>
      </div>       
                     <!-- Unnamed (形状) -->
<!--       <div id="u111" class="ax_文本段落"> -->
<!--           <p id="u112"><span>收起</span></p> -->
<!--       </div> -->
      
    <input type="hidden" name="postpartumExaId" value="${postpartumExa.id}" />  
    <input type="hidden" name="birthArchivesId" value="${birthArchivesId }" />
    <input type="hidden" name="nextFollowingDate" />
      <div name="foldDiv2" style="height: 221px;">
                <!-- Unnamed (形状) -->
          <div id="u113" class="ax_文本段落">
              <p id="u114"><span>血压</span><span>：</span></p>
          </div>
          
                <!-- Unnamed (文本框) -->
          <div id="u117" class="ax_文本框">
            <input id="u117_input" type="text" name="bloodLow" value="${postpartumExaDetailed.bloodLow }"/>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u118" class="ax_文本段落">
              <p id="u119"><span>/</span></p>
          </div>
          
               <!-- Unnamed (文本框) -->
          <div id="u120" class="ax_文本框">
            <input id="u120_input" type="text" name="bloodHi" value="${postpartumExaDetailed.bloodHi }"/>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u115" class="ax_文本段落">
              <p id="u116"><span>mmHg</span></p>
          </div>
      
                <!-- Unnamed (形状) -->
          <div id="u139" class="ax_文本段落">
              <p id="u140"><span>一般健康情况</span><span>：</span></p>
          </div>
          
                <!-- Unnamed (文本框) -->
          <div id="u144" class="ax_文本框">
            <input id="u144_input" type="text" name="health" value="${postpartumExaDetailed.health }"/>
          </div>
                <!-- Unnamed (形状) -->
          <div id="u141" class="ax_文本段落">
              <p id="u142"><span>一般心理状况</span><span>：</span></p>
          </div>
          
                <!-- Unnamed (文本框) -->
          <div id="u143" class="ax_文本框">
            <input id="u143_input" type="text" name="psychological" value="${postpartumExaDetailed.psychological }"/>
          </div>
      
          <!-- Unnamed (形状) -->
          <div id="u123" class="ax_文本段落">
              <p id="u124" ><span>乳房：</span></p>
          </div>
          
                <!-- Unnamed (下拉列表框) -->
          <div id="u129" class="ax_下拉列表框">
            <select id="u129_input" name="breast" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaDetailed.breast==0 }">selected="true"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaDetailed.breast==1 }">selected="true"</c:if>>异常</option>
            </select>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u128" class="ax_文本框">
            <input style="color: #000000" id="u128_input" type="text" class="u129_input" name="breastRemark" value="${postpartumExaDetailed.breastRemark }"/>
          </div>
                <!-- Unnamed (形状) -->
          <div id="u125" class="ax_文本段落">
              <p id="u126"><span>恶露：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u136" class="ax_下拉列表框">
            <select id="u136_input" name="lochia" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaDetailed.lochia==0 }">selected="true"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaDetailed.lochia==1 }">selected="true"</c:if>>异常</option>
            </select>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u127" class="ax_文本框">
            <input style="color: #000000" id="u127_input" class="u136_input" type="text" name="lochiaRemark" value="${postpartumExaDetailed.lochiaRemark }"/>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u130" class="ax_文本段落">
              <p id="u131"><span>子宫</span><span>：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u137" class="ax_下拉列表框">
            <select id="u137_input" name="uterus" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaDetailed.uterus==0 }">selected="true"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaDetailed.uterus==1 }">selected="true"</c:if>>异常</option>
            </select>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u132" class="ax_文本框">
            <input style="color: #000000" id="u132_input" class="u137_input" type="text" name="uterusRemark" value="${postpartumExaDetailed.uterusRemark }"/>
          </div>
          
                <!-- Unnamed (形状) -->
          <div id="u133" class="ax_文本段落">
              <p id="u134"><span>伤口</span><span>：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u138" class="ax_下拉列表框">
            <select id="u138_input" name="wound" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaDetailed.wound==0 }">selected="true"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaDetailed.wound==1 }">selected="true"</c:if>>异常</option>
            </select>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u135" class="ax_文本框">
            <input style="color: #000000" id="u135_input" class="u138_input" type="text" name="woundRemark" value="${postpartumExaDetailed.woundRemark }"/>
          </div>
  
      </div>
      
 <!-- ------------------------------------------------------------------------------------------------ -->          
        
          <!-- Unnamed (形状) -->
      <div id="u145" class="ax_形状" name="foldDiv3" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv4','u148',10)">
          <p id="u146"><span>其</span><span>&nbsp;</span><span>他</span></p>
          <p id="u148"><span>收起</span></p>
      </div>  
      
            <!-- Unnamed (形状) -->
<!--       <div id="u147" class="ax_文本段落"> -->
<!--           <p id="u148"><span>收起</span></p> -->
<!--       </div>   -->
        
        
     <div name="foldDiv4" style="height: 216px;">
     		
                          <!-- Unnamed (形状) -->
              <div id="u58" class="ax_文本段落">
                  <p id="u59"><span>外阴：</span></p>
              </div>
                    <!-- Unnamed (下拉列表框) -->
          <div id="u64" class="ax_下拉列表框">
            <select id="u64_input" name="vulva" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaOther.vulva==0 }">selected="selected"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaOther.vulva==1 }">selected="selected"</c:if>>异常</option>
            </select>
          </div>
              <!-- Unnamed (文本框) -->
          <div id="u63" class="ax_文本框">
            <input style="color: #000000" id="u63_input" type="text" class="u64_input" name="vulvaRemark" value="${postpartumExaOther.vulvaRemark }"/>
          </div>
                <!-- Unnamed (形状) -->
          <div id="u60" class="ax_文本段落">
              <p id="u61"><span>阴道：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u68" class="ax_下拉列表框">
            <select id="u68_input" name="vagina" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaOther.vagina==0 }">selected="selected"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaOther.vagina==1 }">selected="selected"</c:if>>异常</option>
            </select>
          </div>
                <!-- Unnamed (文本框) -->
          <div id="u62" class="ax_文本框">
            <input style="color: #000000" id="u62_input" type="text" class="u68_input" name="vaginaRemark" value="${postpartumExaOther.vaginaRemark }"/>
          </div>
                <!-- Unnamed (形状) -->
          <div id="u65" class="ax_文本段落">
              <p id="u66"><span>宫颈：</span></p>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u69" class="ax_下拉列表框">
            <select id="u69_input" name="cervical" class="test" style="width: 150px;height: 25px;">
              <option value="0" <c:if test="${postpartumExaOther.cervical==0 }">selected="selected"</c:if>>未见异常</option>
              <option value="1" <c:if test="${postpartumExaOther.cervical==1 }">selected="selected"</c:if>>异常</option>
            </select>
          </div>
      
          <!-- Unnamed (文本框) -->
          <div id="u67" class="ax_文本框">
            <input style="color: #000000" id="u67_input" type="text" class="u69_input" name="cervicalRemark" value="${postpartumExaOther.cervicalRemark }"/>
          </div>
                <!-- Unnamed (形状) -->
          <div id="u70" class="ax_文本段落">
              <p id="u71"><span>其他：</span></p>
          </div>
                <!-- Unnamed (多行文本框) -->
          <div id="u57" class="ax_多行文本框">
            <textarea id="u57_input"  name="other">${postpartumExaOther.other}</textarea>
          </div>
    
     </div>   
        
 <!-- ----------------------------------------------------------------------------------------------- -->         
    
      <!-- Unnamed (形状) -->
      <div id="u12" class="ax_形状" name="foldDiv5" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv6','u15',10)">
          <p id="u13"><span>分类</span></p>
           <p id="u15"><span>收起</span></p>
      </div>    
        
             <!-- Unnamed (形状) -->
<!--       <div id="u14" class="ax_文本段落"> -->
<!--           <p id="u15"><span>收起</span></p> -->
<!--       </div> -->
      
      
      <div name="foldDiv6" style="height: 53px;">
      
          <!-- Unnamed (形状) -->
              <div id="u16" class="ax_文本段落">
                  <p id="u17"><span>分类：</span></p>
              </div> 
                <!-- Unnamed (单选按钮) -->
          <div id="u18" class="ax_单选按钮">
            <label for="u18_input">
                <p id="u19"><span>已恢复</span></p>
            </label>
            <input id="u18_input" type="radio" value="0" name="result" <c:if test="${postpartumExa.result==0 }">checked="checked"</c:if>/>
          </div>     
                    <!-- Unnamed (单选按钮) -->
          <div id="u20" class="ax_单选按钮">
            <label for="u20_input">
                <p id="u21"><span>&nbsp;</span><span>未恢复</span></p>
            </label>
            <input id="u20_input" type="radio" value="1" name="result" <c:if test="${postpartumExa.result==1 }">checked="checked"</c:if>/>
          </div>
                <!-- Unnamed (下拉列表框) -->
          <div id="u72" class="ax_下拉列表框">
            <select id="u72_input" name="reason" class="test">
              <option value="0" <c:if test="${postpartumExa.reason==0 }">selected="selected"</c:if>>产褥感染</option>
              <option value="1" <c:if test="${postpartumExa.reason==1 }">selected="selected"</c:if>>晚期产后出血</option>
              <option value="2" <c:if test="${postpartumExa.reason==2 }">selected="selected"</c:if>>产褥期抑郁症</option>
              <option value="3" <c:if test="${postpartumExa.reason==3 }">selected="selected"</c:if>>其他</option>
            </select>
          </div>
          
          <!-- Unnamed (文本框) -->
          <div id="u56" class="ax_文本框">
            <input  id="u56_input" type="text"  name="remark" value="${postpartumExa.remark }" style="width: 150px;height: 25px;color: #000000;"/>
          </div>
   
      </div>
 
   <!-- ----------------------------------------------------------------------------------------------- -->        
           <!-- Unnamed (形状) -->
      <div id="u22" class="ax_形状" name="foldDiv7" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv8','u25',10)">
          <p id="u23"><span>保 健 指 导</span></p>
          <p id="u25"><span>收起</span></p>
      </div>
      
      <!-- Unnamed (形状) -->
<!--       <div id="u24" class="ax_文本段落"> -->
<!--           <p id="u25"><span>收起</span></p> -->
<!--       </div> -->
      
      
      
      <div name="foldDiv8" style="height: 147px;">
          <!-- Unnamed (多行文本框) -->
          <div id="u26" class="ax_多行文本框">
            <textarea id="u26_input" name="guidance">${postpartumExa.guidance }</textarea>
          </div>
      </div>
   
     <!-- ----------------------------------------------------------------------------------------------- -->        
        
             <!-- Unnamed (形状) -->
      <div id="u27" name="foldDiv9" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv10','u30',10)">
          <p id="u28"><span>处 理</span></p>
           <p id="u30"><span>收起</span></p>
      </div> 
              <!-- Unnamed (形状) -->
<!--       <div id="u29" class="ax_文本段落"> -->
<!--           <p id="u30"><span>收起</span></p> -->
<!--       </div> -->
        
	
      <div name="foldDiv10" style="height: 30px;">
        	      <!-- Unnamed (形状) -->
          <div id="u73" class="ax_文本段落">
              <p id="u74"><span>结案</span><span>：</span></p>
          </div>
               <!-- Unnamed (单选按钮) -->
          <div id="u75" class="ax_单选按钮">
            <label for="u75_input">
                <p id="u76"><span>是</span></p>
            </label>
            <input id="u75_input" type="radio" value="1" name="closeCase" checked="checked"/>
          </div> 
          <div id="u75f" class="ax_单选按钮">
            <label for="u75f_input">
                <p id="u76f"><span>否</span></p>
            </label>
            <input id="u75f_input" type="radio" value="0" name="closeCase" checked="checked"/>
          </div> 
                        
                  <!-- Unnamed (形状) -->
          <div id="u31" class="ax_文本段落">
              <p id="u32"><span>转诊</span><span>：</span></p>
          </div>
        
                  <!-- Unnamed (单选按钮) -->
          <div id="u33" class="ax_单选按钮">
            <label for="u33_input">
                <p id="u34"><span> 无</span></p>
            </label>
            <input id="u33_input" type="radio" value="0" name="referral" <c:if test="${postpartumReferral.referral==0 }">checked="checked"</c:if>/>
          </div>
                  <!-- Unnamed (单选按钮) -->
          <div id="u35" class="ax_单选按钮">
            <label for="u35_input">
                <p id="u36"><span> 有</span></p>
            </label>
            <input id="u35_input" type="radio" value="1" name="referral" <c:if test="${postpartumReferral.referral==1 }">checked="checked"</c:if>/>
          </div>
                 <!-- Unnamed (形状) -->
          <div id="u37" class="ax_文本段落">
              <p id="u38"><span>原因：</span></p>
          </div>
     
                <!-- Unnamed (文本框) -->
          <div id="u39" class="ax_文本框">
            <input style="color: #000000" id="u39_input" type="text" name="referralReason" value="${postpartumReferral.referralReason }"/>
          </div>
          
    <c:if test="${postpartumReferral.referral==0 ||postpartumReferral.referral==null}">
    		             <!-- Unnamed (形状) -->
          <div id="u40" class="ax_文本段落">
              <p id="u41"><span>转诊机构：</span></p>
          </div> 
                <!-- Unnamed (下拉列表框) -->
          <div id="u42" class="ax_下拉列表框">
            <select id="u42_input" name="mechanism" class="test" style="width: 150px;height: 25px;">
            	 <c:forEach items="${hospitals }" var="hospital">
	           	 	<option value="${hospital.id }">${hospital.name }</option>
	            </c:forEach>
            </select>
          </div>  
                  <!-- Unnamed (形状) -->
          <div id="u43" class="ax_文本段落">
              <p id="u44"><span>转诊科室：</span></p>
          </div>
                  <!-- Unnamed (下拉列表框) -->
          <div id="u45" class="ax_下拉列表框">
            <select id="u45_input" name="department" class="test" style="width: 150px;height: 25px;">
            	<c:forEach items="${roleList }" var="role">
                	<option value="${role.id }">${role.name }</option>
                </c:forEach>
            </select>
          </div>
    </c:if>   
    <c:if test="${postpartumReferral.referral==1 }">
                 <!-- Unnamed (形状) -->
          <div id="u40" class="ax_文本段落">
              <p id="u41"><span>转诊机构：</span></p>
          </div> 
                <!-- Unnamed (下拉列表框) -->
          <div id="u42" class="ax_下拉列表框">
            <select id="u42_input" name="mechanism" class="test" style="width: 150px;height: 25px;">
            	 <c:forEach items="${hospitals }" var="hospital">
	           	 	<option value="${hospital.id }" <c:if test="${hospital.id == postpartumReferral.mechanism }">selected="selected"</c:if>>${hospital.name }</option>
	            </c:forEach>
            </select>
          </div>  
                  <!-- Unnamed (形状) -->
          <div id="u43" class="ax_文本段落">
              <p id="u44"><span>转诊科室：</span></p>
          </div>
                  <!-- Unnamed (下拉列表框) -->
          <div id="u45" class="ax_下拉列表框">
            <select id="u45_input" name="department" class="test" style="width: 150px;height: 25px;">
            	<c:forEach items="${roleList }" var="role">
                	<option value="${role.id }" <c:if test="${role.id == postpartumReferral.department }">selected="selected"</c:if>>${role.name }</option>
                </c:forEach>
            </select>
          </div>
          
      </c:if>  
      
       <div id="u1051" class="ax_水平线">
				<hr style="border:1px dashed #B5B5B5;" />
          </div>      
            
                  <!-- Unnamed (形状) -->
          <div id="u46" class="ax_文本段落">
              <p id="u47"><span>母子健康手册使用：</span></p>
          </div>
            
            
          <!-- Unnamed (下拉列表框) -->
          <div id="u48" class="ax_下拉列表框">
            <select id="u48_input" name="healthHandbook" class="test" style="width: 150px;height: 25px;">
              <option value="1" <c:if test="${postpartumReferral.healthHandbook == 1}">selected="selected"</c:if>>是</option>
              <option value="0" <c:if test="${postpartumReferral.healthHandbook == 0}">selected="selected"</c:if>>否</option>
            </select>
          </div>
 
       </div>

 </form>

     <!-- ----------------------------------------------------------------------------------------------- -->  

      
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
      	 <input type="hidden" name="postpartumExaId" value="${postpartumExa.id}" />
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
