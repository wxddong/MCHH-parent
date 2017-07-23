package com.threefiveninetong.mchh.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.core.base.BaseService;
import com.threefiveninetong.mchh.sys.dao.ResourcesDao;
import com.threefiveninetong.mchh.sys.po.ResourcesPO;
import com.threefiveninetong.mchh.sys.vo.ResourcesVO;
import com.threefiveninetong.mchh.util.IdUtil;

/**
 * 资源业务接口实现类
 * 
 * @author zhouzhao
 * @date 2013-7-26上午09:55:31
 * @description
 */
@Service
public class ResourcesService extends BaseService<ResourcesPO, ResourcesVO> {

    @Resource
    ResourcesDao resourcesDao;

    public List<ResourcesVO> listResourcesTree(Map<String, Object> conds) {
        List<ResourcesPO> list = resourcesDao.listResources(conds);
        return pl2vl(list);
    }

    public List<ResourcesVO> listResourcesGrantTree(Map<String, Object> conds) {
        List<ResourcesPO> list = resourcesDao.listResourcesGrant(conds);
        return pl2vl(list);
    }

    public ResourcesVO addOrUpdateResourcesActoin(ResourcesVO resourcesVO) {
        ResourcesPO resourcesPO = vo2po(resourcesVO);
        if (resourcesVO != null && !StringUtils.isEmpty(resourcesVO.getId())) {
            resourcesDao.update(resourcesPO);
        } else {
            resourcesPO.setId(IdUtil.uuid());
            resourcesDao.add(resourcesPO);
        }
        return resourcesVO;
    }

    public void deleteResources(String resourcesId) {
        Map<String, Object> conds = new HashMap<String, Object>();
        conds.put("parentId", resourcesId);
        List<ResourcesPO> children = resourcesDao.listResources(conds);
        if (children.isEmpty()) {
            resourcesDao.delete(new String[] { resourcesId });
            resourcesDao.deleteRoleRes(new String[] { resourcesId });
        } else {
            for (ResourcesPO child : children) {
                deleteResources(child.getId());
            }
        }
    }

}
