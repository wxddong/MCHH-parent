package com.threefiveninetong.mchh.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.appConfig.po.AppBannerInfoPO;
import com.threefiveninetong.mchh.appConfig.po.AppExpertGuidancePO;
import com.threefiveninetong.mchh.appConfig.po.AppVersionPO;
import com.threefiveninetong.mchh.appConfig.vo.resp.VersionVo;
import com.threefiveninetong.mchh.appHospital.po.AppCharacteristicServiceInfoPO;
import com.threefiveninetong.mchh.appHospital.po.AppSchoolCurriculumInfoPO;
import com.threefiveninetong.mchh.appHospital.vo.resp.CharacteristicServiceVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.CurriculumVo;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.appMember.po.AppMoodRecordPO;
import com.threefiveninetong.mchh.appMember.vo.resp.MbrMessageVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MoodRecordVo;
import com.threefiveninetong.mchh.appPostpartum.po.AppBabyBasicInfoPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingBabyDentitionRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingBabyGrowRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEarlyStageDetailsPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEightMonthRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingFiveYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingFourYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingMomWeightRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneMonthRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneYearSixRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingSixMonthRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingSixYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingThreeMonthRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingThreeYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingTwoYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingTwoYearSixRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingVaccineRecordPO;
import com.threefiveninetong.mchh.appPostpartum.vo.req.BabyToochGrowVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.BabyVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.EarlyStageDetailsVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.BabyGrowVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.ParentingWeightVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchEightMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFiveYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFourYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneYearSixRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchSixMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchSixYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchThreeMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchThreeYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchTwoYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchTwoYearSixRecordRespVo;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationTemperatureRecordPO;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationWeightRecordPO;
import com.threefiveninetong.mchh.appPremarital.vo.resp.BannerImageInfoVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.ExpertGuidanceVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PreparationWeightVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.TemperatureVo;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalFetalMovementRecordPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalLectureRecordPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordSpecialPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalWeightRecordPO;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.FetalMovementVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.LectureRecordVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalWeightVo;
import com.threefiveninetong.mchh.util.BeanUtil;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.StringUtil;

/**
 * 公用组装类
 * @author zhanght
 */
public class CommonAssembleSupport {
	
	/**
	 * 组装版本信息
	 * @param versionPO
	 * @return
	 */
	public static VersionVo assembleVersionVo(AppVersionPO versionPO) {
		if (null != versionPO) {
			VersionVo versionRes = new VersionVo();
			versionRes.setDownloadUrl(StringUtil.valueOf(versionPO.getDownloadUrl()));
			versionRes.setVersionName(StringUtil.valueOf(versionPO.getVersion()));
			versionRes.setVersionCode(StringUtil.valueOf(versionPO.getVersionCode()));
			versionRes.setUpdateInfo(StringUtil.valueOf(versionPO.getDescription()));
			return versionRes;
		}
		return null;
	}
	
