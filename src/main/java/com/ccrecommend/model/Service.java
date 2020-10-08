package com.ccrecommend.model;

public class Service {
	private java.lang.String centreCode;
	private java.lang.Float fee;
	private java.lang.String feeRange;
	private java.lang.String studyLevel;
	private java.lang.String typeOfCitizenship;
	private java.lang.String typeOfService;

	public Service() {}
	
	public java.lang.String getCentreCode() {
		return this.centreCode;
	}

	public void setCentreCode(java.lang.String centreCode) {
		this.centreCode = centreCode;
	}

	public java.lang.Float getFee() {
		return this.fee;
	}

	public void setFee(java.lang.Float fee) {
		this.fee = fee;
	}

	public java.lang.String getFeeRange() {
		return this.feeRange;
	}

	public void setFeeRange(java.lang.String feeRange) {
		this.feeRange = feeRange;
	}

	public java.lang.String getStudyLevel() {
		return this.studyLevel;
	}

	public void setStudyLevel(java.lang.String studyLevel) {
		this.studyLevel = studyLevel;
	}

	public java.lang.String getTypeOfCitizenship() {
		return this.typeOfCitizenship;
	}

	public void setTypeOfCitizenship(java.lang.String typeOfCitizenship) {
		this.typeOfCitizenship = typeOfCitizenship;
	}

	public java.lang.String getTypeOfService() {
		return this.typeOfService;
	}

	public void setTypeOfService(java.lang.String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public Service(java.lang.String centreCode, java.lang.Float fee,
			java.lang.String feeRange, java.lang.String studyLevel,
			java.lang.String typeOfCitizenship, java.lang.String typeOfService) {
		this.centreCode = centreCode;
		this.fee = fee;
		this.feeRange = feeRange;
		this.studyLevel = studyLevel;
		this.typeOfCitizenship = typeOfCitizenship;
		this.typeOfService = typeOfService;
	}
}

