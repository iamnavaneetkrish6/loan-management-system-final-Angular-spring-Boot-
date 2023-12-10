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

import com.hexaware.loanmanagementsystem.dto.AdminDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.AdminDetails;
import com.hexaware.loanmanagementsystem.repository.AdminDetailsRepository;
import com.hexaware.loanmanagementsystem.service.AdminDetailsServiceImp;


@SpringBootTest
class AdminDetailsRestControllerTest {



	 @Mock
	 private PasswordEncoder passwordEncoder;

	 @Mock
	 private AdminDetailsRepository adminRepository;

	 @InjectMocks
	 private AdminDetailsServiceImp adminService;

	 @BeforeEach
	 void setUp() {
	      MockitoAnnotations.openMocks(this);
	 }
	
	
	
	
	@Test
	void testCreateAdmin() {
		AdminDetailsDTO adminDetailsDTO = new AdminDetailsDTO();
		adminDetailsDTO.setAdminId(1);
		adminDetailsDTO.setAdminName("admin1");
		adminDetailsDTO.setPassword("password");
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setAdminUsername(adminDetailsDTO.getAdminUsername());
		adminDetails.setPassword(adminDetailsDTO.getPassword());
		
		AdminDetails result = adminService.createAdmin(adminDetailsDTO);
		
       assertNotNull(result);
       assertEquals(adminDetails.getAdminName(), result.getAdminUsername());
       assertEquals(adminDetails.getPassword(), result.getPassword());
	}

	@Test
	void testUpdateAdmin() {
		AdminDetailsDTO adminDetailsDTO = new AdminDetailsDTO();
		adminDetailsDTO.setAdminId(1);
		adminDetailsDTO.setAdminName("admin1");
		adminDetailsDTO.setPassword("password");
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setAdminId(adminDetailsDTO.getAdminId());
		adminDetails.setAdminUsername(adminDetailsDTO.getAdminUsername());
		adminDetails.setPassword(adminDetailsDTO.getPassword());
		
		AdminDetails result = adminService.createAdmin(adminDetailsDTO);
		
       assertNotNull(result);
       assertEquals(adminDetails.getAdminId(), result.getAdminId());
       assertEquals(adminDetails.getAdminName(), result.getAdminUsername());
       assertEquals(adminDetails.getPassword(), result.getPassword());
	}

	@Test
	void testDeleteAdmin() {
		long adminId = 1;

       adminService.deleteAdmin(adminId);
       verify(adminRepository, times(1)).deleteById(adminId);
	}

	@Test
	void testGetAdminById() {
		long adminId = 1;
		AdminDetails admin = new AdminDetails();
       admin.setAdminId(adminId);
       admin.setAdminName("admin1");
       admin.setPassword("password");

       when(adminRepository.findById(adminId)).thenReturn(Optional.of(admin));

       AdminDetails result = adminService.getAdminById(adminId);

       assertNotNull(result);
       assertEquals(admin.getAdminId(), result.getAdminId());
       assertEquals(admin.getAdminName(), result.getAdminName());
       assertEquals(admin.getPassword(), result.getPassword());
	}

	@Test
	void testGetAllAdmin() {

		List<AdminDetails> admins = Arrays.asList(new AdminDetails(), new AdminDetails());

       when(adminRepository.findAll()).thenReturn(admins);

       List<AdminDetails> result = adminService.getAllAdmin();

       assertNotNull(result);
       assertEquals(admins.size(), result.size());
	
	
	
	}
}
