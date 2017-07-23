<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>第1次产前随访记录表-预览</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<script type="text/javascript" src="${ctx}/static/common/js/jquery.jqprint-0.3.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/2ToNPrenatalPreview_style.css" type="text/css" rel="stylesheet"/>

    <script type="text/javascript">
     	$(function(){
     		
     		var go = $("#go").val();
     		if(go == "1"){
     			$("#u2").css("background-color","#999999");
    			$("#u73").css("background-color","#EE5F45");
    			$("#preview").hide();
    			$("#pPreview").show();
     		}
     		
			$("#u74").click(function(){
    			
    			$("#u2").css("background-color","#999999");
    			$("#u73").css("background-color","#EE5F45");
    			$("#preview").hide();
    			$("#pPreview").show();
    			
    		});
    		$("#u3").click(function(){
    			
    			$("#u2").css("background-color","#EE5F45");
    			$("#u73").css("background-color","#999999");
    			$("#preview").show();
    			$("#pPreview").hide();
    			
    		});
    		
    		$("#u5").click(function(){
    			
    			var display =$('#preview').css('display');
    			if(display == 'none'){
    				var arr = $("#pPreview").children("div");
      				for(var i = 0; i <arr.length; i++){
      				   var left = arr[i].offsetLeft;
      				   arr[i].style.left = (left - 170)+"px";
      			   	}
    				
    			   $("#pPreview").jqprint();
    			   
    			   for(var i = 0; i <arr.length; i++){
      				   var left = arr[i].offsetLeft;
      				   arr[i].style.left = (left + 170)+"px";
      			   }
    			}
    			
    			var display2 =$('#pPreview').css('display');
    			if(display2 == 'none'){
    				
    			   var arr = $("#preview").children("div");
       			   for(var i = 0; i <arr.length; i++){
       				   var left = arr[i].offsetLeft;
       				   arr[i].style.left = (left - 170)+"px";
       			   }
    			   $("#preview").jqprint();
    			   for(var i = 0; i <arr.length; i++){
     				   var left = arr[i].offsetLeft;
     				   arr[i].style.left = (left + 170)+"px";
     			   }
    			}
    			
    		});
    		
    		$("#u7").click(function(){
    			
    			window.location.href = "${ctx}/prenatal/list";
    			
    		});
     		
     	});
    </script>
  </head>
  <body style="background-color: #FFFFFF">
    <div id="base" class="">
    	<input id="go" type="hidden" value="${go }"/>
    	<div>
        	<div id="u2" class="ax_形状" style="background-color:#EE5F45">
          		<p id="u3" style="cursor:pointer"><span>第${count }次产前随访记录表</span></p>
      		</div>
            <div id="u73" class="ax_形状" style="background-color:#999999">
          		<p id="u74" style="cursor:pointer"><span>产前检查反馈单</span></p>
      		</div>
            <div id="u4" class="ax_形状" style="background-color:#009DD9">
          		<p id="u5" style="cursor:pointer"><span>立即打印</span></p>
      		</div>
            <div id="u6" class="ax_形状" style="background-color:#56BB4D">
          		<p id="u7" style="cursor:pointer"><span>关闭预览</span></p>
      		</div>
        </div>
        
        <div id="preview">
        	
            <div id="u8" class="ax_形状" style="border:1px solid #000">
          		<p id="u9"><span>&nbsp;</span></p>
      		</div>
      		<c:if test="${map.birthArchives.riskSign == '1'}">
      		<div style="position: absolute;top: 100px;left: 200px;width: 90px;height: 30px;font-size: 15px;color: #EE5F45;font-weight: 700;">
      			<p>*高危孕产妇</p>
      		</div>
            </c:if>
          	<div id="u10" class="ax_文本段落">
          		<p id="u11"><span style="font-size: 18px;">第${count }次产前随访服务记录表</span></p>
      		</div>
            
            <div id="u12" class="ax_文本段落">
          		<p id="u13"><span style="font-size: 14px;">姓名：${map.archives.name }</span></p>
          		
      		</div>
            
            <div id="u14" class="ax_文本段落">
          		<p id="u15" ><span style="font-size:14px;">编号</span><span style="font-size:14px;">：</span><span style="font-size:14px;">${map.archives.archivesCode }</span></p>
      		</div>
            
            <div id="u16" class="ax_水平线">
        		<hr id="u16_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
      		<div id="u17" class="ax_垂直线">
        		<hr id="u17_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
          <div id="u21" class="ax_垂直线">
        		<hr id="u21_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
          <div id="u18" class="ax_文本段落">
          		<p id="u19"><span>随访日期</span></p>
      		</div>
            
          <div id="u20" class="ax_垂直线">
        		<hr id="u20_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
          <div id="u180" class="ax_文本段落">
          		<p id="u190"><span><fmt:formatDate value="${map.prenatal.creatTime }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
          <div id="u24" class="ax_水平线">
        		<hr id="u24_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u22" class="ax_文本段落">
          		<p id="u23"><span>孕周（周）</span></p>
      		</div>
          <div id="u220" class="ax_文本段落">
          		<p id="u230"><span>${map.week }</span></p>
      		</div>
            
          <div id="u27" class="ax_水平线">
         		<hr id="u27_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u29" class="ax_文本段落">
       		  <p id="u30"><span>体重(kg)</span></p>
      		</div>
          <div id="u290" class="ax_文本段落">
          		<p id="u300"><span>${map.obstetricExa.weight }</span></p>
      		</div>
            
          <div id="u28" class="ax_水平线">
        		<hr id="u28_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
          <div id="u25" class="ax_文本段落">
       		<p id="u26"><span>主 诉</span></p>
      		</div>
            
            <div id="u250" class="ax_文本段落">
          		<p id="u260"><span>${map.prenatal.chiefComplaint }</span></p>
      		</div>
            
            <div id="u68" class="ax_水平线">
        		<hr id="u68_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u76" class="ax_文本段落">
          		<p><span>产</span></p><p><span>&nbsp;</span></p><p><span>科</span></p><p><span>&nbsp;</span></p><p><span>检</span></p><p><span>&nbsp;</span></p><p><span>查</span></p>
      		</div>
            <div id="u75" class="ax_垂直线">
        		<hr id="u75_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>      
            </div>
            
            <div id="u31" class="ax_文本段落">
          		<p id="u32"><span>宫底高度(cm)</span></p>
      		</div>
            
            <div id="u310" class="ax_文本段落">
          		<p id="u320"><span>${map.obstetricExa.uterusHight }</span></p>
      		</div>
            
            <div id="u35" class="ax_水平线">
        		<hr id="u35_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
			
            <div id="u33" class="ax_文本段落">
          		<p id="u34"><span>腹围(cm)</span></p>
      		</div>
            
            <div id="u330" class="ax_文本段落">
          		<p id="u340"><span>${map.obstetricExa.abdomen }</span></p>
      		</div>
            
            <div id="u38" class="ax_水平线">
        		<hr id="u38_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u36" class="ax_文本段落">
          		<p id="u37"><span>胎位</span></p>
      		</div>
            
            <div id="u360" class="ax_文本段落">
          		<p id="u370"><span>${map.obstetricExa.fetusPosition }</span></p>
      		</div>
            
            <div id="u39" class="ax_水平线">
        		<hr id="u39_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u69" class="ax_文本段落">
          		<p id="u70"><span>胎心率（次/分钟）</span></p>
      		</div>
            <div id="u690" class="ax_文本段落">
          		<p id="u700"><span>${map.obstetricExa.heartRate }</span></p>
      		</div>
            
            <div id="u40" class="ax_水平线">
        		<hr id="u40_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u80" class="ax_文本段落">
          		<p id="u81"><span>血压(mmHg)</span></p>
      		</div>
            <div id="u800" class="ax_文本段落">
          		<p id="u810"><span>${map.obstetricExa.bloodHi }/${map.obstetricExa.bloodLow }</span></p>
      		</div>
            
            <div id="u41" class="ax_水平线">
        		<hr id="u41_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u82" class="ax_文本段落">
          		<p id="u83"><span>血红蛋白(g/L)</span></p>
      		</div>
            <div id="u820" class="ax_文本段落">
          		<p id="u830"><span>${map.supplemetnaryExam.hemoglobin }&nbsp;${map.supplemetnaryExam.bloodOthers }</span></p>
      		</div>
            
            <div id="u78" class="ax_水平线">
        		<hr id="u78_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u84" class="ax_文本段落">
          		<p id="u85"><span>尿蛋白</span></p>
      		</div>
            <div id="u840" class="ax_文本段落">
          		<p id="u850"><span>${map.supplemetnaryExam.proteinuria }&nbsp;${map.supplemetnaryExam.urineOthers }</span></p>
      		</div>
            
            <div id="u79" class="ax_水平线">
        		<hr id="u79_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u43" class="ax_文本段落">
          		<p id="u44"><span>其他辅助检查</span></p>
      		</div>
            <div id="u430" class="ax_文本段落">
          		<p id="u440">
          			<span style="top:0px;left:0px;position:absolute;width:200px;">血糖：
	          			<c:if test="${map.supplemetnaryExam.bloodGlucose != '-1'}">${map.supplemetnaryExam.bloodGlucose }mmol/L</c:if> 
	        			<c:if test="${map.supplemetnaryExam.bloodGlucose == '-1'}">未检查</c:if> 
	        		</span>
          			<c:if test="${map.supplemetnaryExam.sgpt == '-1' && map.supplemetnaryExam.sgot == '-1' && map.supplemetnaryExam.albumin == '-1' && map.supplemetnaryExam.totalBilirubin == '-1' && map.supplemetnaryExam.dbil == '-1'}">
          			<span style="top:25px;left:0px;position:absolute;width:300px;">肝功能：未检查 </span></c:if>
          			<c:if test="${map.supplemetnaryExam.sgpt != '-1' || map.supplemetnaryExam.sgot != '-1' && map.supplemetnaryExam.albumin != '-1' && map.supplemetnaryExam.totalBilirubin != '-1' && map.supplemetnaryExam.dbil != '-1'}">
          			<span style="top:25px;left:0px;position:absolute;width:300px;">肝功能：
          			&nbsp;血清谷丙转氨酶<c:if test="${map.supplemetnaryExam.sgpt != '-1'}">${map.supplemetnaryExam.sgpt }U/L；</c:if>
        					  <c:if test="${map.supplemetnaryExam.sgpt == '-1'}">未检查</c:if>&nbsp;
          			血清谷草转氨酶<c:if test="${map.supplemetnaryExam.sgot != '-1'}">${map.supplemetnaryExam.sgot }U/L；</c:if>
        						<c:if test="${map.supplemetnaryExam.sgot == '-1'}">未检查</c:if>&nbsp;
          			白蛋白<c:if test="${map.supplemetnaryExam.albumin != '-1'}">${map.supplemetnaryExam.albumin }g/L</c:if>
	            		<c:if test="${map.supplemetnaryExam.albumin == '-1'}">未检查</c:if></span>
          			<span style="top:45px;left:50px;position:absolute;width:300px;">
          				总胆红素<c:if test="${map.supplemetnaryExam.totalBilirubin != '-1'}">${map.supplemetnaryExam.totalBilirubin }umol/L；</c:if>
        					<c:if test="${map.supplemetnaryExam.totalBilirubin == '-1'}">未检查</c:if>&nbsp;
          				结合胆红素<c:if test="${map.supplemetnaryExam.dbil != '-1'}">${map.supplemetnaryExam.dbil }umol/L</c:if>
        						<c:if test="${map.supplemetnaryExam.dbil == '-1'}">未检查</c:if>&nbsp;
          			</span>
          			</c:if>
          			<span style="top:65px;left:0px;position:absolute;width:200px;">
          				肾功能：
          				<c:if test="${map.supplemetnaryExam.scr == '-1' && map.supplemetnaryExam.bun == '-1' }">未检查</c:if>
          				<c:if test="${map.supplemetnaryExam.scr != '-1' || map.supplemetnaryExam.bun != '-1' }">
          				&nbsp;血清肌酐<c:if test="${map.supplemetnaryExam.scr != '-1'}">${map.supplemetnaryExam.scr }umol/L；</c:if>
        									<c:if test="${map.supplemetnaryExam.scr == '-1'}">未检查</c:if>;&nbsp;
          				血清素氮<c:if test="${map.supplemetnaryExam.bun != '-1'}">${map.supplemetnaryExam.bun }umol/L</c:if>
        						<c:if test="${map.supplemetnaryExam.bun == '-1'}">未检查</c:if>
        						
        						</c:if></span>
          			<span style="top:85px;left:0px;position:absolute;width:200px;">
          				B超：&nbsp;
          				<c:if test="${map.supplemetnaryExam.bscan == '0'}">未检查</c:if>
          				<c:if test="${map.supplemetnaryExam.bscan == '1'}">无异常</c:if>
            			<c:if test="${map.supplemetnaryExam.bscan == '2'}">有异常&nbsp;${map.supplemetnaryExam.bscanRemark}</c:if></span>
            		<c:if test="${map.week >= 14 && map.week <=20 }">
	            		<span style="top:105px;left:0px;position:absolute;width:200px;">
	            			唐筛：&nbsp;
	          				<c:if test="${map.supplemetnaryExam.tangSyndrome == '0'}">未检查</c:if>
	          				<c:if test="${map.supplemetnaryExam.tangSyndrome == '1'}">无异常</c:if>
	            			<c:if test="${map.supplemetnaryExam.tangSyndrome == '2'}">有异常&nbsp;${map.supplemetnaryExam.tangSyndromeRemark}</c:if>
	            		</span>
            		</c:if>
            		<c:if test="${map.week >= 11 && map.week <=13 }">
	            		<span style="top:105px;left:0px;position:absolute;width:200px;">
	            			NT：&nbsp;
	          				<c:if test="${map.supplemetnaryExam.nt == '0'}">未检查</c:if>
	          				<c:if test="${map.supplemetnaryExam.nt == '1'}">无异常</c:if>
	            			<c:if test="${map.supplemetnaryExam.nt == '2'}">有异常&nbsp;${map.supplemetnaryExam.ntRemark}</c:if>
	            		</span>
            		</c:if>
            		<c:if test="${map.week >= 22 && map.week <=26 }">
	            		<span style="top:105px;left:0px;position:absolute;width:200px;">
	            			四维：&nbsp;
	          				<c:if test="${map.supplemetnaryExam.fourDimensional == '0'}">未检查</c:if>
	          				<c:if test="${map.supplemetnaryExam.fourDimensional == '1'}">无异常</c:if>
	            			<c:if test="${map.supplemetnaryExam.fourDimensional == '2'}">有异常&nbsp;${map.supplemetnaryExam.fourDimensionalRemark}</c:if>
	            		</span>
            		</c:if>
            		<span style="top:125px;left:0px;position:absolute;width:200px;">NST：&nbsp;
          				<c:if test="${map.supplemetnaryExam.nst == '0'}">未检查</c:if>
          				<c:if test="${map.supplemetnaryExam.nst == '1'}">无异常</c:if>
            			<c:if test="${map.supplemetnaryExam.nst == '2'}">有异常&nbsp;${map.supplemetnaryExam.nstRemark}</c:if>
            		</span>
            		<span style="top:125px;left:250px;position:absolute;width:200px;">其他：&nbsp;${map.supplemetnaryExam.others}
          			</span>
          		</p>
      		</div>
            
            <div id="u42" class="ax_水平线">
        		<hr id="u42_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u46" class="ax_文本段落">
          		<p id="u47"><span>分类</span></p>
      		</div>
            <div id="u460" class="ax_文本段落">
          		<p id="u470">
          			<span>
          				<c:if test="${map.prenatal.evaluate == '0'}">未见异常</c:if>
          				<c:if test="${map.prenatal.evaluate == '1'}">异常&nbsp;高危评分：${map.highRisk.score }
          					<%-- <c:forEach items="${map.list}" var="item">
          						${item };&nbsp;
          					</c:forEach> --%>
          					<br/>
          				</c:if>
          				<span  style="color: #EE5F45;top: -15px;left: 130px;width: 400px;position: absolute;white-space: normal;">${map.nomalList }<br/>${map.malList }</span>
          			</span>
          		</p>
      		</div>
            
            <div id="u45" class="ax_水平线">
        		<hr id="u45_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u49" class="ax_文本段落">
          		<p id="u50"><span>指导</span></p>
      		</div>
            <div id="u490" class="ax_文本段落">
          		<%-- <p id="u500"><span>${map.prenatal.guidance }</span></p> --%>
          		<p><span style="color:#333333;">&nbsp;</span></p>
	          	<p><span style="color:#333333;">${map.prenatal.guidance }</span></p>
	          	<p><span style="color:#333333;">&nbsp;</span></p>
	          	<p>
		          <%-- <span style="color:#FF0000;">&nbsp; &nbsp; &nbsp;&nbsp; 
		          	<c:if test="${map.prenatal.evaluate == '1' }">
		          		${map.highRisk.scheme }
		          	</c:if>
		          </span> --%>
	          	</p>
      		</div>
            
            <div id="u48" class="ax_水平线">
        		<hr id="u48_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
     		</div>
            
            <div id="u51" class="ax_文本段落">
          		<p id="u52"><span>转诊</span></p>
      		</div>
            
            <div id="u53" class="ax_单选按钮">
            	<p id="u54">
	            	<span>
						<c:if test="${map.prenatalReferral.referral == '0' }">无</c:if>
            			<c:if test="${map.prenatalReferral.referral == '1' }">有</c:if>
					</span>
				</p>
      		</div>
            
            <div id="u55" class="ax_文本段落">
          		<p id="u56"><span>原因：  ${map.prenatalReferral.reason}</span></p>
      		</div>
            
            <div id="u57" class="ax_文本段落">
          		<p id="u58">
	          		<span>机构及科室：
	          			<c:if test="${map.prenatalReferral.referral == '0' }"></c:if>
            			<c:if test="${map.prenatalReferral.referral == '1' }">${department.name}-${role.name}</c:if>
	          		</span>
          		</p>
      		</div>
            
            <div id="u59" class="ax_水平线">
        		<hr id="u59_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u62" class="ax_文本段落">
          		<p id="u63"><span>下次随访日期</span></p>
      		</div>
            
            <div id="u61" class="ax_垂直线">
        		<hr id="u61_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u71" class="ax_文本段落">
          		<p id="u72"><span><fmt:formatDate value="${map.prenatalReferral.nextFollowingDate}" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u64" class="ax_垂直线">
        		<hr id="u64_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
     		</div>
            
            <div id="u66" class="ax_文本段落">
          		<p id="u67"><span>随访医生签名</span></p>
      		</div>
            
            <div id="u65" class="ax_垂直线">
        		<hr id="u65_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u660" class="ax_文本段落">
          		<p id="u670"><span></span></p>
      		</div>
            
            <div id="u60" class="ax_水平线">
        		<hr id="u60_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
        
        </div>
        
        <div id="pPreview" style="display: none">
      
	      	<div id="pu0" class="ax_形状">
	          <p id="pu1"><span>&nbsp;</span></p>
	      	</div>
	        <div id="pu14" class="ax_形状" style="border:1px solid #000;">
	          <p id="pu15"><span>&nbsp;</span></p>
	      	</div>
	        
	        <div id="pu16" class="ax_文本段落">
	          <p id="pu17"><span style="font-size: 18px;">产前检查反馈单</span></p>
	      	</div>
	        
	        <div id="pu18" class="ax_文本段落">
	          <p id="pu19"><span>档案编号：</span><span>${map.archives.archivesCode }</span></p>
	       	</div>
	        
	        <div id="pu22" class="ax_文本段落">
	          <p id="pu23"><span>孕妇姓名：</span><span>${map.archives.name }</span></p>
	      	</div>
	        
	        <div id="pu20" class="ax_文本段落">
	          <p id="pu21"><span>年龄：${map.age }</span></p>
	      	</div>
	        
	        <div id="pu24" class="ax_文本段落">
	          <p id="pu25"><span>检查日期：</span><span><fmt:formatDate value="${map.prenatal.creatTime }" pattern="yyyy-MM-dd"/></span></p>
	      	</div>
	        
	        <div id="pu26" class="ax_文本段落">
	          <p id="pu27" ><span>末次月经：</span><span><fmt:formatDate value="${map.birthArchives.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
	      	</div>
	        
	        <div id="pu28" class="ax_文本段落">
	          <p id="pu29"><span>预产期：</span><span><fmt:formatDate value="${map.expectedDate }" pattern="yyyy-MM-dd"/></span></p>
	      	</div>
	        
	        <div id="pu33" class="ax_文本段落">
	          <p id="pu34"><span>孕周：</span><span>${map.week }周</span></p>
	      	</div>
	      	
	      	<div id="pu330" class="ax_文本段落">
          		<p id="pu340"><span>检查次数：</span><span>${num }次</span></p>
      		</div>
	        
	        <div id="pu30" class="ax_水平线">
	        	<hr id="pu30_line" style="height:1px;border:none;border-top:1px dashed #000;" />
	      	</div>
	        
	        <div id="pu31" class="ax_image">
	        	<img id="pu31_img" class="img " src="${ctx }/static/css/first_u31.png"/>
	          	<p id="pu32"><span>&nbsp;</span></p>
	      	</div>
	        
	        <div id="pu46" class="ax_文本段落">
	          <p id="pu47"><span>身&nbsp;&nbsp; 高</span><span>：${map.height }cm</span></p>
	      	</div>
	        
	        <div id="pu48" class="ax_文本段落">
	          <p id="pu49"><span>体&nbsp; 重：${map.obstetricExa.weight }Kg</span></p>
	      	</div>
	        
	        <div id="pu50" class="ax_文本段落">
	          <p id="pu51"><span>血&nbsp; 压：${map.obstetricExa.bloodHi }/${map.obstetricExa.bloodLow }mmHg</span></p>
	      	</div>
	        
	        <div id="pu56" class="ax_文本段落">
	          <p id="pu57">
	          	<span>血 型：</span>
	          	<span>
	          		<c:if test="${map.bloodType == '0'}">A</c:if>
           			<c:if test="${map.bloodType == '1'}">B</c:if>
           			<c:if test="${map.bloodType == '2'}">AB</c:if>
           			<c:if test="${map.bloodType == '3'}">O</c:if>
	          	</span>
	          </p>
	      	</div>
	        
	        <div id="pu52" class="ax_文本段落">
	          <p id="pu53"><span>血常规：血红蛋白${map.supplemetnaryExam.hemoglobin}g/L&nbsp;&nbsp;
	          	其他：${map.supplemetnaryExam.bloodOthers}</span></p>
	      	</div>
	        
	        <%-- <div id="pu60" class="ax_文本段落">
	          <p id="pu61">
		          <span>乙型肝炎表面抗原：无
		          	<c:if test="${map.supplemetnaryExam.hbsag == 0}">阴性</c:if>
            		<c:if test="${map.supplemetnaryExam.hbsag == 1}">阳性</c:if>
		          </span>
	          </p>
	      	</div> --%>
	        
	        <div id="pu54" class="ax_文本段落">
	          <p id="pu55"><span>尿常规：尿蛋白${map.supplemetnaryExam.proteinuria}μmol/L&nbsp;&nbsp;
	          	其他：${map.supplemetnaryExam.urineOthers}
	          </span></p>
	      	</div>
	        
	        <%-- <div id="pu64" class="ax_文本段落">
	          <p id="pu65"><span>HIV抗体检测：无
	          	<c:if test="${map.supplemetnaryExam.hivab == 0}">阴性</c:if>
            	<c:if test="${map.supplemetnaryExam.hivab == 1}">阳性</c:if>
	          </span></p>
	      	</div>	 --%>
	
			<div id="pu58" class="ax_文本段落">
	          <p id="pu59"><span>血糖：<c:if test="${map.supplemetnaryExam.bloodGlucose != '-1'}">${map.supplemetnaryExam.bloodGlucose }mmol/L</c:if> 
	        			<c:if test="${map.supplemetnaryExam.bloodGlucose == '-1'}">未检查</c:if></span></p>
	      	</div>
	        
	        <%-- <div id="pu62" class="ax_文本段落">
	          <p id="pu63"><span>梅毒血清学试验：无
	          	<c:if test="${map.supplemetnaryExam.syphilisSerology == 0}">阴性</c:if>
            	<c:if test="${map.supplemetnaryExam.syphilisSerology == 1}">阳性</c:if>
	          </span></p>
	      	</div> --%>
	      	
	      	<div id="pu580" class="ax_文本段落">
          		<p id="pu590"><span>宫底高度：${map.obstetricExa.uterusHight }cm</span></p>
      		</div>
        
	        <div id="pu581" class="ax_文本段落">
	        	<p id="pu591"><span>腹围：${map.obstetricExa.abdomen }cm</span></p>
	      	</div>
	        
	        <div id="pu582" class="ax_文本段落">
	        	<p id="pu592"><span>胎位：${map.obstetricExa.fetusPosition }</span></p>
	      	</div>
	        
	        <div id="pu583" class="ax_文本段落">
	        	<p id="pu594"><span>胎心率：${map.obstetricExa.heartRate }</span></p>
	      	</div>
	        
	        <c:if test="${map.prenatal.evaluate == 1 }">
		        <div id="pu35" class="ax_文本段落">
		          <p id="pu36"><span>诊断：</span><span> ${map.highRisk.diaResult }</span></p>
		      	</div>
		        <!-- <div id="pu66" class="ax_文本段落" style="background-color:#FFFF00">
		          <p id="pu67"><span>---非高危表无诊断</span></p>
		      	</div> -->
	        </c:if>
	        
	        <div id="pu37" class="ax_文本段落" style="border: 1px solid #000;">
	          <p id="pu38"><span style="color:#333333;">指导意见：</span></p>
	          <p><span style="color:#333333;">&nbsp;</span></p>
	          <p><span style="color:#333333;">${map.prenatal.guidance }</span></p>
	          <p><span style="color:#333333;">&nbsp;</span></p>
	          <p>
		          <span style="color:#FF0000;">&nbsp; &nbsp; &nbsp;&nbsp; 
		          	<c:if test="${map.prenatal.evaluate == '1' }">
		          		${map.highRisk.scheme }
		          	</c:if>
		          </span>
	          </p>
	      	</div>
	        
	        <div id="pu39" class="ax_文本段落">
	          <p id="pu40"><span>医生签名：</span></p>
	      	</div>
	        <div id="pu41" class="ax_水平线">
	        	<hr id="pu41_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
	      	</div>
	        <div id="pu42" class="ax_文本段落">
	          <p id="pu43"><span>下次预约时间：<fmt:formatDate value="${map.prenatalReferral.nextFollowingDate}" pattern="yyyy-MM-dd"/></span></p>
	      	</div>
	        
	        <div id="pu44" class="ax_文本段落">
	          <p id="pu45"><span>*以上意见仅供参考，如有不适，请及时随诊*</span></p>
	      	</div>
      
      </div>
      

    </div>
  </body>
</html>
