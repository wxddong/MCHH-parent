 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
    <script type="text/javascript">
		$(function(){
			
			$("#du119").click(function(){
				closeDialog_();
			});
		})
    </script>
    <div id="base" class="">
    
         <!-- Unnamed (形状) -->
      <div id="du117" class="ax_形状">
        个人基本信息详情
      </div>

      <!-- Unnamed (形状) -->
      <div id="du119" style="cursor: pointer;" class="ax_形状">
        关闭
      </div>

      <!-- Unnamed (形状) -->
      <div id="du0" class="ax_形状">
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="du2" class="ax_文本段落">
        档案编号：${archives.archivesCode }
      </div>
      
     <!-- Unnamed (形状) -->
      <div id="du6" class="ax_文本段落">
        建档医院：&nbsp;${operator.department }
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du8" class="ax_文本段落">
        建档医生：&nbsp;${operator.realName }
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du4" class="ax_文本段落">
        建档日期：&nbsp;<fmt:formatDate value="${archives.creatTime }" pattern="yyyy年MM月dd日"/>
      </div>

      
      <!-- Unnamed (水平线) -->
      <div id="du116" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>
      

      <!-- Unnamed (形状) -->
      <div id="du10" class="ax_文本段落">
        姓&nbsp; &nbsp;&nbsp;&nbsp;名：${archives.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du12" class="ax_文本段落">
        性&nbsp; &nbsp; &nbsp; 别：<c:if test="${archives.sex == '1' }">男</c:if><c:if test="${archives.sex == '2' }">性别不明</c:if><c:if test="${archives.sex == '0' }">女</c:if>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du18" class="ax_文本段落">
        出生日期：<fmt:formatDate value="${archives.birthday }" pattern="yyyy-MM-dd"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du14" class="ax_文本段落">
        年&nbsp;&nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;${babyAge }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du16" class="ax_文本段落">
        身份证号：${archives.idNo }
      </div>

     <!-- Unnamed (形状) -->
      <div id="du86" class="ax_文本段落">
        出生孕周：${archives.gestationalWeek }
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du84" class="ax_文本段落">
        胎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数：
        <c:if test="${archives.fetusNum == '0' }">单胎</c:if>
        <c:if test="${archives.fetusNum == '1' }">多胎</c:if>
        <c:if test="${archives.fetusNum == '2' }">双胎</c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du88" class="ax_文本段落">
        第&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${archives.whichFetus }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du90" class="ax_文本段落">
        胎
      </div>

      <!-- Unnamed (形状) -->
      <div id="du92" class="ax_文本段落">
        第&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${archives.whichBirth }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du94" class="ax_文本段落">
        产
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du96" class="ax_文本段落">
        分娩方式：<c:if test="${archives.deliveryType == '0' }">顺产</c:if>
        <c:if test="${archives.deliveryType == '1' }">剖宫产</c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du98" class="ax_文本段落">
        出生情况：
        <c:forEach items="${ birthConditions}" var="birthCondition">
	        <c:if test="${birthCondition == '0' }">顺产&nbsp;</c:if>
	        <c:if test="${birthCondition == '1' }">胎头吸引&nbsp;</c:if>
	        <c:if test="${birthCondition == '2' }">产钳&nbsp;</c:if>
	        <c:if test="${birthCondition == '3' }">剖宫产&nbsp;</c:if>
	        <c:if test="${birthCondition == '4' }">臀位&nbsp;</c:if>
	        <c:if test="${birthCondition == '5' }">双多胎&nbsp;</c:if>
	        <c:if test="${birthCondition == '6' }">其他：${archives.conditionRemark }</c:if>
        </c:forEach>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du100" class="ax_文本段落">
        出生体重：${archives.weight }kg
      </div>

      <!-- Unnamed (形状) -->
      <div id="du102" class="ax_文本段落">
        出生身长：${archives.height }cm
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du104" class="ax_文本段落">
        新生儿窒息：<c:if test="${archives.asphyxia == '0' }">无</c:if><c:if test="${archives.asphyxia == '1' }">有</c:if>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du108" class="ax_文本段落">
        Apgar评分：
        <c:if test="${archives.apgarScore == '0' }">三分钟</c:if>
        <c:if test="${archives.apgarScore == '1' }">五分钟</c:if>
        <c:if test="${archives.apgarScore == '2' }">不详</c:if>
        &nbsp;${archives.apgarRemark }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du106" class="ax_文本段落">
        新生儿疾病：<c:if test="${archives.newbornDisease == '0' }">无</c:if>
        <c:if test="${archives.newbornDisease == '1' }">有&nbsp;${archives.diseaseRemark }</c:if>
      </div>
      
       <!-- Unnamed (形状) -->
      <div id="du110" class="ax_文本段落">
        母亲妊娠期患病情况：<c:forEach items="${pregns }" var="pregn">
        			<c:if test="${pregn eq '0'}">糖尿病&nbsp;</c:if>
        			<c:if test="${pregn eq '1'}">妊娠期高血压&nbsp;</c:if>
        			<c:if test="${pregn eq '2'}">其他&nbsp;${archives.sicknessRemark }</c:if>
        		  </c:forEach>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du112" class="ax_文本段落">
        是否有畸形：<c:if test="${archives.anomaly eq '0' }">无</c:if>
        <c:if test="${archives.anomaly eq '1' }">有&nbsp;${archives.anomalyRemark }</c:if>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du121" class="ax_文本段落">
        助产机构：${department.name }&nbsp;${archives.institutionsRemark }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du123" class="ax_文本段落">
		出院日期：<fmt:formatDate value="${archives.dischargeDate }" pattern="yyyy-MM-dd"/>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du26" class="ax_文本段落">
        户口地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${accProvince.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du28" class="ax_文本段落">
        省&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${accCity.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du30" class="ax_文本段落">
        市&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${accCounty.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du32" class="ax_文本段落">
        县（区）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${accTown.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du34" class="ax_文本段落">
        乡（街道）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${accVillage.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du36" class="ax_文本段落">
        村&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${archives.accAddress }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du38" class="ax_文本段落">
        家庭地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${homeProvince.name }
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du44" class="ax_文本段落">
        省&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${homeCity.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du46" class="ax_文本段落">
        市&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${homeCounty.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du48" class="ax_文本段落">
        县（区）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${homeTown.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du50" class="ax_文本段落">
        乡（街道）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${homeVillage.name }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du52" class="ax_文本段落">
        村&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${archives.homeAddress }
      </div>
      
      
      <!-- Unnamed (水平线) -->
      <div id="du115" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

      <!-- Unnamed (形状) -->
      <div id="du20" class="ax_文本段落">
        妈妈姓名：${archives.momName }
      </div>
      
       <!-- Unnamed (形状) -->
      <div id="du54" class="ax_文本段落">
        文化程度：
          <c:if test="${archives.momEducation eq '0' }">小学</c:if>
          <c:if test="${archives.momEducation eq '1' }">初中</c:if>
          <c:if test="${archives.momEducation eq '2' }">高中</c:if>
          <c:if test="${archives.momEducation eq '3' }">中专</c:if>
          <c:if test="${archives.momEducation eq '4' }">大专</c:if>
          <c:if test="${archives.momEducation eq '5' }">本科</c:if>
          <c:if test="${archives.momEducation eq '6' }">硕士</c:if>
          <c:if test="${archives.momEducation eq '7' }">博士</c:if>
          <c:if test="${archives.momEducation eq '8' }">其他</c:if>
          <c:if test="${archives.momEducation eq '9' }">无</c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du56" class="ax_文本段落">
        职&nbsp;&nbsp;&nbsp;&nbsp;业：
        	<c:if test="${archives.momOccupation eq '0'}">农民</c:if>
        	<c:if test="${archives.momOccupation eq '1'}">工人</c:if>
        	<c:if test="${archives.momOccupation eq '2'}">经商</c:if>
        	<c:if test="${archives.momOccupation eq '3'}">干部</c:if>
        	<c:if test="${archives.momOccupation eq '4'}">军人</c:if>
        	<c:if test="${archives.momOccupation eq '5'}">科技</c:if>
        	<c:if test="${archives.momOccupation eq '6'}">医药</c:if>
        	<c:if test="${archives.momOccupation eq '7'}">其他</c:if>
        	<c:if test="${archives.momOccupation eq '8'}">不详</c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du58" class="ax_文本段落">
        工作单位：${archives.momWorkUnit }
      </div>
      
         <!-- Unnamed (形状) -->
      <div id="du24" class="ax_文本段落">
        身份证号：${archives.momIdNo }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du42" class="ax_文本段落">
        出生日期：<fmt:formatDate value="${archives.momBirthday }" pattern="yyyy-MM-dd"/>
      </div>


      <!-- Unnamed (形状) -->
      <div id="du22" class="ax_文本段落">
        年&nbsp; &nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;${momAge }岁
      </div>

      <!-- Unnamed (形状) -->
      <div id="du40" class="ax_文本段落">
        联系电话：${archives.momTele }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du60" class="ax_文本段落">
        健康状况：<c:forEach items="${momHealths }" var="momHealth">
        		<c:if test="${momHealth eq '0' }">健康</c:if>
        		<c:if test="${momHealth eq '1' }">慢性病&nbsp;${archives.momChronicRemark }</c:if>
        		<c:if test="${momHealth eq '2' }">传染病&nbsp;${archives.momInfectiousRemark }</c:if>
           </c:forEach>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="du62" class="ax_文本段落">
        家&nbsp;族&nbsp;史：<c:forEach items="${momFamHistorys }" var="momFamHistory">
		        		<c:if test="${momFamHistory eq '0' }">无特殊</c:if>
		        		<c:if test="${momFamHistory eq '1' }">先天性疾病&nbsp;${archives.momCongenitalRemark }</c:if>
		        		<c:if test="${momFamHistory eq '2' }">遗产性疾病&nbsp;${archives.momHereditaryRemark }</c:if>
		             </c:forEach>
      </div>

         <!-- Unnamed (水平线) -->
      <div id="du114" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
      </div>

      <!-- Unnamed (形状) -->
      <div id="du64" class="ax_文本段落">
        爸爸姓名：${archives.dadName }
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du74" class="ax_文本段落">
        文化程度：
          <c:if test="${archives.dadEducation eq '0' }">小学</c:if>
          <c:if test="${archives.dadEducation eq '1' }">初中</c:if>
          <c:if test="${archives.dadEducation eq '2' }">高中</c:if>
          <c:if test="${archives.dadEducation eq '3' }">中专</c:if>
          <c:if test="${archives.dadEducation eq '4' }">大专</c:if>
          <c:if test="${archives.dadEducation eq '5' }">本科</c:if>
          <c:if test="${archives.dadEducation eq '6' }">硕士</c:if>
          <c:if test="${archives.dadEducation eq '7' }">博士</c:if>
          <c:if test="${archives.dadEducation eq '8' }">其他</c:if>
          <c:if test="${archives.dadEducation eq '9' }">无</c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du76" class="ax_文本段落">
        职&nbsp;&nbsp;&nbsp;&nbsp;业：
        	<c:if test="${archives.dadOccupation eq '0'}">农民</c:if>
        	<c:if test="${archives.dadOccupation eq '1'}">工人</c:if>
        	<c:if test="${archives.dadOccupation eq '2'}">经商</c:if>
        	<c:if test="${archives.dadOccupation eq '3'}">干部</c:if>
        	<c:if test="${archives.dadOccupation eq '4'}">军人</c:if>
        	<c:if test="${archives.dadOccupation eq '5'}">科技</c:if>
        	<c:if test="${archives.dadOccupation eq '6'}">医药</c:if>
        	<c:if test="${archives.dadOccupation eq '7'}">其他</c:if>
        	<c:if test="${archives.dadOccupation eq '8'}">不详</c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du78" class="ax_文本段落">
        工作单位：${archives.dadWorkUnit }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du68" class="ax_文本段落">
        身份证号：${archives.dadIdNo }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du72" class="ax_文本段落">
        出生日期：<fmt:formatDate value="${archives.dadBirthday }" pattern="yyyy-MM-dd"/>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="du66" class="ax_文本段落">
        年&nbsp;&nbsp; &nbsp;&nbsp;龄：&nbsp;&nbsp;${dadAge }岁
      </div>

      <!-- Unnamed (形状) -->
      <div id="du70" class="ax_文本段落">
        联系电话：${archives.dadTele }
      </div>

      <!-- Unnamed (形状) -->
      <div id="du80" class="ax_文本段落">
        健康状况：<c:forEach items="${babHealths }" var="babHealth">
        		<c:if test="${babHealth eq '0' }">健康</c:if>
        		<c:if test="${babHealth eq '1' }">慢性病&nbsp;${archives.babChronicRemark }</c:if>
        		<c:if test="${babHealth eq '2' }">传染病&nbsp;${archives.babInfectiousRemark }</c:if>
           </c:forEach>
      </div>

      <!-- Unnamed (形状) -->
      <div id="du82" class="ax_文本段落">
        家&nbsp;族&nbsp;史：<c:forEach items="${babFamHistorys }" var="babFamHistory">
		        		<c:if test="${babFamHistory eq '0' }">无特殊</c:if>
		        		<c:if test="${babFamHistory eq '1' }">先天性疾病&nbsp;${archives.babCongenitalRemark }</c:if>
		        		<c:if test="${babFamHistory eq '2' }">遗产性疾病&nbsp;${archives.babHereditaryRemark }</c:if>
		             </c:forEach>
      </div>
      
    </div>
