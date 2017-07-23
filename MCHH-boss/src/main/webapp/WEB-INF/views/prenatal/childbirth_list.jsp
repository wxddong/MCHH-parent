<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>0分娩登记列表</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx }/static/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/data/styles.css" type="text/css" rel="stylesheet"/>
	<link href="${ctx}/static/css/childbirth_list.css" type="text/css" rel="stylesheet"/>
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
		height:50px;
		z-index:9999;
		background: #FFFFFF; 
		border:1px solid #CCCCCC;
		}
    
    </style>
    <script type="text/javascript">
     	$(function (){
     		 var size=document.getElementById('size').value;
     		 var sh = document.getElementById('s7').style.display;
     		if(size==2){
     			
     			document.getElementById("hs1").style.display='';
         		/* document.getElementById('h4').style.height='870px';
         		document.getElementById('u1314').style.height='1023px';
         		document.getElementById('s8').style.top='920px';
         		document.getElementById('s9').style.top='1440px';
         		document.getElementById('s7').style.top='1468px'; */
         		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+360+'px';
         		document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+360+'px';
         		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+360+'px';
         		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+360+'px';
         		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+360+'px';
         		if (sh == '') {
             		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+360+'px';
             		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+360+'px';
    			}else{
             		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+176+'px';
             		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+176+'px';
    			}
     			
     		}
     		if(size==3){
     			
     			document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		
         		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+720+'px';
         		document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+720+'px';
         		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+720+'px';
         		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+720+'px';
         		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+720+'px';
         		
         		if (sh == '') {
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+720+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+720+'px';
				}else{
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+536+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+536+'px';
				}
     			
     		}if(size==4){
     			
     			document.getElementById("hs1").style.display='';
     			
         		document.getElementById("hs2").style.display='';
         		
         		document.getElementById("hs3").style.display='';
         		
         		document.getElementById('h4').style.height='1590px';
				
         		document.getElementById('u1314').style.height='1743px';
         		
         		document.getElementById('s8').style.top='1640px';
         		
         		document.getElementById('s9').style.top='2160px';
         		
         		document.getElementById('s7').style.top='2188px';
         		
         		
         		if (sh == '') {
	         		document.getElementById('s10').style.top='2371px';
	         		document.getElementById('s11').style.top='2398px';
				}else{
	         		document.getElementById('s10').style.top='2187px';
	         		document.getElementById('s11').style.top='2214px';
				}
     			
     		}if(size==5){
     			
     			document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById("hs3").style.display='';
         		document.getElementById("hs4").style.display='';
         		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+1440+'px';
         		document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+1440+'px';
         		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+1440+'px';
         		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+1440+'px';
         		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+1440+'px';
         		if (sh == '') {
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1440+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1440+'px';
				}else{
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1256+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1256+'px';
				}
     			
     		}if(size==6){
     			
     			document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById("hs3").style.display='';
         		document.getElementById("hs4").style.display='';
         		document.getElementById("hs5").style.display='';
         		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+1800+'px';
         		document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+1800+'px';
         		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+1800+'px';
         		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+1800+'px';
         		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+1800+'px';
         		if (sh == '') {
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1800+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1800+'px';
				}else{
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1616+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1616+'px';
				}
     			
     		}if(size==7){
     			
     			document.getElementById("hs1").style.display='';
         		document.getElementById("hs2").style.display='';
         		document.getElementById("hs3").style.display='';
         		document.getElementById("hs4").style.display='';
         		document.getElementById("hs5").style.display='';
         		document.getElementById("hs6").style.display='';
         		document.getElementById('h4').style.height=document.getElementById('h4').offsetHeight+2160+'px';
         		document.getElementById('u1314').style.height=document.getElementById('u1314').offsetHeight+2160+'px';
         		document.getElementById('s8').style.top=document.getElementById('s8').offsetTop+2160+'px';
         		document.getElementById('s9').style.top=document.getElementById('s9').offsetTop+2160+'px';
         		document.getElementById('s7').style.top=document.getElementById('s7').offsetTop+2160+'px';
         		if (sh == '') {
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+2160+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+2160+'px';
				}else{
	         		document.getElementById('s10').style.top=document.getElementById('s10').offsetTop+1976+'px';
	         		document.getElementById('s11').style.top=document.getElementById('s11').offsetTop+1976+'px';
				}
     			
     		}
     		
		 		
		 		var addUrl="${ctx}/archivesinfo/listChildbirth";
		 		$("#u61").click(function(){
		 			
		 			
					
					document.getElementById("editStatus").value=0;

					window.location.href=addUrl ;
		 		
		 		});
				var editurl="${ctx}/archivesinfo/updateNoteView";
				$("#u63").click(function(){
					var id = $("#archId").val();
					window.location.href=editurl+'?archiveId='+id ;
				})
				var zhuanUrl="${ctx}/highriskprojectmanagement/list";
				
				$("#u65").click(function(){
					var id = $("#archId").val();
					var birthArchiveId = $("#birthArchiveId").val();
					
					window.location.href=zhuanUrl+'?archivesId='+id+'&birthArchiveId='+birthArchiveId ;
				})
				
		});
     	
     	/* function AutoFold(divName,textId,num){
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
		} */
     	
		function AutoFold(divName,textId,num){
			var operateDiv=document.getElementsByName(divName);
			var textDoc=document.getElementById(textId);
			var operateDivNum = divName.substring(7,divName.length);//获取当前操作层的层号
			
			var showStatus=operateDiv[0].style.display;
			var changeHeight=0;
			if(showStatus=='none'){
			//归位在展示，如果不归位，由于上移的关系，展示出来后的位置会偏上
			var d=document.getElementsByName("foldDiv"+(parseInt(operateDivNum)-1));
			operateDiv[0].style.top = (d[0].offsetTop+d[0].offsetHeight)+'px';
			
			operateDiv[0].style.display='';
			textDoc.innerHTML="收起";
			changeHeight=operateDiv[0].offsetHeight;
			}else{
			changeHeight=0-operateDiv[0].offsetHeight;
			operateDiv[0].style.display='none';
			textDoc.innerHTML="展开";
			}
			
			for (var i=parseInt(operateDivNum)+1;i<=num;i++)
			{
			var changeTopDiv=document.getElementsByName("foldDiv"+i);
			changeTopDiv[0].style.top=(changeTopDiv[0].offsetTop+changeHeight)+'px';
			}
		}
		
		
    </script>
  </head>
  <body style="background-color: #ffffff">
     <div id="base" class="">
		<form id="queryform" method="post">
      
      
      
      <div id="u8" class="ax_文本段落">
          <p id="u9"><span>检查医院:${operator2.department }</span></p>
      </div>
      
      
           <!-- Unnamed (形状) -->
      <div id="u10" class="ax_文本段落" >
          <p><span>检查医生:${operator2.realName }</span></p>
     </div>
     
     
     
           <!-- Unnamed (形状) -->
      <div id="u12" class="ax_文本段落">
	      <c:if test="${birthArchives.referralSign=='0' }">
	          <p id="u13"><span>转诊状态:未转诊</span></p>
	      </c:if>
	      <c:if test="${birthArchives.referralSign=='1' }">
	          <p id="u13"><span>转诊状态:孕检转诊</span></p>
	      </c:if>
	      <c:if test="${birthArchives.referralSign=='2' }">
	          <p id="u13"><span>转诊状态:分娩转诊</span></p>
	      </c:if>
	      <c:if test="${birthArchives.referralSign=='3' }">
	          <p id="u13"><span>转诊状态:产后转诊</span></p>
	      </c:if>
      </div>
      
      <div id="title">
		     
		      <div id="u54" class="ax_形状" style="background-color:#ee5f45">
		        <p id="u55"><span>分娩登记</span></p>
		      </div>
		      
		      <c:if test="${birthArchives.riskSign=='1' }">
			      <div id="u64" class="ax_形状" style="background-color:#ee5f45; display:'';cursor: pointer">
			          <p id="u65"><span id="u65" >专案记录</span></p>
			      </div>
      		  </c:if>
      		  <c:if test="${birthArchives.pregnantState!='2'}">
			      <div id="u62" class="ax_形状" style="background-color:#E9854F;cursor:pointer;" >
			          <p id="u63"><span>编辑</span></p>
			      </div>
		      </c:if>
		      
		      
      </div>

