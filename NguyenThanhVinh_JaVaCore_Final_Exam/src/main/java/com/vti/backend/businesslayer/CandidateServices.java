package com.vti.backend.businesslayer;


import com.vti.backend.datalayer.CandidateRepository;
import com.vti.entity.Fresher;
import com.vti.entity.Candidate;
import com.vti.entity.Experience;

public class CandidateServices {
	private CandidateRepository candidateRepository;
	
	public CandidateServices() {
		candidateRepository = new CandidateRepository();
	}

	public Candidate login(String email, String password) {
		return candidateRepository.login(email, password);
	}

	public String createExperience(Experience experience) {
		return candidateRepository.createExperience(experience);
	}

	public String createFresher(Fresher fresher) {
		return candidateRepository.createFresher(fresher);
	}

	

}
