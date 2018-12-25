package com.blbuyer.erp.vo.request;

import java.io.Serializable;
import java.util.List;

import com.blbuyer.erp.vo.WapOrderItemVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class WapPlaceOrderRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7112897873251191545L;

	@ApiModelProperty(value = "用户id", required = true)
	private String userId;
	
	@ApiModelProperty(value = "用户名", required = true)
	private String username;
	
	@ApiModelProperty(value = "用户手机号", required = true)
	private String mobile;
	
	@ApiModelProperty(value = "省份code", required = true)
	private String provinceCode;
	
	@ApiModelProperty(value = "省份名称", required = true)
	private String provinceName;
	
	@ApiModelProperty(value = "详细地址")
	private String address;
	
	@ApiModelProperty(value = "订单总额", required = true)
	private Double totalAmount;
	
	
	@ApiModelProperty(value = "订单行", required = true)
	private List<WapOrderItemVo> orderItems;


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProvinceCode() {
		return provinceCode;
	}


	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}


	public String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public List<WapOrderItemVo> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<WapOrderItemVo> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
