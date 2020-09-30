package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.DAO.CompanyRepository;
import com.example.demo.DAO.EmployeeRepository;
import com.example.demo.model.ListSpecificCompanyForm;
import com.example.demo.model.SearchCompanyForm;
import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.model.ListCompanyEmployeesForm;


@Controller
@RequestMapping(path = "/company_management")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping(path = "/insertEmployeeForm")
	public String showinsertEmployeeForm(@ModelAttribute("employee") Employee employeeForm) {
		System.out.println("Inside insertEmployeeForm Get endpoint");
		// model.addAttribute("companyForm", new company());
		return "formEmployee";
	}

	@PostMapping(path = "/saveEmployee")
	public String addNewEmployee(@Valid @ModelAttribute("employee") Employee employeeForm, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println("inside saveEmployee form has errors");
			return "formEmployee";
		} else {
			System.out.println("inside saveEmployee form does NOT have errors");
			employeeRepository.save(employeeForm);

			model.addAttribute("successMessage", "New employee successfully added");

			return "formEmployee";
		}
	}
	
	
	@GetMapping(path = "/searchEmployeeForm")
	public String showSearchEmployeeForm(Model model) {
		System.out.println("Inside searchEmployeeForm Get endpoint");
		
		model.addAttribute("companyEmployees", new ListCompanyEmployeesForm());
		
		System.out.println(companyRepository.findAll());
		
		model.addAttribute("companies", companyRepository.findAll());

		return "searchEmployee";
	}
	
	@PostMapping(path = "/listEmployee")
	public String listEmployee(@ModelAttribute ListCompanyEmployeesForm companyEmployees,
			@RequestParam(value = "companyid") Integer companyid,
			Model model) {
		System.out.println("inside listEmployee Post endpoint");
		System.out.println("companyid = "+companyid);
		System.out.println(employeeRepository.findAllByCompanyid(companyid));
		
		model.addAttribute("employees", employeeRepository.findAllByCompanyid(companyid));
		return "listEmployees";
	}
}
