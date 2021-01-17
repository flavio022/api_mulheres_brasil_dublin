package com.mulheres.mulheres_do_brasil.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulheres.mulheres_do_brasil.dto.CategoryDTO;
import com.mulheres.mulheres_do_brasil.dto.InstitutionDTO;
import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.entities.Institution;
import com.mulheres.mulheres_do_brasil.repositories.CategoryRepository;
import com.mulheres.mulheres_do_brasil.repositories.InstitutionRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	InstitutionRepository institutionRepository;
	
	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category category = new Category(null,dto.getNome());
		
		category = categoryRepository.save(category);
		
		return new CategoryDTO(category);
		
	}
	
}
