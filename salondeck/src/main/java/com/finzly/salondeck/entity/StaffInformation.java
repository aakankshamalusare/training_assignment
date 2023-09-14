package com.finzly.salondeck.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff_info")
public class StaffInformation {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "staffid", unique = true, updatable = false, nullable = false)
	    private Integer staffid;
	    
	    
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

	    @Column(name = "question", unique = false, updatable = false, nullable = false)
	    private String question;

	    @Column(name = "answer", unique = false, updatable = false, nullable = false)
	    private String answer;

	    @Column(name = "password", unique = false, updatable = true, nullable = false)
	    private String password;
	    
	    @Column(name = "position", unique = false, updatable = true, nullable = false)
	    private String position;
	    
	    @Column(name = "salary", unique = false, updatable = true, nullable = false)
	    private String salary;
	    
	    @Column(name = "hireDate", unique = false, updatable = true, nullable = false)
	    private Date hireDate;
	    
	    @Column(name = "loginstatus", unique = false, updatable = true, nullable = true)
	    private Integer loginStatus;

	    @Column(name = "leaves", unique = false, updatable = true, nullable = true)
	    private Integer leaves=0;
	    
	    
		public StaffInformation() {
	    	
	    	
	    }
	    
	    public StaffInformation(String name, String phonenumber, String email, String city, String gender,
				String question, String answer, String password, String position, String salary, String hireDate,
				Integer loginStatus)  {
			super();
			this.name = name;
			this.phonenumber = phonenumber;
			this.email = email;
			this.city = city;
			this.gender = gender;
			this.question = question;
			this.answer = answer;
			this.password = password;
			this.position = position;
			this.salary = salary;
			try {
				this.hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(hireDate);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			this.loginStatus = loginStatus;
		}

	    
	    public Integer getStaffid() {
			return staffid;
		}

		public void setStaffid(Integer staffid) {
			this.staffid = staffid;
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

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getSalary() {
			return salary;
		}

		public void setSalary(String salary) {
			this.salary = salary;
		}

		public Date getHireDate() {
			return hireDate;
		}

		public void setHireDate(Date hireDate) {
			this.hireDate = hireDate;
		}

		public Integer getLoginStatus() {
			return loginStatus;
		}

		public void setLoginStatus(Integer loginStatus) {
			this.loginStatus = loginStatus;
		}
		
		public Integer getLeaves() {
			return leaves;
		}

		public void setLeaves(Integer leaves) {
			this.leaves = leaves;
		}


		
	    

	}


