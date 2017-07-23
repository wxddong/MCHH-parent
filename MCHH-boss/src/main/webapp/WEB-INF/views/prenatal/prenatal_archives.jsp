<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
		#lastMenses{
			position: absolute;
		    left: 0px;
		    top: 0px;
		    width: 145px;
		    height: 25px;
		    border-style: solid;
		    border-width: 1px;
		    border-color: #C8C9CD;
		    font-family: 'Arial Normal', 'Arial';
		    font-weight: 400;
		    font-style: normal;
		    font-size: 13px;
		    text-decoration: none;
		    color: #333333;
		    text-align: left;
		}
		#predictDate{
			position: absolute;
		    left: 0px;
		    top: 0px;
		    width: 145px;
		    height: 25px;
		    border-style: solid;
		    border-width: 1px;
		    border-color: #C8C9CD;
		    font-family: 'Arial Normal', 'Arial';
		    font-weight: 400;
		    font-style: normal;
		    font-size: 13px;
		    text-decoration: none;
		    color: #333333;
		    text-align: left;
		}
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
		  left:231px;
		  top:103px;
		  width:258px;
		  height:16px;
		  font-size:16px;
		  color:#000000;
		  text-align:center;
		}
		#u03 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:258px;
		  white-space:nowrap;
		}
		#u04 {
		  position:absolute;
		  left:0px;
		  top:0px;
		  width:217px;
		  height:36px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u05 {
		  position:absolute;
		  left:2px;
		  top:10px;
		  width:213px;
		  word-wrap:break-word;
		}
		#u06 {
		  position:absolute;
		  left:96px;
		  top:226px;
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
		  left:368px;
		  top:226px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u09 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u010 {
		  position:absolute;
		  left:504px;
		  top:226px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u011 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
		#u012 {
		  position:absolute;
		  left:232px;
		  top:226px;
		  width:120px;
		  height:44px;
		  font-family:'Arial Negreta', 'Arial';
		  font-weight:700;
		  color:#FFFFFF;
		}
		#u013 {
		  position:absolute;
		  left:2px;
		  top:14px;
		  width:116px;
		  word-wrap:break-word;
		}
	
	</style>
    <title>孕产妇新建档案</title>
    <%@ include file="/WEB-INF/views/common/public_jc.jsp"%>
	<%@ include file="/WEB-INF/views/common/showDialog_js_.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="${ctx}/static/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/data_styles.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/prenatlArchives_styles.css" type="text/css" rel="stylesheet"/>
    
    <script type="text/javascript">
    	
    	$(function(){
    		//使所有下拉列表默认为空
    		for(var i = 0; i<32; i ++){
      		  
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
     		province(provinceUrl,"u83_input",null);
      	  
      	  //家庭市
      	  $("#u83_input").change(function(){
      		  var provinceId = $("#u83_input").val();
      		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
      		  province(cityUrl,"u95_input",provinceId);
	      	  $("#u96_input")[0].selectedIndex = -1;
	  		  $("#u97_input")[0].selectedIndex = -1;
	  		  $("#u98_input")[0].selectedIndex = -1;
	  		  $("#u96_input").html("");
	  		  $("#u97_input").html("");
	  		  $("#u98_input").html("");
      	  });
      	  
      	  //家庭县
      	  $("#u95_input").change(function(){
      		  var provinceId = $("#u95_input").val();
      		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
      		  province(cityUrl,"u96_input",provinceId);
      		  $("#u97_input")[0].selectedIndex = -1;
	  		  $("#u98_input")[0].selectedIndex = -1;
	  		  $("#u97_input").html("");
	  		  $("#u98_input").html("");
      	  });
      	  
      	  //家庭乡
      	  $("#u96_input").change(function(){
      		  var provinceId = $("#u96_input").val();
      		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
      		  province(cityUrl,"u97_input",provinceId);
      		  $("#u98_input")[0].selectedIndex = -1;
	  		  $("#u98_input").html("");
      	  }); 
      	 
      	  //家庭村
      	  $("#u97_input").change(function(){
      		  var provinceId = $("#u97_input").val();
      		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
      		  province(cityUrl,"u98_input",provinceId);
      	  });
      	  
      	  //户口省份
      	 province(provinceUrl,"u30_input",null);
      		  
      	  //户口市
      	  $("#u30_input").change(function(){
      		  var provinceId = $("#u30_input").val();
      		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
      		  province(cityUrl,"u74_input",provinceId);
      		  $("#u75_input")[0].selectedIndex = -1;
	  		  $("#u76_input")[0].selectedIndex = -1;
	  		  $("#u77_input")[0].selectedIndex = -1;
	  		  $("#u75_input").html("");
	  		  $("#u76_input").html("");
	  		  $("#u77_input").html("");
      	  });
      	  
      	  //户口县
      	  $("#u74_input").change(function(){
      		  var provinceId = $("#u74_input").val();
      		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
      		  province(cityUrl,"u75_input",provinceId);
      		  $("#u76_input")[0].selectedIndex = -1;
	  		  $("#u77_input")[0].selectedIndex = -1;
	  		  $("#u76_input").html("");
	  		  $("#u77_input").html("");
      	  });
      	  
      	  //户口乡
      	  $("#u75_input").change(function(){
      		  var provinceId = $("#u75_input").val();
      		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
      		  province(cityUrl,"u76_input",provinceId);
      		  $("#u77_input")[0].selectedIndex = -1;
	  		  $("#u77_input").html("");
      	  });
      	
      	  //户口村
      	  $("#u76_input").change(function(){
      		  var provinceId = $("#u76_input").val();
      		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
      		  province(cityUrl,"u77_input",provinceId);
      	  });
      	  
      	  //男方
      	//家庭省份
   		  province(provinceUrl,"u144_input",null);
    	  
    	  //家庭市
    	  $("#u144_input").change(function(){
    		  var provinceId = $("#u144_input").val();
    		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
    		  province(cityUrl,"u156_input",provinceId);
    		  $("#u157_input")[0].selectedIndex = -1;
	  		  $("#u158_input")[0].selectedIndex = -1;
	  		  $("#u159_input")[0].selectedIndex = -1;
	  		  $("#u157_input").html("");
	  		  $("#u158_input").html("");
	  		  $("#u159_input").html("");
    	  });
    	  
    	  //家庭县
    	  $("#u156_input").change(function(){
    		  var provinceId = $("#u156_input").val();
    		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
    		  province(cityUrl,"u157_input",provinceId);
    		  $("#u158_input")[0].selectedIndex = -1;
	  		  $("#u159_input")[0].selectedIndex = -1;
	  		  $("#u158_input").html("");
	  		  $("#u159_input").html("");
    	  });
    	  
    	  //家庭乡
    	  $("#u157_input").change(function(){
    		  var provinceId = $("#u157_input").val();
    		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
    		  province(cityUrl,"u158_input",provinceId);
    		  $("#u159_input")[0].selectedIndex = -1;
	  		  $("#u159_input").html("");
    	  }); 
    	 
    	  //家庭村
    	  $("#u158_input").change(function(){
    		  var provinceId = $("#u158_input").val();
    		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
    		  province(cityUrl,"u159_input",provinceId);
    	  });
    	  
    	  //户口省份
    	 province(provinceUrl,"u115_input",null);
    		  
    	  //户口市
    	  $("#u115_input").change(function(){
    		  var provinceId = $("#u115_input").val();
    		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
    		  province(cityUrl,"u138_input",provinceId);
    		  $("#u139_input")[0].selectedIndex = -1;
	  		  $("#u140_input")[0].selectedIndex = -1;
	  		  $("#u141_input")[0].selectedIndex = -1;
	  		  $("#u139_input").html("");
	  		  $("#u140_input").html("");
	  		  $("#u141_input").html("");
    	  });
    	  
    	  //户口县
    	  $("#u138_input").change(function(){
    		  var provinceId = $("#u138_input").val();
    		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
    		  province(cityUrl,"u139_input",provinceId);
    		  $("#u140_input")[0].selectedIndex = -1;
	  		  $("#u141_input")[0].selectedIndex = -1;
	  		  $("#u140_input").html("");
	  		  $("#u141_input").html("");
    	  });
    	  
    	  //户口乡
    	  $("#u139_input").change(function(){
    		  var provinceId = $("#u139_input").val();
    		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
    		  province(cityUrl,"u140_input",provinceId);
    		  $("#u141_input")[0].selectedIndex = -1;
	  		  $("#u141_input").html("");
    	  });
    	
    	  //户口村
    	  $("#u140_input").change(function(){
    		  var provinceId = $("#u140_input").val();
    		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
    		  province(cityUrl,"u141_input",provinceId);
    	  });
    	  
    	  //根据出生日期改变年龄
    	  $("#u73_input").blur(function(){
    		  //debugger;
    		  var birthday = this.value;
    		  var nowdate = new Date();
    		  var age = nowdate.getFullYear() - birthday.substr(0,4);
    		  if(age > 100 || age < 0){
    			  $("#age").val("");
    		  }else{
    			  $("#age").val(age);
    		  }
    	  });
    	  $("#u137_input").blur(function(){
    		  var birthday = this.value;
    		  var nowdate = new Date();
    		  var age = nowdate.getFullYear() - birthday.substr(0,4);
    		  if(age > 100 || age < 0){
    			  $("#manAge").val("");
    		  }else{
    		  	$("#manAge").val(age);
    		  }
    	  });
    		
    	  var build = 0;
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
    		  
    		  if(nation == "" || nation == null){
    			  alert("请选择民族！");
    			  return false;
    		  }
    		  /* var tag2 = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X|x)$/;
    		  var idNo = $("#u27_input").val();
    		  if(idNo == "" || idNo == null){
    			  alert("请输入身份证号！");
    			  return false ;
    		  }
    		  if(!tag2.test(idNo)){
    			  alert("请输入正确的身份证号码！");
    			  return false;
    		  } */
    		  
    		  var birthday = $("#u73_input").val();
    		  if(birthday == "" || birthday == null){
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
    		  var accC = $("#u74_input").val();
    		  if(accC == "" || accC == null){
    			  alert("请选择户口市！");
    			  return false;
    		  }
    		  var accT = $("#u75_input").val();
    		  if(accT == "" || accT == null){
    			  alert("请选择户口县(区)！");
    			  return false;
    		  }
    		  var accS = $("#u76_input").val();
    		  if(accS == "" || accS == null){
    			  alert("请选择户口乡(街道)！");
    			  return false;
    		  }
    		  var accV = $("#u77_input").val();
    		  if(accV == "" || accV == null){
     			  alert("请选择户口村！");
     			  return false;
     		  } 
    		  
    		  var homeP = $("#u83_input").val();
    		  if(homeP == "" || homeP == null){
    			  alert("请选择家庭省！");
    			  return false;
    		  }
    		  var homeC = $("#u95_input").val();
    		  if(homeC == "" || homeC == null){
    			  alert("请选择家庭市！");
    			  return false;
    		  }
    		  var homeT = $("#u96_input").val();
    		  if(homeT == "" || homeT == null){
    			  alert("请选择家庭县(区)！");
    			  return false;
    		  }
    		  var homeS = $("#u97_input").val();
    		  if(homeS == "" || homeS == null){
    			  alert("请选择家庭乡(街道)！");
    			  return false;
    		  }
     		  var homeV = $("#u98_input").val();
     		  if(homeV == "" || homeV == null){
     			  alert("请选择家庭村！");
     			  return false;
    		  }
    		  
    		  var tag3 = /^1[34578]\d{9}$/;
    		  var tele = $("#u70_input").val();
    		  if(tele == "" || tele == null){
    			  alert("请输入联系电话！");
    			  return false;
    		  }
    		  if(!tag3.test(tele)){
    			  alert("请输入正确联系电话格式！");
    			  return false;
    		  }
    		  var lastMenses = $("#lastMenses").val();
    		  if(lastMenses == "" || lastMenses == null){
    			  alert("请输入末次月经");
    			  return false;
    		  }
    		  var predictDate = $("#predictDate").val();
    		  if(predictDate == "" || predictDate == null){
    			  alert("请输入预产期");
    			  return false;
    		  }
    		  
    		  var manName = $("#u104_input").val();
    		  if(manName == "" || manName == null){
    			  alert("请输入丈夫姓名！");
    			  return false;
    		  }
    		  if(!tag1.test(manName)){
    			  alert("请输入正确的丈夫姓名！");
    			  return false;
    		  }
    		  var sex = $("#u103_input").val();
    		  if(sex == "" || sex == null){
    			  alert("请选择性别！");
    			  return false;
    		  }
    		  var gen = $("#u107_input").val();
    		  if(gen == "" || gen == null){
    			  alert("请选择国籍！");
    			  return false;
    		  }
    		  var nation = $("#u129_input").val();
    		  
    		  if(nation == "" || nation == null){
    			  alert("请选择民族！");
    			  return false;
    		  }
    		  
    		  /* var manId = $("#u112_input").val();
    		  if(manId == "" || manId == null){
    			  alert("请输入丈夫身份证号！");
    			  return false;
    		  } */
    		  /* if(!tag2.test(manId)){
    			  alert("请输入格式正确的丈夫身份证号！");
    			  return false;
    		  }
    		  if(manId == idNo){
    			  alert("两人身份证号不能相同!");
    			  return false;
    		  } */
    		  var birthday = $("#u137_input").val();
    		  if(birthday == "" || birthday == null){
    			  alert("请选择对方出生日期！");
    			  return false;
    		  }
    		  var age = $("#manAge").val();
    		  if(age == "" || age == null){
    			  alert("对方年龄不能为空！");
    			  return false;
    		  }
    		  
    		  var manTel = $("#u134_input").val();
    		  if(manTel == "" || manTel == null){
    			  alert("请输入对方联系电话！");
    			  return false;
    		  }
    		  if(!tag3.test(manTel)){
    			  alert("请输入格式正确的对方联系电话！");
    			  return false;
    		  }
    		  
    		  
    		  var manAccP = $("#u115_input").val();
    		  if(manAccP == "" || manAccP == null){
    			  alert("请选择丈夫户口省！");
    			  return false;
    		  }
    		  var manAccC = $("#u138_input").val();
    		  if(manAccC == "" || manAccC == null){
    			  alert("请选择丈夫户口市！");
    			  return false;
    		  }
    		  var manAccT = $("#u139_input").val();
    		  if(manAccT == "" || manAccT == null){
    			  alert("请选择丈夫户口县(区)！");
    			  return false;
    		  }
    		  var manAccS = $("#u140_input").val();
    		  if(manAccS == "" || manAccS == null){
    			  alert("请选择丈夫户口乡(街道)！");
    			  return false;
    		  }
     		  var manAccV = $("#u141_input").val();
     		  if(manAccV == "" || accV == null){
     			  alert("请选择丈夫户口村！");
     			  return false;
     		  }
    		  
    		  var manHomeP = $("#u144_input").val();
    		  if(manHomeP == "" || manHomeP == null){
    			  alert("请选择丈夫家庭省！");
    			  return false;
    		  }
    		  var manHomeC = $("#u156_input").val();
    		  if(manHomeC == "" || manHomeC == null){
    			  alert("请选择丈夫家庭市！");
    			  return false;
    		  }
    		  var manHomeT = $("#u157_input").val();
    		  if(manHomeT == "" || manHomeT == null){
    			  alert("请选择丈夫家庭县(区)！");
    			  return false;
    		  }
    		  var manHomeS = $("#u158_input").val();
    		  if(manHomeS == "" || manHomeS == null){
    			  alert("请选择丈夫家庭乡(街道)！");
    			  return false;
    		  }
    		  var manHomeV = $("#u159_input").val();
     		  if(manHomeV == "" || manHomeV == null){
     			  alert("请选择丈夫家庭村！");
    			  return false;
     		  }
    		  var grant = $("#u161_input").val();
    		  if(grant == null || grant == undefined){
    			  $("#grantSign").attr("name","grantSign");
    		  }
			  
    		  
    		  
    		  var prenatalUrl = "${ctx}/archivesinfo/prenatalArchives";
    		  
   			  $.ajax({
   					url:prenatalUrl,
   					type:"POST",
   					data:$('#from').serialize(),
   					success:function(data){
   						$("#archivesId").val(data.archives.id);
   	 					$("#archivesNum").html("档案编号:"+data.archives.archivesCode);
   					}
   				});
   		  	  showDialog_("提示","addOrUpdateWin","moremiddleOver",false);
    		  build ++;
    	  });
		  
		//完成
		$("#u07").click(function(){
			window.location.href = "${ctx}/prenatal/list";
		});
		  
		//分娩登记
   		$("#u09").click(function(){
   			var archivesId = $("#archivesId").val();
   			window.location.href="${ctx}/archivesinfo/listChildbirth?id="+archivesId;
   		});
   		//产后访视
   		$("#u011").click(function(){
   			var archivesId = $("#archivesId").val();
   			window.location.href="${ctx}/postpartum/postpartumexainfo/list?archiveId="+archivesId+"&go=0 ";
   		});
   		//进入产检
   		$("#u013").click(function(){
   			var archivesId = $("#archivesId").val();
   			window.location.href="${ctx}/archivesinfo/comePrenatalExa?id="+archivesId;
   		});
   		
   		$("#lastMenses").blur(function(){
   			
   			var lastMenses = this.value;
   			getDirectDate(lastMenses,'predictDate');
   		});
   		
   		//同上功能
   		$("#u79").click(function(){
       			$("#u83_input").html($("#u30_input").html());
       			if($("#u30_input").val() != null){
	    	  		$("#u83_input").val($("#u30_input").val());
       			}else{
       				$("#u83_input")[0].selectedIndex = -1;
       			}
    	  		$("#u95_input").html($("#u74_input").html());
    	  		if($("#u74_input").val() != null){
    	  			$("#u95_input").val($("#u74_input").val());
    	  		}else{
    	  			$("#u95_input")[0].selectedIndex = -1;
    	  		}
    	  		$("#u96_input").html($("#u75_input").html());
    	  		if($("#u75_input").val() != null){
    	  			$("#u96_input").val($("#u75_input").val());
    	  		}else{
    	  			$("#u96_input")[0].selectedIndex = -1;
    	  		}
    	  		$("#u97_input").html($("#u76_input").html());
    	  		if($("#u76_input").val() != null){
    	  			$("#u97_input").val($("#u76_input").val());
    	  		}else{
    	  			$("#u97_input")[0].selectedIndex = -1;
    	  		}
    	  		$("#u98_input").html($("#u77_input").html());
    	  		if($("#u77_input").val() != null){
    	  			$("#u98_input").val($("#u77_input").val());
    	  		}else{
    	  			$("#u98_input")[0].selectedIndex = -1;
    	  		}
    	  		$("#u84_input").val($("#u40_input").val());
       		});
   		$("#u143").click(function(){
   			$("#u144_input").html($("#u115_input").html());
   			if($("#u115_input").val() != null){
	  			$("#u144_input").val($("#u115_input").val());
	  		}else{
	  			$("#u144_input")[0].selectedIndex = -1;
	  		}
  		    $("#u156_input").html($("#u138_input").html());
  		  	if($("#u138_input").val() != null){
  		  		$("#u156_input").val($("#u138_input").val());
	  		}else{
	  			$("#u156_input")[0].selectedIndex = -1;
	  		}
  		    $("#u157_input").html($("#u139_input").html());
  		  	if($("#u139_input").val() != null){
  		  		$("#u157_input").val($("#u139_input").val());
	  		}else{
	  			$("#u157_input")[0].selectedIndex = -1;
	  		}
  		    $("#u158_input").html($("#u140_input").html());
  		  	if($("#u140_input").val() != null){
  		  		$("#u158_input").val($("#u140_input").val());
	  		}else{
	  			$("#u158_input")[0].selectedIndex = -1;
	  		}
  		    $("#u159_input").html($("#u141_input").html());
  		  	if($("#u141_input").val() != null){
  		  		$("#u159_input").val($("#u141_input").val());
	  		}else{
	  			$("#u159_input")[0].selectedIndex = -1;
	  		}
  		    $("#u145_input").val($("#u116_input").val());
   		});
    		
    	});
    	
    	function getDirectDate(lastMenses,predictId){

    		var year = parseInt(lastMenses.substr(0,4));
    		
    		var month = parseInt(lastMenses.substr(4,2));
    		
    		var day = parseInt(lastMenses.substr(6,2));
    		
    		/* month += 9;
    		if(month > 12){
    			month -= 12;
    			year += 1;
    		} */
    		var date = year+"-"+month+"-"+day;
    		var lastDate = new Date(date);
    		var eceute = lastDate.getTime() + 280*(1000*24*60*60);
    		var ecDate = new Date(eceute);
    		var ecMonth = ecDate.getMonth();
    		ecMonth += 1;
    		if(ecMonth < 10){
    			ecMonth = "0"+ecMonth;
    		}
    		var ecDay = ecDate.getDate();
    		if(ecDay<10){
    			ecDay = "0"+ecDay;
    		}
    		var predict = ecDate.getFullYear()+""+ecMonth+""+ecDay;
    		//alert(predict);
    		var length = predict.length;
    		if(length == 8){
	    		$("#"+predictId).val(predict);
    		}
    	}
		//如果叶酸发放为否，改变叶酸发放数量为0，状态为只读，不能修改	
    	function only(){
    		if($("#u161_input").val()=="0"){
    			$("#u162_input").val("0");
    			$("#u162_input")[0].readOnly = true;
    		}else{
    			$("#u162_input").val("");
    			$("#u162_input")[0].readOnly = false;
    		}
    	};
    
    </script>
  </head>
  <body style="border: 0px solid;">
  
  	<form action="" method="post" id="from">
    <div id="base" class="">
    
      <div id="title">
      	<div id="u4" class="ax_文本段落">
          <p id="u5"><span>档案编号:&nbsp;<input style="border: 1px solid #CCCCCC;position: absolute;top: -3px;"/></span></p>
      	</div>
        <input type="hidden" id="archivesId" value=""/>
        <div id="u8" class="ax_文本段落">
          <p id="u9"><span>建档医院:&nbsp;${operator.department }</span></p>
     	</div>
        
        <div id="u10" class="ax_文本段落">
          <p id="u11"><span>建档医生：&nbsp;${operator.realName }</span></p>
        </div>
        
        <div id="u6" class="ax_文本段落">
          <input type="hidden" name="createTime" value="${time }"/>
          <p id="u7"><span>建档日期：&nbsp;${time }</span></p>
      </div>
        
      </div>
      <div id="u167" class="ax_形状" style="background-color:#EE5F45">
          <p id="u168"><span>孕产妇信息</span></p>
      </div>
      
      <div id="">
      
      	<div id="u2" class="ax_形状" style="border:1px solid #CCCCCC">
        <div id="u3" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>
      	
        <div id="u14" class="ax_文本段落">
          <p id="u15"><span>姓&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;名：</span></p>
      	</div>
      	<div id="u19" class="ax_文本框">
        	<input id="u19_input" type="text" name="name" placeholder="孕产妇姓名" value=""/>
      	</div>
      
      	<div id="u16" class="ax_文本段落">
          <p id="u17"><span>性&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;别：</span></p>
      	</div>
        <div id="u18" class="ax_下拉列表框">
            <select id="u18_input" name="sex" data-label="性别">
              <option selected value="0">女</option>
              <option value="1">男</option>
              <option value="2">性别不明</option>
            </select>
      	</div>
      	
        <div id="u20" class="ax_文本段落">
          <p id="u21"><span>国&nbsp; &nbsp; &nbsp;&nbsp;籍：</span></p>
      	</div>
        <div id="u22" class="ax_下拉列表框">
            <select id="u22_input" name="international">
              <option value="0">中国</option>
              <option value="1">外国</option>
            </select>
      	</div>
        
        <div id="u57" class="ax_文本段落">
          <p id="u58"><span>民&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;族：</span></p>
      	</div>
        <div id="u59" class="ax_下拉列表框">
            <select id="u59_input" name="nation">
              <option value="汉">汉</option>
              <option value="回">回</option>
              <option value="其他">其他</option>
            </select>
      	</div>
        
        <div id="u25" class="ax_文本段落">
          <p id="u26"><span>身份证号</span><span>：</span></p>
      	</div>
        <div id="u27" class="ax_文本框">
        <input id="u27_input" type="text" name="idNo" placeholder="18位身份证号码" value=""/>
      	</div>
        
        <div id="u71" class="ax_文本段落">
          <p id="u72"><span>出生日期：</span></p>
      	</div>
        <div id="u73" class="ax_文本框">
        	<!-- <input id="u73_input" type="date" value="根据身份证自动显示"/> -->
        	<input type="text" id="u73_input" name="birthday" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
      	</div>
        
        <div id="u23" class="ax_文本段落">
          <p id="u24"><span>年&nbsp; &nbsp; &nbsp;&nbsp;龄：&nbsp;&nbsp;<input id="age" type="text" style="position:absolute;left:68px;top:-3px;border-color: #c8c9cd;border-style: solid;border-width: 1px; width:45px;height: 25px;" value=""><span style="position:absolute;left:117px;top:2px;">岁</span></span></p>
      	</div>
        
        <div id="u34" class="ax_文本段落">
          <p id="u35"><span>文化程度：</span></p>
      	</div>
        <div id="u39" class="ax_下拉列表框">
            <select id="u39_input" name="education">
              <option value="9">不详</option>
              <option value="0">小学</option>
              <option value="1">初中</option>
              <option selected value="2">高中</option>
              <option value="3">技校</option>
              <option value="4">专科</option>
              <option value="5">本科</option>
              <option value="6">研究生</option>
              <option value="7">博士</option>
              <option value="8">无</option>
            </select>
      	</div>
        
        <div id="u60" class="ax_文本段落">
          <p id="u61"><span>户籍类型：</span></p>
      	</div>
        <div id="u62" class="ax_下拉列表框">
            <select id="u62_input" name="householdType">
              <option selected value="0">本地</option>
              <option value="1">外地</option>
            </select>
      	</div>
        
        <div id="u63" class="ax_文本段落">
          <p id="u64"><span>户口类型：</span></p>
      	</div>
        <div id="u65" class="ax_下拉列表框">
            <select id="u65_input" name="accountType">
              <option value="1">非农户籍</option>
              <option value="0">农业户籍</option>
            </select>
        </div>
        
        <div id="u31" class="ax_文本段落">
          <p id="u32"><span>职&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;业：</span></p>
      	</div>
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
        
        <div id="u36" class="ax_文本段落">
          <p id="u37"><span>工作单位：</span></p>
      	</div>
        <div id="u38" class="ax_文本框">
        	<input id="u38_input" type="text" name="workUnit" placeholder="工作单位" value=""/>
      	</div>
        
        <div id="u28" class="ax_文本段落">
          <p id="u29"><span>户口地址：</span></p>
      	</div>
        <div id="u30" class="ax_下拉列表框">
            <select id="u30_input" name="accProvinceId">
        	</select>
      	</div>
        <div id="u41" class="ax_文本段落">
          <p id="u42"><span>省</span></p>
     	</div>
        
        
        <div id="u74" class="ax_下拉列表框">
        	<select id="u74_input" name="accCityId">
       	 	</select>
   	    </div>
        <div id="u43" class="ax_文本段落">
          <p id="u44"><span>市</span></p>
      	</div>
        
        <div id="u75" class="ax_下拉列表框">
            <select id="u75_input" name="accCountyId">
            </select>
      	</div>
        <div id="u45" class="ax_文本段落">
          <p id="u46"><span>县（区）</span></p>
     	</div>
        
        <div id="u76" class="ax_下拉列表框">
            <select id="u76_input" name="accTownshipId">
            </select>
      	</div>
         <div id="u47" class="ax_文本段落">
          <p id="u48"><span>乡（街道）</span></p>
         </div>
        
        <div id="u77" class="ax_下拉列表框">
            <select id="u77_input" name="accVillageId">
            </select>
     	</div>
        <div id="u49" class="ax_文本段落">
          <p id="u50"><span>村</span></p>
        </div>
        
        <div id="u40" class="ax_文本框">
        	<input id="u40_input" name="accAddress" type="text" placeholder="非必填项" value=""/>
      	</div>
        
        <div id="u66" class="ax_文本段落">
          <p id="u67"><span>家庭地址：</span></p>
        </div>
        <div id="u83" class="ax_下拉列表框">
            <select id="u83_input" name="homeProvinceId">
            </select>
      	</div>
        <div id="u85" class="ax_文本段落">
          <p id="u86"><span>省</span></p>
        </div>
        
        <div id="u95" class="ax_下拉列表框"><span class="ax_形状" style="background-color:#FFFFFF">
          <select id="u95_input" name="homeCityId">
          </select>
        </span></div>
        <div id="u87" class="ax_文本段落">
          <p id="u88"><span>市</span></p>
        </div>
        
        <div id="u96" class="ax_下拉列表框">
            <select id="u96_input" name="homeCountyId">
            </select>
      	</div>
        <div id="u89" class="ax_文本段落">
          <p id="u90"><span>县（区）</span></p>
        </div>
        
        <div id="u97" class="ax_下拉列表框">
            <select id="u97_input" name="homeTownshipId">
            </select>
      	</div>
        <div id="u91" class="ax_文本段落">
          <p id="u92"><span>乡（街道）</span></p>
        </div>
        
        <div id="u98" class="ax_下拉列表框">
            <select id="u98_input" name="homeVillageId">
            </select>
      	</div>
        <div id="u93" class="ax_文本段落">
          <p id="u94"><span>村</span></p>
        </div>
        
        <div id="u84" class="ax_文本框">
        	<input id="u84_input" name="homeAddress" type="text" placeholder="非必填项" value=""/>
      	</div>
        <div id="u78" class="ax_文本段落">
          <p id="u79" style="cursor: pointer;"><span>同上</span></p>
        </div>
        
        <div id="u68" class="ax_文本段落">
          <p id="u69"><span>联系电话：</span></p>
        </div>
        <div id="u70" class="ax_文本框">
        	<input id="u70_input" type="text" name="telephone" placeholder="11位手机号" value=""/>
      	</div>
        
        <div id="u80" class="ax_文本段落">
          <p id="u81"><span>紧急电话：</span></p>
        </div>
        <div id="u82" class="ax_文本框">
        	<input id="u82_input" name="urgentCall" type="text" placeholder="非必填项" value=""/>
      	</div>
        
        <div style="position: absolute;left: 610px;top: 259px; width: 82px;height: 15px;" class="ax_文本段落">
          <p id="u81"><span>末次月经：</span></p>
        </div>
        <div  class="ax_文本框" style="position: absolute;left: 679px;top: 254px;width: 145px;height: 25px;">
        	<input type="text" id="lastMenses" name="lastMenses" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"
        style="color:#333333;cursor:pointer;"  
        class="Wdate" value="" tabindex="1" required>
      	</div>
        
        <div style="position: absolute;left: 879px;top: 259px; width: 82px;height: 15px;"  class="ax_文本段落">
          <p id="u81"><span>预&nbsp;&nbsp;产&nbsp;&nbsp;期：</span></p>
        </div>
        <div id="u82" class="ax_文本框" style="position: absolute;left: 949px;top: 254px;width: 145px;height: 25px;">
        	<input type="text" id="predictDate" name="predictDate" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"
        style="color:#333333;cursor:pointer;"  
        class="Wdate" value="" tabindex="1" required>
      	</div>
      
      </div>
      
      <div id="u165" class="ax_形状" style="background-color:#EE5F45">
          <p id="u166"><span>丈夫信息</span></p>
      </div>
      
      <div id="manMsg">
      
      	<div id="u12" class="ax_形状" style="border:1px solid #CCCCCC">
          <div id="u13" class="text">
              <p><span>&nbsp;</span></p>
            </div>
      	</div>
      	
        <div id="u99" class="ax_文本段落">
          <p id="u100"><span>丈夫姓名：</span></p>
        </div>
        <div id="u104" class="ax_文本框">
        	<input id="u104_input" name="manName" type="text" placeholder="丈夫姓名" value=""/>
      	</div>
        
        <div id="u101" class="ax_文本段落">
          <p id="u102"><span>性&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;别：</span></p>
        </div>
        <div id="u103" class="ax_下拉列表框">
            <select id="u103_input" name="manSex" data-label="性别">
              <option selected value="1">男</option>
              <option value="0">女</option>
              <option value="2">性别不明</option>
            </select>
      	</div>
        
        <div id="u105" class="ax_文本段落">
          <p id="u106"><span>国&nbsp; &nbsp;&nbsp;&nbsp;籍：</span></p>
        </div>
        <div id="u107" class="ax_下拉列表框">
            <select id="u107_input" name="manInte">
              <option value="0">中国</option>
              <option value="1">外国</option>
            </select>
      	</div>
        
        <div id="u127" class="ax_文本段落">
          <p id="u128"><span>民&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;族 ：</span></p>
        </div>
        <div id="u129" class="ax_下拉列表框">
            <select id="u129_input" name="manNation">
              <option value="汉">汉</option>
              <option value="回">回</option>
              <option value="其他">其他</option>
            </select>
      	</div>
      
      	<div id="u110" class="ax_文本段落">
          <p id="u111"><span>身份证号：</span></p>
        </div>
        <div id="u112" class="ax_文本框">
        	<input id="u112_input" name="manIdNo" type="text" placeholder="18位身份证号码" value=""/>
      	</div>
        
        <div id="u135" class="ax_文本段落">
          <p id="u136"><span>出生日期：</span></p>
        </div>
        <div id="u137" class="ax_文本框">
        	<!-- <input id="u137_input" type="date" value="根据身份证自动显示"/> -->
        	<input type="text" id="u137_input" name="manBirthday" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="" tabindex="1" required>
      	</div>
        
        <div id="u108" class="ax_文本段落">
          <p id="u109"><span>年&nbsp; &nbsp;&nbsp;&nbsp;龄：<input id="manAge" type="text" style="position:absolute;left:68px;top:-5px;border-color: #c8c9cd;border-style: solid;border-width: 1px; width:45px;height: 25px;" value=""><span style="position:absolute;left:117px;top:2px;">岁</span></span></p>
        </div>
        
        <div id="u132" class="ax_文本段落">
          <p id="u133"><span>联系电话：</span></p>
        </div>
        <div id="u134" class="ax_文本框">
        	<input id="u134_input" type="text" name="manTele" placeholder="11位手机号" value=""/>
      	</div>
        
        <div id="u113" class="ax_文本段落">
          <p id="u114"><span>户口地址：</span></p>
        </div>
        <div id="u115" class="ax_下拉列表框">
            <select id="u115_input" name="manAccProvinceId">
            </select>
      	</div>
        <div id="u117" class="ax_文本段落">
          <p id="u118"><span>省</span></p>
        </div>
        
        <div id="u138" class="ax_下拉列表框">
            <select id="u138_input" name="manAccCityId">
            </select>
      	</div>
        <div id="u119" class="ax_文本段落">
          <p id="u120"><span>市</span></p>
        </div>
        
        <div id="u139" class="ax_下拉列表框">
            <select id="u139_input" name="manAccCountyId">
            </select>
      	</div>
        <div id="u121" class="ax_文本段落">
          <p id="u122"><span>县（区）</span></p>
        </div>
		
        <div id="u140" class="ax_下拉列表框">
            <select id="u140_input" name="manAccTownshipId">
            </select>
      	</div>
        <div id="u123" class="ax_文本段落">
          <p id="u124"><span>乡（街道）</span></p>
        </div>
        
        <div id="u141" class="ax_下拉列表框">
            <select id="u141_input" name="manAccVillageId">
            </select>
      	</div>
        <div id="u125" class="ax_文本段落">
          <p id="u126"><span>村</span></p>
        </div>
        <div id="u116" class="ax_文本框">
        	<input id="u116_input" name="manAccAddress" type="text" placeholder="非必填项" value=""/>
      	</div>
        
        <div id="u130" class="ax_文本段落">
          <p id="u131"><span>家庭地址：</span></p>
        </div>
        
        <div id="u144" class="ax_下拉列表框">
            <select id="u144_input" name="manHomeProvinceId">
            </select>
      	</div>
        <div id="u146" class="ax_文本段落">
          <p id="u147"><span>省</span></p>
        </div>
        
        <div id="u156" class="ax_下拉列表框">
            <select id="u156_input" name="manHomeCityId">
            </select>
      	</div>
        <div id="u148" class="ax_文本段落">
          <p id="u149"><span>市</span></p>
        </div>
        
        <div id="u157" class="ax_下拉列表框">
            <select id="u157_input" name="manHomeCountyId">
            </select>
      	</div>
        <div id="u150" class="ax_文本段落">
          <p id="u151"><span>县（区）</span></p>
        </div>
        
        <div id="u158" class="ax_下拉列表框">
            <select id="u158_input" name="manHomeTownshipId">
            </select>
      	</div>
        <div id="u152" class="ax_文本段落">
          <p id="u153"><span>乡（街道）</span></p>
        </div>
        
        <div id="u159" class="ax_下拉列表框">
            <select id="u159_input" name="manHomeVillageId">
            </select>
      	</div>
        <div id="u154" class="ax_文本段落">
          <p id="u155"><span>村</span></p>
        </div>
        
      	<div id="u145" class="ax_文本框">
        	<input id="u145_input" name="manHomeAddress" type="text" placeholder="非必填项" value=""/>
      	</div>
        <div id="u142" class="ax_文本段落">
          <p id="u143" style="cursor: pointer;"><span>同上</span></p>
        </div>
      
      </div>
      
      <div id="u163" class="ax_形状" style="background-color:#EE5F45">
          <p id="u164"><span>其他信息</span></p>
        </div>
      </div>
      
      <div id="otherMsg">
      	
        <div id="u0" class="ax_形状" style="border:1px solid #CCCCCC">
            <div id="u1" class="text">
              <p><span>&nbsp;</span></p>
            </div>
      	</div>
        
        <div id="u51" class="ax_文本段落">
          <p id="u52"><span>母子健康手册发放：</span></p>
        </div>
        <div id="u160" class="ax_下拉列表框">
        	<input type="hidden" id="grantSign" value=""/>
            <select id="u160_input" name="grantSign">
              <option value="1">是</option>
              <option value="0">否</option>
            </select>
      	</div>
		
		<div id="u53" class="ax_文本段落">
          <p id="u54"><span>叶酸发放：</span></p>
        </div>
        <div id="u161" class="ax_下拉列表框">
            <select id="u161_input" onchange="only()">
              <option value="1">是</option>
              <option value="0">否</option>
            </select>
      	</div>
        
        <div id="u55" class="ax_文本段落">
          <p id="u56"><span>发放数量：&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;</span></p>
        </div>
        <div id="u162" class="ax_文本框">
        	<input id="u162_input" name="frantNum" type="text" placeholder="填写数量" value=""/>
      	</div>
            
      </div>

      <div id="u169" class="ax_形状" style="background-color:#009DD9">
          <p id="u170"><span id="build" style="cursor:pointer">确认建档</span></p>
      </div>
      
      
    </div>
  </form>
  
  <div id="addOrUpdateWin" class="easyui-dialog" title="角色" closed="true">

      <!-- Unnamed (形状) -->
      <div id="u00" class="ax_形状">
        <div id="u01" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u02" class="ax_文本段落">
          <p id="u03"><span>建档成功！</span></p><p><span>&nbsp;</span></p><p><span>&nbsp;</span></p><p><span id="archivesNum">档案编号：</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <!-- <div id="u04" class="ax_形状" style="background-color:#EE5F45">
          <p id="u05"><span>提&nbsp; &nbsp; 示</span></p>
      </div> -->

      <!-- Unnamed (形状) -->
      <div id="u06" class="ax_形状" style="background-color:#34A097">
          <p id="u07"><span style="cursor:pointer">完成</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u08" class="ax_形状" style="background-color:#009DD9">
          <p id="u09"><span style="cursor:pointer">分娩登记</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u010" class="ax_形状" style="background-color:#56BB4D">
          <p id="u011"><span style="cursor:pointer">产后访视</span></p>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u012" class="ax_形状" style="background-color:#E9854F">
          <p id="u013"><span style="cursor:pointer">进入产检</span></p>
      </div>
      
    </div>
  
  </body>
</html>
