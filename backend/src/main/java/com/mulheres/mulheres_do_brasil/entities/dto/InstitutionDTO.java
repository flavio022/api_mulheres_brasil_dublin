package com.mulheres.mulheres_do_brasil.entities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.entities.Institution;

public class InstitutionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private Category category;

	public InstitutionDTO() {
		
	}
	public InstitutionDTO(Institution obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.category = obj.getCategory();
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
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
