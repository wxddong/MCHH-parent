/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPhysiqueExaInfoServiceTest.java  
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.service;
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
import com.threefiveninetong.mchh.childCare.po.ChildrenPhysiqueExaInfoPO;
import com.threefiveninetong.mchh.childCare.service.ChildrenPhysiqueExaInfoService;

/**
 * @ClassName: ChildrenPhysiqueExaInfoServiceTest 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:03 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ChildrenPhysiqueExaInfoServiceTest {
	@Resource
	private ChildrenPhysiqueExaInfoService childrenPhysiqueExaInfoService;
	int id = 1;
	Date now = new Date();

	@Test
	public void testFind() {
		ChildrenPhysiqueExaInfoPO po = childrenPhysiqueExaInfoService.find(id);
		//Assert.assertEquals("a", po.getName());
	}

	@Test
	public void testFindAll() {
		List<ChildrenPhysiqueExaInfoPO> all = childrenPhysiqueExaInfoService.findAll();
		Assert.assertEquals(1, all.size());
	}

	@Test
	public void testCreate() {
		ChildrenPhysiqueExaInfoPO basePO = new ChildrenPhysiqueExaInfoPO();
		try {
			childrenPhysiqueExaInfoService.create(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testUpdate() {
		ChildrenPhysiqueExaInfoPO basePO = childrenPhysiqueExaInfoService.find(id);
		//basePO.setUpdateTime(now);
		try {
			childrenPhysiqueExaInfoService.update(basePO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDelete() {
		try {
			childrenPhysiqueExaInfoService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testDeletes() {
		Integer[] ids = new Integer[] { id };
		try {
			childrenPhysiqueExaInfoService.deletes(ids);
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
		Page<ChildrenPhysiqueExaInfoPO> page = new Page<ChildrenPhysiqueExaInfoPO>();
		childrenPhysiqueExaInfoService.listForPage(reqs, page);
		Assert.assertEquals(1, page.getTotal());
	}
}