package com.blbuyer.erp.vo.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.blbuyer.erp.vo.WapOrderItemVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class WapSearchOrderResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7112897873251191545L;

	@ApiModelProperty(value = "订单id", required = true)
	private String orderId;
	
	@ApiModelProperty(value = "订单总额", required = true)
	private Double totalAmount;
	
	@ApiModelProperty(value = "订单行", required = true)
	private List<WapOrderItemVo> orderItems;
	
	@ApiModelProperty(value = "创建日期", required = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	@ApiModelProperty(value = "订单状态:1已创建,2已发送ERP,3发送ERP失败,4已发货", required = true)
	private int orderStatus;
	
	
	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	


	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public List<WapOrderItemVo> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<WapOrderItemVo> orderItems) {
		this.orderItems = orderItems;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
