/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PopulationDataServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
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
import com.threefiveninetong.mchh.config.po.PopulationDataPO;
import com.threefiveninetong.mchh.config.service.PopulationDataService;

/**
 * @ClassName: PopulationDataServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PopulationDataServiceTest {
	@Resource
	private PopulationDataService populationDataService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		PopulationDataPO po = populationDataService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<PopulationDataPO> all = populationDataService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		PopulationDataPO basePO = new PopulationDataPO();
		try {
			populationDataService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		PopulationDataPO basePO = populationDataService.find(id);
		//basePO.setUpdateTime(now);
		try {
			populationDataService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			populationDataService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			populationDataService.deletes(ids);
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
		Page<PopulationDataPO> page = new Page<PopulationDataPO>();
		populationDataService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}