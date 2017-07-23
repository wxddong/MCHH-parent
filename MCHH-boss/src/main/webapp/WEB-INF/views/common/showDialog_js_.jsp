<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style type="text/css">
	.window .datagrid-body td{border-bottom:0; border-right:0;}
</style>


<script type="text/javascript">
	/**
	 *	展示窗口 (默认显示 type类型为：middle的窗口) 
	 *	
	 *	适合：显示对话框的div在父页面，且div中不是iframe的情况(需在引用页面自定义Div及div中的内容)
		
 *	
	 *	参数说明：
	 *		title：窗口标题
	 *		tmpurl:窗口中iframe的src		
	 *		type:窗口大小,值为{'big','middle'}之一（可以扩展）；big:1000*600 middle:500*300 ...
	 *		isReloadParent:关闭窗口后，是否刷新父窗口，true:是  false:否
	 */
	var dialog_div_id = ""; 
	var dialog_excend_id_ = 'middle';
	
	function showDialog_(title,divId,type,isReloadParent){
		dialog_div_id = divId;
		var ie6Flag = false;
		if($.browser.msie){
			if($.browser.version == '6.0'){
				ie6Flag = true;
			}
		}
		var defaulttop=40;
		var defaultleft;
		var defaultWith = 500;
		var defaultHeight = 300;
		
		if(type==="big"){
			defaultleft=40;
			defaultWith = 1000;
			defaultHeight = 600;
		}else if(type==="bigHigh"){
			defaulttop="40%";
			defaultleft=40;
			defaultWith = 1000;
			defaultHeight = 790;
		}else if(type==="closeCase"){
			defaulttop=140;
			defaultleft
			defaultWith = 700;
			defaultHeight = 380;
			dialog_excend_id_ = 'closeCase';
		}else if(type==="over"){
			defaulttop=140;
			defaultleft
			defaultWith = 700;
			defaultHeight = 380;
			dialog_excend_id_ = 'over';
		}else if(type==="moremiddle"){
			defaulttop=40;
			defaultleft
			defaultWith = 700;
			defaultHeight = 380;
			dialog_excend_id_ = 'moremiddle';
		}else if(type==="moretopmiddle"){
			defaulttop=120;
			defaultleft
			defaultWith = 700;
			defaultHeight = 380;
			dialog_excend_id_ = 'moretopmiddle';
		}else if(type==="moremiddleOver"){
			defaulttop="40%";
			defaultleft
			defaultWith = 700;
			defaultHeight = 380;
			dialog_excend_id_ = 'moremiddle';
		}else if(type==="moremiddle3"){
			defaulttop=40;
			defaultleft
			defaultWith = 720;
			defaultHeight = 440;
			dialog_excend_id_ = 'moremiddle3';
		}else if(type==="moremiddle2"){
			defaulttop=50;
			defaultleft
			defaultWith = 800;
			defaultHeight = 400;
			dialog_excend_id_ = 'moremiddle2';
		}else if(type==="moremiddle4"){
			defaulttop=100;
			defaultleft
			defaultWith = 700;
			defaultHeight = 400;
			dialog_excend_id_ = 'moremiddle4';
		}else if(type==="moremiddle14"){
			defaulttop=100;
			defaultleft
			defaultWith = 860;
			defaultHeight = 450;
			dialog_excend_id_ = 'moremiddle14';
		}else if(type==="village"){
			defaulttop=40;
			defaultleft;
			defaultWith = 550;
			defaultHeight = 468;
			dialog_excend_id_ = 'village';
		}else if(type==="town"){
			defaulttop=40;
			defaultleft;
			defaultWith = 550;
			defaultHeight = 420;
			dialog_excend_id_ = 'town';
		}else if(type==="county"){
			defaulttop=40;
			defaultleft;
			defaultWith = 550;
			defaultHeight = 380;
			dialog_excend_id_ = 'county';
		}else if(type==="city"){
			defaulttop=40;
			defaultleft;
			defaultWith = 500;
			defaultHeight = 330;
			dialog_excend_id_ = 'city';
		} else if(type==="maxiddle"){
			defaulttop=40;
			defaultleft;
			defaultWith = 600;
			defaultHeight = 400;
			dialog_excend_id_ = 'maxiddle';
		}else if(type==="maxiddle1"){
			defaulttop=40;
			defaultleft;
			defaultWith = 700;
			defaultHeight = 400;
			dialog_excend_id_ = 'maxiddle1';
		}else if(type==="zhongjianddle"){
			defaulttop=40;
			defaultleft
			defaultWith = 600;
			defaultHeight = 500;
			dialog_excend_id_ = 'zhongjianddle'; 
		}else if(type==="zhongjianddle6"){
			defaulttop=40;
			defaultleft
			defaultWith = 600;
			defaultHeight = 300;
			dialog_excend_id_ = 'zhongjianddle6'; 
		}else if(type==="zhongjianddle7"){
			defaulttop=40;
			defaultleft
			defaultWith = 600;
			defaultHeight = 340;
			dialog_excend_id_ = 'zhongjianddle7'; 
		}else if(type==="zhongjianddle8"){
			defaulttop=40;
			defaultleft
			defaultWith = 700;
			defaultHeight = 490;
			dialog_excend_id_ = 'zhongjianddle8'; 
		}else if(type==="zhongjianddle9"){
			defaulttop=40;
			defaultleft
			defaultWith = 1000;
			defaultHeight = 600;
			dialog_excend_id_ = 'zhongjianddle9'; 
		}else if(type==="moremiddle5"){
			defaulttop=40;
			defaultleft
			defaultWith = 700;
			defaultHeight = 400;
			dialog_excend_id_ = 'moremiddle5';
		} else if(type==="maxiddle5"){
			defaulttop=40;
			defaultleft;
			defaultWith = 600;
			defaultHeight = 380;
			dialog_excend_id_ = 'maxiddle5';
		}else if(type==="moremiddle6"){
			defaulttop=50;
			defaultleft
			defaultWith = 800;
			defaultHeight = 340;
			dialog_excend_id_ = 'moremiddle6';
		}
		if(type==="middle"){
		}
		
		$('#'+dialog_div_id).dialog({
			top:defaulttop,
			left:defaultleft,
			title:title,
			width:defaultWith,
			height:defaultHeight,
			draggable:true, //定义是否可以拖动
            //collapsible:true, //定义是否显示可折叠按钮
			modal:true, 
			resizable:true,  //定义是否可以bianj
			//minimizable:true, //
			onBeforeClose:function(){
				if(isReloadParent === true){
					reloadList();
				}
			}
		});
		
		$('#'+dialog_div_id).dialog('open');
		if(ie6Flag){
			//IE6bug
			ie6bug.maskSelect();
		}
	}
	
	function closeDialog_(){
		$('#'+dialog_div_id).dialog('close');
	}
		
