<%@ page contentType="text/html; charset=utf-8"%>
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
		var ie6Flag = isIe6Frame?true:false;
		var defaulttop=10;
		var defaultleft;
		var defaultWith = 500;
		var defaultHeight = 300;
		if(type==="big"){
			defaultleft=10;
			defaultWith = 1000;
			defaultHeight = 600;
			dialog_excend_id = 'big'
		}else if(type==="middle"){
			dialog_excend_id = 'middle';
		}else if(type==="moremiddle"){
			defaulttop=30;
			defaultleft=30;
			defaultWith = 900;
			defaultHeight = 500;
			dialog_excend_id = 'moremiddle';
		}else{
			dialog_excend_id = 'middle';
		}
		$('#popup'+dialog_excend_id).dialog({
			top:defaulttop,
			left:defaultleft,
			title:title,
			width:defaultWith,
			height:defaultHeight,
			draggable:true,
			modal:true,
			resizable:true,
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
	 *		isIe6Frame 是否IE6加iframe 
	 */
	var dialog_div_id = ""; 
	function showDialog_(title,divId,type,isReloadParent,isIe6Frame){
		dialog_div_id = divId;
		var ie6Flag = isIe6Frame?true:false;
		var defaulttop=10;
		var defaultleft;
		var defaultWith = 500;
		var defaultHeight = 300;
		
		if(type==="big"){
			defaultleft=10;
			defaultWith = 1000;
			defaultHeight = 600;
		}else if(type==="moremiddle"){
			defaulttop=30;
			defaultleft=30;
			defaultWith = 900;
			defaultHeight = 500;
			dialog_excend_id = 'moremiddle';
		} if(type==="middle"){
		}
		
		$('#'+dialog_div_id).dialog({
			top:defaulttop,
			left:defaultleft,
			title:title,
			width:defaultWith,
			height:defaultHeight,
			draggable:false,
			modal:true,
			onBeforeClose:function(){
				if(isReloadParent === true){
					window.location.reload();
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
<div id="popupbig" class="easyui-dialog" closed="true">
	<iframe id="framepopupbig" height="550"  width="100%"  frameborder="0"></iframe>
</div>
<div id="popupmoremiddle" class="easyui-dialog" closed="true">
	<iframe id="framepopupmoremiddle" height="450"  width="100%"  frameborder="0"></iframe>
</div>
<div id="popupmiddle" class="easyui-dialog" closed="true">
	<iframe id="framepopupmiddle" height="260"  width="100%"  frameborder="0"></iframe>
</div>