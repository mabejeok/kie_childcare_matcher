package com.ccrecommend.model;

import java.util.Map;
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ChildcareCollection {
	private java.util.Set<com.ccrecommend.model.Childcare> childcareList = new HashSet<com.ccrecommend.model.Childcare>();
	
	public ChildcareCollection() {}
	
	public java.util.Set<com.ccrecommend.model.Childcare> getChildcareList() {
		return this.childcareList;
	}
	
	public void setChildcareList(java.util.Set<com.ccrecommend.model.Childcare> childcareList) {
		this.childcareList = childcareList;
	}
	
	public ChildcareCollection(
		java.util.Set<com.ccrecommend.model.Childcare> childcareList) {
	this.childcareList = childcareList;
	}
	
	public void populateChildcares(java.util.List<com.ccrecommend.model.Service> serviceList) throws Exception{
		// Get the childcares from MySQL and add them into the childcareList
		HashMap<String, com.ccrecommend.model.Service> centreCodesDict = new HashMap<String, com.ccrecommend.model.Service>();
	
		serviceList.forEach((svc) -> {
			centreCodesDict.put(svc.getCentreCode(), svc);
		});
		
		MySQLAccess dao = new MySQLAccess();
        java.util.List<Map<String, String>> ccList = dao.readChildcares(new ArrayList<>(centreCodesDict.keySet()));
        
        ccList.forEach((currCc) -> {
        	 Childcare cc = createCC(currCc);
	         cc.setFee(centreCodesDict.get(currCc.get("centre_code")).getFee());
             cc.setStudyLevel(centreCodesDict.get(currCc.get("centre_code")).getStudyLevel());
             cc.setTypeOfCitizenship(centreCodesDict.get(currCc.get("centre_code")).getTypeOfCitizenship());
             cc.setTypeOfService(centreCodesDict.get(currCc.get("centre_code")).getTypeOfService());
             getChildcareList().add(cc);
        });
	}
	
	
	private static Childcare createCC(Map<String, String> ccDict){
		String centreCode = ccDict.get("centre_code");
		String centreName = ccDict.get("centre_name");
		String centreAddress = ccDict.get("centre_address");
		String postalCode = ccDict.get("postal_code");
		String infantVacancy = ccDict.get("infant_vacancy");
		String pgVacancy = ccDict.get("pg_vacancy");
		String n1Vacancy = ccDict.get("n1_vacancy");
		String n2Vacancy = ccDict.get("n2_vacancy");
		String k1Vacancy = ccDict.get("k1_vacancy");
		String k2Vacancy = ccDict.get("k2_vacancy");
		String food = ccDict.get("food_offered");
		String secondLanguage = ccDict.get("second_language");
		 
		Childcare cc = new Childcare();
		cc.setCentreCode(centreCode);
		cc.setCentreName(centreName);
		cc.setCentreAddress(centreAddress);
		cc.setPostalCode(postalCode);
		cc.setInfantVacancy(infantVacancy);
		cc.setPgVacancy(pgVacancy);
		cc.setN1Vacancy(n1Vacancy);
		cc.setN2Vacancy(n2Vacancy);
		cc.setK1Vacancy(k1Vacancy);
		cc.setK2Vacancy(k2Vacancy);
		cc.setFood(food);
		cc.setSecondLanguage(secondLanguage);
		return cc;
	}

}