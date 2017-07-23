package com.threefiveninetong.mchh.sys.dao;

import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.sys.po.OperateLogPO;






/**
 * 操作日志DAO
 * @author xuyh
 * @date 2013-7-26上午10:14:56
 * @description
 */
public interface OperateLogDao{

	/**
	 * 分页查询
	 * @param conds
	 */
	public List<OperateLogPO> listOperateLogForPage(Map<String,Object> conds);
	/**
	 * 创建 
	 * @param po 
	 */
	public void add(OperateLogPO po);


}