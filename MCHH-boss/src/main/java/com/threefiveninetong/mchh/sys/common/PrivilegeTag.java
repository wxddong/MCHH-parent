package com.threefiveninetong.mchh.sys.common;



import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.threefiveninetong.mchh.sys.vo.OperatorVO;


/**
 * 功能权限标签
 * @author xuyh
 * @date 2013-7-26上午10:19:11
 * @description
 */
public class PrivilegeTag extends TagSupport {

	private static final long serialVersionUID = -8158553218536026024L;
	private String url;

	@Override
	public int doStartTag() throws JspException {

		// 当前登录用户是否有指定的权限
		OperatorVO operator = (OperatorVO) pageContext.getSession().getAttribute(Constant.SESSION_KEY_OPERATOR);
		if ("admin".equals(operator.getLoginName())) {
			// 超级管理员有所有的权限
			return EVAL_BODY_INCLUDE;
		}
		String[] resUris = (String[]) pageContext.getSession().getAttribute(Constant.SESSION_KEY_RESURIS);
		boolean hasPrivilege = false;
		for (String resId : resUris) {
			if (url.equals(resId)) {
				hasPrivilege = true;
				break;
			}
		}

		// 根据是否有权限确定返回值
		if (hasPrivilege) {
			return EVAL_BODY_INCLUDE; // 执行标签体
		} else {
			return SKIP_BODY; // 忽略标签体
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
