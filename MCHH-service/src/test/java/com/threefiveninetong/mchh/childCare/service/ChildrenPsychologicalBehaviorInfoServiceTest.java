/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPsychologicalBehaviorInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:05 
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
import com.threefiveninetong.mchh.childCare.po.ChildrenPsychologicalBehaviorInfoPO;
import com.threefiveninetong.mchh.childCare.service.ChildrenPsychologicalBehaviorInfoService;

/**
 * @ClassName: ChildrenPsychologicalBehaviorInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ChildrenPsychologicalBehaviorInfoServiceTest {
	@Resource
	private ChildrenPsychologicalBehaviorInfoService childrenPsychologicalBehaviorInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ChildrenPsychologicalBehaviorInfoPO po = childrenPsychologicalBehaviorInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ChildrenPsychologicalBehaviorInfoPO> all = childrenPsychologicalBehaviorInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ChildrenPsychologicalBehaviorInfoPO basePO = new ChildrenPsychologicalBehaviorInfoPO();
		try {
			childrenPsychologicalBehaviorInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ChildrenPsychologicalBehaviorInfoPO basePO = childrenPsychologicalBehaviorInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			childrenPsychologicalBehaviorInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			childrenPsychologicalBehaviorInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			childrenPsychologicalBehaviorInfoService.deletes(ids);
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
		Page<ChildrenPsychologicalBehaviorInfoPO> page = new Page<ChildrenPsychologicalBehaviorInfoPO>();
		childrenPsychologicalBehaviorInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}