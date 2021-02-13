package com.mulheres.mulheres_do_brasil.controllers.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.password = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return password;
    }

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
