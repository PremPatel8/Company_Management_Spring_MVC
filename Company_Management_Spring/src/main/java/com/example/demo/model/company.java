package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"idcompany"})})
public class company {
	@Id
	@NotNull(message = "Company ID may not be blank")
	@Column(unique = true, nullable = false)
	private Integer idcompany;
	
	@NotNull(message = "company name may not be null")
	@NotBlank(message = "company name may not be blank")
	@Size(min=2, max=30)
	@Column(unique = true, nullable = false)
    private String company_name;
	
	@NotBlank(message = "Company phone number may not be blank")
    private String phone;
	
	@NotBlank(message = "Company Email may not be blank")
	private String email;
	
	@Column(name = "date_ins")
    @CreationTimestamp
    private LocalDateTime createdAt;

	
	public Integer getIdcompany() {
		return idcompany;
	}

	public void setIdcompany(Integer idcompany) {
		this.idcompany = idcompany;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Company [idcompany = " + idcompany + ", company_name = " + company_name + ", phone = " + phone + ", email = " + email+ ", createdAt= " + createdAt +"]";
	}
}
