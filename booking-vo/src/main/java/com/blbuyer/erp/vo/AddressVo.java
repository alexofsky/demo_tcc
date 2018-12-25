package com.blbuyer.erp.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class AddressVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "用户id", required = true)
	private String userId;
	
	@ApiModelProperty(value = "用户名", required = true)
	private String username;
	
	@ApiModelProperty(value = "用户手机号", required = true)
	private String mobile;
	
	@ApiModelProperty(value = "省份code", required = true)
	private String provinceCode;
	
	@ApiModelProperty(value = "省份name", required = true)
	private String provinceName;
	
	@ApiModelProperty(value = "详细地址")
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	
	
}
