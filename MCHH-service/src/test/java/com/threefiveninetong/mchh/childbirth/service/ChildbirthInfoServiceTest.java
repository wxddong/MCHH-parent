/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childbirth.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 20:03:48 
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
import com.threefiveninetong.mchh.childbirth.po.ChildbirthInfoPO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthInfoService;

/**
 * @ClassName: ChildbirthInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 20:03:48 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ChildbirthInfoServiceTest {
	@Resource
	private ChildbirthInfoService childbirthInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ChildbirthInfoPO po = childbirthInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ChildbirthInfoPO> all = childbirthInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ChildbirthInfoPO basePO = new ChildbirthInfoPO();
		try {
			childbirthInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ChildbirthInfoPO basePO = childbirthInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			childbirthInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			childbirthInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			childbirthInfoService.deletes(ids);
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
		Page<ChildbirthInfoPO> page = new Page<ChildbirthInfoPO>();
		childbirthInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}