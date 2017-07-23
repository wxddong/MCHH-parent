/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalExaInfoServiceTest.java  
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
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.premarital.service.PremaritalExaInfoService;

/**
 * @ClassName: PremaritalExaInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PremaritalExaInfoServiceTest {
	@Resource
	private PremaritalExaInfoService premaritalExaInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		PremaritalExaInfoPO po = premaritalExaInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<PremaritalExaInfoPO> all = premaritalExaInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		PremaritalExaInfoPO basePO = new PremaritalExaInfoPO();
		try {
			premaritalExaInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		PremaritalExaInfoPO basePO = premaritalExaInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			premaritalExaInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			premaritalExaInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			premaritalExaInfoService.deletes(ids);
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
		Page<PremaritalExaInfoPO> page = new Page<PremaritalExaInfoPO>();
		premaritalExaInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}