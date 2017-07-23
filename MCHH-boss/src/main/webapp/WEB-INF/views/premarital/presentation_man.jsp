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
    <link href="${ctx}/static/css/presentation-styles.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${ctx}/static/common/js/jquery.jqprint-0.3.js"></script>
   </head>

	<script type="text/javascript">
	
	$(function(){
		  //年龄
		  var birthday = $("#birthday").html();
		  
		  var nowdate = new Date();
		  
		  var age = nowdate.getFullYear() - birthday.substr(0,4);
		  
		  $("#u107").html("年龄："+age);
		  
		  
		  var manPresentationUrl = "${ctx}/premaritalexainfo/manPresentation"
		  var toUpdateUrl = "${ctx}/premaritalexainfo/toEditManPremarital"
		  var listUrl = "${ctx}/archivesinfo/manList";
		  //修改
		  $("#u258").click(function(){
			  var id = $("#archId").val();
			  
			  window.location = toUpdateUrl+'?id='+id;
		  })
		  //删除
		  $("#u254").click(function(){
			  var manName = $("#manName").val();
			  
			  $("#names").html(manName);
			  showDialog_("提示","deleteAtv","moremiddle4",false);
		  })
		  
		  
		  //删除取消
		  $("#u04").click(function(){
			  var id = $("#archId").val();
	 			
			  $("#deleteAtv").window("close");
		  })
		  
		  //确认删除
		  $("#u06").click(function(){
			  var id = $("#archId").val();
	 			
	 			window.location = toUpdateUrl+'?id='+id;
		  })
		  
		  //关闭
		  $("#u600").click(function(){
			  
			  window.location.href=listUrl;
	 			
		  })
		  
		  //打印
		  $("#u256").click(function(){
			  
			  var arr = $("#manPresentation").children("div");
			   for(var i = 0; i <arr.length; i++){
				   var left = arr[i].offsetLeft;
				   arr[i].style.left = (left - 170)+"px";
			   }
			   $("#manPresentation").jqprint();
			   for(var i = 0; i <arr.length; i++){
				   var left = arr[i].offsetLeft;
				   arr[i].style.left = (left + 170)+"px";
			   }
		  })
		  
		  var doctorId = $("#doctorId").val();
		  var currentId = $("#currentId").val();
		  var admId = $("#admId").val();
		  var adminId = $("#adminId").val();
		  /* if (doctorId != currentId) {
			  document.getElementById('u600').style.left='932px';
		  }else{
			  document.getElementById('u600').style.left='680px';
		  } */
		  /* if (admId != currentId && doctorId != currentId && adminId != currentId) {
			  
			  document.getElementById('u600').style.left='932px';
		  }else{
			  document.getElementById('u600').style.left='680px';
		  } */
		  /* if (adminId != currentId) {
			  document.getElementById('u600').style.left='932px';
		  }else{
			  document.getElementById('u600').style.left='680px';
		  } */
		  
		  
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
		  left:410px;
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
		  left:190px;
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
		  left:231px;
		  top:103px;
		  width:258px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#u09 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:258px;
		  white-space:nowrap;
		}
	</style>
   <body>
    <div id="base" class="">

      <div id = "u288" class="ax_形状">

      <!-- Unnamed (形状) -->
      <div id="u2" class="ax_形状" style="background-color:#EE5F45">
        
          <p id="u3"><span>男性婚前医学检查</span><span>报告</span></p>
        
      </div>
      
      <c:if test="${archivesInfoDetail.archivesInfo.doctorId == archivesInfoDetail.currentId || archivesInfoDetail.currentId == archivesInfoDetail.admId || archivesInfoDetail.currentId == archivesInfoDetail.adminId}">
      <!-- Unnamed (形状) -->
      <div id="u254" class="ax_形状" style="background-color:#009DD9;cursor:pointer">
        
          <p id="u255"><span>删除</span></p>
        
      </div>
      </c:if>

      <!-- Unnamed (形状) -->
      <div id="u256" class="ax_形状" style="background-color:#56BB4D;cursor:pointer">
        
          <p id="u257"><span>立即打印</span></p>
        
      </div>

		<input id = "doctorId" type = "hidden" value = "${archivesInfoDetail.archivesInfo.doctorId }"/>
		<input id = "currentId" type = "hidden" value = "${archivesInfoDetail.currentId }"/>
		<input id = "admId" type = "hidden" value = "${archivesInfoDetail.admId }"/>
		<input id = "adminId" type = "hidden" value = "${archivesInfoDetail.adminId }"/>
      <!-- Unnamed (形状) -->
      
      <c:if test="${archivesInfoDetail.archivesInfo.doctorId == archivesInfoDetail.currentId || archivesInfoDetail.currentId == archivesInfoDetail.admId || archivesInfoDetail.currentId == archivesInfoDetail.adminId}">
      <div id="u258" class="ax_形状" style="background-color:#E9854F;cursor:pointer">
        
          <p id="u259"><span>修改</span></p>
        
      </div>
      </c:if>
      
      <div id="u600" class="ax_形状" style="background-color:#EE5F45;cursor:pointer">
        
          <p id="u601"><span>关闭</span></p>
        
      </div>
      
      </div>
      
      <div id = "manPresentation">
      
       <!-- Unnamed (形状) -->
      <div id="u6" class="ax_形状">
        <img id="u6_img" class="img " src="${ctx}/static/images/u6.png"/>
        <!-- Unnamed () -->
        <div id="u7" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>
      
      <!-- Unnamed (水平线) -->
      <div id="u148" class="ax_水平线">
        <img id="u148_start" class="img " src="${ctx}/static/images/transparent.gif" alt="u148_start"/>
        <img id="u148_end" class="img " src="${ctx}/static/images/transparent.gif" alt="u148_end"/>
        <img id="u148_line" class="img " src="${ctx}/static/images/u148_line.png" alt="u148_line"/>
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u149" class="ax_水平线">
        <img id="u149_start" class="img " src="${ctx}/static/images/transparent.gif" alt="u149_start"/>
        <img id="u149_end" class="img " src="${ctx}/static/images/transparent.gif" alt="u149_end"/>
        <img id="u149_line" class="img " src="${ctx}/static/images/u149_line.png" alt="u149_line"/>
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u150" class="ax_水平线">
        <img id="u150_start" class="img " src="${ctx}/static/images/transparent.gif" alt="u150_start"/>
        <img id="u150_end" class="img " src="${ctx}/static/images/transparent.gif" alt="u150_end"/>
        <img id="u150_line" class="img " src="${ctx}/static/images/u149_line.png" alt="u150_line"/>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u142" class="ax_文本段落">
        
          <p id="u143"><span>男性婚前医学检查</span><span>报告</span></p>
        
      </div>
      
     
      
      <!-- Unnamed (Image) -->
      <div id="u14" class="ax_image">
        <img id="u14_img" class="img " src="images/男性婚检医学检查报告/u14.png"/>
        <!-- Unnamed () -->
        <div id="u15" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u8" class="ax_文本段落">
        	<input id = "archId" name = "archId" type = "hidden" value="${archivesInfoDetail.archivesInfo.id}"/>
          <p id="u9"><span>档案</span><span>编号：${archivesInfoDetail.archivesInfo.archivesCode }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u12" class="ax_文本段落">
        
          <p id="u13"><span>检查日期</span><span>：${archivesInfoDetail.creatTime }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u10" class="ax_文本段落">
        	<input id = "manName" name = "manName" type = "hidden" value="${archivesInfoDetail.archivesInfo.manName}"/>
          <p id="u11"><span>姓名</span><span>：${archivesInfoDetail.archivesInfo.manName }</span></p>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u100" class="ax_文本段落">
        
          <p id="u101"><span>性别：</span><span>&nbsp;&nbsp; 
          		<c:if test="${archivesInfoDetail.archivesInfo.manSex eq '1'}">
          			男
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manSex eq '0'}">
          			女
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manSex eq '2'}">
          			性别不明
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u104" class="ax_文本段落">
        
          <p id="u105"><span>出生日期：<span id = "birthday">${archivesInfoDetail.manBirthday }</span></span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u106" class="ax_文本段落">
        
          <p id="u107"><span>年龄：</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u108" class="ax_文本段落">
        
          <p id="u109"><span>身份证号码：${archivesInfoDetail.archivesInfo.manIdNo }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u116" class="ax_文本段落">
        
          <p id="u117"><span>职业：
          		<c:if test="${archivesInfoDetail.archivesInfo.manOccupation eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manOccupation eq '1'}">
          			事业单位
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manOccupation eq '2'}">
          			企业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manOccupation eq '3'}">
          			服务业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manOccupation eq '4'}">
          			制造业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manOccupation eq '5'}">
          			农业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manOccupation eq '6'}">
          			其他
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u118" class="ax_文本段落">
        
          <p id="u119"><span>文化程度：
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '0'}">
          			小学
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '1'}">
          			初中
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '2'}">
          			高中
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '3'}">
          			中专
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '4'}">
          			大专
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '5'}">
          			本科
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '6'}">
          			硕士
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '7'}">
          			博士
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '8'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.manEducation eq '9'}">
          			不详
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u102" class="ax_文本段落">
        
          <p id="u103"><span>民族：&nbsp;&nbsp;${archivesInfoDetail.archivesInfo.manNation }<span> </p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u112" class="ax_文本段落">
        
          <p id="u113"><span>户口所在地：&nbsp; </span>
          	  <span>${archivesInfoDetail.provinceInfo.name }</span>
   			  <span>${archivesInfoDetail.cityInfo.name }</span>
   			  <span>${archivesInfoDetail.districtAndCountyInfo.name }</span>
   			  <span>${archivesInfoDetail.townshipInfo.name }</span>
   			  <span>${archivesInfoDetail.villageInfo.name }</span>
   			  <span>${archivesInfoDetail.archivesInfo.manAccAddress }</span>
          </p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u114" class="ax_文本段落">
        
          <p id="u115"><span>现住址：&nbsp;</span>
          	  <span>${archivesInfoDetail.provinceInfo1.name }</span>
   			  <span>${archivesInfoDetail.cityInfo1.name }</span>
   			  <span>${archivesInfoDetail.districtAndCountyInfo1.name }</span>
   			  <span>${archivesInfoDetail.townshipInfo1.name }</span>
   			  <span>${archivesInfoDetail.villageInfo1.name }</span>
   			  <span>${archivesInfoDetail.archivesInfo.manHomeAddress }</span>
          </p>
        
      </div>
      
      <!-- Unnamed () -->
      <div id="u144" class="ax_文本段落">
        
          <p id="u145"><span>工作单位：${archivesInfoDetail.archivesInfo.manWorkUnit }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u110" class="ax_文本段落">
        
          <p id="u111"><span>联系电话：${archivesInfoDetail.archivesInfo.manTele }</span></p>
       
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u120" class="ax_文本段落">
        
          <p id="u121"><span>对方姓名：${archivesInfoDetail.archivesInfo.name }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u16" class="ax_文本段落">
        
       <p id="u17"><span>血缘关系：
       			<c:if test="${archivesInfoDetail.health.kinship eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship eq '1'}">
          			表
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship eq '2'}">
          			堂
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship eq '3'}">
          			${archivesInfoDetail.health.otherRelationships }
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.kinship eq '4'}">
          			${archivesInfoDetail.health.otherRelationships }
          		</c:if>
       </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u18" class="ax_文本段落">
        
          <p id="u19"><span>既往病史：
          		<c:forEach items="${list }" var="s">
					<c:if test="${s == '0'}">
		          			无<span>&nbsp;&nbsp;</span>
		          	</c:if>
	          	</c:forEach>
	          	<c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '1'}">
		          			心脏病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '2'}">
		          			肺结核<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '3'}">
		          			肝脏病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '4'}">
		          			泌尿生殖系统疾病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '5'}">
		          			糖尿病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '6'}">
		          			高血压<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '7'}">
		          			精神病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '8'}">
		          			性病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '9'}">
		          			癫痫<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '10'}">
		          			甲亢<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        <c:forEach items="${list }" var="s"> 
		        	<c:if test="${s == '11'}">
		          			先天疾患<span>&nbsp;&nbsp;</span>
		          	</c:if>
		        </c:forEach>
		        ${archivesInfoDetail.health.medicalOther }
          		
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u20" class="ax_文本段落">
        
          <p id="u21"><span>手术史：
          		<c:if test="${archivesInfoDetail.health.surgeryHistory eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.surgeryHistory eq '1'}">
          			${archivesInfoDetail.health.operation }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u22" class="ax_文本段落">
        
          <p id="u23"><span>现病史：
          		<c:if test="${archivesInfoDetail.health.hpi eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.hpi eq '1'}">
          			${archivesInfoDetail.health.caseInformation }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u800" class="ax_文本段落">
       
          <p id="u801"><span>既往婚育史：
          		<c:if test="${archivesInfoDetail.health.marriedHistory eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.marriedHistory eq '1'}">
          			有
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u802" class="ax_文本段落">
        
          <p id="u803"><span>与遗传有关的家族史：
          		<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '0'}">
		          			无<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '1'}">
		          			盲<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '2'}">
		          			聋<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '3'}">
		          			哑<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '4'}">
		          			精神病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '5'}">
		          			先天性智力低下<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '6'}">
		          			先天性心脏病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '7'}">
		          			血友病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '8'}">
		          			糖尿病<span>&nbsp;&nbsp;</span>
		          	</c:if>
		       	</c:forEach>
		       	<c:forEach items="${list1 }" var="s1">
		        	<c:if test="${s1 == '9'}">
		          			${archivesInfoDetail.health.geneticHistoryRemark }
		          	</c:if>
		       	</c:forEach>
          </span></p>
        
      </div>
      
      

     

      

      <!-- Unnamed (形状) -->
      <c:if test="${archivesInfoDetail.health.marriedHistory eq '1'}">
      <div id="u804" class="ax_文本段落">
        
          <p id="u805"><span>子女：
          		<c:if test="${archivesInfoDetail.health.childrenNumber eq '0'}">
          			0
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.childrenNumber eq '1'}">
          			1
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.childrenNumber eq '2'}">
          			2
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.childrenNumber eq '3'}">
          			3
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.childrenNumber eq '4'}">
          			4
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.childrenNumber eq '5'}">
          			5
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.childrenNumber eq '6'}">
          			6
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.childrenNumber eq '7'}">
          			${archivesInfoDetail.health.childrenOther }
          		</c:if>
          </span></p>
        
      </div>
      </c:if>

      <!-- Unnamed (形状) -->
      <div id="u806" class="ax_文本段落">
        
          <p id="u807"><span>家族近亲婚配：
          		<c:if test="${archivesInfoDetail.health.relativesMating eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.relativesMating eq '1'}">
          			有（父母）
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.relativesMating eq '2'}">
          			有（祖父母）
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.relativesMating eq '3'}">
          			有（外祖父母）
          		</c:if>
          		<c:if test="${archivesInfoDetail.health.relativesMating eq '4'}">
          			${archivesInfoDetail.health.relativesMatingRemark }
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u808" class="ax_文本段落" style="background: #FFFFFF">
        
          <p id="u809"><span>体格检查</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u810" class="ax_文本段落">
        
          <p id="u811"><span>血压：${archivesInfoDetail.physique.bloodHi }<span>/</span>${archivesInfoDetail.physique.bloodLow }<span>mmHg</span></span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u812" class="ax_文本段落">
        
          <p id="u813"><span>特殊体态：
          		<c:if test="${archivesInfoDetail.physique.specialPosture eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.specialPosture eq '1'}">
          			${archivesInfoDetail.physique.postureRemark }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u814" class="ax_文本段落">
        
          <p id="u815"><span>精神状态：
          		<c:if test="${archivesInfoDetail.physique.mentalState eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.mentalState eq '1'}">
          			${archivesInfoDetail.physique.stateRemark }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u816" class="ax_文本段落">
        
          <p id="u817"><span>特殊面容：
          		<c:if test="${archivesInfoDetail.physique.specialFace eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.specialFace eq '1'}">
          			${archivesInfoDetail.physique.faceRemark }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u818" class="ax_文本段落">
        
          <p id="u819"><span>智力：
          		<c:if test="${archivesInfoDetail.physique.intelligence eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.intelligence eq '1'}">
          			异常
          		</c:if>
          </span></p>
       
      </div>

      <!-- Unnamed (形状) -->
      <div id="u820" class="ax_文本段落">
        
          <p id="u821"><span>皮肤毛发：
          		<c:if test="${archivesInfoDetail.physique.skinHair eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.skinHair eq '1'}">
          			${archivesInfoDetail.physique.skinHairNote }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u822" class="ax_文本段落">
        
          <p id="u823"><span>五官：
          		<c:if test="${archivesInfoDetail.physique.facialFeatures eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.facialFeatures eq '1'}">
          			${archivesInfoDetail.physique.facialFeaturesRemark }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u824" class="ax_文本段落">
        
          <p id="u825"><span>甲状腺：
          		<c:if test="${archivesInfoDetail.physique.thyroidGland eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.thyroidGland eq '1'}">
          			${archivesInfoDetail.physique.thyroidGlandRemark }
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u826" class="ax_文本段落">
        
          <p id="u827"><span>心：</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u828" class="ax_文本段落">
        
          <p id="u829"><span>心率：${archivesInfoDetail.physique.heartRate }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u830" class="ax_文本段落">
        
          <p id="u831"><span>次/分</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u832" class="ax_文本段落">
        
          <p id="u833"><span>心律：
          		<c:if test="${archivesInfoDetail.physique.heartRhythm eq '0'}">
          			齐
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm eq '1'}">
          			过速
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm eq '2'}">
          			过缓
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm eq '3'}">
          			不齐
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.heartRhythm eq '4'}">
          			${archivesInfoDetail.physique.heartRhythmRemark }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u834" class="ax_文本段落">
        
          <p id="u835"><span>杂音：
          		<c:if test="${archivesInfoDetail.physique.noise eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.noise eq '1'}">
          			${archivesInfoDetail.physique.noiseRemark }
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u836" class="ax_文本段落">
        
          <p id="u837"><span>肺：
          		<c:if test="${archivesInfoDetail.physique.lung eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.lung eq '1'}">
          			${archivesInfoDetail.physique.lungRemark }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u838" class="ax_文本段落">
        
          <p id="u839"><span>肝：
          		<c:if test="${archivesInfoDetail.physique.liver eq '0'}">
          			未及
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.liver eq '1'}">
          			${archivesInfoDetail.physique.liverRemark }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u840" class="ax_文本段落">
        
          <p id="u841"><span>四肢脊柱：
          		<c:if test="${archivesInfoDetail.physique.limbs eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.limbs eq '1'}">
          			${archivesInfoDetail.physique.limbsRemark }
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u842" class="ax_文本段落">
        
          <p id="u843"><span>第二性征：喉结：
          		<c:if test="${archivesInfoDetail.physique.throat eq '0'}">
          			有
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.throat eq '1'}">
          			无
          		</c:if>
          </span><span>&nbsp; </span>
          <span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 阴毛：
          		<c:if test="${archivesInfoDetail.physique.pubicHair eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.pubicHair eq '1'}">
          			稀少
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.pubicHair eq '2'}">
          			无
          		</c:if>
          </span><span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u844" class="ax_文本段落">
        
          <p id="u845"><span>生殖器：</span><span>阴茎：
          		<c:if test="${archivesInfoDetail.physique.penis eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.penis eq '1'}">
          			${archivesInfoDetail.physique.penisRemark }
          		</c:if>
          </span><span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 包皮：
          		<c:if test="${archivesInfoDetail.physique.foreskin eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.foreskin eq '1'}">
          			过长
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.foreskin eq '2'}">
          			包茎
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u846" class="ax_文本段落">
        
          <p id="u847"><span>睾丸：</span><span>
          		<c:if test="${archivesInfoDetail.physique.without eq '0'}">
          			左
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.without eq '1'}">
          			右
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u848" class="ax_文本段落">
        
          <p id="u849"><span>附睾：</span><span>
          		<%-- <c:if test="${archivesInfoDetail.physique.attachment eq '0'}">
          			正常
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.attachment eq '1'}">
          			${archivesInfoDetail.physique.attachmentRemark }
          		</c:if> --%>
          </span></p>
        
      </div>
      

      <!-- Unnamed (形状) -->
      <div id="u140" class="ax_文本段落">
        
          <p id="u141"><span>精索静脉曲张：
          		<c:if test="${archivesInfoDetail.physique.varicocele eq '0'}">
          			<input id="varicocele" type="radio" value="0" name="varicocele" checked/>
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.physique.varicocele eq '1'}">
        			<input id="varicocele" type="radio" value="1" name="varicocele" checked/>
        			有
          		</c:if>
          </span></p>
        
      </div>
      
      
      
      <!-- Unnamed (形状) -->
      <div id="u173" class="ax_文本段落">
        
          <p id="u174"><span>检查医师签名：</span></p>
        
      </div>
      
      
		<!-- Unnamed (形状) -->
      <div id="u126" class="ax_文本段落" style="background: #FFFFFF">
        
          <p id="u127"><span>实验室及特殊检查</span></p>
       
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u151" class="ax_文本段落">
        
          <p id="u152"><span>血</span><span>常规：</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u224" class="ax_文本段落">
        
          <p id="u152"><span>血红蛋白值</span><span>${archivesInfoDetail.laboratory.hemoglobin }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u226" class="ax_文本段落">
        
          <p id="u227"><span>g/L</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u228" class="ax_文本段落">
        
          <p id="u229"><span>白细胞计数值：${archivesInfoDetail.laboratory.whiteCellCount }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u230" class="ax_文本段落">
        
          <p id="u231"><span>血小板计数值：${archivesInfoDetail.laboratory.platelet }</span></p>
       
      </div>

      <!-- Unnamed (形状) -->
      <div id="u232" class="ax_文本段落">
        
          <p id="u233"><span>10^9/L</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u169" class="ax_文本段落">
        
          <p id="u170"><span>尿</span><span>常规：</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u234" class="ax_文本段落">
        
          <p id="u235"><span>尿蛋白：${archivesInfoDetail.laboratory.urineProtein }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u236" class="ax_文本段落">
        
          <p id="u237"><span>尿糖：${archivesInfoDetail.laboratory.urineSugar }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u238" class="ax_文本段落">
        
          <p id="u239"><span>尿酮体：${archivesInfoDetail.laboratory.ketoneBody }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u240" class="ax_文本段落">
        
          <p id="u241"><span>尿潜血：${archivesInfoDetail.laboratory.ery }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u153" class="ax_文本段落">
        
          <p id="u154"><span>肝功能：</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u198" class="ax_文本段落">
        
          <p id="u199"><span>血清谷丙转氨酶：${archivesInfoDetail.laboratory.serumAlt }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u200" class="ax_文本段落">
        
          <p id="u201"><span>血清谷草转氨酶：${archivesInfoDetail.laboratory.aspertateAmi }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u202" class="ax_文本段落">
        
          <p id="u203"><span>U/L</span></p>
       
      </div>

      <!-- Unnamed (形状) -->
      <div id="u204" class="ax_文本段落">
        
          <p id="u205"><span>白蛋白：${archivesInfoDetail.laboratory.albumin }</span></p>
       
      </div>

      <!-- Unnamed (形状) -->
      <div id="u206" class="ax_文本段落">
        
          <p id="u207"><span>g/L</span></p>
       
      </div>

      <!-- Unnamed (形状) -->
      <div id="u208" class="ax_文本段落">
        
          <p id="u209"><span>总胆红素：${archivesInfoDetail.laboratory.totalBilirubin }</span></p>
       
      </div>

      <!-- Unnamed (形状) -->
      <div id="u210" class="ax_文本段落">
        
          <p id="u211"><span>μ</span><span> mol/L</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u212" class="ax_文本段落">
        
          <p id="u213"><span>结合胆红素：${archivesInfoDetail.laboratory.combiningBilirubin }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u214" class="ax_文本段落">
        
          <p id="u215"><span>μ</span><span> mol/L</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u155" class="ax_文本段落">
        
          <p id="u156"><span>肾功能：</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u216" class="ax_文本段落">
        
          <p id="u217"><span>血清肌酐：${archivesInfoDetail.laboratory.serumCreatinine }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u218" class="ax_文本段落">
        
          <p id="u219"><span>μ</span><span> mol/L</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u220" class="ax_文本段落">
        
          <p id="u221"><span>血尿素氮：${archivesInfoDetail.laboratory.bloodUreaNitrogen }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u222" class="ax_文本段落">
        
          <p id="u223"><span>m</span><span>mol/L</span></p>
        
      </div>
      
      
      <!-- Unnamed (形状) -->
      <div id="u161" class="ax_文本段落">
        
          <p id="u162"><span>乙肝五项：</span></p>
        
      </div>
      
        <!-- Unnamed (形状) -->
      <div id="u188" class="ax_文本段落">
        
          <p id="u189"><span>乙型肝炎表面抗原：
          		<c:if test="${archivesInfoDetail.laboratory.antigenHepatitis eq '0'}">
          			阴性
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.antigenHepatitis eq '1'}">
          			阳性
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u190" class="ax_文本段落">
        
          <p id="u191"><span>乙型肝炎表面抗体：
          		<c:if test="${archivesInfoDetail.laboratory.hepatitisAntibody eq '0'}">
          			阴性
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.hepatitisAntibody eq '1'}">
          			阳性
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u192" class="ax_文本段落">
        
          <p id="u193"><span>乙型肝炎e抗原：
          		<c:if test="${archivesInfoDetail.laboratory.eantigen eq '0'}">
          			阴性
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.eantigen eq '1'}">
          			阳性
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u194" class="ax_文本段落">
        
          <p id="u195"><span>乙型肝炎e抗体：
          		<c:if test="${archivesInfoDetail.laboratory.eantibody eq '0'}">
          			阴性
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.eantibody eq '1'}">
          			阳性
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u196" class="ax_文本段落">
        
          <p id="u197"><span>乙型肝炎核心抗体：
          		<c:if test="${archivesInfoDetail.laboratory.coreAntibody eq '0'}">
          			阴性
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.coreAntibody eq '1'}">
          			阳性
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u163" class="ax_文本段落">
        
          <p id="u164"><span>梅毒血清学试验：
          		<c:if test="${archivesInfoDetail.laboratory.syphilisSerum eq '0'}">
          			阴性
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.syphilisSerum eq '1'}">
          			阳性
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u165" class="ax_文本段落">
        
          <p id="u166"><span>HIV抗体检测：
          		<c:if test="${archivesInfoDetail.laboratory.hivAntibodies eq '0'}">
          			阴性
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.hivAntibodies eq '1'}">
          			阳性
          		</c:if>
          </span></p>
       
      </div>

      <!-- Unnamed (形状) -->
      <div id="u167" class="ax_文本段落">
        
          <p id="u168"><span>胸透：
          		<c:if test="${archivesInfoDetail.laboratory.chest eq '0'}">
          			未见异常
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.chest eq '1'}">
          			${archivesInfoDetail.laboratory.note }
          		</c:if>
          		<c:if test="${archivesInfoDetail.laboratory.chest eq '2'}">
          			未检查
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u128" class="ax_文本段落" style="background: #FFFFFF">
        
          <p id="u129"><span>检查结果</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u66" class="ax_文本段落">
        
          <p id="u67"><span>检查结果：
          		<c:if test="${archivesInfoDetail.inspection.checkResult eq '0'}">
          			未见异常
          		</c:if>
          		<c:if test="${archivesInfoDetail.inspection.checkResult eq '1'}">
          			异常
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u68" class="ax_文本段落">
        
          <p id="u69"><span>疾病诊断：${archivesInfoDetail.inspection.diseaseDiagnosis }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u70" class="ax_文本段落">
        
          <p id="u71"><span>医学意见：
          		<c:if test="${archivesInfoDetail.inspection.medicalAdvice eq '0'}">
          			未发现医学上不宜结婚的情形
          		</c:if>
          		<c:if test="${archivesInfoDetail.inspection.medicalAdvice eq '1'}">
          			建议暂缓结婚
          		</c:if>
          		<c:if test="${archivesInfoDetail.inspection.medicalAdvice eq '2'}">
          			建议不宜生育
          		</c:if>
          		<c:if test="${archivesInfoDetail.inspection.medicalAdvice eq '3'}">
          			建议不宜结婚
          		</c:if>
          		<c:if test="${archivesInfoDetail.inspection.medicalAdvice eq '4'}">
          			建议采取医学措施，尊重受检者意愿
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u72" class="ax_文本段落">
        
          <p id="u73"><span>受检双方签名：</span></p>
        
      </div>

      

      <!-- Unnamed (形状) -->
      <div id="u75" class="ax_文本段落">
        
          <p id="u76"><span>婚前卫生咨询：</span></p>
        
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u77" class="ax_文本框">
        <p><span>${archivesInfoDetail.inspection.maritalConsultation }</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u78" class="ax_文本段落">
        
          <p id="u79"><span>咨询指导结果：
          		<c:if test="${archivesInfoDetail.inspection.consultativeResults eq '0'}">
          			接受指导意见
          		</c:if>
          		<c:if test="${archivesInfoDetail.inspection.consultativeResults eq '1'}">
          			不接受指导意见，知情后选择结婚，后果自己承担
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u80" class="ax_文本段落">
        
          <p id="u81"><span>受检双方签名：</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u83" class="ax_文本段落">
        
          <p id="u84"><span>转诊医院：${archivesInfoDetail.preReferral.departmentPO.name }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u85" class="ax_文本段落">
        
          <p id="u86"><span>转诊日期：${archivesInfoDetail.referralDate }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u87" class="ax_文本段落">
        
          <p id="u88"><span>预约复诊日期：${archivesInfoDetail.appointmentDate }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u122" class="ax_文本段落">
        
          <p id="u123"><span>预约医生：${archivesInfoDetail.preReferral.operatorPO.realName }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u89" class="ax_文本段落">
        
          <p id="u90"><span>出具《婚前医学检查证明》日期：${archivesInfoDetail.issuedByDate }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u91" class="ax_文本段落">
       
          <p id="u92"><span>受检人员签名：</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u94" class="ax_文本段落">
        
          <p id="u95"><span>检查医师签名：</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u97" class="ax_文本段落">
        
          <p id="u98"><span>主检医师签名：</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u171" class="ax_文本段落">
        
          <p id="u172"><span>镇平县妇幼保健院</span></p>
        
      </div>

      

      <!-- Unnamed (形状) -->
      <div id="u175" class="ax_文本段落">
        
          <p id="u176"><span>————</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u242" class="ax_文本段落">
        
          <p id="u243"><span>10^9/L</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u244" class="ax_文本段落">
        
          <p id="u245"><span>μ</span><span> mol/L</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u246" class="ax_文本段落">
        
          <p id="u247"><span>μ</span><span> mol/L</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u248" class="ax_文本段落">
        
          <p id="u249"><span>μ</span><span> mol/L</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u250" class="ax_文本段落">
        
          <p id="u251"><span>μ</span><span> mol/L</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u252" class="ax_文本段落">
        
          <p id="u253"><span>U/L</span></p>
        
      </div>

      </div>
    </div>
    <!-- 删除弹出框 -->
    <div id="deleteAtv" class="easyui-dialog" title="角色" closed="true">
        	<!-- Unnamed (形状) -->
	      <div id="u00" class="ax_形状">
	        <div id="u1" class="text">
	          <p><span>&nbsp;</span></p>
	        </div>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <!-- <div id="u02" class="ax_形状" style="background-color:#F30">
	          <p id="u03"><span>提&nbsp; &nbsp; 示</span></p>
	      </div> -->
	
	      <!-- Unnamed (形状) -->
      		<div id="u04" class="ax_形状" style="background-color:#06F;cursor:pointer">
	          <p id="u05"><span id="no">取消</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u06" class="ax_形状" style="background-color:#F00;cursor:pointer">
	          <p id="u07"><span id="yes">确定删除</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u08" class="ax_文本段落">
	          <p id="u09"><span>确定要删除 &nbsp; &nbsp;"</span><span id = "names"></span><span>" &nbsp; &nbsp;的婚检报告？</span>
	          	<input id = "archId" name = "archId" type = "hidden" value="${archivesInfoDetail.archivesInfo.id}"/>
	          </p>
      	  </div>
        </div>
  </body>
</html>
