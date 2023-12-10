package com.hexaware.loanmanagementsystem.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.loanmanagementsystem.config.UserInfoUserDetailsService;
import com.hexaware.loanmanagementsystem.dto.AuthRequest;
import com.hexaware.loanmanagementsystem.service.JwtService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/login/")
public class LoginRestController {

	@Autowired
	AuthenticationManager authenticationManager;
	Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	@Autowired
	private JwtService jwtService;
	

    
	@Autowired    
	private  UserInfoUserDetailsService userDetailsService; 


    @PostMapping("adminlogin")
    public String adminLogin(@RequestBody AuthRequest authRequest) {
        authenticate(authRequest.getUsername(), authRequest.getPassword(), userDetailsService);

        String token = jwtService.generateToken(authRequest.getUsername());
        
        logger.info("Admin login successful for username: {}", authRequest.getUsername());
        
        return  token;
    }

    @PostMapping("customerlogin")
    public String customerLogin(@RequestBody AuthRequest authRequest) {
        authenticate(authRequest.getUsername(), authRequest.getPassword(), userDetailsService);

        String token = jwtService.generateToken(authRequest.getUsername());
        
        logger.info("Customer login successful for username: {}", authRequest.getUsername());
        return token;
    }
    
    private void authenticate(String username, String password, UserInfoUserDetailsService userDetailsService) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        if (!authenticate.isAuthenticated()) {
            throw new UsernameNotFoundException("Invalid Username or Password / Invalid request");
        }
    }
}
