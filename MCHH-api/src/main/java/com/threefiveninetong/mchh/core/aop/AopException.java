package com.threefiveninetong.mchh.core.aop;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.JsonUtil;
import com.threefiveninetong.mchh.util.SystemException;

public class AopException implements HandlerExceptionResolver {
    private MessageSource messageSource;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        BaseVo base = new BaseVo();
        if (ex instanceof SystemException) {
            SystemException sysex = (SystemException) ex;
            base.setStatusCode(sysex.getKey());
            base.setMessage(sysex.getMessage());
        } else {
            base.setStatusCode("-1000");
            base.setMessage("系统异常");
        }
       if(handler instanceof HandlerMethod){
        	HandlerMethod method = (HandlerMethod)handler;
        	ResponseBody rb = method.getMethod().getAnnotation(ResponseBody.class);
        	//方法加入ResponseBody注解，返回json类型
        	if(rb!=null){
        		String jsonError;
        		jsonError=JsonUtil.toJson(base);
        		response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                try {
                	response.getOutputStream().write(jsonError.getBytes("UTF-8"));
                	response.getOutputStream().flush();
                    response.getOutputStream().close();
				} catch (Exception e) {
					e.printStackTrace();
				}
                return null;
        	}
       }
       ModelAndView mv = new ModelAndView();
       mv.addObject(base);
       return mv;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
