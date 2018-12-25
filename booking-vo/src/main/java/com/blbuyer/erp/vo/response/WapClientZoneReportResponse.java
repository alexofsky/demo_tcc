package com.blbuyer.erp.vo.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class WapClientZoneReportResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7112897873251191545L;

	
	@ApiModelProperty(value = "省份", required = true)
	private String province;
	
	@ApiModelProperty(value = "销售总额", required = true)
	private Double totalAmount;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
