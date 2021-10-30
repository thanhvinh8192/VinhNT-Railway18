package com.testing_system_1.entity;

public class Position {
    private int positionId;
    private String name;
    private PositionName positionName;

    public Position() {
    }

    public enum PositionName {
        Dev, Test, Scrum_Master, PM
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId= " + positionId +
                ", positionName= " + positionName +
                "}";
    }

    public Position(int positionId, PositionName positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

}
