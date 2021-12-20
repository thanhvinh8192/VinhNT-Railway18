package com.ntv;

import com.ntv.entity.Address;
import com.ntv.entity.Department;
import com.ntv.entity.Employee;
import com.ntv.entity.User;
import com.ntv.repository.EmployeeRepository;
import com.ntv.repository.UserRepository;
import com.ntv.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println("Day 7");
        //HibernateUtils.getInstance().openSession();
        /*
        UserRepository userRepository = new UserRepository();
        List<User> users =  userRepository.getListUsers();
        for (User user : users) {
            System.out.println(user);
        }*/

        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.getListEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("Addresses:");
            for (Address address : employee.getAddresses()) {
                System.out.println(address.getStreet() + ", " + address.getCity());
            }
            System.out.println("Departments:");
            for (Department department : employee.getDepartments()) {
                System.out.println(department.getDepartmentName());
            }
            System.out.println("________________");
        }

    }
}
