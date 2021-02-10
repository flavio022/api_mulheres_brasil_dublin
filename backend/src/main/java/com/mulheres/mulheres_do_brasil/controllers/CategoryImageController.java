package com.mulheres.mulheres_do_brasil.controllers;

import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@RestController
@RequestMapping(value = "/categories/{id}/image")
@CrossOrigin("*")
public class CategoryImageController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadImage(@PathVariable("id") UUID id,
                            @RequestParam("file") MultipartFile file){
        categoryService.uploadImage(id,file);
    }
    @GetMapping("/download")
    public byte[] dowloadImage(@PathVariable("id") UUID id) {
        return categoryService.dowloadImage(id);
    }

}
