package com.ntv;


import com.ntv.entity.ContractEmployee;
import com.ntv.entity.RegularEmployee;
import com.ntv.repository.EmployeeRepository;
import com.ntv.utils.HibernateUtils;

public class Program {
    public static void main(String[] args) {
        System.out.println("Demo Inheritance");

//        HibernateUtils.getInstance().openSession();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        ContractEmployee contractEmployee = new ContractEmployee("Nguyen Thanh Tam",1200,"3 years");
        RegularEmployee regularEmployee = new RegularEmployee("Nguyen Thi Thanh Truc", 180000, 90000);
//        employeeRepository.createContractEmployee(contractEmployee);
//        employeeRepository.createRegularEmployee(regularEmployee);
        System.out.println("Successful!");
    }
}
