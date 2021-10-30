package com.vti.backend;

import com.vti.entity.Student;

import java.util.ArrayList;

public class Exercise4 {
    //Duyet Arraylist co 3 cach: 1.For 2.FroEach 3.Iterator
    public void question1(){
        ArrayList<Student> students = new ArrayList<Student>();
        Student st1 = new Student("Nguyen Van A", "HCM");
        st1.setScore(8.1);
        students.add(st1);
        Student st2 = new Student("Tran Van B", "HN");
        st2.setScore(4.0);
        students.add(st2);
        Student st3 = new Student("Doan Van C", "DN");
        st3.setScore(7.0);
        students.add(st3);

        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }
    }

    public void question2(){

    }
}
