<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		#title {
		position:fixed;
		left: 0px;
		top: 0px;
		width:1177px;
		line-height:44px;
		height:44px;
		z-index:9999;
		background: #FFFFFF; 
		border:1px solid #CCCCCC;
		}
		#u1660 {
		  position:absolute;
		  left:230px;
		  top:10px;
		  width:120px;
		  height:35px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u1670 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u1661 {
		  position:absolute;
		  left:360px;
		  top:10px;
		  width:120px;
		  height:35px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u1671 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:116px;
		  word-wrap:break-word;
		}
		#jau0 {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:346px;
		}
		#jau1 {
		  position:absolute;
		  left:2px;
		  top:165px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#jau2 {
		  position:absolute;
		  left:410px;
		  top:246px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#jau3 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#jau4 {
		  position:absolute;
		  left:190px;
		  top:246px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#jau5 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#jau6 {
		  position:absolute;
		  left:296px;
		  top:120px;
		  width:129px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#jau7 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:129px;
		  white-space:nowrap;
		}
		#jau8 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#jau9 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#jau10 {
		  position:absolute;
		  left:150px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#jau11 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		#jau10_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#jau12 {
		  position:absolute;
		  left:270px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#jau13 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		#jau12_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#jau14 {
		  position:absolute;
		  left:390px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#jau15 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		#jau14_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#jau16 {
		  position:absolute;
		  left:510px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#jau17 {
		  position:absolute;
		  left:16px;
		  top:0px;
		  width:82px;
		  word-wrap:break-word;
		}
		#jau16_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		
		#u409_state0 {
		  position:absolute;
		  left:0px;
		  top:185px;
		  width:1177px;
		  height:400px;
		  overflow:auto;
		  -webkit-overflow-scrolling:touch;
		  border-style:solid;border-width:1px;border-color:#C8C9CD;
		}
		
		#u412 {
		  
		  left:0px;
		  top:0px;
		  width:1182px;
		  height:400px;
		}
	</style>
    <title>孕产妇详细历史检查页-妊娠中</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/prenatlGestationHistory_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
    	$(function(){
    		//点击已结案
    		$("#u165").click(function(){
    			
    			showDialog_("提示","closeExa","moremiddleOver",false);
    		});
			
			//确定
			$("#jau5").click(function(){
				var status = $("input[name='closingReason']:checked").val();
				if(status == null && status == undefined){
					alert("请选择结案原因!");
					return false;
				}
				$("#closeForm").submit();
			});
			
			//取消
			$("#jau3").click(function(){
				
				$("#closeExa").window("close");
			});
    		
    	});
    
    </script>
  </head>
  <body style="background-color: #FFFFFF">
  <div id="base" class="">
    
    	<div id="title">
    	<div id="u4" class="ax_形状" style="background-color:#EE5F45">
          <p id="u5"><span>历史信息查看</span></p>
      	</div>
        <c:if test="${nomal == '0' }">
        <div id="u1660" class="ax_形状" style="background-color:#34A097">
          <p id="u1670" style="cursor: pointer;" onclick="window.location.href='${ctx}/prenatal/suppleFirstPrenatal?birthArchivesId=${birthArchives.id }'"><span>补卡</span></p>
      	</div>
      	</c:if>
      
		<div id="u1661" class="ax_形状" style="background-color:#34A097">
          <p id="u1671" onclick="window.location.href='${ctx}/prenatal/suppleSecondToNPrenatal?birthArchivesId=${birthArchives.id }'" style="cursor: pointer;"><span>补随访</span></p>
      	</div>
        
        <div id="u166" class="ax_形状" style="background-color:#34A097">
          <p id="u167" style="cursor: pointer;" onclick="window.location.href='${ctx}/archivesinfo/listChildbirth?id=${archives.id }'"><span>分娩登记</span></p>
      	</div>
        
        <div id="u164" class="ax_形状" style="background-color:#999999">
          <p id="u165" style="cursor: pointer;"><span>结案</span></p>
      	</div>
        
        <c:if test="${birthArchives.riskSign == 1 }">
	        <div id="u160" class="ax_形状" style="background-color:#E9854F">
	          <p id="u161" style="cursor: pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchives.id }&archivesId=${birthArchives.archivesId }'"><span>专案记录</span></p>
	      	</div>
      	</c:if>
        
        <!-- <div id="u162" class="ax_形状" style="background-color:#56BB4D">
          <p id="u163"><span>增加随访</span></p>
      	</div> -->
      	<c:if test="${operator.depId != birthArchives.outHospitalId || birthArchives.referralSign != '1'}">
	        <div id="u158" class="ax_形状" style="background-color:#56BB4D">
	          <p id="u159" style="cursor: pointer;" onclick="window.location.href='${ctx}/archivesinfo/comePrenatalExa?id=${archives.id }'"><span>新增随访</span></p>
	      	</div>
      	</c:if>
      	</div>
        <div id="u0" class="ax_形状">
          <p id="u1"><span>&nbsp;</span></p>
      	</div>
        
        <div id="u2" class="ax_形状" style="background-color:#009DD9">
          <p id="u3"><span>个 人 基 本 信 息</span></p>
      	</div>
        
        <div id="u156" class="ax_文本段落">
          <p id="u157"><span>妊娠中</span></p>
   	  </div>
        
        <div>
        	
            <div id="u140" class="ax_文本段落" <c:if test="${birthArchives.riskSign == 1 }">style="color:#EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if> >
          		<p id="u141"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name } </span></p>
      		</div>
            
            <div id="u142" class="ax_文本段落" <c:if test="${birthArchives.riskSign == 1 }">style="color:#EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if>>
          		<p id="u143"><span>档案编号：${archives.archivesCode }</span></p>
      		</div>
            
            <div id="u154" class="ax_文本段落">
          		<p id="u155"><span>建档日期：<fmt:formatDate value="${archives.creatTime }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u138" class="ax_文本段落">
          		<p id="u139"><span>孕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;周：${week }</span></p>
      		</div>
            
            <div id="u132" class="ax_文本段落">
          		<p id="u133" ><span>分娩日期：无</span></p>
      		</div>
            
            <div id="u144" class="ax_文本段落">
          		<p id="u145"><span>孕妇年龄：${age }</span></p>
      		</div>
            
            <div id="u134" class="ax_文本段落">
          		<p id="u135"><span>末次月经：<fmt:formatDate value="${birthArchives.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u136" class="ax_文本段落">
          		<p id="u137"><span>预&nbsp;&nbsp;产&nbsp;&nbsp;期：<fmt:formatDate value="${birthArchives.predictDate }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u146" class="ax_文本段落">
          		<p id="u147"><span>联系电话：${archives.telephone }</span></p>
      		</div>
            
            <div id="u148" class="ax_文本段落">
          		<p id="u149"><span>丈夫姓名：${archives.manName }</span></p>
      		</div>
            
            <div id="u150" class="ax_文本段落">
          		<p id="u151"><span>丈夫年龄：${manAge }</span></p>
      		</div>
            
            <div id="u152" class="ax_文本段落">
          		<p id="u153"><span>丈夫电话：${archives.manTele }</span></p>
      		</div>
            
        </div>
        
        <div id="u6" class="ax_形状" style="background-color:#006Ebc">
          <p id="u7"><span>历 史 检 查 记 录</span></p>
      	</div>
        
        <div id="u8" class="ax_文本段落">
          <p id="u9"><span>收起</span></p>
      	</div>

      <iframe id="u10" scrolling="auto" frameborder="1"></iframe>
