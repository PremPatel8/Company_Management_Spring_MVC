package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"idemployee"})})
public class Employee {
	@Id
	@Column(unique = true, nullable = false)
	@Size(min=3, max=16)
	private String idemployee;
	

	@Size(min=1, max=45)
    private String name;
	
	
	@Size(min=1, max=45)
    private String surname;
	
	@Size(min=3, max=5)
	private String badge;
	

	private Integer companyid;
	
	
    @CreationTimestamp
    private LocalDateTime date_ins;
    



	public String getIdemployee() {
		return idemployee;
	}




	public void setIdemployee(String idemployee) {
		this.idemployee = idemployee;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSurname() {
		return surname;
	}




	public void setSurname(String surname) {
		this.surname = surname;
	}




	public String getBadge() {
		return badge;
	}




	public void setBadge(String badge) {
		this.badge = badge;
	}


	public Integer getCompanyid() {
		return companyid;
	}




	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}




	@Override
	public String toString() {
		return "Employee [idemployee = " + idemployee + ", name = " + name + ", surname = " + surname + ", badge = " + badge + ", companyid= " + companyid + ", date_ins = " + date_ins + "]";
	}
}
