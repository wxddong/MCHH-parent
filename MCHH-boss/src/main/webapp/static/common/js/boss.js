/**
 * @author Administrator
 */
boss = window.boss||{
	env : {
		contextPath: '',
		profile:{}
	},
	namespace : function(){
		var o, d;
	    for(var i = 0; i < arguments.length; i++){
	    	d = arguments[i].split(".");
	    	o = window[d[0]] = window[d[0]] || {};
	    	for(var j = 1; j < d.length; j++){
	    		 o = o[d[j]] = o[d[j]] || {};
	    	}
	    }
	    return o;
	},
	message : {
		get : function(key, arr, defvalue){
			var message = '';
			if(null == key) return message;
			if(this[key]){
				message = (this[key]).toString();
				if(arr && arr instanceof Array){
					for(var i = 0; i < arr.length; i++){
						message = message.replace('{'+i+'}', arr[i]);
					}
				}
			}else{
				if(defvalue != undefined){
					message = defvalue;
				}else if(typeof(arr) == 'string'){
					message = arr;
				}else{
					message = key;
				}
			}

			return message;
		}
	},
	code : {
		get:function(category, code){
			var codes = this.getCodes(category);
			//if(codes.length > 0){
			if(codes != '' && codes != 'undefined' && codes != undefined){
				if(codes[code]){
					return codes[code];
				}
			}
			return code;
		},
		getCodes:function(category){
			if(this[category]){
				return this[category];
			}
			return [];
		},
		selector:function(obj, category, title){
			var codes = this.getCodes(category);
			var htmlstr = '';
			if(title.text){
				htmlstr += '<option value="'+title['value']+'">'+title['text']+'</option>';
			}
			htmlstr += '<option value="">请选择</option>';
			for(var i in codes){
				htmlstr += '<option value="'+i+'">'+codes[i]+'</option>';
			}
			$(obj).html(htmlstr);
		}
	},
	city: {
		getProvince:function(){
			return this['city'];
		},
		getCity:function(province){
			var prov = this['city'];
			for(var i=0;i<prov.length;i++){
				if(prov[i][province]){
					return prov[i]['citys'];
				}
			}
			return [];
		},
		getDistrict:function(prov0,city0){
			var citys = this.getCity(prov0);
			for(var i=0;i<citys.length;i++){
				if(citys[i][city0]){
					return citys[i]['districts'];
				}
			}
			return [];
		}
	},
	
	
	//洲信息
	continents:{
		//洲
		getContinents:function(){
			return this['continents'];
		},
		//国家
		getCountry:function(continents){
			var continentsov = this['continents'];
			for(var i=0;i<continentsov.length;i++){
				if(continentsov[i][continents]){
					return continentsov[i]['country'];
				}
			}
			return [];
		},
		//城市
		getCityType:function(continents0,country0){
			var country = this.getCountry(continents0);
			for(var i=0;i<country.length;i++){
				if(country[i][country0]){
					return country[i]['city'];
				}
			}
			return [];
		}
	},
	
	//渠道版本信息
	channel: {
		getChannel:function(){
			return this['channel'];
		},
		getVersion:function(channel){
			var channelov = this['channel'];
			for(var i=0;i<channelov.length;i++){
				if(channelov[i][channel]){
					return channelov[i]['version'];
				}
			}
			return [];
		}
	},
	
	month: {
        month: ['一月', '二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
        selector: function(obj, defaultMonth, title){
            var htmlstr = '';
            if (title) {//text,value
                htmlstr += '<option value="' + title['value'] + '">' + title['text'] + '</option>';
            }
            for (var i in this['month']) {
                htmlstr += '<option value="' + (Number(i) + 1) + '">' + this['month'][i] + '</option>';
            }
            $(obj).html(htmlstr);
            if(defaultMonth){
            	$(obj).val(defaultMonth);
            }
        }
    },
	convert : function(v, render){
		if(render){
			if(typeof(render) == 'function'){//自定义转化器
				return render(v);
			}else{
				if(boss.util.convert[render]){//公用转化器
					return boss.util.convert[render](v);
				}
				if(boss.code[render]){//代码表转化
					if(boss.code[render][v]){
						return boss.code[render][v];
					}
				}
			}
		}
		return v;
	},
	go : function(uri){
		var url = [boss.env.contextPath, uri].join('');
		window.location.href = url;
	}
};
boss.ns = boss.namespace;
boss.ns("boss.ui", "boss.util");

// 设置分页控件
if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '第';
	$.fn.pagination.defaults.afterPageText = '页    共 {pages} 页';
	$.fn.pagination.defaults.displayMsg = '当前显示 {from} - {to} 条记录   共 {total} 条记录';
}

