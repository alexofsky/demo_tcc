package com.blbuyer.erp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheConfiguration {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public RedisCacheConfiguration() {
	}

	public  int decrement(String key, int delta) {
        Long value = stringRedisTemplate.opsForValue().increment(key, -delta);
        return value.intValue();
    }

    public  int increment(String key, int delta) {
        Long value = stringRedisTemplate.opsForValue().increment(key, delta);
        return value.intValue();
    }
    
    public  String getStringCacheKey(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    
    public  void setStringCacheKey(String key,String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }

}
