package com.mulheres.mulheres_do_brasil.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.entities.Institution;
import com.mulheres.mulheres_do_brasil.entities.User;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private UUID id;
	private String nome;
	private String imageUri;

	private List<Institution> institutions = new ArrayList<>();
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(UUID id, String nome,String imageUri) {
		super();
		this.id = id;
		this.nome = nome;
		this.imageUri = imageUri;
		
	}

	public CategoryDTO(Category entity) {
		id = entity.getId();
		nome = entity.getNome();
		imageUri = entity.getImageUri().orElse(null);
	}


	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
}
