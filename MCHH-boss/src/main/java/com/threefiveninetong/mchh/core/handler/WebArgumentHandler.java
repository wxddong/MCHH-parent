package com.threefiveninetong.mchh.core.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class WebArgumentHandler implements WebArgumentResolver{

	@Override
	public Object resolveArgument(MethodParameter methodPara, NativeWebRequest webRequest) throws Exception {
		/*if(methodPara.getParameterType().equals(OrgnizationVO.class)){
			OrgnizationVO vo=new OrgnizationVO();
			vo.setName("orgname");
			return vo;
		}*/
		return null;
	}

}
