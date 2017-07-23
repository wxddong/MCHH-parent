/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaDetailedInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.postpartum.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:39 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.service;
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
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaDetailedInfoPO;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaDetailedInfoService;

/**
 * @ClassName: PostpartumExaDetailedInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:39 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PostpartumExaDetailedInfoServiceTest {
	@Resource
	private PostpartumExaDetailedInfoService postpartumExaDetailedInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		PostpartumExaDetailedInfoPO po = postpartumExaDetailedInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<PostpartumExaDetailedInfoPO> all = postpartumExaDetailedInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		PostpartumExaDetailedInfoPO basePO = new PostpartumExaDetailedInfoPO();
		try {
			postpartumExaDetailedInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		PostpartumExaDetailedInfoPO basePO = postpartumExaDetailedInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			postpartumExaDetailedInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			postpartumExaDetailedInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			postpartumExaDetailedInfoService.deletes(ids);
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
		Page<PostpartumExaDetailedInfoPO> page = new Page<PostpartumExaDetailedInfoPO>();
		postpartumExaDetailedInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}