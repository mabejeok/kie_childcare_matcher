package com.ccrecommend.model;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class ServiceCollection {
	private java.util.List<com.ccrecommend.model.Service> serviceList = new ArrayList<com.ccrecommend.model.Service>();
	
	public ServiceCollection() {
		try {
			populateServices();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public java.util.List<com.ccrecommend.model.Service> getServiceList() {
		return this.serviceList;
	}
	
	public void setServiceList(
			java.util.List<com.ccrecommend.model.Service> serviceList) {
		this.serviceList = serviceList;
	}
	
	public ServiceCollection(
			java.util.List<com.ccrecommend.model.Service> serviceList) {
		this.serviceList = serviceList;
	}
	
	//Populate the service list from csv
//	public void populateServices(){
//        //Load services from CSV
//      	    
//		Path pathToFile = Paths.get("C:\\Users\\mavec\\Desktop\\MTech\\IRS_PM\\listing-of-centre-services.csv");
//		BufferedReader br = null;
//		
//		try {
//			br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);	
//		} catch(IOException ioe){
//			ioe.printStackTrace(); 
//		}
//		
//	    try
//        { 
//     		String line; 
//	    	int j = 0;
//     	 	 while ((line = br.readLine()) != null) {
//     	 	    String[] attributes = line.split(";");
//
//	      	    if(j == 0) {
//    		    	j++;
//    		    	continue;
//    		    }
//      		    
//      		    Service service = createService(attributes);
//      			getServiceList().add(service) ;
//      	        
//      	        }
//        } catch (IOException ioe) {
//        	ioe.printStackTrace(); 
//  	   	}
//	    finally {
//            if (br!=null) {
//            	try {
//            		br.close();
//            	} catch (IOException ioe) {
//                	ioe.printStackTrace(); 
//          	   	}
//            	 
//            }
//        }
//        
//	}
	
	public void populateServices() throws Exception {
		MySQLAccess dao = new MySQLAccess();
        java.util.List<Map<String, String>> serviceList = dao.readServices();
		
        serviceList.forEach((service) -> {
        	Service currService = createService(service);
        	getServiceList().add(currService);
        });
	}
	
	private static Service createService(Map<String, String> serviceDict){
		String centreCode = serviceDict.get("centre_code");
		String typeOfService = serviceDict.get("type_of_service");
    	String studyLevel = serviceDict.get("level");
    	String stringFee = serviceDict.get("fee");
		float fee = Float.parseFloat(stringFee);

		String typeOfCitizenship = serviceDict.get("citizenship");
		String feeRange = "Below SGD200";
		
		if(fee > 200 && fee <= 500){
		    feeRange = "SGD200 - SGD500";
		} else if (fee > 500 && fee <= 800){
		    feeRange = "SGD500 - SGD800";
		} else if (fee > 800){
		    feeRange = "Above SGD800";
		}
		 
		Service service = new Service();
		service.setFee(fee);
		service.setTypeOfService(typeOfService);
		service.setStudyLevel(studyLevel);
		service.setTypeOfCitizenship(typeOfCitizenship);
		service.setCentreCode(centreCode);
		service.setFeeRange(feeRange);

		return service;
			 
	}
}

