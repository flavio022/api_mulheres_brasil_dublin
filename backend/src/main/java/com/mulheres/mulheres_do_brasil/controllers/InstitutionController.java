package com.mulheres.mulheres_do_brasil.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mulheres.mulheres_do_brasil.dto.InstitutionDTO;
import com.mulheres.mulheres_do_brasil.services.InstitutionService;


@RestController
@RequestMapping(value="/institution")
public class InstitutionController {
	@Autowired
	private InstitutionService institutionService;

	@PostMapping
	public ResponseEntity<InstitutionDTO> insert(
			@RequestParam UUID category_id,
			@RequestBody InstitutionDTO dto){

		dto = institutionService.insert(dto,category_id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/id").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping
	public ResponseEntity <List<InstitutionDTO>> findAll(){
		List<InstitutionDTO> list = institutionService.listAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}/image",method = RequestMethod.POST)
	public ResponseEntity<Void> uploadImage(
			@PathVariable("id") UUID id,
			@RequestParam(name="file") MultipartFile file){
		URI uri = institutionService.uploadImage(id,file);

		return ResponseEntity.created(uri).build();
	}


}
