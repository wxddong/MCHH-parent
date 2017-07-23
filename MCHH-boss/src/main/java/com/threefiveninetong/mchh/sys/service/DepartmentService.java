package com.threefiveninetong.mchh.sys.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.config.dao.CityInfoDao;
import com.threefiveninetong.mchh.config.dao.DistrictAndCountyInfoDao;
import com.threefiveninetong.mchh.config.dao.TownshipInfoDao;
import com.threefiveninetong.mchh.config.dao.VillageInfoDao;
import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.core.base.BaseService;
import com.threefiveninetong.mchh.sys.dao.DepartmentDao;
import com.threefiveninetong.mchh.sys.dao.OperatorDao;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.vo.DepartmentVO;
import com.threefiveninetong.mchh.util.IdUtil;


/**
 * 部门业务接口
 * 
 * @author xuyh
 * @date 2013-7-26上午09:47:45
 * @description
 */
@Service
public class DepartmentService extends BaseService<DepartmentPO, DepartmentVO> {
	@Resource
    DepartmentDao departmentDao;
	
	@Resource
    OperatorDao operatorDao;
	
	@Resource
	VillageInfoDao villageInfoDao;
	
	@Resource
	TownshipInfoDao townshipInfoDao;
	
	@Resource
	CityInfoDao cityInfoDao;
	
	@Resource
	private  DistrictAndCountyInfoDao  districtAndCountyInfoDao;

	public List<DepartmentVO> listDepartment(Map<String, Object> conds) {
		List<DepartmentPO> list = departmentDao.listDepartment(conds);
		return pl2vl(list);
	}

	
	public int getOpeCountByDepIds(String[] departmentIds) {
		for (String depId : departmentIds) {
			int count = departmentDao.getOpeCountByDepId(depId);
			if (count != 0)
				return count;
		}
		return 0;
	}

	
	public int getchdCountByDepIds(String[] departmentIds) {
		for (String depId : departmentIds) {
			int count = departmentDao.getchdCountByDepId(depId);
			if (count != 0)
				return count;
		}
		return 0;
	}

	public DepartmentVO addOrUpdateDepartmentActoin(DepartmentVO departmentVO) {
		DepartmentPO departmentPO = vo2po(departmentVO);
		if (departmentVO != null && !StringUtils.isEmpty(departmentVO.getId())) {
			departmentDao.update(departmentPO);
		} else {
			departmentPO.setId(IdUtil.uuid());
			departmentDao.add(departmentPO);
		}
		return departmentVO;
	}

	
	public void deleteDepartment(String[] departmentIds) {
		departmentDao.delete(departmentIds);
	}


	/**
	 * 根据部门名称查询区域信息
	 * @param val
	 * @return
	 */
	public String queryQyByName(String val) {
		return departmentDao.queryQyByName(val);
	}

	/**
	 * 县名称
	 * @return
	 */
	public List<CityInfoPO> queryCountyName() {
		return cityInfoDao.queryCountyName();
	}

	/**
	 * 乡镇名称
	 * @return
	 */
	public List<TownshipInfoPO> queryXiangName() {
		return townshipInfoDao.queryXiangName();
	}

	/**
	 * 村名称
	 * @return
	 */
	public List<VillageInfoPO> queryCunName() {
		return villageInfoDao.queryCunName();
	}


	/**
	 * 根据转诊机构获取预约医生
	 * @param val
	 * @return
	 */
	public List<OperatorPO> findDoctorName(String val) {
		// TODO Auto-generated method stub
		return operatorDao.findDoctorName(val);
	}


	public List<DepartmentPO> findXiangHospital() {
		// TODO Auto-generated method stub
		return departmentDao.findXiangHospital();
	}


	public List<DepartmentPO> findXianHospital() {
		// TODO Auto-generated method stub
		return departmentDao.findXianHospital();
	}


	public DepartmentPO getDepartmentById(String depId) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentById(depId);
	}


	public List<DepartmentPO> getDep(String parentId) {
		// TODO Auto-generated method stub
		return departmentDao.getDep(parentId);
	}


	/**
	 * 所有部门
	 * @return
	 */
	public DepartmentPO allDepartment() {
		// TODO Auto-generated method stub
		return departmentDao.allDepartment();
	}


	public List<DistrictAndCountyInfoPO> queryXianName() {
		// TODO Auto-generated method stub
		return districtAndCountyInfoDao.queryXianName();
	}


	public List<DepartmentPO> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}


	public DepartmentPO getDepByName(String val) {
		// TODO Auto-generated method stub
		return departmentDao.getDepByName(val);
	}
}
