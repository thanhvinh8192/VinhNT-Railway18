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
				System.out.print("Mời bạn nhập lại: ");
			}
		}
	}
	
	public static int inputPositive(String errorMessage) {
		while (true) {
			int positiveNumber = inputInt(errorMessage);
			if (positiveNumber > 0) {
				return positiveNumber;
			}else {
				System.err.println("Vui lòng nhập số lớn hơn 0");
				System.out.print("Mời bạn nhập lại: ");
			}
		}
	}
	
	public static int inputExpInYear(String errorMessage) {
		while (true) {
			int positiveNumber = inputInt(errorMessage);
			if (positiveNumber > 0 && positiveNumber < 11) {
				return positiveNumber;
			}else {
				System.err.println("Bạn chỉ được nhập từ 1 -> 10");
				System.out.print("Mời bạn nhập lại: ");
			}
		}
	}
	
	public static int inputGraduationRank(String errorMessage) {
		while (true) {
			int positiveNumber = inputInt(errorMessage);
			if (positiveNumber > 0 && positiveNumber < 5) {
				return positiveNumber;
			}else {
				System.err.println("Bạn chỉ được nhập từ 1 -> 4");
				System.out.print("Mời bạn nhập lại: ");
			}
		}
	}
	
	public static int inputRole(String errorMessage) {
		while (true) {
			int role = inputInt(errorMessage);
			if (role < 1 || role > 2) {
				System.err.println("Vui lòng nhập 1 hoặc 2");
				System.out.print("Mời bạn nhập lại: ");
			}else {
				return role;
			}
		}
	}
	
	public static String inputPhoneNumber(String errorMessage) {
		while (true) {
			String number = scanner.nextLine();
			if (number.length() > 12 || number.length() < 9) {
				System.err.println(errorMessage);
				continue;
			}

			if (number.charAt(0) != '0') {
				System.err.println(errorMessage);
				continue;
			}

			boolean isNumber = true;

			for (int i = 0; i < number.length(); i++) {
				if (Character.isDigit(number.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return number;
			} else {
				System.out.println(errorMessage);
				System.out.print("Mời bạn nhập lại phone number: ");
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
				System.err.println(errorMessage + " Password phải dài 6 -> 12 ký tự");
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
	
	
	public static String inputString(String errorMessage) {
		String input = scanner.nextLine();
		input = input.trim(); 						// Loại khoảng trắng 2 đầu
		input = input.replaceAll("\\s+", " "); 		// Loại khoảng trắng trong từ
		input = input.toLowerCase();
		String[] words = input.split(" ");
		String nameString = "";
		for (String word : words) {
			word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
			nameString = nameString + word + " ";
		}
		nameString = nameString.trim();
		return nameString;
	}
}
 