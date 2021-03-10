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

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InstitutionService {
	@Autowired
	InstitutionRepository institutionRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Transactional
	public InstitutionDTO insert(InstitutionDTO dto,UUID category_id) {

		Category category = categoryRepository.getOne(category_id);

		Institution institution =  new Institution(
				null,
				dto.getNome(),
				dto.getEmail(),
				dto.getPhone(),
				dto.getWebSite(),
				dto.getDescription(),
				dto.getPaymentType(),
				category);

		institution = institutionRepository.save(institution);

		return new InstitutionDTO(institution);
	}

	public List<InstitutionDTO> listAll() {
		List<Institution> list = institutionRepository.findAll();
		return list.stream().map(x -> new InstitutionDTO(x)).collect(Collectors.toList());

	}

}
