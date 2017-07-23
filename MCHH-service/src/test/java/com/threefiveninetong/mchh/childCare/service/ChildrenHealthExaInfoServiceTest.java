/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHealthExaInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:02 
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
import com.threefiveninetong.mchh.childCare.po.ChildrenHealthExaInfoPO;
import com.threefiveninetong.mchh.childCare.service.ChildrenHealthExaInfoService;

/**
 * @ClassName: ChildrenHealthExaInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:02 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ChildrenHealthExaInfoServiceTest {
	@Resource
	private ChildrenHealthExaInfoService childrenHealthExaInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ChildrenHealthExaInfoPO po = childrenHealthExaInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ChildrenHealthExaInfoPO> all = childrenHealthExaInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ChildrenHealthExaInfoPO basePO = new ChildrenHealthExaInfoPO();
		try {
			childrenHealthExaInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ChildrenHealthExaInfoPO basePO = childrenHealthExaInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			childrenHealthExaInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			childrenHealthExaInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			childrenHealthExaInfoService.deletes(ids);
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
		Page<ChildrenHealthExaInfoPO> page = new Page<ChildrenHealthExaInfoPO>();
		childrenHealthExaInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}