<div id="h1">    
      <div id="u4" class="ax_形状" style="background-color:#009dd9"> 
          <p id="u5"><span>个人基本信息</span></p>
      </div>
</div>
<div id="s3">
		<input id = "archId" type="hidden" name="id" value="${find.id }"/>
		<input id = "birthArchiveId" type="hidden" name="birthArchiveId" value="${birthArchives.id }"/>
		<input type="hidden" id="editStatus" name="editStatus" value="0"/>
  		<div id="u76" class="ax_文本段落">
          <p id="u77"><span>姓名:${find.name }</span></p>
      	</div>

   
  	  <div id="u78" class="ax_文本段落">
          <p id="u79">
          <span>档案编号:${find.archivesCode }</span>
          
          </p>
      </div>
      <div id="u90" class="ax_文本段落">
      		<p id="u91"><span>建档日期:<fmt:formatDate value="${find.creatTime }" pattern="yyyyMMdd"/></span></p>
      </div>
      <div id="u74" class="ax_文本段落">
          <p id="u75"><span>末次月经:<fmt:formatDate value="${birthArchives.lastMenses}" pattern="yyyyMMdd"/></span></p>
      </div>
      <div id="u70" class="ax_文本段落">
        	<p id="u71"><span>孕周:${weekByLastMenses}</span></p>
      </div>
      <div id="u68" class="ax_文本段落">
          <p id="u69"><span>出生日期:${womenbirthday}</span></p>
      </div>
      <div id="u80" class="ax_文本段落">
          <p  id="u81"><span>孕妇年龄:${age }</span></p>
      </div>
      <div id="u72" class="ax_文本段落">
          <p id="u73"><span>预产期:<fmt:formatDate value="${endOfDate }" pattern="yyyyMMdd"/></span></p>
      </div>
     
      <div id="u82" class="ax_文本段落">
        <p  id="u83"><span>联系电话:${find.telephone }</span></p>
      </div>
	  <div id="u84" class="ax_文本段落">
		       <p id="u85"><span>丈夫姓名:${find.manName }</span></p>
	  </div>
      <div id="u86" class="ax_文本段落">
          <p id="u87"><span>丈夫年龄:${manAge}</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u88" class="ax_文本段落">     
        <p id="u89"><span>丈夫电话:${find.manTele }</span></p>
      </div>
</div>




<div id="h2" name="foldDiv1" onclick="AutoFold('foldDiv2','u16',8)">
     
     <div id="u14" class="ax_形状" style="background-color:#009dd9">
          <p id="u15"><span>基本情况</span></p>
     </div>
     <div id="u16" class="ax_文本段落" style="background-color:#009dd9">
          <p id="u17">收起</p>
      </div>
</div>    
<div id="s4" name="foldDiv2">
     <div id="u287" class="ax_文本段落">
          <p id="u288" ><span>分娩日期:  </span></p>
     </div>
     
     
      <div id="u289" class="ax_下拉列表框">
       ${birthWODate }
      </div> 
      
      
        <div id="u290" class="ax_文本段落">
          <p id="u291"><span>住院号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${childbirthBasic.hospitalCode }</span></p>
      </div>
      
      
         <div id="u340" class="ax_文本段落">
          <p id="u341"><span>出院日期:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${childbirthBasic.leaveDate }" pattern="yyyyMMdd"/></span></p>
      </div>
       
      <div id="u276" class="ax_文本段落">
          <p id="u277"><span>末次月经:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${birthArchives.lastMenses}" pattern="yyyyMMdd"/></span></p>      
      </div>
      
     

