package com.finzly.salondeck.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.salondeck.entity.ServiceInformation;

import com.finzly.salondeck.service.AdminService;

@RestController
@RequestMapping(value ="/salondeck/admin")

public class AdminController {

    @Autowired
    AdminService adminService;


    /**
     *
     * @author Aakanksha
     *  Adds a new service by accepting a ServiceInformation object in the request body.
     *  
     */
    @PostMapping(value="add-service")
    public ResponseEntity<Map<String,String> >addService(@RequestBody ServiceInformation service) {
		 
		 return adminService.addService(service);
		 
	}


    /**
     * @author Aakanksha 
     * Updates an existing service using updated data provided in the request body.
     */
    @PutMapping(value="update-service")
    public ResponseEntity<Map<String,String> >updateService(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updateService(entity);
		 
	}

    /*
     * @author Aakanksha 
     * Updates the service name of an existing service using the updated name provided in the request body
     * 
     */
    
    @PutMapping(value="update-serivename")
     public ResponseEntity<Map<String,String> >updateServiceName(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updateServiceName(entity);
		 
	}

    /**
     * 
     * Updates the description of an existing service using the updated description provided in the request body.
     *      
     */
    @PutMapping(value="update-description")
    public ResponseEntity<Map<String,String> >updateDescription(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updateDescription(entity);
		 
	}


    /**
     * 
     * Updates the price of an existing service using the updated price provided in the request body.
     */
    @PutMapping(value="update-price")
    public ResponseEntity<Map<String,String> >updatePrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updatePrice(entity);
		 
	}


    /**
     * 
     *  Updates the category of an existing service using the updated category provided in the request body.
     */
    @PutMapping(value="update-category")
    public ResponseEntity<Map<String,String> >updateCategory(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updateCategory(entity);
		 
	}

    @PutMapping(value="update-duration")
    public ResponseEntity<Map<String,String> >updateDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updateDuration(entity);
		 
	}


    @GetMapping(value="get-all")
    public ResponseEntity<List<ServiceInformation >> getAll() {
		 
		 return adminService.getAll();
		 
	}

    @GetMapping(value="get-by-serviceName")
    public ResponseEntity<List<ServiceInformation >> getByServiceName(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByServiceName(entity);
		 
	}

    @GetMapping(value="get-all-startwith-serviceName")
    public ResponseEntity<List<ServiceInformation >> getAllStartwithServiceName(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getAllStartwithServiceName(entity);
		 
	}
    

    @GetMapping(value="get-by-price")
    public ResponseEntity<List<ServiceInformation >> getByPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByPrice(entity);
		 
	}

    @GetMapping(value="get-by-lessthan-price")
    public ResponseEntity<List<ServiceInformation >> getByLessthanPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByLessthanPrice(entity);
		 
	}

     @GetMapping(value="get-by-greaterthan-price")
    public ResponseEntity<List<ServiceInformation >> getByGreaterthanPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByGreaterthanPrice(entity);
		 
	}


    @GetMapping(value="get-by-between-price")
    public ResponseEntity<List<ServiceInformation >> getByBetweenPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByBetweenPrice(entity);
		 
	}

    @GetMapping(value="get-by-category")
    public ResponseEntity<List<ServiceInformation >> getByCategory(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByCategory(entity);
		 
	}


     @GetMapping(value="get-all-startwith-category")
    public ResponseEntity<List<ServiceInformation >> getAllStartwihCategory(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getAllStartwithCategory(entity);
		 
	}

    @GetMapping(value="get-by-duration")
    public ResponseEntity<List<ServiceInformation >> getByDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByDuration(entity);
		 
	}


    @GetMapping(value="get-by-lessthan-duration")
    public ResponseEntity<List<ServiceInformation >> getByLessthanDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByLessthanDuration(entity);
		 
	}

     @GetMapping(value="get-by-greaterthan-duration")
    public ResponseEntity<List<ServiceInformation >> getByGreaterthanDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByGreaterthanDuration(entity);
		 
	}


    @DeleteMapping(value="delete-service")
    public ResponseEntity<Map<String,String> >deleteService(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteService(entity);
		 
	}

    @DeleteMapping(value="delete-service-by-serviceName")
    public ResponseEntity<Map<String,String> >deleteServiceByServiceName(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByServiceName(entity);
		 
	}

    @DeleteMapping(value="delete-service-by-category")
    public ResponseEntity<Map<String,String> >deleteServiceByCategory(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByCategory(entity);
		 
	}


    @DeleteMapping(value="delete-service-by-price")
    public ResponseEntity<Map<String,String> >deleteServiceByPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByPrice(entity);
		 
	}


    @DeleteMapping(value="delete-service-by-duration")
    public ResponseEntity<Map<String,String> >deleteServiceByDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByDuration(entity);
		 
	}


     @DeleteMapping(value="delete-service-by-description")
    public ResponseEntity<Map<String,String> >deleteServiceByDescription(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByDescription(entity);
		 
	}




    








    

    















    
}
