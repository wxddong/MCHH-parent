package com.threefiveninetong.mchh.maternalhealthcarestatistics.dao;

import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.highriskmaternalmanage.po.HighRiskMaternalManagePO;
import com.threefiveninetong.mchh.maternalhealthcarestatistics.po.Dates;
import com.threefiveninetong.mchh.maternalhealthcarestatistics.po.MaternalHealthCareStatisticsPO;

public interface MaternalHealthCareStatisticsDao {

	List<MaternalHealthCareStatisticsPO> listForPage(Map<String, Object> conds);

	List<Dates> getChecksByTime(Map map);

	List<Dates> getPost3to7CheckTimes(Map map);

	int getPost42CheckTimes(Map map);

}
