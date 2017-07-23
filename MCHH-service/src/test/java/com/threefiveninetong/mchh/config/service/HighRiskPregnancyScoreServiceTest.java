/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskPregnancyScoreServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
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
import com.threefiveninetong.mchh.config.po.HighRiskPregnancyScorePO;
import com.threefiveninetong.mchh.config.service.HighRiskPregnancyScoreService;

/**
 * @ClassName: HighRiskPregnancyScoreServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class HighRiskPregnancyScoreServiceTest {
	@Resource
	private HighRiskPregnancyScoreService highRiskPregnancyScoreService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		HighRiskPregnancyScorePO po = highRiskPregnancyScoreService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<HighRiskPregnancyScorePO> all = highRiskPregnancyScoreService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		HighRiskPregnancyScorePO basePO = new HighRiskPregnancyScorePO();
		try {
			highRiskPregnancyScoreService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		HighRiskPregnancyScorePO basePO = highRiskPregnancyScoreService.find(id);
		//basePO.setUpdateTime(now);
		try {
			highRiskPregnancyScoreService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			highRiskPregnancyScoreService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			highRiskPregnancyScoreService.deletes(ids);
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
		Page<HighRiskPregnancyScorePO> page = new Page<HighRiskPregnancyScorePO>();
		highRiskPregnancyScoreService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}