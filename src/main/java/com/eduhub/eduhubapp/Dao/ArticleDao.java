package com.eduhub.eduhubapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduhub.eduhubapp.entity.Article;

@Repository
public interface ArticleDao extends JpaRepository<Article,Integer>{
	
	Article findByTitle(String title);

	Article findByArticleId(Integer articleId);

}
