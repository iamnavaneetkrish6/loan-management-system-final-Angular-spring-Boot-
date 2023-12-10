package com.hexaware.loanmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.loanmanagementsystem.entity.PropertyDetail;


@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetail, Long>{

	public PropertyDetail findByPropertyOwner(String propertyOwner);
}
