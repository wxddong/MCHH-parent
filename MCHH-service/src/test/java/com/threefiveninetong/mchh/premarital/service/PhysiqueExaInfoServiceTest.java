/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PhysiqueExaInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:33 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.service;
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
import com.threefiveninetong.mchh.premarital.po.PhysiqueExaInfoPO;
import com.threefiveninetong.mchh.premarital.service.PhysiqueExaInfoService;

/**
 * @ClassName: PhysiqueExaInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:33 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PhysiqueExaInfoServiceTest {
	@Resource
	private PhysiqueExaInfoService physiqueExaInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		PhysiqueExaInfoPO po = physiqueExaInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<PhysiqueExaInfoPO> all = physiqueExaInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		PhysiqueExaInfoPO basePO = new PhysiqueExaInfoPO();
		try {
			physiqueExaInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		PhysiqueExaInfoPO basePO = physiqueExaInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			physiqueExaInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			physiqueExaInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			physiqueExaInfoService.deletes(ids);
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
		Page<PhysiqueExaInfoPO> page = new Page<PhysiqueExaInfoPO>();
		physiqueExaInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}