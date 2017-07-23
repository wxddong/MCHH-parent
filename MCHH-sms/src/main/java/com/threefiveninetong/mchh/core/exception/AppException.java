package com.threefiveninetong.mchh.core.exception;


public class AppException extends RuntimeException {

	/***************************************************************************
	 * B A S E E X C E P T I O N
	 * <LI>Exception默认的构造函数
	 * <LI>直接调用java.lang.Exception的构造函数
	 * 
	 * @version 1.0
	 * @author baiys
	 * @since 1.0
	 **************************************************************************/

	public AppException() {
		super();
	}

	/***************************************************************************
	 * B A S E E X C E P T I O N
	 * <LI>传入字符串参数的构造函数,并且传入一个Message
	 * <LI>调用java.lang.Exception的带String参数构造函数
	 * 
	 * @param message
	 *            String,构造函数传入的参数 表示生成的对Exception类的说明
	 * @version 1.0
	 * @author baiys
	 * @since 1.0
	 **************************************************************************/

	public AppException(String message) {
		super(message);
	}

	/***************************************************************************
	 * B A S E E X C E P T I O N
	 * <LI>传入字符串参数的构造函数,并且传入一个Message,
	 * <LI>并且传入一个Throwable的类型,比如下一个方法中 抛出的异常传入.
	 * <LI>调用java.lang.Exception的带String,Throwable参数构造函数
	 * 
	 * @param message
	 *            String,构造函数传入的参数 表示生成的对Exception类的说明
	 * @param cause
	 *            产生异常的原因,可以是在子方法中出现的异常.
	 * @version 1.0
	 * @author baiys
	 * @since 1.0
	 **************************************************************************/

	public AppException(String message, Throwable cause) {
		super(message + AirBaseUtil.printStackTrace(cause));
	}

	/***************************************************************************
	 * B A S E E X C E P T I O N
	 * <LI>传入字符串参数的构造函数,并且传入一个Message,
	 * <LI>并且传入一个Throwable的类型,比如下一个方法中 抛出的异常传入.
	 * <LI>调用java.lang.Exception的带String,Throwable参数构造函数
	 * 
	 * @param cause
	 *            在子方法中可能出现的异常
	 * @version 1.0
	 * @author baiys
	 * @since 1.0
	 **************************************************************************/

	public AppException(Throwable cause) {
		super(AirBaseUtil.printStackTrace(cause));
	}

	
	
	
	
	
}
