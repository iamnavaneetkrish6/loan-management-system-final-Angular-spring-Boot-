package com.hexaware.loanmanagementsystem.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hexaware.loanmanagementsystem.dto.CustomerDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.CustomerDetails;
import com.hexaware.loanmanagementsystem.repository.CustomerDetailsRepository;
import com.hexaware.loanmanagementsystem.service.CustomerDetailsServiceImp;

@SpringBootTest
class CustomerDetailsRestControllerTest {

	 @Mock
	 private PasswordEncoder passwordEncoder;

	 @Mock
	 private CustomerDetailsRepository customerDetailsRepository;

	 @InjectMocks
	 private CustomerDetailsServiceImp  customerDetailsServiceImp;

	 @BeforeEach
	 void setUp() {
	      MockitoAnnotations.openMocks(this);
	 }
	@Test
	void testCreateCustomerDetails() {
		CustomerDetailsDTO customerDetailsDTO = new CustomerDetailsDTO();
		customerDetailsDTO.setCustomerId(1);
		customerDetailsDTO.setCustomerName("admin1");
		customerDetailsDTO.setCustomerPassword("password");
		customerDetailsDTO.setCustomerEmailId("admin1");
		customerDetailsDTO.setCustomerUsername("password");
		
		
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerId(1);
		customerDetails.setCustomerName(customerDetailsDTO.getCustomerName());
		customerDetails.setCustomerPassword(customerDetailsDTO.getCustomerPassword());
		customerDetails.setCustomerEmailId(customerDetailsDTO.getCustomerEmailId());
		customerDetails.setCustomerUsername(customerDetailsDTO.getCustomerUsername());
	
		when(passwordEncoder.encode(customerDetailsDTO.getCustomerPassword())).thenReturn("encodedPassword");

		CustomerDetails result = customerDetailsServiceImp.customerRegisteration(customerDetailsDTO);

        assertNotNull(result);
        assertEquals(customerDetails.getCustomerName(), result.getCustomerName());
        assertEquals(customerDetails.getCustomerPassword(), result.getCustomerPassword());
        assertEquals(customerDetails.getCustomerEmailId(), result.getCustomerEmailId());
        assertEquals(customerDetails.getCustomerUsername(), result.getCustomerUsername());
		
	}

	@Test
	void testUpdateCustomerDetails() {
		CustomerDetailsDTO customerDetailsDTO = new CustomerDetailsDTO();
		customerDetailsDTO.setCustomerId(1);
		customerDetailsDTO.setCustomerName("admin1");
		customerDetailsDTO.setCustomerPassword("password");
		customerDetailsDTO.setCustomerEmailId("admin1");
		customerDetailsDTO.setCustomerUsername("password");
		
		
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerId(1);
		customerDetails.setCustomerName(customerDetailsDTO.getCustomerName());
		customerDetails.setCustomerPassword(customerDetailsDTO.getCustomerPassword());
		customerDetails.setCustomerEmailId(customerDetailsDTO.getCustomerEmailId());
		customerDetails.setCustomerUsername(customerDetailsDTO.getCustomerUsername());
	
		when(passwordEncoder.encode(customerDetailsDTO.getCustomerPassword())).thenReturn("encodedPassword");

		CustomerDetails result = customerDetailsServiceImp.customerRegisteration(customerDetailsDTO);

        assertNotNull(result);
        assertEquals(customerDetails.getCustomerName(), result.getCustomerName());
        assertEquals(customerDetails.getCustomerPassword(), result.getCustomerPassword());
        assertEquals(customerDetails.getCustomerEmailId(), result.getCustomerEmailId());
        assertEquals(customerDetails.getCustomerUsername(), result.getCustomerUsername());	}

	@Test
	void testDeleteCustomerDetails() {
        long customerId = 1;

        customerDetailsServiceImp.deleteCustomer(customerId);
       verify(customerDetailsRepository, times(1)).deleteById(customerId);	}

	@Test
	void testGetCustomerDetailsByCustomerId() {

   	 long Id = 1;
   	CustomerDetails customerDetails = new CustomerDetails();
   	customerDetails.setCustomerId(Id);
   	customerDetails.setCustomerName("KRISHNA");
   	customerDetails.setCustomerAddress("PALAKKAD");
   	customerDetails.setCustomerUsername("KRISHNA213@GMAIL.COM");

     when(customerDetailsRepository.findById(Id)).thenReturn(Optional.of(customerDetails));

    
     CustomerDetails result = customerDetailsServiceImp.getCustomerDetailsById(Id);

    
     assertNotNull(result);
     assertEquals(customerDetails.getCustomerId(), result.getCustomerId());
     assertEquals(customerDetails.getCustomerName(), result.getCustomerName());
     assertEquals(customerDetails.getCustomerAddress(), result.getCustomerAddress());
     assertEquals(customerDetails.getCustomerUsername(), result.getCustomerUsername());

     
     verify(customerDetailsRepository, times(1)).findById(Id);
		
	
	}

	@Test
	void testGetAllCustomerDetails() {
        List<CustomerDetails> customerDetails = Arrays.asList(new CustomerDetails(), new CustomerDetails());

        when(customerDetailsRepository.findAll()).thenReturn(customerDetails);

        List<CustomerDetails> result = customerDetailsServiceImp.getAllCustomerDetails();

        assertNotNull(result);
        assertEquals(customerDetails.size(), result.size());	}

}
