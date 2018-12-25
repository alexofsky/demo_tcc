package com.blbuyer.erp.vo.request;

import java.io.Serializable;
import java.util.List;

import com.blbuyer.erp.vo.SapPoHeadVo;
import com.blbuyer.erp.vo.SapPoItemVo;

public class SapPoRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7112897873251191545L;

	private SapPoHeadVo head;
	
	private List<SapPoItemVo> item;

	public SapPoHeadVo getHead() {
		return head;
	}

	public void setHead(SapPoHeadVo head) {
		this.head = head;
	}

	public List<SapPoItemVo> getItem() {
		return item;
	}

	public void setItem(List<SapPoItemVo> item) {
		this.item = item;
	}
	
	
}
