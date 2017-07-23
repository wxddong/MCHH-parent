j<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="panel-fit">
  <head>
    <title>基础数据管理-结婚登记人数</title>
	<link href="${ctx }/static/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx }/static/data/styles.css" type="text/css" rel="stylesheet"/>
	<link href="${ctx}/static/css/short_manage.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript">
	

	</script>
	<style type="text/css">
 		.combo-p{border:1px solid #95B8E7;} 
 		.panel-fit body{overflow-y:auto; overflow-x:hidden;}	
 	</style>
  </head>
 	<body class="panel-noscroll">

					<form id="queryform" method="post">

							<div  style="right:710px;bottom:420px;position:absolute;">
									<input type="hidden" name="messType" value="1"/>
									<input type="hidden" name="id" value="${ShortMessageTemplatePO.id }"/>

								  		<div id="u8" class="ax_文本段落">
								          <p id="u9"><span>发送人群：</span></p>
								  		</div>
								
								      <div id="u12" class="ax_下拉列表框">
								        <select id="send" name="sendCrowd" style="width: 150px;height: 30px;border:1px solid #cccccc;">
								          <option></option>
								          <option value="${ShortMessageTemplatePO.sendCrowd }" selected>${ShortMessageTemplatePO.sendCrowd }</option>
								          <option value="孕12周以前">孕12周以前</option>
								          <option value="孕13-16周">孕13-16周</option>
								          <option value="孕17-20周">孕17-20周</option>
								          <option value="孕21-24周">孕21-24周</option>
								          <option value="孕25-28周">孕25-28周</option>
								          <option value="孕29-30周">孕29-30周</option>
								          <option value="孕31-32周">孕31-32周</option>
								          <option value="孕33-34周">孕33-34周</option>
								          <option value="孕35-36周">孕35-36周</option>
								          <option value="孕37周">孕37周</option>
								          <option value="孕38周">孕38周</option>
								          <option value="孕39周">孕39周</option>
								        </select>
								      </div>
								      
								      <div id="u14" class="ax_文本段落">
								          <p id="u15"><span>可用标识：</span></p>
								      </div>
								      
								      <div id="u16" class="ax_下拉列表框">
								      
								        <select id="use" name="useSign" style="width: 150px;height: 30px;border:1px solid #cccccc;">
								        	<c:if test="${ShortMessageTemplatePO.useSign=='0' }">
									          <option value="0 " selected>正常</option>
									          <option value="1">停用</option>
								        	</c:if>
								        	<c:if test="${ShortMessageTemplatePO.useSign=='1' }">
									          <option value="0 " >正常</option>
									          <option value="1" selected>停用</option>
								      		</c:if>
								        </select>
								      </div>
								      
								      
								       <div id="u17" class="ax_文本段落">
								          <p id="u18"><span>发送时间：</span></p>
								      </div>
								      <div id="u19" class="ax_下拉列表框">
								        <select id="Time" name="sendTime" style="width: 150px;height: 30px;border:1px solid #cccccc;">
								        	<c:if test="${ShortMessageTemplatePO.sendTime=='0' }">
								        	<option value="0" selected>提前三天</option>
								        	<option value=""></option>
								        	</c:if>
								        </select>
								      </div>
								      
								      
								      <div id="u10" class="ax_文本段落" >
								          <p id="u11"><span>短信内容：</span></p>
								      </div>
								      
								      
								      <div id="u13" class="ax_多行文本框">
								        <textarea id="tent"  style="width: 471px;height: 149px;border:1px solid #cccccc;" name="content">${ShortMessageTemplatePO.content }</textarea>
								      </div>
								      
									<div style="right:30px;bottom:40px;position:absolute;">
									      <!-- Unnamed (形状) -->
									      <div id="u4" class="ax_形状" style="background-color:#009dd9">
									          <p id="u5"><span id="cancel" onclick="canl()">取消</span></p>
									      </div>
									
									      <!-- Unnamed (形状) -->
									      <div id="u6" class="ax_形状" style="background-color:#fc7d45">
									         <p id="u7"><span id="ed" onclick="edtt()">修改</span></p>
									      </div>
								      </div>
			   					</div>

			   		</form>
	</body>
</html>