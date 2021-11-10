package vti.testing_system_1.assignment2;

import vti.testing_system_1.entity.Account;
import vti.testing_system_1.entity.Department;
import vti.testing_system_1.entity.Group;
import vti.testing_system_1.entity.Position;

import java.util.*;

public class Exercise5 { //input from console
    Scanner input = new Scanner(System.in);

    public void createAccount(){
        Account insertAccount = new Account();
        System.out.println("Enter account information");
        System.out.print("Enter accountId: ");
        insertAccount.setAccountId(input.nextInt());

        System.out.print("Enter email: ");
        insertAccount.setEmailAddress(input.next());
        input.nextLine();
        System.out.print("Enter username:");
        insertAccount.setUsername(input.next());

        System.out.print("Enter fullName:");
        insertAccount.setFullName(input.next());

        input.nextLine();
        System.out.print("Choose position: 1.Dev 2.Test 3.Scrum_Master 4.PM ");
        int position = input.nextInt();
        switch (position) {
            case 1 -> {
                insertAccount.setPosition(new Position(1, Position.PositionName.Dev));
            }
            case 2 -> {
                insertAccount.setPosition(new Position(2, Position.PositionName.Test));
            }
            case 3 -> {
                insertAccount.setPosition(new Position(3, Position.PositionName.Scrum_Master));
            }
            default -> {
                insertAccount.setPosition(new Position(3, Position.PositionName.PM));
            }
        }
        insertAccount.setCreatedDate(new Date());
        System.out.println("Account Information: " + insertAccount);
    }

    public void createDepartment(){
        Department department = new Department();
        System.out.println("Enter deparment information");
        System.out.print("Enter departmentId: ");
        department.setDepartmentId(input.nextInt());
        input.nextLine();
        System.out.print("Enter department name: ");
        department.setDepartmentName(input.nextLine());
        System.out.print("Department has created! \n" + "Department information: " + department);
    }

    public void menu(){
        int option;
        do{
            System.out.print("""
                    Enter function you want use\s
                    1. Create Account
                    2. Create Department
                    """);
            option = input.nextInt();
        }while  (option != 1 && option != 2);
        switch (option) {
            case 1 -> createAccount();
            case 2 -> createDepartment();
        }
    }

    public void inputEvenNumber(){
        int number;
        System.out.print("Enter number: ");
        do {
            number = input.nextInt();
            System.out.print("Please enter even number!...\n" + "Enter number again: ");
        } while (number % 2 != 0);
        System.out.print("Your numbber: " + number);
    }
    private boolean findUsername(ArrayList<Account> accounts, String username){
        boolean found = false;
        for (Account account: accounts) {
            if (account.getUsername().equals(username)){
                found = true;
                break;
            }
        }
        return found;
    }

    private boolean findGroupName(ArrayList<Group> groups, String groupName){
        boolean found = false;
        for (Group group: groups) {
            if (group.getGroupName().equals(groupName)){
                found = true;
                break;
            }
        }
        return found;
    }

    public void addGrouptoAccount(){ //Question 9
        //Create account admin
        Account admin = new Account();

        // Create Group and groups
        Group group1 = new Group(1, "Java PM", admin);
        Group group2 = new Group(2, "Kotlin PM", admin);
        Group group3 = new Group(3, "Flutter PM", admin);
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);

        //Creater account
        Account acount1 = new Account(1, "annguyen@gmail.com", "annguyen", "Nguyễn Văn An");
        Account acount2 = new Account(2, "datnguyen@gmail.com", "datnguyen", "Nguyễn Thành Đạt");
        Account acount3 = new Account(3, "lamnguyen@gmail.com", "lamnguyen", "Nguyễn Văn Lâm");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(acount1);
        accounts.add(acount2);
        accounts.add(acount3);

        System.out.print("Danh sách người dùng: \n");
        for (Account acc: accounts) {
            System.out.println(acc);
        }

        System.out.print("Enter username you want add to group");
        String username = input.nextLine();

        System.out.print("Danh sách group: \n");
        for (Group gr: groups) {
            System.out.println(gr);
        }
    }
}
