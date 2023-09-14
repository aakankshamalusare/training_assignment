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

import com.finzly.salondeck.entity.ServiceInformation;

import com.finzly.salondeck.entity.StaffInformation;

@Repository
public class AdminDao {


    @Autowired 
    SessionFactory sessionFactory;

    public ResponseEntity<Map<String, String>> addService(ServiceInformation service) {

        Map<String, String> response = new HashMap<String, String>();
        
        Session session = sessionFactory.openSession();
		
		Transaction transaction =  session.beginTransaction();
		
		Criteria criteria = session.createCriteria(ServiceInformation .class);
		
	    criteria.add(Restrictions.eq("service", service.getService()));
	    
	    List<ServiceInformation > services = criteria.list();
	    
	     if(services.isEmpty()) {
	    	
            //Services service1 = new Services(service.getService(),service.getDescription(),service.getPrice(),service.getDuration(),service.getCategory());
	        session.save(service);
	          
	        transaction.commit();

            response.put("message", "Service added successfully");
            
	        return ResponseEntity.ok().body(response);
        }

        response.put("message", "Service with name already exists");
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> updateService(Map<String, String> entity) {
        
        Map<String, String> response = new HashMap<String, String>();
		
		
		    Session session = sessionFactory.openSession();
			
			Transaction transaction =  session.beginTransaction();
			
			Criteria criteria = session.createCriteria(ServiceInformation .class);
			
			
			criteria.add(Restrictions.eq("serviceid", Integer.parseInt(entity.get("serviceid"))));
			
			List<ServiceInformation > services = criteria.list();
			
			ServiceInformation service = services.get(0);
		   
		    service.setService(entity.get("service"));
            service.setDescription(entity.get("description"));
            service.setPrice(entity.get("price"));
            service.setDuration(entity.get("duration"));
            service.setCategory(entity.get("category"));

            session.update(service);

		    transaction.commit();

		    response.put("message", "Service information updated successfully");

		    return ResponseEntity.ok().body(response);
		
    }

    public ResponseEntity<Map<String, String>> updateServiceName(Map<String, String> entity) {

        Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("service", entity.get("service")));
			
		List<ServiceInformation > services = criteria.list();
			
		ServiceInformation  service = services.get(0);

        service.setService(entity.get("service"));
            
        session.update(service);
        
		   
		transaction.commit();

		response.put("message", " Service name updated successfully");

		return ResponseEntity.ok().body(response);
        
    }

    public ResponseEntity<Map<String, String>> updateDescription(Map<String, String> entity) {
       
        Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
					
	    criteria.add(Restrictions.eq("serviceid", Integer.parseInt(entity.get("serviceid"))));		
		
        List<ServiceInformation > services = criteria.list();
			
        ServiceInformation  service = services.get(0);

        service.setDescription(entity.get("description"));
            
        session.update(service);
        
		   
		transaction.commit();

		response.put("message", " Service description updated successfully");

		return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> updatePrice(Map<String, String> entity) {
        Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
					
	    criteria.add(Restrictions.eq("serviceid", Integer.parseInt(entity.get("serviceid"))));		
		
        List<ServiceInformation > services = criteria.list();
			
        ServiceInformation  service = services.get(0);

        service.setPrice(entity.get("price"));
            
        session.update(service);
        
		   
		transaction.commit();

		response.put("message", " Service price updated successfully");

		return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> updateCategory(Map<String, String> entity) {
         Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
					
	    criteria.add(Restrictions.eq("serviceid", Integer.parseInt(entity.get("serviceid"))));		
		
        List<ServiceInformation > services = criteria.list();
			
        ServiceInformation  service = services.get(0);

        service.setCategory(entity.get("category"));
            
        session.update(service);
        
		   
		transaction.commit();

		response.put("message", " Service category updated successfully");

		return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> updateDuration(Map<String, String> entity) {

        Map<String, String> response = new HashMap<String, String>();
		
		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
					
	    criteria.add(Restrictions.eq("serviceid", Integer.parseInt(entity.get("serviceid"))));		
		
        List<ServiceInformation > services = criteria.list();
			
        ServiceInformation  service = services.get(0);

        service.setDuration(entity.get("duration"));
            
        session.update(service);

		transaction.commit();

		response.put("message", " Service duration updated successfully");

		return ResponseEntity.ok().body(response);
        
    }

    public ResponseEntity<List<ServiceInformation >> getAll() {
        
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
	    return ResponseEntity.ok().body(criteria.list());
    }

    
    public ResponseEntity<List<ServiceInformation >> getByServiceName(Map<String, String> entity) {
       
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("service", entity.get("service")));
			
		return  ResponseEntity.ok().body(criteria.list());
	}

    public ResponseEntity<List<ServiceInformation >> getAllStartwithServiceName(Map<String, String> entity) {
       
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.like("service", entity.get("service")+"%"));
			
		return  ResponseEntity.ok().body(criteria.list());
    }

    public ResponseEntity<List<ServiceInformation >> getByPrice(Map<String, String> entity) {
         
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("price", entity.get("price")));
			
		return  ResponseEntity.ok().body(criteria.list());
    }

