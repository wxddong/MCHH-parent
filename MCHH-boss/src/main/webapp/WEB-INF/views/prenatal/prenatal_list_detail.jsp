<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
    
<script type="text/javascript">
 	
 	$(function(){
 		
  		$("#du67").click(function(){
 			//window.location="${ctx}/prenatal/list";
 			closeDialog_();
		});
  
 	});
 
 </script>
<div id="base" class="" style="background-color: #FFFFFF">
	<div id="du2" class="ax_形状" style="background-color:#EE5F45">
      <p id="du3"><span>个人基本信息详情</span></p>
  	</div>
    
    <div id="du66" class="ax_形状" style="background-color:#56BB4D">
      <p id="du67" style="cursor:pointer"><span>关闭</span></p>
  	</div>
    
    <div id="du0" class="ax_形状" style="border:1px solid #CCCCCC">
      <p id="du1"><span>&nbsp;</span></p>
  	</div>

  
  <div id="du4" class="ax_文本段落">
      <p id="du5"><span>档案编号：${archives.archivesCode }</span></p>
  </div>
  
  <div id="du8" class="ax_文本段落">
      <p id="du9"><span>建档医院：${department.name }</span></p>
  </div>
  
  <div id="du10" class="ax_文本段落">
      <p id="du11"><span>建档医生：${operatorPO.realName }</span></p>
  </div>
  
  <div id="du6" class="ax_文本段落">
      <p id="du7"><span>建档日期：<fmt:formatDate value="${archives.creatTime }" pattern="yyyy-MM-dd"/></span></p>
  </div>
  
  <div id="du64" class="ax_水平线">
    <hr id="du64_line" style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
  </div>
  
  <div id="du12" class="ax_文本段落">
      <p id="du13"><span>姓 名：${archives.name }</span></p>
  </div>
  
  <div id="du14" class="ax_文本段落">
      <p id="du15"><span>性 别：
      	<c:if test="${archives.sex eq '0'}">女</c:if>
      	<c:if test="${archives.sex eq '1'}">男</c:if>
      	<c:if test="${archives.sex eq '2'}">性别不明</c:if>
      	</span></p>
  </div>
  
  <div id="du16" class="ax_文本段落">
      <p id="du17"><span>国 籍：
			<c:if test="${archives.international eq '1'}">
          		外国
          	</c:if>
          	<c:if test="${archives.international eq '0'}">
          		中国
          	</c:if>
      </span></p>
  </div>
  
  <div id="du30" class="ax_文本段落">
      <p id="du31"><span>民  族 ：${archives.nation }</span></p>
  </div>
  
  <div id="du20" class="ax_文本段落">
      <p id="du21"><span>身份证号：${archives.idNo }</span></p>
  </div>
  
  <div id="du38" class="ax_文本段落">
      <p id="du39"><span>出生日期:<fmt:formatDate value="${archives.birthday }" pattern="yyyy-MM-dd"/></span></p>
  </div>
  
  <div id="du18" class="ax_文本段落">
      <p id="du19"><span>年 龄：${age }</span></p>
  </div>
  
  <div id="du26" class="ax_文本段落">
      <p id="du27"><span>文化程度：
      	<c:if test="${archives.education eq '9'}">
   			不详
   		</c:if>
      	<c:if test="${archives.education eq '0'}">
   			小学
   		</c:if>
   		<c:if test="${archives.education eq '1'}">
   			初中
   		</c:if>
   		<c:if test="${archives.education eq '2'}">
   			高中
   		</c:if>
   		<c:if test="${archives.education eq '3'}">
   			中专
   		</c:if>
   		<c:if test="${archives.education eq '4'}">
   			大专
   		</c:if>
   		<c:if test="${archives.education eq '5'}">
   			本科
   		</c:if>
   		<c:if test="${archives.education eq '6'}">
   			硕士
   		</c:if>
   		<c:if test="${archives.education eq '7'}">
   			博士
   		</c:if>
   		<c:if test="${archives.education eq '8'}">
   			无
   		</c:if>
      </span></p>
  </div>
  
  <div id="du32" class="ax_文本段落">
      <p id="du33"><span>户籍类型：
      	<c:if test="${archives.householdType eq '0'}">
   			本地
   		</c:if>
   		<c:if test="${archives.householdType eq '1'}">
   			外地
   		</c:if>
      </span></p>
  </div>
  
  <div id="du34" class="ax_文本段落">
      <p  id="du35"><span>户口类型：
      	<c:if test="${archives.accountType eq '0'}">
   			农业户籍
   		</c:if>
   		<c:if test="${archives.accountType eq '1'}">
   			非农户籍
   		</c:if>
      </span></p>
  </div>
  
  <div id="du24" class="ax_文本段落">
      <p id="du25"><span>职 业：
      	<c:if test="${archives.occupation eq '0'}">
   			无
   		</c:if>
   		<c:if test="${archives.occupation eq '1'}">
   			事业单位
   		</c:if>
   		<c:if test="${archives.occupation eq '2'}">
   			企业
   		</c:if>
   		<c:if test="${archives.occupation eq '3'}">
   			服务业
   		</c:if>
   		<c:if test="${archives.occupation eq '4'}">
   			制造业
   		</c:if>
   		<c:if test="${archives.occupation eq '5'}">
   			农业
   		</c:if>
   		<c:if test="${archives.occupation eq '6'}">
   			其他
   		</c:if>
      </span></p>
  </div>
  
  <div id="du28" class="ax_文本段落">
      <p id="du29"><span>工作单位：${archives.workUnit }</span></p>
  </div>
  
  <div id="du22" class="ax_文本段落">
      <p id="du23"><span>户口地址：${accAddress}</span></p>
  </div>
  
  <div id="du36" class="ax_文本段落">
      <p id="du37"><span>家庭地址：${homeAddress }</span></p>
  </div>
  
  <div id="du62" class="ax_文本段落">
      <p id="du63"><span>联系电话：${archives.telephone }</span></p>
  </div>
  
  <div id="du40" class="ax_文本段落">
      <p id="du41"><span>紧急电话：${archives.urgentCall }</span></p>
  </div>
  <div style="position: absolute;left: 480px;top: 246px; width: 82px;height: 15px;" class="ax_文本段落">
       <p id="u81"><span>末次月经：</span></p>
  </div>
  <div class="ax_文本框" style="position: absolute;left: 540px;top: 246px;width: 145px;height: 25px;">
      <fmt:formatDate value="${birthArchives.lastMenses }" pattern="yyyy-MM-dd"/>
  </div>
  <div style="position: absolute;left: 710px;top: 246px; width: 82px;height: 15px;"  class="ax_文本段落">
      <p id="u81"><span>预&nbsp;&nbsp;产&nbsp;&nbsp;期：</span></p>
    </div>
  	<div id="u82" class="ax_文本框" style="position: absolute;left: 770px;top: 246px;width: 145px;height: 25px;">
  		<fmt:formatDate value="${birthArchives.predictDate }" pattern="yyyy-MM-dd"/>
	</div>
  
  <div id="du65" class="ax_水平线">
    <hr id="du65_line" style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
  </div>
  
  <div id="du42" class="ax_文本段落">
      <p id="du43"><span>丈夫姓名：${archives.manName }</span></p>
  </div>
  
  <div id="du44" class="ax_文本段落">
      <p id="du45"><span>性 别：
		<c:if test="${archives.manSex eq '0'}">女</c:if>
      	<c:if test="${archives.manSex eq '1'}">男</c:if>
      	<c:if test="${archives.manSex eq '2'}">性别不明</c:if>
		</span></p>
  </div>
  
  <div id="du46" class="ax_文本段落">
      <p id="du47"><span>国 籍：
      	<c:if test="${archives.manInte eq '1'}">
      		外国
      	</c:if>
      	<c:if test="${archives.manInte eq '0'}">
      		中国
      	</c:if>
      </span></p>
  </div>
  
  <div id="du54" class="ax_文本段落">
      <p id="du55"><span>民 族：${archives.manNation }</span></p>
  </div>
  
  <div id="du50" class="ax_文本段落">
      <p id="du51"><span>身份证号：${archives.manIdNo }</span></p>
  </div>
  
  <div id="du60" class="ax_文本段落">
      <p id="du61"><span>出生日期:<fmt:formatDate value="${archives.manBirthday }" pattern="yyyy-MM-dd"/> </span></p>
  </div>
  
  <div id="du48" class="ax_文本段落">
      <p id="du49"><span>年 龄：${manAge }</span></p>
  </div>
  
  <div id="du58" class="ax_文本段落">
      <p id="du59"><span>联系电话：${archives.manTele }</span></p>
  </div>
  
  <div id="du52" class="ax_文本段落">
      <p id="du53"><span>户口地址：${manAccAdd }</span></p>
  </div>
  
  <div id="du56" class="ax_文本段落">
      <p id="du57"><span>家庭地址：${manHomeAdd }</span></p>
  </div>
  
</div>