//分页方法	
function getpage(val) {
	//设置分页控件
     var p = $('#'+val).datagrid('getPager');
     $(p).pagination({  
        pageSize: 10,//每页显示的记录条数，默认为10  
        pageList: [10,20,30],//可以设置每页记录条数的列表  
        beforePageText: '第',//页数文本框前显示的汉字  
        afterPageText: '页    共 {pages} 页',  
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
        onBeforeRefresh:function(){ 
            $(this).pagination('loading'); 
            $(this).pagination('loaded'); 
        }
  });
}
</script>

<script type="text/javascript">
	/**
	 *	展示窗口 (默认显示 type类型为：middle的窗口)
	 *	
	 *	适合 显示对话框的div独立，且div中是iframe的情况（只需引入本文件，不需另定义div）
	 *	
	 *	参数说明：
	 *		title：窗口标题
	 *		tmpurl:窗口中iframe的src		
	 *		type:窗口大小,值为{'big','middle'}之一（可以扩展）；big:1000*600 middle:500*300 ...
	 *		isReloadParent:关闭窗口后，是否刷新父窗口，true:是  false:否
	 *		isIe6Frame 是否IE6加iframe 
	 */
	var dialog_excend_id = 'middle';
	function showDialog(title,tmpurl,type,isReloadParent,isIe6Frame){
		//alert(ie6Flag);
		var ie6Flag = isIe6Frame?true:false;
		var defaulttop=40;
		var defaultleft;
		var defaultWith = 500;
		var defaultHeight = 300;
		if(type==="big"){
			defaultleft=40;
			defaultWith = 1000;
			defaultHeight = 600;
			dialog_excend_id = 'big'
		}else if(type==="middle"){
			dialog_excend_id = 'middle';
		}else if(type==="moremiddle"){
			defaulttop=40;
			defaultleft=30;
			defaultWith = 900;
			defaultHeight = 500;
			dialog_excend_id = 'moremiddle';
		}else if(type==="maxBig"){
			defaultleft=40;
			defaultWith = 1200;
			defaultHeight = 800;
			dialog_excend_id_ = 'maxBig'; 
		}else if(type==="provinceDialog"){
			defaulttop=40;
			defaultWith = 800;
			defaultHeight = 400;
			dialog_excend_id = 'provinceDialog';
		}else{
			dialog_excend_id = 'middle';
		}
		
		$('#popup'+dialog_excend_id).dialog({
			top:defaulttop,
			left:defaultleft,
			title:title,
			width:defaultWith,
			height:defaultHeight,
			draggable:false,
			modal:true,
			onClose:function(){
				$('#framepopup'+dialog_excend_id).attr('src','about:blank');
				//$('#framepopup'+dialog_excend_id).dialog('refresh'); 此处使用会引起js报错
			},
			onBeforeClose:function(){
				if(isReloadParent === true){
					window.location.reload();
				}
			}
		});
		
		if(tmpurl.indexOf('?')>-1){
			tmpurl = tmpurl + "&sdfdsf="+new Date().getTime();
		}else{
			tmpurl = tmpurl + "?sdfdsf="+new Date().getTime();
		}
		$('#framepopup'+dialog_excend_id).attr('src',tmpurl);
		
		$('#popup'+dialog_excend_id).dialog('open');
		if(ie6Flag){
			//IE6bug
			ie6bug.maskSelect();
		}
		
        
	}
	function closeDialog(){
		$('#popup'+dialog_excend_id).dialog('close');
	}
	
