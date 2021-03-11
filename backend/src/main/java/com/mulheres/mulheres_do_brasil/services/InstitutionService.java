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
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.applicationautoscaling.model.ObjectNotFoundException;


import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InstitutionService {
	@Autowired
	InstitutionRepository institutionRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	S3Service s3Service;

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
				dto.getImageUri(),
				category);

		institution = institutionRepository.save(institution);

		return new InstitutionDTO(institution);
	}

	public List<InstitutionDTO> listAll() {
		List<Institution> list = institutionRepository.findAll();
		return list.stream().map(x -> new InstitutionDTO(x)).collect(Collectors.toList());

	}
	public Institution find(UUID id){
		Optional<Institution> optional = institutionRepository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Institution.class.getName()));
	}
	public URI uploadImage(UUID id, MultipartFile file) {
		URI uri = s3Service.uploadFile(file);
		Institution institution = find(id);
		institution.setImageUri(uri.toString());
		institutionRepository.save(institution);
		return uri;
	}
}
