package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import com.hexaware.loanmanagementsystem.dto.AdminDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.AdminDetails;



public interface IAdminDetailsService {

	public AdminDetails createAdmin(AdminDetailsDTO adminDetails);
	public AdminDetails updateAdmin(AdminDetailsDTO adminDetails, long id);
	
	public void deleteAdmin(long adminId);
	
	public AdminDetails getAdminById (long adminId);
	public List<AdminDetails> getAllAdmin();
}
