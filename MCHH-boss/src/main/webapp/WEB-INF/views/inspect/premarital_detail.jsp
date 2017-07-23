<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript">
		$(function() {
			   //根据出生日期计算年龄
	  		   var birthday = $("#birthday").html();
			   
	  		   var nowdate = new Date();
	  		   var age = nowdate.getFullYear() - birthday.substr(0,4);
	  		 	
	  		   $("#u19_1").html(age);
	  		   
	  		   
	  		   //关闭
	  		   $("#u52").click(function(){
	  			 	closeDialog_();
	  		   })
	  		   
		})
</script>
    <div id="base" class="">

	<div id="u0" class="ax_形状">
        <img id="u0_img" class="img " src="${ctx}/static/images/u0.png"/>
        <!-- Unnamed () -->
        <div id="u1" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>
      
      <!-- Unnamed (水平线) -->
      <div id="u50" class="ax_水平线">
        <img id="u50_line" class="img " src="${ctx}/static/images/u50_line.png" alt="u50_line"/>
      </div>

      <!-- Unnamed (水平线) -->
      <div id="u51" class="ax_水平线">
        <img id="u51_line" class="img " src="${ctx}/static/images/u50_line.png" alt="u51_line"/>
      </div>
	
      <!-- Unnamed (形状) -->
      <div id="u2" class="ax_形状" style="background-color:#EE5F45">
       		<p id="u3"><span>个人基本信息详情</span></p>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u52" class="ax_形状" style="background-color:#56BB4D;cursor:pointer">
        <p id="u53"><span>关闭</span></p>
     </div>

      <!-- Unnamed (形状) -->
      <div id="u4" class="ax_文本段落">
        <p id="u5"><span>档案编号：${archivesInfoDetail.archivesInfo.archivesCode }</span></p>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u8" class="ax_文本段落">
			<p id="u9"><span>建档医院：${archivesInfoDetail.department.name }</span></p>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u10" class="ax_文本段落">
			 <p id="u11"><span>建档医生：${archivesInfoDetail.operatorPO.realName }</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u6" class="ax_文本段落">
			<p id="u7"><span>建档日期：${archivesInfoDetail.creatTime }</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u12" class="ax_文本段落">
         <p id="u13"><span>姓&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;名： ${archivesInfoDetail.archivesInfo.name }</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u14" class="ax_文本段落">
         <p id="u15"><span>性&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;别：
         		<c:if test="${archivesInfoDetail.archivesInfo.sex eq '1'}">
          			男
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex eq '0'}">
          			女
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.sex eq '2'}">
          			性别不明
          		</c:if>
         </span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u16" class="ax_文本段落">

          <p id="u17"><span>国&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;籍：
				<c:if test="${archivesInfoDetail.archivesInfo.international eq '1'}">
          			外国
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.international eq '0'}">
          			中国
          		</c:if>
          	</span></p>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u30" class="ax_文本段落">
        
          <p id="u31"><span>民&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;族：${archivesInfoDetail.archivesInfo.nation }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u20" class="ax_文本段落">
        
          <p id="u21"><span>身份证号：${archivesInfoDetail.archivesInfo.idNo }</span></p>

      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u38" class="ax_文本段落">
        
          <p id="u39"><span>出生日期：<span id = "birthday">${archivesInfoDetail.birthday }</span></span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u18" class="ax_文本段落">
        
          <p id="u19"><span>年<span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>龄：</span>
          	<p id="u19_1"></p>
          </p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u26" class="ax_文本段落">
        
          <p id="u27"><span>文化程度：
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '0'}">
          			小学
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '1'}">
          			初中
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '2'}">
          			高中
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '3'}">
          			中专
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '4'}">
          			大专
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '5'}">
          			本科
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '6'}">
          			硕士
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '7'}">
          			博士
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '8'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.education eq '9'}">
          			不详
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u32" class="ax_文本段落">
        
          <p id="u33"><span>户籍类型：
          		<c:if test="${archivesInfoDetail.archivesInfo.householdType eq '0'}">
          			本地
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.householdType eq '1'}">
          			外地
          		</c:if>
          </span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u34" class="ax_文本段落">
        
          <p id="u35"><span>户口类型：
          		<c:if test="${archivesInfoDetail.archivesInfo.accountType eq '0'}">
          			务农
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.accountType eq '1'}">
          			非农
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u24" class="ax_文本段落">
        
          <p id="u25"><span>职&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;业：
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '0'}">
          			无
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '1'}">
          			事业单位
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '2'}">
          			企业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '3'}">
          			服务业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '4'}">
          			制造业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '5'}">
          			农业
          		</c:if>
          		<c:if test="${archivesInfoDetail.archivesInfo.occupation eq '6'}">
          			其他
          		</c:if>
          </span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u28" class="ax_文本段落">
        
          <p id="u29"><span>工作单位：${archivesInfoDetail.archivesInfo.workUnit }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u22" class="ax_文本段落">
        
          <p id="u23"><span>户口地址：</span>
          	  <span>${archivesInfoDetail.provinceInfo.name }</span>
   			  <span>${archivesInfoDetail.cityInfo.name }</span>
   			  <span>${archivesInfoDetail.districtAndCountyInfo.name }</span>
   			  <span>${archivesInfoDetail.townshipInfo.name }</span>
   			  <span>${archivesInfoDetail.villageInfo.name }</span>
   			  <span>${archivesInfoDetail.archivesInfo.accAddress }</span>
          </p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u36" class="ax_文本段落">
        
          <p id="u37"><span>家庭地址：</span>
          	  <span>${archivesInfoDetail.provinceInfo1.name }</span>
   			  <span>${archivesInfoDetail.cityInfo1.name }</span>
   			  <span>${archivesInfoDetail.districtAndCountyInfo1.name }</span>
   			  <span>${archivesInfoDetail.townshipInfo1.name }</span>
   			  <span>${archivesInfoDetail.villageInfo1.name }</span>
   			  <span>${archivesInfoDetail.archivesInfo.homeAddress }</span>
          </p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u48" class="ax_文本段落">
        
          <p id="u49"><span>联系电话：${archivesInfoDetail.archivesInfo.telephone }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u40" class="ax_文本段落">
        
          <p id="u41"><span>紧急电话：${archivesInfoDetail.archivesInfo.urgentCall }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u42" class="ax_文本段落">
        
          <p id="u43"><span>对方姓名：${archivesInfoDetail.archivesInfo.manName }</span></p>
       
      </div>

      <!-- Unnamed (形状) -->
      <div id="u44" class="ax_文本段落">
        
          <p id="u45"><span>身份证号：${archivesInfoDetail.archivesInfo.manIdNo }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u46" class="ax_文本段落">
        
          <p id="u47"><span>联系电话：${archivesInfoDetail.archivesInfo.manTele }</span></p>

      </div>
 
    </div>

