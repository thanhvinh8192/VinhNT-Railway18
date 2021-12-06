package com.vti.entity;

public class Employee extends User {

	private String ProSkill;

	public Employee(int id, String fullName, String email, String password, String ProSkill) {
		super(id, fullName, email, password, Role.USER);
		this.ProSkill = ProSkill;

	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Employee [ProSkill=" + ProSkill + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getRole()=" + getRole()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
