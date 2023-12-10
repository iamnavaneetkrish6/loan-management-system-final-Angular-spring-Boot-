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

import com.hexaware.loanmanagementsystem.dto.LoanTypeDTO;
import com.hexaware.loanmanagementsystem.entity.LoanType;
import com.hexaware.loanmanagementsystem.repository.LoanTypesRepository;
import com.hexaware.loanmanagementsystem.service.LoanTypesServiceImp;

@SpringBootTest
class LoanTypeRestControllerTest {

	

    @Mock
	 private LoanTypesRepository loanTypesRepository;


	 @InjectMocks
	 private LoanTypesServiceImp loanTypesService;

	 @BeforeEach
	 void setUp() {
	     MockitoAnnotations.openMocks(this);
	 }
	
	@Test
	void testCreateLoanTypeDetails() {
    	LoanTypeDTO loanTypes = new LoanTypeDTO();
    	loanTypes.setLoanTypeId(1);
    	loanTypes.setLoanTypeName("goldloan");
    	loanTypes.setLoanDescription("best rate");
    	loanTypes.setLoanInterestRate(12.651);

    	LoanType loanType = new LoanType();
    	loanTypes.setLoanTypeId(loanTypes.getLoanTypeId());
    	loanTypes.setLoanTypeName(loanTypes.getLoanTypeName());
    	loanTypes.setLoanDescription(loanTypes.getLoanDescription());
    	loanTypes.setLoanInterestRate(loanTypes.getLoanInterestRate());
    	
    	
    	LoanType result = loanTypesService.createLoanType(loanTypes);

     
      assertNotNull(result);
      
      assertEquals(loanType.getLoanTypeId(), result.getLoanTypeId());
      assertEquals(loanType.getLoanTypeName(), result.getLoanTypeName());
      assertEquals(loanType.getLoanDescription(), result.getLoanTypeName());
      assertEquals(loanType.getLoanInterestRate(), result.getLoanInterestRate());	}

	@Test
	void testUpdateLoanTypeDetails() {

		
		
		
		
	    	LoanTypeDTO loanTypes = new LoanTypeDTO();
	    	loanTypes.setLoanTypeId(1);
	    	loanTypes.setLoanTypeName("goldloan");
	    	loanTypes.setLoanDescription("best rate");
	    	loanTypes.setLoanInterestRate(12.651);

	    	LoanType loanType = new LoanType();
	    	loanTypes.setLoanTypeId(loanTypes.getLoanTypeId());
	    	loanTypes.setLoanTypeName(loanTypes.getLoanTypeName());
	    	loanTypes.setLoanDescription(loanTypes.getLoanDescription());
	    	loanTypes.setLoanInterestRate(loanTypes.getLoanInterestRate());
	    	
	    	
	    	LoanType result = loanTypesService.updateLoanType(loanTypes,1);

	     
	      assertNotNull(result);
	      
	      assertEquals(loanType.getLoanTypeId(), result.getLoanTypeId());
	      assertEquals(loanType.getLoanTypeName(), result.getLoanTypeName());
	      assertEquals(loanType.getLoanDescription(), result.getLoanTypeName());
	      assertEquals(loanType.getLoanInterestRate(), result.getLoanInterestRate());	}

	@Test
	void testDeleteLoanType() {
        long loanTypeID = 1;

        loanTypesService.deleteLoanTypeById(loanTypeID);
       verify(loanTypesRepository, times(1)).deleteById(loanTypeID);
	}

	@Test
	void testGetLoanTypeByLoanTypeId() {
	   	 long loanTypeID = 1;
	    	LoanType loanTypes = new LoanType();
	    	loanTypes.setLoanTypeId(loanTypeID);
	    	loanTypes.setLoanTypeName("goldloan");
	    	loanTypes.setLoanDescription("best rate");
	    	loanTypes.setLoanInterestRate(12.651);

	      when(loanTypesRepository.findById(loanTypeID)).thenReturn(Optional.of(loanTypes));

	     
	      LoanType result = loanTypesService.getLoanTypeById(loanTypeID);

	     
	      assertNotNull(result);
	      
	      assertEquals(loanTypes.getLoanTypeId(), result.getLoanTypeId());
	      assertEquals(loanTypes.getLoanTypeName(), result.getLoanTypeName());
	      assertEquals(loanTypes.getLoanDescription(), result.getLoanTypeName());
	      assertEquals(loanTypes.getLoanInterestRate(), result.getLoanInterestRate());
	}

	@Test
	void testGetAllLoanType() {
        List<LoanType> loanTypes = Arrays.asList(new LoanType(), new LoanType());

        when(loanTypesRepository.findAll()).thenReturn(loanTypes);

        List<LoanType> result = loanTypesService.getAllLoanType();

        assertNotNull(result);
        assertEquals(loanTypes.size(), result.size());	}

}
