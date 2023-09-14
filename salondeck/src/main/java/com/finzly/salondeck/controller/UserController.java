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

import com.finzly.salondeck.entity.UserInformation;
import com.finzly.salondeck.service.UserService;

@RestController

@RequestMapping(value="/salondeck")
public class UserController {
	
	@Autowired 
	UserService userService;
	
	
	 @PostMapping(value="sign-up")
	 public ResponseEntity<String> signUp(@RequestBody Map<String, String> entity) {
		 
		 return userService.signUp(entity);
		 
	 }
	 
	 
	 @PostMapping(value="/login-by-phonenumber")
	 public ResponseEntity<Map<String,String>> loginByPhonenumber(@RequestBody Map<String, String> entity){
		 
		 
		 return userService.loginByPhonenumber(entity);
		 
	 }
	 

	 @PostMapping(value="/login-by-email")
	 public ResponseEntity<Map<String,String>> loginByEmail(@RequestBody Map<String, String> entity){
		 
		 
		 return userService.loginByEmail(entity);
		 
	 }
	 
	 
	  @PostMapping(value="/get-question")
	    public ResponseEntity<String> getQuestion(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return userService.getQuestion(entity);
	    }
	 
	 
	 @PostMapping(value="/update-password")
	 public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return userService.updatePassword(entity);
	 }
	 
	 
	 @PutMapping(value="/update-profile")
	 public ResponseEntity<Map<String,String>> updateProfile(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return userService.updateProfile(entity);
	 }
	 

	 
	@GetMapping(value="/get-all")
	 public ResponseEntity<List<UserInformation>> getAll(){
		 
		 return userService.getAll();
		 
     }
	
	

	 @GetMapping(value="get-by-gender")
	 public ResponseEntity<List> getByGender(@RequestBody Map<String,String>entity){

		return userService.getByGender(entity);
	
	}

	@GetMapping(value="get-by-phonenumber")
	 public ResponseEntity<List> getByPhonenumber(@RequestBody Map<String,String>entity){

		return userService.getByPhonenumber(entity);
	
	}

	
	@GetMapping(value="get-by-email")
	 public ResponseEntity<List> getByEmail(@RequestBody Map<String,String>entity){

		return userService.getByEmail(entity);
	
	}

	
	
	@GetMapping(value="get-by-name")
	 public ResponseEntity<List> getByName(@RequestBody Map<String,String>entity){

		return userService.getByName(entity);
	
	}

	@GetMapping(value="get-by-city")
	 public ResponseEntity<List> getByCity(@RequestBody Map<String,String>entity){

		return userService.getByCity(entity);
	
	}

	@GetMapping(value="get-by-login")
	 public ResponseEntity<List> getByLogin(@RequestBody Map<String,String>entity){

		return userService.getByLogin(entity);
	
	}


	@PostMapping("/log-out")
    public ResponseEntity<String> logOut(@RequestBody Map<String, String> entity) {
        // Check Data

        return userService.logOut(entity);
    }

	/*
	 *  13 Sept
	 */

	 @PutMapping(value ="update-name")
	public ResponseEntity<Map<String, String>> updateName(@RequestBody Map<String,String>entity){

		return userService.updateName(entity);
	}


	@PutMapping(value ="update-phonenumber")
	public ResponseEntity<Map<String, String>> updatePhonenumber(@RequestBody Map<String,String>entity){

		return userService.updatePhonenumber(entity);
	}


	@PutMapping(value ="update-email")
	public ResponseEntity<Map<String, String>> updateEmail(@RequestBody Map<String,String>entity){

		return userService.updateEmail(entity);
	}


	@PutMapping(value ="update-city")
	public ResponseEntity<Map<String, String>> updateCity(@RequestBody Map<String,String>entity){

		return userService.updateCity(entity);
	}


	@DeleteMapping(value="delete-user")
	public ResponseEntity<Map<String, String>> deleteUser(@RequestBody Map<String,String>entity){

		return userService.deleteUser(entity);
	}


	@DeleteMapping(value="delete-user-by-name")
	public ResponseEntity<Map<String, String>> deleteUserByName(@RequestBody Map<String,String>entity){

		return userService.deleteUserByName(entity);
	}

	@DeleteMapping(value="delete-user-by-city")
	public ResponseEntity<Map<String, String>> deleteUserByCity(@RequestBody Map<String,String>entity){

		return userService.deleteUserByCity(entity);
	}

	@DeleteMapping(value="delete-user-by-phonenumber")
	public ResponseEntity<Map<String, String>> deleteUserByPhonenumber(@RequestBody Map<String,String>entity){

		return userService.deleteUserByPhonenumber(entity);
	}

	
	@DeleteMapping(value="delete-user-by-email")
	public ResponseEntity<Map<String, String>> deleteUserByEmail(@RequestBody Map<String,String>entity){

		return userService.deleteUserByEmail(entity);
	}


	@GetMapping(value="get-all-startwith-name")
	public ResponseEntity<List> getAllStartwithName(@RequestBody Map<String,String>entity){

		return userService.getAllStartwithName(entity);
	
	}


	@GetMapping(value="get-all-startwith-city")
	public ResponseEntity<List> getAllStartwithCity(@RequestBody Map<String,String>entity){

		return userService.getAllStartwithCity(entity);
	
	}


	@GetMapping(value="get-all-startwith-email")
	public ResponseEntity<List> getAllStartwithEmail(@RequestBody Map<String,String>entity){

		return userService.getAllStartwithEmail(entity);
	
	}

	@GetMapping(value="get-all-startwith-phonenumber")
	public ResponseEntity<List> getAllStartwithPhonenumber(@RequestBody Map<String,String>entity){

		return userService.getAllStartwithPhonenumber(entity);
	
	} 
	 

}
