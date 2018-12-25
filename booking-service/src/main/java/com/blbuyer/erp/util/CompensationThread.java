package com.blbuyer.erp.util;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang.reflect.MethodUtils;

import com.blbuyer.core.logging.Logger;
import com.blbuyer.core.logging.LoggerUtils;
import com.blbuyer.erp.helper.SpringBeanUtils;
import com.blbuyer.erp.vo.MythInvocation;

public class CompensationThread implements Runnable {

	private static final Logger LOGGER = LoggerUtils.getLogger(CompensationThread.class);

	private List<MythInvocation> invocations;

	public CompensationThread(List<MythInvocation> invocations) {
		this.invocations = invocations;
	}

	@Override
	public void run() {
		try {
			executeLocalTransaction(invocations);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
	}

	private void executeLocalTransaction(List<MythInvocation> invocations) throws Exception {
		for (MythInvocation mythInvocation : invocations) {
			try {
				if (Objects.nonNull(mythInvocation)) {
					final Class clazz = mythInvocation.getTargetClass();
					final String method = mythInvocation.getMethodName();
					final Object[] args = mythInvocation.getArgs();
					final Class[] parameterTypes = mythInvocation.getParameterTypes();
					final Object bean = SpringBeanUtils.getInstance().getBean(clazz);
					MethodUtils.invokeMethod(bean, method, args, parameterTypes);
					LOGGER.info("执行本地补偿事务:{}", mythInvocation.getTargetClass() + ":" + mythInvocation.getMethodName());

				}
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}
	}

}
