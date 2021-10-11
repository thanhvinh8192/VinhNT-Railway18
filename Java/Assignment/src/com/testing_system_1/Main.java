package com.testing_system_1;

import com.testing_system_1.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Position pos1 = new Position();
        //Create Department
        Department dep1 = new Department();
        dep1.setDepartmentID(1);
        dep1.setDepartmentName("Dev");

        Department dep2 = new Department();
        dep2.setDepartmentID(2);
        dep2.setDepartmentName("Tester");

        //System.out.println("Department 1: " + dep1);

        Account acc1 = new Account();
        acc1.setAccountID(1);
        acc1.setUserName("employee1");
        acc1.setFullName("Tran Van A");
        acc1.setEmail("employee@gmail.com");
        acc1.setDepartment(dep1);
        acc1.setPosition(pos1);
        acc1.setCreatedDate(LocalDate.now());

        System.out.println(acc1);
    }
}
