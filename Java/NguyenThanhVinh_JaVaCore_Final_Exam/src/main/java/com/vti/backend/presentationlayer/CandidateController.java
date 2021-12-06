package com.vti.backend.presentationlayer;


import com.vti.backend.businesslayer.CandidateServices;
import com.vti.entity.Fresher;
import com.vti.entity.Candidate;
import com.vti.entity.Experience;

public class CandidateController {
	private CandidateServices cadidateServices;
	
	public CandidateController() {
		cadidateServices = new CandidateServices();
	}

	public Candidate login(String email, String password) {
		return cadidateServices.login(email, password);
	}

	public String createExperience(Experience experience) {
		return cadidateServices.createExperience(experience);
	}

	public String createFresher(Fresher fresher) {
		return cadidateServices.createFresher(fresher);
	}

	

}
