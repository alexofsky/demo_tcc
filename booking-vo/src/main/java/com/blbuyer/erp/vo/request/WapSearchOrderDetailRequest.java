package com.blbuyer.erp.vo.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class WapSearchOrderDetailRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "orderId", required = true)
	private String orderId;


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	
	
}
