package com.vti.backend.presentationlayer;

import java.util.List;

import com.vti.backend.businesslayer.UserServices;
import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.entity.User;

public class UserController {
	private UserServices userServices;
	
	public UserController() {
		userServices = new UserServices();
	}

	public User login(String email, String password) {
		return userServices.login(email, password);
	}

	
	public List<User> getListUserByProjectId(int projectId) {
		return userServices.getListUserByProjectId(projectId);
	}

	public List<Manager> getListManager() {
		return userServices.getListManager();
	}

}
