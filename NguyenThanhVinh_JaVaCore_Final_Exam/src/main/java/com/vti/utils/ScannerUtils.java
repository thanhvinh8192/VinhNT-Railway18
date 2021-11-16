package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int inputInt(String errorMessage) {
		while(true) {
			try {
				String input = scanner.nextLine();
				int numberInt = Integer.parseInt(input);
				return numberInt;
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	public static int inputPositive(String errorMessage) {
		while (true) {
			int positiveNumber = inputInt(errorMessage);
			if (positiveNumber > 0) {
				return positiveNumber;
			}else {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại: ");
			}
		}
	}
	
	public static int inputRole(String errorMessage) {
		while (true) {
			int role = inputInt(errorMessage);
			if (role < 1 || role > 2) {
				System.err.println(errorMessage);
			}else {
				return role;
			}
		}
	}
	
	public static String inputEmail(String errorMessage) {
		while(true) {
			String email = scanner.nextLine();
			if (!email.contains("@vti.com.vn")) {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại email: ");
			}else {
				return email;
			}
		}
	}
	
	public static String inputPassword(String errorMessage) {
		while(true) {
			String password = scanner.nextLine();
			
			if (password.length() < 6 || password.length() > 12) {
				System.err.println(errorMessage + " Password chỉ được 6 -> 12 ký tự");
				System.out.print("Mời bạn nhập lại password: ");
				continue;
			}
			
			boolean hasUpperCase = false;
			
			for(int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i))) {
					hasUpperCase = true;
					break;
				}
			}
			
			if (hasUpperCase) {
				return password;
			}else {
				System.err.println(errorMessage + " Password phải có ít nhất 1 chữ viết hoa");
				System.out.print("Mời bạn nhập lại password: ");
			}
		}
	}
	
	public static String inputFullname(String errorMessage) {
		while (true) {
			String fullName = inputName();
			String tempName = fullName.replaceAll("\\s+", "");
			
			boolean nameInvalid = false;
			
			for (int i = 0; i < tempName.length(); i++) {
				if (tempName.charAt(i) < 'A' || tempName.charAt(i) > 'z') {
					nameInvalid = true;
					break;
				}
			}
			
			if (nameInvalid == false) {
				return fullName;
			}else {
				System.err.println("Tên chưa đúng định dạng, mời bạn nhập lại");
			}
		}
	}
	
	private static String inputName() {
		String name = scanner.nextLine();
		name = name.trim();
		name = name.replaceAll("\\s+", " ");
		name = name.toLowerCase();
		
		name = "";
		
		String[] words = name.split(" ");
		for (String word : words) {
			word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
			name = name + word + " ";
		}
		name = name.trim();
		return name;
	}
}
 