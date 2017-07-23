/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: BirthArchivesInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.archives.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:42 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.service;
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
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;

/**
 * @ClassName: BirthArchivesInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:42 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BirthArchivesInfoServiceTest {
	@Resource
	private BirthArchivesInfoService birthArchivesInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		BirthArchivesInfoPO po = birthArchivesInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<BirthArchivesInfoPO> all = birthArchivesInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		BirthArchivesInfoPO basePO = new BirthArchivesInfoPO();
		try {
			birthArchivesInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		BirthArchivesInfoPO basePO = birthArchivesInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			birthArchivesInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			birthArchivesInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			birthArchivesInfoService.deletes(ids);
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
		Page<BirthArchivesInfoPO> page = new Page<BirthArchivesInfoPO>();
		birthArchivesInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}