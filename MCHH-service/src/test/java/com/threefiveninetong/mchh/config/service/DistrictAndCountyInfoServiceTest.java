/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DistrictAndCountyInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:34 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.service;
import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;

/**
 * @ClassName: DistrictAndCountyInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class DistrictAndCountyInfoServiceTest {
	@Resource
	private DistrictAndCountyInfoService districtAndCountyInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		DistrictAndCountyInfoPO po = districtAndCountyInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<DistrictAndCountyInfoPO> all = districtAndCountyInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		DistrictAndCountyInfoPO basePO = new DistrictAndCountyInfoPO();
		try {
			districtAndCountyInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		DistrictAndCountyInfoPO basePO = districtAndCountyInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			districtAndCountyInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			districtAndCountyInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			districtAndCountyInfoService.deletes(ids);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testListForPage() {
		Map<String, Object> reqs = new HashMap<String, Object>();
		reqs.put("name", "a");
		reqs.put("title", "b");
		Page<DistrictAndCountyInfoPO> page = new Page<DistrictAndCountyInfoPO>();
		districtAndCountyInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}