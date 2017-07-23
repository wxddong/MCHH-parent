<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<style media=print type="text/css"> 
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
/* 		.noprint{visibility:hidden}  */
	</style> 
    <title>产后42天健康检查反馈单-预览</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx }/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/42Preview_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/42Preview_styles1.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${ctx}/static/common/js/jquery.jqprint-0.3.js"></script>
    <script type="text/javascript">
    $(function(){
    	$("#u4").click(function(){
    		var arr = $("#42FeedBack").children("div");
			   for(var i = 0; i <arr.length; i++){
				   var left = arr[i].offsetLeft;
				   arr[i].style.left = (left - 170)+"px";
			   }
			   $("#42FeedBack").jqprint();
			   for(var i = 0; i <arr.length; i++){
				   var left = arr[i].offsetLeft;
				   arr[i].style.left = (left + 170)+"px";
			   }
    	});
    });
    </script>
  </head>
  
  <body>
  
  	      <!-- Unnamed (形状) -->
      <div id="u10" class="ax_形状">
        <img id="u10_img" class="img " src="${ctx }/static/common/images/42previewbiankuang.png"/>
        <!-- Unnamed () -->
        <div id="u11" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>
  <div id="title">	
<!--   <div id="printDisplay" class="noprint"> -->
  		      <!-- Unnamed (形状) -->
      <div id="u2" class="ax_形状" style="background-color:#EE5F45;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaRecord?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'">
          <p id="u3"><span>产后42天健康检查记录</span></p>
      </div>
         <!-- Unnamed (形状) -->
<!--       <div id="u8" class="ax_形状" style="background-color:#999999" > -->
<!--           <p id="u9"><span>产后42天健康检查反馈单</span></p> -->
<!--       </div> -->

      <!-- Unnamed (形状) -->
      <div id="u4" class="ax_形状" style="background-color:#009DD9;cursor:pointer;">
          <p id="u5"><span>立即打印</span></p>
      </div>

       <!-- Unnamed (形状) -->
      <div id="u6" class="ax_形状"  style="background-color:#56BB4D;cursor:pointer;" onclick="window.location.href='${ctx}/prenatal/list'">
          <p id="u7"><span>关闭预览</span></p>
      </div>
<!--      </div> -->
  </div>   
 
<div id="42FeedBack">
      <!-- Unnamed (形状) -->
      <div id="u12" class="ax_文本段落">
          <p id="u13"><span style="font-size: 18px;">产后42天健康检查反馈单</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u14" class="ax_文本段落">
          <p id="u15"><span>档案编号：${archives.archivesCode }</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u18" class="ax_文本段落">
          <p id="u19"><span>孕妇姓名：${archives.name }</span></p>
      </div>
         <!-- Unnamed (形状) -->
      <div id="u16" class="ax_文本段落">
          <p id="u17"><span>年龄：${womenAge }</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u20" class="ax_文本段落">
          <p id="u21"><span>检查日期：<fmt:formatDate value="${postpartumExa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u22" class="ax_文本段落">
          <p id="u23"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u24" class="ax_水平线">
			<hr style="border:1px dashed #B5B5B5;" />
      </div>

      <!-- Unnamed (形状) -->
      <div id="u34" class="ax_文本段落">
          <p id="u35"><span>血&nbsp; 压：${postpartumExaDetailed.bloodLow }/${postpartumExaDetailed.bloodHi }</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u40" class="ax_文本段落">
          <p id="u41"><span>乳&nbsp; 房：<c:if test="${postpartumExaDetailed.breast==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.breast==1 }">${postpartumExaDetailed.breastRemark }</c:if></span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u42" class="ax_文本段落">
          <p id="u43"><span>恶&nbsp; 露：<c:if test="${postpartumExaDetailed.lochia==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.lochia==1 }">${postpartumExaDetailed.lochiaRemark }</c:if></span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u44" class="ax_文本段落">
          <p id="u45"><span>子&nbsp; 宫：<c:if test="${postpartumExaDetailed.uterus==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.uterus==1 }">${postpartumExaDetailed.uterusRemark }</c:if></span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u46" class="ax_文本段落">
          <p id="u47"><span>伤&nbsp; 口：<c:if test="${postpartumExaDetailed.wound==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.wound==1 }">${postpartumExaDetailed.woundRemark }</c:if></span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u36" class="ax_文本段落">
          <p id="u37"><span>血常规</span><span>：</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u38" class="ax_文本段落">
          <p id="u39"><span>尿常规</span><span>：</span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u48" class="ax_文本段落">
          <p id="u49"><span>其他：</span></p>
      </div>
            <!-- Unnamed (形状) -->
      <div id="u54" class="ax_文本段落">
          	<c:if test="${postpartumExaOther.vulva==1 }">外阴：${postpartumExaOther.vulvaRemark };</c:if>
          	<c:if test="${postpartumExaOther.vagina==1 }">阴道：${postpartumExaOther.vaginaRemark };</c:if>
          	<c:if test="${postpartumExaOther.cervical==1 }">宫颈：${postpartumExaOther.cervicalRemark };</c:if>
          	<c:if test="${postpartumExaOther.other!='' && postpartumExaOther.other!=null}">其他：${postpartumExaOther.other}</c:if>
      </div>
      
            <!-- Unnamed (形状) -->
      <div id="u25" class="ax_文本段落">
          <p id="u26"><span>分类：<c:if test="${postpartumExa.result==0 }">已恢复</c:if>
          						 <c:if test="${postpartumExa.result==1 }">未恢复&nbsp;&nbsp;&nbsp;
					 				原因： <c:if test="${postpartumExa.reason==0 }">产褥感染</c:if>
					 					 <c:if test="${postpartumExa.reason==1 }">晚期产后出血</c:if>
					 					 <c:if test="${postpartumExa.reason==2 }">产褥期抑郁症</c:if>
					 					 <c:if test="${postpartumExa.reason==3 }">${postpartumExa.remark }</c:if>
          						 </c:if></span></p>
          						 
					 			
      </div>
      
      
             <!-- Unnamed (形状) -->
      <div id="u27" class="ax_文本段落">
          	指导意见：
      </div>
      <!-- Unnamed (形状) -->
      <div id="u27-" class="ax_文本段落">
          	${postpartumExa.guidance }
      </div>

      <c:if test="${postpartumReferral.referral==1 }">
	      		       <!-- Unnamed (形状) -->
	      <div id="u50" class="ax_文本段落">
	          <p id="u51"><span>转诊原因：${postpartumReferral.referralReason }</span></p>
	      </div>
	      
	      <!-- Unnamed (形状) -->
	      <div id="u52" class="ax_文本段落">
	          <p id="u53"><span>转诊机构：${mechanismName }   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span>&nbsp;&nbsp; </span><span>科室：${postpartumReferral.departmentName }</span></p>
	      </div>
      </c:if>
      
      <!-- Unnamed (形状) -->
      <div id="u29" class="ax_文本段落">
          <p id="u30"><span>医</span><span>生签名：</span></p>
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u31" class="ax_水平线">
      		<HR width="80%" color=#333333 SIZE=1 />
      </div>

      <!-- Unnamed (形状) -->
      <div id="u32" class="ax_文本段落">
          <p id="u33"><span>*以上意见仅供参考，如有不适，请及时随诊*</span></p>
      </div>
 </div>     
  </body>
</html>
