package com.threefiveninetong.mchh.achievements.dao;

import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.achievements.po.CountyAchievementsPO;
import com.threefiveninetong.mchh.achievements.po.DoctorAchievementsPO;

public interface AchievementsDao {

	/**
	 * 县级绩效统计列表查询
	 * wangxd 2016.9.21
	 * @param conds
	 * @return
	 */
	List<CountyAchievementsPO> countyListForPage(Map<String, Object> conds);

	int getearlyCardNum(Map<String, Object> conds);

	int getSysManagementPersonsNum(Map<String, Object> conds);

	int getActualCloseNum(Map<String, Object> conds);

	int getPreGreat0Num(Map<String, Object> conds);

	int getPostGreat0Num(Map<String, Object> conds);

	int getBloodNum(Map<String, Object> conds);

	int getUrineNum(Map<String, Object> conds);

	int getBloodTypeNum(Map<String, Object> conds);

	int getLiverNum(Map<String, Object> conds);

	int getKidneyNum(Map<String, Object> conds);

	int getHepatitisBNum(Map<String, Object> conds);

	int getSyphilisNum(Map<String, Object> conds);

	int getAidsNum(Map<String, Object> conds);

	int getHemoglobinNum(Map<String, Object> conds);

	int getUrineProteinNum(Map<String, Object> conds);

	/**
	 * 医生绩效统计列表查询
	 * wangxd 2016.9.23
	 * @param conds
	 * @return
	 */
	List<DoctorAchievementsPO> doctorListForPage(Map<String, Object> conds);

	int getPreExaNum(Map<String, Object> conds);

	int getPost3to7Num(Map<String, Object> conds);

	int getPost42Num(Map<String, Object> conds);

	int getItemsCheckNum(Map<String, Object> conds);

	int getHemoglobinNum1(Map<String, Object> conds);

	int getUrineProteinNum1(Map<String, Object> conds);

	int getActualCloseNum1(Map<String, Object> conds);

}
