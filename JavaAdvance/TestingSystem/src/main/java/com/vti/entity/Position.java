package com.vti.entity;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Column(name = "position_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    @Column(name = "position_name")
    @Enumerated(EnumType.STRING)
    private PositionEnum positionName;

    @Override
    public String toString() {
        return "Position [id= " + positionId + ", name= " + positionName + "]\n";
    }

    public enum PositionEnum {
        Dev1, Dev2, PM, Leader, Scrum_Master, Tester
    }
}
