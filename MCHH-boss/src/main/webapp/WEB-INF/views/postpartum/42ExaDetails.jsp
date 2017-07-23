<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>产后42天健康检查详情</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
		
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx }/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/42exaDetails_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/42exaDetails_styles1.css" type="text/css" rel="stylesheet"/>
  </head>
  <style type="text/css"> 
		
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
		      <div id="u47" class="ax_形状" style="background-color:#EE5F45">
		          <p id="u48"><span>产后42天健康检查详情</span></p>
		      </div>
		      
<c:if test="${currentDoctorId==checkDoctorId && birthArchives.riskSign==1 && birthArchives.pregnantState!=2}">		      
		      <div id="u105" class="ax_形状" style="background-color:#E9854F;cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchivesId}&archivesId=${archiveId }'">
		          <p id="u106"><span>专案</span><span>记录</span></p>
		      </div>
		    
		      <div id="u111" class="ax_形状" style="background-color:#56BB4D;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/toPostExaEdit?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'">
		          <p id="u112"><span>编辑</span></p>
		      </div>
</c:if>

<c:if test="${(currentDoctorId!=checkDoctorId || birthArchives.pregnantState==2) && birthArchives.riskSign==1 }">

				<div id="u111" class="ax_形状" style="background-color:#E9854F;cursor:pointer;" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchivesId}&archivesId=${archiveId }'">
		          <p id="u112"><span>专案记录</span></p>
		      </div>

</c:if>
<c:if test="${currentDoctorId==checkDoctorId && birthArchives.riskSign ==0 && birthArchives.pregnantState!=2 }">
		 <div id="u111" class="ax_形状" style="background-color:#56BB4D;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/toPostExaEdit?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'">
		          <p id="u112"><span>编辑</span></p>
		      </div>
</c:if>
<!-- 		            Unnamed (形状) -->
<%-- 		      <div id="u107" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaRecord?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'"> --%>
<!-- 		          <p id="u108"><span>产后42天健康检查记录表</span></p> -->
<!-- 		      </div> -->
<!-- 		           Unnamed (形状) -->
<%-- 		      <div id="u109" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/ExaFeedBack?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'"> --%>
<!-- 		          <p id="u110"><span>产后42天健康检查反馈单</span></p> -->
<!-- 		      </div> -->
		             <!-- Unnamed (形状) -->
		      <div id="u109" class="ax_形状" style="background-color:#009DD9;cursor:pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaRecord?archiveId=${archives.id }&postpartumExaId=${postpartumExaId }'">
		          <p id="u110"><span>产后42天健康检查记录表</span></p>
		      </div>
		      
		      
		      
		      
