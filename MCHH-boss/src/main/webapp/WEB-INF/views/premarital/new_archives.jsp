<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	#u00 {
	  position:absolute;
	  left:1px;
	  top:34px;
	  width:719px;
	  height:346px;
	}
	#u01 {
	  position:absolute;
	  left:2px;
	  top:165px;
	  width:715px;
	  visibility:hidden;
	  word-wrap:break-word;
	}
	#u02 {
	  position:absolute;
	  left:0px;
	  top:0px;
	  width:217px;
	  height:36px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#u03 {
	  position:absolute;
	  left:2px;
	  top:10px;
	  width:213px;
	  word-wrap:break-word;
	}
	#u04 {
	  position:absolute;
	  left:410px;
	  top:216px;
	  width:120px;
	  height:44px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#u05 {
	  position:absolute;
	  left:2px;
	  top:14px;
	  width:116px;
	  word-wrap:break-word;
	}
	#u06 {
	  position:absolute;
	  left:190px;
	  top:216px;
	  width:120px;
	  height:44px;
	  font-family:'Arial Negreta', 'Arial';
	  font-weight:700;
	  color:#FFFFFF;
	}
	#u07 {
	  position:absolute;
	  left:2px;
	  top:14px;
	  width:116px;
	  word-wrap:break-word;
	}
	#u08 {
	  position:absolute;
	  left:231px;
	  top:103px;
	  width:258px;
	  height:16px;
	  font-size:16px;
	  color:#000000;
	  text-align:center;
	}
	#u09 {
	  position:absolute;
	  left:0px;
	  top:0px;
	  width:258px;
	  white-space:nowrap;
	}

