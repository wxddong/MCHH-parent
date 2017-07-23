package com.threefiveninetong.mchh.core.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;

import com.threefiveninetong.mchh.core.util.APISignUtils;
import com.threefiveninetong.mchh.core.util.StringUtil;
import com.threefiveninetong.mchh.send.vo.base.BaseVo;


/**
 * @ClassName: TerminalNoInterceptor
 * @Description: TODO 终端TerminalNo验证
 * @author: dingjh
 * @date: 2016年1月8日 下午12:28:10
 */
@PropertySource("classpath:/config.properties")
@Component
public class SignInterceptor extends HandlerInterceptorAdapter {
	@Resource
	Environment env;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String sign = request.getParameter("sign");
        return validate(sign, request, response);
//        return true;
    }

    /**
     * @Title: validate @Description: TODO sign验证 @param: @param
     *         terinalNo @param: @return @return: boolean @throws
     */
    private boolean validate(String sign, HttpServletRequest request, HttpServletResponse response) {
        String errorMsg = null;
        String keyStr = env.getProperty("token.key");

        // 为空
        if (StringUtils.isEmpty(sign)) {
            errorMsg = JSON.toJSONString(new BaseVo("-2001", "Sign不可为空"));
        } else {

            // 验证规则
            /**
             * xx xx xx
             */

            // 参数Map
            Map properties = request.getParameterMap();
            // 返回值Map
            Set<String> keys = properties.keySet();
            String value = "";// 参数值
            Map<String, String> mapParam = new HashMap<String, String>();// 将拦截到的请求参数的参数名和参数值放到map中
            for (String key : keys) {
                Object valueObj = properties.get(key);
                if (null == valueObj) {
                    value = "";
                } else if (valueObj instanceof String[]) {
                    String[] values = (String[]) valueObj;
                    for (int i = 0; i < values.length; i++) {
                        value = values[i] + ",";
                    }
                    value = value.substring(0, value.length() - 1);
                } else {
                    value = StringUtil.valueOf(valueObj);
                }
                // System.out.println(key + "：" + value + "；");

                mapParam.put(key, value);
            }

            if (!APISignUtils.validateSign(mapParam, sign,keyStr)) {// 校验sign不合法
                errorMsg = JSON.toJSONString(new BaseVo("-2002", "签名校验不通过"));
            }
        }

        // 有异常
        if (errorMsg != null) {
            try {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                response.getOutputStream().write(errorMsg.getBytes("utf-8"));
                response.getOutputStream().flush();
                response.getOutputStream().close();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
