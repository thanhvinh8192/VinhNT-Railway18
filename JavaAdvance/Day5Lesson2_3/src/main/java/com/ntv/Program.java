package com.ntv;

import com.ntv.entity.Article;
import com.ntv.entity.Department;
import com.ntv.entity.User;
import com.ntv.repository.ArticleRepository;
import com.ntv.repository.DepartmentRepository;
import com.ntv.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

public class Program {
    public static void main(String[] args) {

//        DepartmentRepository departmentRepository = new DepartmentRepository();
//        Department department = new Department(Department.DepartmentNameEnum.HUMAN_RESOURCES, LocalDate.now());
//        departmentRepository.createDepartment(department);
//        List<Department> departments = departmentRepository.getAllDepartments();
//        for (Department department : departments) {
//            System.out.println(department);
//        }
//
//        ArticleRepository articleRepository = new ArticleRepository();
//        Article article = new Article("Javascript-Nodes", "Back-End");
//        Article article = new Article("HTML", "Front-End");
//        articleRepository.createArticle(article);

        System.out.println("Successfully!");
    }
}
