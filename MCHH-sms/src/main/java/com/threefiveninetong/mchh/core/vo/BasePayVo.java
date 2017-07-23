
package com.threefiveninetong.mchh.core.vo;

/**
 * @ClassName: BaseVO
 * @Description: 基础vo
 * @author: jixf
 * @date: 2016年1月8日 上午10:23:41
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
