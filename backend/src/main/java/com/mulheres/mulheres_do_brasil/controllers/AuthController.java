package com.mulheres.mulheres_do_brasil.controllers;

import com.mulheres.mulheres_do_brasil.config.security.TokenService;
import com.mulheres.mulheres_do_brasil.controllers.form.LoginForm;
import com.mulheres.mulheres_do_brasil.dto.TokenDto;
import com.mulheres.mulheres_do_brasil.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.generateToken(authentication);
            User AuthenticatedUserData = tokenService.getAuthenticatedUser(authentication);
            return ResponseEntity.ok(new TokenDto(token,"Bearer",AuthenticatedUserData));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
