package com.ScrumTool.User;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Autowired
	private JwtUtil jwtUtil;



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
	
//	@Value("${jwt.secretKey}")
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
	    String emailId = user.getEmailId();
	    String password = user.getPassword();

	    if (emailId != null && password != null) {
	        // Validate the user credentials and check if the user exists
	        boolean isValidUser = userService.validateUserCredentials(emailId, password);

	        if (isValidUser) {
	            // User is authenticated, generate JWT token
	            String token = jwtUtil.generateToken(emailId);
	            Map<String, Object> response = new HashMap<>();
	            response.put("token", token);
	            response.put("success", true);
	            response.put("secretKey","c2NydW10b29s");
	            return ResponseEntity.ok(response);
	        } else {
	            Map<String, Object> response = new HashMap<>();
	            response.put("token", null);
	            response.put("success", false);
	            response.put("message", "Invalid credentials"); // Add an error message
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	        }
	    } else {
	        Map<String, Object> response = new HashMap<>();
	        response.put("token", null);
	        response.put("success", false);
	        response.put("message", "Invalid request"); // Add an error message
	        return ResponseEntity.ok(response);
	    }
	}
	
	





}

