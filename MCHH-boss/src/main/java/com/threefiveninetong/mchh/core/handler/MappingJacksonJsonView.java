package com.threefiveninetong.mchh.core.handler;

import java.util.Map;

public class MappingJacksonJsonView extends
com.alibaba.fastjson.support.spring.FastJsonJsonView {

protected Object filterModel(Map<String, Object> model) {
	Map<?, ?> result = (Map<?, ?>) super.filterModel(model);
		if (result.size() == 1) {
			return result.values().iterator().next();
		} else {
			return result;
		}
	}

}
