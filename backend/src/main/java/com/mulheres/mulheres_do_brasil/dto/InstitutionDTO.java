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
	
	@ManyToMany()
	@JoinTable(name = "tb_category_institution", 
	joinColumns = @JoinColumn(name = "category_id"),
	inverseJoinColumns = @JoinColumn(name = "institution_id"))
	private List<CategoryDTO> categories = new ArrayList<>();

	public InstitutionDTO() {
		
	}
	
	public InstitutionDTO(Institution obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		categories = obj.getCategory().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
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
	
	public List<CategoryDTO> getCategories() {
		return categories;
	}	
}
