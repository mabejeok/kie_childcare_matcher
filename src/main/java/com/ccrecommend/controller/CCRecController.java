package com.ccrecommend.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccrecommend.model.Parent;
import com.ccrecommend.model.ServiceCollection;
import com.ccrecommend.model.Service;
import com.ccrecommend.model.Childcare;
import com.ccrecommend.model.ChildcareCollection;

import com.ccrecommend.service.CCRecService;

@RestController
public class CCRecController {

	private final CCRecService ccRecService;

	@Autowired
	public CCRecController(CCRecService ccRecService) {
		this.ccRecService = ccRecService;
	}

	@RequestMapping(value = "/addParent", method = RequestMethod.POST, produces = "application/json")
	public Parent getQuestions(@RequestParam(required = true) String feeRange, String location, 
			String distance, String language, String dietaryRestrictions, String enrolmentDateStr, 
			String childBirthdateStr, String citizenshipType, 
			String service, String postalList ) throws Exception {
		
	    Date enrolmentDate=new SimpleDateFormat("yyyy-MM-dd").parse(enrolmentDateStr);
	    Date childBirthdate=new SimpleDateFormat("yyyy-MM-dd").parse(childBirthdateStr);  

		Parent parent = new Parent(feeRange, location, distance, language, 
				dietaryRestrictions, enrolmentDate, childBirthdate, citizenshipType, service);
		ServiceCollection sc = new ServiceCollection();
		
		// When ServiceCollection is initialised, it will grab all the services from database
		// Then each svc object will be sent into the rules stream along with the parent obj
		// If it doesn't meet requirement it will get retracted
		for (Service $svc: sc.getServiceList()){
			Service $svcObj = new Service();
			$svcObj.setCentreCode( $svc.getCentreCode() );
			$svcObj.setFee( $svc.getFee() );
			$svcObj.setFeeRange( $svc.getFeeRange() );
			$svcObj.setStudyLevel( $svc.getStudyLevel() );
			$svcObj.setTypeOfCitizenship( $svc.getTypeOfCitizenship() );
			$svcObj.setTypeOfService( $svc.getTypeOfService() );
			parent = ccRecService.filterServices($svcObj, parent);
		}
		
		// The main services will be used to match with childcares
		// childcares that get matched will go into ChildcareCollection
		ChildcareCollection ccc = new ChildcareCollection();
		ccc.populateChildcares( parent.getServiceList() );
		
		// The childcares from the collection will be sent into the stream
		// along with the parent object. Childcares that doesn't meet requirement
		// will get retracted
		for (Childcare $cc: ccc.getChildcareList()){
			Childcare $ccObj = new Childcare();
			$ccObj.setCentreCode( $cc.getCentreCode() );
			$ccObj.setCentreAddress( $cc.getCentreAddress());
			$ccObj.setCentreName( $cc.getCentreName() );
			$ccObj.setFood( $cc.getFood() );
			$ccObj.setInfantVacancy( $cc.getInfantVacancy() );
			$ccObj.setK1Vacancy( $cc.getK1Vacancy() );
			$ccObj.setK2Vacancy( $cc.getK2Vacancy() );
			$ccObj.setN1Vacancy( $cc.getN1Vacancy() );
			$ccObj.setN2Vacancy( $cc.getN2Vacancy() );
			$ccObj.setPgVacancy( $cc.getPgVacancy() );
			$ccObj.setPostalCode( $cc.getPostalCode() );
			$ccObj.setSecondLanguage( $cc.getSecondLanguage() );
			$ccObj.setFee( $cc.getFee() );
			$ccObj.setStudyLevel( $cc.getStudyLevel() );
			$ccObj.setTypeOfCitizenship( $cc.getTypeOfCitizenship() );
			$ccObj.setTypeOfService( $cc.getTypeOfService() );
			$ccObj.computeDistance(parent.getLocation(), parent.getDistance(), postalList );
			parent = ccRecService.filterChildcare($ccObj, parent);
		}
		
		// If there are no childcares at the end of the filter,
		// we will then relax the requirement and find other childcares
		if(parent.getChildcareList().isEmpty()) {
			ChildcareCollection otherCcc = new ChildcareCollection();
			otherCcc.populateChildcares( parent.getServiceList() );
			
			for (Childcare $cc: otherCcc.getChildcareList()){
				Childcare $ccObj = new Childcare();
				$ccObj.setCentreCode( $cc.getCentreCode() );
				$ccObj.setCentreAddress( $cc.getCentreAddress() );
				$ccObj.setCentreName( $cc.getCentreName() );
				$ccObj.setFood( $cc.getFood() );
				$ccObj.setInfantVacancy( $cc.getInfantVacancy() );
				$ccObj.setK1Vacancy( $cc.getK1Vacancy() );
				$ccObj.setK2Vacancy( $cc.getK2Vacancy() );
				$ccObj.setN1Vacancy( $cc.getN1Vacancy() );
				$ccObj.setN2Vacancy( $cc.getN2Vacancy() );
				$ccObj.setPgVacancy( $cc.getPgVacancy() );
				$ccObj.setPostalCode( $cc.getPostalCode() );
				$ccObj.setSecondLanguage( $cc.getSecondLanguage() );
				$ccObj.setFee( $cc.getFee() );
				$ccObj.setStudyLevel( $cc.getStudyLevel() );
				$ccObj.setTypeOfCitizenship( $cc.getTypeOfCitizenship() );
				$ccObj.setTypeOfService( $cc.getTypeOfService() );
				$ccObj.computeDistance(parent.getLocation(), parent.getDistance(), postalList );
				parent = ccRecService.filterOtherChildcare($ccObj, parent);
			}
		}
		

		return parent;
	}
}
