package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.presentation.UserController;
import com.vti.entity.User;

public class Function {

	private UserController userController;

	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}

	public void getListUser() throws ClassNotFoundException, SQLException {
		List<User> users = userController.getListUsers();
		System.out.printf("%-15s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password");
		for (User user : users) {
			System.out.printf("%-15s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),
					"*********");
		}
	}

	public void getUserById() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Mời bạn nhập vào id: ");
			int id = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");

			if (userController.isUserIdExits(id)) {
				System.out.println(userController.getUserById(id));
				return;
			} else {
				System.err.println("id khong ton tai! Vui long nhap lai! ");
			}
		}
	}

	public void deleteUser() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Mời bạn nhập vào id của account: ");
			int id2 = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương!");

			if (userController.isUserIdExits(id2)) {
				userController.deleteUser(id2);
				System.out.println("Xoa thanh cong!");
				return;
			} else {
				System.err.println("id khong ton tai! Vui long nhap lai!");
			}

		}
	}

	public User login() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Mời bạn nhập vào Email của account: ");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng.");

			System.out.print("Mời bạn nhập password: ");
			String password = ScannerUtils
					.inputPassword("Password phai dai tu 6--> 12 ki tu va co it nhat 1 chu viet hoa!");
			try {
				return userController.login(email, password);

			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}
}
