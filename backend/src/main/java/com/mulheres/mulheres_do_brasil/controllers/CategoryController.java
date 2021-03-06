package com.mulheres.mulheres_do_brasil.controllers;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.entities.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mulheres.mulheres_do_brasil.dto.CategoryDTO;
import com.mulheres.mulheres_do_brasil.services.CategoryService;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/categories")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<CategoryDTO> insert(
			@RequestBody CategoryDTO dto) {
		dto = categoryService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> list = categoryService.listAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity find(@PathVariable UUID id){
		Category category = categoryService.find(id);
		return ResponseEntity.ok().body(category);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> remove(@PathVariable UUID id){
		System.out.println(id);
		 categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "/{id}/image",method = RequestMethod.POST)
	public ResponseEntity<Void> uploadImage(@PathVariable("id") UUID id,@RequestParam(name="file") MultipartFile file){
		URI uri = categoryService.uploadImage(id,file);
		return ResponseEntity.created(uri).build();
	}
}
