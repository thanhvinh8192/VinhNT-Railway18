package com.testing_system_1.model;

import java.time.LocalDate;

public class Question {
    private int questionID;
    private String content;
    private CategoryQuestion categoryQuestion;
    private TypeQuestion typeQuestion;
    private Account creatorID;
    private LocalDate createdDate;
}
