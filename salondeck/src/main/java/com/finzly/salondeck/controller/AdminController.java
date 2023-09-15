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
     * @author Aakanksha 
     * Updates the description of an existing service using the updated description provided in the request body.
     *      
     */
    @PutMapping(value="update-description")
    public ResponseEntity<Map<String,String> >updateDescription(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updateDescription(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     * Updates the price of an existing service using the updated price provided in the request body.
     */
    @PutMapping(value="update-price")
    public ResponseEntity<Map<String,String> >updatePrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updatePrice(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     *  Updates the category of an existing service using the updated category provided in the request body.
     */
    @PutMapping(value="update-category")
    public ResponseEntity<Map<String,String> >updateCategory(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updateCategory(entity);
		 
	}

    /**
     *
     * @author Aakanksha 
     * Updates the duration of an existing service using the updated duration provided in the request body.
     */
    @PutMapping(value="update-duration")
    public ResponseEntity<Map<String,String> >updateDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.updateDuration(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     * Retrieves a list of all services.
     */
    @GetMapping(value="get-all")
    public ResponseEntity<List<ServiceInformation >> getAll() {
		 
		 return adminService.getAll();
		 
	}

    /**
     * 
     * @author Aakanksha 
     *  Retrieves a list of services matching a specific service name provided in the request body.
     */
    @GetMapping(value="get-by-serviceName")
    public ResponseEntity<List<ServiceInformation >> getByServiceName(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByServiceName(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     * Retrieves a list of services whose names start with a specific prefix provided in the request body.
     */
    @GetMapping(value="get-all-startwith-serviceName")
    public ResponseEntity<List<ServiceInformation >> getAllStartwithServiceName(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getAllStartwithServiceName(entity);
		 
	}
    

    /**
     * 
     * @author Aakanksha 
     * Retrieves a list of services based on a specific price provided.
     */
    @GetMapping(value="get-by-price")
    public ResponseEntity<List<ServiceInformation >> getByPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByPrice(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     *Retrieves a list of services with prices less than the value provided.
     */
    @GetMapping(value="get-by-lessthan-price")
    public ResponseEntity<List<ServiceInformation >> getByLessthanPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByLessthanPrice(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     *  Retrieves a list of services with prices greater than the value provided.
     */
     @GetMapping(value="get-by-greaterthan-price")
    public ResponseEntity<List<ServiceInformation >> getByGreaterthanPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByGreaterthanPrice(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     *Retrieves a list of services with prices falling within a specified range provided.
     */
    @GetMapping(value="get-by-between-price")
    public ResponseEntity<List<ServiceInformation >> getByBetweenPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByBetweenPrice(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     * Retrieves a list of services matching a specific category provided.
     */
    @GetMapping(value="get-by-category")
    public ResponseEntity<List<ServiceInformation >> getByCategory(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByCategory(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     * Retrieves a list of services whose categories start with a specific prefix provided.
     */
     @GetMapping(value="get-all-startwith-category")
    public ResponseEntity<List<ServiceInformation >> getAllStartwihCategory(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getAllStartwithCategory(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     * Retrieves a list of services based on a specific duration provided.
     */
    @GetMapping(value="get-by-duration")
    public ResponseEntity<List<ServiceInformation >> getByDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByDuration(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     * Retrieves a list of services with durations less than the value provided. 
     */
    @GetMapping(value="get-by-lessthan-duration")
    public ResponseEntity<List<ServiceInformation >> getByLessthanDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByLessthanDuration(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     * Retrieves a list of services with durations greater than the value provided.
     */
     @GetMapping(value="get-by-greaterthan-duration")
    public ResponseEntity<List<ServiceInformation >> getByGreaterthanDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.getByGreaterthanDuration(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     * Deletes a service based on information provided.
     */
    @DeleteMapping(value="delete-service")
    public ResponseEntity<Map<String,String> >deleteService(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteService(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     *  Deletes services based on a specific service name provided.
     */
    @DeleteMapping(value="delete-service-by-serviceName")
    public ResponseEntity<Map<String,String> >deleteServiceByServiceName(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByServiceName(entity);
		 
	}

    /**
     * 
     * @author Aakanksha 
     * Deletes services based on a specific category provided.
     */
    @DeleteMapping(value="delete-service-by-category")
    public ResponseEntity<Map<String,String> >deleteServiceByCategory(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByCategory(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     * Deletes services based on a specific price provided.
     */
    @DeleteMapping(value="delete-service-by-price")
    public ResponseEntity<Map<String,String> >deleteServiceByPrice(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByPrice(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     * Deletes services based on a specific duration provided.
     */
    @DeleteMapping(value="delete-service-by-duration")
    public ResponseEntity<Map<String,String> >deleteServiceByDuration(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByDuration(entity);
		 
	}


    /**
     * 
     * @author Aakanksha 
     *Deletes services based on a specific description provided.
     */
     @DeleteMapping(value="delete-service-by-description")
    public ResponseEntity<Map<String,String> >deleteServiceByDescription(@RequestBody Map<String, String> entity) {
		 
		 return adminService.deleteServiceByDescription(entity);
		 
	}


    /**
     * 15 sept
     */




    








    

    















    
}
