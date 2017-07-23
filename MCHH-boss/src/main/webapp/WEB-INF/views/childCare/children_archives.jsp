<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>儿童建档页</title>
    <style type="text/css">
    	#u0_ {
		  position:absolute;
		  left:1px;
		  top:34px;
		  width:719px;
		  height:346px;
		}
		#u1_ {
		  position:absolute;
		  left:2px;
		  top:165px;
		  width:715px;
		  visibility:hidden;
		  word-wrap:break-word;
		}
		#u2_ {
			position: absolute;
			left: 204px;
			top: 103px;
			width: 374px;
			height: 79px;
			font-size: 16px;
			color: #000000;
			text-align: center;
		}
		#u3_ {
			position: absolute;
			left: 0px;
			top: 1px;
			width: 374px;
			white-space: nowrap;
			height: 22px;
		}
		#u2_0 {
			position: absolute;
			left: 184px;
			top: 143px;
			width: 374px;
			height: 79px;
			font-size: 16px;
			color: #000000;
			text-align: center;
		}
		#u3_0 {
			position: absolute;
			left: 0px;
			top: 1px;
			width: 374px;
			white-space: nowrap;
			height: 22px;
		}
		#u4_ {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u5_ {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u6_ {
			position: absolute;
			left: 89px;
			top: 228px;
			width: 120px;
			height: 43px;
			font-family: 'Arial Negreta', 'Arial';
			font-weight: 700;
			color: #FFFFFF;
		}
		#u7_ {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u8_ {
			position: absolute;
			left: 331px;
			top: 232px;
			width: 120px;
			height: 44px;
			font-family: 'Arial Negreta', 'Arial';
			font-weight: 700;
			color: #FFFFFF;
		}
		#u9_ {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u10_ {
			position: absolute;
			left: 504px;
			top: 232px;
			width: 118px;
			height: 44px;
			font-family: 'Arial Negreta', 'Arial';
			font-weight: 700;
			color: #FFFFFF;
		}
		#u11_ {
			position: absolute;
			left: 0px;
			top: 15px;
			width: 116px;
			word-wrap: break-word;
		}
		#u12_ {
			position: absolute;
			left: 159px;
			top: 232px;
			width: 120px;
			height: 44px;
			font-family: 'Arial Negreta', 'Arial';
			font-weight: 700;
			color: #FFFFFF;
		}
		#u13_ {
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
    <link href="${ctx}/static/css/child_jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/child_axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/child_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/child_archives_styles.css" type="text/css" rel="stylesheet"/>
 <script type="text/javascript">
 	
 	$(function(){
 		for(var i = 0; i<23; i ++){
    		  
    	  	$("select")[i].selectedIndex = -1;  	  
    	}
 		
 		var provinceUrl = "${ctx}/config/provinceInfo/all";
		
		//家庭省份
		province(provinceUrl,"u38",null);
  	  
  	  //家庭市
  	  $("#u38").change(function(){
  		  var provinceId = $("#u38").val();
  		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
  		  province(cityUrl,"u50",provinceId);
      	  $("#u51")[0].selectedIndex = -1;
  		  $("#u52")[0].selectedIndex = -1;
  		  $("#u53")[0].selectedIndex = -1;
  		  $("#u51").html("");
  		  $("#u52").html("");
  		  $("#u53").html("");
  	  });
  	  
  	  //家庭县
  	  $("#u50").change(function(){
  		  var provinceId = $("#u50").val();
  		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
  		  province(cityUrl,"u51",provinceId);
  		  $("#u52")[0].selectedIndex = -1;
  		  $("#u53")[0].selectedIndex = -1;
  		  $("#u52").html("");
  		  $("#u53").html("");
  	  });
  	  
  	  //家庭乡
  	  $("#u51").change(function(){
  		  var provinceId = $("#u51").val();
  		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
  		  province(cityUrl,"u52",provinceId);
  		  $("#u53")[0].selectedIndex = -1;
  		  $("#u53").html("");
  	  }); 
  	 
  	  //家庭村
  	  $("#u52").change(function(){
  		  var provinceId = $("#u52").val();
  		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
  		  province(cityUrl,"u53",provinceId);
  	  });
  	  
  	  //户口省份
  	 province(provinceUrl,"u18",null);
  		  
  	  //户口市
  	  $("#u18").change(function(){
  		  var provinceId = $("#u18").val();
  		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
  		  province(cityUrl,"u32",provinceId);
  		  $("#u33")[0].selectedIndex = -1;
  		  $("#u34")[0].selectedIndex = -1;
  		  $("#u35")[0].selectedIndex = -1;
  		  $("#u33").html("");
  		  $("#u34").html("");
  		  $("#u35").html("");
  	  });
  	  
  	  //户口县
  	  $("#u32").change(function(){
  		  var provinceId = $("#u32").val();
  		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
  		  province(cityUrl,"u33",provinceId);
  		  $("#u34")[0].selectedIndex = -1;
  		  $("#u35")[0].selectedIndex = -1;
  		  $("#u34").html("");
  		  $("#u35").html("");
  	  });
  	  
  	  //户口乡
  	  $("#u33").change(function(){
  		  var provinceId = $("#u33").val();
  		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
  		  province(cityUrl,"u34",provinceId);
  		  $("#u34")[0].selectedIndex = -1;
  		  $("#u34").html("");
  	  });
  	
  	  //户口村
  	  $("#u34").change(function(){
  		  var provinceId = $("#u34").val();
  		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
  		  province(cityUrl,"u35",provinceId);
  	  });
 		
  		//同上功能
 		$("#u36").click(function(){
   			$("#u38").html($("#u18").html());
   			if($("#u18").val() != null){
   	  			$("#u38").val($("#u18").val());
   			}else{
   				$("#u38")[0].selectedIndex = -1;
   			}
  	  		$("#u50").html($("#u32").html());
  	  		if($("#u32").val() != null){
  	  			$("#u50").val($("#u32").val());
  	  		}else{
  	  			$("#u50")[0].selectedIndex = -1;
  	  		}
  	  		$("#u51").html($("#u33").html());
  	  		if($("#u33").val() != null){
  	  			$("#u51").val($("#u33").val());
  	  		}else{
  	  			$("#u51")[0].selectedIndex = -1;
  	  		}
  	  		$("#u52").html($("#u34").html());
  	  		if($("#u34").val() != null){
  	  			$("#u52").val($("#u34").val());
  	  		}else{
  	  			$("#u52")[0].selectedIndex = -1;
  	  		}
  	  		$("#u53").html($("#u35").html());
  	  		if($("#u35").val() != null){
  	  			$("#u53").val($("#u35").val());
  	  		}else{
  	  			$("#u53")[0].selectedIndex = -1;
  	  		}
  	  		$("#u39").val($("#u19").val());
     	});
  		
  		//出生情况选中其他时后面输入框可以录入
  		$("#u122_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u108")[0].readOnly = false;
  			}else{
  				$("#u108")[0].readOnly = true;
  			}
  		});
  		//新生儿疾病有的话让后面的输入框可以录入
  		$("#u90").change(function(){
  			if(this.value == "1"){
  				$("#u91")[0].readOnly = false;
  			}
  			if(this.value == "0"){
  				$("#u91")[0].readOnly = true;
  			}
  		});
  		//新生儿是否有畸形有的话让后面的输入框可以录入
  		$("#u99").change(function(){
  			if(this.value == "1"){
  				$("#u101")[0].readOnly = false;
  			}
  			if(this.value == "0"){
  				$("#u101")[0].readOnly = true;
  			}
  		});
  		//母亲妊娠期患病情况选中其他时后面输入框可以录入
  		$("#u128_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u100")[0].readOnly = false;
  			}else{
  				$("#u100")[0].readOnly = true;
  			}
  		});
  		//助产机构选其他的话让后面的输入框可以录入
  		$("#u104").change(function(){
  			if(this.value == "1"){
  				$("#u105")[0].readOnly = false;
  			}else{
  				$("#u105")[0].readOnly = true;
  			}
  		});
  		//妈妈信息健康状况慢性病选中后面输入框可以录入
  		$("#u195_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u159")[0].readOnly = false;
  			}else{
  				$("#u159")[0].readOnly = true;
  			}
  		});
  		//妈妈信息健康状况传染病选中后面输入框可以录入
  		$("#u197_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u199")[0].readOnly = false;
  			}else{
  				$("#u199")[0].readOnly = true;
  			}
  		});
  		//妈妈信息家庭史先天性疾病选中后面输入框可以录入
  		$("#u203_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u202")[0].readOnly = false;
  			}else{
  				$("#u202")[0].readOnly = true;
  			}
  		});
  		//妈妈信息家庭史遗传性疾病选中后面输入框可以录入
  		$("#u205_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u207")[0].readOnly = false;
  			}else{
  				$("#u207")[0].readOnly = true;
  			}
  		});
  		//爸爸信息健康状况慢性病选中后面输入框可以录入
  		$("#u215_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u210")[0].readOnly = false;
  			}else{
  				$("#u210")[0].readOnly = true;
  			}
  		});
  		//爸爸信息健康状况传染病选中后面输入框可以录入
  		$("#u217_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u219")[0].readOnly = false;
  			}else{
  				$("#u219")[0].readOnly = true;
  			}
  		});
  		//爸爸信息家庭史先天性疾病选中后面输入框可以录入
  		$("#u223_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u222")[0].readOnly = false;
  			}else{
  				$("#u222")[0].readOnly = true;
  			}
  		});
  		//爸爸信息家庭史遗传性疾病选中后面输入框可以录入
  		$("#u225_input").click(function(){
  			if($(this).attr("checked")){
  				$("#u227")[0].readOnly = false;
  			}else{
  				$("#u227")[0].readOnly = true;
  			}
  		});
  	  
  		//计算婴儿年龄
  		$("#u15").blur(function(){
  			getAge("u15","childAge");
  	    });
  		//计算妈妈年龄
  		$("#u145").blur(function(){
  			//debugger;
  			var birthday = this.value;
			var nowdate = new Date();
			var age = nowdate.getFullYear() - birthday.substr(0,4);
			if(age > 100 || age < 0){
				$("#momAge").html("");
			}else{
				$("#momAge").html(age);
			}
  		});
  		//计算爸爸年龄
  		$("#u177").blur(function(){
  			var birthday = this.value;
			var nowdate = new Date();
			var age = nowdate.getFullYear() - birthday.substr(0,4);
			if(age > 100 || age < 0){
				$("#dadAge").html("");
			}else{
				$("#dadAge").html(age);
			}
  		});
  		
  		$("#selectMam").click(function(){
  			//debugger;
  			var selectUrl = "${ctx}/childrenarchives/selectChildBirth";
  			showDialog_("查询母亲信息","detailAtv1","big",false);
  			//showDialog_URl('','detailAtv1',selectUrl,'maxBig1','zhongjianddle');
  		});
 		var build = 0;
 		//点击确认建档并返回档案号
 		$("#u229").click(function(){
 			//只能点击一次确认建档
 			if(build != 0){
 				return false;
 			}
 			var babyName = $("#u7").val();
 			var tag = /[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/;
 			if(babyName == "" || babyName == null){
 				alert("请输入儿童姓名！");
 				return false;
 			}
 			if(!tag.test(babyName)){
 				alert("请输入正确的儿童姓名格式!");
 				return false;
 			}
 			var babySex = $("#u6").val();
 			if(babySex == null || babySex == ""){
 				alert("请选择儿童性别！");
 				return false;
 			}
 			var babyBirth = $("#u15").val();
 			if(babyBirth == null || babyBirth == ""){
 				alert("请输入或选择儿童出生日期！");
 				return false;
 			}
 			var birthWeek = $("#u59").val();
 			var tag1 = /[\d|A-z|\u4E00-\u9FFF]+/;
 			if(birthWeek == "" || birthWeek == null){
 				alert("请输入出生孕周！");
 				return false;
 			}
 			if(!tag1.test(birthWeek)){
 				alert("出生孕周只能输入汉字和数字！");
 				return false;
 			}
 			var taiNo = $("#u56").val();
 			if(taiNo == "" || taiNo == null){
 				alert("请选择胎数！");
 				return false;
 			}
 			var whyTai = $("#u62").val();
 			var tag2 = /^\d{1,2}$/;
 			if(whyTai == "" || whyTai == null){
 				alert("请输入第几胎！");
 				return false;
 			}
 			if(!tag2.test(whyTai)){
 				alert("第几胎只能输入一位或两位数字！");
 				return false;
 			}
 			var whyChan = $("#u67").val();
 			if(whyChan == "" || whyChan == null){
 				alert("请输入第几产！");
 				return false;
 			}
 			if(!tag2.test(whyChan)){
 				alert("第几产只能输入一位或两位数字！");
 				return false;
 			}
 			var birthType = $("#u72").val();
 			if(birthType == "" || birthType == null){
 				alert("请选择分娩方式！");
 				return false;
 			}
 			var birthSign = $("input[name='birthCondition']:checked").val();
 			if(birthSign == null || birthSign == "" || birthSign == undefined){
 				alert("请选择出生情况！");
 				return false;
 			}
 			var weight = $("#u77").val();
 			var tag3 = /^\d+(\.\d{1,2})?$/;
 			if(weight == "" || weight == null){
 				alert("请输入出生体重！");
 				return false;
 			}
 			if(!tag3.test(weight)){
 				alert("出生体重只能输入不超过三位的数字！");
 				return false;
 			}
 			var height = $("#u80").val();
 			if(height == "" || height == null){
 				alert("请输入出生身长！");
 				return false;
 			}
 			if(!tag3.test(height)){
 				alert("出生身长只能输入不超过三位的数字！");
 				return false;
 			}
 			var zhix = $("#u87").val();
 			if(zhix == null || zhix == ""){
 				alert("请选择新生儿是否窒息！");
 				return false;
 			}
 			var apgar = $("#u94").val();
 			if(apgar == null || apgar == ""){
 				alert("请选择Apgar评分！");
 				return false;
 			}
 			if(apgar == 0){
 				var ping = $("#u109").val();
 				if(ping == null || ping == ""){
 					alert("请输入对应的评分！");
 					return false;
 				}
 			}
 			if(apgar == 1){
 				var ping = $("#u109").val();
 				if(ping == null || ping == ""){
 					alert("请输入对应的评分！");
 					return false;
 				}
 			}
 			var birthIll = $("#u90").val();
 			if(birthIll == null || birthIll == "" || birthIll == undefined){
 				alert("请选择新生儿是否有疾病！");
 				return false;
 			}
 			var isNomal = $("#u99").val();
 			if(isNomal == null || isNomal == "" || isNomal == undefined){
 				alert("请选择是否有畸形！");
 				return false;
 			}
 			var momIll = $("input[name='pregnancySickness']:checked").val();
 			if(momIll == null || momIll == undefined){
 				alert("请选择母亲母亲妊娠期患病情况!");
 				return false;
 			}
 			var liveDate = $("#u228").val();
 			if(liveDate == null || liveDate == ""){
 				alert("请选择或输入出院日期！");
 				return false;
 			}
 			var hosp = $("#u104").val();
 			if(hosp == null || hosp == ""){
 				alert("请选择助产机构！");
 				return false;
 			}
 			var homeP = $("#u18").val();
 			if(homeP == null || homeP == ""){
 				alert("请选择家庭省！");
 				return false;
 			}
 			var homeC = $("#u32").val();
 			if(homeC == null || homeC == ""){
 				alert("请选择家庭市！");
 				return false;
 			}
 			var homeT = $("#u33").val();
 			if(homeT == null || homeT == ""){
 				alert("请选择家庭县（区）！");
 				return false;
 			}
 			var homeS = $("#u34").val();
 			if(homeS == null || homeS == ""){
 				alert("请选择家庭乡（街道）！");
 				return false;
 			}
 			var homeV = $("#u35").val();
 			if(homeV == null || homeV == ""){
 				alert("请选择家庭村！");
 				return false;
 			}
 			var accP = $("#u38").val();
 			if(accP == null || accP == ""){
 				alert("请选择户口省！");
 				return false;
 			}
 			var accC = $("#u50").val();
 			if(accC == null || accC == ""){
 				alert("请选择户口市！");
 				return false;
 			}
 			var accT = $("#u51").val();
 			if(accT == null || accT == ""){
 				alert("请选择户口县（区）！");
 				return false;
 			}
 			var accS = $("#u52").val();
 			if(accS == null || accS == ""){
 				alert("请选择户口乡（街道）！");
 				return false;
 			}
 			var accV = $("#u53").val();
 			if(accV == null || accV == ""){
 				alert("请选择户口村！");
 				return false;
 			}
 			var momName = $("#u134").val();
 			if(momName == null || momName == ""){
 				alert("请输入妈妈姓名！");
 				return flase;
 			}
 			if(!tag.test(momName)){
 				alert("请输入正确格式的妈妈姓名！");
 				return false;
 			}
 			var momBirthday = $("#u145").val();
 			if(momBirthday == null || momBirthday == ""){
 				alert("请输入或选择妈妈出生日期！");
 				return false;
 			}
 			var telephone = $("#u142").val();
 			var tag4 = /^1[34578]\d{9}$/;
 			if(telephone == null || telephone == ""){
 				alert("请输入妈妈联系电话！");
 				return false;
 			}
 			if(!tag4.test(telephone)){
 				alert("请输入格式正确的妈妈联系电话！");
 				return false;
 			}
 			var momHealth = $("input[name='momHealth']:checked").val();
 			if(momHealth == null || momHealth == undefined){
 				alert("请选择妈妈健康状况！");
 				return false;
 			}
 			var momFamHistory = $("input[name='momFamHistory']:checked").val();
 			if(momFamHistory == null || momFamHistory == undefined){
 				alert("请选择妈妈家族史！");
 				return false;
 			}

 			var dadName = $("#u166").val();
 			if(dadName == null || dadName == ""){
 				alert("请输入爸爸姓名！");
 				return flase;
 			}
 			if(!tag.test(dadName)){
 				alert("请输入正确格式的爸爸姓名！");
 				return false;
 			}
 			var dadBirthday = $("#u177").val();
 			if(momBirthday == null || momBirthday == ""){
 				alert("请输入或选择爸爸出生日期！");
 				return false;
 			}
 			var manTele = $("#u174").val();
 			var tag4 = /^1[34578]\d{9}$/;
 			if(manTele == null || manTele == ""){
 				alert("请输入爸爸联系电话！");
 				return false;
 			}
 			if(!tag4.test(manTele)){
 				alert("请输入格式正确的爸爸联系电话！");
 				return false;
 			}
 			var babHealth = $("input[name='babHealth']:checked").val();
 			if(babHealth == null || babHealth == undefined){
 				alert("请选择爸爸健康状况！");
 				return false;
 			}
 			var babFamHistory = $("input[name='babFamHistory']:checked").val();
 			if(babFamHistory == null || babFamHistory == undefined){
 				alert("请选择爸爸家族史！");
 				return false;
 			}
 			var note = $("#u233").val();
 			if(note == null || note == "" || note == undefined){
 				$("#useHelthNote").attr("name","grantSign");
 			}
 			
 			var childUrl = "${ctx}/childrenarchives/buildArchives";
  		  
 			  $.ajax({
 					url:childUrl,
 					type:"POST",
 					data:$('#form').serialize(),
 					success:function(data){
 						$("#archivesId").val(data.childrenArchives.id);
 	 					$("#childArchivesCode").html(data.childrenArchives.archivesCode);
 					}
 				});
 			
 			showDialog_("提示","addOrUpdate1","moremiddleOver",false);
 			build ++;
 		});
 		//完成
 		$("#u13_").click(function(){
 			window.location.href = "${ctx}/childrenarchives/list";
 		});
 		//进入新生儿访视
 		$("#u9_").click(function(){
 			
 		});
 		
 		//进入儿童健康检查
 		$("#u11_").click(function(){
 			
 		});
 	});
 	//计算婴儿年龄
 	function getAge(birthId,ageId){
 		//debugger;
 		var birthday = $("#"+birthId).val();
		var nowdate = new Date();
		var age =nowdate.getFullYear() - birthday.substr(0,4);
		var month =nowdate.getMonth() + 1 - birthday.substr(4,2);
		var day = nowdate.getDate() - birthday.substr(6,2);
		var birthDate = new Date(birthday.substr(0,4)+"-"+birthday.substr(4,2)+"-"+birthday.substr(6,2));
		var dayNo = parseInt((nowdate.getTime() - birthDate.getTime())/(1000*60*60*24));
		month += age*12;
		var bigMonths = [1,3,5,7,8,10,12];
		var smallMonths = [4,6,9,11];
		var big = -1;
		for(var i = 0; i < bigMonths.length; i++){
			if(nowdate.getMonth() == bigMonths[i]){
				big = 0;
			}
		}
		var small = -1;
		for(var i = 0; i < smallMonths.lengh; i ++){
			if(nowdate.getMonth() == smallMonths[i]){
				small = 0;
			}
		}
		if(age >= 3 && age < 100){
			$("#"+ageId).html(age+"岁");
		}else if(age < 3 && age >= 0){
			if(nowdate.getMonth() == 2 && nowdate.getFullYear()%4 == 0){
				if(dayNo == 29){
					$("#"+ageId).html("满月");
				}else if(dayNo < 29){
					$("#"+ageId).html(dayNo+"天");
				}else if(month == 1){
					$("#"+ageId).html("满月");
				}else if(month > 1){
					$("#"+ageId).html(month + "月");
				}
			}else if(nowdate.getMonth() == 2 && nowdate.getFullYear()%4 != 0){
				if(dayNo == 28){
					$("#"+ageId).html("满月");
				}else if(dayNo < 28){
					$("#"+ageId).html(dayNo+"天");
				}else if(month == 1){
					$("#"+ageId).html("满月");
				}else if(month > 1){
					$("#"+ageId).html(month + "月");
				}
			}else if(big == 0){
				if(dayNo == 31){
					$("#"+ageId).html("满月");
				}else if(dayNo < 31){
					$("#"+ageId).html(dayNo+"天");
				}else if(month == 1){
					$("#"+ageId).html("满月");
				}else if(month > 1){
					$("#"+ageId).html(month + "月");
				}
			}else if(small == 0){
				if(dayNo == 30){
					$("#"+ageId).html("满月");
				}else if(dayNo < 30){
					$("#"+ageId).html(dayNo+"天");
				}else if(month == 1){
					$("#"+ageId).html("满月");
				}else if(month > 1){
					$("#"+ageId).html(month + "月");
				}
			}
		}
 	};
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
 </script>
  </head>
  <body>
       
      <div id="u191" class="ax_形状">
        儿童信息
      </div>
      <div style="position: absolute;top: 17px;left: 150px;width: 250px">档案编号：</div>
      <div style="position: absolute;top: 17px;left: 420px;width: 250px">建档医院：${operator.department }</div>
      <div style="position: absolute;top: 17px;left: 650px;width: 250px">建档医生：${operator.realName }</div>
      <div style="position: absolute;top: 17px;left: 900px;width: 250px">建档日期：<fmt:formatDate value="<%=new Date() %>" pattern="yyyy年MM月dd日"/></div>
   <form action="" method="post" id="form">
    <div id="base" class="">

      <!-- Unnamed (形状) -->
      <div id="u0" class="ax_形状">
      
        <p id="u2"  class="ax_文本段落">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</p>
         
      <input id="u7" type="text" name="name" placeholder="儿童姓名" value=""/>
    

        <p id="u4" class="ax_文本段落">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</p>
                <!-- 性别 (下拉列表框) -->
        <select id="u6" data-label="性别" name="sex">
          <option value="0">女</option>
          <option value="1">男</option>
          <option value="2">性别不明</option>
        </select>


        
       <p id="u13" class="ax_文本段落">出生日期：</p>
       <!--  <input  type="date" value="根据身份证自动显示"/> -->
		<input type="text" id="u15" name="birthday" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>


