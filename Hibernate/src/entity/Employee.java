package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {


	    @Id
	    private int id;
	    private String fname;
	    private String lname;
	    private Date dateOfBirth;
	    private String email;
	    private String department;
	    private double salary;
	    
	    

	    public Employee(){

	    }

	    public Employee(String fname, String lname, Date dateOfBirth, String email, String department,
	            double salary) {
	  
	        this.fname = fname;
	        this.lname = lname;
	        this.dateOfBirth = dateOfBirth;
	        this.email = email;
	        this.department = department;
	        this.salary = salary;
	    }
	    
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getFname() {
	        return fname;
	    }
	    public void setFname(String fname) {
	        this.fname = fname;
	    }
	    public String getLname() {
	        return lname;
	    }
	    public void setLname(String lname) {
	        this.lname = lname;
	    }
	    public Date getDateOfBirth() {
	        return dateOfBirth;
	    }
	    public void setDateOfBirth(Date dateOfBirth) {
	        this.dateOfBirth = dateOfBirth;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String getDepartment() {
	        return department;
	    }
	    public void setDepartment(String department) {
	        this.department = department;
	    }
	    public double getSalary() {
	        return salary;
	    }
	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

	       
	    @Override
	    public String toString() {
	        return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", dateOfBirth=" + dateOfBirth
	                + ", email=" + email + ", department=" + department + ", salary=" + salary + "]";
	    }

	    

}
