package com.mulheres.mulheres_do_brasil.services;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.amazonaws.services.applicationautoscaling.model.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulheres.mulheres_do_brasil.dto.CategoryDTO;
import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.repositories.CategoryRepository;
import com.mulheres.mulheres_do_brasil.repositories.InstitutionRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	private final InstitutionRepository institutionRepository;
	private final S3Service s3Service;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository,
						   InstitutionRepository institutionRepository,
						   S3Service s3Service){
		this.categoryRepository = categoryRepository;
		this.institutionRepository = institutionRepository;
		this.s3Service = s3Service;
	}
	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category category = new Category(null,dto.getNome(),dto.getImageUri());

		category = categoryRepository.save(category);

		return new CategoryDTO(category);

	}
	public List<CategoryDTO> listAll() {
		List<Category> list = categoryRepository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	public Category find(UUID id){
		Optional<Category> optional = categoryRepository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));
	}
	public void delete(UUID id){
		try{
			categoryRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public URI uploadImage(UUID id, MultipartFile file) {
			URI uri  = s3Service.uploadFile(file);
			Category category = find(id);
			category.setImageUri(uri.toString());
			categoryRepository.save(category);
			return uri;
	}



}


