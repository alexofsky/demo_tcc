package com.blbuyer.erp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import com.blbuyer.core.logging.Logger;
import com.blbuyer.core.logging.LoggerUtils;
import com.blbuyer.erp.BasicServiceApplication;
import com.blbuyer.erp.config.RedisCacheConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BasicServiceApplication.class)
public class RedisServiceTest {

	private static final Logger LOGGER = LoggerUtils.getLogger(RedisServiceTest.class);
	@Autowired
	RedisCacheConfiguration redisCacheConfiguration;
	
	private final static String WapOrderIdCacheKey = "wap_order_id";
	
	private int minOrderId = 5010000;

	@Test
	public void testOrderCachekey() {
		try {
			LOGGER.info("orderId:{}",getOrderId());
			
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}

	}
	
	private int getOrderId() {
		int orderId = 0;
		
		String cachedOrderId = redisCacheConfiguration.getStringCacheKey(WapOrderIdCacheKey);
		if(StringUtils.isEmpty(cachedOrderId)) {
			orderId = minOrderId;
			redisCacheConfiguration.setStringCacheKey(WapOrderIdCacheKey, orderId+"");
		}else if(Integer.parseInt(cachedOrderId) < minOrderId){
			orderId = minOrderId;
			redisCacheConfiguration.setStringCacheKey(WapOrderIdCacheKey, orderId+"");
		}else {
			orderId = redisCacheConfiguration.increment(WapOrderIdCacheKey, 1);
		}
		
		return orderId;
	}

	

}
