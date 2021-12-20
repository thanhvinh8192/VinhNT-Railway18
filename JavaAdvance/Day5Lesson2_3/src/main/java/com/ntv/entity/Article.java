package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter @Setter @ToString @NoArgsConstructor
@Entity @Table(name = "article")
public class Article {

    public Article(String title, String type){
        this.title = title;
        this.type = type;
    }

    @Column(name = "`code`")
    @Id
    @GenericGenerator(
            name = "sequence_code_id",
            strategy = "com.ntv.entity.ArticleCodeGenerator"
    )
    @GeneratedValue(generator = "sequence_code_id")
    private String code;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

}
