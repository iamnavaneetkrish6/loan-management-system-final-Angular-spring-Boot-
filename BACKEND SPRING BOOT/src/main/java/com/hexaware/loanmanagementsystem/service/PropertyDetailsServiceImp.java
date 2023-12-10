package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.loanmanagementsystem.dto.PropertyDetailDTO;
import com.hexaware.loanmanagementsystem.entity.PropertyDetail;
import com.hexaware.loanmanagementsystem.exception.PropertyDetailsNotFound;
import com.hexaware.loanmanagementsystem.repository.PropertyDetailsRepository;

@Service
public class PropertyDetailsServiceImp implements IPropertyDetailsService {

	@Autowired
	PropertyDetailsRepository propertyDetailsRepository;

	Logger logger = LoggerFactory.getLogger(PropertyDetailsServiceImp.class);

	@Override
	public PropertyDetail createpropertyDetails(PropertyDetailDTO propertyDetailDto) {

		PropertyDetail propertyDetail = new PropertyDetail();
		propertyDetail.setPropertyOwner(propertyDetailDto.getPropertyOwner());
		propertyDetail.setPropertyAddress(propertyDetailDto.getPropertyAddress());
		propertyDetail.setPropertyValue(propertyDetailDto.getPropertyValue());

		return propertyDetailsRepository.save(propertyDetail);
	}

	@Override
	public PropertyDetail updatepropertyDetails(PropertyDetailDTO propertyDetailDto, long id) {

		PropertyDetail propertyDetail = new PropertyDetail();//propertyDetailsRepository.findById(id).orElseThrow(() -> new PropertyDetailsNotFound(HttpStatus.NOT_FOUND, "property details not found"));
		propertyDetail.setPropertyId(id);
		propertyDetail.setPropertyOwner(propertyDetailDto.getPropertyOwner());
		propertyDetail.setPropertyAddress(propertyDetailDto.getPropertyAddress());
		propertyDetail.setPropertyValue(propertyDetailDto.getPropertyValue());

		return propertyDetailsRepository.save(propertyDetail);
	}

	@Override
	public void deletepropertyDetailsById(long propertyDetailsId) {
	    propertyDetailsRepository.deleteById(propertyDetailsId);
	}

	@Override
	public PropertyDetail getpropertyDetailsId(long propertyDetailsId) {
		return propertyDetailsRepository.findById(propertyDetailsId)
				.orElseThrow(() -> new PropertyDetailsNotFound(HttpStatus.NOT_FOUND, "property details not found"));
	}

	@Override
	public List<PropertyDetail> getAllPropertyDetails() {

		List<PropertyDetail> propertyDetails = propertyDetailsRepository.findAll();

		if (propertyDetails.isEmpty()) {
			throw new PropertyDetailsNotFound(HttpStatus.NOT_FOUND, "property details not found");
		}

		return propertyDetails;
	}

}