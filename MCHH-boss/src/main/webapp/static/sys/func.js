//UTF-8 encoding

$(document).ready(function(){
	
	var box = new jcl.ui.Box({
		title: jcl.message.get('ui.cmc.func.tree', 'Tree'),
		minWidth:800
	});
	box.addDom('func-box');
	
	jcl.postJSON('/cmc/func/tree', '', tree_init);
	
	$('#addFuncSubmitButton').click(addFuncSubmit);
	$('#modFuncSubmitButton').click(modFuncSubmit);
	$('#cancelButton').click(cancel);
	
	
});


function tree_init(data){
	var nodeType = jcl.message.get('ui.cmc.func.nodetype').split(','); //['子系统', '模块', '功能', '子功能'];
	var list = data.list;
	var icons = ['moduleIcon', 'nodeIcon','fnIcon','subfnIcon'];
	for(var i = 0 ; i < list.length; i++){
		list[i]['icon'] = icons[list[i]['ftype']];
		if(list[i]['flag'] == '0'){list[i]['font'] = 'grayfont';}
		//TODO 
	}
	list.push({id:'-1', ftype:'-1', text: jcl.message.get('ui.cmc.func.tree', 'Tree'), icon:'rootIcon', onum: 0});
	var t = new jcl.ui.Tree(list, {
		id: 'tree-box',
		sm:{
			type: 'radio',
			name: 'funcId'
		}
	});

	$('#tree-box span[onclick]:first').click();
	$('#tree-box a').each(function(){
		$(this).replaceWith($(this).text());
	});
	
	var htmlstr = '<span class="tree-menu" id="tree-manager-menu" style="display:none; margin-left:5px;">';
	htmlstr += '<a href="javascript:;" class="operate" id="tree-manager-add">'+jcl.message.get('ui.common.btn.add', 'Add')+'</a> ';
	htmlstr += '<a href="javascript:;" class="operate" id="tree-manager-mod">'+jcl.message.get('ui.common.btn.mod', 'Modify')+'</a> ';
	htmlstr += '<a href="javascript:;" class="operate" id="tree-manager-del">'+jcl.message.get('ui.common.btn.del', 'Delete')+'</a>';
	htmlstr += '</span>';
	
	$('#tree-box').append(htmlstr);
	$('#tree-manager-add').click(addFunc);
	$('#tree-manager-mod').click(modFunc);
	$('#tree-manager-del').click(delFunc);
	$('#tree-box :radio').click(showTreeManagerMenu);
	
	function showTreeManagerMenu(){
		var id = $(this).val();
		var li = $(this).parent().parent();
		var ftype = t.map[id].ftype;
		
		if(t.map[id].ftype < '3'){
			$('#tree-manager-add').show();
		}else{
			$('#tree-manager-add').hide();
		}
		if(ftype == '-1'){
			$('#tree-manager-mod').hide();
		}else{
			$('#tree-manager-mod').show();
		}
		
		li.children('.text').append($('#tree-manager-menu'));
		$('#tree-manager-menu').show();
	}
	
	function addFunc(){
		$('#modFuncSubmitButton').hide();
		$('#addFuncSubmitButton').show();
		var funcId = $(':radio[name=funcId]:checked').val();
		var node = t.map[funcId];
		var ffid = funcId;
		$('#ffid').val(ffid);
		$('#fname').val('');
		$('#conf').val('');
		$('#ffname').val(node.text);
		$('#onum').val('0');
		$('#info').val('');
		
		$('#item-ffname').show();
		var ftype = parseInt(node.ftype) + 1;
		$('#ftype').val(ftype);
		$('#ftype-info').text(nodeType[ftype]);
		
		$('#grant').attr('checked', false);
		$('#islog').attr('checked', false);
		$('#loguri').val('');
		$('#logurlMethod').val('0');
		$('#flag').val(1);
		
		if(ftype == 2){//功能才需要授权
			$('#item-grant').show();
		}else{
			$('#item-grant').hide();
		}
		if(ftype >= 2){
			$('#item-islog, #item-loguri, #item-logurlMethod').show();
		}else{
			$('#item-islog, #item-loguri, #item-logurlMethod').hide();
		}
		if(ftype > 2){
			$('#item-menu').hide();
			setMenu('0');
		}else{
			$('#item-menu').show();
			setMenu(node.menu);
		}
		
		$('#form-box').show();
		return false;
	}
	function modFunc(){
		$('#addFuncSubmitButton').hide();
		$('#modFuncSubmitButton').show();
		var funcId = $(':radio[name=funcId]:checked').val();
		if(funcId){
			var node = t.map[funcId];
			$('#fid').val(funcId);
			$('#ffid').val(node.fid);
			$('#fname').val(node.text);
			$('#info').val(node.info);
			
			//TODO 配置内容根据节点类型而不同
			$('#conf').val(node.conf);
			$('#ftype').val(node.ftype);
			var ftype = parseInt(node.ftype);
			$('#ftype-info').text(nodeType[ftype]);
			
			if(ftype == 2){//功能才需要授权
				$('#item-grant').show();
			}else{
				$('#item-grant').hide();
			}
			if(ftype >= 2){
				$('#item-islog, #item-loguri, #item-logurlMethod').show();
			}else{
				$('#item-islog, #item-loguri, #item-logurlMethod').hide();
			}
			
			if(ftype > 2){
				$('#item-menu').hide();
				setMenu('0');
			}else{
				$('#item-menu').show();
				setMenu(node.menu);
			}
			
			$('#flag').val(node.flag);
			$('#onum').val(node.onum);
			$('#ffname').val('');
			
			setIslog(node.islog);
			$('#loguri').val(node.loguri);
			$('#logurlMethod').val(node.logurlMethod);
			setIsgrant(node.isgrant);
			
			$('#item-ffname').hide();
			$('#form-box').slideDown();
		}
		return false;
	}
	function delFunc(){
		if(confirm('确定要删除功能节点吗？其下级节点将都会被删除！')){
			var funcId = $(':radio[name=funcId]:checked').val();
			//jcl.postJSON('/sys/func:del', 'fid='+funcId+'&rf=json', tree_init);
			//JCL.Common.doService('/sys/func:del', 'fid='+funcId+'&rf=json', function(data)
			jcl.postJSON('/cmc/func/del', 'funcId='+funcId+'&rf=json', function(data){
				var info = '';
				if(data.success){
					info += '删除功能成功！';
				}
				alert(info);
				jcl.go("/cmc/func/tree");
			});
		}
		return false;
	}
	
	function setMenu(v){
		$('input:radio[name=menu]').each(function(){
			if (v == $(this).val()){
				$(this).attr('checked', true);
			}else{
				$(this).attr('checked', false);
			}
		});
	}
	function setIslog(v){
		$('input:checkbox[name=islog]').each(function(){
			if (v == $(this).val()){
				$(this).attr('checked', true);
			}else{
				$(this).attr('checked', false);
			}
		});
	}
	function setIsgrant(v){
		$('input:checkbox[name=grant]').each(function(){
			if (v == $(this).val()){
				$(this).attr('checked', true);
			}else{
				$(this).attr('checked', false);
			}
		});
	}
}

