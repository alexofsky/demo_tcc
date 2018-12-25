package com.blbuyer.erp.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class WapOrderItemVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7112897873251191545L;

	@ApiModelProperty(value = "商品code", required = true)
	private String code;
	
	@ApiModelProperty(value = "商品名称", required = true)
	private String title;
	
	@ApiModelProperty(value = "商品数量", required = true)
	private String qty;
	
	@ApiModelProperty(value = "商品price", required = true)
	private Double price;
	
	@ApiModelProperty(value = "商品图片", required = true)
	private String pic;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
}
