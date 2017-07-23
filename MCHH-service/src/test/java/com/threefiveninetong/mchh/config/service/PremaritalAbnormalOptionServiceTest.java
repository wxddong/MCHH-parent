/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalAbnormalOptionServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.service;
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
import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;
import com.threefiveninetong.mchh.config.service.PremaritalAbnormalOptionService;

/**
 * @ClassName: PremaritalAbnormalOptionServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PremaritalAbnormalOptionServiceTest {
	@Resource
	private PremaritalAbnormalOptionService premaritalAbnormalOptionService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		PremaritalAbnormalOptionPO po = premaritalAbnormalOptionService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<PremaritalAbnormalOptionPO> all = premaritalAbnormalOptionService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		PremaritalAbnormalOptionPO basePO = new PremaritalAbnormalOptionPO();
		try {
			premaritalAbnormalOptionService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		PremaritalAbnormalOptionPO basePO = premaritalAbnormalOptionService.find(id);
		//basePO.setUpdateTime(now);
		try {
			premaritalAbnormalOptionService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			premaritalAbnormalOptionService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			premaritalAbnormalOptionService.deletes(ids);
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
		Page<PremaritalAbnormalOptionPO> page = new Page<PremaritalAbnormalOptionPO>();
		premaritalAbnormalOptionService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}