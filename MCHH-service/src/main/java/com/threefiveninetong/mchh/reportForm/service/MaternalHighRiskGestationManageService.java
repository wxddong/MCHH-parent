package com.threefiveninetong.mchh.reportForm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.reportForm.dao.MaternalHighRiskGestationManageDao;
import com.threefiveninetong.mchh.reportForm.po.ChildrenHealthcareConditionPO;
import com.threefiveninetong.mchh.reportForm.po.MaternalHighRiskGestationManagePO;
import com.threefiveninetong.mchh.reportForm.po.TownShipHealthCenterStatisticsPO;
import com.threefiveninetong.mchh.util.Page;

@Service
public class MaternalHighRiskGestationManageService {
	
	@Resource
	private MaternalHighRiskGestationManageDao maternalHighRiskGestationManageDao;

	/**
	 * 高危妊娠管理统计列表查询
	 * @param conds
	 * @param page
	 */
	public void listForPage(Map<String, Object> conds, Page<MaternalHighRiskGestationManagePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
//		List<MaternalHighRiskGestationManagePO> list = maternalHighRiskGestationManageDao.listForPage(conds);
//		if(list!=null && list.size()>0){
//			for (MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO : list) {
//				String departmentId = maternalHighRiskGestationManagePO.getDepartmentId();
//				conds.put("departmentId", departmentId);
//				//查询高危管理人数  maternalManageNum
//				int maternalManageNum = maternalHighRiskGestationManageDao.getMaternalManageNum(conds);
//				//查询高危产妇转让人数 turnOnNum
//				int turnOnNum = maternalHighRiskGestationManageDao.getTurnOnNum(conds);
//			}
//		}
		
		List<MaternalHighRiskGestationManagePO> list = new ArrayList();
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO2 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO3 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO4 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO5 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO6 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO7 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO8 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO9 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO10 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO11 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		MaternalHighRiskGestationManagePO maternalHighRiskGestationManagePO12 = new MaternalHighRiskGestationManagePO("1","2",3,4,5,6,7,8,9);
		list.add(maternalHighRiskGestationManagePO);
		list.add(maternalHighRiskGestationManagePO2);
		list.add(maternalHighRiskGestationManagePO3);
		list.add(maternalHighRiskGestationManagePO4);
		list.add(maternalHighRiskGestationManagePO5);
		list.add(maternalHighRiskGestationManagePO6);
		list.add(maternalHighRiskGestationManagePO7);
		list.add(maternalHighRiskGestationManagePO8);
		list.add(maternalHighRiskGestationManagePO9);
		list.add(maternalHighRiskGestationManagePO10);
		list.add(maternalHighRiskGestationManagePO11);
		list.add(maternalHighRiskGestationManagePO12);
		page.setList(list);
	}

	public void listForPage2(Map<String, Object> conds, Page<ChildrenHealthcareConditionPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenHealthcareConditionPO> list = new ArrayList();
		ChildrenHealthcareConditionPO childrenHealthcareConditionPO = new ChildrenHealthcareConditionPO("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54");
		list.add(childrenHealthcareConditionPO);
		page.setList(list);
	}

	public void listForPage3(Map<String, Object> conds, Page<TownShipHealthCenterStatisticsPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<TownShipHealthCenterStatisticsPO> list = new ArrayList();
		TownShipHealthCenterStatisticsPO townShipHealthCenterStatisticsPO = new TownShipHealthCenterStatisticsPO("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43");
		list.add(townShipHealthCenterStatisticsPO);
		page.setList(list);
	}
	
}
