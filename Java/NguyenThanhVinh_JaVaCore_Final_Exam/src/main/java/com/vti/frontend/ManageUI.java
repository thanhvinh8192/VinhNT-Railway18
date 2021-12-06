package com.vti.frontend;


import com.vti.backend.presentationlayer.CandidateController;
import com.vti.entity.Fresher;
import com.vti.entity.GraduationRank;
import com.vti.entity.Candidate;
import com.vti.entity.Experience;
import com.vti.utils.ScannerUtils;

public class ManageUI {
	private String menuStr = """
			1. Register
			2. Login
			3. Kết thúc chương trình
			----------------------------------------------""";
	
	public CandidateController candidateController;
	
	public ManageUI() {
		candidateController = new CandidateController();
	}
	
	//Chức năng 1
	public void registerCandidate() {
		System.out.print("Mời nhập First Name: ");
		String firstName = ScannerUtils.inputName("Tên không đúng định dạng.");
		System.out.print("Mời nhập Last Name: ");
		String lastName = ScannerUtils.inputName("Tên không đúng định dạng.");
		System.out.print("Mời nhập Phone: ");
		String phone = ScannerUtils.inputPhoneNumber("Phone không đúng dịnh dạng.");
		System.out.print("Mời nhập email: ");
		String email = ScannerUtils.inputEmail("Email không đúng định dạng. ");
		System.out.print("Mời nhập password: ");
		String password = ScannerUtils.inputPassword("Error.");
		System.out.print("Mời chọn Role cho ứng viên: 1. Experience || 2. Fresher");
		int role = ScannerUtils.inputRole("Bạn chỉ được nhập số.");
		if (role == 1) {
			System.out.print("Mời nhập số năm kinh nghiệm cho ứng viên: ");
			int expInYear = ScannerUtils.inputExpInYear("Bạn chỉ được nhập số.");
			Experience experience = new Experience( firstName, lastName, phone, email, password, expInYear, null);
			System.out.println(candidateController.createExperience(experience));
			
		}else {
			Fresher fresher = new Fresher(firstName, lastName, phone, email, password, null);
			System.out.println("Mời chọn xếp loại ứng viên: ");
			System.out.println("""
								1. Excellence
								2. Good
								3. Fair
								4. Poor
								""");
			int rank = ScannerUtils.inputGraduationRank("Nhập sai.");
			switch (rank) {
			case 1:
				fresher.setGraduationRank(GraduationRank.Excellence);
				break;
			case 2:
				fresher.setGraduationRank(GraduationRank.Good);
				break;
			case 3:
				fresher.setGraduationRank(GraduationRank.Fair);
				break;
			case 4:
				fresher.setGraduationRank(GraduationRank.Poor);
				break;
			}
			System.out.println(candidateController.createFresher(fresher));
		}
	}
	
	//Chức năng 2
	public void login() {
			System.out.print("Mời nhập email: ");
			String email = ScannerUtils.inputEmail("Email không đúng định dạng. ");
			System.out.print("Mời nhập password: ");
			String password = ScannerUtils.inputPassword("Error.");
			Candidate candidate = candidateController.login(email, password);
			if (candidate == null) {
				System.err.println();
			}else {
				System.out.println("Đăng nhập thành công");
				System.out.println("Xin chào " + candidate.getFirstName() + " " + candidate.getLastName());
				System.out.println("______________________________");
				
			}
			
	}
	
	//Chọn chức năng
	public int inputFunction() {
		while(true) {
			int x = ScannerUtils.inputInt("Bạn chỉ được nhập số.");
			if (x >= 1 && x <= 3) {
				return x;
			}else {
				System.err.println("Bạn chỉ nhập được chức năng từ 1->4.");
				System.out.print("Mời bạn nhập lại: ");
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
					System.out.println("Register");
					registerCandidate();
					break;
				case 2:
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
