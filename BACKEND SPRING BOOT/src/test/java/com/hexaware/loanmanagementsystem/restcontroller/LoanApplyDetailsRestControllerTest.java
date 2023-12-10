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

import com.hexaware.loanmanagementsystem.dto.LoanApplyDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.LoanApplyDetails;
import com.hexaware.loanmanagementsystem.repository.LoanApplyDetailsRepository;
import com.hexaware.loanmanagementsystem.service.LoanApplyDetailsServiceImp;

@SpringBootTest
class LoanApplyDetailsRestControllerTest {

    @Mock
	 private LoanApplyDetailsRepository loanApplyDetailsRepository;


	 @InjectMocks
	 private LoanApplyDetailsServiceImp loanApplyDetailsService;

	 @BeforeEach
	 void setUp() {
	     MockitoAnnotations.openMocks(this);
	  }
	
	@Test
	void testCreateLoanApplyDetails() {
	   	LoanApplyDetailsDTO loanDetails = new LoanApplyDetailsDTO();
	   	loanDetails.setCustomerName("loanee");
	   	loanDetails.setLoanTypeName("home");
	   	loanDetails.setLoanAmount(12651);
	
	
	   	LoanApplyDetails loanApplyDetails = new LoanApplyDetails();	
	   	loanApplyDetails.setCustomerName(loanDetails.getCustomerName());
	   	loanApplyDetails.setLoanTypeName(loanDetails.getLoanTypeName());
	   	loanApplyDetails.setLoanAmount(loanDetails.getLoanAmount());
	   	
	   	
	   	
	     LoanApplyDetails result = loanApplyDetailsService.createLoanApplyDetails(loanDetails);
	     
	     assertNotNull(result);
	     assertEquals(loanDetails.getLoanNo(), result.getLoanNo());
	     assertEquals(loanDetails.getCustomerName(), result.getCustomerName());
	     assertEquals(loanDetails.getLoanTypeName(), result.getLoanTypeName());
	     assertEquals(loanDetails.getLoanAmount(), result.getLoanAmount());
	
	}

	@Test
	void testUpdateLoanApplyDetails() {

	   	LoanApplyDetailsDTO loanDetails = new LoanApplyDetailsDTO();
	   	loanDetails.setCustomerName("loanee");
	   	loanDetails.setLoanTypeName("home");
	   	loanDetails.setLoanAmount(12651);
	
	
	   	LoanApplyDetails loanApplyDetails = new LoanApplyDetails();	
	   	loanApplyDetails.setCustomerName(loanDetails.getCustomerName());
	   	loanApplyDetails.setLoanTypeName(loanDetails.getLoanTypeName());
	   	loanApplyDetails.setLoanAmount(loanDetails.getLoanAmount());
	   	
	   	
	   	
	     LoanApplyDetails result = loanApplyDetailsService.updateApplyDetails(loanDetails,1);
	     
	     assertNotNull(result);
	     assertEquals(loanDetails.getLoanNo(), result.getLoanNo());
	     assertEquals(loanDetails.getCustomerName(), result.getCustomerName());
	     assertEquals(loanDetails.getLoanTypeName(), result.getLoanTypeName());
	     assertEquals(loanDetails.getLoanAmount(), result.getLoanAmount());
	}

	@Test
	void testDeleteLoanApplyDetailsById() {
        long loanNo = 1;

        loanApplyDetailsService.deleteApplyDetails(loanNo);
       verify(loanApplyDetailsRepository, times(1)).deleteById(loanNo);	}

	@Test
	void testGetLoanApplyDetailsByLoanNumber() {
   	 long loanNo = 1;
   	LoanApplyDetails loanDetails = new LoanApplyDetails();
   	loanDetails.setLoanNo(loanNo);
   	loanDetails.setCustomerName("loanee");
   	loanDetails.setLoanTypeName("home");
   	loanDetails.setLoanAmount(12651);

     when(loanApplyDetailsRepository.findById(loanNo)).thenReturn(Optional.of(loanDetails));

    
     LoanApplyDetails result = loanApplyDetailsService.getloanDetailsByLoanNumber(loanNo);

    
     assertNotNull(result);
     
     assertEquals(loanDetails.getLoanNo(), result.getLoanNo());
     assertEquals(loanDetails.getCustomerName(), result.getCustomerName());
     assertEquals(loanDetails.getLoanTypeName(), result.getLoanTypeName());
     assertEquals(loanDetails.getLoanAmount(), result.getLoanAmount());
	
	}

	@Test
	void testGetAllLoanApplyDetails() {
        List<LoanApplyDetails> loanDetails = Arrays.asList(new LoanApplyDetails(), new LoanApplyDetails());

        when(loanApplyDetailsRepository.findAll()).thenReturn(loanDetails);

        List<LoanApplyDetails> result = loanApplyDetailsService.getAllLoanDetails();

        assertNotNull(result);
        assertEquals(loanDetails.size(), result.size());	}



}
