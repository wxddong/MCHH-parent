<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>孕产妇详细历史检查页-正常分娩</title>
    <style type="text/css">
    	#nu166 {
		  position:absolute;
		  left:0px;
		  top:626px;
		  width:1177px;
		  height:26px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#nu167 {
		  position:absolute;
		  left:2px;
		  top:6px;
		  width:1173px;
		  word-wrap:break-word;
		}
		#nu176 {
		  position:absolute;
		  left:80px;
		  top:660px;
		  width:65px;
		  height:15px;
		}
		#nu177 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:65px;
		  white-space:nowrap;
		}
		#nu178 {
		  position:absolute;
		  left:376px;
		  top:660px;
		  width:172px;
		  height:15px;
		}
		#nu179 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:172px;
		  word-wrap:break-word;
		}
		#nu186 {
		  position:absolute;
		  left:626px;
		  top:655px;
		  width:37px;
		  height:25px;
		  background-color:#006Ebc;
		  color:#FFFFFF;
		  cursor:pointer;
		}
		#nu187 {
		  position:absolute;
		  left:7px;
		  top:5px;
		  width:27px;
		  white-space:nowrap;
		}
		#nu168 {
		  position:absolute;
		  left:0px;
		  top:683px;
		  width:1177px;
		  height:26px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#nu169 {
		  position:absolute;
		  left:2px;
		  top:6px;
		  width:1173px;
		  word-wrap:break-word;
		}
		#nu180 {
		  position:absolute;
		  left:80px;
		  top:719px;
		  width:65px;
		  height:15px;
		}
		#nu181 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:65px;
		  white-space:nowrap;
		}
		#nu182 {
		  position:absolute;
		  left:376px;
		  top:719px;
		  width:172px;
		  height:15px;
		}
		#nu183 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:172px;
		  word-wrap:break-word;
		}
		#nu188 {
		  position:absolute;
		  left:626px;
		  top:688px;
		  width:37px;
		  height:25px;
		  color:#FFFFFF;
		}
		#nu189 {
		  position:absolute;
		  left:7px;
		  top:5px;
		  width:27px;
		  white-space:nowrap;
		}
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
		#u1640 {
		  position:absolute;
		  left:636px;
		  top:10px;
		  width:120px;
		  height:35px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u1650 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u1641 {
		  position:absolute;
		  left:506px;
		  top:10px;
		  width:120px;
		  height:35px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u1651 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u1642 {
		  position:absolute;
		  left:376px;
		  top:10px;
		  width:120px;
		  height:35px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u1652 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u1643 {
		  position:absolute;
		  left:246px;
		  top:10px;
		  width:120px;
		  height:35px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u1653 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:116px;
		  word-wrap:break-word;
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
		#u002 {
		  position:absolute;
		  left:296px;
		  top:120px;
		  width:129px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
	
		#u003 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:129px;
		  white-space:nowrap;
		  font-weight: 500;
		  
		}
		#u004 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
	
		#u005 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u006 {
		  position:absolute;
		  left:270px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#u007 {
		  position:absolute;
		  left:16px;
		  top:-2px;
		  width:82px;
		  word-wrap:break-word;
		}
		#u006_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#u008 {
		  position:absolute;
		  left:390px;
		  top:184px;
		  width:100px;
		  height:15px;
		}
		#u009 {
		  position:absolute;
		  left:16px;
		  top:-2px;
		  width:82px;
		  word-wrap:break-word;
		}
		#u008_input {
		  position:absolute;
		  left:-3px;
		  top:-2px;
		}
		#u0010 {
		  position:absolute;
		  left:410px;
		  top:246px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
	
		#u0011 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u0012 {
		  position:absolute;
		  left:190px;
		  top:246px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}

		#u0013 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
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
    <link href="${ctx}/static/css/prenatlChildbirthHistory_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
    	
    	$(function(){
    		
    		//点击结案按钮，进行结案（弹对话框写入结案原因）
			$("#u165").click(function(){
				showDialog_("提示","ifCloseCase","moremiddleOver",false);
			});
			//点击否关闭弹框
			$("#u0010").click(function(){
				$("#ifCloseCase").window("close");
			});
			//点击确定进行结案
			$("#u0012").click(function(){
				var status = $("input[name='closeCaseReason']:checked").val();
				if(status == null && status == undefined){
					alert("请选择结案原因!");
					return false;
				}
				$("#closeCase").submit();
			});
			var p3s = $("#post3to7Size").val();
    		if(p3s > 1){
	   			var top = $("#nu168")[0].offsetTop ;
	   			$("#nu168")[0].style.top = (top + (p3s-1)*30)+"px";
    		}
    	});
    
    </script>
  </head>
  <body style="background-color: #FFFFFF">
  <div id="base" class="">
    
    	<div id="title">
        <div id="u4" class="ax_形状" style="background-color:#EE5F45">
          <p id="u5"><span>历史信息查看</span></p>
      	</div>
        
        <!-- <div id="u166" class="ax_形状" style="background-color:#34A097">
          <p id="u167"><span>分娩信息</span></p>
      	</div> -->
        <c:if test="${nomal2 == '2' }">
	        <div id="u1640" class="ax_形状" style="background-color:#34A097">
	          <p id="u1650" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/falseList?archiveId=${birthArchives.archivesId }&go=0'" style="cursor: pointer;"><span>补访视</span></p>
	      	</div>
      	</c:if>
      	<c:if test="${nomal1 == '1' }">
	        <div id="u1641" class="ax_形状" style="background-color:#34A097">
	          <p id="u1651" onclick="window.location.href='${ctx}/archivesinfo/listChildbirth?id=${birthArchives.archivesId }&Sign=1'" style="cursor: pointer;"><span>补分娩</span></p>
	      	</div>
      	</c:if>
      	
        <div id="u1642" class="ax_形状" style="background-color:#34A097">
          <p id="u1652" onclick="window.location.href='${ctx}/prenatal/suppleSecondToNPrenatal?birthArchivesId=${birthArchives.id }'" style="cursor: pointer;"><span>补随访</span></p>
      	</div>
      	
      	<c:if test="${ nn == '0'}">
	        <div id="u1643" class="ax_形状" style="background-color:#34A097">
	          <p id="u1653" onclick="window.location.href='${ctx}/prenatal/suppleFirstPrenatal?birthArchivesId=${birthArchives.id }'" style="cursor: pointer;"><span>补卡</span></p>
	      	</div>
      	</c:if>
        <div id="u164" class="ax_形状" style="background-color:#999999">
          <p id="u165" style="cursor: pointer;"><span>结案</span></p>
      	</div>
        
        <c:if test="${birthArchives.riskSign == 1 }">
	        <div id="u160" class="ax_形状" style="background-color:#E9854F">
	          <p id="u161" onclick="window.location.href='${ctx}/highriskprojectmanagement/list?birthArchiveId=${birthArchives.id }&archivesId=${birthArchives.archivesId }'" style="cursor: pointer;"><span>专案记录</span></p>
	      	</div>
      	</c:if>
        <c:if test="${operator.depId != birthArchives.outHospitalId || birthArchives.referralSign != '2'}">
	      	<div id="u158" class="ax_形状" style="background-color:#56BB4D">
	          <p id="u159" style="cursor: pointer;" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/list?archiveId=${birthArchives.archivesId }&go=0'"><span>新增访视</span></p>
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
          <p id="u157"><span>正常分娩</span></p>
      	</div>
        
        <div>
        	
            <div id="u140" class="ax_文本段落" <c:if test="${birthArchives.riskSign == 1 }"> style="color: #EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if> >
          		<p id="u141"><span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name }</span></p>
   		  </div>
            
            <div id="u142" class="ax_文本段落" <c:if test="${birthArchives.riskSign == 1 }"> style="color: #EE5F45; font-family:'Arial Negreta', 'Arial';
  font-weight:700;"</c:if>>
       		  <p id="u143"><span>档案编号：${archives.archivesCode }</span></p>
   		  </div>
            
            <div id="u154" class="ax_文本段落">
          		<p id="u155"><span>建档日期：<fmt:formatDate value="${archives.creatTime }" pattern="yyyy-MM-dd"/></span></p>
      		</div>
            
            <div id="u138" class="ax_文本段落">
          		<p id="u139"><span>孕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;周：(已分娩)</span></p>
      		</div>
            
            <div id="u132" class="ax_文本段落">
          		<p id="u133"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
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
        
        <div id="u6" class="ax_形状" style="background-color:#006EBC">
          <p id="u7"><span>历 史 检 查 记 录</span></p>
      	</div>
        
        <div id="u8" class="ax_文本段落">
          <p id="u9"><span>收起</span></p>
      	</div>
        
        

      
      <iframe id="u10" scrolling="auto" frameborder="1"></iframe>
		
