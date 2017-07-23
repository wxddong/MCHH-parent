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
    <link href="${ctx}/static/css/firstPrenatalPreview_style.css" type="text/css" rel="stylesheet"/>

    <script type="text/javascript">
      
    	$(function(){
    		
    		var go = $("#go").val();
    		if(go == "1"){
    			$("#u2").css("background-color","#999999");
    			$("#u319").css("background-color","#EE5F45");
    			$("#preview").hide();
    			$("#pPreview").show();
    		}
    		
    		$("#u320").click(function(){
    			
    			$("#u2").css("background-color","#999999");
    			$("#u319").css("background-color","#EE5F45");
    			$("#preview").hide();
    			$("#pPreview").show();
    			
    		});
    		$("#u3").click(function(){
    			
    			$("#u2").css("background-color","#EE5F45");
    			$("#u319").css("background-color","#999999");
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

        <div>
        
       	  <div id="u2" class="ax_形状" style="background-color:#EE5F45">
          		<p id="u3" style="cursor:pointer"><span>第1次产前随访记录表</span></p>
   		  </div>
            <div id="u319" class="ax_形状" style="background-color:#999999">
          		<p id="u320" style="cursor:pointer"><span>产前检查反馈单</span></p>
      		</div>
            <div id="u4" class="ax_形状" style="background-color:#009DD9">
          		<p id="u5" style="cursor:pointer"><span>立即打印</span></p>
      		</div>
            <div id="u6" class="ax_形状" style="background-color:#56BB4D">
          		<p id="u7" style="cursor:pointer"><span>关闭预览</span></p>
      		</div>
        
        </div>
		<input type="hidden" id="go" value="${go }"/>
        <div id="preview">
        	
       	  <!-- <div id="u0" class="ax_形状">
          		<p id="u1"><span>&nbsp;</span></p>
   		  </div> -->
            
       	  <div id="u8" class="ax_形状" style="border:1px solid #000">
          		<p id="u9"><span>&nbsp;</span></p>
   		  </div>
            
            <c:if test="${map.prenatalExa.evaluate == '1' }">
	            <div id="u317" class="ax_文本段落">
	              <p id="u318"><span style="font-size:16px;">* 高危孕产妇 *</span></p>
	          	</div>
           </c:if>
            
            <div id="u10" class="ax_文本段落">
          		<p id="u11"><span style="font-size:18px;">第一次产前随访服务记录表</span></p>
      		</div>
            
        	<div id="u12" class="ax_文本段落">
          		<p id="u13"><span style="font-size:14px;">姓名：${map.archives.name }</span></p>
      		</div>
        	
            <div id="u14" class="ax_文本段落">
          		<p id="u15" style="font-size:14px;"><span style="font-size:14px;">编号：</span><span style="font-size:13px;">${map.archives.archivesCode }</span></p>
      		</div>
            
          <div id="u16" class="ax_水平线">
   		    <hr id="u16_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
   		  </div>
            <div id="u18" class="ax_垂直线">
       		  <hr id="u18_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u19" class="ax_文本段落">
          		<p id="u20"><span>填表日期</span></p>
   		  </div>
            
            <div id="u21" class="ax_垂直线">
        		<hr id="u21_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u223" class="ax_文本段落">
          		<p id="u224"><span><fmt:formatDate value="${map.prenatalExa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
   		  </div>
            
            <div id="u25" class="ax_垂直线">
        		<hr id="u25_line" style="weight:1px;border:none;border-left:1px solid #000000;">
      		</div>
            
            <div id="u23" class="ax_文本段落">
          		<p id="u24"><span>填表孕周</span></p>
   		  </div>
            
            <div id="u26" class="ax_垂直线">
        		<hr id="u26_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u27" class="ax_文本框">
        		<p id="u27_input"><span>${map.week }</span></p>
      		</div>
            <div id="u22" class="ax_垂直线">
       		 	<hr id="u22_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            <div id="u17" class="ax_水平线">
        		<hr id="u17_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
   		  </div>
            
            <div id="u28" class="ax_文本段落">
          		<p id="u29"><span>孕妇年龄</span></p>
   		  </div>
            
            <div id="u225" class="ax_文本段落">
          		<p id="u226"><span>${map.age }</span></p>
   		  </div>
            
            <div id="u30" class="ax_水平线">
        		<hr id="u30_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
   		  </div>
            
            <div id="u31" class="ax_文本段落">
          		<p id="u32"><span>丈夫姓名</span></p>
   		  </div>
            
            <div id="u36" class="ax_文本框">
        		<p id="u36_input" ><span>${map.archives.manName }</span></p>
   		  </div>
            
            <div id="u34" class="ax_垂直线">
        		<hr id="u34_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u37" class="ax_文本段落">
          		<p id="u38"><span>丈夫年龄</span></p>
      		</div>
            <div id="u35" class="ax_垂直线">
        		<hr id="u35_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            <div id="u40" class="ax_文本框">
        		<p id="u40_input"><span>${map.manAge }</span></p>
   		  </div>
            <div id="u39" class="ax_垂直线">
        		<hr id="u39_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
          <div id="u41" class="ax_文本段落">
       		<p id="u42"><span>丈夫电话</span></p>
   		  </div>
            
            <div id="u44" class="ax_垂直线">
        		<hr id="u44_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u43" class="ax_文本框">
       		  <p id="u43_input"><span>${map.archives.manTele }</span></p>
   		  	</div>
          	<div id="u33" class="ax_水平线">
        		<hr id="u33_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            <div id="u46" class="ax_文本段落">
                <p id="u47"><span>孕&nbsp; 次</span></p>
      		</div>
            <div id="u57" class="ax_文本框">
       			<p id="u57_input"><span> ${map.motherhood.pregnancyNum }</span></p>
      		</div>
            
            <div id="u48" class="ax_文本段落">
                 <p id="u49"><span>产 次</span></p>
          	</div>
            <div id="u50" class="ax_文本段落">
                  <p id="u51"><span>阴道分娩${map.motherhood.eutociaNum }次</span></p>
      		</div>
        	<div id="u52" class="ax_文本段落">
                <p id="u53"><span>剖宫产${map.motherhood.cesareanNum }次</span></p>
      		</div>
            
            <div id="u45" class="ax_水平线">
        		<hr id="u45_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            <div id="u58" class="ax_文本段落">
                <p id="u59"><span>末次月经</span></p>
          	</div>
            <div id="u227" class="ax_文本段落">
                <p id="u228" ><span><fmt:formatDate value="${map.motherhood.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
          	</div>
            
            <div id="u55" class="ax_文本段落">
          		<p id="u56"><span>预产期</span></p>
      		</div>
            <div id="u229" class="ax_文本段落">
          		<p id="u230"><span><fmt:formatDate value="${map.expectedDate }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            <div id="u54" class="ax_水平线">
        		<hr id="u54_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u61" class="ax_文本段落">
            	<p id="u62"><span>既往史</span></p>
      		</div>
            
            <div id="u231" class="ax_文本段落">
                <p id="u232">
	               	<span>
	               		<c:forEach items="${map.historys }" var = "history">
	               		<c:if test="${history == '0' }">无</c:if>
	               		<c:if test="${history == '1' }">心脏病</c:if>
	               		<c:if test="${history == '2' }">肾脏疾病</c:if>
	               		<c:if test="${history == '3' }">肝脏疾病</c:if>
	               		<c:if test="${history == '4' }">高血压</c:if>
	               		<c:if test="${history == '5' }">贫血</c:if>
	               		<c:if test="${history == '6' }">糖尿病</c:if>
	               		<c:if test="${history == '7' }">其它&nbsp;${map.motherhood.historyOthers }</c:if>
	               		</c:forEach>
	               	</span>
                </p>
      		</div>
            
            <div id="u60" class="ax_水平线">
        		<hr id="u60_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u64" class="ax_文本段落">
                <p id="u65"><span>家族史</span></p>
      		</div>
            
            <div id="u233" class="ax_文本段落">
                 <p id="u234">
                 	<span>
                 		<c:forEach items="${map.famHistorys }" var="famHistory">
		                 	<c:if test="${famHistory == '0' }">无</c:if>
		                 	<c:if test="${famHistory == '1' }">遗传性疾病史&nbsp;${map.motherhood.heredityRelation }</c:if>
		                 	<c:if test="${famHistory == '2' }">精神疾病史&nbsp;${map.motherhood.mentalRelation }</c:if>
		                 	<c:if test="${famHistory == '3' }">其它&nbsp;${map.motherhood.famHistoryOthers }</c:if>
                 		</c:forEach>
                 	</span>
                 </p>
          	</div>
            <div id="u63" class="ax_水平线">
        		<hr id="u63_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            <div id="u67" class="ax_文本段落">
                <p id="u68"><span>个人史</span></p>
          	</div>
            <div id="u235" class="ax_文本段落">
                <p id="u236">
                	<span>
	                	<c:forEach items="${map.perHistorys }" var="perHistory">
			                <c:if test="${perHistory == '0' }">无</c:if>
		                 	<c:if test="${perHistory == '1' }">吸烟</c:if>
		                 	<c:if test="${perHistory == '2' }">饮酒</c:if>
		                 	<c:if test="${perHistory == '3' }">服用药物</c:if>
		                 	<c:if test="${perHistory == '4' }">接触有毒有害物质</c:if>
		                 	<c:if test="${perHistory == '5' }">接触放射线</c:if>
		                 	<c:if test="${perHistory == '6' }">其它&nbsp;${map.motherhood.perHistoryOthers }</c:if>
                 		</c:forEach>
                	</span>
                </p>
      		</div>
            
            <div id="u214" class="ax_水平线">
        		<hr id="u214_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u215" class="ax_文本段落">
                  <p id="u216"><span>妇科手术史</span></p>
          	</div>
            <div id="u237" class="ax_文本段落">
                <p id="u238">
                	<span>
                		<c:if test="${map.motherhood.operation == '0' }">无</c:if>
                		<c:if test="${map.motherhood.operation == '1' }">有&nbsp;${map.motherhood.operationRemark }</c:if>
                	</span>
                </p>
      		</div>
            
            <div id="u66" class="ax_水平线">
        		<hr id="u66_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u70" class="ax_文本段落">
                <p id="u71"><span>孕产史</span></p>
      		</div>
            <div id="u239" class="ax_文本段落">
                <p id="u240"><span>流产${map.motherhood.abortionNum }次</span></p>
   		  	</div>
			<div id="u74" class="ax_文本段落">
				<p id="u75"><span>死产${map.motherhood.stillbirthNum}次</span></p>
			</div>
			<div id="u309" class="ax_文本段落">
				<p id="u310"><span>死胎${map.motherhood.deadfetusNum }次</span></p>
			</div>
			<div id="u2390" class="ax_文本段落">
				<p id="u2400"><span>新生儿死亡${map.motherhood.newbornDieNum }次</span></p>
			</div>
			<div id="u2391" class="ax_文本段落">
				<p id="u2401"><span>初生儿缺陷${map.motherhood.defectNum }次</span></p>
			</div>
			<div id="u2392" class="ax_文本段落">
				<p id="u2402"><span>产后出血${map.motherhood.bleedingNum}次</span></p>
			</div>
			<div id="u2393" class="ax_文本段落">
				<p id="u2403"><span>双胎${map.motherhood.twinsNum }次</span></p>
			</div>
			<div id="u2394" class="ax_文本段落">
				<p id="u2404"><span>畸形${map.motherhood.deformityNum }次</span></p>
			</div>

            <div id="u73" class="ax_水平线">
        		<hr id="u73_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u77" class="ax_文本段落">
          		<p id="u78"><span>身高</span></p>
      		</div>
            <div id="u79" class="ax_文本段落">
         		<p id="u80"><span>${map.bloodStethos.height }cm</span></p>
      		</div>
            
            <div id="u81" class="ax_垂直线">
        		<hr id="u81_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u84" class="ax_文本段落">
         		<p id="u85"><span>体重</span></p>
      		</div>
            <div id="u83" class="ax_垂直线">
        		<hr id="u83_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            <div id="u86" class="ax_文本段落">
          		<p id="u87"><span>${map.bloodStethos.weight }Kg</span></p>
      		</div>
            
            <div id="u76" class="ax_水平线">
        		<hr id="u76_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            <div id="u88" class="ax_文本段落">
          		<p id="u89"><span>体质指数</span></p>
      		</div>
            <div id="u241" class="ax_文本段落">
          		<p id="u242"><span>${map.bmi }</span></p>
      		</div>
            <div id="u90" class="ax_文本段落">
          		<p id="u91"><span>血压</span></p>
      		</div>
            <div id="u92" class="ax_文本段落">
          		<p id="u93"><span>${map.bloodStethos.bloodHi }/${map.bloodStethos.bloodLow }mmHg</span></p>
      		</div>
            
            <div id="u82" class="ax_水平线">
        		<hr id="u82_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u95" class="ax_文本段落">
          		<p id="u96"><span>听诊</span></p>
      		</div>
            <div id="u97" class="ax_文本段落">
          		<p id="u98"><span>心脏：</span></p>
      		</div>
            <div id="u99" class="ax_单选按钮">
          		<p id="u100">
          			<span>
          				<c:if test="${map.bloodStethos.heart == '0' }">未见异常</c:if>
          				<c:if test="${map.bloodStethos.heart == '1' }">异常${map.bloodStethos.heartRemark }</c:if>
          			</span>
          		</p>
      		</div>
            <div id="u101" class="ax_文本段落">
          		<p id="u102"><span>肺部：</span></p>
      		</div>
            <div id="u103" class="ax_单选按钮">
          		<p id="u104">
	          		<span>
	          			<c:if test="${map.bloodStethos.lung == '0' }">未见异常</c:if>
          				<c:if test="${map.bloodStethos.lung == '1' }">异常&nbsp;${map.bloodStethos.lungRemark }</c:if>
	          		</span>
          		</p>
      		</div>
            
            <div id="u94" class="ax_水平线">
        		<hr id="u94_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u108" class="ax_文本段落">
          		<p id="u109"><span>妇科检查</span></p>
      		</div>
            
            <div id="u110" class="ax_文本段落">
          		<p id="u111"><span>外阴：</span></p>
     		</div>
            <div id="u112" class="ax_单选按钮">
          		<p id="u113">
          			<span>
          				<c:if test="${map.gynecologcal.outerVulva == '0' }">未见异常</c:if>
          				<c:if test="${map.gynecologcal.outerVulva == '2' }">未检查</c:if>
          				<c:if test="${map.gynecologcal.outerVulva == '1' }">异常&nbsp;${map.gynecologcal.outerVulvaRemark }</c:if>
          			</span>
          		</p>
      		</div>
            
            <div id="u122" class="ax_文本段落">
          		<p id="u123"><span>阴道：</span></p>
      		</div>
            <div id="u124" class="ax_单选按钮">
          		<p id="u125">
          			<span>
          				<c:if test="${map.gynecologcal.vagina == '0' }">未见异常</c:if>
          				<c:if test="${map.gynecologcal.vagina == '2' }">未检查</c:if>
          				<c:if test="${map.gynecologcal.vagina == '1' }">异常&nbsp;${map.gynecologcal.vaginaRemark }</c:if>
          			</span>
          		</p>
      		</div>
            
            <div id="u105" class="ax_水平线">
        		<hr id="u105_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u114" class="ax_文本段落">
          		<p id="u115"><span>宫颈：</span></p>
      		</div>
            <div id="u116" class="ax_单选按钮">
          		<p id="u117">
          			<span>
          				<c:if test="${map.gynecologcal.uterineNeck == '0' }">未见异常</c:if>
          				<c:if test="${map.gynecologcal.uterineNeck == '2' }">未检查</c:if>
          				<c:if test="${map.gynecologcal.uterineNeck == '1' }">异常&nbsp;${map.gynecologcal.uterineNeckRemark }</c:if>
          			</span>
          		</p>
      		</div>
            
            <div id="u126" class="ax_文本段落">
          		<p id="u127"><span>子宫：</span></p>
      		</div>
            <div id="u128" class="ax_单选按钮">
          		<p id="u129">
          			<span>
          				<c:if test="${map.gynecologcal.uterus == '0' }">未见异常</c:if>
          				<c:if test="${map.gynecologcal.uterus == '3' }">未检查</c:if>
          				<c:if test="${map.gynecologcal.uterus == '2' }">正常孕期&nbsp;${map.gynecologcal.uterusRemark }</c:if>
          				<c:if test="${map.gynecologcal.uterus == '1' }">异常&nbsp;${map.gynecologcal.uterusRemark }</c:if>
          			</span>
          		</p>
      		</div>
            
            <div id="u106" class="ax_水平线">
        		<HR id="u106_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            <div id="u118" class="ax_文本段落">
          		<p id="u119"><span>附件：</span></p>
      		</div>
            <div id="u120" class="ax_单选按钮">
          		<p id="u121">
          			<span>
          				<c:if test="${map.gynecologcal.appendix == '0' }">未见异常</c:if>
          				<c:if test="${map.gynecologcal.appendix == '2' }">未检查</c:if>
          				<c:if test="${map.gynecologcal.appendix == '1' }">异常&nbsp;${map.gynecologcal.appendixRemark }</c:if>
          			</span>
          		</p>
      		</div>
            
            <div id="u107" class="ax_水平线">
        		<HR id="u107_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u189" class="ax_文本段落">
          		<p id="u190"><span>辅助检查</span></p>
     	 	</div>
            
            <div id="u132" class="ax_文本段落">
          		<p id="u133"><span>血常规</span></p>
      		</div>
            
            <div id="u131" class="ax_垂直线">
       		  <HR id="u131_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u253" class="ax_文本段落">
          		<p id="u254"><span>血红蛋白值${map.supplemetnaryExam.hemoglobin}</span></p>
     		</div>
            <div id="u255" class="ax_文本段落">
          		<p id="u256"><span>g/L</span></p>
     		</div>
            
            <div id="u257" class="ax_文本段落">
          		<p id="u258"><span>白细胞计数值${map.supplemetnaryExam.leucocyte}</span></p>
      		</div>
            <div id="u263" class="ax_文本段落">
          		<p id="u264"><span>10^9/L</span></p>
      		</div>
            
            <div id="u259" class="ax_文本段落">
          		<p id="u260"><span>血小板计数值${map.supplemetnaryExam.platelet}</span></p>
      		</div>
            <div id="u261" class="ax_文本段落">
          		<p id="u262" ><span>10^9/L</span></p>
      		</div>
            
            <div id="u130" class="ax_水平线">
        		<hr id="u130_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u135" class="ax_文本段落">
          		<p id="u136"><span>尿常规</span></p>
      		</div>
            
            <div id="u265" class="ax_文本段落">
          		<p id="u266"><span>尿蛋白${map.supplemetnaryExam.proteinuria}</span></p>
      		</div>
            <div id="u273" class="ax_文本段落">
          		<p id="u274"><span>μmol/L</span></p>
      		</div>
            
            <div id="u267" class="ax_文本段落">
          		<p id="u268"><span>尿糖${map.supplemetnaryExam.urineSugar}</span></p>
      		</div>
            <div id="u275" class="ax_文本段落">
          		<p id="u276"><span>μmol/L</span></p>
      		</div>
            <div id="u269" class="ax_文本段落">
          		<p id="u270"><span>尿酮体${map.supplemetnaryExam.ketone}</span></p>
      		</div>
            <div id="u277" class="ax_文本段落">
          		<p id="u278"><span>μmol/L</span></p>
      		</div>
            
            <div id="u271" class="ax_文本段落">
          		<p id="u272"><span>尿潜血${map.supplemetnaryExam.urineBlood}</span></p>
      		</div>
            <div id="u279" class="ax_文本段落">
          		<p id="u280"><span>μmol/L</span></p>
      		</div>
            
            <div id="u134" class="ax_水平线">
        		<hr id="u134_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u140" class="ax_文本段落">
          		<p id="u141"><span>血型</span></p>
      		</div>
            
            <div id="u139" class="ax_垂直线">
       			<hr id="u139_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u217" class="ax_单选按钮">
            	<p id="u218">
            		<span>
            			<c:if test="${map.supplemetnaryExam.bloodType == '0'}">A</c:if>
            			<c:if test="${map.supplemetnaryExam.bloodType == '1'}">B</c:if>
            			<c:if test="${map.supplemetnaryExam.bloodType == '2'}">AB</c:if>
            			<c:if test="${map.supplemetnaryExam.bloodType == '3'}">O</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u137" class="ax_水平线">
        		<hr id="u137_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u219" class="ax_单选按钮">
            	<p id="u220">
            		<span>
            			<c:if test="${map.supplemetnaryExam.bloodTypeRh == '0'}">Rh+</c:if>
            			<c:if test="${map.supplemetnaryExam.bloodTypeRh == '1'}">Rh-</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u138" class="ax_水平线">
        		<hr id="u138_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u143" class="ax_文本段落">
          		<p id="u144"><span>血糖*</span></p>
      		</div>
            
            <div id="u145" class="ax_文本段落">
          		<p id="u146"><span>${map.supplemetnaryExam.bloodGlucose}mmol/L</span></p>
      		</div>
            
            <div id="u142" class="ax_水平线">
        		<hr id="u142_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u148" class="ax_文本段落">
          		<p id="u149"><span>肝功能</span></p>
      		</div>
            
            <div id="u281" class="ax_文本段落">
          		<p id="u282"><span>血清谷丙转氨酶${map.supplemetnaryExam.sgpt}</span></p>
      		</div>
            <div id="u299" class="ax_文本段落">
          		<p id="u300"><span>U/L</span></p>
      		</div>
            
            <div id="u283" class="ax_文本段落">
          		<p id="u284"><span>血清谷草转氨酶${map.supplemetnaryExam.sgot}</span></p>
      		</div>
            <div id="u285" class="ax_文本段落">
          		<p id="u286"><span>U/L</span></p>
      		</div>
            
            <div id="u287" class="ax_文本段落">
          		<p id="u288"><span>白蛋白${map.supplemetnaryExam.albumin}</span></p>
      		</div>
            <div id="u289" class="ax_文本段落">
          		<p id="u290"><span>g/L</span></p>
      		</div>
            
            <div id="u291" class="ax_文本段落">
          		<p id="u292"><span>总胆红素${map.supplemetnaryExam.totalBilirubin}</span></p>
      		</div>
            <div id="u293" class="ax_文本段落">
          		<p id="u294"><span>μmol/L</span></p>
      		</div>
            
            <div id="u295" class="ax_文本段落">
          		<p id="u296"><span>结合胆红素${map.supplemetnaryExam.dbil}</span></p>
      		</div>
            <div id="u297" class="ax_文本段落">
          		<p id="u298"><span>μmol/L</span></p>
      		</div>
            
            <div id="u147" class="ax_水平线">
        		<hr id="u147_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u153" class="ax_文本段落">
          		<p id="u154"><span>肾功能</span></p>
      		</div>
            
            <div id="u301" class="ax_文本段落">
          		<p id="u302"><span>血清肌酐${map.supplemetnaryExam.scr}</span></p>
     		</div>
            <div id="u303" class="ax_文本段落">
          		<p id="u304"><span>μmol/L</span></p>
      		</div>
            
            <div id="u305" class="ax_文本段落">
          		<p id="u306"><span>血尿素氮${map.supplemetnaryExam.bun}</span></p>
      		</div>
            <div id="u307" class="ax_文本段落">
          		<p id="u308"><span>mmol/L</span></p>
      		</div>
            
            <div id="u152" class="ax_水平线">
        		<hr  id="u152_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u155" class="ax_文本段落">
          		<p id="u156"><span>阴道分泌物*</span></p>
      		</div>
            <div id="u157" class="ax_单选按钮">
            	<p id="u158">
            		<span>
            			<c:forEach items="${map.vaginalFluids }" var="vagin">
	            			<c:if test="${vagin == '0'}">未见异常</c:if>
	            			<c:if test="${vagin == '1'}">滴虫</c:if>
	            			<c:if test="${vagin == '2'}">假丝酵母菌</c:if>
	            			<c:if test="${vagin == '3'}">其他&nbsp;${map.supplemetnaryExam.vaginalFluidOthers}</c:if>
            			</c:forEach>
            		</span>
           		</p>
      		</div>
            
            <div id="u150" class="ax_水平线">
        		<hr id="u150_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u159" class="ax_文本段落">
          		<p id="u160"><span>阴道清洁度：</span></p>
      		</div>
            <div id="u161" class="ax_单选按钮">
            	<p id="u162">
            		<span>
            			<c:if test="${map.supplemetnaryExam.vaginalClean == '0'}">Ⅰ度</c:if>
            			<c:if test="${map.supplemetnaryExam.vaginalClean == '1'}">ⅠⅠ度</c:if>
            			<c:if test="${map.supplemetnaryExam.vaginalClean == '2'}">ⅠⅠⅠ度</c:if>
            			<c:if test="${map.supplemetnaryExam.vaginalClean == '3'}">Ⅳ度</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u151" class="ax_水平线">
        		<hr id="u151_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u164" class="ax_文本段落">
          		<p id="u165"><span>乙型肝炎五项</span></p>
      		</div>
            
            <div id="u166" class="ax_文本段落">
          		<p id="u167"><span>乙型肝炎表面抗原</span></p>
   		  </div>
            <div id="u243" class="ax_单选按钮">
            	<p id="u244">
            		<span>
            			<c:if test="${map.supplemetnaryExam.hbsag == '0'}">阴性</c:if>
            			<c:if test="${map.supplemetnaryExam.hbsag == '1'}">阳性</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u168" class="ax_文本段落">
          		<p id="u169"><span>乙型肝炎表面抗体</span></p>
   		  </div>
            <div id="u249" class="ax_单选按钮">
            	<p id="u250">
            		<span>
            			<c:if test="${map.supplemetnaryExam.hbsab == '0'}">阴性</c:if>
            			<c:if test="${map.supplemetnaryExam.hbsab == '1'}">阳性</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u170" class="ax_文本段落">
          		<p id="u171"><span>乙型肝炎抗原</span></p>
      		</div>
            <div id="u245" class="ax_单选按钮">
            	<p id="u246">
            		<span>
            			<c:if test="${map.supplemetnaryExam.hbcab == '0'}">阴性</c:if>
            			<c:if test="${map.supplemetnaryExam.hbcab == '1'}">阳性</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u172" class="ax_文本段落">
          		<p id="u173"><span>乙型肝炎e抗体</span></p>
      		</div>
            
            <div id="u251" class="ax_单选按钮">
            	<p id="u252">
            		<span>
            			<c:if test="${map.supplemetnaryExam.hbeab == '0'}">阴性</c:if>
            			<c:if test="${map.supplemetnaryExam.hbeab == '1'}">阳性</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u174" class="ax_文本段落">
          		<p id="u175"><span>乙型肝炎核心抗体</span></p>
      		</div>
            <div id="u247" class="ax_单选按钮">
            	<p id="u248">
            		<span>
            			<c:if test="${map.supplemetnaryExam.hbeag == '0'}">阴性</c:if>
            			<c:if test="${map.supplemetnaryExam.hbeag == '1'}">阳性</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u163" class="ax_水平线">
        		<hr id="u163_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u177" class="ax_文本段落">
          		<p id="u178"><span>梅毒血清学试验*</span></p>
      		</div>
            
            <div id="u179" class="ax_单选按钮">
            	<p id="u180">
            		<span>
            			<c:if test="${map.supplemetnaryExam.syphilisSerology == '0'}">阴性</c:if>
            			<c:if test="${map.supplemetnaryExam.syphilisSerology == '1'}">阳性</c:if>
            		</span>
           		</p>
      		</div>
            
            <div id="u176" class="ax_水平线">
        		<hr id="u176_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u182" class="ax_文本段落">
          		<p id="u183"><span>HIV抗体检测*</span></p>
      		</div>
            <div id="u184" class="ax_单选按钮">
            	<p id="u185">
            		<span>
            			<c:if test="${map.supplemetnaryExam.hivab == '0'}">阴性</c:if>
            			<c:if test="${map.supplemetnaryExam.hivab == '1'}">阳性</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u181" class="ax_水平线">
        		<hr id="u181_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            <div id="u187" class="ax_文本段落">
          		<p id="u188"><span>B超*</span></p>
      		</div>
            <div id="u1870" class="ax_文本段落">
          		<p id="u1880">
          			<span>
          				<c:if test="${map.supplemetnaryExam.bscan == '0'}">未检查</c:if>
          				<c:if test="${map.supplemetnaryExam.bscan == '1'}">无异常</c:if>
            			<c:if test="${map.supplemetnaryExam.bscan == '2'}">有异常&nbsp;${map.supplemetnaryExam.bscanRemark}</c:if>
          			</span>
          		</p>
      		</div>
            <div id="u186" class="ax_水平线">
        		<hr id="u186_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
     		</div>
			<div id="u192" class="ax_文本段落">
          		<p id="u193"><span></span></p>
      		</div>
            <div id="u311" class="ax_文本段落">
          		<p id="u312">
          			<span>
<%--           				<c:if test="${map.prenatalExa.evaluate == '0'}">未见异常</c:if> --%>
          				<c:if test="${map.prenatalExa.evaluate == '1'}">异常&nbsp;高危评分：${map.highRisk.score }
          					<br/><%-- <c:forEach items="${map.list}" var="item">
          						${item };&nbsp;
          						</c:forEach> --%>
          						<span style="color: #EE5F45">${map.nomalList }</span><br/>${map.malList }
          				</c:if>
          			</span>
          		</p>
      		</div>
            <!-- <div id="u191" class="ax_水平线">
        		<hr id="u191_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div> -->
            
            <div id="u195" class="ax_文本段落">
          		<p id="u196"><span>总体评估</span></p>
      		</div>
            
            <div id="u221" class="ax_文本段落">
                <p id="u222"><span><c:if test="${map.prenatalExa.evaluate == '0'}">未见异常</c:if></span></p>
      		</div>
            
            <div id="u194" class="ax_水平线">
        		<hr id="u194_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u197" class="ax_文本段落">
          		<p id="u198"><span>转诊</span></p>
      		</div>
            
            <div id="u199" class="ax_单选按钮">
            	<p id="u200">
            		<span>
            			<c:if test="${map.prenatalReferral.referral == '0' }">无</c:if>
            			<c:if test="${map.prenatalReferral.referral == '1' }">有</c:if>
            		</span>
            	</p>
      		</div>
            
            <div id="u201" class="ax_文本段落">
          		<p id="u202"><span>原因： ${map.prenatalReferral.reason}</span></p>
      		</div>
            
            <div id="u203" class="ax_文本段落">
          		<p id="u204">
          			<span>机构及科室：
          				<c:if test="${map.prenatalReferral.referral == '0' }"></c:if>
            			<c:if test="${map.prenatalReferral.referral == '1' }">${department.name}-${role.name}</c:if>
          			</span>
          		</p>
      		</div>
            
            <div id="u205" class="ax_水平线">
        		<hr id="u205_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
      		</div>
            
            <div id="u208" class="ax_文本段落">
          		<p id="u209"><span>下次随访日期</span></p>
      		</div>
            
            <div id="u207" class="ax_垂直线">
        		<hr id="u207_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u313" class="ax_文本段落">
          		<p id="u314"><span><fmt:formatDate value="${map.prenatalReferral.nextFollowingDate}" pattern="yyyy-MM-dd"/></span></p>
   		  	</div>
            
            <div id="u210" class="ax_垂直线">
        		<hr id="u210_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u212" class="ax_文本段落">
         		<p id="u213"><span>随访医生签名</span></p>
      		</div>
            
            <div id="u211" class="ax_垂直线">
        		<hr id="u211_line" style="weight:1px;border:none;border-left:1px solid #000000;"/>
      		</div>
            
            <div id="u315" class="ax_文本段落">
          		<p id="u316"><span></span></p>
      		</div>
            
          	<div id="u206" class="ax_水平线">
        		<hr id="u206_line" style="height:1px;border:none;border-top:1px solid #000000;"/>
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
	          <p id="pu17"><span style="font-size:18px;">产前检查反馈单</span></p>
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
	          <p id="pu25"><span>检查日期：</span><span><fmt:formatDate value="${map.prenatalExa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
	      	</div>
	        
	        <div id="pu26" class="ax_文本段落">
	          <p id="pu27" ><span>末次月经：</span><span><fmt:formatDate value="${map.motherhood.lastMenses }" pattern="yyyy-MM-dd"/></span></p>
	      	</div>
	        
	        <div id="pu28" class="ax_文本段落">
	          <p id="pu29"><span>预产期：</span><span><fmt:formatDate value="${map.expectedDate }" pattern="yyyy-MM-dd"/></span></p>
	      	</div>
	        
	        <div id="pu33" class="ax_文本段落">
	          <p id="pu34"><span>孕周：</span><span>${map.week }周</span></p>
	      	</div>
	        
	        <div id="pu30" class="ax_水平线">
	        	<hr id="pu30_line" style="height:1px;border:none;border-top:1px dashed #000;"/>
	      	</div>
	        
	        <div id="pu31" class="ax_image">
	        	<img id="pu31_img" class="img " src="${ctx }/static/css/first_u31.png"/>
	          	<p id="pu32"><span>&nbsp;</span></p>
	      	</div>
	        
	        <div id="pu46" class="ax_文本段落">
	          <p id="pu47"><span>身&nbsp;&nbsp; 高</span><span>：${map.bloodStethos.height }cm</span></p>
	      	</div>
	        
	        <div id="pu48" class="ax_文本段落">
	          <p id="pu49"><span>体&nbsp; 重：${map.bloodStethos.weight }Kg</span></p>
	      	</div>
	        
	        <div id="pu50" class="ax_文本段落">
	          <p id="pu51"><span>血&nbsp; 压：${map.bloodStethos.bloodHi }/${map.bloodStethos.bloodLow }mmHg</span></p>
	      	</div>
	        
	        <div id="pu56" class="ax_文本段落">
	          <p id="pu57">
	          	<span>血 型：</span>
	          	<span>
	          		<c:if test="${map.supplemetnaryExam.bloodType == '0'}">A</c:if>
           			<c:if test="${map.supplemetnaryExam.bloodType == '1'}">B</c:if>
           			<c:if test="${map.supplemetnaryExam.bloodType == '2'}">AB</c:if>
           			<c:if test="${map.supplemetnaryExam.bloodType == '3'}">O</c:if>
	          	</span>
	          </p>
	      	</div>
	        
	        <div id="pu52" class="ax_文本段落">
	          <p id="pu53"><span>血常规：白细胞计数值${map.supplemetnaryExam.leucocyte}g/L&nbsp;&nbsp;
	          	白细胞计数值${map.supplemetnaryExam.leucocyte}10^9/L</span></p>
	      	</div>
	        
	        <div id="pu60" class="ax_文本段落">
	          <p id="pu61">
		          <span>乙型肝炎表面抗原：
		          	<c:if test="${map.supplemetnaryExam.hbsag == '0'}">阴性</c:if>
            		<c:if test="${map.supplemetnaryExam.hbsag == '1'}">阳性</c:if>
		          </span>
	          </p>
	      	</div>
	        
	        <div id="pu54" class="ax_文本段落">
	          <p id="pu55"><span>尿常规：尿蛋白${map.supplemetnaryExam.proteinuria}μmol/L;&nbsp;
	          	尿糖${map.supplemetnaryExam.urineSugar}μmol/L;&nbsp;
	          	尿酮体${map.supplemetnaryExam.ketone}μmol/L;&nbsp;
	          	尿潜血${map.supplemetnaryExam.urineBlood}μmol/L;&nbsp;
	          </span></p>
	      	</div>
	        
	        <div id="pu64" class="ax_文本段落">
	          <p id="pu65"><span>HIV抗体检测：
	          	<c:if test="${map.supplemetnaryExam.hivab == '0'}">阴性</c:if>
            	<c:if test="${map.supplemetnaryExam.hivab == '1'}">阳性</c:if>
	          </span></p>
	      	</div>	
	
			<div id="pu58" class="ax_文本段落">
	          <p id="pu59"><span>血糖：${map.supplemetnaryExam.bloodGlucose}mmol/L</span></p>
	      	</div>
	        
	        <div id="pu62" class="ax_文本段落">
	          <p id="pu63"><span>梅毒血清学试验：
	          	<c:if test="${map.supplemetnaryExam.syphilisSerology == '0'}">阴性</c:if>
            	<c:if test="${map.supplemetnaryExam.syphilisSerology == '1'}">阳性</c:if>
	          </span></p>
	      	</div>
	        
	        <c:if test="${map.prenatalExa.evaluate == '1' }">
		        <div id="pu35" class="ax_文本段落">
		          <p id="pu36"><span>诊断：</span><span> ${map.highRisk.diaResult }</span></p>
		      	</div>
		        <!-- <div id="pu66" class="ax_文本段落" style="background-color:#FFFF00">
		          <p id="pu67"><span>---非高危表无诊断</span></p>
		      	</div> -->
	        </c:if>
	        
	        <div id="pu37" class="ax_文本段落" style="border:1px solid #000">
	          <p id="pu38"><span style="color:#333333;">指导意见：</span></p>
	          <p><span style="color:#333333;">&nbsp;</span></p>
	          <p><span style="color:#333333;">${map.prenatalExa.guidance }</span></p>
	          <p><span style="color:#333333;">&nbsp;</span></p>
	          <p>
		          <span style="color:#FF0000;">&nbsp; &nbsp; &nbsp;&nbsp; 
		          	<c:if test="${map.prenatalExa.evaluate == '1' }">
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
