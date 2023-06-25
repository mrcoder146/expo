package com.ScrumTool.User;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

    
    public User createUser(String emailId, String password) {
        User user = new User();
        user.setEmailId(emailId);
        user.setPassword(password);
        user.setEmailConfirmed(false);
        user.setConfirmationToken(generateConfirmationToken());
        return userRepository.save(user);
    }

	
	  public boolean confirmEmail(String token) { User user =
	  userRepository.findByConfirmationToken(token);
	  
	  System.out.println(user);
	  
	  if (user != null && !user.getEmailConfirmed() && isTokenValid(token)) {
	  user.setEmailConfirmed(true); userRepository.save(user); return true; }
	  
	  return false; }
	 
    
    private String generateConfirmationToken() {
        // Implement token generation logic here (e.g., using UUID)
        return UUID.randomUUID().toString();
    }

    private boolean isTokenValid(String token) {
        // Implement token validation logic here (e.g., check expiration time)
        return true;
    }
    
    
    public boolean validateUserCredentials(String emailId, String password) {
        User user = userRepository.findByEmailId(emailId);
        if (user != null && emailId.equals(user.getEmailId()) && password.equals(user.getPassword())) {
            return true; // Credentials are valid
        }
        return false; // Credentials are invalid
    }


}
