package com.testing_system_1;

import com.testing_system_1.assignment2.AccountManagement;
import com.testing_system_1.assignment2.Exercise5;
import com.testing_system_1.entity.Account;
import com.testing_system_1.entity.Department;
import com.testing_system_1.entity.Group;
import com.testing_system_1.entity.Position;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        //Create Department
        Department department1 = new Department(1, "HR");
        Department department2 = new Department(2, "Marketing");
        Department department3 = new Department(3, "Sale");

        //Create Position
        Position position1 = new Position(1, Position.PositionName.Dev);
        Position position2 = new Position(2, Position.PositionName.Scrum_Master);
        Position position3 = new Position(3, Position.PositionName.PM);
        Position po2 = new Position();

        Account account = new Account(3, "admin@gmail.com", "admin", "Boyce Codd", position3, new Date());
        //Create Group
        Group group1 = new Group(1, "Java Fresher", account, new Date() );
        Group group2 = new Group(2, "C #", account, new Date() );
        Group group3 = new Group(3, "MySQL", null, new Date() );
        Group group4 = new Group(4, "JavaScript", null, new Date() );

        //Create Account
        Account account1 = new Account(1, "tranvana@gmail.com","tranvana", "Trần Văn A",
                department1, position1, (new Date()), (new Group[] {group1, group3}));
        Account account2 = new Account(2, "lethidieu@gmail.com","lethidieu", "Lê Thị Điệu",
                position2, (new Date()), (new Group[] {group1, group2, group3, group4}));
       // System.out.println(account1);
       // System.out.println(account2);

        /*AccountManagement accountManagement = new AccountManagement();
        accountManagement.checkDepartmentUseTenary(account2);
        accountManagement.checkGroup(account2);
        accountManagement.checkPositionUseTenary(account2);*/

        Exercise5 ex5 = new Exercise5();
        ex5.addGrouptoAccount();
    }
}
