package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import com.hexaware.loanmanagementsystem.dto.PropertyDetailDTO;
import com.hexaware.loanmanagementsystem.entity.PropertyDetail;

public interface IPropertyDetailsService {

	public PropertyDetail createpropertyDetails(PropertyDetailDTO propertyDetailDto);

	public PropertyDetail updatepropertyDetails(PropertyDetailDTO propertyDetailDto, long id);

	public void deletepropertyDetailsById(long propertyDetailsId);

	public PropertyDetail getpropertyDetailsId(long propertyDetailsId);

	public List<PropertyDetail> getAllPropertyDetails();

}
