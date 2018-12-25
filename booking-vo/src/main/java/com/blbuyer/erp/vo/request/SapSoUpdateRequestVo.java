package com.blbuyer.erp.vo.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SapSoUpdateRequestVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ApiModelProperty(value = "订单号", required = true)
	private String vbeln;


	public String getVbeln() {
		return vbeln;
	}


	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}
	
	
	
	
	
	
}
