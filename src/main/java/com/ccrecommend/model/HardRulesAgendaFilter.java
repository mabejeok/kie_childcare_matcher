package com.ccrecommend.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

public class HardRulesAgendaFilter implements AgendaFilter{
    // Here we are mapping the rules to execute at each stage:
	// 1. svcList is the rules to execute when we want to find services that fully matches the 
	//    parents' requirements
	// 2. childcareList is the rules to execute when we want to find childcares that fully matches
	//    the parents' requirements
	// 3. otherChildcareList is the rules to execute when we want to find childcares that partially 
	//    the parents' requirements
    private static HashMap<String, List<String>> ruleSet = new HashMap<String, List<String>>();
    private List<String> selectedRules = new ArrayList<String>();
    
    public HardRulesAgendaFilter(String ruleKey) {
    	if(ruleSet.isEmpty()) {
    		List<String> svcList = Arrays.asList("Filter Service Rule 1", 
        			"Filter Service sessions 1", "Filter Service sessions 2",
        			"Filter Service sessions 3", "Filter Service Rule 3");
        	
        	ruleSet.put("svc", svcList);
        	
        	List<String> ccList = Arrays.asList("Row 1 Filter CC vacancy DT", 
        			"Row 2 Filter CC vacancy DT", "Row 3 Filter CC vacancy DT",
        			"Row 4 Filter CC vacancy DT", "Row 5 Filter CC vacancy DT",
        			"Row 6 Filter CC vacancy DT", "Row 1 Filter CC Language DT",
        			"Row 2 Filter CC Language DT", "Row 3 Filter CC Language DT",
        			"Row 1 Filter CC Food DT", "Row 2 Filter CC Food DT",
        			"Row 3 Filter CC Food DT", "Filter distance < 1km",
        			"Filter distance < 2km", "Filter distance < 3km",
        			"Add cc");
        	
        	ruleSet.put("cc", ccList);
        	
        	List<String> otherCCList = Arrays.asList("Row 1 Filter CC vacancy DT", 
        			"Row 2 Filter CC vacancy DT", "Row 3 Filter CC vacancy DT",
        			"Row 4 Filter CC vacancy DT", "Row 5 Filter CC vacancy DT",
        			"Row 6 Filter CC vacancy DT", "Add other cc");
        	
        	ruleSet.put("otherCC", otherCCList);
    	}
    	
    	this.selectedRules = ruleSet.get(ruleKey);    	

    }
    
   // ... getters & setters
   public boolean accept( Match match ){
       return this.selectedRules.contains( match.getRule().getName() );
   }

}