f
	   <div id="u279" class="ax_文本段落">
	          <p id="u280"><span>孕周:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBasic.gestationalWeek } 周 ${childbirthBasic.gestationalDay } 天</span></p>
	  </div>

    	<div id="u293" class="ax_文本段落">
          <p  id="u294"><span>孕 次:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBasic.pregnancyNum } 次</span></p>
      </div>
      <div id="u296" class="ax_文本段落">
          <p id="u297"><span>产 次:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBasic.bearNum } 次</span></p>
      </div>
      <div id="u303" class="ax_文本段落">
          <p id="u304"><span>孕产保健:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBasic.healthcareNum } 次</span></p>
      </div>

    <div id="u308" class="ax_文本段落">
          <p  id="u309"><span>是否检测乙肝:</span></p>
  </div>

  <!-- Unnamed (下拉列表框) -->
      <div id="u310" class="ax_下拉列表框">
      <c:if test="${childbirthBasic.checkHepatitis=='0' }">
        <span id="u310_input"> 是</span>
      </c:if>
      
      <c:if test="${childbirthBasic.checkHepatitis=='1' }">
        <span id="u310_input"> 否</span>
      </c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u311" class="ax_文本段落">
          <p id="u312"><span>乙肝表面抗原:</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u313" class="ax_下拉列表框">
      <c:if test="${childbirthBasic.antigenHepatitis=='1' }">
        <span id="u313_input"> 否</span>
      </c:if>
      <c:if test="${childbirthBasic.antigenHepatitis=='0' }">
        <span id="u313_input"> 是</span>
      </c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u314" class="ax_文本段落">
          <p id="u315"><span>是否检测梅毒:</span></p>
      </div>
      <div id="u316" class="ax_下拉列表框">
        
	      <c:if test="${childbirthBasic.checkSyphilis=='1' }">
	        <span id="u316_input"> 否</span>
	      </c:if>
	      <c:if test="${childbirthBasic.checkSyphilis=='0' }">
	        <span id="u316_input"> 是</span>
	      </c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u317" class="ax_文本段落">
          <p id="u318"><span>是否感染梅毒:</span></p>
      </div>
      <div id="u319" class="ax_下拉列表框">
          <c:if test="${childbirthBasic.infectedSyphilis=='1' }">
	        <span id="u319_input"> 否</span>
	      </c:if>
	      <c:if test="${childbirthBasic.infectedSyphilis=='0' }">
	        <span id="u319_input"> 是</span>
	      </c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u320" class="ax_文本段落">
          <p id="u321"><span>是否检测艾滋病:</span></p>
      </div>
      <div id="u322" class="ax_下拉列表框"> 
      	<c:if test="${childbirthBasic.checkAids=='1' }">
	        <span id="u319_input"> 否</span>
	    </c:if>
	    <c:if test="${childbirthBasic.checkAids=='0' }">
	        <span id="u319_input"> 是</span>
	    </c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u323" class="ax_文本段落" >
          <p id="u324"><span>是否感染艾滋病:</span></p>
      </div>
      <div id="u325" class="ax_下拉列表框">
      
      <c:if test="${childbirthBasic.infectedAids=='1' }">
	        <span id="u325_input"> 否</span>
	    </c:if>
	    <c:if test="${childbirthBasic.infectedAids=='0' }">
	        <span id="u325_input"> 是</span>
	    </c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u326" class="ax_文本段落">
          <p id="u327"><span>血红蛋白检测:</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u328" class="ax_下拉列表框">
      	<c:if test="${childbirthBasic.checkHemoglobin=='1' }">
	        <span id="u328_input"> 否</span>
	    </c:if>
	    <c:if test="${childbirthBasic.checkHemoglobin=='0' }">
	        <span id="u328_input"> 是</span>
	    </c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u329" class="ax_文本段落">
        <div>
          <p id="u330"><span>是否重度贫血:</span></p>
        </div>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u331" class="ax_下拉列表框">
      	<c:if test="${childbirthBasic.anemia=='1' }">
	        <span id="u331_input"> 否</span>
	    </c:if>
	    <c:if test="${childbirthBasic.anemia=='0' }">
	        <span id="u331_input"> 是</span>
	    </c:if>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u332" class="ax_文本段落">
          <p id="u333"><span name="famHistory">家族史:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u334" class="ax_文本段落">
          <p id="u335"><span>家族遗传疾病:</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u336" class="ax_文本框">
        <span id="u336_input">${childbirthBasic.geneticIll }</span>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u337" class="ax_文本段落">
          <p id="u338"><span>近亲结婚:</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u339" class="ax_下拉列表框" >
      
      	<c:if test="${childbirthBasic.relativesMating=='1' }">
	        <span id="u339_input"> 否</span>
	    </c:if>
	    <c:if test="${childbirthBasic.relativesMating=='0' }">
	        <span id="u339_input"> 是</span>
	    </c:if>
      </div>
</div>  
   

<div id="h3" name="foldDiv3" onclick="AutoFold('foldDiv4','u20',8)">
      <div id="u18" class="ax_形状" style="background-color:#009dd9">
        <p id="u19"><span>分娩信息</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u20" class="ax_文本段落" style="background-color:#009dd9">
          <p id="u21" onclick="CanShu('h4','u21');">收起</p>
      </div>   
</div>

<div id = "u1314" name="foldDiv4">
<div id="h4">
<div id="s5">  
   
      <div id="u343" class="ax_文本段落">
          <p id="u344"><span>分娩地点:</span></p>
      </div>
      
       <div id="u429" class="ax_下拉列表框">
       
        <span id="u429_input">${childbirth.childbirthPlace }</span>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u345" class="ax_文本段落">
          <p id="u346"><span>产程时间:</span></p>
      </div>
      
      
       <div id="u365" class="ax_文本段落">
		 <p id="u366"><span>第一产程:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirth.firstHour } 小时 ${childbirth.firstMinute } 分钟</span></p>      
  	  </div>
      
 
      <div id="u367" class="ax_文本段落">
          <p id="u368"><span>第二产程:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirth.secondHour } 小时 ${childbirth.secondMinute } 分钟</span></p>
      </div>
       
      
       
	<div id="u369" class="ax_文本段落">
          <p id="u370"><span>第三产程:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirth.thirdHour } 小时 ${childbirth.thirdMinute } 分钟</span></p>
    </div>
   

	 
     
  <div id="u371" class="ax_文本段落">
       <p id="u372"><span>总产程:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirth.totalHour } 小时 ${childbirth.totalMinute } 分钟</span></p>
  </div>
   

 		<div id="u347" class="ax_文本段落">
          <p id="u348"><span>胎盘:</span></p>
       </div>
       <div id="u454" class="ax_下拉列表框">
        <span id="u454_input">${childbirth.placenta }</span>
      </div>
      
      

 	  <div id="u373" class="ax_文本段落">
          <p id="u374"><span>会阴侧切:</span></p>
      </div>
	 <div id="u455" class="ax_下拉列表框">
	 	
	 		<c:if test="${childbirth.perineumCut=='0' }">
	        	<span id="u455_input">是</span>
	        	
        	</c:if>
        	<c:if test="${childbirth.perineumCut=='1' }">
	        	<span id="u455_input">否</span>
        	</c:if>
       
        
  	</div>
  	 <!-- Unnamed (形状) -->
      <div id="u375" class="ax_文本段落">
          <p  id="u376"><span>伤裂程度:</span></p>
      </div>
      
      <div id="u456" class="ax_下拉列表框">
      
       	<span id="u456_input">${childbirth.injuryDegree}</span>
      </div>

      <!-- Unnamed (形状) -->
      
	  <div id="u379" class="ax_文本段落">
          <p id="u380"><span>出血量及羊水:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u381" class="ax_文本段落">
          <p id="u382"><span>产时出血量:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirth.bearBleeding } ml</span></p>      
  	  </div>
       

      <!-- Unnamed (形状) -->
      <div id="u383" class="ax_文本段落">
          <p id="u384"><span>产后2小时:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirth.afterbearTwo } ml</span></p>
      </div>
      
       

      <!-- Unnamed (形状) -->
      <div id="u385" class="ax_文本段落">
          <p id="u386"><span>总出血量:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirth.totalBleeding } ml</span></p>
      </div>
      
      <div id="u476" class="ax_文本段落">
          <p id="u477"><span>羊水性状:</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      

      <!-- Unnamed (下拉列表框) -->
      <div id="u481" class="ax_下拉列表框" name="amnioticFluidTrait">
        
      		<c:if test="${childbirth.amnioticFluidTrait=='0' }">
	        	 <span id="u481_input">正常</span>
	        </c:if>
       		<c:if test="${childbirth.amnioticFluidTrait=='1' }">
	        	 <span id="u481_input">异常&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirth.amnioticFluidRemark}</span>
			</c:if>
	  </div>
	  <div id="u387" class="ax_文本段落">
          <p id="u388"><span>羊水量:</span></p>
      </div>
      <div id="u478" class="ax_文本框">
      	
        	<span id="u478_input">${childbirth.amnioticFluidAmount } ml</span>
      </div>

      
      <div id="u359" class="ax_文本段落">
          <p id="u360"><span>胎数:</span></p>
      </div>
      
      <div id="u483" class="ax_下拉列表框">
        <span id="u483_input">${childbirth.fetalNum }</span>
      </div>
      
      <%-- <div id="u504" class="ax_文本段落">
      <img id="u506_img" class="img " src="${ctx}/static/images/0第2次产前随访记录表/u639.png"/>
          <a href="" id="u505" style="color:#ff4848" >新增婴儿信息</a>
      </div> 
      --%>
