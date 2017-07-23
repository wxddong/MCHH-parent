/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenReferralInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:04 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.service;
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
import com.threefiveninetong.mchh.childCare.po.ChildrenReferralInfoPO;
import com.threefiveninetong.mchh.childCare.service.ChildrenReferralInfoService;

/**
 * @ClassName: ChildrenReferralInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:04 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ChildrenReferralInfoServiceTest {
	@Resource
	private ChildrenReferralInfoService childrenReferralInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ChildrenReferralInfoPO po = childrenReferralInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ChildrenReferralInfoPO> all = childrenReferralInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ChildrenReferralInfoPO basePO = new ChildrenReferralInfoPO();
		try {
			childrenReferralInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ChildrenReferralInfoPO basePO = childrenReferralInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			childrenReferralInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			childrenReferralInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			childrenReferralInfoService.deletes(ids);
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
		Page<ChildrenReferralInfoPO> page = new Page<ChildrenReferralInfoPO>();
		childrenReferralInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}