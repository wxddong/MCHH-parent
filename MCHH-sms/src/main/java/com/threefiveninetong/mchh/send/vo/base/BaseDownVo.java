package com.threefiveninetong.mchh.send.vo.base;

import com.threefiveninetong.mchh.po.SmsSendingPO;

/**
 * 
 * @author lyg
 * 下行信息状态的的BaseDownVo
 *
 */
public class BaseDownVo implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8333945088954004676L;
	public static final String Success="0";
	/*返回码，0代表成功，其他代表失败 */
	private String errorCode;
	/*返回消息，成功为空， */
	private String errorMsg; 
	/*失败次数，默认为0 */
	private int failNum;
	/*来源   如YM,CL，GD，默认为0 */
	private String source;
	
	/**  下行消息的id */
	private String masDownId;
	/**  下行消息的状态  */
	private String state;
	
	
	
	private SmsSendingPO sendingPo;
	
	
	
	public BaseDownVo() {
		super();
		this.errorCode = "0";
		this.errorMsg = "";
		this.failNum = 0;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
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

	public String getMasDownId() {
		return masDownId;
	}

	public void setMasDownId(String masDownId) {
		this.masDownId = masDownId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