</div>      
      

<div id="s6">
	<input type="hidden" value="${size }" id="size">
      <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位:</span></p>
      </div>
      
      <c:if test="${childbirthBabyInfoPO0.fetusPosition==0}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">左腹</span>
	      </div>
	  </c:if>
	    <c:if test="${childbirthBabyInfoPO0.fetusPosition==1}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">右腹</span>
	      </div>
	  </c:if>
      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBabyInfoPO0.deliveryHour} 时 ${childbirthBabyInfoPO0.deliveryMinute } 分</span></p>
      </div>
      
       
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产:</span></p>
      </div>
      
      <c:if test="${childbirthBabyInfoPO0.inducelabour==0 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO0.inducelabour==1 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">否</span>
	      </div>
      </c:if>
      
      <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式:</span></p>
      </div>
      
      <c:if test="${childbirthBabyInfoPO0.deliveryType ==0}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">剖宫产</span>
	      </div>
     </c:if> 
      <c:if test="${childbirthBabyInfoPO0.deliveryType ==1}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">顺产</span>
	      </div>
     </c:if> 
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征:</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <span id="u466_input">${childbirthBabyInfoPO0.cesareanIdicatio }</span>
      </div>
      
      <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况:</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名:</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <span  id="u485_input">${childbirthBabyInfoPO0.babyName }</span>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别:</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">   
        	<c:if test="${childbirthBabyInfoPO0.babySex=='0' }">
        		<span id="u482_input">男</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO0.babySex=='1' }">
        		<span id="u482_input">女</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO0.babySex=='2' }">
        		<span id="u482_input">性别不明</span>
        	</c:if>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况:</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
       		<c:if test="${childbirthBabyInfoPO0.health=='0' }">
        		<span id="u484_input">强壮</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO0.health=='1' }">
        		<span id="u484_input">健康</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO0.health=='2' }">
        		<span id="u484_input">虚弱</span>
        	</c:if>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形:</span></p>
      </div>
      
      
      <c:if test="${childbirthBabyInfoPO0.fetalAnomaly==0 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO0.fetalAnomaly==1 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">否</span>
	      </div>
      </c:if>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位:</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <span id="u487_input">${childbirthBabyInfoPO0.abnormalPosition }</span>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称:</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <span id="u488_input">${childbirthBabyInfoPO0.abnormalName }</span>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分:</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分:</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <span id="u489_input">${childbirthBabyInfoPO0.oneMinScore }</span>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分:</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <span id="u490_input">${childbirthBabyInfoPO0.fiveMinScore }</span>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重:</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <span  id="u491_input">${childbirthBabyInfoPO0.bornWeight } g</span>
      </div>
      
       
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长:</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <span id="u492_input">${childbirthBabyInfoPO0.bodyLenght } cm</span>
      </div>
      
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗:</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
            <c:forEach var="list" items="${list0 }">
	            <c:if test="${list=='0' }">
	        		<input id="u411_input" type="checkbox" value="0" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        	<c:forEach var="list" items="${list0 }">
	            <c:if test="${list=='1' }">
	        		<input id="u413_input" type="checkbox" value="1" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        	<c:forEach var="list" items="${list0 }">
	            <c:if test="${list=='2' }">
	        		<input id="u415_input" type="checkbox" value="2" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡:</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <c:if test="${childbirthBabyInfoPO0.fetusDie=='0' }">
        	<span id="u498_input">是</span>
        </c:if>
        <c:if test="${childbirthBabyInfoPO0.fetusDie=='1' }">
        	<span id="u498_input">否</span>
        </c:if>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者:</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <span id="u497_input">${childbirthBabyInfoPO0.midwife }</span>
      </div>
 </div> 
    
<div id="hs1"  style="display: none" >
            <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位:</span></p>
      </div>
      
        <c:if test="${childbirthBabyInfoPO1.fetusPosition==0}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">左腹</span>
	      </div>
	  </c:if>
	    <c:if test="${childbirthBabyInfoPO1.fetusPosition==1}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">右腹</span>
	      </div>
	  </c:if>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBabyInfoPO1.deliveryHour } 时 ${childbirthBabyInfoPO1.deliveryMinute } 分</span></p>
      </div>
      
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产:</span></p>
      </div>
      
       <div id="u458" class="ax_下拉列表框">
	       		<c:if test="${childbirthBabyInfoPO1.inducelabour==0 }">
		        	<span id="u458_input">是</span>
		      	</c:if>
		      <c:if test="${childbirthBabyInfoPO1.inducelabour==1 }">
			        <span id="u458_input">否</span>
		      </c:if>
     
      </div>
      
      <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式:</span></p>
      </div>
      
      
       <c:if test="${childbirthBabyInfoPO1.deliveryType ==0}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">剖宫产</span>
	      </div>
     </c:if> 
      <c:if test="${childbirthBabyInfoPO1.deliveryType ==1}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">顺产</span>
	      </div>
     </c:if> 
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征:</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.cesareanIdicatio }</span>
      </div>
      
      <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况:</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名:</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.babyName }</span>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别:</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">   
        	<c:if test="${childbirthBabyInfoPO1.babySex=='0' }">
        		<span id="u482_input">男</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO1.babySex=='1' }">
        		<span id="u482_input">女</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO1.babySex=='2' }">
        		<span id="u482_input">性别不明</span>
        	</c:if>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况:</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
       		<c:if test="${childbirthBabyInfoPO1.health=='0' }">
        		<span id="u484_input">强壮</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO1.health=='1' }">
        		<span id="u484_input">健康</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO1.health=='2' }">
        		<span id="u484_input">虚弱</span>
        	</c:if>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形:</span></p>
      </div>
      
      
        <c:if test="${childbirthBabyInfoPO1.fetalAnomaly==0 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO1.fetalAnomaly==1 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">否</span>
	      </div>
      </c:if>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位:</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.abnormalPosition }</span>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称:</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.abnormalName }</span>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分:</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分:</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.oneMinScore }</span>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分:</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.fiveMinScore }</span>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重:</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.bornWeight } g</span>
      </div>
      
       
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长:</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.bodyLenght } cm</span>
      </div>
      
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗:</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
            <c:forEach var="list" items="${list1 }">
	            <c:if test="${list=='0' }">
	        		<input id="u411_input" type="checkbox" value="0" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        	<c:forEach var="list" items="${list1 }">
	            <c:if test="${list=='1' }">
	        		<input id="u413_input" type="checkbox" value="1" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        	<c:forEach var="list" items="${list1 }">
	            <c:if test="${list=='2' }">
	        		<input id="u415_input" type="checkbox" value="2" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡:</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
       <c:if test="${childbirthBabyInfoPO1.fetusDie=='0' }">
        	<span id="u498_input">是</span>
        </c:if>
        <c:if test="${childbirthBabyInfoPO1.fetusDie=='1' }">
        	<span id="u498_input">否</span>
        </c:if>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者:</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <span>${childbirthBabyInfoPO1.midwife }</span>
      </div>
 </div>
