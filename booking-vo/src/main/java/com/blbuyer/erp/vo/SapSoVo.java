package com.blbuyer.erp.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SapSoVo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "订单号", required = true)
	private String vbeln = "";
	
	private String erdadt = "";
	
	private String erzet = "";
	
	private String kunnr = "";
	
	@ApiModelProperty(value = "客户名称", required = true)
	private String bstnk = "";
	
	private String ernam = "";
	
	private String audat = "";
	
	private String auart = "OR";
	
	private String waerk = "";
	
	private String vkorg = "";
	
	private String vtweg = "";
	
	private String spart = "";
	
	private String vdatu = "";
	
	private String kalsm = "";
	
	private SapSoItemListVo headtoitemnav;

	public String getVbeln() {
		return vbeln;
	}

	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}

	public String getErdadt() {
		return erdadt;
	}

	public void setErdadt(String erdadt) {
		this.erdadt = erdadt;
	}

	public String getErzet() {
		return erzet;
	}

	public void setErzet(String erzet) {
		this.erzet = erzet;
	}

	public String getKunnr() {
		return kunnr;
	}

	public void setKunnr(String kunnr) {
		this.kunnr = kunnr;
	}

	public String getBstnk() {
		return bstnk;
	}

	public void setBstnk(String bstnk) {
		this.bstnk = bstnk;
	}

	public String getErnam() {
		return ernam;
	}

	public void setErnam(String ernam) {
		this.ernam = ernam;
	}

	public String getAudat() {
		return audat;
	}

	public void setAudat(String audat) {
		this.audat = audat;
	}

	public String getAuart() {
		return auart;
	}

	public void setAuart(String auart) {
		this.auart = auart;
	}

	public String getWaerk() {
		return waerk;
	}

	public void setWaerk(String waerk) {
		this.waerk = waerk;
	}

	public String getVkorg() {
		return vkorg;
	}

	public void setVkorg(String vkorg) {
		this.vkorg = vkorg;
	}

	public String getVtweg() {
		return vtweg;
	}

	public void setVtweg(String vtweg) {
		this.vtweg = vtweg;
	}

	public String getSpart() {
		return spart;
	}

	public void setSpart(String spart) {
		this.spart = spart;
	}

	public String getVdatu() {
		return vdatu;
	}

	public void setVdatu(String vdatu) {
		this.vdatu = vdatu;
	}

	public String getKalsm() {
		return kalsm;
	}

	public void setKalsm(String kalsm) {
		this.kalsm = kalsm;
	}

	public SapSoItemListVo getHeadtoitemnav() {
		return headtoitemnav;
	}

	public void setHeadtoitemnav(SapSoItemListVo headtoitemnav) {
		this.headtoitemnav = headtoitemnav;
	}
	
	
	
	
	
}
