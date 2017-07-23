<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>妇幼健康信息管理平台</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/sys/css/default.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/themes/icon.css" />
     <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/demo.css">
     <link rel="stylesheet" type="text/css" href="${ctx}/static/common/css/font-awesome.min.css">
    <script type="text/javascript" src="${ctx}/static/common/js/jquery-1.8.0.min.js"></script>
     <script type="text/javascript" src="${ctx}/static/sys/outlook2.js"></script>
    <script type="text/javascript" src="${ctx}/static/common/js/jquery.easyui.min.js"></script>
     <script type="text/javascript" src="${ctx}/static/common/js/jquery.md5.js"></script>
     <script type="text/javascript" src="${ctx}/static/common/js/easyui-lang-zh_CN.js"></script>
     <script type="text/javascript">
	     var menuUrl = '${ctx}/menu';//菜单
	     var logoutUrl = '${ctx}/logout';//注销
	     var _menus ;
	     $.ajax({url:menuUrl,type:'POST',async:false, success:function(data){
	    	 	if(!data.menus||data.menus.length==0){
	    	 		alert('该用户没有任何权限');
	    	 		window.location = '${ctx}/logout';
	    	 	}
				_menus = data;
		 }});
	     $.extend($.fn.validatebox.defaults.rules, {    
    		/*必须和某个字段相等*/  
		    equalTo: {  
		        validator:function(value,param){
		            return $(param[0]).val() == value;  
		        },  
		        message:'两次输入密码不一致'  
		    },validPass: {  
		        validator:function(value,param){
			    	var reg = /[\s]/;
					return !reg.test(value);
		        },  
		        message:'密码不能包含空白字符'  
		    }
		});  
	     $(function(){
	    	 //显示时钟
			clockon();
	    	 //注销
			$('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
                    if (r) {
                        location.href = logoutUrl;
                    }
                });
            });
	    	 //修改密码
	    	  $('#editPass').click(function() {
	    		openPwd();
                $('#w').window('open');
            });
	    	//确定修改密码
            $("#editPassForm").form({
				url : '${ctx}/profile/pwd/update',
				onSubmit : function() {
					if($('#txtOldPass')){
						$('#editPassForm').find('input[name=oldPassword]').val($.md5($('#txtOldPass').val()));
					}
					$('#editPassForm').find('input[name=newPassword]').val($.md5($('#txtNewPass').val()));
					return $(this).form('validate');
				},
				success : function(data) {
					if(data.error){
					}else{
						window.location="${ctx}/";
					}
				}
			});
	    	 $('#btnEp').click(function() {
                //editPass();
                $('#editPassForm').submit();
            });
           	//取消修改
			$('#btnCancel').click(function(){
				
				closePwd();
			});
	    	 
	     });
	     
	      function openPwd() {
	    	var height = 160;
	    	if($('#txtOldPass')){
	    		height = 200;
	    	}
	    	$('#editPassForm').find(':password').val('');
	    	$('#editPassForm').find('#oldPassword').val('');
	    	$('#editPassForm').find('#newPassword').val('');
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: height,
                resizable:false,
                modal:true,
                minimizable:false,
                maximizable:false,
                collapsible:false
            });
        }
	    //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }
    </script>
    <style type="text/css">
    .mar_l_10{margin-left:10px;}
    .mar_l_05{margin-left:5px;}
    .mar_r_10{margin-right:10px;}
    .mar_r_05{margin-right:5px;}
    .mar_t_10{margin-top:10px;}
    .mar_b_10{margin-bottom:10px;}
    .tabs-panels-noborder{border:1px solid #3273d0; margin-top:-1px;}
    .window .window-body{border-top:1px solid #95B8E7;}	
    #west .panel-title{background: url('${ctx}/static/sys/images/test.png') no-repeat; padding-left:20px;}
    #mainPanle .panel .panel-body{overflow-y:hidden;} 
    #west .panel-title{background:none;padding-left:10px;} 
    .accordion-collapse{background:none;}  
    .panel-tool a{color:#fff;background:none;}
    </style>
  </head>
  
 <body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<!-- 脚本检测 -->
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="${ctx }/static/sys/images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div>
</noscript>
	<!-- 头部 -->
    <div region="north" split="true" border="false" style="overflow: hidden; height:69px; background:#009dd9; border:1px solid #4889e6; border-top:4px solid #4889e6; line-height: 20px;color: #fff;">
        <span style="float:right; padding-right:20px; margin-top:8px; color:#fff;" class="head">
        	<span style="margin-right:100px;">单位： ${OPERATOR.department }</span>
        	<span style="margin-right:50px;vertical-align:middle; display:inline-block; line-height:26px; text-align:center;">当前用户： ${OPERATOR.realName} <!-- <div id="sysDate" name="sysDate"></div> -->
        </span> 
        <a class="head_btn" href="javascript:void(0)" id="editPass"><i class="fa fa-edit"></i>修改密码</a> 
        <a class="head_btn" href="javascript:void(0)" id="loginOut"><i class="fa fa-sign-out"></i>安全退出</a>
       	<!-- <span id="bgclock"></span> -->
        </span>
        <span style="margin:12px 0 0 30px;font-weight:bold; color:#fff; font-size: 16px; float:left;"><i class="fa fa-medkit mar_r_05" style="font-size:30px;vertical-align:middle;"></i>妇幼健康信息管理平台</span>
    </div>
    <!--  导航内容 -->
    <div region="west" collapsible="true" split="true" title="导航菜单" style="width:220px;" id="west">
	<div class="easyui-accordion" fit="true" border="false">	
	<div class="panel-icon icon-sys">344</div>
	</div>
    </div>
    <!-- 主窗口 -->
    <div id="mainPanle" region="center" style="background: #fff; border:0; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="color:#000;background:url('${ctx }/static/sys/images/u4.jpg') no-repeat left top #f4f4f4; margin:0px auto;opacity:0.2;text-align:center" id="home">
			<!-- <p><img width="76" height="36" src="${ctx }/static/sys/images/asideindex.png"></p> -->
			<p style="font-size: 22px;text-align:center; padding-top:250px;">欢迎进入妇幼健康信息管理系统，工作愉快</p>
			</div>
		</div>		
    </div>
    <!-- 箭头收缩导航内容 -->
    <div class="mini-handler" style="top: 165px; left: 175px; z-index:300; width: 5px; height:35px;">
    	<div class="mini-handler-buttons" style="margin-top: -17.5px;">
    		<a class="mini-splitter-pane1-button" id="pane1-button"></a>
   		</div>
	</div>
    </div>
    <!-- 版权信息 -->
    <div region="south" split="true" style="height: 30px; background:#009dd9; ">
        <div class="footer">版权所有 三五九通(北京)科技有限公司</div>
    </div>
    
     <!--修改密码窗口-->
    <div id="w" class="easyui-window"  title="修改密码" modal="true" closed="true"
       icon="icon-save"  style="width: 300px; height: 160px; padding: 5px;background: #fafafa;">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
            	<form method="post" action="${ctx}/profile/pwd/update" id="editPassForm">
            	<input type="hidden" name="oldPassword"/>
            	<input type="hidden" name="newPassword">
                <table cellpadding=3>
                	<c:if test="${OPERATOR.loginName ne 'admin'}">
	                    <tr>
	                        <td>当前密码：</td>
	                        <td><input id="txtOldPass" type="password" class="txt01 easyui-validatebox" 
	                        data-options="validType:['maxLength[20]','validPass']" 
	                        required="true"/></td>
	                    </tr>
                	</c:if>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="password" class="txt01 easyui-validatebox" 
                        required="true"
                        data-options="validType:['maxLength[20]','validPass']" 
                        /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="password" class="txt01 easyui-validatebox" required="true"  
                        data-options="validType:['maxLength[20]','equalTo[\'#txtNewPass\']','validPass']" 
                        invalidMessage="两次输入密码不匹配"/></td>
                    </tr>
                </table>
	             </form>
            </div>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height:24px; margin-top:6px;">
                <a id="btnEp" class="easyui-linkbutton"  href="javascript:void(0)" >确定</a> 
                <a id="btnCancel" class="easyui-linkbutton"  href="javascript:void(0)">取消</a>
            </div>
    </div>
    
      <!--修改密码窗口-->
    <div id="w" class="easyui-window"  title="修改密码" modal="true" closed="true"
       icon="icon-save"  style="width: 300px; height: 160px; padding: 5px;background: #fafafa;">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
            	<form method="post" action="${ctx}/profile/pwd/update" id="editPassForm">
            	<input type="hidden" name="oldPassword"/>
            	<input type="hidden" name="newPassword">
                <table cellpadding=3>
                	<c:if test="${OPERATOR.loginName ne 'admin'}">
	                    <tr>
	                        <td>当前密码：</td>
	                        <td><input id="txtOldPass" type="password" class="txt01 easyui-validatebox" 
	                        data-options="validType:['maxLength[20]','validPass']" 
	                        required="true"/></td>
	                    </tr>
                	</c:if>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="password" class="txt01 easyui-validatebox" 
                        required="true"
                        data-options="validType:['maxLength[20]','validPass']" 
                        /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="password" class="txt01 easyui-validatebox" required="true"  
                        data-options="validType:['maxLength[20]','equalTo[\'#txtNewPass\']','validPass']" 
                        invalidMessage="两次输入密码不匹配"/></td>
                    </tr>
                </table>
	             </form>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height:24px; margin-top:6px;">
                <a id="btnEp" class="easyui-linkbutton"  href="javascript:void(0)" >确定</a> 
                <a id="btnCancel" class="easyui-linkbutton"  href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>
    <!-- 选项卡菜单 -->
	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
<script type="text/javascript">
    //yangjs to modify by 2013/8/9
		;jQuery(function($){
			var ar_wid = $(window).width()-5,
				le_wid = $("#west").parent().width();
				ar_hei = $(window).height()-95;
			$(".mini-handler").css({"top":ar_hei/2+35});			
			
			//绑定改变窗口大小，箭头跟着移动		
			$(window).bind("resize",function(){
				var a = $(".mini-handler").css("left");	
				if( a == "0px" ){
					$("#west").parent().css("width",0);
					$("#mainPanle").parent().css({"width":ar_wid,"left":"5px"});
					$("#mainPanle,#tabs,.tabs-header,.tabs-wrap").css("width","100%");
				}			
				var ar_hei = $(window).height()-95;
				$(".mini-handler").css({"top":ar_hei/2+35});
				return false;
			});
			
			// 点击收缩按钮 缩回导航
			$("#pane1-button").toggle(function(){
				hand_left = $(".mini-handler").css("left");
				west_wid = $("#west").parent().width();
				$(this).attr("class","mini-splitter-pane2-button").parents(".mini-handler").css("left",0);
				$("#west").parent().css("width",0);
				$("#mainPanle").parent().css({"width":ar_wid-10,"left":"5px"});
				$("#mainPanle,#tabs,.tabs-header,.tabs-wrap,.tabs-panels,#tabs .panel,#tabs .panel .panel-body").css("width","100%");
			},function(){	
				var hand5 = (parseInt(hand_left)+5)+"px";			
				$(this).attr("class","mini-splitter-pane1-button").parents(".mini-handler").css("left",hand_left);
				$("#west").parent().css("width",west_wid);
				$("#mainPanle").parent().css({"width":ar_wid-west_wid-13,"left":hand5});
				$("#mainPanle,#tabs,.tabs-header,.tabs-wrap").css("width",ar_wid-west_wid-13);			
			});
			
			//左右2侧高度相同			
			function sameHeight(){
				var left_hei = $("#west").height(),rig_hei = $("#mainPanle").height(),
					sel_hei = $(".accordion-header-selected").siblings(".accordion-body");
				sel_hei.height(sel_hei.height() + rig_hei-left_hei - 1);
				$("#west").find(".easyui-accordion").height(rig_hei - 1);
				$("#west").height(rig_hei - 1);
			}
			sameHeight();

			$(".panel-header").eq(0).hide();
			$("#west").find(".panel").eq(0).css("border-top","1px solid #A7ABB0");
			$(".accordion-header:last").css("border-bottom",0);	
			
			
			//拖动左侧区域 箭头跟随滚动			
			$(".layout-panel-west,.layout-panel-center").mousemove(function(){
			var west_wid = $(".layout-panel-west").css("width");
				$(".mini-handler").css("left",west_wid);
				sameHeight();
				window.getSelection&&window.getSelection().removeAllRanges();
			}); 
			 
		});
					
		
		window.onload=function(){
			var aa = $("#west .accordion-header-selected").next(".panel-body").height();
			$("#west .panel").find(".panel-body").height(aa);
			//sysDate();
		};
				
		/* function sysDate() {
			var div=document.getElementById("sysDate"); 
		    div.innerHTML="当前登录时间："+formattime(new Date()) ;
		} */


		// 处理时间格式
		var format = function(time, format){
		    var t = new Date(time);
		    var tf = function(i){return (i < 10 ? '0' : '') + i};
		    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
		        switch(a){
		            case 'yyyy':
		                return tf(t.getFullYear());
		                break;
		            case 'MM':
		                return tf(t.getMonth() + 1);
		                break;
		            case 'mm':
		                return tf(t.getMinutes());
		                break;
		            case 'dd':
		                return tf(t.getDate());
		                break;
		            case 'HH':
		                return tf(t.getHours());
		                break;
		            case 'ss':
		                return tf(t.getSeconds());
		                break;
		        }
		    })
		}
		
		function formatdate(val) {
			return format(val, 'yyyy-MM-dd');
		}	
		
		function formattime(val) {
			return format(val, 'yyyy年MM月dd日HH:mm:ss');
		}	

		
		window.onresize=function(){
			var aa = $("#west .accordion-header-selected").next(".panel-body").height();
			$("#west .panel").find(".panel-body").height(aa);	
		};
		
	</script>
</body>
</html>
