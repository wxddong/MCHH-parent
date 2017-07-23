/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskTermServiceTest.java  
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
import com.threefiveninetong.mchh.childCare.po.ChildrenHighRiskTermPO;
import com.threefiveninetong.mchh.childCare.service.ChildrenHighRiskTermService;

/**
 * @ClassName: ChildrenHighRiskTermServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ChildrenHighRiskTermServiceTest {
	@Resource
	private ChildrenHighRiskTermService childrenHighRiskTermService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ChildrenHighRiskTermPO po = childrenHighRiskTermService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ChildrenHighRiskTermPO> all = childrenHighRiskTermService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ChildrenHighRiskTermPO basePO = new ChildrenHighRiskTermPO();
		try {
			childrenHighRiskTermService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ChildrenHighRiskTermPO basePO = childrenHighRiskTermService.find(id);
		//basePO.setUpdateTime(now);
		try {
			childrenHighRiskTermService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			childrenHighRiskTermService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			childrenHighRiskTermService.deletes(ids);
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
		Page<ChildrenHighRiskTermPO> page = new Page<ChildrenHighRiskTermPO>();
		childrenHighRiskTermService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}