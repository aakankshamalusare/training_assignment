package com.finzly.salondeck.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.finzly.salondeck.dao.UserDao;
import com.finzly.salondeck.entity.UserInformation;

@Service

public class UserService {
	
	@Autowired 
	UserDao userDao;
	
	

	public ResponseEntity<String> signUp(Map<String, String> entity) {
		
		 return userDao.signUp(entity);
	}



	public ResponseEntity<Map<String, String>> loginByPhonenumber(Map<String, String> entity) {
		
		return userDao.loginByPhonenumber(entity);
	}



	public ResponseEntity<Map<String, String>> loginByEmail(Map<String, String> entity) {
		
		return userDao.loginByEmail(entity);
	}



	public ResponseEntity<String> getQuestion(Map<String, String> entity) {
		
		return userDao.getQuestion(entity);
	}



	public ResponseEntity<String> updatePassword(Map<String, String> entity) {
		
		return userDao.updatePassword(entity) ;
	}



	public ResponseEntity<Map<String, String>> updateProfile(Map<String, String> entity) {
		
		return userDao. updateProfile(entity);
	}



	public ResponseEntity<List<UserInformation>> getAll() {
		
		return userDao. getAll();
	}


	public ResponseEntity<List> getByName(Map<String, String> entity) {
		return userDao.getByName(entity);
	}



	public ResponseEntity<List> getByGender(Map<String, String> entity) {
		
		return userDao.getByGender(entity);
	}



	public ResponseEntity<List> getByPhonenumber(Map<String, String> entity) {
		
		return userDao.getByPhonenumber(entity);
	}



	public ResponseEntity<List> getByEmail(Map<String, String> entity) {
		
		return userDao.getByEmail(entity);
	}



	public ResponseEntity<List> getByCity(Map<String, String> entity) {
		
		return userDao.getByCity(entity);
	}



	public ResponseEntity<List> getByLogin(Map<String, String> entity) {
	
		return  userDao.getByLogin(entity);
	}



	public ResponseEntity<String> logOut(Map<String, String> entity) {
	
		return userDao.logOut(entity);
	}


	/*
	 * 13 sept
	 */

	 public ResponseEntity<Map<String, String>> updateName(Map<String, String> entity) {
		return userDao.updateName(entity);
	}



	public ResponseEntity<Map<String, String>> updatePhonenumber(Map<String, String> entity) {
		return userDao.updatePhonenumber(entity);
	}



    public ResponseEntity<Map<String, String>> updateEmail(Map<String, String> entity) {
        return userDao.updateEmail(entity);
    }



    public ResponseEntity<Map<String, String>> updateCity(Map<String, String> entity) {
        return userDao.updateCity(entity);
    }



	public ResponseEntity<Map<String, String>> deleteUser(Map<String, String> entity) {
		return userDao.deleteUser(entity);
	}



	public ResponseEntity<Map<String, String>> deleteUserByName(Map<String, String> entity) {
		return userDao.deleteUserByName(entity);
	}



	public ResponseEntity<Map<String, String>> deleteUserByCity(Map<String, String> entity) {
		return userDao.deleteUserByCity(entity);
	}



	public ResponseEntity<Map<String, String>> deleteUserByPhonenumber(Map<String, String> entity) {
		return userDao.deleteUserByPhonenumber(entity);
	}



	public ResponseEntity<Map<String, String>> deleteUserByEmail(Map<String, String> entity) {
		return userDao.deleteUserByEmail(entity);
	}



	public ResponseEntity<List> getAllStartwithName(Map<String, String> entity) {
		return userDao.getAllStartwithName(entity);
	}



    public ResponseEntity<List> getAllStartwithCity(Map<String, String> entity) {
        return userDao.getAllStartwithCity(entity);
    }



	public ResponseEntity<List> getAllStartwithEmail(Map<String, String> entity) {
		return userDao.getAllStartwithEmail(entity);
	}



	public ResponseEntity<List> getAllStartwithPhonenumber(Map<String, String> entity) {
		return userDao.getAllStartwithPhonenumber(entity);
	}



	





	

}