<p id="u8" class="ax_文本段落">年&nbsp; &nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;<span id="childAge"></span></p>

     <p id="u10" class="ax_文本段落">身份证号：</p>
        <input id="u12" type="text" name="idNo" placeholder="18位身份证号码" value=""/>

     
      <p id="u57" class="ax_文本段落">出生孕周：</p>
        <input id="u59" type="text" name="gestationalWeek" value=""/>

<p id="u54" class="ax_文本段落">胎&nbsp; &nbsp; &nbsp; 数：</p>
        
        <select id="u56" data-label="性别" name="fetusNum">
          <option value="0">单胎</option>
          <option value="1">多胎</option>
          <option value="2">双胎</option>
        </select>
      
     <p id="u60" class="ax_文本段落">第</p>
        <input id="u62" type="text" name="whichFetus" value=""/>

      
    <p id="u63" class="ax_文本段落">胎</p>

    <p id="u65" class="ax_文本段落">第</p>
        <input id="u67" type="text" name="whichBirth" value=""/>

<p id="u68" class="ax_文本段落">产</p>

   <p id="u70" class="ax_文本段落">分娩方式：</p>
        <select id="u72" data-label="性别" name="deliveryType">
          <option value="0">顺产</option>
          <option value="1">剖宫产</option>
        </select>

      <p id="u73" class="ax_文本段落">出生情况：</p>
       <!-- Unnamed (复选框) -->
      <div id="u110" class="ax_复选框">
            <p id="u111">顺产</p>
        <input id="u110_input" name="birthCondition" type="checkbox" value="0"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u112" class="ax_复选框">
            <p id="u113">胎头吸引</p>
        <input id="u112_input" name="birthCondition" type="checkbox" value="1"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u114" class="ax_复选框">
         <p id="u115">产钳</p>
        <input id="u114_input" name="birthCondition" type="checkbox" value="2"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u116" class="ax_复选框">
            <p id="u117">剖宫产</p>
        <input id="u116_input" name="birthCondition" type="checkbox" value="3"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u118" class="ax_复选框">
        <p id="u119">臀位</p>
        <input id="u118_input" name="birthCondition" type="checkbox" value="4"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u120" class="ax_复选框">
            <p id="u121">双多胎</p>
        <input id="u120_input" name="birthCondition" type="checkbox" value="5"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u122" class="ax_复选框">
         <p id="u123">其他</p>
        <input id="u122_input" name="birthCondition" type="checkbox" value="6"/>
      </div>

        <input id="u108" name="conditionRemark" readonly="readonly" placeholder="其他" type="text" value=""/>
      
       <p id="u75" class="ax_文本段落">出生体重：</p>
        <input id="u77" type="text" name="weight" value=""/>
      
      <p id="u81" class="ax_文本段落">kg</p>
      
      <p id="u78" class="ax_文本段落">出生身长：</p>
        <input id="u80" type="text" name="height" value=""/>
        <p id="u83" class="ax_文本段落">cm</p>
           
      <p id="u85" class="ax_文本段落">新生儿窒息：</p>
        <select id="u87" data-label="性别" name="asphyxia">
          <option value="0">无</option>
          <option value="1">有</option>
        </select>

     <p id="u92" class="ax_文本段落">Apgar评分：</p>
        <select id="u94" data-label="性别" name="apgarScore">
          <option value="0">3分钟</option>
          <option value="1">5分钟</option>
          <option value="2">不详</option>
        </select>

        <input id="u109" type="text" name="apgarRemark" value=""/>

      
     <p id="u88" class="ax_文本段落">新生儿疾病：</p>
        <select id="u90" data-label="性别" name="newbornDisease">
          <option value="0">无</option>
          <option value="1">有</option>
        </select>

        <input id="u91" name="diseaseRemark" readonly="readonly" type="text" placeholder="详述" value=""/>
 
      <p id="u97" class="ax_文本段落">是否有畸形：</p>
        <select id="u99" data-label="性别" name="anomaly">
          <option value="0">无</option>
          <option value="1">有</option>
        </select>
        <input id="u101" type="text" readonly="readonly" name="anomalyRemark" placeholder="详述" value=""/>
      
      <p id="u95" class="ax_文本段落">母亲妊娠期患病情况：</p>
     
     <!-- Unnamed (复选框) -->
      <div id="u124" class="ax_复选框">
            <p id="u125"><span>糖尿病</span></p>
        <input id="u124_input" name="pregnancySickness" type="checkbox" value="0"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u126" class="ax_复选框">
            <p id="u127">妊娠期高血压</p>
        <input id="u126_input" name="pregnancySickness" type="checkbox" value="1"/>
      </div>

      <!-- Unnamed (复选框) -->
      <div id="u128" class="ax_复选框">
        <p id="u129"><span>其他</span></p>
        <input id="u128_input" name="pregnancySickness" type="checkbox" value="2"/>
      </div>

        <input id="u100" type="text" readonly="readonly" name="sicknessRemark" placeholder="详述" value=""/>
      
      <p id="u106" class="ax_文本段落">出院日期：</p>
        <!-- <input id="u228" type="date" value=""/> -->
      	<input type="text" id="u228" name="dischargeDate" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
      
      <p id="u102" class="ax_文本段落">助产机构：</p>
        <select id="u104" data-label="性别" name="institutions">
          <c:forEach items="${list }" var="department">
          	<option value="${department.id }">${department.name }</option>
          </c:forEach>
          <option selected value="1">其他 </option>
        </select>

        <input id="u105" type="text" readonly="readonly" name="institutionsRemark" placeholder="其他" value=""/>

        <p id="u16" class="ax_文本段落">户口地址：</p>

        <select id="u18" name="accProvinceId">
        </select>
       <p id="u20" class="ax_文本段落">省</p>

        <select id="u32" name="accCityId">
        </select>
      <p id="u22" class="ax_文本段落">市</p>
      
        <select id="u33" name="accCountyId">
        </select>
      <p id="u24" class="ax_文本段落">县（区）</p>

        <select id="u34" name="accTownshipId">
        </select>
      <p id="u26" class="ax_文本段落">乡（街道）</p>
      
        <select id="u35" name="accVillageId">
        </select>
       <p id="u28" class="ax_文本段落">村</p>

      <input id="u19" type="text" name="accAddress" placeholder="非必填项" value=""/>
      
     <p id="u30" class="ax_文本段落">家庭地址：</p>

        <select id="u38" name="homeProvinceId">
        </select>
        <p id="u40" class="ax_文本段落">省</p>

        <select id="u50" name="homeCityId">
        </select>
        <p id="u42" class="ax_文本段落">市</p>

        <select id="u51" name="homeCountyId">
        </select>
        <p id="u44" class="ax_文本段落">县（区）</p>

        <select id="u52" name="homeTownshipId">
        </select>
       <p id="u46" class="ax_文本段落">乡（街道）</p>

        <select id="u53" name="homeVillageId">
        </select>
        <p id="u48" class="ax_文本段落">村</p>
        
      <input id="u39" type="text" name="homeAddress" placeholder="非必填项" value=""/>

     <p id="u36" class="ax_文本段落" style="cursor: pointer;">同上</p>
      </div>

      <div id="u146" class="ax_形状">
      <span>妈妈信息</span>
      </div>

      <div id="u130" class="ax_形状">
      
       <p id="u132" class="ax_文本段落">妈妈姓名：</p>
        <input id="u134" type="text" name="momName" placeholder="妈妈姓名" value=""/>
      <div id="selectMam" style="position: absolute;left: 300px;top: 18px;width: 35px;height: 20px;cursor: pointer;background-color: #009ED7";>
      	<p style="position: absolute;top: 1px;left:4px;color: #FFFFFF">查询</p>
      </div>
      <p id="u148" class="ax_文本段落">文化程度：</p>
        <select id="u150" name="momEducation">
          <option value="9">无</option>
          <option value="0">小学</option>
          <option value="1">初中</option>
          <option value="2">高中</option>
          <option value="3">技校</option>
          <option value="4">专科</option>
          <option value="5">本科</option>
          <option value="7">博士</option>
          <option value="6">研究生</option>
          <option value="8">其他</option>
        </select>

