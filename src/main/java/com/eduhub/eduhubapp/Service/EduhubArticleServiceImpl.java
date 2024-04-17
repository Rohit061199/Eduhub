package com.eduhub.eduhubapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eduhub.eduhubapp.Dao.ArticleDao;
import com.eduhub.eduhubapp.entity.Article;

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
			return new ResponseEntity<>("Created an article with Article ID "+articleDao.findByTitle(articleDetails.getTitle()).getArticleId(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error occured.Check logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return null;
	}

	@Override
	public ResponseEntity<List<Article>> viewAllArticles() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(articleDao.findAll(),HttpStatus.OK);
		//return null;
	}

	@Override
	public ResponseEntity<Article> viewArticle(Article articleReq) {
		// TODO Auto-generated method stub
		try {
			Article fecthArticle=articleDao.findByArticleId(articleReq.getArticleId());
			return new ResponseEntity<>(fecthArticle,HttpStatus.OK);
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
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