    public ResponseEntity<List<ServiceInformation >> getByLessthanPrice(Map<String, String> entity) {
         Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.le("price", entity.get("price")));
			
		return  ResponseEntity.ok().body(criteria.list());
    }

    public ResponseEntity<List<ServiceInformation >> getByGreaterthanPrice(Map<String, String> entity) {
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.gt("price", entity.get("price")));
			
		return  ResponseEntity.ok().body(criteria.list());
    }

    public ResponseEntity<List<ServiceInformation >> getByBetweenPrice(Map<String, String> entity) {
        
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.between("price", entity.get("lprice"),entity.get("hprice")));
			
		return  ResponseEntity.ok().body(criteria.list());
    }

    public ResponseEntity<List<ServiceInformation >>getByCategory(Map<String, String> entity) {
        
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("category", entity.get("category")));
		
        return  ResponseEntity.ok().body(criteria.list());
    }

    public ResponseEntity<List<ServiceInformation >> getAllStartwithServiceCategory(Map<String, String> entity) {
       
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.like("category", entity.get("category")+"%"));
			
		return  ResponseEntity.ok().body(criteria.list());
    }

    public ResponseEntity<List<ServiceInformation >> getByDuration(Map<String, String> entity) {
        
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("duration", entity.get("duration")));
		
        return  ResponseEntity.ok().body(criteria.list());

    }

    public ResponseEntity<List<ServiceInformation >> getByLessthanDuration(Map<String, String> entity) {
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.le("duration", entity.get("duration")));
			
		return  ResponseEntity.ok().body(criteria.list());
    }
    

    public ResponseEntity<List<ServiceInformation >> getByGreaterthanDuration(Map<String, String> entity) {
       
        Session session = sessionFactory.openSession();
			
		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.gt("duration", entity.get("duration")));
			
		return  ResponseEntity.ok().body(criteria.list());
    }

    public ResponseEntity<Map<String, String>> deleteService(Map<String, String> entity) {
        
        Map<String, String> response = new HashMap<String, String>();


		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("staffid", Integer.parseInt(entity.get("staffid"))));
			
		List<ServiceInformation >services= criteria.list();
			
		ServiceInformation  service = services.get(0);

		session.delete(service);

		transaction.commit();

		response.put("message", "Service deleted successfully");

		return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> deleteServiceByServiceName(Map<String, String> entity) {
         Map<String, String> response = new HashMap<String, String>();


		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("service", entity.get("service")));
			
		List<ServiceInformation >services= criteria.list();
			
		ServiceInformation  service = services.get(0);

		session.delete(service);

		transaction.commit();

		response.put("message", "Service deleted successfully");

		return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> deleteServiceByCategory(Map<String, String> entity) {
         Map<String, String> response = new HashMap<String, String>();


		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("category", entity.get("category")));
			
		List<ServiceInformation >services= criteria.list();
		
		session.delete(services);

		transaction.commit();

		response.put("message", "Service deleted successfully");

		return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> deleteServiceByPrice(Map<String, String> entity) {
         
        Map<String, String> response = new HashMap<String, String>();


		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("price", entity.get("price")));
			
		List<ServiceInformation >services= criteria.list();

		session.delete(services);

		transaction.commit();

		response.put("message", "Service deleted successfully");

		return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> deleteServiceByDuration(Map<String, String> entity) {
         Map<String, String> response = new HashMap<String, String>();


		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.eq("duration", entity.get("duration")));
			
		List<ServiceInformation >services= criteria.list();

		session.delete(services);

		transaction.commit();

		response.put("message", "Service deleted successfully");

		return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Map<String, String>> deleteServiceByDescription(Map<String, String> entity) {
        Map<String, String> response = new HashMap<String, String>();


		Session session = sessionFactory.openSession();
			
		Transaction transaction =  session.beginTransaction();

		Criteria criteria = session.createCriteria(ServiceInformation .class);
			
		criteria.add(Restrictions.like("description", entity.get("description")+"%"));
			
		List<ServiceInformation >services= criteria.list();

		session.delete(services);

		transaction.commit();

		response.put("message", "Service deleted successfully");

		return ResponseEntity.ok().body(response);
    }
    
    
}




    

