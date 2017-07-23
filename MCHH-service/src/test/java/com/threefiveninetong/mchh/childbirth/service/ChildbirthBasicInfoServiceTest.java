/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBasicInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childbirth.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:05 
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
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBasicInfoService;

/**
 * @ClassName: ChildbirthBasicInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:05 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ChildbirthBasicInfoServiceTest {
	@Resource
	private ChildbirthBasicInfoService childbirthBasicInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ChildbirthBasicInfoPO po = childbirthBasicInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ChildbirthBasicInfoPO> all = childbirthBasicInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ChildbirthBasicInfoPO basePO = new ChildbirthBasicInfoPO();
		try {
			childbirthBasicInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ChildbirthBasicInfoPO basePO = childbirthBasicInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			childbirthBasicInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			childbirthBasicInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			childbirthBasicInfoService.deletes(ids);
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
		Page<ChildbirthBasicInfoPO> page = new Page<ChildbirthBasicInfoPO>();
		childbirthBasicInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}