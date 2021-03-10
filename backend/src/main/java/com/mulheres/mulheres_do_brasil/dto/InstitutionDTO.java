package com.mulheres.mulheres_do_brasil.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.entities.Institution;

public class InstitutionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String description;
	private String phone;
	private String email;
	private String webSite;
	private String paymentType;

	private Category category;



	public InstitutionDTO() {
		
	}
	
	public InstitutionDTO(Institution obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.phone = obj.getPhone();
		this.description = obj.getDescription();
		this.webSite = obj.getWebSite();
		this.paymentType = obj.getPaymentType();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
}
