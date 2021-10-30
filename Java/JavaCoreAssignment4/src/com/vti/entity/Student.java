package com.vti.entity;

public class Student {
    private int studentId;
    private String studentName;
    private String homeTown;
    private double score;

    public Student() {
    }

    @Override
    public String toString() {
        String rankScore = "";
        if(score < 4.0){
            rankScore = "Yếu";
        }else if(score >= 4.0 && score <6.0){
            rankScore = "Trung bình";
        }else if(score >= 6.0 && score <8.0){
            rankScore = "Khá";
        }else{
            rankScore = "Giỏi";
        }
        return "Student info\n" +
                "id: " + studentId + "\n" +
                "name: " + studentName + "\n" +
                "hometown: " + homeTown + "\n" +
                "rank score: " + rankScore+ "\n";
    }

    public Student(String studentName, String hometown) {
        this.studentName = studentName;
        this.homeTown = hometown;
        this.score = 0;
    }


    public void setScore(double score) {
        this.score = score;
    }

    public void plusScore(double score) {
        this.score = this.score + score ;
    }
}
