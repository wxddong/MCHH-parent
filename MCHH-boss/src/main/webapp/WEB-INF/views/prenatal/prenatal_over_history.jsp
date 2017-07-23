<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>孕产妇详细历史检查页-已结案</title>
     <style type="text/css">
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
		#u409_state0 {
		  position:absolute;
		  left:0px;
		  top:185px;
		  width:1177px;
		  height:380px;
		  overflow:auto;
		  -webkit-overflow-scrolling:touch;
		  border-style:solid;border-width:1px;border-color:#C8C9CD;
		}
		
		#u412 {
		  
		  left:0px;
		  top:0px;
		  width:1182px;
		  height:380px;
		}
    </style>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/prenatlOverHistory_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
    	$(function(){
    		
    		var p3s = $("#post3to7Size").val();
    		if(p3s > 1){
	   			var top = $("#u168")[0].offsetTop ;
	   			$("#u168")[0].style.top = (top + (p3s-1)*30)+"px";
    		}
    		
    	});
    
    </script>
  </head>
  <body style="background-color: #FFFFFF">
  <div id="base" class="">
    
    	<div id="u8" class="ax_形状" style="background-color:#EE5F45">
          <p id="u9"><span>历史信息查看</span></p>
      	</div>
        
        <c:if test="${birthArchives.riskSign == 1 }">
	        <div id="u6" class="ax_形状" style="background-color:#E9854F">
	          <p id="u7" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchives.id }&archivesId=${birthArchives.archivesId }'" style="cursor: pointer;"><span>专案记录</span></p>
	      	</div>
      	</c:if>
        
        <div id="u0" class="ax_形状" style="background-color:#56BB4D">
          <p id="u1" style="cursor: pointer;" onclick="window.location.href='${ctx}/prenatal/affirmPrenatalArchives?archivesId=${archives.id }'"><span>增加产检</span></p>
      	</div>
        
        <div id="u2" class="ax_形状">
          <p id="u3"><span>&nbsp;</span></p>
      	</div>
        
      <div id="u4" class="ax_形状" style="background-color:#009DD9">
          <p id="u5"><span>个 人 基 本 信 息</span></p>
      	</div>
        
        <div id="u160" class="ax_文本段落">
          <p id="u161"><span>已结案</span></p>
      	</div>
        
        <div id="u162" class="ax_文本段落">
          <p id="u163"><span>结案状态：
				<c:if test="${birthArchives.closingReason == '1' }">流产</c:if>
				<c:if test="${birthArchives.closingReason == '2' }">引产</c:if>
				<c:if test="${birthArchives.closingReason == '3' }">失访</c:if>
				<c:if test="${birthArchives.closingReason == '4' }">其他</c:if>
				<c:if test="${birthArchives.closingReason == '0' }">正常分娩</c:if>
				<c:if test="${birthArchives.closingReason == '5' }">自动结案</c:if>
			</span></p>
      	</div>
        
        <div>
        
        	<div id="u144" class="ax_文本段落" <c:if test="${birthArchives.riskSign == 1 }"> style="color: #EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if>>
          		<p id="u145"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name }</span></p>
      		</div>
            
            <div id="u146" class="ax_文本段落" <c:if test="${birthArchives.riskSign == 1 }"> style="color: #EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if>>
          		<p id="u147"><span>档案编号：${archives.archivesCode }</span></p>
      		</div>
            
            <div id="u158" class="ax_文本段落">
          		<p id="u159"><span>结案日期：<fmt:formatDate value="${birthArchives.closingDate }" pattern="yyyy-MM-dd"/> </span></p>
      		</div>
            
            <div id="u142" class="ax_文本段落">
          		<p id="u143"><span>孕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;周：(已结案)</span></p>
      		</div>
            
            <div id="u136" class="ax_文本段落">
          		<p id="u137"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u148" class="ax_文本段落">
          		<p id="u149"><span>孕妇年龄：${age }</span></p>
      		</div>
            
            <div id="u138" class="ax_文本段落">
          		<p id="u139"><span>末次月经：<fmt:formatDate value="${birthArchives.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u140" class="ax_文本段落">
          		<p id="u141"><span>预&nbsp;&nbsp;产&nbsp;&nbsp;期：<fmt:formatDate value="${birthArchives.predictDate }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u150" class="ax_文本段落">
          		<p id="u151"><span>联系电话：${archives.telephone }</span></p>
      		</div>
            
            <div id="u152" class="ax_文本段落">
          		<p id="u153"><span>丈夫姓名：${archives.manName }</span></p>
      		</div>
            
            <div id="u154" class="ax_文本段落">
          		<p id="u155"><span>丈夫年龄：${manAge }</span></p>
      		</div>
            
            <div id="u156" class="ax_文本段落">
          		<p id="u157"><span>丈夫电话：${archives.manTele }</span></p>
      		</div>
        	
        </div>
        
        <div id="u10" class="ax_形状" style="background-color:#006EbC">
          <p id="u11"><span>历 史 检 查 记 录</span></p>
      	</div>
        
        <div id="u12" class="ax_文本段落">
          <p id="u13"><span>收起</span></p>
      	</div>
        
      <iframe id="u14" scrolling="auto" frameborder="1"></iframe>
      
