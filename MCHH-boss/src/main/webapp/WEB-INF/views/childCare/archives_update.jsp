<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <script type="text/javascript">
 	
 	$(function(){
 		/* for(var i = 0; i<23; i ++){
    		  
    	  	$("select")[i].selectedIndex = -1;  	  
    	} */
 		
 		var provinceUrl = "${ctx}/config/provinceInfo/all";
		//debugger;
		//家庭省份
		provinces(provinceUrl,"au38","homePro");
  	  
  	  //家庭市
  	  $("#au38").change(function(){
  		  var provinceId = $("#au38").val();
  		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
  		  province(cityUrl,"au50",provinceId);
      	  $("#au51")[0].selectedIndex = -1;
  		  $("#au52")[0].selectedIndex = -1;
  		  $("#au53")[0].selectedIndex = -1;
  		  $("#au51").html("");
  		  $("#au52").html("");
  		  $("#au53").html("");
  	  });
  	  
  	  //家庭县
  	  $("#au50").change(function(){
  		  var provinceId = $("#au50").val();
  		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
  		  province(cityUrl,"au51",provinceId);
  		  $("#au52")[0].selectedIndex = -1;
  		  $("#au53")[0].selectedIndex = -1;
  		  $("#au52").html("");
  		  $("#au53").html("");
  	  });
  	  
  	  //家庭乡
  	  $("#au51").change(function(){
  		  var provinceId = $("#au51").val();
  		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
  		  province(cityUrl,"au52",provinceId);
  		  $("#au53")[0].selectedIndex = -1;
  		  $("#au53").html("");
  	  }); 
  	 
  	  //家庭村
  	  $("#au52").change(function(){
  		  var provinceId = $("#au52").val();
  		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
  		  province(cityUrl,"au53",provinceId);
  	  });
  	  
  	  //户口省份
  	 provinces(provinceUrl,"au18","accPro");
  		  
  	  //户口市
  	  $("#au18").change(function(){
  		  var provinceId = $("#au18").val();
  		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
  		  province(cityUrl,"au32",provinceId);
  		  $("#au33")[0].selectedIndex = -1;
  		  $("#au34")[0].selectedIndex = -1;
  		  $("#au35")[0].selectedIndex = -1;
  		  $("#au33").html("");
  		  $("#au34").html("");
  		  $("#au35").html("");
  	  });
  	  
  	  //户口县
  	  $("#au32").change(function(){
  		  var provinceId = $("#au32").val();
  		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
  		  province(cityUrl,"au33",provinceId);
  		  $("#au34")[0].selectedIndex = -1;
  		  $("#au35")[0].selectedIndex = -1;
  		  $("#au34").html("");
  		  $("#au35").html("");
  	  });
  	  
  	  //户口乡
  	  $("#au33").change(function(){
  		  var provinceId = $("#au33").val();
  		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
  		  province(cityUrl,"au34",provinceId);
  		  $("#au34")[0].selectedIndex = -1;
  		  $("#au34").html("");
  	  });
  	
  	  //户口村
  	  $("#au34").change(function(){
  		  var provinceId = $("#au34").val();
  		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
  		  province(cityUrl,"au35",provinceId);
  	  });
 		
  		//同上功能
 		$("#au36").click(function(){
   			$("#au38").html($("#au18").html());
   			if($("#au18").val() != null){
   	  			$("#au38").val($("#au18").val());
   			}else{
   				$("#au38")[0].selectedIndex = -1;
   			}
  	  		$("#au50").html($("#au32").html());
  	  		if($("#au32").val() != null){
  	  			$("#au50").val($("#au32").val());
  	  		}else{
  	  			$("#au50")[0].selectedIndex = -1;
  	  		}
  	  		$("#au51").html($("#au33").html());
  	  		if($("#au33").val() != null){
  	  			$("#au51").val($("#au33").val());
  	  		}else{
  	  			$("#au51")[0].selectedIndex = -1;
  	  		}
  	  		$("#au52").html($("#au34").html());
  	  		if($("#au34").val() != null){
  	  			$("#au52").val($("#au34").val());
  	  		}else{
  	  			$("#au52")[0].selectedIndex = -1;
  	  		}
  	  		$("#au53").html($("#au35").html());
  	  		if($("#au35").val() != null){
  	  			$("#au53").val($("#au35").val());
  	  		}else{
  	  			$("#au53")[0].selectedIndex = -1;
  	  		}
  	  		$("#au39").val($("#au19").val());
     	});
  		
  		//出生情况选中其他时后面输入框可以录入
  		$("#au122_input").click(function(){
  			if($(this).attr("checked")){
  				$("#au108")[0].readOnly = false;
  			}else{
  				$("#au108")[0].readOnly = true;
  			}
  		});
  		//新生儿疾病有的话让后面的输入框可以录入
  		$("#au90").change(function(){
  			if(this.value == "1"){
  				$("#au91")[0].readOnly = false;
  			}
  			if(this.value == "0"){
  				$("#au91")[0].readOnly = true;
  			}
  		});
  		//新生儿是否有畸形有的话让后面的输入框可以录入
  		$("#au99").change(function(){
  			if(this.value == "1"){
  				$("#au101")[0].readOnly = false;
  			}
  			if(this.value == "0"){
  				$("#au101")[0].readOnly = true;
  			}
  		});
  		//母亲妊娠期患病情况选中其他时后面输入框可以录入
  		$("#au128_input").click(function(){
  			if($(this).attr("checked")){
  				$("#au100")[0].readOnly = false;
  			}else{
  				$("#au100")[0].readOnly = true;
  			}
  		});
  		//助产机构选其他的话让后面的输入框可以录入
  		$("#au104").change(function(){
  			if(this.value == "1"){
  				$("#au105")[0].readOnly = false;
  			}else{
  				$("#au105")[0].readOnly = true;
  			}
  		});
  		//妈妈信息健康状况慢性病选中后面输入框可以录入
  		$("#au195_input").click(function(){
  			debugger;
  			if($(this).attr("checked")){
  				$("#au159")[0].readOnly = false;
  			}else{
  				$("#au159")[0].readOnly = true;
  			}
  		});
  		//妈妈信息健康状况传染病选中后面输入框可以录入
  		$("#au197_input").click(function(){
  			debugger;
  			if($(this).attr("checked")){
  				$("#au199")[0].readOnly = false;
  			}else{
  				$("#au199")[0].readOnly = true;
  			}
  		});
  		//妈妈信息家庭史先天性疾病选中后面输入框可以录入
  		$("#au203_input").click(function(){
  			debugger;
  			if($(this).attr("checked")){
  				alert("02");
  				$("#au202")[0].readOnly = false;
  			}else{
  				alert("03");
  				$("#au202")[0].readOnly = true;
  			}
  		});
  		//妈妈信息家庭史遗传性疾病选中后面输入框可以录入
  		$("#au205_input").click(function(){
  			debugger;
  			if($(this).attr("checked")){
  				alert("0");
  				$("#au207")[0].readOnly = false;
  			}else{
  				alert("1");
  				$("#au207")[0].readOnly = true;
  			}
  		});
  		//爸爸信息健康状况慢性病选中后面输入框可以录入
  		$("#au215_input").click(function(){
  			debugger;
  			if($(this).attr("checked")){
  				$("#au210")[0].readOnly = false;
  			}else{
  				$("#au210")[0].readOnly = true;
  			}
  		});
  		//爸爸信息健康状况传染病选中后面输入框可以录入
  		$("#au217_input").click(function(){
  			
  			if($(this).attr("checked")){
  				alert("2");
  				$("#au219")[0].readOnly = false;
  			}else{
  				alert("3");
  				$("#au219")[0].readOnly = true;
  			}
  		});
  		//爸爸信息家庭史先天性疾病选中后面输入框可以录入
  		$("#au223_input").click(function(){
  			if($(this).attr("checked")){
  				$("#au222")[0].readOnly = false;
  			}else{
  				$("#au222")[0].readOnly = true;
  			}
  		});
  		//爸爸信息家庭史遗传性疾病选中后面输入框可以录入
  		$("#au225_input").click(function(){
  			if($(this).attr("checked")){
  				$("#au227")[0].readOnly = false;
  			}else{
  				$("#au227")[0].readOnly = true;
  			}
  		});
  	  
  		//计算婴儿年龄
  		$("#au15").blur(function(){
  			getAge("u15","childAge");
  	    });
  		//计算妈妈年龄
  		$("#au145").blur(function(){
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
  		$("#au177").blur(function(){
  			var birthday = this.value;
			var nowdate = new Date();
			var age = nowdate.getFullYear() - birthday.substr(0,4);
			if(age > 100 || age < 0){
				$("#dadAge").html("");
			}else{
				$("#dadAge").html(age);
			}
  		});
  		
 		var build = 0;
 		//点击确认建档并返回档案号
 		$("#auz193").click(function(){
 			//只能点击一次确认建档
 			if(build != 0){
 				return false;
 			}
 			/* alert($("#au202").val());
 			return false; */
 			var babyName = $("#au7").val();
 			var tag = /[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/;
 			if(babyName == "" || babyName == null){
 				alert("请输入儿童姓名！");
 				return false;
 			}
 			if(!tag.test(babyName)){
 				alert("请输入正确的儿童姓名格式!");
 				return false;
 			}
 			var babySex = $("#au6").val();
 			if(babySex == null || babySex == ""){
 				alert("请选择儿童性别！");
 				return false;
 			}
 			/* var babyBirth = $("#au15").val();
 			if(babyBirth == null || babyBirth == ""){
 				alert("请输入或选择儿童出生日期！");
 				return false;
 			} */
 			var birthWeek = $("#au59").val();
 			var tag1 = /[\d|A-z|\u4E00-\u9FFF]+/;
 			if(birthWeek == "" || birthWeek == null){
 				alert("请输入出生孕周！");
 				return false;
 			}
 			if(!tag1.test(birthWeek)){
 				alert("出生孕周只能输入汉字和数字！");
 				return false;
 			}
 			var taiNo = $("#au56").val();
 			if(taiNo == "" || taiNo == null){
 				alert("请选择胎数！");
 				return false;
 			}
 			var whyTai = $("#au62").val();
 			var tag2 = /^\d{1,2}$/;
 			if(whyTai == "" || whyTai == null){
 				alert("请输入第几胎！");
 				return false;
 			}
 			if(!tag2.test(whyTai)){
 				alert("第几胎只能输入一位或两位数字！");
 				return false;
 			}
 			var whyChan = $("#au67").val();
 			if(whyChan == "" || whyChan == null){
 				alert("请输入第几产！");
 				return false;
 			}
 			if(!tag2.test(whyChan)){
 				alert("第几产只能输入一位或两位数字！");
 				return false;
 			}
 			var birthType = $("#au72").val();
 			if(birthType == "" || birthType == null){
 				alert("请选择分娩方式！");
 				return false;
 			}
 			var birthSign = $("input[name='birthCondition']:checked").val();
 			if(birthSign == null || birthSign == "" || birthSign == undefined){
 				alert("请选择出生情况！");
 				return false;
 			}
 			var weight = $("#au77").val();
 			var tag3 = /^\d+(\.\d{1,2})?$/;
 			if(weight == "" || weight == null){
 				alert("请输入出生体重！");
 				return false;
 			}
 			if(!tag3.test(weight)){
 				alert("出生体重只能输入不超过三位的数字！");
 				return false;
 			}
 			var height = $("#au80").val();
 			if(height == "" || height == null){
 				alert("请输入出生身长！");
 				return false;
 			}
 			if(!tag3.test(height)){
 				alert("出生身长只能输入不超过三位的数字！");
 				return false;
 			}
 			var zhix = $("#au87").val();
 			if(zhix == null || zhix == ""){
 				alert("请选择新生儿是否窒息！");
 				return false;
 			}
 			var apgar = $("#au94").val();
 			if(apgar == null || apgar == ""){
 				alert("请选择Apgar评分！");
 				return false;
 			}
 			if(apgar == 0){
 				var ping = $("#au109").val();
 				if(ping == null || ping == ""){
 					alert("请输入对应的评分！");
 					return false;
 				}
 			}
 			if(apgar == 1){
 				var ping = $("#au109").val();
 				if(ping == null || ping == ""){
 					alert("请输入对应的评分！");
 					return false;
 				}
 			}
 			var birthIll = $("#au90").val();
 			if(birthIll == null || birthIll == "" || birthIll == undefined){
 				alert("请选择新生儿是否有疾病！");
 				return false;
 			}
 			var isNomal = $("#au99").val();
 			if(isNomal == null || isNomal == "" || isNomal == undefined){
 				alert("请选择是否有畸形！");
 				return false;
 			}
 			var momIll = $("input[name='pregnancySickness']:checked").val();
 			if(momIll == null || momIll == undefined){
 				alert("请选择母亲母亲妊娠期患病情况!");
 				return false;
 			}
 			var liveDate = $("#au228").val();
 			if(liveDate == null || liveDate == ""){
 				alert("请选择或输入出院日期！");
 				return false;
 			}
 			var hosp = $("#au104").val();
 			if(hosp == null || hosp == ""){
 				alert("请选择助产机构！");
 				return false;
 			}
 			var homeP = $("#au18").val();
 			if(homeP == null || homeP == ""){
 				alert("请选择家庭省！");
 				return false;
 			}
 			var homeC = $("#au32").val();
 			if(homeC == null || homeC == ""){
 				alert("请选择家庭市！");
 				return false;
 			}
 			var homeT = $("#au33").val();
 			if(homeT == null || homeT == ""){
 				alert("请选择家庭县（区）！");
 				return false;
 			}
 			var homeS = $("#au34").val();
 			if(homeS == null || homeS == ""){
 				alert("请选择家庭乡（街道）！");
 				return false;
 			}
 			var homeV = $("#au35").val();
 			if(homeV == null || homeV == ""){
 				alert("请选择家庭村！");
 				return false;
 			}
 			var accP = $("#au38").val();
 			if(accP == null || accP == ""){
 				alert("请选择户口省！");
 				return false;
 			}
 			var accC = $("#au50").val();
 			if(accC == null || accC == ""){
 				alert("请选择户口市！");
 				return false;
 			}
 			var accT = $("#au51").val();
 			if(accT == null || accT == ""){
 				alert("请选择户口县（区）！");
 				return false;
 			}
 			var accS = $("#au52").val();
 			if(accS == null || accS == ""){
 				alert("请选择户口乡（街道）！");
 				return false;
 			}
 			var accV = $("#au53").val();
 			if(accV == null || accV == ""){
 				alert("请选择户口村！");
 				return false;
 			}
 			var momName = $("#au134").val();
 			if(momName == null || momName == ""){
 				alert("请输入妈妈姓名！");
 				return flase;
 			}
 			if(!tag.test(momName)){
 				alert("请输入正确格式的妈妈姓名！");
 				return false;
 			}
 			/* var momBirthday = $("#au145").val();
 			if(momBirthday == null || momBirthday == ""){
 				alert("请输入或选择妈妈出生日期！");
 				return false;
 			} */
 			var telephone = $("#au142").val();
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

 			var dadName = $("#au166").val();
 			if(dadName == null || dadName == ""){
 				alert("请输入爸爸姓名！");
 				return flase;
 			}
 			if(!tag.test(dadName)){
 				alert("请输入正确格式的爸爸姓名！");
 				return false;
 			}
 			/* var dadBirthday = $("#au177").val();
 			if(momBirthday == null || momBirthday == ""){
 				alert("请输入或选择爸爸出生日期！");
 				return false;
 			} */
 			var manTele = $("#au174").val();
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
 			var note = $("#au233").val();
 			if(note == null || note == "" || note == undefined){
 				$("#auseHelthNote").attr("name","grantSign");
 			}
 			
 			$("#form").submit();
 			build ++;
 		});
 		//完成
 		$("#au13_").click(function(){
 			window.location.href = "${ctx}/childrenarchives/list";
 		});
 		
 		
 		$("#auz192").click(function(){
 			closeDialog_();
 			//window.location.href = "${ctx}/childrenarchives/list"
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
			}
		});
	  };
 </script>
  </head>
  <body>
       
       <div id="auz191" class="ax_形状">个人基本信息详情编辑</div>
       <div id="auz192" style="cursor: pointer;" class="ax_形状">关闭</div>
       <div id="auz193" style="cursor: pointer;" class="ax_形状">保存</div>
       
      <div id="au191" class="ax_形状">
        儿童信息
      </div>
      <form action="${ctx }/childrenarchives/saveArchives" method="post" id="form"> 
      <div style="position: absolute;top: 57px;left: 150px;width: 250px">档案编号：${archives.archivesCode }</div>
      <div style="position: absolute;top: 57px;left: 420px;width: 250px">建档医院：${operator.department }</div>
      <div style="position: absolute;top: 57px;left: 650px;width: 250px">建档医生：${operator.realName }</div>
      <div style="position: absolute;top: 57px;left: 900px;width: 250px">建档日期：
      	<input type="text" name="creatTime" 
        style="color:#333333;cursor:pointer;height: 18px;width: 65px;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="" value="<fmt:formatDate value="${archives.creatTime }" pattern="yyyyMMdd"/>" tabindex="1" required>
        </div>
   <input type="hidden" name="id" value="${archives.id }"/>
    <div id="base" class="">

      <!-- Unnamed (形状) -->
      <div id="au0" class="ax_形状">
      
        <p id="au2"  class="ax_文本段落">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</p>
         
      <input id="au7" type="text" name="name" placeholder="儿童姓名" value="${archives.name }"/>
    

        <p id="au4" class="ax_文本段落">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</p>
                <!-- 性别 (下拉列表框) -->
        <select id="au6" data-label="性别" name="sex">
          <option <c:if test="${archives.sex eq '0'}">selected</c:if> value="0">女</option>
          <option <c:if test="${archives.sex eq '1'}">selected</c:if> value="1">男</option>
          <option <c:if test="${archives.sex eq '2'}">selected</c:if> value="2">性别不明</option>
        </select>


        
       <p id="au13" class="ax_文本段落">出生日期：</p>
       <!--  <input  type="date" value="根据身份证自动显示"/> -->
		<%-- <input type="text" id="au15" name="birthday" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="<fmt:formatDate value="${archives.birthday }" pattern="yyyyMMdd"/>" tabindex="1" required> --%>
		<div id="au15" style="left: 631px;top:20px;"><fmt:formatDate value="${archives.birthday }" pattern="yyyyMMdd"/></div>

<p id="au8" class="ax_文本段落">年&nbsp; &nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;<span id="childAge">${babyAge }</span></p>

     <p id="au10" class="ax_文本段落">身份证号：</p>
        <input id="au12" type="text" name="idNo" placeholder="18位身份证号码" value="${archives.idNo }"/>

     
      <p id="au57" class="ax_文本段落">出生孕周：</p>
        <input id="au59" type="text" name="gestationalWeek" value="${archives.gestationalWeek }"/>

<p id="au54" class="ax_文本段落">胎&nbsp; &nbsp; &nbsp; 数：</p>
        
        <select id="au56" data-label="性别" name="fetusNum">
          <option <c:if test="${archives.fetusNum == '0' }">selected</c:if> value="0">单胎</option>
          <option <c:if test="${archives.fetusNum == '1' }">selected</c:if> value="1">多胎</option>
          <option <c:if test="${archives.fetusNum == '2' }">selected</c:if> value="2">双胎</option>
        </select>
      
     <p id="au60" class="ax_文本段落">第</p>
        <input id="au62" type="text" name="whichFetus" value="${archives.whichFetus }"/>

      
    <p id="au63" class="ax_文本段落">胎</p>

    <p id="au65" class="ax_文本段落">第</p>
        <input id="au67" type="text" name="whichBirth" value="${archives.whichBirth }"/>

<p id="au68" class="ax_文本段落">产</p>

   <p id="au70" class="ax_文本段落">分娩方式：</p>
        <select id="au72" data-label="性别" name="deliveryType">
          <option <c:if test="${archives.deliveryType == '0' }">selected</c:if> value="0">顺产</option>
          <option <c:if test="${archives.deliveryType == '1' }">selected</c:if> value="1">剖宫产</option>
        </select>

      <p id="au73" class="ax_文本段落">出生情况：</p>
       <!-- Unnamed (复选框) -->
       <c:forEach items="${birthConditions}" var="birthCondition">
      <div id="au110" class="ax_复选框">
            <p id="au111">顺产</p>
        <input id="au110_input" <c:if test="${birthCondition == '0' }">checked="checked"</c:if> name="birthCondition" type="checkbox" value="0"/>
      </div>
		</c:forEach>
		<c:forEach items="${birthConditions}" var="birthCondition">
      <!-- Unnamed (复选框) -->
      <div id="au112" class="ax_复选框">
            <p id="au113">胎头吸引</p>
        <input id="au112_input" <c:if test="${birthCondition == '1' }">checked="checked"</c:if> name="birthCondition" type="checkbox" value="1"/>
      </div>
		</c:forEach>
		<c:forEach items="${birthConditions}" var="birthCondition">
      <!-- Unnamed (复选框) -->
      <div id="au114" class="ax_复选框">
         <p id="au115">产钳</p>
        <input id="au114_input" <c:if test="${birthCondition == '2' }">checked="checked"</c:if> name="birthCondition" type="checkbox" value="2"/>
      </div>
		</c:forEach>
		<c:forEach items="${birthConditions}" var="birthCondition">
      <!-- Unnamed (复选框) -->
      <div id="au116" class="ax_复选框">
            <p id="au117">剖宫产</p>
        <input id="au116_input" <c:if test="${birthCondition == '3' }">checked="checked"</c:if> name="birthCondition" type="checkbox" value="3"/>
      </div>
		</c:forEach>
		<c:forEach items="${birthConditions}" var="birthCondition">
      <!-- Unnamed (复选框) -->
      <div id="au118" class="ax_复选框">
        <p id="au119">臀位</p>
        <input id="au118_input" <c:if test="${birthCondition == '4' }">checked="checked"</c:if> name="birthCondition" type="checkbox" value="4"/>
      </div>
		</c:forEach>
		<c:forEach items="${birthConditions}" var="birthCondition">
      <!-- Unnamed (复选框) -->
      <div id="au120" class="ax_复选框">
            <p id="au121">双多胎</p>
        <input id="au120_input" <c:if test="${birthCondition == '5' }">checked="checked"</c:if> name="birthCondition" type="checkbox" value="5"/>
      </div>
		</c:forEach>
		<c:forEach items="birthConditions" var="birthCondition">
      <!-- Unnamed (复选框) -->
      <div id="au122" class="ax_复选框">
         <p id="au123">其他</p>
        <input id="au122_input" <c:if test="${birthCondition == '6' }">checked="checked"</c:if> name="birthCondition" type="checkbox" value="6"/>
      </div>
        <input id="au108" name="conditionRemark"  <c:if test="${birthCondition != '6'}">readonly="readonly"</c:if> placeholder="其他" type="text" value="${archives.conditionRemark }"/>
	</c:forEach>
      
       <p id="au75" class="ax_文本段落">出生体重：</p>
        <input id="au77" type="text" name="weight" value="${archives.weight }"/>
      
      <p id="au81" class="ax_文本段落">kg</p>
      
      <p id="au78" class="ax_文本段落">出生身长：</p>
        <input id="au80" type="text" name="height" value="${archives.height }"/>
        <p id="au83" class="ax_文本段落">cm</p>
           
      <p id="au85" class="ax_文本段落">新生儿窒息：</p>
        <select id="au87" data-label="性别" name="asphyxia">
          <option <c:if test="${archives.asphyxia == '0' }">selected</c:if> value="0">无</option>
          <option <c:if test="${archives.asphyxia == '1' }">selected</c:if> value="1">有</option>
        </select>

     <p id="au92" class="ax_文本段落">Apgar评分：</p>
        <select id="au94" data-label="性别" name="apgarScore">
          <option <c:if test="${archives.apgarScore == '0' }">selected</c:if> value="0">3分钟</option>
          <option <c:if test="${archives.apgarScore == '1' }">selected</c:if> value="1">5分钟</option>
          <option <c:if test="${archives.apgarScore == '2' }">selected</c:if> value="2">不详</option>
        </select>

        <input id="au109" type="text" name="apgarRemark" value="${archives.apgarRemark }"/>

      
     <p id="au88" class="ax_文本段落">新生儿疾病：</p>
        <select id="au90" data-label="性别" name="newbornDisease">
          <option <c:if test="${archives.newbornDisease == '0' }">selected</c:if> value="0">无</option>
          <option <c:if test="${archives.newbornDisease == '1' }">selected</c:if> value="1">有</option>
        </select>

        <input id="au91" name="diseaseRemark" <c:if test="${archives.newbornDisease == '0' }">readonly="readonly"</c:if> type="text" placeholder="详述" value="${archives.diseaseRemark }"/>
 
      <p id="au97" class="ax_文本段落">是否有畸形：</p>
        <select id="au99" data-label="性别" name="anomaly">
          <option <c:if test="${archives.anomaly eq '0' }">selected</c:if> value="0">无</option>
          <option <c:if test="${archives.anomaly eq '1' }">selected</c:if> value="1">有</option>
        </select>
        <input id="au101" type="text" <c:if test="${archives.anomaly eq '0' }">readonly="readonly"</c:if> name="anomalyRemark" placeholder="详述" value=""/>
      
      <p id="au95" class="ax_文本段落">母亲妊娠期患病情况：</p>
     
     <c:forEach items="${pregns }" var="pregn">
      <div id="au124" class="ax_复选框">
            <p id="au125"><span>糖尿病</span></p>
        <input id="au124_input" <c:if test="${pregn eq '0'}">checked="checked"</c:if> name="pregnancySickness" type="checkbox" value="0"/>
      </div>
      </c:forEach>
	<c:forEach items="${pregns }" var="pregn">
      <!-- Unnamed (复选框) -->
      <div id="au126" class="ax_复选框">
            <p id="au127">妊娠期高血压</p>
        <input id="au126_input" <c:if test="${pregn eq '1'}">checked="checked"</c:if> name="pregnancySickness" type="checkbox" value="1"/>
      </div>
		</c:forEach>
	<c:forEach items="${pregns }" var="pregn">
      <!-- Unnamed (复选框) -->
      <div id="au128" class="ax_复选框">
        <p id="au129"><span>其他</span></p>
        <input id="au128_input" <c:if test="${pregn eq '2'}">checked="checked"</c:if> name="pregnancySickness" type="checkbox" value="2"/>
      </div>

        <input id="au100" type="text" <c:if test="${pregn != '2'}">readonly="readonly"</c:if> name="sicknessRemark" placeholder="详述" value="${archives.sicknessRemark }"/>
      </c:forEach>
      
      <p id="au106" class="ax_文本段落">出院日期：</p>
        <!-- <input id="au228" type="date" value=""/> -->
      	<input type="text" id="au228" name="dischargeDate" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="<fmt:formatDate value="${archives.dischargeDate }" pattern="yyyyMMdd"/>" tabindex="1" required>
      
      <p id="au102" class="ax_文本段落">助产机构：</p>
        <select id="au104" data-label="性别" name="institutions">
          <c:forEach items="${list }" var="dep">
          	<option <c:if test="${department.id == dep.id}">selected</c:if> value="${dep.id }">${dep.name }</option>
          </c:forEach>
          <option <c:if test="${department.id == '1'}">selected</c:if> value="1">其他 </option>
        </select>

        <input id="au105" type="text" <c:if test="${department.id != '1'}">readonly="readonly"</c:if> name="institutionsRemark" placeholder="其他" value="${archives.institutionsRemark }"/>

        <p id="au16" class="ax_文本段落">户口地址：</p>
		<input id="accPro" type="hidden" value="${accProvince.id }"/>
        <select id="au18" name="accProvinceId">
        </select>
       <p id="au20" class="ax_文本段落">省</p>

        <select id="au32" name="accCityId">
        	<option value="${accCity.id }">${accCity.name }</option>
        </select>
      <p id="au22" class="ax_文本段落">市</p>
      
        <select id="au33" name="accCountyId">
        	<option value="${accCounty.id }">${accCounty.name }</option>
        </select>
      <p id="au24" class="ax_文本段落">县（区）</p>

        <select id="au34" name="accTownshipId">
        	<option value="${accTown.id }">${accTown.name }</option>
        </select>
      <p id="au26" class="ax_文本段落">乡（街道）</p>
      
        <select id="au35" name="accVillageId">
        	<option value="${accVillage.id }">${accVillage.name }</option>
        </select>
       <p id="au28" class="ax_文本段落">村</p>

      <input id="au19" type="text" name="accAddress" placeholder="非必填项" value="${archives.accAddress }"/>
      
     <p id="au30" class="ax_文本段落">家庭地址：</p>
		<input id="homePro" type="hidden" value="${homeProvince.id }"/>
        <select id="au38" name="homeProvinceId">
        </select>
        <p id="au40" class="ax_文本段落">省</p>

        <select id="au50" name="homeCityId">
        	<option value="${homeCity.id }">${homeCity.name }</option>
        </select>
        <p id="au42" class="ax_文本段落">市</p>

        <select id="au51" name="homeCountyId">
        	<option value="${homeCounty.id }">${homeCounty.name }</option>
        </select>
        <p id="au44" class="ax_文本段落">县（区）</p>

        <select id="au52" name="homeTownshipId">
        	<option value="${homeTown.id }">${homeTown.name }</option>
        </select>
       <p id="au46" class="ax_文本段落">乡（街道）</p>

        <select id="au53" name="homeVillageId">
        	<option value="${homeVillage.id }">${homeVillage.name }</option>
        </select>
        <p id="au48" class="ax_文本段落">村</p>
        
      <input id="au39" type="text" name="homeAddress" placeholder="非必填项" value="${archives.homeAddress }"/>

     <p id="au36" class="ax_文本段落" style="cursor: pointer;">同上</p>
      </div>

      <div id="au146" class="ax_形状">
      <span>妈妈信息</span>
      </div>

      <div id="au130" class="ax_形状">
      
       <p id="au132" class="ax_文本段落">妈妈姓名：</p>
        <input id="au134" type="text" name="momName" placeholder="妈妈姓名" value="${archives.momName }"/>
      <!-- <div id="selectMam" style="position: absolute;left: 300px;top: 18px;width: 35px;height: 20px;cursor: pointer;background-color: #009ED7";>
      	<p style="position: absolute;top: 1px;left:4px;color: #FFFFFF">查询</p>
      </div> -->
      <p id="au148" class="ax_文本段落">文化程度：</p>
        <select id="au150" name="momEducation">
          <option <c:if test="${archives.momEducation eq '9' }">selected</c:if> value="9">无</option>
          <option <c:if test="${archives.momEducation eq '0' }">selected</c:if> value="0">小学</option>
          <option <c:if test="${archives.momEducation eq '1' }">selected</c:if> value="1">初中</option>
          <option <c:if test="${archives.momEducation eq '2' }">selected</c:if> value="2">高中</option>
          <option <c:if test="${archives.momEducation eq '3' }">selected</c:if> value="3">技校</option>
          <option <c:if test="${archives.momEducation eq '4' }">selected</c:if> value="4">专科</option>
          <option <c:if test="${archives.momEducation eq '5' }">selected</c:if> value="5">本科</option>
          <option <c:if test="${archives.momEducation eq '7' }">selected</c:if> value="7">博士</option>
          <option <c:if test="${archives.momEducation eq '6' }">selected</c:if> value="6">研究生</option>
          <option <c:if test="${archives.momEducation eq '8' }">selected</c:if> value="8">其他</option>
        </select>

	<p id="au151" class="ax_文本段落">职&nbsp;&nbsp;&nbsp;&nbsp;业：</p>
        <select id="au153" name="momOccupation">
          <option <c:if test="${archives.momOccupation eq '0'}">selected</c:if> value="0">农民</option>
          <option <c:if test="${archives.momOccupation eq '1'}">selected</c:if> value="1">工人</option>
          <option <c:if test="${archives.momOccupation eq '2'}">selected</c:if> value="2">经商</option>
          <option <c:if test="${archives.momOccupation eq '3'}">selected</c:if> value="3">干部</option>
          <option <c:if test="${archives.momOccupation eq '4'}">selected</c:if> value="4">军人</option>
          <option <c:if test="${archives.momOccupation eq '5'}">selected</c:if> value="5">科技</option>
          <option <c:if test="${archives.momOccupation eq '6'}">selected</c:if> value="6">医药</option>
          <option <c:if test="${archives.momOccupation eq '7'}">selected</c:if> value="7">其他</option>
          <option <c:if test="${archives.momOccupation eq '8'}">selected</c:if> value="8">不祥</option>
        </select>
      
      <p id="au154" class="ax_文本段落">工作单位：</p>
        <input id="au156" type="text" name="momWorkUnit" placeholder="工作单位" value="${archives.momWorkUnit }"/>
      
      <p id="au137" class="ax_文本段落">身份证号：</p>
        <input id="au139" type="text" name="momIdNo" placeholder="18位身份证号码" value="${archives.momIdNo }"/>

      
       <p id="au143" class="ax_文本段落">出生日期：</p>
        <!-- <input id="au145" type="date" value="根据身份证自动显示"/> -->
		<input type="text" id="au145" name="momBirthday"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="<fmt:formatDate value="${archives.momBirthday }" pattern="yyyyMMdd"/>" tabindex="1" required>
          <p id="au135" class="ax_文本段落">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;<span id="momAge">${momAge }</span>岁</p>

       

    <p id="au140" class="ax_文本段落">联系电话：</p>
        <input id="au142" type="text" name="momTele" placeholder="11位手机号" value="${archives.momTele }"/>


    <p id="au157" class="ax_文本段落">健康状况：</p>
    <c:forEach items="${momHealths }" var="momHealth">
      <div id="au193" class="ax_复选框">
            <p id="au194">健康</p>
        <input id="au193_input" <c:if test="${momHealth eq '0' }">checked="checked"</c:if> name="momHealth" type="checkbox" value="0"/>
      </div>
      </c:forEach>
      <c:forEach items="${momHealths }" var="momHealth">
      <div id="au195" class="ax_复选框">
            <p id="au196">慢性病</p>
        <input id="au195_input" <c:if test="${momHealth eq '1' }">checked="checked"</c:if> name="momHealth" type="checkbox" value="1"/>
      </div>
        <input id="au159" name="momChronicRemark" <c:if test="${momHealth != '1' }">readonly="readonly"</c:if> placeholder="详述" type="text" value="${archives.momChronicRemark }"/>
        </c:forEach>
      <c:forEach items="${momHealths }" var="momHealth">
	<div id="au197" class="ax_复选框">
            <p id="au198">传染病</p>
        <input id="au197_input" <c:if test="${momHealth eq '2' }">checked="checked"</c:if> name="momHealth" type="checkbox" value="2"/>
      </div>
        <input id="au199" placeholder="详述" <c:if test="${momHealth != '2' }">readonly="readonly"</c:if> name="momInfectiousRemark" type="text" value="${archives.momInfectiousRemark }"/>
 	</c:forEach>
 	<p id="au160" class="ax_文本段落">家 族 史：</p>
 	<c:forEach items="${momFamHistorys }" var="momFamHistory">
      <div id="au200" class="ax_复选框">
            <p id="au201">无特殊</p>
        <input id="au200_input" <c:if test="${momFamHistory eq '0' }">checked="checked"</c:if> name="momFamHistory" type="checkbox" value="0"/>
      </div>
      </c:forEach>
	  <c:forEach items="${momFamHistorys }" var="momFamHistory">
      <div id="au203" class="ax_复选框">
            <p id="au204">先天性疾病</p>
        <input id="au203_input" <c:if test="${momFamHistory eq '1' }">checked="checked"</c:if> name="momFamHistory" type="checkbox" value="1"/>
      </div>
        <input id="au202" placeholder="详述" <c:if test="${momFamHistory != '1' }">readonly="readonly"</c:if> name="momCongenitalRemark" type="text" value="${archives.momCongenitalRemark }"/>
     </c:forEach>
	  <c:forEach items="${momFamHistorys }" var="momFamHistory">
      <div id="au205" class="ax_复选框">
            <p id="au206">遗传性疾病</p>
        <input id="au205_input" <c:if test="${momFamHistory eq '2' }">checked="checked"</c:if> name="momFamHistory" type="checkbox" value="2"/>
      </div>
      <input id="au207" placeholder="详述" <c:if test="${momFamHistory != '2' }">readonly="readonly"</c:if> name="momHereditaryRemark" type="text" value="${archives.momHereditaryRemark }"/>
      </c:forEach>
      </div>
      
      <div id="au178" class="ax_形状">
        <span>爸爸信息</span>
      </div>

      <div id="au162" class="ax_形状">
        <p id="au164" class="ax_文本段落">爸爸姓名：</p>
        <input id="au166" type="text" name="dadName" placeholder="爸爸姓名" value="${archives.dadName }"/>
      
       <p id="au180" class="ax_文本段落">文化程度：</p>
        <select id="au182" name="dadEducation">
          <option <c:if test="${archives.dadEducation eq '9' }">selected</c:if> value="9">无</option>
          <option <c:if test="${archives.dadEducation eq '0' }">selected</c:if> value="0">小学</option>
          <option <c:if test="${archives.dadEducation eq '1' }">selected</c:if> value="1">初中</option>
          <option <c:if test="${archives.dadEducation eq '2' }">selected</c:if> value="2">高中</option>
          <option <c:if test="${archives.dadEducation eq '3' }">selected</c:if> value="3">技校</option>
          <option <c:if test="${archives.dadEducation eq '4' }">selected</c:if> value="4">专科</option>
          <option <c:if test="${archives.dadEducation eq '5' }">selected</c:if> value="5">本科</option>
          <option <c:if test="${archives.dadEducation eq '7' }">selected</c:if> value="7">博士</option>
          <option <c:if test="${archives.dadEducation eq '6' }">selected</c:if> value="6">研究生</option>
          <option <c:if test="${archives.dadEducation eq '8' }">selected</c:if> value="8">其他 </option>
        </select>
      
       <p id="au183" class="ax_文本段落">职&nbsp;&nbsp;&nbsp;&nbsp;业：</p>
        <select id="au185" name="dadOccupation">
          <option <c:if test="${archives.dadOccupation eq '0'}">selected</c:if> value="0">农民</option>
          <option <c:if test="${archives.dadOccupation eq '1'}">selected</c:if> value="1">工人</option>
          <option <c:if test="${archives.dadOccupation eq '2'}">selected</c:if> value="2">经商</option>
          <option <c:if test="${archives.dadOccupation eq '3'}">selected</c:if> value="3">干部</option>
          <option <c:if test="${archives.dadOccupation eq '4'}">selected</c:if> value="4">军人</option>
          <option <c:if test="${archives.dadOccupation eq '5'}">selected</c:if> value="5">科技</option>
          <option <c:if test="${archives.dadOccupation eq '6'}">selected</c:if> value="6">医药</option>
          <option <c:if test="${archives.dadOccupation eq '7'}">selected</c:if> value="7">其他</option>
          <option <c:if test="${archives.dadOccupation eq '8'}">selected</c:if> value="8">不祥</option>
        </select>

      <p id="au186" class="ax_文本段落">工作单位：</p>
        <input id="au188" type="text" name="dadWorkUnit" placeholder="工作单位" value="${archives.dadWorkUnit }"/>

     <p id="au169" class="ax_文本段落">身份证号：</p>
        <input id="au171" type="text" name="dadIdNo" placeholder="18位身份证号码" value="${archives.dadIdNo }"/>
      
      <p id="au175" class="ax_文本段落">出生日期：</p>
        <!-- <input id="au177" type="date" value="根据身份证自动显示"/> -->
        <input type="text" id="au177" name="dadBirthday"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="<fmt:formatDate value="${archives.dadBirthday }" pattern="yyyyMMdd"/>" tabindex="1" required>
        
    <p id="au167" class="ax_文本段落">年&nbsp;&nbsp;&nbsp;&nbsp;龄：&nbsp;&nbsp;<span id="dadAge">${dadAge }</span>岁</p>

     <p id="au172" class="ax_文本段落">联系电话：</p>
        <input id="au174" type="text" name="dadTele" placeholder="11位手机号" value="${archives.dadTele }"/>

     <p id="au208" class="ax_文本段落">健康状况：</p>
     <c:forEach items="${babHealths }" var="babHealth">
      <div id="au213" class="ax_复选框">
            <p id="au214">健康</p>
        <input id="au213_input" <c:if test="${babHealth == '0' }">checked="checked"</c:if> name="babHealth" type="checkbox" value="0"/>
      </div>
      </c:forEach>
      <c:forEach items="${babHealths }" var="babHealth">
      <div id="au215" class="ax_复选框">
            <p id="au216">慢性病</p>
        <input id="au215_input" <c:if test="${babHealth eq '1' }">checked="checked"</c:if> name="babHealth" type="checkbox" value="1"/>
      </div>
        <input id="au210" placeholder="详述" <c:if test="${babHealth != '1' }">readonly="readonly"</c:if> name="babChronicRemark" type="text" value="${archives.babChronicRemark }"/>
        </c:forEach>
      <c:forEach items="${babHealths }" var="babHealth">
        <div id="au217" class="ax_复选框">
            <p id="au218">传染病</p>
        <input id="au217_input" <c:if test="${babHealth eq '2' }">checked="checked"</c:if> name="babHealth" type="checkbox" value="2"/>
      </div>
        <input id="au219" placeholder="详述" <c:if test="${babHealth != '2' }">readonly="readonly"</c:if> name="babInfectiousRemark" type="text" value="${archives.babInfectiousRemark }"/>
      </c:forEach>
      <p id="au211" class="ax_文本段落">家 族 史：</p>
      <c:forEach items="${babFamHistorys }" var="babFamHistory">
      <div id="au220" class="ax_复选框">
            <p id="au221">无特殊</p>
        <input id="au220_input" <c:if test="${babFamHistory == '0' }">checked="checked"</c:if> name="babFamHistory" type="checkbox" value="0"/>
      </div>
      </c:forEach>
   	  <c:forEach items="${babFamHistorys }" var="babFamHistory">
      <div id="au223" class="ax_复选框">
            <p id="au224">先天性疾病</p>
        <input id="au223_input" <c:if test="${babFamHistory == '1' }">checked="checked"</c:if> name="babFamHistory" type="checkbox" value="1"/>
      </div>
        <input id="au222" placeholder="详述" <c:if test="${babFamHistory != '1' }">readonly="readonly"</c:if> name="babCongenitalRemark" type="text" value="${archives.babCongenitalRemark }"/>
      </c:forEach>
   	  <c:forEach items="${babFamHistorys }" var="babFamHistory">
      <div id="au225" class="ax_复选框">
            <p id="au226">遗传性疾病</p>
        <input id="au225_input" <c:if test="${babFamHistory == '2' }">checked="checked"</c:if> name="babFamHistory" type="checkbox" value="2"/>
      </div>
        <input id="au227" placeholder="详述" <c:if test="${babFamHistory != '2' }">readonly="readonly"</c:if> name="babHereditaryRemark" type="text" value="${archives.babHereditaryRemark }"/>
      </c:forEach>
      </div>
	
  </div>

</form>
 <!-- <script type="text/javascript">
		
		$(function() {
			var b = "";
			var p = "";
			var mh = "";
			var mf = "";
			var bh = "";
			var bf = "";
			$("#selectMam").click(function(){
				//debugger;
				var birthCondition = document.getElementsByName('birthCondition');
				for(var i = 0; i < birthCondition.length; i ++){
					if(birthCondition[i].checked){
						b += birthCondition[i].value+",";
					}
				}
				var pregnancySickness = document.getElementsByName('pregnancySickness');
				for(var i = 0; i < pregnancySickness.length; i ++){
					if(pregnancySickness[i].checked){
						p += pregnancySickness[i].value+",";
					}
				}
				var momHealth = document.getElementsByName('momHealth');
				for(var i = 0; i < momHealth.length; i ++){
					if(momHealth[i].checked){
						mh += momHealth[i].value+",";
					}
				}
				var momFamHistory = document.getElementsByName('momFamHistory');
				for(var i = 0; i < momFamHistory.length; i ++){
					if(momFamHistory[i].checked){
						mf += momFamHistory[i].value+",";
					}
				}
				var babHealth = document.getElementsByName('babHealth');
				for(var i = 0; i < babHealth.length; i ++){
					if(babHealth[i].checked){
						bh += babHealth[i].value+",";
					}
				}
				var babFamHistory = document.getElementsByName('babFamHistory');
				for(var i = 0; i < babFamHistory.length; i ++){
					if(babFamHistory[i].checked){
						bf += babFamHistory[i].value+",";
					}
				}
				
				var listUrl = "${ctx}/childrenarchives/selectChildBirth";
			    	
				$.grid({id:'#dg1',url:listUrl,title:"",toolbar:'#tb1',
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
				 
				var selectUrl = "${ctx}/childrenarchives/selectChildBirth";
	  			showDialog_("查询母亲信息","detailAtv11","zhongjianddle9",false);
				
	  		});
             
			$("#closeWindow").click(function(){
				debugger;
				var bb = b.split(",");
				for(var i = 0; i < bb.length; i ++){
					$("#au"+(110+bb[i]*2)+"_input")[0].checked = true;
				}
				var pp = p.split(",");
				for(var i = 0; i < pp.length; i ++){
					$("#au"+(124+bb[i]*2)+"_input")[0].checked = true;
				}
				var mmh = mh.split(",");
				for(var i = 0; i < mmh.length; i ++){
					$("#au"+(193+mmh[i]*2)+"_input")[0].checked = true;
				}
				var mmf = mf.split(",");
				for(var i = 0; i < mmf.length; i ++){
					if(mmf[i] == 0){
						$("#au200_input")[0].checked = true;
					}
					if(mmf[i] == 1){
						$("#au203_input")[0].checked = true;
					}
					if(mmf[i] == 2){
						$("#au205_input")[0].checked = true;
					}
				}
				var bbh = bh.split(",");
				for(var i = 0; i < bbh.length; i ++){
					$("#au"+(213+bbh[i]*2)+"_input")[0].checked = true;
				}
				var bbf = bf.split(",");
				for(var i = 0; i < bbf.length; i ++){
					if(bbf[i] == 0){
						$("#au220_input")[0].checked = true;
					}
					if(bbf[i] == 1){
						$("#au223_input")[0].checked = true;
					}
					if(bbf[i] == 2){
						$("#au225_input")[0].checked = true;
					}
				}
 				$("#detailAtv11").window("close");
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
			$("#au134").val(node.name);
			$("#au150").val(node.education);
			$("#au153").val(node.occupation);
			$("#au156").val(node.workUnit);
			$("#au139").val(node.idNo);
			var month = (new Date(node.birthday).getMonth()+1)+"";
			if(month.length == 1){
				month = "0"+month;
			}
			var day = new Date(node.birthday).getDate()+"";
			if(day.length == 1){
				day = "0"+day;
			}
			var birthday = new Date(node.birthday).getFullYear()+""+month+""+day;
			$("#au145").val(birthday);
			var momAge = new Date().getFullYear() - new Date(node.birthday).getFullYear();
			$("#momAge").html(momAge);
			$("#au142").val(node.telephone);
			$("#au166").val(node.manName);
			$("#au182").val(node.manEducation);
			$("#au185").val(node.manOccupation);
			$("#au188").val(node.manWorkUnit);
			$("#au171").val(node.manIdNo);
			var manMonth = (new Date(node.manBirthday).getMonth()+1)+"";
			if(manMonth.length == 1){
				manMonth = "0"+manMonth;
			}
			var manDay = new Date(node.manBirthday).getDate()+"";
			if(manDay.length == 1){
				manDay = "0"+manDay;
			}
			var manBirthday = new Date(node.manBirthday).getFullYear()+""+manMonth+""+manDay;
			$("#au177").val(manBirthday);
			var dadAge = new Date().getFullYear() - new Date(node.manBirthday).getFullYear();
			$("#dadAge").html(dadAge);
			$("#au174").val(node.manTele);
			$("#detailAtv11").window("close");
		}
	</script> --> 
  <!-- <div id="detailAtv11" class="easyui-dialog" style="overflow: hidden" title="角色" closed="true">
  	<table id="dg1"></table>
		<div id="tb1" style="padding:5px;height:auto;">
		 <div style="">
			 <form id="queryForm" method="post">
			 <input type="hidden" id="sign" name="sign" value=""/>
			 
			 <div style="position:relative;border: 1px solid #cccccc;height: 100px;width: 99%;">
				 <div style="float: right;top:5px;">
				<span style="position:absolute;left:50px ;width:90px; top:18px;height: 25px;">妈妈档案编号：</span> <input style="position:absolute;left:140px ;width:150px; top:15px;height: 25px;border: 1px solid #cccccc;" type="text" class="form-control" name="archivesCode"/>
				<span style="position:absolute;left:330px ;width:80px; top:18px;height: 25px;">妈妈姓名：</span><input style="position:absolute;left:395px ;width:90px; top:15px;height: 25px;border: 1px solid #cccccc;" class="form-control" type="text" name="name"/>
				<span style="position:absolute;left:518px ;width:90px; top:18px;height: 25px;">妈妈身份证号：</span><input style="position:absolute;left:607px ;width:180px; top:15px;height: 25px;border: 1px solid #cccccc;"  class="form-control" type="text" name="idNo"/>
				 </div>
				<span style="position:absolute;left:50px ;width:85px; top:60px;height: 25px;">儿 童 姓 名 ：</span> <input style="position:absolute;left:140px ;width:150px; top:58px;height: 25px;border: 1px solid #cccccc;" type="text" class="form-control" name="childName"/>
				<span style="position:absolute;left:330px ;width:80px; top:60px;height: 25px;">出生日期：</span>
				<input type="text" id="beginTime" name="beginTime" readonly
        	style="position:absolute;left:395px ;top:58px;color:#333333;width:150px;height: 25px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
        	<span style="position:absolute;left:557px ;top:60px;">—</span>
        	<input type="text" id="endTime" name="endTime" readonly
        	style="position:absolute;left:580px ;top:58px;color:#333333;width:150px;height: 25px;cursor:pointer;border: 1px solid #cccccc;" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        	class="form-control" value="" tabindex="1" required>
				 </div>
      		<div style="position: absolute;left:91%;top: 60px;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton" id="queryBtn"><i class="fa fa-search"></i>查询</a>
      		</div>
      		</form>
			</div>
			
      		<div style="position: absolute;left:50%;top: 94%;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton reset" style="background-color: #009ED7;" onClick="edit();" id="rollBackBtn"><i class="fa fa-undo"></i>选择</a>
      		</div>
      		<div style="position: absolute;left:60%;top: 94%;height:45px;width:95px;">
      			<a href="javascript:void(0)" class="easyui-linkbutton export" style="background-color: #00BE51;" id="closeWindow"><i class="fa fa-file-text-o"></i>关闭</a>
      		</div>
		
		</div>
	
  	<div id="addOrUpdateAtv1"></div>
	   <div id="detailAtv1"></div>
  </div> -->
