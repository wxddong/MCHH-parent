/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskTermServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.service;
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
import com.threefiveninetong.mchh.prenatal.po.HighRiskTermPO;
import com.threefiveninetong.mchh.prenatal.service.HighRiskTermService;

/**
 * @ClassName: HighRiskTermServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class HighRiskTermServiceTest {
	@Resource
	private HighRiskTermService highRiskTermService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		HighRiskTermPO po = highRiskTermService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<HighRiskTermPO> all = highRiskTermService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		HighRiskTermPO basePO = new HighRiskTermPO();
		try {
			highRiskTermService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		HighRiskTermPO basePO = highRiskTermService.find(id);
		//basePO.setUpdateTime(now);
		try {
			highRiskTermService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			highRiskTermService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			highRiskTermService.deletes(ids);
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
		Page<HighRiskTermPO> page = new Page<HighRiskTermPO>();
		highRiskTermService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}