package com.threefiveninetong.mchh.core.vo;
/**
 * @ClassName: BaseVO
 * @Description: 基础vo
 * @author: zhanght
 */
public class BasePayVo {
    /**
     * @Fields : 状态码
     */
    private String status = "0";

    /**
     * @Fields : 消息
     */
    private String message = "";

    public BasePayVo() {
    }

    public BasePayVo(String status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * @Description: 成功BaseVo
     */
    public static BasePayVo valueOfSuccess() {
        return new BasePayVo("0000", "");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
