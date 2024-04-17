package com.eduhub.eduhubapp.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eduhub.eduhubapp.entity.Article;

@Service
public interface EduhubArticleService {
	
	ResponseEntity<String> createNewArticle(Article articleDetails);
	ResponseEntity<List<Article>> viewAllArticles();
	ResponseEntity<Article> viewArticle(Article articleReq);
	ResponseEntity<String> editArticle(Article articleEditReq);

}
