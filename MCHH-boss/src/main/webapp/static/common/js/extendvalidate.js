$(function(){
$.extend($.fn.combotree.methods, {  
    /** 
    *使用范围，全部加载数据即非异步加载 
    *功能说明:我们用原始的setValue的方法时，如果选择的元素在第3级的话不会进行展开，所以写了此扩展方法 
    */  
    setExpandValue:function(jq,v){  
          
        var o = jq[0] ;  
        var cbt =  $(o).combotree('tree');  
        $(o).combotree('setValue',v);  
        var node =cbt.tree('find',v);  
        if(node){  
            cbt.tree('expandTo',node.target);  
        }  
    }  
});  


$.extend($.fn.validatebox.defaults.rules, {
				CHS: {
					validator: function (value, param) {
						return /^[\u0391-\uFFE5]+$/.test(value);
					},
					message: '请输入汉字'
				},
				english : {// 验证英语
			        validator : function(value) {
			            return /^[A-Za-z]+$/i.test(value);
			        },
			        message : '请输入英文'
			    },
			    ip : {// 验证IP地址
			        validator : function(value) {
			            return /\d+\.\d+\.\d+\.\d+/.test(value);
			        },
			        message : 'IP地址格式不正确'
			    },
				ZIP: {
					validator: function (value, param) {
						return /^[1-9]\d{5}$/.test(value);
					},
					message: '邮政编码不存在'
				},
				QQ: {
					validator: function (value, param) {
						return /^[1-9]\d{4,10}$/.test(value);
					},
					message: 'QQ号码不正确'
				},
				mobile: {
					validator: function (value, param) {
						return /^[1][3,4,5,7,8][0-9]{9}$/.test(value);
						
					},
					message: '手机号码不正确'
				},
				tel:{
					validator:function(value,param){
						return /^\d{3,4}?\d{7,8}$/.test(value);
					},
					message:'电话号码不正确,须输入区号'
				},
				
				mobileTelephone:{
					validator:function(value,param){
					    var cmccMobile = /^[1][3,4,5,7,8][0-9]{9}$/;
					    //var tel=/^(\d{3}-|\d{4}-)?(\d{8}|\d{7})?(-\d{3}|-\d{4})?$/;
					    var tel = /^\d{3,4}?\d{7,8}$/;
						return tel.test(value) || (value.length == 11 && cmccMobile.test(value));
					},
					message:'请正确填写您的联系电话,固定电话须输入区号'
				},
				number: {
					validator: function (value, param) {
						return /^[0-9]+.?[0-9]*$/.test(value);
					},
					message: '请输入数字'
				},
				specstr: {
					validator: function (value, param) {
						return /^[0-9,]*$/.test(value);
					},
					message: '请输入数字或者逗号'
				},
				telstr: {
					validator: function (value, param) {
						return /^[0-9-]*$/.test(value);
					},
					message: '只支持-和数字。'
				},
				integer:{
					validator:function(value,param){
						return /^[+]?[1-9]\d*$/.test(value);
					},
					message: '请输入整数'
				},
				range:{
					validator:function(value,param){
						if(/^[0-9]\d*$/.test(value)){
							return value >= param[0] && value <= param[1]
						}else{
							return false;
						}
					},
					message:'输入的数字在{0}到{1}之间'
				},
				rangeDouble:{
					validator:function(value,param){
					       return /^[0-9]+([.]{1}[0-9]{1,4})?$/.test(value);
					},
					message:'请输入合法数字,非负整数或小数[小数最多精确到小数点后四位]！'
				},
				rangeDoubles:{
					validator:function(value,param){
						if(/^[0-9]\d*$/.test(value) || /^[0-9]+(.[0-9]{0,1})\d*$/.test(value)){
							return value >= param[0] && value <= param[1]
						}else{
							return false;
						}
					},
					message:'输入的数字在{0}到{1}之间,且最多三位小数'
				},
				maxLengths:{
					validator:function(value,param){
				     return  value.length<=param[0]
					},
					message:'最多{0}个汉字。'
				},
				minLength:{
					validator:function(value,param){
						return value.length >=param[0]
					},
					message:'至少输入{0}个字'
				},
				maxLength:{
					validator:function(value,param){
						return getstrlen(value)<=param[0]
					},
					message:'最多{0}个字符，一个汉字占3个字符。'
						
				},
				//select即选择框的验证
				selectValid:{
					validator:function(value,param){
						if(value == param[0]){
							return false;
						}else{
							return true ;
						}
					},
					message:'请选择'
				},
				loginName: {
					validator: function (value, param) {
						return /^[A-Za-z0-9\u0391-\uFFE5]+$/.test(value);
					},
					message: '登录名称只能由汉字、字母和数字组成。'
				},
				equalTo: {
					validator: function (value, param) {
						return value == $(param[0]).val();
					},
					message: '两次输入的字符不一至'
				},
				email: {
					validator: function (value, param) {
						return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/.test(value);
					},
					message: '请输入正确邮箱号'
				},
				invalidChar: {
					validator: function (value, param) {
						var reg = /[\s\d!@#$%^&*()]/;
						return !reg.test(value);
					},
					message: '不能含有数字、空格或非法字符等'
				}
			});

});
var chinaWordLen = 3;  //一个汉字占的数据库长度 SQLSERVER:2 ORACLE-UTF8:3
function getstrlen(str)
{
    var len;
    var i;
    len = 0;
    for (i=0;i<str.length;i++)
    {
        if (str.charCodeAt(i)>255) len+=chinaWordLen; else len++;
    }
    return len;
}
