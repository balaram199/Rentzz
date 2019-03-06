package com.grabasset.csr.bo;

import java.util.Date;

public class AddressBo {
	private int addressId;
	private String addressLine1;
	private String addressLine2;
	private int city;
	private int state;
	private int country;
	private int zip;
	private String createdBy;
	private Date cratedDt;
	private String lastmodifiedBy;
	private Date lastmodifiedDt;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCratedDt() {
		return cratedDt;
	}

	public void setCratedDt(Date cratedDt) {
		this.cratedDt = cratedDt;
	}

	public String getLastmodifiedBy() {
		return lastmodifiedBy;
	}

	public void setLastmodifiedBy(String lastmodifiedBy) {
		this.lastmodifiedBy = lastmodifiedBy;
	}

	public Date getLastmodifiedDt() {
		return lastmodifiedDt;
	}

	public void setLastmodifiedDt(Date lastmodifiedDt) {
		this.lastmodifiedDt = lastmodifiedDt;
	}

}
