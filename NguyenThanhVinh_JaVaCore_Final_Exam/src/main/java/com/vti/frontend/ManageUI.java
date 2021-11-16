package com.vti.frontend;

import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Manager;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

public class ManageUI {
	private String menuStr = """
			1. In thông tin Employee và Manager theo id project.
			2. Lấy ra tất cả thông tin của các Manager trong các project.
			3. Login
			4. Kết thúc chương trình
			----------------------------------------------""";
	
	public UserController userController;
	
	public ManageUI() {
		userController = new UserController();
	}
	
	//Chức năng 1 (Câu 2)
	public void printMemberByProjectId() {
		System.out.print("Mời bạn nhập id project:");
		int projectId = ScannerUtils.inputPositive("Vui lòng nhập số lớn hơn 0");
		List<User> listUsers = userController.getListUserByProjectId(projectId);
		System.out.println("Display User Info");
		System.out.println("___________________________________________________________________________");
		System.out.printf("%-5s%-20s%-25s%-15s%-15s", "ID", "FullName", "Email", "Password", "Role");
		System.out.println("\n___________________________________________________________________________");
		for (User user : listUsers) {
			System.out.printf("%-5d%-20s%-25s%-15s%-15s\n", user.getId(), user.getFullname(), user.getEmail(),
					user.getPassword(), user.getRole());
		}
	}
	
	//Chức năng 2 (Câu 3)
	public void getManagerInfo() {
		List<Manager> managers = userController.getListManager();
		System.out.println("Display Manager Info");
		System.out.println("___________________________________________________________________________");
		System.out.printf("%-10s%-10s%-20s%-25s%-15s", "ProjectID", "ManagerID", "FullName", "Email", "ExpInYear");
		System.out.println("\n___________________________________________________________________________");
		for (Manager manager : managers) {
			System.out.printf("%-10d%-10s%-20s%-25s%-15s\n",manager.getProject(), manager.getId(), 
					manager.getFullname(), manager.getEmail(), manager.getExpInYear());
		}
	}
	
	//Chức năng 3 login
	public void login() {
			System.out.print("Mời nhập email: ");
			String email = ScannerUtils.inputEmail("Email không đúng định dạng. ");
			System.out.print("Mời nhập password: ");
			String password = ScannerUtils.inputPassword("Error.");
			User user = userController.login(email, password);
			if (user == null) {
				System.err.println();
			}else {
				System.out.println("Đăng nhập thành công, thông tin user vừa đăng nhập: ");
				System.out.println(user);
				System.out.println("----------------------------------------------------");
			}
			
			
	}
	
	//Chọn chức năng
	public int inputFunction() {
		while(true) {
			int x = ScannerUtils.inputInt("Bạn chỉ nhập được chức năng từ 1->4. Mời bạn nhập lại");
			if (x >= 1 && x <= 4) {
				return x;
			}else {
				System.err.println("Bạn chỉ nhập được chức năng từ 1->4. Mời bạn nhập lại");
			}
		}
	}
	
	//In menu chương trình
	public void showMenu() {
		System.out.println(menuStr);
		while(true) {
			System.out.println("Mời bạn chọn chức năng: ");
			int inputChoosen = inputFunction();
			switch(inputChoosen) {
				case 1:
					System.out.println("Danh sách nhân viên trong project");
					printMemberByProjectId();
					break;
				case 2:
					System.out.println("Danh sách Manager của các Project");
					getManagerInfo();
					break;
				case 3:
					System.out.println("Login");
					login();
					break;
				default:
					System.out.println("Đã thoát khỏi chương trình");
					System.exit(0);
			}
		}
	}
}
