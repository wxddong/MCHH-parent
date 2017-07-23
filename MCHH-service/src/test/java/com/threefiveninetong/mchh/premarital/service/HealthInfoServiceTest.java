/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HealthInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:32 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.service;
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
import com.threefiveninetong.mchh.premarital.po.HealthInfoPO;
import com.threefiveninetong.mchh.premarital.service.HealthInfoService;

/**
 * @ClassName: HealthInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class HealthInfoServiceTest {
	@Resource
	private HealthInfoService healthInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		HealthInfoPO po = healthInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<HealthInfoPO> all = healthInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		HealthInfoPO basePO = new HealthInfoPO();
		try {
			healthInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		HealthInfoPO basePO = healthInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			healthInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			healthInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			healthInfoService.deletes(ids);
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
		Page<HealthInfoPO> page = new Page<HealthInfoPO>();
		healthInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}