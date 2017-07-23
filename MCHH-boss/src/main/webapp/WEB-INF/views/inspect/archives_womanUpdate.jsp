<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript">
		$(function() {
				
	    	  var editArchUrl = "${ctx}/archivesinfo/updateWoman";
	    	  var provinceUrl = "${ctx}/config/provinceInfo/all";
	    	  
	    	  //下拉列
	    	  function province(thisUrl,id,parentId){
	    		  $.ajax({
					dataType:'json',
					url:thisUrl,
					data:{parentId:parentId},
					success:function(data){
	 					$("#"+id).html("");
	 					var str = "" ;
	 					for(var i = 0;i<data.list.length;i++){
	 						str += "<option value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
	 					}
	 					$("#"+id).html(str);
	 					$("#"+id)[0].selectedIndex = -1;
					}
				});
	    	  };
	    	  
	    	  function provinces(thisUrl,id,pId){
    			  $.ajax({
    				dataType:'json',
    				url:thisUrl,
    				success:function(data){
    					
    					var proId = $("#"+pId).val();
    					$("#"+id).html("");
    					var str = "" ;
    					for(var i = 0;i<data.list.length;i++){
    						var s = "";
    						if(proId == data.list[i].id){
    							s = "selected";
    						}
    						str += "<option "+s+" value="+data.list[i].id+">"+data.list[i].name+"</option>" ;
    					}
    					$("#"+id).html(str);
    					//$("#"+id)[0].selectedIndex = -1;
    				}
    			});
    		  };
	    	  
	    	  //家庭省份
	   		  provinces(provinceUrl,"u079_input","womanHomePro");
	    	  
	    	  //家庭市
	    	  $("#u079_input").change(function(){
	    		  var provinceId = $("#u079_input").val();
	    		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
	    		  province(cityUrl,"u091_input",provinceId);
	    		  $("#u092_input")[0].selectedIndex = -1;
	    		  $("#u093_input")[0].selectedIndex = -1;
	    		  $("#u094_input")[0].selectedIndex = -1;
	    		  $("#u080_input").val("");
	    	  });
	    	  
	    	  //家庭县
	    	  $("#u091_input").change(function(){
	    		  var provinceId = $("#u091_input").val();
	    		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
	    		  province(cityUrl,"u092_input",provinceId);
	    		  $("#u093_input")[0].selectedIndex = -1;
	    		  $("#u094_input")[0].selectedIndex = -1;
	    		  $("#u080_input").val("");
	    	  });
	    	  
	    	  //家庭乡
	    	  $("#u092_input").change(function(){
	    		  var provinceId = $("#u092_input").val();
	    		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
	    		  province(cityUrl,"u093_input",provinceId);
	    		  $("#u094_input")[0].selectedIndex = -1;
	    		  $("#u080_input").val("");
	    	  }); 
	    	 
	    	  //家庭村
	    	  $("#u093_input").change(function(){
	    		  var provinceId = $("#u093_input").val();
	    		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
	    		  province(cityUrl,"u094_input",provinceId);
	    		  $("#u080_input").val("");
	    	  });
	    	  
	    	  //户口省份
	    	 provinces(provinceUrl,"u032_input","womanAccPro");
	    		  
	    	  //户口市
	    	  $("#u032_input").change(function(){
	    		  var provinceId = $("#u032_input").val();
	    		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
	    		  province(cityUrl,"u070_input",provinceId);
	    		  $("#u071_input")[0].selectedIndex = -1;
	    		  $("#u072_input")[0].selectedIndex = -1;
	    		  $("#u073_input")[0].selectedIndex = -1;
	    		  $("#u042_input").val("");
	    	  });
	    	  
	    	  //户口县
	    	  $("#u070_input").change(function(){
	    		  var provinceId = $("#u070_input").val();
	    		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
	    		  province(cityUrl,"u071_input",provinceId);
	    		  $("#u072_input")[0].selectedIndex = -1;
	    		  $("#u073_input")[0].selectedIndex = -1;
	    		  $("#u042_input").val("");
	    	  });
	    	  
	    	  //户口乡
	    	  $("#u071_input").change(function(){
	    		  var provinceId = $("#u071_input").val();
	    		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
	    		  province(cityUrl,"u072_input",provinceId);
	    		  $("#u073_input")[0].selectedIndex = -1;
	    		  $("#u042_input").val("");
	    	  });
	    	
	    	  //户口村
	    	  $("#u072_input").change(function(){
	    		  var provinceId = $("#u072_input").val();
	    		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
	    		  province(cityUrl,"u073_input",provinceId);
	    		  $("#u042_input").val("");
	    	  });
	    	  
				//根据身份证号获取出生日期
				/* var idNo = $("#u029_input").val();
				
				var birth = idNo.substr(6,8);
				
				var y = birth.substr(0,4);
				
				var m = birth.substr(4,2);
				
				var d = birth.substr(6,2);
			    
				var births = y + m + d;
				
				$("#u069_input").val(births); */
				
			   //根据出生日期计算年龄
	  		   var birthday = $("#u069_input").val();
			   
	  		   var nowdate = new Date();
	  		   var age = nowdate.getFullYear() - birthday.substr(0,4);
	  		   $("#u19_1").html(age + "岁");
	  		   
	  		  //通过出生日期选择计算年龄
	     	  $("#u069_input").blur(function(){
	     		  var birthday = this.value;
	     		  var nowdate = new Date();
	     		  var age = nowdate.getFullYear() - birthday.substr(0,4);
	     		  if(age >100 || age <0){
	     			  //$("#age").val("");
	     			 $("#u19_1").html("");
	     		  }else{
	     		  	//$("#age").val(age);
	     		  	$("#u19_1").html(age + "岁");
	     		  }
	     	  });
	  		   
	  		   //同上功能
	  		   $("#u074").click(function(){
	  			   
	    		  $("#u079_input").html($("#u032_input").html());
	    		  if($("#u032_input").val() != null){
	    			  $("#u079_input").val($("#u032_input").val());
	    		  }else{
	    			  $("#u079_input")[0].selectedIndex = -1;
	    		  }
	    		  $("#u091_input").html($("#u070_input").html());
	    		  if($("#u070_input").val() != null){
	    			  $("#u091_input").val($("#u070_input").val());
	    		  }else{
	    			  $("#u091_input")[0].selectedIndex = -1;
	    		  }
	    		  $("#u092_input").html($("#u071_input").html());
	    		  if($("#u071_input").val() != null){
	    			  $("#u092_input").val($("#u071_input").val());
	    		  }else{
	    			  $("#u092_input")[0].selectedIndex = -1;
	    		  }
	    		  $("#u093_input").html($("#u072_input").html());
	    		  if($("#u072_input").val() != null){
	    			  $("#u093_input").val($("#u072_input").val());
	    		  }else{
	    			  $("#u093_input")[0].selectedIndex = -1;
	    		  }
	    		  $("#u094_input").html($("#u073_input").html());
	    		  if($("#u073_input").val() != null){
	    			  $("#u094_input").val($("#u073_input").val());
	    		  }else{
	    			  $("#u094_input")[0].selectedIndex = -1;
	    		  }
	    		  $("#u080_input").val($("#u042_input").val());
	    		  
	    	  });
	  		   
	  		   //关闭
	  		   $("#u991").click(function(){
	  			 $("#addOrUpdateAtv").window("close");
	  		   })
	  		   
	  		   //保存
	  		   $("#u099").click(function(){
	  			 	var birthday = $("#u069_input").val();
	  			 	var id = $("#archivesId").val();
	  			 	
	  			 	
	      		  var tag1 = /[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/;
	      		  
	      		  var tag2 = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X|x)$/;
	      		  
	      		  var birthday = $("#u069_input").val();
	      		
	    		  if(birthday == "" || birthday == null ){
	    			  alert("请选择出生日期！");
	    			  return false;
	    		  }
	      		  
	      		  var occu = $("#u035_input").val();
	      		  
	      		  if(occu == "" || occu == null || occu == "undfined"){
	      			  alert("请选择职业！");
	      			  return false;
	      		  }
	      		  
	      		  var workUnit = $("#u040_input").val();
	      		  if(occu != 0){
	  	    		  if(workUnit == "" || workUnit == null || workUnit == "undfined"){
	  	    			  alert("请输入工作单位！");
	  	    			  return false;
	  	    		  }
	      		  }
	      		  
	      		  var accP = $("#u032_input").val();
	      		  if(accP == "" || accP == null || accP == "undfined"){
	      			  alert("请选择户口省！");
	      			  return false;
	      		  }
	      		  var accC = $("#u070_input").val();
	      		  if(accC == "" || accC == null || accC == "undfined"){
	      			  alert("请选择户口市！");
	      			  return false;
	      		  }
	      		  var accT = $("#u071_input").val();
	      		  if(accT == "" || accT == null || accT == "undfined"){
	      			  alert("请选择户口县(区)！");
	      			  return false;
	      		  }
	      		  var accS = $("#u072_input").val();
	      		  if(accS == "" || accS == null || accS == "undfined"){
	      			  alert("请选择户口乡(街道)！");
	      			  return false;
	      		  }
	      		  var accV = $("#u073_input").val();
	      		  if(accV == "" || accV == null || accV == "undfined"){
	      			  alert("请选择户口村！");
	      			  return false;
	      		  }
	      		  
	      		  var homeP = $("#u079_input").val();
	      		  if(homeP == "" || homeP == null || homeP == "undfined"){
	      			  alert("请选择家庭省！");
	      			  return false;
	      		  }
	      		  var homeC = $("#u091_input").val();
	      		  if(homeC == "" || homeC == null || homeC == "undfined"){
	      			  alert("请选择家庭市！");
	      			  return false;
	      		  }
	      		  var homeT = $("#u092_input").val();
	      		  if(homeT == "" || homeT == null || homeT == "undfined"){
	      			  alert("请选择家庭县(区)！");
	      			  return false;
	      		  }
	      		  var homeS = $("#u093_input").val();
	      		  if(homeS == "" || homeS == null || homeS == "undfined"){
	      			  alert("请选择家庭乡(街道)！");
	      			  return false;
	      		  }
	      		  var homeV = $("#u094_input").val();
	      		  if(homeV == "" || homeV == null || homeV == "undfined"){
	      			  alert("请选择家庭村！");
	      			  return false;
	      		  }
	      		  
	      		  var tag3 = /^1[34578]\d{9}$/;
	      		  var telephone = $("#u066_input").val();
	      		  
	      		  if(telephone == "" || telephone == null || telephone == "undfined"){
	      			  alert("请输入联系电话！");
	      			  return false;
	      		  }
	      		  if(!tag3.test(telephone)){
	      			  alert("请输入正确联系电话格式！");
	      			  return false;
	      		  }
	      		  
	      		  /* var manName = $("#u0103_input").val();
	      		  if(manName == "" || manName == null || manName == "undfined"){
	      			  alert("请输入对方姓名！");
	      			  return false;
	      		  }
	      		  if(!tag1.test(manName)){
	      			  alert("请输入格式正确的对方姓名！");
	      			  return false;
	      		  } */
	      		  
	      		  /* var manId = $("#u0106_input").val();
	      		  if(manId == "" || manId == null || manId == "undfined"){
	      			  alert("请输入对方身份证号！");
	      			  return false;
	      		  }
	      		  if(!tag2.test(manId)){
	      			  alert("请输入格式正确的对方身份证号！");
	      			  return false;
	      		  } */
	      		  var manTel = $("#u0109_input").val();
	      		  if(manTel == "" || manTel == null || manTel == "undfined"){
	      			  alert("请输入对方联系电话！");
	      			  return false;
	      		  }
	      		  if(!tag3.test(manTel)){
	      			  alert("请输入格式正确的对方联系电话！");
	      			  return false;
	      		  }
	  			 	
	  			 	$("#addOrUpdate").attr("action",editArchUrl);
			    	$("#addOrUpdate").submit();
	  		   })
	  		   
		})
