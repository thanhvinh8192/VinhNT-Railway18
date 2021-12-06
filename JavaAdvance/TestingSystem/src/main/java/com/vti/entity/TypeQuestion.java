package com.vti.entity;

import javax.persistence.*;

@Entity
@Table(name = "type_question")
public class TypeQuestion {
    @Column(name = "type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeQuestionId;
    @Column(name = "type_name")

    @Enumerated(EnumType.STRING)
    private TypeQuestionName typeQuestionName;

    @Override
    public String toString() {
        return "Position [id= " + typeQuestionId + ", name= " + typeQuestionName + "]\n";
    }

    public enum TypeQuestionName {
        Essay, Multiple_Choice
    }
}
