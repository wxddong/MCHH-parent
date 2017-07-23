<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <script type="text/javascript">
    function getDirectDate(lastMenses,predictId){
		//debugger;
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
    	$(function(){
    		$("#lastMenses").blur(function(){
       			var lastMenses = this.value;
       			getDirectDate(lastMenses,'predictDate');
       		});
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
    					var manAccPro = $("#manAccPro").val()
				  		if(manAccPro == "" || manAccPro == null){
				  			
				  			$("#upu115_input")[0].selectedIndex = -1;
				  		}
				  		var manHomePro = $("#manHomePro").val()
				  		if(manAccPro == "" || manAccPro == null){
				  			$("#upu144_input")[0].selectedIndex = -1;
				  		}
    				}
    			});
    		  };
    		
    		//家庭省份
     		provinces(provinceUrl,"upu83_input","homePro");
      	  
      	  //家庭市
      	  $("#upu83_input").change(function(){
      		  var provinceId = $("#upu83_input").val();
      		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
      		  province(cityUrl,"upu95_input",provinceId);
      		  $("#upu96_input")[0].selectedIndex = -1;
	  		  $("#upu97_input")[0].selectedIndex = -1;
	  		  $("#upu98_input")[0].selectedIndex = -1;
	  		  $("#upu96_input").html("");
	  		  $("#upu97_input").html("");
	  		  $("#upu98_input").html("");
      	  });
      	  
      	  //家庭县
      	  $("#upu95_input").change(function(){
      		  var provinceId = $("#upu95_input").val();
      		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
      		  province(cityUrl,"upu96_input",provinceId);
      		  $("#upu97_input")[0].selectedIndex = -1;
	  		  $("#upu98_input")[0].selectedIndex = -1;
	  		  $("#upu97_input").html("");
	  		  $("#upu98_input").html("");
      	  });
      	  
      	  //家庭乡
      	  $("#upu96_input").change(function(){
      		  var provinceId = $("#upu96_input").val();
      		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
      		  province(cityUrl,"upu97_input",provinceId);
      		  $("#upu98_input")[0].selectedIndex = -1;
	  		  $("#upu98_input").html("");
      	  }); 
      	 
      	  //家庭村
      	  $("#upu97_input").change(function(){
      		  var provinceId = $("#upu97_input").val();
      		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
      		  province(cityUrl,"upu98_input",provinceId);
      	  });
      	  
      	  //户口省份
      	 provinces(provinceUrl,"upu30_input","accPro");
      		  
      	  //户口市
      	  $("#upu30_input").change(function(){
      		  var provinceId = $("#upu30_input").val();
      		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
      		  province(cityUrl,"upu74_input",provinceId);
      		  $("#upu75_input")[0].selectedIndex = -1;
	  		  $("#upu76_input")[0].selectedIndex = -1;
	  		  $("#upu77_input")[0].selectedIndex = -1;
	  		  $("#upu75_input").html("");
	  		  $("#upu76_input").html("");
	  		  $("#upu77_input").html("");
      	  });
      	  
      	  //户口县
      	  $("#upu74_input").change(function(){
      		  var provinceId = $("#upu74_input").val();
      		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
      		  province(cityUrl,"upu75_input",provinceId);
      		  $("#upu76_input")[0].selectedIndex = -1;
	  		  $("#upu77_input")[0].selectedIndex = -1;
	  		  $("#upu77_input").html("");
	  		  $("#upu76_input").html("");
      	  });
      	  
      	  //户口乡
      	  $("#upu75_input").change(function(){
      		  var provinceId = $("#upu75_input").val();
      		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
      		  province(cityUrl,"upu76_input",provinceId);
      		  $("#upu77_input")[0].selectedIndex = -1;
	  		  $("#upu77_input").html("");
      	  });
      	
      	  //户口村
      	  $("#upu76_input").change(function(){
      		  var provinceId = $("#upu76_input").val();
      		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
      		  province(cityUrl,"upu77_input",provinceId);
      	  });
      	  
      	  //男方
      	//家庭省份
   		  provinces(provinceUrl,"upu144_input","manHomePro");
    	  
    	  //家庭市
    	  $("#upu144_input").change(function(){
    		  var provinceId = $("#upu144_input").val();
    		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
    		  province(cityUrl,"upu156_input",provinceId);
    		  $("#upu157_input")[0].selectedIndex = -1;
	  		  $("#upu158_input")[0].selectedIndex = -1;
	  		  $("#upu159_input")[0].selectedIndex = -1;
	  		  $("#upu157_input").html("");
	  		  $("#upu158_input").html("");
	  		  $("#upu159_input").html("");
    	  });
    	  
    	  //家庭县
    	  $("#upu156_input").change(function(){
    		  var provinceId = $("#upu156_input").val();
    		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
    		  province(cityUrl,"upu157_input",provinceId);
    		  $("#upu158_input")[0].selectedIndex = -1;
	  		  $("#upu159_input")[0].selectedIndex = -1;
	  		  $("#upu159_input").html("");
	  		  $("#upu158_input").html("");
    	  });
    	  
    	  //家庭乡
    	  $("#upu157_input").change(function(){
    		  var provinceId = $("#upu157_input").val();
    		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
    		  province(cityUrl,"upu158_input",provinceId);
    		  $("#upu159_input")[0].selectedIndex = -1;
	  		  $("#upu159_input").html("");
    	  }); 
    	 
    	  //家庭村
    	  $("#upu158_input").change(function(){
    		  var provinceId = $("#upu158_input").val();
    		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
    		  province(cityUrl,"upu159_input",provinceId);
    	  });
    	  
    	  //户口省份
    	 provinces(provinceUrl,"upu115_input","manAccPro");
    		  
    	  //户口市
    	  $("#upu115_input").change(function(){
    		  var provinceId = $("#upu115_input").val();
    		  var cityUrl = "${ctx}/config/cityInfo/cityByProvinceId";
    		  province(cityUrl,"upu138_input",provinceId);
    		  $("#upu139_input")[0].selectedIndex = -1;
	  		  $("#upu140_input")[0].selectedIndex = -1;
	  		  $("#upu141_input")[0].selectedIndex = -1;
	  		  $("#upu139_input").html("");
	  		  $("#upu140_input").html("");
	  		  $("#upu141_input").html("");
    	  });
    	  
    	  //户口县
    	  $("#upu138_input").change(function(){
    		  var provinceId = $("#upu138_input").val();
    		  var cityUrl = "${ctx}/config/districtAndCountyInfo/countyByCityId";
    		  province(cityUrl,"upu139_input",provinceId);
    		  $("#upu140_input")[0].selectedIndex = -1;
	  		  $("#upu141_input")[0].selectedIndex = -1;
	  		  $("#upu141_input").html("");
	  		  $("#upu140_input").html("");
    	  });
    	  
    	  //户口乡
    	  $("#upu139_input").change(function(){
    		  var provinceId = $("#upu139_input").val();
    		  var cityUrl = "${ctx}/config/townshipinfo/townshipByCountyId";
    		  province(cityUrl,"upu140_input",provinceId);
    		  $("#upu141_input")[0].selectedIndex = -1;
	  		  $("#upu141_input").html("");
    	  });
    	
    	  //户口村
    	  $("#upu140_input").change(function(){
    		  var provinceId = $("#upu140_input").val();
    		  var cityUrl = "${ctx}/config/villageInfo/villageByTownshipId";
    		  province(cityUrl,"upu141_input",provinceId);
    	  });
    	  
    	  //根据出生日期改变年龄
    	  $("#upu73_input").blur(function(){
    		  var birthday = this.value;
    		  var nowdate = new Date();
    		  var age = nowdate.getFullYear() - birthday.substr(0,4);
    		  $("#age").html(age);
    	  });
    	  $("#upu137_input").blur(function(){
    		  var birthday = this.value;
    		  var nowdate = new Date();
    		  var age = nowdate.getFullYear() - birthday.substr(0,4);
    		  $("#manAge").html(age);
    	  });
    	  
    	  $("#nu161").click(function(){
    		  
    		  var birthday = $("#upu73_input").val();
    		  if(birthday == "" || birthday == null){
    			  alert("请选择出生日期！");
    			  return false;
    		  }
    		  var occu = $("#upu33_input").val();
    		  var workUnit = $("#upu38_input").val();
    		  workUnit = $.trim(workUnit);
    		  if(occu != 0){
	    		  if(workUnit == "" || workUnit == null){
	    			  alert("请输入工作单位！");
	    			  return false;
	    		  }
    		  }
    		  
    		  var accP = $("#upu30_input").val();
    		  if(accP == "" || accP == null){
    			  alert("请选择户口省！");
    			  return false;
    		  }
    		  var accC = $("#upu74_input").val();
    		  if(accC == "" || accC == null){
    			  alert("请选择户口市！");
    			  return false;
    		  }
    		  var accT = $("#upu75_input").val();
    		  if(accT == "" || accT == null){
    			  alert("请选择户口县(区)！");
    			  return false;
    		  }
    		  var accS = $("#upu76_input").val();
    		  if(accS == "" || accS == null){
    			  alert("请选择户口乡(街道)！");
    			  return false;
    		  }
     		  var accV = $("#upu77_input").val();
     		  if(accV == "" || accV == null){
     			  alert("请选择户口村！");
     			  return false;
     		  }
    		  
    		  var homeP = $("#upu83_input").val();
    		  if(homeP == "" || homeP == null){
    			  alert("请选择家庭省！");
    			  return false;
    		  }
    		  var homeC = $("#upu95_input").val();
    		  if(homeC == "" || homeC == null){
    			  alert("请选择家庭市！");
    			  return false;
    		  }
    		  var homeT = $("#upu96_input").val();
    		  if(homeT == "" || homeT == null ){
    			  alert("请选择家庭县(区)！");
    			  return false;
    		  }
    		  var homeS = $("#upu97_input").val();
    		  if(homeS == "" || homeS == null ){
    			  alert("请选择家庭乡(街道)！");
    			  return false;
    		  }
     		  var homeV = $("#upu98_input").val();
     		  if(homeV == "" || homeV == null ){
    			  alert("请选择家庭村！");
    			  return false;
     		  }
    		  
    		  var tag3 = /^1[34578]\d{9}$/;
    		  var telephone = $("#upu70_input").val();
    		  //alert(telephone);
    		  if(telephone == "" || telephone == null){
    			  alert("请输入联系电话！");
    			  return false;
    		  }
    		  if(!tag3.test(telephone)){
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
    		  var tag1 = /[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/;
    		  var manName = $("#upu104_input").val();
    		  if(manName == "" || manName == null){
    			  alert("请输入对方姓名！");
    			  return false;
    		  }
    		  if(!tag1.test(manName)){
    			  alert("请输入格式正确的对方姓名！");
    			  return false;
    		  }
    		  var birthday = $("#upu137_input").val();
    		  if(birthday == "" || birthday == null){
    			  alert("请选择出生日期！");
    			  return false;
    		  }
    		  
    		  
    		  var manTel = $("#upu134_input").val();
    		  if(manTel == "" || manTel == null){
    			  alert("请输入对方联系电话！");
    			  return false;
    		  }
    		  if(!tag3.test(manTel)){
    			  alert("请输入格式正确的对方联系电话！");
    			  return false;
    		  }
    		  
    		  
    		  var manAccP = $("#upu115_input").val();
    		  if(manAccP == "" || manAccP == null){
    			  alert("请选择丈夫户口省！");
    			  return false;
    		  }
    		  var manAccC = $("#upu138_input").val();
    		  if(manAccC == "" || manAccC == null){
    			  alert("请选择丈夫户口市！");
    			  return false;
    		  }
    		  var manAccT = $("#upu139_input").val();
    		  if(manAccT == "" || manAccT == null){
    			  alert("请选择丈夫户口县(区)！");
    			  return false;
    		  }
    		  var manAccS = $("#upu140_input").val();
    		  if(manAccS == "" || manAccS == null){
    			  alert("请选择丈夫户口乡(街道)！");
    			  return false;
    		  }
     		  var manAccV = $("#upu141_input").val();
     		  if(manAccV == "" || accV == null){
     			  alert("请选择丈夫户口村！");
     			  return false;
     		  }
    		  
    		  var manHomeP = $("#upu144_input").val();
    		  if(manHomeP == "" || manHomeP == null){
    			  alert("请选择丈夫家庭省！");
    			  return false;
    		  }
    		  var manHomeC = $("#upu156_input").val();
    		  if(manHomeC == "" || manHomeC == null){
    			  alert("请选择丈夫家庭市！");
    			  return false;
    		  }
    		  var manHomeT = $("#upu157_input").val();
    		  if(manHomeT == "" || manHomeT == null){
    			  alert("请选择丈夫家庭县(区)！");
    			  return false;
    		  }
    		  var manHomeS = $("#upu158_input").val();
    		  if(manHomeS == "" || manHomeS == null){
    			  alert("请选择丈夫家庭乡(街道)！");
    			  return false;
    		  }
     		  var manHomeV = $("#upu159_input").val();
     		  if(manHomeV == "" || manHomeV == null){
    			  alert("请选择丈夫家庭村！");
     			  return false;
     		  }
    		  
    		  $("#form").submit();
    		  
    	  });
    	  $("#nu1610").click(function(){
    		  closeDialog_();
   			//window.location="${ctx}/prenatal/list";
  		  });
    	  var manInte = $("#manInte").val();
    	  //alert(manInte);
    	  if(manInte == null||manInte == ""){
    		 
    		  $("#upu107_input")[0].selectedIndex = -1;
    	  }
    	  var manNation = $("#manNation").val();
    	  //alert(manNation);
    	  if(manInte == null||manInte == ""){
    		  
    		  $("#upu129_input")[0].selectedIndex = -1;
    	  }
    	  
    	//同上功能
     		$("#upu79").click(function(){
     			$("#upu83_input").html($("#upu30_input").html());
     			if($("#upu30_input").val() != null){
	    	  		$("#upu83_input").val($("#upu30_input").val());
     			}else{
     				$("#upu83_input")[0].selectedIndex = -1;
     			}
	  	  		$("#upu95_input").html($("#upu74_input").html());
	  	  		if($("#upu74_input").val() != null){
	  	  			$("#upu95_input").val($("#upu74_input").val());
	  	  		}else{
	  	  			$("#upu95_input")[0].selectedIndex = -1;
	  	  		}
	  	  		$("#upu96_input").html($("#upu75_input").html());
	  	  		if($("#upu75_input").val() != null){
	  	  			$("#upu96_input").val($("#upu75_input").val());
	  	  		}else{
	  	  			$("#upu96_input")[0].selectedIndex = -1;
	  	  		}
	  	  		$("#upu97_input").html($("#upu76_input").html());
	  	  		if($("#upu76_input").val() != null){
	  	  			$("#upu97_input").val($("#upu76_input").val());
	  	  		}else{
	  	  			$("#upu97_input")[0].selectedIndex = -1;
	  	  		}
	  	  		$("#upu98_input").html($("#upu77_input").html());
	  	  		if($("#upu77_input").val() != null){
  	  				$("#upu98_input").val($("#upu77_input").val());
  	  			}else{
  	  				$("#upu98_input")[0].selectedIndex = -1;
  	  			}
	  	  		$("#upu84_input").val($("#upu40_input").val());
     		});
     		$("#upu143").click(function(){
     			$("#upu144_input").html($("#upu115_input").html());
     			if($("#upu115_input").val() != null){
  	  			$("#upu144_input").val($("#upu115_input").val());
  	  			}else{
  	  			$("#upu144_input")[0].selectedIndex = -1;
  	  			}
    		    $("#upu156_input").html($("#upu138_input").html());
    		  	if($("#upu138_input").val() != null){
    		  		$("#upu156_input").val($("#upu138_input").val());
  	  			}else{
  	  			$("#upu156_input")[0].selectedIndex = -1;
  	  			}
    		    $("#upu157_input").html($("#upu139_input").html());
    		  	if($("#upu139_input").val() != null){
    		  		$("#upu157_input").val($("#upu139_input").val());
  	  			}else{
  	  			$("#upu157_input")[0].selectedIndex = -1;
  	  			}
    		    $("#upu158_input").html($("#upu140_input").html());
    		  	if($("#upu140_input").val() != null){
    		  		$("#upu158_input").val($("#upu140_input").val());
  	  			}else{
  	  			$("#upu158_input")[0].selectedIndex = -1;
  	  			}
    		    $("#upu159_input").html($("#upu141_input").html());
    		  	if($("#upu141_input").val() != null){
    		  		$("#upu159_input").val($("#upu141_input").val());
  	  			}else{
  	  			$("#upu159_input")[0].selectedIndex = -1;
  	  			}
    		  	$("#upu145_input").val($("#upu116_input").val());
     		});
	  		
    	});
		//如果叶酸发放为否，改变叶酸发放数量为0，状态为只读，不能修改	
    	function only(){
    		if($("#upu161_input").val()=="0"){
    			$("#upu162_input").val("0");
    			$("#upu162_input").attr("readonly","true");
    		}else{
    			$("#upu162_input").val("");
    		}
    	};
    
    </script>
  	<form action="${ctx }/prenatal/saveUpdate" method="post" id="form">
    	
    	<div id="nu2" class="ax_形状" style="background-color:#EE5F45">
          <p id="nu3"><span>个人基本信息详情编辑</span></p>
      	</div>
        <div id="nu1600" class="ax_形状" style="background-color:#EE5F45">
          <p id="nu1610" style="cursor: pointer;"><span>关闭</span></p>
      	</div>
        <div id="nu160" class="ax_形状" style="background-color:#56BB4D">
          <p id="nu161" style="cursor: pointer;"><span>保存</span></p>
      	</div>
    	
      <div id="title">
      	<div id="upu4" class="ax_文本段落">
          <p id="upu5"><span>档案编号:${archives.archivesCode }</span></p>
      	</div>
        <input type="hidden" id="archivesId" name="id" value="${archives.id }"/>
        <div id="upu8" class="ax_文本段落">
          <p id="upu9"><span>建档医院:${department.name }</span></p>
     	</div>
        
        <div id="upu10" class="ax_文本段落">
          <p id="upu11"><span>建档医生：${operatorPO.realName }</span></p>
        </div>
        
        <div id="upu6" class="ax_文本段落">
          <p id="upu7">建档日期：<input type="text" id="cteatDate" name="cteatDate" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"
							        style="color:#333333;cursor:pointer;width: 80px;height: 20px;border: 1px solid #CCCCCC;"  
							        class="" value="<fmt:formatDate value="${archives.creatTime }" pattern="yyyyMMdd"/>" tabindex="1" required>
      	  </p>
      </div>
        
      </div>
      <div id="upu167" class="ax_形状" style="background-color:#EE5F45">
          <p id="upu168"><span>孕产妇信息</span></p>
      </div>
      
      <div id="">
      
      	<div id="upu2" class="ax_形状" style="background-color:#FFFFFF;border:1px solid #CCCCCC">
        <div id="upu3" class="text">
          <p><span>&nbsp;</span></p>
        </div>
      </div>
      	
        <div id="upu14" class="ax_文本段落">
          <p id="upu15"><span>姓&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;名：</span></p>
      	</div>
      	<div id="upu19" class="ax_文本框">
        	<p id="upu19_input">${archives.name }</p>
      	</div>
      
      	<div id="upu16" class="ax_文本段落">
          <p id="upu17"><span>性&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;别：</span></p>
      	</div>
        <div id="upu18" class="ax_下拉列表框">
            <select id="upu18_input" name="sex" data-label="性别">
              <option <c:if test="${archives.sex eq '0'}">selected</c:if> value="0">女</option>
              <option <c:if test="${archives.sex eq '1'}">selected</c:if> value="1">男</option>
              <option <c:if test="${archives.sex eq '2'}">selected</c:if> value="2">性别不明</option>
            </select>
      	</div>
      	
        <div id="upu20" class="ax_文本段落">
          <p id="upu21"><span>国&nbsp; &nbsp; &nbsp;&nbsp;籍：</span></p>
      	</div>
        <div id="upu22" class="ax_下拉列表框">
            <select id="upu22_input" name="international">
              <option <c:if test="${archives.international eq '1'}">selected</c:if> value="0">中国</option>
              <option <c:if test="${archives.international eq '0'}">selected</c:if> value="1">外国</option>
            </select>
      	</div>
        
        <div id="upu57" class="ax_文本段落">
          <p id="upu58"><span>民&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;族：</span></p>
      	</div>
        <div id="upu59" class="ax_下拉列表框">
            <select id="upu59_input" name="nation">
              <option <c:if test="${archives.nation eq '汉'}">selected</c:if> value="汉">汉</option>
              <option <c:if test="${archives.nation eq '回'}">selected</c:if> value="回">回</option>
              <option <c:if test="${archives.nation eq '其他'}">selected</c:if> value="其他">其他</option>
            </select>
      	</div>
        
        <div id="upu25" class="ax_文本段落">
          <p id="upu26"><span>身份证号</span><span>：</span></p>
      	</div>
        <div id="upu27" class="ax_文本框">
        	<input id="upu27_input" type="text" name="idNo" placeholder="18位身份证号码" value="${archives.idNo }"/>
        <%-- <p id="upu27_input">${archives.idNo }</p> --%>
      	</div>
        
        <div id="upu71" class="ax_文本段落">
          <p id="upu72"><span>出生日期：</span></p>
      	</div>
        <div id="upu73" class="ax_文本框">
        	<!-- <input id="upu73_input" type="date" value="根据身份证自动显示"/> -->
        	<input type="text" id="upu73_input" name="birthday" 
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="<fmt:formatDate value="${archives.birthday }" pattern="yyyyMMdd"/>" tabindex="1" required>
      	</div>
        
        <div id="upu23" class="ax_文本段落">
          <p id="upu24"><span>年&nbsp; &nbsp; &nbsp;&nbsp;龄：&nbsp;&nbsp;<span id="age">${age }</span>岁</span></p>
      	</div>
        
        <div id="upu34" class="ax_文本段落">
          <p id="upu35"><span>文化程度：</span></p>
      	</div>
        <div id="upu39" class="ax_下拉列表框">
            <select id="upu39_input" name="education">
              <option <c:if test="${archives.education eq '9'}">selected</c:if> value="9">不详</option>
              <option <c:if test="${archives.education eq '0'}">selected</c:if> value="0">小学</option>
              <option <c:if test="${archives.education eq '1'}">selected</c:if> value="1">初中</option>
              <option <c:if test="${archives.education eq '2'}">selected</c:if> value="2">高中</option>
              <option <c:if test="${archives.education eq '3'}">selected</c:if> value="3">技校</option>
              <option <c:if test="${archives.education eq '4'}">selected</c:if> value="4">专科</option>
              <option <c:if test="${archives.education eq '5'}">selected</c:if> value="5">本科</option>
              <option <c:if test="${archives.education eq '6'}">selected</c:if> value="6">研究生</option>
              <option <c:if test="${archives.education eq '7'}">selected</c:if> value="7">博士</option>
              <option <c:if test="${archives.education eq '8'}">selected</c:if> value="8">无</option>
            </select>
      	</div>
        
        <div id="upu60" class="ax_文本段落">
          <p id="upu61"><span>户籍类型：</span></p>
      	</div>
        <div id="upu62" class="ax_下拉列表框">
            <select id="upu62_input" name="householdType">
              <option <c:if test="${archives.householdType eq '0'}">selected</c:if> value="0">本地</option>
              <option <c:if test="${archives.householdType eq '1'}">selected</c:if> value="1">外地</option>
            </select>
      	</div>
        
        <div id="upu63" class="ax_文本段落">
          <p id="upu64"><span>户口类型：</span></p>
      	</div>
        <div id="upu65" class="ax_下拉列表框">
            <select id="upu65_input" name="accountType">
              <option <c:if test="${archives.accountType eq '1'}">selected</c:if> value="1">非农户籍</option>
              <option <c:if test="${archives.accountType eq '0'}">selected</c:if> value="0">农业户籍</option>
            </select>
        </div>
        
        <div id="upu31" class="ax_文本段落">
          <p id="upu32"><span>职&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;业：</span></p>
      	</div>
        <div id="upu33" class="ax_下拉列表框">
            <select id="upu33_input" name="occupation">
              <option <c:if test="${archives.occupation eq '0'}">selected</c:if> value="0">无</option>
	          <option <c:if test="${archives.occupation eq '1'}">selected</c:if> value="1">事业单位</option>
	          <option <c:if test="${archives.occupation eq '2'}">selected</c:if> value="2">企业</option>
	          <option <c:if test="${archives.occupation eq '3'}">selected</c:if> value="3">服务业</option>
	          <option <c:if test="${archives.occupation eq '4'}">selected</c:if> value="4">制造业</option>
	          <option <c:if test="${archives.occupation eq '5'}">selected</c:if> value="5">农业</option>
	          <option <c:if test="${archives.occupation eq '6'}">selected</c:if> value="6">其他</option>
            </select>
      	</div>
        
        <div id="upu36" class="ax_文本段落">
          <p id="upu37"><span>工作单位：</span></p>
      	</div>
        <div id="upu38" class="ax_文本框">
        	<input id="upu38_input" type="text" name="workUnit" placeholder="工作单位" value="${archives.workUnit }"/>
      	</div>
        
        <div id="upu28" class="ax_文本段落">
          <p id="upu29"><span>户口地址：</span></p>
      	</div>
      	<input type="hidden" id="accPro" value="${accProvince.id }">
        <div id="upu30" class="ax_下拉列表框">
            <select id="upu30_input" name="accProvinceId">
        	</select>
      	</div>
        <div id="upu41" class="ax_文本段落">
          <p id="upu42"><span>省</span></p>
     	</div>
        
        
        <div id="upu74" class="ax_下拉列表框">
        	<select id="upu74_input" name="accCityId">
        		<option selected value="${accCity.id }">${accCity.name }</option>
       	 	</select>
   	    </div>
        <div id="upu43" class="ax_文本段落">
          <p id="upu44"><span>市</span></p>
      	</div>
        
        <div id="upu75" class="ax_下拉列表框">
            <select id="upu75_input" name="accCountyId">
            	<option selected value="${accCounty.id }">${accCounty.name }</option>
            </select>
      	</div>
        <div id="upu45" class="ax_文本段落">
          <p id="upu46"><span>县（区）</span></p>
     	</div>
        
        <div id="upu76" class="ax_下拉列表框">
            <select id="upu76_input" name="accTownshipId">
            	<option selected value="${accTownship.id }">${accTownship.name }</option>
            </select>
      	</div>
         <div id="upu47" class="ax_文本段落">
          <p id="upu48"><span>乡（街道）</span></p>
         </div>
        
        <div id="upu77" class="ax_下拉列表框">
            <select id="upu77_input" name="accVillageId">
            	<option selected value="${accVillage.id }">${accVillage.name }</option>
            </select>
     	</div>
        <div id="upu49" class="ax_文本段落">
          <p id="upu50"><span>村</span></p>
        </div>
        
        <div id="upu40" class="ax_文本框">
        	<input id="upu40_input" name="accAddress" type="text" placeholder="非必填项" value="${archives.accAddress }"/>
      	</div>
        
        <div id="upu66" class="ax_文本段落">
          <p id="upu67"><span>家庭地址：</span></p>
        </div>
        <input type="hidden" id="homePro" value="${homeProvince.id }">
        <div id="upu83" class="ax_下拉列表框">
            <select id="upu83_input" name="homeProvinceId">
            </select>
      	</div>
        <div id="upu85" class="ax_文本段落">
          <p id="upu86"><span>省</span></p>
        </div>
        
        <div id="upu95" class="ax_下拉列表框"><span class="ax_形状" style="background-color:#FFFFFF">
          <select id="upu95_input" name="homeCityId">
          	<option selected value="${homeCity.id }">${homeCity.name }</option>
          </select>
        </span></div>
        <div id="upu87" class="ax_文本段落">
          <p id="upu88"><span>市</span></p>
        </div>
        
        <div id="upu96" class="ax_下拉列表框">
            <select id="upu96_input" name="homeCountyId">
            	<option selected value="${homeCounty.id }">${homeCounty.name }</option>
            </select>
      	</div>
        <div id="upu89" class="ax_文本段落">
          <p id="upu90"><span>县（区）</span></p>
        </div>
        
        <div id="upu97" class="ax_下拉列表框">
            <select id="upu97_input" name="homeTownshipId">
            	<option selected value="${homeTownship.id }">${homeTownship.name }</option>
            </select>
      	</div>
        <div id="upu91" class="ax_文本段落">
          <p id="upu92"><span>乡（街道）</span></p>
        </div>
        
        <div id="upu98" class="ax_下拉列表框">
            <select id="upu98_input" name="homeVillageId">
            	<option selected value="${homeVillage.id }">${homeVillage.name }</option>
            </select>
      	</div>
        <div id="upu93" class="ax_文本段落">
          <p id="upu94"><span>村</span></p>
        </div>
        
        <div id="upu84" class="ax_文本框">
        	<input id="upu84_input" name="homeAddress" type="text" placeholder="非必填项" value="${archives.homeAddress }"/>
      	</div>
        <div id="upu78" class="ax_文本段落">
          <p id="upu79" style="cursor: pointer;"><span>同上</span></p>
        </div>
        
        <div id="upu68" class="ax_文本段落">
          <p id="upu69"><span>联系电话：</span></p>
        </div>
        <div id="upu70" class="ax_文本框">
        	<input id="upu70_input" type="text" name="telephone" placeholder="11位手机号" value="${archives.telephone }"/>
      	</div>
        
        <div id="upu80" class="ax_文本段落">
          <p id="upu81"><span>紧急电话：</span></p>
        </div>
        <div id="upu82" class="ax_文本框">
        	<input id="upu82_input" name="upurgentCall" type="text" placeholder="非必填项" value="${archives.urgentCall }"/>
      	</div>
      	
      	<div style="position: absolute;left: 610px;top: 299px; width: 82px;height: 15px;" class="ax_文本段落">
          <p id="u81"><span>末次月经：</span></p>
        </div>
        <div  class="ax_文本框" style="position: absolute;left: 679px;top: 294px;width: 145px;height: 25px;">
        	<input type="text" id="lastMenses" name="lastMenses" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"
        style="color:#333333;cursor:pointer;"  
        class="Wdate" value="<fmt:formatDate value="${birthArchives.lastMenses }" pattern="yyyyMMdd"/>" tabindex="1" required>
      	</div>
        <input type="hidden" name="birthArchivesId" value="${birthArchives.id }"/>
        <div style="position: absolute;left: 879px;top: 299px; width: 82px;height: 15px;"  class="ax_文本段落">
          <p id="u81"><span>预&nbsp;&nbsp;产&nbsp;&nbsp;期：</span></p>
        </div>
        <div id="u82" class="ax_文本框" style="position: absolute;left: 949px;top: 294px;width: 145px;height: 25px;">
        	<input type="text" id="predictDate" name="predictDate" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})"
        style="color:#333333;cursor:pointer;"  
        class="Wdate" value="<fmt:formatDate value="${birthArchives.predictDate }" pattern="yyyyMMdd"/>" tabindex="1" required>
      	</div>
      
      </div>
      
      <div id="upu165" class="ax_形状" style="background-color:#EE5F45">
          <p id="upu166"><span>丈夫信息</span></p>
      </div>
      
      <div id="manMsg">
      
      	<div id="upu12" class="ax_形状" style="background-color:#FFFFFF;border:1px solid #CCCCCC">
          <div id="upu13" class="text">
              <p><span>&nbsp;</span></p>
            </div>
      	</div>
      	
        <div id="upu99" class="ax_文本段落">
          <p id="upu100"><span>丈夫姓名：</span></p>
        </div>
        <div id="upu104" class="ax_文本框">
        	<input id="upu104_input" name="manName" type="text" placeholder="丈夫姓名" value="${archives.manName }"/>
      	</div>
        
        <div id="upu101" class="ax_文本段落">
          <p id="upu102"><span>性&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;别：</span></p>
        </div>
        <div id="upu103" class="ax_下拉列表框">
            <select id="upu103_input" name="manSex" data-label="性别">
              <option <c:if test="${archives.manSex eq '1'}">selected</c:if> value="1">男</option>
              <option <c:if test="${archives.manSex eq '0'}">selected</c:if> value="0">女</option>
              <option <c:if test="${archives.manSex eq '2'}">selected</c:if> value="2">性别不明</option>
            </select>
      	</div>
        
        <div id="upu105" class="ax_文本段落">
          <p id="upu106"><span>国&nbsp; &nbsp;&nbsp;&nbsp;籍：</span></p>
        </div>
        <input type="hidden" id="manInte" value="${archives.manInte}"/>
        <div id="upu107" class="ax_下拉列表框">
            <select id="upu107_input" name="manInte">
              <option <c:if test="${archives.manInte eq '1'}">selected</c:if> value="0">中国</option>
              <option <c:if test="${archives.manInte eq '0'}">selected</c:if> value="1">外国</option>
            </select>
      	</div>
        
        <div id="upu127" class="ax_文本段落">
          <p id="upu128"><span>民&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;族 ：</span></p>
        </div>
        <input type="hidden" id="manNation" value="${archives.manNation  }"/>
        <div id="upu129" class="ax_下拉列表框">
            <select id="upu129_input" name="manNation">
              <option <c:if test="${archives.manNation eq '汉'}">selected</c:if> value="汉">汉</option>
              <option <c:if test="${archives.manNation eq '回'}">selected</c:if> value="回">回</option>
              <option <c:if test="${archives.manNation eq '其他'}">selected</c:if> value="其他">其他</option>
            </select>
      	</div>
      
      	<div id="upu110" class="ax_文本段落">
          <p id="upu111"><span>身份证号：</span></p>
        </div>
        <div id="upu112" class="ax_文本框">
        	<input id="upu112_input" name="manIdNo" type="text" placeholder="18位身份证号码" value="${archives.manIdNo }"/>
        	<%-- <p id="upu112_input">${archives.manIdNo }</p> --%>
      	</div>
        
        <div id="upu135" class="ax_文本段落">
          <p id="upu136"><span>出生日期：</span></p>
        </div>
        <div id="upu137" class="ax_文本框">
        	<input type="text" id="upu137_input" name="manBirthday"
        style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" 
        class="Wdate" value="<fmt:formatDate value="${archives.manBirthday }" pattern="yyyyMMdd"/>" tabindex="1" required>
      	</div>
        
        <div id="upu108" class="ax_文本段落">
          <p id="upu109"><span>年&nbsp; &nbsp;&nbsp;&nbsp;龄：<span id="manAge">${manAge }</span>岁</span></p>
        </div>
        
        <div id="upu132" class="ax_文本段落">
          <p id="upu133"><span>联系电话：</span></p>
        </div>
        <div id="upu134" class="ax_文本框">
        	<input id="upu134_input" type="text" name="manTele" placeholder="11位手机号" value="${archives.manTele }"/>
      	</div>
        
        <div id="upu113" class="ax_文本段落">
          <p id="upu114"><span>户口地址：</span></p>
        </div>
        <input type="hidden" id="manAccPro" value="${manAccProvince.id }">
        <div id="upu115" class="ax_下拉列表框">
            <select id="upu115_input" name="manAccProvinceId">
            </select>
      	</div>
        <div id="upu117" class="ax_文本段落">
          <p id="upu118"><span>省</span></p>
        </div>
        
        <div id="upu138" class="ax_下拉列表框">
            <select id="upu138_input" name="manAccCityId">
            	<option selected value="${manAccCity.id }">${manAccCity.name }</option>
            </select>
      	</div>
        <div id="upu119" class="ax_文本段落">
          <p id="upu120"><span>市</span></p>
        </div>
        
        <div id="upu139" class="ax_下拉列表框">
            <select id="upu139_input" name="manAccCountyId">
            	<option selected value="${manAccCount.id }">${manAccCount.name }</option>
            </select>
      	</div>
        <div id="upu121" class="ax_文本段落">
          <p id="upu122"><span>县（区）</span></p>
        </div>
		
        <div id="upu140" class="ax_下拉列表框">
            <select id="upu140_input" name="manAccTownshipId">
            	<option selected value="${manAccTown.id }">${manAccTown.name }</option>
            </select>
      	</div>
        <div id="upu123" class="ax_文本段落">
          <p id="upu124"><span>乡（街道）</span></p>
        </div>
        
        <div id="upu141" class="ax_下拉列表框">
            <select id="upu141_input" name="manAccVillageId">
            	<option selected value="${manAccVill.id }">${manAccVill.name }</option>
            </select>
      	</div>
        <div id="upu125" class="ax_文本段落">
          <p id="upu126"><span>村</span></p>
        </div>
        <div id="upu116" class="ax_文本框">
        	<input id="upu116_input" name="manAccAddress" type="text" placeholder="非必填项" value="${archives.manAccAddress }"/>
      	</div>
        
        <div id="upu130" class="ax_文本段落">
          <p id="upu131"><span>家庭地址：</span></p>
        </div>
        <input type="hidden" id="manHomePro" value="${manHomeProvince.id }">
        <div id="upu144" class="ax_下拉列表框">
            <select id="upu144_input" name="manHomeProvinceId">
            </select>
      	</div>
        <div id="upu146" class="ax_文本段落">
          <p id="upu147"><span>省</span></p>
        </div>
        
        <div id="upu156" class="ax_下拉列表框">
            <select id="upu156_input" name="manHomeCityId">
            	<option selected value="${manHomeCity.id }">${manHomeCity.name }</option>
            </select>
      	</div>
        <div id="upu148" class="ax_文本段落">
          <p id="upu149"><span>市</span></p>
        </div>
        
        <div id="upu157" class="ax_下拉列表框">
            <select id="upu157_input" name="manHomeCountyId">
            	<option selected value="${manHomeCount.id }">${manHomeCount.name }</option>
            </select>
      	</div>
        <div id="upu150" class="ax_文本段落">
          <p id="upu151"><span>县（区）</span></p>
        </div>
        
        <div id="upu158" class="ax_下拉列表框">
            <select id="upu158_input" name="manHomeTownshipId">
            	<option selected value="${manHomeTown.id }">${manHomeTown.name }</option>
            </select>
      	</div>
        <div id="upu152" class="ax_文本段落">
          <p id="upu153"><span>乡（街道）</span></p>
        </div>
        
        <div id="upu159" class="ax_下拉列表框">
            <select id="upu159_input" name="manHomeVillageId">
            	<option selected value="${manHomeVill.id }">${manHomeVill.name }</option>
            </select>
      	</div>
        <div id="upu154" class="ax_文本段落">
          <p id="upu155"><span>村</span></p>
        </div>
        
      	<div id="upu145" class="ax_文本框">
        	<input id="upu145_input" name="manHomeAddress" type="text" placeholder="非必填项" value="${archives.manHomeAddress }"/>
      	</div>
        <div id="upu142" class="ax_文本段落">
          <p id="upu143" style="cursor: pointer;"><span>同上</span></p>
        </div>
      
      </div>
      
  </form>
  
 