/* AJAX函数封装 */
$.postJSON = function(url, params, callback){
	url += ((url.indexOf('?') != -1) ? '&' : '?' ) + 't=' + new Date().getTime();
	$.post(url, params, function(data){
		if(data.success){//成功情况调用传入的回调函数
			callback(data);
		}else{//失败情况的集中处理
			$.messager.alert('消息提示', data.message?data.message:'操作失败', 'error');
		}
	},'json');
};
$.getJSON = function(url, params, callback){
	url += ((url.indexOf('?') != -1) ? '&' : '?' ) + 't=' + new Date().getTime();
	$.get(url, params, function(data){
		if(data.success){//成功情况调用传入的回调函数
			callback(data);
		}else{//失败情况的集中处理
			$.messager.alert('消息提示', data.message?data.message:'操作失败', 'error');
		}
	},'json');
};
//分页组件封装
$.grid = function(options){
	var id = options.id;//表格id
	var pagination = true;//默认是分页的分页
	if(options.pagination!=undefined){
		pagination = options.pagination;	
	}
	var pageSize = options.pageSize?options.pageSize:10;//分页大小
	var url = options.url;//数据url
	var title = options.title;//
	var toolbar = options.toolbar;//
	var singleSelect = options.singleSelect?options.singleSelect:false;//
	var fitFlag = options.fit!=undefined?options.fit:true;
	url += ((url.indexOf('?') != -1) ? '&' : '?' ) + 't=' + new Date().getTime();
	var columns = options.columns;//列定义
	var queryParams = options.queryParams;
	var frozenColumns = options.frozenColumns;
	$(id).datagrid({
		fit:fitFlag,//自动大小
		nowrap : true,
		striped : true,
		rownumbers : true,
		singleSelect : singleSelect,
		pagination : pagination,
		pageSize : pageSize,
		fitColumn : true,
		dataType : 'json',
		animate : true,
		loadMsg : '数据装载中......',
        url:url, 
        title:title,
        autoRowHeight:true,
        toolbar:toolbar,
        queryParams:queryParams,
        loadFilter:function(data){
			if(!data||!data.page){
				$.messager.alert('消息提示', data.message?data.message:"操作失败", 'error');
				return {total:0,rows:[]};
			}else{
				if(data.page.total==0&&data.page.list.length==0){
					$.messager.show({
						title:'消息提示',
						msg:'没有符合要求的数据',
						showType:'show'
					});
				}
				return {total:data.page.total,rows:data.page.list};
			}
		},
		columns:columns,
		onLoadSuccess:checkBoxState,
		frozenColumns:frozenColumns?frozenColumns:[[]]
    });
}

function checkBoxState(){
	var checkedCount = $("input[type=checkbox]:checked").length;
	if(checkedCount!=0){
		$("input[type=checkbox]:checked").attr("checked",false);
	}
}
//分页树组件封装
$.treegrid = function(options){
	var id = options.id;//表格id
	var pagination = true;//默认是分页的分页
	if(options.pagination!=undefined){
		pagination = options.pagination;	
	}
	var pageSize = options.pageSize?options.pageSize:10;//分页大小
	var url = options.url;//数据url
	var title = options.title;//标题
	var toolbar = options.toolbar;//
	
	url += ((url.indexOf('?') != -1) ? '&' : '?' ) + 't=' + new Date().getTime();
	var columns = options.columns;//列定义
	$(id).treegrid({
		fit: true,//自动大小
		nowrap : true,
		striped : true,
		rownumbers : true,
		singleSelect : false,
		pagination : pagination,
		pageSize : pageSize,
		fitColumn : true,
		dataType : 'json',
		animate : true,
		loadMsg : '数据装载中......',
        url:url, 
		idField: 'id',
		treeField: 'name',
        title:title,
        toolbar:toolbar,
        loadFilter:function(data){
			if(!data||!data.treepage){
				$.messager.alert('消息提示', data.message?data.message:"操作失败", 'error');
				return {total:0,rows:[]};
			}else{
				if(data.treepage.total==0&&data.treepage.rows.length==0){
					$.messager.show({
						title:'消息提示',
						msg:'没有符合要求的数据',
						showType:'show'
					});
				}
				return {total:data.treepage.total,rows:data.treepage.rows};
			}
		},
		columns:columns
    });
}

