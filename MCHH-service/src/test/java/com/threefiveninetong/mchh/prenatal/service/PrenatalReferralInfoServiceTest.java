/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalReferralInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:17 
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
import com.threefiveninetong.mchh.prenatal.po.PrenatalReferralInfoPO;
import com.threefiveninetong.mchh.prenatal.service.PrenatalReferralInfoService;

/**
 * @ClassName: PrenatalReferralInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:17 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PrenatalReferralInfoServiceTest {
	@Resource
	private PrenatalReferralInfoService prenatalReferralInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		PrenatalReferralInfoPO po = prenatalReferralInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<PrenatalReferralInfoPO> all = prenatalReferralInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		PrenatalReferralInfoPO basePO = new PrenatalReferralInfoPO();
		try {
			prenatalReferralInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		PrenatalReferralInfoPO basePO = prenatalReferralInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			prenatalReferralInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			prenatalReferralInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			prenatalReferralInfoService.deletes(ids);
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
		Page<PrenatalReferralInfoPO> page = new Page<PrenatalReferralInfoPO>();
		prenatalReferralInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}