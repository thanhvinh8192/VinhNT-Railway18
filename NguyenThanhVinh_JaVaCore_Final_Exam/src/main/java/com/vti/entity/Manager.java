package com.vti.entity;

public class Manager extends User {
	private int expInYear;
	private int project;

	public Manager() {
	}

	public Manager(int id, String fullname, String email, String password, int expInYear, int projectId) {
		super(id, fullname, email, password, Role.Manager);
		this.expInYear = expInYear;
		this.project = projectId;
	}

	public int getProject() {
		return project;
	}
	
	public int getExpInYear() {
		return expInYear;
	}
	
	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
	
}
