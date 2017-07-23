package com.threefiveninetong.mchh.sys.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.core.base.BaseService;
import com.threefiveninetong.mchh.sys.dao.OperateLogDao;
import com.threefiveninetong.mchh.sys.po.OperateLogPO;
import com.threefiveninetong.mchh.sys.vo.OperateLogVO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * 操作日志业务接口实现类
 * 
 * @author zhouzhao
 * @date 2013-7-26上午09:54:12
 * @description
 */
@Service
public class OperateLogService extends BaseService<OperateLogPO, OperateLogVO> {

    @Resource
    OperateLogDao operateLogDao;

    public void listOperateLogForPage(Map<String, Object> conds, Page<OperateLogPO> page) {
        page.setEntityOrField(true);
        conds.put("page", page);
        List<OperateLogPO> list = operateLogDao.listOperateLogForPage(conds);
        page.setList(list);
    }

    public OperateLogVO addOperateLog(OperateLogVO operateLogVO) {
        OperateLogPO operateLogPO = vo2po(operateLogVO);
        operateLogPO.setId(IdUtil.uuid());
        operateLogDao.add(operateLogPO);
        return operateLogVO;
    }

}
