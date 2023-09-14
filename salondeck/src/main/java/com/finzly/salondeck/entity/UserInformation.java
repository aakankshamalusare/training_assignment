package com.finzly.salondeck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInformation {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", unique = true, updatable = false, nullable = true)
    private Integer userid;
    
    
    @Column(name = "name", unique = false, updatable = true, nullable = false)
    private String name;
    
    @Column(name = "phonenumber", unique = true, updatable = false, nullable = false)
    private String phonenumber;
    
    
    @Column(name = "email", unique = true, updatable = true, nullable = false)
    private String email;
    
    
    @Column(name = "city", unique = false, updatable = true, nullable = false)
    private String city;

    
    @Column(name = "gender", unique = false, updatable = true, nullable = false)
    private String gender;
    
    
    @Column(name = "question", unique = false, updatable = false,nullable = false)
    private String question;

    @Column(name = "answer", unique = false, updatable = false,nullable = false)
    private String answer;

    @Column(name = "password", unique = false, updatable = true , nullable = false)
    private String password;
    
    @Column(name = "admin", unique = false, updatable = false, nullable = false)
    private Integer admin = 0;

    @Column(name = "loginstatus", unique = false, updatable = true, nullable = true)
    private Integer loginStatus;


   
    
    public UserInformation() {
    	
    	
    }
    
    public UserInformation(String name, String phonenumber, String email, String city, String gender,
			String question, String answer, String password, Integer loginStatus) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.question = question;
		this.answer = answer;
		this.password = password;
		this.loginStatus = loginStatus;
	}



	public UserInformation(String name, String phonenumber, String email, String city, String gender,
            String password, int loginStatus) {


		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.city = city;
		this.gender = gender;
	    this.password = password;
		this.loginStatus = loginStatus;


    }

    public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	public Integer getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

	
    

}

