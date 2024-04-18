package com.eduhub.eduhubapp.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eduhub.eduhubapp.Dao.ArticleDao;
import com.eduhub.eduhubapp.entity.Article;
import com.google.gson.Gson;

@Service
public class EduhubArticleServiceImpl implements EduhubArticleService{
	
	@Autowired
	Article article;
	
	@Autowired
	ArticleDao articleDao;

	@Override
	public ResponseEntity<String> createNewArticle(Article articleDetails) {
		// TODO Auto-generated method stub
		article.setOwnerId(articleDetails.getOwnerId());
		article.setDescription(articleDetails.getDescription());
		article.setPublishedDate(articleDetails.getPublishedDate());
		article.setTitle(articleDetails.getTitle());
		article.setTags(articleDetails.getTags());
		try {
			articleDao.save(article);
			Map<Object,Object> ob=new HashMap<>();
			ob.put("articleId",articleDao.findByTitle(articleDetails.getTitle()).getArticleId());
			ob.put("message", "Created the article");
			Gson gson=new Gson();
			String json=gson.toJson(ob);
			return new ResponseEntity<>(json,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error occured.Check logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return null;
	}

	@Override
	public ResponseEntity<String> viewAllArticles() {
		// TODO Auto-generated method stub
		Map<Object,Object> ob=new HashMap<>();
		ob.put("articleList",articleDao.findAll());
		ob.put("message", "Fetched the articles");
		Gson gson=new Gson();
		String json=gson.toJson(ob);
		return new ResponseEntity<>(json,HttpStatus.OK);
		//return null;
	}

	@Override
	public ResponseEntity<String> viewArticle(Article articleReq) {
		// TODO Auto-generated method stub
		try {
			Article fecthArticle=articleDao.findByArticleId(articleReq.getArticleId());
			Gson gson=new Gson();
			String json=gson.toJson(fecthArticle);
			return new ResponseEntity<>(json,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@Override
	public ResponseEntity<String> editArticle(Article articleEditReq){
		try {
			Article articleFromDB=articleDao.findByArticleId(articleEditReq.getArticleId());
			if(articleEditReq.getDescription()!=null) {
				articleFromDB.setDescription(articleEditReq.getDescription());
			}
			if(articleEditReq.getTitle()!=null) {
				articleFromDB.setTitle(articleEditReq.getTitle());
			}
			if(articleEditReq.getTags()!=null) {
				articleFromDB.setTags(articleEditReq.getTags());
			}
			articleDao.save(articleFromDB);
			Map<Object,Object> ob=new HashMap<>();
			ob.put("message", "Success");
			
			return new ResponseEntity<>(new Gson().toJson(ob),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