//将对象转为json串，没有考虑数组
function toJsonStr(obj){
	var str = '\{';
	for(var key in obj){
		if(!obj[key]||typeof(obj[key])=='number'||typeof(obj[key])=='string'||typeof(obj[key])=='boolean'){
			var v = obj[key];
			var trimstr = "";
			if(typeof(v)=='string'&&v&&v.indexOf('\n')!=-1){//去掉空格
				v = v.replace(/<\/?.+?>/g,"");
    			v = v.replace(/[\r\n]/g, ""); 
			}
			str+=key+':\''+v+'\',';
		}else{
			if(obj[key].length == 0){
				//str+=key+':\''+null+'\',';
				str+=key+':'+null+',';
			}else{
				str+=key+':'+toJsonStr(obj[key])+',';
			}
		}
	}
	str = str.substring(0,str.length-1);
	str += '\}';
	return str;
}

$.messager.info = function(str,fun){
	$.messager.alert('消息提示',str,'info',fun);
}
$.messager.error = function(str,fun){
	$.messager.alert('错误提示',str,'error',fun);
}
$.messager.question = function(str,fun){
	$.messager.alert('消息提示',str,'question',fun);
}
$.messager.warning = function(str,fun){
	$.messager.alert('警告提示',str,'warning',fun);
}

//扫描select,如<select name="memType" id="memType" class="selector" code="member_type" title="请选择"></select>
$(function(){
	if($('select')&&$('select').length>0){
		$('select').each(function(index, domEle){
			if($(domEle).attr('code')){
				var key = $(domEle).attr('code');
				var id = $(domEle).attr('id');
				var title = $(domEle).attr('title');
				boss.code.selector(domEle,key,{text:title,value:''});
			}else if ($(domEle).attr('month')) {
                    var month = $(domEle).attr('month');
                    var id = $(domEle).attr('id');
                    var title = $(domEle).attr('title');
                    boss.month.selector(domEle, month, title ? {
                        text: title,
                        value: ''
                    } : null);
                }
		});
	}
	if($("td[name='data_dictionary']")&&$("td[name='data_dictionary']").length>0){
		$("td[name='data_dictionary']").each(function(index, domEle){
			if($(domEle).attr('code')){
				var key = $(domEle).attr('code');
				var id = $(domEle).attr('id');
				var value = $(domEle).attr('value');
				var codes = boss.code.getCodes(key);
				for(var i in codes){
					if(i==value){
						$(domEle).text(codes[i]);
				}
			}
			}
		});
	}
});



/*----------------------------------------------------------------洲信息-------------------------------------------------------------------------------------------------------------------------*/
$.initContinentsov=function(continentsov, country,cityType,defaultContinentsov,defaultCountry,defaultCityType){
    var continentsovEl = $(continentsov);
    var countryEl = $(country);
    var cityTypeEl = $(cityType);
    var hasDefaultContinentsov = (typeof(defaultContinentsov) != 'undefined');
	var continentsovs = boss['continents'].getContinents();
	if(typeof(defaultContinentsov) != 'undefined'){
		for (var continentsov in continentsovs) {
			for (var country in continentsovs[continentsov].country) {
			for (var c in continentsovs[continentsov].country[country]) {
				if (c == defaultCountry){
					for(var p in continentsovs[continentsov]){
						if(p!='country'){
							defaultContinentsov = p;
							hasDefaultContinentsov = true;
							break;
						}
					}
				}
			}
        	}
		}
	}
    var continentsHtml = '';
    var title = $(continentsov).attr('title');
    if(title){
    	continentsHtml += '<option value="">'+title+'</option>';
    }
    for (var continentsov in continentsovs) {
        for (var p in continentsovs[continentsov]) {
            if (p != 'country') 
            	continentsHtml += '<option value="' + p + '"' + ((hasDefaultContinentsov && p == defaultContinentsov) ? ' selected="selected"' : '') + '>' + continentsovs[continentsov][p] + '</option>';
        }
    }
    continentsovEl.html(continentsHtml);
    $.initCountry(continentsovEl, countryEl,cityTypeEl,defaultCountry,defaultCityType);
    continentsovEl.change(function(){
     $.initCountry(continentsovEl,countryEl,cityTypeEl,defaultCountry,defaultCityType);
    });
};

