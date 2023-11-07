package com.ScrumTool.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;


	@GetMapping("/user")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping("/confirm-email")
    public ResponseEntity<String> confirmEmail(@RequestParam("token") String token) {
		boolean isConfirmed = userService.confirmEmail(token);

        if (isConfirmed) {
            return ResponseEntity.ok("Email confirmed successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
    }
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
	    String emailId = user.getEmailId();
	    String password = user.getPassword();

	    if (emailId != null && password != null) {
	        // Validate the user credentials and check if the user exists
	        boolean isValidUser = userService.validateUserCredentials(emailId, password);
	        
	        if (isValidUser) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    } else {
	        return ResponseEntity.badRequest().body("Email and password are required");
	    }
	}



}

