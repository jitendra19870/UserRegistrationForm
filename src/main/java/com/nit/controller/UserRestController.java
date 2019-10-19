package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.User;
import com.nit.service.IUserService;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
	@Autowired
	private IUserService userService;

	// Fetch alll records from DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		List<User> list = userService.getAllUsers();
		if (list != null && !list.isEmpty()) {
			resp = new ResponseEntity<List<User>>(list, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("No DATA FOUND ", HttpStatus.OK);
		}

		return resp;
	}

	// insert data
	@PostMapping("/save")
	public ResponseEntity<?> saveData(@RequestBody User user) {
		ResponseEntity<?> resp = null;
		try {
			User u = userService.saveUser(user);
			String body = "save successfully";
			resp = new ResponseEntity<String>(body, HttpStatus.OK);

		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();

		}

		return resp;
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteById(@PathVariable Integer userId) {
		ResponseEntity resp=null;
		try {
		userService.deleteUserById(userId);
		resp=new ResponseEntity<String>(userId +"deleted sucessfully",HttpStatus.OK);
		}catch(Exception e) {
			resp=new ResponseEntity<String>(userId +"unable to delete/not exist",HttpStatus.BAD_REQUEST);
		}
		
		return resp;
		
	}

}