<!--       <div id="u409" class="ax_动态面板"> -->
        <div id="u409_state0" class="panel_state" data-label="State1">
<!--           <div id="u409_state0_content" class="panel_state_content"> -->
           <div id="u412" class="ax_表格">
      <!-- <div id="u15" class="ax_表格"> -->

        <table width="1500"> 
                      <tr>
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">次数</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="100">
                          <p><span style="color: white;font-weight: bold;">检查日期</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">孕周</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">主诉</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">血压</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40"> 
                          <p><span style="color: white;font-weight: bold;">体重</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">宫高</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">腹围</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">胎方位</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">胎心率</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">先露</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">浮肿</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">血红蛋白</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">尿蛋白</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">血糖</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">唐筛</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">NT</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">四维</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">B超</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">NST</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="100">
                 		   <p><span style="color: white;font-weight: bold;">其他（肝功、肾功、免疫）</span></p>
              		  </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="40">
                          <p><span style="color: white;font-weight: bold;">高危评分</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="80">
                          <p><span style="color: white;font-weight: bold;">高危因素</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">分类</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">转诊</span></p>
                      </td> 
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="100">
                          <p><span style="color: white;font-weight: bold;">下次随访日期</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">产检检查单位</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">随访医生</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="60">
                          <p><span style="color: white;font-weight: bold;">指导</span></p>
                      </td>
        
                      <!-- Unnamed (单元格) -->
                      <td  style="background-color:#999999;border:0.5px solid #FFF" width="50">
                          <p><span style="color: white;font-weight: bold;">操作</span></p>
                      </td>
                  </tr>     
     <!--  --------------------------------------------------------------------------------  -->                  
                      
                      
                      
     
 				<!-- ----------------需要遍历的历史检查记录-------------------------------- -->
 			<%int i = 1; %>
        <c:forEach items="${historyChecks }" var="historyCheck">
                      <!-- Unnamed (单元格) -->
                      <tr>
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span><%=i++ %></span></p>
                      </td>
                      <c:if test="${historyCheck.checkDate!=null }">
                       <td  style="border:0.5px solid #A6A6A6">
                          <p><span><fmt:formatDate value="${historyCheck.checkDate }" pattern="yyyy-MM-dd"/></span></p>
                      </td>
                      </c:if>
        			<c:if test="${historyCheck.checkDate==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
       				 </c:if>
       				 <c:if test="${historyCheck.pregnancyWeeks!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.pregnancyWeeks }</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.pregnancyWeeks==null }">
                      	<td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      	</td>
                      </c:if>
        
                      <c:if test="${historyCheck.chiefComplaint!=null }">
	                      <td  style="border:0.5px solid #A6A6A6">
	                          <p><span>${historyCheck.chiefComplaint }</span></p>
	                      </td>
       				 </c:if>
       				  <c:if test="${historyCheck.chiefComplaint==null }">
	                      <td  style="border:0.5px solid #A6A6A6">
	                          <p><span>-</span></p>
	                      </td>
       				 </c:if>
       				 
       				  <c:if test="${historyCheck.bloodLow!=null || historyCheck.bloodHi!=null }">
	                      <td  style="border:0.5px solid #A6A6A6">
	                          <p><span>${historyCheck.bloodHi }/${historyCheck.bloodLow }</span></p>
	                      </td>
       				 </c:if>
       				 
       				  <c:if test="${historyCheck.bloodLow==null && historyCheck.bloodHi==null }">
	                      <td  style="border:0.5px solid #A6A6A6">
	                          <p><span>-</span></p>
	                      </td>
       				 </c:if>
       				 <c:if test="${historyCheck.weight!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.weight }</span></p>
                      </td>
			        </c:if>
			         <c:if test="${historyCheck.weight==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
			        </c:if>
			        
			         <c:if test="${historyCheck.uterusHight!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.uterusHight }</span></p>
                      </td>
        			 </c:if>
        			   <c:if test="${historyCheck.uterusHight==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
        			 </c:if>
                       <c:if test="${historyCheck.abdomen!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.abdomen }</span></p>
                      </td>
                      </c:if>
                          <c:if test="${historyCheck.abdomen==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.fetusPosition!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.fetusPosition }</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.fetusPosition==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                       <c:if test="${historyCheck.heartRate!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.heartRate }</span></p>
                      </td>
                       </c:if>
                                <c:if test="${historyCheck.heartRate==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
         <c:if test="${historyCheck.present!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.present }</span></p>
                      </td>
        </c:if>
             <c:if test="${historyCheck.present==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
        </c:if>
                      <c:if test="${historyCheck.edema!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.edema }</span></p>
                      </td>
                       </c:if>
                         <c:if test="${historyCheck.edema==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
        
         <c:if test="${historyCheck.hemoglobin!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.hemoglobin }</span></p>
                      </td>
         </c:if>
           <c:if test="${historyCheck.hemoglobin==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
         </c:if>
                       <c:if test="${historyCheck.proteinuria!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.proteinuria }</span></p>
                      </td>
                      </c:if>
                         <c:if test="${historyCheck.proteinuria==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.bloodGlucose!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span><c:if test="${historyCheck.bloodGlucose == '-1' }">未检查</c:if>
                          <c:if test="${historyCheck.bloodGlucose != '-1' }">${historyCheck.bloodGlucose }</c:if></span></p>
                      </td>
                       </c:if>
                          <c:if test="${historyCheck.bloodGlucose==null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
        
                     <c:if test="${historyCheck.tangSyndrome==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.tangSyndrome==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.tangSyndrome==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.tangSyndrome==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
                      
                       <c:if test="${historyCheck.NT==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.NT==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.NT==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.NT==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                               <c:if test="${historyCheck.fourDimensional==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.fourDimensional==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.fourDimensional==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.fourDimensional==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.bScan==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.bScan==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.bScan==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.bScan==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
                      
                     <c:if test="${historyCheck.NST==0 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未检查</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.NST==1 }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>无异常</span></p>
                      </td>
                      </c:if>
                           <c:if test="${historyCheck.NST==2}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
                      <c:if test="${historyCheck.NST==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.others!=null}">
                      <td  style="border:0.5px solid #A6A6A6" >
                          <div  class="autocut" onmouseover="this.className='autocut1'" onmouseout="this.className='autocut'">${historyCheck.others }</div>

                      </td>
                     
                      </c:if>
                       <c:if test="${historyCheck.others==null}">
                      <td  style="border:0.5px solid #A6A6A6" >
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                       <c:if test="${historyCheck.score!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.score }</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.score==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.highRisk!=null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <div class="autocut" onmouseover="this.className='autocut1'" onmouseout="this.className='autocut'">${historyCheck.highRisk }</div>
                      </td>
                      </c:if>
                      
                         <c:if test="${historyCheck.highRisk==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.evaluate==0 || historyCheck.evaluate==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>未见异常</span></p>
                      </td>
                      </c:if>
                         <c:if test="${historyCheck.evaluate==1}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>异常</span></p>
                      </td>
                      </c:if>
        
                       <c:if test="${historyCheck.referral==0 || historyCheck.referral==null}">
                      <td style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
                          <c:if test="${historyCheck.referral==1}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>转诊</span></p>
                      </td>
                      </c:if>
        
                     <c:if test="${historyCheck.nextFollowingDate!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span><fmt:formatDate value="${historyCheck.nextFollowingDate }" pattern="yyyy-MM-dd"/></span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.nextFollowingDate==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.hospital!=null }">
                      <td style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.hospital }</span></p>
                      </td>
                      </c:if>
                       <c:if test="${historyCheck.hospital==null}">
                      <td style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                      </c:if>
        
                      <c:if test="${historyCheck.doctorName!=null }">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>${historyCheck.doctorName }</span></p>
                      </td>
                       </c:if>
                        <c:if test="${historyCheck.doctorName==null}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
        
                       <c:if test="${historyCheck.guidance!=null && historyCheck.guidance!=''}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p class="autocut" onmouseover="this.className='autocut1'" onmouseout="this.className='autocut'"><span>${historyCheck.guidance }</span></p>
                      </td>
                       </c:if>
                        <c:if test="${historyCheck.guidance==null || historyCheck.guidance==''}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
       				 <c:if test="${historyCheck.type==1}">
	                      <!-- Unnamed (单元格) -->
	                      <td  style="background-color:#009DD9;border:0.5px solid #A6A6A6;cursor: pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaDetails?archiveId=${archiveId}&postpartumExaId=${historyCheck.checkId}'">
	                          <p><span >详情</span></p>
	                      </td>
                      </c:if>
                       <c:if test="${historyCheck.type==0}">
	                      <!-- Unnamed (单元格) -->
	                      <td  style="background-color:#009DD9;border:0.5px solid #A6A6A6;cursor: pointer;" onclick="window.location.href='${ctx}/prenatal/prenatalExaDetails?prenatalId=${historyCheck.checkId}&count=<%=i-1 %>'">
	                          <p><span >详情</span></p>
	                      </td>
                      </c:if>
                      </tr>
               </c:forEach>
               </table>