<div id="hs2"  style="display: none">
	        <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位:</span></p>
      </div>
      
       <c:if test="${childbirthBabyInfoPO2.fetusPosition==0}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">左腹</span>
	      </div>
	  </c:if>
	    <c:if test="${childbirthBabyInfoPO2.fetusPosition==1}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">右腹</span>
	      </div>
	  </c:if>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBabyInfoPO2.deliveryHour } 时 ${childbirthBabyInfoPO2.deliveryMinute } 分</span></p>
      </div>
      
      
      
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产:</span></p>
      </div>
      
        <c:if test="${childbirthBabyInfoPO2.inducelabour==0 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO2.inducelabour==1 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">否</span>
	      </div>
      </c:if>
      
      
      <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式:</span></p>
      </div>
      
      
       <c:if test="${childbirthBabyInfoPO2.deliveryType ==0}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">剖宫产</span>
	      </div>
     </c:if> 
      <c:if test="${childbirthBabyInfoPO2.deliveryType ==1}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">顺产</span>
	      </div>
     </c:if> 
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征:</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.cesareanIdicatio }</span>
      </div>
      
      <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况:</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名:</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.babyName }</span>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别:</span></p>
      </div>
      
       <div id="u482" class="ax_下拉列表框">   
        	<c:if test="${childbirthBabyInfoPO2.babySex=='0' }">
        		<span id="u482_input">男</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO2.babySex=='1' }">
        		<span id="u482_input">女</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO2.babySex=='2' }">
        		<span id="u482_input">性别不明</span>
        	</c:if>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况:</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
       		<c:if test="${childbirthBabyInfoPO2.health=='0' }">
        		<span id="u484_input">强壮</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO2.health=='1' }">
        		<span id="u484_input">健康</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO2.health=='2' }">
        		<span id="u484_input">虚弱</span>
        	</c:if>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形:</span></p>
      </div>
      
      
      
         <c:if test="${childbirthBabyInfoPO2.fetalAnomaly==0 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO2.fetalAnomaly==1 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">否</span>
	      </div>
      </c:if>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位:</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.abnormalPosition }</span>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称:</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.abnormalName }</span>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分:</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分:</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.oneMinScore }</span>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分:</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.fiveMinScore }</span>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重:</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.bornWeight } g</span>
      </div>
      
       
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长:</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.bodyLenght } cm</span>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗:</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
            <c:forEach var="list" items="${list2 }">
	            <c:if test="${list=='0' }">
	        		<input id="u411_input" type="checkbox" value="0" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        	<c:forEach var="list" items="${list2 }">
	            <c:if test="${list=='1' }">
	        		<input id="u413_input" type="checkbox" value="1" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        	<c:forEach var="list" items="${list2 }">
	            <c:if test="${list=='2' }">
	        		<input id="u415_input" type="checkbox" value="2" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡:</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <c:if test="${childbirthBabyInfoPO2.fetusDie=='0' }">
        	<span id="u498_input">是</span>
        </c:if>
        <c:if test="${childbirthBabyInfoPO2.fetusDie=='1' }">
        	<span id="u498_input">否</span>
        </c:if>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者:</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <span>${childbirthBabyInfoPO2.midwife }</span>
      </div>
 </div>