</script>





<script type="text/javascript">
	/**
	 *	展示窗口 (默认显示 type类型为：middle的窗口) 
	 *	
	 *	适合：显示对话框的div在父页面，且div中不是iframe的情况(需在引用页面自定义Div及div中的内容)
		
 *	
	 *	参数说明：
	 *		title：窗口标题
	 *		tmpurl:窗口中iframe的src		
	 *		type:窗口大小,值为{'big','middle'}之一（可以扩展）；big:1000*600 middle:500*300 ...
	 *		isReloadParent:关闭窗口后，是否刷新父窗口，true:是  false:否
	 */
	var dialog_div_id = ""; 
	var dialog_excend_id_ = 'middle';
	function showDialog_URl(title,divId,urlHmtl,type,isReloadParent){
		dialog_div_id = divId;
		var ie6Flag = false;
		if($.browser.msie){
			if($.browser.version == '6.0'){
				ie6Flag = true;
			}
		}
		var defaulttop=40;
		var defaultleft;
		var defaultWith = 500;
		var defaultHeight = 300;
		
		if(type==="big"){
			defaultleft=40;
			defaultWith = 1000;
			defaultHeight = 600;
		}else if(type==="moremiddle"){
			defaulttop=40;
			defaultleft
			defaultWith = 800;
			defaultHeight = 400;
			dialog_excend_id_ = 'moremiddle';
		}else if(type==="moremiddle2"){
			defaulttop=40;
			defaultleft
			defaultWith = 800;
			defaultHeight = 500;
			dialog_excend_id_ = 'moremiddle2';
		}else if(type==="moremiddle3"){
			defaulttop=40;
			defaultleft
			defaultWith = 720;
			defaultHeight = 440;
			dialog_excend_id_ = 'moremiddle3';
		}else if(type==="moremiddle1"){
			defaulttop=40;
			defaultleft
			defaultWith = 720;
			defaultHeight = 440;
			dialog_excend_id_ = 'moremiddle1';
		}else if(type==="maxiddle"){
			defaulttop=40;
			defaultleft;
			defaultWith = 600;
			defaultHeight = 400;
			dialog_excend_id_ = 'maxiddle';
		}else if(type==="maxiddle1"){
			defaulttop=40;
			defaultleft;
			defaultWith = 700;
			defaultHeight = 400;
			dialog_excend_id_ = 'maxiddle1';
		}else if(type==="zhongjianddle"){
			defaulttop=40;
			defaultleft
			defaultWith = 600;
			defaultHeight = 540;
			dialog_excend_id_ = 'zhongjianddle'; 
		}else if(type==="maxBig"){
			defaultleft=100;
			defaultWith = 1200;
			defaultHeight = 800;
			dialog_excend_id_ = 'maxBig'; 
		}else if(type==="maxBig1"){
			defaultleft=100;
			defaultWith = 1192;
			defaultHeight = 552;
			dialog_excend_id_ = 'maxBig'; 
		}else if(type==="dialList"){
			defaulttop=40;
			defaultleft
			defaultWith = 1170;
			defaultHeight = 500;
			dialog_excend_id_ = 'dialList'; 
		}else if(type==="dialList3"){
			defaulttop=40;
			defaultleft
			defaultWith = 1140;
			defaultHeight = 450;
			dialog_excend_id_ = 'dialList'; 
		}else if(type==="dialList2"){
			defaulttop=40;
			defaultleft
			defaultWith = 1000;
			defaultHeight = 419;
			dialog_excend_id_ = 'dialList'; 
		}else if(type==="dialList4"){
			defaulttop=40;
			defaultleft
			defaultWith = 978;
			defaultHeight = 419;
			dialog_excend_id_ = 'dialList'; 
		}else if(type==="dialList5"){
			defaulttop=40;
			defaultleft=40;
			defaultWith = 1204;
			defaultHeight = 767;
			dialog_excend_id_ = 'dialList'; 
		}else if(type==="dialList6"){
			defaulttop=40;
			defaultleft=40;
			defaultWith = 1204;
			defaultHeight = 997;
			dialog_excend_id_ = 'dialList'; 
		}else if(type==="dialList1"){
			defaulttop=40;
			defaultleft
			defaultWith = 1000;
			defaultHeight = 400;
			dialog_excend_id_ = 'dialList1'; 
		}else if(type==="moremiddle5"){
			defaulttop=40;
			defaultleft
			defaultWith = 700;
			defaultHeight =400;
			dialog_excend_id_ = 'moremiddle5';
		}else if(type==="maxiddle5"){
			defaulttop=40;
			defaultleft;
			defaultWith = 600;
			defaultHeight = 380;
			dialog_excend_id_ = 'maxiddle5';
		}else if(type==="moremiddle6"){
			defaulttop=50;
			defaultleft
			defaultWith = 800;
			defaultHeight = 340;
			dialog_excend_id_ = 'moremiddle6';
		}
		if(type==="middle"){
		}
		
		$('#'+dialog_div_id).dialog({
			top:defaulttop,
			left:defaultleft,
			title:title,
			href:urlHmtl,
			width:defaultWith,
			height:defaultHeight,
			draggable:true, //定义是否可以拖动
            //collapsible:true, //定义是否显示可折叠按钮
			modal:true, 
			resizable:true,  //定义是否可以bianj
			//minimizable:true, //
			onBeforeClose:function(){
				if(isReloadParent === true){
					reloadList();
				}
			}
		});
		
		$('#'+dialog_div_id).dialog('open');
		if(ie6Flag){
			//IE6bug
			ie6bug.maskSelect();
		}
	}
	
	function closeDialog_(){
		$('#'+dialog_div_id).dialog('close');
	}
		
</script>
