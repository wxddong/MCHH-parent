package com.threefiveninetong.mchh.core.handler;

import java.util.concurrent.ConcurrentHashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemMonitor implements MethodInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(SystemMonitor.class);
	private static ConcurrentHashMap<String, MethodStats> methodStats = new ConcurrentHashMap<String, MethodStats>();
	//超过多少秒警告
	private  long methodWarningThreshold;
	public long getMethodWarningThreshold() {
		return methodWarningThreshold;
	}

	public void setMethodWarningThreshold(long methodWarningThreshold) {
		this.methodWarningThreshold = methodWarningThreshold;
	}

	public Object invoke(MethodInvocation method) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			return method.proceed();
		} finally {
			updateStats(method.getMethod().getDeclaringClass()+":"+method.getMethod().getName(), (System
					.currentTimeMillis() - start));
		}
	}

	private void updateStats(String methodName, long elapsedTime) {
		MethodStats stats = methodStats.get(methodName);
		if (stats == null) {
			stats = new MethodStats(methodName);
			methodStats.put(methodName, stats);
		}
		stats.count++;
		stats.totalTime += elapsedTime;
		if (elapsedTime > stats.maxTime) {
			stats.maxTime = elapsedTime;
		}

		if (elapsedTime > methodWarningThreshold) {
			long avgTime = stats.totalTime / stats.count;
			/*logger.warn("method warning: " + methodName + "(), 方法执行次数 = "
					+ stats.count + ", 执行时间 = " + elapsedTime
					+ ", 最大执行时间 = " + stats.maxTime);*/
			logger.warn("method: " + methodName + "(), 方法执行次数 = " + stats.count
					+ ", 执行时间 = " + elapsedTime + ", 平均执行时间 = " + avgTime
					+ ", 最大执行时间 = "
					+ stats.maxTime);
		}else{
			long avgTime = stats.totalTime / stats.count;
			/*long runningAvg = (stats.totalTime - stats.lastTotalTime)
					/ statLogFrequency;*/
			logger.info("method: " + methodName + "(), 方法执行次数 = " + stats.count
					+ ", 执行时间 = " + elapsedTime + ", 平均执行时间 = " + avgTime
					+ ", 最大执行时间 = "
					+ stats.maxTime);

			// reset the last total time
			stats.lastTotalTime = stats.totalTime;
		}

	/*	if (stats.count % statLogFrequency == 0) {
			long avgTime = stats.totalTime / stats.count;
			long runningAvg = (stats.totalTime - stats.lastTotalTime)
					/ statLogFrequency;
			logger.info("method: " + methodName + "(), 方法执行次数 = " + stats.count
					+ ", 执行时间 = " + elapsedTime + ", 平均执行时间 = " + avgTime
					+ ", 最大执行时间 = "
					+ stats.maxTime);

			// reset the last total time
			stats.lastTotalTime = stats.totalTime;
		}*/
	}

	class MethodStats {
		public String methodName; //方法名
		public long count; //总调用次数
		public long totalTime; //总执行时间
		public long lastTotalTime;
		public long maxTime;

		public MethodStats(String methodName) {
			this.methodName = methodName;
		}
	}

	
}
