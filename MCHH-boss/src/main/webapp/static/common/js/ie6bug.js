/**
 * 解决垃圾IE6兼容
 * @author 郝启敏
 */
var ie6bug={};

/**
 * 在弹出页面时，IE6下面的select出现在弹出框外面
 */
ie6bug.maskSelect=function(){
	 var htmlstr="<iframe id=\"tempiframe\" frameborder=\"0\"  style=\"position:absolute;visibility:inherit; top:0px;left:0px;width:100%;height:100%;z-index:-1;\"></iframe>";
	 if($.browser.msie){
		if($.browser.version == '6.0'){
			$(".menu-shadow,.window-shadow,.window-mask").each(function(){
				if($(this).children("iframe").length<1){
					$(this).append(htmlstr);
				}
			});
		}
	}
}

/**
 * <a>标签herf指定为javascript:void(0)时，调用js方法使用window.location不起作用
 * 例如:<a href="javascript:void(0)" onclick="test();">操作</a>
 */
function datagridToolbarHref(){
	if($.browser.msie){
		if($.browser.version == '6.0'){
			$("div.datagrid-toolbar a").each(function(){
				$(this).attr("href","#");
			})
		}
	}
}

$(function(){
	if($.browser.msie){
		if($.browser.version == '6.0'){
			setTimeout(datagridToolbarHref,1000);
		}
	}
})