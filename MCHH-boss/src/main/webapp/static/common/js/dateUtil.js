//年-月-日 时：分：秒
function formattime(val) {
	if(val){
	 	var d=new Date(val);
		var year=d.getFullYear();
		var month=d.getMonth()+1;
		month=month>9?month:('0'+month);
		var date=d.getDate();
		date=date>9?date:('0'+date);
		var hours=d.getHours();
		hours=hours>9?hours:('0'+hours);
		var minutes=d.getMinutes();
		minutes=minutes>9?minutes:('0'+minutes);
		var seconds=d.getSeconds();
		seconds=seconds>9?seconds:('0'+seconds);
		var time=year+'-'+month+'-'+date+' '+hours+':'+minutes+':'+seconds;
	    return time;
	}
}

//计算儿童年龄
function getAge(val){
	if(val){
		var birthday = new Date(val);
		var nowdate = new Date();
		var age =nowdate.getFullYear() - birthday.getFullYear();
		var month =nowdate.getMonth() + 1 - (birthday.getMonth() + 1);
		var day = nowdate.getDate() - birthday.getDate();
		var dayNo = parseInt((nowdate.getTime() - birthday.getTime())/(1000*60*60*24));
		month += age*12;
		var bigMonths = [1,3,5,7,8,10,12];
		var smallMonths = [4,6,9,11];
		var big = -1;
		for(var i = 0; i < bigMonths.length; i++){
			if(nowdate.getMonth() == bigMonths[i]){
				big = 0;
			}
		}
		var small = -1;
		for(var i = 0; i < smallMonths.length; i ++){
			if(nowdate.getMonth() == smallMonths[i]){
				small = 0;
			}
		}
		if(age >= 3 && age < 100){
			return age+"岁";
		}else if(age < 3 && age >= 0){
			if(nowdate.getMonth() == 2 && nowdate.getFullYear()%4 == 0){
				if(dayNo == 29){
					return "满月";
				}else if(dayNo < 29){
					return dayNo+"天";
				}else if(month == 1){
					return "满月";
				}else if(month > 1){
					return month + "月";
				}
			}else if(nowdate.getMonth() == 2 && nowdate.getFullYear()%4 != 0){
				if(dayNo == 28){
					return "满月";
				}else if(dayNo < 28){
					return dayNo+"天";
				}else if(month == 1){
					return "满月";
				}else if(month > 1){
					return month + "月";
				}
			}else if(big == 0){
				if(dayNo == 31){
					return "满月";
				}else if(dayNo < 31){
					return dayNo+"天";
				}else if(month == 1){
					return "满月";
				}else if(month > 1){
					return month + "月";
				}
			}else if(small == 0){
				if(dayNo == 30){
					return "满月";
				}else if(dayNo < 30){
					return dayNo+"天";
				}else if(month == 1){
					return "满月";
				}else if(month > 1){
					return month + "月";
				}
			}
		}
	}
}
//年-月-日
function formatDate(val) {
	if(val){
	 	var d=new Date(val);
		var year=d.getFullYear();
		var month=d.getMonth()+1;
		month=month>9?month:('0'+month);
		var date=d.getDate();
		date=date>9?date:('0'+date);
		var time=year+'-'+month+'-'+date;
	    return time;
	}
}

function formaDouble(val){
	var d;
	if(parseInt(val)==val){
	    d=val;	
	}else{
	     d=val.toFixed(2);
	}
	d=d+'元';
	return d;
}


// 产品钱转
function formaProdutc(val,row){
	var type=row.type;
	var d=val;
	if(parseInt(val)==val){
	    d=val;	
	}
	if(type==2){
		d=d+'M';
	}else{
		d=d+'元';	
	}
	return d;
}

//流水产品总值
function formaPay(val,row){
	var type=row.proType;
	var d;
	if(parseInt(val)==val){
	    d=val;	
	}else{
	     d=val.toFixed(2);
	}
	if(type==2){
		d=d+'M';
	}else{
		d=d+'元';	
	}
	return d;
}

//流水支付总额
function formaPayMoney(val,row){
	var type=row.order.payWay;
	var d;
	if(parseInt(val)==val){
	    d=val;	
	}else{
	     d=val.toFixed(2);
	}
	if(type==0){
		d=d+'个';
	}else{
		d=d+'元';	
	}
	return d;
}

//付款总额
function formaSumMoney(val,row){
	var type=row.payWay;
	var d=val;
	if(parseInt(val)==val){
	    d=val;	
	}
	if(type==0){
		d=d+'个';
	}else{
		d=d+'元';	
	}
	return d;
}


//金币单位个数
function formaGold(val){
	var d=val+'个';
	return d;
}

//100%
function formaHundred(val){
	var d=val+'%';
	return d;
}

//折扣
function formaZhe(val){
	var d=val+'折';
	return d;
}

//文本显示
function formaSizeText(val){
	var d=val;
	if(d!=''&&d!=null&&d!='null'){
		if(d.length>18){
		    md=d.substring(0,18);
			d=md+"...";
			var htmlStr= "";
		    htmlStr = htmlStr + "<div title=\""+val+"\">" +d+ "</td>";
		    return htmlStr;
		   }
		return d;
	}
}