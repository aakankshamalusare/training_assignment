package com.finzly.salondeck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_info")
public class ProductInformation {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "productid", unique = true, updatable = false, nullable = false)
	  private Integer productid;

      @Column(name = "product", unique = true, updatable = true, nullable = false)
	  private String product;
	
      @Column(name = "description", unique = true, updatable = false, nullable = false)
	  private String description;  
      
      @Column(name = "price", unique = false, updatable = true, nullable = false)
	  private String price;


      @Column(name = "category", unique = false, updatable = false, nullable = false)
	  private String category;


      //later make false
      @Column(name = "producturl", unique = false, updatable = true, nullable = true)
	  private String producturl;

      @Column(name = "rating", unique = false, updatable = true, nullable = false)
	  private Double rating=0.0;

    public ProductInformation(String product, String description, String price, String category, String producturl) {
        this.product = product;
        this.description = description;
        this.price = price;
        this.category = category;
        this.producturl = producturl;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducturl() {
        return producturl;
    }

    public void setProducturl(String producturl) {
        this.producturl = producturl;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    


    
}
