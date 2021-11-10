package vti.testing_system_1.entity;

import java.util.Arrays;
import java.util.Date;

public class Exam {
    private int examId;
    private String code;
    private String title;
    private CategoryQuestion[] categoryQuestions;
    private int duration;
    private Account creatorAccount;
    private Date createdDate;
    private Question[] questions;

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", categoryQuestions=" + Arrays.toString(categoryQuestions) +
                ", duration=" + duration +
                ", creatorAccount=" + creatorAccount +
                ", createdDate=" + createdDate +
                ", questions=" + Arrays.toString(questions) +
                '}';
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryQuestion[] getCategoryQuestions() {
        return categoryQuestions;
    }

    public void setCategoryQuestions(CategoryQuestion[] categoryQuestions) {
        this.categoryQuestions = categoryQuestions;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Account getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(Account creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
