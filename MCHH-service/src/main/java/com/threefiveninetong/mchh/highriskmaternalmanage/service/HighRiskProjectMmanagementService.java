package com.threefiveninetong.mchh.highriskmaternalmanage.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.highriskmaternalmanage.dao.HighRiskProjectMmanagementDao;
import com.threefiveninetong.mchh.highriskmaternalmanage.po.HighRiskProjectMmanagementPO;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.Page;

@Service
public class HighRiskProjectMmanagementService {
	
	@Resource
	private HighRiskProjectMmanagementDao HighRiskProjectMmanagementDao;
	
	
	
	/**
	 * 高危孕产妇个人专案管理列表（报表导出使用）
	 * wangxd 2016.10.6
	 * @param conds
	 */
	public List<HighRiskProjectMmanagementPO> listForExport(Map<String, Object> conds) {
		List<HighRiskProjectMmanagementPO> list = HighRiskProjectMmanagementDao.listForPage(conds);
		if(list!=null && list.size()>0){
			for (HighRiskProjectMmanagementPO highRiskProjectMmanagementPO : list) {
				//根据检查日期计算孕周
				Date lastMenses = highRiskProjectMmanagementPO.getLastMenses();
				Date checkDate = highRiskProjectMmanagementPO.getCheckDate();
				if (checkDate != null && lastMenses != null) {
					int day = (int) ((checkDate.getTime() - lastMenses.getTime())/(1000*60*60*24));
					int weeks = day / 7;
					
					highRiskProjectMmanagementPO.setWeeks(weeks);
				}
		        
		        //获取检查id
		        String preExaId = highRiskProjectMmanagementPO.getPreExaId();
		        //根据检查id获取固态因素 和 动态因素
		        Map<String,String> riskMap =  HighRiskProjectMmanagementDao.getRiskByPreExaId(preExaId);
		        if(riskMap!=null && riskMap.size()>0){
		        	highRiskProjectMmanagementPO.setMoveRisk(riskMap.get("moveRisk"));
		        	highRiskProjectMmanagementPO.setStaticRisk(riskMap.get("staticRisk"));
		        }
		        //将转归改为汉字
				String lapseToNo = highRiskProjectMmanagementPO.getLapseToNo();
				if("0".equals(lapseToNo)){
					highRiskProjectMmanagementPO.setLapseTo("继续监护");
				}
				if("1".equals(lapseToNo)){
					highRiskProjectMmanagementPO.setLapseTo("正常随访");
				}
				if("2".equals(lapseToNo)){
					highRiskProjectMmanagementPO.setLapseTo("结束分娩");
				}
			}
		}
			return list;
		
		}

	/**
	 * 高危孕产妇个人专案管理列表
	 * wangxd 2016.9.20
	 * @param conds
	 * @param page
	 */
	public void listForPage(Map<String, Object> conds, Page<HighRiskProjectMmanagementPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<HighRiskProjectMmanagementPO> list = HighRiskProjectMmanagementDao.listForPage(conds);
		if(list!=null && list.size()>0){
			for (HighRiskProjectMmanagementPO highRiskProjectMmanagementPO : list) {
				//根据检查日期计算孕周
				Date lastMenses = highRiskProjectMmanagementPO.getLastMenses();
				Date checkDate = highRiskProjectMmanagementPO.getCheckDate();
				int day = (int) ((checkDate.getTime() - lastMenses.getTime())/(1000*60*60*24));
		        int weeks = day / 7;
		        highRiskProjectMmanagementPO.setWeeks(weeks);
		        
		        //获取检查id
		        String preExaId = highRiskProjectMmanagementPO.getPreExaId();
		        //根据检查id获取固态因素 和 动态因素
		        Map<String,String> riskMap =  HighRiskProjectMmanagementDao.getRiskByPreExaId(preExaId);
		       if(riskMap!=null && riskMap.size()>0){
		        	highRiskProjectMmanagementPO.setMoveRisk(riskMap.get("moveRisk"));
		        	highRiskProjectMmanagementPO.setStaticRisk(riskMap.get("staticRisk"));
		       }
		       //将转归改为汉字
				String lapseToNo = highRiskProjectMmanagementPO.getLapseToNo();
				if("0".equals(lapseToNo)){
					highRiskProjectMmanagementPO.setLapseTo("继续监护");
				}
				if("1".equals(lapseToNo)){
					highRiskProjectMmanagementPO.setLapseTo("正常随访");
				}
				if("2".equals(lapseToNo)){
					highRiskProjectMmanagementPO.setLapseTo("结束分娩");
				}
			}
		}
		page.setList(list);
		
		}

	/**
	 * 获取基本信息放在map里
	 * wangxd 2016.9.20
	 * @param birthArchiveId
	 * @return
	 */
	public Map<String, Object> getMessageByPreExaId(String birthArchiveId) {
		Map<String,Object> message = HighRiskProjectMmanagementDao.getMessageByPreExaId(birthArchiveId);
		return message;
	}
}
