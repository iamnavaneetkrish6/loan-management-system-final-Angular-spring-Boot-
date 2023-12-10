package com.hexaware.loanmanagementsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.hexaware.loanmanagementsystem.dto.PropertyDetailDTO;
import com.hexaware.loanmanagementsystem.entity.PropertyDetail;
import com.hexaware.loanmanagementsystem.service.IPropertyDetailsService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/property-details/")
public class PropertyDetailRestController {

	@Autowired
	IPropertyDetailsService propertyDetailsService;
	
	@PostMapping(value = "addpropertydetail", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public PropertyDetail createPropertyDetails(@RequestBody @Valid PropertyDetailDTO propertyDetailDto) {

		return propertyDetailsService.createpropertyDetails(propertyDetailDto);
	}

	@PutMapping(value = "updateproperty/{id} ", consumes = "application/json", produces = "application/json")
	
	public PropertyDetail updatePropertyDetails(@RequestBody  PropertyDetailDTO propertyDetailDto,@PathVariable long id) {

		return propertyDetailsService.updatepropertyDetails(propertyDetailDto, id);
	}

	@DeleteMapping(value = "deletepropertydetail/{ID}")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public ResponseEntity<String> deletePropertyDetail(@PathVariable long ID) {
	    propertyDetailsService.deletepropertyDetailsById(ID);
	    return new ResponseEntity<>("Property details deleted successfully", HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "getbypropertydetailid/{id}", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public PropertyDetail getPropertyDetailId(@PathVariable int id) {

		return propertyDetailsService.getpropertyDetailsId(id);
	}

	@GetMapping(value = "getAllpropertydetail", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<PropertyDetail> getAllProperptyDetails() {

		return propertyDetailsService.getAllPropertyDetails();
	}	
}
