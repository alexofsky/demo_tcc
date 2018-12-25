package com.blbuyer.erp.vo.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class WapSearchAddressRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "用户id", required = true)
	private String userId;


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
