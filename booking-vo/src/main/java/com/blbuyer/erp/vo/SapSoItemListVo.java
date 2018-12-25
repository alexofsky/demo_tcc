package com.blbuyer.erp.vo;

import java.io.Serializable;
import java.util.List;

public class SapSoItemListVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SapSoItemVo> results;

	public List<SapSoItemVo> getResults() {
		return results;
	}

	public void setResults(List<SapSoItemVo> results) {
		this.results = results;
	}
	
	
	

}
