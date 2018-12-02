package com.aridhu.microservices.film.piracy.capturetorrent.components;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PeriodicVisit {
	
	private EnterPiracySite enterPiracySite;
	
	public PeriodicVisit (EnterPiracySite enterPiracySite) {
		this.enterPiracySite = enterPiracySite;
	}
	
	@Scheduled (fixedRate=60000)
	public void doRoutine() {
		System.out.println("Routine visit at " + new Date());
		this.enterPiracySite.lookforNewEntry();
		
	} 

}
