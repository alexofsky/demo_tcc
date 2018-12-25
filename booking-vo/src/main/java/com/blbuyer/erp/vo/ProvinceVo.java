package com.blbuyer.erp.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ProvinceVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "省份code", required = true)
	private String provinceCode;
	
	@ApiModelProperty(value = "省份name", required = true)
	private String provinceName;

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
