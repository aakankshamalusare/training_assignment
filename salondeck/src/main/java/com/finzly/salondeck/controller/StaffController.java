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

import com.finzly.salondeck.entity.StaffInformation;
import com.finzly.salondeck.entity.UserInformation;
import com.finzly.salondeck.service.StaffService;

@RestController

@RequestMapping(value="/salondeck/staff")
public class StaffController {
	
	@Autowired 
	 StaffService staffService;
	
	
	 /**
	  * @author Aakanksha 
	  * Allows a user to sign up by providing information in the request body.
	  *
	  */
	 @PostMapping(value="/sign-up")
	 public ResponseEntity<String> signUp(@RequestBody Map<String, String> entity) {
		 
		 return staffService.signUp(entity);
		 
	 }
	 
	 /**
	  *  @author Aakanksha 
	  *  Allows a user to log in using their phone number by providing the phone number in the request body.
	  */
	 @PostMapping(value="/login-by-phonenumber")
	 public ResponseEntity<Map<String,String>> loginByPhonenumber(@RequestBody Map<String, String> entity){
		 
		 
		 return staffService.loginByPhonenumber(entity);
		 
	 }
	 

	 /**
	  * @author Aakanksha 
	  * Allows a user to log in using their email address by providing the email address in the request body.
	  */
	 @PostMapping(value="/login-by-email")
	 public ResponseEntity<Map<String,String>> loginByEmail(@RequestBody Map<String, String> entity){
		 
		 
		 return staffService.loginByEmail(entity);
		 
	 }
	 
	 
	 /**
	  * @author Aakanksha 
	  * Retrieves a security question for a user based on the information provided in the request body.
	  */
	  @PostMapping(value="/get-question")
	    public ResponseEntity<String> getQuestion(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return staffService.getQuestion(entity);
	    }
	 
