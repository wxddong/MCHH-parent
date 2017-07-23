package com.threefiveninetong.mchh.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.core.base.BaseService;
import com.threefiveninetong.mchh.sys.dao.OperatorDao;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;

/**
 * 操作员业务接口实现类
 * 
 * @author zhouzhao
 * @date 2013-7-26上午09:54:52
 * @description
 */
@Service
public class OperatorService extends BaseService<OperatorPO, OperatorVO> {

    @Resource
    OperatorDao operatorDao;

    public void listOperatorForPage(Map<String, Object> conds, Page<OperatorPO> page) {
        page.setEntityOrField(true);
        conds.put("page", page);
        List<OperatorPO> list = operatorDao.listOperatorForPage(conds);
        page.setList(list);
    }
    
    
    @Transactional
    public OperatorVO addOrUpdateOperatorActoin(OperatorVO operatorVO) {
        OperatorPO operatorPO = vo2po(operatorVO);
        if (operatorVO != null && !StringUtils.isEmpty(operatorVO.getId())) {
            operatorDao.update(operatorPO);
            
        } else {
            operatorPO.setId(IdUtil.uuid());
            operatorDao.add(operatorPO);
        }
        return operatorVO;
    }

    public void deleteOperator(String[] operatorIds) {
        operatorDao.deleteOperatorRole(operatorIds);
        operatorDao.delete(operatorIds);
    }

    public void assignOperatorRole(String operatorId, String[] roleIds) {
        operatorDao.deleteOperatorRole(new String[] { operatorId });
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (String roleId : roleIds) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("operatorId", operatorId);
            map.put("roleId", roleId);
            list.add(map);
        }
        operatorDao.batchOperatorRole(list);
    }

    public OperatorVO getOperator(Map<String, Object> conds) {
        OperatorPO opePO = operatorDao.getOperator(conds);
        if (opePO != null) {
            return po2vo(opePO);
        }
        return null;
    }

    public void updateOperator(OperatorVO operatorVO) {
        operatorDao.update(vo2po(operatorVO));
    }

    public List<OperatorPO> findAll() {
        return operatorDao.findAll();
    }


	public OperatorVO getOperatorAndDeptName(OperatorVO operator) {
		
		String loginName = operator.getLoginName();
		OperatorPO opePO = operatorDao.getOperatorAndDeptName(loginName);
		
		if(opePO != null){
			return po2vo(opePO);
		}
		
		return null;
		
	}


	public OperatorPO getOperatorByRealName(String realName) {
		// TODO Auto-generated method stub
		return operatorDao.getOperatorByRealName(realName);
	}


	public OperatorPO getRealName(String doctorId) {
		// TODO Auto-generated method stub
		return operatorDao.getRealName(doctorId);
	}


	/**
	 * 通过医生id获取医生信息
	 * @param doctorId
	 * @return
	 * @author yanwk
	 */
	public OperatorPO getOperatorById(String doctorId) {
		return operatorDao.getOperatorById(doctorId);
	}


	public List<OperatorPO> findDoctor(String depId) {
		// TODO Auto-generated method stub
		return operatorDao.findDoctor(depId);
	}

}
