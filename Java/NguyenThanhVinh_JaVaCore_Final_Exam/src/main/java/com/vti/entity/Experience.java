package com.vti.entity;

public class Experience extends Candidate {
	private int expInYear;
	private String proSkill;
	
	public Experience() {
	
	}

	public Experience(String firstName, String lastName, String phone, String email, String password, int expInYear, String proSkill) {
		super(firstName, lastName, phone,  email, password, Role.Experience);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	
}
