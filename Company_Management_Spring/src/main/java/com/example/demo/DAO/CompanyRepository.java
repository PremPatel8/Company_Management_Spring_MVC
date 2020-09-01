package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	Company findBycompanyName(String company_name);
	
	Company findByidcompany(Integer idcompany);
	
//	Users findByUsername(String username);
}
