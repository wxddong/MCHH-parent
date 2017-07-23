package com.threefiveninetong.mchh.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.TownshipInfoService;
import com.threefiveninetong.mchh.config.service.VillageInfoService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.service.DepartmentService;
import com.threefiveninetong.mchh.sys.vo.DepartmentVO;
import com.threefiveninetong.mchh.util.Page;




/**
 * 部门控制类
 * <ul>
 * <li>/list： 部门列表</li>
 * <li>/get ： 获取部门的树形数据，作为上级部门用</li>
 * <li>/add ：部门添加</li>
 * <li>/update ：部门修改</li>
 * <li>/beforeDel：部门删除前验证</li>
 * <li>/del：部门删除</li>
 * </ul>
 * 
 * @author xuyh
 * @date 2013-7-16
 */
@Controller
@RequestMapping("/sys/department")
public class DepartmentController {
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	@Resource
	private  TownshipInfoService  townshipInfoService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private DistrictAndCountyInfoService districtAndCountyInfoService;
	@Resource
	private  VillageInfoService  villageInfoService;

	/**
	 * 部门列表视图
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDepartmentView() {
		log.debug("request page: /sys/department/list");
		return "sys/department/department_list";
	}

	/**
	 * 部门列表数据
	 * 
	 * @param reqs
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listDepartmentActoin(@RequestParam Map<String, Object> reqs) {
		log.debug("request data: listDepartment");
		Model model = new Model();
		List<DepartmentVO> list = departmentService.listDepartment(reqs);
		for (DepartmentVO departmentVO : list) {
			String level = departmentVO.getLevel();
			String regionId = departmentVO.getRegionId();
			if(level.equals("0")){
				DistrictAndCountyInfoPO countyInfo = districtAndCountyInfoService.find(regionId) ;
				departmentVO.setReginName(countyInfo.getName());
			}else if(level.equals("1")){
				TownshipInfoPO townInfo = townshipInfoService.find(regionId);
				departmentVO.setReginName(townInfo.getName());
			}else if (level.equals("2")) {
				VillageInfoPO villageInfo = villageInfoService.find(regionId);
				departmentVO.setReginName(villageInfo.getName());
			}
			
		}
		List<DepartmentVO> list2 = new ArrayList<DepartmentVO>();
		rl2tl(list, list2, null, null);
		model.setTreePage(list2);
		return model;
	}

	/**
	 * 获取部门的树形数据，作为上级部门用
	 * 
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Model getDepartmentActoin(@RequestParam Map<String, Object> reqs, Page<DepartmentVO> page) {
		log.debug("request data: get");
		Model model = new Model();
		List<DepartmentVO> list = departmentService.listDepartment(reqs);
		List<DepartmentVO> list2 = new ArrayList<DepartmentVO>();
		rl2tl(list, list2, null, null);
		model.setList(list2);
		return model;
	}

	/**
	 * 部门添加
	 * 
	 * @param departmentVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addDepartmentActoin(DepartmentVO departmentVO) {
		Model model = new Model();
		try {
			model.setRow(departmentService.addOrUpdateDepartmentActoin(departmentVO));
		} catch (DuplicateKeyException e) {
			model.setMessage("操作失败,该部门已存在!");
			model.set(Model.SUCCESS, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	/**
	 * 部门修改
	 * 
	 * @param departmentVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateDepartmentActoin(DepartmentVO departmentVO) {
		Model model = new Model();
		try {
			model.setRow(departmentService.addOrUpdateDepartmentActoin(departmentVO));
		} catch (DuplicateKeyException e) {
			model.setMessage("操作失败,该部门已存在!");
			model.set(Model.SUCCESS, false);
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 部门删除前验证
	 * 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/beforeDel", method = RequestMethod.GET, produces = "application/json")
	public Model beforeDelAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			int opeCount = departmentService.getOpeCountByDepIds(ids.split(","));
			if (opeCount != 0) {
				model.set(Model.SUCCESS, false);
				model.setMessage("所删除的部门中关联了操作员，不允许删除");
			}
			int chdCount = departmentService.getchdCountByDepIds(ids.split(","));
			if (chdCount != 0) {
				model.set(Model.SUCCESS, false);
				model.setMessage("所删除的部门中含有子部门，不允许删除");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 部门删除
	 * 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delDepartmentAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			departmentService.deleteDepartment(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	private List<DepartmentVO> rl2tl(List<DepartmentVO> dl, List<DepartmentVO> tgl, DepartmentVO parent, String parentId) {
		if (StringUtils.isEmpty(parentId)) {
			for (DepartmentVO d : dl) {
				if (StringUtils.isEmpty(d.getParentId())) {
					DepartmentVO td = new DepartmentVO();
					BeanUtils.copyProperties(d, td);
					tgl.add(td);
					if ("closed".equals(td.getState())) {
						rl2tl(dl, tgl, td, d.getId());
					}
				}
			}
		} else {
			DepartmentVO p = parent;
			for (DepartmentVO d : dl) {
				if (parentId.equals(d.getParentId())) {
					DepartmentVO td = new DepartmentVO();
					BeanUtils.copyProperties(d, td);
					p.getChildren().add(td);
					if ("closed".equals(td.getState())) {
						rl2tl(dl, tgl, td, d.getId());
					}
				}
			}
		}
		return tgl;
	}
	/**
	 * 根据部门名称查询区域信息
	 * @param val
	 * @return
	 */
	@RequestMapping("/queryQy")
	@ResponseBody
	public Map<String,Object> queryQy(String val){
		Map<String,Object> resultMap = new HashMap<String,Object>() ;
		//List<String> list  = null ;
		
		if(val.equals("总部")){
			List<DistrictAndCountyInfoPO> list1 = departmentService.queryXianName();
			resultMap.put("list", list1) ;
			resultMap.put("level2","0");
		}else{
			//根据上级部门名称获取部门信息
			DepartmentPO department = departmentService.getDepByName(val);
			
			//获取部门级别和所属地区id
			String level = department.getLevel();
			String regionId = department.getRegionId();
			
			if(level != null && !level.trim().equals("")){
				//如果上级部门级别是县医院,根据县区Id查询出符合条件的乡镇信息
				if("0".equals(level)){
					List<TownshipInfoPO> list2 = townshipInfoService.getTownshipByCountyId(regionId);
					resultMap.put("list", list2) ;
					resultMap.put("level2","1");
				}else if("1".equals(level)){ //如果上级部门是乡镇医院，根据乡镇id查询出符合条件的村的信息
					List<VillageInfoPO> list3 = villageInfoService.getTownshipByCountyId(regionId);
					resultMap.put("list", list3) ;
					resultMap.put("level2","2");
				}
			}
			
		}
		return resultMap ;
	}
}
