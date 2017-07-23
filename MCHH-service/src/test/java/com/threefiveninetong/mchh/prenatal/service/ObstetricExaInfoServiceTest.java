/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ObstetricExaInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
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
import com.threefiveninetong.mchh.prenatal.po.ObstetricExaInfoPO;
import com.threefiveninetong.mchh.prenatal.service.ObstetricExaInfoService;

/**
 * @ClassName: ObstetricExaInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ObstetricExaInfoServiceTest {
	@Resource
	private ObstetricExaInfoService obstetricExaInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ObstetricExaInfoPO po = obstetricExaInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ObstetricExaInfoPO> all = obstetricExaInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ObstetricExaInfoPO basePO = new ObstetricExaInfoPO();
		try {
			obstetricExaInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ObstetricExaInfoPO basePO = obstetricExaInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			obstetricExaInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			obstetricExaInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			obstetricExaInfoService.deletes(ids);
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
		Page<ObstetricExaInfoPO> page = new Page<ObstetricExaInfoPO>();
		obstetricExaInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}