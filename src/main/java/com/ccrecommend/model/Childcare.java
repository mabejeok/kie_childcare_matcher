package com.ccrecommend.model;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.parser.ParseException;

public class Childcare {
	private java.lang.String centreCode;
	private java.lang.String centreName;
	private java.lang.String centreAddress;
	private java.lang.String postalCode;
	private java.lang.String infantVacancy;
	private java.lang.String pgVacancy;
	private java.lang.String n1Vacancy;
	private java.lang.String n2Vacancy;
	private java.lang.String k1Vacancy;
	private java.lang.String k2Vacancy;
	private java.lang.String food;
	private java.lang.String secondLanguage;
	private java.lang.Float fee;
	private java.lang.String studyLevel;
	private java.lang.String typeOfCitizenship;
	private java.lang.String typeOfService;
	private float distance;

	public Childcare() {}

	public java.lang.String getCentreCode() {
		return this.centreCode;
	}

	public void setCentreCode(java.lang.String centreCode) {
		this.centreCode = centreCode;
	}

	public java.lang.String getCentreName() {
		return this.centreName;
	}

	public void setCentreName(java.lang.String centreName) {
		this.centreName = centreName;
	}

	public java.lang.String getCentreAddress() {
		return this.centreAddress;
	}

	public void setCentreAddress(java.lang.String centreAddress) {
		this.centreAddress = centreAddress;
	}

	public java.lang.String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(java.lang.String postalCode) {
		this.postalCode = postalCode;
	}

	public java.lang.String getInfantVacancy() {
		return this.infantVacancy;
	}

	public void setInfantVacancy(java.lang.String infantVacancy) {
		this.infantVacancy = infantVacancy;
	}

	public java.lang.String getPgVacancy() {
		return this.pgVacancy;
	}

	public void setPgVacancy(java.lang.String pgVacancy) {
		this.pgVacancy = pgVacancy;
	}

	public java.lang.String getN1Vacancy() {
		return this.n1Vacancy;
	}

	public void setN1Vacancy(java.lang.String n1Vacancy) {
		this.n1Vacancy = n1Vacancy;
	}

	public java.lang.String getN2Vacancy() {
		return this.n2Vacancy;
	}

	public void setN2Vacancy(java.lang.String n2Vacancy) {
		this.n2Vacancy = n2Vacancy;
	}

	public java.lang.String getK1Vacancy() {
		return this.k1Vacancy;
	}

	public void setK1Vacancy(java.lang.String k1Vacancy) {
		this.k1Vacancy = k1Vacancy;
	}

	public java.lang.String getK2Vacancy() {
		return this.k2Vacancy;
	}

	public void setK2Vacancy(java.lang.String k2Vacancy) {
		this.k2Vacancy = k2Vacancy;
	}

	public java.lang.String getFood() {
		return this.food;
	}

	public void setFood(java.lang.String food) {
		this.food = food;
	}

	public java.lang.String getSecondLanguage() {
		return this.secondLanguage;
	}

	public void setSecondLanguage(java.lang.String secondLanguage) {
		this.secondLanguage = secondLanguage;
	}

	public java.lang.Float getFee() {
		return this.fee;
	}

	public void setFee(java.lang.Float fee) {
		this.fee = fee;
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
	
	public float getDistance() {
		return this.distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public void computeDistance(String parentAddress, String parentDistance, String postalList) throws URISyntaxException, IOException, ParseException {
		String googleApiKey = "AIzaSyC-RKwFKudeyJ8hKmg-GE_MdmnxHlpx8OU"; // Your Google API key
		String[] postalStrings = postalList.split(", ");

		try {
			if(this.postalCode != null) {
				if(parentDistance == "Any") {
					if(Arrays.stream(postalStrings).anyMatch(this.postalCode.substring(0, 2):: equals)) {
						this.setDistance(3);
					} else {
						this.setDistance(-1);
					}
				} else {
					if(Arrays.stream(postalStrings).anyMatch(this.postalCode.substring(0, 2):: equals)) {
						try {
							JsonService jSvc = new JsonService(
									"https://maps.googleapis.com/maps/api/distancematrix/json?units=metrics",
									"key=" + googleApiKey,
									"origins=" + parentAddress,
									"destinations=" + this.postalCode
									);
							String strDistance = jSvc.getJson().replace("km","").replace(",","");
							this.setDistance(Float.parseFloat(strDistance));
						} catch (UnknownHostException e) {
							this.setDistance(Float.parseFloat(parentDistance.substring(2,3)));
						}
					} else {
						this.setDistance(-1);
					}
				}
			} else {
				this.setDistance(-1);
			}
		} catch (SocketTimeoutException e) {
			this.setDistance(-1);
		}
		
	}

	public Childcare(java.lang.String centreCode, java.lang.String centreName,
			java.lang.String centreAddress, java.lang.String postalCode,
			java.lang.String infantVacancy, java.lang.String pgVacancy,
			java.lang.String n1Vacancy, java.lang.String n2Vacancy,
			java.lang.String k1Vacancy, java.lang.String k2Vacancy,
			java.lang.String food, java.lang.String secondLanguage,
			java.lang.Float fee, java.lang.String studyLevel,
			java.lang.String typeOfCitizenship, java.lang.String typeOfService) {
		this.centreCode = centreCode;
		this.centreName = centreName;
		this.centreAddress = centreAddress;
		this.postalCode = postalCode;
		this.infantVacancy = infantVacancy;
		this.pgVacancy = pgVacancy;
		this.n1Vacancy = n1Vacancy;
		this.n2Vacancy = n2Vacancy;
		this.k1Vacancy = k1Vacancy;
		this.k2Vacancy = k2Vacancy;
		this.food = food;
		this.secondLanguage = secondLanguage;
		this.fee = fee;
		this.studyLevel = studyLevel;
		this.typeOfCitizenship = typeOfCitizenship;
		this.typeOfService = typeOfService;
	}

}
