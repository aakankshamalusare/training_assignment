package com.finzly.salondeck.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.finzly.salondeck.entity.UserInformation;


@Repository
public class UserDao {

	@Autowired 
	SessionFactory sessionfactory;
	
	

	public ResponseEntity<String> signUp(Map<String, String> entity) {
		
		
		Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
	    
	    List<UserInformation> users = criteria.list();
	    
	     if(users.isEmpty()) {
	    	
	    	  UserInformation userInformation = new UserInformation(entity.get("name"), entity.get("phonenumber"), entity.get("email"), entity.get("city"), entity.get("gender"),
	      			entity.get("question"), entity.get("answer"), entity.get("password"), 1);
	          
	          session.save(userInformation);
	          
	          transaction.commit();
	          return ResponseEntity.ok().body("You are signed up successfully");
	    	
	    }
	     
	     
	     return ResponseEntity.ok().body("User already registered");
       
	}



	public ResponseEntity<Map<String, String>> loginByPhonenumber(Map<String, String> entity) {
		
		
		Map<String, String> response = new HashMap<String, String>();
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
	    
	    
	    List<UserInformation> users = criteria.list();
	    
	    if(users.isEmpty()) {
	    	
	    	   response.put("message", "User have to registered");
	    	    return ResponseEntity.badRequest().body(response);
	            //flag=1;
	    	
	    	
	    }
	    
	    int flag = 0;
	    
	    UserInformation userObj = users.get(0);
	    
	      if (!userObj.getPassword().equals(entity.get("password")) && flag == 0) {
	           
	    	    response.put("message", "Invalid password");
	            flag = 1;
	      }

	       if (userObj.getLoginStatus() == 1 && flag == 0) {
	            response.put("message", "Already Logged in");
	            flag = 1;
	       }

	        if (flag == 0) {
	            userObj.setLoginStatus(1);
	            response.put("message", "Logged in successfully");
	            response.put("admin", userObj.getAdmin().toString());
	            session.save(userObj);
	            transaction.commit();

	        }

	        return ResponseEntity.ok().body(response);

	}



	public ResponseEntity<Map<String, String>> loginByEmail(Map<String, String> entity) {
		
		
		Map<String, String> response = new HashMap<String, String>();
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
	    
	    
	    List<UserInformation> users = criteria.list();
	    
	    if(users.isEmpty()) {
	    	
	    	   response.put("message", "User have to registered");
	    	    return ResponseEntity.badRequest().body(response);
	            //flag=1;
	    	
	    	
	    }
	    
	    int flag = 0;
	    
	    UserInformation userObj = users.get(0);
	    
	      if (!userObj.getPassword().equals(entity.get("password")) && flag == 0) {
	           
	    	    response.put("message", "Invalid password");
	            flag = 1;
	      }

	       if (userObj.getLoginStatus() == 1 && flag == 0) {
	            response.put("message", "Already Logged in");
	            flag = 1;
	       }

	        if (flag == 0) {
	            userObj.setLoginStatus(1);
	            response.put("message", "Logged in successfully");
	            response.put("admin", userObj.getAdmin().toString());
	            session.save(userObj);
	            transaction.commit();

	        }

	        return ResponseEntity.ok().body(response);
	    
	}



	public ResponseEntity<String> getQuestion(Map<String, String> entity) {
		
		
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
		
		
	    List<UserInformation> users = criteria.list();
      
	    if (users.isEmpty()) {
            return ResponseEntity.ok().body("User does not exist.");
        }

        UserInformation us = users.get(0);

        return ResponseEntity.ok().body(us.getQuestion());
	}



	public ResponseEntity<String> updatePassword(Map<String, String> entity) {
		
		
		
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
		
		
	    List<UserInformation> users = criteria.list();
		

	     UserInformation usObj = users.get(0);

	        if (!usObj.getAnswer().equalsIgnoreCase(entity.get("answer"))) {

	            return ResponseEntity.ok().body("Incorrect answer"); 

	        }

	        if (usObj.getPassword().equals(entity.get("password"))) {

	            return ResponseEntity.ok().body("Password already used");
	        }

	        usObj.setPassword(entity.get("password"));

	        session.save(usObj);

	        return ResponseEntity.ok().body("Password Updated Successfully");
	}



	public ResponseEntity<Map<String, String>> updateProfile(Map<String, String> entity) {
		
		    Map<String, String> response = new HashMap<String, String>();
		
		
		    Session session = sessionfactory.openSession();
			
			Transaction transaction =  session.beginTransaction();
			
			Criteria criteria = session.createCriteria(UserInformation.class);
			
			
			criteria.add(Restrictions.eq("userid", Integer.parseInt(entity.get("userid"))));
			
			List<UserInformation> users = criteria.list();
			
			UserInformation userInformation = users.get(0);
		   
		   userInformation.setName(entity.get("name"));
		   userInformation.setPhonenumber(entity.get("phonenumber"));
		   userInformation.setEmail(entity.get("email"));
		   userInformation.setCity(entity.get("city"));
		   userInformation.setGender( entity.get("gender"));
		   userInformation.setPassword(entity.get("password"));
		   userInformation.setLoginStatus(0);

		   session.update(userInformation);
		   
		   transaction.commit();

		   response.put("message", "User profile update successfully");

		    return ResponseEntity.ok().body(response);
		
	}



	public ResponseEntity<List<UserInformation>> getAll() {
		
		
		 Session session = sessionfactory.openSession();
			
		 Transaction transaction =  session.beginTransaction();
			
		 Criteria criteria = session.createCriteria(UserInformation.class);
			
		
		 return ResponseEntity.ok().body(criteria.list());
	}

