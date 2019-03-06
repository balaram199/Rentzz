package com.grabasset.csr.bo;

import java.util.Date;

public class UserDetailsBo {
	private int SystemUserId;
	private String IdentificationNo;
	private String IdentifictionType;
	private int UserAddressId;
	private String createdBy;
	private Date createdDate;
	private String lastModifiedBy;
	private Date ModifiedDate;

	public int getSystemUserId() {
		return SystemUserId;
	}

	public void setSystemUserId(int systemUserId) {
		SystemUserId = systemUserId;
	}

	public String getIdentificationNo() {
		return IdentificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		IdentificationNo = identificationNo;
	}

	public String getIdentifictionType() {
		return IdentifictionType;
	}

	public void setIdentifictionType(String identifictionType) {
		IdentifictionType = identifictionType;
	}

	public int getUserAddressId() {
		return UserAddressId;
	}

	public void setUserAddressId(int userAddressId) {
		UserAddressId = userAddressId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}
}
