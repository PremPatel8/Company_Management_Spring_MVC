package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DAO.CompanyRepository;
import com.example.demo.model.company;

import ListSpecificCompany.ListSpecificCompanyForm;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/company_management") // This means URL's start with /demo (after Application path)
public class CompanyController {
	@Autowired // This means to get the bean called companyRepository // Which is
				// auto-generated by Spring, we will use it to handle the data
	private CompanyRepository companyRepository;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewCompany(@RequestParam Integer Company_ID, @RequestParam String Company_Name,
			@RequestParam String phone, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		company com = new company();
		com.setIdcompany(Company_ID);
		com.setCompany_name(Company_Name);
		com.setPhone(phone);
		com.setEmail(email);

		companyRepository.save(com);
		return "Saved";
	}

	@GetMapping("/listCompany")
	public String getAllCompanies(Model model) {
		System.out.println("Inside listCompany endpoint");
		model.addAttribute("specificCompany", new ListSpecificCompanyForm());
		
//		System.out.println("All Companies "+companyRepository.findAll());
		
		model.addAttribute("companies", companyRepository.findAll());
		
		return "listCompany";
	}

	@RequestMapping("/listSpecificCompany")
	public String getSpecificCompany(@ModelAttribute ListSpecificCompanyForm specificCompany,
			@RequestParam(value = "idcompany") Integer idcompany,
			@RequestParam(value = "ListSelectedCompanyButton", required = false) String ListSelectedCompanyButton, Model model) {
		
		System.out.println("Inside listSpecificCompany endpoint");

		// If radio button selected
		if (specificCompany.getIdcompany() != null) {
			Integer cmp_id = specificCompany.getIdcompany();

			System.out.println("cmp_id = " + cmp_id);

			company cmp = companyRepository.findByidcompany(cmp_id);

			if (cmp != null) {
				model.addAttribute("specificCompany", cmp);

				return "ListSpecificCompany";
			} else {
				System.out.println("Inside Company not found in DB");
				model.addAttribute("companyNotFound", "Given Company ID is incorrect");
				return "listCompany";
			}

		} else {// If radio button not selected
			System.out.println("in radio button not selected");
			// if Submit button was clicked without selecting a company
			if (ListSelectedCompanyButton != null) {
				System.out.println("Inside RadiobuttonNotSelected");

				model.addAttribute("RadiobuttonNotSelected", "Please select a company");

				return "listCompany";
			} else {
				// view link was used instead of radio button

				System.out.println("idcompany = " + idcompany);

				company cmp = companyRepository.findByidcompany(idcompany);

				if (cmp != null) {
					model.addAttribute("specificCompany", cmp);

					return "ListSpecificCompany";
				} else {
					System.out.println("Inside Company not found in DB");
					model.addAttribute("companyNotFound", "Given Company ID is incorrect");
					return "listCompany";
				}
			}
		}
	}
}
