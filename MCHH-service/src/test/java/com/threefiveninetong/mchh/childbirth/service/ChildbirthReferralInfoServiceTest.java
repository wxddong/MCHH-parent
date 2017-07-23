/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthReferralInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childbirth.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:18 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.service;
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
import com.threefiveninetong.mchh.childbirth.po.ChildbirthReferralInfoPO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthReferralInfoService;

/**
 * @ClassName: ChildbirthReferralInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:18 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ChildbirthReferralInfoServiceTest {
	@Resource
	private ChildbirthReferralInfoService childbirthReferralInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ChildbirthReferralInfoPO po = childbirthReferralInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ChildbirthReferralInfoPO> all = childbirthReferralInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ChildbirthReferralInfoPO basePO = new ChildbirthReferralInfoPO();
		try {
			childbirthReferralInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ChildbirthReferralInfoPO basePO = childbirthReferralInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			childbirthReferralInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			childbirthReferralInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			childbirthReferralInfoService.deletes(ids);
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
		Page<ChildbirthReferralInfoPO> page = new Page<ChildbirthReferralInfoPO>();
		childbirthReferralInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}