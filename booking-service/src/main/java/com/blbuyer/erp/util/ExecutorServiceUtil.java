package com.blbuyer.erp.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceUtil {

	public static ExecutorService cachedThreadPool = null;
	
	static {
		if (cachedThreadPool == null) {
			cachedThreadPool = Executors.newCachedThreadPool();
		}
	}
	
	
	
}