</script>
   
 <div id="0base" class="">
    
      <div id="u0" class="ax_形状">
        <img id="u000_img" class="img " src="${ctx}/static/images/u0.png"/>
        <!-- Unnamed () -->
        <div id="u1" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>
      
    	<!-- Unnamed (形状) -->
      <div id="u505" class="ax_形状" style="background-color:#EE5F45">
        
          <p id="u03"><span>个人基本信息详情编辑</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u991" class="ax_形状" style="background-color:#EE5F45;cursor:pointer">
       
          <p id="u992"><span>关闭</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u099" class="ax_形状" style="background-color:#56BB4D;cursor:pointer">
       
          <p id="u0100"><span>保存</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u097" class="ax_形状" style="background-color:#EE5F45">
        
          <p id="u098"><span>基本信息</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u06" class="ax_文本段落">
        
          <p id="u07"><span>档案编号：${archivesInfoDetail.archivesInfo.archivesCode }</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u010" class="ax_文本段落">
        
          <p id="u011"><span>建档医院：${archivesInfoDetail.department.name }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u012" class="ax_文本段落">
        
          <p id="u013"><span>建档医生：${archivesInfoDetail.operatorPO.realName }</span></p>
        
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u08" class="ax_文本段落">
        
        
          <p id="u09"><span>建档日期：${archivesInfoDetail.creatTime }</span></p>
        
      </div>
	<form id="addOrUpdate" action="" method="post">
	
		<input type="hidden" id="archivesId" name="id" value="${archivesInfoDetail.archivesInfo.id}"/>
		<input type="hidden" id="archivesCode" name="archivesCode" value="${archivesInfoDetail.archivesInfo.archivesCode}"/>
		<input type="hidden" id="realName" name="realName" value="${archivesInfoDetail.operatorPO.realName }"/>
		<input type="hidden" id="departmentId" name="departmentId" value="${archivesInfoDetail.department.id }"/>
      <!-- Unnamed (形状) -->
      <div id="u016" class="ax_文本段落">        
          <p id="u017"><span>姓</span><span>&nbsp; &nbsp; </span><span>&nbsp;</span><span>&nbsp;</span><span>名</span><span></span><span>：</span></p>        
      </div>
      <!-- Unnamed (文本框) -->
      <div id="u021" class="ax_文本框">
        <span>${archivesInfoDetail.archivesInfo.name }</span>
        <input id="u021_input" name = "name" readonly= "true" type="hidden" value="${archivesInfoDetail.archivesInfo.name }" placeholder = ""/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u018" class="ax_文本段落">
        
          <p id="u019"><span>性</span><span>&nbsp; &nbsp; &nbsp; </span><span>别：</span></p>
        
      </div>

      <!-- 性别 (下拉列表框) -->
      <div id="u020" class="ax_下拉列表框">
        <select id="u020_input" name = "sex" data-label="性别">
          <c:if test="${archivesInfoDetail.archivesInfo.sex == '0' }">
          	<option value="0" selected="selected">女</option>
          	<option value="1">男</option>
          	<option value="2">性别不明</option>
          </c:if>
          <c:if test="${archivesInfoDetail.archivesInfo.sex == '1' }">
          	<option value="0" >女</option>
          	<option value="1" selected="selected">男</option>
          	<option value="2">性别不明</option>
          </c:if>
          <c:if test="${archivesInfoDetail.archivesInfo.sex == '2' }">
          	<option value="0" >女</option>
          	<option value="1">男</option>
          	<option value="2" selected="selected">性别不明</option>
          </c:if>
        </select>
      </div>

      

      <!-- Unnamed (形状) -->
      <div id="u022" class="ax_文本段落">
        
          <p id="u023"><span>国</span><span>&nbsp; &nbsp; </span><span>&nbsp;</span><span>&nbsp;</span><span>籍：</span></p>
        
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u024" class="ax_下拉列表框">
        <select id="u024_input" name = "international">
        	<c:if test="${archivesInfoDetail.archivesInfo.international == '1'}">
		          <option value="0">中国</option>
		          <option value="1" selected="selected">外国</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.archivesInfo.international == '0'}">
          		  <option value="0" selected="selected">中国</option>
		          <option value="1">外国</option>
          	</c:if>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u053" class="ax_文本段落">
        
          <p id="u054"><span>民</span><span>&nbsp; &nbsp; </span><span>&nbsp;</span><span>&nbsp;</span><span>族 </span><span></span><span>：</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u055" class="ax_下拉列表框">
        <select id="u055_input" name = "nation">
          	<c:if test="${archivesInfoDetail.archivesInfo.nation == '汉'}">
		          <option value="汉" selected="selected">汉</option>
		          <option value="回">回</option>
		          <option value="其他">其他</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.archivesInfo.nation == '回'}">
          		  <option value="汉">汉</option>
		          <option value="回" selected="selected">回</option>
		          <option value="其他">其他</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.archivesInfo.nation == '其他'}">
          		  <option value="汉">汉</option>
		          <option value="回">回</option>
		          <option value="其他" selected="selected">其他</option>
          	</c:if>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u027" class="ax_文本段落">
        
          <p id="u028"><span>身份证号</span><span>：</span></p>
        
      </div>
      
      <!-- Unnamed (文本框) -->
      <div id="u029" class="ax_文本框">
      	<%-- <span>${archivesInfoDetail.archivesInfo.idNo }</span> --%>
        <input id="u029_input" name = "idNo" type="text" value="${archivesInfoDetail.archivesInfo.idNo }"/>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u067" class="ax_文本段落">
        
          <p id="u068"><span>出生日期</span><span></span><span>：</span></p>
        
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u069" class="ax_文本框">
        <%-- <input id="u069_input" name = "birthday" type="text" value="${archivesInfoDetail.birthday }"/> --%>
        <input type="text" id="u069_input" name="birthday"
        style="color:#333333;cursor:pointer;width:145px; height: 25px;border-style: solid;border-width: 1px;border-color: #c8c9cd;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="${archivesInfoDetail.birthday }" tabindex="1" required>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u025" class="ax_文本段落">
        
          <p id="u026"><span>年&nbsp; &nbsp; &nbsp; &nbsp;龄：</span><span><p id="u19_1"></p></span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u036" class="ax_文本段落">
        
          <p id="u037"><span>文化程度</span><span>&nbsp;</span><span></span><span>：</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u041" class="ax_下拉列表框">
        <select id="u041_input" name = "education">
        	<c:if test="${archivesInfoDetail.archivesInfo.education == '0'}">
          		  <option value="9">不详</option>
          		  <option value="0" selected="selected">小学</option>
		          <option value="1">初中</option>
		          <option value="2">高中</option>
		          <option value="3">中专</option>
		          <option value="4">大专</option>
		          <option value="5">本科</option>
		          <option value="6">硕士</option>
		          <option value="7">博士</option>
		          <option value="8">无</option>
          	</c:if>
          	<c:if test="${archivesInfoDetail.archivesInfo.education == '1'}">
          		  <option value="9">不详</option>
          		  <option value="0">小学</option>
		          <option value="1" selected="selected">初中</option>
		          <option value="2">高中</option>
		          <option value="3">中专</option>
		          <option value="4">大专</option>
		          <option value="5">本科</option>
		          <option value="6">硕士</option>
		          <option value="7">博士</option>
		          <option value="8">无</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.education == '2'}">
       			  <option value="9">不详</option>
       			  <option value="0">小学</option>
		          <option value="1">初中</option>
		          <option value="2" selected="selected">高中</option>
		          <option value="3">中专</option>
		          <option value="4">大专</option>
		          <option value="5">本科</option>
		          <option value="6">硕士</option>
		          <option value="7">博士</option>
		          <option value="8">无</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.education == '3'}">
       			  <option value="9">不详</option>
       			  <option value="0">小学</option>
		          <option value="1">初中</option>
		          <option value="2">高中</option>
		          <option value="3" selected="selected">中专</option>
		          <option value="4">大专</option>
		          <option value="5">本科</option>
		          <option value="6">硕士</option>
		          <option value="7">博士</option>
		          <option value="8">无</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.education == '4'}">
       			  <option value="9">不详</option>
       			  <option value="0">小学</option>
		          <option value="1">初中</option>
		          <option value="2">高中</option>
		          <option value="3">中专</option>
		          <option value="4" selected="selected">大专</option>
		          <option value="5">本科</option>
		          <option value="6">硕士</option>
		          <option value="7">博士</option>
		          <option value="8">无</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.education == '5'}">
       			  <option value="9">不详</option>
       			  <option value="0">小学</option>
		          <option value="1">初中</option>
		          <option value="2">高中</option>
		          <option value="3">中专</option>
		          <option value="4">大专</option>
		          <option value="5" selected="selected">本科</option>
		          <option value="6">硕士</option>
		          <option value="7">博士</option>
		          <option value="8">无</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.education == '6'}">
       			  <option value="9">不详</option>
       			  <option value="0">小学</option>
		          <option value="1">初中</option>
		          <option value="2">高中</option>
		          <option value="3">中专</option>
		          <option value="4">大专</option>
		          <option value="5">本科</option>
		          <option value="6" selected="selected">硕士</option>
		          <option value="7">博士</option>
		          <option value="8">无</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.education == '7'}">
       			  <option value="9">不详</option>
       			  <option value="0">小学</option>
		          <option value="1">初中</option>
		          <option value="2">高中</option>
		          <option value="3">中专</option>
		          <option value="4">大专</option>
		          <option value="5">本科</option>
		          <option value="6">硕士</option>
		          <option value="7" selected="selected">博士</option>
		          <option value="8">无</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.education == '8'}">
       			  <option value="9">不详</option>
       			  <option value="0">小学</option>
		          <option value="1">初中</option>
		          <option value="2">高中</option>
		          <option value="3">中专</option>
		          <option value="4">大专</option>
		          <option value="5">本科</option>
		          <option value="6">硕士</option>
		          <option value="7">博士</option>
		          <option value="8" selected="selected">无</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.education == '9'}">
       			  <option value="9" selected="selected">不详</option>
       			  <option value="0">小学</option>
		          <option value="1">初中</option>
		          <option value="2">高中</option>
		          <option value="3">中专</option>
		          <option value="4">大专</option>
		          <option value="5">本科</option>
		          <option value="6">硕士</option>
		          <option value="7">博士</option>
		          <option value="8">无</option>
       		</c:if>
          
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u056" class="ax_文本段落">
        
          <p id="u057"><span>户籍类型</span><span>：</span></p>
        
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u058" class="ax_下拉列表框">
        <select id="u058_input" name = "householdType">
        	<c:if test="${archivesInfoDetail.archivesInfo.householdType == '0'}">
		          <option selected value="0">本地</option>
		          <option value="1">外地</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.householdType == '1'}">
       			  <option value="0">本地</option>
		          <option selected value="1">外地</option>
       		</c:if>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u059" class="ax_文本段落">
        
          <p id="u060"><span>户口</span><span>类型</span><span>：</span></p>
        
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u061" class="ax_下拉列表框">
        <select id="u061_input" name = "accountType">
        	<c:if test="${archivesInfoDetail.archivesInfo.accountType eq '0'}">
       			<option value="1">非农户籍</option>
          		<option value="0" selected>农业户籍</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.accountType eq '1'}">
       			<option value="1" selected>非农户籍</option>
          		<option value="0">农业户籍</option>
       		</c:if>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u033" class="ax_文本段落">
        
          <p id="u034"><span>职</span><span>&nbsp; &nbsp; </span><span>&nbsp;</span><span>&nbsp;</span><span>业：</span></p>
        
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u035" class="ax_下拉列表框">
        <select id="u035_input" name = "occupation">
        	<c:if test="${archivesInfoDetail.archivesInfo.occupation == '0'}">
       			<option value="0" selected>无</option>
       			<option value="1">事业单位</option>
       			<option value="2">企业</option>
       			<option value="3">服务业</option>
       			<option value="4">制造业</option>
       			<option value="5">农业</option>
       			<option value="6">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.occupation == '1'}">
       			<option value="0">无</option>
       			<option value="1" selected>事业单位</option>
       			<option value="2">企业</option>
       			<option value="3">服务业</option>
       			<option value="4">制造业</option>
       			<option value="5">农业</option>
       			<option value="6">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.occupation == '2'}">
       			<option value="0">无</option>
       			<option value="1">事业单位</option>
       			<option value="2" selected>企业</option>
       			<option value="3">服务业</option>
       			<option value="4">制造业</option>
       			<option value="5">农业</option>
       			<option value="6">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.occupation == '3'}">
       			<option value="0">无</option>
       			<option value="1">事业单位</option>
       			<option value="2">企业</option>
       			<option value="3" selected>服务业</option>
       			<option value="4">制造业</option>
       			<option value="5">农业</option>
       			<option value="6">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.occupation == '4'}">
       			<option value="0">无</option>
       			<option value="1">事业单位</option>
       			<option value="2">企业</option>
       			<option value="3">服务业</option>
       			<option value="4" selected>制造业</option>
       			<option value="5">农业</option>
       			<option value="6">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.occupation == '5'}">
       			<option value="0">无</option>
       			<option value="1">事业单位</option>
       			<option value="2">企业</option>
       			<option value="3">服务业</option>
       			<option value="4">制造业</option>
       			<option value="5" selected>农业</option>
       			<option value="6">其他</option>
       		</c:if>
       		<c:if test="${archivesInfoDetail.archivesInfo.occupation == '6'}">
       			<option value="0">无</option>
       			<option value="1">事业单位</option>
       			<option value="2">企业</option>
       			<option value="3">服务业</option>
       			<option value="4">制造业</option>
       			<option value="5">农业</option>
       			<option value="6" selected>其他</option>
       		</c:if>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u038" class="ax_文本段落">
        
          <p id="u039"><span>工作单位</span><span>：</span></p>
        
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u040" class="ax_文本框">
        <input id="u040_input" name = "workUnit" type="text" value="${archivesInfoDetail.archivesInfo.workUnit }"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u030" class="ax_文本段落">
        
          <p id="u031"><span>户口</span><span>地址</span><span>：</span></p>
        
      </div>

      <!-- Unnamed (下拉列表框) -->     
      <div id="u032" class="ax_下拉列表框">
      <input type="hidden" id="womanAccPro" value="${archivesInfoDetail.provinceInfo.id }"/>
        <select id="u032_input" name = "accProvinceId">
          <%-- <option selected value="${archivesInfoDetail.provinceInfo.id }">${archivesInfoDetail.provinceInfo.name }</option> --%>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u043" class="ax_文本段落">
        
          <p id="u044"><span>省</span></p>
        
      </div>

      
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u070" class="ax_下拉列表框">
        <select id="u070_input" name = "accCityId">
          <option selected value="${archivesInfoDetail.cityInfo.id }">${archivesInfoDetail.cityInfo.name }</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u045" class="ax_文本段落">
        
          <p id="u046"><span>市</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u071" class="ax_下拉列表框">
        <select id="u071_input" name = "accCountyId">
          <option selected value="${archivesInfoDetail.districtAndCountyInfo.id }">${archivesInfoDetail.districtAndCountyInfo.name }</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u047" class="ax_文本段落">
        
          <p id="u048"><span>县（区）</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u072" class="ax_下拉列表框">
        <select id="u072_input" name = "accTownshipId">
           <option selected value = "${archivesInfoDetail.townshipInfo.id }">${archivesInfoDetail.townshipInfo.name }</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u049" class="ax_文本段落">
        
          <p id="u050"><span>乡（街道）</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u073" class="ax_下拉列表框">
        <select id="u073_input" name = "accVillageId">
          <option selected value = "${archivesInfoDetail.villageInfo.id }">${archivesInfoDetail.villageInfo.name }</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u051" class="ax_文本段落">
        
          <p id="u052"><span>村</span></p>
        
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u042" class="ax_文本框">
        <input id="u042_input" name = "accAddress" type="text" value="${archivesInfoDetail.archivesInfo.accAddress }"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u062" class="ax_文本段落">
        
          <p id="u063"><span>家庭</span><span>地址</span><span>：</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u079" class="ax_下拉列表框">
        <input type="hidden" id="womanHomePro" value="${archivesInfoDetail.provinceInfo1.id }"/>
        <select id="u079_input" name = "homeProvinceId">
          <option selected value = "${archivesInfoDetail.provinceInfo1.id }">${archivesInfoDetail.provinceInfo1.name }</option>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u081" class="ax_文本段落">
        
          <p id="u082"><span>省</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u091" class="ax_下拉列表框">
        <select id="u091_input" name = "homeCityId">
          <option selected value = "${archivesInfoDetail.cityInfo1.id }">${archivesInfoDetail.cityInfo1.name }</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u083" class="ax_文本段落">
        
          <p id="u084"><span>市</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u092" class="ax_下拉列表框">
        <select id="u092_input" name = "homeCountyId">
          <option selected value = "${archivesInfoDetail.districtAndCountyInfo1.id }">${archivesInfoDetail.districtAndCountyInfo1.name }</option>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u085" class="ax_文本段落">
        
          <p id="u086"><span>县（区）</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u093" class="ax_下拉列表框">
        <select id="u093_input" name = "homeTownshipId">
          <option selected value = "${archivesInfoDetail.townshipInfo1.id }">${archivesInfoDetail.townshipInfo1.name }</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u087" class="ax_文本段落">
        
          <p id="u088"><span>乡（街道）</span></p>
        
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u094" class="ax_下拉列表框">
        <select id="u094_input" name = "homeVillageId">
          <option selected value = "${archivesInfoDetail.villageInfo1.id }">${archivesInfoDetail.villageInfo1.name }</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u089" class="ax_文本段落">
        
          <p id="u090"><span>村</span></p>
        
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u080" class="ax_文本框">
        <input id="u080_input" name = "homeAddress" type="text" value="${archivesInfoDetail.archivesInfo.homeAddress }"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u074" class="ax_文本段落">
        
          <p id="u075" style="cursor: pointer;"><span>同上</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u064" class="ax_文本段落">
        
          <p id="u065"><span>联系</span><span>电话</span><span></span><span>：</span></p>
        
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u066" class="ax_文本框">
        <input id="u066_input" name = "telephone" type="text" value="${archivesInfoDetail.archivesInfo.telephone }"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u076" class="ax_文本段落">
        
          <p id="u077"><span>紧急电话</span><span></span><span>：</span></p>
        
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u078" class="ax_文本框">
        <input id="u078_input" name = "urgentCall" type="text" value="${archivesInfoDetail.archivesInfo.urgentCall }"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u095" class="ax_形状" style="background-color:#EE5F45">
        
          <p id="u096"><span>对方信息</span></p>
        
      </div>

      <!-- Unnamed (形状) -->
      <div id="u0101" class="ax_文本段落">
        
          <p id="u0102"><span>对方</span><span>姓名</span><span>：</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u0103" class="ax_文本框">
      	<span>${archivesInfoDetail.archivesInfo.manName }</span>
        <input id="u0103_input" name = "manName" type="hidden" value="${archivesInfoDetail.archivesInfo.manName }"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u0104" class="ax_文本段落">
        
          <p id="u0105"><span>身份证号</span><span>：</span></p>

      </div>

      <!-- Unnamed (文本框) -->
      <div id="u0106" class="ax_文本框">
      	<%-- <span>${archivesInfoDetail.archivesInfo.manIdNo }</span> --%>
        <input id="u0106_input" name = "manIdNo" type="text" value="${archivesInfoDetail.archivesInfo.manIdNo }"/>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u0107" class="ax_文本段落">
        
          <p id="u0108"><span>联系</span><span>电话</span><span></span><span>：</span></p>
        
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u0109" class="ax_文本框">
        <input id="u0109_input" name = "manTele" type="text" value="${archivesInfoDetail.archivesInfo.manTele }"/>
      </div>
      </form>
    </div>
    
