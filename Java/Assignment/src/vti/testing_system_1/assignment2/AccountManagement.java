package com.testing_system_1.assignment2;

import com.testing_system_1.entity.Account;
import com.testing_system_1.entity.Position;

public class AccountManagement {
    //Account account;

    public AccountManagement() {
    }

    public void checkDepartment(Account account){
        if (account.getDepartment() == null){
            System.out.println("This employee does not have a deparment");
        }else System.out.println("This employee's department is " + account.getDepartment().getDepartmentName());
    }

    public void checkGroup(Account account){
        if (account.getGroups() == null || account.getGroups().length == 0){
            System.out.println("This employee does not have a group");
        }else if (account.getGroups().length == 1 || account.getGroups().length == 2){
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        }else if (account.getGroups().length == 3){
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        }else
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");

    }
    public void checkDepartmentUseTenary(Account account){
        System.out.println((account.getDepartment() == null) ?
                "This employee does not have a deparment" : "This employee's department is " + account.getDepartment().getDepartmentName());
    }
    public void checkPositionUseTenary(Account account){
        /*System.out.println((account.getPosition().getPositionName() == Position.PositionName.Dev) ?
                "This person is Developer" : "This person is not Developer");*/
        if (account.getPosition() == null){
            System.out.println("This employee");
            return;
        }
        System.out.println((account.getPosition().getPositionName().toString().equals("Dev")) ?
                "This person is Developer" : "This person is not Developer");
    }

}