</div>		      
		       <div id="u0" class="ax_文本段落" style="border-top:#B5B5B5 solid 1px;">
     			 </div>
		            <!-- Unnamed (形状) -->
		          <p id="u6"><span>检查医院：${operator.department }</span></p>
		            <!-- Unnamed (形状) -->
		          <p id="u8"><span>检查医生：${operator.realName }</span></p>
		      
		      		<c:if test="${birthArchives.referralSign != 0}">
		          		<p id="u10"><span>转诊状态：转诊</span></p>
		           </c:if>
		           <c:if test="${birthArchives.referralSign == 0}">
              	 	    <p id="u10"><span>转诊状态：本院</span></p>
             	   </c:if>
		
		    
		    
		          <!-- Unnamed (形状) -->
		      <div id="u49" class="ax_形状" style="background-color:#009DD9">
		          <p id="u50"><span>个 人 基 本 信 息</span></p>
		      </div>
		
		
		 <c:if test="${birthArchives.riskSign ==1 }"> 
			      <!-- Unnamed (形状) -->
		      <div id="u59" class="ax_文本段落">
		          <p id="u60"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name }</span></p>
		  		</div>
		            <!-- Unnamed (形状) -->
		      <div id="u61" class="ax_文本段落">
		          <p id="u62"><span>档案编号：${archives.archivesCode }</span></p>
		      </div>
		   </c:if>  
		   
		 <c:if  test="${birthArchives.riskSign ==0 }"> 
			      <!-- Unnamed (形状) -->
		      <div style="font-weight: 500;color: black" id="u59" class="ax_文本段落">
		          <p id="u60"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name }</span></p>
		  		</div>
		            <!-- Unnamed (形状) -->
		      <div style="font-weight: 500;color: black" id="u61" class="ax_文本段落">
		          <p id="u62"><span>档案编号：${archives.archivesCode }</span></p>
		      </div>
		   </c:if>    
		      
		            <!-- Unnamed (形状) -->
		      <div id="u73" class="ax_文本段落">
		          <p id="u74"><span>检查日期：<fmt:formatDate value="${postpartumExa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u57" class="ax_文本段落">
		          <p id="u58"><span>孕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;周：${childbirthBasic.gestationalWeek }</span></p>
		      </div>
		        <!-- Unnamed (形状) -->
		      <div id="u51" class="ax_文本段落">
		          <p id="u52"><span>出生日期：<fmt:formatDate value="${archives.birthday }" pattern="yyyy-MM-dd"/></span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u65" class="ax_文本段落">
		          <p id="u66"><span>联系电话</span><span>：${archives.telephone }</span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u85" class="ax_文本段落">
		          <p id="u86"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u63" class="ax_文本段落">
		          <p id="u64"><span>孕妇年龄：${womenAge }</span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u67" class="ax_文本段落">
		          <p id="u68"><span>丈夫姓名：${archives.manName }</span></p>
		  	  </div>
		            <!-- Unnamed (形状) -->
		      <div id="u103" class="ax_文本段落">
		          <p id="u104"><span>出</span><span>院日期：<fmt:formatDate value="${childbirthBasic.leaveDate }" pattern="yyyy-MM-dd"/></span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u53" class="ax_文本段落">
		          <p id="u54"><span>末次月经：<fmt:formatDate value="${birthArchives.lastMenses }" pattern="yyyy-MM-dd"/></span><span>&nbsp;</span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u69" class="ax_文本段落">
		          <p id="u70"><span>丈夫年龄：${manAge }</span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u55" class="ax_文本段落">
		          <p id="u56"><span>预 &nbsp;产 &nbsp;期：<fmt:formatDate value="${expectedDate }" pattern="yyyy-MM-dd"/></span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u71" class="ax_文本段落">
		          <p id="u72"><span>丈夫电话：${archives.manTele }</span></p>
		      </div>
		</div>
		    
		    
		          <!-- Unnamed (形状) -->
		  <div id="u75" class="ax_形状" name="foldDiv1" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv2','u78',10)">
		          <p id="u76"><span>一 般 检 查</span></p>
		          <p id="u78"><span>收起</span></p>
		      </div>
		      
		      <!-- Unnamed (形状) -->
