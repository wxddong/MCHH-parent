/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SupplementaryExamInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.service;
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
import com.threefiveninetong.mchh.prenatal.po.SupplementaryExamInfoPO;
import com.threefiveninetong.mchh.prenatal.service.SupplementaryExamInfoService;

/**
 * @ClassName: SupplementaryExamInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class SupplementaryExamInfoServiceTest {
	@Resource
	private SupplementaryExamInfoService supplementaryExamInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		SupplementaryExamInfoPO po = supplementaryExamInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<SupplementaryExamInfoPO> all = supplementaryExamInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		SupplementaryExamInfoPO basePO = new SupplementaryExamInfoPO();
		try {
			supplementaryExamInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		SupplementaryExamInfoPO basePO = supplementaryExamInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			supplementaryExamInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			supplementaryExamInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			supplementaryExamInfoService.deletes(ids);
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
		Page<SupplementaryExamInfoPO> page = new Page<SupplementaryExamInfoPO>();
		supplementaryExamInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}