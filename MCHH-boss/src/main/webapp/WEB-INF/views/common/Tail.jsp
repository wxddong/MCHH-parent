<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="mm" class="easyui-menu" style="width:150px;">
       <div id="mm-tabclose">关闭</div>
       <div id="mm-tabcloseall">全部关闭</div>
       <div id="mm-tabcloseother">除此之外全部关闭</div>
       <div class="menu-sep"></div>
       <div id="mm-tabcloseright">当前页右侧全部关闭</div>
       <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
</div>
<script type="text/javascript">
	function tabCloseEven(){
	    //关闭当前
	    $('#mm-tabclose').click(function(){
	        var tt = $('#main').data("currtab");
	        $('#main').tabs('select', tt);
	        if(tt == defaultTitle){
	        	$.messager.alert('信息提示',"不能关闭默认tab页", 'info',function(){
		            return false;
	            });
	        }else{
	        	$('#main').tabs('close',tt);
	        }
	    })
	    //全部关闭
	    $('#mm-tabcloseall').click(function(){
	    	var tt = $('#main').data("currtab");
	        $('#main').tabs('select', tt);
	        
	        $('.tabs-inner span').each(function(i,n){
	            var t = $(n).text();
	            if(t != defaultTitle){
			        $('#main').tabs('close',t);
		        }
	        });    
	    });
	    //关闭除当前之外的TAB
	    $('#mm-tabcloseother').click(function(){
	        var tt = $('#main').data("currtab");
	        $('#main').tabs('select', tt);
	        
	        $('.tabs-inner span').each(function(i,n){
	            var t = $(n).text();
	            if(t!=tt && t != defaultTitle){
	                $('#main').tabs('close',t);
	            }
	        });    
	    });
	    //关闭当前右侧的TAB
	    $('#mm-tabcloseright').click(function(){
	     	var tt = $('#main').data("currtab");
	        $('#main').tabs('select', tt);
	        
	        var nextall = $('.tabs-selected').nextAll();
	        if(nextall.length==0){
	            $.messager.alert('信息提示',"右侧没有可以关闭的tab页", 'info',function(){
		            return false;
	            });
	        }
	        nextall.each(function(i,n){
	            var t=$('a:eq(0) span',$(n)).text();
	            if(t != defaultTitle){
		            $('#main').tabs('close',t);
	            }
	        });
	        return false;
	    });
	    //关闭当前左侧的TAB
	    $('#mm-tabcloseleft').click(function(){
	    	var tt = $('#main').data("currtab");
	        $('#main').tabs('select', tt);
	        
	        var prevall = $('.tabs-selected').prevAll();
	        if(prevall.length <= 0){
	            $.messager.alert('信息提示',"左侧没有可以关闭的tab页", 'info',function(){
		            return false;
	            });
	        }
	        prevall.each(function(i,n){
	            var t=$('a:eq(0) span',$(n)).text();
	            if(t != defaultTitle){
		            $('#main').tabs('close',t);
	            }
	        });
	        return false;
	    });
	}
</script>
