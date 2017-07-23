package com.threefiveninetong.mchh.core.util;


public class SystemException extends RuntimeException{
	private String key;
	private Object[] values;
	public SystemException(){
		super();
	}
	public SystemException(String message,Throwable throwable){
		super(message,throwable);
	}
	public SystemException(String message){
		super(message);
	}
	public SystemException(Throwable throwable){
		super(throwable);
	}

	public SystemException(String key,String message){
		super(message);
		this.key=key;
	}
	public SystemException(String key,Object values,String message,Throwable throwable){
		super(message,throwable);
		this.key=key;
		this.values=new Object[]{values};
		
	}
	/*
	 * key 异常配置文件中的key
	 * values指定异常的类名
	 * message 指定异常信息
	 */
	public SystemException(String key,Object [] values,String message,Throwable throwable){
		super(message,throwable);
		this.key=key;
		this.values=values;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public Object[] getValues() {
		return values;
	}
	public void setValues(Object[] values) {
		this.values = values;
	}
}