	 /**
	  * @author Aakanksha 
	  * Allows a user to update their password based on the information provided in the request body.
	  */
	 @PostMapping(value="/update-password")
	 public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return staffService.updatePassword(entity);
	 }
	 
	 /**
	  * @author Aakanksha 
	  * Updates the user's profile information based on the information provided in the request body.
	  */
	 @PutMapping(value="/update-profile")
	 public ResponseEntity<Map<String,String>> updateProfile(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return staffService.updateProfile(entity);
	 }
	 

	 /**
	  * @author Aakanksha 
	  * Retrieves a list of all staff members.
	  */
	@GetMapping(value="/get-all")
	 public ResponseEntity<List<StaffInformation>> getAll(){
		 
		 return staffService.getAll();
		 
     }
	
	
     /**
	  * @author Aakanksha 
	  * Retrieves staff members based on their gender, with the gender provided in the request body.
	  */
	 @GetMapping(value="get-by-gender")
	 public ResponseEntity<List> getByGender(@RequestBody Map<String,String>entity){

		return staffService.getByGender(entity);
	
	}

	/**
	 * @author Aakanksha 
	 *  Retrieves staff members based on their phone number, with the phone number provided in the request body.
	 */
	@GetMapping(value="get-by-phonenumber")
	 public ResponseEntity<List> getByPhonenumber(@RequestBody Map<String,String>entity){

		return staffService.getByPhonenumber(entity);
	
	}

	/**
	 * @author Aakanksha 
	 * Retrieves staff members based on their email address, with the email address provided in the request body.
	 */	
	@GetMapping(value="get-by-email")
	 public ResponseEntity<List> getByEmail(@RequestBody Map<String,String>entity){

		return staffService.getByEmail(entity);
	
	}

	
	/**
	 * @author Aakanksha 
	 * Retrieves staff members based on their name, with the name provided in the request body.
	 */
	@GetMapping(value="get-by-name")
	 public ResponseEntity<List> getByName(@RequestBody Map<String,String>entity){

		return staffService.getByEmail(entity);
	
	}

	/**
	 *  @author Aakanksha 
	 *  Retrieves staff members based on their city, with the city provided in the request body.
	 */
	@GetMapping(value="get-by-city")
	 public ResponseEntity<List> getByCity(@RequestBody Map<String,String>entity){

		return staffService.getByCity(entity);
	
	}

	/**
	 * @author Aakanksha 
	 * Retrieves staff members based on their login information, with the login information provided in the request body.
	 */
	@GetMapping(value="get-by-login")
	 public ResponseEntity<List> getByLogin(@RequestBody Map<String,String>entity){

		return staffService.getByLogin(entity);
	
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members based on their position, with the position provided in the request body.
	 */
	@GetMapping(value ="get-by-position")
	public ResponseEntity<List<StaffInformation>> getPosition(@RequestBody Map<String,String>entity){

		return staffService.getByPosition(entity);
	
	}

	/**
	 * @author Aakanksha 
	 * Retrieves staff members based on their hire date, with the hire date provided in the request body.
	 */
	@GetMapping(value ="get-by-hireDate")
	public ResponseEntity<List<StaffInformation>> getByHireDate(@RequestBody Map<String,String>entity){

		return staffService.getByHireDate(entity);
    }

	/**
	 * @author Aakanksha 
	 * Allows a user to log out based on the information provided in the request body.
	 */
	@PostMapping("/log-out")
    public ResponseEntity<String> logOut(@RequestBody Map<String, String> entity) {
        // Check Data

        return staffService.logOut(entity);
    }
	 
     /*
	  *  13 Sept
	  */


	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members based on their salary, with the salary provided in the request body.
	 */
	@GetMapping(value="/get-by-salary")
	public ResponseEntity<List<StaffInformation>> getBySalary(@RequestBody Map<String,String>entity){

		return staffService.getBySalary(entity);
    }


	/**
	 * 
	 * @author Aakanksha 
	 *  Retrieves staff members with salaries less than the value provided in the request body.
	 */
	@GetMapping(value="/get-by-lessthan-salary")
	public ResponseEntity<List<StaffInformation>> getByLessthanSalary(@RequestBody Map<String,String>entity){

		return staffService.getByLessthanSalary(entity);
    }

	/**
	 * @author Aakanksha 
	 * Retrieves staff members with salaries greater than the value provided in the request body.
	 */
	@GetMapping(value="/get-by-greaterthan-salary")
	public ResponseEntity<List<StaffInformation>> getByGreaterthanSalary(@RequestBody Map<String,String>entity){

		return staffService.getByGreaterthanSalary(entity);
    }


	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members with salaries falling within a specified range provided in the request body.
	 */
	@GetMapping(value="/get-by-between-salary")
	public ResponseEntity<List<StaffInformation>> getByBetweenSalary(@RequestBody Map<String,String>entity){

		return staffService.getByBetweenSalary(entity);
    }


	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members based on the number of leaves, with the leaves count provided in the request body.
	 */
    @GetMapping(value ="get-by-leaves")
	public ResponseEntity<List<StaffInformation>> getByLeaves(@RequestBody Map<String,String>entity){

		return staffService.getByLeaves(entity);
	
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members with a leaves count less than the value provided in the request body.
	 */
	@GetMapping(value ="get-by-lessthan-leaves")
	public ResponseEntity<List<StaffInformation>> getByLessthanLeaves(@RequestBody Map<String,String>entity){

		return staffService.getByLessthanLeaves(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 *Retrieves staff members with a leaves count greater than the value provided in the request body.
	 */
	@GetMapping(value ="get-by-greaterthan-leaves")
	public ResponseEntity<List<StaffInformation>> getByGreaterthanLeaves(@RequestBody Map<String,String>entity){

		return staffService.getByGreaterthanLeaves(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members with leaves counts falling within a specified range provided in the request body.
	 */
	@GetMapping(value ="get-by-between-leaves")
	public ResponseEntity<List<StaffInformation>> getByBetweenLeaves(@RequestBody Map<String,String>entity){

		return staffService.getByBetweenLeaves(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members hired before the specified hire date provided in the request body.
	 */
	@GetMapping(value ="get-by-before-hireDate")
	public ResponseEntity<List<StaffInformation>> getByBeforeHireDate(@RequestBody Map<String,String>entity){

		return staffService.getByBeforeHireDate(entity);
    }

	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members hired after the specified hire date provided in the request body.
	 */
	@GetMapping(value ="get-by-after-hireDate")
	public ResponseEntity<List<StaffInformation>> getByAfterHireDate(@RequestBody Map<String,String>entity){

		return staffService.getByAfterHireDate(entity);
    }


	/**
	 * 
	 *@author Aakanksha 
	 * Retrieves staff members hired within a specified range of hire dates provided in the request body.
	 */
	@GetMapping(value ="get-by-between-hireDate")
	public ResponseEntity<List<StaffInformation>> getByBetweenHireDate(@RequestBody Map<String,String>entity){

		return staffService.getByBetweenHireDate(entity);
    }


	/**
	 * 
	 * @author Aakanksha 
	 * Updates the name of a staff member based on the information provided in the request body.
	 */
	@PutMapping(value ="update-name")
	public ResponseEntity<Map<String, String>> updateName(@RequestBody Map<String,String>entity){

		return staffService.updateName(entity);
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Updates the phone number of a staff member based on the information provided in the request body.
	 */
	@PutMapping(value ="update-phonenumber")
	public ResponseEntity<Map<String, String>> updatePhonenumber(@RequestBody Map<String,String>entity){

		return staffService.updatePhonenumber(entity);
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Updates the email address of a staff member based on the information provided in the request body.
	 */
	@PutMapping(value ="update-email")
	public ResponseEntity<Map<String, String>> updateEmail(@RequestBody Map<String,String>entity){

		return staffService.updateEmail(entity);
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Updates the city of a staff member based on the information provided in the request body.
	 */
	@PutMapping(value ="update-city")
	public ResponseEntity<Map<String, String>> updateCity(@RequestBody Map<String,String>entity){

		return staffService.updateCity(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Updates the position of a staff member based on the information provided in the request body.
	 */
	@PutMapping(value ="update-position")
	public ResponseEntity<Map<String, String>> updatePosition(@RequestBody Map<String,String>entity){

		return staffService.updatePosition(entity);
	}

    /**
	 * 
	 * @author Aakanksha 
	 * Updates the salary of a staff member based on the information provided in the request body.
	 */
	@PutMapping(value ="update-salary")
	public ResponseEntity<Map<String, String>> updateSalary(@RequestBody Map<String,String>entity){

		return staffService.updateSalary(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes a staff member based on the information provided in the request body.
	 */
	@DeleteMapping(value="delete-employee")
	public ResponseEntity<Map<String, String>> deleteEmployee(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployee(entity);
	}

    /**
	 * 
	 * @author Aakanksha 
	 * Deletes staff members by their name provided in the request body.
	 */
	@DeleteMapping(value="delete-employee-by-name")
	public ResponseEntity<Map<String, String>> deleteEmployeeByName(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByName(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes staff members by their city provided in the request body.
	 */
	@DeleteMapping(value="delete-employee-by-city")
	public ResponseEntity<Map<String, String>> deleteEmployeeByCity(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByCity(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes staff members by their phone number provided in the request body.
	 * 
	 */
	@DeleteMapping(value="delete-employee-by-phonenumber")
	public ResponseEntity<Map<String, String>> deleteEmployeeByPhonenumber(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByPhonenumber(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes staff members by their email address provided in the request body.
	 */
	@DeleteMapping(value="delete-employee-by-email")
	public ResponseEntity<Map<String, String>> deleteEmployeeByEmail(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByEmail(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 *Deletes staff members by their position provided in the request body.
	 */
	@DeleteMapping(value="delete-employee-by-position")
	public ResponseEntity<Map<String, String>> deleteEmployeeByPosition(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByPosition(entity);
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Deletes staff members by their salary provided in the request body.
	 */
	@DeleteMapping(value="delete-employee-by-salary")
	public ResponseEntity<Map<String, String>> deleteEmployeeBySalary(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeBySalary(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes staff members by their hire date provided in the request body.
	 */
	@DeleteMapping(value="delete-employee-by-hireDate")
	public ResponseEntity<Map<String, String>> deleteEmployeeByHireDate(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByHireDate(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes staff members by their leaves count provided in the request body.
	 */
	@DeleteMapping(value="delete-employee-by-leaves")
	public ResponseEntity<Map<String, String>> deleteUserByEmployee(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByLeaves(entity);
	}

	

    /**
	 * 
	 * @author Aakanksha 
	 *  Retrieves staff members whose names start with a specific prefix provided in the request body.
	 */
	@GetMapping(value="get-all-startwith-name")
	public ResponseEntity<List> getAllStartwithName(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithName(entity);
	
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members whose cities start with a specific prefix provided in the request body.
	 */
	@GetMapping(value="get-all-startwith-city")
	public ResponseEntity<List> getAllStartwithCity(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithCity(entity);
	
	}

    /**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members whose email addresses start with a specific prefix provided in the request body.
	 */
	@GetMapping(value="get-all-startwith-email")
	public ResponseEntity<List> getAllStartwithEmail(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithEmail(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members whose phone numbers start with a specific prefix provided in the request body.
	 */
	@GetMapping(value="get-all-startwith-phonenumber")
	public ResponseEntity<List> getAllStartwithPhonenumber(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithPhonenumber(entity);
	
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves staff members whose positions start with a specific prefix provided in the request body.
	 */
	@GetMapping(value="get-all-startwith-position")
	public ResponseEntity<List> getAllStartwithPosition(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithPosition(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 *  Retrieves staff members whose hire dates start with a specific prefix provided in the request body.
	 */
	@GetMapping(value="get-all-startwith-hireDate")
	public ResponseEntity<List> getAllStartwithHireDate(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithHireDate(entity);
	
	}

	

}
