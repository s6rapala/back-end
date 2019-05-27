package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {
	private static Map<String, User> userRepo = new HashMap<>();

		@Autowired
		private UserRepository userData;
		
		
		public String newUser(User user) {
			userData.save(user);
			return "New User created";
		}
			
		
	   @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
	      userRepo.remove(id);
	      return new ResponseEntity<>("User removed successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) { 
	      userRepo.remove(id);
	      user.setId(id);
	      userRepo.put(id, user);
	      return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	   public ResponseEntity<Object> createUser(@RequestBody User user) {
	      userRepo.put(user.getId(), user);
	      return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value = "/getAllUsers")
	   public ResponseEntity<Object> getAllUsers() {
	      return new ResponseEntity<>(userRepo.values(), HttpStatus.OK);
	   }
	   
	   
	   @RequestMapping(value = "/getSingleUser/{id}", method = RequestMethod.GET)
	   public ResponseEntity<User> getSingleUser(@PathVariable("id") String id) { 
	      return new ResponseEntity<User>(userRepo.get(id), HttpStatus.OK);
	   }
	   

}
