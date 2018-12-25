package com.blbuyer.erp.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.blbuyer.erp.helper.SpringBeanUtils;

@Component
public class ApplicationContextRegister implements ApplicationContextAware{

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		SpringBeanUtils.getInstance().setCfgContext((ConfigurableApplicationContext) applicationContext);
	}

}
