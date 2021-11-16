package com.vti.backend.businesslayer;

import java.util.List;

import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.entity.User;

public class UserServices {
	private UserRepository userRepository;
	
	public UserServices() {
		userRepository = new UserRepository();
	}

	public User login(String email, String password) {
		
		return userRepository.login(email, password);
	}

	public List<User> getListUserByProjectId(int projectId) {
		return userRepository.getListUserByProjectId(projectId);
	}

	public List<Manager> getListManager() {
		return userRepository.getListManager();
	}

}
