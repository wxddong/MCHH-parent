package com.threefiveninetong.mchh.highriskmaternalmanage.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.highriskmaternalmanage.dao.HighRiskMaternalManageDao;
import com.threefiveninetong.mchh.highriskmaternalmanage.po.HighRiskMaternalManagePO;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;

@Service
public class HighRiskMaternalManageService {
	
	@Resource
	private HighRiskMaternalManageDao highRiskMaternalManageDao;
	
	/**
	 * 高危孕产妇列表(报表导出使用)
	 * wangxd 2016.10.6
	 * @param conds
	 * @throws UnsupportedEncodingException 
	 */
	public List<HighRiskMaternalManagePO> listForExport(Map<String, Object> conds) throws UnsupportedEncodingException {
		

		//将转诊状态作为查询条件传入到sql
		String thisHospitalId = (String) conds.get("thisHospitalId");
		
		String  referralStatue = (String) conds.get("referralStatue");
		if("n".equals(referralStatue)){
			conds.remove(referralStatue);
		}
		if("in".equals(referralStatue)){
			//如果是转入的话，转入医院的id为本院id,
			conds.put("inHosital", "inHosital");
			conds.put("thisHospitalId", thisHospitalId);
		}
		if("this".equals(referralStatue)){
			//如果是本院的话，生育档案的建档医院的id等于当前医院的id
			conds.put("thisHosital", "thisHosital");
			conds.put("thisHospitalId", thisHospitalId);
		}
		if("out".equals(referralStatue)){
			//如果是转出的话，生育档案的转入医院id等于当前医院的id
			conds.put("outHosital", "outHosital");
			conds.put("thisHospitalId", thisHospitalId);
		}
		
		//将转归作为查询条件传给sql
		String lapseTo = (String) conds.get("lapseTo");
		if("n".equals(lapseTo)){
			conds.remove("lapseTo");
		}
		//根据前台传进的是否结案来给sql传入查询条件
		String ifClose = (String) conds.get("ifClose");
		String statue = (String) conds.get("statue");
		if("0".equals(ifClose)){
			//已结案
			conds.put("isClose", 2);
		}else if("1".equals(ifClose)){
			//未结案
			conds.put("noClose", 2);
			
			if("n".equals(statue)){
				conds.remove("statue");
				conds.put("statueAll",2);
			}
			
		}else{
			conds.remove("ifClose");
		}
		//如果选择已结案，把结案原因带入sql语句
		String closeReason = (String) conds.get("closeReason");
		if("n".equals(closeReason)){
			conds.remove("closeReason");
		}
		if("n".equals(statue)){
			conds.remove("statue");
		}
		
		//将高危因素作为查询条件传入到sql
		String highRisk = (String) conds.get("highRisk");
		if("n".equals(highRisk)){
			conds.remove("highRisk");
		}else if("m".equals(highRisk)){
			conds.remove("highRisk");
			conds.put("m", "m");
		}
		//将得分作为查询条件传入sql
		String score = (String) conds.get("score");
		if("0".equals(score)){
			conds.put("zero", "zero");
		}
		if("5".equals(score)){
			conds.put("five","five");
		}
		if("10to15".equals(score)){
			conds.put("tenToFiveteen", "tenToFiveteen");
		}
		if("G20".equals(score)){
			conds.put("G20", "G20");
		}
		
		//根据医疗机构作为查询条件传入sql
		String countyMechanism = (String) conds.get("countyMechanism");
		String townMechanism =  (String) conds.get("townMechanism");
		String villageMechanism =  (String) conds.get("villageMechanism");
		if(villageMechanism!=null && villageMechanism!=""){
			conds.put("departmentId", villageMechanism);
		}else if(townMechanism!=null && townMechanism!=""){
			conds.put("departmentId", townMechanism);
		}else if(countyMechanism!=null && countyMechanism!=""){
			conds.put("departmentId", countyMechanism);
		}
		
		List<HighRiskMaternalManagePO> list = highRiskMaternalManageDao.listForPage(conds);
		if(list!=null && list.size() > 0){
			for (HighRiskMaternalManagePO highRiskMaternalManagePO : list) {
				//将查询出来的省市县乡村家庭地址取出放进List集合，然后转化为字符串重新赋值给address
				List<String> addressList = new ArrayList<>();
				addressList.add(highRiskMaternalManagePO.getProvinceName());
				addressList.add(highRiskMaternalManagePO.getCityName());
				addressList.add(highRiskMaternalManagePO.getCountyName());
				addressList.add(highRiskMaternalManagePO.getTownshipName());
				addressList.add(highRiskMaternalManagePO.getVillageName());
				addressList.add(highRiskMaternalManagePO.getDetailAddress());
				String address = StringUtil.listToString(addressList);
				highRiskMaternalManagePO.setAddress(address);
				//根据末次月经计算孕周
				Date lastMenses = highRiskMaternalManagePO.getLastMenses();
				int weeks = DateUtils.getWeekByLastMenses(lastMenses);
				highRiskMaternalManagePO.setWeeks(weeks);
				//根据出生日期计算年龄
				Date birthday = highRiskMaternalManagePO.getBirthday();
				int age= DateUtils.getAgeByBirthday(birthday);
				highRiskMaternalManagePO.setAge(age);
				//将转归改为汉字
				String lapseToNo = highRiskMaternalManagePO.getLapseToNo();
				if("0".equals(lapseToNo)){
					highRiskMaternalManagePO.setLapseTo("继续监护");
				}
				if("1".equals(lapseToNo)){
					highRiskMaternalManagePO.setLapseTo("正常随访");
				}
				if("2".equals(lapseToNo)){
					highRiskMaternalManagePO.setLapseTo("结束分娩");
				}
			}
		}
		return list;
	}

