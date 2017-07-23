function finish(){
/*	//验证孕周
 	var tagA = /^[0-9]{1}$|^[0-9]{2}$/;
	var weekA=document.getElementById("u281_inputA").value;
		if(!tagA.test(weekA) ){
			alert("请输入正确的孕周(周 )");
			return false;
		};
		var daytimeA = /^[0-9]{1}$/;
		var dayA=document.getElementById("u286_inputA").value;
		if(!daytimeA.test(dayA) ){
			alert("请输入正确的孕周(天)");
			return false;
		};
		//验证孕次
		var timeA=document.getElementById("u295_inputA").value;
		if(timeA ==null || timeA==""){
			alert("请选择孕次");
			return false;
		};
		
		//验证产次
		var chantimeA=document.getElementById("u298_inputA").value;
		if(chantimeA ==null || chantimeA==""){
			alert("请选择产次");
			return false;
		};
		
		//验证孕产保健次数
		var yuntimeA=document.getElementById("u305_inputA").value;
		if(yuntimeA ==null || yuntimeA==""){
			alert("请选择孕产保健");
			return false;
		};
		
		
		
		
		//验证是否检测乙肝
		var yiganA=document.getElementById("u310_inputA").value;
		if(yiganA ==null || yiganA==""){
			alert("请选择是否检测乙肝");
			return false;
		};
		//验证血红蛋白检测
		var xueA=document.getElementById("u328_inputA").value;
		if(xueA ==null || xueA==""){
			alert("请选择血红蛋白检测");
			return false;
		};
		
		//验证第一次产程时
		var firstchanA= /^\+?[1-9][0-9]*$/;
		var chanweekA=document.getElementById("u430_inputA").value;
		if(!firstchanA.test(chanweekA)){
			alert("请输入第一次产程(时)");
			return false;
		};
		//验证第一产程分
		var firstchanfenA= /^\+?[1-9][0-9]*$/;
		var chanTianA=document.getElementById("u435_inputA").value;
		if(!firstchanfenA.test(chanTianA)){
			alert("请输入第一次产程(分)");
			return false;
		};
		
		//验证分娩地点
		var dianA = /^[\u4e00-\u9fa5]{0,}$/;
		var jiehunA=document.getElementById("u429_inputA").value;
		var difianA=document.getElementById("u909_inputA").value;
		if(jiehunA == null &&difianA !=null){
			if(!dianA.test(difianA)){
				alert("请输入中文");
				return false;
			};
		};
		
	
		//验证第二产程时
		var secondshiA=/^\+?[1-9][0-9]*$/;
		var erchanA=document.getElementById("u436_inputA").value;
		if(!secondshiA.test(erchanA)){
			alert("请输入第二次产程(时)(数字)");
			return false;
		};
		
		//验证第二产程分
		var secondfenA=/^\+?[1-9][0-9]*$/;
		var erfenA=document.getElementById("u441_inputA").value;
		if(!secondfenA.test(erfenA)){
			alert("请输入第二次产程(分)(数字)");
			return false;
		};
		
		
		//验证第三产程时
		var threeshiA=/^\+?[1-9][0-9]*$/;
		var sanchanA=document.getElementById("u442_inputA").value;
		if( !threeshiA.test(sanchanA)){
			alert("请输入第三次产程(时)(数字)");
			return false;
		};
		
		//验证第三产程分
		var threefenA=/^\+?[1-9][0-9]*$/;
		var sanfenA=document.getElementById("u447_inputA").value;
		if(! threefenA.test(sanfenA)){
			alert("请输入第三次产程(分)(数字)");
			return false;
		};
		
		
		//验证总产程时
		var totalfenA=/^\+?[1-9][0-9]*$/;
		var totalchanA=document.getElementById("u448_inputA").value;
		if(!totalfenA.test(totalchanA)){
			alert("请输入总产程(时)");
			return false;
		};
		
		//验证在总产程分
		var totfenA=/^\+?[1-9][0-9]*$/;
		var totalfenA=document.getElementById("u453_inputA").value;
		if(!totfenA.test(totalfenA)){
			alert("请输入总产程(分)");
			return false;
		};
		//验证胎盘
		var taipanA=document.getElementById("u454_inputA").value;
		if(taipanA ==null || taipanA ==""){
			alert("请输入胎盘");
		};
		
		
		var huiyinA=document.getElementById("u455_inputA").value;
		if(huiyinA ==null || huiyinA ==""){
			alert("请输入会阴侧切");
		};
		

		
		var shanglieA=document.getElementById("u456_inputA").value;
		if(shanglieA ==null || shanglieA ==""){
			alert("请输入伤裂");
			return false;
		};
		
		
		var chuxueliangA=/^\+?[1-9][0-9]*$/;
		var chanliangA=document.getElementById("u467_inputA").value;
		if(!chuxueliangA.test(chanliangA)){
			alert("请输入产时出血量");
			return false;
		};
		
		
		
		var twohourliangA=/^\+?[1-9][0-9]*$/;
		var twoliangA=document.getElementById("u470_inputA").value;
		if(!twohourliangA.test(twoliangA)){
			alert("请输入产时2小时出血量");
			return false;
		};
		
		
		var totalhourliangA=/^\+?[1-9][0-9]*$/;
		var talliangA=document.getElementById("u471_inputA").value;
		if(!totalhourliangA.test(talliangA)){
			alert("请输入总出血量");
			return false;
		};
		
		//验证胎盘
		var yangshuiA=document.getElementById("u481_inputA").value;
		if(yangshuiA ==null || yangshuiA ==""){
			alert("请输入羊水性状");
			return false;
		};
		
		
		
		var yangshuiliangA=/^\+?[1-9][0-9]*$/;
		var tyangshuiA=document.getElementById("u478_inputA").value;
		if(!yangshuiliangA.test(tyangshuiA)){
			alert("请输入羊水量");
			return false;
		};
		
		var taishuiA=document.getElementById("u483_inputA").value;
		if(taishuiA ==null || taishuiA ==""){
			alert("请选择胎数");
			return false;
		};*/
		
		var taiweiA=document.getElementById("u457_inputA").value;
		if(taiweiA ==null || taiweiA ==""){
			alert("请选择胎位");
			return false;
		};
		
		var fenmiansA=/^\+?[1-9][0-9]*$/;
		var fenmainshiA=document.getElementById("u460_inputA").value;
		if(!fenmiansA.test(fenmainshiA) ){
			alert("请填写分娩   时");
			return false;
		};
		
		var fenmianfA=/^\+?[1-9][0-9]*$/;
		var fenmainfenA=document.getElementById("u465_inputA").value;
		if(!fenmianfA.test(fenmainfenA)){
			alert("请填写分娩    分");
			return false;
		};
		
		
		var yinchanA=document.getElementById("u458_inputA").value;
		if(yinchanA ==null || yinchanA ==""){
			alert("请选择引产");
			return false;
		};
		
		
		var fenmianfangA=document.getElementById("u459_inputA").value;
		if(fenmianfangA ==null || fenmianfangA ==""){
			alert("请选择分娩方式");
			return false;
		};
		
		var zhizhengA=document.getElementById("u466_inputA").value;
		if(zhizhengA ==null || zhizhengA ==""){
			alert("请选择指证");
			return false;
		};
		
		var xingmingA=document.getElementById("u485_inputA").value;
		if(xingmingA ==null || xingmingA ==""){
			alert("请输入婴儿姓名");
			return false;
		};
		
		var xinbieA=document.getElementById("u482_inputA").value;
		if(xinbieA ==null || xinbieA ==""){
			alert("请选择婴儿性别");
			return false;
		};
		
		var jiankangA=document.getElementById("u484_inputA").value;
		if(jiankangA==null || jiankangA ==""){
			alert("请选择婴儿健康状况");
			return false;
		};
		
		var jixingA=document.getElementById("u486_inputA").value;
		if(jixingA ==null || jixingA ==""){
			alert("请选择婴儿畸形状况");
			return false;
		};
		
		var buweiA=document.getElementById("u487_inputA").value;
		if(buweiA ==null || buweiA ==""){
			alert("请输入婴儿畸形部位");
			return false;
		};
		
		var jixingmingA=document.getElementById("u488_inputA").value;
		if(jixingmingA ==null || jixingmingA ==""){
			alert("请输入婴儿畸形名称");
			return false;
		};
		
		
		var yifengA=document.getElementById("u489_inputA").value;
		if(yifengA ==null || yifengA ==""){
			alert("请输入一分钟评分");
			return false;
		};
		
		
		var wufenA=document.getElementById("u490_inputA").value;
		if(wufenA ==null || wufenA ==""){
			alert("请输入五分钟评分");
			return false;
		};
		
		
		var tizhongA=document.getElementById("u491_inputA").value;
		if(tizhongA ==null || tizhongA ==""){
			alert("请输入体重");
			return false;
		};
		
		var shenchangA=document.getElementById("u492_inputA").value;
		if(shenchangA ==null || shenchangA ==""){
			alert("请输入身长");
			return false;
		};
		
		
		
		
		var jieshengA=document.getElementById("u497_inputA").value;
		if(jieshengA ==null || jieshengA ==""){
			alert("请输入接生者");
			return false;
		};
		
		
		
		
		var val_payPlatformA = $('input[name="referral"]:checked ').val();
		if(val_payPlatformA==undefined){
			
			alert("请选择是否转诊");
			return false;
		};

	
		
	
	
		var shouceA=document.getElementById("u52_inputA").value;
		if(shouceA ==null || shouceA ==""){
			alert("请选择是否发放母子健康手册");
			return false;
		};
		
		
		var geneticHistoryA = $('input[name="vaccine"]:checked').val();
		  
		 if (geneticHistoryA == undefined) {
		alert("请选择疫苗");
		return false;
	 };
	 
	 
	 
	
	 
	 

		var val_payPlatwwA = $('input[name="orderCheck"]:checked ').val();
		if(val_payPlatwwA=="0"){
		
	 		//获取下次访视日期
			var fangA=document.getElementById("u43_input").value;
			
	 		if(fangA==null ||fangA ==""){
				alert("请选择下次访视日期");
			
			
			
				return false;
				}
		};
	
	
}