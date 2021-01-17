package com.mulheres.mulheres_do_brasil.controllers;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mulheres.mulheres_do_brasil.dto.InstitutionDTO;
import com.mulheres.mulheres_do_brasil.services.InstitutionService;


@RestController
@RequestMapping(value="/institutions")
public class InstitutionController {
	@Autowired
	private InstitutionService institutionService;
	
	@PostMapping
	public ResponseEntity<InstitutionDTO> insert(@RequestBody InstitutionDTO dto){
		dto = institutionService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
