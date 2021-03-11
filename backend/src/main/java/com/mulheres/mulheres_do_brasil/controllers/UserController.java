package com.mulheres.mulheres_do_brasil.controllers;

import com.mulheres.mulheres_do_brasil.dto.InstitutionDTO;
import com.mulheres.mulheres_do_brasil.dto.UserDTO;
import com.mulheres.mulheres_do_brasil.services.InstitutionService;
import com.mulheres.mulheres_do_brasil.services.S3Service;
import com.mulheres.mulheres_do_brasil.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto){
        dto = userService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @RequestMapping(value = "/{id}/image_profile",method = RequestMethod.POST)
    public ResponseEntity<Void> uploadImage(
            @PathVariable("id") UUID id,
            @RequestParam(name="file") MultipartFile file){
        URI uri = userService.uploadImage(id,file);

        return ResponseEntity.created(uri).build();
    }
}

