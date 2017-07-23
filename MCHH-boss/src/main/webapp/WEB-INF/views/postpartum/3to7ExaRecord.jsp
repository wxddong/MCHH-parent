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
    <title>出院3-7天记录表</title>
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
    	    		var arr = $("#3to7Record").children("div");
    				   for(var i = 0; i <arr.length; i++){
    					   var left = arr[i].offsetLeft;
    					   arr[i].style.left = (left - 200)+"px";
    				   }
    				   $("#3to7Record").jqprint();
    				   for(var i = 0; i <arr.length; i++){
    					   var left = arr[i].offsetLeft;
    					   arr[i].style.left = (left + 200)+"px";
    				   }
    	    
    	});
    });
    </script>
  </head>
  
  <body>
  
<!--   	      Unnamed (形状) -->
<!--       <div id="u10" class="ax_形状"> -->
<%--         <img id="u10_img" class="img " src="${ctx }/static/common/images/42previewbiankuang.png"/> --%>
<!--         Unnamed () -->
<!--         <div id="u11" class="text"> -->
<!--           <p><span>&nbsp;</span></p> -->
<!--         </div> -->
<!--       </div> -->
  
<!--   <div id="printDisplay" class="noprint"> -->
  		      <!-- Unnamed (形状) -->
  <div id="title">		      
      <div id="u2" class="ax_形状" style="background-color:#EE5F45">
          <p id="u3"><span>产后访视记录表</span></p>
      </div>
<!--          Unnamed (形状) -->
<%--       <div id="u8" class="ax_形状" style="background-color:#EE5F45;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/ExaFeedBack?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'"> --%>
<!--           <p id="u9"><span>产后访视反馈单</span></p> -->
<!--       </div> -->

      <!-- Unnamed (形状) -->
      <div id="u4" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" >
          <p id="u5"><span>立即打印</span></p>
      </div>

       <!-- Unnamed (形状) -->
      <div id="u6" class="ax_形状"  style="background-color:#56BB4D;cursor:pointer;" onclick="window.location.href='${ctx}/prenatal/list'">
          <p id="u7"><span>关闭预览</span></p>
      </div>
 </div>     
<!--    </div> -->
     <br>  <br>  <br>  <br>  <br>  <br>
  <div id="3to7Record">
  <div style="font-size: 18px;font-weight: 700px;position:absolute;left: 570px;top: 90px;">产后访视记录表</div>
  <div style="font-size: 14px;position: absolute;left: 230px;top:142px;">姓名：${archives.name }</div>
  <div style="font-size: 14px;position: absolute;left: 845px;top:142px; ">编号：${archives.archivesCode }</div>
  
  <div style="position: absolute;top: 168px;left:220px;">
 <table border="1"  width="800" style="margin: auto;word-break:break-all; word-wrap:break-all;">
 		<tr>
 			<td align="center" style="font-size: 14px" height="50" width="200">随访日期</td>	
 			<td align="center" style="font-size: 14px"><fmt:formatDate value="${postpartumExa.creatTime }" pattern="yyyy-MM-dd"/> </td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">体温</td>	
 			<td  align="center" style="font-size: 14px"> ${postpartumExaDetailed.bodyTemperature }℃</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">血压</td>	
 			<td align="center" style="font-size: 14px">  ${postpartumExaDetailed.bloodLow }/${postpartumExaDetailed.bloodHi }  &nbsp;mmHg</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">一般健康情况</td>	
 			<td  align="center" style="font-size: 14px">${postpartumExaDetailed.health } </td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">一般心理情况</td>	
 			<td  align="center" style="font-size: 14px"> ${postpartumExaDetailed.psychological }</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">乳房</td>	
 			<td align="center" style="font-size: 14px"> <input type="radio" <c:if test="${postpartumExaDetailed.breast==0 }">checked="checked"</c:if>  disabled />1.未见异常  <input type="radio" <c:if test="${postpartumExaDetailed.breast==1 }">checked="checked"</c:if> disabled />2.异常  ${postpartumExaDetailed.breastRemark }</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">恶露</td>	
 			<td align="center" style="font-size: 14px"> <input type="radio" <c:if test="${postpartumExaDetailed.lochia==0 }">checked="checked"</c:if> disabled />1.未见异常  <input type="radio" <c:if test="${postpartumExaDetailed.lochia==1 }">checked="checked"</c:if> disabled />2.异常  ${postpartumExaDetailed.lochiaRemark }</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">子宫</td>	
 			<td align="center" style="font-size: 14px"> <input type="radio" <c:if test="${postpartumExaDetailed.uterus==0 }">checked="checked"</c:if> disabled />1.未见异常  <input type="radio" <c:if test="${postpartumExaDetailed.uterus==1 }">checked="checked"</c:if> disabled />2.异常  ${postpartumExaDetailed.uterusRemark }</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">伤口</td>	
 			<td align="center" style="font-size: 14px"> <input type="radio" <c:if test="${postpartumExaDetailed.wound==0 }">checked="checked"</c:if> disabled />1.未见异常  <input type="radio" <c:if test="${postpartumExaDetailed.wound==1 }">checked="checked"</c:if> disabled />2.异常  ${postpartumExaDetailed.woundRemark }</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">其他</td>	
 			<td align="center" style="font-size: 14px"> ${postpartumExaOther.other} </td>	
 		</tr>
 		 <tr>
 			<td align="center" style="font-size: 14px" height="50">分类</td>	
 			<td align="center" style="font-size: 14px"> <input type="radio" <c:if test="${postpartumExa.result==0 }">checked="checked"</c:if> disabled />1.未见异常  <input type="radio" <c:if test="${postpartumExa.result==1 }">checked="checked"</c:if> disabled />2.异常  ${postpartumExa.remark}</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50" >指导</td>	
 			<td align="center" style="font-size: 14px"> ${postpartumExa.guidance }</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">转诊</td>	
 			<td align="center" style="font-size: 14px"><input type="radio" <c:if test="${postpartumReferral.referral==0 }">checked="checked"</c:if> disabled />1.无  <input type="radio" <c:if test="${postpartumReferral.referral==1 }">checked="checked"</c:if> disabled />2.有  
 			<c:if test="${postpartumReferral.referral==1 }">
 			原因:${postpartumReferral.referralReason }
 			转诊机构：${mechanismName }
 			转诊科室：${postpartumReferral.departmentName }
 			</c:if>
 			</td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">下次随访日期</td>	
 			<td align="center" style="font-size: 14px"> <fmt:formatDate value="${postpartumReferral.nextFollowingDate }" pattern="yyyy-MM-dd"/></td>	
 		</tr>
 		<tr>
 			<td align="center" style="font-size: 14px" height="50">随访医生签名</td>	
 			<td align="center" style="font-size: 14px"> </td>	
 		</tr>
 
 </table> 
 
 </div>     
</div>

      <br><br><br><br><br>
      
     

     
  </body>
</html>
