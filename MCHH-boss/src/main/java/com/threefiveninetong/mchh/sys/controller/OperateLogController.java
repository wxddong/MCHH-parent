package com.threefiveninetong.mchh.sys.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.sys.po.OperateLogPO;
import com.threefiveninetong.mchh.sys.service.OperateLogService;
import com.threefiveninetong.mchh.util.Page;



/**
 * 操作日志控制类
 * <ul>
 * <li>/list： 操作日志列表</li>
 * </ul>
 * 
 * @author xuyh
 * @date 2013-7-16
 */
@Controller
@RequestMapping("/sys/operateLog")
public class OperateLogController {
	private static final Logger log = LoggerFactory.getLogger(OperateLogController.class);

	@Resource
	private OperateLogService operateLogService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listOperateLogView() {
		log.debug("request page: /sys/operateLog/list");
		return "sys/operateLog/operateLog_list";
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listOperateLogActoin(@RequestParam Map<String, Object> reqs, Page<OperateLogPO> page) {
		log.debug("request data: listOperateLog");
		Model model = new Model();
		operateLogService.listOperateLogForPage(reqs, page);
		model.setPage(page);
		return model;
	}

}