<!-- 	  <div id="u409" class="ax_动态面板"> -->
        <div id="u409_state0" class="panel_state" data-label="State1">
<!--           <div id="u409_state0_content" class="panel_state_content"> -->
           <div id="u412" class="ax_表格">
      <!-- <div id="u11" class="ax_表格"> -->

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
	                          <p><span>详情</span></p>
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
<!-- 	      	</div> -->
<!-- 	      </div> -->
      	</div>
      </div>


      <div id="u168" class="ax_形状" style="background-color:#006EBC">
          <p id="u169"><span>分 娩 信 息</span></p>
      </div>
      
      <div id="u176" class="ax_文本段落">
      	<c:if test="${childbirthBasic.birthDate != null}">
          <p id="u177" style="cursor: pointer;"  onclick="window.location.href='${ctx}/archivesinfo/listArchives?id=${archives.id }'"><span>详情</span></p>
      	</c:if>
      </div>
      
      <div id="u170" class="ax_文本段落">
          <p id="u171"><span>分娩日期：<fmt:formatDate value="${childbirthBasic.birthDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
      
      <div id="u172" class="ax_文本段落">
          <p id="u173"><span>分娩方式：
          	<c:forEach items="${childbirthBabys }" var="baby">
          		<c:if test="${baby.deliveryType == '0' }">剖宫产</c:if>
          		<c:if test="${baby.deliveryType == '1' }">顺产</c:if>
          		&nbsp;
          	</c:forEach>
          </span></p>
      </div>
      
      <div id="u174" class="ax_文本段落">
          <p id="u175"><span>出院时间：<fmt:formatDate value="${childbirthBasic.leaveDate }" pattern="yyyy-MM-dd"/></span></p>
      </div>
      
      <div id="nu166" class="ax_形状" style="background-color:#006EBC">
          <p id="nu167"><span>产 后 访 视 记 录</span></p>
      </div>
     <% int z=0; %>
      <c:forEach items="${post3To7Exas }" var="post3To7Exa">
	      <div id="nu176" style="top: <%=(660+z*30) %>px;" class="ax_文本段落">
	          <p id="nu177"><span>访视日期：<fmt:formatDate value="${post3To7Exa.creatTime }" pattern="yyyy-MM-dd"/> </span></p>
	      </div>
	      
	      <div id="nu178" style="top: <%=(660+z*30) %>px;" class="ax_文本段落">
	          <p id="nu179">
	          	<span>分类：
	          		<c:if test="${post3To7Exa.result == 0 }">未见异常</c:if>
	          		<c:if test="${post3To7Exa.result == 1 }">异常 ：${post3To7Exa.remark}</c:if>
	         	</span>
	          </p>
	      </div>
	      
	      <div id="nu186" style="top: <%=(654+z*30) %>px;background-color: #006EBC;" class="ax_文本段落">
	          <p id="nu187" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaDetails?archiveId=${archives.id}&postpartumExaId=${post3To7Exa.id}'" style="cursor: pointer;"><span>详情</span></p>
	      </div>
 	      <% z ++; %> 
 	  </c:forEach>  
      <input type="hidden" id="post3to7Size" value="${post3to7Size }"/>
      <div id="nu168" class="ax_形状" style="background-color:#006EbC">
          <p id="nu169"><span>产 后 42 天 健 康 检 查 记 录</span></p>
      </div>
     <% if(z == 0){ z += 1;} %>
      <c:forEach items="${post42Exas }" var="post42Exa"> 
      
	      <div id="nu180" style="top: <%=(719+(z-1)*30) %>px;" class="ax_文本段落">
	          <p id="nu181"><span>访视日期：<fmt:formatDate value="${post42Exa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
	      </div>
	      
	      <div id="nu182" style="top: <%=(719+(z-1)*30) %>px;" class="ax_文本段落">
	          <p id="nu183">
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
		  
		  <div id="nu188" style="background-color: #006EBC; top: <%=(711+(z-1)*30) %>px; " class="ax_文本段落">
	          <p id="nu189" onclick="window.location.href='${ctx}/postpartum/postpartumexainfo/postExaDetails?archiveId=${archives.id}&postpartumExaId=${post42Exa.id}'" style="cursor: pointer;"><span>详情</span></p>
	      </div>
	      <%-- <div id="u180" style="top: <%=(719+(z+1)*30) %>px;" class="ax_文本段落">
	          <p id="u181"><span>访视日期：<fmt:formatDate value="${post42Exa.creatTime }" pattern="yyyy-MM-dd"/></span></p>
	      </div> --%>
	      <%z++; %>
       </c:forEach> 
      
  </div>
  <div id="ifCloseCase" class="easyui-dialog" title="是否结案" closed="true">
		 <!-- Unnamed (形状) -->
      <!-- <div id="u004" class="ax_形状" style="background-color:#EE5F45;">
          <p id="u005"><span>提&nbsp; &nbsp; 示</span></p>
      </div> -->
         <!-- Unnamed (形状) -->
      <div id="u002" class="ax_文本段落">
          <p id="u003"><span style="font-size: 14px;">请选择结案原因：</span></p>
      </div>
	<form id="closeCase" action="${ctx }/postpartum/postpartumexainfo/closeCase" method="post">  
	      <!-- Unnamed (单选按钮) -->
	      <div id="u006" class="ax_单选按钮">
	        <label for="u006_input">
	            <p id="u007"><span> 失访</span></p>
	        </label>
	        <input id="u006_input" type="radio" value="3" name="closeCaseReason"/>
	      </div>
	
	      <!-- Unnamed (单选按钮) -->
	      <div id="u008" class="ax_单选按钮">
	        <label for="u008_input">
	            <p id="u009"><span> 其他</span></p>
	        </label>
	        <input id="u008_input" type="radio" value="4" name="closeCaseReason"/>
	      </div>
	     <!-- 点击结案时需要提交的参数（生育档案的id） -->
	      	<input type="hidden" name="birthArchivesId" value="${birthArchives.id }" />
	      </form>    
          <!-- Unnamed (形状) -->
      <div id="u0012" class="ax_形状" style="background-color:#E9854F;">
          <p id="u0013" style="cursor: pointer;"><span>确定</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u0010" class="ax_形状" style="background-color:#009DD9;" >
          <p id="u0011" style="cursor: pointer;"><span>取消</span></p>
      </div>
  </div>
  </body>
</html>
