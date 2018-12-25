package com.blbuyer.erp.vo.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class WapSearchOrderRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "用户id", required = true)
	private String userId;
	
	@ApiModelProperty(value = "订单状态")
	private String orderStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
