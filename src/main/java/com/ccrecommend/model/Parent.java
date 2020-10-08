package com.ccrecommend.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Parent {
	private java.lang.String feeRange;
	private java.util.List<com.ccrecommend.model.Service> serviceList = new ArrayList<com.ccrecommend.model.Service>();
	private java.util.List<com.ccrecommend.model.Service> otherServiceList = new ArrayList<com.ccrecommend.model.Service>();
	private java.lang.String location;
	private java.lang.String distance;
	private java.lang.String language;
	private java.lang.String dietaryRestrictions;
	private java.lang.String studyLevel;
	private java.lang.String vacancy;
	private java.util.Date enrolmentDate;
	private java.lang.String childName;
	private java.util.Date childBirthDate;
	private java.lang.String childId;
	private java.lang.String typeOfCitizenship;
	private java.lang.String service;
	private java.util.List<com.ccrecommend.model.Childcare> childcareList  = new ArrayList<com.ccrecommend.model.Childcare>();
	private java.util.List<com.ccrecommend.model.Childcare> otherChildcareList  = new ArrayList<com.ccrecommend.model.Childcare>();
	
	public Parent() {}
	
	public void setFeeRange(java.lang.String feeRange) {
		this.feeRange = feeRange;
	}
	
	public java.lang.String getFeeRange() {
		return this.feeRange;
	}
	
	public java.util.List<com.ccrecommend.model.Service> getServiceList() {
		return this.serviceList;
	}

	public void setServiceList(
			java.util.List<com.ccrecommend.model.Service> serviceList) {
		this.serviceList = serviceList;
	}

	public void addService(com.ccrecommend.model.Service svc) {
		getServiceList().add(svc);
	}
	
	public java.util.List<com.ccrecommend.model.Service> getOtherServiceList() {
		return this.otherServiceList;
	}
	
	public void setOtherServiceList(
			java.util.List<com.ccrecommend.model.Service> serviceList) {
		this.otherServiceList = serviceList;
	}

	public void addOtherService(com.ccrecommend.model.Service svc) {
		getOtherServiceList().add(svc);
	}

	public java.lang.String getLocation() {
		return this.location;
	}

	public void setLocation(java.lang.String location) {
		this.location = location;
	}

	public java.lang.String getDistance() {
		return this.distance;
	}

	public void setDistance(java.lang.String distance) {
		this.distance = distance;
	}

	public java.lang.String getLanguage() {
		return this.language;
	}

	public void setLanguage(java.lang.String language) {
		this.language = language;
	}

	public java.lang.String getDietaryRestrictions() {
		return this.dietaryRestrictions;
	}

	public void setDietaryRestrictions(java.lang.String dietaryRestrictions) {
		this.dietaryRestrictions = dietaryRestrictions;
	}

	public java.lang.String getStudyLevel() {
		return this.studyLevel;
	}

	public void setStudyLevel(java.lang.String studyLevel) {
		this.studyLevel = studyLevel;
	}

	public java.lang.String getVacancy() {
		return this.vacancy;
	}

	public void setVacancy(java.lang.String vacancy) {
		this.vacancy = vacancy;
	}

	public java.util.Date getEnrolmentDate() {
		return this.enrolmentDate;
	}

	public void setEnrolmentDate(java.util.Date enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}

	public java.lang.String getChildName() {
		return this.childName;
	}

	public void setChildName(java.lang.String childName) {
		this.childName = childName;
	}

	public java.util.Date getChildBirthDate() {
		return this.childBirthDate;
	}

	public void setChildBirthDate(java.util.Date childBirthDate) {
		this.childBirthDate = childBirthDate;
	}
	
	public void addChildcare(com.ccrecommend.model.Childcare cc) {
		getChildcareList().add(cc);
	}
	
	public void addOtherChildcare(com.ccrecommend.model.Childcare cc) {
		getOtherChildcareList().add(cc);
	}
	
	public java.lang.String getChildId() {
		return this.childId;
	}

	public void setChildId(java.lang.String childId) {
		this.childId = childId;
	}

	public java.lang.String getTypeOfCitizenship() {
		return this.typeOfCitizenship;
	}

	public void setTypeOfCitizenship(java.lang.String typeOfCitizenship) {
		this.typeOfCitizenship = typeOfCitizenship;
	}

	public java.lang.String getService() {
		return this.service;
	}

	public void setService(java.lang.String service) {
		this.service = service;
	}

	public java.util.List<com.ccrecommend.model.Childcare> getChildcareList() {
		return this.childcareList;
	}

	public void setChildcareList(
			java.util.List<com.ccrecommend.model.Childcare> childcareList) {
		this.childcareList = childcareList;
	}
	
	public java.util.List<com.ccrecommend.model.Childcare> getOtherChildcareList() {
		return this.otherChildcareList;
	}

	public void setOtherChildcareList(
			java.util.List<com.ccrecommend.model.Childcare> childcareList) {
		this.otherChildcareList = childcareList;
	}

	public Parent(java.lang.String feeRange,
			java.util.List<com.ccrecommend.model.Service> serviceList,
			java.lang.String location, java.lang.String distance,
			java.lang.String language, java.lang.String dietaryRestrictions,
			java.lang.String studyLevel, java.lang.String vacancy,
			java.util.Date enrolmentDate, java.lang.String childName,
			java.util.Date childBirthDate, java.lang.String childId,
			java.lang.String typeOfCitizenship, java.lang.String service,
			java.util.List<com.ccrecommend.model.Childcare> childcareList) {
		this.feeRange = feeRange;
		this.serviceList = serviceList;
		this.location = location;
		this.distance = distance;
		this.language = language;
		this.dietaryRestrictions = dietaryRestrictions;
		this.studyLevel = studyLevel;
		this.vacancy = vacancy;
		this.enrolmentDate = enrolmentDate;
		this.childName = childName;
		this.childBirthDate = childBirthDate;
		this.childId = childId;
		this.typeOfCitizenship = typeOfCitizenship;
		this.service = service;
		this.childcareList = childcareList;
	}
	
	public Parent(java.lang.String feeRange,
			java.lang.String location, java.lang.String distance,
			java.lang.String language, java.lang.String dietaryRestrictions,
			java.util.Date enrolmentDate, java.lang.String childName,
			java.util.Date childBirthDate, java.lang.String childId,
			java.lang.String typeOfCitizenship, java.lang.String service) {
		this.feeRange = feeRange;
		this.location = location;
		this.distance = distance;
		this.language = language;
		this.dietaryRestrictions = dietaryRestrictions;
		this.enrolmentDate = enrolmentDate;
		this.childName = childName;
		this.childBirthDate = childBirthDate;
		this.childId = childId;
		this.typeOfCitizenship = typeOfCitizenship;
		this.service = service;
		
		populateParent();
	}
	
	public Parent(java.lang.String feeRange,
			java.lang.String location, java.lang.String distance,
			java.lang.String language, java.lang.String dietaryRestrictions,
			java.util.Date enrolmentDate, java.util.Date childBirthDate, 
			java.lang.String typeOfCitizenship, java.lang.String service) {
		this.feeRange = feeRange;
		this.location = location;
		this.distance = distance;
		this.language = language;
		this.dietaryRestrictions = dietaryRestrictions;
		this.enrolmentDate = enrolmentDate;
		this.childBirthDate = childBirthDate;
		this.typeOfCitizenship = typeOfCitizenship;
		this.service = service;
		
		populateParent();
	}
	
	public void populateParent() {
		// Populate study level
		float diffInYears = (float) Duration
				.between(getChildBirthDate().toInstant(),
						getEnrolmentDate().toInstant()).toDays() / 365;
		if (diffInYears < 2 && diffInYears > 1) {
			int diffInMonths = (int) (diffInYears * 12);
			if (diffInMonths <= 18) {
				setStudyLevel("Infant");
			} else {
				setStudyLevel("Playgroup");
			}
		} else {
			switch ((int) diffInYears) {
				case 0 :
					setStudyLevel("Infant");
					break;
				case 1 :
					setStudyLevel("Infant");
					break;
				case 2 :
					setStudyLevel("Playgroup");
					break;
				case 3 :
					setStudyLevel("Pre-Nursery");
					break;
				case 4 :
					setStudyLevel("Nursery");
					break;
				case 5 :
					setStudyLevel("Kindergarten 1");
					break;
				case 6 :
					setStudyLevel("Kindergarten 2");
					break;
				default :
					setStudyLevel("N.A.");

			}
		}

		// Populate vacancy
		float yearsFromNow = (float) Duration.between(new Date().toInstant(),
				enrolmentDate.toInstant()).toDays() / 365;
		if (yearsFromNow < (2 / 12)) {
			setVacancy("Immediate");
		} else if (yearsFromNow < 1) {
			setVacancy("Within 1 Year");
		} else {
			setVacancy("More than 1 Year");
		}
	}
	
}