<!-- 		      <div id="u77" class="ax_文本段落"> -->
<!-- 		          <p id="u78"><span>收起</span></p> -->
<!-- 		      </div> -->
		      
		      
		<div name="foldDiv2" style="height: 221px;">
			      <!-- Unnamed (形状) -->
		      <div id="u79" class="ax_文本段落">
		          <p id="u80"><span>血压：</span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u83" class="ax_文本段落">
		          <p id="u84"><span>${postpartumExaDetailed.bloodLow }/${postpartumExaDetailed.bloodHi }</span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u81" class="ax_文本段落">
		          <p id="u82"><span>mmHg</span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u95" class="ax_文本段落">
		          <p id="u96"><span>一般健康情况：${postpartumExaDetailed.health }</span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u97" class="ax_文本段落">
		          <p id="u98"><span>一般心理状况：${postpartumExaDetailed.psychological }</span><span></span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u87" class="ax_文本段落">
		          <p id="u88"><span>乳房：<c:if test="${postpartumExaDetailed.breast==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.breast==1 }">${postpartumExaDetailed.breastRemark }</c:if></span></p>
		  </div>
		      <!-- Unnamed (形状) -->
		      <div id="u89" class="ax_文本段落">
		          <p id="u90"><span>恶露：<c:if test="${postpartumExaDetailed.lochia==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.lochia==1 }">${postpartumExaDetailed.lochiaRemark }</c:if></span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u91" class="ax_文本段落">
		          <p id="u92"><span>子宫：<c:if test="${postpartumExaDetailed.uterus==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.uterus==1 }">${postpartumExaDetailed.uterusRemark }</c:if></span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u93" class="ax_文本段落">
		          <p id="u94"><span>伤口：<c:if test="${postpartumExaDetailed.wound==0 }">未见异常</c:if><c:if test="${postpartumExaDetailed.wound==1 }">${postpartumExaDetailed.woundRemark }</c:if></span></p>
		      </div>
		</div>
		
		        <!-- Unnamed (形状) -->
		  <div id="u99" class="ax_形状" name="foldDiv3" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv4','u102',10)">
		          <p id="u100"><span>其 他</span></p>
		          <p id="u102"><span>收起</span></p>
		      </div>  
		          <!-- Unnamed (形状) -->
<!-- 		      <div id="u101" class="ax_文本段落"> -->
<!-- 		          <p id="u102"><span>收起</span></p> -->
<!-- 		      </div> -->
		    
		<div name="foldDiv4" style="height: 216px;">
		      <!-- Unnamed (形状) -->
		      <div id="u37" class="ax_文本段落">
		          <p id="u38"><span>外阴：<c:if test="${postpartumExaOther.vulva==0 }">未见异常</c:if><c:if test="${postpartumExaOther.vulva==1 }">${postpartumExaOther.vulvaRemark }</c:if></span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u39" class="ax_文本段落">
		          <p id="u40"><span>阴道：<c:if test="${postpartumExaOther.vagina==0 }">未见异常</c:if><c:if test="${postpartumExaOther.vagina==1 }">${postpartumExaOther.vaginaRemark }</c:if></span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u41" class="ax_文本段落">
		          <p id="u42"><span>宫颈：<c:if test="${postpartumExaOther.cervical==0 }">未见异常</c:if><c:if test="${postpartumExaOther .cervical==1 }">${postpartumExaOther.cervicalRemark }</c:if></span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u43" class="ax_文本段落">
		     	     其他：
		      </div>
		      <div id="u43-" class="ax_文本段落">
		      		<c:if test="${postpartumExaOther.other=='' || postpartumExaOther.other==null}">无</c:if><c:if test="${postpartumExaOther.other!='' && postpartumExaOther.other!=null}">${postpartumExaOther.other}</c:if>
		      </div>
		</div> 
		
		
		
		      <!-- Unnamed (形状) -->
		      <div id="u12" class="ax_形状" name="foldDiv5" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv6','u15',10)">
		          <p id="u13"><span>分 类</span></p>
		           <p id="u15"><span>收起</span></p>
		  </div>
		      <!-- Unnamed (形状) -->
<!-- 		  	 <div id="u14" class="ax_文本段落" > -->
<!-- 		          <p id="u15"><span>收起</span></p> -->
<!-- 		  </div> -->
		
		
		<div name="foldDiv6" style="height: 53px;">
		
		      <!-- Unnamed (形状) -->
		      <div id="u16" class="ax_文本段落">
		          <p id="u17"><span>分类：<c:if test="${postpartumExa.result==0 }">已恢复
		          						</c:if><c:if test="${postpartumExa.result==1 }">
							         			 未恢复  原因：<c:if test="${postpartumExa.reason==0 }">产褥感染</c:if>
									 					  <c:if test="${postpartumExa.reason==1 }">晚期产后出血</c:if>
									 					  <c:if test="${postpartumExa.reason==2 }">产褥期抑郁症</c:if>
									 					  <c:if test="${postpartumExa.reason==3 }">${postpartumExa.remark }</c:if>
									 	</c:if>
				</span></p>
		      </div>
		</div>
		
		      <!-- Unnamed (形状) -->
		      <div id="u18" class="ax_形状" name="foldDiv7" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv8','u21',10)">
		          <p id="u19"><span>保 健 指 导</span></p>
		           <p id="u21"><span>收起</span></p>
		  		</div>
		      <!-- Unnamed (形状) -->