<!--       		</div> -->
<!--       	  </div> -->
      	</div>
      </div>

      
      

      <div id="u164" class="ax_形状" style="background-color:#006EBC">
          <p id="u165"><span>分 娩 信 息</span></p>
      </div>
      
      <div id="u184" class="ax_文本段落">
      	<c:if test="${childbirthBasic.birthDate != null}">
          <p id="u185"><span style="cursor: pointer;"  onclick="window.location.href='${ctx}/archivesinfo/listArchives?id=${archives.id }'">详情</span></p>
      	</c:if>
      </div>
      
      <div id="u170" class="ax_文本段落">
          <p id="u171"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
      
      <div id="u172" class="ax_文本段落">
          <p id="u173"><span>分娩方式：
          	<c:forEach items="${childbirthBabys }" var="baby">
          		<c:if test="${baby.deliveryType == '0' }">剖腹产</c:if>
          		<c:if test="${baby.deliveryType == '1' }">顺产</c:if>&nbsp;
          	</c:forEach>
          </span></p>
      </div>
      
      <div id="u174" class="ax_文本段落">
          <p id="u175"><span>出院时间：<fmt:formatDate value="${childbirthBasic.leaveDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
      
      <div id="u166" class="ax_形状" style="background-color:#006EBC">
          <p id="u167"><span>产 后 访 视 记 录</span></p>
      </div>
     <% int z=0; %>
      <c:forEach items="${post3To7Exas }" var="post3To7Exa">
	      <div id="u176" style="top: <%=(660+z*30) %>px;" class="ax_文本段落">
	          <p id="u177"><span>访视日期：<fmt:formatDate value="${post3To7Exa.creatTime }" pattern="yyyy-MM-dd"/> </span></p>
	      </div>
	      
	      <div id="u178" style="top: <%=(660+z*30) %>px;" class="ax_文本段落">
	          <p id="u179">
	          	<span>分类：
	          		<c:if test="${post3To7Exa.result == 0 }">未见异常</c:if>
	          		<c:if test="${post3To7Exa.result == 1 }">异常 ：${post3To7Exa.remark}</c:if>
	         	</span>
	          </p>
	      </div>
	      
	      <div id="u186" style="top: <%=(654+z*30) %>px;background-color: #006EBC;" class="ax_文本段落">
	          <p id="u187" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaDetails?archiveId=${archives.id}&postpartumExaId=${post3To7Exa.id}'" style="cursor: pointer;"><span>详情</span></p>
	      </div>
 	      <% z ++; %> 
 	  </c:forEach>  
      <input type="hidden" id="post3to7Size" value="${post3to7Size }"/>
      <div id="u168" class="ax_形状" style="background-color:#006EbC">
          <p id="u169"><span>产 后 42 天 健 康 检 查 记 录</span></p>
      </div>
     <% if(z == 0){ z += 1;} %>
      <c:forEach items="${post42Exas }" var="post42Exa"> 
      
	      <div id="u180" style="top: <%=(719+(z-1)*30) %>px;" class="ax_文本段落">
	          <p id="u181"><span>访视日期：<fmt:formatDate value="${post42Exa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
	      </div>
	      
	      <div id="u182" style="top: <%=(719+(z-1)*30) %>px;" class="ax_文本段落">
	          <p id="u183">
		          <span>分类：
		          	<c:if test="${post42Exa.result == 0 }">已恢复</c:if>
		          	<c:if test="${post42Exa.result == 1 }">未恢复：
		          		<c:if test="${post42Exa.reason == 0 }">产褥感染</c:if>
		          		<c:if test="${post42Exa.reason == 1 }">晚期产后出血</c:if>
		          		<c:if test="${post42Exa.reason == 2 }">产褥期抑郁症</c:if>
		          		<c:if test="${post42Exa.reason == 3 }">其他 :&nbsp;${post42Exa.remark }</c:if>
		          	</c:if>
		          </span>
	          </p>
	      </div>
		  
		  <div id="u188" style="background-color: #006EBC; top: <%=(711+(z-1)*30) %>px; " class="ax_文本段落">
	          <p id="u189" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaDetails?archiveId=${archives.id}&postpartumExaId=${post42Exa.id}'" style="cursor: pointer;"><span>详情</span></p>
	      </div>
	      <%-- <div id="u180" style="top: <%=(719+(z+1)*30) %>px;" class="ax_文本段落">
	          <p id="u181"><span>访视日期：<fmt:formatDate value="${post42Exa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
	      </div> --%>
	      <%z++; %>
       </c:forEach> 
    </div>
  </body>
</html>
