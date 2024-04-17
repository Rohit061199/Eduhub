package com.eduhub.eduhubapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eduhub.eduhubapp.Dao.EduhubUserDao;
import com.eduhub.eduhubapp.entity.EduhubUser;

@Service
public class EduhubUserServiceImpl implements EduhubUserService{
	
	@Autowired
	EduhubUser eduhubUser;
	
	@Autowired
	EduhubUserDao eduhubUserDao;

	@Override
	public ResponseEntity<String> addNewUser(EduhubUser eduhubUserReq) {
		// TODO Auto-generated method stub
		if(checkIfUserExists(eduhubUserReq.getEmailId())!=0) {
			return new ResponseEntity<>("User Exists with userId "+checkIfUserExists(eduhubUserReq.getEmailId()),HttpStatus.ALREADY_REPORTED);
		}
		eduhubUser.setEmailId(eduhubUserReq.getEmailId());
		eduhubUser.setName(eduhubUserReq.getName());
		eduhubUser.setRole(eduhubUserReq.getRole());
		try {
			eduhubUserDao.save(eduhubUser);
			return new ResponseEntity<>("Added user with userId "+eduhubUserDao.findByEmailId(eduhubUserReq.getEmailId()).getUserId(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Error Adding user",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<EduhubUser> fetchUserDetails(EduhubUser eduhubUserReq) {
		// TODO Auto-generated method stub
		try {
			
			return new ResponseEntity<>(eduhubUserDao.findByEmailId(eduhubUserReq.getEmailId()),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return null;
	}
	
	public String fetchUserNameForCertificate(Integer userId) {
		
		EduhubUser foundUser= eduhubUserDao.findByUserId(userId);
		return foundUser.getName();
		
	}
	
	public Integer checkIfUserExists(String emailId) {
		Integer userId=eduhubUserDao.findByEmailId(emailId).getUserId();
		return userId;
	}

}
