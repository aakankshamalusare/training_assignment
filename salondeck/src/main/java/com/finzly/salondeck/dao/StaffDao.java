package com.finzly.salondeck.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.finzly.salondeck.entity.StaffInformation;
import com.finzly.salondeck.entity.UserInformation;

@Repository
public class StaffDao {

    @Autowired 
	SessionFactory sessionfactory;
	
	

	public ResponseEntity<String> signUp(Map<String, String> entity) {
		
		
		Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
	    
	    List<StaffInformation> users = criteria.list();
	    
	     if(users.isEmpty()) {
	    	
            StaffInformation StaffInformation = new StaffInformation(entity.get("name"), entity.get("phonenumber"), entity.get("email"), entity.get("city"), entity.get("gender"),
            entity.get("question"), entity.get("answer"),entity.get("password"),entity.get("position"),entity.get("salary"),entity.get("hireDate"),1);
    
	          
	        session.save(StaffInformation);
	          
	          transaction.commit();
	          return ResponseEntity.ok().body("You are signed up successfully");
	    	
	    }
	     
	     
	     return ResponseEntity.ok().body("User already registered");
       
	}



	public ResponseEntity<Map<String, String>> loginByPhonenumber(Map<String, String> entity) {
		
		
		Map<String, String> response = new HashMap<String, String>();
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
	    
	    
	    List<StaffInformation> users = criteria.list();
	    
	    if(users.isEmpty()) {
	    	
	    	   response.put("message", "User have to registered");
	    	    return ResponseEntity.badRequest().body(response);
	            //flag=1;
	    	
	    	
	    }
	    
	    int flag = 0;
	    
	    StaffInformation userObj = users.get(0);
	    
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
	            //response.put("admin", userObj.getAdmin().toString());
	            session.save(userObj);
	            transaction.commit();

	        }

