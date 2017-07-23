<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="basePath" value="<%=basePath%>" /> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>0女性婚前医学检查表</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/prove-styles.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${ctx}/static/common/js/jquery.jqprint-0.3.js"></script>
   </head>
   <script type="text/javascript">
	
	$(function(){
		  
		  var listUrl = "${ctx}/archivesinfo/list";  
		  
		  //关闭
		  $("#u200").click(function(){
			  
			  window.location.href=listUrl;
	 			
		  })
		  
		  //打印
		  $("#u4").click(function(){
			  
			  var arr = $("#womanProve").children("div");
			   for(var i = 0; i <arr.length; i++){
				   var left = arr[i].offsetLeft;
				   arr[i].style.left = (left - 170)+"px";
			   }
			   $("#womanProve").jqprint();
			   for(var i = 0; i <arr.length; i++){
				   var left = arr[i].offsetLeft;
				   arr[i].style.left = (left + 170)+"px";
			   }
		  })
		  
	})
	</script>

  <body>
      <div id="base" class="">

	<!-- Unnamed (形状) -->
      <div id="u2" class="ax_形状" style="background-color:#EE5F45">
        
          <p id="u3"><span>婚前医学检查证明</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u4" class="ax_形状" style="background-color:#56BB4D;cursor:pointer">
        
          <p id="u5"><span>立即打印</span></p>
        
      </div>
      
      <div id="u200" class="ax_形状" style="background-color:#EE5F45;cursor:pointer">
        
          <p id="u201"><span>关闭</span></p>
        
      </div>
	<div id = "womanProve">
      <!-- Unnamed (形状) -->
      <div id="u6" class="ax_文本段落">
        
          <p id="u7"><span>婚前医学检查证明</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u8" class="ax_形状" style="border: 1px solid #cccccc;">
        
        <!-- Unnamed () -->
        <div id="u9" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u10" class="ax_文本段落">
        
          <p id="u11"><span>编号：${archivesInfoDetail.archivesInfo.archivesCode }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u12" class="ax_文本段落">
        
          <p id="u13"><span>河南省南阳市镇平县</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u14" class="ax_水平线">
        
        <img id="u14_end" class="img " src="${ctx}/static/images/transparent.gif" alt="u14_end"/>
        
      </div>

      <!-- Unnamed (Image) -->
      <div id="u15" class="ax_image">
        
          <p id="u16"><span>&nbsp;</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u17" class="ax_文本段落">
        
          <p id="u18"><span>姓名</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u19" class="ax_垂直线">
        
        <img id="u19_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u19_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u20" class="ax_文本段落">
        
          <p id="u21"><span>${archivesInfoDetail.archivesInfo.name }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u22" class="ax_文本段落">
        
          <p id="u23"><span>性别</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u24" class="ax_垂直线">
        
        <img id="u24_line" class="img " src="${ctx}/static/images/u24_line.png" alt="u24_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u25" class="ax_垂直线">
        
        <img id="u25_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u25_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u26" class="ax_文本段落">
        
          <p id="u27"><span>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex == '1'}">
          			男
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex == '0'}">
          			女
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex == '2'}">
          			性别不明
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u28" class="ax_垂直线">
        
        <img id="u28_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u28_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u29" class="ax_文本段落">
        
          <p id="u30"><span>出生日期</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u37" class="ax_文本段落">
        
          <p id="u38"><span>${archivesInfoDetail.birthday }</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u31" class="ax_垂直线">
        
        <img id="u31_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u31_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u32" class="ax_垂直线">
        
        <img id="u32_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u32_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u33" class="ax_垂直线">
        
        <img id="u33_line" class="img " src="${ctx}/static/images/u33_line.png" alt="u33_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u34" class="ax_垂直线">
        
        <img id="u34_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u34_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u35" class="ax_文本段落">
        
          <p id="u36"><span>民族</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u39" class="ax_文本段落">
        
          <p id="u40"><span>${archivesInfoDetail.archivesInfo.nation }</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u41" class="ax_水平线">
        
        <img id="u41_line" class="img " src="${ctx}/static/images/u41_line.png" alt="u41_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u42" class="ax_文本段落">
        
          <p id="u43"><span>身</span><span>&nbsp; </span><span>份</span><span>&nbsp; </span><span>证</span><span>&nbsp; </span><span>号</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u44" class="ax_文本段落">
        
          <p id="u45"><span>${archivesInfoDetail.archivesInfo.idNo }</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u46" class="ax_水平线">
        
        <img id="u46_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u46_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u47" class="ax_文本段落">
        
          <p id="u48"><span>单位或职业</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u53" class="ax_文本段落">
        
          <p id="u54"><span>${archivesInfoDetail.archivesInfo.workUnit }</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u49" class="ax_垂直线">
        
        <img id="u49_line" class="img " src="${ctx}/static/images/u49_line.png" alt="u49_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u50" class="ax_垂直线">
        
        <img id="u50_line" class="img " src="${ctx}/static/images/u49_line.png" alt="u50_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u51" class="ax_文本段落">
        
          <p id="u52"><span>对方姓名</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u55" class="ax_文本段落">
        
          <p id="u56"><span>${archivesInfoDetail.archivesInfo.manName }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u57" class="ax_文本段落">
        
          <p id="u58"><span>现</span><span>&nbsp; </span><span>住</span><span>&nbsp; </span><span>址</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u59" class="ax_水平线">
        
        <img id="u59_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u59_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u60" class="ax_文本段落">
        
          <p id="u61"><span>${archivesInfoDetail.provinceInfo1.name }</span>
          			  <span>${archivesInfoDetail.cityInfo1.name }</span>
          			  <span>${archivesInfoDetail.districtAndCountyInfo1.name }</span>
          			  <span>${archivesInfoDetail.townshipInfo1.name }</span>
          			  <span>${archivesInfoDetail.villageInfo1.name }</span>
          			  <span>${archivesInfoDetail.archivesInfo.homeAddress }</span>
          </p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u62" class="ax_水平线">
        
        <img id="u62_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u62_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u63" class="ax_文本段落">
        
          <p id="u64"><span>直系、三代内旁系血亲关系</span></p>
        
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u65" class="ax_单选按钮">
        <label for="u65_input">
          
            <p id="u66"><span>无</span></p>
          
        </label>
        <input id="u65_input" type="radio" value="radio"
        		<c:if test="${archivesInfoDetail.health.kinship == '0'}">
          			checked = "checked"
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship == '4'}">
          			checked = "checked"
          		</c:if> name="u65"/>
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u67" class="ax_单选按钮">
        <label for="u67_input">
          
            <p id="u68"><span>有</span></p>
          
        </label>
        <input id="u67_input" type="radio" value="radio"
        		<c:if test="${archivesInfoDetail.health.kinship == '1'}">
          			checked = "checked"
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship == '2'}">
          			checked = "checked"
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship == '3'}">
          			checked = "checked"
          		</c:if> name="u67"/>
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u69" class="ax_水平线">
        
        <img id="u69_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u69_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u70" class="ax_文本段落">
        
          <p id="u68"><span>婚前医学检查结果：</span><span>
          		<c:if test="${archivesInfoDetail.inspection.checkResult == '0'}">
          			未见异常
          		</c:if>
          		<c:if test="${archivesInfoDetail.inspection.checkResult == '1'}">
          			${archivesInfoDetail.inspection.diseaseDiagnosis }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u72" class="ax_水平线">
        
        <img id="u72_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u72_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u73" class="ax_文本段落">
        
          <p id="u74"><span>医学意见：</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u75" class="ax_文本段落">
        
          <p id="u76"><span>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '0'}">
          		  	未发现医学上不宜结婚的情形
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '1'}">
		          	建议暂缓结婚
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '2'}">
		          	建议不宜生育
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '3'}">
		          	建议不宜结婚
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '4'}">
		          	建议采取医学措施，尊重受检者意愿
          	</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u77" class="ax_文本段落">
        
          <p id="u78"><span>主检医师签字</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u79" class="ax_垂直线">
        
        <img id="u79_line" class="img " src="${ctx}/static/images/u79_line.png" alt="u79_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u80" class="ax_垂直线">
        
        <img id="u80_line" class="img " src="${ctx}/static/images/u79_line.png" alt="u80_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u81" class="ax_垂直线">
        
        <img id="u81_line" class="img " src="${ctx}/static/images/u79_line.png" alt="u81_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u82" class="ax_文本段落">
        
          <p id="u83"><span>检查单位专用章</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u84" class="ax_文本段落">
        
          <p id="u85"><span>注：1、本证明有效期为三个月&nbsp; &nbsp;&nbsp; 2、对上述结果如有异议，可申请医学技术鉴定。此联交婚姻登记部门</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u86" class="ax_文本段落">
        
          <p id="u87"><span>${archivesInfoDetail.creatTime }</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u88" class="ax_水平线">
        
        <hr>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u89" class="ax_文本段落">
        
          <p id="u90"><span>婚前医学检查证明</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u91" class="ax_形状" style="border: 1px solid #cccccc;">
        
          <p id="u92"><span>&nbsp;</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u93" class="ax_文本段落">
        
          <p id="u94"><span>编号：${archivesInfoDetail.archivesInfo.archivesCode }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u95" class="ax_文本段落">
        
          <p id="u96"><span>河南省南阳市镇平</span><span>县</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u97" class="ax_水平线">
        
        <img id="u97_line" class="img " src="${ctx}/static/images/u14_line.png" alt="u97_line"/>
      </div>
      
      <!-- Unnamed (水平线) -->
      <div id="u971" class="ax_水平线">
        
        <img id="u97_line" class="img " src="${ctx}/static/images/u14_line.png" alt="u97_line"/>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u98" class="ax_image">
        
          <p id="u99"><span>&nbsp;</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u100" class="ax_文本段落">
        
          <p id="u101"><span>姓名</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u102" class="ax_垂直线">
        
        <img id="u102_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u102_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u103" class="ax_文本段落">
        
          <p id="u104"><span>${archivesInfoDetail.archivesInfo.name }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u105" class="ax_文本段落">
        
          <p id="u106"><span>性别</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u107" class="ax_垂直线">
        
        <img id="u107_line" class="img " src="${ctx}/static/images/u24_line.png" alt="u107_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u108" class="ax_垂直线">
        
        <img id="u108_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u108_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u109" class="ax_文本段落">
        
          <p id="u110"><span>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex == '1'}">
          			男
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex == '0'}">
          			女
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex == '2'}">
          			性别不明
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u111" class="ax_垂直线">
        
        <img id="u111_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u111_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u112" class="ax_文本段落">
        
          <p id="u113"><span>出生日期</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u114" class="ax_垂直线">
        
        <img id="u114_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u114_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u115" class="ax_垂直线">
        
        <img id="u115_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u115_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u116" class="ax_垂直线">
        
        <img id="u116_line" class="img " src="${ctx}/static/images/u33_line.png" alt="u116_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u117" class="ax_垂直线">
        
        <img id="u117_line" class="img " src="${ctx}/static/images/u19_line.png" alt="u117_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u118" class="ax_文本段落">
        
          <p id="u119"><span>民族</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u120" class="ax_文本段落">
        
          <p id="u121"><span>${archivesInfoDetail.birthday }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u122" class="ax_文本段落">
        
          <p id="u123"><span>${archivesInfoDetail.archivesInfo.nation }</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u124" class="ax_水平线">
        
        <img id="u124_line" class="img " src="${ctx}/static/images/u41_line.png" alt="u124_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u125" class="ax_文本段落">
        
          <p id="u126"><span>身</span><span>&nbsp; </span><span>份</span><span>&nbsp; </span><span>证</span><span>&nbsp; </span><span>号</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u127" class="ax_文本段落">
        
          <p id="u128"><span>${archivesInfoDetail.archivesInfo.idNo }</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u129" class="ax_水平线">
        
        <img id="u129_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u129_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u130" class="ax_文本段落">
        
          <p id="u131"><span>单位或职业</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u132" class="ax_垂直线">
        
        <img id="u132_line" class="img " src="${ctx}/static/images/u49_line.png" alt="u132_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u133" class="ax_垂直线">
        
        <img id="u133_line" class="img " src="${ctx}/static/images/u49_line.png" alt="u133_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u134" class="ax_文本段落">
        
          <p id="u135"><span>对方姓名</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u136" class="ax_文本段落">
        
          <p id="u137"><span>${archivesInfoDetail.archivesInfo.workUnit }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u138" class="ax_文本段落">
        
          <p id="u139"><span>${archivesInfoDetail.archivesInfo.manName }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u140" class="ax_文本段落">
        
          <p id="u141"><span>现</span><span>&nbsp; </span><span>住</span><span>&nbsp; </span><span>址</span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u142" class="ax_水平线">
        
        <img id="u142_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u142_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u143" class="ax_文本段落">
        
          <p id="u144">
          		  <span>${archivesInfoDetail.provinceInfo1.name }</span>
      			  <span>${archivesInfoDetail.cityInfo1.name }</span>
      			  <span>${archivesInfoDetail.districtAndCountyInfo1.name }</span>
      			  <span>${archivesInfoDetail.townshipInfo1.name }</span>
      			  <span>${archivesInfoDetail.villageInfo1.name }</span>
      			  <span>${archivesInfoDetail.archivesInfo.homeAddress }</span>
          </p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u145" class="ax_水平线">
        
        <img id="u145_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u145_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u146" class="ax_文本段落">
        
          <p id="u147"><span>直系、三代内旁系血亲关系</span></p>
        
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u148" class="ax_单选按钮">
        <label for="u148_input">
          
            <p id="u149"><span>无</span></p>
          
        </label>
        <input id="u148_input" type="radio" value="radio"
        		<c:if test="${archivesInfoDetail.health.kinship == '0'}">
          			checked = "checked"
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship == '4'}">
          			checked = "checked"
          		</c:if> name="u148"/>
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u150" class="ax_单选按钮">
        <label for="u150_input">
          
            <p id="u151"><span>有</span></p>
          
        </label>
        <input id="u150_input" type="radio" value="radio"
        		<c:if test="${archivesInfoDetail.health.kinship == '1'}">
          			checked = "checked"
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship == '2'}">
          			checked = "checked"
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship == '3'}">
          			checked = "checked"
          		</c:if> name="u150"/>
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u152" class="ax_水平线">
        
        <img id="u152_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u152_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u153" class="ax_文本段落">
        
          <p id="u154"><span>婚前医学检查结果：</span><span>
          		<c:if test="${archivesInfoDetail.inspection.checkResult == '0'}">
          			未见异常
          		</c:if>
          		<c:if test="${archivesInfoDetail.inspection.checkResult == '1'}">
          			${archivesInfoDetail.inspection.diseaseDiagnosis }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u155" class="ax_水平线">
        
        <img id="u155_line" class="img " src="${ctx}/static/images/u46_line.png" alt="u155_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u156" class="ax_文本段落">
        
          <p id="u157"><span>医学意见：</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u158" class="ax_文本段落">
        
          <p id="u159"><span>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '0'}">
          		  	未发现医学上不宜结婚的情形
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '1'}">
		          	建议暂缓结婚
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '2'}">
		          	建议不宜生育
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '3'}">
		          	建议不宜结婚
          	</c:if>
          	<c:if test="${archivesInfoDetail.inspection.medicalAdvice == '4'}">
		          	建议采取医学措施，尊重受检者意愿
          	</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u160" class="ax_文本段落">
        
          <p id="u161"><span>主检医师签字</span></p>
        
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u162" class="ax_垂直线">
        
        <img id="u162_line" class="img " src="${ctx}/static/images/u79_line.png" alt="u162_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u163" class="ax_垂直线">
        
        <img id="u163_line" class="img " src="${ctx}/static/images/u79_line.png" alt="u163_line"/>
      </div>

      <!-- Unnamed (垂直线) -->
      <div id="u164" class="ax_垂直线">
        
        <img id="u164_line" class="img " src="${ctx}/static/images/u79_line.png" alt="u164_line"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u165" class="ax_文本段落">
        
          <p id="u166"><span>检查单位专用章</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u167" class="ax_文本段落">
        
          <p id="u168"><span>注：1、本证明有效期为三个月&nbsp; &nbsp;&nbsp; 2、对上述结果如有异议，可申请医学技术鉴定。此联交婚姻登记部门</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u169" class="ax_文本段落">
        
          <p id="u170"><span>${archivesInfoDetail.creatTime }</span></p>
        
      </div>
      
      </div>
    </div>
  </body>
</html>
