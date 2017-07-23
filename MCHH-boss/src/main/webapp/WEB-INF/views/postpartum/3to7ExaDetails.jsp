<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>出院3到7天访视</title>
	<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>

	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx }/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/3to7exaDetails_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/3to7exaDetails_styles1.css" type="text/css" rel="stylesheet"/>
</head>
	<style type="text/css">
		 #title {
		position:fixed;
		left: 0px;
		top: 0px;
		width:1180px;
		line-height:44px;
		height:44px;
		z-index:9999;
		background: #FFFFFF; 
		border:1px solid #CCCCCC;
		}
	</style>
	<script type="text/javascript">
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
		});
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
	</script>
<body>
	<div id="title">
          <!-- Unnamed (形状) -->
      <div id="u83" class="ax_形状" style="background-color:#EE5F45">
          <p id="u84"><span>产后访视详情</span></p>
      </div>
      
     
     <c:if test="${(currentDoctorId==checkDoctorId || currentDoctorId==doctorAdminId) && birthArchives.riskSign==1 && birthArchives.pregnantState!=2 }">
		      <div id="u85" class="ax_形状" style="background-color:#E9854F;cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchivesId}&archivesId=${archiveId }'">
		          <p id="u86"><span>专案</span><span>记录</span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u111" class="ax_形状" style="background-color:#56BB4D;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/toPostExaEdit?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'">
		          <p id="u112"><span>编辑</span></p>
		      </div>
      </c:if>
      
      
       <c:if test="${(currentDoctorId!=checkDoctorId || birthArchives.pregnantState==2) && birthArchives.riskSign==1 && currentDoctorId!=doctorAdminId }">
	      <div id="u111" class="ax_形状" style="background-color:#E9854F;cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchivesId}&archivesId=${archiveId }'">
	          <p id="u112"><span>专案记录</span></p>
	      </div>
      </c:if>
      
      
       
       <c:if test="${(currentDoctorId==checkDoctorId || currentDoctorId==doctorAdminId) && birthArchives.riskSign ==0 && birthArchives.pregnantState!=2}">
	      <!-- Unnamed (形状) -->
	      <div id="u111" class="ax_形状" style="background-color:#56BB4D;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/toPostExaEdit?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'">
	          <p id="u112"><span>编辑</span></p>
	      </div>
      </c:if>
      
      
      
<!--         Unnamed (形状) -->
<%--       <div id="u107" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaRecord?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'"> --%>
<!--           <p id="u108"><span>产后访视记录表</span></p> -->
<!--       </div> -->
      
<!--             Unnamed (形状) -->
<%--       <div id="u109" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/ExaFeedBack?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'"> --%>
<!--           <p id="u110"><span>产后访视反馈单</span></p> -->
<!--       </div> -->
      
            <!-- Unnamed (形状) -->
      <div id="u109" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaRecord?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'">
          <p id="u110"><span>产后访视记录表</span></p>
      </div>
   </div>
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
      
            <!-- Unnamed (形状) -->
      <div id="u4" class="ax_形状" style="background-color:#009DD9">
          <p id="u5"><span>个 人 基 本 信 息</span></p>
      </div>
      
     <c:if test="${birthArchives.riskSign ==0 }"> 
            <!-- Unnamed (形状) -->
	      <div style="font-weight: 500;color: black" id="u14" class="ax_文本段落">
	          <p id="u15"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name } </span></p>
	      </div>
	             <!-- Unnamed (形状) -->
	      <div style="font-weight: 500;color: black" id="u16" class="ax_文本段落">
	          <p id="u17"><span>档案编号</span><span>：${archives.archivesCode }</span></p>
	      </div>
      </c:if>
       <c:if test="${birthArchives.riskSign ==1 }"> 
            <!-- Unnamed (形状) -->
	      <div  id="u14" class="ax_文本段落">
	          <p id="u15"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name } </span></p>
	      </div>
	             <!-- Unnamed (形状) -->
	      <div id="u16" class="ax_文本段落">
	          <p id="u17"><span>档案编号</span><span>：${archives.archivesCode }</span></p>
	      </div>
      </c:if>
      
            <!-- Unnamed (形状) -->
      <div id="u6" class="ax_文本段落">
          <p id="u7"><span>出生日期：<fmt:formatDate value="${archives.birthday }" pattern="yyyy-MM-dd"/></span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u20" class="ax_文本段落">
          <p id="u21"><span>联系电话</span><span>：${archives.telephone }</span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u87" class="ax_文本段落">
          <p id="u88"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u18" class="ax_文本段落">
          <p id="u19"><span>孕妇年龄：${womenAge }</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u22" class="ax_文本段落">
          <p id="u23"><span>丈夫姓名：${archives.manName }</span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u105" class="ax_文本段落">
          <p id="u106"><span>出院日期：<fmt:formatDate value="${childbirthBasic.leaveDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u28" class="ax_文本段落">
          <p id="u29"><span>检查日期：<fmt:formatDate value="${postpartumExa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u8" class="ax_文本段落">
          <p id="u9"><span>末次月经：<fmt:formatDate value="${birthArchives.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u24" class="ax_文本段落">
          <p id="u25"><span>丈夫年龄：${manAge }</span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u12" class="ax_文本段落">
          <p id="u13"><span>孕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;周：${childbirthBasic.gestationalWeek }</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u10" class="ax_文本段落">
          <p id="u11"><span>预 &nbsp;产 &nbsp;期：<fmt:formatDate value="${expectedDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u26" class="ax_文本段落">
          <p id="u27"><span>丈夫电话：${archives.manTele }</span></p>
      </div>
      

      <!-- Unnamed (形状) -->
      <div id="u36" class="ax_形状" name="foldDiv1" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv2','u39',10)">
          <p id="u37"><span>一 般 检 查</span></p>
          <p id="u39"><span>收起</span></p>
      </div>
      <!-- Unnamed (形状) -->
