package com.hexaware.loanmanagementsystem.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hexaware.loanmanagementsystem.entity.AdminDetails;
import com.hexaware.loanmanagementsystem.entity.CustomerDetails;
import com.hexaware.loanmanagementsystem.repository.AdminDetailsRepository;
import com.hexaware.loanmanagementsystem.repository.CustomerDetailsRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    
    @Autowired 
    private AdminDetailsRepository adminRepository;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
    	
    	Optional<AdminDetails> adminInfo = adminRepository.findByAdminUsername(username);
    	if(adminInfo.isPresent()) {
    		return adminInfo.map(AdminInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username));
    	}
    	
    	Optional<CustomerDetails> customerInfo = customerDetailsRepository.findByCustomerUsername(username);
    	if(customerInfo.isPresent()) {
    		return customerInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    	}

	    throw new UsernameNotFoundException("User not found: " + username);
	}
    
}