function addFuncSubmit(){
	//JCL.Common.clearForm('#data-form');
	//JCL.Common.setForm('#data-form', {'fname':'12321312313', 'FFNAME': 'dad12321'});
	//return false;
	//
	if(!/^.+$/.test(jQuery.trim($('#fname').val()))){
		jcl.msg.error('[节点名称]不能为空！');
		return false;
	}
	if($('#fname').val().lengths() > 32){
		jcl.msg.error('[节点名称]最多只能输入32个字符！');
		return false;
	}
	if(!/^\d{1,2}$/.test($('#onum').val())){
		jcl.msg.error('[顺序]请输入小于99的正整数！');
		return false;
	}
	if($('#info').val().lengths() > 200){
		jcl.msg.error('[描述信息]最多只能输入66个汉字！');
		return false;
	}
	var params = $('#data-form').serializeArray();
	jcl.postJSON('/cmc/func/add', params, function(data){
		if(data.success){
			alert("添加成功！");
			jcl.go("/cmc/func/tree");
		}
	});
}
function modFuncSubmit(){
	if(!/^.+$/.test(jQuery.trim($('#fname').val()))){
		jcl.msg.error('[节点名称]不能为空！');
		return false;
	}
	if(!/^\d{1,2}$/.test($('#onum').val())){
		jcl.msg.error('[顺序]请输入小于99的正整数！');
		return false;
	}
	if($('#info').val().lengths() > 200){
		jcl.msg.error('[描述信息]最多只能输入66个汉字！');
		return false;
	}
	var params = $('#data-form').serializeArray();
	jcl.postJSON('/cmc/func/mod', params, function(data){
		if(data.success){
			alert("修改功能成功！");
			jcl.go("/cmc/func/tree");
		}
	});
}
function cancel(evnet){
	$('#form-box').slideUp('fast');
	return false;
}