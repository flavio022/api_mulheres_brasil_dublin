package com.mulheres.mulheres_do_brasil.services;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.mulheres.mulheres_do_brasil.config.BucketName;
import com.mulheres.mulheres_do_brasil.store.FileStore;
import org.apache.http.entity.ContentType;
import org.hibernate.ObjectNotFoundException;
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
	private final FileStore fileStore;
	@Autowired
	public CategoryService(CategoryRepository categoryRepository,
						   InstitutionRepository institutionRepository,
						   FileStore fileStore){
		this.categoryRepository = categoryRepository;
		this.institutionRepository = institutionRepository;
		this.fileStore = fileStore;
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

	public void uploadImage(UUID id, MultipartFile file) {
		isFileEmpty(file);

		isImage(file);

		Category category = getCategoryId(id);

		Map<String, String> metadata = extractMetadata(file);

		String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(),category.getId());
		String filename = String.format("%s/%s",file.getOriginalFilename(),UUID.randomUUID());

		try{
			fileStore.save(path,filename,Optional.of(metadata),file.getInputStream());
			category.setImageUri(filename);
			categoryRepository.save(category);

		}catch (IOException e) {
			throw new IllegalStateException(e);
		}

	}

	private void isImage(MultipartFile file) {
		if (!Arrays.asList(
				ContentType.IMAGE_JPEG.getMimeType(),
				ContentType.IMAGE_PNG.getMimeType(),
				ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
			throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
		}
	}

	private void isFileEmpty(MultipartFile file) {
		if(file.isEmpty()){
			throw new IllegalStateException("Cannot upload empty file [" + file.getSize() + "]");
		}
	}

	private Map<String, String> extractMetadata(MultipartFile file) {
		Map<String,String> metadata = new HashMap<>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("Content-Length", String.valueOf(file.getSize()));
		return metadata;
	}

	private Category getCategoryId(UUID id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.orElseThrow(() -> null);
	}

}
