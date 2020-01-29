package com.example.simplerestapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.simplerestapis.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
}