<p id="u151" class="ax_文本段落">职&nbsp;&nbsp;&nbsp;&nbsp;业：</p>
        <select id="u153" name="momOccupation">
          <option value="0">农民</option>
          <option value="1">工人</option>
          <option value="2">经商</option>
          <option value="3">干部</option>
          <option value="4">军人</option>
          <option value="5">科技</option>
          <option value="6">医药</option>
          <option value="7">其他</option>
          <option value="8">不祥</option>
        </select>
      
      <p id="u154" class="ax_文本段落">工作单位：</p>
        <input id="u156" type="text" name="momWorkUnit" placeholder="工作单位" value=""/>
      
      <p id="u137" class="ax_文本段落">身份证号：</p>
        <input id="u139" type="text" name="momIdNo" placeholder="18位身份证号码" value=""/>

      
       <p id="u143" class="ax_文本段落">出生日期：</p>
        <!-- <input id="u145" type="date" value="根据身份证自动显示"/> -->
		<input type="text" id="u145" name="momBirthday"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
          <p id="u135" class="ax_文本段落">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;<span id="momAge"></span>岁</p>

       

    <p id="u140" class="ax_文本段落">联系电话：</p>
        <input id="u142" type="text" name="momTele" placeholder="11位手机号" value=""/>


    <p id="u157" class="ax_文本段落">健康状况：</p>
     <!-- Unnamed (复选框) -->
      <div id="u193" class="ax_复选框">
            <p id="u194">健康</p>
        <input id="u193_input" name="momHealth" type="checkbox" value="0"/>
      </div>
      
      <div id="u195" class="ax_复选框">
            <p id="u196">慢性病</p>
        <input id="u195_input" name="momHealth" type="checkbox" value="1"/>
      </div>
        <input id="u159" name="momChronicRemark" readonly="readonly" placeholder="详述" type="text" value=""/>
        
	<div id="u197" class="ax_复选框">
            <p id="u198">传染病</p>
        <input id="u197_input" name="momHealth" type="checkbox" value="2"/>
      </div>
        <input id="u199" placeholder="详述" readonly="readonly" name="momInfectiousRemark" type="text" value=""/>
 	
 	<p id="u160" class="ax_文本段落">家 族 史：</p>
      <div id="u200" class="ax_复选框">
            <p id="u201">无特殊</p>
        <input id="u200_input" name="momFamHistory" type="checkbox" value="0"/>
      </div>

      <div id="u203" class="ax_复选框">
            <p id="u204">先天性疾病</p>
        <input id="u203_input" name="momFamHistory" type="checkbox" value="1"/>
      </div>
        <input id="u202" placeholder="详述" readonly="readonly" name="momCongenitalRemark" type="text" value=""/>
     
      <div id="u205" class="ax_复选框">
            <p id="u206">遗传性疾病</p>
        <input id="u205_input" name="momFamHistory" type="checkbox" value="2"/>
      </div>
      <input id="u207" placeholder="详述" readonly="readonly" name="momHereditaryRemark" type="text" value=""/>
      
      </div>
      
      <div id="u178" class="ax_形状">
        <span>爸爸信息</span>
      </div>

      <div id="u162" class="ax_形状">
        <p id="u164" class="ax_文本段落">爸爸姓名：</p>
        <input id="u166" type="text" name="dadName" placeholder="爸爸姓名" value=""/>
      
       <p id="u180" class="ax_文本段落">文化程度：</p>
        <select id="u182" name="dadEducation">
          <option value="9">无</option>
          <option value="0">小学</option>
          <option value="1">初中</option>
          <option value="2">高中</option>
          <option value="3">技校</option>
          <option value="4">专科</option>
          <option value="5">本科</option>
          <option value="7">博士</option>
          <option value="6">研究生</option>
          <option value="8">其他 </option>
        </select>
      
       <p id="u183" class="ax_文本段落">职&nbsp;&nbsp;&nbsp;&nbsp;业：</p>
        <select id="u185" name="dadOccupation">
          <option value="0">农民</option>
          <option value="1">工人</option>
          <option value="2">经商</option>
          <option value="3">干部</option>
          <option value="4">军人</option>
          <option value="5">科技</option>
          <option value="6">医药</option>
          <option value="7">其他</option>
          <option value="8">不祥</option>
        </select>

      <p id="u186" class="ax_文本段落">工作单位：</p>
        <input id="u188" type="text" name="dadWorkUnit" placeholder="工作单位" value=""/>

     <p id="u169" class="ax_文本段落">身份证号：</p>
        <input id="u171" type="text" name="dadIdNo" placeholder="18位身份证号码" value=""/>
      
      <p id="u175" class="ax_文本段落">出生日期：</p>
        <!-- <input id="u177" type="date" value="根据身份证自动显示"/> -->
        <input type="text" id="u177" name="dadBirthday"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
        
    <p id="u167" class="ax_文本段落">年&nbsp;&nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;<span id="dadAge"></span>岁</p>

     <p id="u172" class="ax_文本段落">联系电话：</p>
        <input id="u174" type="text" name="dadTele" placeholder="11位手机号" value=""/>

     <p id="u208" class="ax_文本段落">健康状况：</p>
      <div id="u213" class="ax_复选框">
            <p id="u214">健康</p>
        <input id="u213_input" name="babHealth" type="checkbox" value="0"/>
      </div>
      <div id="u215" class="ax_复选框">
            <p id="u216">慢性病</p>
        <input id="u215_input" name="babHealth" type="checkbox" value="1"/>
      </div>
        <input id="u210" placeholder="详述" readonly="readonly" name="babChronicRemark" type="text" value=""/>
        
        <div id="u217" class="ax_复选框">
            <p id="u218">传染病</p>
        <input id="u217_input" name="babHealth" type="checkbox" value="2"/>
      </div>
        <input id="u219" placeholder="详述" readonly="readonly" name="babInfectiousRemark" type="text" value=""/>
      
      <p id="u211" class="ax_文本段落">家 族 史：</p>
      <div id="u220" class="ax_复选框">
            <p id="u221">无特殊</p>
        <input id="u220_input" name="babFamHistory" type="checkbox" value="0"/>
      </div>
   
      <div id="u223" class="ax_复选框">
            <p id="u224">先天性疾病</p>
        <input id="u223_input" name="babFamHistory" type="checkbox" value="1"/>
      </div>
        <input id="u222" placeholder="详述" readonly="readonly" name="babCongenitalRemark" type="text" value=""/>
      
      <div id="u225" class="ax_复选框">
            <p id="u226">遗传性疾病</p>
        <input id="u225_input" name="babFamHistory" type="checkbox" value="2"/>
      </div>
        <input id="u227" placeholder="详述" readonly="readonly" name="babHereditaryRemark" type="text" value=""/>
      </div>

  </div>

 <p id="u231" class="ax_文本段落">母子健康手册发放：</p>
 <div id="u229" style="cursor: pointer;" class="ax_形状">
   <span>确认建档</span>
   </div>
   <input type="hidden" value="" id="useHelthNote"/>
 <select name="grantSign" id="u233">
   <option value="1">是</option>
   <option value="0">否</option>
 </select>