$.initCountry = function(continentsovEl,countryEl,cityTypeEl,defaultCountry,defaultCityType){
    var hasDefaultCountry = (typeof(defaultCountry) != 'undefined');
    if (continentsovEl.val() != '') {
        var countrys = boss['continents'].getCountry(continentsovEl.val());
        var countryHtml = '';
        var title = $(countryEl).attr('title');
	    if(title){
	    	countryHtml += '<option value="">'+title+'</option>';
	    }
	    for (var country in countrys) {
            for (var c in countrys[country]) {
                if (c != 'city') {
                	countryHtml += '<option value="' + c + '"' + ((hasDefaultCountry && c == defaultCountry) ? ' selected="selected"' : '') + '>' + countrys[country][c] + '</option>';
                }
            }
        }
	    countryEl.html(countryHtml);  
        $.initCityTypes(continentsovEl, countryEl, cityTypeEl, defaultCityType);
        countryEl.change(function(){
            $.initCityTypes(continentsovEl, countryEl, cityTypeEl, defaultCityType);
        });
    }else {
    	countryEl.html('<option value="">请选择</option>');
 		$.initCityTypes(continentsovEl, countryEl, cityTypeEl, defaultCityType);
    }
};
$.initCityTypes = function(continentsovEl, countryEl, cityTypeEl, defaultCityType){
    var hasCityType = (typeof(defaultCityType) != 'undefined');
    if (countryEl.val() != '') {
        var cityTypes = boss['continents'].getCityType(continentsovEl.val(), countryEl.val());
        var cityTypeHtml = '';
        var title = $(cityTypeEl).attr('title');
	    if(title){
	    	cityTypeHtml += '<option value="">'+title+'</option>';
	    }
        for (var cityType in cityTypes) {
            for (var c in cityTypes[cityType]) {
            	cityTypeHtml += '<option value="' + c + '"' + ((hasCityType && c == defaultCityType) ? ' selected="selected"' : '') + '>' + cityTypes[cityType][c] + '</option>';
            }
        }
        cityTypeEl.html(cityTypeHtml);
    }
    else {
    	cityTypeEl.html('<option value="">请选择</option>');
    }
};

/*---------------------------------------------------------------版本详情---------------------------------------------------------------------------------*/
$.initChannelov = function(channel,version, defaultChannel, defaultVersion){
    var channelEl = $(channel);
    var versionEl = $(version);
    var hasDefaultChannel = (typeof(defaultChannel) != 'undefined');
	var channelovs = boss['channel'].getChannel();
	if(typeof(defaultVersion) != 'undefined'){
		for (var channelov in channelovs) {
			for (var versin in channelovs[channelov].version) {
			for (var c in channelovs[channelov].version[versin]) {
				if (c == defaultVersion){
					for(var p in channelovs[channelov]){
						if(p!='version'){
							defaultChannel = p;
							hasDefaultChannel = true;
							break;
						}
					}
				}
			}
        	}
		}
	}
    var channelovHtml = '';
    var title = $(channelov).attr('title');
    if(title){
    	channelovHtml += '<option value="">'+title+'</option>';
    }
    
    for (var channelov in channelovs) {
        for (var p in channelovs[channelov]) {
            if (p != 'version') 
            	channelovHtml += '<option value="' + p + '"' + ((hasDefaultChannel && p == defaultChannel) ? ' selected="selected"' : '') + '>' + channelovs[channelov][p] + '</option>';
        }
    }
    channelEl.html(channelovHtml);
    $.initVersion(channelEl, versionEl, defaultVersion);
    channelEl.change(function(){
        $.initVersion(channelEl, versionEl, defaultVersion);
    });
};

