package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.loanmanagementsystem.dto.AdminDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.AdminDetails;
import com.hexaware.loanmanagementsystem.exception.AdminNotFoundException;
import com.hexaware.loanmanagementsystem.repository.AdminDetailsRepository;

@Service
public class AdminDetailsServiceImp implements IAdminDetailsService {

	@Autowired
	private AdminDetailsRepository adminDetailsRepository;
	@Autowired
	private  PasswordEncoder passwordEncoder;

	
	Logger logger = LoggerFactory.getLogger(AdminDetailsServiceImp.class);

	@Override
	public AdminDetails createAdmin(AdminDetailsDTO adminDetails) {

		AdminDetails adminDetail = new AdminDetails();
		adminDetail.setAdminName(adminDetails.getAdminName());
		adminDetail.setAdminUsername(adminDetails.getAdminUsername());
		adminDetail.setEmailId(adminDetails.getEmailId());
		adminDetail.setPassword(passwordEncoder.encode(adminDetails.getPassword()));

		logger.info("Admin Service Implementation -added Admin data into database successfully ");

		return adminDetailsRepository.save(adminDetail);
	}

	@Override
	public AdminDetails updateAdmin(AdminDetailsDTO adminDetails, long id) {

		AdminDetails adminDetail = adminDetailsRepository.findById(id).orElseThrow(()-> new AdminNotFoundException(HttpStatus.NOT_FOUND, "Admin not found with ID:"+id));
		adminDetail.setAdminId(adminDetail.getAdminId());
		adminDetail.setAdminName(adminDetails.getAdminName());
		adminDetail.setAdminUsername(adminDetails.getAdminUsername());
		adminDetail.setEmailId(adminDetails.getEmailId());
		adminDetail.setPassword(passwordEncoder.encode(adminDetails.getPassword()));

		logger.info(
				"Admin Service Implementation -Updated the Admin data in existing record in  database successfully ");

		return adminDetailsRepository.save(adminDetail);
	}

	@Override
	public void deleteAdmin(long adminID) {
	    adminDetailsRepository.deleteById(adminID);
	    logger.info("Admin Data with ID: {} deleted successfully in the Admin Service Implementation", adminID);
	}

	@Override
	public AdminDetails getAdminById(long adminId) {

		logger.info("Admin Service Implementation- Fetching admins by ID :{}", adminId);

		return adminDetailsRepository.findById(adminId).orElseThrow(()-> new AdminNotFoundException(HttpStatus.NOT_FOUND, "Admin not found with ID:"+adminId));
	}

	@Override
	public List<AdminDetails> getAllAdmin() {

		logger.info("Admin Service Implementation- Fetching all admins ");

		List<AdminDetails> adminDetails = adminDetailsRepository.findAll();
		
		if(adminDetails.isEmpty())
		{
			throw new AdminNotFoundException(HttpStatus.NOT_FOUND, "Admin details not found");
		}
		
		return adminDetails;
	}

}
