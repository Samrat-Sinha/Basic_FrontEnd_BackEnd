package com.UserBackEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserBackEnd.Exception.UserException;
import com.UserBackEnd.Model.User;
import com.UserBackEnd.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

	@Autowired
	private UserService uService;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) throws UserException {
	    User registeredUser = uService.register(user);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Access-Control-Allow-Origin", "http://127.0.0.1:5500");

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .headers(headers)
	            .body(registeredUser);
	}
	
	@GetMapping("/data")
	public ResponseEntity<List<User>> allUser() throws UserException{
		return new ResponseEntity<List<User>>(uService.alluser(),HttpStatus.OK);
	}
	
}