	public ResponseEntity<List> getByName(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.eq("name", entity.get("name")));
		
		return  ResponseEntity.ok().body(criteria.list());
	}


	public ResponseEntity<List> getByGender(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.eq("gender", entity.get("gender")));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByPhonenumber(Map<String, String> entity) {
		
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByEmail(Map<String, String> entity) {
		// TODO Auto-generated method stub
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.eq("email", entity.get("email")));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByCity(Map<String, String> entity) {
		 Session session = sessionfactory.openSession();
			
			Transaction transaction =  session.beginTransaction();
				
			Criteria criteria = session.createCriteria(UserInformation.class);
			
			criteria.add(Restrictions.eq("city", entity.get("city")));
			
			return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByLogin(Map<String, String> entity) {
		
		 Session session = sessionfactory.openSession();
			
			Transaction transaction =  session.beginTransaction();
				
			Criteria criteria = session.createCriteria(UserInformation.class);
			
			criteria.add(Restrictions.eq("loginstatus", entity.get("loginstatus")));
			
			return  ResponseEntity.ok().body(criteria.list());

	}



	public ResponseEntity<String> logOut(Map<String, String> entity) {
		
		
		Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.eq("loginstatus", entity.get("loginstatus")));
		
		List<UserInformation> users = criteria.list();
		
	    UserInformation user = users.get(0);
	    
	    user.setLoginStatus(0);
	    
	    session.update(user);
	    
	    transaction.commit();
		   
	    return ResponseEntity.ok().body("Logged Out Successfully");
	
	}

	/*
	 * 13 sept
	 */

	public ResponseEntity<Map<String, String>> updateName(Map<String, String> entity) {
		 
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("userid", Integer.parseInt(entity.get("userid"))));
			
		List<UserInformation> users = criteria.list();
			
		UserInformation userInformation = users.get(0);
		   
		userInformation.setName(entity.get("name"));
        userInformation.setLoginStatus(0);
        session.update(userInformation);
		   
		transaction.commit();

		response.put("message", "User name update successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> updatePhonenumber(Map<String, String> entity) {
		
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("userid", Integer.parseInt(entity.get("userid"))));
			
		List<UserInformation> users = criteria.list();
			
		UserInformation userInformation = users.get(0);
		   
		userInformation.setPhonenumber(entity.get("phonenumber"));
        userInformation.setLoginStatus(0);
        session.update(userInformation);
		   
		transaction.commit();

		response.put("message", "User phonenumber update successfully");

		return ResponseEntity.ok().body(response);
	}



    public ResponseEntity<Map<String, String>> updateEmail(Map<String, String> entity) {
        
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("userid", Integer.parseInt(entity.get("userid"))));
			
		List<UserInformation> users = criteria.list();
			
		UserInformation userInformation = users.get(0);
		   
		userInformation.setEmail(entity.get("email"));
        userInformation.setLoginStatus(0);
        session.update(userInformation);
		   
		transaction.commit();

		response.put("message", "User email update successfully");

		return ResponseEntity.ok().body(response);
    }



    public ResponseEntity<Map<String, String>> updateCity(Map<String, String> entity) {
       
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("userid", Integer.parseInt(entity.get("userid"))));
			
		List<UserInformation> users = criteria.list();
			
		UserInformation userInformation = users.get(0);
		   
		userInformation.setCity(entity.get("city"));
        userInformation.setLoginStatus(0);
        session.update(userInformation);
		   
		transaction.commit();

		response.put("message", "User city update successfully");

		return ResponseEntity.ok().body(response);
    }



    public ResponseEntity<Map<String, String>> deleteUser(Map<String, String> entity) {


		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("userid", Integer.parseInt(entity.get("userid"))));
			
		List<UserInformation> users = criteria.list();
			
		UserInformation userInformation = users.get(0);

		session.delete(userInformation);

		transaction.commit();

		response.put("message", "User deleted successfully");

		return ResponseEntity.ok().body(response);
        
    }



	public ResponseEntity<Map<String, String>> deleteUserByName(Map<String, String> entity) {
		
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("name", entity.get("name")));
			
		List<UserInformation> users = criteria.list();
			
		session.delete(users);

		transaction.commit();

		response.put("message", "Users deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> deleteUserByCity(Map<String, String> entity) {
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("city", entity.get("city")));
			
		List<UserInformation> users = criteria.list();
			
		session.delete(users);

		transaction.commit();

		response.put("message", "Users deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> deleteUserByPhonenumber(Map<String, String> entity) {
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
			
		List<UserInformation> users = criteria.list();

		if(users.isEmpty()){

			response.put("message", "User not found");
			ResponseEntity.ok().body(response);
		}
			
		UserInformation userInformation = users.get(0);

		session.delete(userInformation);

		transaction.commit();

		response.put("message", "User deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> deleteUserByEmail(Map<String, String> entity) {
	
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(UserInformation.class);
			
		criteria.add(Restrictions.eq("email", entity.get("email")));
			
		List<UserInformation> users = criteria.list();

		if(users.isEmpty()){

			response.put("message", "User not found");
			ResponseEntity.ok().body(response);
		}
			
		UserInformation userInformation = users.get(0);

		session.delete(userInformation);

		transaction.commit();

		response.put("message", "User deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<List> getAllStartwithName(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
		
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.like("name", entity.get("name")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getAllStartwithCity(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.like("city", entity.get("city")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getAllStartwithEmail(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.like("email", entity.get("email")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getAllStartwithPhonenumber(Map<String, String> entity) {

		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(UserInformation.class);
		
		criteria.add(Restrictions.like("phonenumber", entity.get("phonenumber")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
		
	}



	
	
	
	

}
