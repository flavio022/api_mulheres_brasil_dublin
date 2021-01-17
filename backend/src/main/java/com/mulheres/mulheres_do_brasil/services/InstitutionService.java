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
public class InstitutionService {
	@Autowired
	InstitutionRepository institutionRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Transactional
	public InstitutionDTO insert(InstitutionDTO dto) {
		Institution institution =  new Institution(null,dto.getNome());
		
		for(CategoryDTO i : dto.getCategories()) {
			
			Category category = categoryRepository.getOne(i.getId());
			institution.getCategory().add(category);
		}
		institution = institutionRepository.save(institution);

		return new InstitutionDTO(institution);
	}
}
