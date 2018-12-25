package com.blbuyer.erp.vo.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class WapOrderDailyReportResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7112897873251191545L;

	@ApiModelProperty(value = "日期", required = true)
	private String daytime;
	
	@ApiModelProperty(value = "销售总额", required = true)
	private Double totalAmount;

	public String getDaytime() {
		return daytime;
	}

	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
