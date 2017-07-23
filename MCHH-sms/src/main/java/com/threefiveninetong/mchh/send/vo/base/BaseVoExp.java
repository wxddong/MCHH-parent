package com.threefiveninetong.mchh.send.vo.base;

import org.apache.commons.lang.ArrayUtils;
import com.threefiveninetong.mchh.po.SmsSendingPO;

/**
 * 
 * @author lyg
 * 发送短信的baseVo
 *
 */
public class BaseVoExp extends BaseVo implements java.io.Serializable{

	private static final long serialVersionUID = -9176893233366321721L;

	public static final String Success="0000";

	private String source;//发送短信的平台  如YM,CL，GD，默认为0 
	
	private int maxSendNum;//平台一次群发短信的最大数量
	
	private SmsSendingPO sendingPo;//发送的短信信息
	
	private int failNum;//失败次数，默认为0 
	
	/**  下行消息的id    {{手机号，downdis},{手机号，downdis},{手机号，downdis}}*/
	private String[][] phoneAndDownIds;

	public BaseVoExp() {
		super();
		this.failNum = 0;
	}

	public int getFailNum() {
		return failNum;
	}

	public void setFailNum(int failNum) {
		this.failNum = failNum;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public SmsSendingPO getSendingPo() {
		return sendingPo;
	}

	public void setSendingPo(SmsSendingPO sendingPo) {
		this.sendingPo = sendingPo;
	}

	public String[][] getPhoneAndDownIds() {
		return phoneAndDownIds;
	}

	public int getMaxSendNum() {
		return maxSendNum;
	}

	public void setMaxSendNum(int maxSendNum) {
		this.maxSendNum = maxSendNum;
	}
	public void addPhoneAndDownIds(String[][] phoneAndDownIds) {
		this.phoneAndDownIds= (String[][]) ArrayUtils.addAll(this.phoneAndDownIds,phoneAndDownIds);
	}
	
}