<div id="hs3"  style="display: none" >
		      <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位:</span></p>
      </div>
      
        <c:if test="${childbirthBabyInfoPO3.fetusPosition==0}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">左腹</span>
	      </div>
	  </c:if>
	    <c:if test="${childbirthBabyInfoPO3.fetusPosition==1}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">右腹</span>
	      </div>
	  </c:if>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBabyInfoPO3.deliveryHour } 时 ${childbirthBabyInfoPO3.deliveryMinute } 分</span></p>
      </div>
      
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产:</span></p>
      </div>
      
      <c:if test="${childbirthBabyInfoPO3.inducelabour==0 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO3.inducelabour==1 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">否</span>
	      </div>
      </c:if>
     
      
      <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式:</span></p>
      </div>
      
      
       <c:if test="${childbirthBabyInfoPO3.deliveryType ==0}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">剖宫产</span>
	      </div>
     </c:if> 
      <c:if test="${childbirthBabyInfoPO3.deliveryType ==1}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">顺产</span>
	      </div>
     </c:if> 
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征:</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.cesareanIdicatio }</span>
      </div>
      
      <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况:</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名:</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.babyName }</span>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别:</span></p>
      </div>
      
     <div id="u482" class="ax_下拉列表框">   
        	<c:if test="${childbirthBabyInfoPO3.babySex=='0' }">
        		<span id="u482_input">男</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO3.babySex=='1' }">
        		<span id="u482_input">女</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO3.babySex=='2' }">
        		<span id="u482_input">性别不明</span>
        	</c:if>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况:</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
       		<c:if test="${childbirthBabyInfoPO3.health=='0' }">
        		<span id="u484_input">强壮</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO3.health=='1' }">
        		<span id="u484_input">健康</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO3.health=='2' }">
        		<span id="u484_input">虚弱</span>
        	</c:if>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形:</span></p>
      </div>
      
      
      
        <c:if test="${childbirthBabyInfoPO3.fetalAnomaly==0 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO3.fetalAnomaly==1 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">否</span>
	      </div>
      </c:if>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位:</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.abnormalPosition }</span>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称:</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.abnormalName }</span>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分:</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分:</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.oneMinScore }</span>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分:</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.fiveMinScore }</span>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重:</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.bornWeight } g</span>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长:</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.bodyLenght } cm</span>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗:</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
            <c:forEach var="list" items="${list3 }">
	            <c:if test="${list=='0' }">
	        		<input id="u411_input" type="checkbox" value="0" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        	<c:forEach var="list" items="${list3 }">
	            <c:if test="${list=='1' }">
	        		<input id="u413_input" type="checkbox" value="1" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        	<c:forEach var="list" items="${list3 }">
	            <c:if test="${list=='2' }">
	        		<input id="u415_input" type="checkbox" value="2" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡:</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
       <c:if test="${childbirthBabyInfoPO3.fetusDie=='0' }">
        	<span id="u498_input">是</span>
        </c:if>
        <c:if test="${childbirthBabyInfoPO3.fetusDie=='1' }">
        	<span id="u498_input">否</span>
        </c:if>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者:</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <span>${childbirthBabyInfoPO3.midwife }</span>
      </div>
 </div>
 
 <div id="hs4"  style="display: none" >
		      <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位:</span></p>
      </div>
      
        <c:if test="${childbirthBabyInfoPO4.fetusPosition==0}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">左腹</span>
	      </div>
	  </c:if>
	    <c:if test="${childbirthBabyInfoPO4.fetusPosition==1}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">右腹</span>
	      </div>
	  </c:if>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBabyInfoPO4.deliveryHour } 时 ${childbirthBabyInfoPO4.deliveryMinute } 分</span></p>
      </div>
      
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产:</span></p>
      </div>
      
       <c:if test="${childbirthBabyInfoPO4.inducelabour==0 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO4.inducelabour==1 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">否</span>
	      </div>
      </c:if>
  
      
      <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式:</span></p>
      </div>
      
      
       <c:if test="${childbirthBabyInfoPO4.deliveryType ==0}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">剖宫产</span>
	      </div>
     </c:if> 
      <c:if test="${childbirthBabyInfoPO4.deliveryType ==1}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">顺产</span>
	      </div>
     </c:if> 
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征:</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.cesareanIdicatio }</span>
      </div>
      
      <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况:</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名:</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.babyName }</span>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别:</span></p>
      </div>
      
     <div id="u482" class="ax_下拉列表框">   
        	<c:if test="${childbirthBabyInfoPO4.babySex=='0' }">
        		<span id="u482_input">男</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO4.babySex=='1' }">
        		<span id="u482_input">女</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO4.babySex=='2' }">
        		<span id="u482_input">性别不明</span>
        	</c:if>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况:</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
       		<c:if test="${childbirthBabyInfoPO4.health=='0' }">
        		<span id="u484_input">强壮</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO4.health=='1' }">
        		<span id="u484_input">健康</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO4.health=='2' }">
        		<span id="u484_input">虚弱</span>
        	</c:if>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形:</span></p>
      </div>
      
      
      
        <c:if test="${childbirthBabyInfoPO4.fetalAnomaly==0 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO4.fetalAnomaly==1 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">否</span>
	      </div>
      </c:if>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位:</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.abnormalPosition }</span>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称:</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.abnormalName }</span>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分:</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分:</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.oneMinScore }</span>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分:</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.fiveMinScore }</span>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重:</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.bornWeight } g</span>
      </div>
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长:</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.bodyLenght } cm</span>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗:</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
            <c:forEach var="list" items="${list4 }">
	            <c:if test="${list=='0' }">
	        		<input id="u411_input" type="checkbox" value="0" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        	<c:forEach var="list" items="${list4 }">
	            <c:if test="${list=='1' }">
	        		<input id="u413_input" type="checkbox" value="1" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        	<c:forEach var="list" items="${list4 }">
	            <c:if test="${list=='2' }">
	        		<input id="u415_input" type="checkbox" value="2" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡:</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
       <c:if test="${childbirthBabyInfoPO4.fetusDie=='0' }">
        	<span id="u498_input">是</span>
        </c:if>
        <c:if test="${childbirthBabyInfoPO4.fetusDie=='1' }">
        	<span id="u498_input">否</span>
        </c:if>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者:</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <span>${childbirthBabyInfoPO4.midwife }</span>
      </div>
 </div>
 
 
 
 <div id="hs5"  style="display: none" >
	  <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位:</span></p>
      </div>
      
      <c:if test="${childbirthBabyInfoPO5.fetusPosition==0}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">左腹</span>
	      </div>
	  </c:if>
	    <c:if test="${childbirthBabyInfoPO5.fetusPosition==1}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">右腹</span>
	      </div>
	  </c:if>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBabyInfoPO5.deliveryHour } 时 ${childbirthBabyInfoPO5.deliveryMinute } 分</span></p>
      </div>
      
      
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产:</span></p>
      </div>
      
       <c:if test="${childbirthBabyInfoPO5.inducelabour==0 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO5.inducelabour==1 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">否</span>
	      </div>
      </c:if>
     
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式:</span></p>
      </div>
      
      
       <c:if test="${childbirthBabyInfoPO5.deliveryType ==0}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">剖宫产</span>
	      </div>
     </c:if> 
      <c:if test="${childbirthBabyInfoPO5.deliveryType ==1}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">顺产</span>
	      </div>
     </c:if> 
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征:</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.cesareanIdicatio }</span>
      </div>
      
      <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况:</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名:</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.babyName }</span>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别:</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">   
        	<c:if test="${childbirthBabyInfoPO5.babySex=='0' }">
        		<span id="u482_input">男</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO5.babySex=='1' }">
        		<span id="u482_input">女</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO5.babySex=='2' }">
        		<span id="u482_input">性别不明</span>
        	</c:if>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况:</span></p>
      </div>
      
        <div id="u484" class="ax_下拉列表框">
       		<c:if test="${childbirthBabyInfoPO5.health=='0' }">
        		<span id="u484_input">强壮</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO5.health=='1' }">
        		<span id="u484_input">健康</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO5.health=='2' }">
        		<span id="u484_input">虚弱</span>
        	</c:if>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形:</span></p>
      </div>
      
      
      
         <c:if test="${childbirthBabyInfoPO5.fetalAnomaly==0 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO5.fetalAnomaly==1 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">否</span>
	      </div>
      </c:if>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位:</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.abnormalPosition }</span>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称:</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.abnormalName }</span>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分:</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分:</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.oneMinScore }</span>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分:</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.fiveMinScore }</span>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重:</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.bornWeight } g</span>
      </div>
      
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长:</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.bodyLenght } cm</span>
      </div>
      
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗:</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
            <c:forEach var="list" items="${list5 }">
	            <c:if test="${list=='0' }">
	        		<input id="u411_input" type="checkbox" value="0" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        	<c:forEach var="list" items="${list5 }">
	            <c:if test="${list=='1' }">
	        		<input id="u413_input" type="checkbox" value="1" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        	<c:forEach var="list" items="${list5 }">
	            <c:if test="${list=='2' }">
	        		<input id="u415_input" type="checkbox" value="2" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡:</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <c:if test="${childbirthBabyInfoPO5.fetusDie=='0' }">
        	<span id="u498_input">是</span>
        </c:if>
        <c:if test="${childbirthBabyInfoPO5.fetusDie=='1' }">
        	<span id="u498_input">否</span>
        </c:if>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者:</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <span>${childbirthBabyInfoPO5.midwife }</span>
      </div>
 </div>
 <div id="hs6"  style="display: none" >
	        <div id="u506" class="ax_形状">
          <p id="u507"><span>&nbsp;</span></p>
      </div>
      
      <div id="u502" class="ax_形状">
          <p id="u503"><span>&nbsp;</span></p>
      </div>
      <div id="u349" class="ax_文本段落">
          <p id="u350"><span>分娩情况:</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u351" class="ax_文本段落">
          <p id="u352"><span>胎位:</span></p>
      </div>
      
        <c:if test="${childbirthBabyInfoPO6.fetusPosition==0}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">左腹</span>
	      </div>
	  </c:if>
	    <c:if test="${childbirthBabyInfoPO6.fetusPosition==1}">
	       <!-- Unnamed (下拉列表框) -->
	      <div id="u457" class="ax_下拉列表框">
	        <span id="u457_input">右腹</span>
	      </div>
	  </c:if>

      <div id="u353" class="ax_文本段落">
          <p id="u354"><span>分娩时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childbirthBabyInfoPO6.deliveryHour } 时 ${childbirthBabyInfoPO6.deliveryMinute } 分</span></p>
      </div>
      
      
         <!-- Unnamed (形状) -->
      <div id="u377" class="ax_文本段落">
          <p id="u378"><span>引产:</span></p>
      </div>
      
        <c:if test="${childbirthBabyInfoPO6.inducelabour==0 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO6.inducelabour==1 }">
	       <div id="u458" class="ax_下拉列表框">
	        <span id="u458_input">否</span>
	      </div>
      </c:if>
      
      
          <div id="u355" class="ax_文本段落">
          <p id="u356"><span>分娩方式:</span></p>
      </div>
      
      
       <c:if test="${childbirthBabyInfoPO6.deliveryType ==0}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">剖宫产</span>
	      </div>
     </c:if> 
      <c:if test="${childbirthBabyInfoPO6.deliveryType ==1}">
	       <div id="u459" class="ax_下拉列表框">
	        
	        	<span id="u459_input">顺产</span>
	      </div>
     </c:if> 
      
      
       
      <div id="u363" class="ax_文本段落">
          <p id="u364"><span>剖宫产指征:</span></p>
      </div>
      <div id="u466" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.cesareanIdicatio }</span>
      </div>
      
      <div id="u389" class="ax_文本段落">

          <p id="u390"><span>婴儿基本情况:</span></p>
      </div>
      
      <div id="u391" class="ax_文本段落">
          <p id="u392" ><span>婴儿姓名:</span></p>
      </div>
      
       <div id="u485" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.babyName }</span>
      </div>
      
      <div id="u357" class="ax_文本段落">
          <p id="u358"><span>婴儿性别:</span></p>
      </div>
      
      <div id="u482" class="ax_下拉列表框">   
        	<c:if test="${childbirthBabyInfoPO6.babySex=='0' }">
        		<span id="u482_input">男</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO6.babySex=='1' }">
        		<span id="u482_input">女</span>
        	</c:if>
        	
        	<c:if test="${childbirthBabyInfoPO6.babySex=='2' }">
        		<span id="u482_input">性别不明</span>
        	</c:if>
      </div>
      
      <div id="u361" class="ax_文本段落">
          <p id="u362"><span>健康状况:</span></p>
      </div>
      
       <div id="u484" class="ax_下拉列表框">
       		<c:if test="${childbirthBabyInfoPO6.health=='0' }">
        		<span id="u484_input">强壮</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO6.health=='1' }">
        		<span id="u484_input">健康</span>
        	</c:if>
        	<c:if test="${childbirthBabyInfoPO6.health=='2' }">
        		<span id="u484_input">虚弱</span>
        	</c:if>
      </div>
      
       <div id="u393" class="ax_文本段落">
          <p id="u394"><span>胎儿畸形:</span></p>
      </div>
      
      
      
        <c:if test="${childbirthBabyInfoPO6.fetalAnomaly==0 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">是</span>
	      </div>
      </c:if>
      <c:if test="${childbirthBabyInfoPO6.fetalAnomaly==1 }">
	       <div id="u486" class="ax_下拉列表框">
	        
	        	<span id="u486_input">否</span>
	      </div>
      </c:if>
      
       <div id="u395" class="ax_文本段落">
          <p id="u396"><span>畸形各类部位:</span></p>
      </div>
      
      <div id="u487" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.abnormalPosition }</span>
      </div>
      <div id="u397" class="ax_文本段落">
          <p id="u398"><span>畸形名称:</span></p>
      </div>
      
      <div id="u488" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.abnormalName }</span>
      </div>
      
       <div id="u399" class="ax_文本段落">
          <p id="u400"><span>评分:</span></p>
      </div>
      
      <div id="u401" class="ax_文本段落">
          <p id="u402"><span>1钟评分:</span></p>
      </div>
      
       <div id="u489" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.oneMinScore }</span>
      </div>
      
        <div id="u403" class="ax_文本段落">
          <p id="u404"><span>5分钟评分:</span></p>
      </div>
      
       <div id="u490" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.fiveMinScore }</span>
      </div>
      <div id="u405" class="ax_文本段落">
          <p id="u406"><span>出生体重:</span></p>
      </div>
      
      <div id="u491" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.bornWeight } g</span>
      </div>
      
      
      <div id="u407" class="ax_文本段落">
          <p id="u408"><span>身长:</span></p>
      </div>
      
      
      <div id="u492" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.bodyLenght } cm</span>
      </div>
      
       <div id="u409" class="ax_文本段落">
          <p id="u410"><span>已打疫苗:</span></p>
      </div>
      
      <div id="u411" class="ax_复选框">

            <p id="u412"><span>卡介苗</span></p>
            <c:forEach var="list" items="${list6 }">
	            <c:if test="${list=='0' }">
	        		<input id="u411_input" type="checkbox" value="0" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
      
      
      <div id="u413" class="ax_复选框">
            <p id="u414"><span>乙肝疫苗</span></p>
        	<c:forEach var="list" items="${list6 }">
	            <c:if test="${list=='1' }">
	        		<input id="u413_input" type="checkbox" value="1" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>


      <div id="u415" class="ax_复选框">
            <p id="u416"><span>早吸吮</span></p>
        	<c:forEach var="list" items="${list6 }">
	            <c:if test="${list=='2' }">
	        		<input id="u415_input" type="checkbox" value="2" name="vaccine" checked/>
	      		</c:if>
      		</c:forEach>
      </div>
        
      <div id="u417" class="ax_文本段落">
          <p id="u418"><span>胎儿死亡:</span></p>
      </div>
      
      <div id="u498" class="ax_下拉列表框">
        <c:if test="${childbirthBabyInfoPO6.fetusDie=='0' }">
        	<span id="u498_input">是</span>
        </c:if>
        <c:if test="${childbirthBabyInfoPO6.fetusDie=='1' }">
        	<span id="u498_input">否</span>
        </c:if>
      </div>
      
      <div id="u419" class="ax_文本段落">
          <p id="u420"><span>接生者:</span></p>
      </div>
      
      <div id="u497" class="ax_文本框">
        <span>${childbirthBabyInfoPO6.midwife }</span>
      </div>
 </div>
 </div>
