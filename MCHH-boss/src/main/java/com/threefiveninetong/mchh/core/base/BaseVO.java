package com.threefiveninetong.mchh.core.base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="base")
public class BaseVO implements Serializable{
	private String Message;
	private String StatusCode;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	
}
