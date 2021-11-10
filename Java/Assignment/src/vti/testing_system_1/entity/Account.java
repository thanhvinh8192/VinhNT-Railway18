package vti.testing_system_1.entity;

import java.util.Arrays;
import java.util.Date;

public class Account {
    private int accountId;
    private String emailAddress;
    private String username;
    private String fullName;
    private Department department;
    private Position position;
    private Date createdDate;
    private Group[] groups;

    public Account() {
    }

    public  Account(int id, String email, String username, String fullName){
        this.accountId = id;
        this.emailAddress = email;
        this.username = username;
        this.fullName = fullName;
    }

    public Account(int accountId, String emailAddress, String username, String fullName, Department department, Position position, Date createdDate, Group[] groups) {
        this.accountId = accountId;
        this.emailAddress = emailAddress;
        this.username = username;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createdDate = createdDate;
        this.groups = groups;
    }
    public Account(int accountId, String emailAddress, String username, String fullName, Position position, Date createdDate, Group[] groups) {
        this.accountId = accountId;
        this.emailAddress = emailAddress;
        this.username = username;
        this.fullName = fullName;
        this.position = position;
        this.createdDate = createdDate;
        this.groups = groups;
    }

    public Account(int accountId, String emailAddress, String username, String fullName, Position position, Date createdDate) {
        this.accountId = accountId;
        this.emailAddress = emailAddress;
        this.username = username;
        this.fullName = fullName;
        this.position = position;
        this.createdDate = createdDate;

    }



    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", emailAddress='" + emailAddress + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createdDate=" + createdDate +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }
}
