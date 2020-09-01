package com.example.demo.model;

import javax.validation.constraints.Size;

public class SearchCompanyForm {

	private Integer idcompany;

	private String company_name;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Integer getIdcompany() {
		return idcompany;
	}

	public void setIdcompany(Integer idcompany) {
		this.idcompany = idcompany;
	}
}