<!-- 		      <div id="u20" class="ax_文本段落"> -->
<!-- 		          <p id="u21"><span>收起</span></p> -->
<!-- 		      </div> -->
	<div name="foldDiv8" style="height: 147px">
	
			<div id="u18-" class="ax_文本段落">
				${postpartumExa.guidance }
			</div>
	
	</div>
		

		      <!-- Unnamed (形状) -->
		      <div id="u22" class="ax_形状" name="foldDiv9" style="background-color:#009DD9;cursor:pointer;" onclick="AutoFold('foldDiv10','u25',10)">
		          <p id="u23"><span>处 理</span></p>
		           <p id="u25"><span>收起</span></p>
		  	  </div>
		            <!-- Unnamed (形状) -->
<!-- 		      <div id="u24" class="ax_文本段落"> -->
<!-- 		          <p id="u25"><span>收起</span></p> -->
<!-- 		      </div> -->
		
		
	<div name="foldDiv10" style="height: 30px;">
		
		      <!-- Unnamed (形状) -->
		      <div id="u45" class="ax_文本段落">
		          <p id="u46"><span>结案</span><span>：
		          <c:if test="${birthArchives.pregnantState==2 }">已结案</c:if>
		          <c:if test="${birthArchives.pregnantState!=2}">未结案</c:if>
		          </span></p>
		      </div>
		      
		      
	 <c:if test="${postpartumReferral.referral==1 }">
		            <!-- Unnamed (形状) -->
		      <div id="u26" class="ax_文本段落">
		          <p id="u27"><span>转诊</span><span>：是</span></p>
		  	</div>
		      <!-- Unnamed (形状) -->
		      <div id="u28" class="ax_文本段落">
		          <p><span id="u29">原因：${postpartumReferral.referralReason }</span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u30" class="ax_文本段落">
		          <p id="u31"><span>转诊机构：${postpartumReferral.mechanism }</span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u32" class="ax_文本段落">
		          <p id="u33"><span>转诊科室：${postpartumReferral.departmentName }</span></p>
		      </div>
	 </c:if>
	 
	  <c:if test="${postpartumReferral.referral==0 }">
		            <!-- Unnamed (形状) -->
		      <div id="u26" class="ax_文本段落">
		          <p id="u27"><span>转诊</span><span>：否</span></p>
		  	</div>
		      <!-- Unnamed (形状) -->
		      <div id="u28" class="ax_文本段落">
		          <p><span id="u29">原因：</span></p>
		      </div>
		            <!-- Unnamed (形状) -->
		      <div id="u30" class="ax_文本段落">
		          <p id="u31"><span>转诊机构：</span></p>
		      </div>
		      <!-- Unnamed (形状) -->
		      <div id="u32" class="ax_文本段落">
		          <p id="u33"><span>转诊科室：</span></p>
		      </div>
	 </c:if>
		      <!-- Unnamed (水平线) -->
		      <div id="u36" class="ax_水平线">
					<hr style="border:1px dashed #B5B5B5;" />
		      </div>
		      
	<c:if test="${postpartumReferral.healthHandbook==0 }">   
		      <!-- Unnamed (形状) -->
		      <div id="u34" class="ax_文本段落">
		          <p id="u35"><span>母子健康手册使用：未使用</span></p>
		      </div>
	</c:if>
		<c:if test="${postpartumReferral.healthHandbook==1 }">   
		      <!-- Unnamed (形状) -->
		      <div id="u34" class="ax_文本段落">
		          <p id="u35"><span>母子健康手册使用：使用</span></p>
		      </div>
	</c:if>
		</div>
		
		<br><br><br>

  </body>
</html>
