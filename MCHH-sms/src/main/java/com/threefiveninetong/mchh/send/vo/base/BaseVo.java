
package com.threefiveninetong.mchh.send.vo.base;

/**
 * @ClassName: BaseVO
 * @Description: 基础vo
 * @author: jixf
 * @date: 2016年1月8日 上午10:23:41
 */
public class BaseVo {
    /**
     * @Fields : 状态码
     */
    private String statusCode = "0000";

    /**
     * @Fields : 消息
     */
    private String message = "";

    public BaseVo() {
    	 this.statusCode = "0000";
    	 this.message = "";
    }

    public BaseVo(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    /**
     * @Description: 成功BaseVo
     */
    public static BaseVo valueOfSuccess() {
        return new BaseVo("0000", "");
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
