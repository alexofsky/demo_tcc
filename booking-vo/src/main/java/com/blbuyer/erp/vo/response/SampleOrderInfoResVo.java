package com.blbuyer.erp.vo.response;

import java.io.Serializable;
import java.util.Date;

public class SampleOrderInfoResVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1128828623805022918L;

	
	private String id;
	private Date orderDate;
	private String orderType;
	private String orderNum;
	private Double amount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
