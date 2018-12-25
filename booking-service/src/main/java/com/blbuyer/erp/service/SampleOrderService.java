package com.blbuyer.erp.service;

public interface SampleOrderService {

	public String createOrder(Integer orderamount);
	public void cancelCreateOrder(String orderId);
	
	public String createRoom(Integer rooms);
	public void cancelCreateRoom(String roomId);
	
}
