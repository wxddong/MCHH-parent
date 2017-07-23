/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ShortMessageTemplateServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
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
import com.threefiveninetong.mchh.config.po.ShortMessageTemplatePO;
import com.threefiveninetong.mchh.config.service.ShortMessageTemplateService;

/**
 * @ClassName: ShortMessageTemplateServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ShortMessageTemplateServiceTest {
	@Resource
	private ShortMessageTemplateService shortMessageTemplateService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ShortMessageTemplatePO po = shortMessageTemplateService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ShortMessageTemplatePO> all = shortMessageTemplateService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ShortMessageTemplatePO basePO = new ShortMessageTemplatePO();
		try {
			shortMessageTemplateService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ShortMessageTemplatePO basePO = shortMessageTemplateService.find(id);
		//basePO.setUpdateTime(now);
		try {
			shortMessageTemplateService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			shortMessageTemplateService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			shortMessageTemplateService.deletes(ids);
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
		Page<ShortMessageTemplatePO> page = new Page<ShortMessageTemplatePO>();
		shortMessageTemplateService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}