package com.threefiveninetong.mchh.sys.common;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.threefiveninetong.mchh.sys.po.ResourcesPO;
import com.threefiveninetong.mchh.sys.service.OperateLogService;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;


/**
 * 获取操作日志记录类工厂实现类
 * @author xuyh
 * @date 2013-7-26上午10:18:48
 * @description
 */
public class OperateLogFactoryImpl implements OperateLogFactory{
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(OperateLogFactoryImpl.class);
	
	private Resources resources;
	
	public void setResources(Resources resources){
		this.resources = resources;
	}

	private OperateLogService operateLogService;
	
	public void setOperateLogService(OperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}
	
	
	public OperateLog newLog(String uri, String method,
			HttpServletRequest request) {
		
		OperateLogImpl operatelog = new OperateLogImpl(operateLogService);
		
		ResourcesPO resourcesPO = resources.getResourcesByUri(uri,method);
		if(resourcesPO.getId()!=null){
			OperatorVO operator = new OperatorVO();
			String operatedata = "";
			operatedata +=method+": "+uri+";\r\nDATA:  ";
			String log_mac = "";
			int operateresult = 1;
			
			if(uri.contains("logout")){	 //用户退出操作
				operator =(OperatorVO) request.getAttribute(Constant.SESSION_KEY_OPERATOR);
				operatedata+="username="+operator.getLoginName()+" ";
			}else{
				operator =(OperatorVO) request.getSession().getAttribute(Constant.SESSION_KEY_OPERATOR);
			}
			if(operator!=null){	//登录成功后的操作
				Enumeration  e = (Enumeration)request.getParameterNames();
				while(e.hasMoreElements()){
					String key = (String)e.nextElement();
					String tvalue[] ;
					 if(!key.equals("pagesize")&&!key.equals("format")&&!key.equals("pageindex")&&!key.equals("password")&&!key.contains("pwd")){
						   tvalue = (String[])request.getParameterValues(key);
						   operatedata+=key+"=";
							for(int i=0;i<tvalue.length;i++){
					               operatedata+=tvalue[0]+"&";
							}
		             }
				}
				if(operatedata.length()>500){
					operatedata = operatedata.substring(0,499);
				}else{
					operatedata = operatedata.substring(0,operatedata.length()-1);
				}
				operatelog.setOperatorId(operator.getId());
				operatelog.setOperateData(operatedata);
				/*try {
					log_mac = MacUtil.md5(operator.get("OPERATOR_ID")+funmap.get("FUNC_ID")+operateresult+new Date());
				} catch (NoSuchAlgorithmException e1) {
					logger.error("OperateLogFactoryImpl error.", e1);
				}*/
			}else if(uri.contains("login") && !"GET".equalsIgnoreCase(method)){		//登录失败操作		
				String loginName [] =(String [])request.getParameterValues("loginName");
				operatelog.setOperatorId("");
				operatelog.setOperateData(operatedata+"username="+loginName[0]);
			}
			operatelog.setOperateResult(operateresult);
			operatelog.setResId(resourcesPO.getId());
			operatelog.setOperateTime(new Date());
			operatelog.setLogMac(log_mac);
		}else{
			operatelog=null;
		}
		return operatelog;
	}

}
