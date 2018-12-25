package com.blbuyer.erp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blbuyer.core.logging.Logger;
import com.blbuyer.core.logging.LoggerUtils;
import com.blbuyer.erp.service.IntegrationService;
import com.blbuyer.erp.service.SampleOrderService;

import io.swagger.annotations.ApiOperation;

@RestController
public class IntegrateController {
	private static final Logger LOGGER = LoggerUtils.getLogger(IntegrateController.class);

	@Autowired
	SampleOrderService sampleOrderService;
	
	@Autowired
	IntegrationService integrationService;

	@ApiOperation(value = "booking")
	@PostMapping("/booking/{rooms}/{orderamount}")
	public String order(@PathVariable Integer rooms, @PathVariable Integer orderamount) {
		boolean res = integrationService.integration(orderamount, rooms);
		return res+"";
	}
	
	@ApiOperation(value = "room")
	@PostMapping("/room/{rooms}")
	public String order(@PathVariable Integer rooms) {
		return sampleOrderService.createRoom(rooms);
	}

}