	/**
	 * 高危孕产妇列表
	 * wangxd 2016.9.16
	 * @param conds
	 * @param page
	 */
	public void listForPage(Map<String, Object> conds, Page<HighRiskMaternalManagePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<HighRiskMaternalManagePO> list = highRiskMaternalManageDao.listForPage(conds);
		if(list!=null && list.size() > 0){
			for (HighRiskMaternalManagePO highRiskMaternalManagePO : list) {
				//将查询出来的省市县乡村家庭地址取出放进List集合，然后转化为字符串重新赋值给address
				List<String> addressList = new ArrayList<>();
				addressList.add(highRiskMaternalManagePO.getProvinceName());
				addressList.add(highRiskMaternalManagePO.getCityName());
				addressList.add(highRiskMaternalManagePO.getCountyName());
				addressList.add(highRiskMaternalManagePO.getTownshipName());
				addressList.add(highRiskMaternalManagePO.getVillageName());
				addressList.add(highRiskMaternalManagePO.getDetailAddress());
				String address = StringUtil.listToString(addressList);
				highRiskMaternalManagePO.setAddress(address);
				//根据末次月经计算孕周
				Date lastMenses = highRiskMaternalManagePO.getLastMenses();
				if(lastMenses!=null){
					int weeks = DateUtils.getWeekByLastMenses(lastMenses);
					highRiskMaternalManagePO.setWeeks(weeks);
				}
				
				//根据出生日期计算年龄
				Date birthday = highRiskMaternalManagePO.getBirthday();
				if(birthday!=null){
					int age= DateUtils.getAgeByBirthday(birthday);
					highRiskMaternalManagePO.setAge(age);
				}
				
				//将转归改为汉字
				String lapseToNo = highRiskMaternalManagePO.getLapseToNo();
				if("0".equals(lapseToNo)){
					highRiskMaternalManagePO.setLapseTo("继续监护");
				}
				if("1".equals(lapseToNo)){
					highRiskMaternalManagePO.setLapseTo("正常随访");
				}
				if("2".equals(lapseToNo)){
					highRiskMaternalManagePO.setLapseTo("结束分娩");
				}
			}
		}
		page.setList(list);
	}

	/**
	 * 本院本日新增人数
	 * wangxd 2016.9.29
	 * @param depId
	 * @return
	 */
	public int getIncreaseNumToday(String depId) {
		
		return highRiskMaternalManageDao.getIncreaseNumToday(depId);
	}

	/**
	 * 本院本日新增人数
	 * wangxd 2016.9.29 
	 * @param depId
	 * @return
	 */
	public int getInNumToday(String depId) {
		return highRiskMaternalManageDao.getInNumToday(depId);
	}

	/**
	 * 本院本日转入人数
	 * wangxd 2016.9.29
	 * @param depId
	 * @return
	 */
	public int getOutNumToday(String depId) {
		return highRiskMaternalManageDao.getOutNumToday(depId);
	}

	/**
	 * 本院共计人数
	 * wangxd 2016.9.29
	 * @param depId
	 * @return
	 */
	public int getTotalNum(String depId) {
		return highRiskMaternalManageDao.getTotalNum(depId);
	}

	/**
	 * 获取辖区总人口数
	 * wangxd 2016.9.29
	 * @param depId
	 * @return
	 */
	public String getAllPeopleNum(String depId) {
		return highRiskMaternalManageDao.getAllPeopleNum(depId);
	}
}
