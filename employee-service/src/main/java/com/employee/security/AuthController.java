package com.employee.security;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
//@CrossOrigin(origins = "http://api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
	
	
	  @Autowired
	    private UserDetailsService userDetailsService;

	    @Autowired
	    private AuthenticationManager manager;


	    @Autowired
	    private JWTHelper helper;

	    @PostMapping("/login")
	    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

	        this.doAuthenticate(request.getUserName(), request.getPassword());


	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
	        String token = this.helper.generateToken(userDetails);


	        JwtResponse response = new JwtResponse();
	        response.setStatus("success");
	        response.setMessage("token generated successfull");
	        response.setAccessToken(token);
	        response.setUsername(userDetails.getUsername());
	        
	        
	        
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    private void doAuthenticate(String email, String password) {

	        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
	        try {
	            manager.authenticate(authentication);


	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException(" Invalid Username or Password  !!");
	        }

	    }

	    @ExceptionHandler(BadCredentialsException.class)
	    public HashMap<String, Object> exceptionHandler() {
	    	HashMap<String, Object> response = new HashMap<String, Object>();
	    	response.put("status", "Bad request");
	    	response.put("message", "Credentials Invalid !!");
	    	response.put("errorcode", "400");
	        return response;
	    }


}
