package com.vti.backend.presentation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.IUserService;
import com.vti.backend.bussinesslayer.UserService;
import com.vti.entity.User;

public class UserController {
	private IUserService userService;

	public UserController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userService = new UserService();
	}

	public List<User> getListUsers() throws SQLException, ClassNotFoundException {

		return userService.getListUsers();
	}

	public User getUserById(int id) throws SQLException, ClassNotFoundException {
		return userService.getUserById(id);
	}

	public int deleteUser(int id) throws ClassNotFoundException, SQLException {
		return userService.deleteUser(id);
	}

	public boolean isUserIdExits(int id) throws SQLException, ClassNotFoundException {
		return userService.isUserIdExits(id);
	}

	public User login(String email, String password) throws Exception {
		return userService.login(email, password);
	}

}