$.initVersion = function(channelEl, versionEl,defaultVersion){
    var hasDefaultVersion = (typeof(defaultVersion) != 'undefined');
    if (channelEl.val() != '') {
        var cities = boss['channel'].getVersion(channelEl.val());
        var versionHtml = '';
        var title = $(channelEl).attr('title');
	    if(title){
	    	versionHtml += '<option value="">'+title+'</option>';
	    }
        for (var versin in cities) {
            for (var c in cities[versin]) {
                    versionHtml += '<option value="' + c + '"' + ((hasDefaultVersion && c == defaultVersion) ? ' selected="selected"' : '') + '>' + cities[versin][c] + '</option>';
            }
        }
        versionEl.html(versionHtml);
    }else {
    	versionEl.html('<option value="">请选择</option>');
     
    }
};

/*------------------------------------------页面的crud------------------------------------------*/
//添加操作列
function operationFormate(value,node,methods,edit,del){
	var nodeStr = toJsonStr(node);
	var str ='';
	if(edit!='false'){
		str +=' <a style="color:green;text-decoration:none;margin-right:4px;" href="javascript:void(0);" onclick="edit('+nodeStr+')">修改</a>'
	}
	if(del!='false'){
  		str +='<a style="color:red;text-decoration:none;margin-right:4px;" href="javascript:void(0);" onclick="delById('+nodeStr+');">删除</a>';
	}
	if(methods&&Object.prototype.toString.call(methods) == '[object Array]'&&methods.length>0){
		for(var index in methods){
			var color = index%2==0?'green':'red';
		  	str+='<a style="color:'+color+';text-decoration:none;margin-right:4px;" href="javascript:void(0);" onclick="'+methods[index].name+'('+nodeStr+')">'+methods[index].label+'</a>';
		}
	}
    return str;  
}
//获取选择项
function getSelected(opt) {
	var rows ;
	if($('#dg')&&$('#dg').length>0){
		rows = $('#dg').datagrid('getSelections');
	}else if($('#tg')&&$('#tg').length>0){
		rows = $('#tg').treegrid('getSelections');
	}
	var len = rows.length;
	if(len==0){
		$.messager.info('请选择要操作的数据');
	}else {
		if(opt=='edit'||opt=='assignrole'||opt=='grant'||opt=='one'){
			if(len>1){
				$.messager.info('最多选择一条数据');
			}else{
				return rows[0];
			}
		}else if(opt=='del'||opt=='more'){
			return rows;
		}
	}
}

//表单重置
function resetAddOrUpdateForm(){
	$('#addOrUpdate')[0].reset();
	$('#addOrUpdate').find('input,textarea').each(function(index,domEle){
		var type = $(domEle).attr('type');
		var reset = $(domEle).attr('reset');
		if(type!='button'&&type!='submit'&&reset!='false'&&type!='checkbox'){//有reset属性时不重置
			$(domEle).val('');
		}
	});
}
//添加按钮
function add(){
	resetAddOrUpdateForm();
	var title = $('#addOrUpdateWin').panel('options').title;
	showDialog_('新建'+title,'addOrUpdateWin','maxiddle');
	$('#addOrUpdateWin').panel('options').title = title;
}

//删除
function del(){
    var node = getSelected('del');
    if(node){
	    $.messager.confirm('确认框', '确定要删除吗?', function(r){
	        if (r) {
	            var ss = new Array();
	            var rows = $('#dg').datagrid('getSelections');
	            for (var i = 0; i < rows.length; i++) {
	                var row = rows[i];
	                ss.push(row.id);
	            }
	            $.postJSON(delUrl, {
	                ids: ss.join(',')
	            }, function(data){
					try{
						$('#queryForm')[0].reset();
					}catch(e){}
					//以下的处理，保证，如果这些参数是在初始化时添加的，保留，如果是在查询表单中的参数，去掉
					var queryParams0 =$('#dg').datagrid('options').queryParams;
					var queryParams = {};
					for(var parm in queryParams0){
						if($('#'+parm)&&$('#'+parm).val()==queryParams0[parm]){
							eval('queryParams.'+parm+'=\''+queryParams0[parm]+'\'');
						}
					}
					$('#dg').datagrid('options').queryParams=queryParams;
	                $('#dg').datagrid('reload');
	            });
	        }
	    });
    }
}


