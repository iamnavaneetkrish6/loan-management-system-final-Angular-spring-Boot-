package com.hexaware.loanmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.loanmanagementsystem.entity.AdminDetails;



@Repository
public interface AdminDetailsRepository extends JpaRepository<AdminDetails, Long> {
 
	Optional<AdminDetails>findByAdminName(String adminName);
	Optional<AdminDetails>findByAdminUsername(String adminUsername);
	public AdminDetails findByAdminUsernameAndPassword(String adminUsername, String password);
}
