package com.mulheres.mulheres_do_brasil.dto;

import com.mulheres.mulheres_do_brasil.entities.User;

public class TokenDto {
    private String token;
    private String tipo;
    private User user;

    public TokenDto(String token, String tipo,User user) {
        this.token = token;
        this.tipo = tipo;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
    public User getUser(){
        return user;
    }
}
