package com.blbuyer.erp.vo;

import java.io.Serializable;


import io.swagger.annotations.ApiModelProperty;

public class SapSoItemVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "订单号", required = true)
	private String vbeln = "";
	
	@ApiModelProperty(value = "订单行编号")
	private String posnr = "";
	
	@ApiModelProperty(value = "物料", required = true)
	private String matnr = "";
	
	@ApiModelProperty(value = "订单数量", required = true)
	private String kwmeng = "";
	
	@ApiModelProperty(value = "价格", required = true)
	private String netwr = "";
	
	private String werks = "";
	
	private String vstel = "";
	
	private String route = "";
	
	private String prctr = "";
	
	private String vrkme = "";

	public String getVbeln() {
		return vbeln;
	}

	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}

	public String getPosnr() {
		return posnr;
	}

	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	public String getMatnr() {
		return matnr;
	}

	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}

	public String getKwmeng() {
		return kwmeng;
	}

	public void setKwmeng(String kwmeng) {
		this.kwmeng = kwmeng;
	}

	public String getNetwr() {
		return netwr;
	}

	public void setNetwr(String netwr) {
		this.netwr = netwr;
	}

	public String getWerks() {
		return werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	public String getVstel() {
		return vstel;
	}

	public void setVstel(String vstel) {
		this.vstel = vstel;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getPrctr() {
		return prctr;
	}

	public void setPrctr(String prctr) {
		this.prctr = prctr;
	}

	public String getVrkme() {
		return vrkme;
	}

	public void setVrkme(String vrkme) {
		this.vrkme = vrkme;
	}
	
	

}
