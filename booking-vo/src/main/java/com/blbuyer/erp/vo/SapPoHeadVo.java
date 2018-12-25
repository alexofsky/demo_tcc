package com.blbuyer.erp.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SapPoHeadVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7572070273048738025L;
	@DateTimeFormat(pattern = "yyyyMMdd")
    @JsonFormat(pattern = "yyyyMMdd")
	private Date aedat;
	private String bsakz;
	private String bsart;
	private String bstyp;
	private String bukrs;
	private String ebeln;
	private String ekgrp;
	private String ekorg;
	private String ernam;
	private String lifnr;
	private String loekz;
	private String statu;
	private String waers;
	
	public Date getAedat() {
		return aedat;
	}
	public void setAedat(Date aedat) {
		this.aedat = aedat;
	}
	public String getBsakz() {
		return bsakz;
	}
	public void setBsakz(String bsakz) {
		this.bsakz = bsakz;
	}
	public String getBsart() {
		return bsart;
	}
	public void setBsart(String bsart) {
		this.bsart = bsart;
	}
	public String getBstyp() {
		return bstyp;
	}
	public void setBstyp(String bstyp) {
		this.bstyp = bstyp;
	}
	public String getBukrs() {
		return bukrs;
	}
	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}
	public String getEbeln() {
		return ebeln;
	}
	public void setEbeln(String ebeln) {
		this.ebeln = ebeln;
	}
	public String getEkgrp() {
		return ekgrp;
	}
	public void setEkgrp(String ekgrp) {
		this.ekgrp = ekgrp;
	}
	public String getEkorg() {
		return ekorg;
	}
	public void setEkorg(String ekorg) {
		this.ekorg = ekorg;
	}
	public String getErnam() {
		return ernam;
	}
	public void setErnam(String ernam) {
		this.ernam = ernam;
	}
	public String getLifnr() {
		return lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}
	public String getLoekz() {
		return loekz;
	}
	public void setLoekz(String loekz) {
		this.loekz = loekz;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getWaers() {
		return waers;
	}
	public void setWaers(String waers) {
		this.waers = waers;
	}
	
	
}