<div id="s8">        
    <div id="u421" class="ax_文本段落">
          <p id="u422"><span>产妇、婴儿死亡情况:</span></p>
    </div>  
        
      
      <div id="u423" class="ax_文本段落">
          <p id="u424"><span id="" name="puerpera">产妇:</span></p>
      </div>
      
      <div id="u499" class="ax_文本框">
        <span id="u499_input">${childbirth.puerpera }</span>
      </div>
      
       <div id="u425" class="ax_文本段落">
          <p id="u426"><span >死亡原因:</span></p>
      </div>
      
      <div id="u500" class="ax_文本框">
        <span id="u500_input">${childbirth.puerperaDieReason }</span>
      </div>
      
       <div id="u427" class="ax_文本段落">
          <p id="u428"><span >婴儿:</span></p>
      </div>
      
      <div id="u501" class="ax_文本框">
         <span id="u501_input">${childbirth.baby }</span>
      </div>
      
</div>
</div>

<div id="s9" name="foldDiv5" onclick="AutoFold('foldDiv6','u24',8)" style="background-color:#009dd9">      
      <div id="u22" class="ax_形状">
          <p id="u23"><span>转   诊</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u24" class="ax_文本段落">
          <!-- <p id="u25"><span>收起</span></p> -->
           <p id="u25">收起</p>
      </div>
