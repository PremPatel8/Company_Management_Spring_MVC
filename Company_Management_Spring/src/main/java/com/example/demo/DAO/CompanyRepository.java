package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.company;

public interface CompanyRepository extends CrudRepository<company, Integer> {
	company findByidcompany(Integer idcompany);
}
