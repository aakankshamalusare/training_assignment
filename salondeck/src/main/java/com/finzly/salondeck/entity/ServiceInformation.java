package com.finzly.salondeck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class ServiceInformation {

  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "serviceid", unique = true, updatable = false, nullable = false)
	  private Integer serviceid;

      @Column(name = "service", unique = true, updatable = true, nullable = false)
	  private String service;
	
      @Column(name = "description", unique = true, updatable = false, nullable = false)
	  private String description;  
      
      @Column(name = "price", unique = false, updatable = true, nullable = false)
	  private String price;

      @Column(name = "duration", unique = false, updatable = true, nullable = false)
	  private String duration;

      @Column(name = "category", unique = false, updatable = false, nullable = false)
	  private String category;



      public ServiceInformation(){

        
      }

    public ServiceInformation(String service, String description, String price, String duration, String category) {
        this.service = service;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.category = category;
    }
    
    
      public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
	    
	    
		
	    
	    

	    
	  



	 

	    
}