	/**
	 * 组装专家健康指导信息
	 * @param expertGuidanceList
	 * @return
	 */
	public static List<ExpertGuidanceVo> assembleExpertGuidanceVo(List<AppExpertGuidancePO> expertGuidanceList,String serverUrl) {
		List<ExpertGuidanceVo> list = new LinkedList<ExpertGuidanceVo>();
		if (!CollectionUtil.isNullOrEmpty(expertGuidanceList) && !StringUtil.isNullOrBlank(serverUrl)) {
			ExpertGuidanceVo egInfo = null;
			for (AppExpertGuidancePO expertGuidance : expertGuidanceList) {
				egInfo = new ExpertGuidanceVo();
				egInfo.setTitle(StringUtil.valueOf(expertGuidance.getTitle()));
				egInfo.setContent(StringUtil.valueOf(expertGuidance.getContent()));
				egInfo.setSmallImageUrl(serverUrl + StringUtil.valueOf(expertGuidance.getSmallImageUrl()));
				egInfo.setBigImageUrl(serverUrl + StringUtil.valueOf(expertGuidance.getBigImageUrl()));
				if (null != expertGuidance.getBigenTime()) {
					egInfo.setReleaseTime(StringUtil.valueOf(expertGuidance.getBigenTime().getTime()));
				}
				list.add(egInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装Banner图信息
	 * @param bannerlist
	 * @return
	 */
	public static List<BannerImageInfoVo> assembleBannerImageInfoVo(List<AppBannerInfoPO> bannerlist,String serverUrl) {
		List<BannerImageInfoVo> list = new LinkedList<BannerImageInfoVo>();
		if (!CollectionUtil.isNullOrEmpty(bannerlist) && !StringUtil.isNullOrBlank(serverUrl)) {
			BannerImageInfoVo bannerInfo = null;
			for (AppBannerInfoPO banner : bannerlist) {
				bannerInfo = new BannerImageInfoVo();
				bannerInfo.setTitle(StringUtil.valueOf(banner.getTitle()));
				bannerInfo.setContent(StringUtil.valueOf(banner.getContent()));
				bannerInfo.setSmallImageUrl(serverUrl + StringUtil.valueOf(banner.getSmallImageUrl()));
				bannerInfo.setBigImageUrl(serverUrl + StringUtil.valueOf(banner.getBigImageUrl()));
				if (null != banner.getBigenTime()) {
					bannerInfo.setReleaseTime(StringUtil.valueOf(banner.getBigenTime().getTime()));
				}
				list.add(bannerInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装备孕期30条体温记录
	 * @param temperatureRecordlist
	 * @return
	 */
	public static List<TemperatureVo> assembleSearchPremaritalTemperatureRecord(List<AppPreparationTemperatureRecordPO> temperatureRecordlist) {
		List<TemperatureVo> list = new LinkedList<TemperatureVo>();
		if (!CollectionUtil.isNullOrEmpty(temperatureRecordlist)) {
			TemperatureVo temperatureInfo = null;
			for (AppPreparationTemperatureRecordPO tem : temperatureRecordlist) {
				temperatureInfo = new TemperatureVo();
				temperatureInfo.setPeriodSign(StringUtil.valueOf(tem.getPeriodSign()));
				temperatureInfo.setTemperature(StringUtil.valueOf(tem.getTemperature()));
				temperatureInfo.setCreateTime(StringUtil.valueOf(tem.getCreateTime().getTime()));
				list.add(temperatureInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装备孕期妈妈体重记录
	 * @param weightList
	 * @return
	 */
	public static List<PreparationWeightVo> assembleSearchPremaritalWeightRecord(List<AppPreparationWeightRecordPO> weightList) {
		List<PreparationWeightVo> list = new LinkedList<PreparationWeightVo>();
		if (!CollectionUtil.isNullOrEmpty(weightList)) {
			PreparationWeightVo weightInfo = null;
			for (AppPreparationWeightRecordPO weight : weightList) {
				weightInfo = new PreparationWeightVo();
				weightInfo.setWeight(StringUtil.valueOf(weight.getWeight()));
				weightInfo.setHeight(StringUtil.valueOf(weight.getHeight()));
				weightInfo.setBmi(StringUtil.valueOf(weight.getBmi()));
				weightInfo.setCreateTime(StringUtil.valueOf(weight.getCreateTime().getTime()));
				list.add(weightInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装孕产期自我记录点亮信息
	 * @param lightList
	 * @return
	 */
	public static List<String> assembleSearchPrenatalSelfRecord(List<AppPrenatalSelfRecordSpecialPO> lightList) {
		List<String> list = new LinkedList<String>();
		if (!CollectionUtil.isNullOrEmpty(lightList)) {
			for (AppPrenatalSelfRecordSpecialPO self : lightList) {
				if (!list.contains(self.getSymptom())) {
					list.add(self.getSymptom());
				}
			}
		}
		return list;
	}
	
	/**
	 * 组装孕产期妈妈体重记录
	 * @param weightList
	 * @return
	 */
	public static List<PrenatalWeightVo> assembleSearchPrenatalWeightRecord(List<AppPrenatalWeightRecordPO> weightList) {
		List<PrenatalWeightVo> list = new LinkedList<PrenatalWeightVo>();
		if (!CollectionUtil.isNullOrEmpty(weightList)) {
			PrenatalWeightVo weightInfo = null;
			for (AppPrenatalWeightRecordPO weight : weightList) {
				weightInfo = new PrenatalWeightVo();
				weightInfo.setWeight(StringUtil.valueOf(weight.getWeight()));
				weightInfo.setWeightGain(StringUtil.valueOf(weight.getWeightGain()));
				weightInfo.setPrenatalBmi(StringUtil.valueOf(weight.getPrenatalBmi()));
				weightInfo.setCreateTime(StringUtil.valueOf(weight.getCreateTime().getTime()));
				list.add(weightInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装孕产期胎动记录
	 * @param weightList
	 * @return
	 */
	public static List<FetalMovementVo> assembleSearchPrenatalFetalMovementRecord(List<AppPrenatalFetalMovementRecordPO> fetalMovementList) {
		List<FetalMovementVo> list = new LinkedList<FetalMovementVo>();
		if (!CollectionUtil.isNullOrEmpty(fetalMovementList)) {
			FetalMovementVo fetalInfo = null;
			for (AppPrenatalFetalMovementRecordPO fetal : fetalMovementList) {
				fetalInfo = new FetalMovementVo();
				fetalInfo.setMoveNum(StringUtil.valueOf(fetal.getMoveNum()));
				fetalInfo.setCreateTime(StringUtil.valueOf(fetal.getCreateTime().getTime()));
				list.add(fetalInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装孕产期听课记录
	 * @param weightList
	 * @return
	 */
	public static List<LectureRecordVo> assembleSearchPrenatalLectureRecord(List<AppPrenatalLectureRecordPO> lectureList) {
		List<LectureRecordVo> list = new LinkedList<LectureRecordVo>();
		if (!CollectionUtil.isNullOrEmpty(lectureList)) {
			LectureRecordVo lectureInfo = null;
			for (AppPrenatalLectureRecordPO lecture : lectureList) {
				lectureInfo = new LectureRecordVo();
				lectureInfo.setSubjects(StringUtil.valueOf(lecture.getSubjects()));
				lectureInfo.setContent(StringUtil.valueOf(lecture.getContent()));
				lectureInfo.setLectureTime(StringUtil.valueOf(lecture.getLectureTime().getTime()));
				lectureInfo.setRemark(StringUtil.valueOf(lecture.getRemark()));
				lectureInfo.setCreateTime(StringUtil.valueOf(lecture.getCreateTime().getTime()));
				list.add(lectureInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装育儿期宝宝信息
	 * @param babyList
	 * @return
	 */
	public static List<BabyVo> assembleSearchPostpartumBabyList(List<AppBabyBasicInfoPO> babyList) {
		List<BabyVo> list = new LinkedList<BabyVo>();
		if (!CollectionUtil.isNullOrEmpty(babyList)) {
			BabyVo babyInfo = null;
			for (AppBabyBasicInfoPO angelababy : babyList) {
				babyInfo = new BabyVo();
				babyInfo.setBabyInfoId(angelababy.getId());
				babyInfo.setBirthday(StringUtil.valueOf(angelababy.getBirthday().getTime()));
				babyInfo.setName(StringUtil.valueOf(angelababy.getName()));
				babyInfo.setSex(StringUtil.valueOf(angelababy.getSex()));
				babyInfo.setBirthTime(StringUtil.valueOf(angelababy.getBirthTime().getTime()));
				babyInfo.setHeight(StringUtil.valueOf(angelababy.getLength()));
				babyInfo.setWeight(StringUtil.valueOf(angelababy.getWeight()));
				babyInfo.setBirthGesWeeks(StringUtil.valueOf(angelababy.getBirthGesWeeks()));
				babyInfo.setBirthPlace(StringUtil.valueOf(angelababy.getBirthPlace()));
				babyInfo.setDeliveryMec(StringUtil.valueOf(angelababy.getDeliveryMec()));
				list.add(babyInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装育儿期宝宝生长记录信息
	 * @param babyGrowList
	 * @return
	 */
	public static List<BabyGrowVo> assembleSearchPostpartumBabyGrowRecord(List<AppParentingBabyGrowRecordPO> babyGrowList) {
		List<BabyGrowVo> list = new LinkedList<BabyGrowVo>();
		if (!CollectionUtil.isNullOrEmpty(babyGrowList)) {
			BabyGrowVo growInfo = null;
			for (AppParentingBabyGrowRecordPO baby : babyGrowList) {
				growInfo = new BabyGrowVo();
				growInfo.setHeight(StringUtil.valueOf(baby.getHeight()));
				growInfo.setWeight(StringUtil.valueOf(baby.getWeight()));
				growInfo.setCreateTime(StringUtil.valueOf(baby.getCreateTime().getTime()));
				list.add(growInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装育儿期宝宝牙齿生长记录信息
	 * @param babyToochGrowList
	 * @return
	 */
	public static List<BabyToochGrowVo> assembleSearchPostpartumBabyDentitionRecord(List<AppParentingBabyDentitionRecordPO> babyToochGrowList) {
		List<BabyToochGrowVo> list = new LinkedList<BabyToochGrowVo>();
		if (!CollectionUtil.isNullOrEmpty(babyToochGrowList)) {
			BabyToochGrowVo toochInfo = null;
			for (AppParentingBabyDentitionRecordPO babyDetition : babyToochGrowList) {
				toochInfo = new BabyToochGrowVo();
				toochInfo.setBabyToochGrowId(babyDetition.getId());
				toochInfo.setPosition(StringUtil.valueOf(babyDetition.getPosition()));
				toochInfo.setToothingDate(StringUtil.valueOf(babyDetition.getToothingDate().getTime()));
				list.add(toochInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装育儿期宝宝疫苗接种记录信息
	 * @param vaccineList
	 * @return
	 */
	public static List<String> assembleSearchPostpartumVaccineRecord(List<AppParentingVaccineRecordPO> vaccineList) {
		List<String> list = new LinkedList<String>();
		if (!CollectionUtil.isNullOrEmpty(vaccineList)) {
			for (AppParentingVaccineRecordPO vaccine : vaccineList) {
				if (!list.contains(vaccine.getVaccineType())) 
					list.add(vaccine.getVaccineType());
			}	
		}
		return list;
	}	
	
	/**
	 * 组装育儿期新生儿早期记录详情
	 * @param earlyStageDetailsList
	 * @return
	 */
	public static List<EarlyStageDetailsVo> assembleSearchPostpartumEarlyStageRecord(List<AppParentingEarlyStageDetailsPO> earlyStageDetailsList) {
		List<EarlyStageDetailsVo> list = new LinkedList<EarlyStageDetailsVo>();
		if (!CollectionUtil.isNullOrEmpty(earlyStageDetailsList)) {
			EarlyStageDetailsVo earlyInfo = null;
			for (AppParentingEarlyStageDetailsPO stage : earlyStageDetailsList) {
				earlyInfo = new EarlyStageDetailsVo();
				earlyInfo.setBirthDays(StringUtil.valueOf(stage.getBirthDays()));
				earlyInfo.setFeedingMode(StringUtil.valueOf(stage.getFeedingMode()));
				earlyInfo.setMilkNum(StringUtil.valueOf(stage.getMilkNum()));
				earlyInfo.setUrineNum(StringUtil.valueOf(stage.getUrineNum()));
				earlyInfo.setShitNum(StringUtil.valueOf(stage.getShitNum()));
				earlyInfo.setWeight(StringUtil.valueOf(stage.getWeight()));
				earlyInfo.setJaundice(StringUtil.valueOf(stage.getJaundice()));
				earlyInfo.setCreateTime(StringUtil.valueOf(stage.getCreateTime().getTime()));
				list.add(earlyInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装育儿期妈妈体重历史记录
	 * @param momWeightList
	 * @return
	 */
	public static List<ParentingWeightVo> assembleSearchPostpartumWeightRecord(List<AppParentingMomWeightRecordPO> momWeightList) {
		List<ParentingWeightVo> list = new LinkedList<ParentingWeightVo>();
		if (!CollectionUtil.isNullOrEmpty(momWeightList)) {
			ParentingWeightVo weightInfo = null;
			for (AppParentingMomWeightRecordPO momWeight : momWeightList) {
				weightInfo = new ParentingWeightVo();
				weightInfo.setBmi(StringUtil.valueOf(momWeight.getBmi()));
				weightInfo.setHeight(StringUtil.valueOf(momWeight.getHeight()));
				weightInfo.setWeight(StringUtil.valueOf(momWeight.getWeight()));
				weightInfo.setPrenatalBmi(StringUtil.valueOf(momWeight.getPreBmi()));
				weightInfo.setCreateTime(StringUtil.valueOf(momWeight.getCreateTime().getTime()));
				list.add(weightInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装育儿期六岁记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchSixYearRecordRespVo assembleSearchPostpartumSixYearRecord(PostpartumSearchSixYearRecordRespVo respInfo,AppParentingSixYearRecordPO sixYearInfo) {
		if (null != sixYearInfo) {
			respInfo.setSimpleHousework(sixYearInfo.getSimpleHousework());
			respInfo.setShareFood(sixYearInfo.getShareFood());
			respInfo.setComplyGameRule(sixYearInfo.getComplyGameRule());
			respInfo.setWriteOwnName(sixYearInfo.getWriteOwnName());
			respInfo.setExpressIdeas(sixYearInfo.getExpressIdeas());
			respInfo.setPlayCosplayGame(sixYearInfo.getPlayCosplayGame());
			respInfo.setDrawSquare(sixYearInfo.getDrawSquare());
			respInfo.setRun(sixYearInfo.getRun());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期五岁记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchFiveYearRecordRespVo assembleSearchPostpartumFiveYearRecord(PostpartumSearchFiveYearRecordRespVo respInfo,AppParentingFiveYearRecordPO fiveYearInfo) {
		if (null != fiveYearInfo) {
			respInfo.setHoldPenDraw(fiveYearInfo.getHoldPenDraw());
			respInfo.setDistinguishColour(fiveYearInfo.getDistinguishColour());
			respInfo.setHabitCollectiveLife(fiveYearInfo.getHabitCollectiveLife());
			respInfo.setOwnDisrobe(fiveYearInfo.getOwnDisrobe());
			respInfo.setBriefThings(fiveYearInfo.getBriefThings());
			respInfo.setKnowSex(fiveYearInfo.getKnowSex());
			respInfo.setUseChopsticks(fiveYearInfo.getUseChopsticks());
			respInfo.setSingleFootJump(fiveYearInfo.getSingleFootJump());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期四岁记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchFourYearRecordRespVo assembleSearchPostpartumFourYearRecord(PostpartumSearchFourYearRecordRespVo respInfo,AppParentingFourYearRecordPO fourYearInfo) {
		if (null != fourYearInfo) {
			respInfo.setKindergarten(fourYearInfo.getKindergarten());
			respInfo.setCutSomething(fourYearInfo.getCutSomething());
			respInfo.setIndependentToilet(fourYearInfo.getIndependentToilet());
			respInfo.setTellingStories(fourYearInfo.getTellingStories());
			respInfo.setOutdoorActivityTime(fourYearInfo.getOutdoorActivityTime());
			respInfo.setWatchVideoTime(fourYearInfo.getWatchVideoTime());
			respInfo.setSaidAdjectiveSentence(fourYearInfo.getSaidAdjectiveSentence());
			respInfo.setRequirementWait(fourYearInfo.getRequirementWait());
			respInfo.setIndependentDress(fourYearInfo.getIndependentDress());
			respInfo.setSingleFootStand(fourYearInfo.getSingleFootStand());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期三岁记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchThreeYearRecordRespVo assembleSearchPostpartumThreeYearRecord(PostpartumSearchThreeYearRecordRespVo respInfo,AppParentingThreeYearRecordPO threeYearInfo) {
		if (null != threeYearInfo) {
			respInfo.setKindergarten(threeYearInfo.getKindergarten());
			respInfo.setChewingHabit(threeYearInfo.getChewingHabit());
			respInfo.setSleepBrushTooth(threeYearInfo.getSleepBrushTeeth());
			respInfo.setMealWashHand(threeYearInfo.getMealWashHand());
			respInfo.setSquinting(threeYearInfo.getSquinting());
			respInfo.setOwnName(threeYearInfo.getOwnName());
			respInfo.setPretendPlay(threeYearInfo.getPretendPlay());
			respInfo.setImitateDrawCircle(threeYearInfo.getImitateDrawCircle());
			respInfo.setDoubleJump(threeYearInfo.getDoubleJump());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期两岁半记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchTwoYearSixRecordRespVo assembleSearchPostpartumTwoYearSixRecord(PostpartumSearchTwoYearSixRecordRespVo respInfo,AppParentingTwoYearSixRecordPO twoYearSixInfo) {
		if (null != twoYearSixInfo) {
			respInfo.setBodyPartsNum(twoYearSixInfo.getBodyPartsNum());
			respInfo.setTeethNum(twoYearSixInfo.getTeethNum());
			respInfo.setPicky(twoYearSixInfo.getPicky());
			respInfo.setDoNotLike(twoYearSixInfo.getDoNotLike());
			respInfo.setLookPicture(twoYearSixInfo.getLookPicture());
			respInfo.setSayPhrase(twoYearSixInfo.getSayPhrase());
			respInfo.setSingleInterest(twoYearSixInfo.getSingleInterest());
			respInfo.setSignalToilet(twoYearSixInfo.getSignalToilet());
			respInfo.setRun(twoYearSixInfo.getRun());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期两岁记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchTwoYearRecordRespVo assembleSearchPostpartumTwoYearRecord(PostpartumSearchTwoYearRecordRespVo respInfo,AppParentingTwoYearRecordPO twoYearInfo) {
		if (null != twoYearInfo) {
			respInfo.setMilkAmount(twoYearInfo.getMilkAmount());
			respInfo.setMeatAmount(twoYearInfo.getMeatAmount());
			respInfo.setGargle(twoYearInfo.getGargle());
			respInfo.setEatVegetables(twoYearInfo.getEatVegetables());
			respInfo.setTeachWobiDraw(twoYearInfo.getTeachWobiDraw());
			respInfo.setSayThreeGoods(twoYearInfo.getSayThreeGoods());
			respInfo.setDoSimpleThings(twoYearInfo.getDoSimpleThings());
			respInfo.setSpoonMeal(twoYearInfo.getSpoonMeal());
			respInfo.setHoldClimbStairs(twoYearInfo.getHoldClimbStairs());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期一岁半记录
	 * @param
	 * @return
	 */
	public static PostpartumSearchOneYearSixRecordRespVo assembleSearchPostpartumOneYearSixRecord(PostpartumSearchOneYearSixRecordRespVo respInfo,AppParentingOneYearSixRecordPO oneYearSix) {
		if (null != oneYearSix) {
			respInfo.setOwnWalkTime(StringUtil.valueOf(oneYearSix.getOwnWalkTime().getTime()));
			respInfo.setOwnSpoon(oneYearSix.getOwnSpoon());
			respInfo.setOwnGalss(oneYearSix.getOwnGalss());
			respInfo.setOftenPlay(oneYearSix.getOftenPlay());
			respInfo.setConsciousCall(oneYearSix.getConsciousCall());
			respInfo.setRequirementFinger(oneYearSix.getRequirementFinger());
			respInfo.setEyeContact(oneYearSix.getEyeContact());
			respInfo.setOwnWalk(oneYearSix.getOwnWalk());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期一岁记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchOneYearRecordRespVo assembleSearchPostpartumOneYearRecord(PostpartumSearchOneYearRecordRespVo respInfo,AppParentingOneYearRecordPO oneYear) {
		if (null != oneYear) {
			respInfo.setMealNum(oneYear.getMealNum());
			respInfo.setToothNum(oneYear.getToothNum());
			respInfo.setMealSituation(oneYear.getMealSituation());
			respInfo.setBreastMilk(oneYear.getBreastMilk());
			respInfo.setNameReaction(oneYear.getNameReaction());
			respInfo.setImitate(oneYear.getImitate());
			respInfo.setPinchThing(oneYear.getPinchThing());
			respInfo.setStandingUp(oneYear.getStandingUp());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期八个月记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchEightMonthRecordRespVo assembleSearchPostpartumEightMonthRecord(PostpartumSearchEightMonthRecordRespVo respInfo,AppParentingEightMonthRecordPO eightMonth) {
		if (null != eightMonth) {
			respInfo.setAddMeatTime(StringUtil.valueOf(eightMonth.getAddMeatTime().getTime()));
			respInfo.setAddEggTime(StringUtil.valueOf(eightMonth.getAddEggTime().getTime()));
			respInfo.setFirstToothTime(StringUtil.valueOf(eightMonth.getFirstToothTime().getTime()));
			respInfo.setHideAndSeek(eightMonth.getHideAndSeek());
			respInfo.setSoundAnswer(eightMonth.getSoundAnswer());
			respInfo.setDistinguishPeople(eightMonth.getDistinguishPeople());
			respInfo.setBothHandsToys(eightMonth.getBothHandsToys());
			respInfo.setSitAlone(eightMonth.getSitAlone());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期六个月记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchSixMonthRecordRespVo assembleSearchPostpartumSixMonthRecord(PostpartumSearchSixMonthRecordRespVo respInfo,AppParentingSixMonthRecordPO sixMonth) {
		if (null != sixMonth) {
			respInfo.setAddFoodTime(StringUtil.valueOf(sixMonth.getAddFoodTime().getTime()));
			respInfo.setTurnOverTime(StringUtil.valueOf(sixMonth.getTurnOverTime().getTime()));
			respInfo.setToysNum(sixMonth.getToysNum());
			respInfo.setBabyPlay(sixMonth.getBabyPlay());
			respInfo.setSoundLaugh(sixMonth.getSoundLaugh());
			respInfo.setHandGrab(sixMonth.getHandGrab());
			respInfo.setClenchFist(sixMonth.getClenchFist());
			respInfo.setSit(sixMonth.getSit());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期三个月记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchThreeMonthRecordRespVo assembleSearchPostpartumThreeMonthRecord(PostpartumSearchThreeMonthRecordRespVo respInfo,AppParentingThreeMonthRecordPO threeMonth) {
		if (null != threeMonth) {
			respInfo.setOutdoorsDuration(StringUtil.valueOf(threeMonth.getOutdoorsDuration().getTime()));
			respInfo.setFeedingMode(threeMonth.getFeedingMode());
			respInfo.setFeedingSituation(threeMonth.getFeedingSituation());
			respInfo.setTalkBaby(threeMonth.getTalkBaby());
			respInfo.setvSupplement(threeMonth.getVSupplement());
			respInfo.setLoudReaction(threeMonth.getLoudReaction());
			respInfo.setTeasingSmile(threeMonth.getTeasingSmile());
			respInfo.setGazeTracking(threeMonth.getGazeTracking());
			respInfo.setRiseProne(threeMonth.getRiseProne());
		}
		return respInfo;
	}
	
	/**
	 * 组装育儿期一个月记录
	 * @param 
	 * @return
	 */
	public static PostpartumSearchOneMonthRecordRespVo assembleSearchPostpartumOneMonthRecord(PostpartumSearchOneMonthRecordRespVo respInfo,AppParentingOneMonthRecordPO oneMonth) {
		if (null != oneMonth) {
			respInfo.setUmbilicalTime(StringUtil.valueOf(oneMonth.getUmbilicalTime().getTime()));
			respInfo.setJaundiceFadeTime(StringUtil.valueOf(oneMonth.getJaundiceFadeTime().getTime()));
			respInfo.setFeedingMode(oneMonth.getFeedingMode());
			respInfo.setFeedingSituation(oneMonth.getFeedingSituation());
			respInfo.setFrightCry(oneMonth.getFrightCry());
			respInfo.setCrying(oneMonth.getCrying());
			respInfo.setvSupplement(oneMonth.getVSupplement());
		}
		return respInfo;
	}
	
	/**
	 * 组装医院医院特色服务信息
	 * @param characteristicServiceList
	 * @param serverUrl
	 * @return
	 */
	public static List<CharacteristicServiceVo> assembleSearchCharacteristicServiceInfo(List<AppCharacteristicServiceInfoPO> characteristicServiceList,String serverUrl) {
		List<CharacteristicServiceVo> list = new LinkedList<CharacteristicServiceVo>();
		if (!CollectionUtil.isNullOrEmpty(characteristicServiceList) && !StringUtil.isNullOrBlank(serverUrl)) {
			CharacteristicServiceVo characterInfo = null;
			for (AppCharacteristicServiceInfoPO character : characteristicServiceList) {
				characterInfo = new CharacteristicServiceVo();
				characterInfo.setName(character.getName());
				characterInfo.setSmallImageUrl(serverUrl + character.getSmallImageUrl()); 
				characterInfo.setBigImageUrl(serverUrl + character.getBigImageUrl());
				characterInfo.setContent(character.getContent());
				characterInfo.setSortNum(StringUtil.valueOf(character.getSortNum()));
				list.add(characterInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装医院孕妇学校课程信息表
	 * @param curriculumList
	 * @return
	 */
	public static List<CurriculumVo> assembleSearchHospitalSchoolCurriculumInfo2(List<AppSchoolCurriculumInfoPO> curriculumList) {
		List<CurriculumVo> list = new LinkedList<CurriculumVo>();
		if (!CollectionUtil.isNullOrEmpty(curriculumList)) {
			CurriculumVo curriculumInfo = null;
			for (AppSchoolCurriculumInfoPO curriculum : curriculumList) {
				curriculumInfo = new CurriculumVo();
				curriculumInfo.setStartDate(StringUtil.valueOf(curriculum.getStartDate().getTime()));
				curriculumInfo.setStartTime(StringUtil.valueOf(curriculum.getStartTime().getTime()));
				curriculumInfo.setEndTime(StringUtil.valueOf(curriculum.getEndTime().getTime()));
				curriculumInfo.setTopic(curriculum.getTopic());
				curriculumInfo.setCourseContent(curriculum.getCourseContent());
				curriculumInfo.setSpeaker(curriculum.getSpeaker());
				list.add(curriculumInfo);
			}
		}
		return list;
	}

	/**
	 * 组装会员的医院通知
	 * @param msgList
	 * @return
	 */
	public static List<MbrMessageVo> assembleSearchHospitalMessage(List<AppMbrMessageInfoPO> msgList) {
		List<MbrMessageVo> list = new LinkedList<MbrMessageVo>();
		if (!CollectionUtil.isNullOrEmpty(msgList)) {
			MbrMessageVo msgInfo = null;
			for (AppMbrMessageInfoPO msg : msgList) {
				msgInfo = new MbrMessageVo();
				msgInfo.setContent(msg.getContent());
				msgInfo.setReceiveTime(StringUtil.valueOf(msg.getReceiveTime().getTime()));
				msgInfo.setTitle(msg.getTitle());
				msgInfo.setType(msg.getType());
				list.add(msgInfo);
			}
		}
		return list;
	}
	
	/**
	 * 组装心情语录信息
	 * @param moodList
	 * @return
	 */
	public static List<MoodRecordVo> assembleGetMoodRecordList(List<AppMoodRecordPO> moodList) {
		List<MoodRecordVo> list = new LinkedList<MoodRecordVo>();
		if (!CollectionUtil.isNullOrEmpty(moodList)) {
			MoodRecordVo moodInfo = null;
			for (AppMoodRecordPO mood : moodList) {
				moodInfo = new MoodRecordVo();
				moodInfo.setMoodId(mood.getId());
				moodInfo.setContent(mood.getContent());
				moodInfo.setType(mood.getType());
				moodInfo.setCreateTime(StringUtil.valueOf(mood.getCreateTime().getTime()));
				list.add(moodInfo);
			}
		}
		return list;
	}
	
	/**
	 * 公用转换类
	 * @param list
	 * @return
	 */
	public static List<Map<String,Object>> commonListToMapTools(List<?> list) {
		List<Map<String,Object>> resList = new LinkedList<Map<String,Object>>();
		if (!CollectionUtil.isNullOrEmpty(list)) {
			for (int i=0;i<list.size();i++) {
				resList.add(BeanUtil.beanToMap(list.get(i)));
			}
		}
		return resList;
	}
}