//冻结，解冻
function updateStatu(node){
	if(node){
    	$.messager.confirm('确认框', '确定要执行此操作吗?', function(r){
        if (r) {
        	if(node.status=='0'){
        		updateState(node,'1');
        	}else{
        		updateState(node,'0');
        	}
        }
 	  }); 
	 }
}

//批量冻结
function updateStatus(){
	   var rows = getSelected('more');
	   if(rows){
	   $.messager.confirm('确认框', '确定要冻结吗?', function(r){
	        if (r) {
	        	if(rows&&rows.length>0){
					updateState(rows,'1');
				}
	        }
	 	  }); 
	  }
}
function updateState(rows,status){
	var ss = new Array();
	if(rows.length>0){
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i];
            ss.push(row.id);
        }
	}else{
		ss.push(rows.id);
	}
    $.postJSON(updateStatusUrl, {
        ids: ss.join(','),status:status
    }, function(data){
    	if(data.success){
    		$.messager.info('操作成功！',function(){
        		$('#dg').datagrid('reload');
			});
		}
    	});
    }

//删除
function delById(row){
    $.messager.confirm('确认框', '确定要删除吗?', function(r){
        if (r) {
            var ss = new Array();
            ss.push(row.id);
            $.postJSON(delUrl, {
                ids: ss.join(',')
            }, function(data){
                $('#dg').datagrid('reload');
            });
        }
    });
}

//修改
function edit(node){
	if(!node){
		node = getSelected('edit');
	}
	$('#addOrUpdate').find('input,textarea,select').each(function(index,domEle){
		var type = $(domEle).attr('type');
		if(type!='button'&&type!='submit'){
			var id =  $(domEle).attr('id')? $(domEle).attr('id'): $(domEle).attr('name');
			var value = eval('node.'+id);
			if($(domEle).attr("class") == "Wdate"){
				value =parseInt(value);
				var d=new Date(value);
				value=d.format('yyyy-MM-dd hh:mm:ss');
			}else if(type == "checkbox"){
				var ckValues = eval('node.'+id).split(",");
				var exits = $.inArray($(domEle).val(),ckValues);
				$(domEle).attr("checked",exits>-1);
				return true;
			}
			$(domEle).val(value);
		}
	});
	if(node.continentsCode&&node.countryCode){
		$.initContinentsov($('#continentsCode'),$('#countryCode'),$('#cityCode'),node.continentsCode,node.countryCode,null);
	}
	if(node.continentsCode&&node.countryCode&&node.cityCode){
		$.initContinentsov($('#continentsCode'),$('#countryCode'),$('#cityCode'),node.continentsCode,node.countryCode,node.cityCode);
	}
	
	if(node.channelNo&&node.version){
		$.initChannelov($('#channelNo'),$('#version'),node.channelNo,node.version);
	}
	
	var title = $('#addOrUpdateWin').panel('options').title;
	showDialog_('更新'+title,'addOrUpdateWin','maxiddle')
	$('#addOrUpdateWin').panel('options').title = title;
}

/* 导出数据 */
function exportExcel(form,excelId){
	 $.messager.confirm('确认框', '确定要导出吗?', function(r){
	        if (r) {
	        	var param = $('#'+form).serialize();
	        	window.location.href=exportUrl+'?__excel_id_='+excelId+'&'+param;
	        }
	    });
}
		  
//选择框选项填充数据通用函数
$.commonSelectFill=function(typeParams){
	var id = typeParams.id;//选择框控件的ID
	var valueField = typeParams.valueField;//value使用的属性
	var textField= typeParams.textField;//text使用的属性
	var url = typeParams.url;//请求的URL
	if($(id)&&$(id).length>0){
		$(id).each(function(index, domEle){
			$(domEle).combobox({ 
			url:url, 
			valueField:valueField, 
			textField:textField 
			}); 
		});
	}
}
//打开窗口并刷新父页面（如果是谷歌通过open打开）
function openChromeModalDialog(options) {
	     var answer=window.open(options.url,options.parm,options.style);
		 if(answer==1){
			$('#dg').datagrid('reload');
		}
}


