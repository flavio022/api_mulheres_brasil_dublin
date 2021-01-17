package com.mulheres.mulheres_do_brasil.entities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.entities.Institution;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;

	private List<Institution> institutions = new ArrayList<>();
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		
	}

	public CategoryDTO(Category entity) {
		id = entity.getId();
		nome = entity.getNome();
		institutions = entity.getInstitutions();
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
	public List<Institution> getInstitutions(){
		return institutions;
	}
}
