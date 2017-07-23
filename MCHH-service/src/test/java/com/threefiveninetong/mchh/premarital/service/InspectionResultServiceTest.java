/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: InspectionResultServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:33 
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
import com.threefiveninetong.mchh.premarital.po.InspectionResultPO;
import com.threefiveninetong.mchh.premarital.service.InspectionResultService;

/**
 * @ClassName: InspectionResultServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:33 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class InspectionResultServiceTest {
	@Resource
	private InspectionResultService inspectionResultService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		InspectionResultPO po = inspectionResultService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<InspectionResultPO> all = inspectionResultService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		InspectionResultPO basePO = new InspectionResultPO();
		try {
			inspectionResultService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		InspectionResultPO basePO = inspectionResultService.find(id);
		//basePO.setUpdateTime(now);
		try {
			inspectionResultService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			inspectionResultService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			inspectionResultService.deletes(ids);
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
		Page<InspectionResultPO> page = new Page<InspectionResultPO>();
		inspectionResultService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}