<!-- 	<div id="u409" class="ax_动态面板"> -->
        <div id="u409_state0" class="panel_state" data-label="State1">
<!--           <div id="u409_state0_content" class="panel_state_content"> -->
            <div id="u412" class="ax_表格">
            	<!-- <div id="u410" class="ax_形状">
					<p id="u411"><span>&nbsp;</span></p>
				</div> -->
<!--       		<div id="u11" class="ax_表格"> -->
      		
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
                          <p><span>${historyCheck.bloodGlucose }</span></p>
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
                       <c:if test="${historyCheck.type==0}">
	                      <!-- Unnamed (单元格) -->
	                      <td  style="background-color:#009DD9;border:0.5px solid #A6A6A6;cursor: pointer;" onclick="window.location.href='${ctx}/prenatal/prenatalExaDetails?prenatalId=${historyCheck.checkId}&count=<%=i-1 %>'">
	                          <p><span>详情</span></p>
	                      </td>
                      </c:if>
                      </tr>
               </c:forEach>
               </table>
      		</div>
<!--       	</div> -->
<!--      </div> -->
      
</div>
  <div id="closeExa" class="easyui-dialog" title="角色" closed="true">
		<form id="closeForm" action="${ctx }/prenatal/closeExa" method="post">
		<!-- <div id="jau8" class="ax_形状" style="background-color:#EE5F45">
          <p id="jau9"><span>提&nbsp; &nbsp; 示</span></p>
      	</div> -->
        
        <div id="jau6" class="ax_文本段落">
          <p id="jau7"><span>请选择结案原因：</span></p>
      	</div>
        
        <div id="jau10" class="ax_单选按钮">
            <label for="u10_input">
                <p id="jau11"><span> 流产</span></p>
            </label>
            <input id="jau10_input" type="radio" value="1" name="closingReason"/>
      	</div>
        
        <div id="jau12" class="ax_单选按钮">
            <label for="u12_input">
                <p id="jau13"><span> 引产</span></p>
            </label>
            <input id="jau12_input" type="radio" value="2" name="closingReason"/>
      	</div>
        
         <div id="jau14" class="ax_单选按钮">
            <label for="u14_input">
                <p id="jau15"><span> 失访</span></p>
            </label>
            <input id="jau14_input" type="radio" value="3" name="closingReason"/>
      	</div>
        
         <div id="jau16" class="ax_单选按钮">
            <label for="u16_input">
                <p id="jau17"><span> 其他</span></p>
            </label>
            <input id="jau16_input" type="radio" value="4" name="closingReason"/>
      	</div>
        <input type="hidden" name="birthId" value="${birthArchives.id }"/>
        <div id="jau4" class="ax_形状" style="background-color:#e9854f">
          <p id="jau5" style="cursor:pointer;"><span>确定</span></p>
      	</div>
        
        <div id="jau2" class="ax_形状" style="background-color:#009DD9">
          <p id="jau3" style="cursor:pointer;"><span>取消</span></p>
      	</div>
     </form>
    </div>
    </div>
  </body>
</html>
