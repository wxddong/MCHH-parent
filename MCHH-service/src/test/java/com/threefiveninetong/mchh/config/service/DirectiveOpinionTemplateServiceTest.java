/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DirectiveOpinionTemplateServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
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
import com.threefiveninetong.mchh.config.po.DirectiveOpinionTemplatePO;
import com.threefiveninetong.mchh.config.service.DirectiveOpinionTemplateService;

/**
 * @ClassName: DirectiveOpinionTemplateServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class DirectiveOpinionTemplateServiceTest {
	@Resource
	private DirectiveOpinionTemplateService directiveOpinionTemplateService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		DirectiveOpinionTemplatePO po = directiveOpinionTemplateService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<DirectiveOpinionTemplatePO> all = directiveOpinionTemplateService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		DirectiveOpinionTemplatePO basePO = new DirectiveOpinionTemplatePO();
		try {
			directiveOpinionTemplateService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		DirectiveOpinionTemplatePO basePO = directiveOpinionTemplateService.find(id);
		//basePO.setUpdateTime(now);
		try {
			directiveOpinionTemplateService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			directiveOpinionTemplateService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			directiveOpinionTemplateService.deletes(ids);
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
		Page<DirectiveOpinionTemplatePO> page = new Page<DirectiveOpinionTemplatePO>();
		directiveOpinionTemplateService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}