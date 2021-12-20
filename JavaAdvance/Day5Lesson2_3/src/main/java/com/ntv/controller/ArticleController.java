package com.ntv.controller;

import com.ntv.entity.Article;
import com.ntv.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("list-articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }
}