</form>
    <div id="addOrUpdate1" class="easyui-dialog" title="角色" closed="true">

      <div id="u0_" class="ax_形状">
        <div id="u1_" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>

      <div id="u2_" class="ax_文本段落">
          <p id="u3_">建档成功！</p>
      </div>
      <div id="u2_0" class="ax_文本段落">
          <p id="u3_0">档案编号：<span style="font-size: 14px;" id="childArchivesCode"></span></p>
      </div>
		<input type="hidden" id="archivesId" value=""/>
      <!-- <div id="u4_" class="ax_形状" style="background-color:#EE5F45">
          <p id="u5_"><span>提&nbsp; &nbsp; 示</span></p>
      </div> -->

      <div id="u8_" class="ax_形状" style="background-color:#FC7D45">
          <p id="u9_" style="cursor:pointer"><span>进入新生儿访视</span></p>
      </div>

      <div id="u10_" class="ax_形状" style="background-color:#009ED7">
          <p id="u11_" style="cursor:pointer"><span>进入儿童健康检查</span></p>
      </div>

      <div id="u12_" class="ax_形状" style="background-color:#00A191">
          <p id="u13_" style="cursor:pointer"><span>完成</span></p>
      </div>
      
  </div>
  <script type="text/javascript">
		//debugger;
		$(function() {
			var listUrl = "${ctx}/childrenarchives/selectChildBirth";
		    	
			$.grid({id:'#dg',url:listUrl,title:"",toolbar:'#tb',
				columns:[[
                 {title:'选择',field:'ck',checkbox:true,resizable:'false',align:'center'},
                 {title:'业务来源',field:'source',width:'130', resizable:'true',align:'center'},
                 {title:'妈妈档案编号',field:'archivesCode', width:'130',resizable:'true',align:'center'},
                 {title:'妈妈姓名',field:'name',width:'130',resizable:'true',align:'center'},
                 {title:'妈妈身份证号码',field:'idNo',width:'120',resizable:'true',align:'center'},
                 {title:'儿童姓名',field:'babyName',width:'90',resizable:'true',align:'center'},
                 {title:'儿童性别',field:'babySex',width:'100',resizable:'true',align:'center',
                	 formatter:function(v){ 
                         if(v==1){
                             return "女"
                         } 
                         if(v==0){
                             return "男"
                         }
                	 } 
                 },
                 {title:'出生日期',field:'birthDate',formatter:formatDate,width : '100',resizable:'true',align:'center'},
                 {title:'分娩方式',field:'deliveryType', width : '115',resizable:'true',align:'center',
                	 formatter:function(v){ 
                         if(v==0){
                             return "剖宫产"
                         } 
                         if(v==1){
                             return "顺产"
                         }
                	 } 
                 },
                ]]
			});
			
			$("#closeWindow").click(function(){
				$("#detailAtv1").window("close");
			});
		});
		function edit(node){
			//debugger;
			if(!node){
				node = getSelected('edit');
			}
			if(node == undefined){
				return false;
			}
			$("#u134").val(node.name);
			$("#u150").val(node.education);
			$("#u153").val(node.occupation);
			$("#u156").val(node.workUnit);
			$("#u139").val(node.idNo);
			var month = (new Date(node.birthday).getMonth()+1)+"";
			if(month.length == 1){
				month = "0"+month;
			}
			var day = new Date(node.birthday).getDate()+"";
			if(day.length == 1){
				day = "0"+day;
			}
			var birthday = new Date(node.birthday).getFullYear()+""+month+""+day;
			$("#u145").val(birthday);
			var momAge = new Date().getFullYear() - new Date(node.birthday).getFullYear();
			$("#momAge").html(momAge);
			$("#u142").val(node.telephone);
			$("#u166").val(node.manName);
			$("#u182").val(node.manEducation);
			$("#u185").val(node.manOccupation);
			$("#u188").val(node.manWorkUnit);
			$("#u171").val(node.manIdNo);
			var manMonth = (new Date(node.manBirthday).getMonth()+1)+"";
			if(manMonth.length == 1){
				manMonth = "0"+manMonth;
			}
			var manDay = new Date(node.manBirthday).getDate()+"";
			if(manDay.length == 1){
				manDay = "0"+manDay;
			}
			var manBirthday = new Date(node.manBirthday).getFullYear()+""+manMonth+""+manDay;
			$("#u177").val(manBirthday);
			var dadAge = new Date().getFullYear() - new Date(node.manBirthday).getFullYear();
			$("#dadAge").html(dadAge);
			$("#u174").val(node.manTele);
			$("#detailAtv1").window("close");
		}
	</script>
  <div id="detailAtv1" class="easyui-dialog" style="overflow: hidden" title="角色" closed="true">
  	<table id="dg"></table>
		<div id="tb" style="padding:5px;height:auto;">
		 <div style="">
			 <form id="queryForm" method="post">
			 <input type="hidden" id="sign" name="sign" value=""/>
			 
			 <div style="position:relative;border: 1px solid #cccccc;height: 100px;width: 99%;">
				 <!-- <div style="background-color: #EE5F45; top:10px; color: #FFFFFF; width: 60px;height: 25px;float: left;">个案查询</div> -->
				 <!-- <div style="float: right;top:5px;"> -->
				<span style="position:absolute;left:50px ;width:90px; top:18px;height: 25px;">妈妈档案编号：</span> <input style="position:absolute;left:140px ;width:150px; top:15px;height: 25px;border: 1px solid #cccccc;" type="text" class="form-control" name="archivesCode"/>
				<span style="position:absolute;left:330px ;width:80px; top:18px;height: 25px;">妈妈姓名：</span><input style="position:absolute;left:395px ;width:90px; top:15px;height: 25px;border: 1px solid #cccccc;" class="form-control" type="text" name="name"/>
				<span style="position:absolute;left:518px ;width:90px; top:18px;height: 25px;">妈妈身份证号：</span><input style="position:absolute;left:607px ;width:180px; top:15px;height: 25px;border: 1px solid #cccccc;"  class="form-control" type="text" name="idNo"/>
				 <!-- </div> -->
				<span style="position:absolute;left:50px ;width:85px; top:60px;height: 25px;">儿 童 姓 名 ：</span> <input style="position:absolute;left:140px ;width:150px; top:58px;height: 25px;border: 1px solid #cccccc;" type="text" class="form-control" name="childName"/>
				<span style="position:absolute;left:330px ;width:80px; top:60px;height: 25px;">出生日期：</span>
				<input type="text" id="beginTime" name="beginTime" readonly
        	style="position:absolute;left:395px ;top:58px;color:#333333;width:150px;height: 25px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
        	<span style="position:absolute;left:557px ;top:60px;">—</span>
        	<input type="text" id="endTime" name="endTime" readonly
        	style="position:absolute;left:580px ;top:58px;color:#333333;width:150px;height: 25px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
				 <!-- </div> -->
      		<div style="position: absolute;left:91%;top: 60px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
      		</div>
			 </div>
			
      		<div style="position: absolute;left:50%;top: 94%;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" style="background-color: #009ED7;" onClick="edit();" id="rollBackBtn"><i class="fa fa-undo"></i>选择</a>
      		</div>
      		<div style="position: absolute;left:60%;top: 94%;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton export" style="background-color: #00BE51;" id="closeWindow"><i class="fa fa-file-text-o"></i>关闭</a>
      		</div>
			
			</form>
		
		</div>
	</div>
  	<div id="addOrUpdateAtv"></div>
	   <div id="detailAtv"></div>
  </div>
</body>
</html>
