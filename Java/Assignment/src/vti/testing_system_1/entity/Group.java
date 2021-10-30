package com.testing_system_1.entity;

import java.util.Arrays;
import java.util.Date;

public class Group {
    private int groupId;
    private String groupName;
    private Account creatorAccount;
    private Date createdDate;
    private Account[] members;

    public Group() {
    }

    public Group(int groupId, String groupName,Account creatorAccount) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.creatorAccount = creatorAccount;
        this.createdDate = new Date();
    }

    public Group(int groupId, String groupName, Account creatorAccount, Date createdDate, Account[] members) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.creatorAccount = creatorAccount;
        this.createdDate = createdDate;
        this.members = members;
    }

    public Group(int i, String java_fresher, Account account, Date date) {
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                //", createAccount=" + creatorAccount +
                ", createdDate=" + createdDate +
                ", members=" + Arrays.toString(members) +
                '}';
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public Account[] getMembers() {
        return members;
    }

    public void setMembers(Account[] members) {
        this.members = members;
    }
}