//其他游览器打开窗口并刷新父页面(解决IE8不兼容)
 function openModalDialog(options) {
	 var answer=window.showModalDialog(options.url,options.parm,options.style);
	 if(answer==1){
	    $('#dg').datagrid('reload');
	}
}

//关闭子窗口，返回参数--dy
function refreshParent() {
	window.returnValue=1; 
	opener.location.reload();
	window.close();
}

$(function(){
	//查询字典
    $('#queryBtn').click(function(){
		if($('#dg')&&$('#dg').length>0){
	        var queryParams = $('#dg').datagrid('options').queryParams;
	        $('#dg').datagrid('options').pageNumber  = 1;
	        $('#queryForm').find('input,textarea,select').each(function(index, domEle){
	            var type = $(domEle).attr('type');
	            if (type != 'button' && type != 'submit') {
	                var name = $(domEle).attr('name');
					if (name) {
		                var value = $.trim($(domEle).val());
						var cmd ;
						if(typeof(value)=='string'||typeof(value)=='undefined'||typeof(value)=='null'){
		                	cmd = 'queryParams.' + name + '=\'' + value+'\'';
						}else{
		                	cmd = 'queryParams.' + name + '=' + value;
						}
		                eval(cmd);
					}
	            }
	        });
	        $('#dg').datagrid('options').queryParams = queryParams;
	        $('#dg').datagrid('reload');
		}else if($('#tg')&&$('#tg').length>0){
			var queryParams = $('#tg').treegrid('options').queryParams;
	        $('#queryForm').find('input,textarea,select').each(function(index, domEle){
	            var type = $(domEle).attr('type');
	            if (type != 'button' && type != 'submit') {
	                var name = $(domEle).attr('name');
					if (name) {
		                var value = $.trim($(domEle).val());
						var cmd ;
						if(typeof(value)=='string'||typeof(value)=='undefined'||typeof(value)=='null'){
		                	cmd = 'queryParams.' + name + '=\'' + value+'\'';
						}else{
		                	cmd = 'queryParams.' + name + '=' + value;
						}
		                eval(cmd);
					}
	            }
	        });
			$('#tg').treegrid({'queryParams':queryParams});    
		}
    });
	//编辑表单提交
	$('#submitButton').click(function(){
		if($('#addOrUpdate').form('validate')){
			$.postJSON($('#id').val().length>0?updateUrl:addUrl,$('#addOrUpdate').serialize(),function(data){
				if(data.success){
					closeDialog_();
					if($('#dg')&&$('#dg').length>0){
						$('#dg').datagrid('reload');
					}else if($('#tg')&&$('#tg').length>0){
						$('#tg').treegrid('reload');
					}
				}else{
					$.messager.error('操作失败！');
				}
			});
		}
	});
	//取消按钮
	$('#cancelBtn').click(function(){
		closeDialog_();
	});
});
/**
 * 次方式提交，controller次接受到的是list对象
 * @param {} arrayData 数组
 * @param {} url
 */
function ajaxPost(arrayData,url){
			$.ajax({
				url:url,
				type:'POST',
				async:false,
				contentType : 'application/json',
				data : JSON.stringify(arrayData),
				success:function(data){
					if(data.success){
						$.messager.alert('消息提示', '操作成功！', 'info',function(){
							$('#dg').datagrid('reload');
							});
					}else{
						$.messager.error(data.message?data.message:'操作失败');
					}
				}});
		}


//扩展Date的format方法   把log改成data
Date.prototype.format = function (format) {  
    var o = {  
        "M+": this.getMonth() + 1,  
        "d+": this.getDate(),  
        "h+": this.getHours(),  
        "m+": this.getMinutes(),  
        "s+": this.getSeconds(),  
        "q+": Math.floor((this.getMonth() + 3) / 3),  
        "S": this.getMilliseconds()  
    }  
    if (/(y+)/.test(format)) {  
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    }  
    for (var k in o) {  
        if (new RegExp("(" + k + ")").test(format)) {  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
        }  
    }  
    return format;  
}  


