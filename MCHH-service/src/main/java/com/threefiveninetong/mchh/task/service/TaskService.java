/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: TaskService.java 
 * @Prject: MyUniversity-service
 * @Package: cn.com.devsource.myuniversity.task.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-01-08 10:14:25 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.task.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.archives.dao.BirthArchivesInfoDao;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.childbirth.dao.ChildbirthBasicInfoDao;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.config.dao.ShortMessageTemplateDao;
import com.threefiveninetong.mchh.config.dto.SmsScreenTempVo;
import com.threefiveninetong.mchh.config.po.ShortMessageTemplatePO;
import com.threefiveninetong.mchh.prenatal.dao.FirstMotherhoodInfoDao;
import com.threefiveninetong.mchh.sms.dao.SysSmsSendedDao;
import com.threefiveninetong.mchh.sms.po.SysSmsSendedPO;
import com.threefiveninetong.mchh.sms.service.SmsService;
import com.threefiveninetong.mchh.util.DateStyle;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DateUtils;


/**
 * @ClassName: TaskService
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-09-14 10:14:25
 */
@Service
public class TaskService{

    private static final Logger log = LoggerFactory	.getLogger(TaskService.class);

//    @Resource
//    Environment env;
    
    @Resource
    private BirthArchivesInfoDao birthArchivesInfoDao;
    
    @Resource
    private FirstMotherhoodInfoDao firstMotherhoodInfoDao;
    
    @Resource
    private ChildbirthBasicInfoDao childbirthBasicInfoDao;
    
    @Resource
    private ShortMessageTemplateDao shortMessageTemplateDao;
    
    @Resource
    private SmsService smsService;

