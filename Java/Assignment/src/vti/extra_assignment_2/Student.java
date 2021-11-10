package vti.extra_assignment_2;

public class Student {
    private double mathMark;
    private double physicalMark;
     private double chemistryMark;

    public Student() {
    }

    public Student(double mathMark, double physicalMark, double chemistryMark) {
        this.mathMark = mathMark;
        this.physicalMark = physicalMark;
        this.chemistryMark = chemistryMark;
    }

    public double getMathMark() {
        return mathMark;
    }

    public void setMathMark(double mathMark) {
        this.mathMark = mathMark;
    }

    public double getPhysicalMark() {
        return physicalMark;
    }

    public void setPhysicalMark(double physicalMark) {
        this.physicalMark = physicalMark;
    }

    public double getChemistryMark() {
        return chemistryMark;
    }

    public void setChemistryMark(double chemistryMark) {
        this.chemistryMark = chemistryMark;
    }

    public double getGpaStudent(){
        return (getMathMark()*2 + getPhysicalMark() + getChemistryMark())/4;
    }

    public String getGradeStudent(double gpa) {
        String gradeStudnet;
        if (gpa >= 9.0) {
            gradeStudnet = "Excellent";
        } else if (gpa < 9 && gpa >= 8.0) {
            gradeStudnet = "Very Good";
        }else if (gpa < 8.0 && gpa >= 7.0){
            gradeStudnet = "Good";
        }
        else if (gpa < 7.0 && gpa >= 6.0){
            gradeStudnet = "Average Good";
        }
        else gradeStudnet = "Average";
        return gradeStudnet;
    }
}
