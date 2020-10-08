package com.ccrecommend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.kie.api.runtime.KieContainer;

import com.ccrecommend.model.HardRulesAgendaFilter;
import com.ccrecommend.model.Parent;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCRecService {

	private final KieContainer kieContainer;

	@Autowired
	public CCRecService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public Parent filterServices(com.ccrecommend.model.Service svc, Parent parent) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(parent);
		kieSession.insert(svc);
		kieSession.fireAllRules(new HardRulesAgendaFilter("svc"));

		kieSession.dispose();
		return parent;
	}
	
	public Parent filterChildcare(com.ccrecommend.model.Childcare cc, Parent parent) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(cc);
		kieSession.insert(parent);
		kieSession.fireAllRules(new HardRulesAgendaFilter("cc"));

		kieSession.dispose();
		
		return parent;
	}
	
	public Parent filterOtherChildcare(com.ccrecommend.model.Childcare cc, Parent parent) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(cc);
		kieSession.insert(parent);
		kieSession.fireAllRules(new HardRulesAgendaFilter("otherCC"));

		kieSession.dispose();
		
		return parent;
	}
}
