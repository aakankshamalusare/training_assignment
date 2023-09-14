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
	
	
	 @PostMapping(value="/sign-up")
	 public ResponseEntity<String> signUp(@RequestBody Map<String, String> entity) {
		 
		 return staffService.signUp(entity);
		 
	 }
	 
	 
	 @PostMapping(value="/login-by-phonenumber")
	 public ResponseEntity<Map<String,String>> loginByPhonenumber(@RequestBody Map<String, String> entity){
		 
		 
		 return staffService.loginByPhonenumber(entity);
		 
	 }
	 

	 @PostMapping(value="/login-by-email")
	 public ResponseEntity<Map<String,String>> loginByEmail(@RequestBody Map<String, String> entity){
		 
		 
		 return staffService.loginByEmail(entity);
		 
	 }
	 
	 
	  @PostMapping(value="/get-question")
	    public ResponseEntity<String> getQuestion(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return staffService.getQuestion(entity);
	    }
	 
	 
	 @PostMapping(value="/update-password")
	 public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return staffService.updatePassword(entity);
	 }
	 
	 
	 @PutMapping(value="/update-profile")
	 public ResponseEntity<Map<String,String>> updateProfile(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return staffService.updateProfile(entity);
	 }
	 

	 
	@GetMapping(value="/get-all")
	 public ResponseEntity<List<StaffInformation>> getAll(){
		 
		 return staffService.getAll();
		 
     }
	
	

	 @GetMapping(value="get-by-gender")
	 public ResponseEntity<List> getByGender(@RequestBody Map<String,String>entity){

		return staffService.getByGender(entity);
	
	}

	@GetMapping(value="get-by-phonenumber")
	 public ResponseEntity<List> getByPhonenumber(@RequestBody Map<String,String>entity){

		return staffService.getByPhonenumber(entity);
	
	}

	
	@GetMapping(value="get-by-email")
	 public ResponseEntity<List> getByEmail(@RequestBody Map<String,String>entity){

		return staffService.getByEmail(entity);
	
	}

	
	
	@GetMapping(value="get-by-name")
	 public ResponseEntity<List> getByName(@RequestBody Map<String,String>entity){

		return staffService.getByEmail(entity);
	
	}

	@GetMapping(value="get-by-city")
	 public ResponseEntity<List> getByCity(@RequestBody Map<String,String>entity){

		return staffService.getByCity(entity);
	
	}

	@GetMapping(value="get-by-login")
	 public ResponseEntity<List> getByLogin(@RequestBody Map<String,String>entity){

		return staffService.getByLogin(entity);
	
	}


	@GetMapping(value ="get-by-position")
	public ResponseEntity<List<StaffInformation>> getPosition(@RequestBody Map<String,String>entity){

		return staffService.getByPosition(entity);
	
	}

	@GetMapping(value ="get-by-hireDate")
	public ResponseEntity<List<StaffInformation>> getByHireDate(@RequestBody Map<String,String>entity){

		return staffService.getByHireDate(entity);
    }

	@PostMapping("/log-out")
    public ResponseEntity<String> logOut(@RequestBody Map<String, String> entity) {
        // Check Data

        return staffService.logOut(entity);
    }
	 
     /*
	  *  13 Sept
	  */

	@GetMapping(value="/get-by-salary")
	public ResponseEntity<List<StaffInformation>> getBySalary(@RequestBody Map<String,String>entity){

		return staffService.getBySalary(entity);
    }


	@GetMapping(value="/get-by-lessthan-salary")
	public ResponseEntity<List<StaffInformation>> getByLessthanSalary(@RequestBody Map<String,String>entity){

		return staffService.getByLessthanSalary(entity);
    }

	@GetMapping(value="/get-by-greaterthan-salary")
	public ResponseEntity<List<StaffInformation>> getByGreaterthanSalary(@RequestBody Map<String,String>entity){

		return staffService.getByGreaterthanSalary(entity);
    }


	@GetMapping(value="/get-by-between-salary")
	public ResponseEntity<List<StaffInformation>> getByBetweenSalary(@RequestBody Map<String,String>entity){

		return staffService.getByBetweenSalary(entity);
    }


    @GetMapping(value ="get-by-leaves")
	public ResponseEntity<List<StaffInformation>> getByLeaves(@RequestBody Map<String,String>entity){

		return staffService.getByLeaves(entity);
	
	}


	@GetMapping(value ="get-by-lessthan-leaves")
	public ResponseEntity<List<StaffInformation>> getByLessthanLeaves(@RequestBody Map<String,String>entity){

		return staffService.getByLessthanLeaves(entity);
	
	}

	@GetMapping(value ="get-by-greaterthan-leaves")
	public ResponseEntity<List<StaffInformation>> getByGreaterthanLeaves(@RequestBody Map<String,String>entity){

		return staffService.getByGreaterthanLeaves(entity);
	
	}

	@GetMapping(value ="get-by-between-leaves")
	public ResponseEntity<List<StaffInformation>> getByBetweenLeaves(@RequestBody Map<String,String>entity){

		return staffService.getByBetweenLeaves(entity);
	
	}

	@GetMapping(value ="get-by-before-hireDate")
	public ResponseEntity<List<StaffInformation>> getByBeforeHireDate(@RequestBody Map<String,String>entity){

		return staffService.getByBeforeHireDate(entity);
    }

	@GetMapping(value ="get-by-after-hireDate")
	public ResponseEntity<List<StaffInformation>> getByAfterHireDate(@RequestBody Map<String,String>entity){

		return staffService.getByAfterHireDate(entity);
    }


	@GetMapping(value ="get-by-between-hireDate")
	public ResponseEntity<List<StaffInformation>> getByBetweenHireDate(@RequestBody Map<String,String>entity){

		return staffService.getByBetweenHireDate(entity);
    }


	@PutMapping(value ="update-name")
	public ResponseEntity<Map<String, String>> updateName(@RequestBody Map<String,String>entity){

		return staffService.updateName(entity);
	}


	@PutMapping(value ="update-phonenumber")
	public ResponseEntity<Map<String, String>> updatePhonenumber(@RequestBody Map<String,String>entity){

		return staffService.updatePhonenumber(entity);
	}


	@PutMapping(value ="update-email")
	public ResponseEntity<Map<String, String>> updateEmail(@RequestBody Map<String,String>entity){

		return staffService.updateEmail(entity);
	}


	@PutMapping(value ="update-city")
	public ResponseEntity<Map<String, String>> updateCity(@RequestBody Map<String,String>entity){

		return staffService.updateCity(entity);
	}

	@PutMapping(value ="update-position")
	public ResponseEntity<Map<String, String>> updatePosition(@RequestBody Map<String,String>entity){

		return staffService.updatePosition(entity);
	}


	@PutMapping(value ="update-salary")
	public ResponseEntity<Map<String, String>> updateSalary(@RequestBody Map<String,String>entity){

		return staffService.updateSalary(entity);
	}

	@DeleteMapping(value="delete-employee")
	public ResponseEntity<Map<String, String>> deleteEmployee(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployee(entity);
	}


	@DeleteMapping(value="delete-employee-by-name")
	public ResponseEntity<Map<String, String>> deleteEmployeeByName(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByName(entity);
	}

	@DeleteMapping(value="delete-employee-by-city")
	public ResponseEntity<Map<String, String>> deleteEmployeeByCity(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByCity(entity);
	}

	@DeleteMapping(value="delete-employee-by-phonenumber")
	public ResponseEntity<Map<String, String>> deleteEmployeeByPhonenumber(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByPhonenumber(entity);
	}

	
	@DeleteMapping(value="delete-employee-by-email")
	public ResponseEntity<Map<String, String>> deleteEmployeeByEmail(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByEmail(entity);
	}

	@DeleteMapping(value="delete-employee-by-position")
	public ResponseEntity<Map<String, String>> deleteEmployeeByPosition(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByPosition(entity);
	}


	@DeleteMapping(value="delete-employee-by-salary")
	public ResponseEntity<Map<String, String>> deleteEmployeeBySalary(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeBySalary(entity);
	}

	@DeleteMapping(value="delete-employee-by-hireDate")
	public ResponseEntity<Map<String, String>> deleteEmployeeByHireDate(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByHireDate(entity);
	}

	@DeleteMapping(value="delete-employee-by-leaves")
	public ResponseEntity<Map<String, String>> deleteUserByEmployee(@RequestBody Map<String,String>entity){

		return staffService.deleteEmployeeByLeaves(entity);
	}

	


	@GetMapping(value="get-all-startwith-name")
	public ResponseEntity<List> getAllStartwithName(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithName(entity);
	
	}


	@GetMapping(value="get-all-startwith-city")
	public ResponseEntity<List> getAllStartwithCity(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithCity(entity);
	
	}


	@GetMapping(value="get-all-startwith-email")
	public ResponseEntity<List> getAllStartwithEmail(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithEmail(entity);
	
	}

	@GetMapping(value="get-all-startwith-phonenumber")
	public ResponseEntity<List> getAllStartwithPhonenumber(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithPhonenumber(entity);
	
	}


	@GetMapping(value="get-all-startwith-position")
	public ResponseEntity<List> getAllStartwithPosition(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithPosition(entity);
	
	}

	@GetMapping(value="get-all-startwith-hireDate")
	public ResponseEntity<List> getAllStartwithHireDate(@RequestBody Map<String,String>entity){

		return staffService.getAllStartwithHireDate(entity);
	
	}


	
	


	








	

}
