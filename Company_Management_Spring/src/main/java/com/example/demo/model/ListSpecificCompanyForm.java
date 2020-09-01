package com.example.demo.model;

import javax.validation.constraints.NotNull;

public class ListSpecificCompanyForm {

	@NotNull(message = "Company ID may not be null")
	private Integer idcompany;

	public Integer getIdcompany() {
		return idcompany;
	}

	public void setIdcompany(Integer idcompany) {
		this.idcompany = idcompany;
	}
}
