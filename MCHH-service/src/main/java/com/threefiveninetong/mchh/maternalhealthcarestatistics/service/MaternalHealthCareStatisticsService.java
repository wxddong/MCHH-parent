package com.threefiveninetong.mchh.maternalhealthcarestatistics.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.maternalhealthcarestatistics.dao.MaternalHealthCareStatisticsDao;
import com.threefiveninetong.mchh.maternalhealthcarestatistics.po.Dates;
import com.threefiveninetong.mchh.maternalhealthcarestatistics.po.MaternalHealthCareStatisticsPO;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;

@Service
public class MaternalHealthCareStatisticsService {
	
	@Resource
	private MaternalHealthCareStatisticsDao maternalHealthCareStatisticsDao;
	
	/**
	 * 孕产妇保健统计列表（报表导出使用）
	 * wangxd 2016.10.6
	 * @param conds
	 */
	public List<MaternalHealthCareStatisticsPO> listForExport(Map<String, Object> conds) {

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
		
		List<MaternalHealthCareStatisticsPO> list = maternalHealthCareStatisticsDao.listForPage(conds);
		Map map = new HashMap();
		for (MaternalHealthCareStatisticsPO maternalHealthCareStatisticsPO : list) {
			//获取生育id
			String birthArchivesId = maternalHealthCareStatisticsPO.getBirthArchivesId();
			map.put("birthArchivesId", birthArchivesId);
			//根据出生日期计算年龄
			Date birthday = maternalHealthCareStatisticsPO.getBirthday();
			if(birthday!=null){
				int age = DateUtils.getAgeByBirthday(birthday);
				maternalHealthCareStatisticsPO.setAge(age);
			}
			//根据将当日期计算孕周
			Date lastMenses = maternalHealthCareStatisticsPO.getLastMenses();
			Date creatDate = maternalHealthCareStatisticsPO.getCreatDate();
			if(creatDate!=null && lastMenses!=null){
				int day = (int) ((creatDate.getTime() - lastMenses.getTime())/(1000*60*60*24));
		        int weeks = day / 7;
		        maternalHealthCareStatisticsPO.setWeeks(weeks);	
			}
	        
	        //将地址拼接起来
	        List<String> addressList = new ArrayList<>();
			addressList.add(maternalHealthCareStatisticsPO.getProvinceName());
			addressList.add(maternalHealthCareStatisticsPO.getCityName());
			addressList.add(maternalHealthCareStatisticsPO.getCountyName());
			addressList.add(maternalHealthCareStatisticsPO.getTownshipName());
			addressList.add(maternalHealthCareStatisticsPO.getVillageName());
			addressList.add(maternalHealthCareStatisticsPO.getDetailAddress());
			String address = StringUtil.listToString(addressList);
			maternalHealthCareStatisticsPO.setAddress(address);
	        
	        //查询13周前的随访时间和预约时间
	        int day13 = 12*7+6;
	        map.remove("minDay");
	        map.put("maxDay", day13);
	        List<Dates> dateListOne = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListOne!=null && dateListOne.size()!=0){
	            maternalHealthCareStatisticsPO.setOneCheckDate(dateListOne.get(0).getCheckDate());
	 	        maternalHealthCareStatisticsPO.setOneOrderDate(dateListOne.get(0).getOrderDate());
	        }
	       
	        //查询14-15周的随访时间和预约时间 并求出随访次数
	        int day14 = 13*7+6;
	        int day15 = 14*7+6;
	        map.put("minDay", day14);
	        map.put("maxDay", day15);
	        List<Dates> dateListTwo = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListTwo!=null && dateListTwo.size()!=0){
		        maternalHealthCareStatisticsPO.setTwoCheckTimes(dateListTwo.size());
		        maternalHealthCareStatisticsPO.setTwoOrderDate(dateListTwo.get(0).getOrderDate());
	        }
	        