<!--       <div id="u38" class="ax_文本段落"> -->
<!--           <p id="u39"><span>收起</span></p> -->
<!--       </div> -->



<div name="foldDiv2" style="height: 225px;">

	  <div id="u40" class="ax_文本段落">
          <p id="u41"><span>体温：</span></p>
      </div>
      <div id="u42" class="ax_文本段落">
          <p id="u43"><span>${postpartumExaDetailed.bodyTemperature }℃</span></p>
      </div>
      <div id="u44" class="ax_文本段落">
          <p id="u45"><span>血压</span><span>：</span></p>
      </div>
      <div id="u48" class="ax_文本段落">
          <p id="u49"><span>${postpartumExaDetailed.bloodLow }/${postpartumExaDetailed.bloodHi }</span></p>
      </div>
      <div id="u46" class="ax_文本段落">
          <p id="u47"><span>mmHg</span></p>
      </div>
      <div id="u97" class="ax_文本段落">
          <p id="u98"><span>一般健康情况：${postpartumExaDetailed.health }</span></p>
      </div>
      <div id="u99" class="ax_文本段落">
          <p id="u100"><span>一般心理状况</span><span>：${postpartumExaDetailed.psychological }</span></p>
      </div>
      <div id="u89" class="ax_文本段落">
          <p id="u90"><span>乳房：<c:if test="${postpartumExaDetailed.breast==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.breast==1 }">${postpartumExaDetailed.breastRemark }</c:if></span></p>
      </div>
      <div id="u91" class="ax_文本段落">
          <p id="u92"><span>恶露：<c:if test="${postpartumExaDetailed.lochia==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.lochia==1 }">${postpartumExaDetailed.lochiaRemark }</c:if></span></p>
      </div>
      <div id="u93" class="ax_文本段落">
          <p id="u94"><span>子宫：<c:if test="${postpartumExaDetailed.uterus==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.uterus==1 }">${postpartumExaDetailed.uterusRemark }</c:if></span></p>
      </div>
      <div id="u95" class="ax_文本段落">
          <p id="u96"><span>伤口：<c:if test="${postpartumExaDetailed.wound==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.wound==1 }">${postpartumExaDetailed.woundRemark }</c:if></span></p>
      </div>
      
</div>



     <div id="u101" name="foldDiv3" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv4','u104',10)">
              <p id="u102"><span>其</span><span>&nbsp;</span><span>他</span></p>
              <p id="u104"><span>收起</span></p>
     </div>

<!--       <div id="u103" class="ax_文本段落"> -->
<!--           <p id="u104"><span>收起</span></p> -->
<!--       </div> -->
		
<div name="foldDiv4" style="height:92px;">
	<div id="qita" class="ax_文本段落">
		 ${postpartumExaOther.other }
	</div>
</div>	


      <div id="u50" name="foldDiv5" class="ax_形状"  style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv6','u53',10)">
          <p id="u51"><span>分</span><span>&nbsp;</span><span>类</span></p>
           <p id="u53"><span>收起</span></p>
      </div>
      <!-- Unnamed (形状) -->
