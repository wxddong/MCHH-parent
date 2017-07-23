/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SpecialDiseaseInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-10-20 17:23:54 
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
import com.threefiveninetong.mchh.premarital.po.SpecialDiseaseInfoPO;
import com.threefiveninetong.mchh.premarital.service.SpecialDiseaseInfoService;

/**
 * @ClassName: SpecialDiseaseInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-10-20 17:23:54 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class SpecialDiseaseInfoServiceTest {
	@Resource
	private SpecialDiseaseInfoService specialDiseaseInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		SpecialDiseaseInfoPO po = specialDiseaseInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<SpecialDiseaseInfoPO> all = specialDiseaseInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		SpecialDiseaseInfoPO basePO = new SpecialDiseaseInfoPO();
		try {
			specialDiseaseInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		SpecialDiseaseInfoPO basePO = specialDiseaseInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			specialDiseaseInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			specialDiseaseInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			specialDiseaseInfoService.deletes(ids);
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
		Page<SpecialDiseaseInfoPO> page = new Page<SpecialDiseaseInfoPO>();
		specialDiseaseInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}