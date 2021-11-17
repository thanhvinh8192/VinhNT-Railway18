package com.vti.entity;

public class Fresher extends Candidate {
	private GraduationRank graduationRank;

	public Fresher() {
	}

	public Fresher(String firstName, String lastName, String phone, String email, String password, GraduationRank graduationRank) {
		super(firstName, lastName, phone, email, password, Role.Fresher);
		this.graduationRank = graduationRank;
	}

	public GraduationRank getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(GraduationRank graduationRank) {
		this.graduationRank = graduationRank;
	}

	
	
}