<!--       <div id="u52" class="ax_文本段落"> -->
<!--           <p id="u53"><span>收起</span></p> -->
<!--       </div> -->

<div name="foldDiv6" style="height: 43px;">

      <!-- Unnamed (形状) -->
      <div id="u54" class="ax_文本段落">
          <p id="u55"><span>分类：<c:if test="${postpartumExa.result==0 }">未见异常</c:if><c:if test="${postpartumExa.result==1 }">异常 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${postpartumExa.remark }</c:if></span></p>
      </div>

</div>


      <!-- Unnamed (形状) -->
      <div id="u56" class="ax_形状" name="foldDiv7" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv8','u59',10)">
          <p id="u57"><span>保 健 指 导</span></p>
          <p id="u59"><span>收起</span></p>
      </div>
      <!-- Unnamed (形状) -->
<!--       <div id="u58" class="ax_文本段落"> -->
<!--           <p id="u59"><span>收起</span></p> -->
<!--       </div> -->
      
<div name="foldDiv8" style="height: 152px;">
	<div id="zhidao" class="ax_文本段落">
		 ${postpartumExa.guidance }
	</div>
</div>

      <!-- Unnamed (形状) -->
      <div id="u60" name="foldDiv9" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv10','u63',10)">
          <p id="u61"><span>转</span><span>&nbsp;</span><span>诊</span></p>
           <p id="u63"><span>收起</span></p>
      </div>
      <!-- Unnamed (形状) -->
<!--       <div id="u62" class="ax_文本段落"> -->
<!--           <p id="u63"><span>收起</span></p> -->
<!--       </div> -->

<div name="foldDiv10" style="height: 20px;">

 <c:if test="${postpartumReferral.referral==1 }">
      <!-- Unnamed (形状) -->
      <div id="u64" class="ax_文本段落">
          <p id="u65"><span>转诊</span><span>：是</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u66" class="ax_文本段落">
          <p id="u67"><span>原因：${postpartumReferral.referralReason }</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u68" class="ax_文本段落">
          <p id="u69"><span>转诊机构：${postpartumReferral.mechanism }</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u70" class="ax_文本段落">
          <p id="u71"><span>转诊科室：${postpartumReferral.departmentName }</span></p>
      </div>
    </c:if>
    
     <c:if test="${postpartumReferral.referral==0 }">
      <!-- Unnamed (形状) -->
      <div id="u64" class="ax_文本段落">
          <p id="u65"><span>转诊</span><span>：否</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u66" class="ax_文本段落">
          <p id="u67"><span>原因：</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u68" class="ax_文本段落">
          <p id="u69"><span>转诊机构：</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u70" class="ax_文本段落">
          <p id="u71"><span>转诊科室：</span></p>
      </div>
    </c:if>
    
    
      <!-- Unnamed (形状) -->
      <div id="u72" class="ax_文本段落">
          <p id="u73"><span>下次随访日期</span><span>：<fmt:formatDate value="${postpartumReferral.nextFollowingDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u74" class="ax_文本段落">
          <p id="u75"><span>是否预约下次检查：
           <c:if test="${postpartumReferral.orderCheck==1 }">是</c:if>
           <c:if test="${postpartumReferral.orderCheck==0 }">否</c:if>
          </span></p>
      </div>
      
      
      <!-- Unnamed (水平线) -->
      <div id="u82" class="ax_水平线">
			<hr style="border:1px dashed #B5B5B5;" />
      </div>
      
            <!-- Unnamed (形状) -->
      <div id="u76" class="ax_文本段落">
          <p id="u77"><span>母子健康手册使用：
          <c:if test="${postpartumReferral.healthHandbook==0 }">未使用</c:if>
          <c:if test="${postpartumReferral.healthHandbook==1 }">使用</c:if>
          </span></p>
      </div>
      
      
<!--       Unnamed (形状) -->
<!--       <div id="u78" class="ax_文本段落"> -->
<!--           <p id="u79"><span>叶酸发放：</span></p> -->
<!--       </div> -->
      
<!--             Unnamed (形状) -->
<!--       <div id="u80" class="ax_文本段落"> -->
<!--           <p id="u81"><span>发放数量：</span><span>&nbsp;</span><span>&nbsp; &nbsp; </span><span>&nbsp; &nbsp; &nbsp; </span><span>&nbsp; &nbsp; &nbsp;&nbsp; </span><span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; </span><span>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; </span><span>&nbsp;</span><span>&nbsp;</span><span>瓶</span></p> -->
<!--       </div> -->

</div>
</body>
</html>