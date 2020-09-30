package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
//	Employee findByemployeeName(String company_name);
//	Employee getEmployee(Integer idcompany);
	
	Employee findAllByCompanyid(Integer companyid);
	
//	Employee findByidcompany(Integer idcompany);
}