</div>      
     
     
<div id="s7" name="foldDiv6">    
      <div id="u26" class="ax_文本段落">
          <p id="u27"><span>转诊:</span></p>
      </div>
      <c:if test="${findBy.referral=='0' }">
      <div id="u28" class="ax_单选按钮">
        <p id="u29"><span> 无</span></p>
        
        <input id="u28_input" type="radio" value="0" name="referral" checked/>
      	
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u30" class="ax_单选按钮">
        <p id="u31"><span> 有</span></p>
        
        <input id="u30_input" type="radio" value="1" name="referral"/>
       
      </div>
      </c:if>
      
      
      
      
    <c:if test="${findBy.referral =='1'}">
      <div id="u28" class="ax_单选按钮">
        <p id="u29"><span> 无</span></p>
        
        <input id="u28_input" type="radio" value="0" name="referral"/>
      	
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u30" class="ax_单选按钮">
        <p id="u31"><span> 有</span></p>
        
        <input id="u30_input" type="radio" value="1" name="referral" checked/>
       
      </div>
      </c:if>
      
      
      
      
      
      <div id="u32" class="ax_文本段落">
          <p id="u33"><span>原因:</span></p>
      </div>
      
       <div id="u34" class="ax_文本框">
        <span id="u34_input">${findBy.reason }</span>
      </div>
      
      <div id="u35" class="ax_文本段落">
          <p id="u36"><span>转诊机构:</span></p>
      </div>
      
      <div id="u37" class="ax_下拉列表框">
        <span id="u37_input">${departmentById.name}</span> 
      </div>
      
      <div id="u38" class="ax_文本段落">
          <p id="u39"><span>转诊科室:</span></p>
      </div>
      
      <div id="u40" class="ax_下拉列表框">
        	<span id="u40_input">${roleBy.name }</span>
      </div>
      <div id="u41" class="ax_文本段落">
          <p id="u42"><span>下次访视日期:</span></p>
      </div>

       <div id="u43" class="ax_下拉列表框">
         <span><fmt:formatDate value="${findBy.nextFollowingDate }" pattern="yyyyMMdd"/></span> 
      </div>
      
      <div id="u44" class="ax_文本段落">
          <p id="u45"><span>是否预约下次访视:</span></p>
      </div>
      
      
      <c:if test="${findBy.orderCheck=='0' }">
      <div id="u46" class="ax_单选按钮">
       <p id="u47" ><span> 是</span></p>
      
        	<input id="u46_input" type="radio" value="0" name="u46" name="orderCheck" checked/>
      	 
      	 
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u48" class="ax_单选按钮">
            <p id="u49"><span> 否</span></p>
        
        	<input id="u46_input" type="radio" value="1" name="u46" name="orderCheck" />
	  </div>
      </c:if>
      
      <c:if test="${findBy.orderCheck=='1' || findBy.orderCheck=='' }">
      <div id="u46" class="ax_单选按钮">
       <p id="u47" ><span> 是</span></p>
      
        	<input id="u46_input" type="radio" value="0" name="u46" name="orderCheck"/>
      	 
      	 
      </div>

      <!-- Unnamed (单选按钮) -->
      <div id="u48" class="ax_单选按钮">
            <p id="u49"><span> 否</span></p>
        
        	<input id="u46_input" type="radio" value="1" name="u46" name="orderCheck" checked/>
	  </div>
      </c:if>
      <div id="u50" class="ax_文本段落">
          <p id="u51"><span>母子健康手册使用:</span></p>                
     </div>
     
     <div id="u52" class="ax_下拉列表框">
     	<c:if test="${findBy.healthHandbook==0 }">
        <span id="u52_input">是</span>
        </c:if>
        <c:if test="${findBy.healthHandbook==1 }">
        <span id="u52_input">否</span>
        </c:if>
     </div>
</div>       
      
      
<div id="s10" name="foldDiv7" onclick="AutoFold('foldDiv8','u59',8)">      
      <div id="u56" class="ax_形状" style="background-color:#009dd9">
          <p id="u57"><span>历史检查记录</span></p>
      </div>
    
      <div id="u58" class="ax_文本段落">
          <!-- <p id="u59"><span>收起</span></p> -->
          <p id="u59" onclick="CanShu('s11','u59');">收起</p>
      </div>
</div>

<div id="s11" name="foldDiv8">     
       		
				
		<div id="u93" class="ax_形状">
				<p id="u94"><span>&nbsp;</span></p>
		</div>		           
		<div id="u152" class="ax_动态面板">
              <!-- 可以下拉的框 -->
                <div id="u152_state0" class="panel_state" data-label="State1">
                 
        
                    <!-- Unnamed (形状) -->
                    <div id="u153" class="ax_形状">
                        <p id="u154"><span>&nbsp;</span></p>
                    </div>
                
                    <!-- Unnamed (表格) -->
                    <div id="u155" class="ax_表格">  
                    
                     <table width="1173px"> 
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
                      <c:if test="${historyCheck.pregnancyWeeks==null}">
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
        			   <c:if test="${historyCheck.uterusHight==null}">
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
s                      </td>
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
                      <td " style="border:0.5px solid #A6A6A6">
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
                          <div class="autocut" onmouseover="this.className='autocut1'" onmouseout="this.className='autocut'">${historyCheck.guidance }</div>
                      </td>
                       </c:if>
                        <c:if test="${historyCheck.guidance==null || historyCheck.guidance==''}">
                      <td  style="border:0.5px solid #A6A6A6">
                          <p><span>-</span></p>
                      </td>
                       </c:if>
        			<c:if test="${historyCheck.type==1}">
	                      <!-- Unnamed (单元格) -->
	                      <td  style="background-color:#009DD9;border:0.5px solid #A6A6A6" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaDetails?archiveId=${archiveId}&postpartumExaId=${historyCheck.checkId}'">
	                          <p><span>详情</span></p>
	                      </td>
                      </c:if>
                      <c:if test="${historyCheck.type==0}">
	                      <!-- Unnamed (单元格) -->
	                       <td  style="background-color:#009DD9;cursor: pointer;border:0.5px solid #A6A6A6" onclick="window.location.href='${ctx}/prenatal/prenatalExaDetails?prenatalId=${historyCheck.checkId}&count=<%=i-1 %>'">
	                          <p><span>详情</span></p>
	                      </td>
                      </c:if>
                      </tr>
               </c:forEach>
               </table>
    <!--  --------------------------------------------------------------------------------  --> 
                    </div>
                  </div>
              </div>
</div>
</form>
	</div>
	
  </body>
</html>
