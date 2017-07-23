<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>新生儿家庭访视</title>
    <style type="text/css">
    	#title {
		position:fixed;
		left: 0px;
		top: 0px;
		width:1177px;
		line-height:44px;
		height:51px;
		z-index:9999;
		background: #FFFFFF; 
		border:1px solid #CCCCCC;
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
    <link href="${ctx}/static/css/neonatal_family_visit_styles.css" type="text/css" rel="stylesheet"/>
    
          <script type="text/javascript"> 
    
          $(function(){
        	  
        	  for(var i = 0; i < 22; i ++){
        		  
        		  $("select")[i].selectedIndex = -1;
        	  }
        	  
          });
          
    /**
 * @author dingjh
 */
     /** 展开和收起 *
	 *divName 要操作层的name
	 *textId 变换文字的元素ID
	 *num 操作的层数量
	 */
function AutoFold(divName,textId,num){
	
	var words = divName.split('-');

	var textDoc=document.getElementById(textId);
	var operateDivNumFirst = words[0].substring(7,words[0].length);//获取当前操作层的第一层层号
	var operateDivNumLast = words[words.length-1].substring(7,words[words.length-1].length);//获取当前操作层的最后一层层号
	var changeHeight=0;
	
	for(var m=parseInt(operateDivNumFirst);m<=parseInt(operateDivNumLast);m++ ){
		var divNameNow="foldDiv"+m;
		var operateDiv=document.getElementsByName(divNameNow);
		var showStatus=operateDiv[0].style.display;
		if(showStatus=='none'){
			//归位在展示，如果不归位，由于上移的关系，展示出来后的位置会偏上
			var d=document.getElementsByName("foldDiv"+(parseInt(m)-1));
			operateDiv[0].style.top = (d[0].offsetTop+d[0].offsetHeight)+'px';
	
			operateDiv[0].style.display='';
			if(null!=textDoc && typeof(textDoc) != "undefined"){
				textDoc.innerHTML="收起";
			}
			
			changeHeight += operateDiv[0].offsetHeight;
		}else{
			changeHeight += 0-operateDiv[0].offsetHeight;
			operateDiv[0].style.display='none';
			if(null!=textDoc && typeof(textDoc) != "undefined"){
				textDoc.innerHTML="展开";
			}
		}
	}
	

	for (var i=parseInt(operateDivNumLast)+1;i<=num;i++)
	{
		var changeTopDiv=document.getElementsByName("foldDiv"+i);
		changeTopDiv[0].style.top=(changeTopDiv[0].offsetTop+changeHeight)+'px';
	}
}

    </script>
   
  </head>
  <body style="background-color: #FFFFFF;">
    
    <div id="title">
    <!-- Unnamed (形状) -->
      <div id="u282" class="ax_形状">
        新生儿家庭访视
      </div>
      
		<!-- Unnamed (形状) -->
      <div id="u288" class="ax_形状">
        儿童健康检查
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u290" class="ax_形状">
        专案管理
      </div>

      <!-- Unnamed (形状) -->
      <div id="u292" class="ax_形状">
        结案
      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u284" class="ax_形状">
        保存
      </div>

      <!-- Unnamed (形状) -->
      <div id="u286" class="ax_形状">
        完成
      </div>
	</div>
      <!-- Unnamed (形状) -->
  <div id="u0" class="ax_形状">
              <!-- Unnamed (形状) -->
          <div id="u6" class="ax_文本段落">
            检查医院：&nbsp;${operator.department }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u8" class="ax_文本段落">
            检查医生：${operator.realName }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u10" class="ax_文本段落">
            转诊状态：本院
          </div>
      </div>

      <!-- Unnamed (形状) -->
      <div id="u40" class="ax_形状">
        基&nbsp;本&nbsp;信&nbsp;息
      </div>
      
      
  <div id="u1">
          <!-- Unnamed (形状) -->
          <div id="u50" class="ax_文本段落">
            姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${archives.name }
    </div>
    
          <!-- Unnamed (形状) -->
          <div id="u52" class="ax_文本段落">
            档案编号：${archives.archivesCode }
          </div>
          
          
           <!-- Unnamed (形状) -->
          <div id="u64" class="ax_文本段落">
            性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
            <c:if test="${archives.sex eq '0' }">女</c:if>
            <c:if test="${archives.sex eq '1' }">男</c:if>
            <c:if test="${archives.sex eq '2' }">性别不明</c:if>
          </div>
              
          <!-- Unnamed (形状) -->
          <div id="u48" class="ax_文本段落">
            访视日期：&nbsp;<c:if test="${sign eq '1' }"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>
            		<input type="hidden" name="checkTime" value="<fmt:formatDate value="<%=new Date() %>" pattern="yyyyMMdd"/>"/>
            	  </c:if>
            	  <c:if test="${sign eq '0' }">
            		<input type="text" name="checkTime" style="color:#333333;cursor:pointer" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})" tabindex="1" required value="<fmt:formatDate value="<%=new Date() %>" pattern="yyyyMMdd"/>"/>
            	  </c:if>
          </div>
              
           <!-- Unnamed (形状) -->
          <div id="u42" class="ax_文本段落">
            出生日期：<fmt:formatDate value="${archives.birthday }" pattern="yyyy-MM-dd"/>
          </div>
          
           <!-- Unnamed (形状) -->
          <div id="u54" class="ax_文本段落">
            年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：${babyAge }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u44" class="ax_文本段落">
            助产机构：${department.name }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u46" class="ax_文本段落">
            出院日期：<fmt:formatDate value="${archives.dischargeDate }" pattern="yyyy-MM-dd"/>
          </div>
          
            <!-- Unnamed (形状) -->
          <div id="u70" class="ax_文本段落">
            身份证号码：${archives.idNo }
          </div>
          
            <!-- Unnamed (形状) -->
          <div id="u76" class="ax_文本段落">
            家庭住址：${homeProvince.name }&nbsp;${homeCity.name }&nbsp;${homeCounty.name }&nbsp;${homeTown.name }&nbsp;${homeVillage.name }
          </div>
          
          <!-- Unnamed (形状) -->
          <div id="u56" class="ax_文本段落">
            妈妈姓名：${archives.momName }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u58" class="ax_文本段落">
            联系电话：${archives.momTele }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u60" class="ax_文本段落">
            爸爸姓名：${archives.dadName }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u62" class="ax_文本段落">
            联系电话：${archives.dadTele }
          </div>

  </div>
      
      
      <!-- Unnamed (形状) -->
      <div id="u66" class="ax_形状" name="foldDiv1" onclick="AutoFold('foldDiv2','u68',10)">
          个人史
          <p id="u68">收起</p>
      </div>
      
  <div id="u2"  name="foldDiv2" >
           <!-- Unnamed (形状) -->
          <div id="u80" class="ax_文本段落">
            出生孕周：${archives.gestationalWeek }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u78" class="ax_文本段落">
            胎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数：
            <c:if test="${archives.fetusNum eq '0' }">单胎</c:if>
            <c:if test="${archives.fetusNum eq '1' }">多胎</c:if>
            <c:if test="${archives.fetusNum eq '2' }">双胎</c:if>
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u82" class="ax_文本段落">
            第&nbsp;&nbsp;&nbsp;${archives.whichFetus }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u84" class="ax_文本段落">
            胎
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u86" class="ax_文本段落">
            第&nbsp;&nbsp;&nbsp;${archives.whichBirth }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u88" class="ax_文本段落">
            产
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u90" class="ax_文本段落">
            分娩方式：
            <c:if test="${archives.deliveryType eq '0'}">顺产</c:if>
            <c:if test="${archives.deliveryType eq '1'}">剖宫产</c:if>
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u92" class="ax_文本段落">
            出生情况：
			<c:forEach items="${ birthConditions}" var="birthCondition">
		        <c:if test="${birthCondition == '0' }">顺产&nbsp;</c:if>
		        <c:if test="${birthCondition == '1' }">胎头吸引&nbsp;</c:if>
		        <c:if test="${birthCondition == '2' }">产钳&nbsp;</c:if>
		        <c:if test="${birthCondition == '3' }">剖宫产&nbsp;</c:if>
		        <c:if test="${birthCondition == '4' }">臀位&nbsp;</c:if>
		        <c:if test="${birthCondition == '5' }">双多胎&nbsp;</c:if>
		        <c:if test="${birthCondition == '6' }">其他：${archives.conditionRemark }</c:if>
        	</c:forEach>
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u94" class="ax_文本段落">
            出生体重：${archives.weight }
          </div>
          
           <!-- Unnamed (形状) -->
          <div id="u122" class="ax_文本段落">
            kg
          </div>
          
           <!-- Unnamed (形状) -->
          <div id="u96" class="ax_文本段落">
            出生身长：${archives.height }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u98" class="ax_文本段落">
            cm
          </div>
          
          <!-- Unnamed (形状) -->
          <div id="u100" class="ax_文本段落">
            新生儿窒息：<c:if test="${archives.asphyxia == '0' }">无</c:if><c:if test="${archives.asphyxia == '1' }">有</c:if>
          </div>
          
          <!-- Unnamed (形状) -->
          <div id="u104" class="ax_文本段落">
            Apgar评分：<c:if test="${archives.apgarScore == '0' }">三分钟</c:if>
			        <c:if test="${archives.apgarScore == '1' }">五分钟</c:if>
			        <c:if test="${archives.apgarScore == '2' }">不详</c:if>
			        &nbsp;${archives.apgarRemark }
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u102" class="ax_文本段落">
            新生儿疾病：
            <c:if test="${archives.newbornDisease == '0' }">无</c:if>
        	<c:if test="${archives.newbornDisease == '1' }">有&nbsp;${archives.diseaseRemark }</c:if>
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u106" class="ax_文本段落">
            母亲妊娠期患病情况：<c:forEach items="${pregns }" var="pregn">
        			<c:if test="${pregn eq '0'}">糖尿病&nbsp;</c:if>
        			<c:if test="${pregn eq '1'}">妊娠期高血压&nbsp;</c:if>
        			<c:if test="${pregn eq '2'}">其他&nbsp;${archives.sicknessRemark }</c:if>
        		  </c:forEach>
          </div>
    
          <!-- Unnamed (形状) -->
          <div id="u108" class="ax_文本段落">
            是否有畸形：<c:if test="${archives.anomaly eq '0' }">无</c:if>
        	<c:if test="${archives.anomaly eq '1' }">有&nbsp;${archives.anomalyRemark }</c:if>
          </div>

      </div>
      
      <!-- Unnamed (形状) -->
      <div id="u72" class="ax_形状" name="foldDiv3" onclick="AutoFold('foldDiv4','u74',10)">
        体格检查
        <p id="u74">收起</p>
      </div>
      
      
      
  <div id="u3"  name="foldDiv4" >
        <!-- Unnamed (形状) -->
    <div id="u110" class="ax_文本段落">
        新生儿疾病筛查：
      </div>
      
            <!-- Unnamed (复选框) -->
    <div id="u253" class="ax_复选框">
          <div id="u254" >
            甲低
          </div>
        <input id="u253_input" type="checkbox" value="checkbox"/>
      </div>
      
            <!-- Unnamed (复选框) -->
    <div id="u255" class="ax_复选框">
          <div id="u256" >
            苯丙酮尿症
          </div>
        <input id="u255_input" type="checkbox" value="checkbox"/>
      </div>
      
            <!-- Unnamed (复选框) -->
    <div id="u257" class="ax_复选框">
          <div id="u258" >
            其他遗传代谢病
          </div>

        <input id="u257_input" type="checkbox" value="checkbox"/>
      </div>

    <input id="u125_input" type="text" placeholder="其他" value=""/>

    <div id="u112" class="ax_文本段落">
        新生儿听力筛查：
    </div>
    
    <select id="u124_input">
          <option value="通过">通过</option>
          <option value="未通过">未通过</option>
          <option value="未筛查">未筛查</option>
          <option value="不详">不详</option>
        </select>

      
      <div id="u118" class="ax_文本段落">
        目前体重：
      </div>

    <input id="u126_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u127" class="ax_文本段落">
        kg
      </div>
      
            <!-- Unnamed (形状) -->
    <div id="u259" class="ax_文本段落">
        胸围：
     </div>
    <input id="u261_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u262" class="ax_文本段落">
        cm
      </div>
      
      
      <!-- Unnamed (形状) -->
    <div id="u114" class="ax_文本段落">
        喂养方式：
      </div>

    <select id="u129_input">
      <option value="纯母乳">纯母乳</option>
          <option value="人工">人工</option>
          <option value="混合">混合</option>
        </select>
      
            <!-- Unnamed (形状) -->
    <div id="u116" class="ax_文本段落">
        *吃奶量：
      </div>

    <input id="u130_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u131" class="ax_文本段落">
        ml/次
      </div>
      
       <!-- Unnamed (形状) -->
      <div id="u120" class="ax_文本段落">
        *呕吐：
    </div>

        <select id="u153_input">
          <option value="无">无</option>
          <option value="有">有</option>
        </select>

      <!-- Unnamed (形状) -->
      <div id="u133" class="ax_文本段落">
        *吃奶次数：
    </div>

    <input id="u135_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u136" class="ax_文本段落">
        次/日
      </div>
      
            <!-- Unnamed (形状) -->
    <div id="u154" class="ax_文本段落">
        *大便：
      </div>

    <select id="u156_input">
      <option value="糊状">糊状</option>
          <option value="稀">稀</option>
        </select>
      
      <!-- Unnamed (形状) -->
      <div id="u138" class="ax_文本段落">
        *大便次数：
      </div>

    <input id="u140_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u141" class="ax_文本段落">
        次/日
      </div>
      
            <!-- Unnamed (形状) -->
    <div id="u162" class="ax_文本段落">
        面色：
      </div>

        <select id="u164_input">
          <option value="红润">红润</option>
          <option value="黄染">黄染</option>
          <option value="其他 ">其他 </option>
    </select>

        <input id="u167_input" type="text" value="其他"/>
      
        <!-- Unnamed (形状) -->
    <div id="u165" class="ax_文本段落">
        黄疸部位：
      </div>
      <!-- Unnamed (复选框) -->
      <div id="u264" class="ax_复选框">
          <div id="u265" >
            面部
          </div>
        <input id="u264_input" type="checkbox" value="checkbox"/>
    </div>

      <!-- Unnamed (复选框) -->
      <div id="u266" class="ax_复选框">
          <div id="u267" >
            躯干
          </div>
        <input id="u266_input" type="checkbox" value="checkbox"/>
    </div>

      <!-- Unnamed (复选框) -->
      <div id="u268" class="ax_复选框">
          <div id="u269" >
            四肢
          </div>
        <input id="u268_input" type="checkbox" value="checkbox"/>
    </div>

      <!-- Unnamed (复选框) -->
      <div id="u270" class="ax_复选框">
          <div id="u271">
            用足
          </div>
        <input id="u270_input" type="checkbox" value="checkbox"/>
    </div>

      <!-- Unnamed (复选框) -->
    <div id="u272" class="ax_复选框">
          <div id="u273">
            无
          </div>
        <input id="u272_input" type="checkbox" value="checkbox"/>
      </div>
      
            <!-- Unnamed (形状) -->
    <div id="u157" class="ax_文本段落">
        体温：
      </div>

    <input id="u159_input" type="text" value=""/>

    <div id="u160" class="ax_文本段落">
        ℃
      </div>

    <div id="u143" class="ax_文本段落">
        脉率：
      </div>

    <input id="u145_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u146" class="ax_文本段落">
        次/分钟
      </div>

      <!-- Unnamed (形状) -->
    <div id="u148" class="ax_文本段落">
        呼吸频率：
      </div>

    <input id="u150_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u151" class="ax_文本段落">
        次/分钟
      </div>
      
      <!-- Unnamed (形状) -->
    <div id="u168" class="ax_文本段落">
        前囟：
      </div>

    <input id="u170_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u171" class="ax_文本段落">
        cm X
      </div>

    <input id="u173_input" type="text" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u174" class="ax_文本段落">
        cm
      </div>

    <select id="u176_input">
          <option value="正常">正常</option>
          <option value="膨隆">膨隆</option>
          <option value="凹陷">凹陷</option>
          <option value="其他">其他</option>
        </select>

    <input id="u177_input" type="text" placeholder="其他" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u178" class="ax_文本段落">
        眼外观：
      </div>

    <select id="u180_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

    <input id="u181_input" type="text" placeholder="异常时填写" value=""/>

      <!-- Unnamed (形状) -->
      <div id="u182" class="ax_文本段落">
        四肢活动度：
      </div>

        <select id="u184_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

    <input id="u185_input" type="text" placeholder="异常时填写" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u186" class="ax_文本段落">
        耳外观：
      </div>

    <select id="u188_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

    <input id="u189_input" type="text" placeholder="异常时填写" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u190" class="ax_文本段落">
        颈&nbsp;部&nbsp;包&nbsp;块：
      </div>

    <select id="u192_input">
          <option value="无">无</option>
          <option value="有">有</option>
        </select>

    <input id="u193_input" type="text" placeholder="有时填写" value=""/>

      <!-- Unnamed (形状) -->
      <div id="u194" class="ax_文本段落">
        鼻：
      </div>

        <select id="u196_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

    <input id="u197_input" type="text" placeholder="异常时填写" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u198" class="ax_文本段落">
        皮&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;肤：
    </div>

    <select id="u200_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

    <input id="u201_input" type="text" placeholder="其他时填写" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u202" class="ax_文本段落">
        口&nbsp;&nbsp;腔：
      </div>

    <select id="u204_input">
      <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

        <input id="u205_input" type="text" placeholder="异常时填写" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u206" class="ax_文本段落">
        肛&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;门：
    </div>

    <select id="u208_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

        <input id="u209_input" placeholder="异常时填写" type="text" value=""/>

      <!-- Unnamed (形状) -->
      <div id="u210" class="ax_文本段落">
        心&nbsp;&nbsp;&nbsp;&nbsp;肺：
      </div>

        <select id="u212_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
    </select>

        <input id="u213_input" type="text" placeholder="异常时填写" value=""/>

      <!-- Unnamed (形状) -->
    <div id="u214" class="ax_文本段落">
        外 生 殖 器：
      </div>

    <select id="u216_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

        <input id="u217_input" type="text" placeholder="异常时填写" value=""/>

      <!-- Unnamed (形状) -->
      <div id="u218" class="ax_文本段落">
        腹&nbsp;&nbsp;&nbsp;&nbsp;部：
      </div>

        <select id="u220_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>

    <input id="u221_input" type="text" placeholder="异常时填写" value=""/>

      <div id="u222" class="ax_文本段落">
        脊&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;柱：
      </div>

        <select id="u224_input">
          <option value="未见异常">未见异常</option>
          <option value="异常">异常</option>
        </select>
        
    <input id="u225_input" type="text" placeholder="异常时填写" value=""/>

    <div id="u226" class="ax_文本段落">
        脐&nbsp;&nbsp;带：
      </div>
      
       <!-- Unnamed (复选框) -->
    <div id="u274" class="ax_复选框">
          <div id="u275" >
            未脱
          </div>
        <input id="u274_input" type="checkbox" value="checkbox"/>
      </div>

      <!-- Unnamed (复选框) -->
    <div id="u276" class="ax_复选框">
          <div id="u277" >
            脱落
          </div>
        <input id="u276_input" type="checkbox" value="checkbox"/>
      </div>

      <!-- Unnamed (复选框) -->
    <div id="u278" class="ax_复选框">
          <div id="u279" >
            脐部有渗出
          </div>
        <input id="u278_input" type="checkbox" value="checkbox"/>
      </div>

      <!-- Unnamed (复选框) -->
    <div id="u280" class="ax_复选框">
          <div id="u281" >
           其他
          </div>
        <input id="u280_input" type="checkbox" value="checkbox"/>
      </div>

    <input id="u228_input" type="text" placeholder="其他时填写" value=""/>

  </div>
  
        <!-- Unnamed (形状) -->
      <div id="u241" class="ax_形状" name="foldDiv5" onclick="AutoFold('foldDiv6','u244',10)">
        总&nbsp;体&nbsp;评&nbsp;估
        <p id="u244">收起</p>
      </div>


  <div id="u4"  name="foldDiv6" >

      <div id="u245" class="ax_文本段落">
        总体评估：
      </div>

      <div id="u247" class="ax_单选按钮">
          <div id="u248" >
            未见异常
          </div>
        <input id="u247_input" type="radio" value="radio" name="u247"/>
      </div>

      <div id="u249" class="ax_单选按钮">
          <div id="u250" >
            异常
          </div>

        <input id="u249_input" type="radio" value="radio" name="u249"/>
      </div>

  <div id="u251" class="ax_形状">
        异常选项
      </div>
      </div>

      <div id="u12" class="ax_形状" name="foldDiv7" onclick="AutoFold('foldDiv8','u14',10)">
        保&nbsp;健&nbsp;指&nbsp;导
         <p id="u14">收起</p>
      </div>
      
  <div id="u5"  name="foldDiv8" >
        <textarea id="u16_input"></textarea>
      </div>

      <div id="u17" class="ax_形状" name="foldDiv9" onclick="AutoFold('foldDiv10','u19',10)">
        处&nbsp;理
        <p id="u19">收起</p>
      </div>

  <div id="u7"  name="foldDiv10" >

      <div id="u21" class="ax_文本段落">
        转诊：
      </div>

      <div id="u23" class="ax_单选按钮">
          <div id="u24" >
            无
          </div>
        <input id="u23_input" type="radio" value="radio" name="u23"/>
      </div>

      <div id="u25" class="ax_单选按钮">
          <div id="u26">
            有
          </div>
        <input id="u25_input" type="radio" value="radio" name="u25"/>
      </div>

      <div id="u27" class="ax_文本段落">
          原因：      
          </div>

        <input id="u29_input" type="text" value=""/>

      <div id="u30" class="ax_文本段落">
          转诊机构：
      </div>

        <select id="u32_input">
        </select>

      <div id="u33" class="ax_文本段落">
        转诊科室：
      </div>

        <select id="u35_input">
        </select>

      <div id="u229" class="ax_文本段落">
        下次随访日期：
      </div>

        <select id="u231_input">
        </select>

      <div id="u238" class="ax_文本段落">
          下次随访地点：
      </div>

      <input id="u240_input" type="text" value=""/>

      <div id="u232" class="ax_文本段落">
        是否预约下次检查：
    </div>

      <div id="u234" class="ax_单选按钮">
          <div id="u235">
            是
          </div>

        <input id="u234_input" type="radio" value="radio" name="u234"/>
    </div>

      <div id="u236" class="ax_单选按钮">
          <div id="u237">
            否
          </div>

        <input id="u236_input" type="radio" value="radio" name="u236"/>
      </div>

  <div id="u39" class="ax_水平线">
        <hr style="border:1px dashed #B5B5B5;" />
    </div>

      <div id="u36" class="ax_文本段落">
        母子健康手册使用：
      </div>

        <select id="u38_input">
          <option value="是">是</option>
          <option value="否">否</option>
        </select>

  </div>

  </body>
</html>
