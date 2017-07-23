/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalReferralInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
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
import com.threefiveninetong.mchh.premarital.po.PremaritalReferralInfoPO;
import com.threefiveninetong.mchh.premarital.service.PremaritalReferralInfoService;

/**
 * @ClassName: PremaritalReferralInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PremaritalReferralInfoServiceTest {
	@Resource
	private PremaritalReferralInfoService premaritalReferralInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		PremaritalReferralInfoPO po = premaritalReferralInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<PremaritalReferralInfoPO> all = premaritalReferralInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		PremaritalReferralInfoPO basePO = new PremaritalReferralInfoPO();
		try {
			premaritalReferralInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		PremaritalReferralInfoPO basePO = premaritalReferralInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			premaritalReferralInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			premaritalReferralInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			premaritalReferralInfoService.deletes(ids);
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
		Page<PremaritalReferralInfoPO> page = new Page<PremaritalReferralInfoPO>();
		premaritalReferralInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}