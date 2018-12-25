package com.blbuyer.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.blbuyer.core.logging.Logger;
import com.blbuyer.core.logging.LoggerUtils;
import com.blbuyer.erp.service.IntegrationService;
import com.blbuyer.erp.service.SampleOrderService;
import com.blbuyer.erp.util.CompensationThread;
import com.blbuyer.erp.util.ExecutorServiceUtil;
import com.blbuyer.erp.vo.MythInvocation;

@Service
public class IntegrationServiceImpl implements IntegrationService{
	private static final Logger LOGGER = LoggerUtils.getLogger(IntegrationServiceImpl.class);
	
	@Autowired
	SampleOrderService sampleOrderService;
	
	@Autowired
	private RestOperations restTemplate;
	
	@Value("${hotel.service.address:http://localhost:10201}")
	private String hotelServiceUrl;
	
	public boolean integration(Integer orderamount, Integer rooms) {
		boolean res = false;
		List<MythInvocation> invocations = new ArrayList<MythInvocation>();
		try {
			String orderId = sampleOrderService.createOrder(orderamount);
			Class[] parameterTypes = {String.class}; 
			Object[] args = {orderId};
			MythInvocation invocation = new MythInvocation(SampleOrderService.class, "cancelCreateOrder", parameterTypes, args);
			invocations.add(invocation);
			ResponseEntity<String> response =  restTemplate.postForEntity(hotelServiceUrl + "/room/"+rooms, null, String.class, rooms);
			Class[] parameterTypes1 = {String.class}; 
			Object[] args1 = {response.getBody()};
			invocation = new MythInvocation(SampleOrderService.class, "cancelCreateRoom", parameterTypes1, args1);
			invocations.add(invocation);
			if(rooms >200) {
				throw new RuntimeException("rooms > 200");
			}
			res = true;
			
		}catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			throw ex;
			
		}finally {
			if(!res && !invocations.isEmpty()) {
				ExecutorServiceUtil.cachedThreadPool.execute(new CompensationThread(invocations));
			}
		}
		return res;
	}
}
