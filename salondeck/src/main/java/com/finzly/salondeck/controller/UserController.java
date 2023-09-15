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
	
	
	/**
	 * 
	 * @author Aakanksha 
	 * Allows a user to sign up by providing user information in the request body. 
	 * Returns a ResponseEntity with a string indicating the result.
	 */
	 @PostMapping(value="sign-up")
	 public ResponseEntity<String> signUp(@RequestBody Map<String, String> entity) {
		 
		 return userService.signUp(entity);
		 
	 }
	 
	 /**
	  * 
	  * @author Aakanksha 
	  * Allows a user to log in using their phone number by providing the phone number in the request body. 
	  * Returns a ResponseEntity with a map containing login-related information.
	  */
	 @PostMapping(value="/login-by-phonenumber")
	 public ResponseEntity<Map<String,String>> loginByPhonenumber(@RequestBody Map<String, String> entity){
		 
		 
		 return userService.loginByPhonenumber(entity);
		 
	 }
	 
     /**
	  * 
	  * @author Aakanksha 
	  * Allows a user to log in using their email address by providing the email address in the request body. 
	  * Returns a ResponseEntity with a map containing login-related information.
	  */
	 @PostMapping(value="/login-by-email")
	 public ResponseEntity<Map<String,String>> loginByEmail(@RequestBody Map<String, String> entity){
		 
		 
		 return userService.loginByEmail(entity);
		 
	 }
	 
	 /**
	  * 
	  *  @author Aakanksha 
	  *  Retrieves a security question for a user based on the information provided in the request body.
	  *  Returns a ResponseEntity with a string containing the security question.
	  */
	 
	  @PostMapping(value="/get-question")
	    public ResponseEntity<String> getQuestion(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return userService.getQuestion(entity);
	    }
	 
	 /**
	  * 
	  *  @author Aakanksha 
	  *  Allows a user to update their password based on the information provided in the request body.
	  *  Returns a ResponseEntity with a string indicating the result.
	  */
	 @PostMapping(value="/update-password")
	 public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return userService.updatePassword(entity);
	 }
	 
	 
	 /**
	  * 
	  * @author Aakanksha 
	  * Updates the user's profile information based on the information provided in the request body. 
	  * Returns a ResponseEntity with a map containing updated profile information.
	  */
	 @PutMapping(value="/update-profile")
	 public ResponseEntity<Map<String,String>> updateProfile(@RequestBody Map<String, String> entity) {
	        // Check Data

	        return userService.updateProfile(entity);
	 }
	 

	 /**
	  * 
	  * @author Aakanksha 
	  * Retrieves a list of all user information. Returns a ResponseEntity with a list of user information objects.
	  */
	@GetMapping(value="/get-all")
	 public ResponseEntity<List<UserInformation>> getAll(){
		 
		 return userService.getAll();
		 
     }
	
	
     /**
	  * 
	  * @author Aakanksha 
	  * Retrieves user information based on their gender, with the gender provided in the request body.
	  * Returns a ResponseEntity with a list of user information objects.
	  */
	 @GetMapping(value="get-by-gender")
	 public ResponseEntity<List> getByGender(@RequestBody Map<String,String>entity){

		return userService.getByGender(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 *Retrieves user information based on their phone number, with the phone number provided in the request body. 
	 *Returns a ResponseEntity with a list of user information objects.
	 */
	@GetMapping(value="get-by-phonenumber")
	 public ResponseEntity<List> getByPhonenumber(@RequestBody Map<String,String>entity){

		return userService.getByPhonenumber(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves user information based on their email address, with the email address provided in the request body.
	 *  Returns a ResponseEntity with a list of user information objects.
	 */
	@GetMapping(value="get-by-email")
	 public ResponseEntity<List> getByEmail(@RequestBody Map<String,String>entity){

		return userService.getByEmail(entity);
	
	}

	
	/**
	 * 
	 *  @author Aakanksha 
	 *  Retrieves user information based on their name, with the name provided in the request body. 
	 *  Returns a ResponseEntity with a list of user information objects.
	 */
	@GetMapping(value="get-by-name")
	 public ResponseEntity<List> getByName(@RequestBody Map<String,String>entity){

		return userService.getByName(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves user information based on their city, with the city provided in the request body. 
	 * Returns a ResponseEntity with a list of user information objects.
	 */
	@GetMapping(value="get-by-city")
	 public ResponseEntity<List> getByCity(@RequestBody Map<String,String>entity){

		return userService.getByCity(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 *Retrieves user information based on their login information, with the login information provided in the request body. 
	 *Returns a ResponseEntity with a list of user information objects.
	 */
	@GetMapping(value="get-by-login")
	 public ResponseEntity<List> getByLogin(@RequestBody Map<String,String>entity){

		return userService.getByLogin(entity);
	
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Allows a user to log out based on the information provided in the request body.
	 *  Returns a ResponseEntity with a string indicating the result.
	 */
	@PostMapping("/log-out")
    public ResponseEntity<String> logOut(@RequestBody Map<String, String> entity) {
        // Check Data

        return userService.logOut(entity);
    }

	/*
	 *  13 Sept
	 */

	 /**
	  * 
	  * @author Aakanksha 
	  * Updates the name of a user based on the information provided in the request body.
	  * Returns a ResponseEntity with a map containing updated user information.
	  */
	 @PutMapping(value ="update-name")
	public ResponseEntity<Map<String, String>> updateName(@RequestBody Map<String,String>entity){

		return userService.updateName(entity);
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Updates the phone number of a user based on the information provided in the request body. 
	 * Returns a ResponseEntity with a map containing updated user information.
	 */
	@PutMapping(value ="update-phonenumber")
	public ResponseEntity<Map<String, String>> updatePhonenumber(@RequestBody Map<String,String>entity){

		return userService.updatePhonenumber(entity);
	}


   /**
	* 
	*  @author Aakanksha 
	*  Updates the email address of a user based on the information provided in the request body. 
	*  Returns a ResponseEntity with a map containing updated user information.
    */
	@PutMapping(value ="update-email")
	public ResponseEntity<Map<String, String>> updateEmail(@RequestBody Map<String,String>entity){

		return userService.updateEmail(entity);
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Updates the city of a user based on the information provided in the request body. 
	 * Returns a ResponseEntity with a map containing updated user information.
	 */
	@PutMapping(value ="update-city")
	public ResponseEntity<Map<String, String>> updateCity(@RequestBody Map<String,String>entity){

		return userService.updateCity(entity);
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Deletes a user based on the information provided in the request body. 
	 * Returns a ResponseEntity with a string indicating the result.
	 */
	@DeleteMapping(value="delete-user")
	public ResponseEntity<Map<String, String>> deleteUser(@RequestBody Map<String,String>entity){

		return userService.deleteUser(entity);
	}


	/**
	 * 
	 * @author Aakanksha 
	 * Deletes users by their name provided in the request body. 
	 * Returns a ResponseEntity with a string indicating the result.
	 */
	@DeleteMapping(value="delete-user-by-name")
	public ResponseEntity<Map<String, String>> deleteUserByName(@RequestBody Map<String,String>entity){

		return userService.deleteUserByName(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes users by their city provided in the request body. 
	 * Returns a ResponseEntity with a string indicating the result.
	 */
	@DeleteMapping(value="delete-user-by-city")
	public ResponseEntity<Map<String, String>> deleteUserByCity(@RequestBody Map<String,String>entity){

		return userService.deleteUserByCity(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes users by their phone number provided in the request body.
	 * Returns a ResponseEntity with a string indicating the result.
	 */
	@DeleteMapping(value="delete-user-by-phonenumber")
	public ResponseEntity<Map<String, String>> deleteUserByPhonenumber(@RequestBody Map<String,String>entity){

		return userService.deleteUserByPhonenumber(entity);
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Deletes users by their email address provided in the request body.
	 * Returns a ResponseEntity with a string indicating the result.
	 */
	@DeleteMapping(value="delete-user-by-email")
	public ResponseEntity<Map<String, String>> deleteUserByEmail(@RequestBody Map<String,String>entity){

		return userService.deleteUserByEmail(entity);
	}

    /**
	 * 
	 * @author Aakanksha 
	 * Retrieves users whose names start with a specific prefix provided in the request body.
	 * Returns a ResponseEntity with a list of user information objects.
	 */
	@GetMapping(value="get-all-startwith-name")
	public ResponseEntity<List> getAllStartwithName(@RequestBody Map<String,String>entity){

		return userService.getAllStartwithName(entity);
	
	}

    /**
	 * 
	 * @author Aakanksha 
	 * Retrieves users whose cities start with a specific prefix provided in the request body. 
	 * Returns a ResponseEntity with a list of user information objects.
	 */
	@GetMapping(value="get-all-startwith-city")
	public ResponseEntity<List> getAllStartwithCity(@RequestBody Map<String,String>entity){

		return userService.getAllStartwithCity(entity);
	
	}


	/**
	 * 
	 * @author Aakanksha 
	 *Retrieves users whose email addresses start with a specific prefix provided in the request body. 
	 *Returns a ResponseEntity with a list of user information objects
	 */
	@GetMapping(value="get-all-startwith-email")
	public ResponseEntity<List> getAllStartwithEmail(@RequestBody Map<String,String>entity){

		return userService.getAllStartwithEmail(entity);
	
	}

	/**
	 * 
	 * @author Aakanksha 
	 * Retrieves users whose phone numbers start with a specific prefix provided in the request body.
	 * Returns a ResponseEntity with a list of user information objects.
	 */
	@GetMapping(value="get-all-startwith-phonenumber")
	public ResponseEntity<List> getAllStartwithPhonenumber(@RequestBody Map<String,String>entity){

		return userService.getAllStartwithPhonenumber(entity);
	
	} 
	 

}