	        return ResponseEntity.ok().body(response);

	}



	public ResponseEntity<Map<String, String>> loginByEmail(Map<String, String> entity) {
		
		
		Map<String, String> response = new HashMap<String, String>();
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
	    
	    
	    List<StaffInformation> users = criteria.list();
	    
	    if(users.isEmpty()) {
	    	
	    	   response.put("message", "User have to registered");
	    	    return ResponseEntity.badRequest().body(response);
	            //flag=1;
	    	
	    	
	    }
	    
	    int flag = 0;
	    
	    StaffInformation userObj = users.get(0);
	    
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
	           
	            session.save(userObj);
	            transaction.commit();

	        }

	        return ResponseEntity.ok().body(response);
	    
	}



	public ResponseEntity<String> getQuestion(Map<String, String> entity) {
		
		
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
		
		
	    List<StaffInformation> users = criteria.list();
      
	    if (users.isEmpty()) {
            return ResponseEntity.ok().body("User does not exist.");
        }

        StaffInformation us = users.get(0);

        return ResponseEntity.ok().body(us.getQuestion());
	}



	public ResponseEntity<String> updatePassword(Map<String, String> entity) {
		
		
		
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
	    criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
		
		
	    List<StaffInformation> users = criteria.list();
		

	     StaffInformation usObj = users.get(0);

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
			
			Criteria criteria = session.createCriteria(StaffInformation.class);
			
			
			criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
			List<StaffInformation> users = criteria.list();
			
			StaffInformation staffInformation = users.get(0);
		   
		    staffInformation.setName(entity.get("name"));
            staffInformation.setPhonenumber(entity.get("phonenumber"));
            staffInformation.setEmail(entity.get("email"));
            staffInformation.setCity(entity.get("city"));
            staffInformation.setGender( entity.get("gender"));
            staffInformation.setPosition(entity.get("position"));
            staffInformation.setLoginStatus(0);
            session.update(staffInformation);
		   
		   transaction.commit();

		   response.put("message", "Employee profile update successfully");

		    return ResponseEntity.ok().body(response);
		
	}



	public ResponseEntity<List<StaffInformation>> getAll() {
		
		
		 Session session = sessionfactory.openSession();
			
		 Transaction transaction =  session.beginTransaction();
			
		 Criteria criteria = session.createCriteria(StaffInformation.class);
			
		
		 return ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByGender(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.eq("gender", entity.get("gender")));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByPhonenumber(Map<String, String> entity) {
		
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByEmail(Map<String, String> entity) {
		
        Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.eq("email", entity.get("email")));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByCity(Map<String, String> entity) {
		 
		    Session session = sessionfactory.openSession();
			
			Transaction transaction =  session.beginTransaction();
				
			Criteria criteria = session.createCriteria(StaffInformation.class);
			
			criteria.add(Restrictions.eq("city", entity.get("city")));
			
			return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getByLogin(Map<String, String> entity) {
		
		 Session session = sessionfactory.openSession();
			
			Transaction transaction =  session.beginTransaction();
				
			Criteria criteria = session.createCriteria(StaffInformation.class);
			
			criteria.add(Restrictions.eq("loginstatus", entity.get("loginstatus")));
			
			return  ResponseEntity.ok().body(criteria.list());

	}



	public ResponseEntity<List<StaffInformation>> getByPosition(Map<String, String> entity) {
		
		 Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("position", entity.get("position")));
			
		return  ResponseEntity.ok().body(criteria.list());
	}



    public ResponseEntity<List<StaffInformation>> getByHireDate(Map<String, String> entity) {

		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);


		Date hireDate = null;
        	try {
				hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(entity.get("hireDate"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		criteria.add(Restrictions.eq("hireDate", hireDate));
			
		return  ResponseEntity.ok().body(criteria.list());
        
    }



	public ResponseEntity<String> logOut(Map<String, String> entity) {
		
		
		Session session = sessionfactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.eq("loginstatus", entity.get("loginstatus")));
		
		List<StaffInformation> users = criteria.list();
		
	    StaffInformation user = users.get(0);
	    
	    user.setLoginStatus(0);
	    
	    session.update(user);
	    
	    transaction.commit();
		   
	    return ResponseEntity.ok().body("Logged Out Successfully");
	
	}

    /*
	 * 13 Sept
	 */

	public ResponseEntity<List<StaffInformation>> getByLeaves(Map<String,String> entity) {


		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("leaves", entity.get("leaves")));
			
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List<StaffInformation>> getBySalary(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("salary", entity.get("salary")));
			
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List<StaffInformation>> getByLessthanSalary(Map<String, String> entity) {

		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.le("salary", entity.get("salary")));
			
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List<StaffInformation>> getByGreaterthanSalary(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.gt("salary", entity.get("salary")));
			
		return  ResponseEntity.ok().body(criteria.list());
	}



    public ResponseEntity<List<StaffInformation>> getByBetweenSalary(Map<String, String> entity) {

		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.between("salary", entity.get("lsalary"),entity.get("hsalary")));
			
		return  ResponseEntity.ok().body(criteria.list());
        
    }



	public ResponseEntity<List<StaffInformation>> getByLessthanLeaves(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.le("leaves", entity.get("leaves")));
			
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List<StaffInformation>> getByGreaterthanLeaves(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.gt("leaves", entity.get("leaves")));
			
		return  ResponseEntity.ok().body(criteria.list());
	}



    public ResponseEntity<List<StaffInformation>> getByBetweenLeaves(Map<String, String> entity) {
        
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.between("leaves", entity.get("lleaves"),entity.get("hleaves")));
			
		return  ResponseEntity.ok().body(criteria.list());
    }



	public ResponseEntity<List<StaffInformation>> getByBeforeHireDate(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);


		Date hireDate = null;
        	try {
				hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(entity.get("hireDate"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		criteria.add(Restrictions.le("hireDate", hireDate));
			
		return  ResponseEntity.ok().body(criteria.list());
        
	}



	public ResponseEntity<List<StaffInformation>> getByAfterHireDate(Map<String, String> entity) {
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);


		Date hireDate = null;
        	try {
				hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(entity.get("hireDate"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		criteria.add(Restrictions.gt("hireDate", hireDate));
			
		return  ResponseEntity.ok().body(criteria.list());
        
	}



    public ResponseEntity<List<StaffInformation>> getByBetweenHireDate(Map<String, String> entity) {
        
		Session session = sessionfactory.openSession();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);


		Date lhireDate = null;
		Date hhireDate = null;
        	try {
				lhireDate = new SimpleDateFormat("yyyy-MM-dd").parse(entity.get("lhireDate"));
				hhireDate = new SimpleDateFormat("yyyy-MM-dd").parse(entity.get("hhireDate"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		criteria.add(Restrictions.between("hireDate", entity.get("lhireDate"),entity.get("hhireDate")));
			
		return  ResponseEntity.ok().body(criteria.list());
    }


// Multiple value
	public ResponseEntity<Map<String, String>> updateName(Map<String, String> entity) {
		 
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
		List<StaffInformation> users = criteria.list();
			
		StaffInformation staffInformation = users.get(0);
		   
		staffInformation.setName(entity.get("name"));
        staffInformation.setLoginStatus(0);
        session.update(staffInformation);
		   
		transaction.commit();

		response.put("message", " Employee name update successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> updatePhonenumber(Map<String, String> entity) {
		
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
		List<StaffInformation> users = criteria.list();
			
		StaffInformation staffInformation = users.get(0);
		   
		staffInformation.setPhonenumber(entity.get("phonenumber"));
        staffInformation.setLoginStatus(0);
        session.update(staffInformation);
		   
		transaction.commit();

		response.put("message", "Employee phonenumber update successfully");

		return ResponseEntity.ok().body(response);
	}



    public ResponseEntity<Map<String, String>> updateEmail(Map<String, String> entity) {
        
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
		List<StaffInformation> users = criteria.list();
			
		StaffInformation staffInformation = users.get(0);
		   
		staffInformation.setEmail(entity.get("email"));
        staffInformation.setLoginStatus(0);
        session.update(staffInformation);
		   
		transaction.commit();

		response.put("message", "Employee email update successfully");

		return ResponseEntity.ok().body(response);
    }



    public ResponseEntity<Map<String, String>> updateCity(Map<String, String> entity) {
       
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
		List<StaffInformation> users = criteria.list();
			
		StaffInformation staffInformation = users.get(0);
		   
		staffInformation.setCity(entity.get("city"));
        staffInformation.setLoginStatus(0);
        session.update(staffInformation);
		   
		transaction.commit();

		response.put("message", "Employee city update successfully");

		return ResponseEntity.ok().body(response);
    }



    public ResponseEntity<Map<String, String>> updatePosition(Map<String, String> entity) {
        Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
		List<StaffInformation> users = criteria.list();
			
		StaffInformation staffInformation = users.get(0);
		   
		staffInformation.setPosition(entity.get("position"));
        staffInformation.setLoginStatus(0);
        session.update(staffInformation);
		   
		transaction.commit();

		response.put("message", "Employee position update successfully");

		return ResponseEntity.ok().body(response);
    }



    public ResponseEntity<Map<String, String>> updateSalary(Map<String, String> entity) {
        
		Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
		List<StaffInformation> users = criteria.list();
			
		StaffInformation staffInformation = users.get(0);
		   
		staffInformation.setSalary(entity.get("salary"));
        staffInformation.setLoginStatus(0);
        session.update(staffInformation);
		   
		transaction.commit();

		response.put("message", "Employee salary update successfully");

		return ResponseEntity.ok().body(response);
    }



	public ResponseEntity<Map<String, String>> deleteEmployee(Map<String, String> entity) {
		
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
		List<StaffInformation> users = criteria.list();
			
		StaffInformation staffInformation = users.get(0);

		session.delete(staffInformation);

		transaction.commit();

		response.put("message", "Employee deleted successfully");

		return ResponseEntity.ok().body(response);
        
	}



	public ResponseEntity<Map<String, String>> deleteEmployeeByName(Map<String, String> entity) {
		
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("name", entity.get("name")));
			
		List<StaffInformation> users = criteria.list();

		session.delete(users);

		transaction.commit();

		response.put("message", "Employees deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> deleteEmployeeByCity(Map<String, String> entity) {
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("city", entity.get("city")));
			
		List<StaffInformation> users = criteria.list();

		session.delete(users);

		transaction.commit();

		response.put("message", "Employees deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> deleteEmployeeByPhonenumber(Map<String, String> entity) {
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("phonenumber", entity.get("phonenumber")));
			
		List<StaffInformation> users = criteria.list();

		if(users.isEmpty()){

			response.put("message", "Employee not found");
			ResponseEntity.ok().body(response);
		}
			
		StaffInformation staffInformation = users.get(0);

		session.delete(staffInformation);

		transaction.commit();

		response.put("message", "Employee deleted successfully");

		return ResponseEntity.ok().body(response);
	}



    public ResponseEntity<Map<String, String>> deleteEmployeeByEmail(Map<String, String> entity) {
        Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("email", entity.get("email")));
			
		List<StaffInformation> users = criteria.list();

		if(users.isEmpty()){

			response.put("message", "Employee not found");
			ResponseEntity.ok().body(response);
		}
			
		StaffInformation staffInformation = users.get(0);

		session.delete(staffInformation);

		transaction.commit();

		response.put("message", "Employee deleted successfully");

		return ResponseEntity.ok().body(response);
    }



	public ResponseEntity<Map<String, String>> deleteEmployeeByPosition(Map<String, String> entity) {
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("position", entity.get("position")));
			
		List<StaffInformation> users = criteria.list();

		session.delete(users);

		transaction.commit();

		response.put("message", "Employees deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> deleteEmployeeBySalary(Map<String, String> entity) {
		
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("salary", entity.get("salary")));
			
		List<StaffInformation> users = criteria.list();

		session.delete(users);

		transaction.commit();

		response.put("message", "Employees deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> deleteEmployeeByHireDate(Map<String, String> entity) {

		Map<String, String> response = new HashMap<String, String>();

		Session session = sessionfactory.openSession();

		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(StaffInformation.class);


		Date hireDate = null;
        	try {
				hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(entity.get("hireDate"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		
		criteria.add(Restrictions.eq("hireDate", entity.get("hireDate")));
		List<StaffInformation> users = criteria.list();

		session.delete(users);

		transaction.commit();

		response.put("message", "Employees deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<Map<String, String>> deleteEmployeeByLeaves(Map<String, String> entity) {
		Map<String, String> response = new HashMap<String, String>();


		Session session = sessionfactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(StaffInformation.class);
			
		criteria.add(Restrictions.eq("leaves", Integer.parseInt(entity.get("leaves"))));
			
		List<StaffInformation> users = criteria.list();

		session.delete(users);

		transaction.commit();

		response.put("message", "Employees deleted successfully");

		return ResponseEntity.ok().body(response);
	}



	public ResponseEntity<List> getAllStartwithName(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.like("name", entity.get("name")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getAllStartwithCity(Map<String, String> entity) {
		Session session = sessionfactory.openSession();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.like("city", entity.get("city")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getAllStartwithEmail(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.like("email", entity.get("email")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getAllStartwithPhonenumber(Map<String, String> entity) {
		Session session = sessionfactory.openSession();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.like("phonenumber", entity.get("phonenumber")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getAllStartwithPosition(Map<String, String> entity) {
		Session session = sessionfactory.openSession();
		
		Criteria criteria = session.createCriteria(StaffInformation.class);
		
		criteria.add(Restrictions.like("position", entity.get("position")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}



	public ResponseEntity<List> getAllStartwithHireDate(Map<String, String> entity) {
		
		Session session = sessionfactory.openSession();

        Criteria criteria = session.createCriteria(StaffInformation.class);


		Date hireDate = null;
        	try {
				hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(entity.get("hireDate"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		
		criteria.add(Restrictions.like("hireDate", entity.get("hireDate")+"%"));
		
		return  ResponseEntity.ok().body(criteria.list());
	}
	


}