    @Resource
    private SysSmsSendedDao sysSmsSendedDao;
    /**
     * 自动结案
     */
    public void autoCloseCase() {
    	try {

	    	//查出未结案的生育档案
	    	List<BirthArchivesInfoPO> birthArchivesInfoPOList=birthArchivesInfoDao.getNoCloseCase();
	    	if(null!=birthArchivesInfoPOList&&birthArchivesInfoPOList.size()>0){
	    		for(int i=0;i<birthArchivesInfoPOList.size();i++){//循环处理所有未结案的生育档案
	    			
	    			boolean isClose=false;//是否结案，默认不结案
	    			
	    			BirthArchivesInfoPO birthArchivesInfoPO=birthArchivesInfoPOList.get(i);
	    			String birthArchivesId=birthArchivesInfoPO.getId();
	    			String pregnantState=birthArchivesInfoPO.getPregnantState();
	    			if(pregnantState.equals("0")){//妊娠中
	    				//查询末次月经
//	    				FirstMotherhoodInfoPO firstMotherhoodInfoPO = firstMotherhoodInfoDao.getFirstMotherhoodByBirthArchivesId(birthArchivesId);
	    				//计算预产期,超过预产期60天，自动结案
	    				if(null!=birthArchivesInfoPO.getLastMenses()&&!birthArchivesInfoPO.getLastMenses().equals("")){
		    				long dayDiff=DateUtils.dayDiff(DateUtils.expectedDate(birthArchivesInfoPO.getLastMenses()),new Date());
		    				if(dayDiff>60){
		    					//结案
		    					isClose=true;
		    				}
	    				}
	    			}else{//已分娩
	    				//查询分娩时间
	    				//超过分娩日期60，自动结案
	    				ChildbirthBasicInfoPO childbirthBasicInfoPO=childbirthBasicInfoDao.getChildbirthBasicByBirthArchivesId(birthArchivesId);
	    				if(null!=childbirthBasicInfoPO){
		    				childbirthBasicInfoPO.getBirthDate();
		    				//查询分娩日期,超过分娩日期60天，自动结案
		    				long dayDiff=DateUtils.dayDiff(childbirthBasicInfoPO.getBirthDate(),new Date());
		    				if(dayDiff>60){
		    					//结案
		    					isClose=true;
		    				}
	    				}
	    			}
	    			if(isClose){//结案
	    				Map paraMap=new HashMap();
						paraMap.put("closeCaseReason", "5");//自动结案
						paraMap.put("closeCaseTime", new Date());
						paraMap.put("birthArchivesId", birthArchivesId);
						birthArchivesInfoDao.toCloseCase(paraMap);
	    			}
	    		}
	    	}

	    	//查询所有结案的生育档案，清理历史短信
	    	List<SmsScreenTempVo> smsScreenTempVoList=shortMessageTemplateDao.getCloseCase();
	    	for(int m=0;m<smsScreenTempVoList.size();m++){
	    		SmsScreenTempVo smsScreenTempVo=smsScreenTempVoList.get(m);
	    		String telephone = smsScreenTempVo.getTelephone();
	    		//删除历史短信记录
	    		sysSmsSendedDao.deleteByTel(telephone);
	    	}
    	} catch (Exception e) {
		      e.printStackTrace();
		      log.error("自动结案定时任务报异常",e);
    	}
    }
    
    
    /**
     * 短信提醒
     */
    public void messageRemind() {
    	try {
    		List<ShortMessageTemplatePO> shortMessageTemplatePOList = shortMessageTemplateDao.findAlluse();
    		if(null!=shortMessageTemplatePOList&&shortMessageTemplatePOList.size()>0){
    			for(int i=0;i<shortMessageTemplatePOList.size();i++){
    				ShortMessageTemplatePO shortMessageTemplatePO=shortMessageTemplatePOList.get(i);
    				String appointmentDate=DateUtil.dateToString(new Date(),DateStyle.YYYY_MM_DD);
    				if(shortMessageTemplatePO.getSendTime().equals("0")){
    					//预约时间
    					appointmentDate=DateUtil.dateToString(DateUtil.addInteger(new Date(),Calendar.DATE, 3),DateStyle.YYYY_MM_DD);
    				}
    				
    				String smsType="0";
					
					int startDay=0;
					int endDay=0;
					
					String highRisk="";
					switch(shortMessageTemplatePO.getSendCrowd())
					{
					case "0": startDay=0;endDay=90;smsType="000";//孕12周以前
						break;
					case "1":startDay=91;endDay=118;smsType="001";//孕13-16周
						break;
					case "2": startDay=119;endDay=146;smsType="002";//孕17-20周
						break;
					case "3": startDay=147;endDay=174;smsType="003";//孕21-24周
						break;
					case "4": startDay=175;endDay=202;smsType="004";//孕25-28周
						break;
					case "5": startDay=203;endDay=216;smsType="005";//孕29-30周
						break;
					case "6": startDay=217;endDay=230;smsType="006";//孕31-32周
						break;
					case "7": startDay=231;endDay=244;smsType="007";//孕33-34周
						break;
					case "8": startDay=245;endDay=258;smsType="008";//孕35-36周
						break;
					case "9": startDay=259;endDay=265;smsType="009";//孕37周
						break;
					case "10": startDay=266;endDay=272;smsType="010";//孕38周
						break;
					case "11": startDay=273;endDay=279;smsType="011";//孕39周
						break;
					case "12": highRisk="心脏病";smsType="012";//心脏病
						break;
					case "13": highRisk="糖尿病";smsType="013";//糖尿病
						break;
					}
					
					String content=shortMessageTemplatePO.getContent();//短信内容
					
					List<SmsScreenTempVo> smsScreenTempVoList = null;
					
    				if(shortMessageTemplatePO.getMessType().equals("0")){//预约检查提醒短信
    					//（妊娠中的，最近一次的检查记录，预约日期为当前日期+3小时，孕周符合的）或（妊娠中的，最近一次的检查记录，计算孕周日期，提前三天。）
    					Map paraMap=new HashMap();
						paraMap.put("nextFollowingDate", appointmentDate);
						paraMap.put("startDay",startDay);
						paraMap.put("endDay", endDay);
    					smsScreenTempVoList = shortMessageTemplateDao.screenByFollowingDate(paraMap);
    					
    				}else if(shortMessageTemplatePO.getMessType().equals("1")){//高危检查提醒短信
    					//(妊娠中的，最近一次的检查记录,预约日期为当前日期+3小时，高危项符合的)或（妊娠中的，最近一次的检查记录,计算孕周日期，提前三天。）
    					
    					Map paraMap=new HashMap();
						paraMap.put("nextFollowingDate", appointmentDate);
						paraMap.put("highRisk",highRisk);
    					smsScreenTempVoList = shortMessageTemplateDao.screenByHighRisk(paraMap);
    					
    					//根据孕周，再次筛选
    					for(int n=0;n<smsScreenTempVoList.size();n++){
    						SmsScreenTempVo smsScreenTempVo=smsScreenTempVoList.get(n);
    						if(smsScreenTempVo.getOrderCheck().equals("0")){//没有预约
    							int weekNum=DateUtils.getWeekByLastMenses(smsScreenTempVo.getLastMenses());
    							
    							int nextExaWeek=0;
    							if(weekNum<=12){
    								nextExaWeek=13;
    							}else if(weekNum>=13&&weekNum<=16){
    								nextExaWeek=17;
    							}else if(weekNum>=17&&weekNum<=20){
    								nextExaWeek=21;
    							}else if(weekNum>=21&&weekNum<=24){
    								nextExaWeek=25;
    							}else if(weekNum>=25&&weekNum<=28){
    								nextExaWeek=29;
    							}else if(weekNum>=29&&weekNum<=30){
    								nextExaWeek=31;
    							}else if(weekNum>=31&&weekNum<=32){
    								nextExaWeek=33;
    							}else if(weekNum>=33&&weekNum<=34){
    								nextExaWeek=35;
    							}else if(weekNum>=35&&weekNum<=36){
    								nextExaWeek=37;
    							}else if(weekNum==37){
    								nextExaWeek=38;
    							}else if(weekNum==38){
    								nextExaWeek=39;
    							}else if(weekNum==39){
    								nextExaWeek=40;
    							}

    							//计算下次产检第一天的时间
    							String nextExaTime=DateUtil.dateToString(DateUtil.addInteger(smsScreenTempVo.getLastMenses(),Calendar.DATE, nextExaWeek*7),DateStyle.YYYY_MM_DD);
								if(!appointmentDate.equals(nextExaTime)){//如果和当前时间提前三天不相等
									smsScreenTempVoList.remove(smsScreenTempVo);//remove掉
									n--;
								}
    						}
    					}
    				}
    				
    				if(null!=smsScreenTempVoList&&smsScreenTempVoList.size()>=1){
	    				for(int j=0;j<smsScreenTempVoList.size();j++){
							String telephone=smsScreenTempVoList.get(j).getTelephone();
							//是否发送过此类型短信
							List<SysSmsSendedPO> sysSmsSendedPOList=sysSmsSendedDao.findByPhoneAndType(telephone, smsType);
							if(!(null!=sysSmsSendedPOList&&sysSmsSendedPOList.size()>=1)){
								//调用发送短信接口
								smsService.sendSms(telephone, content,smsType);//发送短信
							}
						}
    				}
    			}
    		}
    		
    	} catch (Exception e) {
		      e.printStackTrace();
		      log.error("短信提醒定时任务报异常",e);
    	}
  }
  
}