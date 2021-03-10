package com.mulheres.mulheres_do_brasil.entities;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.swing.text.html.Option;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;

	private String nome;
	
	private String imageUri;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Institution> institutions = new HashSet<>();

	public Category() {

	}

	public Category(UUID id, String nome, String imageUri) {
		this.id = id;
		this.nome = nome;
		
		this.imageUri = imageUri;
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

	public Optional<String> getImageUri() {
		return Optional.ofNullable(imageUri);
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public Set<Institution> getInstitutions(){
		return institutions;
	}
	public void setInstitutions(Set<Institution> institutions){
		this.institutions = institutions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
