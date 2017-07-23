/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaOtherInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.postpartum.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-31 13:47:42 
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
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaOtherInfoPO;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaOtherInfoService;

/**
 * @ClassName: PostpartumExaOtherInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-31 13:47:42 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PostpartumExaOtherInfoServiceTest {
	@Resource
	private PostpartumExaOtherInfoService postpartumExaOtherInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		PostpartumExaOtherInfoPO po = postpartumExaOtherInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<PostpartumExaOtherInfoPO> all = postpartumExaOtherInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		PostpartumExaOtherInfoPO basePO = new PostpartumExaOtherInfoPO();
		try {
			postpartumExaOtherInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		PostpartumExaOtherInfoPO basePO = postpartumExaOtherInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			postpartumExaOtherInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			postpartumExaOtherInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			postpartumExaOtherInfoService.deletes(ids);
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
		Page<PostpartumExaOtherInfoPO> page = new Page<PostpartumExaOtherInfoPO>();
		postpartumExaOtherInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}