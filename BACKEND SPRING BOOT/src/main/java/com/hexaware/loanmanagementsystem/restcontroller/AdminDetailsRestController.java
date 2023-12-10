package com.hexaware.loanmanagementsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.loanmanagementsystem.dto.AdminDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.AdminDetails;
import com.hexaware.loanmanagementsystem.service.IAdminDetailsService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/admin-details/")
public class AdminDetailsRestController {

	@Autowired
	private IAdminDetailsService adminDetailsService;



	@PostMapping(value = "addadmin", consumes = "application/json", produces = "application/json")
	public AdminDetails createAdmin(@RequestBody @Valid AdminDetailsDTO adminDetailsDTO) {

		return adminDetailsService.createAdmin(adminDetailsDTO);
	}

	@PutMapping(value = "updateadmin/{id}", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public AdminDetails updateAdmin(@RequestBody @Valid AdminDetailsDTO adminDetailsDTO, @PathVariable long id) {

		return adminDetailsService.updateAdmin(adminDetailsDTO,id);
	}

	@DeleteMapping(value = "deleteadmin/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public String deleteAdmin(@PathVariable long id) {
	    adminDetailsService.deleteAdmin(id);
	    return "Admin ID: " + id + " successfully deleted";
	}

	@GetMapping(value = "getbyadminid/{id}", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public AdminDetails getByAdminId(@PathVariable int id) {

		return adminDetailsService.getAdminById(id);
	}

	@GetMapping(value = "getadminAll", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<AdminDetails> getAllAdmin() {

		return adminDetailsService.getAllAdmin();
	}
//http://localhost:8485/swagger-ui/index.html#/login-rest-controller/adminLogin
}
