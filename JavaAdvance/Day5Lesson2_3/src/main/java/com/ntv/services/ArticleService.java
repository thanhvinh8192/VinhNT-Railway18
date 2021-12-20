package com.ntv.services;

import com.ntv.entity.Article;
import com.ntv.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.getAllArticles();
    }
}