	        //查询16-20周的随访时间和预约时间 并求出随访次数
	        int day16 = 15*7+6;
	        int day20 = 19*7+6;
	        map.put("minDay", day16);
	        map.put("maxDay", day20);
	        List<Dates> dateListThree = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListThree!=null && dateListThree.size()!=0){
		        maternalHealthCareStatisticsPO.setThreeCheckTimes(dateListThree.size());
		        maternalHealthCareStatisticsPO.setThreeOrderDate(dateListThree.get(0).getOrderDate());
	        }
	        //查询21-24周的随访时间和预约时间 并求出随访次数
	        int day21 = 20*7+6;
	        int day24 = 23*7+6;
	        map.put("minDay", day21);
	        map.put("maxDay", day24);
	        List<Dates> dateListFour = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListFour!=null && dateListFour.size()!=0){
		        maternalHealthCareStatisticsPO.setFourCheckTimes(dateListFour.size());
		        maternalHealthCareStatisticsPO.setFourOrderDate(dateListFour.get(0).getOrderDate());
	        }
	        //查询25-27周的随访时间和预约时间 并求出随访次数
	        int day25 = 24*7+6;
	        int day27 = 26*7+6;
	        map.put("minDay", day25);
	        map.put("maxDay", day27);
	        List<Dates> dateListFive = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListFive!=null && dateListFive.size()!=0){
		        maternalHealthCareStatisticsPO.setFiveCheckTimes(dateListFive.size());
		        maternalHealthCareStatisticsPO.setFiveOrderDate(dateListFive.get(0).getOrderDate());
	        }
	        //查询28-36周的随访时间和预约时间 并求出随访次数
	        int day28 = 27*7+6;
	        int day36 = 35*7+6;
	        map.put("minDay", day28);
	        map.put("maxDay", day36);
	        List<Dates> dateListSix = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListSix!=null && dateListSix.size()!=0){
		        maternalHealthCareStatisticsPO.setSixCheckTimes(dateListSix.size());
		        maternalHealthCareStatisticsPO.setSixOrderDate(dateListSix.get(0).getOrderDate());
	        }
	        //查询37-40周的随访时间和预约时间 并求出随访次数
	        int day37 = 36*7+6;
	        int day40 = 39*7+6;
	        map.put("minDay", day37);
	        map.put("maxDay", day40);
	        List<Dates> dateListSeven = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListSeven!=null && dateListSeven.size()!=0){
		        maternalHealthCareStatisticsPO.setSevenCheckTimes(dateListSeven.size());
		        maternalHealthCareStatisticsPO.setSevenOrderDate(dateListSeven.get(0).getOrderDate());
	        }
	        
	        //查询出院后3-7天的检查次数
	        List<Dates> dateListSevenPost3to7 = maternalHealthCareStatisticsDao.getPost3to7CheckTimes(map);
	        if(dateListSevenPost3to7!=null && dateListSevenPost3to7.size()!=0){
	        	maternalHealthCareStatisticsPO.setPost3to7Times(dateListSevenPost3to7.size());
	        	maternalHealthCareStatisticsPO.setPost3to7Date(dateListSevenPost3to7.get(0).getOrderDate());
	        }
	        //查询产后42天周的检查次数
	        int post42Times = maternalHealthCareStatisticsDao.getPost42CheckTimes(map);
	        maternalHealthCareStatisticsPO.setPost42Times(post42Times);
	    	 
			
		}
			return list;
		
		}
	
	/**
	 * 孕产妇保健统计列表
	 * wangxd 2016.9.16
	 * @param conds
	 * @param page
	 */
	public void listForPage(Map<String, Object> conds, Page<MaternalHealthCareStatisticsPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<MaternalHealthCareStatisticsPO> list = maternalHealthCareStatisticsDao.listForPage(conds);
		Map map = new HashMap();
		for (MaternalHealthCareStatisticsPO maternalHealthCareStatisticsPO : list) {
			//获取生育id
			String birthArchivesId = maternalHealthCareStatisticsPO.getBirthArchivesId();
			map.put("birthArchivesId", birthArchivesId);
			//根据出生日期计算年龄
			Date birthday = maternalHealthCareStatisticsPO.getBirthday();
			if(birthday!=null){
				int age = DateUtils.getAgeByBirthday(birthday);
				maternalHealthCareStatisticsPO.setAge(age);
			}
			
			//根据将当日期计算孕周
			Date lastMenses = maternalHealthCareStatisticsPO.getLastMenses();
			Date creatDate = maternalHealthCareStatisticsPO.getCreatDate();
			if(creatDate!=null && lastMenses!=null){
				int day = (int) ((creatDate.getTime() - lastMenses.getTime())/(1000*60*60*24));
		        int weeks = day / 7;
		        maternalHealthCareStatisticsPO.setWeeks(weeks);	
			}
	    	
	        
	        //将地址拼接起来
	        List<String> addressList = new ArrayList<>();
			addressList.add(maternalHealthCareStatisticsPO.getProvinceName());
			addressList.add(maternalHealthCareStatisticsPO.getCityName());
			addressList.add(maternalHealthCareStatisticsPO.getCountyName());
			addressList.add(maternalHealthCareStatisticsPO.getTownshipName());
			addressList.add(maternalHealthCareStatisticsPO.getVillageName());
			addressList.add(maternalHealthCareStatisticsPO.getDetailAddress());
			String address = StringUtil.listToString(addressList);
			maternalHealthCareStatisticsPO.setAddress(address);
	        
	        //查询13周前的随访时间和预约时间
	        int day13 = 13*7;
	        map.remove("minDay");
	        map.put("maxDay", day13);
	        List<Dates> dateListOne = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListOne!=null && dateListOne.size()!=0){
	            maternalHealthCareStatisticsPO.setOneCheckDate(dateListOne.get(0).getCheckDate());
	 	        maternalHealthCareStatisticsPO.setOneOrderDate(dateListOne.get(0).getOrderDate());
	        }
	       
	        //查询14-15周的随访时间和预约时间 并求出随访次数
	        int day14 = 13*7+6;
	        int day15 = 15*7;
	        map.put("minDay", day14);
	        map.put("maxDay", day15);
	        List<Dates> dateListTwo = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListTwo!=null && dateListTwo.size()!=0){
		        maternalHealthCareStatisticsPO.setTwoCheckTimes(dateListTwo.size());
		        maternalHealthCareStatisticsPO.setTwoOrderDate(dateListTwo.get(0).getOrderDate());
	        }
	        
	        //查询16-20周的随访时间和预约时间 并求出随访次数
	        int day16 = 15*7+6;
	        int day20 = 20*7;
	        map.put("minDay", day16);
	        map.put("maxDay", day20);
	        List<Dates> dateListThree = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListThree!=null && dateListThree.size()!=0){
		        maternalHealthCareStatisticsPO.setThreeCheckTimes(dateListThree.size());
		        maternalHealthCareStatisticsPO.setThreeOrderDate(dateListThree.get(0).getOrderDate());
	        }
	        //查询21-24周的随访时间和预约时间 并求出随访次数
	        int day21 = 20*7+6;
	        int day24 = 24*7;
	        map.put("minDay", day21);
	        map.put("maxDay", day24);
	        List<Dates> dateListFour = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListFour!=null && dateListFour.size()!=0){
		        maternalHealthCareStatisticsPO.setFourCheckTimes(dateListFour.size());
		        maternalHealthCareStatisticsPO.setFourOrderDate(dateListFour.get(0).getOrderDate());
	        }
	        //查询25-27周的随访时间和预约时间 并求出随访次数
	        int day25 = 24*7+6;
	        int day27 = 27*7;
	        map.put("minDay", day25);
	        map.put("maxDay", day27);
	        List<Dates> dateListFive = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListFive!=null && dateListFive.size()!=0){
		        maternalHealthCareStatisticsPO.setFiveCheckTimes(dateListFive.size());
		        maternalHealthCareStatisticsPO.setFiveOrderDate(dateListFive.get(0).getOrderDate());
	        }
	        //查询28-36周的随访时间和预约时间 并求出随访次数
	        int day28 = 27*7+6;
	        int day36 = 36*7;
	        map.put("minDay", day28);
	        map.put("maxDay", day36);
	        List<Dates> dateListSix = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListSix!=null && dateListSix.size()!=0){
		        maternalHealthCareStatisticsPO.setSixCheckTimes(dateListSix.size());
		        maternalHealthCareStatisticsPO.setSixOrderDate(dateListSix.get(0).getOrderDate());
	        }
	        //查询37-40周的随访时间和预约时间 并求出随访次数
	        int day37 = 36*7+6;
	        int day40 = 40*7;
	        map.put("minDay", day37);
	        map.put("maxDay", day40);
	        List<Dates> dateListSeven = maternalHealthCareStatisticsDao.getChecksByTime(map);
	        if(dateListSeven!=null && dateListSeven.size()!=0){
		        maternalHealthCareStatisticsPO.setSevenCheckTimes(dateListSeven.size());
		        maternalHealthCareStatisticsPO.setSevenOrderDate(dateListSeven.get(0).getOrderDate());
	        }
	        
	        //查询出院后3-7天的检查次数
	        List<Dates> dateListSevenPost3to7 = maternalHealthCareStatisticsDao.getPost3to7CheckTimes(map);
	        if(dateListSevenPost3to7!=null && dateListSevenPost3to7.size()!=0){
	        	maternalHealthCareStatisticsPO.setPost3to7Times(dateListSevenPost3to7.size());
	        	maternalHealthCareStatisticsPO.setPost3to7Date(dateListSevenPost3to7.get(0).getOrderDate());
	        }
	        //查询产后42天周的检查次数
	        int post42Times = maternalHealthCareStatisticsDao.getPost42CheckTimes(map);
	        maternalHealthCareStatisticsPO.setPost42Times(post42Times);
	    	 
			
		}
			page.setList(list);
		
		}

	}
	