</style>
<title>婚前建档</title>
	<%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/newArchives_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
    	
      $(function(){
    	  for(var i = 0; i<19; i ++){
    		  
    	  	$("select")[i].selectedIndex = -1;  	  
    	  }
    	  
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
    	  
    	  //家庭省份
   		  province(provinceUrl,"u80_input",null);
    	  
    	  
    	  //家庭市
    	  $("#u80_input").change(function(){
    		  var provinceId = $("#u80_input").val();
    		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
    		  province(cityUrl,"u92_input",provinceId);
    		  $("#u93_input")[0].selectedIndex = -1;
    		  $("#u94_input")[0].selectedIndex = -1;
    		  $("#u95_input")[0].selectedIndex = -1;
    		  $("#u93_input").html("");
    		  $("#u94_input").html("");
    		  $("#u95_input").html("");
    	  });
    	  
    	  //家庭县
    	  $("#u92_input").change(function(){
    		  var provinceId = $("#u92_input").val();
    		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
    		  province(cityUrl,"u93_input",provinceId);
    		  $("#u94_input")[0].selectedIndex = -1;
    		  $("#u95_input")[0].selectedIndex = -1;
    		  $("#u94_input").html("");
    		  $("#u95_input").html("");
    	  });
    	  
    	  //家庭乡
    	  $("#u93_input").change(function(){
    		  var provinceId = $("#u93_input").val();
    		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
    		  province(cityUrl,"u94_input",provinceId);
    		  $("#u95_input")[0].selectedIndex = -1;
    		  $("#u95_input").html("");
    	  }); 
    	 
    	  //家庭村
    	  $("#u94_input").change(function(){
    		  var provinceId = $("#u94_input").val();
    		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
    		  province(cityUrl,"u95_input",provinceId);
    	  });
    	  
    	  //户口省份
    	 province(provinceUrl,"u30_input",null);
    		  
    	  //户口市
    	  $("#u30_input").change(function(){
    		  var provinceId = $("#u30_input").val();
    		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
    		  province(cityUrl,"u71_input",provinceId);
     		  $("#u72_input")[0].selectedIndex = -1;
     		  $("#u73_input")[0].selectedIndex = -1;
			  $("#u74_input")[0].selectedIndex = -1;
			  $("#u72_input").html("");
			  $("#u73_input").html("");
			  $("#u74_input").html("");
    	  });
    	  
    	  //户口县
    	  $("#u71_input").change(function(){
    		  var provinceId = $("#u71_input").val();
    		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
    		  province(cityUrl,"u72_input",provinceId);
     		  $("#u73_input")[0].selectedIndex = -1;
    		  $("#u74_input")[0].selectedIndex = -1;
    		  $("#u73_input").html("");
			  $("#u74_input").html("");
    	  });
    	  
    	  //户口乡
    	  $("#u72_input").change(function(){
    		  var provinceId = $("#u72_input").val();
    		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
    		  province(cityUrl,"u73_input",provinceId);
    		  $("#u74_input")[0].selectedIndex = -1;
    		  $("#u74_input").html("");
    	  });
    	
    	  //户口村
    	  $("#u73_input").change(function(){
    		  var provinceId = $("#u73_input").val();
    		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
    		  province(cityUrl,"u74_input",provinceId);
    	  });
    	  
    	  var build = 0;
    	  //点击建档完成后通过性别判断进入哪个方法
    	  $("#build").click(function(){
    		  
    		  if(build != 0){
    			  return false;
    		  }
    		  
    		  var name = $("#u19_input").val();
    		  var tag1 = /[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/;
    		  if(name == "" || name == null){
    			  alert("请输入名字！");
    			  return false;
    		  }
    		  if(!tag1.test(name)){
    			  alert("请输入正确的名字格式！");
    			  return false;
    		  }
    		  var sex = $("#u18_input").val();
    		  if(sex == "" || sex == null){
    			  alert("请选择性别！");
    			  return false;
    		  }
    		  var gen = $("#u22_input").val();
    		  if(gen == "" || gen == null){
    			  alert("请选择国籍！");
    			  return false;
    		  }
    		  var nation = $("#u59_input").val();
    		  
    		  if(nation == "" || nation == null ){
    			  alert("请选择民族！");
    			  return false;
    		  }
    		 /*  var tag2 = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X|x)$/;
    		  var idNo = $("#u27_input").val();
    		  if(idNo == "" || idNo == null){
    			  alert("请输入身份证号！");
    			  return false ;
    		  }
    		  if(!tag2.test(idNo)){
    			  alert("请输入正确的身份证号码！");
    			  return false;
    		  } */
    		  
    		  var birthday = $("#bigenTime").val();
    		  if(birthday == "" || birthday == null ){
    			  alert("请选择出生日期！");
    			  return false;
    		  }
    		  var age = $("#age").val();
    		  if(age == "" || age == null){
    			  alert("年龄不能为空！");
    			  return false;
    		  }
    		  
    		  var edu = $("#u39_input").val();
    		  if(edu == "" || edu == null){
    			  alert("请选择文化程度！");
    			  return false;
    		  }
    		  
    		  var hosType = $("#u62_input").val();
    		  if(hosType == "" || hosType == null){
    			  alert("请选择户籍类型！");
    			  return false;
    		  }
    		  
    		  var accType = $("#u65_input").val();
    		  if(accType == "" || accType == null){
    			  alert("请选择户口类型！");
    			  return false;
    		  }
    		  var occu = $("#u33_input").val();
    		  
    		  if(occu == "" || occu == null){
    			  alert("请选择职业！");
    			  return false;
    		  }
    		  
    		  var workUnit = $("#u38_input").val();
    		  workUnit = $.trim(workUnit);
    		  if(occu != 0){
	    		  if(workUnit == "" || workUnit == null){
	    			  alert("请输入工作单位！");
	    			  return false;
	    		  }
    		  }
    		  
    		  var accP = $("#u30_input").val();
    		  if(accP == "" || accP == null){
    			  alert("请选择户口省！");
    			  return false;
    		  }
    		  var accC = $("#u71_input").val();
    		  if(accC == "" || accC == null){
    			  alert("请选择户口市！");
    			  return false;
    		  }
    		  var accT = $("#u72_input").val();
    		  if(accT == "" || accT == null){
    			  alert("请选择户口县(区)！");
    			  return false;
    		  }
    		  var accS = $("#u73_input").val();
    		  if(accS == "" || accS == null){
    			  alert("请选择户口乡(街道)！");
    			  return false;
    		  }
    		  var accV = $("#u74_input").val();
     		  if(accV == "" || accV == null){
     			  alert("请选择户口村！");
     			  return false;
    		  }
    		  
    		  var homeP = $("#u80_input").val();
    		  if(homeP == "" || homeP == null){
    			  alert("请选择家庭省！");
    			  return false;
    		  }
    		  var homeC = $("#u92_input").val();
    		  if(homeC == "" || homeC == null){
    			  alert("请选择家庭市！");
    			  return false;
    		  }
    		  var homeT = $("#u93_input").val();
    		  if(homeT == "" || homeT == null){
    			  alert("请选择家庭县(区)！");
    			  return false;
    		  }
    		  var homeS = $("#u94_input").val();
    		  if(homeS == "" || homeS == null){
    			  alert("请选择家庭乡(街道)！");
    			  return false;
    		  }
    		  var homeV = $("#u95_input").val();
     		  if(homeV == "" || homeV == null){
    			  alert("请选择家庭村！");
    			  return false;
    		  }
    		  
    		  var tag3 = /^1[34578]\d{9}$/;
    		  var telephone = $("#u118_input").val();
    		  //alert(telephone);
    		  if(telephone == "" || telephone == null){
    			  alert("请输入联系电话！");
    			  return false;
    		  }
    		  if(!tag3.test(telephone)){
    			  alert("请输入正确联系电话格式！");
    			  return false;
    		  }
    		  
    		  var manName = $("#u98_input").val();
    		  if(manName == "" || manName == null){
    			  alert("请输入对方姓名！");
    			  return false;
    		  }
    		  if(!tag1.test(manName)){
    			  alert("请输入格式正确的对方姓名！");
    			  return false;
    		  }
    		  
    		  /* var manId = $("#u101_input").val();
    		  if(manId == "" || manId == null){
    			  alert("请输入对方身份证号！");
    			  return false;
    		  }
    		  if(!tag2.test(manId)){
    			  alert("请输入格式正确的对方身份证号！");
    			  return false;
    		  }
    		  if(idNo == manId){
    			  alert("两人身份证号不能相同！");
    			  return false;
    		  } */
    		  var manTel = $("#u104_input").val();
    		  if(manTel == "" || manTel == null){
    			  alert("请输入对方联系电话！");
    			  return false;
    		  }
    		  if(!tag3.test(manTel)){
    			  alert("请输入格式正确的对方联系电话！");
    			  return false;
    		  }
    		  
    		  if(sex == "1"){
    			  var tag4 = /^[0-9]{19}$/;
    			  var archivesCode = $("#archivesCode").val();
    			  if(archivesCode == "" || archivesCode == null){
    				  alert("请输入档案编号！");
    			  }
    			  if(!tag4.test(archivesCode)){
    				  alert("请输入正确的档案编号！");
    			  }
    		  }
    		  var grant = $("#u105_input").val();
    		  if(grant == null || grant == undefined){
    			  $("#grantSign").attr("name","grantSign");
    		  }
    		 
    		  var womanUrl = "${ctx}/archivesinfo/woman";
    		  var manUrl = "${ctx}/archivesinfo/man";
    		  
    		  if($("#u18_input").val() == "0"){
    			  $.ajax({
    					url:womanUrl,
    					type:"POST",
    					data:$('#from').serialize(),
    					success:function(data){
    						$("#archivesId").val(data.map.archives.id);
    						$("#premaritalId").val(data.map.premId);
    	 					
    	 					if(data.map.archives.archivesCode != null){
    	 						$("#archivesNum").html("档案编号:"+data.map.archives.archivesCode);
    	 					}else if(data.map.archives.archivesCode == null || data.map.archives.archivesCode == ""){
    	 						$("#u09").html("建档失败！");
    	 					}
    	 					showDialog_("提示","addOrUpdateWin","moremiddleOver",false);
    					}
    				});
    		  	
    		  }
    		  if($("#u18_input").val() == "1"){
    			  var archivesCode = $.trim($("#archivesCode").val());
    			  if(archivesCode == ""){
    				  alert("请输入档案号！");
    				  return false;
    			  }
    			  $.ajax({
  					url:manUrl,
  					type:"POST",
  					data:$('#from').serialize(),
  					success:function(data){
  						if(data.msg){
  	 						$("#archivesNum").html("档案编号:"+data.archives.archivesCode);
  						}else{
  							$("#u09").html("建档失败！");
  						}
  						showDialog_("提示","addOrUpdateWin","moremiddleOver",false);
  					}
  				});
  		  		
    		  }
    		  build ++;
    	  });
    	  
    	  //通过出生日期选择计算年龄
    	  $("#bigenTime").blur(function(){
    		  var birthday = this.value;
    		  var nowdate = new Date();
    		  var age = nowdate.getFullYear() - birthday.substr(0,4);
    		  if(age >100 || age <0){
    			  $("#age").val("");
    		  }else{
    		  	$("#age").val(age);
    		  }
    	  });
    	  
    	  
    	  
    	  //当性别改变时，触发以下判断
    	  $("#u18_input").change(function(){
    		  
    		  var sex = this.value;
    		  if(sex == "0"){
    			  $("#archivesCode").val("");
    			  $("#archivesCode")[0].readOnly = true;
    			  $("#u98_input").val("");
				  $("#u101_input").val("");
				  $("#u104_input").val("");
				  //$("#u19_input").val("");
				  $("#u27_input").val("");
				  $("#u118_input").val("");
    		  }else if(sex == "1"){
    			  if($("#archivesCode").val() == ""){
    				  alert("请输入档案编号");
    				  
    				  $("#archivesCode")[0].readOnly = false;
    				  document.getElementById("archivesCode").focus();
    			  }
    		  }
    	  });
    	  
    	  //当输入档案编号的时候性别为男，补全女方的信息
    	  $("#archivesCode").change(function(){
    		  var tag5 = /^[0-9]{19}$/;
			  var archivesCode = $("#archivesCode").val();
			  if(!tag5.test(archivesCode)){
				  alert("请输入正确格式的档案编号！");
				  return false;
			  }
    		  var selectUrl = "${ctx}/archivesinfo/selectWoman";
    		  var archivesCode = $.trim($("#archivesCode").val());
    		  $("#u18_input").val("1");
    		  $.ajax({
					//dataType:'json',
					url:selectUrl,
					type:"GET",
					data:{archivesCode:archivesCode},
					success:function(data){
						if(data != null){
							$("#u19_input").val(data.archivesInfoPO.manName);
							$("#u27_input").val(data.archivesInfoPO.manIdNo);
							$("#u118_input").val(data.archivesInfoPO.manTele);
		 					$("#u98_input").val(data.archivesInfoPO.name);
		 					$("#u101_input").val(data.archivesInfoPO.idNo);
		 					$("#u104_input").val(data.archivesInfoPO.telephone);
		 					$("#archivesId").val(data.archivesInfoPO.id);
						} else {
							alert("请先为女性建档！");
							return false;
						}
					}
				});
    	  });
    	  //进入婚检
    	  $("#intoCheck").click(function(){
    		  var id = $("#archivesId").val();
    		  var sex = $("#u18_input").val();
    		  var premId = $("#premaritalId").val();
    		  var manCheckUrl = "${ctx}/premaritalexainfo/manAdd?id="+id;
    		  var womanCheckUrl = "${ctx}/premaritalexainfo/toAdd?id="+id+"&premaritalId="+premId;
    		  if(sex == "0"){
    			  window.location.href = womanCheckUrl;
    		  }
    		  if(sex == "1"){
    			  window.location.href = manCheckUrl;
    		  }
    		  
    	  });
    	  //完成
		  $("#finish").click(function(){
    		  var sex = $("#u18_input").val();
    		  var manFinishUrl = "${ctx}/archivesinfo/manList";
    		  var womanFinishUrl = "${ctx}/archivesinfo/list";
    		  if(sex == "0"){
    			  window.location.href = womanFinishUrl;
    		  }
    		  if(sex == "1"){
    			  window.location.href = manFinishUrl;
    		  }
    		  
    	  });
    	  
    	  //同上功能
    	  $("#u76").click(function(){
    		  $("#u80_input").html($("#u30_input").html());
    		  if($("#u30_input").val() != null){
    			  $("#u80_input").val($("#u30_input").val());
    		  }else{
    			  $("#u80_input")[0].selectedIndex = -1;
    		  }
    		  $("#u92_input").html($("#u71_input").html());
    		  if($("#u71_input").val() != null){
    			  $("#u92_input").val($("#u71_input").val());
    		  }else{
    			  $("#u92_input")[0].selectedIndex = -1;
    		  }
    		  $("#u93_input").html($("#u72_input").html());
    		  if($("#u72_input").val() != null){
    			  $("#u93_input").val($("#u72_input").val());
    		  }else{
    			  $("#u93_input")[0].selectedIndex = -1;
    		  }
    		  $("#u94_input").html($("#u73_input").html());
    		  if($("#u73_input").val() != null){
    			  $("#u94_input").val($("#u73_input").val());
    		  }else{
    			  $("#u94_input")[0].selectedIndex = -1;
    		  }
    		  $("#u95_input").html($("#u74_input").html());
    		  if($("#u74_input").val() != null){
    			  $("#u95_input").val($("#u74_input").val());
    		  }else{
    			  $("#u95_input")[0].selectedIndex = -1;
    		  }
    		  $("#u81_input").val($("#u40_input").val());
    		  
    	  });
      });
      //如果叶酸发放为否，改变叶酸发放数量为0，状态为只读，不能修改	
      function only(){
    		if($("#u106_input").val()=="0"){
    			$("#u107_input").val("0");
    			$("#u107_input")[0].readOnly = true;
    		}else{
    			$("#u107_input").val("");
    			$("#u107_input")[0].readOnly = false;
    		}
    	};
   	
      </script>
</head>
<body style="border: 0px solid;">
    <div id="base" class="">
	
	  <form id="from" action="" method="post">
	  
	  <div id="title">
	      <!-- Unnamed (形状) -->
	      <div id="u4" class="ax_文本段落">
	          <p id="u5"><span>档案编号：<input style="border: 1px solid #CCCCCC;position: absolute;top: -3px;" id="archivesCode" type="text" name="archivesCode" value=""></span></p>
	      </div>
			<input id="archivesId" type="hidden" name="id" value=""/>
			<input id="premaritalId" type="hidden" value=""/>
	      <!-- Unnamed (形状) -->
	      <div id="u6" class="ax_文本段落">
	          <input type="hidden" name="createTime" value="${time }">
	          <p id="u7"><span>建档日期：${time }</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u8" class="ax_文本段落">
	          <p id="u9"><span>建档医院：${operator.department }</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u10" class="ax_文本段落">
	          <p id="u11"><span>建档医生：${operator.realName }</span></p>
	      </div>
	      
	  </div>
      <!-- Unnamed (形状) -->
      <div id="u112" class="ax_形状" style="background-color:#EE5F45">
          <p id="u113"><span>基本信息</span></p>
      </div>
      
      <div id="baseConfig">
      	<div id="u2" class="ax_形状" style=" border:1px solid;border-color: #CCCCCC;">
        <!-- Unnamed () -->
        <div id="u3" class="text">
        </div>
      </div>
      <div id="u14" class="ax_文本段落">
        
          <p id="u15"><span>姓&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;名 ：</span></p>
      </div>
      <div id="u19" class="ax_文本框">
        <input id="u19_input" type="text" name="name" value="" placeholder="姓名"/>
      </div>
      
      <div id="u16" class="ax_文本段落">
          <p id="u17">性&nbsp;&nbsp; &nbsp;&nbsp;别：</p>
      </div>

      <!-- 性别 (下拉列表框) -->
      <div id="u18" class="ax_下拉列表框">
        <select id="u18_input" name="sex" data-label="性别">
          <option selected value="0">女</option>
          <option value="1">男</option>
          <option value="2">性别不明</option>
        </select>
      </div>
      <div id="u20" class="ax_文本段落">
          <p id="u21"><span>国&nbsp;&nbsp;&nbsp;&nbsp;籍：</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u22" class="ax_下拉列表框">
        <select id="u22_input" name="international">
          <option selected value="0">中国</option>
          <option value="1">外国</option>
        </select>
      </div>
		
        <div id="u57" class="ax_文本段落">
          <p id="u58"><span>民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族 ：</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u59" class="ax_下拉列表框">
        <select id="u59_input" name="nation">
          <option value="汉">汉</option>
          <option value="回">回</option>
          <option value="其他">其他</option>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u25" class="ax_文本段落">
          <p id="u26"><span>身份证号</span><span>：</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u27" class="ax_文本框">
        <input id="u27_input" name="idNo" type="text" placeholder="18位身份证号码" value=""/>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u68" class="ax_文本段落">
          <p id="u69"><span>出生日期</span><span></span><span>：</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u70" class="ax_文本框">
        <input type="text" id="bigenTime" name="birthday"
        style="color:#333333;cursor:pointer;width:145px; height: 25px;border-style: solid;border-width: 1px;border-color: #c8c9cd;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
      </div>
      
      <div id="u23" class="ax_文本段落">
          <p id="u24"><span>年&nbsp;&nbsp;&nbsp;&nbsp;龄</span>：<input id="age" type="text" style="position:absolute;width:45px;left:69px;top:-4px;height: 25px;border-color: #c8c9cd;border-style: solid;border-width: 1px;" value=""><span style="position:absolute;left:117px;top:2px;">岁</span></p>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u34" class="ax_文本段落">
          <p id="u35"><span>文化程度：</span></p>
      </div>
      <div id="u39" class="ax_下拉列表框">
        <select id="u39_input" name="education">
          <option value="9">不详</option>
          <option selected value="2">高中</option>
          <option value="0">小学</option>
          <option value="1">初中</option>
          <option value="3">技校</option>
          <option value="4">专科</option>
          <option value="5">本科</option>
          <option value="6">研究生</option>
          <option value="7">博士</option>
          <option value="8">无</option>
        </select>
      </div>
      
      <div id="u60" class="ax_文本段落">
          <p id="u61"><span>户籍类型</span><span>：</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u62" class="ax_下拉列表框">
        <select id="u62_input" name="householdType">
          <option selected value="0">本地</option>
          <option value="1">外地</option>
        </select>
      </div>
      
      <div id="u63" class="ax_文本段落">
          <p id="u64"><span>户口</span><span>类型</span><span>：</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u65" class="ax_下拉列表框">
        <select id="u65_input" name="accountType">
          <option value="1">非农户籍</option>
          <option value="0">农业户籍</option>
        </select>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u31" class="ax_文本段落">
          <p id="u32"><span>职&nbsp;&nbsp;&nbsp;&nbsp;业：</span></p>
      </div>

      <!-- Unnamed (下拉列表框) -->
      <div id="u33" class="ax_下拉列表框">
        <select id="u33_input" name="occupation">
          <option value="0">无</option>
          <option value="1">事业单位</option>
          <option value="2">企业</option>
          <option value="3">服务业</option>
          <option value="4">制造业</option>
          <option value="5">农业</option>
          <option value="6">其他</option>
        </select>
      </div>
      
       <!-- Unnamed (形状) -->
      <div id="u36" class="ax_文本段落">
          <p id="u37"><span>工作单位</span><span>：</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u38" class="ax_文本框">
        <input id="u38_input" type="text" name="workUnit" placeholder="工作单位" value=""/>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u28" class="ax_文本段落">
          <p id="u29"><span>户口地址</span><span>：</span></p>
      </div>
      <div id="u30" class="ax_下拉列表框">
        <select id="u30_input" name="accProvinceId">
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u41" class="ax_文本段落">
          <p id="u42"><span>省</span></p>
      </div>
      
      <!-- Unnamed (下拉列表框) -->
      <div id="u71" class="ax_下拉列表框">
        <select id="u71_input" name="accCityId">
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u43" class="ax_文本段落">
          <p id="u44"><span>市</span></p>
      </div>
      <!-- Unnamed (下拉列表框) -->
      <div id="u72" class="ax_下拉列表框">
        <select id="u72_input" name="accCountyId">          
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u45" class="ax_文本段落">
          <p id="u46"><span>县（区）</span></p>
      </div>
      <!-- Unnamed (下拉列表框) -->
      <div id="u73" class="ax_下拉列表框">
        <select id="u73_input" name="accTownshipId">          
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u47" class="ax_文本段落">
          <p id="u48"><span>乡（街道）</span></p>
      </div>
	  <!-- Unnamed (下拉列表框) -->
      <div id="u74" class="ax_下拉列表框">
        <select id="u74_input" name="accVillageId">          
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u49" class="ax_文本段落">
          <p id="u50"><span>村</span></p>
      </div>
      <!-- Unnamed (文本框) -->
      <div id="u40" class="ax_文本框">
        <input id="u40_input" name="accAddress" type="text" placeholder="非必填项" value=""/>
      </div>
      
      <div id="u66" class="ax_文本段落">
          <p id="u67"><span>家庭地址：</span></p>
      </div>
	  <!-- Unnamed (下拉列表框) -->
      <div id="u80" class="ax_下拉列表框">
        <select id="u80_input" name="homeProvinceId">
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u82" class="ax_文本段落">
          <p id="u83"><span>省</span></p>
      </div>
      <!-- Unnamed (下拉列表框) -->
      <div id="u92" class="ax_下拉列表框">
        <select id="u92_input" name="homeCityId">
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u84" class="ax_文本段落">
          <p id="u85"><span>市</span></p>
      </div>
      <!-- Unnamed (下拉列表框) -->
      <div id="u93" class="ax_下拉列表框">
        <select id="u93_input" name="homeCountyId">
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u86" class="ax_文本段落">
          <p id="u87"><span>县（区）</span></p>
      </div>
       <!-- Unnamed (下拉列表框) -->
      <div id="u94" class="ax_下拉列表框">
        <select id="u94_input" name="homeTownshipId">         
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u88" class="ax_文本段落">
          <p id="u89"><span>乡（街道）</span></p>
      </div>
      <!-- Unnamed (下拉列表框) -->
      <div id="u95" class="ax_下拉列表框">
        <select id="u95_input" name="homeVillageId">          
        </select>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u90" class="ax_文本段落">
          <p id="u91"><span>村</span></p>
      </div>
      <!-- Unnamed (文本框) -->
      <div id="u81" class="ax_文本框">
        <input id="u81_input" name="homeAddress" type="text" placeholder="非必填项" value=""/>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u75" class="ax_文本段落">
          <p id="u76" style="cursor: pointer;"><span>同上</span></p>
      </div>
       <!-- Unnamed (形状) -->
      <div id="u116" class="ax_文本段落">
          <p id="u117"><span>联系</span><span>电话</span><span></span><span>：</span></p>
      </div>
      <div id="u118" class="ax_文本框">
      <span class="ax_文本框">
      	  <input id="u118_input" type="text" name="telephone" placeholder="11位手机号" value=""/>
      	</span>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u77" class="ax_文本段落">
          <p id="u78"><span>紧急电话</span><span></span><span>：</span></p>
      </div>
      <!-- Unnamed (文本框) -->
      <div id="u79" class="ax_文本框">
        <input id="u79_input" name="urgentCall" type="text" placeholder="非必填项" value=""/>
      </div>
      
     </div>
     
     <!-- Unnamed (形状) -->
      <div id="u110" class="ax_形状" style="background-color:#EE5F45"><!-- Unnamed () -->
          <p id="u111"><span>对方信息</span></p>
      </div>
	 <div id="ortherMessage">
   
      <!-- Unnamed (形状) -->
      <div id="u12" class="ax_形状" style="border:1px solid;border-color: #CCCCCC;">
        <div id="u13" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u96" class="ax_文本段落">
          <p id="u97"><span>对方</span><span>姓名</span><span>：</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u98" class="ax_文本框">
        <input id="u98_input" name="manName" type="text" placeholder="姓名" value=""/>
      </div>
      <!-- Unnamed (形状) -->
      <div id="u99" class="ax_文本段落">
          <p id="u100"><span>身份证号</span><span>：</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u101" class="ax_文本框">
        <input id="u101_input" name="manIdNo" type="text" placeholder="18位身份证号码" value=""/>
      </div>
      
      <div id="u102" class="ax_文本段落">
          <p id="u103"><span>联系电话：</span></p>
      </div>

      <!-- Unnamed (文本框) -->
      <div id="u104" class="ax_文本框">
        <input id="u104_input" name="manTele" type="text" placeholder="11位手机号" value=""/>
      </div>
      
	 </div>
     
     <!-- Unnamed (形状) -->
      <div id="u108" class="ax_形状" style="background-color:#EE5F45">
          <p id="u109"><span>其他信息</span></p>
      </div>
      
	<div id="anotherMessage">
    	<!-- Unnamed (形状) -->
      <div id="u0" class="ax_形状" style="border:1px solid;border-color: #CCCCCC;">
        <div id="u1" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>
      
       <!-- Unnamed (形状) -->
      <div id="u51" class="ax_文本段落">
          <p id="u52"><span>母子健康手册发放</span><span>：</span></p>
      </div>
		<!-- Unnamed (下拉列表框) -->
      <div id="u105" class="ax_下拉列表框">
      	<input  type="hidden" value="" id="grantSign"/>
        <select id="u105_input" name="grantSign">
          <option value="1">是</option>
          <option value="0">否</option>
        </select>
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u53" class="ax_文本段落">
          <p id="u54"><span>叶酸发放</span><span>：</span></p>
      </div>
      <!-- Unnamed (下拉列表框) -->
      <div id="u106" class="ax_下拉列表框">
        <select id="u106_input" onchange="only()">
          <option value="-1">是</option>
          <option value="0">否</option>
        </select>
      </div>
      
      <div id="u55" class="ax_文本段落">
          <p id="u56"><span>发放</span><span>数量</span><span>：</span><span>&nbsp;</span><span>&nbsp; &nbsp; </span><span>&nbsp; &nbsp; &nbsp; </span><span>&nbsp; &nbsp; &nbsp;&nbsp; </span><span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; </span><span>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; </span><span>&nbsp;</span><span>&nbsp;</span><span></span></p>
      </div>
      <!-- Unnamed (文本框) -->
      <div id="u107" class="ax_文本框">
        <input id="u107_input" name="frantNum" type="text" placeholder="填写数量" value=""/>
      </div>
    
    </div>

      <div id="u114" class="ax_形状" style="background-color:#009DD9">
          <p id="u115"><span id="build" style="cursor:pointer">确认建档</span></p>
      </div>
    </form>
  </div>
    <div id="addOrUpdateWin" class="easyui-dialog" title="角色" closed="true">
				<!-- Unnamed (形状) -->
	      <div id="u00" class="ax_形状">
	        <div id="u1" class="text">
	          <p><span>&nbsp;</span></p>
	        </div>
	      </div>
	
	      <!-- <div id="u02" class="ax_形状" style="background-color:#F30">
	          <p id="u03"><span>提&nbsp; &nbsp; 示</span></p>
	      </div> -->
	
	      <!-- Unnamed (形状) -->
      <div id="u04" class="ax_形状" style="background-color:#06F">
	          <p id="u05"><span id="intoCheck" style="cursor:pointer">进入婚检</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u06" class="ax_形状" style="background-color:#F00">
	          <p id="u07"><span id="finish" style="cursor:pointer">完成</span></p>
	      </div>
	
	      <!-- Unnamed (形状) -->
	      <div id="u08" class="ax_文本段落">
	          <p id="u09"><span>建档成功！&nbsp;</span></p>&nbsp;<p><span id="archivesNum">档案编号：</span></p>
      	  </div>
      </div>
      
  </body>
</html>